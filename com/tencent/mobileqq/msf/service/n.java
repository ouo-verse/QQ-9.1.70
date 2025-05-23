package com.tencent.mobileqq.msf.service;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.sdk.MsfConstants;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes15.dex */
public class n {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    public static final String f250971a = "MSF.S.Util";

    public n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void a(Context context, String str, String str2, String str3, int i3, FromServiceMsg fromServiceMsg) {
        a(context, str, str2, str3, i3, 0, fromServiceMsg);
    }

    public static String b(ToServiceMsg toServiceMsg) {
        return (toServiceMsg == null || toServiceMsg.getAttributes().get(MsfConstants.ATTRIBUTE_SENDERPROCESSNAME) == null) ? "" : (String) toServiceMsg.getAttributes().get(MsfConstants.ATTRIBUTE_SENDERPROCESSNAME);
    }

    public static boolean c() {
        try {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = SystemMethodProxy.getRunningAppProcesses((ActivityManager) BaseApplication.getContext().getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY));
            if (runningAppProcesses == null) {
                if (QLog.isColorLevel()) {
                    QLog.d(f250971a, 2, "can not load appProcesses.");
                }
            } else {
                String processName = MsfSdkUtils.getProcessName(BaseApplication.getContext());
                if (processName != null && processName.indexOf(":") > 0) {
                    processName = processName.substring(0, processName.indexOf(":"));
                }
                Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                while (it.hasNext()) {
                    if (it.next().processName.equals(processName)) {
                        return true;
                    }
                }
            }
            return false;
        } catch (Exception e16) {
            QLog.d(f250971a, 1, "check isMainProcessRunning error " + e16);
            return false;
        }
    }

    public static void a(Context context, String str, String str2, String str3, int i3, int i16, FromServiceMsg fromServiceMsg) {
        QLog.d(f250971a, 1, String.format("sendBootAction processName=%s uin=%s bootAction=%s status=%s type=%s fromServiceMsg=%s", str, str2, str3, Integer.valueOf(i3), Integer.valueOf(i16), fromServiceMsg));
        try {
            Intent intent = new Intent(str3);
            intent.putExtra("uin", str2);
            intent.putExtra("istatus", i3);
            intent.putExtra("type", i16);
            intent.putExtra("gatewayip", MsfService.core.getGatewayIp());
            intent.setPackage(context.getPackageName());
            if (i16 == 1) {
                intent.putExtra("processExitTimestamp", System.currentTimeMillis());
            }
            a("MSF:BootAction", 5000L);
            if (str3.toLowerCase().indexOf(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, 0) != -1) {
                intent.setFlags(268435456);
                if (fromServiceMsg != null && str != null && str.endsWith(MsfConstants.PROCESS_VIDEO)) {
                    if (fromServiceMsg.getAttribute("msf_timestamp") == null) {
                        fromServiceMsg.addAttribute("msf_timestamp", Long.valueOf(System.currentTimeMillis()));
                    }
                    intent.putExtra("fromServiceMsg", fromServiceMsg);
                }
                context.startActivity(intent);
            }
            intent.setFlags(32);
            context.sendBroadcast(intent);
        } catch (Throwable th5) {
            QLog.e(f250971a, 1, "sendBootAction fail.", th5);
        }
    }

    public static String b(FromServiceMsg fromServiceMsg) {
        return (fromServiceMsg == null || fromServiceMsg.getAttributes().get(MsfConstants.ATTRIBUTE_SENDERPROCESSNAME) == null) ? "" : (String) fromServiceMsg.getAttributes().get(MsfConstants.ATTRIBUTE_SENDERPROCESSNAME);
    }

    public static String b() {
        Random random = new Random(System.currentTimeMillis());
        String str = "---------";
        for (int i3 = 0; i3 < 12; i3++) {
            str = str + String.valueOf(random.nextInt(10));
        }
        return str;
    }

    public static void a(FromServiceMsg fromServiceMsg) {
        if (fromServiceMsg != null) {
            try {
                String serviceCmd = fromServiceMsg.getServiceCmd();
                if (TextUtils.isEmpty(serviceCmd) || !serviceCmd.equals("SharpSvr.s2c")) {
                    return;
                }
                a("MSF:VideoPush", 3000L);
            } catch (Throwable th5) {
                QLog.e(f250971a, 1, "checkVideoPushCmd fail.", th5);
            }
        }
    }

    public static void a(String str, long j3) {
        try {
            if (QLog.isColorLevel()) {
                QLog.d(str, 1, String.format("requestPartialWakeLock tag=%s timeout=%s", str, Long.valueOf(j3)));
            }
            PowerManager powerManager = (PowerManager) BaseApplication.getContext().getSystemService("power");
            if (powerManager != null) {
                powerManager.newWakeLock(1, str).acquire(j3);
            }
        } catch (Throwable th5) {
            QLog.d(str, 1, "requestPartialWakeLock fail.", th5);
        }
    }

    public static FromServiceMsg a(ToServiceMsg toServiceMsg) {
        FromServiceMsg fromServiceMsg = new FromServiceMsg(toServiceMsg.getUin(), toServiceMsg.getServiceCmd());
        fromServiceMsg.setAppId(toServiceMsg.getAppId());
        fromServiceMsg.setAppSeq(toServiceMsg.getAppSeq());
        fromServiceMsg.setRequestSsoSeq(toServiceMsg.getRequestSsoSeq());
        fromServiceMsg.setMsfCommand(toServiceMsg.getMsfCommand());
        MsfSdkUtils.addFromMsgProcessName(b(toServiceMsg), fromServiceMsg);
        return fromServiceMsg;
    }

    public static String a() {
        d a16 = e.a(BaseApplication.getContext().getPackageName());
        return a16 != null ? a16.a() : BaseApplicationImpl.bootBroadcastName;
    }

    public static boolean a(String str) {
        return !TextUtils.isEmpty(str) && (str.equals(BaseApplication.getContext().getPackageName()) || str.endsWith(MsfConstants.PROCESS_VIDEO));
    }
}
