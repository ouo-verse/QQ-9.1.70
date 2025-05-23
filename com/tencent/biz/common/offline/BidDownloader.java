package com.tencent.biz.common.offline;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.biz.webviewplugin.OfflinePlugin;
import com.tencent.commonsdk.soload.MyZipConstants;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ds;
import com.tencent.mobileqq.webview.swift.injector.aa;
import com.tencent.mobileqq.webview.swift.injector.m;
import com.tencent.mobileqq.webview.util.n;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import px.e;

/* compiled from: P */
/* loaded from: classes2.dex */
public class BidDownloader implements Handler.Callback {
    public static String M;
    public static HashMap<String, Integer> N;
    public static ArrayList<BidDownloader> P;
    public static Context Q;
    public static WifiListener R;
    public static boolean S;

    @QAutoInject(configPath = "AutoInjectYml/Business/Webview/Inject_OfflineDownloader.yml", version = 1)
    public static px.c T;
    private static ArrayList U;
    public boolean C;
    public boolean D;
    public String G;
    public a H;
    public String I;
    public Handler K;
    public int L;

    /* renamed from: d, reason: collision with root package name */
    public WeakReference<a> f78388d;

    /* renamed from: e, reason: collision with root package name */
    public String f78389e;

    /* renamed from: f, reason: collision with root package name */
    public int f78390f;

    /* renamed from: h, reason: collision with root package name */
    public boolean f78391h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f78392i;

    /* renamed from: m, reason: collision with root package name */
    public boolean f78393m;
    public boolean E = false;
    public int F = 0;
    public int J = 0;

    /* compiled from: P */
    /* renamed from: com.tencent.biz.common.offline.BidDownloader$3, reason: invalid class name */
    /* loaded from: classes2.dex */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ BidDownloader this$0;

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.e();
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class WifiListener extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (NetworkUtil.getNetWorkType() == 1) {
                BidDownloader.n();
            }
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        U = arrayList;
        arrayList.add(e.class);
        M = "BidDownloader";
        S = false;
    }

    public BidDownloader(String str, AppRuntime appRuntime, a aVar, boolean z16, int i3) {
        this.f78390f = 0;
        this.f78391h = true;
        this.f78392i = false;
        this.f78393m = false;
        this.C = false;
        this.D = false;
        this.G = null;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (P == null) {
            P = new ArrayList<>();
            N = new HashMap<>();
            R = new WifiListener();
        }
        this.f78388d = new WeakReference<>(aVar);
        Q = appRuntime.getApplication().getApplicationContext();
        this.f78389e = str;
        this.f78391h = z16;
        if (i3 == 1) {
            this.f78392i = true;
        } else if (i3 == 3) {
            this.C = true;
        } else if (i3 == 4) {
            this.D = true;
        } else if (i3 == 2) {
            this.f78393m = true;
        }
        String d16 = c.d(str);
        if (!TextUtils.isEmpty(d16)) {
            if (this.D) {
                this.G = d16 + this.f78389e + ".7z";
            } else if (!this.C && !this.f78393m) {
                QLog.e(M, 1, "do not know what format, use default zip name!");
                this.G = d16 + this.f78389e + ".zip";
            } else {
                this.G = d16 + this.f78389e + ".zip";
            }
        }
        this.K = new Handler(Looper.getMainLooper(), this);
        this.f78390f = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void b(String str) {
        if (N == null) {
            N = new HashMap<>();
        }
        if (N.get(str) == null) {
            N.put(str, 1);
            if (QLog.isDevelopLevel()) {
                QLog.i(M, 2, "addDownloadingState:" + str);
            }
        }
    }

    public static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        File file = new File(str);
        if (!file.exists()) {
            if (QLog.isColorLevel()) {
                QLog.i(M, 2, "doUnzipZip: no zip ! " + str);
            }
            return "";
        }
        RandomAccessFile randomAccessFile = null;
        try {
            try {
                try {
                    RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "r");
                    try {
                        randomAccessFile2.seek(0L);
                        long reverseBytes = Integer.reverseBytes(randomAccessFile2.readInt());
                        if (reverseBytes != MyZipConstants.LOCSIG && reverseBytes == 930790575) {
                        }
                        randomAccessFile2.close();
                    } catch (Exception e16) {
                        e = e16;
                        randomAccessFile = randomAccessFile2;
                        if (QLog.isColorLevel()) {
                            QLog.e(M, 2, "open compress file error! path: " + str, e);
                        }
                        if (randomAccessFile != null) {
                            randomAccessFile.close();
                        }
                        return "";
                    } catch (Throwable th5) {
                        th = th5;
                        randomAccessFile = randomAccessFile2;
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (Exception unused) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
            } catch (Exception e17) {
                e = e17;
            }
        } catch (Exception unused2) {
            return "";
        }
    }

    private void d(int i3, int i16) {
        if (this.f78388d.get() != null) {
            this.f78388d.get().loaded(null, i3);
        }
    }

    private void h() {
        if (j(this.f78389e)) {
            if (QLog.isColorLevel()) {
                QLog.i(M, 2, this.f78389e + " is downloading");
                return;
            }
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.i(M, 2, this.f78389e + " download");
        }
        if (N.size() >= 1) {
            a(this);
            if (QLog.isDevelopLevel()) {
                QLog.i(M, 2, N + "," + this.f78389e + "add to queue");
                return;
            }
            return;
        }
        HtmlOffline.Q(Q.getApplicationContext(), this.f78389e);
        g();
        if (QLog.isDevelopLevel()) {
            QLog.i(M, 2, this.f78389e + this.I + this.H);
        }
        b(this.f78389e);
    }

    @QAutoInitMethod
    static void i() {
        T = (px.c) com.tencent.mobileqq.qroute.utils.b.a(U);
        if (QLog.isColorLevel()) {
            n.a(M, T);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean j(String str) {
        HashMap<String, Integer> hashMap = N;
        if (hashMap == null || hashMap.get(str) == null) {
            return false;
        }
        return true;
    }

    public static boolean k(int i3) {
        if (i3 != 0 && i3 != -1) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void l(String str) {
        HashMap<String, Integer> hashMap = N;
        if (hashMap == null) {
            return;
        }
        if (hashMap.get(str) != null) {
            N.remove(str);
            if (QLog.isColorLevel()) {
                QLog.d(M, 2, "removeDownloadingState:" + str);
            }
        }
        ArrayList<BidDownloader> arrayList = P;
        if (arrayList != null && !arrayList.isEmpty()) {
            BidDownloader bidDownloader = P.get(0);
            if (Q != null) {
                if (bidDownloader.E && NetworkUtil.getNetWorkType() != 1 && !S) {
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                    Q.registerReceiver(R, intentFilter);
                    S = true;
                    return;
                }
                if (QLog.isDevelopLevel()) {
                    QLog.i(M, 2, "start download from queue:" + bidDownloader.f78389e);
                }
                bidDownloader.f();
                P.remove(0);
                if (S && P.size() == 0) {
                    Q.unregisterReceiver(R);
                    S = false;
                }
            }
        }
    }

    public static void m(int i3, String str, int i16, int i17, String str2, int i18) {
        String str3;
        HashMap<String, String> hashMap = new HashMap<>(10);
        hashMap.put("download_cost_time", String.valueOf(i3));
        hashMap.put("business_id", String.valueOf(str));
        hashMap.put("download_code", String.valueOf(i16));
        hashMap.put("download_network", String.valueOf(NetworkUtil.getNetWorkType()));
        hashMap.put("download_version", String.valueOf(i17));
        hashMap.put("download_main_action", str2);
        hashMap.put("download_sub_action", String.valueOf(i18));
        try {
            str3 = MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
        } catch (Throwable unused) {
            QLog.e(M, 1, "getAccount faild \uff01\uff01\uff01");
            str3 = "";
        }
        String str4 = str3;
        hashMap.put("qq_num", str4);
        if (((com.tencent.mobileqq.inject.b) aa.k(com.tencent.mobileqq.inject.b.class)).isPublicVersion() && ds.d(0, 1000) > 0) {
            if (QLog.isColorLevel()) {
                QLog.d(M, 2, "reportOfflineDownloadStatus not in sample. extraInfo:" + hashMap.toString());
                return;
            }
            return;
        }
        ((m) aa.k(m.class)).collectPerformance(str4, "offline_report", true, 0L, 0L, hashMap, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void n() {
        ArrayList<BidDownloader> arrayList;
        if (N.size() == 0 && (arrayList = P) != null && !arrayList.isEmpty()) {
            BidDownloader remove = P.remove(0);
            if (Q != null) {
                remove.f();
            }
        }
    }

    protected void a(BidDownloader bidDownloader) {
        int size = P.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (bidDownloader.f78389e.equals(P.get(i3).f78389e)) {
                return;
            }
        }
        P.add(bidDownloader);
    }

    @TargetApi(11)
    public boolean e() {
        final long currentTimeMillis = System.currentTimeMillis();
        if (TextUtils.isEmpty(this.G)) {
            return false;
        }
        this.H = new a() { // from class: com.tencent.biz.common.offline.BidDownloader.1
            @Override // com.tencent.biz.common.offline.a
            public void loaded(String str, int i3) {
                int i16;
                int currentTimeMillis2 = (int) (System.currentTimeMillis() - currentTimeMillis);
                ConcurrentHashMap<String, String> concurrentHashMap = HtmlOffline.f78404g;
                if (concurrentHashMap != null && concurrentHashMap.containsKey(BidDownloader.this.f78389e)) {
                    HtmlOffline.f78404g.remove(BidDownloader.this.f78389e);
                }
                int i17 = 0;
                BidDownloader.this.K.sendEmptyMessage(0);
                boolean z16 = true;
                if (i3 == 0) {
                    OfflinePlugin.Q(BidDownloader.this.f78389e);
                    BidDownloader bidDownloader = BidDownloader.this;
                    if (bidDownloader.f78392i) {
                        if (!HtmlOffline.m(bidDownloader.f78389e)) {
                            com.tencent.mobileqq.webview.util.d.b(BidDownloader.this.G);
                            com.tencent.mobileqq.webview.util.d.a(c.c(BidDownloader.this.f78389e) + BidDownloader.this.f78389e);
                            BidDownloader.this.K.sendMessage(BidDownloader.this.K.obtainMessage(2, 10, currentTimeMillis2));
                            HtmlOffline.J(BidDownloader.this.f78389e, 14, 0L, NetworkUtil.getNetWorkType(), "lixian_update", "0");
                            OfflinePlugin.P(BidDownloader.this.f78389e, "Offline_Update_BSDiff", currentTimeMillis2, 14, "", "", "");
                            BidDownloader.m(0, BidDownloader.this.f78389e, 14, 0, "lixian_update", 0);
                            return;
                        }
                    } else if ((bidDownloader.C || bidDownloader.D) && !bidDownloader.o()) {
                        QLog.e(BidDownloader.M, 1, "businessId " + BidDownloader.this.f78389e + " now un compress file error! " + BidDownloader.this.G);
                        return;
                    }
                    BidDownloader bidDownloader2 = BidDownloader.this;
                    if (2 == bidDownloader2.f78390f) {
                        z16 = HtmlOffline.q(bidDownloader2.f78389e);
                        BidDownloader.this.K.sendMessage(BidDownloader.this.K.obtainMessage(2, -1, currentTimeMillis2));
                    } else {
                        if (bidDownloader2.f78391h) {
                            z16 = HtmlOffline.q(bidDownloader2.f78389e);
                        }
                        BidDownloader.this.K.sendMessage(BidDownloader.this.K.obtainMessage(2, 0, currentTimeMillis2));
                    }
                    BidDownloader bidDownloader3 = BidDownloader.this;
                    if (bidDownloader3.f78392i) {
                        OfflinePlugin.P(bidDownloader3.f78389e, "Offline_Update_BSDiff", currentTimeMillis2, 0, "", "", "");
                    } else {
                        String str2 = bidDownloader3.f78389e;
                        if (!z16) {
                            i17 = 13;
                        }
                        OfflinePlugin.P(str2, "Offline_Update", currentTimeMillis2, i17, "", "", "");
                    }
                    BaseApplication.getContext().getSharedPreferences("bid_update_success_time", 4).edit().putLong(BidDownloader.this.f78389e, System.currentTimeMillis()).commit();
                    if (QLog.isColorLevel()) {
                        QLog.i("OfflinePluginQQ", 2, "success update bid: " + BidDownloader.this.f78389e);
                    }
                    HtmlOffline.J(BidDownloader.this.f78389e, i3, currentTimeMillis2, NetworkUtil.getNetWorkType(), "lixian_update", BidDownloader.this.L + "");
                    BidDownloader bidDownloader4 = BidDownloader.this;
                    BidDownloader.m(currentTimeMillis2, bidDownloader4.f78389e, i3, bidDownloader4.L, "lixian_update", 0);
                    return;
                }
                BidDownloader bidDownloader5 = BidDownloader.this;
                int i18 = bidDownloader5.F + 1;
                bidDownloader5.F = i18;
                if (i18 < 3) {
                    if (i18 == 1) {
                        i16 = 5000;
                    } else {
                        i16 = 10000;
                    }
                    d.a().c(new Runnable() { // from class: com.tencent.biz.common.offline.BidDownloader.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BidDownloader.this.g();
                        }
                    }, i16);
                    return;
                }
                BidDownloader.this.K.sendMessage(bidDownloader5.K.obtainMessage(2, 2, currentTimeMillis2));
                HtmlOffline.J(BidDownloader.this.f78389e, i3, currentTimeMillis2, NetworkUtil.getNetWorkType(), "lixian_update", BidDownloader.this.L + "");
                OfflinePlugin.P(BidDownloader.this.f78389e, "Offline_Update", currentTimeMillis2, i3, "", "", "");
                BidDownloader bidDownloader6 = BidDownloader.this;
                BidDownloader.m(currentTimeMillis2, bidDownloader6.f78389e, i3, bidDownloader6.L, "lixian_update", 0);
            }

            @Override // com.tencent.biz.common.offline.a
            public void progress(int i3) {
                if (BidDownloader.this.f78388d.get() != null) {
                    BidDownloader.this.f78388d.get().progress(i3);
                }
            }
        };
        this.K.sendEmptyMessage(1);
        return true;
    }

    public void f() {
        if (j(this.f78389e)) {
            if (QLog.isColorLevel()) {
                QLog.i(M, 2, this.f78389e + " is downloading");
                return;
            }
            return;
        }
        d.a().b(new Runnable() { // from class: com.tencent.biz.common.offline.BidDownloader.4
            @Override // java.lang.Runnable
            public void run() {
                boolean z16;
                if (BidDownloader.T == null) {
                    BidDownloader.i();
                }
                px.c cVar = BidDownloader.T;
                if (cVar != null && cVar.b(BidDownloader.Q, BidDownloader.this.I)) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (QLog.isColorLevel()) {
                    QLog.i(BidDownloader.M, 2, "downloading = " + z16);
                }
                if (!z16) {
                    BidDownloader.this.K.sendEmptyMessage(3);
                }
            }
        });
    }

    public void g() {
        d.a().b(new Runnable() { // from class: com.tencent.biz.common.offline.BidDownloader.2
            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put("Accept-Encoding", "gzip");
                if (BidDownloader.T == null) {
                    BidDownloader.i();
                }
                px.c cVar = BidDownloader.T;
                if (cVar != null) {
                    Context context = BidDownloader.Q;
                    BidDownloader bidDownloader = BidDownloader.this;
                    cVar.a(context, bidDownloader.I, bidDownloader.f78389e, bidDownloader.G, bidDownloader.H, hashMap);
                }
            }
        });
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i3 = message.what;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        h();
                        return false;
                    }
                    return false;
                }
                d(message.arg1, message.arg2);
                return false;
            }
            f();
            return false;
        }
        l(this.f78389e);
        return false;
    }

    public synchronized boolean o() {
        int c16;
        int i3;
        String str = this.f78389e;
        String str2 = this.G;
        boolean z16 = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (TextUtils.isEmpty(c.d(str))) {
            return false;
        }
        File file = new File(str2);
        if (!file.exists()) {
            if (QLog.isColorLevel()) {
                QLog.i(M, 2, "doUnzipZip: no zip ! : businessId:" + str);
            }
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(file.getParent());
        String str3 = File.separator;
        sb5.append(str3);
        sb5.append(str);
        String sb6 = sb5.toString();
        String c17 = c(str2);
        if (QLog.isColorLevel()) {
            QLog.i(M, 2, "fileFormat: " + c17 + ", path: " + str2);
        }
        if (!TextUtils.isEmpty(c17)) {
            if (c17.equals("zip")) {
                c16 = ((com.tencent.mobileqq.webview.swift.injector.b) aa.k(com.tencent.mobileqq.webview.swift.injector.b.class)).d(str2, sb6);
            } else {
                if (c17.equals("7z")) {
                    c16 = ((com.tencent.mobileqq.webview.swift.injector.b) aa.k(com.tencent.mobileqq.webview.swift.injector.b.class)).c(BaseApplication.getContext().getApplicationContext(), str2, sb6);
                }
                i3 = 1;
            }
            i3 = c16;
        } else {
            QLog.w(M, 1, "can not recognize download compress file format, " + this.G);
            if (this.C) {
                c16 = ((com.tencent.mobileqq.webview.swift.injector.b) aa.k(com.tencent.mobileqq.webview.swift.injector.b.class)).d(str2, sb6);
            } else {
                if (this.D) {
                    c16 = ((com.tencent.mobileqq.webview.swift.injector.b) aa.k(com.tencent.mobileqq.webview.swift.injector.b.class)).c(BaseApplication.getContext().getApplicationContext(), str2, sb6);
                }
                i3 = 1;
            }
            i3 = c16;
        }
        if (QLog.isColorLevel()) {
            QLog.i(M, 2, "now delete original download offline zip, path: " + str2);
        }
        com.tencent.mobileqq.webview.util.d.b(str2);
        if (i3 > 0) {
            HtmlOffline.J(str, 13, 0L, i3, "lixian_update", "0");
            m(0, str, 13, 0, "lixian_update", i3);
            if (QLog.isColorLevel()) {
                QLog.i(M, 2, "unZipFolder fail!");
            }
        } else {
            String str4 = sb6 + str3 + str + ".zip";
            File file2 = new File(str4);
            String str5 = file.getParent() + str3 + str + ".zip";
            if (QLog.isColorLevel()) {
                QLog.i(M, 2, "now move zip file to location: " + str5);
            }
            if (file2.exists()) {
                boolean renameTo = file2.renameTo(new File(str5));
                if (!renameTo) {
                    renameTo = FileUtils.moveFile(str4, str5);
                }
                if (!renameTo) {
                    HtmlOffline.J(str, 13, 0L, i3, "lixian_update", "0");
                    m(0, str, 13, 0, "lixian_update", i3);
                } else {
                    HtmlOffline.J(str, 13, 0L, i3, "lixian_time", "0");
                    m(0, str, 13, 0, "lixian_time", i3);
                    z16 = true;
                }
            } else {
                HtmlOffline.J(str, 13, 0L, i3, "lixian_update", "0");
                m(0, str, 13, 0, "lixian_update", i3);
            }
        }
        com.tencent.mobileqq.webview.util.d.a(sb6);
        if (QLog.isColorLevel()) {
            QLog.i(M, 2, "time of unzip zip\uff1a" + (System.currentTimeMillis() - currentTimeMillis) + ", isSuccess: " + z16);
        }
        return z16;
    }
}
