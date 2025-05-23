package com.tencent.qqnt.qwallet.db;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.tencent.mobileqq.app.AppConstants;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes25.dex */
public final class b implements com.tencent.qqnt.qwallet.db.a {

    /* renamed from: a, reason: collision with root package name */
    private final RoomDatabase f361837a;

    /* renamed from: b, reason: collision with root package name */
    private final EntityInsertionAdapter<HbCommandEntity> f361838b;

    /* compiled from: P */
    /* loaded from: classes25.dex */
    class a extends EntityInsertionAdapter<HbCommandEntity> {
        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityInsertionAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, HbCommandEntity hbCommandEntity) {
            if (hbCommandEntity.getListId() == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, hbCommandEntity.getListId());
            }
            if (hbCommandEntity.getCommand() == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, hbCommandEntity.getCommand());
            }
            supportSQLiteStatement.bindLong(3, hbCommandEntity.getExpireTime());
            supportSQLiteStatement.bindLong(4, hbCommandEntity.getSenderUin());
            supportSQLiteStatement.bindLong(5, hbCommandEntity.getPeerUin());
            if (hbCommandEntity.getAuthKey() == null) {
                supportSQLiteStatement.bindNull(6);
            } else {
                supportSQLiteStatement.bindString(6, hbCommandEntity.getAuthKey());
            }
            supportSQLiteStatement.bindLong(7, hbCommandEntity.getChatType());
            supportSQLiteStatement.bindLong(8, hbCommandEntity.getRedChannel());
            supportSQLiteStatement.bindLong(9, hbCommandEntity.getPayFlag());
            supportSQLiteStatement.bindLong(10, hbCommandEntity.getHbFlag());
            supportSQLiteStatement.bindLong(11, hbCommandEntity.getResourceType());
            supportSQLiteStatement.bindLong(12, hbCommandEntity.getHbFrom());
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR REPLACE INTO `hb_command_table` (`listId`,`command`,`expireTime`,`senderUin`,`peerUin`,`authKey`,`chatType`,`redChannel`,`payFlag`,`hbFlag`,`resourceType`,`hbFrom`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        }
    }

    public b(RoomDatabase roomDatabase) {
        this.f361837a = roomDatabase;
        this.f361838b = new a(roomDatabase);
    }

    public static List<Class<?>> d() {
        return Collections.emptyList();
    }

    @Override // com.tencent.qqnt.qwallet.db.a
    public void a(HbCommandEntity hbCommandEntity) {
        this.f361837a.assertNotSuspendingTransaction();
        this.f361837a.beginTransaction();
        try {
            this.f361838b.insert((EntityInsertionAdapter<HbCommandEntity>) hbCommandEntity);
            this.f361837a.setTransactionSuccessful();
        } finally {
            this.f361837a.endTransaction();
        }
    }

    @Override // com.tencent.qqnt.qwallet.db.a
    public HbCommandEntity b(String str) {
        String string;
        String string2;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM hb_command_table WHERE listId =?", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.f361837a.assertNotSuspendingTransaction();
        HbCommandEntity hbCommandEntity = null;
        String string3 = null;
        Cursor query = DBUtil.query(this.f361837a, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "listId");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "command");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "expireTime");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, AppConstants.Key.COLUMN_MSG_SENDER_UIN);
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "peerUin");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "authKey");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "chatType");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "redChannel");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "payFlag");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "hbFlag");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "resourceType");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "hbFrom");
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
                long j16 = query.getLong(columnIndexOrThrow4);
                long j17 = query.getLong(columnIndexOrThrow5);
                if (!query.isNull(columnIndexOrThrow6)) {
                    string3 = query.getString(columnIndexOrThrow6);
                }
                hbCommandEntity = new HbCommandEntity(string, string2, j3, j16, j17, string3, query.getInt(columnIndexOrThrow7), query.getInt(columnIndexOrThrow8), query.getInt(columnIndexOrThrow9), query.getInt(columnIndexOrThrow10), query.getInt(columnIndexOrThrow11), query.getInt(columnIndexOrThrow12));
            }
            return hbCommandEntity;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // com.tencent.qqnt.qwallet.db.a
    public HbCommandEntity c(String str) {
        String string;
        String string2;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM hb_command_table WHERE command=? ORDER BY expireTime DESC LIMIT 1", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.f361837a.assertNotSuspendingTransaction();
        HbCommandEntity hbCommandEntity = null;
        String string3 = null;
        Cursor query = DBUtil.query(this.f361837a, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "listId");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "command");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "expireTime");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, AppConstants.Key.COLUMN_MSG_SENDER_UIN);
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "peerUin");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "authKey");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "chatType");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "redChannel");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "payFlag");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "hbFlag");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "resourceType");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "hbFrom");
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
                long j16 = query.getLong(columnIndexOrThrow4);
                long j17 = query.getLong(columnIndexOrThrow5);
                if (!query.isNull(columnIndexOrThrow6)) {
                    string3 = query.getString(columnIndexOrThrow6);
                }
                hbCommandEntity = new HbCommandEntity(string, string2, j3, j16, j17, string3, query.getInt(columnIndexOrThrow7), query.getInt(columnIndexOrThrow8), query.getInt(columnIndexOrThrow9), query.getInt(columnIndexOrThrow10), query.getInt(columnIndexOrThrow11), query.getInt(columnIndexOrThrow12));
            }
            return hbCommandEntity;
        } finally {
            query.close();
            acquire.release();
        }
    }
}
