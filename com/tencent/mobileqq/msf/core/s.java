package com.tencent.mobileqq.msf.core;

import LBS.LBSInfo;
import android.app.ActivityManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.huawei.hms.framework.common.ContainerUtils;
import com.qq.jce.wup.UniPacket;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.msf.service.protocol.QQWiFi.WiFiService;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.api.ProcessConstant;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes15.dex */
public class s {
    static IPatchRedirector $redirector_ = null;
    public static final String A = "MQQ.QQWiFiMgrServer.QQWiFiMgrObj";
    public static final String B = "AvailQQWiFiForMSF";
    public static final String C = "QQWifiSvc.AvailQQWiFiForMSF";
    public static final String D = "MQQ.WiFiMapServer.WiFiMapObj";
    public static final String E = "getNearbyAvailWiFiInfo";
    public static final String F = "QQWifiSvc.getNearbyAvailWiFiInfo";
    public static final long G = 25000;
    public static final long H = 21600000;
    public static final int I = 1001;
    public static final int J = 1003;
    public static final int K = 1004;
    public static final int L = 1007;
    public static final int M = 1008;
    public static final int N = 1009;
    public static final int O = -80;
    public static final int P = 20000;
    public static final int Q = 1;
    public static final int R = 2;
    public static final int S = 4;
    public static final int T = 1;
    public static final int U = -1;
    public static final int V = 0;
    public static final int W = 1;
    public static final int X = 2;
    public static final int Y = 3;
    public static final int Z = 4;

    /* renamed from: a0, reason: collision with root package name */
    public static final int f249952a0 = 5;

    /* renamed from: b0, reason: collision with root package name */
    public static final int f249953b0 = 6;

    /* renamed from: c0, reason: collision with root package name */
    public static final int f249954c0 = 1;

    /* renamed from: d0, reason: collision with root package name */
    public static final int f249955d0 = 2;

    /* renamed from: e0, reason: collision with root package name */
    public static final int f249956e0 = 3;

    /* renamed from: x, reason: collision with root package name */
    private static final String f249957x = "QQWiFiScanManager";

    /* renamed from: y, reason: collision with root package name */
    private static s f249958y = null;

    /* renamed from: z, reason: collision with root package name */
    public static final String f249959z = "mobileqq.service";

    /* renamed from: a, reason: collision with root package name */
    private MsfCore f249960a;

    /* renamed from: b, reason: collision with root package name */
    private Context f249961b;

    /* renamed from: c, reason: collision with root package name */
    private d f249962c;

    /* renamed from: d, reason: collision with root package name */
    private Notification f249963d;

    /* renamed from: e, reason: collision with root package name */
    private int f249964e;

    /* renamed from: f, reason: collision with root package name */
    private String f249965f;

    /* renamed from: g, reason: collision with root package name */
    private RemoteViews f249966g;

    /* renamed from: h, reason: collision with root package name */
    private LBSInfo f249967h;

    /* renamed from: i, reason: collision with root package name */
    private long f249968i;

    /* renamed from: j, reason: collision with root package name */
    private long f249969j;

    /* renamed from: k, reason: collision with root package name */
    private long f249970k;

    /* renamed from: l, reason: collision with root package name */
    private List<String> f249971l;

    /* renamed from: m, reason: collision with root package name */
    private List<String> f249972m;

    /* renamed from: n, reason: collision with root package name */
    private List<WiFiService> f249973n;

    /* renamed from: o, reason: collision with root package name */
    private List<String> f249974o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f249975p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f249976q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f249977r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f249978s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f249979t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f249980u;

    /* renamed from: v, reason: collision with root package name */
    private int f249981v;

    /* renamed from: w, reason: collision with root package name */
    private final BroadcastReceiver f249982w;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) s.this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                return;
            }
            if (intent.getAction().equals("android.net.wifi.SCAN_RESULTS")) {
                try {
                    s.this.p();
                } catch (Throwable th5) {
                    if (QLog.isColorLevel()) {
                        QLog.e(s.f249957x, 2, "onReceive, SCAN_RESULTS_AVAILABLE_ACTION", th5);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class b implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MsfCore f249984a;

        b(MsfCore msfCore) {
            this.f249984a = msfCore;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) s.this, (Object) msfCore);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                s.this.a(this.f249984a);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class c extends BaseThread {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) s.this);
            }
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                s.this.f249978s = true;
                int i3 = 0;
                while (true) {
                    if (i3 >= s.this.f249962c.f249994h) {
                        break;
                    }
                    i3++;
                    if (s.this.r()) {
                        if (QLog.isColorLevel()) {
                            QLog.d(s.f249957x, 2, "accScan, launch count=" + i3);
                        }
                        try {
                            LockMethodProxy.sleep(s.this.f249962c.f249995i);
                        } catch (InterruptedException e16) {
                            e16.printStackTrace();
                        }
                    } else if (QLog.isColorLevel()) {
                        QLog.d(s.f249957x, 2, "accScan, count=" + i3 + ", stopped");
                    }
                }
                s.this.f249978s = false;
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f249964e = 0;
        this.f249965f = "";
        this.f249968i = 0L;
        this.f249969j = 0L;
        this.f249970k = 0L;
        this.f249971l = Collections.synchronizedList(new ArrayList());
        this.f249972m = Collections.synchronizedList(new ArrayList());
        this.f249973n = Collections.synchronizedList(new ArrayList());
        this.f249974o = Collections.synchronizedList(new ArrayList());
        this.f249976q = false;
        this.f249977r = false;
        this.f249978s = false;
        this.f249979t = true;
        this.f249980u = false;
        this.f249981v = 1;
        this.f249982w = new a();
        this.f249961b = BaseApplication.getContext();
        this.f249962c = new d(this, null);
    }

    private void d() {
        File dir = this.f249961b.getDir("qqwifi_dir", 0);
        File file = new File(dir, "enable_file");
        if (file.exists()) {
            try {
                if (new JSONObject(a(file)).has("mIsQQWiFiEnable_" + this.f249962c.f249989c)) {
                    this.f249962c.f249988b = false;
                    if (QLog.isColorLevel()) {
                        QLog.d(f249957x, 2, "initConfig, mIsQQWiFiEnable_" + this.f249962c.f249989c + ContainerUtils.KEY_VALUE_DELIMITER + this.f249962c.f249988b);
                    }
                }
            } catch (Exception unused) {
                if (QLog.isColorLevel()) {
                    QLog.e(f249957x, 2, "initConfig, enable_file exception");
                }
            }
        }
        File file2 = new File(dir, "ssids_file");
        if (file2.exists()) {
            try {
                JSONArray jSONArray = new JSONObject(a(file2)).getJSONArray("ssidList");
                int length = jSONArray.length();
                String str = "";
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    str = str + jSONArray.get(i3).toString();
                    if (i3 < length - 1) {
                        str = str + "|";
                    }
                }
                this.f249962c.f249987a = str;
                if (QLog.isColorLevel()) {
                    QLog.d(f249957x, 2, "initConfig, pattern - " + str);
                }
            } catch (Exception unused2) {
                if (QLog.isColorLevel()) {
                    QLog.e(f249957x, 2, "initConfig, ssids_file exception");
                }
            }
        }
    }

    public static s e() {
        if (f249958y == null) {
            f249958y = new s();
        }
        return f249958y;
    }

    private int f() {
        int i3 = !i() ? 1 : 0;
        if (this.f249962c.f249993g) {
            i3 |= 2;
        }
        if (h()) {
            i3 |= 4;
        }
        if (QLog.isColorLevel()) {
            QLog.i(f249957x, 2, "scantype=" + i3);
        }
        return i3;
    }

    private void g() {
        if (this.f249976q) {
            return;
        }
        this.f249976q = true;
        s();
        d();
        m();
    }

    private boolean h() {
        d dVar = this.f249962c;
        if (!dVar.f249988b) {
            return false;
        }
        int i3 = dVar.f249999m;
        if (i3 == 1) {
            return true;
        }
        if (i3 == -1 || !dVar.f249998l) {
            return false;
        }
        return true;
    }

    private boolean i() {
        d dVar = this.f249962c;
        int i3 = dVar.f249990d;
        if (i3 == 1) {
            return false;
        }
        if (i3 != -1 && dVar.f249992f) {
            return false;
        }
        return true;
    }

    private boolean j() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f249961b.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable() || NetworkMonitor.getType(activeNetworkInfo) == 1) {
            return false;
        }
        return true;
    }

    private boolean k() {
        if (!this.f249979t) {
            return false;
        }
        return true;
    }

    private boolean l() {
        if (this.f249980u) {
            if (QLog.isColorLevel()) {
                QLog.i(f249957x, 2, "CurUinQuited,return");
            }
            return false;
        }
        if (System.currentTimeMillis() - this.f249970k < 60000) {
            if (QLog.isColorLevel()) {
                QLog.i(f249957x, 2, "shouldAutoConnect in frequency limit,return");
            }
            return false;
        }
        if (!h()) {
            if (QLog.isColorLevel()) {
                QLog.i(f249957x, 2, "shouldAutoConnect isOpened false,return");
            }
            return false;
        }
        if (!k()) {
            if (QLog.isColorLevel()) {
                QLog.i(f249957x, 2, "shouldAutoConnect isDeviceSituationOk false,return");
            }
            return false;
        }
        if (!j()) {
            if (QLog.isColorLevel()) {
                QLog.i(f249957x, 2, "shouldAutoConnect isCurNetstatuAvailForAutoconnect false,return");
            }
            return false;
        }
        return true;
    }

    private void m() {
        try {
            Map<String, String> b16 = b(this.f249961b);
            if (b16 != null) {
                String str = b16.get("QuickScanTimes");
                if (str != null) {
                    try {
                        this.f249962c.f249994h = Integer.parseInt(str);
                    } catch (NumberFormatException e16) {
                        if (QLog.isColorLevel()) {
                            QLog.e(f249957x, 2, "init QuickScanTimes:", e16);
                        }
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(f249957x, 2, "loadParams, accScanTimes=" + this.f249962c.f249994h);
                    }
                }
                if (b16.get("QuickScanInterval") != null) {
                    try {
                        this.f249962c.f249995i = Integer.parseInt(r5) * 1000;
                    } catch (NumberFormatException e17) {
                        if (QLog.isColorLevel()) {
                            QLog.e(f249957x, 2, "init mAccScanInterval:", e17);
                        }
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(f249957x, 2, "loadParams, accScanTimes=" + this.f249962c.f249995i);
                    }
                }
                if (b16.get("barstatechangeinterval") != null) {
                    try {
                        this.f249962c.f249996j = Integer.parseInt(r5) * 1000;
                        if (QLog.isColorLevel()) {
                            QLog.d(f249957x, 2, "loadParams, barstatechangeinterval=" + this.f249962c.f249996j);
                        }
                    } catch (NumberFormatException e18) {
                        if (QLog.isColorLevel()) {
                            QLog.e(f249957x, 2, "loadParams, barstatechangeinterval:", e18);
                        }
                    }
                }
                String str2 = b16.get("systemNotifyBarSwitch");
                this.f249962c.f249992f = "1".equals(str2);
                if (QLog.isColorLevel()) {
                    QLog.d(f249957x, 2, "systemNotifyBarSwitch=" + this.f249962c.f249992f + ", " + str2);
                }
                String str3 = b16.get("QQWiFiActivitySwitch");
                this.f249962c.f249993g = "1".equals(str3);
                if (QLog.isColorLevel()) {
                    QLog.d(f249957x, 2, "QQWiFiActivitySwitch=" + this.f249962c.f249993g + "," + str3);
                }
                String str4 = b16.get("autoConnectSwitch");
                this.f249962c.f249998l = "1".equals(str4);
                if (QLog.isColorLevel()) {
                    QLog.d(f249957x, 2, "autoConnectFlag=" + this.f249962c.f249998l + "," + str4);
                }
                String str5 = b16.get("autoConnectProtectedInterval");
                if (str5 != null) {
                    try {
                        this.f249962c.f250000n = Long.parseLong(str5) * 1000;
                    } catch (NumberFormatException e19) {
                        if (QLog.isColorLevel()) {
                            QLog.e(f249957x, 2, "init autoConnectProtectedInterval:", e19);
                        }
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(f249957x, 2, "loadParams, autoConnectProtectedInterval=" + this.f249962c.f250000n);
                    }
                }
                String str6 = b16.get("autoMaxconnecttimes");
                if (str6 != null) {
                    try {
                        this.f249962c.f250001o = Integer.parseInt(str6);
                    } catch (Exception e26) {
                        if (QLog.isColorLevel()) {
                            QLog.e(f249957x, 2, "init maxAutoConnecttimes:", e26);
                        }
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(f249957x, 2, "loadParams, maxAutoConnecttimes=" + this.f249962c.f250001o);
                    }
                }
                if (b16.get("autoMaxconnecttimes") != null) {
                    try {
                        this.f249962c.f250002p = str6.equals("1");
                    } catch (Exception e27) {
                        if (QLog.isColorLevel()) {
                            QLog.e(f249957x, 2, "init isRootReport:", e27);
                        }
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(f249957x, 2, "loadParams, isRootReport=" + this.f249962c.f250002p);
                    }
                }
                String str7 = b16.get("noNetSupport");
                if (str7 != null) {
                    try {
                        this.f249962c.f250004r = str7.replaceAll("\\\\", "");
                    } catch (Exception e28) {
                        if (QLog.isColorLevel()) {
                            QLog.e(f249957x, 2, "init noNetSupport:", e28);
                        }
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(f249957x, 2, "loadParams, noNetSupport=" + this.f249962c.f250004r);
                    }
                }
                String str8 = b16.get("onlyReport");
                if (str8 != null) {
                    try {
                        this.f249962c.f250003q = str8;
                    } catch (Exception e29) {
                        if (QLog.isColorLevel()) {
                            QLog.e(f249957x, 2, "init reportPattern:", e29);
                        }
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(f249957x, 2, "loadParams, reportPattern=" + this.f249962c.f250003q);
                    }
                }
            }
        } catch (Exception e36) {
            if (QLog.isColorLevel()) {
                QLog.w(f249957x, 2, e36.toString());
            }
        }
    }

    private void n() {
        if (QLog.isColorLevel()) {
            QLog.d(f249957x, 2, "onAccountChange");
        }
        b(0);
        b(2);
        b(4);
        b(3);
        if (this.f249975p && this.f249977r && i()) {
            QQNotificationManager.getInstance().cancel(f249957x, 481);
            this.f249977r = false;
            this.f249964e = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x015f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void p() {
        boolean z16;
        ArrayList<com.tencent.msf.service.protocol.QQWiFi.d> arrayList;
        Pattern pattern;
        Pattern pattern2;
        List<ScanResult> scanResults;
        Matcher matcher;
        Matcher matcher2;
        if (!this.f249962c.f249988b) {
            return;
        }
        if (!a(this.f249961b)) {
            String a16 = a(this.f249961b, i());
            if (!TextUtils.isEmpty(a16)) {
                Pattern compile = Pattern.compile(a16);
                if (QLog.isColorLevel()) {
                    QLog.d(f249957x, 2, "NotNetworkSupportSsidList pattern: " + a16);
                }
                List<ScanResult> scanResults2 = NetworkMonitor.getScanResults((WifiManager) this.f249961b.getSystemService("wifi"));
                if (scanResults2 != null) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i3 = 0; i3 < scanResults2.size(); i3++) {
                        ScanResult scanResult = scanResults2.get(i3);
                        String replace = scanResult.SSID.replace("\"", "");
                        if (compile.matcher(replace).matches()) {
                            com.tencent.msf.service.protocol.QQWiFi.d dVar = new com.tencent.msf.service.protocol.QQWiFi.d();
                            dVar.f336464a = replace;
                            dVar.f336465b = scanResult.BSSID;
                            dVar.f336466c = (short) scanResult.level;
                            arrayList2.add(dVar);
                        }
                    }
                    if (!arrayList2.isEmpty()) {
                        if (i()) {
                            long j3 = BaseApplication.getContext().getSharedPreferences(ProcessConstant.QQWIFI, 4).getLong("lastPushAvailableWiFiToBarClosedUser", 0L);
                            if (j3 <= 0 || System.currentTimeMillis() - j3 >= 21600000) {
                                a(1008, "", false, true);
                            }
                        } else {
                            a(1001, "", false, true);
                        }
                        z16 = true;
                        if (z16 && r()) {
                            this.f249968i = System.currentTimeMillis();
                            arrayList = new ArrayList<>();
                            if (TextUtils.isEmpty(this.f249962c.f249987a) || !TextUtils.isEmpty(this.f249962c.f250003q)) {
                                if (TextUtils.isEmpty(this.f249962c.f249987a)) {
                                    pattern = Pattern.compile(this.f249962c.f249987a);
                                } else {
                                    pattern = null;
                                }
                                if (TextUtils.isEmpty(this.f249962c.f250003q)) {
                                    pattern2 = Pattern.compile(this.f249962c.f250003q);
                                } else {
                                    pattern2 = null;
                                }
                                if (QLog.isColorLevel()) {
                                    QLog.d(f249957x, 2, "pattern: " + this.f249962c.f249987a + " reportPattern: " + this.f249962c.f250003q);
                                }
                                scanResults = NetworkMonitor.getScanResults((WifiManager) this.f249961b.getSystemService("wifi"));
                                if (scanResults != null) {
                                    for (int i16 = 0; i16 < scanResults.size(); i16++) {
                                        ScanResult scanResult2 = scanResults.get(i16);
                                        String replace2 = scanResult2.SSID.replace("\"", "");
                                        if (pattern != null) {
                                            matcher = pattern.matcher(replace2);
                                        } else {
                                            matcher = null;
                                        }
                                        if (pattern2 != null) {
                                            matcher2 = pattern2.matcher(replace2);
                                        } else {
                                            matcher2 = null;
                                        }
                                        if ((matcher != null && matcher.matches()) || (matcher2 != null && matcher2.matches())) {
                                            com.tencent.msf.service.protocol.QQWiFi.d dVar2 = new com.tencent.msf.service.protocol.QQWiFi.d();
                                            dVar2.f336464a = replace2;
                                            dVar2.f336465b = scanResult2.BSSID;
                                            dVar2.f336466c = (short) scanResult2.level;
                                            arrayList.add(dVar2);
                                        }
                                    }
                                }
                            }
                            if (!arrayList.isEmpty()) {
                                c();
                                NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f249961b.getSystemService("connectivity")).getActiveNetworkInfo();
                                int wifiState = ((WifiManager) this.f249961b.getSystemService("wifi")).getWifiState();
                                if (activeNetworkInfo == null) {
                                    if (3 == wifiState) {
                                        a(1003, "", false, false);
                                        return;
                                    } else {
                                        a(1004, "", false, false);
                                        return;
                                    }
                                }
                                if (3 != wifiState) {
                                    a(1004, "", false, false);
                                    return;
                                } else if (NetworkMonitor.getType(activeNetworkInfo) != 1 && NetworkMonitor.getType(activeNetworkInfo) != 9) {
                                    a(1009, "", false, false);
                                    return;
                                } else {
                                    a(1007, "", false, false);
                                    return;
                                }
                            }
                            int f16 = f();
                            if ((f16 & 1) <= 0 && !a()) {
                                if ((f16 & 2) > 0 || (4 & f16) > 0) {
                                    d(arrayList);
                                    return;
                                }
                                return;
                            }
                            c(arrayList);
                            return;
                        }
                        return;
                    }
                }
            }
        }
        z16 = false;
        if (z16) {
            return;
        }
        this.f249968i = System.currentTimeMillis();
        arrayList = new ArrayList<>();
        if (TextUtils.isEmpty(this.f249962c.f249987a)) {
        }
        if (TextUtils.isEmpty(this.f249962c.f249987a)) {
        }
        if (TextUtils.isEmpty(this.f249962c.f250003q)) {
        }
        if (QLog.isColorLevel()) {
        }
        scanResults = NetworkMonitor.getScanResults((WifiManager) this.f249961b.getSystemService("wifi"));
        if (scanResults != null) {
        }
        if (!arrayList.isEmpty()) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean r() {
        if (!this.f249962c.f249988b || this.f249980u) {
            return false;
        }
        String string = BaseApplication.getContext().getSharedPreferences("Last_Login", 4).getString("uin", "");
        if (TextUtils.isEmpty(string)) {
            return false;
        }
        if (!string.equals(this.f249962c.f249989c)) {
            if (QLog.isColorLevel()) {
                QLog.d(f249957x, 2, "onAccountChange, " + this.f249962c.f249989c + ", " + string);
            }
            this.f249962c.f249989c = string;
            n();
        }
        if (!a(this.f249962c.f249989c) || !this.f249979t || !this.f249975p) {
            return false;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f249961b.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && NetworkMonitor.getType(activeNetworkInfo) == 1) {
            if (!b("")) {
                a(1007, "", false, false);
            }
            return false;
        }
        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
            int f16 = f();
            if (f16 <= 0) {
                if (!a()) {
                    return false;
                }
                return true;
            }
            if (f16 == 2 && !a() && System.currentTimeMillis() - this.f249969j < this.f249962c.f249997k) {
                return false;
            }
            return true;
        }
        a(1003, "", false, false);
        return false;
    }

    private void s() {
        SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences("Last_Login", 4);
        if (sharedPreferences != null) {
            this.f249962c.f249989c = sharedPreferences.getString("uin", "");
            if (QLog.isColorLevel()) {
                QLog.d(f249957x, 2, "lastLoginUin = " + this.f249962c.f249989c);
            }
        }
        SharedPreferences sharedPreferences2 = BaseApplication.getContext().getSharedPreferences("mobileQQ", 4);
        if (sharedPreferences2 != null) {
            this.f249962c.f249990d = sharedPreferences2.getInt("bar_switch_operation" + this.f249962c.f249989c, 0);
            if (QLog.isColorLevel()) {
                QLog.d(f249957x, 2, "initConfig, barOperation=" + this.f249962c.f249990d);
            }
            b(sharedPreferences2);
            a(sharedPreferences2);
        }
        sharedPreferences2.edit().putBoolean("hasPushedAvailNotification", false).commit();
    }

    private boolean t() {
        if (!this.f249978s) {
            if (QLog.isColorLevel()) {
                QLog.d(f249957x, 2, "startAccScan");
            }
            new c().start();
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f249957x, 2, "startAccScan, already running.");
            return false;
        }
        return false;
    }

    public void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        try {
            if (this.f249980u) {
                return;
            }
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f249961b.getSystemService("connectivity")).getActiveNetworkInfo();
            int wifiState = ((WifiManager) this.f249961b.getSystemService("wifi")).getWifiState();
            if (activeNetworkInfo == null) {
                if (3 == wifiState) {
                    a(1003, "", false, false);
                    return;
                } else {
                    a(1004, "", false, false);
                    return;
                }
            }
            if (3 != wifiState) {
                a(1004, "", false, false);
                return;
            }
            if (NetworkMonitor.getType(activeNetworkInfo) != 1 && NetworkMonitor.getType(activeNetworkInfo) != 9) {
                r();
                return;
            }
            a(1007, "", false, false);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(f249957x, 2, e16.getMessage());
            }
        }
    }

    public void q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        try {
            r();
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.e(f249957x, 2, "scan", th5);
            }
        }
    }

    public void u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (this.f249975p) {
            BaseApplication.getContext().unregisterReceiver(this.f249982w);
        }
        this.f249975p = false;
        if (QLog.isColorLevel()) {
            QLog.d(f249957x, 2, "unregister");
        }
    }

    private void b(SharedPreferences sharedPreferences) {
        if (sharedPreferences == null) {
            sharedPreferences = BaseApplication.getContext().getSharedPreferences("mobileQQ", 4);
        }
        if (sharedPreferences != null) {
            String string = sharedPreferences.getString("autoconnect_bssids", "");
            if (!TextUtils.isEmpty(string)) {
                String[] split = string.split("\\|");
                if (split == null || split.length == 0) {
                    this.f249974o.add(string);
                } else {
                    for (String str : split) {
                        this.f249974o.add(str);
                    }
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d(f249957x, 2, "updateConfig, bssidsString=" + string + " ssid list=" + this.f249974o.toString());
            }
        }
    }

    private void c() {
        SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences("mobileQQ", 4);
        if (sharedPreferences != null) {
            sharedPreferences.edit().remove("autoconnect_bssids").commit();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MsfCore msfCore) {
        g();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.SCAN_RESULTS");
        BaseApplication.getContext().registerReceiver(this.f249982w, intentFilter);
        b();
    }

    private void e(ArrayList<com.tencent.msf.service.protocol.QQWiFi.d> arrayList) {
        boolean z16;
        if (l()) {
            HashSet hashSet = new HashSet();
            Iterator<WiFiService> it = this.f249973n.iterator();
            while (true) {
                z16 = true;
                if (!it.hasNext()) {
                    break;
                }
                WiFiService next = it.next();
                if (next.autoConnFlag == 1) {
                    hashSet.add(next.wifi.f336465b);
                }
            }
            Iterator<com.tencent.msf.service.protocol.QQWiFi.d> it5 = arrayList.iterator();
            while (true) {
                if (!it5.hasNext()) {
                    z16 = false;
                    break;
                } else if (hashSet.contains(it5.next().f336465b)) {
                    break;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d(f249957x, 2, "processWiFiScanResultForBar, hasAutoIntersection=" + z16);
            }
            if (z16) {
                d(this.f249973n);
            }
        }
    }

    private void c(ArrayList<com.tencent.msf.service.protocol.QQWiFi.d> arrayList) {
        boolean b16 = b(arrayList);
        if (QLog.isColorLevel()) {
            QLog.d(f249957x, 2, "processWiFiScanResultForBar, hasIntersection=" + b16);
        }
        if (b16) {
            if (i()) {
                if (a()) {
                    a(1008, "", false, false);
                }
            } else {
                a(1001, "", false, false);
            }
            e(arrayList);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            Iterator<com.tencent.msf.service.protocol.QQWiFi.d> it = arrayList.iterator();
            while (it.hasNext()) {
                com.tencent.msf.service.protocol.QQWiFi.d next = it.next();
                sb5.append(next.f336464a + "," + next.f336465b + "," + ((int) next.f336466c) + "|");
            }
            QLog.d(f249957x, 2, "scanlist before filter:" + sb5.toString());
        }
        Iterator<com.tencent.msf.service.protocol.QQWiFi.d> it5 = arrayList.iterator();
        while (it5.hasNext()) {
            com.tencent.msf.service.protocol.QQWiFi.d next2 = it5.next();
            if (next2.f336466c < -80) {
                it5.remove();
            } else {
                arrayList2.add(next2.f336465b);
            }
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb6 = new StringBuilder();
            Iterator<com.tencent.msf.service.protocol.QQWiFi.d> it6 = arrayList.iterator();
            while (it6.hasNext()) {
                com.tencent.msf.service.protocol.QQWiFi.d next3 = it6.next();
                sb6.append(next3.f336464a + "," + next3.f336465b + "," + ((int) next3.f336466c) + "|");
            }
            QLog.d(f249957x, 2, "scanlist after filter:" + sb6.toString());
            QLog.d(f249957x, 2, "bssidSet:" + arrayList2.toString());
        }
        boolean a16 = a(this.f249971l, arrayList2);
        if (QLog.isColorLevel()) {
            QLog.d(f249957x, 2, "processWiFiScanResultForBar, isSubset=" + a16 + ", bssidSet.size=" + arrayList2.size());
        }
        if (a16) {
            return;
        }
        a(arrayList);
        this.f249971l.clear();
        this.f249971l.addAll(arrayList2);
    }

    public void a(MsfCore msfCore, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, msfCore, Boolean.valueOf(z16));
            return;
        }
        if (this.f249975p) {
            if (QLog.isColorLevel()) {
                QLog.d(f249957x, 2, "QQWifi already register.");
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f249957x, 2, "QQWifi register,isSyncRegister=" + z16);
        }
        this.f249960a = msfCore;
        this.f249975p = true;
        if (z16) {
            a(msfCore);
        } else {
            new BaseThread(new b(msfCore)).start();
        }
    }

    private void b(int i3) {
        switch (i3) {
            case 0:
                File file = new File(this.f249961b.getDir("qqwifi_dir", 0), "enable_file");
                if (file.exists()) {
                    try {
                        if (new JSONObject(a(file)).has("mIsQQWiFiEnable_" + this.f249962c.f249989c)) {
                            this.f249962c.f249988b = false;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d(f249957x, 2, "updateConfig, mIsQQWiFiEnable_" + this.f249962c.f249989c + ContainerUtils.KEY_VALUE_DELIMITER + this.f249962c.f249988b);
                            return;
                        }
                        return;
                    } catch (Exception unused) {
                        if (QLog.isColorLevel()) {
                            QLog.e(f249957x, 2, "updateConfig, enable_file exception");
                            return;
                        }
                        return;
                    }
                }
                return;
            case 1:
                File file2 = new File(this.f249961b.getDir("qqwifi_dir", 0), "ssids_file");
                if (file2.exists()) {
                    try {
                        JSONArray jSONArray = new JSONObject(a(file2)).getJSONArray("ssidList");
                        int length = jSONArray.length();
                        String str = "";
                        for (int i16 = 0; i16 < jSONArray.length(); i16++) {
                            str = str + jSONArray.get(i16).toString();
                            if (i16 < length - 1) {
                                str = str + "|";
                            }
                        }
                        this.f249962c.f249987a = str;
                        if (QLog.isColorLevel()) {
                            QLog.d(f249957x, 2, "updateConfig, pattern - " + str);
                            return;
                        }
                        return;
                    } catch (Exception unused2) {
                        if (QLog.isColorLevel()) {
                            QLog.e(f249957x, 2, "updateConfig, ssids_file exception");
                            return;
                        }
                        return;
                    }
                }
                return;
            case 2:
                SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences("mobileQQ", 4);
                if (sharedPreferences != null) {
                    this.f249962c.f249990d = sharedPreferences.getInt("bar_switch_operation" + this.f249962c.f249989c, 0);
                    if (QLog.isColorLevel()) {
                        QLog.d(f249957x, 2, "updateConfig, BarSwitch=" + this.f249962c.f249990d);
                    }
                    if (this.f249962c.f249990d == -1) {
                        this.f249977r = false;
                        this.f249964e = 0;
                        return;
                    }
                    return;
                }
                return;
            case 3:
                m();
                return;
            case 4:
                a((SharedPreferences) null);
                return;
            case 5:
                b((SharedPreferences) null);
                return;
            case 6:
                this.f249962c.f249991e = BaseApplication.getContext().getSharedPreferences(ProcessConstant.QQWIFI, 4).getBoolean("availNotificationSwitch", false);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f249987a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f249988b;

        /* renamed from: c, reason: collision with root package name */
        public String f249989c;

        /* renamed from: d, reason: collision with root package name */
        public int f249990d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f249991e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f249992f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f249993g;

        /* renamed from: h, reason: collision with root package name */
        public int f249994h;

        /* renamed from: i, reason: collision with root package name */
        public long f249995i;

        /* renamed from: j, reason: collision with root package name */
        public long f249996j;

        /* renamed from: k, reason: collision with root package name */
        public long f249997k;

        /* renamed from: l, reason: collision with root package name */
        public boolean f249998l;

        /* renamed from: m, reason: collision with root package name */
        public int f249999m;

        /* renamed from: n, reason: collision with root package name */
        public long f250000n;

        /* renamed from: o, reason: collision with root package name */
        public int f250001o;

        /* renamed from: p, reason: collision with root package name */
        public boolean f250002p;

        /* renamed from: q, reason: collision with root package name */
        public String f250003q;

        /* renamed from: r, reason: collision with root package name */
        public String f250004r;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) s.this);
                return;
            }
            this.f249987a = "";
            this.f249988b = false;
            this.f249989c = "";
            this.f249990d = 0;
            this.f249991e = false;
            this.f249992f = false;
            this.f249993g = false;
            this.f249994h = 10;
            this.f249995i = 30000L;
            this.f249996j = 60000L;
            this.f249997k = 86400000L;
            this.f249998l = false;
            this.f249999m = 0;
            this.f250000n = 21600000L;
            this.f250001o = 1;
            this.f250002p = false;
        }

        /* synthetic */ d(s sVar, a aVar) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) sVar, (Object) aVar);
        }
    }

    private void a(SharedPreferences sharedPreferences) {
        if (sharedPreferences == null) {
            sharedPreferences = BaseApplication.getContext().getSharedPreferences("mobileQQ", 4);
        }
        if (sharedPreferences != null) {
            this.f249962c.f249999m = sharedPreferences.getInt("autoconnect_switch_operation" + this.f249962c.f249989c, 0);
            if (QLog.isColorLevel()) {
                QLog.d(f249957x, 2, "updateConfig, AutoSwitch=" + this.f249962c.f249999m);
            }
        }
    }

    private boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        BaseApplication context = BaseApplication.getContext();
        return context.getSharedPreferences(context.getPackageName() + "_preferences", 4).getBoolean("login_auto" + str, false);
    }

    private void d(ArrayList<com.tencent.msf.service.protocol.QQWiFi.d> arrayList) {
        if (QLog.isColorLevel()) {
            QLog.i(f249957x, 2, "checkAvailForOperation");
        }
        boolean b16 = b(arrayList);
        if (QLog.isColorLevel()) {
            QLog.d(f249957x, 2, "processWiFiScanResultForBar, hasIntersection=" + b16);
        }
        if (b16) {
            e(arrayList);
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<com.tencent.msf.service.protocol.QQWiFi.d> it = arrayList.iterator();
        while (it.hasNext()) {
            com.tencent.msf.service.protocol.QQWiFi.d next = it.next();
            if (next.f336466c < -80) {
                it.remove();
            } else {
                arrayList2.add(next.f336465b);
            }
        }
        if (!a(this.f249972m, arrayList2)) {
            a(arrayList);
            this.f249972m.clear();
            Iterator it5 = arrayList2.iterator();
            while (it5.hasNext()) {
                this.f249972m.add((String) it5.next());
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f249957x, 2, "processWiFiScanResultForOperation, isSubset=true");
        }
    }

    private boolean a() {
        if (this.f249981v == 0) {
            if (QLog.isColorLevel()) {
                QLog.d(f249957x, 2, "canPushAvailableWiFiToBarClosedUser, availpush=0");
            }
            return false;
        }
        SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences(ProcessConstant.QQWIFI, 4);
        if (System.currentTimeMillis() - sharedPreferences.getLong("lastPushAvailableWiFiToBarClosedUser", 0L) < 21600000) {
            if (QLog.isColorLevel()) {
                QLog.d(f249957x, 2, "canPushAvailableWiFiToBarClosedUser, time limit");
            }
            return false;
        }
        if (sharedPreferences.getBoolean("availNotificationSwitch", false)) {
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f249957x, 2, "canPushAvailableWiFiToBarClosedUser, avail switch is turned off");
        }
        return false;
    }

    private boolean c(List<WiFiService> list) {
        SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences("mobileQQ", 4);
        if (sharedPreferences == null) {
            return false;
        }
        long j3 = sharedPreferences.getLong("autoconnect_reference_time", 0L);
        long currentTimeMillis = System.currentTimeMillis() - j3;
        if (QLog.isColorLevel()) {
            QLog.i(f249957x, 2, "isInAutoconnectIntervalProtected lasttime=" + j3 + " interval=" + currentTimeMillis + " autoConnectProtectedInterval=" + this.f249962c.f250000n);
        }
        return currentTimeMillis < this.f249962c.f250000n && b(list);
    }

    private void a(ArrayList<com.tencent.msf.service.protocol.QQWiFi.d> arrayList) {
        try {
            this.f249969j = System.currentTimeMillis();
            int f16 = f();
            if (QLog.isColorLevel()) {
                QLog.d(f249957x, 2, "getAvailableQQWifi size:" + arrayList.size() + " scanType=" + f16 + " needcallback=true");
            }
            UniPacket uniPacket = new UniPacket(true);
            uniPacket.setEncodeName("UTF-8");
            com.tencent.msf.service.protocol.QQWiFi.a aVar = new com.tencent.msf.service.protocol.QQWiFi.a();
            aVar.f336453a = arrayList;
            aVar.f336454b = com.tencent.mobileqq.msf.core.c.d(this.f249961b);
            aVar.f336455c = "Android";
            aVar.f336456d = f16;
            uniPacket.setServantName(A);
            uniPacket.setFuncName(B);
            uniPacket.put("req", aVar);
            byte[] encode = uniPacket.encode();
            ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.f249962c.f249989c, C);
            toServiceMsg.setAppId(BaseApplication.getContext().getAppId());
            toServiceMsg.setRequestSsoSeq(this.f249960a.getNextSeq());
            toServiceMsg.setTimeout(20000L);
            toServiceMsg.setNeedCallback(true);
            toServiceMsg.putWupBuffer(encode);
            toServiceMsg.addAttribute("isformsf", Boolean.TRUE);
            this.f249960a.sendSsoMsg(toServiceMsg);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(f249957x, 2, "getAvailableQQWifi exp:" + e16);
            }
        }
    }

    private void d(List<WiFiService> list) {
        if (list != null) {
            try {
                if (list.isEmpty()) {
                    return;
                }
                ArrayList arrayList = new ArrayList(list);
                if (QLog.isColorLevel()) {
                    QLog.i(f249957x, 2, "startAutoConnect services all avail:" + arrayList.toString());
                }
                if (!l()) {
                    if (QLog.isColorLevel()) {
                        QLog.i(f249957x, 2, "shouldAutoConnect isEnableAutoconnect false,return");
                        return;
                    }
                    return;
                }
                List<WiFiService> a16 = a((List<WiFiService>) arrayList);
                if (a16 != null && !a16.isEmpty()) {
                    if (c(a16)) {
                        if (QLog.isColorLevel()) {
                            QLog.i(f249957x, 2, "shouldAutoConnect in time protected,return");
                            return;
                        }
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i(f249957x, 2, "startAutoConnect services:" + a16.toString());
                    }
                    this.f249970k = System.currentTimeMillis();
                    Intent intent = new Intent(com.tencent.mobileqq.msf.core.push.h.D0);
                    intent.setPackage(BaseApplication.getContext().getPackageName());
                    intent.putExtra("services", new ArrayList(a16));
                    BaseApplication.getContext().sendBroadcast(intent);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.i(f249957x, 2, "shouldAutoConnect services empty after filtered,return");
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    e16.printStackTrace();
                }
            }
        }
    }

    private boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String replace = str.replace("\"", "");
        Pattern compile = Pattern.compile(this.f249962c.f249987a);
        boolean matches = compile.matcher(replace).matches();
        if (!QLog.isColorLevel()) {
            return matches;
        }
        QLog.d(f249957x, 2, "isQQWiFi, " + compile + ", " + replace + ", " + matches);
        return matches;
    }

    private boolean b(ArrayList<com.tencent.msf.service.protocol.QQWiFi.d> arrayList) {
        if (this.f249973n != null) {
            HashSet hashSet = new HashSet();
            Iterator<WiFiService> it = this.f249973n.iterator();
            while (it.hasNext()) {
                hashSet.add(it.next().wifi.f336465b);
            }
            Iterator<com.tencent.msf.service.protocol.QQWiFi.d> it5 = arrayList.iterator();
            while (it5.hasNext()) {
                if (hashSet.contains(it5.next().f336465b)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean b(List<WiFiService> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<WiFiService> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().wifi.f336465b);
        }
        int min = Math.min(Math.min(arrayList.size(), this.f249974o.size()), this.f249962c.f250001o);
        if (QLog.isColorLevel()) {
            QLog.i(f249957x, 2, "lastAutoBssids=" + this.f249974o.toString() + " curSet:" + arrayList.toString() + " isSubSet= maxAutoConnecttimes=" + this.f249962c.f250001o + " min=" + min);
        }
        for (int i3 = 0; i3 < min; i3++) {
            String str = (String) arrayList.get(i3);
            if (this.f249974o.contains(str)) {
                if (!QLog.isColorLevel()) {
                    return true;
                }
                QLog.i(f249957x, 2, "return true:" + str + "has already tryed i=" + i3);
                return true;
            }
        }
        c();
        return false;
    }

    public void a(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
            return;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onRecvAvailResponse :");
            sb5.append(fromServiceMsg == null ? "null" : fromServiceMsg.toString());
            QLog.d(f249957x, 2, sb5.toString());
        }
        if (fromServiceMsg != null && fromServiceMsg.isSuccess()) {
            boolean z16 = true;
            UniPacket uniPacket = new UniPacket(true);
            uniPacket.setEncodeName("utf-8");
            uniPacket.decode(fromServiceMsg.getWupBuffer());
            com.tencent.msf.service.protocol.QQWiFi.b bVar = (com.tencent.msf.service.protocol.QQWiFi.b) uniPacket.getByClass("rsp", new com.tencent.msf.service.protocol.QQWiFi.b());
            if (bVar != null && bVar.f336458a == 0) {
                if (QLog.isColorLevel()) {
                    QLog.d(f249957x, 2, "onRecvAvailResponse, availpush=" + bVar.f336461d);
                }
                this.f249981v = bVar.f336461d;
                if (!bVar.f336459b.isEmpty()) {
                    if (i()) {
                        if (this.f249962c.f249991e && this.f249981v == 1) {
                            a(1008, "", false, false);
                        }
                    } else {
                        a(1001, "", false, false);
                    }
                    if (a(this.f249973n, bVar.f336459b)) {
                        if (QLog.isColorLevel()) {
                            QLog.d(f249957x, 2, "onRecvAvailResponse, isSubset=true");
                        }
                    } else {
                        t();
                    }
                    this.f249973n.clear();
                    this.f249973n.addAll(bVar.f336459b);
                    return;
                }
                try {
                    NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f249961b.getSystemService("connectivity")).getActiveNetworkInfo();
                    if (activeNetworkInfo == null || NetworkMonitor.getType(activeNetworkInfo) != 1) {
                        z16 = false;
                    }
                    if (z16) {
                        return;
                    }
                    a(1009, "", false, false);
                    return;
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e(f249957x, 2, "onRecvAvailResponse, qqwifi not avail", e16);
                        return;
                    }
                    return;
                }
            }
            this.f249971l.clear();
            try {
                NetworkInfo activeNetworkInfo2 = ((ConnectivityManager) this.f249961b.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo2 == null || NetworkMonitor.getType(activeNetworkInfo2) != 1) {
                    z16 = false;
                }
                if (z16) {
                    return;
                }
                a(1009, "", false, false);
                return;
            } catch (Exception e17) {
                if (QLog.isColorLevel()) {
                    QLog.e(f249957x, 2, "onRecvAvailResponse, qqwifi not avail", e17);
                    return;
                }
                return;
            }
        }
        this.f249971l.clear();
    }

    public void b() {
        SharedPreferences sharedPreferences;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        if (this.f249962c.f249988b) {
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f249961b.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null && NetworkMonitor.getType(activeNetworkInfo) == 1) {
                    List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = SystemMethodProxy.getRunningAppProcesses((ActivityManager) this.f249961b.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY));
                    if (runningAppProcesses != null) {
                        Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                        while (it.hasNext()) {
                            if ("com.tencent.mobileqq:qqwifi".equals(it.next().processName)) {
                                return;
                            }
                        }
                    }
                    a(NetConnInfoCenter.msfCore, true);
                    if (TextUtils.isEmpty("") || TextUtils.isEmpty("") || (sharedPreferences = BaseApplication.getContext().getSharedPreferences("mobileQQ", 4)) == null) {
                        return;
                    }
                    String string = sharedPreferences.getString("qqwifiConnInfo", "");
                    if (TextUtils.isEmpty(string)) {
                        return;
                    }
                    JSONObject jSONObject = new JSONObject(string);
                    String optString = jSONObject.optString(TPDownloadProxyEnum.USER_SSID);
                    String optString2 = jSONObject.optString("bssid");
                    String optString3 = jSONObject.optString("IPAdress");
                    if ("".equals(optString2) && "".equals(optString3)) {
                        if (QLog.isColorLevel()) {
                            QLog.i(f249957x, 2, "checkConnection:remove netWork\uff01ssid=" + optString + " bssid=" + optString2 + " IPAdress=" + optString3);
                        }
                        WifiManager wifiManager = (WifiManager) this.f249961b.getSystemService("wifi");
                        List<WifiConfiguration> configureNetworks = NetworkMonitor.getConfigureNetworks(wifiManager);
                        if (configureNetworks == null) {
                            return;
                        }
                        for (int i3 = 0; i3 < configureNetworks.size(); i3++) {
                            WifiConfiguration wifiConfiguration = configureNetworks.get(i3);
                            if (wifiConfiguration != null && !TextUtils.isEmpty(wifiConfiguration.SSID)) {
                                String replace = wifiConfiguration.SSID.replace("\"", "");
                                optString = optString.replace("\"", "");
                                if (replace.equals(optString)) {
                                    wifiManager.removeNetwork(wifiConfiguration.networkId);
                                    if (QLog.isColorLevel()) {
                                        QLog.i(f249957x, 2, "checkConnection\uff1a\u5df2\u7ecf\u5220\u9664\u4e86" + wifiConfiguration.SSID + "\u7f51\u7edc networkId:" + wifiConfiguration.networkId + " bssid:" + wifiConfiguration.BSSID);
                                    }
                                }
                            }
                        }
                        wifiManager.saveConfiguration();
                    }
                }
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.d(f249957x, 2, "checkConnection:Exception:" + th5.getMessage());
                }
            }
        }
    }

    private List<WiFiService> a(List<WiFiService> list) {
        if (list == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (WiFiService wiFiService : list) {
            if (wiFiService.autoConnFlag == 1 && arrayList.size() < this.f249962c.f250001o) {
                arrayList.add(wiFiService);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i(f249957x, 2, "after filtered:" + arrayList.toString());
        }
        return arrayList;
    }

    public void a(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) intent);
            return;
        }
        if (this.f249980u) {
            if (QLog.isColorLevel()) {
                QLog.d(f249957x, 2, "onResponseWifiStatechange isCurUinQuited true, return");
                return;
            }
            return;
        }
        int intExtra = intent.getIntExtra("wifi_state", 0);
        if (QLog.isColorLevel()) {
            QLog.i(f249957x, 2, " onResponseWifiStatechange, wifiState=" + intExtra);
        }
        boolean z16 = true;
        if (intExtra == 1) {
            a(1004, "", false, false);
            return;
        }
        if (intExtra != 3) {
            return;
        }
        try {
            NetworkInfo[] allNetworkInfo = ((ConnectivityManager) this.f249961b.getSystemService("connectivity")).getAllNetworkInfo();
            if (allNetworkInfo == null || allNetworkInfo.length <= 0 || allNetworkInfo[0].getState() != NetworkInfo.State.CONNECTED) {
                z16 = false;
            }
            if (z16) {
                return;
            }
            a(1003, "", false, false);
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.e(f249957x, 2, th5, new Object[0]);
            }
        }
    }

    private Map<String, String> b(Context context) {
        try {
            String a16 = a(new File(context.getDir("qqwifi_dir", 0), "params_file"));
            if (TextUtils.isEmpty(a16)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(a16);
            HashMap hashMap = new HashMap();
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                hashMap.put(str, jSONObject.getString(str));
            }
            return hashMap;
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    private void a(int i3, String str, boolean z16, boolean z17) {
        if (this.f249962c.f249988b) {
            if (a(i3) || z17) {
                a(i3, str, z16);
                this.f249964e = i3;
                this.f249965f = str;
                if (i3 != 1008) {
                    this.f249977r = true;
                }
            }
        }
    }

    private boolean a(int i3) {
        List<ScanResult> list;
        if (!this.f249977r) {
            try {
                list = NetworkMonitor.getScanResults((WifiManager) this.f249961b.getSystemService("wifi"));
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(f249957x, 2, e16.getMessage());
                }
                list = null;
            }
            if (list == null || list.size() <= 0) {
                return false;
            }
        }
        if (!this.f249975p) {
            if (QLog.isColorLevel()) {
                QLog.d(f249957x, 2, "canPushNotification, not registered.");
            }
            return false;
        }
        SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences("mobileQQ", 4);
        if (sharedPreferences != null && !TextUtils.isEmpty(this.f249962c.f249989c)) {
            this.f249962c.f249990d = sharedPreferences.getInt("bar_switch_operation" + this.f249962c.f249989c, 0);
            if (QLog.isColorLevel()) {
                QLog.d(f249957x, 2, "canPushNotification, BarSwitch=" + this.f249962c.f249990d);
            }
        }
        if (i() && i3 != 1008) {
            if (QLog.isColorLevel()) {
                QLog.d(f249957x, 2, "canPushNotification, bar closed.");
            }
            return false;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f249961b.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || NetworkMonitor.getType(activeNetworkInfo) != 1 || i3 != 1001) {
            return a(this.f249962c.f249989c);
        }
        if (QLog.isColorLevel()) {
            QLog.d(f249957x, 2, "canPushNotification, dont push qqwifi info while wifi is connected");
        }
        return false;
    }

    public void a(int i3, String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), str, Boolean.valueOf(z16));
            return;
        }
        if (this.f249962c.f249988b) {
            switch (i3) {
                case 1001:
                    Intent intent = new Intent(com.tencent.mobileqq.msf.core.push.h.A0);
                    intent.putExtra("hasvailable", true);
                    if (z16) {
                        a(intent, i3, BaseApplication.qqWifiUserful, TextUtils.isEmpty(str) ? "\u5f53\u524d\u6709\u514d\u8d39WiFi\uff0c\u70b9\u51fb\u67e5\u770b" : str, "\u8bd5\u8bd5\u4e00\u952e\u8fde\u63a5", "\u5f53\u524d\u6709\u53ef\u7528\u7684 QQ WiFi,\u70b9\u51fb\u8fdb\u5165\u8fde\u63a5");
                    } else {
                        a(intent, i3, BaseApplication.qqWifiUserful, TextUtils.isEmpty(str) ? "\u5f53\u524d\u6709\u514d\u8d39WiFi\uff0c\u70b9\u51fb\u67e5\u770b" : str, "\u8bd5\u8bd5\u4e00\u952e\u8fde\u63a5", null);
                    }
                    a(1, (Bundle) null);
                    return;
                case 1002:
                case 1005:
                case 1006:
                default:
                    return;
                case 1003:
                    a(new Intent(com.tencent.mobileqq.msf.core.push.h.A0), i3, BaseApplication.qqWifiNoSignal, "\u7f51\u7edc\u8fde\u63a5\u4e0d\u53ef\u7528", "\u7f51\u7edc\u6062\u590d\u540e\u67e5\u770b", null);
                    return;
                case 1004:
                    a(new Intent(com.tencent.mobileqq.msf.core.push.h.A0), i3, BaseApplication.qqWifiNoSignal, "\u5df2\u5173\u95ed\u65e0\u7ebf\u7f51\u7edc", "\u6253\u5f00\u540e\u67e5\u770b", null);
                    return;
                case 1007:
                    a(new Intent(com.tencent.mobileqq.msf.core.push.h.A0), i3, BaseApplication.qqWifiConnecticon3, "\u5df2\u8fde\u63a5 " + str, "\u5feb\u6765\u8d5a\u53d6\u514d\u8d39QQ WiFi\u65f6\u957f", null);
                    return;
                case 1008:
                    a(new Intent(com.tencent.mobileqq.msf.core.push.h.A0), i3, BaseApplication.qqWifiUserful, "\u5f53\u524d\u6709\u514d\u8d39WiFi\uff0c\u70b9\u51fb\u67e5\u770b", "\u8bd5\u8bd5\u4e00\u952e\u8fde\u63a5", "\u5f53\u524d\u6709\u53ef\u7528\u7684QQ WiFi\uff0c\u70b9\u51fb\u8fdb\u5165\u8fde\u63a5");
                    BaseApplication.getContext().getSharedPreferences(ProcessConstant.QQWIFI, 4).edit().putLong("lastPushAvailableWiFiToBarClosedUser", System.currentTimeMillis()).commit();
                    a(3, (Bundle) null);
                    return;
                case 1009:
                    a(new Intent(com.tencent.mobileqq.msf.core.push.h.A0), i3, BaseApplication.qqWifiNoSignal, "\u672a\u8fde\u63a5\u4efb\u4f55WiFi", "xxx", null);
                    return;
            }
        }
    }

    private void a(Intent intent, int i3, int i16, String str, String str2, String str3) {
        QQNotificationManager qQNotificationManager = QQNotificationManager.getInstance();
        if (this.f249966g == null) {
            this.f249966g = new RemoteViews(BaseApplication.getContext().getPackageName(), BaseApplication.qqWifiLayout);
        }
        this.f249966g.setImageViewResource(BaseApplication.qqWifiSettingViewId, BaseApplication.qqWifiSettings);
        this.f249966g.setViewVisibility(BaseApplication.qqWifiRedTouchViewId, 8);
        Intent intent2 = new Intent(com.tencent.mobileqq.msf.core.push.h.B0);
        intent2.putExtras(new Bundle());
        intent2.addFlags(603979776);
        this.f249966g.setOnClickPendingIntent(BaseApplication.qqWifiSettingViewId, PendingIntent.getActivity(BaseApplication.getContext(), 0, intent2, 201326592));
        SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences(ProcessConstant.QQWIFI, 4);
        int i17 = sharedPreferences.getInt("BarOperation_id", 0);
        String str4 = "";
        if (i17 != 0) {
            boolean z16 = sharedPreferences.getBoolean(this.f249962c.f249989c + "hasClicked" + i17, false);
            long j3 = sharedPreferences.getLong("BarOperation_expiry", 0L);
            if (z16 || System.currentTimeMillis() >= j3 * 1000) {
                str4 = "";
            } else {
                int i18 = sharedPreferences.getInt("BarOperation_type", 0);
                str4 = "";
                String string = sharedPreferences.getString("BarOperation_url", str4);
                Intent intent3 = new Intent(com.tencent.mobileqq.msf.core.push.h.C0);
                intent3.putExtra("type", i18);
                intent3.putExtra("url", string);
                intent3.putExtra("id", i17);
                intent3.addFlags(603979776);
                this.f249966g.setOnClickPendingIntent(BaseApplication.qqWifiRedTouchViewId, PendingIntent.getActivity(BaseApplication.getContext(), 0, intent3, 201326592));
                this.f249966g.setImageViewResource(BaseApplication.qqWifiRedTouchViewId, BaseApplication.qqWifiOperation);
                this.f249966g.setViewVisibility(BaseApplication.qqWifiRedTouchViewId, 0);
                Bundle bundle = new Bundle();
                bundle.putInt("id", i17);
                a(2, bundle);
            }
        }
        this.f249966g.setImageViewResource(BaseApplication.qqWifiStateIconViewId, i16);
        this.f249966g.setTextViewText(BaseApplication.qqWifiStateTextSingleLine, str);
        this.f249966g.setViewVisibility(BaseApplication.qqWifiTextDoubleLine, 8);
        this.f249966g.setViewVisibility(BaseApplication.qqWifiStateTextSingleLine, 0);
        if (this.f249963d == null) {
            Notification notification = new Notification();
            this.f249963d = notification;
            notification.priority = 2;
            notification.flags |= 32;
            notification.contentView = this.f249966g;
        }
        if (i3 == 1008) {
            this.f249963d.flags = 16;
        } else {
            this.f249963d.flags = 32;
        }
        intent.putExtra(QQNotificationManager.PARAM_NOTIFYID, 481);
        PendingIntent activity = PendingIntent.getActivity(BaseApplication.getContext(), 481, intent, 201326592);
        if (BaseApplication.qqWifiNoSignal == i16) {
            this.f249963d.icon = BaseApplication.qqwifinotifynoneicon;
        } else if (BaseApplication.qqWifiUserful == i16) {
            this.f249963d.icon = BaseApplication.qqwifinotifyusefulicon;
        } else if (BaseApplication.qqWifiConnecticon3 == i16) {
            this.f249963d.icon = BaseApplication.qqwifinotifyconnectedicon;
        } else {
            this.f249963d.icon = i16;
        }
        if (str3 != null) {
            Notification notification2 = this.f249963d;
            notification2.defaults = 1;
            notification2.tickerText = str3;
        } else {
            Notification notification3 = this.f249963d;
            notification3.defaults = 0;
            notification3.tickerText = str4;
        }
        Notification notification4 = this.f249963d;
        notification4.contentIntent = activity;
        QQNotificationManager.addChannelIfNeed(notification4, QQNotificationManager.CHANNEL_ID_OTHER);
        qQNotificationManager.notify(f249957x, 481, this.f249963d);
        if (QLog.isColorLevel()) {
            QLog.d(f249957x, 2, "type=" + i3 + "," + str + ", " + str2 + "," + str3);
        }
    }

    private <T> boolean a(List<T> list, List<T> list2) {
        if (list != null && list2 != null && list.size() > 0) {
            Iterator<T> it = list2.iterator();
            int i3 = 0;
            while (it.hasNext() && list.contains(it.next())) {
                i3++;
            }
            if (i3 == list2.size()) {
                return true;
            }
        }
        return false;
    }

    public String a(File file) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this, (Object) file);
        }
        BufferedReader bufferedReader = null;
        if (file == null || !file.exists()) {
            return null;
        }
        String str = "";
        try {
            try {
                try {
                    StringBuilder sb5 = new StringBuilder();
                    BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
                    while (true) {
                        try {
                            String readLine = bufferedReader2.readLine();
                            if (readLine == null) {
                                break;
                            }
                            sb5.append(readLine);
                        } catch (FileNotFoundException e16) {
                            e = e16;
                            bufferedReader = bufferedReader2;
                            e.printStackTrace();
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            return str;
                        } catch (IOException e17) {
                            e = e17;
                            bufferedReader = bufferedReader2;
                            e.printStackTrace();
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            return str;
                        } catch (Throwable th5) {
                            th = th5;
                            bufferedReader = bufferedReader2;
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e18) {
                                    e18.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    }
                    str = sb5.toString();
                    bufferedReader2.close();
                    bufferedReader2.close();
                } catch (FileNotFoundException e19) {
                    e = e19;
                } catch (IOException e26) {
                    e = e26;
                }
            } catch (IOException e27) {
                e27.printStackTrace();
            }
            return str;
        } catch (Throwable th6) {
            th = th6;
        }
    }

    private void a(int i3, Bundle bundle) {
        SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences(this.f249962c.f249989c, 4);
        if (i3 == 1) {
            sharedPreferences.edit().putInt("showQQWiFiNotifyCount", sharedPreferences.getInt("showQQWiFiNotifyCount", 0) + 1).commit();
        } else if (i3 == 2) {
            sharedPreferences.edit().putInt("QQWiFiShowRedTouch", bundle.getInt("id")).commit();
        } else {
            if (i3 != 3) {
                return;
            }
            sharedPreferences.edit().putInt("showQQWiFiAvailExtend", sharedPreferences.getInt("showQQWiFiAvailExtend", 0) + 1).commit();
        }
    }

    public void a(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, z16);
            return;
        }
        this.f249980u = z16;
        if (z16) {
            QQNotificationManager.getInstance().cancel(f249957x, 481);
        }
    }

    private static boolean a(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.isConnected()) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    private String a(Context context, boolean z16) {
        if (TextUtils.isEmpty(this.f249962c.f250004r)) {
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.e(f249957x, 2, "getNotNetworkSupportSsidList mControlConfig.noNetSupport is empty");
            return null;
        }
        SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences("no_network_support_qqwifi", 4);
        StringBuffer stringBuffer = new StringBuffer();
        try {
            JSONArray jSONArray = new JSONArray(this.f249962c.f250004r);
            int length = jSONArray.length();
            int i3 = 0;
            while (true) {
                boolean z17 = true;
                if (i3 >= length) {
                    break;
                }
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                if (jSONObject != null && (!z16 || jSONObject.optInt("canPush") == 1)) {
                    JSONArray optJSONArray = jSONObject.optJSONArray(HttpMsg.FILE_JAR);
                    int length2 = optJSONArray.length();
                    int i16 = 0;
                    while (true) {
                        if (i16 >= length2) {
                            z17 = false;
                            break;
                        }
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i16);
                        String optString = optJSONObject.optString("pkgid");
                        int optInt = optJSONObject.optInt("limitVersion");
                        if (sharedPreferences.contains(optString) && sharedPreferences.getInt(optString, 0) > optInt) {
                            break;
                        }
                        i16++;
                    }
                    if (z17) {
                        stringBuffer.append(jSONObject.optString(TPDownloadProxyEnum.USER_SSID));
                        stringBuffer.append("|");
                    }
                }
                i3++;
            }
            if (stringBuffer.length() > 0) {
                stringBuffer.delete(stringBuffer.length() - 1, stringBuffer.length());
            }
        } catch (Exception unused) {
        }
        return stringBuffer.toString();
    }
}
