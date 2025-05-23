package com.tencent.mobileqq.selectmember;

import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mobileqq.adapter.k;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes18.dex */
public class f extends k {
    static IPatchRedirector $redirector_;
    public CheckBox C;
    public Object D;

    /* renamed from: i, reason: collision with root package name */
    public TextView f285963i;

    /* renamed from: m, reason: collision with root package name */
    public TextView f285964m;

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
