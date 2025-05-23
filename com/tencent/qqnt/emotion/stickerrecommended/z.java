package com.tencent.qqnt.emotion.stickerrecommended;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes24.dex */
public class z {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f356672a;

    /* renamed from: b, reason: collision with root package name */
    public String f356673b;

    /* renamed from: c, reason: collision with root package name */
    public String f356674c;

    /* renamed from: d, reason: collision with root package name */
    public List<? extends g> f356675d;

    /* renamed from: e, reason: collision with root package name */
    public List<? extends g> f356676e;

    public z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f356672a = 0;
        }
    }
}
