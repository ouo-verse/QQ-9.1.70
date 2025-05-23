package com.tencent.creatorad.ui.presenter;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.ad.tangram.util.AdExposureChecker;
import com.tencent.creatorad.pb.CreatorReader$ShareAD;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
/* loaded from: classes5.dex */
public class f extends com.tencent.creatorad.ui.b {
    static IPatchRedirector $redirector_;

    /* renamed from: q, reason: collision with root package name */
    public static final int f100413q;

    /* renamed from: f, reason: collision with root package name */
    protected ImageView f100414f;

    /* renamed from: g, reason: collision with root package name */
    private TextView f100415g;

    /* renamed from: h, reason: collision with root package name */
    private View f100416h;

    /* renamed from: i, reason: collision with root package name */
    protected AdExposureChecker f100417i;

    /* renamed from: j, reason: collision with root package name */
    private AdExposureChecker.ExposureCallback f100418j;

    /* renamed from: k, reason: collision with root package name */
    private long f100419k;

    /* renamed from: l, reason: collision with root package name */
    private HashSet<String> f100420l;

    /* renamed from: m, reason: collision with root package name */
    protected Rect f100421m;

    /* renamed from: n, reason: collision with root package name */
    private final View.OnClickListener f100422n;

    /* renamed from: o, reason: collision with root package name */
    protected final View.OnClickListener f100423o;

    /* renamed from: p, reason: collision with root package name */
    private ViewTreeObserver.OnScrollChangedListener f100424p;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a implements AdExposureChecker.ExposureCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ qq_ad_get.QQAdGetRsp.AdInfo f100425a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CreatorReader$ShareAD f100426b;

        a(qq_ad_get.QQAdGetRsp.AdInfo adInfo, CreatorReader$ShareAD creatorReader$ShareAD) {
            this.f100425a = adInfo;
            this.f100426b = creatorReader$ShareAD;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, f.this, adInfo, creatorReader$ShareAD);
            }
        }

        @Override // com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback
        public void onExposure(WeakReference<View> weakReference) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) weakReference);
            } else {
                com.tencent.creatorad.utils.b.c(this.f100425a.report_info.exposure_url.get());
                com.tencent.creatorad.ui.f.b(this.f100426b, 0);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class b implements View.OnAttachStateChangeListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) f.this);
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                f.this.f100417i.startCheck();
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
            } else {
                f.this.w();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class c implements ViewTreeObserver.OnScrollChangedListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) f.this);
            }
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                f.this.t();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26666);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            f100413q = com.tencent.creatorad.ui.c.c(1, false, 1);
        }
    }

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f100420l = new HashSet<>();
        this.f100421m = new Rect();
        this.f100422n = new View.OnClickListener() { // from class: com.tencent.creatorad.ui.presenter.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.this.u(view);
            }
        };
        this.f100423o = new View.OnClickListener() { // from class: com.tencent.creatorad.ui.presenter.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.this.v(view);
            }
        };
        this.f100424p = new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        QLog.e("BasePresenter", 1, "handleOnScrollChanged");
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = this.f100419k;
        if (j3 != -1 && currentTimeMillis - j3 > 200) {
            this.f100419k = currentTimeMillis;
            if (this.f100385d.getGlobalVisibleRect(this.f100421m)) {
                x();
                QLog.e("BasePresenter", 1, "handleOnScrollChanged startCheck");
                this.f100417i.startCheck();
                this.f100385d.getViewTreeObserver().removeOnScrollChangedListener(this.f100424p);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        n(this.f100382a, 0);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (com.tencent.creatorad.utils.c.f(this.f100382a, 0)) {
            d(this.f100382a, 0);
            com.tencent.creatorad.ui.f.a(this.f100382a, 0);
            AdExposureChecker.onClick(this.f100385d.getContext(), new GdtAd(this.f100382a.qq_ad_get_rsp.pos_ads_info.get(0).ads_info.get(0)), new WeakReference(this.f100418j));
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private void x() {
        if (!com.tencent.creatorad.utils.c.f(this.f100382a, 0)) {
            return;
        }
        GdtAd gdtAd = new GdtAd(this.f100382a.qq_ad_get_rsp.pos_ads_info.get(0).ads_info.get(0));
        if (this.f100420l.contains(String.valueOf(gdtAd.getTraceId()))) {
            return;
        }
        this.f100420l.add(String.valueOf(gdtAd.getTraceId()));
        com.tencent.creatorad.utils.b.c(gdtAd.getOriginalExposureUrl());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.creatorad.ui.b
    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return f100413q;
    }

    @Override // com.tencent.creatorad.ui.b
    protected int h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return R.layout.e4p;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.creatorad.ui.b
    public void j(CreatorReader$ShareAD creatorReader$ShareAD) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) creatorReader$ShareAD);
            return;
        }
        if (!com.tencent.creatorad.utils.c.g(creatorReader$ShareAD)) {
            QLog.e("BasePresenter", 1, "isSharedAdValid false");
            return;
        }
        qq_ad_get.QQAdGetRsp.AdInfo adInfo = creatorReader$ShareAD.qq_ad_get_rsp.pos_ads_info.get(0).ads_info.get(0);
        GdtAd gdtAd = new GdtAd(adInfo);
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mFailedDrawable = this.f100385d.getContext().getResources().getDrawable(R.drawable.b9s);
        this.f100414f.setImageDrawable(URLDrawable.getDrawable(gdtAd.getBasic_img(), obtain));
        this.f100415g.setText(com.tencent.creatorad.utils.c.b(gdtAd));
        this.f100417i = new AdExposureChecker(gdtAd, new WeakReference(this.f100385d));
        this.f100418j = new a(adInfo, creatorReader$ShareAD);
        this.f100417i.setCallback(new WeakReference<>(this.f100418j));
        this.f100385d.addOnAttachStateChangeListener(new b());
        this.f100385d.getViewTreeObserver().addOnScrollChangedListener(this.f100424p);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.creatorad.ui.b
    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.f100414f = (ImageView) this.f100384c.findViewById(R.id.ube);
        this.f100415g = (TextView) this.f100384c.findViewById(R.id.ubd);
        View findViewById = this.f100384c.findViewById(R.id.ubf);
        this.f100416h = findViewById;
        findViewById.setOnClickListener(this.f100422n);
        this.f100385d.setOnClickListener(this.f100423o);
    }

    @Override // com.tencent.creatorad.ui.b
    public void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            super.o();
            w();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            this.f100417i.onActivityDestroy();
            this.f100385d.getViewTreeObserver().removeOnScrollChangedListener(this.f100424p);
        }
    }
}
