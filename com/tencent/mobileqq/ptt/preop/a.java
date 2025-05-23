package com.tencent.mobileqq.ptt.preop;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.mobileqq.highway.utils.BaseConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import mqq.app.AppRuntime;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes16.dex */
public final class a implements BaseConstants.NetType {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected static C8274a[] f261269a;

    /* renamed from: b, reason: collision with root package name */
    protected static boolean f261270b;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.ptt.preop.a$a, reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public static class C8274a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f261271a;

        /* renamed from: b, reason: collision with root package name */
        public final int[] f261272b;

        public C8274a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f261271a = -1;
                this.f261272b = new int[6];
            }
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            StringBuilder sb5 = new StringBuilder(100);
            sb5.append(this.f261271a);
            for (int i3 = 0; i3 < this.f261272b.length; i3++) {
                sb5.append('#');
                sb5.append(i3);
                sb5.append(util.base64_pad_url);
                sb5.append(this.f261272b[i3]);
            }
            return sb5.toString();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21713);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        C8274a[] c8274aArr = new C8274a[4];
        f261269a = c8274aArr;
        c8274aArr[1] = new C8274a();
        f261269a[2] = new C8274a();
        f261269a[3] = new C8274a();
    }

    public static C8274a a(AppRuntime appRuntime, int i3) {
        c(appRuntime, false);
        return f261269a[i3];
    }

    protected static String b(AppRuntime appRuntime) {
        String currentAccountUin = appRuntime.getCurrentAccountUin();
        String string = BaseApplication.getContext().getSharedPreferences("RecordParams_" + currentAccountUin, 0).getString("PreDownloadCfg", null);
        if (QLog.isColorLevel()) {
            QLog.d("PreDownloadParams", 2, "Params getSavedCfg: " + string + " for:" + currentAccountUin);
        }
        return string;
    }

    public static void c(AppRuntime appRuntime, boolean z16) {
        String[] split;
        int parseInt;
        if ((f261270b && !z16) || appRuntime == null) {
            return;
        }
        f261270b = true;
        try {
            String b16 = b(appRuntime);
            if (QLog.isColorLevel()) {
                QLog.d("PreDownloadParams", 2, "Params initCfg :" + b16);
            }
            if (b16 != null && b16.length() != 0 && (split = b16.split("\\|")) != null && split.length >= 1) {
                for (int length = split.length - 1; length >= 0; length--) {
                    String[] split2 = split[length].split(":");
                    if (split2 != null && split2.length >= 2 && (parseInt = Integer.parseInt(split2[0])) >= 1) {
                        C8274a[] c8274aArr = f261269a;
                        if (parseInt < c8274aArr.length) {
                            e(split2[1], c8274aArr[parseInt]);
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String d(AppRuntime appRuntime, int i3, C8274a c8274a) {
        String currentAccountUin = appRuntime.getCurrentAccountUin();
        String str = null;
        String string = BaseApplication.getContext().getSharedPreferences("RecordParams_" + currentAccountUin, 0).getString("PTTPreDownloadParams_" + i3, null);
        if (QLog.isDevelopLevel()) {
            QLog.d("PreDownloadParams", 4, "Params getSavedParams: " + string + " for: PTTPreDownloadParams_" + i3 + " for:" + currentAccountUin);
        }
        if (string != null && string.length() > 0) {
            String[] split = string.split("##");
            str = split[0];
            String str2 = split[1];
            try {
                e(str2.substring(str2.indexOf(58) + 1), c8274a);
            } catch (Exception unused) {
            }
        }
        return str;
    }

    protected static void e(String str, C8274a c8274a) {
        String[] split;
        String[] split2 = str.split("#");
        if (split2 != null && split2.length >= 2) {
            c8274a.f261271a = Integer.parseInt(split2[0]);
            for (int i3 = 1; i3 < split2.length && (split = split2[i3].split("_")) != null && split.length >= 2; i3++) {
                c8274a.f261272b[Integer.parseInt(split[0])] = Integer.parseInt(split[1]);
            }
        }
    }

    public static void f() {
        f261270b = false;
        C8274a[] c8274aArr = new C8274a[4];
        f261269a = c8274aArr;
        c8274aArr[1] = new C8274a();
        f261269a[2] = new C8274a();
        f261269a[3] = new C8274a();
    }

    public static void g(AppRuntime appRuntime, String str) {
        boolean equals;
        String currentAccountUin = appRuntime.getCurrentAccountUin();
        String b16 = b(appRuntime);
        SharedPreferences.Editor putString = BaseApplication.getContext().getSharedPreferences("RecordParams_" + currentAccountUin, 0).edit().putString("PreDownloadCfg", str);
        if (QLog.isColorLevel()) {
            QLog.d("PreDownloadParams", 2, "Params saveCfg: " + str + " for:" + currentAccountUin);
        }
        if (TextUtils.isEmpty(b16)) {
            equals = TextUtils.isEmpty(str);
        } else {
            equals = b16.equals(str);
        }
        if (!equals) {
            putString.putString("PTTPreDownloadParams_1", "");
            putString.putString("PTTPreDownloadParams_3", "");
            putString.putString("PTTPreDownloadParams_2", "");
            if (QLog.isDevelopLevel()) {
                QLog.d("PreDownloadParams", 4, "Params ClearParams for:" + currentAccountUin);
            }
        }
        putString.commit();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void h(AppRuntime appRuntime, C8274a c8274a, int i3) {
        StringBuilder sb5 = new StringBuilder(new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT).format(new Date()));
        sb5.append("##");
        sb5.append(i3);
        sb5.append(':');
        sb5.append(c8274a.f261271a);
        for (int i16 = 0; i16 <= 5; i16++) {
            sb5.append('#');
            sb5.append(i16);
            sb5.append(util.base64_pad_url);
            sb5.append(c8274a.f261272b[i16]);
        }
        String currentAccountUin = appRuntime.getCurrentAccountUin();
        SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences("RecordParams_" + currentAccountUin, 0);
        String sb6 = sb5.toString();
        sharedPreferences.edit().putString("PTTPreDownloadParams_" + i3, sb6).commit();
        if (QLog.isDevelopLevel()) {
            QLog.d("PreDownloadParams", 4, "Params saveParams: " + sb6 + " for: PTTPreDownloadParams_" + i3 + " for:" + currentAccountUin);
        }
    }
}
