package com.tencent.mobileqq.troop.filemanager.data;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    String f295787a;

    /* renamed from: b, reason: collision with root package name */
    String f295788b;

    /* renamed from: c, reason: collision with root package name */
    int f295789c;

    public a(Context context, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, str, str2);
            return;
        }
        this.f295787a = str;
        this.f295788b = str2;
        this.f295789c = str2.length();
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        if (this.f295787a != null) {
            sb5.append(", hanzi = " + this.f295787a);
        }
        if (this.f295788b != null) {
            sb5.append(", pinyin = " + this.f295788b);
        }
        return sb5.toString();
    }
}
