package com.tencent.tfd.sdk.wxa;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Iterator;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class Sculptor {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f375685a;

    /* renamed from: b, reason: collision with root package name */
    public int f375686b;

    /* renamed from: c, reason: collision with root package name */
    public Betelnut f375687c;

    public Sculptor(String str, int i3, Betelnut betelnut) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), betelnut);
            return;
        }
        this.f375685a = str;
        this.f375686b = i3;
        this.f375687c = betelnut;
    }

    public static String a(String str, String str2, String str3) {
        return !TextUtils.isEmpty(str3) ? str3.replace(str, str2) : str3;
    }

    public final String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        String str = this.f375685a;
        if (str == null) {
            str = "";
        }
        sb5.append(a(ContainerUtils.FIELD_DELIMITER, "%0A", a(",", "%54", a("_", "%5F", a(";", "%3B", a(":", "%3A", str))))));
        sb5.append("_");
        sb5.append(this.f375686b);
        sb5.append("_");
        Betelnut betelnut = this.f375687c;
        if (betelnut == null) {
            return sb5.toString();
        }
        sb5.append(betelnut.f375430a);
        sb5.append(":");
        sb5.append(this.f375687c.f375431b);
        sb5.append(":");
        Iterator<Blackberry> it = this.f375687c.f375432c.iterator();
        while (it.hasNext()) {
            Blackberry next = it.next();
            sb5.append(next.f375453a);
            sb5.append(",");
            sb5.append(",");
            sb5.append(",");
            String format = String.format(Locale.SIMPLIFIED_CHINESE, "%.5f", Float.valueOf(next.f375456d));
            if (format.indexOf(".") > 0) {
                format = format.replaceAll("0+?$", "").replaceAll("[.]$", "");
            }
            sb5.append(format);
            sb5.append(",");
            String format2 = String.format(Locale.SIMPLIFIED_CHINESE, "%.5f", Float.valueOf(next.f375457e));
            if (format2.indexOf(".") > 0) {
                format2 = format2.replaceAll("0+?$", "").replaceAll("[.]$", "");
            }
            sb5.append(format2);
            if (it.hasNext()) {
                sb5.append(";");
            }
        }
        sb5.append(":");
        sb5.append(this.f375687c.f375433d);
        return sb5.toString();
    }
}
