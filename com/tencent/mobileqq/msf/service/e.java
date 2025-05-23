package com.tencent.mobileqq.msf.service;

import android.app.ActivityManager;
import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.MsfStore;
import com.tencent.mobileqq.msf.sdk.MsfMessagePair;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.IMsfServiceCallbacker;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.raft.measure.utils.MeasureConst;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes15.dex */
public class e {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    static final String f250883a = "MSF.S.AppProcessManager";

    /* renamed from: b, reason: collision with root package name */
    public static final String f250884b = "app_process_info_";

    /* renamed from: c, reason: collision with root package name */
    static ConcurrentHashMap<String, d> f250885c;

    /* renamed from: d, reason: collision with root package name */
    static c f250886d;

    /* renamed from: e, reason: collision with root package name */
    static MsfCore f250887e;

    /* renamed from: f, reason: collision with root package name */
    static o f250888f;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25781);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f250885c = new ConcurrentHashMap<>();
        f250886d = new c();
        f250888f = null;
    }

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void a(Context context, MsfCore msfCore) {
        f250887e = msfCore;
        f250886d.setName("MsfServiceAppMsgHandler");
        f250888f = new o(msfCore);
        f250886d.start();
        a(context);
    }

    public static boolean b(String str) {
        d dVar = f250885c.get(str);
        if (dVar == null || dVar.d() == null) {
            return true;
        }
        QLog.w(f250883a, 1, "process " + str + " also registed,can not unregister by proxy.");
        return false;
    }

    public static void c(String str, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        if (str != null && str.length() != 0) {
            d dVar = f250885c.get(str);
            if (dVar != null) {
                int intValue = ((Integer) toServiceMsg.getAttribute("status")).intValue();
                fromServiceMsg.addAttribute("status", Integer.valueOf(intValue));
                fromServiceMsg.setMsgSuccess();
                if (intValue == 1) {
                    b(str, toServiceMsg, fromServiceMsg);
                    dVar.f250867c = true;
                    dVar.f250866b = SystemClock.elapsedRealtime();
                } else if (intValue == 2) {
                    dVar.f250867c = false;
                }
                QLog.e(f250883a, 1, "setAppConnStatus " + str + " " + intValue);
                return;
            }
            QLog.e(f250883a, 1, "can not find " + str + " to receive msg to:" + toServiceMsg + " from:" + fromServiceMsg);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e(f250883a, 2, "find null processName msg to app " + toServiceMsg + " " + fromServiceMsg);
        }
    }

    public static void b(String str, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        if (str != null && str.length() != 0) {
            if (str.equals("*")) {
                for (Map.Entry<String, d> entry : f250885c.entrySet()) {
                    MsfSdkUtils.addFromMsgProcessName(entry.getKey(), fromServiceMsg);
                    entry.getValue().f250874j.add(new MsfMessagePair(toServiceMsg, fromServiceMsg));
                }
            } else {
                d dVar = f250885c.get(str);
                if (dVar != null) {
                    dVar.f250874j.add(new MsfMessagePair(toServiceMsg, fromServiceMsg));
                } else {
                    QLog.e(f250883a, 1, "can not find " + str + " to receive msg to:" + toServiceMsg + " from:" + fromServiceMsg);
                }
                if (fromServiceMsg.getServiceCmd().equals("SharpSvr.s2c")) {
                    HashMap hashMap = new HashMap();
                    a((HashMap<String, String>) hashMap);
                    hashMap.put("MsgType", fromServiceMsg.toString());
                    hashMap.put("AppInfo", String.valueOf(dVar != null));
                    hashMap.put("uin", fromServiceMsg.getUin());
                    hashMap.put("ProcName", str);
                    hashMap.put("appid", String.valueOf(fromServiceMsg.getAppId()));
                    if (f250887e.getStatReporter() != null) {
                        f250887e.getStatReporter().a("dim.Msf.ForkVideoProc", false, 0L, 0L, (Map<String, String>) hashMap, true, false);
                    }
                }
            }
            f250886d.b();
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e(f250883a, 2, "find null processName msg to app " + toServiceMsg + " " + fromServiceMsg);
        }
    }

    public static void a(String str, String str2, IMsfServiceCallbacker iMsfServiceCallbacker, int i3) {
        boolean z16;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("onRegisterApp process=");
        sb5.append(str);
        sb5.append(" processBootName=");
        sb5.append(str2);
        sb5.append(" appid=");
        sb5.append(i3);
        sb5.append(" callback=");
        sb5.append(iMsfServiceCallbacker != null ? Integer.toHexString(iMsfServiceCallbacker.hashCode()) : "null");
        QLog.i(f250883a, 1, sb5.toString());
        if (str == null) {
            QLog.w(f250883a, 1, MsfSdkUtils.getProcessName(BaseApplication.getContext()) + " " + Thread.currentThread().getName() + " onRegisterApp appProcessName is null");
            return;
        }
        try {
            z16 = str.equals(BaseApplication.getContext().getPackageName());
        } catch (Exception e16) {
            QLog.w(f250883a, 1, "except at string compare ", e16);
            z16 = false;
        }
        if (!f250885c.containsKey(str)) {
            f250885c.putIfAbsent(str, new d());
            if (QLog.isColorLevel()) {
                QLog.d(f250883a, 2, "add processName: " + str);
            }
            d dVar = f250885c.get(str);
            if (dVar != null && z16) {
                dVar.f250876l = f250888f;
            }
            if (dVar != null && n.a(str)) {
                dVar.f250870f.set(0L);
                dVar.f250871g.set(0);
                dVar.f250869e = true;
            }
        }
        f250885c.get(str).a(str, str2, iMsfServiceCallbacker);
        MsfStore.getNativeConfigStore().setConfig(f250884b + str, f250885c.get(str).g());
        f250886d.b();
        h.d().a();
    }

    public static void a(String str, int i3, long j3, long j16) {
        d dVar = f250885c.get(str);
        if (dVar != null) {
            dVar.a(i3, j3, j16);
        }
    }

    public static d a(String str) {
        return f250885c.get(str);
    }

    public static void a(String str, Boolean bool) {
        QLog.i(f250883a, 1, "onUnRegisterApp process=" + str + " stopWakeupProcess=" + bool);
        d dVar = f250885c.get(str);
        if (dVar != null) {
            dVar.a(dVar.d());
            if (BaseApplication.getContext().getPackageName().equals(str)) {
                dVar.a(100, 0L, 0L);
            }
        }
        if (!bool.booleanValue()) {
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("unregister process :");
                sb5.append(str);
                sb5.append(" ");
                sb5.append(dVar != null ? MeasureConst.SLI_TYPE_SUCCESS : "failed");
                QLog.d(f250883a, 2, sb5.toString());
                return;
            }
            return;
        }
        d remove = f250885c.remove(str);
        MsfStore.getNativeConfigStore().removeConfig(f250884b + str);
        if (QLog.isColorLevel()) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append("remove process :");
            sb6.append(str);
            sb6.append(" ");
            sb6.append(remove != null ? MeasureConst.SLI_TYPE_SUCCESS : "failed");
            QLog.d(f250883a, 2, sb6.toString());
        }
    }

    public static void a(Context context) {
        String[] strArr;
        try {
            strArr = MsfStore.getNativeConfigStore().getConfigList(f250884b);
        } catch (UnsatisfiedLinkError e16) {
            QLog.d(f250883a, 1, "loadAppProcessInfo UnsatisfiedLinkError", e16);
            if (new Random().nextInt(100) < 1) {
                BaseApplication.getContext().getMSFInterfaceAdapter().handleCatchException(Thread.currentThread(), e16, "NativeConfigStoreCatchedException", null);
            }
            strArr = null;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("start loadAppProcessInfos proInfos size=");
        sb5.append(strArr == null ? "null" : Integer.valueOf(strArr.length));
        QLog.d(f250883a, 1, sb5.toString());
        if (strArr != null) {
            for (String str : strArr) {
                QLog.d(f250883a, 1, "loadAppProcessInfo proInfo:" + str);
                String[] split = str.split(",");
                a(split[0], split.length > 1 ? split[1] : "", (IMsfServiceCallbacker) null, 0);
            }
        }
    }

    public static void a(HashMap<String, String> hashMap) {
        try {
            ActivityManager activityManager = (ActivityManager) BaseApplication.getContext().getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            hashMap.put("availMem", String.valueOf(memoryInfo.availMem));
            hashMap.put(HippyReporter.RemoveEngineReason.LOW_MEMORY, String.valueOf(memoryInfo.lowMemory));
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f250883a, 2, "getSystemStatus exception", e16);
            }
        }
    }

    public static void a(String str, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        if (QLog.isColorLevel()) {
            QLog.d(f250883a, 2, String.format("keepProcessAlive processName=%s toServiceMsg=%s fromServiceMsg=%s", str, toServiceMsg, fromServiceMsg));
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        d dVar = f250885c.get(str);
        if (dVar != null) {
            boolean booleanValue = ((Boolean) toServiceMsg.getAttribute("keepAlive")).booleanValue();
            QLog.d(f250883a, 1, String.format("keepProcessAlive processName=%s keepProcessAlive=%s", str, Boolean.valueOf(booleanValue)));
            dVar.f250877m = booleanValue;
            fromServiceMsg.addAttribute("keepAlive", Boolean.valueOf(booleanValue));
            fromServiceMsg.setMsgSuccess();
            b(str, toServiceMsg, fromServiceMsg);
            return;
        }
        QLog.e(f250883a, 1, String.format("keepProcessAlive can not find process to receive msg, processName=%s", str));
    }

    public static boolean a() {
        return f250888f.d();
    }
}
