package com.tencent.creatorad.ui.presenter;

import android.view.View;
import android.widget.ImageView;
import com.tencent.creatorad.pb.CreatorReader$ShareAD;
import com.tencent.creatorad.ui.box.c;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.ad.api.IAdApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class g extends com.tencent.creatorad.ui.b {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f100430f;

    /* renamed from: g, reason: collision with root package name */
    private com.tencent.creatorad.ui.box.c f100431g;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) g.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                g.this.v();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class b implements c.InterfaceC1021c {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) g.this);
            }
        }

        @Override // com.tencent.creatorad.ui.box.c.InterfaceC1021c
        public void onClick(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
                return;
            }
            g gVar = g.this;
            gVar.d(((com.tencent.creatorad.ui.b) gVar).f100382a, i3);
            com.tencent.creatorad.ui.f.a(((com.tencent.creatorad.ui.b) g.this).f100382a, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class c implements c.d {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) g.this);
            }
        }

        @Override // com.tencent.creatorad.ui.box.c.d
        public void a(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
            } else {
                com.tencent.creatorad.ui.f.b(((com.tencent.creatorad.ui.b) g.this).f100382a, i3);
            }
        }
    }

    public g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        com.tencent.creatorad.ui.box.c cVar = new com.tencent.creatorad.ui.box.c(this.f100384c.getContext());
        this.f100431g = cVar;
        cVar.P(this.f100382a);
        this.f100431g.U(new b());
        this.f100431g.W(new c());
        this.f100431g.show();
        HashMap hashMap = new HashMap();
        hashMap.put("ADTicket", this.f100383b);
        ((IAdApi) QRoute.api(IAdApi.class)).report("adbox_click", hashMap);
    }

    @Override // com.tencent.creatorad.ui.b
    protected int h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return R.layout.e4t;
    }

    @Override // com.tencent.creatorad.ui.b
    protected void j(CreatorReader$ShareAD creatorReader$ShareAD) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) creatorReader$ShareAD);
            return;
        }
        if (!com.tencent.creatorad.utils.c.g(creatorReader$ShareAD)) {
            return;
        }
        this.f100430f.setImageDrawable(URLDrawable.getDrawable(creatorReader$ShareAD.display.icon_url.get(), URLDrawable.URLDrawableOptions.obtain()));
        this.f100430f.setOnClickListener(new a());
        HashMap hashMap = new HashMap();
        hashMap.put("ADTicket", this.f100383b);
        ((IAdApi) QRoute.api(IAdApi.class)).report("adbox_exposure", hashMap);
    }

    @Override // com.tencent.creatorad.ui.b
    protected void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.f100430f = (ImageView) this.f100385d.findViewById(R.id.ubh);
        }
    }
}
