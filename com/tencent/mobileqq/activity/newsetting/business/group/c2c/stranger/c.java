package com.tencent.mobileqq.activity.newsetting.business.group.c2c.stranger;

import android.content.Context;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.x;

/* compiled from: P */
/* loaded from: classes10.dex */
public class c extends com.tencent.mobileqq.activity.newsetting.custom.group.a {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.mobileqq.activity.newsetting.custom.config.b f183589e;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a extends com.tencent.mobileqq.activity.newsetting.custom.config.b<x.b.d, x.c.C8997c> {
        static IPatchRedirector $redirector_;

        a(x.b bVar, x.c cVar, QUIListItemAdapter qUIListItemAdapter) {
            super(bVar, cVar, qUIListItemAdapter);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, c.this, bVar, cVar, qUIListItemAdapter);
            }
        }
    }

    public c(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    @Override // com.tencent.mobileqq.activity.newsetting.custom.group.a
    protected Group c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Group) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        this.f183589e = new a(new x.b.d(g(R.string.a2p)), new x.c.f(false, null), f());
        return new Group(this.f183589e);
    }

    public com.tencent.mobileqq.activity.newsetting.custom.config.b j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.mobileqq.activity.newsetting.custom.config.b) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f183589e;
    }
}
