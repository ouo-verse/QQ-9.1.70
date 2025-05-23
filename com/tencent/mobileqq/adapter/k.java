package com.tencent.mobileqq.adapter;

import android.widget.ImageView;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.widget.SwipRightMenuBuilder;

/* compiled from: P */
/* loaded from: classes10.dex */
public class k extends SwipRightMenuBuilder.SwipItemBaseHolder {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public String f187210d;

    /* renamed from: e, reason: collision with root package name */
    public int f187211e;

    /* renamed from: f, reason: collision with root package name */
    public ImageView f187212f;

    /* renamed from: h, reason: collision with root package name */
    public QQProAvatarView f187213h;

    public k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f187211e = 1;
        }
    }
}
