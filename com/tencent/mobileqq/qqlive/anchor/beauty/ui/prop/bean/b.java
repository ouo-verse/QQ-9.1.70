package com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.bean;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes17.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f270507a;

    /* renamed from: b, reason: collision with root package name */
    public String f270508b;

    /* renamed from: c, reason: collision with root package name */
    public String f270509c;

    /* renamed from: d, reason: collision with root package name */
    public Map<String, String> f270510d;

    /* renamed from: e, reason: collision with root package name */
    public List<a> f270511e;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NonNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        StringBuffer stringBuffer = new StringBuffer("PropCategory = [");
        stringBuffer.append("id = ");
        stringBuffer.append(this.f270507a);
        stringBuffer.append(",");
        stringBuffer.append("name = ");
        stringBuffer.append(this.f270508b);
        stringBuffer.append(",");
        stringBuffer.append("thumbUrl = ");
        stringBuffer.append(this.f270509c);
        stringBuffer.append(",");
        if (this.f270510d != null) {
            stringBuffer.append("dynamicField = ");
            stringBuffer.append(this.f270510d.toString());
            stringBuffer.append(",");
        }
        if (this.f270511e != null) {
            stringBuffer.append("materialItemList = ");
            stringBuffer.append(this.f270511e.toString());
            stringBuffer.append(",");
        }
        stringBuffer.append("]");
        return super.toString();
    }
}
