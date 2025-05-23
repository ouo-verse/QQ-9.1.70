package com.tencent.mobileqq.activity.newsetting.business.group.notify;

import android.content.Context;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.settings.business.api.IGrowthPushSwitchApi;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.c;
import com.tencent.mobileqq.widget.listitem.x;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a extends com.tencent.mobileqq.activity.newsetting.custom.group.a {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.mobileqq.activity.newsetting.custom.config.b f183625e;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.mobileqq.activity.newsetting.custom.config.b f183626f;

    /* renamed from: g, reason: collision with root package name */
    private com.tencent.mobileqq.activity.newsetting.custom.config.b f183627g;

    /* renamed from: h, reason: collision with root package name */
    private com.tencent.mobileqq.activity.newsetting.custom.config.b f183628h;

    /* renamed from: i, reason: collision with root package name */
    private com.tencent.mobileqq.widget.listitem.c f183629i;

    /* renamed from: j, reason: collision with root package name */
    private String f183630j;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.activity.newsetting.business.group.notify.a$a, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    class C7182a extends com.tencent.mobileqq.activity.newsetting.custom.config.b {
        static IPatchRedirector $redirector_;

        C7182a(x.b bVar, x.c cVar, QUIListItemAdapter qUIListItemAdapter) {
            super(bVar, cVar, qUIListItemAdapter);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, a.this, bVar, cVar, qUIListItemAdapter);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class b extends com.tencent.mobileqq.activity.newsetting.custom.config.b {
        static IPatchRedirector $redirector_;

        b(x.b bVar, x.c cVar, QUIListItemAdapter qUIListItemAdapter) {
            super(bVar, cVar, qUIListItemAdapter);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, a.this, bVar, cVar, qUIListItemAdapter);
            }
        }
    }

    public a(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    private static boolean o() {
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
        C7182a c7182a = new C7182a(new x.b.C8996b(g(R.string.f230116y_), R.drawable.qui_remind), new x.c.f(false, null), f());
        this.f183625e = c7182a;
        c7182a.c0(g(R.string.f230116y_));
        com.tencent.mobileqq.activity.newsetting.custom.config.b bVar = new com.tencent.mobileqq.activity.newsetting.custom.config.b(new x.b.C8996b(g(R.string.f173109vr0), R.drawable.qui_eye_on), new x.c.f(false, null), f());
        this.f183626f = bVar;
        bVar.c0(g(R.string.f173109vr0));
        b bVar2 = new b(new x.b.C8996b(g(R.string.f171097c62), R.drawable.qui_message_alert), new x.c.f(false, null), f());
        this.f183627g = bVar2;
        bVar2.c0(g(R.string.f171097c62));
        com.tencent.mobileqq.activity.newsetting.custom.config.b bVar3 = new com.tencent.mobileqq.activity.newsetting.custom.config.b(new x.b.C8996b(g(R.string.iio), R.drawable.qui_telephone), new x.c.f(false, null), f());
        this.f183628h = bVar3;
        bVar3.c0(g(R.string.iio));
        String str = this.f183630j;
        if (str == null || str.length() == 0) {
            this.f183630j = g(R.string.f174902x4);
        }
        this.f183629i = new com.tencent.mobileqq.widget.listitem.c(new c.a.b(g(R.string.f20411521), this.f183630j, R.drawable.qui_wechat), new c.b.C8995c("", true, false));
        ((IGrowthPushSwitchApi) QRoute.api(IGrowthPushSwitchApi.class)).reportTabExposure();
        if (o()) {
            return new Group("\u672a\u6253\u5f00QQ\u65f6", this.f183625e, this.f183626f, this.f183628h, this.f183629i);
        }
        return new Group("\u672a\u6253\u5f00QQ\u65f6", this.f183625e, this.f183626f, this.f183628h);
    }

    public com.tencent.mobileqq.activity.newsetting.custom.config.b j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.mobileqq.activity.newsetting.custom.config.b) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f183628h;
    }

    public com.tencent.mobileqq.activity.newsetting.custom.config.b k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.mobileqq.activity.newsetting.custom.config.b) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.f183627g;
    }

    public com.tencent.mobileqq.activity.newsetting.custom.config.b l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (com.tencent.mobileqq.activity.newsetting.custom.config.b) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.f183626f;
    }

    public com.tencent.mobileqq.activity.newsetting.custom.config.b m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.mobileqq.activity.newsetting.custom.config.b) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f183625e;
    }

    public com.tencent.mobileqq.widget.listitem.c n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (com.tencent.mobileqq.widget.listitem.c) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        if (o()) {
            return this.f183629i;
        }
        return null;
    }

    public void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            f().l0(this.f183629i);
        }
    }

    public void q(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
            return;
        }
        if (str != null && str.length() != 0) {
            this.f183630j = str;
        } else {
            this.f183630j = g(R.string.f174902x4);
        }
        if (this.f183629i.K() instanceof c.a.b) {
            ((c.a.b) this.f183629i.K()).c(str);
            f().l0(this.f183629i);
        }
    }
}
