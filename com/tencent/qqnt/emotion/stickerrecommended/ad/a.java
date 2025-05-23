package com.tencent.qqnt.emotion.stickerrecommended.ad;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes24.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public boolean f356432a;

    /* renamed from: b, reason: collision with root package name */
    public int f356433b;

    /* renamed from: c, reason: collision with root package name */
    public List<d> f356434c;

    public a(boolean z16, int i3, List<d> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), Integer.valueOf(i3), list);
            return;
        }
        this.f356432a = true;
        this.f356433b = i3;
        this.f356434c = list;
    }
}
