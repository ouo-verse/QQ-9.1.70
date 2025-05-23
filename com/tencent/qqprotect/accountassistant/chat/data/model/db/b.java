package com.tencent.qqprotect.accountassistant.chat.data.model.db;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes25.dex */
public final class b implements com.tencent.qqprotect.accountassistant.chat.data.model.db.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final RoomDatabase f363462a;

    /* renamed from: b, reason: collision with root package name */
    private final EntityInsertionAdapter<com.tencent.qqprotect.accountassistant.chat.data.model.db.c> f363463b;

    /* renamed from: c, reason: collision with root package name */
    private final EntityDeletionOrUpdateAdapter<com.tencent.qqprotect.accountassistant.chat.data.model.db.c> f363464c;

    /* renamed from: d, reason: collision with root package name */
    private final EntityDeletionOrUpdateAdapter<com.tencent.qqprotect.accountassistant.chat.data.model.db.c> f363465d;

    /* renamed from: e, reason: collision with root package name */
    private final SharedSQLiteStatement f363466e;

    /* renamed from: f, reason: collision with root package name */
    private final SharedSQLiteStatement f363467f;

    /* compiled from: P */
    /* loaded from: classes25.dex */
    class a extends EntityInsertionAdapter<com.tencent.qqprotect.accountassistant.chat.data.model.db.c> {
        static IPatchRedirector $redirector_;

        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this, (Object) roomDatabase);
            }
        }

        @Override // androidx.room.EntityInsertionAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, com.tencent.qqprotect.accountassistant.chat.data.model.db.c cVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) supportSQLiteStatement, (Object) cVar);
                return;
            }
            String str = cVar.f363473a;
            if (str == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, str);
            }
            supportSQLiteStatement.bindLong(2, cVar.f363474b);
            String str2 = cVar.f363475c;
            if (str2 == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, str2);
            }
            supportSQLiteStatement.bindLong(4, cVar.f363476d);
            supportSQLiteStatement.bindLong(5, cVar.f363477e);
            supportSQLiteStatement.bindLong(6, cVar.f363478f);
            String str3 = cVar.f363479g;
            if (str3 == null) {
                supportSQLiteStatement.bindNull(7);
            } else {
                supportSQLiteStatement.bindString(7, str3);
            }
            String str4 = cVar.f363480h;
            if (str4 == null) {
                supportSQLiteStatement.bindNull(8);
            } else {
                supportSQLiteStatement.bindString(8, str4);
            }
            supportSQLiteStatement.bindLong(9, cVar.f363481i);
            supportSQLiteStatement.bindLong(10, cVar.f363482j ? 1L : 0L);
            supportSQLiteStatement.bindLong(11, cVar.f363483k);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "INSERT OR REPLACE INTO `assistant_robot_message_table` (`msgId`,`msg_seq`,`conversation_id`,`msg_type`,`msg_sender_type`,`msg_time`,`msg_text`,`msg_ext_text`,`msg_send_status`,`need_reply`,`row_id`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.qqprotect.accountassistant.chat.data.model.db.b$b, reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    class C9712b extends EntityDeletionOrUpdateAdapter<com.tencent.qqprotect.accountassistant.chat.data.model.db.c> {
        static IPatchRedirector $redirector_;

        C9712b(RoomDatabase roomDatabase) {
            super(roomDatabase);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this, (Object) roomDatabase);
            }
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, com.tencent.qqprotect.accountassistant.chat.data.model.db.c cVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) supportSQLiteStatement, (Object) cVar);
                return;
            }
            String str = cVar.f363473a;
            if (str == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, str);
            }
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
        public String createQuery() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "DELETE FROM `assistant_robot_message_table` WHERE `msgId` = ?";
        }
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    class c extends EntityDeletionOrUpdateAdapter<com.tencent.qqprotect.accountassistant.chat.data.model.db.c> {
        static IPatchRedirector $redirector_;

        c(RoomDatabase roomDatabase) {
            super(roomDatabase);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this, (Object) roomDatabase);
            }
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, com.tencent.qqprotect.accountassistant.chat.data.model.db.c cVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) supportSQLiteStatement, (Object) cVar);
                return;
            }
            String str = cVar.f363473a;
            if (str == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, str);
            }
            supportSQLiteStatement.bindLong(2, cVar.f363474b);
            String str2 = cVar.f363475c;
            if (str2 == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, str2);
            }
            supportSQLiteStatement.bindLong(4, cVar.f363476d);
            supportSQLiteStatement.bindLong(5, cVar.f363477e);
            supportSQLiteStatement.bindLong(6, cVar.f363478f);
            String str3 = cVar.f363479g;
            if (str3 == null) {
                supportSQLiteStatement.bindNull(7);
            } else {
                supportSQLiteStatement.bindString(7, str3);
            }
            String str4 = cVar.f363480h;
            if (str4 == null) {
                supportSQLiteStatement.bindNull(8);
            } else {
                supportSQLiteStatement.bindString(8, str4);
            }
            supportSQLiteStatement.bindLong(9, cVar.f363481i);
            supportSQLiteStatement.bindLong(10, cVar.f363482j ? 1L : 0L);
            supportSQLiteStatement.bindLong(11, cVar.f363483k);
            String str5 = cVar.f363473a;
            if (str5 == null) {
                supportSQLiteStatement.bindNull(12);
            } else {
                supportSQLiteStatement.bindString(12, str5);
            }
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
        public String createQuery() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "UPDATE OR ABORT `assistant_robot_message_table` SET `msgId` = ?,`msg_seq` = ?,`conversation_id` = ?,`msg_type` = ?,`msg_sender_type` = ?,`msg_time` = ?,`msg_text` = ?,`msg_ext_text` = ?,`msg_send_status` = ?,`need_reply` = ?,`row_id` = ? WHERE `msgId` = ?";
        }
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    class d extends SharedSQLiteStatement {
        static IPatchRedirector $redirector_;

        d(RoomDatabase roomDatabase) {
            super(roomDatabase);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this, (Object) roomDatabase);
            }
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "UPDATE assistant_robot_message_table SET msg_time = ?, msg_send_status = ?   WHERE  msgId= ?";
        }
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    class e extends SharedSQLiteStatement {
        static IPatchRedirector $redirector_;

        e(RoomDatabase roomDatabase) {
            super(roomDatabase);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this, (Object) roomDatabase);
            }
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "DELETE FROM assistant_robot_message_table";
        }
    }

    public b(RoomDatabase roomDatabase) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) roomDatabase);
            return;
        }
        this.f363462a = roomDatabase;
        this.f363463b = new a(roomDatabase);
        this.f363464c = new C9712b(roomDatabase);
        this.f363465d = new c(roomDatabase);
        this.f363466e = new d(roomDatabase);
        this.f363467f = new e(roomDatabase);
    }

    public static List<Class<?>> h() {
        return Collections.emptyList();
    }

    @Override // com.tencent.qqprotect.accountassistant.chat.data.model.db.a
    public void a(com.tencent.qqprotect.accountassistant.chat.data.model.db.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) cVar);
            return;
        }
        this.f363462a.assertNotSuspendingTransaction();
        this.f363462a.beginTransaction();
        try {
            this.f363465d.handle(cVar);
            this.f363462a.setTransactionSuccessful();
        } finally {
            this.f363462a.endTransaction();
        }
    }

    @Override // com.tencent.qqprotect.accountassistant.chat.data.model.db.a
    public com.tencent.qqprotect.accountassistant.chat.data.model.db.c b(String str) {
        String string;
        String string2;
        String string3;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (com.tencent.qqprotect.accountassistant.chat.data.model.db.c) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        }
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM assistant_robot_message_table WHERE conversation_id = ? And msg_send_status = 1 ORDER BY row_id DESC LIMIT 1", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.f363462a.assertNotSuspendingTransaction();
        com.tencent.qqprotect.accountassistant.chat.data.model.db.c cVar = null;
        String string4 = null;
        Cursor query = DBUtil.query(this.f363462a, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "msgId");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "msg_seq");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "conversation_id");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, QQHealthReportApiImpl.MSG_TYPE_KEY);
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "msg_sender_type");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, ProtocolDownloaderConstants.HEADER_C2C_MSG_TIME);
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "msg_text");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "msg_ext_text");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "msg_send_status");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "need_reply");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "row_id");
            if (query.moveToFirst()) {
                if (query.isNull(columnIndexOrThrow)) {
                    string = null;
                } else {
                    string = query.getString(columnIndexOrThrow);
                }
                long j3 = query.getLong(columnIndexOrThrow2);
                if (query.isNull(columnIndexOrThrow3)) {
                    string2 = null;
                } else {
                    string2 = query.getString(columnIndexOrThrow3);
                }
                int i3 = query.getInt(columnIndexOrThrow4);
                int i16 = query.getInt(columnIndexOrThrow5);
                long j16 = query.getLong(columnIndexOrThrow6);
                if (query.isNull(columnIndexOrThrow7)) {
                    string3 = null;
                } else {
                    string3 = query.getString(columnIndexOrThrow7);
                }
                if (!query.isNull(columnIndexOrThrow8)) {
                    string4 = query.getString(columnIndexOrThrow8);
                }
                String str2 = string4;
                int i17 = query.getInt(columnIndexOrThrow9);
                if (query.getInt(columnIndexOrThrow10) != 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                cVar = new com.tencent.qqprotect.accountassistant.chat.data.model.db.c(string, j3, string2, i3, i16, j16, string3, str2, i17, z16, query.getLong(columnIndexOrThrow11));
            }
            return cVar;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // com.tencent.qqprotect.accountassistant.chat.data.model.db.a
    public List<com.tencent.qqprotect.accountassistant.chat.data.model.db.c> c(String str, long j3, int i3) {
        String string;
        String string2;
        String string3;
        String string4;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (List) iPatchRedirector.redirect((short) 8, this, str, Long.valueOf(j3), Integer.valueOf(i3));
        }
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM assistant_robot_message_table WHERE (? = 0 OR row_id < ?) AND conversation_id = ? ORDER BY row_id DESC LIMIT ?", 4);
        acquire.bindLong(1, j3);
        acquire.bindLong(2, j3);
        if (str == null) {
            acquire.bindNull(3);
        } else {
            acquire.bindString(3, str);
        }
        acquire.bindLong(4, i3);
        this.f363462a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.f363462a, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "msgId");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "msg_seq");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "conversation_id");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, QQHealthReportApiImpl.MSG_TYPE_KEY);
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "msg_sender_type");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, ProtocolDownloaderConstants.HEADER_C2C_MSG_TIME);
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "msg_text");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "msg_ext_text");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "msg_send_status");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "need_reply");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "row_id");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                if (query.isNull(columnIndexOrThrow)) {
                    string = null;
                } else {
                    string = query.getString(columnIndexOrThrow);
                }
                long j16 = query.getLong(columnIndexOrThrow2);
                if (query.isNull(columnIndexOrThrow3)) {
                    string2 = null;
                } else {
                    string2 = query.getString(columnIndexOrThrow3);
                }
                int i16 = query.getInt(columnIndexOrThrow4);
                int i17 = query.getInt(columnIndexOrThrow5);
                long j17 = query.getLong(columnIndexOrThrow6);
                if (query.isNull(columnIndexOrThrow7)) {
                    string3 = null;
                } else {
                    string3 = query.getString(columnIndexOrThrow7);
                }
                if (query.isNull(columnIndexOrThrow8)) {
                    string4 = null;
                } else {
                    string4 = query.getString(columnIndexOrThrow8);
                }
                int i18 = query.getInt(columnIndexOrThrow9);
                if (query.getInt(columnIndexOrThrow10) != 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                arrayList.add(new com.tencent.qqprotect.accountassistant.chat.data.model.db.c(string, j16, string2, i16, i17, j17, string3, string4, i18, z16, query.getLong(columnIndexOrThrow11)));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // com.tencent.qqprotect.accountassistant.chat.data.model.db.a
    public com.tencent.qqprotect.accountassistant.chat.data.model.db.c d(String str) {
        String string;
        String string2;
        String string3;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (com.tencent.qqprotect.accountassistant.chat.data.model.db.c) iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
        }
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM assistant_robot_message_table WHERE msgId = ?", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.f363462a.assertNotSuspendingTransaction();
        com.tencent.qqprotect.accountassistant.chat.data.model.db.c cVar = null;
        String string4 = null;
        Cursor query = DBUtil.query(this.f363462a, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "msgId");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "msg_seq");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "conversation_id");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, QQHealthReportApiImpl.MSG_TYPE_KEY);
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "msg_sender_type");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, ProtocolDownloaderConstants.HEADER_C2C_MSG_TIME);
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "msg_text");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "msg_ext_text");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "msg_send_status");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "need_reply");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "row_id");
            if (query.moveToFirst()) {
                if (query.isNull(columnIndexOrThrow)) {
                    string = null;
                } else {
                    string = query.getString(columnIndexOrThrow);
                }
                long j3 = query.getLong(columnIndexOrThrow2);
                if (query.isNull(columnIndexOrThrow3)) {
                    string2 = null;
                } else {
                    string2 = query.getString(columnIndexOrThrow3);
                }
                int i3 = query.getInt(columnIndexOrThrow4);
                int i16 = query.getInt(columnIndexOrThrow5);
                long j16 = query.getLong(columnIndexOrThrow6);
                if (query.isNull(columnIndexOrThrow7)) {
                    string3 = null;
                } else {
                    string3 = query.getString(columnIndexOrThrow7);
                }
                if (!query.isNull(columnIndexOrThrow8)) {
                    string4 = query.getString(columnIndexOrThrow8);
                }
                String str2 = string4;
                int i17 = query.getInt(columnIndexOrThrow9);
                if (query.getInt(columnIndexOrThrow10) != 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                cVar = new com.tencent.qqprotect.accountassistant.chat.data.model.db.c(string, j3, string2, i3, i16, j16, string3, str2, i17, z16, query.getLong(columnIndexOrThrow11));
            }
            return cVar;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // com.tencent.qqprotect.accountassistant.chat.data.model.db.a
    public void e(com.tencent.qqprotect.accountassistant.chat.data.model.db.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) cVar);
            return;
        }
        this.f363462a.assertNotSuspendingTransaction();
        this.f363462a.beginTransaction();
        try {
            this.f363464c.handle(cVar);
            this.f363462a.setTransactionSuccessful();
        } finally {
            this.f363462a.endTransaction();
        }
    }

    @Override // com.tencent.qqprotect.accountassistant.chat.data.model.db.a
    public void f(List<com.tencent.qqprotect.accountassistant.chat.data.model.db.c> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
            return;
        }
        this.f363462a.assertNotSuspendingTransaction();
        this.f363462a.beginTransaction();
        try {
            this.f363463b.insert(list);
            this.f363462a.setTransactionSuccessful();
        } finally {
            this.f363462a.endTransaction();
        }
    }

    @Override // com.tencent.qqprotect.accountassistant.chat.data.model.db.a
    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        this.f363462a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.f363467f.acquire();
        this.f363462a.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.f363462a.setTransactionSuccessful();
        } finally {
            this.f363462a.endTransaction();
            this.f363467f.release(acquire);
        }
    }

    @Override // com.tencent.qqprotect.accountassistant.chat.data.model.db.a
    public int getItemCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        int i3 = 0;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM assistant_robot_message_table", 0);
        this.f363462a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.f363462a, acquire, false, null);
        try {
            if (query.moveToFirst()) {
                i3 = query.getInt(0);
            }
            return i3;
        } finally {
            query.close();
            acquire.release();
        }
    }
}
