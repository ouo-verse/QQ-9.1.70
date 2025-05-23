package com.tencent.ecommerce.repo.db;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenHelper;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.tencent.mobileqq.mini.servlet.MiniAppSendSmsCodeServlet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import vj0.b;
import vj0.c;
import vj0.d;
import vj0.e;
import vj0.f;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECommerceDatabase_Impl extends ECommerceDatabase {
    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `Product`");
            writableDatabase.execSQL("DELETE FROM `ECPtsCacheData`");
            writableDatabase.execSQL("DELETE FROM `ECAddress`");
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
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "Product", "ECPtsCacheData", "ECAddress");
    }

    @Override // androidx.room.RoomDatabase
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(databaseConfiguration.context).name(databaseConfiguration.name).callback(new RoomOpenHelper(databaseConfiguration, new a(3), "119a6e76e1b651ce0ceb9846970bbd5b", "c8c08617ff6cda75f62205f3b752181c")).build());
    }

    @Override // androidx.room.RoomDatabase
    protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap hashMap = new HashMap();
        hashMap.put(c.class, d.a());
        hashMap.put(e.class, f.a());
        hashMap.put(vj0.a.class, b.a());
        return hashMap;
    }

    /* compiled from: P */
    /* loaded from: classes31.dex */
    class a extends RoomOpenHelper.Delegate {
        a(int i3) {
            super(i3);
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `Product` (`mediaProductId` TEXT NOT NULL, `saasProductId` TEXT NOT NULL, `title` TEXT NOT NULL, `desc` TEXT NOT NULL, `price` INTEGER NOT NULL, `originPrice` INTEGER NOT NULL, `couponPrice` INTEGER NOT NULL, `commission` INTEGER NOT NULL, `commissionRate` REAL NOT NULL, `priceLower` INTEGER NOT NULL, `priceUpper` INTEGER NOT NULL, `commissionLower` INTEGER NOT NULL, `commissonUpper` INTEGER NOT NULL, `inventory` INTEGER NOT NULL, `sales` INTEGER NOT NULL, `saasTypeStr` TEXT NOT NULL, `saasTypeName` TEXT NOT NULL, `detailUrl` TEXT NOT NULL, `inWindow` INTEGER NOT NULL, `editable` INTEGER NOT NULL, `selected` INTEGER NOT NULL, `isMaster` INTEGER NOT NULL, `showAddBtn` INTEGER NOT NULL, `isEdited` INTEGER NOT NULL, `state` INTEGER NOT NULL, `goodsType` INTEGER NOT NULL, `pageName` TEXT NOT NULL, `isPriceExceed` INTEGER NOT NULL, `isUnSupportAdd` INTEGER NOT NULL, PRIMARY KEY(`mediaProductId`))");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `ECPtsCacheData` (`cacheKey` TEXT NOT NULL, `pageName` TEXT NOT NULL, `data` TEXT NOT NULL, PRIMARY KEY(`cacheKey`))");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `ECAddress` (`id` INTEGER NOT NULL, `province` TEXT NOT NULL, `city` TEXT NOT NULL, `district` TEXT NOT NULL, `street` TEXT NOT NULL, `detailAddress` TEXT NOT NULL, `consignee` TEXT NOT NULL, `phoneNumber` TEXT NOT NULL, `maskedPhoneNumber` TEXT NOT NULL, `isDefaultAddress` INTEGER NOT NULL, `label` TEXT NOT NULL, PRIMARY KEY(`id`))");
            supportSQLiteDatabase.execSQL(RoomMasterTable.CREATE_QUERY);
            supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '119a6e76e1b651ce0ceb9846970bbd5b')");
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `Product`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `ECPtsCacheData`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `ECAddress`");
            if (((RoomDatabase) ECommerceDatabase_Impl.this).mCallbacks != null) {
                int size = ((RoomDatabase) ECommerceDatabase_Impl.this).mCallbacks.size();
                for (int i3 = 0; i3 < size; i3++) {
                    ((RoomDatabase.Callback) ((RoomDatabase) ECommerceDatabase_Impl.this).mCallbacks.get(i3)).onDestructiveMigration(supportSQLiteDatabase);
                }
            }
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        protected void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
            if (((RoomDatabase) ECommerceDatabase_Impl.this).mCallbacks != null) {
                int size = ((RoomDatabase) ECommerceDatabase_Impl.this).mCallbacks.size();
                for (int i3 = 0; i3 < size; i3++) {
                    ((RoomDatabase.Callback) ((RoomDatabase) ECommerceDatabase_Impl.this).mCallbacks.get(i3)).onCreate(supportSQLiteDatabase);
                }
            }
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
            ((RoomDatabase) ECommerceDatabase_Impl.this).mDatabase = supportSQLiteDatabase;
            ECommerceDatabase_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
            if (((RoomDatabase) ECommerceDatabase_Impl.this).mCallbacks != null) {
                int size = ((RoomDatabase) ECommerceDatabase_Impl.this).mCallbacks.size();
                for (int i3 = 0; i3 < size; i3++) {
                    ((RoomDatabase.Callback) ((RoomDatabase) ECommerceDatabase_Impl.this).mCallbacks.get(i3)).onOpen(supportSQLiteDatabase);
                }
            }
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void onPreMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            DBUtil.dropFtsSyncTriggers(supportSQLiteDatabase);
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase supportSQLiteDatabase) {
            HashMap hashMap = new HashMap(29);
            hashMap.put("mediaProductId", new TableInfo.Column("mediaProductId", "TEXT", true, 1, null, 1));
            hashMap.put("saasProductId", new TableInfo.Column("saasProductId", "TEXT", true, 0, null, 1));
            hashMap.put("title", new TableInfo.Column("title", "TEXT", true, 0, null, 1));
            hashMap.put("desc", new TableInfo.Column("desc", "TEXT", true, 0, null, 1));
            hashMap.put("price", new TableInfo.Column("price", "INTEGER", true, 0, null, 1));
            hashMap.put("originPrice", new TableInfo.Column("originPrice", "INTEGER", true, 0, null, 1));
            hashMap.put("couponPrice", new TableInfo.Column("couponPrice", "INTEGER", true, 0, null, 1));
            hashMap.put("commission", new TableInfo.Column("commission", "INTEGER", true, 0, null, 1));
            hashMap.put("commissionRate", new TableInfo.Column("commissionRate", "REAL", true, 0, null, 1));
            hashMap.put("priceLower", new TableInfo.Column("priceLower", "INTEGER", true, 0, null, 1));
            hashMap.put("priceUpper", new TableInfo.Column("priceUpper", "INTEGER", true, 0, null, 1));
            hashMap.put("commissionLower", new TableInfo.Column("commissionLower", "INTEGER", true, 0, null, 1));
            hashMap.put("commissonUpper", new TableInfo.Column("commissonUpper", "INTEGER", true, 0, null, 1));
            hashMap.put("inventory", new TableInfo.Column("inventory", "INTEGER", true, 0, null, 1));
            hashMap.put("sales", new TableInfo.Column("sales", "INTEGER", true, 0, null, 1));
            hashMap.put("saasTypeStr", new TableInfo.Column("saasTypeStr", "TEXT", true, 0, null, 1));
            hashMap.put("saasTypeName", new TableInfo.Column("saasTypeName", "TEXT", true, 0, null, 1));
            hashMap.put("detailUrl", new TableInfo.Column("detailUrl", "TEXT", true, 0, null, 1));
            hashMap.put("inWindow", new TableInfo.Column("inWindow", "INTEGER", true, 0, null, 1));
            hashMap.put("editable", new TableInfo.Column("editable", "INTEGER", true, 0, null, 1));
            hashMap.put("selected", new TableInfo.Column("selected", "INTEGER", true, 0, null, 1));
            hashMap.put("isMaster", new TableInfo.Column("isMaster", "INTEGER", true, 0, null, 1));
            hashMap.put("showAddBtn", new TableInfo.Column("showAddBtn", "INTEGER", true, 0, null, 1));
            hashMap.put("isEdited", new TableInfo.Column("isEdited", "INTEGER", true, 0, null, 1));
            hashMap.put("state", new TableInfo.Column("state", "INTEGER", true, 0, null, 1));
            hashMap.put("goodsType", new TableInfo.Column("goodsType", "INTEGER", true, 0, null, 1));
            hashMap.put("pageName", new TableInfo.Column("pageName", "TEXT", true, 0, null, 1));
            hashMap.put("isPriceExceed", new TableInfo.Column("isPriceExceed", "INTEGER", true, 0, null, 1));
            hashMap.put("isUnSupportAdd", new TableInfo.Column("isUnSupportAdd", "INTEGER", true, 0, null, 1));
            TableInfo tableInfo = new TableInfo("Product", hashMap, new HashSet(0), new HashSet(0));
            TableInfo read = TableInfo.read(supportSQLiteDatabase, "Product");
            if (!tableInfo.equals(read)) {
                return new RoomOpenHelper.ValidationResult(false, "Product(com.tencent.ecommerce.repo.showwindow.Product).\n Expected:\n" + tableInfo + "\n Found:\n" + read);
            }
            HashMap hashMap2 = new HashMap(3);
            hashMap2.put("cacheKey", new TableInfo.Column("cacheKey", "TEXT", true, 1, null, 1));
            hashMap2.put("pageName", new TableInfo.Column("pageName", "TEXT", true, 0, null, 1));
            hashMap2.put("data", new TableInfo.Column("data", "TEXT", true, 0, null, 1));
            TableInfo tableInfo2 = new TableInfo("ECPtsCacheData", hashMap2, new HashSet(0), new HashSet(0));
            TableInfo read2 = TableInfo.read(supportSQLiteDatabase, "ECPtsCacheData");
            if (!tableInfo2.equals(read2)) {
                return new RoomOpenHelper.ValidationResult(false, "ECPtsCacheData(com.tencent.ecommerce.repo.cache.ECPtsCacheData).\n Expected:\n" + tableInfo2 + "\n Found:\n" + read2);
            }
            HashMap hashMap3 = new HashMap(11);
            hashMap3.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
            hashMap3.put("province", new TableInfo.Column("province", "TEXT", true, 0, null, 1));
            hashMap3.put("city", new TableInfo.Column("city", "TEXT", true, 0, null, 1));
            hashMap3.put("district", new TableInfo.Column("district", "TEXT", true, 0, null, 1));
            hashMap3.put("street", new TableInfo.Column("street", "TEXT", true, 0, null, 1));
            hashMap3.put("detailAddress", new TableInfo.Column("detailAddress", "TEXT", true, 0, null, 1));
            hashMap3.put("consignee", new TableInfo.Column("consignee", "TEXT", true, 0, null, 1));
            hashMap3.put(MiniAppSendSmsCodeServlet.KEY_PHONE_NUMBER, new TableInfo.Column(MiniAppSendSmsCodeServlet.KEY_PHONE_NUMBER, "TEXT", true, 0, null, 1));
            hashMap3.put("maskedPhoneNumber", new TableInfo.Column("maskedPhoneNumber", "TEXT", true, 0, null, 1));
            hashMap3.put("isDefaultAddress", new TableInfo.Column("isDefaultAddress", "INTEGER", true, 0, null, 1));
            hashMap3.put("label", new TableInfo.Column("label", "TEXT", true, 0, null, 1));
            TableInfo tableInfo3 = new TableInfo("ECAddress", hashMap3, new HashSet(0), new HashSet(0));
            TableInfo read3 = TableInfo.read(supportSQLiteDatabase, "ECAddress");
            if (!tableInfo3.equals(read3)) {
                return new RoomOpenHelper.ValidationResult(false, "ECAddress(com.tencent.ecommerce.biz.orders.address.ECAddress).\n Expected:\n" + tableInfo3 + "\n Found:\n" + read3);
            }
            return new RoomOpenHelper.ValidationResult(true, null);
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        }
    }
}
