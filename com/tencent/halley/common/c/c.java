package com.tencent.halley.common.c;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static String f113392a;

    /* renamed from: b, reason: collision with root package name */
    public static byte f113393b;

    /* renamed from: c, reason: collision with root package name */
    public static String f113394c;

    /* renamed from: d, reason: collision with root package name */
    public static String f113395d;

    /* renamed from: e, reason: collision with root package name */
    public static String f113396e;

    /* renamed from: f, reason: collision with root package name */
    public static String f113397f;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15683);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        f113392a = "";
        f113393b = (byte) -1;
        f113394c = "";
        f113395d = "";
        f113396e = "";
        f113397f = "";
    }

    private static String a() {
        try {
            return Build.VERSION.RELEASE;
        } catch (Throwable th5) {
            th5.printStackTrace();
            return "null";
        }
    }

    private static String b() {
        try {
            return Build.VERSION.SDK;
        } catch (Throwable th5) {
            th5.printStackTrace();
            return "null";
        }
    }

    public static void a(Context context) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("null");
        stringBuffer.append(";Android ");
        stringBuffer.append(a());
        stringBuffer.append(",level ");
        stringBuffer.append(b());
        f113392a = stringBuffer.toString();
        f113393b = (byte) 1;
        f113395d = b(context);
        f113394c = context.getPackageName();
        f113396e = "null";
        f113397f = "null";
    }

    private static String b(Context context) {
        try {
            PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0);
            String str = packageInfo.versionName;
            int i3 = packageInfo.versionCode;
            if (str != null && str.trim().length() > 0) {
                String replace = str.trim().replace('\n', TokenParser.SP).replace('\r', TokenParser.SP).replace("|", "%7C");
                int i16 = 0;
                for (char c16 : replace.toCharArray()) {
                    if (c16 == '.') {
                        i16++;
                    }
                }
                if (i16 >= 3) {
                    return replace;
                }
                return replace + "." + i3;
            }
            return String.valueOf(i3);
        } catch (Throwable unused) {
            return "";
        }
    }
}
