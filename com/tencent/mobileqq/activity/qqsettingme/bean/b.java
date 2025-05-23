package com.tencent.mobileqq.activity.qqsettingme.bean;

import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.text.QQText;

/* compiled from: P */
/* loaded from: classes10.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f184875a;

    /* renamed from: b, reason: collision with root package name */
    public QQText f184876b;

    /* renamed from: c, reason: collision with root package name */
    public URLDrawable f184877c;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
