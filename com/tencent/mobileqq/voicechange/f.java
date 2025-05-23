package com.tencent.mobileqq.voicechange;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.voicechange.IVoiceChangeHelper;

/* compiled from: P */
/* loaded from: classes20.dex */
public class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public b f313162a;

    /* renamed from: b, reason: collision with root package name */
    public d f313163b;

    /* renamed from: c, reason: collision with root package name */
    public QQVoiceChangerThread f313164c;

    /* renamed from: d, reason: collision with root package name */
    public int f313165d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f313166e;

    /* renamed from: f, reason: collision with root package name */
    public IVoiceChangeHelper.a f313167f;

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
