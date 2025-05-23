package com.tencent.qqnt.graytips.decoder;

import android.text.SpannableStringBuilder;
import android.text.style.ClickableSpan;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes24.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private SpannableStringBuilder f356828a;

    /* renamed from: b, reason: collision with root package name */
    private int f356829b;

    /* renamed from: c, reason: collision with root package name */
    private List<ClickableSpan> f356830c;

    /* renamed from: d, reason: collision with root package name */
    public List<com.tencent.qqnt.graytips.span.b> f356831d;

    /* renamed from: e, reason: collision with root package name */
    public List<com.tencent.qqnt.graytips.c> f356832e;

    /* renamed from: f, reason: collision with root package name */
    private String f356833f;

    /* renamed from: g, reason: collision with root package name */
    private String f356834g;

    public d(SpannableStringBuilder spannableStringBuilder, String str, List<ClickableSpan> list, List<com.tencent.qqnt.graytips.span.b> list2, List<com.tencent.qqnt.graytips.c> list3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, spannableStringBuilder, str, list, list2, list3);
            return;
        }
        this.f356828a = spannableStringBuilder;
        f(str);
        this.f356830c = list;
        this.f356831d = list2;
        this.f356832e = list3;
    }

    public List<ClickableSpan> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f356830c;
    }

    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.f356829b;
    }

    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.f356834g;
    }

    public String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.f356833f;
    }

    public SpannableStringBuilder e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (SpannableStringBuilder) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f356828a;
    }

    public void f(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
            return;
        }
        str.hashCode();
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case -1383228885:
                if (str.equals("bottom")) {
                    c16 = 0;
                    break;
                }
                break;
            case -1364013995:
                if (str.equals("center")) {
                    c16 = 1;
                    break;
                }
                break;
            case 115029:
                if (str.equals("top")) {
                    c16 = 2;
                    break;
                }
                break;
            case 3317767:
                if (str.equals("left")) {
                    c16 = 3;
                    break;
                }
                break;
            case 108511772:
                if (str.equals("right")) {
                    c16 = 4;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                this.f356829b = 80;
                return;
            case 1:
                this.f356829b = 17;
                return;
            case 2:
                this.f356829b = 48;
                return;
            case 3:
                this.f356829b = 3;
                return;
            case 4:
                this.f356829b = 5;
                return;
            default:
                return;
        }
    }

    public void g(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
        } else {
            this.f356834g = str;
        }
    }

    public void h(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        } else {
            this.f356833f = str;
        }
    }
}
