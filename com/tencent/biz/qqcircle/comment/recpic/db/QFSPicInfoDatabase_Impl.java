package com.tencent.biz.qqcircle.comment.recpic.db;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenHelper;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.tencent.ad.tangram.analysis.sqlite.AdAnalysisSQLiteColumns;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import v20.b;
import v20.c;

/* loaded from: classes4.dex */
public final class QFSPicInfoDatabase_Impl extends QFSPicInfoDatabase {

    /* renamed from: c, reason: collision with root package name */
    private volatile b f83821c;

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `rec_pic_info_table`");
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
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "rec_pic_info_table");
    }

    @Override // androidx.room.RoomDatabase
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(databaseConfiguration.context).name(databaseConfiguration.name).callback(new RoomOpenHelper(databaseConfiguration, new a(1), "979739c4c5ae21686dc66e05906a6745", "de44c940396474b73ee1f846fa6a0bce")).build());
    }

    @Override // com.tencent.biz.qqcircle.comment.recpic.db.QFSPicInfoDatabase
    public b e() {
        b bVar;
        if (this.f83821c != null) {
            return this.f83821c;
        }
        synchronized (this) {
            if (this.f83821c == null) {
                this.f83821c = new c(this);
            }
            bVar = this.f83821c;
        }
        return bVar;
    }

    @Override // androidx.room.RoomDatabase
    protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap hashMap = new HashMap();
        hashMap.put(b.class, c.e());
        return hashMap;
    }

    /* loaded from: classes4.dex */
    class a extends RoomOpenHelper.Delegate {
        a(int i3) {
            super(i3);
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `rec_pic_info_table` (`path` TEXT NOT NULL, `photoId` TEXT NOT NULL, `strategy` INTEGER NOT NULL, `mediaWidth` INTEGER NOT NULL, `mediaHeight` INTEGER NOT NULL, `similarityList` TEXT NOT NULL, `typeList` TEXT NOT NULL, PRIMARY KEY(`photoId`))");
            supportSQLiteDatabase.execSQL(RoomMasterTable.CREATE_QUERY);
            supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '979739c4c5ae21686dc66e05906a6745')");
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `rec_pic_info_table`");
            if (((RoomDatabase) QFSPicInfoDatabase_Impl.this).mCallbacks != null) {
                int size = ((RoomDatabase) QFSPicInfoDatabase_Impl.this).mCallbacks.size();
                for (int i3 = 0; i3 < size; i3++) {
                    ((RoomDatabase.Callback) ((RoomDatabase) QFSPicInfoDatabase_Impl.this).mCallbacks.get(i3)).onDestructiveMigration(supportSQLiteDatabase);
                }
            }
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        protected void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
            if (((RoomDatabase) QFSPicInfoDatabase_Impl.this).mCallbacks != null) {
                int size = ((RoomDatabase) QFSPicInfoDatabase_Impl.this).mCallbacks.size();
                for (int i3 = 0; i3 < size; i3++) {
                    ((RoomDatabase.Callback) ((RoomDatabase) QFSPicInfoDatabase_Impl.this).mCallbacks.get(i3)).onCreate(supportSQLiteDatabase);
                }
            }
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
            ((RoomDatabase) QFSPicInfoDatabase_Impl.this).mDatabase = supportSQLiteDatabase;
            QFSPicInfoDatabase_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
            if (((RoomDatabase) QFSPicInfoDatabase_Impl.this).mCallbacks != null) {
                int size = ((RoomDatabase) QFSPicInfoDatabase_Impl.this).mCallbacks.size();
                for (int i3 = 0; i3 < size; i3++) {
                    ((RoomDatabase.Callback) ((RoomDatabase) QFSPicInfoDatabase_Impl.this).mCallbacks.get(i3)).onOpen(supportSQLiteDatabase);
                }
            }
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void onPreMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            DBUtil.dropFtsSyncTriggers(supportSQLiteDatabase);
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase supportSQLiteDatabase) {
            HashMap hashMap = new HashMap(7);
            hashMap.put("path", new TableInfo.Column("path", "TEXT", true, 0, null, 1));
            hashMap.put("photoId", new TableInfo.Column("photoId", "TEXT", true, 1, null, 1));
            hashMap.put(AdAnalysisSQLiteColumns.COLUMN_NAME_STRATEGY, new TableInfo.Column(AdAnalysisSQLiteColumns.COLUMN_NAME_STRATEGY, "INTEGER", true, 0, null, 1));
            hashMap.put("mediaWidth", new TableInfo.Column("mediaWidth", "INTEGER", true, 0, null, 1));
            hashMap.put("mediaHeight", new TableInfo.Column("mediaHeight", "INTEGER", true, 0, null, 1));
            hashMap.put("similarityList", new TableInfo.Column("similarityList", "TEXT", true, 0, null, 1));
            hashMap.put("typeList", new TableInfo.Column("typeList", "TEXT", true, 0, null, 1));
            TableInfo tableInfo = new TableInfo("rec_pic_info_table", hashMap, new HashSet(0), new HashSet(0));
            TableInfo read = TableInfo.read(supportSQLiteDatabase, "rec_pic_info_table");
            if (!tableInfo.equals(read)) {
                return new RoomOpenHelper.ValidationResult(false, "rec_pic_info_table(com.tencent.biz.qqcircle.comment.recpic.QFSRecPicInfo).\n Expected:\n" + tableInfo + "\n Found:\n" + read);
            }
            return new RoomOpenHelper.ValidationResult(true, null);
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        }
    }
}
