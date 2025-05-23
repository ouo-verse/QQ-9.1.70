package com.tencent.mobileqq.activity.newsetting.business.group.notify;

import android.content.Context;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.settings.business.api.IGrowthPushSwitchApi;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.x;

/* compiled from: P */
/* loaded from: classes10.dex */
public class c extends com.tencent.mobileqq.activity.newsetting.custom.group.a {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.mobileqq.activity.newsetting.custom.config.b f183638e;

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
        com.tencent.mobileqq.activity.newsetting.custom.config.b bVar = new com.tencent.mobileqq.activity.newsetting.custom.config.b(new x.b.C8996b(g(R.string.f159921tm), R.drawable.qui_message_alert), new x.c.f(false, null), f());
        this.f183638e = bVar;
        bVar.c0(g(R.string.f159921tm));
        ((IGrowthPushSwitchApi) QRoute.api(IGrowthPushSwitchApi.class)).reportTabExposure();
        return new Group("\u6253\u5f00QQ\u65f6", this.f183638e);
    }

    public com.tencent.mobileqq.activity.newsetting.custom.config.b j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.mobileqq.activity.newsetting.custom.config.b) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f183638e;
    }
}
