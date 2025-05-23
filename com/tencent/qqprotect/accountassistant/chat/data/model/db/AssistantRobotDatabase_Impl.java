package com.tencent.qqprotect.accountassistant.chat.data.model.db;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenHelper;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes25.dex */
public final class AssistantRobotDatabase_Impl extends AssistantRobotDatabase {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private volatile com.tencent.qqprotect.accountassistant.chat.data.model.db.a f363460b;

    /* compiled from: P */
    /* loaded from: classes25.dex */
    class a extends RoomOpenHelper.Delegate {
        static IPatchRedirector $redirector_;

        a(int i3) {
            super(i3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AssistantRobotDatabase_Impl.this, i3);
            }
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) supportSQLiteDatabase);
                return;
            }
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `assistant_robot_message_table` (`msgId` TEXT NOT NULL, `msg_seq` INTEGER NOT NULL, `conversation_id` TEXT, `msg_type` INTEGER NOT NULL, `msg_sender_type` INTEGER NOT NULL, `msg_time` INTEGER NOT NULL, `msg_text` TEXT, `msg_ext_text` TEXT, `msg_send_status` INTEGER NOT NULL, `need_reply` INTEGER NOT NULL, `row_id` INTEGER NOT NULL, PRIMARY KEY(`msgId`))");
            supportSQLiteDatabase.execSQL(RoomMasterTable.CREATE_QUERY);
            supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '177f6d50981aee46e195f99eb674a151')");
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) supportSQLiteDatabase);
                return;
            }
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `assistant_robot_message_table`");
            if (((RoomDatabase) AssistantRobotDatabase_Impl.this).mCallbacks != null) {
                int size = ((RoomDatabase) AssistantRobotDatabase_Impl.this).mCallbacks.size();
                for (int i3 = 0; i3 < size; i3++) {
                    ((RoomDatabase.Callback) ((RoomDatabase) AssistantRobotDatabase_Impl.this).mCallbacks.get(i3)).onDestructiveMigration(supportSQLiteDatabase);
                }
            }
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        protected void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) supportSQLiteDatabase);
                return;
            }
            if (((RoomDatabase) AssistantRobotDatabase_Impl.this).mCallbacks != null) {
                int size = ((RoomDatabase) AssistantRobotDatabase_Impl.this).mCallbacks.size();
                for (int i3 = 0; i3 < size; i3++) {
                    ((RoomDatabase.Callback) ((RoomDatabase) AssistantRobotDatabase_Impl.this).mCallbacks.get(i3)).onCreate(supportSQLiteDatabase);
                }
            }
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                ((RoomDatabase) AssistantRobotDatabase_Impl.this).mDatabase = supportSQLiteDatabase;
                AssistantRobotDatabase_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
                if (((RoomDatabase) AssistantRobotDatabase_Impl.this).mCallbacks != null) {
                    int size = ((RoomDatabase) AssistantRobotDatabase_Impl.this).mCallbacks.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ((RoomDatabase.Callback) ((RoomDatabase) AssistantRobotDatabase_Impl.this).mCallbacks.get(i3)).onOpen(supportSQLiteDatabase);
                    }
                    return;
                }
                return;
            }
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) supportSQLiteDatabase);
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) supportSQLiteDatabase);
            }
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void onPreMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) supportSQLiteDatabase);
            } else {
                DBUtil.dropFtsSyncTriggers(supportSQLiteDatabase);
            }
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase supportSQLiteDatabase) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (RoomOpenHelper.ValidationResult) iPatchRedirector.redirect((short) 8, (Object) this, (Object) supportSQLiteDatabase);
            }
            HashMap hashMap = new HashMap(11);
            hashMap.put("msgId", new TableInfo.Column("msgId", "TEXT", true, 1, null, 1));
            hashMap.put("msg_seq", new TableInfo.Column("msg_seq", "INTEGER", true, 0, null, 1));
            hashMap.put("conversation_id", new TableInfo.Column("conversation_id", "TEXT", false, 0, null, 1));
            hashMap.put(QQHealthReportApiImpl.MSG_TYPE_KEY, new TableInfo.Column(QQHealthReportApiImpl.MSG_TYPE_KEY, "INTEGER", true, 0, null, 1));
            hashMap.put("msg_sender_type", new TableInfo.Column("msg_sender_type", "INTEGER", true, 0, null, 1));
            hashMap.put(ProtocolDownloaderConstants.HEADER_C2C_MSG_TIME, new TableInfo.Column(ProtocolDownloaderConstants.HEADER_C2C_MSG_TIME, "INTEGER", true, 0, null, 1));
            hashMap.put("msg_text", new TableInfo.Column("msg_text", "TEXT", false, 0, null, 1));
            hashMap.put("msg_ext_text", new TableInfo.Column("msg_ext_text", "TEXT", false, 0, null, 1));
            hashMap.put("msg_send_status", new TableInfo.Column("msg_send_status", "INTEGER", true, 0, null, 1));
            hashMap.put("need_reply", new TableInfo.Column("need_reply", "INTEGER", true, 0, null, 1));
            hashMap.put("row_id", new TableInfo.Column("row_id", "INTEGER", true, 0, null, 1));
            TableInfo tableInfo = new TableInfo("assistant_robot_message_table", hashMap, new HashSet(0), new HashSet(0));
            TableInfo read = TableInfo.read(supportSQLiteDatabase, "assistant_robot_message_table");
            if (!tableInfo.equals(read)) {
                return new RoomOpenHelper.ValidationResult(false, "assistant_robot_message_table(com.tencent.qqprotect.accountassistant.chat.data.model.db.AssistantRobotMessageEntity).\n Expected:\n" + tableInfo + "\n Found:\n" + read);
            }
            return new RoomOpenHelper.ValidationResult(true, null);
        }
    }

    public AssistantRobotDatabase_Impl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `assistant_robot_message_table`");
            super.setTransactionSuccessful();
        } finally {
            super.endTransaction();
            writableDatabase.query("PRAGMA wal_checkpoint(FULL)").close();
            if (!writableDatabase.inTransaction()) {
                writableDatabase.execSQL("VACUUM");
            }
        }
    }

    @Override // androidx.room.RoomDatabase
    protected InvalidationTracker createInvalidationTracker() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (InvalidationTracker) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "assistant_robot_message_table");
    }

    @Override // androidx.room.RoomDatabase
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (SupportSQLiteOpenHelper) iPatchRedirector.redirect((short) 2, (Object) this, (Object) databaseConfiguration);
        }
        return databaseConfiguration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(databaseConfiguration.context).name(databaseConfiguration.name).callback(new RoomOpenHelper(databaseConfiguration, new a(5), "177f6d50981aee46e195f99eb674a151", "d31e652b3ea08728176382e6a852d193")).build());
    }

    @Override // com.tencent.qqprotect.accountassistant.chat.data.model.db.AssistantRobotDatabase
    public com.tencent.qqprotect.accountassistant.chat.data.model.db.a d() {
        com.tencent.qqprotect.accountassistant.chat.data.model.db.a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.qqprotect.accountassistant.chat.data.model.db.a) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        if (this.f363460b != null) {
            return this.f363460b;
        }
        synchronized (this) {
            if (this.f363460b == null) {
                this.f363460b = new b(this);
            }
            aVar = this.f363460b;
        }
        return aVar;
    }

    @Override // androidx.room.RoomDatabase
    protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Map) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        HashMap hashMap = new HashMap();
        hashMap.put(com.tencent.qqprotect.accountassistant.chat.data.model.db.a.class, b.h());
        return hashMap;
    }
}
