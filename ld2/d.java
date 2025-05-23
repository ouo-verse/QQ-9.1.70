package ld2;

import android.content.SharedPreferences;
import android.os.Environment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.entitymanager.Interceptor;
import com.tencent.mobileqq.database.corrupt.DBFixManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.backup.impl.DBBackupServiceImpl;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.cu;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ah;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes16.dex */
public class d extends a {
    @Override // com.tencent.mobileqq.data.entitymanager.Interceptor
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Void intercept(Interceptor.Chain<Void> chain) {
        boolean z16;
        long j3;
        AppRuntime a16 = a();
        if (a16 == null) {
            return null;
        }
        SharedPreferences sharedPreferences = a16.getApplication().getSharedPreferences(DBFixManager.f203271m, 0);
        File databasePath = a16.getApplication().getDatabasePath(a16.getAccount() + DBBackupServiceImpl.DB_FILE_SUFFIX);
        if (!sharedPreferences.contains(a16.getAccount() + DBFixManager.Q)) {
            sharedPreferences.edit().putBoolean(a16.getAccount() + DBFixManager.Q, true).apply();
            EntityManagerFactory.corruptedTime = System.currentTimeMillis();
            long j16 = 0;
            if (a16 instanceof QQAppInterface) {
                long length = databasePath.length();
                if (databasePath.exists() && databasePath.length() > 0 && cu.e() && cu.b() > databasePath.length()) {
                    File file = new File(Environment.getExternalStorageDirectory().getPath() + "/tencent/msflogs/corruptInfo");
                    if (!file.exists()) {
                        z16 = FileUtils.copyFile(databasePath, file);
                        j16 = file.length();
                        j3 = j16;
                        j16 = length;
                    }
                }
                z16 = false;
                j3 = j16;
                j16 = length;
            } else {
                z16 = false;
                j3 = 0;
            }
            String sqliteLibraryVersion = EntityManagerFactory.getSqliteLibraryVersion();
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(StatisticCollector.DeviceInfo.ROM_TAG, ah.S());
            hashMap.put("isCopySucc", String.valueOf(z16));
            hashMap.put("totalLen", String.valueOf(j16));
            hashMap.put("copyLen", String.valueOf(j3));
            hashMap.put("sqliteVer", sqliteLibraryVersion);
            QLog.i("DataReportCorruptionHandler", 1, String.format(Locale.getDefault(), "db corrupt, totalLen:%d, clen:%d, sqliteVer:%s", Long.valueOf(j16), Long.valueOf(j3), sqliteLibraryVersion));
            c(hashMap);
        }
        return chain.proceed();
    }

    void c(HashMap<String, String> hashMap) {
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String) null, StatisticCollector.SQLITE_DATABASE_CORRUPT, true, -1L, 0L, hashMap, (String) null, false);
    }
}
