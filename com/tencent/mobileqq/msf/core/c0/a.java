package com.tencent.mobileqq.msf.core.c0;

import android.os.Build;
import android.telephony.TelephonyManager;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.o;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qphone.base.util.ROMUtil;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    public static final String f247562a = "BigTReportUtil";

    /* renamed from: b, reason: collision with root package name */
    public static final String f247563b = "dc04272";

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void a(MsfCore msfCore, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(str2.getBytes("UTF-8"));
            HashMap hashMap = new HashMap();
            hashMap.put(str, arrayList);
            msfCore.configManager.a(new HashMap<>(hashMap), "");
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public static void a(MsfCore msfCore, String str, String str2, String str3, String str4, int i3, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12) {
        a(msfCore, f247563b, a(msfCore.getMainAccount(), str, str2, str3, str4, i3, str5, a(), str6, str7, str8, str9, str10, str11, str12));
    }

    public static void a(MsfCore msfCore, String str, String str2, String str3, String str4, int i3, String str5) {
        a(msfCore, f247563b, a(msfCore.getMainAccount(), str, str2, str3, str4, i3, str5, a(), "", "", "", "", "", "", ""));
    }

    private static String a() {
        int c16 = com.tencent.qphone.base.util.c.c();
        long f16 = (com.tencent.qphone.base.util.c.f() / 1024) / 1024;
        long[] d16 = com.tencent.qphone.base.util.c.d();
        String networkOperator = DeviceInfoMonitor.getNetworkOperator((TelephonyManager) BaseApplication.getContext().getSystemService("phone"));
        if (networkOperator == null) {
            networkOperator = "";
        }
        String format = String.format("%.2f", Double.valueOf(com.tencent.qphone.base.util.c.e()));
        StringBuilder sb5 = new StringBuilder();
        sb5.append(c16);
        sb5.append(";");
        sb5.append(f16);
        sb5.append(";");
        sb5.append(d16[0]);
        sb5.append(";");
        sb5.append(d16[1]);
        sb5.append(";");
        sb5.append(networkOperator.replaceAll(";", ""));
        sb5.append(";");
        sb5.append(format);
        sb5.append(";");
        sb5.append(com.tencent.qphone.base.util.c.f344424e);
        sb5.append(";");
        sb5.append(com.tencent.qphone.base.util.c.f344425f);
        sb5.append(";");
        String sb6 = sb5.toString();
        if (QLog.isColorLevel()) {
            QLog.d(f247562a, 2, "getExtraDeviceInfo=" + sb6);
        }
        return sb5.toString();
    }

    private static String a(String str, String str2, String str3, String str4, String str5, int i3, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14) {
        String str15 = NetConnInfoCenter.getServerTime() + "|" + BaseApplication.getContext().getAppId() + "|android|" + str + "|" + str2 + "|" + str3 + "|" + str4 + "|" + str5 + "|" + i3 + "|" + str6 + "|" + o.e() + "||" + Build.MANUFACTURER + "|" + DeviceInfoMonitor.getModel() + "|" + NetConnInfoCenter.getSystemNetStateString() + "|" + Build.VERSION.RELEASE + "|" + ROMUtil.getRomDetailInfo() + "|" + str7 + "|" + str8 + "|" + str9 + "|" + str10 + "|" + str11 + "|" + str12 + "|" + str13 + "|" + str14 + "|";
        if (QLog.isColorLevel()) {
            QLog.d(f247562a, 2, "getDC04272ReportDetail=" + str15);
        }
        return str15;
    }
}
