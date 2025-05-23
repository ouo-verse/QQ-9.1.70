package com.tencent.mobileqq.wink.storage.album;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenHelper;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import da3.b;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class WinkAlbumRoomDatabase_Impl extends WinkAlbumRoomDatabase {

    /* renamed from: c, reason: collision with root package name */
    private volatile da3.a f326401c;

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `photo_face`");
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
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "photo_face");
    }

    @Override // androidx.room.RoomDatabase
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(databaseConfiguration.context).name(databaseConfiguration.name).callback(new RoomOpenHelper(databaseConfiguration, new a(1), "9cc5a8f467e4ac21f1136b9e20ccc4aa", "dc7cae602d9e9549c506bf6a60b21038")).build());
    }

    @Override // com.tencent.mobileqq.wink.storage.album.WinkAlbumRoomDatabase
    public da3.a e() {
        da3.a aVar;
        if (this.f326401c != null) {
            return this.f326401c;
        }
        synchronized (this) {
            if (this.f326401c == null) {
                this.f326401c = new b(this);
            }
            aVar = this.f326401c;
        }
        return aVar;
    }

    @Override // androidx.room.RoomDatabase
    protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap hashMap = new HashMap();
        hashMap.put(da3.a.class, b.c());
        return hashMap;
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    class a extends RoomOpenHelper.Delegate {
        a(int i3) {
            super(i3);
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `photo_face` (`id` INTEGER NOT NULL, `faceCount` INTEGER NOT NULL, PRIMARY KEY(`id`))");
            supportSQLiteDatabase.execSQL(RoomMasterTable.CREATE_QUERY);
            supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '9cc5a8f467e4ac21f1136b9e20ccc4aa')");
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `photo_face`");
            if (((RoomDatabase) WinkAlbumRoomDatabase_Impl.this).mCallbacks != null) {
                int size = ((RoomDatabase) WinkAlbumRoomDatabase_Impl.this).mCallbacks.size();
                for (int i3 = 0; i3 < size; i3++) {
                    ((RoomDatabase.Callback) ((RoomDatabase) WinkAlbumRoomDatabase_Impl.this).mCallbacks.get(i3)).onDestructiveMigration(supportSQLiteDatabase);
                }
            }
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        protected void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
            if (((RoomDatabase) WinkAlbumRoomDatabase_Impl.this).mCallbacks != null) {
                int size = ((RoomDatabase) WinkAlbumRoomDatabase_Impl.this).mCallbacks.size();
                for (int i3 = 0; i3 < size; i3++) {
                    ((RoomDatabase.Callback) ((RoomDatabase) WinkAlbumRoomDatabase_Impl.this).mCallbacks.get(i3)).onCreate(supportSQLiteDatabase);
                }
            }
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
            ((RoomDatabase) WinkAlbumRoomDatabase_Impl.this).mDatabase = supportSQLiteDatabase;
            WinkAlbumRoomDatabase_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
            if (((RoomDatabase) WinkAlbumRoomDatabase_Impl.this).mCallbacks != null) {
                int size = ((RoomDatabase) WinkAlbumRoomDatabase_Impl.this).mCallbacks.size();
                for (int i3 = 0; i3 < size; i3++) {
                    ((RoomDatabase.Callback) ((RoomDatabase) WinkAlbumRoomDatabase_Impl.this).mCallbacks.get(i3)).onOpen(supportSQLiteDatabase);
                }
            }
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void onPreMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            DBUtil.dropFtsSyncTriggers(supportSQLiteDatabase);
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase supportSQLiteDatabase) {
            HashMap hashMap = new HashMap(2);
            hashMap.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
            hashMap.put("faceCount", new TableInfo.Column("faceCount", "INTEGER", true, 0, null, 1));
            TableInfo tableInfo = new TableInfo("photo_face", hashMap, new HashSet(0), new HashSet(0));
            TableInfo read = TableInfo.read(supportSQLiteDatabase, "photo_face");
            if (!tableInfo.equals(read)) {
                return new RoomOpenHelper.ValidationResult(false, "photo_face(com.tencent.mobileqq.wink.storage.model.PhotoFace).\n Expected:\n" + tableInfo + "\n Found:\n" + read);
            }
            return new RoomOpenHelper.ValidationResult(true, null);
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        }
    }
}
