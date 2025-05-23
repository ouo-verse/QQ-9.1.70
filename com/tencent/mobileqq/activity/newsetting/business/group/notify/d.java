package com.tencent.mobileqq.activity.newsetting.business.group.notify;

import android.content.Context;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.x;

/* compiled from: P */
/* loaded from: classes10.dex */
public class d extends com.tencent.mobileqq.activity.newsetting.custom.group.a {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.mobileqq.activity.newsetting.custom.config.b f183639e;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.mobileqq.activity.newsetting.custom.config.b f183640f;

    public d(Context context) {
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
        com.tencent.mobileqq.activity.newsetting.custom.config.b bVar = new com.tencent.mobileqq.activity.newsetting.custom.config.b(new x.b.C8996b(g(R.string.otb), R.drawable.qui_group), new x.c.g("", true, false), f());
        this.f183639e = bVar;
        bVar.c0(g(R.string.otb));
        com.tencent.mobileqq.activity.newsetting.custom.config.b bVar2 = new com.tencent.mobileqq.activity.newsetting.custom.config.b(new x.b.C8996b(g(R.string.f230736zy), R.drawable.qui_message_record), new x.c.g("", true, false), f());
        this.f183640f = bVar2;
        bVar2.c0(g(R.string.f230736zy));
        return new Group(this.f183639e, this.f183640f);
    }
}
