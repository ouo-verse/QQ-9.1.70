package com.tencent.biz.webviewplugin;

import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.OfflineWebRes;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class OfflineWebResManager {

    /* renamed from: e, reason: collision with root package name */
    public static ConcurrentLinkedQueue<String> f97368e = new ConcurrentLinkedQueue<>();

    /* renamed from: f, reason: collision with root package name */
    static boolean f97369f = false;

    /* renamed from: g, reason: collision with root package name */
    static boolean f97370g = true;

    /* renamed from: a, reason: collision with root package name */
    public AppInterface f97371a;

    /* renamed from: b, reason: collision with root package name */
    public EntityManager f97372b;

    /* renamed from: c, reason: collision with root package name */
    public String f97373c = "";

    /* renamed from: d, reason: collision with root package name */
    public AtomicBoolean f97374d = new AtomicBoolean(false);

    public OfflineWebResManager(AppInterface appInterface) {
        this.f97371a = appInterface;
        EntityManagerFactory entityManagerFactory = appInterface.getEntityManagerFactory();
        if (entityManagerFactory != null) {
            this.f97372b = entityManagerFactory.createEntityManager();
        }
    }

    public static void b(String str) {
        if (!f97368e.contains(str)) {
            f97368e.add(str);
        }
    }

    public static void d() {
        boolean r16 = ((com.tencent.mobileqq.webview.swift.injector.c) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.webview.swift.injector.c.class)).r();
        f97370g = r16;
        if (!r16) {
            QLog.w("OfflineWebResManager", 1, "can not use offline /data cache mode!");
        }
    }

    private void g(File file) {
        if (QLog.isColorLevel()) {
            QLog.i("OfflineWebResManager", 2, "cache data size exceed threshold value ");
        }
        List<Entity> rawQuery = DBMethodProxy.rawQuery(this.f97372b, OfflineWebRes.class, "select * from " + OfflineWebRes.class.getSimpleName() + " where hitcount=1 limit 100", null);
        if (rawQuery != null && rawQuery.size() > 0) {
            StringBuilder sb5 = new StringBuilder(rawQuery.size() * 64);
            Iterator<Entity> it = rawQuery.iterator();
            while (it.hasNext()) {
                OfflineWebRes offlineWebRes = (OfflineWebRes) it.next();
                File file2 = new File(file, offlineWebRes.hashName);
                if (file2.exists()) {
                    if (QLog.isColorLevel()) {
                        sb5.append("delete file: ");
                        sb5.append(file2.getPath());
                        sb5.append("\n");
                    }
                    file2.delete();
                }
                this.f97372b.remove(offlineWebRes);
            }
            if (QLog.isColorLevel() && !TextUtils.isEmpty(sb5.toString())) {
                QLog.i("OfflineWebResManager", 2, sb5.toString());
            }
        }
    }

    private boolean h(File file, long j3) {
        long j16 = (long) (j3 - 4194304.0d);
        if (QLog.isColorLevel()) {
            QLog.i("OfflineWebResManager", 2, "cache data size exceed cache max value " + j16);
        }
        List<Entity> rawQuery = DBMethodProxy.rawQuery(this.f97372b, OfflineWebRes.class, "select * from " + OfflineWebRes.class.getSimpleName() + " order by hitcount", null);
        StringBuilder sb5 = new StringBuilder("");
        if (rawQuery != null && rawQuery.size() > 0) {
            Iterator<Entity> it = rawQuery.iterator();
            while (it.hasNext()) {
                OfflineWebRes offlineWebRes = (OfflineWebRes) it.next();
                if (j16 <= 0) {
                    break;
                }
                File file2 = new File(file, offlineWebRes.hashName);
                if (file2.exists()) {
                    sb5.append("delete file: " + file2.getPath() + "\n");
                    j16 -= file2.length();
                    file2.delete();
                }
                this.f97372b.remove(offlineWebRes);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i("OfflineWebResManager", 2, sb5.toString());
        }
        if (j16 > 0) {
            QLog.w("OfflineWebResManager", 1, "cache data size still exceed cache max value " + j16 + ", now delete folder and database!");
            File[] listFiles = file.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                return true;
            }
            for (File file3 : listFiles) {
                file3.delete();
            }
            this.f97372b.drop(OfflineWebRes.class.getSimpleName());
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0091 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0083 A[Catch: all -> 0x00ae, TRY_LEAVE, TryCatch #7 {all -> 0x00ae, blocks: (B:34:0x0060, B:37:0x0064, B:39:0x0068, B:45:0x007d, B:47:0x0083), top: B:33:0x0060 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0088 A[Catch: IOException -> 0x006f, TRY_ENTER, TRY_LEAVE, TryCatch #4 {IOException -> 0x006f, blocks: (B:41:0x006b, B:50:0x0088), top: B:31:0x0044 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:62:0x0070 -> B:40:0x008b). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private JSONObject l(String str) {
        BufferedInputStream bufferedInputStream;
        String c16 = com.tencent.biz.common.offline.c.c(str);
        BufferedInputStream bufferedInputStream2 = null;
        if (TextUtils.isEmpty(c16)) {
            return null;
        }
        String str2 = c16 + str;
        if (!new File(str2).exists()) {
            f(str);
            return null;
        }
        ConcurrentHashMap<String, String> concurrentHashMap = HtmlOffline.f78404g;
        if (concurrentHashMap != null && concurrentHashMap.containsKey(str)) {
            str2 = HtmlOffline.f78404g.get(str);
        } else {
            try {
                try {
                    bufferedInputStream = new BufferedInputStream(new FileInputStream(str2 + "/verify.json"));
                } catch (Exception e16) {
                    e = e16;
                    bufferedInputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    if (bufferedInputStream2 != null) {
                    }
                    throw th;
                }
                try {
                    try {
                        str2 = com.tencent.biz.common.util.h.d(bufferedInputStream);
                        try {
                            ConcurrentHashMap<String, String> concurrentHashMap2 = HtmlOffline.f78404g;
                            if (concurrentHashMap2 != null) {
                                concurrentHashMap2.put(str, str2);
                            }
                            bufferedInputStream.close();
                        } catch (Exception e17) {
                            e = e17;
                            if (QLog.isColorLevel()) {
                            }
                            if (bufferedInputStream != null) {
                            }
                            if (!TextUtils.isEmpty(str2)) {
                            }
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        bufferedInputStream2 = bufferedInputStream;
                        if (bufferedInputStream2 != null) {
                            try {
                                bufferedInputStream2.close();
                            } catch (IOException e18) {
                                e18.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Exception e19) {
                    e = e19;
                    str2 = "";
                    if (QLog.isColorLevel()) {
                        QLog.e("OfflineWebResManager", 2, "", e);
                    }
                    if (bufferedInputStream != null) {
                        bufferedInputStream.close();
                    }
                    if (!TextUtils.isEmpty(str2)) {
                    }
                }
            } catch (IOException e26) {
                e26.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            try {
                return new JSONObject(str2);
            } catch (Exception e27) {
                if (!QLog.isColorLevel()) {
                    return null;
                }
                QLog.e("OfflineWebResManager", 2, "", e27);
                return null;
            }
        }
        f(str);
        ConcurrentHashMap<String, String> concurrentHashMap3 = HtmlOffline.f78404g;
        if (concurrentHashMap3 != null) {
            concurrentHashMap3.remove(str);
        }
        return null;
    }

    public void a(OfflineWebRes offlineWebRes) {
        if (offlineWebRes == null) {
            return;
        }
        if (offlineWebRes.getStatus() == 1000) {
            String str = com.tencent.biz.common.offline.c.c(offlineWebRes.bid) + offlineWebRes.bid + "/" + offlineWebRes.fileName;
            File file = new File(str);
            if (file.exists()) {
                File file2 = new File(BaseApplication.getContext().getFilesDir(), "WebOfflineRes");
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                FileUtils.copyFile(file, new File(file2, offlineWebRes.hashName));
                if (QLog.isDevelopLevel()) {
                    QLog.i("OfflineWebResManager", 2, "now copy " + offlineWebRes.fileName + " into /data");
                }
                this.f97372b.persistOrReplace(offlineWebRes);
                return;
            }
            QLog.e("OfflineWebResManager", 2, "bid not exit! " + str);
            return;
        }
        if (offlineWebRes.getStatus() == 1001 || offlineWebRes.getStatus() == 1002) {
            File file3 = new File(BaseApplication.getContext().getFilesDir(), "WebOfflineRes");
            if (file3.exists()) {
                if (new File(file3, offlineWebRes.hashName).exists()) {
                    offlineWebRes.hitCount++;
                    if (QLog.isColorLevel()) {
                        QLog.i("OfflineWebResManager", 2, "fileName: " + offlineWebRes.bid + "/" + offlineWebRes.fileName + ", hitcount: " + offlineWebRes.hitCount);
                    }
                    this.f97372b.update(offlineWebRes);
                    return;
                }
                this.f97372b.remove(offlineWebRes);
            }
        }
    }

    public void c() {
        boolean z16;
        final SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences("OfflineWebResManager", 4);
        if (System.currentTimeMillis() - sharedPreferences.getLong("Last_Check_Cache", 0L) < 86400000) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (((com.tencent.mobileqq.inject.b) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.inject.b.class)).isDebugVersion()) {
            if (((Boolean) com.tencent.mobileqq.webview.util.t.j().b("debug_webview_rate", Boolean.TRUE)).booleanValue() && z16) {
                return;
            }
        } else if (z16) {
            return;
        }
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.biz.webviewplugin.OfflineWebResManager.1
            @Override // java.lang.Runnable
            public void run() {
                OfflineWebResManager.this.j();
                sharedPreferences.edit().putLong("Last_Check_Cache", System.currentTimeMillis()).commit();
            }
        }, 5, null, false);
    }

    public void e(int i3) {
        if (!f97370g) {
            return;
        }
        if (i3 > 0 && this.f97374d.get()) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("OfflineWebResManager", 2, "now check update url, deley: " + i3);
        }
        this.f97374d.set(true);
        ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.biz.webviewplugin.OfflineWebResManager.2
            @Override // java.lang.Runnable
            public void run() {
                if (!OfflineWebResManager.f97369f) {
                    OfflineWebResManager.d();
                    if (!OfflineWebResManager.f97370g) {
                        OfflineWebResManager.this.f97372b.drop(OfflineWebRes.class.getSimpleName());
                        return;
                    }
                    boolean tabbleIsExist = OfflineWebResManager.this.f97372b.tabbleIsExist(OfflineWebRes.class.getSimpleName());
                    OfflineWebResManager.f97369f = tabbleIsExist;
                    if (!tabbleIsExist) {
                        OfflineWebRes offlineWebRes = new OfflineWebRes();
                        offlineWebRes.fileName = "test";
                        offlineWebRes.hashName = "test";
                        offlineWebRes.md5 = "test_md5";
                        OfflineWebResManager.this.f97372b.persist(offlineWebRes);
                    }
                }
                while (!OfflineWebResManager.f97368e.isEmpty()) {
                    OfflineWebResManager.this.m(OfflineWebResManager.f97368e.poll());
                }
                OfflineWebResManager.this.c();
                OfflineWebResManager.this.f97374d.set(false);
            }
        }, 128, null, false, i3 * 1000);
    }

    public void f(String str) {
        List<? extends Entity> query = this.f97372b.query(OfflineWebRes.class, false, "bid=?", new String[]{str}, null, null, null, null);
        if (query != null && query.size() != 0) {
            File file = new File(BaseApplication.getContext().getFilesDir(), "WebOfflineRes");
            if (file.exists()) {
                Iterator<? extends Entity> it = query.iterator();
                while (it.hasNext()) {
                    OfflineWebRes offlineWebRes = (OfflineWebRes) it.next();
                    File file2 = new File(file, offlineWebRes.hashName);
                    if (file2.exists()) {
                        file2.delete();
                    }
                    this.f97372b.remove(offlineWebRes, "bid=?", new String[]{str});
                    if (QLog.isColorLevel()) {
                        QLog.i("OfflineWebResManager", 2, "now delete all record of bid: " + str);
                    }
                }
            }
        }
    }

    public void i(String str, String str2) {
        List<? extends Entity> query = this.f97372b.query(OfflineWebRes.class, false, "bid= ? and fileName= ?", new String[]{str2, str}, null, null, null, null);
        if (query != null && query.size() != 0) {
            File file = new File(BaseApplication.getContext().getFilesDir(), "WebOfflineRes");
            if (file.exists()) {
                Iterator<? extends Entity> it = query.iterator();
                while (it.hasNext()) {
                    OfflineWebRes offlineWebRes = (OfflineWebRes) it.next();
                    File file2 = new File(file, offlineWebRes.hashName);
                    if (file2.exists()) {
                        file2.delete();
                    }
                    this.f97372b.remove(offlineWebRes, "bid= ? and fileName= ?", new String[]{str2, str});
                    if (QLog.isColorLevel()) {
                        QLog.i("OfflineWebResManager", 2, "now delete  record for bid: " + str2 + ", fileName: " + str);
                    }
                }
            }
        }
    }

    public void j() {
        if (QLog.isColorLevel()) {
            QLog.i("OfflineWebResManager", 2, "now begin check cache size!");
        }
        File file = new File(BaseApplication.getContext().getFilesDir(), "WebOfflineRes");
        if (!file.exists() || !file.isDirectory() || !this.f97372b.tabbleIsExist(OfflineWebRes.class.getSimpleName())) {
            return;
        }
        try {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length != 0) {
                long j3 = 0;
                for (File file2 : listFiles) {
                    if (!file2.isDirectory()) {
                        j3 += file2.length();
                    } else {
                        file2.delete();
                    }
                }
                double d16 = j3;
                if (d16 < 4194304.0d) {
                    if (QLog.isColorLevel()) {
                        QLog.i("OfflineWebResManager", 2, "now /data cache size :" + j3);
                        return;
                    }
                    return;
                }
                if (d16 >= 4194304.0d && j3 < 5242880) {
                    g(file);
                } else {
                    h(file, j3);
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public OfflineWebRes k(String str) {
        if (!f97370g || TextUtils.isEmpty(str)) {
            return null;
        }
        return (OfflineWebRes) DBMethodProxy.find(this.f97372b, (Class<? extends Entity>) OfflineWebRes.class, str);
    }

    public void m(String str) {
        JSONObject l3;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        String queryParameter = Uri.parse(str).getQueryParameter("_bid");
        if (TextUtils.isEmpty(queryParameter)) {
            queryParameter = this.f97373c;
        }
        if (TextUtils.isEmpty(queryParameter)) {
            return;
        }
        String v3 = HtmlOffline.v(str);
        if (TextUtils.isEmpty(v3) || (l3 = l(queryParameter)) == null) {
            return;
        }
        String optString = l3.optString(v3);
        if (!TextUtils.isEmpty(optString)) {
            OfflineWebRes k3 = k(optString);
            if (k3 == null) {
                String v16 = HtmlOffline.v(str);
                i(v16, queryParameter);
                String str2 = v16 + String.valueOf(System.currentTimeMillis()) + optString;
                String str3 = "";
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
                    messageDigest.update(str2.getBytes());
                    str3 = com.tencent.biz.common.util.h.j(messageDigest.digest());
                    if (QLog.isDevelopLevel()) {
                        QLog.i("OfflineWebResManager", 2, "now filePath " + v16 + ", hashName: " + str3);
                    }
                } catch (Exception e16) {
                    QLog.e("OfflineWebResManager", 1, "add offline res error! " + str);
                    if (!TextUtils.isEmpty(queryParameter)) {
                        f(queryParameter);
                    }
                    e16.printStackTrace();
                }
                if (!TextUtils.isEmpty(str3)) {
                    k3 = new OfflineWebRes();
                    k3.fileName = v16;
                    k3.hashName = str3;
                    k3.md5 = optString;
                    k3.bid = queryParameter;
                }
            }
            a(k3);
            if (QLog.isDevelopLevel()) {
                QLog.i("OfflineWebResManager", 2, "add or update url " + HtmlOffline.v(str) + ", cost: " + (System.currentTimeMillis() - currentTimeMillis));
                return;
            }
            return;
        }
        String v17 = HtmlOffline.v(str);
        if (QLog.isColorLevel()) {
            QLog.i("OfflineWebResManager", 2, "now md5 not exits, fileName:" + v17);
        }
        i(v17, queryParameter);
    }
}
