package ld2;

import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.entitymanager.CorruptionInterceptorChain;
import com.tencent.mobileqq.data.entitymanager.Interceptor;
import com.tencent.mobileqq.database.corrupt.DBFixManager;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.persistence.backup.impl.DBBackupServiceImpl;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes16.dex */
public class c extends a {
    private void d(int i3, boolean z16, String str, String str2) {
        if (i3 == 0) {
            if (z16) {
                i3 = DBFixManager.X;
            } else {
                i3 = DBFixManager.W;
            }
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("reasonCode", String.valueOf(i3));
        hashMap.put("dDName", str);
        if (str2 != null) {
            hashMap.put("errorStack", str2);
        }
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String) null, DBFixManager.U, true, -1L, 0L, hashMap, (String) null, false);
    }

    @Override // com.tencent.mobileqq.data.entitymanager.Interceptor
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Void intercept(Interceptor.Chain<Void> chain) {
        DBFixManager dBFixManager;
        int i3;
        String stackTraceString;
        boolean z16;
        int i16;
        AppRuntime a16 = a();
        if (a16 == null) {
            return null;
        }
        CorruptionInterceptorChain corruptionInterceptorChain = (CorruptionInterceptorChain) chain;
        SQLiteDatabase sQLiteDatabase = corruptionInterceptorChain.database;
        SharedPreferences sharedPreferences = a16.getApplication().getSharedPreferences(DBFixManager.f203271m, 0);
        String name = new File(sQLiteDatabase.getPath()).getName();
        boolean equals = name.equals(a16.getAccount() + DBBackupServiceImpl.DB_FILE_SUFFIX);
        try {
            dBFixManager = (DBFixManager) a16.getManager(QQManagerFactory.DB_FIX_MANAGER);
        } catch (Throwable th5) {
            th = th5;
            dBFixManager = null;
        }
        try {
            z16 = dBFixManager.k();
            stackTraceString = null;
            i3 = 0;
        } catch (Throwable th6) {
            th = th6;
            QLog.e("DBFixCorruptionHandler", 1, "on corrupt", th);
            i3 = DBFixManager.Y;
            stackTraceString = MsfSdkUtils.getStackTraceString(th);
            z16 = false;
            if (!z16) {
            }
            i16 = sharedPreferences.getInt(a16.getAccount() + DBFixManager.P, 0);
            QLog.d("DBFixCorruptionHandler", 1, "db oncorrup, dbobj fileName: ", name, ", isUinDb: ", Boolean.valueOf(equals), ", soFailCount", Integer.valueOf(i16));
            if (i16 >= DBFixManager.N) {
            }
            c(corruptionInterceptorChain, sQLiteDatabase, sharedPreferences);
            d(i3, equals, name, stackTraceString);
            return null;
        }
        if (!z16 && equals) {
            try {
                sQLiteDatabase.close();
            } catch (SQLiteException e16) {
                QLog.e("DBFixCorruptionHandler", 1, "db oncorrupt and close fail ", e16);
            }
            dBFixManager.l(null, true);
        } else {
            i16 = sharedPreferences.getInt(a16.getAccount() + DBFixManager.P, 0);
            QLog.d("DBFixCorruptionHandler", 1, "db oncorrup, dbobj fileName: ", name, ", isUinDb: ", Boolean.valueOf(equals), ", soFailCount", Integer.valueOf(i16));
            if (i16 >= DBFixManager.N && equals) {
                return null;
            }
            c(corruptionInterceptorChain, sQLiteDatabase, sharedPreferences);
            d(i3, equals, name, stackTraceString);
        }
        return null;
    }

    void c(CorruptionInterceptorChain corruptionInterceptorChain, SQLiteDatabase sQLiteDatabase, SharedPreferences sharedPreferences) {
        corruptionInterceptorChain.defaultErrorHandler.onCorruption(sQLiteDatabase);
        sharedPreferences.edit().remove(DBFixManager.Q).apply();
        DBFixManager.f();
        com.tencent.mobileqq.friend.utils.b.d().i(false);
        QLog.d("DBFixCorruptionHandler", 1, "cleared friendlist flag");
    }
}
