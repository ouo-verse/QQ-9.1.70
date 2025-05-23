package ld2;

import com.tencent.mobileqq.data.entitymanager.Interceptor;
import com.tencent.mobileqq.database.corrupt.DBFixManager;
import com.tencent.mobileqq.persistence.backup.impl.DBBackupServiceImpl;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b extends a {
    public void b(AppRuntime appRuntime, File file) {
        File databasePath = appRuntime.getApplication().getDatabasePath("chat.trace");
        if (file.exists() && (!databasePath.exists() || databasePath.length() == 0)) {
            QLog.d("DBExistCheckCorruptionInterceptor", 1, "copy temp db");
            FileUtils.copyFile(file, databasePath);
        }
        File databasePath2 = appRuntime.getApplication().getDatabasePath(appRuntime.getAccount() + ".db-wal");
        File databasePath3 = appRuntime.getApplication().getDatabasePath("chat.trace-wal");
        if (!databasePath3.exists() && databasePath2.exists() && databasePath2.length() > 0) {
            QLog.d("DBExistCheckCorruptionInterceptor", 1, "copy temp db-wal");
            FileUtils.copyFile(databasePath2, databasePath3);
        }
        File databasePath4 = appRuntime.getApplication().getDatabasePath(appRuntime.getAccount() + ".db-shm");
        File databasePath5 = appRuntime.getApplication().getDatabasePath("chat.trace-shm");
        if (!databasePath5.exists() && databasePath4.exists() && databasePath4.length() > 0) {
            QLog.d("DBExistCheckCorruptionInterceptor", 1, "copy temp db-shm");
            FileUtils.copyFile(databasePath4, databasePath5);
        }
    }

    @Override // com.tencent.mobileqq.data.entitymanager.Interceptor
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Void intercept(Interceptor.Chain<Void> chain) {
        String str;
        AppRuntime a16 = a();
        if (a16 == null) {
            return null;
        }
        File databasePath = a16.getApplication().getDatabasePath(a16.getAccount() + DBBackupServiceImpl.DB_FILE_SUFFIX);
        if (databasePath.exists() && databasePath.length() != 0) {
            b(a16, databasePath);
            return chain.proceed();
        }
        HashMap<String, String> hashMap = new HashMap<>();
        if (databasePath.exists()) {
            str = "existFalse";
        } else {
            str = "lenZero";
        }
        hashMap.put("reason", str);
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String) null, DBFixManager.Z, true, -1L, 0L, hashMap, (String) null, false);
        FileUtils.deleteFile(databasePath.getPath());
        return null;
    }
}
