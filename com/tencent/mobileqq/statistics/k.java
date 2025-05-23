package com.tencent.mobileqq.statistics;

import android.content.Intent;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ah;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes18.dex */
public class k {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static boolean f290018a;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f290019a;

        /* renamed from: b, reason: collision with root package name */
        public String f290020b;

        /* renamed from: c, reason: collision with root package name */
        public String f290021c;

        /* renamed from: d, reason: collision with root package name */
        public String f290022d;

        /* renamed from: e, reason: collision with root package name */
        public String f290023e;

        /* renamed from: f, reason: collision with root package name */
        public String f290024f;

        /* renamed from: g, reason: collision with root package name */
        public String f290025g;

        /* renamed from: h, reason: collision with root package name */
        public String f290026h;

        /* renamed from: i, reason: collision with root package name */
        public String f290027i;

        /* renamed from: j, reason: collision with root package name */
        public String f290028j;

        /* renamed from: k, reason: collision with root package name */
        public String f290029k;

        /* renamed from: l, reason: collision with root package name */
        public String f290030l;

        /* renamed from: m, reason: collision with root package name */
        public String f290031m;

        /* renamed from: n, reason: collision with root package name */
        public String f290032n;

        /* renamed from: o, reason: collision with root package name */
        public String f290033o;

        /* renamed from: p, reason: collision with root package name */
        public String f290034p;

        /* renamed from: q, reason: collision with root package name */
        public String f290035q;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f290019a = "";
            this.f290020b = "";
            this.f290021c = "";
            this.f290022d = "";
            this.f290023e = "";
            this.f290024f = "cartoon";
            this.f290025g = "";
            this.f290026h = "";
            this.f290027i = "";
            this.f290028j = "";
            this.f290029k = "";
            this.f290030l = "";
            this.f290031m = "";
            this.f290032n = String.valueOf(System.currentTimeMillis() / 1000);
            this.f290033o = "";
            this.f290034p = "";
            this.f290035q = "";
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            StringBuffer stringBuffer = new StringBuffer(64);
            stringBuffer.append(this.f290019a);
            stringBuffer.append("|");
            stringBuffer.append(this.f290020b);
            stringBuffer.append("|");
            stringBuffer.append(this.f290021c);
            stringBuffer.append("|");
            stringBuffer.append(this.f290022d);
            stringBuffer.append("|");
            stringBuffer.append(this.f290023e);
            stringBuffer.append("|");
            stringBuffer.append(this.f290024f);
            stringBuffer.append("|");
            stringBuffer.append(this.f290025g);
            stringBuffer.append("|");
            stringBuffer.append(this.f290026h);
            stringBuffer.append("|");
            stringBuffer.append(this.f290027i);
            stringBuffer.append("|");
            stringBuffer.append(this.f290028j);
            stringBuffer.append("|");
            stringBuffer.append(this.f290029k);
            stringBuffer.append("|");
            stringBuffer.append(this.f290030l);
            stringBuffer.append("|");
            stringBuffer.append(this.f290031m);
            stringBuffer.append("|");
            stringBuffer.append(this.f290032n);
            stringBuffer.append("|");
            stringBuffer.append(this.f290033o);
            stringBuffer.append("|");
            stringBuffer.append(this.f290034p);
            stringBuffer.append("|");
            stringBuffer.append(this.f290035q);
            stringBuffer.append("|");
            return stringBuffer.toString();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(75425);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f290018a = false;
        }
    }

    private static String a(QQAppInterface qQAppInterface) {
        if (qQAppInterface == null) {
            return "unknown";
        }
        int networkType = NetworkUtil.getNetworkType(qQAppInterface.getApp());
        if (networkType != 0) {
            if (networkType != 1) {
                if (networkType != 2) {
                    if (networkType != 3) {
                        if (networkType != 4) {
                            if (networkType != 5) {
                                return "unknown";
                            }
                            return "5G";
                        }
                        return "4G";
                    }
                    return "3G";
                }
                return "2G";
            }
            return "Wi-Fi";
        }
        return "none";
    }

    public static void b(String str, a aVar) {
        String[] split;
        if (!TextUtils.isEmpty(str) && str.contains(ContainerUtils.FIELD_DELIMITER)) {
            String[] split2 = str.split(ContainerUtils.FIELD_DELIMITER);
            for (int i3 = 0; i3 < split2.length; i3++) {
                if (split2[i3].contains("pushfrom") && (split = split2[i3].split(ContainerUtils.KEY_VALUE_DELIMITER)) != null && split.length >= 2) {
                    aVar.f290025g = split[1];
                }
            }
        }
    }

    private static String c(QQAppInterface qQAppInterface, a aVar) {
        SosoLocation sosoLocation;
        aVar.f290019a = ah.s();
        SosoLbsInfo sosoInfo = ((ISosoInterfaceApi) QRoute.api(ISosoInterfaceApi.class)).getSosoInfo();
        if (sosoInfo != null && (sosoLocation = sosoInfo.mLocation) != null) {
            aVar.f290021c = sosoLocation.city;
        }
        aVar.f290020b = a(qQAppInterface);
        return aVar.toString();
    }

    public static void d(QQAppInterface qQAppInterface, a aVar) {
        String c16 = c(qQAppInterface, aVar);
        if (qQAppInterface == null) {
            if (QLog.isColorLevel()) {
                QLog.i("PushReportController", 1, "not Rumtime");
            }
            Intent intent = new Intent();
            intent.setClassName(BaseApplicationImpl.sApplication, "com.tencent.mobileqq.statistics.ReportReceiver");
            intent.putExtra("reporting_tag", "dc03266");
            intent.putExtra("reporting_detail", c16);
            intent.putExtra("reporting_count", 1);
            intent.putExtra("is_runtime", 0);
            BaseApplicationImpl.getApplication().sendBroadcast(intent);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("PushReportController", 1, " Rumtime");
        }
        ReportController.m(qQAppInterface, "dc03266", c16, 1);
    }
}
