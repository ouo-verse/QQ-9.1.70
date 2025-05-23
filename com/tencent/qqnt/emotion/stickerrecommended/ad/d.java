package com.tencent.qqnt.emotion.stickerrecommended.ad;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes24.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public List<String> f356443a;

    /* renamed from: b, reason: collision with root package name */
    public List<c> f356444b;

    public d(List<String> list, List<c> list2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) list, (Object) list2);
        } else {
            this.f356443a = list;
            this.f356444b = list2;
        }
    }
}
