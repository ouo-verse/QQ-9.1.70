package com.tencent.turingfd.sdk.xq;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Iterator;
import java.util.Locale;

/* compiled from: P */
/* renamed from: com.tencent.turingfd.sdk.xq.while, reason: invalid class name */
/* loaded from: classes27.dex */
public class Cwhile {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final String f383458a;

    /* renamed from: b, reason: collision with root package name */
    public final int f383459b;

    /* renamed from: c, reason: collision with root package name */
    public final Segment f383460c;

    public Cwhile(String str, int i3, Segment segment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), segment);
            return;
        }
        this.f383458a = str;
        this.f383459b = i3;
        this.f383460c = segment;
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
        String str = this.f383458a;
        if (str == null) {
            str = "";
        }
        sb5.append(a(ContainerUtils.FIELD_DELIMITER, "%0A", a(",", "%54", a("_", "%5F", a(";", "%3B", a(":", "%3A", str))))));
        sb5.append("_");
        sb5.append(this.f383459b);
        sb5.append("_");
        Segment segment = this.f383460c;
        if (segment == null) {
            return sb5.toString();
        }
        sb5.append(segment.f383063a);
        sb5.append(":");
        sb5.append(this.f383460c.f383064b);
        sb5.append(":");
        Iterator<Shaddock> it = this.f383460c.f383065c.iterator();
        while (it.hasNext()) {
            Shaddock next = it.next();
            sb5.append(next.f383069a);
            sb5.append(",");
            sb5.append(",");
            sb5.append(",");
            String format = String.format(Locale.SIMPLIFIED_CHINESE, "%.5f", Float.valueOf(next.f383072d));
            if (format.indexOf(".") > 0) {
                format = format.replaceAll("0+?$", "").replaceAll("[.]$", "");
            }
            sb5.append(format);
            sb5.append(",");
            String format2 = String.format(Locale.SIMPLIFIED_CHINESE, "%.5f", Float.valueOf(next.f383073e));
            if (format2.indexOf(".") > 0) {
                format2 = format2.replaceAll("0+?$", "").replaceAll("[.]$", "");
            }
            sb5.append(format2);
            if (it.hasNext()) {
                sb5.append(";");
            }
        }
        sb5.append(":");
        sb5.append(this.f383460c.f383066d);
        return sb5.toString();
    }
}
