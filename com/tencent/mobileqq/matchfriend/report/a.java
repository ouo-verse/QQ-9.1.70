package com.tencent.mobileqq.matchfriend.report;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private String f245509a;

    /* renamed from: b, reason: collision with root package name */
    private String f245510b;

    /* renamed from: c, reason: collision with root package name */
    private String f245511c;

    /* renamed from: d, reason: collision with root package name */
    private String[] f245512d;

    /* renamed from: e, reason: collision with root package name */
    private String f245513e;

    /* renamed from: f, reason: collision with root package name */
    private String f245514f;

    /* renamed from: g, reason: collision with root package name */
    private String f245515g;

    /* renamed from: h, reason: collision with root package name */
    private String f245516h;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static a b() {
        return new a();
    }

    private String c() {
        String[] strArr = this.f245512d;
        String str = "";
        if (strArr != null) {
            for (String str2 : strArr) {
                str = str + str2 + "|";
            }
        }
        if (!TextUtils.isEmpty(this.f245509a)) {
            return str + this.f245509a;
        }
        return str;
    }

    private String d() {
        return "nickname=" + this.f245510b + "|socialDeclaration=" + this.f245511c + "|gender=" + this.f245513e + "|age=" + this.f245514f + "|city=" + this.f245515g;
    }

    public a a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        this.f245509a = str;
        return this;
    }

    public Bundle e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Bundle) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        Bundle bundle = new Bundle();
        bundle.putString("text_evidence", d());
        bundle.putString("img_evidence", c());
        bundle.putString("audio_evidence", this.f245516h);
        return bundle;
    }

    public a f(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (a) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        this.f245510b = str;
        return this;
    }
}
