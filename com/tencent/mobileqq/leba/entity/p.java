package com.tencent.mobileqq.leba.entity;

import android.content.Context;
import com.tencent.mobileqq.leba.redtouch.LebaRedTouch;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.tianshu.ui.RedTouch;

/* compiled from: P */
/* loaded from: classes15.dex */
public class p {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public Context f240520a;

    /* renamed from: b, reason: collision with root package name */
    public RedTouch f240521b;

    /* renamed from: c, reason: collision with root package name */
    public LebaRedTouch f240522c;

    /* renamed from: d, reason: collision with root package name */
    public long f240523d;

    /* renamed from: e, reason: collision with root package name */
    public String f240524e;

    /* renamed from: f, reason: collision with root package name */
    public int f240525f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f240526g;

    public p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
