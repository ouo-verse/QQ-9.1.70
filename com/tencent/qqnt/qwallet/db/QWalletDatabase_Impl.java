package com.tencent.qqnt.qwallet.db;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenHelper;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.mobileqq.app.AppConstants;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes25.dex */
public final class QWalletDatabase_Impl extends QWalletDatabase {

    /* renamed from: a, reason: collision with root package name */
    private volatile g f361833a;

    /* renamed from: b, reason: collision with root package name */
    private volatile com.tencent.qqnt.qwallet.db.a f361834b;

    /* renamed from: c, reason: collision with root package name */
    private volatile d f361835c;

    @Override // com.tencent.qqnt.qwallet.db.QWalletDatabase
    public com.tencent.qqnt.qwallet.db.a c() {
        com.tencent.qqnt.qwallet.db.a aVar;
        if (this.f361834b != null) {
            return this.f361834b;
        }
        synchronized (this) {
            if (this.f361834b == null) {
                this.f361834b = new b(this);
            }
            aVar = this.f361834b;
        }
        return aVar;
    }

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `aio_payment_state_table`");
            writableDatabase.execSQL("DELETE FROM `hb_command_table`");
            writableDatabase.execSQL("DELETE FROM `hb_state_table`");
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
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "aio_payment_state_table", "hb_command_table", "hb_state_table");
    }

    @Override // androidx.room.RoomDatabase
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(databaseConfiguration.context).name(databaseConfiguration.name).callback(new RoomOpenHelper(databaseConfiguration, new a(4), "769e57ee568ffed16f47be793b68cd71", "8e1d37452e2972bf5577206658b9ba3e")).build());
    }

    @Override // com.tencent.qqnt.qwallet.db.QWalletDatabase
    public d d() {
        d dVar;
        if (this.f361835c != null) {
            return this.f361835c;
        }
        synchronized (this) {
            if (this.f361835c == null) {
                this.f361835c = new e(this);
            }
            dVar = this.f361835c;
        }
        return dVar;
    }

    @Override // com.tencent.qqnt.qwallet.db.QWalletDatabase
    public g e() {
        g gVar;
        if (this.f361833a != null) {
            return this.f361833a;
        }
        synchronized (this) {
            if (this.f361833a == null) {
                this.f361833a = new h(this);
            }
            gVar = this.f361833a;
        }
        return gVar;
    }

    @Override // androidx.room.RoomDatabase
    protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap hashMap = new HashMap();
        hashMap.put(g.class, h.d());
        hashMap.put(com.tencent.qqnt.qwallet.db.a.class, b.d());
        hashMap.put(d.class, e.d());
        return hashMap;
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    class a extends RoomOpenHelper.Delegate {
        a(int i3) {
            super(i3);
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `aio_payment_state_table` (`loginUin` TEXT NOT NULL, `paymentId` TEXT NOT NULL, `msgOwnerUin` TEXT NOT NULL, `paymentType` INTEGER NOT NULL, `groupUin` TEXT NOT NULL, `state` INTEGER NOT NULL, PRIMARY KEY(`paymentId`, `msgOwnerUin`, `paymentType`, `loginUin`))");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `hb_command_table` (`listId` TEXT NOT NULL, `command` TEXT NOT NULL, `expireTime` INTEGER NOT NULL, `senderUin` INTEGER NOT NULL, `peerUin` INTEGER NOT NULL, `authKey` TEXT NOT NULL, `chatType` INTEGER NOT NULL, `redChannel` INTEGER NOT NULL, `payFlag` INTEGER NOT NULL, `hbFlag` INTEGER NOT NULL, `resourceType` INTEGER NOT NULL, `hbFrom` INTEGER NOT NULL, PRIMARY KEY(`listId`))");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `hb_state_table` (`listId` TEXT NOT NULL, `toUin` TEXT NOT NULL, `expireTime` INTEGER NOT NULL, `state` INTEGER NOT NULL, `sendState` INTEGER NOT NULL, `text` TEXT NOT NULL, PRIMARY KEY(`listId`, `toUin`))");
            supportSQLiteDatabase.execSQL(RoomMasterTable.CREATE_QUERY);
            supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '769e57ee568ffed16f47be793b68cd71')");
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `aio_payment_state_table`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `hb_command_table`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `hb_state_table`");
            if (((RoomDatabase) QWalletDatabase_Impl.this).mCallbacks != null) {
                int size = ((RoomDatabase) QWalletDatabase_Impl.this).mCallbacks.size();
                for (int i3 = 0; i3 < size; i3++) {
                    ((RoomDatabase.Callback) ((RoomDatabase) QWalletDatabase_Impl.this).mCallbacks.get(i3)).onDestructiveMigration(supportSQLiteDatabase);
                }
            }
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        protected void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
            if (((RoomDatabase) QWalletDatabase_Impl.this).mCallbacks != null) {
                int size = ((RoomDatabase) QWalletDatabase_Impl.this).mCallbacks.size();
                for (int i3 = 0; i3 < size; i3++) {
                    ((RoomDatabase.Callback) ((RoomDatabase) QWalletDatabase_Impl.this).mCallbacks.get(i3)).onCreate(supportSQLiteDatabase);
                }
            }
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
            ((RoomDatabase) QWalletDatabase_Impl.this).mDatabase = supportSQLiteDatabase;
            QWalletDatabase_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
            if (((RoomDatabase) QWalletDatabase_Impl.this).mCallbacks != null) {
                int size = ((RoomDatabase) QWalletDatabase_Impl.this).mCallbacks.size();
                for (int i3 = 0; i3 < size; i3++) {
                    ((RoomDatabase.Callback) ((RoomDatabase) QWalletDatabase_Impl.this).mCallbacks.get(i3)).onOpen(supportSQLiteDatabase);
                }
            }
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void onPreMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            DBUtil.dropFtsSyncTriggers(supportSQLiteDatabase);
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase supportSQLiteDatabase) {
            HashMap hashMap = new HashMap(6);
            hashMap.put(AlbumCacheData.LOGINUIN, new TableInfo.Column(AlbumCacheData.LOGINUIN, "TEXT", true, 4, null, 1));
            hashMap.put("paymentId", new TableInfo.Column("paymentId", "TEXT", true, 1, null, 1));
            hashMap.put("msgOwnerUin", new TableInfo.Column("msgOwnerUin", "TEXT", true, 2, null, 1));
            hashMap.put("paymentType", new TableInfo.Column("paymentType", "INTEGER", true, 3, null, 1));
            hashMap.put("groupUin", new TableInfo.Column("groupUin", "TEXT", true, 0, null, 1));
            hashMap.put("state", new TableInfo.Column("state", "INTEGER", true, 0, null, 1));
            TableInfo tableInfo = new TableInfo("aio_payment_state_table", hashMap, new HashSet(0), new HashSet(0));
            TableInfo read = TableInfo.read(supportSQLiteDatabase, "aio_payment_state_table");
            if (!tableInfo.equals(read)) {
                return new RoomOpenHelper.ValidationResult(false, "aio_payment_state_table(com.tencent.qqnt.qwallet.db.PaymentStateEntity).\n Expected:\n" + tableInfo + "\n Found:\n" + read);
            }
            HashMap hashMap2 = new HashMap(12);
            hashMap2.put("listId", new TableInfo.Column("listId", "TEXT", true, 1, null, 1));
            hashMap2.put("command", new TableInfo.Column("command", "TEXT", true, 0, null, 1));
            hashMap2.put("expireTime", new TableInfo.Column("expireTime", "INTEGER", true, 0, null, 1));
            hashMap2.put(AppConstants.Key.COLUMN_MSG_SENDER_UIN, new TableInfo.Column(AppConstants.Key.COLUMN_MSG_SENDER_UIN, "INTEGER", true, 0, null, 1));
            hashMap2.put("peerUin", new TableInfo.Column("peerUin", "INTEGER", true, 0, null, 1));
            hashMap2.put("authKey", new TableInfo.Column("authKey", "TEXT", true, 0, null, 1));
            hashMap2.put("chatType", new TableInfo.Column("chatType", "INTEGER", true, 0, null, 1));
            hashMap2.put("redChannel", new TableInfo.Column("redChannel", "INTEGER", true, 0, null, 1));
            hashMap2.put("payFlag", new TableInfo.Column("payFlag", "INTEGER", true, 0, null, 1));
            hashMap2.put("hbFlag", new TableInfo.Column("hbFlag", "INTEGER", true, 0, null, 1));
            hashMap2.put("resourceType", new TableInfo.Column("resourceType", "INTEGER", true, 0, null, 1));
            hashMap2.put("hbFrom", new TableInfo.Column("hbFrom", "INTEGER", true, 0, null, 1));
            TableInfo tableInfo2 = new TableInfo("hb_command_table", hashMap2, new HashSet(0), new HashSet(0));
            TableInfo read2 = TableInfo.read(supportSQLiteDatabase, "hb_command_table");
            if (!tableInfo2.equals(read2)) {
                return new RoomOpenHelper.ValidationResult(false, "hb_command_table(com.tencent.qqnt.qwallet.db.HbCommandEntity).\n Expected:\n" + tableInfo2 + "\n Found:\n" + read2);
            }
            HashMap hashMap3 = new HashMap(6);
            hashMap3.put("listId", new TableInfo.Column("listId", "TEXT", true, 1, null, 1));
            hashMap3.put("toUin", new TableInfo.Column("toUin", "TEXT", true, 2, null, 1));
            hashMap3.put("expireTime", new TableInfo.Column("expireTime", "INTEGER", true, 0, null, 1));
            hashMap3.put("state", new TableInfo.Column("state", "INTEGER", true, 0, null, 1));
            hashMap3.put("sendState", new TableInfo.Column("sendState", "INTEGER", true, 0, null, 1));
            hashMap3.put("text", new TableInfo.Column("text", "TEXT", true, 0, null, 1));
            TableInfo tableInfo3 = new TableInfo("hb_state_table", hashMap3, new HashSet(0), new HashSet(0));
            TableInfo read3 = TableInfo.read(supportSQLiteDatabase, "hb_state_table");
            if (!tableInfo3.equals(read3)) {
                return new RoomOpenHelper.ValidationResult(false, "hb_state_table(com.tencent.qqnt.qwallet.db.HbStateEntity).\n Expected:\n" + tableInfo3 + "\n Found:\n" + read3);
            }
            return new RoomOpenHelper.ValidationResult(true, null);
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        }
    }
}
