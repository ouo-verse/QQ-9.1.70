package com.tencent.mobileqq.activity.newsetting.business.group.c2c.message;

import android.content.Context;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.x;

/* compiled from: P */
/* loaded from: classes10.dex */
public class f extends com.tencent.mobileqq.activity.newsetting.custom.group.a {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.mobileqq.activity.newsetting.custom.config.b f183564e;

    /* renamed from: f, reason: collision with root package name */
    private String f183565f;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a extends com.tencent.mobileqq.activity.newsetting.custom.config.b<x.b.d, x.c.g> {
        static IPatchRedirector $redirector_;

        a(x.b bVar, x.c cVar, QUIListItemAdapter qUIListItemAdapter) {
            super(bVar, cVar, qUIListItemAdapter);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, f.this, bVar, cVar, qUIListItemAdapter);
            }
        }
    }

    public f(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.f183565f = "";
        }
    }

    public static boolean k() {
        com.tencent.mobileqq.wechatMsgAgent.a aVar = (com.tencent.mobileqq.wechatMsgAgent.a) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("105418");
        if (aVar == null || !aVar.f315066d) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.activity.newsetting.custom.group.a
    protected Group c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Group) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        this.f183564e = new a(new x.b.d(g(R.string.f20411521)), new x.c.f(false, null), f());
        return new Group("", g(R.string.f174902x4), this.f183564e);
    }

    public com.tencent.mobileqq.activity.newsetting.custom.config.b j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.mobileqq.activity.newsetting.custom.config.b) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f183564e;
    }
}
