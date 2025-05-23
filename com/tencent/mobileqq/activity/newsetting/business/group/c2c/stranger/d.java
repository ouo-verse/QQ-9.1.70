package com.tencent.mobileqq.activity.newsetting.business.group.c2c.stranger;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.w;

/* compiled from: P */
/* loaded from: classes10.dex */
public class d extends com.tencent.mobileqq.activity.newsetting.custom.group.a {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    private a f183591e;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class a extends com.tencent.mobileqq.activity.newsetting.custom.config.a {
        static IPatchRedirector $redirector_;

        /* renamed from: p, reason: collision with root package name */
        private com.tencent.mobileqq.activity.newsetting.custom.item.d f183592p;

        /* renamed from: q, reason: collision with root package name */
        private com.tencent.mobileqq.activity.newsetting.custom.item.d<QQProAvatarView> f183593q;

        /* renamed from: r, reason: collision with root package name */
        private com.tencent.mobileqq.activity.newsetting.custom.item.d<ImageView> f183594r;

        /* renamed from: s, reason: collision with root package name */
        private com.tencent.mobileqq.activity.newsetting.custom.item.c f183595s;

        public a(int i3, QUIListItemAdapter qUIListItemAdapter) {
            super(i3, qUIListItemAdapter);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) qUIListItemAdapter);
                return;
            }
            this.f183592p = new com.tencent.mobileqq.activity.newsetting.custom.item.d();
            this.f183593q = new com.tencent.mobileqq.activity.newsetting.custom.item.d<>();
            this.f183594r = new com.tencent.mobileqq.activity.newsetting.custom.item.d<>();
            this.f183595s = new com.tencent.mobileqq.activity.newsetting.custom.item.c();
        }

        @Override // com.tencent.mobileqq.activity.newsetting.custom.config.a
        protected View J(@NonNull View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
            this.f183592p.h(view);
            this.f183593q.h((QQProAvatarView) view.findViewById(R.id.f166920j43));
            this.f183594r.h((ImageView) view.findViewById(R.id.f166919j42));
            this.f183595s.h((TextView) view.findViewById(R.id.f166917j40));
            return view;
        }

        public com.tencent.mobileqq.activity.newsetting.custom.item.c S() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (com.tencent.mobileqq.activity.newsetting.custom.item.c) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return this.f183595s;
        }

        public com.tencent.mobileqq.activity.newsetting.custom.item.d<ImageView> T() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (com.tencent.mobileqq.activity.newsetting.custom.item.d) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return this.f183594r;
        }

        public com.tencent.mobileqq.activity.newsetting.custom.item.d<QQProAvatarView> U() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (com.tencent.mobileqq.activity.newsetting.custom.item.d) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.f183593q;
        }
    }

    public d(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    @NonNull
    private w<? extends View> k() {
        a aVar = new a(R.layout.e2j, f());
        this.f183591e = aVar;
        return aVar;
    }

    @Override // com.tencent.mobileqq.activity.newsetting.custom.group.a
    public Group c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Group) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new Group(k());
    }

    public a j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (a) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f183591e;
    }
}
