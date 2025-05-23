package com.tencent.mobileqq.activity.newsetting.business.group.notify;

import android.content.Context;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.c;
import com.tencent.mobileqq.widget.listitem.x;

/* compiled from: P */
/* loaded from: classes10.dex */
public class b extends com.tencent.mobileqq.activity.newsetting.custom.group.a {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.mobileqq.activity.newsetting.custom.config.b f183633e;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.mobileqq.activity.newsetting.custom.config.b f183634f;

    /* renamed from: g, reason: collision with root package name */
    private com.tencent.mobileqq.activity.newsetting.custom.config.b f183635g;

    /* renamed from: h, reason: collision with root package name */
    private com.tencent.mobileqq.activity.newsetting.custom.config.b f183636h;

    /* renamed from: i, reason: collision with root package name */
    private com.tencent.mobileqq.widget.listitem.c f183637i;

    public b(Context context) {
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
        com.tencent.mobileqq.activity.newsetting.custom.config.b bVar = new com.tencent.mobileqq.activity.newsetting.custom.config.b(new x.b.C8996b(g(R.string.cz4), R.drawable.qui_voice_high), new x.c.g("", true, false), f());
        this.f183633e = bVar;
        bVar.c0(g(R.string.vra));
        this.f183634f = new com.tencent.mobileqq.activity.newsetting.custom.config.b(new x.b.C8996b(g(R.string.f226596or), R.drawable.qui_shake), new x.c.g("", true, false), f());
        com.tencent.mobileqq.activity.newsetting.custom.config.b bVar2 = new com.tencent.mobileqq.activity.newsetting.custom.config.b(new x.b.C8996b(g(R.string.cz7), R.drawable.qui_shield), new x.c.f(false, null), f());
        this.f183635g = bVar2;
        bVar2.c0(g(R.string.cz7));
        com.tencent.mobileqq.widget.listitem.c cVar = new com.tencent.mobileqq.widget.listitem.c(new c.a.b(g(R.string.cz7), "\u6253\u5f00\u540e\u5728\u6307\u5b9a\u65f6\u95f4\u5185\u4e0d\u63a5\u6536\u4fe1\u606f\u63a8\u9001", R.drawable.qui_shield), new c.b.C8994b(false, null));
        this.f183637i = cVar;
        com.tencent.mobileqq.activity.newsetting.custom.config.b bVar3 = new com.tencent.mobileqq.activity.newsetting.custom.config.b(new x.b.C8996b(g(R.string.cz8), R.drawable.qui_time), new x.c.g(g(R.string.cz8), true, false), f());
        this.f183636h = bVar3;
        bVar3.c0(g(R.string.cz8));
        return new Group("\u63d0\u9192\u65b9\u5f0f", this.f183633e, this.f183634f, cVar, this.f183636h);
    }

    public com.tencent.mobileqq.widget.listitem.c j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.mobileqq.widget.listitem.c) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.f183637i;
    }

    public com.tencent.mobileqq.activity.newsetting.custom.config.b k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (com.tencent.mobileqq.activity.newsetting.custom.config.b) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.f183636h;
    }

    public com.tencent.mobileqq.activity.newsetting.custom.config.b l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.mobileqq.activity.newsetting.custom.config.b) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f183633e;
    }

    public com.tencent.mobileqq.activity.newsetting.custom.config.b m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.mobileqq.activity.newsetting.custom.config.b) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f183634f;
    }
}
