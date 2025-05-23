package com.tencent.mobileqq.activity.newsetting.business.group.c2c.chat;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mutualmark.view.MutualMarkIconsView;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.w;

/* compiled from: P */
/* loaded from: classes10.dex */
public class f extends com.tencent.mobileqq.activity.newsetting.custom.group.a {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    private b f183522e;

    /* renamed from: f, reason: collision with root package name */
    private a f183523f;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class a extends com.tencent.mobileqq.activity.newsetting.custom.config.a {
        static IPatchRedirector $redirector_;

        /* renamed from: p, reason: collision with root package name */
        private com.tencent.mobileqq.activity.newsetting.custom.item.d<View> f183524p;

        /* renamed from: q, reason: collision with root package name */
        private com.tencent.mobileqq.activity.newsetting.custom.item.b f183525q;

        public a(int i3, QUIListItemAdapter qUIListItemAdapter) {
            super(i3, qUIListItemAdapter);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) qUIListItemAdapter);
            } else {
                this.f183524p = new com.tencent.mobileqq.activity.newsetting.custom.item.d<>();
                this.f183525q = new com.tencent.mobileqq.activity.newsetting.custom.item.b();
            }
        }

        @Override // com.tencent.mobileqq.activity.newsetting.custom.config.a
        protected View J(@NonNull View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
            this.f183524p.h(view);
            this.f183525q.h((ImageView) view.findViewById(R.id.f164018h1));
            return view;
        }

        public com.tencent.mobileqq.activity.newsetting.custom.item.b S() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (com.tencent.mobileqq.activity.newsetting.custom.item.b) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.f183525q;
        }

        public com.tencent.mobileqq.activity.newsetting.custom.item.d<View> T() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (com.tencent.mobileqq.activity.newsetting.custom.item.d) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.f183524p;
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class b extends com.tencent.mobileqq.activity.newsetting.custom.config.a {
        static IPatchRedirector $redirector_;

        /* renamed from: p, reason: collision with root package name */
        private com.tencent.mobileqq.activity.newsetting.custom.item.d<View> f183526p;

        /* renamed from: q, reason: collision with root package name */
        private com.tencent.mobileqq.activity.newsetting.custom.item.d<QQProAvatarView> f183527q;

        /* renamed from: r, reason: collision with root package name */
        private com.tencent.mobileqq.activity.newsetting.custom.item.c f183528r;

        /* renamed from: s, reason: collision with root package name */
        private com.tencent.mobileqq.activity.newsetting.custom.item.b f183529s;

        /* renamed from: t, reason: collision with root package name */
        private com.tencent.mobileqq.activity.newsetting.custom.item.d<MutualMarkIconsView> f183530t;

        /* renamed from: u, reason: collision with root package name */
        private com.tencent.mobileqq.activity.newsetting.custom.item.d<View> f183531u;

        public b(int i3, QUIListItemAdapter qUIListItemAdapter) {
            super(i3, qUIListItemAdapter);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) qUIListItemAdapter);
                return;
            }
            this.f183526p = new com.tencent.mobileqq.activity.newsetting.custom.item.d<>();
            this.f183527q = new com.tencent.mobileqq.activity.newsetting.custom.item.d<>();
            this.f183528r = new com.tencent.mobileqq.activity.newsetting.custom.item.c();
            this.f183529s = new com.tencent.mobileqq.activity.newsetting.custom.item.b();
            this.f183530t = new com.tencent.mobileqq.activity.newsetting.custom.item.d<>();
            this.f183531u = new com.tencent.mobileqq.activity.newsetting.custom.item.d<>();
        }

        @Override // com.tencent.mobileqq.activity.newsetting.custom.config.a
        protected View J(@NonNull View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
            this.f183526p.h(view);
            this.f183527q.h((QQProAvatarView) view.findViewById(R.id.clv));
            this.f183528r.h((TextView) view.findViewById(R.id.clx));
            this.f183529s.h((ImageView) view.findViewById(R.id.kyu));
            this.f183529s.e("\u4f1a\u5458\u94ed\u724c");
            this.f183530t.h((MutualMarkIconsView) view.findViewById(R.id.lwx));
            this.f183531u.h(view.findViewById(R.id.y8h));
            return view;
        }

        public com.tencent.mobileqq.activity.newsetting.custom.item.d<QQProAvatarView> S() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (com.tencent.mobileqq.activity.newsetting.custom.item.d) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.f183527q;
        }

        public com.tencent.mobileqq.activity.newsetting.custom.item.d<View> T() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (com.tencent.mobileqq.activity.newsetting.custom.item.d) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.f183526p;
        }

        public com.tencent.mobileqq.activity.newsetting.custom.item.c U() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (com.tencent.mobileqq.activity.newsetting.custom.item.c) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return this.f183528r;
        }

        public com.tencent.mobileqq.activity.newsetting.custom.item.d<MutualMarkIconsView> V() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (com.tencent.mobileqq.activity.newsetting.custom.item.d) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return this.f183530t;
        }

        public com.tencent.mobileqq.activity.newsetting.custom.item.d<View> W() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (com.tencent.mobileqq.activity.newsetting.custom.item.d) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            return this.f183531u;
        }

        public com.tencent.mobileqq.activity.newsetting.custom.item.b X() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (com.tencent.mobileqq.activity.newsetting.custom.item.b) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return this.f183529s;
        }
    }

    public f(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    @NonNull
    private w<? extends View> j() {
        a aVar = new a(R.layout.e1j, f());
        this.f183523f = aVar;
        return aVar;
    }

    @NonNull
    private w<? extends View> m() {
        b bVar = new b(R.layout.e1l, f());
        this.f183522e = bVar;
        return bVar;
    }

    @Override // com.tencent.mobileqq.activity.newsetting.custom.group.a
    public Group c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Group) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new Group(m(), j());
    }

    public a k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (a) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f183523f;
    }

    public b l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (b) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f183522e;
    }
}
