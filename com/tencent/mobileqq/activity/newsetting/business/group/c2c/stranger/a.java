package com.tencent.mobileqq.activity.newsetting.business.group.c2c.stranger;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a extends com.tencent.mobileqq.activity.newsetting.custom.group.a {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    private b f183578e;

    /* renamed from: f, reason: collision with root package name */
    private C7178a f183579f;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.activity.newsetting.business.group.c2c.stranger.a$a, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C7178a extends com.tencent.mobileqq.activity.newsetting.custom.config.a {
        static IPatchRedirector $redirector_;

        /* renamed from: p, reason: collision with root package name */
        private final com.tencent.mobileqq.activity.newsetting.custom.item.c f183580p;

        /* renamed from: q, reason: collision with root package name */
        private final com.tencent.mobileqq.activity.newsetting.custom.item.a f183581q;

        /* renamed from: r, reason: collision with root package name */
        private final com.tencent.mobileqq.activity.newsetting.custom.item.a f183582r;

        /* renamed from: s, reason: collision with root package name */
        private final com.tencent.mobileqq.activity.newsetting.custom.item.c f183583s;

        /* renamed from: t, reason: collision with root package name */
        private final com.tencent.mobileqq.activity.newsetting.custom.item.c f183584t;

        public C7178a(int i3, QUIListItemAdapter qUIListItemAdapter) {
            super(i3, qUIListItemAdapter);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) qUIListItemAdapter);
                return;
            }
            this.f183580p = new com.tencent.mobileqq.activity.newsetting.custom.item.c();
            this.f183581q = new com.tencent.mobileqq.activity.newsetting.custom.item.a();
            this.f183582r = new com.tencent.mobileqq.activity.newsetting.custom.item.a();
            this.f183583s = new com.tencent.mobileqq.activity.newsetting.custom.item.c();
            this.f183584t = new com.tencent.mobileqq.activity.newsetting.custom.item.c();
        }

        @Override // com.tencent.mobileqq.activity.newsetting.custom.config.a
        protected View J(@NonNull View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
            this.f183580p.h((TextView) view.findViewById(R.id.f72873s1));
            this.f183581q.h((QUIButton) view.findViewById(R.id.f166918j41));
            this.f183582r.h((QUIButton) view.findViewById(R.id.aki));
            TextView textView = (TextView) view.findViewById(R.id.f166922j45);
            if (textView.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) textView.getLayoutParams()).setMargins(0, BaseAIOUtils.f(5.0f, textView.getResources()), 0, 0);
            }
            this.f183583s.h((TextView) view.findViewById(R.id.f166922j45));
            this.f183584t.h((TextView) view.findViewById(R.id.f88574xf));
            return view;
        }

        public com.tencent.mobileqq.activity.newsetting.custom.item.a S() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (com.tencent.mobileqq.activity.newsetting.custom.item.a) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return this.f183582r;
        }

        public com.tencent.mobileqq.activity.newsetting.custom.item.c T() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (com.tencent.mobileqq.activity.newsetting.custom.item.c) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.f183580p;
        }

        public com.tencent.mobileqq.activity.newsetting.custom.item.a U() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (com.tencent.mobileqq.activity.newsetting.custom.item.a) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.f183581q;
        }

        public com.tencent.mobileqq.activity.newsetting.custom.item.c V() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (com.tencent.mobileqq.activity.newsetting.custom.item.c) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return this.f183584t;
        }

        public com.tencent.mobileqq.activity.newsetting.custom.item.c W() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (com.tencent.mobileqq.activity.newsetting.custom.item.c) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return this.f183583s;
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class b extends com.tencent.mobileqq.activity.newsetting.custom.config.a {
        static IPatchRedirector $redirector_;

        /* renamed from: p, reason: collision with root package name */
        private final com.tencent.mobileqq.activity.newsetting.custom.item.a f183585p;

        /* renamed from: q, reason: collision with root package name */
        private final com.tencent.mobileqq.activity.newsetting.custom.item.a f183586q;

        public b(int i3, QUIListItemAdapter qUIListItemAdapter) {
            super(i3, qUIListItemAdapter);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) qUIListItemAdapter);
            } else {
                this.f183585p = new com.tencent.mobileqq.activity.newsetting.custom.item.a();
                this.f183586q = new com.tencent.mobileqq.activity.newsetting.custom.item.a();
            }
        }

        @Override // com.tencent.mobileqq.activity.newsetting.custom.config.a
        protected View J(@NonNull View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
            this.f183585p.h((QUIButton) view.findViewById(R.id.zok));
            this.f183586q.h((QUIButton) view.findViewById(R.id.zoi));
            return view;
        }
    }

    public a(Context context) {
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
        this.f183578e = new b(R.layout.e2i, f());
        C7178a c7178a = new C7178a(R.layout.e2h, f());
        this.f183579f = c7178a;
        return Group.INSTANCE.d(this.f183578e, c7178a);
    }

    public C7178a j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (C7178a) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f183579f;
    }

    public b k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (b) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f183578e;
    }
}
