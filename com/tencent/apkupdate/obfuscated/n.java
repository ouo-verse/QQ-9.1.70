package com.tencent.apkupdate.obfuscated;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class n {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f72555a;

    /* renamed from: b, reason: collision with root package name */
    public String f72556b;

    /* renamed from: c, reason: collision with root package name */
    public String f72557c;

    /* renamed from: d, reason: collision with root package name */
    public String f72558d;

    /* renamed from: e, reason: collision with root package name */
    public String f72559e;

    /* renamed from: f, reason: collision with root package name */
    public String f72560f;

    /* renamed from: g, reason: collision with root package name */
    public int f72561g;

    /* renamed from: h, reason: collision with root package name */
    public int f72562h;

    /* renamed from: i, reason: collision with root package name */
    public int f72563i;

    public n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("0");
        stringBuffer.append(this.f72556b.subSequence(0, 1));
        stringBuffer.append(this.f72557c);
        String stringBuffer2 = stringBuffer.toString();
        StringBuffer stringBuffer3 = new StringBuffer();
        stringBuffer3.append("TMASDK_");
        stringBuffer3.append(this.f72556b);
        if (!TextUtils.isEmpty(this.f72558d)) {
            stringBuffer3.append("_");
            stringBuffer3.append(this.f72558d);
        }
        stringBuffer3.append("/");
        stringBuffer3.append(stringBuffer2);
        stringBuffer3.append("&NA/");
        stringBuffer3.append(stringBuffer2);
        stringBuffer3.append(ContainerUtils.FIELD_DELIMITER);
        stringBuffer3.append(this.f72560f);
        stringBuffer3.append("_");
        stringBuffer3.append(this.f72563i);
        stringBuffer3.append(ContainerUtils.FIELD_DELIMITER);
        stringBuffer3.append(this.f72561g / 16);
        stringBuffer3.append("_");
        stringBuffer3.append(this.f72562h / 16);
        stringBuffer3.append("_");
        stringBuffer3.append("14&");
        stringBuffer3.append(this.f72555a);
        stringBuffer3.append(ContainerUtils.FIELD_DELIMITER);
        stringBuffer3.append(this.f72559e);
        stringBuffer3.append(ContainerUtils.FIELD_DELIMITER);
        stringBuffer3.append("NA");
        stringBuffer3.append(ContainerUtils.FIELD_DELIMITER);
        stringBuffer3.append("V3");
        return stringBuffer3.toString();
    }
}
