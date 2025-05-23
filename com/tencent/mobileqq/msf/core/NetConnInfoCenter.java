package com.tencent.mobileqq.msf.core;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.IBinder;
import android.os.SystemClock;
import androidx.core.app.NotificationCompat;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes15.dex */
public class NetConnInfoCenter extends BroadcastReceiver {
    static IPatchRedirector $redirector_ = null;
    public static final String ACTION_FILTER_MSF_NET_CHANGE = "com.tencent.mobileqq.msf.bd.netchange";
    public static byte[] GUID = null;
    public static String RDMREPORT_INTENT = "com.tencent.mobileqq.rdm.report";
    public static final String TAG = "NetConnInfoCenter";
    private static String gateWayIp = "";
    public static boolean isUseNewImpl = true;
    public static MsfCore msfCore = null;
    public static boolean needWifiAuth = false;
    private static final AtomicBoolean netSupport;
    public static int sAppTimeoutConfig = 2000;
    private static boolean sHasBooted = false;
    private static long sMSFServiceInitTimeStamp;
    private static long sMSFServiceReadyTimeStamp;
    public static NetConnInfoCenter sNetConnIfnoCenter;
    public static long servetTimeSecondInterv;
    public static volatile int socketConnState;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements Runnable {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            int i16 = Build.VERSION.SDK_INT;
            if (i16 >= 24 && (i3 = BaseApplication.getContext().getApplicationInfo().targetSdkVersion) >= 24) {
                BaseApplication.getContext().registerReceiver(NetConnInfoCenter.sNetConnIfnoCenter, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                if (i16 >= 26 && i3 >= 26) {
                    BaseApplication.getContext().registerReceiver(NetConnInfoCenter.sNetConnIfnoCenter, new IntentFilter("android.net.wifi.WIFI_STATE_CHANGED"));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class b implements ServiceConnection {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) componentName, (Object) iBinder);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) componentName);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class c implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ NetworkInfo f247306a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f247307b;

        c(NetworkInfo networkInfo, Context context) {
            this.f247306a = networkInfo;
            this.f247307b = context;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, NetConnInfoCenter.this, networkInfo, context);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            try {
                if (QLog.isColorLevel()) {
                    QLog.i(NetConnInfoCenter.TAG, 2, "onReceive CONNECTIVITY_CHANGE, networkInfo: " + this.f247306a);
                }
                Intent intent = new Intent();
                intent.setAction("com.tencent.mobileqq.msf.bd.netchange");
                intent.setPackage(BaseApplication.getContext().getPackageName());
                intent.putExtra("networkInfo", this.f247306a);
                this.f247307b.sendBroadcast(intent);
                NetConnInfoCenter.checkConnInfo(this.f247307b, this.f247306a, true);
            } catch (Exception e16) {
                QLog.d(NetConnInfoCenter.TAG, 1, e16.toString(), e16);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23007);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        GUID = new byte[0];
        netSupport = new AtomicBoolean(false);
        sNetConnIfnoCenter = new NetConnInfoCenter();
    }

    public NetConnInfoCenter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void callQQProcess(String str) {
        int i3;
        try {
            if (com.tencent.mobileqq.msf.core.push.h.f249716l0) {
                long o16 = com.tencent.mobileqq.msf.core.x.b.o();
                Intent intent = new Intent(str);
                String str2 = com.tencent.mobileqq.msf.core.push.h.f249717m0;
                MsfCore msfCore2 = msfCore;
                if (msfCore2 != null) {
                    i3 = msfCore2.getUinPushStatus(str2);
                } else {
                    i3 = 0;
                }
                intent.putExtra("uin", str2);
                intent.putExtra("istatus", i3);
                intent.putExtra("gatewayip", msfCore.getGatewayIp());
                intent.setPackage(BaseApplication.getContext().getPackageName());
                if (o16 > 0) {
                    QLog.d(TAG, 1, "send bootAction for QQ " + MsfSdkUtils.getShortUin(str2) + " delayed: " + o16);
                    ((AlarmManager) BaseApplication.getContext().getSystemService(NotificationCompat.CATEGORY_ALARM)).set(0, System.currentTimeMillis() + com.tencent.mobileqq.msf.core.x.b.o(), PendingIntent.getBroadcast(BaseApplication.getContext(), 0, intent, 201326592));
                } else {
                    BaseApplication.getContext().sendBroadcast(intent);
                    QLog.d(TAG, 1, "send bootAction for QQ " + MsfSdkUtils.getShortUin(str2) + " right now");
                }
                com.tencent.mobileqq.msf.core.push.h.f249716l0 = false;
                return;
            }
            QLog.d(TAG, 1, "not need send bootAction for QQ");
        } catch (Exception e16) {
            QLog.d(TAG, 1, "send bootAction for QQ error " + e16);
        }
    }

    public static void checkConnInfo() {
        r.l().a(BaseApplication.getContext(), null, false);
    }

    public static void checkRecordTime() {
        r.l().h();
    }

    public static int getActiveNetIpFamily(boolean z16) {
        return r.l().a(z16);
    }

    public static int getActiveNetworkType() {
        return r.l().m();
    }

    public static int getCdmaStrength() {
        return r.l().n();
    }

    public static String getCurrentAPN() {
        return r.l().o();
    }

    public static String getCurrentSSID() {
        return r.l().p();
    }

    public static String getGateWayIp() {
        return gateWayIp;
    }

    public static int getGsmStrength() {
        return r.l().q();
    }

    public static String getLastWifiSSID() {
        return r.l().r();
    }

    public static long getMSFServiceInitTime() {
        return sMSFServiceInitTimeStamp;
    }

    public static long getMSFServiceReadyTime() {
        return sMSFServiceReadyTimeStamp;
    }

    public static int getMobileNetworkType() {
        return r.l().s();
    }

    public static NetworkInfo getRecentNetworkInfo() {
        return r.l().u();
    }

    public static long getServerTime() {
        return (System.currentTimeMillis() / 1000) + servetTimeSecondInterv;
    }

    public static long getServerTimeMillis() {
        return System.currentTimeMillis() + (servetTimeSecondInterv * 1000);
    }

    public static String getSignalStrengthsLog() {
        return " SignalStrengths wifi:" + getWifiStrength() + " gsm:" + getGsmStrength() + " cdma:" + getCdmaStrength() + " net:" + getSystemNetworkType();
    }

    public static int getSystemNetState() {
        return r.l().v();
    }

    public static String getSystemNetStateString() {
        return com.tencent.mobileqq.msf.sdk.q.a.a(getSystemNetState());
    }

    public static int getSystemNetworkType() {
        return r.l().w();
    }

    public static int getWifiStrength() {
        return r.l().x();
    }

    public static void handleGetServerTimeDiff(int i3) {
        r.l().b(i3);
    }

    public static void handleGetServerTimeResp(long j3) {
        r.l().a(j3);
    }

    private void handleNetWorkChangeBroadcast(Context context, NetworkInfo networkInfo) {
        q.o().post(new c(networkInfo, context));
    }

    public static void handleServerTimeFromOnlineRegister(ToServiceMsg toServiceMsg) {
        r.l().a(toServiceMsg);
    }

    public static void init(MsfCore msfCore2) {
        msfCore = msfCore2;
        r.l().y();
        q.s().post(new a());
    }

    public static InetAddress intToInetAddress(int i3) {
        try {
            return InetAddress.getByAddress(new byte[]{(byte) (i3 & 255), (byte) ((i3 >> 8) & 255), (byte) ((i3 >> 16) & 255), (byte) ((i3 >> 24) & 255)});
        } catch (UnknownHostException unused) {
            throw new AssertionError();
        }
    }

    public static boolean isMobileConn() {
        return r.l().z();
    }

    public static boolean isMobileNetworkInfo(NetworkInfo networkInfo) {
        if (NetworkMonitor.getType(networkInfo) != 0 && 50 != NetworkMonitor.getType(networkInfo)) {
            return false;
        }
        return true;
    }

    public static boolean isNeedWifiAuth() {
        return needWifiAuth;
    }

    public static boolean isNetSupport() {
        return netSupport.get();
    }

    public static boolean isWifiConn() {
        return r.l().B();
    }

    public static boolean isWifiOrMobileConn() {
        return r.l().C();
    }

    public static void onConnClosed(com.tencent.qphone.base.a aVar) {
        r.l().a(aVar);
    }

    public static void onConnOpened() {
        r.l().D();
    }

    public static void onOepnConnAllFailed() {
        r.l().F();
    }

    public static void onRecvFirstResp() {
        r.l().G();
    }

    public static void onRegProxySvcRsp() {
        r.l().H();
    }

    public static void onRegProxySvcSend() {
        r.l().I();
    }

    public static void onStartConnect() {
        r.l().J();
    }

    public static void setGateWayIp(String str) {
        gateWayIp = str;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "setGateWayIp, GatewayIp:" + str);
            return;
        }
        QLog.d(TAG, 1, "setGateWayIp, GatewayIp=" + com.tencent.mobileqq.msf.core.z.a.a(str));
    }

    public static void setLastConnSuccWithoutNet() {
        r.l().O();
    }

    public static void setMSFServiceInitTime(long j3) {
        sMSFServiceInitTimeStamp = j3;
    }

    public static void setMSFServiceReadyTime(long j3) {
        sMSFServiceReadyTimeStamp = j3;
    }

    public static void setNeedWifiAuth(boolean z16) {
        needWifiAuth = z16;
    }

    public static void setNetSupport(boolean z16) {
        netSupport.set(z16);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "setNetSupport " + z16);
        }
    }

    public static void startOrBindService(Intent intent) {
        try {
            BaseApplication.getContext().startService(intent);
        } catch (Exception e16) {
            QLog.d(TAG, 1, "init msf startService exception:", e16);
            try {
                BaseApplication.getContext().bindService(intent, new b(), 1);
            } catch (Exception e17) {
                QLog.d(TAG, 1, "init msf bindService exception:", e17);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00f8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onReceive(Context context, Intent intent) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) intent);
            return;
        }
        if (intent == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "receive broadcast intent == null return");
                return;
            }
            return;
        }
        QLog.dAsync(TAG, 1, "receive broadcast " + intent + ", init = " + MsfService.inited);
        if (intent.getAction() == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "receive broadcast intent.getAction() == null return");
                return;
            }
            return;
        }
        if (intent.getAction().equals(com.tencent.mobileqq.msf.core.push.h.f249727w0)) {
            msfCore.pushManager.v();
            return;
        }
        if (intent.getAction().equals(com.tencent.mobileqq.msf.core.push.h.f249728x0)) {
            msfCore.pushManager.w();
            return;
        }
        if (intent.getAction().equals(com.tencent.mobileqq.msf.core.push.h.E0)) {
            msfCore.pushManager.s();
            return;
        }
        if (intent.getAction().equals(com.tencent.mobileqq.msf.core.push.h.F0)) {
            msfCore.pushManager.x();
            return;
        }
        if (!sHasBooted) {
            sHasBooted = true;
            if (SystemClock.elapsedRealtime() < MiniBoxNoticeInfo.MIN_5 || "android.intent.action.MY_PACKAGE_REPLACED".equals(intent.getAction())) {
                z16 = true;
                if (!MsfService.inited && p.a()) {
                    MsfService.sIsCreatedByAutoBoot = z16;
                    Intent intent2 = new Intent(context, (Class<?>) MsfService.class);
                    intent2.putExtra(com.tencent.mobileqq.msf.service.j.Q, intent.getAction());
                    startOrBindService(intent2);
                }
                if (!intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                    try {
                        handleNetWorkChangeBroadcast(context, (NetworkInfo) intent.getParcelableExtra("networkInfo"));
                        return;
                    } catch (Exception e16) {
                        QLog.d(TAG, 1, e16.toString(), e16);
                        return;
                    }
                }
                if (!intent.getAction().equals("android.intent.action.TIME_SET") && !intent.getAction().equals("android.intent.action.TIMEZONE_CHANGED")) {
                    if (z16) {
                        com.tencent.mobileqq.msf.core.x.b.a(true);
                        com.tencent.mobileqq.msf.core.c0.j.f247804g1 = true;
                        if (QLog.isColorLevel()) {
                            QLog.d(TAG, 2, "set StatReporter.needReportBooting true");
                            return;
                        }
                        return;
                    }
                    if (intent.getAction().equals(RDMREPORT_INTENT)) {
                        if (QLog.isColorLevel()) {
                            QLog.d(TAG, 2, "receive reportRDM call");
                            return;
                        }
                        return;
                    } else {
                        if ("android.net.wifi.WIFI_STATE_CHANGED".equals(intent.getAction()) && QLog.isColorLevel()) {
                            QLog.i(TAG, 2, "receive WIFI_STATE_CHANGED_ACTION");
                            return;
                        }
                        return;
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "recv broadcast " + intent.getAction());
                }
                r.l().i();
                return;
            }
        }
        z16 = false;
        if (!MsfService.inited) {
            MsfService.sIsCreatedByAutoBoot = z16;
            Intent intent22 = new Intent(context, (Class<?>) MsfService.class);
            intent22.putExtra(com.tencent.mobileqq.msf.service.j.Q, intent.getAction());
            startOrBindService(intent22);
        }
        if (!intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
        }
    }

    public static void checkConnInfo(Context context, boolean z16) {
        r.l().a(context, null, z16);
    }

    public static String getCurrentAPN(boolean z16) {
        return r.l().b(z16);
    }

    public static String getCurrentSSID(boolean z16) {
        return r.l().c(z16);
    }

    public static void onRecvFirstResp(String str) {
        r.l().a(str);
    }

    public static void checkConnInfo(Context context, NetworkInfo networkInfo, boolean z16) {
        r.l().a(context, networkInfo, z16);
    }
}
