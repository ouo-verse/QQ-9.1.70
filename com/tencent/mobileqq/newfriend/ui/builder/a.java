package com.tencent.mobileqq.newfriend.ui.builder;

import android.widget.ImageView;
import com.tencent.mobileqq.newfriend.ui.builder.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a extends d.b {
    static IPatchRedirector $redirector_;
    public ImageView I;
    public ImageView J;
    public ImageView K;
    public ImageView L;
    public ImageView M;
    public String N;
    public String P;
    public String Q;
    public String R;
    public String S;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
