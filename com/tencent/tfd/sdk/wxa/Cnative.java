package com.tencent.tfd.sdk.wxa;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.vas.theme.ThemeReporter;

/* compiled from: P */
/* renamed from: com.tencent.tfd.sdk.wxa.native, reason: invalid class name */
/* loaded from: classes26.dex */
public final class Cnative {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final long f375758a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62862);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            f375758a = System.currentTimeMillis();
        }
    }

    public static String a(Context context, boolean z16, int i3, boolean z17, int i16, Chestnut chestnut) {
        String str;
        String str2;
        long j3;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("T:");
        long j16 = f375758a;
        sb5.append(j16);
        sb5.append(",");
        sb5.append("LT:");
        sb5.append("" + (System.currentTimeMillis() - j16));
        sb5.append(",");
        sb5.append("F:");
        String str3 = "0";
        if (!z16) {
            str = "0";
        } else {
            str = "1";
        }
        sb5.append(str);
        sb5.append(",");
        sb5.append("PT:");
        sb5.append("" + i3);
        sb5.append(",");
        sb5.append("PKG:");
        sb5.append("1");
        sb5.append(",");
        sb5.append("SC:");
        if (!z17) {
            str2 = "0";
        } else {
            str2 = "1";
        }
        sb5.append(str2);
        if (UrsaMinor.f375742a == 105748) {
            sb5.append(",");
            sb5.append("SOTR:");
            sb5.append(Banana.a(context).toString() + ";" + Banana.b(context).toString());
        }
        sb5.append(",");
        sb5.append("SRT:");
        sb5.append(i16);
        Coconut coconut = Coconut.f375544e;
        StringBuilder sb6 = new StringBuilder();
        Cthrows b16 = coconut.b(context);
        if (b16 != null) {
            sb6.append(b16.f375846a);
            sb6.append("_");
            sb6.append(b16.f375848c);
        }
        String sb7 = sb6.toString();
        if (!TextUtils.isEmpty(sb7)) {
            sb5.append(",");
            sb5.append("CL:");
            sb5.append(sb7);
        }
        String b17 = Chestnut.b(context, ThemeReporter.FROM_AUTH);
        if (TextUtils.isEmpty(b17)) {
            StringBuilder a16 = Pyxis.a("0_");
            if (z16) {
                str3 = "1";
            }
            a16.append(str3);
            b17 = a16.toString();
        }
        if (!TextUtils.isEmpty(b17)) {
            sb5.append(",");
            sb5.append("R:");
            sb5.append(b17);
        }
        sb5.append(",");
        sb5.append("US:");
        try {
            j3 = Long.valueOf(Chestnut.b(context, "503")).longValue();
        } catch (Throwable unused) {
            j3 = 0;
        }
        sb5.append(j3);
        sb5.append("_");
        sb5.append(chestnut.a(context, "502"));
        sb5.append("_");
        sb5.append(Process.myUid());
        sb5.append(",");
        sb5.append("STIF:");
        sb5.append(Chestnut.b(context, "904"));
        if (Coconut.f375544e.a(context, "i_v_6", false)) {
            sb5.append(",");
            sb5.append("IPS:");
            sb5.append(Cinterface.a());
        }
        sb5.append(",");
        sb5.append("GCI:");
        sb5.append("1aab0a6");
        return sb5.toString();
    }
}
