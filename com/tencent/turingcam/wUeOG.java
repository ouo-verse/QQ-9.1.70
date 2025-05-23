package com.tencent.turingcam;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Iterator;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes27.dex */
public class wUeOG {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final String f382415a;

    /* renamed from: b, reason: collision with root package name */
    public final int f382416b;

    /* renamed from: c, reason: collision with root package name */
    public final FjMaF f382417c;

    public wUeOG(String str, int i3, FjMaF fjMaF) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), fjMaF);
            return;
        }
        this.f382415a = str;
        this.f382416b = i3;
        this.f382417c = fjMaF;
    }

    public static String a(String str, String str2, String str3) {
        return !TextUtils.isEmpty(str3) ? str3.replace(str, str2) : str3;
    }

    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        String str = this.f382415a;
        if (str == null) {
            str = "";
        }
        sb5.append(a(ContainerUtils.FIELD_DELIMITER, "%0A", a(",", "%54", a("_", "%5F", a(";", "%3B", a(":", "%3A", str))))));
        sb5.append("_");
        sb5.append(this.f382416b);
        sb5.append("_");
        FjMaF fjMaF = this.f382417c;
        if (fjMaF == null) {
            return sb5.toString();
        }
        sb5.append(fjMaF.f381825a);
        sb5.append(":");
        sb5.append(this.f382417c.f381826b);
        sb5.append(":");
        Iterator<TUmP8> it = this.f382417c.f381827c.iterator();
        while (it.hasNext()) {
            TUmP8 next = it.next();
            sb5.append(next.f382063a);
            sb5.append(",");
            sb5.append(",");
            sb5.append(",");
            String format = String.format(Locale.SIMPLIFIED_CHINESE, "%.5f", Float.valueOf(next.f382066d));
            if (format.indexOf(".") > 0) {
                format = format.replaceAll("0+?$", "").replaceAll("[.]$", "");
            }
            sb5.append(format);
            sb5.append(",");
            String format2 = String.format(Locale.SIMPLIFIED_CHINESE, "%.5f", Float.valueOf(next.f382067e));
            if (format2.indexOf(".") > 0) {
                format2 = format2.replaceAll("0+?$", "").replaceAll("[.]$", "");
            }
            sb5.append(format2);
            if (it.hasNext()) {
                sb5.append(";");
            }
        }
        sb5.append(":");
        sb5.append(this.f382417c.f381828d);
        return sb5.toString();
    }
}
