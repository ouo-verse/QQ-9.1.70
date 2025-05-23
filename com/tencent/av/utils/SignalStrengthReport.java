package com.tencent.av.utils;

import android.content.Context;
import android.net.DhcpInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qmethod.pandoraex.monitor.LocationMonitor;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.qmethod.pandoraex.monitor.RuntimeMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.net.URI;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class SignalStrengthReport {

    /* renamed from: n, reason: collision with root package name */
    static volatile SignalStrengthReport f76810n;

    /* renamed from: a, reason: collision with root package name */
    WeakReference<Context> f76811a;

    /* renamed from: b, reason: collision with root package name */
    b f76812b;

    /* renamed from: c, reason: collision with root package name */
    WifiManager f76813c;

    /* renamed from: d, reason: collision with root package name */
    TelephonyManager f76814d;

    /* renamed from: f, reason: collision with root package name */
    HandlerThread f76816f;

    /* renamed from: g, reason: collision with root package name */
    Handler f76817g;

    /* renamed from: e, reason: collision with root package name */
    int f76815e = -1;

    /* renamed from: h, reason: collision with root package name */
    int f76818h = 0;

    /* renamed from: i, reason: collision with root package name */
    int f76819i = 0;

    /* renamed from: j, reason: collision with root package name */
    int f76820j = -1;

    /* renamed from: k, reason: collision with root package name */
    String f76821k = "";

    /* renamed from: l, reason: collision with root package name */
    Runnable f76822l = new Runnable() { // from class: com.tencent.av.utils.SignalStrengthReport.1
        @Override // java.lang.Runnable
        public void run() {
            int h16;
            int g16;
            int i3;
            int b16 = SignalStrengthReport.b();
            int i16 = 0;
            if (b16 == 0) {
                h16 = 0;
            } else {
                SignalStrengthReport signalStrengthReport = SignalStrengthReport.this;
                if (b16 == 1) {
                    h16 = signalStrengthReport.m();
                } else {
                    h16 = signalStrengthReport.h();
                }
            }
            if (b16 == 0) {
                g16 = 0;
            } else {
                SignalStrengthReport signalStrengthReport2 = SignalStrengthReport.this;
                if (b16 == 1) {
                    g16 = signalStrengthReport2.l();
                } else {
                    g16 = signalStrengthReport2.g();
                }
            }
            if (g16 == -1) {
                g16 = 0;
            }
            int abs = Math.abs(g16);
            if (b16 == 1) {
                i3 = SignalStrengthReport.this.f76818h;
            } else {
                i3 = 0;
            }
            if (b16 != 0) {
                i16 = h16;
            }
            com.tencent.av.r.h0().V2(b16, i16, i3);
            SignalStrengthReport.this.f76821k = "networkType:" + b16 + " signalStrength:" + i16 + " pingResult:" + i3;
            if (QLog.isColorLevel()) {
                QLog.d("SignalStrengthReport", 2, "setGatewayTestResult networkType:" + b16 + " | levelPercent:" + h16 + " | dbm:" + abs + "| pingResult:" + SignalStrengthReport.this.f76818h);
            }
            Handler handler = SignalStrengthReport.this.f76817g;
            if (handler != null) {
                handler.postDelayed(this, 2000L);
            }
        }
    };

    /* renamed from: m, reason: collision with root package name */
    Runnable f76823m = new Runnable() { // from class: com.tencent.av.utils.SignalStrengthReport.2
        @Override // java.lang.Runnable
        public void run() {
            SignalStrengthReport signalStrengthReport = SignalStrengthReport.this;
            signalStrengthReport.f76818h = 0;
            if (signalStrengthReport.f76815e != -1) {
                if (SignalStrengthReport.b() == 1) {
                    try {
                        String d16 = SignalStrengthReport.this.d();
                        SignalStrengthReport.this.f76818h = a.b("http://" + d16);
                        SignalStrengthReport signalStrengthReport2 = SignalStrengthReport.this;
                        if (signalStrengthReport2.f76818h < 0) {
                            signalStrengthReport2.f76818h = 0;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("SignalStrengthReport", 2, "mPingTask gatewayIP:" + d16 + " | avgRtt:" + SignalStrengthReport.this.f76818h);
                        }
                    } catch (Exception e16) {
                        AVCoreLog.printColorLog("SignalStrengthReport", "mPingTask e:" + e16);
                    }
                }
                Handler handler = SignalStrengthReport.this.f76817g;
                if (handler != null) {
                    handler.postDelayed(this, r0.f76815e);
                }
            }
        }
    };

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class a {
        private static String a(int i3, int i16, String str) {
            return "/system/bin/ping -c " + i3 + " -w " + i16 + " " + str;
        }

        public static int b(String str) {
            return c(str, 1, 1000);
        }

        public static int c(String str, int i3, int i16) {
            String e16;
            String d16 = d(str);
            if (d16 != null && (e16 = e(a(i3, i16, d16))) != null) {
                try {
                    return Math.round(Float.valueOf(e16.substring(e16.indexOf("min/avg/max/mdev") + 19).split("/")[1]).floatValue());
                } catch (Exception e17) {
                    AVCoreLog.printColorLog("SignalStrengthReport", "getAvgRTT e:" + e17);
                }
            }
            return -1;
        }

        private static String d(String str) {
            try {
                return URI.create(str).getHost();
            } catch (Exception e16) {
                AVCoreLog.printColorLog("SignalStrengthReport", "getDomain e:" + e16);
                return null;
            }
        }

        private static String e(String str) {
            Process process;
            try {
                process = RuntimeMonitor.exec(Runtime.getRuntime(), str);
            } catch (Throwable th5) {
                th = th5;
                process = null;
            }
            try {
                InputStream inputStream = process.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder sb5 = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        sb5.append(readLine);
                        sb5.append("\n");
                    } else {
                        bufferedReader.close();
                        inputStream.close();
                        String sb6 = sb5.toString();
                        process.destroy();
                        return sb6;
                    }
                }
            } catch (Throwable th6) {
                th = th6;
                try {
                    AVCoreLog.printColorLog("SignalStrengthReport", "ping e:" + th);
                    return null;
                } finally {
                    if (process != null) {
                        process.destroy();
                    }
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class b extends PhoneStateListener {
        b() {
        }

        @Override // android.telephony.PhoneStateListener
        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            super.onSignalStrengthsChanged(signalStrength);
            SignalStrengthReport signalStrengthReport = SignalStrengthReport.this;
            signalStrengthReport.f76819i = signalStrengthReport.f(signalStrength);
            SignalStrengthReport signalStrengthReport2 = SignalStrengthReport.this;
            signalStrengthReport2.f76820j = signalStrengthReport2.c(signalStrength);
        }
    }

    SignalStrengthReport(Context context) {
        this.f76811a = new WeakReference<>(context);
        if (Looper.myLooper() != null) {
            this.f76812b = new b();
        }
        if (context != null) {
            this.f76813c = (WifiManager) context.getSystemService("wifi");
            this.f76814d = (TelephonyManager) context.getSystemService("phone");
        }
    }

    static /* bridge */ /* synthetic */ int b() {
        return i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String d() {
        DhcpInfo dhcpInfo;
        try {
            WifiManager wifiManager = this.f76813c;
            if (wifiManager == null || (dhcpInfo = NetworkMonitor.getDhcpInfo(wifiManager)) == null) {
                return "";
            }
            return n(dhcpInfo.gateway);
        } catch (Exception e16) {
            AVCoreLog.printColorLog("SignalStrengthReport", "getGateway e:" + e16);
            return "";
        }
    }

    public static SignalStrengthReport e(Context context) {
        if (f76810n == null) {
            synchronized (SignalStrengthReport.class) {
                if (f76810n == null) {
                    f76810n = new SignalStrengthReport(context);
                }
            }
        }
        return f76810n;
    }

    private static int i() {
        if (AppNetConnInfo.isWifiConn()) {
            return 1;
        }
        if (AppNetConnInfo.isMobileConn()) {
            int mobileInfo = AppNetConnInfo.getMobileInfo();
            int i3 = 2;
            if (mobileInfo != 1) {
                if (mobileInfo == 2) {
                    return 3;
                }
                i3 = 4;
                if (mobileInfo != 3) {
                    if (mobileInfo == 4) {
                        return 5;
                    }
                }
            }
            return i3;
        }
        return 0;
    }

    private int j() {
        try {
            WeakReference<Context> weakReference = this.f76811a;
            if (weakReference == null || weakReference.get() == null) {
                return -1;
            }
            String f16 = af.f(218, af.f76962q);
            if (TextUtils.isEmpty(f16)) {
                return -1;
            }
            AVCoreLog.printColorLog("SignalStrengthReport", "getPingInterval config:" + f16);
            JSONObject jSONObject = new JSONObject(f16);
            if (!jSONObject.has("pingInterval")) {
                return -1;
            }
            int i3 = jSONObject.getInt("pingInterval");
            if (i3 >= 0 && i3 < 2000) {
                return 2000;
            }
            return i3;
        } catch (Exception e16) {
            AVCoreLog.printColorLog("SignalStrengthReport", "getPingInterval e:" + e16);
            return -1;
        }
    }

    private String n(long j3) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(String.valueOf((int) (j3 & 255)));
        stringBuffer.append('.');
        stringBuffer.append(String.valueOf((int) ((j3 >> 8) & 255)));
        stringBuffer.append('.');
        stringBuffer.append(String.valueOf((int) ((j3 >> 16) & 255)));
        stringBuffer.append('.');
        stringBuffer.append(String.valueOf((int) ((j3 >> 24) & 255)));
        return stringBuffer.toString();
    }

    int c(SignalStrength signalStrength) {
        int i3;
        if (signalStrength == null) {
            return -1;
        }
        try {
            i3 = Integer.parseInt(Class.forName(SignalStrength.class.getName()).getDeclaredMethod("getDbm", new Class[0]).invoke(signalStrength, new Object[0]).toString());
        } catch (Exception e16) {
            AVCoreLog.printColorLog("SignalStrengthReport", "getDbmBySignalStrength reflect getDbm e1:" + e16);
            i3 = -1;
        }
        if (i3 == -1) {
            try {
                if (signalStrength.isGsm()) {
                    int gsmSignalStrength = signalStrength.getGsmSignalStrength();
                    if (gsmSignalStrength == 99) {
                        gsmSignalStrength = -1;
                    }
                    if (gsmSignalStrength == -1) {
                        return -1;
                    }
                    return (gsmSignalStrength * 2) - 113;
                }
                i3 = signalStrength.getCdmaDbm();
                int evdoDbm = signalStrength.getEvdoDbm();
                if (evdoDbm != -120) {
                    if (i3 == -120) {
                        i3 = evdoDbm;
                    } else {
                        i3 = Math.min(i3, evdoDbm);
                    }
                }
            } catch (Exception e17) {
                AVCoreLog.printColorLog("SignalStrengthReport", "getDbmBySignalStrength e2:" + e17);
                return -1;
            }
        }
        return i3;
    }

    int f(SignalStrength signalStrength) {
        if (signalStrength == null) {
            return 0;
        }
        try {
            int parseInt = Integer.parseInt(Class.forName(SignalStrength.class.getName()).getDeclaredMethod("getLevel", new Class[0]).invoke(signalStrength, new Object[0]).toString()) * 25;
            if (parseInt > 100) {
                return 100;
            }
            return parseInt;
        } catch (Exception e16) {
            AVCoreLog.printColorLog("SignalStrengthReport", "getLevelPercentBySignalStrength reflect getLevel e:" + e16);
            return 0;
        }
    }

    int g() {
        return this.f76820j;
    }

    int h() {
        return this.f76819i;
    }

    public String k() {
        return this.f76821k;
    }

    int l() {
        WifiInfo connectionInfo;
        try {
            WifiManager wifiManager = this.f76813c;
            if (wifiManager == null || (connectionInfo = LocationMonitor.getConnectionInfo(wifiManager)) == null || NetworkMonitor.getBSSID(connectionInfo) == null) {
                return -1;
            }
            return connectionInfo.getRssi();
        } catch (Exception e16) {
            AVCoreLog.printColorLog("SignalStrengthReport", "getWifiDbm e:" + e16);
            return -1;
        }
    }

    int m() {
        try {
            WifiManager wifiManager = this.f76813c;
            if (wifiManager == null) {
                return 0;
            }
            WifiInfo connectionInfo = LocationMonitor.getConnectionInfo(wifiManager);
            if (NetworkMonitor.getBSSID(connectionInfo) == null) {
                return 0;
            }
            int calculateSignalLevel = WifiManager.calculateSignalLevel(connectionInfo.getRssi(), 5) * 25;
            if (calculateSignalLevel > 100) {
                return 100;
            }
            return calculateSignalLevel;
        } catch (Exception e16) {
            AVCoreLog.printColorLog("SignalStrengthReport", "getWifiLevelPercent e:" + e16);
            return 0;
        }
    }

    public void o() {
        TelephonyManager telephonyManager;
        HandlerThread handlerThread = this.f76816f;
        if (handlerThread != null && handlerThread.isAlive()) {
            return;
        }
        AVCoreLog.printColorLog("SignalStrengthReport", "report start");
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("SignalStrengthReportThread" + ((int) (Math.random() * 100.0d)));
        this.f76816f = baseHandlerThread;
        baseHandlerThread.start();
        this.f76817g = new Handler(this.f76816f.getLooper());
        this.f76815e = j();
        this.f76821k = "";
        Runnable runnable = this.f76822l;
        if (runnable != null) {
            this.f76817g.post(runnable);
        }
        Runnable runnable2 = this.f76823m;
        if (runnable2 != null) {
            this.f76817g.post(runnable2);
        }
        b bVar = this.f76812b;
        if (bVar != null && (telephonyManager = this.f76814d) != null) {
            LocationMonitor.listen(telephonyManager, bVar, 256);
        }
    }

    public void p() {
        TelephonyManager telephonyManager;
        Handler handler = this.f76817g;
        if (handler != null) {
            Runnable runnable = this.f76822l;
            if (runnable != null) {
                handler.removeCallbacks(runnable);
            }
            Runnable runnable2 = this.f76823m;
            if (runnable2 != null) {
                this.f76817g.removeCallbacks(runnable2);
            }
            this.f76817g = null;
        }
        this.f76815e = -1;
        b bVar = this.f76812b;
        if (bVar != null && (telephonyManager = this.f76814d) != null) {
            LocationMonitor.listen(telephonyManager, bVar, 0);
        }
        HandlerThread handlerThread = this.f76816f;
        if (handlerThread != null) {
            handlerThread.quit();
            this.f76816f = null;
        }
        this.f76821k = "";
        AVCoreLog.printColorLog("SignalStrengthReport", "report stop");
    }
}
