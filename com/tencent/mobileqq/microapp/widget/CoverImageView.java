package com.tencent.mobileqq.microapp.widget;

import android.content.Context;
import android.widget.ImageView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class CoverImageView extends ImageView {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f246072a;

    public CoverImageView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }
}
