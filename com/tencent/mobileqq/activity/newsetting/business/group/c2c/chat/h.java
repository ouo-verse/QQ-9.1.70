package com.tencent.mobileqq.activity.newsetting.business.group.c2c.chat;

import android.content.Context;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.newsetting.business.group.c2c.chat.g;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.x;

/* compiled from: P */
/* loaded from: classes10.dex */
public class h extends com.tencent.mobileqq.activity.newsetting.custom.group.a {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.mobileqq.activity.newsetting.custom.config.b f183537e;

    /* renamed from: f, reason: collision with root package name */
    private g.b f183538f;

    /* renamed from: g, reason: collision with root package name */
    private com.tencent.mobileqq.activity.newsetting.custom.config.b f183539g;

    /* renamed from: h, reason: collision with root package name */
    private com.tencent.mobileqq.activity.newsetting.custom.config.b f183540h;

    /* renamed from: i, reason: collision with root package name */
    private com.tencent.mobileqq.activity.newsetting.custom.config.b f183541i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a extends com.tencent.mobileqq.activity.newsetting.custom.config.b<x.b.d, x.c.g> {
        static IPatchRedirector $redirector_;

        a(x.b bVar, x.c cVar, QUIListItemAdapter qUIListItemAdapter) {
            super(bVar, cVar, qUIListItemAdapter);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, h.this, bVar, cVar, qUIListItemAdapter);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class b extends com.tencent.mobileqq.activity.newsetting.custom.config.b<x.b.d, x.c.f> {
        static IPatchRedirector $redirector_;

        b(x.b bVar, x.c cVar, QUIListItemAdapter qUIListItemAdapter) {
            super(bVar, cVar, qUIListItemAdapter);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, h.this, bVar, cVar, qUIListItemAdapter);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class c extends com.tencent.mobileqq.activity.newsetting.custom.config.b<x.b.d, x.c.f> {
        static IPatchRedirector $redirector_;

        c(x.b bVar, x.c cVar, QUIListItemAdapter qUIListItemAdapter) {
            super(bVar, cVar, qUIListItemAdapter);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, h.this, bVar, cVar, qUIListItemAdapter);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class d extends com.tencent.mobileqq.activity.newsetting.custom.config.b<x.b.d, x.c.f> {
        static IPatchRedirector $redirector_;

        d(x.b bVar, x.c cVar, QUIListItemAdapter qUIListItemAdapter) {
            super(bVar, cVar, qUIListItemAdapter);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, h.this, bVar, cVar, qUIListItemAdapter);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class e extends g.b {
        static IPatchRedirector $redirector_;

        e(x.b bVar, x.c cVar, QUIListItemAdapter qUIListItemAdapter) {
            super(bVar, cVar, qUIListItemAdapter);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, h.this, bVar, cVar, qUIListItemAdapter);
            }
        }
    }

    public h(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    @NonNull
    private x<x.b.d, x.c.f> j() {
        c cVar = new c(new x.b.d(g(R.string.iwm)), new x.c.f(false, null), f());
        this.f183539g = cVar;
        return cVar;
    }

    @NonNull
    private x<x.b.d, x.c.f> l() {
        b bVar = new b(new x.b.d(g(R.string.iur)), new x.c.f(false, null), f());
        this.f183540h = bVar;
        return bVar;
    }

    @NonNull
    private x<x.b.d, x.c.g> n() {
        a aVar = new a(new x.b.d(g(R.string.f171422np)), new x.c.g(g(R.string.f173111vr2), true, false), f());
        this.f183541i = aVar;
        return aVar;
    }

    @NonNull
    private x<x.b.d, x.c.f> p() {
        d dVar = new d(new x.b.d(g(R.string.d4j)), new x.c.f(false, null), f());
        this.f183537e = dVar;
        return dVar;
    }

    @NonNull
    private g.b r() {
        e eVar = new e(new x.b.d(g(R.string.f172976g92)), new x.c.g(g(R.string.hbd), true, false), f());
        this.f183538f = eVar;
        return eVar;
    }

    @Override // com.tencent.mobileqq.activity.newsetting.custom.group.a
    public Group c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Group) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new Group(p(), r(), j(), l(), n());
    }

    public com.tencent.mobileqq.activity.newsetting.custom.config.b k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (com.tencent.mobileqq.activity.newsetting.custom.config.b) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.f183539g;
    }

    public com.tencent.mobileqq.activity.newsetting.custom.config.b m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.mobileqq.activity.newsetting.custom.config.b) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.f183540h;
    }

    public com.tencent.mobileqq.activity.newsetting.custom.config.b o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (com.tencent.mobileqq.activity.newsetting.custom.config.b) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.f183541i;
    }

    public com.tencent.mobileqq.activity.newsetting.custom.config.b q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.mobileqq.activity.newsetting.custom.config.b) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f183537e;
    }

    public g.b s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (g.b) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f183538f;
    }
}
