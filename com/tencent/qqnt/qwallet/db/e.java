package com.tencent.qqnt.qwallet.db;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes25.dex */
public final class e implements d {

    /* renamed from: a, reason: collision with root package name */
    private final RoomDatabase f361852a;

    /* renamed from: b, reason: collision with root package name */
    private final EntityInsertionAdapter<HbStateEntity> f361853b;

    /* renamed from: c, reason: collision with root package name */
    private final SharedSQLiteStatement f361854c;

    /* compiled from: P */
    /* loaded from: classes25.dex */
    class a extends EntityInsertionAdapter<HbStateEntity> {
        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityInsertionAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, HbStateEntity hbStateEntity) {
            if (hbStateEntity.getListId() == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, hbStateEntity.getListId());
            }
            if (hbStateEntity.getToUin() == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, hbStateEntity.getToUin());
            }
            supportSQLiteStatement.bindLong(3, hbStateEntity.getExpireTime());
            supportSQLiteStatement.bindLong(4, hbStateEntity.getState());
            supportSQLiteStatement.bindLong(5, hbStateEntity.getSendState());
            if (hbStateEntity.getText() == null) {
                supportSQLiteStatement.bindNull(6);
            } else {
                supportSQLiteStatement.bindString(6, hbStateEntity.getText());
            }
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR REPLACE INTO `hb_state_table` (`listId`,`toUin`,`expireTime`,`state`,`sendState`,`text`) VALUES (?,?,?,?,?,?)";
        }
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    class b extends SharedSQLiteStatement {
        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "UPDATE hb_state_table SET text =? WHERE listId= ? AND toUin= ?";
        }
    }

    public e(RoomDatabase roomDatabase) {
        this.f361852a = roomDatabase;
        this.f361853b = new a(roomDatabase);
        this.f361854c = new b(roomDatabase);
    }

    public static List<Class<?>> d() {
        return Collections.emptyList();
    }

    @Override // com.tencent.qqnt.qwallet.db.d
    public HbStateEntity a(String str, String str2) {
        String string;
        String string2;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM hb_state_table WHERE listId = ? AND toUin= ?", 2);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        if (str2 == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str2);
        }
        this.f361852a.assertNotSuspendingTransaction();
        HbStateEntity hbStateEntity = null;
        String string3 = null;
        Cursor query = DBUtil.query(this.f361852a, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "listId");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "toUin");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "expireTime");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "state");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "sendState");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "text");
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
                long j3 = query.getLong(columnIndexOrThrow3);
                int i3 = query.getInt(columnIndexOrThrow4);
                int i16 = query.getInt(columnIndexOrThrow5);
                if (!query.isNull(columnIndexOrThrow6)) {
                    string3 = query.getString(columnIndexOrThrow6);
                }
                hbStateEntity = new HbStateEntity(string, string2, j3, i3, i16, string3);
            }
            return hbStateEntity;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // com.tencent.qqnt.qwallet.db.d
    public void b(String str, String str2, String str3) {
        this.f361852a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.f361854c.acquire();
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        if (str2 == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str2);
        }
        if (str3 == null) {
            acquire.bindNull(3);
        } else {
            acquire.bindString(3, str3);
        }
        this.f361852a.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.f361852a.setTransactionSuccessful();
        } finally {
            this.f361852a.endTransaction();
            this.f361854c.release(acquire);
        }
    }

    @Override // com.tencent.qqnt.qwallet.db.d
    public void c(HbStateEntity hbStateEntity) {
        this.f361852a.assertNotSuspendingTransaction();
        this.f361852a.beginTransaction();
        try {
            this.f361853b.insert((EntityInsertionAdapter<HbStateEntity>) hbStateEntity);
            this.f361852a.setTransactionSuccessful();
        } finally {
            this.f361852a.endTransaction();
        }
    }
}
