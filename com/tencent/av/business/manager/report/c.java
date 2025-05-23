package com.tencent.av.business.manager.report;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.n;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.statistics.DcReportUtil;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.utils.m;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.proxy.dlg.location.QbAddrData;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static VideoAppInterface f73436a;

    /* renamed from: c, reason: collision with root package name */
    private static String f73438c;

    /* renamed from: d, reason: collision with root package name */
    private static Handler f73439d;

    /* renamed from: b, reason: collision with root package name */
    private static Map<String, String> f73437b = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    private static Handler.Callback f73440e = new a();

    /* renamed from: f, reason: collision with root package name */
    public static int f73441f = 0;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a implements Handler.Callback {
        a() {
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x0115, code lost:
        
            if (com.tencent.av.business.manager.report.c.f73437b.size() != 0) goto L25;
         */
        /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0026. Please report as an issue. */
        @Override // android.os.Handler.Callback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean handleMessage(Message message) {
            Bundle data = message.getData();
            switch (message.what) {
                case 1:
                    if (c.f73439d != null) {
                        c.B();
                        c.A(24, c.k());
                        try {
                            c.f73439d.sendEmptyMessageDelayed(1, 5000L);
                        } catch (NullPointerException e16) {
                            e16.printStackTrace();
                        }
                    }
                    return false;
                case 2:
                    long j3 = data.getLong("roomId");
                    int i3 = data.getInt("node");
                    long j16 = data.getLong("value");
                    boolean z16 = data.getBoolean("isNode");
                    c.h(i3, false);
                    if (c.j(i3, false, z16)) {
                        return false;
                    }
                    if (z16 && c.x(33, false)) {
                        AVCoreLog.printInfoLog("VideoNodeManager", "--> THE node_session_close has write !!  this node  be rejected !!   node = " + b.a(i3));
                        return false;
                    }
                    if (c.w(i3)) {
                        AVCoreLog.printDebugLog("VideoNodeManager", "reportToHandler  roomId = " + j3 + "  node = " + b.a(i3) + ",  value = " + j16 + "   isNode = " + z16);
                    }
                    c.J(i3 + "", j16 + "", z16);
                    c.i(i3, j16, false);
                    return false;
                case 3:
                    String c16 = c.c();
                    if (!TextUtils.isEmpty(c16)) {
                        AVCoreLog.printDebugLog("VideoNodeManager", "--> handleMessage() what = MSG_REPORT_TO_SERVER detail = " + c16);
                        DcReportUtil.b(null, "dc03209", c16);
                        c.G();
                    }
                    if (c.f73437b != null) {
                        break;
                    }
                    return false;
                case 4:
                    c.H();
                    return false;
                case 5:
                    String d16 = c.d();
                    AVCoreLog.printInfoLog("VideoNodeManager", "--> handleMessage() what = MSG_REPORT_TEMP_RECORD_TO_SERVER detail = " + d16);
                    if (!TextUtils.isEmpty(d16)) {
                        DcReportUtil.b(null, "dc03209", d16);
                        c.F();
                    }
                    return false;
                case 6:
                    long j17 = data.getLong("roomId");
                    int i16 = data.getInt("node");
                    long j18 = data.getLong("value");
                    boolean z17 = data.getBoolean("isNode");
                    c.h(i16, true);
                    if (c.j(i16, true, z17)) {
                        return false;
                    }
                    if (z17 && c.x(33, true)) {
                        AVCoreLog.printInfoLog("VideoNodeManager", "--> TempSeesion THE node_session_close has write !!  this node  be rejected !!   node = " + b.a(i16));
                        return false;
                    }
                    c.I(i16 + "", j18 + "", z17);
                    c.i(i16, j18, true);
                    AVCoreLog.printInfoLog("VideoNodeManager", "reportToTempSeesionRecord ,roomId = " + j17 + "  node = " + b.a(i16) + ", value = " + j18 + "   isNode = " + z17);
                    return false;
                default:
                    return false;
            }
        }
    }

    public static void A(int i3, long j3) {
        C(l(), i3, j3, false);
    }

    public static void B() {
        try {
            long X = (ah.X() / 1024) / 1024;
            long g16 = (ah.g(Process.myPid()) / 1024) / 1024;
            A(22, X);
            A(23, g16);
        } catch (Exception e16) {
            QLog.d("VideoNodeManager", 1, "reportMemoryStatus,Exception ", e16);
        }
    }

    private static synchronized void C(long j3, int i3, long j16, boolean z16) {
        synchronized (c.class) {
            VideoAppInterface videoAppInterface = f73436a;
            if (videoAppInterface == null) {
                QLog.e("VideoNodeManager", 1, "reportToHandler param is null  !!!!!!!!!-------------------");
                return;
            }
            boolean z17 = videoAppInterface.f73120h0;
            if (y() && u(i3)) {
                E(j3, i3, j16, z16);
            } else if (!v(j3)) {
                E(j3, i3, j16, z16);
                return;
            }
            D(j3, i3, j16, z16);
        }
    }

    private static void D(long j3, int i3, long j16, boolean z16) {
        Handler handler = f73439d;
        if (handler == null) {
            return;
        }
        Message obtainMessage = handler.obtainMessage();
        obtainMessage.what = 2;
        Bundle bundle = new Bundle();
        bundle.putLong("roomId", j3);
        bundle.putInt("node", i3);
        bundle.putLong("value", j16);
        bundle.putBoolean("isNode", z16);
        obtainMessage.setData(bundle);
        f73439d.sendMessage(obtainMessage);
    }

    private static void E(long j3, int i3, long j16, boolean z16) {
        Handler handler = f73439d;
        if (handler == null) {
            return;
        }
        Message obtainMessage = handler.obtainMessage();
        obtainMessage.what = 6;
        Bundle bundle = new Bundle();
        bundle.putLong("roomId", j3);
        bundle.putInt("node", i3);
        bundle.putLong("value", j16);
        bundle.putBoolean("isNode", z16);
        obtainMessage.setData(bundle);
        f73439d.sendMessage(obtainMessage);
    }

    public static void F() {
        QLog.e("VideoNodeManager", 1, "--> resetTempSeesionRecord() ----------------------------------------");
        f73437b.clear();
    }

    public static void G() {
        QLog.d("VideoNodeManager", 1, "--> resetVideoNode() ----------------------------------------");
        SharedPreferences.Editor edit = BaseApplicationImpl.getApplication().getSystemSharedPreferences(f73438c, 0).edit();
        edit.clear();
        edit.commit();
    }

    public static void H() {
        AVCoreLog.printInfoLog("VideoNodeManager", "=========> SYNC Start !!---------------------------  mTempSeesionRecord.size() = " + f73437b.size());
        if (y()) {
            G();
            if (f73437b.size() > 0) {
                SharedPreferences.Editor edit = BaseApplicationImpl.getApplication().getSystemSharedPreferences(f73438c, 0).edit();
                for (Map.Entry<String, String> entry : f73437b.entrySet()) {
                    AVCoreLog.printInfoLog("VideoNodeManager", "=========> SYNC Temp !!   node= " + b.a(Integer.valueOf(entry.getKey()).intValue()) + "     Value = " + entry.getValue());
                    edit.putString(entry.getKey(), entry.getValue());
                }
                edit.commit();
            }
        }
        AVCoreLog.printInfoLog("VideoNodeManager", "=========> SYNC end !!----------------------------------");
        F();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void I(String str, String str2, boolean z16) {
        f73437b.put(str, str2);
        if (z16) {
            f73437b.put("17", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void J(String str, String str2, boolean z16) {
        SharedPreferences.Editor edit = BaseApplicationImpl.getApplication().getSystemSharedPreferences(f73438c, 0).edit();
        edit.putString(str, str2);
        if (z16) {
            edit.putString("17", str + "");
        }
        edit.commit();
    }

    static /* bridge */ /* synthetic */ String c() {
        return q();
    }

    static /* bridge */ /* synthetic */ String d() {
        return r();
    }

    public static synchronized void h(int i3, boolean z16) {
        synchronized (c.class) {
            if (i3 != 0) {
                return;
            }
            if (!z16) {
                if (n() == 0) {
                    G();
                    AVCoreLog.printDebugLog("VideoNodeManager", "--> checkAndClearSession() ***********************************");
                }
            } else if (!y()) {
                F();
                AVCoreLog.printInfoLog("VideoNodeManager", "--> checkAndClearSession()  temp ***********************************");
            }
        }
    }

    public static void i(int i3, long j3, boolean z16) {
        int i16;
        if (i3 == 20) {
            f73441f = (int) j3;
            return;
        }
        if (i3 == 27 || i3 == 28 || i3 == 36 || i3 == 29 || i3 == 31 || i3 == 32 || i3 == 30) {
            if (SmallScreenUtils.p(BaseApplicationImpl.getApplication())) {
                i16 = 1;
            } else {
                i16 = 2;
            }
            if (i16 != f73441f) {
                f73441f = i16;
                AVCoreLog.printDebugLog("VideoNodeManager", "checkAppOnForeground()  isAppOnForeground change !!! = " + f73441f);
                if (!z16) {
                    J(i3 + "", f73441f + "", false);
                    return;
                }
                I(i3 + "", f73441f + "", false);
            }
        }
    }

    public static boolean j(int i3, boolean z16, boolean z17) {
        if ((z17 || i3 == 0) && i3 != 31 && i3 != 32) {
            if (!z16) {
                if (z(i3 + "") != null) {
                    AVCoreLog.printInfoLog("VideoNodeManager", "--> checkNodeHasWrite() the node is has writh !!!!!!!!!!!!!!!!!!!!!!!!! node = " + b.a(i3));
                    return true;
                }
            }
            if (z16) {
                if (f73437b.get(i3 + "") != null) {
                    AVCoreLog.printInfoLog("VideoNodeManager", "--> checkNodeHasWrite() temp ,the node is has writh !!!!!!!!!!!!!!!!!!!!!!!!! node = " + b.a(i3));
                    return true;
                }
            }
        }
        return false;
    }

    public static long k() {
        if (n.e().f().f73100y0 == 0) {
            return 0L;
        }
        return ((SystemClock.elapsedRealtime() - n.e().f().f73100y0) / 1000) + n.e().f().f73104z0;
    }

    public static long l() {
        SessionInfo f16 = n.e().f();
        if (f16 == null) {
            return 0L;
        }
        return f16.b();
    }

    private static int m(Map<String, ?> map) {
        return (int) ((((float) Long.valueOf(t("22", "0", map)).longValue()) / ((float) s())) * 100.0f);
    }

    private static int n() {
        String z16 = z("0");
        if (z16 != null && !z16.equals("0")) {
            return 1;
        }
        return 0;
    }

    private static String o() {
        VideoAppInterface videoAppInterface = f73436a;
        if (videoAppInterface != null && videoAppInterface.getCurrentAccountUin() != null) {
            return f73436a.getCurrentAccountUin();
        }
        return "0";
    }

    private static String p(Map<String, ?> map) {
        if (map == null || map.size() == 0) {
            return null;
        }
        if ((DeviceInfoMonitor.getModel() != null && "Android SDK built for x86".equals(DeviceInfoMonitor.getModel())) || !t("15", "0", map).equals("1")) {
            return null;
        }
        StringBuilder sb5 = new StringBuilder();
        if (map.size() > 0) {
            sb5.append("Android");
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(String.valueOf(Build.VERSION.SDK_INT));
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(AppSetting.f99551k);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(Build.MANUFACTURER);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(DeviceInfoMonitor.getModel());
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(t("9", "0", map));
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(o());
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(t("11", "0", map));
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(t("12", "0", map));
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(t("13", "0", map));
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(t("14", "0", map));
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(t("15", "0", map));
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(t("16", "0", map));
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(t("17", "0", map));
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(t("18", "0", map));
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(t("19", "0", map));
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(t("20", "0", map));
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(s());
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(t("22", "0", map));
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(t("23", "0", map));
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(t("24", "0", map));
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(t("25", "0", map));
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(t("26", "0", map));
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(t("27", "0", map));
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(t("28", "0", map));
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(t("29", "0", map));
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(t("30", "0", map));
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(t("31", "0", map));
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(t("32", "0", map));
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(t(WadlProxyConsts.OPER_TYPE_APK_SIGN, "0", map));
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(t(WadlProxyConsts.OPER_TYPE_MONITOR, "0", map));
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(t("35", "0", map));
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(t("36", "0", map));
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(t("37", "0", map));
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(t("38", "0", map));
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(t("39", "0", map));
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append("7");
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(t("41", "0", map));
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(m(map));
            sb5.append(QbAddrData.DATA_SPLITER);
        }
        return sb5.toString();
    }

    private static String q() {
        return p(BaseApplicationImpl.getApplication().getSystemSharedPreferences(f73438c, 0).getAll());
    }

    private static String r() {
        return p(f73437b);
    }

    public static long s() {
        return (m.c() / 1024) / 1024;
    }

    private static String t(String str, String str2, Map<String, ?> map) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && map != null) {
            if (map.containsKey(str)) {
                return (String) map.get(str);
            }
            return str2;
        }
        return null;
    }

    private static boolean u(int i3) {
        if (i3 != 20 && i3 != 19 && i3 != 18 && i3 != 23 && i3 != 21 && i3 != 22) {
            return false;
        }
        return true;
    }

    public static boolean v(long j3) {
        if (l() != -1 && l() != 0 && j3 != l()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean w(int i3) {
        if (i3 != 24 && i3 != 18 && i3 != 23 && i3 != 21 && i3 != 22) {
            return true;
        }
        return false;
    }

    public static boolean x(int i3, boolean z16) {
        if (!z16) {
            if (z(i3 + "") != null) {
                AVCoreLog.printInfoLog("VideoNodeManager", "--> checkNodeHasWrite() the node is has writh !!!!!!!!!!!!!!!!!!!!!!!!! node = " + b.a(i3));
                return true;
            }
        }
        if (z16) {
            if (f73437b.get(i3 + "") != null) {
                AVCoreLog.printInfoLog("VideoNodeManager", "--> checkNodeHasWrite() temp ,the node is has writh !!!!!!!!!!!!!!!!!!!!!!!!! node = " + b.a(i3));
                return true;
            }
            return false;
        }
        return false;
    }

    private static boolean y() {
        String str = f73437b.get("0");
        if (str != null && str.equals("1")) {
            return true;
        }
        return false;
    }

    private static String z(String str) {
        return BaseApplicationImpl.getApplication().getSystemSharedPreferences(f73438c, 0).getString(str, null);
    }
}
