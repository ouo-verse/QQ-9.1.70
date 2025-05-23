package e24;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$SecurityData;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes25.dex */
public final class b implements e24.a {

    /* renamed from: a, reason: collision with root package name */
    private final RoomDatabase f395412a;

    /* renamed from: b, reason: collision with root package name */
    private final EntityInsertionAdapter<KuiklyData> f395413b;

    /* renamed from: c, reason: collision with root package name */
    private final SharedSQLiteStatement f395414c;

    /* renamed from: d, reason: collision with root package name */
    private final SharedSQLiteStatement f395415d;

    /* compiled from: P */
    /* loaded from: classes25.dex */
    class a extends EntityInsertionAdapter<KuiklyData> {
        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityInsertionAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, KuiklyData kuiklyData) {
            if (kuiklyData.getDataKey() == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, kuiklyData.getDataKey());
            }
            if (kuiklyData.getDataValue() == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, kuiklyData.getDataValue());
            }
            if (kuiklyData.getByteArray() == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindBlob(3, kuiklyData.getByteArray());
            }
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR REPLACE INTO `kuikly_data` (`dataKey`,`dataValue`,`byteArray`) VALUES (?,?,?)";
        }
    }

    /* compiled from: P */
    /* renamed from: e24.b$b, reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    class C10213b extends SharedSQLiteStatement {
        C10213b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM kuikly_data WHERE dataKey is ?";
        }
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    class c extends SharedSQLiteStatement {
        c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM kuikly_data";
        }
    }

    public b(RoomDatabase roomDatabase) {
        this.f395412a = roomDatabase;
        this.f395413b = new a(roomDatabase);
        this.f395414c = new C10213b(roomDatabase);
        this.f395415d = new c(roomDatabase);
    }

    public static List<Class<?>> d() {
        return Collections.emptyList();
    }

    @Override // e24.a
    public KuiklyData a(String str) {
        String string;
        String string2;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM kuikly_data WHERE dataKey is ?", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.f395412a.assertNotSuspendingTransaction();
        KuiklyData kuiklyData = null;
        byte[] blob = null;
        Cursor query = DBUtil.query(this.f395412a, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, QAdRewardDefine$SecurityData.DATA_KEY);
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "dataValue");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "byteArray");
            if (query.moveToFirst()) {
                if (query.isNull(columnIndexOrThrow)) {
                    string = null;
                } else {
                    string = query.getString(columnIndexOrThrow);
                }
                if (query.isNull(columnIndexOrThrow2)) {
                    string2 = null;
                } else {
                    string2 = query.getString(columnIndexOrThrow2);
                }
                if (!query.isNull(columnIndexOrThrow3)) {
                    blob = query.getBlob(columnIndexOrThrow3);
                }
                kuiklyData = new KuiklyData(string, string2, blob);
            }
            return kuiklyData;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // e24.a
    public void b(KuiklyData kuiklyData) {
        this.f395412a.assertNotSuspendingTransaction();
        this.f395412a.beginTransaction();
        try {
            this.f395413b.insert((EntityInsertionAdapter<KuiklyData>) kuiklyData);
            this.f395412a.setTransactionSuccessful();
        } finally {
            this.f395412a.endTransaction();
        }
    }

    @Override // e24.a
    public void c(String str) {
        this.f395412a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.f395414c.acquire();
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.f395412a.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.f395412a.setTransactionSuccessful();
        } finally {
            this.f395412a.endTransaction();
            this.f395414c.release(acquire);
        }
    }

    @Override // e24.a
    public void deleteAll() {
        this.f395412a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.f395415d.acquire();
        this.f395412a.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.f395412a.setTransactionSuccessful();
        } finally {
            this.f395412a.endTransaction();
            this.f395415d.release(acquire);
        }
    }
}
