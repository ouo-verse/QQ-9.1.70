package com.tencent.mobileqq.activity.contact.troop;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes10.dex */
public class b extends com.tencent.mobileqq.troop.adapter.base.c {
    static IPatchRedirector $redirector_;
    public ImageView C;
    public TextView D;
    public TextView E;
    public Button F;
    public int G;
    public String H;

    /* renamed from: h, reason: collision with root package name */
    public long f181387h;

    /* renamed from: i, reason: collision with root package name */
    public String f181388i;

    /* renamed from: m, reason: collision with root package name */
    public LinearLayout f181389m;

    public b(Context context, View view) {
        super(context, view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) view);
        }
    }
}
