package com.tencent.turingface.sdk.mfa;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.turingcam.WT9z5;
import com.tencent.turingcam.tmnyR;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes27.dex */
public class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final String f382510a;

    /* renamed from: b, reason: collision with root package name */
    public static String f382511b;

    /* renamed from: c, reason: collision with root package name */
    public static String f382512c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21371);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        StringBuilder a16 = tmnyR.a("turingfd_shark_");
        a16.append(WT9z5.f382088a);
        a16.append("_");
        a16.append("mfa");
        f382510a = a16.toString();
        f382511b = "";
        f382512c = "";
    }

    public static String a(Context context) {
        char c16;
        String str = "";
        if (!TextUtils.isEmpty(f382512c)) {
            return f382512c;
        }
        try {
            str = context.getSharedPreferences(f382511b + f382510a, 0).getString("g", "");
        } catch (Throwable unused) {
        }
        if (TextUtils.isEmpty(str)) {
            StringBuilder sb5 = new StringBuilder("03");
            sb5.append(String.format(Locale.SIMPLIFIED_CHINESE, "%02d", 2));
            String format = String.format(Locale.SIMPLIFIED_CHINESE, "%04d", 92);
            sb5.append(format.substring(format.length() - 2));
            sb5.append(new SimpleDateFormat("yyMMddHHmmss", Locale.getDefault()).format(new Date()));
            if (format.length() > 2) {
                sb5.append(format.substring(0, 2));
            } else {
                sb5.append("00");
            }
            sb5.append(String.format(Locale.SIMPLIFIED_CHINESE, "%010d", Long.valueOf((long) (Math.random() * 1.0E10d))));
            sb5.append((char) ((Math.random() % 10.0d) + 48.0d));
            String sb6 = sb5.toString();
            int length = sb6.length() - 1;
            int i3 = 0;
            while (true) {
                c16 = '0';
                if (length > 0) {
                    char charAt = sb6.charAt(length);
                    if (charAt < '0' || charAt > '9') {
                        break;
                    }
                    int i16 = (charAt - '0') * 2;
                    if (i16 > 9) {
                        i16 -= 9;
                    }
                    i3 += i16;
                    length -= 2;
                } else {
                    int length2 = sb6.length() - 2;
                    int i17 = 0;
                    while (true) {
                        if (length2 >= 0) {
                            char charAt2 = sb6.charAt(length2);
                            if (charAt2 < '0' || charAt2 > '9') {
                                break;
                            }
                            i17 += charAt2 - '0';
                            length2 -= 2;
                        } else {
                            c16 = String.valueOf((10 - ((i3 + i17) % 10)) % 10).charAt(0);
                            break;
                        }
                    }
                }
            }
            sb5.append(c16);
            a(context, sb5.toString());
            return f382512c;
        }
        f382512c = str;
        return str;
    }

    public static void a(Context context, String str) {
        try {
            f382512c = str;
            context.getSharedPreferences(f382511b + f382510a, 0).edit().putString("g", str).commit();
        } catch (Throwable unused) {
        }
    }
}
