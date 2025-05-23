package com.tencent.mobileqq.activity.qqsettingme.bean;

import MQQ.LhLogoResources;
import android.graphics.drawable.Drawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes10.dex */
public class i {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public boolean f184910a;

    /* renamed from: b, reason: collision with root package name */
    public LhLogoResources f184911b;

    /* renamed from: c, reason: collision with root package name */
    public URLDrawable f184912c;

    /* renamed from: d, reason: collision with root package name */
    public Drawable f184913d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f184914e;

    public i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
