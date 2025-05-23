package com.tencent.mobileqq.activity.newsetting.business.group.general;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.x;

/* compiled from: P */
/* loaded from: classes10.dex */
public class b extends com.tencent.mobileqq.activity.newsetting.custom.group.a {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.mobileqq.activity.newsetting.custom.config.b f183605e;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.mobileqq.activity.newsetting.custom.config.b f183606f;

    /* renamed from: g, reason: collision with root package name */
    private c f183607g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a extends com.tencent.mobileqq.activity.newsetting.custom.config.b<x.b.d, x.c.g> {
        static IPatchRedirector $redirector_;

        a(x.b bVar, x.c cVar, QUIListItemAdapter qUIListItemAdapter) {
            super(bVar, cVar, qUIListItemAdapter);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, b.this, bVar, cVar, qUIListItemAdapter);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.activity.newsetting.business.group.general.b$b, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C7180b extends com.tencent.mobileqq.activity.newsetting.custom.config.b<x.b.d, x.c.g> {
        static IPatchRedirector $redirector_;

        C7180b(x.b bVar, x.c cVar, QUIListItemAdapter qUIListItemAdapter) {
            super(bVar, cVar, qUIListItemAdapter);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, b.this, bVar, cVar, qUIListItemAdapter);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class c extends com.tencent.mobileqq.activity.newsetting.custom.config.a {
        static IPatchRedirector $redirector_;

        /* renamed from: p, reason: collision with root package name */
        private RedTouch f183610p;

        /* renamed from: q, reason: collision with root package name */
        private ImageView f183611q;

        public c(int i3, QUIListItemAdapter qUIListItemAdapter) {
            super(i3, qUIListItemAdapter);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) qUIListItemAdapter);
            }
        }

        @Override // com.tencent.mobileqq.activity.newsetting.custom.config.a
        protected View J(@NonNull View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
            this.f183610p = new RedTouch(view.getContext(), view).setRightMargin(30.0f).applyTo();
            TextView textView = (TextView) view.findViewById(R.id.gus);
            textView.setText(R.string.a1c);
            textView.setContentDescription(view.getContext().getString(R.string.a1c));
            view.setPadding(Utils.n(4.0f, view.getResources()), 0, Utils.n(8.0f, view.getResources()), 0);
            ImageView imageView = (ImageView) view.findViewById(R.id.f83764kf);
            this.f183611q = imageView;
            imageView.setImageResource(R.drawable.qui_time);
            this.f183610p.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            return this.f183610p;
        }

        @Override // com.tencent.mobileqq.activity.newsetting.custom.config.a
        protected int K() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            ImageView imageView = this.f183611q;
            if (imageView != null) {
                return imageView.getWidth();
            }
            return 0;
        }

        public RedTouch S() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (RedTouch) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.f183610p;
        }
    }

    public b(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    @NonNull
    private void m() {
        a aVar = new a(new x.b.C8996b(g(R.string.vqy), R.drawable.qui_download), new x.c.g("", true, false), f());
        this.f183606f = aVar;
        aVar.c0(g(R.string.vqy));
    }

    private void n() {
        this.f183607g = new c(R.layout.h4d, f());
    }

    private void o() {
        this.f183605e = new C7180b(new x.b.C8996b(g(R.string.f171522iz2), R.drawable.qui_storage), new x.c.g(g(R.string.f228646ua), true, false), f());
    }

    @Override // com.tencent.mobileqq.activity.newsetting.custom.group.a
    public Group c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Group) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        o();
        n();
        m();
        return new Group(this.f183605e, this.f183607g, this.f183606f);
    }

    public com.tencent.mobileqq.activity.newsetting.custom.config.b j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (com.tencent.mobileqq.activity.newsetting.custom.config.b) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.f183606f;
    }

    public c k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (c) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f183607g;
    }

    public com.tencent.mobileqq.activity.newsetting.custom.config.b l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.mobileqq.activity.newsetting.custom.config.b) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f183605e;
    }
}
