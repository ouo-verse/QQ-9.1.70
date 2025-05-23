package com.tencent.qqnt.emotion.stickerrecommended.mvvm.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes24.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f356584a;

    /* renamed from: b, reason: collision with root package name */
    public String f356585b;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.f356584a = 0;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "LayoutStatusLiveData{status=" + this.f356584a + ", title='" + this.f356585b + "'}";
    }

    public a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.f356584a = i3;
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
        }
    }
}
