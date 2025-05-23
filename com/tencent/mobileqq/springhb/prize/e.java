package com.tencent.mobileqq.springhb.prize;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes18.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f289566a;

    /* renamed from: b, reason: collision with root package name */
    public String f289567b;

    /* renamed from: c, reason: collision with root package name */
    public String f289568c;

    /* renamed from: d, reason: collision with root package name */
    public String f289569d;

    /* renamed from: e, reason: collision with root package name */
    public String f289570e;

    /* renamed from: f, reason: collision with root package name */
    public String f289571f;

    /* renamed from: g, reason: collision with root package name */
    public String f289572g;

    /* renamed from: h, reason: collision with root package name */
    public String f289573h;

    /* renamed from: i, reason: collision with root package name */
    public String f289574i;

    /* renamed from: j, reason: collision with root package name */
    public String f289575j;

    /* renamed from: k, reason: collision with root package name */
    public String f289576k;

    /* renamed from: l, reason: collision with root package name */
    public String f289577l;

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        StringBuilder sb5 = new StringBuilder(600);
        sb5.append("appId:");
        sb5.append(this.f289566a);
        sb5.append(",gameName:");
        sb5.append(this.f289567b);
        sb5.append(",packNm:");
        sb5.append(this.f289568c);
        sb5.append(",url:");
        sb5.append(this.f289569d);
        sb5.append(",schema:");
        sb5.append(this.f289570e);
        sb5.append(",channel:");
        sb5.append(this.f289571f);
        sb5.append(",sourceId:");
        sb5.append(this.f289572g);
        sb5.append(",company:");
        sb5.append(this.f289573h);
        sb5.append(",version:");
        sb5.append(this.f289574i);
        sb5.append(",privacyId:");
        sb5.append(this.f289575j);
        sb5.append(",ticket:");
        sb5.append(this.f289576k);
        if (QLog.isColorLevel()) {
            QLog.i("SpringHb_GameInfo", 1, sb5.toString());
        }
    }
}
