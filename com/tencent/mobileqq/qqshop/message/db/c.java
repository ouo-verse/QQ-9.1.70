package com.tencent.mobileqq.qqshop.message.db;

import android.annotation.SuppressLint;
import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
@SuppressLint({"RestrictedApi"})
/* loaded from: classes17.dex */
public final class c implements com.tencent.mobileqq.qqshop.message.db.b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final RoomDatabase f274489a;

    /* renamed from: b, reason: collision with root package name */
    private final EntityInsertionAdapter<com.tencent.mobileqq.qqshop.message.db.a> f274490b;

    /* renamed from: c, reason: collision with root package name */
    private final SharedSQLiteStatement f274491c;

    /* renamed from: d, reason: collision with root package name */
    private final SharedSQLiteStatement f274492d;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class a extends EntityInsertionAdapter<com.tencent.mobileqq.qqshop.message.db.a> {
        static IPatchRedirector $redirector_;

        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this, (Object) roomDatabase);
            }
        }

        @Override // androidx.room.EntityInsertionAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, com.tencent.mobileqq.qqshop.message.db.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) supportSQLiteStatement, (Object) aVar);
                return;
            }
            supportSQLiteStatement.bindLong(1, aVar.b());
            if (aVar.d() == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, aVar.d());
            }
            supportSQLiteStatement.bindLong(3, aVar.c());
            if (aVar.a() == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindString(4, aVar.a());
            }
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "INSERT OR REPLACE INTO `qq_shop_msg_table` (`msgId`,`uid`,`msgTime`,`msgContent`) VALUES (?,?,?,?)";
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class b extends SharedSQLiteStatement {
        static IPatchRedirector $redirector_;

        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this, (Object) roomDatabase);
            }
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "DELETE FROM qq_shop_msg_table WHERE uid is ? AND msgTime <= (SELECT msgTime FROM qq_shop_msg_table WHERE uid is ? ORDER BY msgTime DESC LIMIT 1 OFFSET ?)";
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.qqshop.message.db.c$c, reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    class C8427c extends SharedSQLiteStatement {
        static IPatchRedirector $redirector_;

        C8427c(RoomDatabase roomDatabase) {
            super(roomDatabase);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this, (Object) roomDatabase);
            }
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "DELETE FROM qq_shop_msg_table WHERE uid is ?";
        }
    }

    public c(RoomDatabase roomDatabase) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) roomDatabase);
            return;
        }
        this.f274489a = roomDatabase;
        this.f274490b = new a(roomDatabase);
        this.f274491c = new b(roomDatabase);
        this.f274492d = new C8427c(roomDatabase);
    }

    public static List<Class<?>> e() {
        return Collections.emptyList();
    }

    @Override // com.tencent.mobileqq.qqshop.message.db.b
    public List<com.tencent.mobileqq.qqshop.message.db.a> a(long j3, int i3, String str) {
        String string;
        String string2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (List) iPatchRedirector.redirect((short) 8, this, Long.valueOf(j3), Integer.valueOf(i3), str);
        }
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM qq_shop_msg_table WHERE msgTime < ? AND uid is ? ORDER BY msgTime DESC LIMIT ?", 3);
        acquire.bindLong(1, j3);
        if (str == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str);
        }
        acquire.bindLong(3, i3);
        this.f274489a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.f274489a, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "msgId");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "uid");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "msgTime");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, RemoteMessageConst.MessageBody.MSG_CONTENT);
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                long j16 = query.getLong(columnIndexOrThrow);
                if (query.isNull(columnIndexOrThrow2)) {
                    string = null;
                } else {
                    string = query.getString(columnIndexOrThrow2);
                }
                long j17 = query.getLong(columnIndexOrThrow3);
                if (query.isNull(columnIndexOrThrow4)) {
                    string2 = null;
                } else {
                    string2 = query.getString(columnIndexOrThrow4);
                }
                arrayList.add(new com.tencent.mobileqq.qqshop.message.db.a(j16, string, j17, string2));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // com.tencent.mobileqq.qqshop.message.db.b
    public List<com.tencent.mobileqq.qqshop.message.db.a> b(int i3, String str) {
        String string;
        String string2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (List) iPatchRedirector.redirect((short) 7, (Object) this, i3, (Object) str);
        }
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM qq_shop_msg_table WHERE uid is ? ORDER BY msgTime DESC LIMIT ?", 2);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        acquire.bindLong(2, i3);
        this.f274489a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.f274489a, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "msgId");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "uid");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "msgTime");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, RemoteMessageConst.MessageBody.MSG_CONTENT);
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                long j3 = query.getLong(columnIndexOrThrow);
                if (query.isNull(columnIndexOrThrow2)) {
                    string = null;
                } else {
                    string = query.getString(columnIndexOrThrow2);
                }
                long j16 = query.getLong(columnIndexOrThrow3);
                if (query.isNull(columnIndexOrThrow4)) {
                    string2 = null;
                } else {
                    string2 = query.getString(columnIndexOrThrow4);
                }
                arrayList.add(new com.tencent.mobileqq.qqshop.message.db.a(j3, string, j16, string2));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // com.tencent.mobileqq.qqshop.message.db.b
    public long c(com.tencent.mobileqq.qqshop.message.db.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Long) iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar)).longValue();
        }
        this.f274489a.assertNotSuspendingTransaction();
        this.f274489a.beginTransaction();
        try {
            long insertAndReturnId = this.f274490b.insertAndReturnId(aVar);
            this.f274489a.setTransactionSuccessful();
            return insertAndReturnId;
        } finally {
            this.f274489a.endTransaction();
        }
    }

    @Override // com.tencent.mobileqq.qqshop.message.db.b
    public void d(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3, (Object) str);
            return;
        }
        this.f274489a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.f274491c.acquire();
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        if (str == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str);
        }
        acquire.bindLong(3, i3);
        this.f274489a.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.f274489a.setTransactionSuccessful();
        } finally {
            this.f274489a.endTransaction();
            this.f274491c.release(acquire);
        }
    }

    @Override // com.tencent.mobileqq.qqshop.message.db.b
    public void delete(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            return;
        }
        this.f274489a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.f274492d.acquire();
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.f274489a.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.f274489a.setTransactionSuccessful();
        } finally {
            this.f274489a.endTransaction();
            this.f274492d.release(acquire);
        }
    }
}
