package com.tencent.mobileqq.mini.apkgEntity;

import android.database.sqlite.SQLiteDatabase;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.mini.entity.AppDetainRecordEntity;
import com.tencent.mobileqq.mini.entity.MiniGameStartupReportEntity;
import com.tencent.mobileqq.mini.entity.RecentAppBubbleRecordEntity;
import com.tencent.mobileqq.mini.entity.RecommendAppBubbleRecordEntity;
import com.tencent.mobileqq.mini.entry.MiniAppLocalSearchEntity;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.SQLiteOpenHelperFacade;
import com.tencent.mobileqq.persistence.TableBuilder;
import com.tencent.mobileqq.persistence.backup.impl.DBBackupServiceImpl;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAppEntityManagerFactory extends EntityManagerFactory {
    private static final int DB_VERSION = 21;

    public MiniAppEntityManagerFactory(String str) {
        super(str);
    }

    @Override // com.tencent.mobileqq.persistence.EntityManagerFactory
    public SQLiteOpenHelper build(String str) {
        if (this.dbHelper == null) {
            this.mInnerDbHelper = SQLiteOpenHelperFacade.getHelper(this, "miniapp_" + str + DBBackupServiceImpl.DB_FILE_SUFFIX, 21);
            this.dbHelper = new SQLiteOpenHelper(this.mInnerDbHelper);
        }
        return this.dbHelper;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.EntityManagerFactory
    public String getPackageName() {
        return getClass().getPackage().getName();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.EntityManagerFactory
    public void upgradeDatabase(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
        QLog.d("miniapp-db", 1, "upgradeDatabase --  oldVersion: " + i3 + "; newVersion : " + i16);
        if (i3 < 8) {
            sQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(MiniAppByLinkEntity.class.getSimpleName()));
            sQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(MiniAppByIdEntity.class.getSimpleName()));
            sQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(MiniAppShowInfoEntity.class.getSimpleName()));
        }
        if (i3 < 11) {
            sQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(MiniAppShowInfoEntity.class.getSimpleName()));
        }
        if (i3 < 14) {
            sQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(MiniAppLocalSearchEntity.class.getSimpleName()));
        }
        if (i3 < 16) {
            sQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(MiniAppInfoEntity.class.getSimpleName()));
        }
        if (i3 <= 18 && i16 >= 19) {
            sQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(MiniGameStartupReportEntity.class.getSimpleName()));
            sQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new MiniGameStartupReportEntity()));
        }
        if (i3 <= 19 && i16 >= 20) {
            sQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(MiniAppShowInfoEntity.class.getSimpleName()));
            sQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new MiniAppShowInfoEntity()));
        }
        if (i3 > 20 || i16 < 21) {
            return;
        }
        sQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(MiniGameStartupReportEntity.class.getSimpleName()));
        sQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new MiniGameStartupReportEntity()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.EntityManagerFactory
    public void createDatabase(SQLiteDatabase sQLiteDatabase) {
        QLog.d("miniapp-db", 1, "createDatabase");
        sQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new MiniAppInfoEntity()));
        sQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new MiniAppByLinkEntity()));
        sQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new MiniAppByIdEntity()));
        sQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new MiniAppShowInfoEntity()));
        sQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new MiniAppInfoByIdEntity()));
        sQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new MiniAppInfoByLinkEntity()));
        sQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new AppDetainRecordEntity()));
        sQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new RecentAppBubbleRecordEntity()));
        sQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new RecommendAppBubbleRecordEntity()));
        sQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new MiniGameStartupReportEntity()));
    }
}
