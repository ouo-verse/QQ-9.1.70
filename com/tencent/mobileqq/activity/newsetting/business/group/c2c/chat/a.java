package com.tencent.mobileqq.activity.newsetting.business.group.c2c.chat;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a extends com.tencent.mobileqq.activity.newsetting.custom.group.a {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    private C7175a f183509e;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.activity.newsetting.business.group.c2c.chat.a$a, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C7175a extends com.tencent.mobileqq.activity.newsetting.custom.config.a {
        static IPatchRedirector $redirector_;

        /* renamed from: p, reason: collision with root package name */
        private com.tencent.mobileqq.activity.newsetting.custom.item.d f183510p;

        /* renamed from: q, reason: collision with root package name */
        private com.tencent.mobileqq.activity.newsetting.custom.item.c f183511q;

        /* renamed from: r, reason: collision with root package name */
        private com.tencent.mobileqq.activity.newsetting.custom.item.c f183512r;

        /* renamed from: s, reason: collision with root package name */
        private com.tencent.mobileqq.activity.newsetting.custom.item.c f183513s;

        /* renamed from: t, reason: collision with root package name */
        private WeakReference<QUIListItemAdapter> f183514t;

        public C7175a(int i3, QUIListItemAdapter qUIListItemAdapter) {
            super(i3, qUIListItemAdapter);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) qUIListItemAdapter);
                return;
            }
            this.f183514t = new WeakReference<>(qUIListItemAdapter);
            this.f183510p = new com.tencent.mobileqq.activity.newsetting.custom.item.d();
            this.f183511q = new com.tencent.mobileqq.activity.newsetting.custom.item.c();
            this.f183512r = new com.tencent.mobileqq.activity.newsetting.custom.item.c();
            this.f183513s = new com.tencent.mobileqq.activity.newsetting.custom.item.c();
        }

        @Override // com.tencent.mobileqq.activity.newsetting.custom.config.a
        protected View J(@NonNull View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
            this.f183510p.h(view);
            this.f183511q.h((TextView) view.findViewById(R.id.f72853rz));
            this.f183512r.h((TextView) view.findViewById(R.id.bfm));
            this.f183513s.h((TextView) view.findViewById(R.id.f164710ao0));
            return view;
        }

        public com.tencent.mobileqq.activity.newsetting.custom.item.c S() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (com.tencent.mobileqq.activity.newsetting.custom.item.c) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return this.f183513s;
        }

        public com.tencent.mobileqq.activity.newsetting.custom.item.c T() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (com.tencent.mobileqq.activity.newsetting.custom.item.c) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.f183512r;
        }

        public com.tencent.mobileqq.activity.newsetting.custom.item.c U() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (com.tencent.mobileqq.activity.newsetting.custom.item.c) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.f183511q;
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
    public Group c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Group) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        C7175a c7175a = new C7175a(R.layout.e1k, f());
        this.f183509e = c7175a;
        return Group.INSTANCE.d(c7175a);
    }

    public C7175a j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (C7175a) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f183509e;
    }
}
