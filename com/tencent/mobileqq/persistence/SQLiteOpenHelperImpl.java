package com.tencent.mobileqq.persistence;

import android.annotation.TargetApi;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes16.dex */
public class SQLiteOpenHelperImpl extends SQLiteOpenHelper implements ISQLiteOpenHelper {
    private final SQLiteOpenHelperFacade mFacade;

    public SQLiteOpenHelperImpl(EntityManagerFactory entityManagerFactory, String str, String str2, int i3) {
        this(entityManagerFactory, str, str2, i3, null);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable, com.tencent.mobileqq.persistence.ISQLiteOpenHelper
    public void close() {
        this.mFacade.close();
    }

    @Override // com.tencent.mobileqq.persistence.ISQLiteOpenHelper
    public void dropAllTable() {
        this.mFacade.dropAllTable();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper, com.tencent.mobileqq.persistence.ISQLiteOpenHelper
    public synchronized SQLiteDatabase getReadableDatabase() {
        return this.mFacade.getReadableDatabase();
    }

    @Override // com.tencent.mobileqq.persistence.ISQLiteOpenHelper
    public synchronized SQLiteDatabase getReadableDatabaseInner() {
        return super.getReadableDatabase();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper, com.tencent.mobileqq.persistence.ISQLiteOpenHelper
    public synchronized SQLiteDatabase getWritableDatabase() {
        return this.mFacade.getWritableDatabase();
    }

    @Override // com.tencent.mobileqq.persistence.ISQLiteOpenHelper
    public synchronized SQLiteDatabase getWritableDatabaseInner() {
        return super.getWritableDatabase();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper, com.tencent.mobileqq.persistence.ISQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        this.mFacade.onCreate(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper, com.tencent.mobileqq.persistence.ISQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
        this.mFacade.onDowngrade(sQLiteDatabase, i3, i16);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper, com.tencent.mobileqq.persistence.ISQLiteOpenHelper
    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        super.onOpen(sQLiteDatabase);
        this.mFacade.onOpen(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper, com.tencent.mobileqq.persistence.ISQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
        this.mFacade.onUpgrade(sQLiteDatabase, i3, i16);
    }

    @TargetApi(11)
    public SQLiteOpenHelperImpl(EntityManagerFactory entityManagerFactory, String str, String str2, int i3, DatabaseErrorHandler databaseErrorHandler) {
        super(BaseApplication.getContext(), str, new Factory(entityManagerFactory), i3, databaseErrorHandler);
        this.mFacade = new SQLiteOpenHelperFacade(this, str, entityManagerFactory, str2);
    }
}
