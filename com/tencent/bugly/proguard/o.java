package com.tencent.bugly.proguard;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class o {

    /* renamed from: id, reason: collision with root package name */
    public int f98526id;
    public String moduleName;
    public String version;
    public String versionKey;

    public abstract String[] getTables();

    public abstract void init(Context context, boolean z16, BuglyStrategy buglyStrategy);

    public void onDbDowngrade(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
        try {
            if (getTables() == null) {
                return;
            }
            for (String str : getTables()) {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS ".concat(String.valueOf(str)));
            }
            onDbCreate(sQLiteDatabase);
        } catch (Throwable th5) {
            if (!av.b(th5)) {
                th5.printStackTrace();
            }
        }
    }

    public void onDbUpgrade(SQLiteDatabase sQLiteDatabase, int i3, int i16) {
        try {
            if (getTables() == null) {
                return;
            }
            for (String str : getTables()) {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS ".concat(String.valueOf(str)));
            }
            onDbCreate(sQLiteDatabase);
        } catch (Throwable th5) {
            if (!av.b(th5)) {
                th5.printStackTrace();
            }
        }
    }

    public void onDbCreate(SQLiteDatabase sQLiteDatabase) {
    }

    public void onServerStrategyChanged(StrategyBean strategyBean) {
    }
}
