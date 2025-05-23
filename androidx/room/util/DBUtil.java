package androidx.room.util;

import android.database.AbstractWindowedCursor;
import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteCompat;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteQuery;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.spi.AbstractInterruptibleChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class DBUtil {
    DBUtil() {
    }

    @Nullable
    public static CancellationSignal createCancellationSignal() {
        return SupportSQLiteCompat.Api16Impl.createCancellationSignal();
    }

    public static void dropFtsSyncTriggers(SupportSQLiteDatabase supportSQLiteDatabase) {
        ArrayList<String> arrayList = new ArrayList();
        Cursor query = supportSQLiteDatabase.query("SELECT name FROM sqlite_master WHERE type = 'trigger'");
        while (query.moveToNext()) {
            try {
                arrayList.add(query.getString(0));
            } catch (Throwable th5) {
                query.close();
                throw th5;
            }
        }
        query.close();
        for (String str : arrayList) {
            if (str.startsWith("room_fts_content_sync_")) {
                supportSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS " + str);
            }
        }
    }

    public static void foreignKeyCheck(@NonNull SupportSQLiteDatabase supportSQLiteDatabase, @NonNull String str) {
        Cursor query = supportSQLiteDatabase.query("PRAGMA foreign_key_check(`" + str + "`)");
        try {
            if (query.getCount() <= 0) {
            } else {
                throw new IllegalStateException(processForeignKeyCheckFailure(query));
            }
        } finally {
            query.close();
        }
    }

    private static String processForeignKeyCheckFailure(Cursor cursor) {
        int count = cursor.getCount();
        HashMap hashMap = new HashMap();
        String str = null;
        while (cursor.moveToNext()) {
            if (str == null) {
                str = cursor.getString(0);
            }
            String string = cursor.getString(3);
            if (!hashMap.containsKey(string)) {
                hashMap.put(string, cursor.getString(2));
            }
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("Foreign key violation(s) detected in '");
        sb5.append(str);
        sb5.append("'.\n");
        sb5.append("Number of different violations discovered: ");
        sb5.append(hashMap.keySet().size());
        sb5.append("\n");
        sb5.append("Number of rows in violation: ");
        sb5.append(count);
        sb5.append("\n");
        sb5.append("Violation(s) detected in the following constraint(s):\n");
        for (Map.Entry entry : hashMap.entrySet()) {
            sb5.append("\tParent Table = ");
            sb5.append((String) entry.getValue());
            sb5.append(", Foreign Key Constraint Index = ");
            sb5.append((String) entry.getKey());
            sb5.append("\n");
        }
        return sb5.toString();
    }

    @NonNull
    @Deprecated
    public static Cursor query(RoomDatabase roomDatabase, SupportSQLiteQuery supportSQLiteQuery, boolean z16) {
        return query(roomDatabase, supportSQLiteQuery, z16, null);
    }

    public static int readVersion(@NonNull File file) throws IOException {
        AbstractInterruptibleChannel abstractInterruptibleChannel = null;
        try {
            ByteBuffer allocate = ByteBuffer.allocate(4);
            FileChannel channel = new FileInputStream(file).getChannel();
            channel.tryLock(60L, 4L, true);
            channel.position(60L);
            if (channel.read(allocate) == 4) {
                allocate.rewind();
                int i3 = allocate.getInt();
                channel.close();
                return i3;
            }
            throw new IOException("Bad database header, unable to read 4 bytes at offset 60");
        } catch (Throwable th5) {
            if (0 != 0) {
                abstractInterruptibleChannel.close();
            }
            throw th5;
        }
    }

    @NonNull
    public static Cursor query(@NonNull RoomDatabase roomDatabase, @NonNull SupportSQLiteQuery supportSQLiteQuery, boolean z16, @Nullable CancellationSignal cancellationSignal) {
        Cursor query = roomDatabase.query(supportSQLiteQuery, cancellationSignal);
        if (!z16 || !(query instanceof AbstractWindowedCursor)) {
            return query;
        }
        AbstractWindowedCursor abstractWindowedCursor = (AbstractWindowedCursor) query;
        int count = abstractWindowedCursor.getCount();
        return (abstractWindowedCursor.hasWindow() ? abstractWindowedCursor.getWindow().getNumRows() : count) < count ? CursorUtil.copyAndClose(abstractWindowedCursor) : query;
    }
}
