package com.tencent.qqnt.audio;

import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import mqq.app.AppActivity;

/* compiled from: P */
/* loaded from: classes23.dex */
public class o {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f352544a;

    /* renamed from: b, reason: collision with root package name */
    public int f352545b;

    /* renamed from: c, reason: collision with root package name */
    public AppActivity f352546c;

    /* renamed from: d, reason: collision with root package name */
    public AppInterface f352547d;

    /* renamed from: e, reason: collision with root package name */
    public View f352548e;

    /* renamed from: f, reason: collision with root package name */
    public n f352549f;

    public o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
