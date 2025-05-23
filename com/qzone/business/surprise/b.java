package com.qzone.business.surprise;

import android.text.TextUtils;
import com.qzone.common.account.LoginData;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.open.base.MD5Utils;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QzonePreDownloadManager;
import cooperation.qzone.cache.CacheManager;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes39.dex */
public class b {

    /* renamed from: d, reason: collision with root package name */
    private static volatile b f44823d;

    /* renamed from: a, reason: collision with root package name */
    private List<com.qzone.business.surprise.a> f44824a;

    /* renamed from: b, reason: collision with root package name */
    private Map<String, String> f44825b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private final long f44826c = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_SURPRISE_TIME_INTERVAL, 86400L);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a implements Comparator<com.qzone.business.surprise.a> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(com.qzone.business.surprise.a aVar, com.qzone.business.surprise.a aVar2) {
            return aVar.f44814a - aVar2.f44814a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class c implements FileFilter {
        c() {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return file.isFile();
        }
    }

    b() {
    }

    private String g() {
        return CacheManager.getSurpriseResourceDir();
    }

    public static b h() {
        if (f44823d == null) {
            synchronized ("SurpriseManager") {
                if (f44823d == null) {
                    f44823d = new b();
                }
            }
        }
        return f44823d;
    }

    private ArrayList<String> i(String str) {
        if (!TextUtils.isEmpty(str)) {
            File file = new File(j(str));
            if (file.exists() && file.isDirectory()) {
                ArrayList<String> arrayList = new ArrayList<>();
                for (File file2 : file.listFiles(new c())) {
                    arrayList.add(file2.getAbsolutePath());
                }
                Collections.sort(arrayList);
                return arrayList;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String j(String str) {
        if (!TextUtils.isEmpty(str)) {
            String str2 = g() + File.separator + MD5Utils.toMD5(str);
            File file = new File(str2);
            if (!file.exists() || !file.isDirectory()) {
                file.mkdirs();
            }
            return str2;
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String k(String str) {
        if (!TextUtils.isEmpty(str)) {
            return g() + File.separator + MD5Utils.toMD5(str) + ".zip";
        }
        return "";
    }

    private ArrayList<com.qzone.business.surprise.a> m() {
        ArrayList<com.qzone.business.surprise.a> arrayList;
        String string4Uin = LocalMultiProcConfig.getString4Uin("surprise_config", "", LoginData.getInstance().getUin());
        ArrayList<com.qzone.business.surprise.a> arrayList2 = null;
        if (TextUtils.isEmpty(string4Uin)) {
            return null;
        }
        try {
            arrayList = new ArrayList<>();
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            JSONArray jSONArray = new JSONArray(string4Uin);
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                try {
                    com.qzone.business.surprise.a aVar = new com.qzone.business.surprise.a();
                    aVar.f44814a = Integer.parseInt(jSONObject.optString("priority"));
                    aVar.f44815b = jSONObject.optString("url");
                    aVar.f44816c = jSONObject.optString(QZoneDTLoginReporter.SCHEMA);
                    aVar.f44819f = Long.parseLong(jSONObject.optString("start_time"));
                    aVar.f44820g = Long.parseLong(jSONObject.optString("end_time"));
                    aVar.f44818e = Integer.parseInt(jSONObject.optString("duration"));
                    aVar.f44822i = jSONObject.optString("url_md5");
                    aVar.f44821h = Integer.parseInt(jSONObject.optString("only_wifi", String.valueOf(1)));
                    aVar.f44817d = i(aVar.f44815b);
                    arrayList.add(aVar);
                    QZLog.d("SurpriseManager", 2, aVar.toString());
                } catch (Exception e16) {
                    QZLog.w("SurpriseManager", "parse surprise element json error:", e16);
                }
            }
            return arrayList;
        } catch (Throwable th6) {
            th = th6;
            arrayList2 = arrayList;
            QZLog.w("SurpriseManager", "parse surprise surpriseJsonStr error:", th);
            return arrayList2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(String str, boolean z16) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("url", str);
        StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(LoginData.getInstance().getUinString(), "qzoneSurpriseDownloadRes", z16, 0L, 0L, hashMap, "");
    }

    public void e() {
        List<com.qzone.business.surprise.a> f16 = f();
        if (f16 == null || f16.size() <= 0) {
            return;
        }
        Collections.sort(f16, new a());
        C0361b c0361b = new C0361b();
        for (com.qzone.business.surprise.a aVar : f16) {
            String str = aVar.f44815b;
            String k3 = k(str);
            if (!l(aVar) && !TextUtils.isEmpty(str)) {
                if (aVar.f44821h == 1 && !NetworkState.isWifiConn()) {
                    QZLog.d("SurpriseManager", 2, "download abort, wifi:" + NetworkState.isWifiConn() + " ,onlyWifi:" + aVar.f44821h);
                } else {
                    QZLog.d("SurpriseManager", 2, "try to download resource,priority:" + aVar.f44814a + ",url: " + str);
                    this.f44825b.put(str, aVar.f44822i);
                    QzonePreDownloadManager.getInstance().download(str, k3, c0361b);
                }
            }
        }
    }

    public synchronized List<com.qzone.business.surprise.a> f() {
        if (this.f44824a == null) {
            this.f44824a = m();
        }
        return this.f44824a;
    }

    private boolean l(com.qzone.business.surprise.a aVar) {
        ArrayList<String> arrayList;
        return (aVar == null || (arrayList = aVar.f44817d) == null || arrayList.size() <= 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.qzone.business.surprise.b$b, reason: collision with other inner class name */
    /* loaded from: classes39.dex */
    public class C0361b implements Downloader.DownloadListener {
        C0361b() {
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadCanceled(String str) {
            b.this.n(str, false);
            QZLog.e("SurpriseManager", "download canceled:" + str);
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadFailed(String str, DownloadResult downloadResult) {
            b.this.n(str, false);
            QZLog.e("SurpriseManager", "download failed:" + str);
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0091  */
        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onDownloadSucceed(String str, DownloadResult downloadResult) {
            StringBuilder sb5;
            String k3 = b.this.k(str);
            File file = new File(k3);
            if (file.exists()) {
                String j3 = b.this.j(str);
                File file2 = new File(j3);
                if (file2.exists()) {
                    file2.delete();
                }
                file2.mkdir();
                String str2 = (String) b.this.f44825b.get(str);
                boolean z16 = false;
                try {
                } catch (Throwable th5) {
                    try {
                        QZLog.e("SurpriseManager", "unzip resource error:", th5);
                        if (file2.exists()) {
                            file2.delete();
                        } else {
                            QZLog.i("SurpriseManager", 2, "unzip resource success:" + j3);
                        }
                        if (file.exists()) {
                            sb5 = new StringBuilder();
                        }
                    } catch (Throwable th6) {
                        if (file2.exists()) {
                            file2.delete();
                        } else {
                            QZLog.i("SurpriseManager", 2, "unzip resource success:" + j3);
                        }
                        if (file.exists()) {
                            QZLog.d("SurpriseManager", 2, "delete resource zip after unzip finished:" + k3);
                            file.delete();
                        }
                        b.this.n(str, false);
                        throw th6;
                    }
                }
                if (!TextUtils.isEmpty(str2) && !str2.equalsIgnoreCase(MD5Utils.encodeFileHexStr(k3))) {
                    QZLog.e("SurpriseManager", "md5 check failed,so delete,orgMD5:" + str2);
                    if (z16 && file2.exists()) {
                        file2.delete();
                    } else {
                        QZLog.i("SurpriseManager", 2, "unzip resource success:" + j3);
                    }
                    if (file.exists()) {
                        sb5 = new StringBuilder();
                        sb5.append("delete resource zip after unzip finished:");
                        sb5.append(k3);
                        QZLog.d("SurpriseManager", 2, sb5.toString());
                        file.delete();
                    }
                    b.this.n(str, z16);
                }
                if (ZipUtils.unZipFolder(k3, j3) == 0) {
                    z16 = true;
                }
                if (z16) {
                }
                QZLog.i("SurpriseManager", 2, "unzip resource success:" + j3);
                if (file.exists()) {
                }
                b.this.n(str, z16);
            }
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadProgress(String str, long j3, float f16) {
        }
    }
}
