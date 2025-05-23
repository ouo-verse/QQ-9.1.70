package com.tencent.mobileqq.qqshop.message.db;

import android.annotation.SuppressLint;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenHelper;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* compiled from: P */
@SuppressLint({"RestrictedApi"})
/* loaded from: classes17.dex */
public final class QQShopMsgDatabase_Impl extends QQShopMsgDatabase {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private volatile b f274483b;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class a extends RoomOpenHelper.Delegate {
        static IPatchRedirector $redirector_;

        a(int i3) {
            super(i3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQShopMsgDatabase_Impl.this, i3);
            }
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) supportSQLiteDatabase);
                return;
            }
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `qq_shop_msg_table` (`msgId` INTEGER NOT NULL, `uid` TEXT NOT NULL, `msgTime` INTEGER NOT NULL, `msgContent` TEXT NOT NULL, PRIMARY KEY(`msgId`))");
            supportSQLiteDatabase.execSQL(RoomMasterTable.CREATE_QUERY);
            supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '37b970474c14f9e1deac636b29ee0fef')");
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) supportSQLiteDatabase);
                return;
            }
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `qq_shop_msg_table`");
            if (((RoomDatabase) QQShopMsgDatabase_Impl.this).mCallbacks != null) {
                int size = ((RoomDatabase) QQShopMsgDatabase_Impl.this).mCallbacks.size();
                for (int i3 = 0; i3 < size; i3++) {
                    ((RoomDatabase.Callback) ((RoomDatabase) QQShopMsgDatabase_Impl.this).mCallbacks.get(i3)).onDestructiveMigration(supportSQLiteDatabase);
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
            if (((RoomDatabase) QQShopMsgDatabase_Impl.this).mCallbacks != null) {
                int size = ((RoomDatabase) QQShopMsgDatabase_Impl.this).mCallbacks.size();
                for (int i3 = 0; i3 < size; i3++) {
                    ((RoomDatabase.Callback) ((RoomDatabase) QQShopMsgDatabase_Impl.this).mCallbacks.get(i3)).onCreate(supportSQLiteDatabase);
                }
            }
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                ((RoomDatabase) QQShopMsgDatabase_Impl.this).mDatabase = supportSQLiteDatabase;
                QQShopMsgDatabase_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
                if (((RoomDatabase) QQShopMsgDatabase_Impl.this).mCallbacks != null) {
                    int size = ((RoomDatabase) QQShopMsgDatabase_Impl.this).mCallbacks.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ((RoomDatabase.Callback) ((RoomDatabase) QQShopMsgDatabase_Impl.this).mCallbacks.get(i3)).onOpen(supportSQLiteDatabase);
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
            HashMap hashMap = new HashMap(4);
            hashMap.put("msgId", new TableInfo.Column("msgId", "INTEGER", true, 1, null, 1));
            hashMap.put("uid", new TableInfo.Column("uid", "TEXT", true, 0, null, 1));
            hashMap.put("msgTime", new TableInfo.Column("msgTime", "INTEGER", true, 0, null, 1));
            hashMap.put(RemoteMessageConst.MessageBody.MSG_CONTENT, new TableInfo.Column(RemoteMessageConst.MessageBody.MSG_CONTENT, "TEXT", true, 0, null, 1));
            TableInfo tableInfo = new TableInfo("qq_shop_msg_table", hashMap, new HashSet(0), new HashSet(0));
            TableInfo read = TableInfo.read(supportSQLiteDatabase, "qq_shop_msg_table");
            if (!tableInfo.equals(read)) {
                return new RoomOpenHelper.ValidationResult(false, "qq_shop_msg_table(com.tencent.mobileqq.qqshop.message.db.QQShopMsgData).\n Expected:\n" + tableInfo + "\n Found:\n" + read);
            }
            return new RoomOpenHelper.ValidationResult(true, null);
        }
    }

    public QQShopMsgDatabase_Impl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqshop.message.db.QQShopMsgDatabase
    public b c() {
        b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (b) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        if (this.f274483b != null) {
            return this.f274483b;
        }
        synchronized (this) {
            if (this.f274483b == null) {
                this.f274483b = new c(this);
            }
            bVar = this.f274483b;
        }
        return bVar;
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
            writableDatabase.execSQL("DELETE FROM `qq_shop_msg_table`");
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
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "qq_shop_msg_table");
    }

    @Override // androidx.room.RoomDatabase
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (SupportSQLiteOpenHelper) iPatchRedirector.redirect((short) 2, (Object) this, (Object) databaseConfiguration);
        }
        return databaseConfiguration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(databaseConfiguration.context).name(databaseConfiguration.name).callback(new RoomOpenHelper(databaseConfiguration, new a(1), "37b970474c14f9e1deac636b29ee0fef", "0f6329b7d84ecec0d07a6c5a51be5d2b")).build());
    }

    @Override // androidx.room.RoomDatabase
    protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Map) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        HashMap hashMap = new HashMap();
        hashMap.put(b.class, c.e());
        return hashMap;
    }
}
