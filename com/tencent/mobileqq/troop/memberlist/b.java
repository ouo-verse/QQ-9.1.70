package com.tencent.mobileqq.troop.memberlist;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.adapter.k;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b extends k {
    static IPatchRedirector $redirector_;
    public TextView C;
    public View D;

    /* renamed from: i, reason: collision with root package name */
    public RelativeLayout f297804i;

    /* renamed from: m, reason: collision with root package name */
    public TextView f297805m;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
