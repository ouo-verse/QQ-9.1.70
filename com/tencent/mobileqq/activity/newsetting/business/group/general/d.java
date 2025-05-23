package com.tencent.mobileqq.activity.newsetting.business.group.general;

import android.content.Context;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.x;

/* compiled from: P */
/* loaded from: classes10.dex */
public class d extends com.tencent.mobileqq.activity.newsetting.custom.group.a {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.mobileqq.activity.newsetting.custom.config.b f183615e;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.mobileqq.activity.newsetting.custom.config.b f183616f;

    /* renamed from: g, reason: collision with root package name */
    private com.tencent.mobileqq.activity.newsetting.custom.config.b f183617g;

    /* renamed from: h, reason: collision with root package name */
    private com.tencent.mobileqq.activity.newsetting.custom.config.b f183618h;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a extends com.tencent.mobileqq.activity.newsetting.custom.config.b<x.b.d, x.c.f> {
        static IPatchRedirector $redirector_;

        a(x.b bVar, x.c cVar, QUIListItemAdapter qUIListItemAdapter) {
            super(bVar, cVar, qUIListItemAdapter);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, d.this, bVar, cVar, qUIListItemAdapter);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class b extends com.tencent.mobileqq.activity.newsetting.custom.config.b<x.b.d, x.c.g> {
        static IPatchRedirector $redirector_;

        b(x.b bVar, x.c cVar, QUIListItemAdapter qUIListItemAdapter) {
            super(bVar, cVar, qUIListItemAdapter);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, d.this, bVar, cVar, qUIListItemAdapter);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class c extends com.tencent.mobileqq.activity.newsetting.custom.config.b {
        static IPatchRedirector $redirector_;

        c(x.b bVar, x.c cVar, QUIListItemAdapter qUIListItemAdapter) {
            super(bVar, cVar, qUIListItemAdapter);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, d.this, bVar, cVar, qUIListItemAdapter);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.activity.newsetting.business.group.general.d$d, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    class C7181d extends com.tencent.mobileqq.activity.newsetting.custom.config.b<x.b.d, x.c.g> {
        static IPatchRedirector $redirector_;

        C7181d(x.b bVar, x.c cVar, QUIListItemAdapter qUIListItemAdapter) {
            super(bVar, cVar, qUIListItemAdapter);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, d.this, bVar, cVar, qUIListItemAdapter);
            }
        }
    }

    public d(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    @Override // com.tencent.mobileqq.activity.newsetting.custom.group.a
    public Group c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Group) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        a aVar = new a(new x.b.C8996b(g(R.string.vr7), R.drawable.qui_night_mode), new x.c.f(false, null), f());
        this.f183615e = aVar;
        aVar.c0(g(R.string.vr7));
        b bVar = new b(new x.b.C8996b(g(R.string.hfn), R.drawable.qui_typeface), new x.c.g("", true, false), f());
        this.f183616f = bVar;
        bVar.c0(g(R.string.hfn));
        c cVar = new c(new x.b.C8996b(g(R.string.vqz), R.drawable.qui_edit_imgviewer), new x.c.g("", true, false), f());
        this.f183617g = cVar;
        cVar.c0(g(R.string.vqz));
        this.f183618h = new C7181d(new x.b.C8996b(g(R.string.f225156kv), R.drawable.qui_image), new x.c.g("", true, false), f());
        return new Group(this.f183615e, this.f183616f, this.f183617g, this.f183618h);
    }

    public com.tencent.mobileqq.activity.newsetting.custom.config.b j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.mobileqq.activity.newsetting.custom.config.b) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f183615e;
    }

    public com.tencent.mobileqq.activity.newsetting.custom.config.b k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.mobileqq.activity.newsetting.custom.config.b) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f183616f;
    }

    public com.tencent.mobileqq.activity.newsetting.custom.config.b l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (com.tencent.mobileqq.activity.newsetting.custom.config.b) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.f183617g;
    }

    public com.tencent.mobileqq.activity.newsetting.custom.config.b m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.mobileqq.activity.newsetting.custom.config.b) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.f183618h;
    }
}
