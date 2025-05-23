package com.tencent.mobileqq.troop.filemanager;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.QADNetStatus;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.webviewplugin.QzoneWebViewOfflinePlugin;
import java.util.Random;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes19.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f295934a;

        /* renamed from: b, reason: collision with root package name */
        public int f295935b;

        /* renamed from: c, reason: collision with root package name */
        public int f295936c;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f295935b = 0;
                this.f295936c = 0;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static String f295937a;

        /* renamed from: b, reason: collision with root package name */
        public static int f295938b;

        /* renamed from: c, reason: collision with root package name */
        public static int f295939c;

        /* renamed from: d, reason: collision with root package name */
        public static int f295940d;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(76374);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            f295937a = "<TroopFile> ";
            f295938b = 0;
            f295939c = 1;
            f295940d = 2;
        }

        public static void a(String str, int i3, String str2) {
            QLog.d(str, d(i3), f295937a + str2);
        }

        public static void b(String str, int i3, String str2) {
            QLog.e(str, d(i3), f295937a + str2);
        }

        public static void c(String str, int i3, String str2) {
            QLog.i(str, d(i3), f295937a + str2);
        }

        private static int d(int i3) {
            if (f295938b == i3) {
                return 1;
            }
            if (f295939c == i3 || f295940d != i3) {
                return 2;
            }
            return 4;
        }

        public static void e(String str, int i3, String str2) {
            QLog.w(str, d(i3), f295937a + str2);
        }
    }

    public static long a() {
        return (((int) (System.currentTimeMillis() / 1000)) << 32) | Math.abs(new Random().nextInt());
    }

    public static QQAppInterface b() {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime != null && (runtime instanceof QQAppInterface)) {
            return (QQAppInterface) runtime;
        }
        return null;
    }

    public static String c(String str) {
        if (str == null) {
            return null;
        }
        if (str.startsWith("/")) {
            return str.substring(1);
        }
        return "/" + str;
    }

    public static String d() {
        int mobileInfo;
        if (!AppNetConnInfo.isNetSupport()) {
            return "none";
        }
        if (AppNetConnInfo.isWifiConn()) {
            return "wifi";
        }
        if (!AppNetConnInfo.isMobileConn() || (mobileInfo = AppNetConnInfo.getMobileInfo()) == -1) {
            return "none";
        }
        if (mobileInfo != 0 && mobileInfo != 1) {
            if (mobileInfo != 2) {
                if (mobileInfo != 3) {
                    return "unkonw";
                }
                return QADNetStatus.G_4;
            }
            return QADNetStatus.G_3;
        }
        return QADNetStatus.G_2;
    }

    public static int e(String str) {
        int indexOf;
        int lastIndexOf;
        if (TextUtils.isEmpty(str) || !str.startsWith("H_") || (indexOf = str.indexOf("_")) == -1 || indexOf == (lastIndexOf = str.lastIndexOf("_"))) {
            return 0;
        }
        try {
            return Integer.valueOf(str.substring(indexOf, lastIndexOf - 1)).intValue();
        } catch (Exception unused) {
            return 0;
        }
    }

    public static int f(String str) {
        int indexOf;
        int lastIndexOf;
        if (TextUtils.isEmpty(str) || !str.startsWith("H_") || (indexOf = str.indexOf("_")) == -1 || indexOf == (lastIndexOf = str.lastIndexOf("_"))) {
            return 0;
        }
        try {
            return Integer.valueOf(str.substring(lastIndexOf)).intValue();
        } catch (Exception unused) {
            return 0;
        }
    }

    public static int g(String str) {
        int indexOf;
        int indexOf2;
        if (TextUtils.isEmpty(str) || (indexOf = str.indexOf("User-ReturnCode=[")) == -1) {
            return 0;
        }
        String substring = str.substring(indexOf + 17);
        if (TextUtils.isEmpty(substring) || (indexOf2 = substring.indexOf("]")) == -1) {
            return 0;
        }
        try {
            return Integer.valueOf(substring.substring(0, indexOf2)).intValue();
        } catch (Exception unused) {
            return 0;
        }
    }

    public static TroopFileManager h(long j3) {
        QQAppInterface b16 = b();
        if (b16 == null) {
            return null;
        }
        return TroopFileManager.F(b16, j3);
    }

    public static a i(String str) {
        int i3;
        String str2;
        boolean z16;
        int indexOf;
        a aVar = new a();
        if (TextUtils.isEmpty(str)) {
            return aVar;
        }
        try {
            int indexOf2 = str.indexOf(QzoneWebViewOfflinePlugin.STR_DEVIDER);
            if (indexOf2 == -1) {
                i3 = 0;
            } else {
                i3 = indexOf2 + 3;
            }
            String substring = str.substring(i3);
            int indexOf3 = substring.indexOf("/");
            if (-1 == indexOf3) {
                indexOf3 = substring.length() - 1;
            }
            int i16 = indexOf3 + i3;
            int indexOf4 = str.indexOf("&bHost=");
            if (-1 == indexOf4 || -1 == (indexOf = str.indexOf("&bPort=", indexOf4))) {
                str2 = null;
                z16 = false;
            } else {
                str2 = str.substring(indexOf4 + 7, indexOf) + ":" + str.substring(indexOf + 7);
                z16 = true;
            }
            if (str2 == null) {
                str2 = str.substring(i3, i16);
            }
        } catch (Exception unused) {
        }
        if (str2 == null) {
            return aVar;
        }
        int indexOf5 = str2.indexOf(":");
        if (indexOf5 >= 0) {
            String substring2 = str2.substring(0, indexOf5);
            String substring3 = str2.substring(indexOf5 + 1);
            aVar.f295934a = substring2;
            aVar.f295935b = Integer.valueOf(substring3).intValue();
        } else {
            aVar.f295934a = str2;
            aVar.f295935b = 0;
        }
        if (z16) {
            aVar.f295936c = 1;
        }
        return aVar;
    }
}
