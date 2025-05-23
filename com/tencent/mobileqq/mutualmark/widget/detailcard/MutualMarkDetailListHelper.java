package com.tencent.mobileqq.mutualmark.widget.detailcard;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi;
import com.tencent.mobileqq.mutualmark.model.MutualMarkModel;
import com.tencent.mobileqq.mutualmark.util.WebMutualMarkCardUpdateUtil;
import com.tencent.mobileqq.mutualmark.widget.detailcard.MutualMarkDetailAnimView;
import com.tencent.mobileqq.mutualmark.widget.detailcard.a;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qui.QUIImmersiveHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.visual.debug.util.ActivityUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MutualMarkDetailListHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: l, reason: collision with root package name */
    public static boolean f252334l;

    /* renamed from: m, reason: collision with root package name */
    public static boolean f252335m;

    /* renamed from: n, reason: collision with root package name */
    public static boolean f252336n;

    /* renamed from: o, reason: collision with root package name */
    public static String f252337o;

    /* renamed from: p, reason: collision with root package name */
    public static final String f252338p;

    /* renamed from: q, reason: collision with root package name */
    public static final String f252339q;

    /* renamed from: a, reason: collision with root package name */
    private final RecyclerView f252340a;

    /* renamed from: b, reason: collision with root package name */
    private com.tencent.mobileqq.mutualmark.widget.detailcard.a f252341b;

    /* renamed from: c, reason: collision with root package name */
    private final ArrayList<MutualMarkModel> f252342c;

    /* renamed from: d, reason: collision with root package name */
    private final int f252343d;

    /* renamed from: e, reason: collision with root package name */
    private RelativeLayout f252344e;

    /* renamed from: f, reason: collision with root package name */
    private LinearLayoutManager f252345f;

    /* renamed from: g, reason: collision with root package name */
    private FrameLayout f252346g;

    /* renamed from: h, reason: collision with root package name */
    private FrameLayout f252347h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f252348i;

    /* renamed from: j, reason: collision with root package name */
    private RecyclerView f252349j;

    /* renamed from: k, reason: collision with root package name */
    ab1.a f252350k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class a extends RecyclerView.OnScrollListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MutualMarkDetailListHelper.this);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i3) {
            View findViewByPosition;
            a.C8131a c8131a;
            MutualMarkModel o16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) recyclerView, i3);
                return;
            }
            super.onScrollStateChanged(recyclerView, i3);
            if (MutualMarkDetailListHelper.this.f252345f == null || MutualMarkDetailListHelper.this.f252340a == null || i3 != 0 || (findViewByPosition = MutualMarkDetailListHelper.this.f252345f.findViewByPosition(MutualMarkDetailListHelper.this.f252345f.findFirstCompletelyVisibleItemPosition())) == null || (c8131a = (a.C8131a) MutualMarkDetailListHelper.this.f252340a.getChildViewHolder(findViewByPosition)) == null || (o16 = c8131a.o()) == null) {
                return;
            }
            ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).reportImpl(o16, "2");
            MutualMarkDetailListHelper.this.B(c8131a, o16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class b implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ MutualMarkDetailAnimView f252352d;

        b(MutualMarkDetailAnimView mutualMarkDetailAnimView) {
            this.f252352d = mutualMarkDetailAnimView;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MutualMarkDetailListHelper.this, (Object) mutualMarkDetailAnimView);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
            } else {
                MutualMarkDetailListHelper.this.f252344e.setVisibility(0);
                MutualMarkDetailListHelper.this.f252346g.removeView(this.f252352d.f252325e);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class c implements MutualMarkDetailAnimView.c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f252354a;

        c(Context context) {
            this.f252354a = context;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MutualMarkDetailListHelper.this, (Object) context);
            }
        }

        @Override // com.tencent.mobileqq.mutualmark.widget.detailcard.MutualMarkDetailAnimView.c
        public void onFinish() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                MutualMarkDetailListHelper.this.l(this.f252354a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class d implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f252356d;

        d(Context context) {
            this.f252356d = context;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MutualMarkDetailListHelper.this, (Object) context);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                MutualMarkDetailListHelper.this.k(this.f252356d);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class e implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f252358d;

        e(Context context) {
            this.f252358d = context;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MutualMarkDetailListHelper.this, (Object) context);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                MutualMarkDetailListHelper.this.k(this.f252358d);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class f implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        /* loaded from: classes15.dex */
        class a implements Animation.AnimationListener {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ a.C8131a f252361d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ View f252362e;

            a(a.C8131a c8131a, View view) {
                this.f252361d = c8131a;
                this.f252362e = view;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, f.this, c8131a, view);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                com.tencent.mobileqq.mutualmark.widget.util.a aVar;
                View view;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
                    return;
                }
                a.C8131a c8131a = this.f252361d;
                if (c8131a != null && (aVar = c8131a.K) != null && (view = this.f252362e) != null) {
                    aVar.d(view.findViewById(R.id.zkv));
                }
            }
        }

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MutualMarkDetailListHelper.this);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            View findViewByPosition;
            a.C8131a c8131a;
            MutualMarkModel o16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
                return;
            }
            if (MutualMarkDetailListHelper.this.f252345f == null || MutualMarkDetailListHelper.this.f252340a == null || (findViewByPosition = MutualMarkDetailListHelper.this.f252345f.findViewByPosition(MutualMarkDetailListHelper.this.f252345f.findFirstCompletelyVisibleItemPosition())) == null || (c8131a = (a.C8131a) MutualMarkDetailListHelper.this.f252340a.getChildViewHolder(findViewByPosition)) == null || (o16 = c8131a.o()) == null) {
                return;
            }
            ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).reportImpl(o16, "0");
            if (o16.G == 1) {
                if (o16.f252157e == MutualMarkModel.f252153c0) {
                    c8131a.J.j("mutual_mark_lottie/star.json");
                    c8131a.J.k("mutual_mark_lottie/boom.json");
                    c8131a.J.i("mutual_mark_lottie/confetti_frist.json");
                    c8131a.K.c(new a(c8131a, findViewByPosition));
                    c8131a.K.b(c8131a.F, c8131a.G);
                } else if (o16.N) {
                    c8131a.J.j("mutual_mark_lottie/star.json");
                    c8131a.J.k("mutual_mark_lottie/confetti_special.json");
                }
            } else if (o16.f252157e == MutualMarkModel.f252153c0) {
                c8131a.J.i("mutual_mark_lottie/confetti_frist.json");
            }
            o16.f252157e = MutualMarkModel.f252152b0;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class g extends FrameLayout {
        static IPatchRedirector $redirector_;

        public g(@NonNull Context context) {
            super(context);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onDetachedFromWindow() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                super.onDetachedFromWindow();
                WebMutualMarkCardUpdateUtil.b().a();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33557);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
            return;
        }
        f252334l = false;
        f252335m = false;
        f252336n = false;
        f252337o = "";
        f252338p = ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).getLottieDownloadInfo().f252186a;
        f252339q = ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).getLottieDownloadInfo().f252187b;
    }

    public MutualMarkDetailListHelper(Context context, List<MutualMarkModel> list, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, list, Integer.valueOf(i3));
            return;
        }
        ArrayList<MutualMarkModel> arrayList = new ArrayList<>();
        this.f252342c = arrayList;
        t(list);
        arrayList.addAll(list);
        this.f252340a = new RecyclerView(context);
        this.f252343d = i3;
        i();
        j(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(a.C8131a c8131a, MutualMarkModel mutualMarkModel) {
        if (c8131a != null && mutualMarkModel != null) {
            if (mutualMarkModel.G == 1) {
                if (mutualMarkModel.f252157e == MutualMarkModel.f252153c0) {
                    c8131a.J.j("mutual_mark_lottie/star.json");
                    c8131a.J.k("mutual_mark_lottie/boom.json");
                    c8131a.J.i("mutual_mark_lottie/confetti_frist.json");
                } else if (mutualMarkModel.N) {
                    c8131a.J.j("mutual_mark_lottie/star.json");
                    c8131a.J.k("mutual_mark_lottie/confetti_special.json");
                }
            } else if (mutualMarkModel.f252157e == MutualMarkModel.f252153c0) {
                c8131a.J.i("mutual_mark_lottie/confetti_frist.json");
            }
            mutualMarkModel.f252157e = MutualMarkModel.f252152b0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        Activity topActivity = ActivityUtil.getTopActivity();
        if (topActivity == null) {
            return;
        }
        QUIImmersiveHelper.u(topActivity.getWindow(), true, true);
    }

    private void D() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            C();
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.mutualmark.widget.detailcard.MutualMarkDetailListHelper.3
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) MutualMarkDetailListHelper.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        MutualMarkDetailListHelper.this.C();
                    } else {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
    }

    private void i() {
        if (MobileQQ.sProcessId != 1) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mutualmark.widget.detailcard.MutualMarkDetailListHelper.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) MutualMarkDetailListHelper.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "MutualMarkIpcServer", "checkLottieResource", null);
                    }
                }
            }, 16, null, false);
        } else {
            ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).checkDownloadCartoonResource(null, f252338p, f252339q);
        }
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    private void j(Context context) {
        this.f252346g = new g(context);
        this.f252346g.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f252346g.setClipChildren(false);
        FrameLayout frameLayout = new FrameLayout(context);
        this.f252347h = frameLayout;
        frameLayout.setOnClickListener(new d(context));
        this.f252347h.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f252347h.setBackground(new ColorDrawable(-1946157056));
        this.f252346g.addView(this.f252347h);
        this.f252344e = new RelativeLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, context.getResources().getDimensionPixelSize(R.dimen.d7m));
        layoutParams.gravity = 16;
        this.f252344e.setLayoutParams(layoutParams);
        this.f252346g.addView(this.f252344e);
        this.f252348i = new ImageView(context);
        this.f252348i.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f252346g.addView(this.f252348i);
        this.f252344e.addView(this.f252340a, new RelativeLayout.LayoutParams(-1, -2));
        this.f252340a.setClipChildren(false);
        this.f252344e.setClipChildren(false);
        ImageView imageView = new ImageView(context);
        imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.kss));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(context.getResources().getDimensionPixelSize(R.dimen.d7u), context.getResources().getDimensionPixelSize(R.dimen.d7u));
        layoutParams2.addRule(12, -1);
        layoutParams2.addRule(14, -1);
        this.f252344e.addView(imageView, layoutParams2);
        imageView.setOnClickListener(new e(context));
        ((ViewGroup) ((Activity) context).getWindow().getDecorView().getRootView()).addView(this.f252346g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n(MutualMarkDetailAnimView mutualMarkDetailAnimView) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        he0.b.l(alphaAnimation, R.anim.f154973ug);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setAnimationListener(new b(mutualMarkDetailAnimView));
        this.f252344e.startAnimation(alphaAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o() {
        View findViewByPosition;
        a.C8131a c8131a;
        MutualMarkModel o16;
        LinearLayoutManager linearLayoutManager = this.f252345f;
        if (linearLayoutManager == null || this.f252340a == null || (findViewByPosition = linearLayoutManager.findViewByPosition(this.f252343d)) == null || (c8131a = (a.C8131a) this.f252340a.getChildViewHolder(findViewByPosition)) == null || (o16 = c8131a.o()) == null) {
            return;
        }
        B(c8131a, o16);
    }

    private void p(Context context) {
        View findViewByPosition;
        MutualMarkModel o16;
        String str;
        String str2;
        LinearLayoutManager linearLayoutManager = this.f252345f;
        if (linearLayoutManager != null && this.f252340a != null && (findViewByPosition = linearLayoutManager.findViewByPosition(linearLayoutManager.findFirstCompletelyVisibleItemPosition())) != null && (o16 = ((a.C8131a) this.f252340a.getChildViewHolder(findViewByPosition)).o()) != null && o16.N && !o16.M && com.tencent.mobileqq.mutualmark.widget.util.b.e().f252451d) {
            com.tencent.mobileqq.mutualmark.widget.util.b.e().f252451d = false;
            List<MutualMarkModel.Button> list = o16.Z;
            String str3 = null;
            if (list != null) {
                String str4 = null;
                for (MutualMarkModel.Button button : list) {
                    if (!button.f252166i) {
                        str3 = button.f252163e;
                        str4 = button.f252164f;
                    }
                }
                str = str3;
                str2 = str4;
            } else {
                str = null;
                str2 = null;
            }
            com.tencent.mobileqq.mutualmark.widget.util.b.e().f();
            if (context == null) {
                return;
            }
            ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).showHalfScreenView(context, o16.f252159h, HardCodeUtil.qqStr(R.string.f238507jy), str, str2);
        }
    }

    private void s(boolean z16) {
        float f16;
        float f17 = 0.0f;
        if (z16) {
            f16 = 0.0f;
        } else {
            f16 = 1.0f;
        }
        if (z16) {
            f17 = 1.0f;
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(f16, f17);
        he0.b.m(alphaAnimation, R.anim.f154983uq, 2.0f);
        alphaAnimation.setFillAfter(true);
        this.f252347h.startAnimation(alphaAnimation);
        alphaAnimation.setAnimationListener(new f());
    }

    private void t(List<MutualMarkModel> list) {
        for (MutualMarkModel mutualMarkModel : list) {
            mutualMarkModel.U = ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).upgradeIconUrlToVersion2(mutualMarkModel.U);
            mutualMarkModel.f252159h = ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).upgradeIconUrlToVersion2(mutualMarkModel.f252159h);
        }
    }

    private void u() {
        ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).requestIntimateInfo(f252337o);
    }

    private void v(int i3, Context context) {
        if (i3 > 0 && i3 < this.f252342c.size() - 1 && context != null) {
            this.f252345f.scrollToPositionWithOffset(i3, ((context.getResources().getDisplayMetrics().widthPixels - context.getResources().getDimensionPixelSize(R.dimen.d7n)) - context.getResources().getDimensionPixelSize(R.dimen.f158713n2)) / 2);
            return;
        }
        this.f252345f.scrollToPosition(i3);
    }

    private static boolean y() {
        if (Build.VERSION.SDK_INT <= 25) {
            return true;
        }
        return false;
    }

    public void A(Context context) {
        int i3;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) context);
            return;
        }
        f252336n = true;
        if (MobileQQ.sProcessId != 1) {
            ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).registerIpcClient();
        }
        if (context == null) {
            return;
        }
        com.tencent.mobileqq.mutualmark.widget.util.b.e().g(this.f252348i);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        this.f252345f = linearLayoutManager;
        linearLayoutManager.setOrientation(0);
        this.f252340a.setLayoutManager(this.f252345f);
        com.tencent.mobileqq.mutualmark.widget.detailcard.a aVar = new com.tencent.mobileqq.mutualmark.widget.detailcard.a(context, this);
        this.f252341b = aVar;
        aVar.m0(this.f252342c);
        this.f252340a.setAdapter(this.f252341b);
        this.f252340a.setOverScrollMode(2);
        this.f252340a.setOnScrollListener(new a());
        this.f252340a.addItemDecoration(new com.tencent.mobileqq.mutualmark.widget.detailcard.c());
        new PagerSnapHelper().attachToRecyclerView(this.f252340a);
        v(this.f252343d, context);
        ArrayList<MutualMarkModel> arrayList = this.f252342c;
        if (arrayList != null && (i3 = this.f252343d) >= 0 && i3 < arrayList.size()) {
            IMutualMarkHelperApi iMutualMarkHelperApi = (IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class);
            MutualMarkModel mutualMarkModel = this.f252342c.get(this.f252343d);
            if (MobileQQ.sProcessId != 1) {
                str = "1";
            } else {
                str = "0";
            }
            iMutualMarkHelperApi.reportImpl(mutualMarkModel, str);
            if (MobileQQ.sProcessId != 1) {
                ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.mutualmark.widget.detailcard.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        MutualMarkDetailListHelper.this.o();
                    }
                }, 500L);
            }
            D();
        }
    }

    public void k(Context context) {
        MutualMarkModel mutualMarkModel;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) context);
            return;
        }
        f252336n = false;
        if (MobileQQ.sProcessId != 1) {
            ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).unregisterIpcClient();
            q(this.f252342c);
        }
        WebMutualMarkCardUpdateUtil.b().a();
        if (y()) {
            l(context);
            return;
        }
        if (this.f252349j == null) {
            l(context);
            return;
        }
        p(context);
        int findFirstCompletelyVisibleItemPosition = this.f252345f.findFirstCompletelyVisibleItemPosition();
        if (findFirstCompletelyVisibleItemPosition >= 0 && findFirstCompletelyVisibleItemPosition < this.f252342c.size()) {
            mutualMarkModel = this.f252342c.get(findFirstCompletelyVisibleItemPosition);
        } else {
            mutualMarkModel = null;
        }
        View childAt = this.f252349j.getChildAt(findFirstCompletelyVisibleItemPosition);
        if (childAt == null) {
            l(context);
            return;
        }
        int[] iArr = new int[2];
        childAt.getLocationInWindow(iArr);
        if (context == null) {
            return;
        }
        MutualMarkDetailAnimView mutualMarkDetailAnimView = new MutualMarkDetailAnimView(context);
        if (mutualMarkModel != null) {
            mutualMarkDetailAnimView.setData(mutualMarkModel);
            mutualMarkDetailAnimView.setCardSelectedLevel(mutualMarkModel.f252156d, mutualMarkModel);
            mutualMarkDetailAnimView.setMode(2);
            mutualMarkDetailAnimView.setOriginParams(0, 0, context.getResources().getDimensionPixelSize(R.dimen.d7n), context.getResources().getDimensionPixelSize(R.dimen.d7m));
            mutualMarkDetailAnimView.setDestParams(iArr[0], iArr[1], childAt.getMeasuredWidth(), childAt.getMeasuredHeight());
            mutualMarkDetailAnimView.j(this.f252346g, new c(context));
            s(false);
        }
        this.f252346g.removeView(this.f252344e);
        u();
    }

    public boolean l(Context context) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) context)).booleanValue();
        }
        HashMap<String, Object> pgTagProfileData = ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).getPgTagProfileData();
        if (f252334l) {
            str = "1";
        } else {
            str = "0";
        }
        pgTagProfileData.put("interaction_page_state", str);
        f252334l = false;
        ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).reportItemEvent("dt_imp_end", "pg_tag_detail", "em_interact_tag_profile", ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).getPgTagDetailData(), pgTagProfileData);
        f252336n = false;
        if (MobileQQ.sProcessId != 1) {
            ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).unregisterIpcClient();
        }
        WebMutualMarkCardUpdateUtil.b().a();
        FrameLayout frameLayout = this.f252346g;
        if (frameLayout == null || frameLayout.getParent() == null || context == null) {
            return false;
        }
        ((ViewGroup) ((Activity) context).getWindow().getDecorView().getRootView()).removeView(this.f252346g);
        u();
        com.tencent.mobileqq.mutualmark.widget.util.b.e().f();
        D();
        return true;
    }

    public ArrayList<MutualMarkModel> m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ArrayList) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f252342c;
    }

    public void q(ArrayList<MutualMarkModel> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) arrayList);
            return;
        }
        try {
            if (this.f252350k != null && arrayList != null && arrayList.size() != 0) {
                MutualMarkModel mutualMarkModel = arrayList.get(0);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("id", mutualMarkModel.D);
                jSONObject.put("wear", mutualMarkModel.M);
                jSONObject.put("lightUp", mutualMarkModel.N);
                JSONArray jSONArray = new JSONArray();
                List<MutualMarkModel.Button> list = mutualMarkModel.Z;
                if (list != null) {
                    for (MutualMarkModel.Button button : list) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("name", button.f252162d);
                        jSONObject2.put("text", button.f252163e);
                        jSONObject2.put("url", button.f252164f);
                        jSONObject2.put("react_button_name", button.f252165h);
                        jSONObject2.put("hide", button.f252166i);
                        jSONObject2.put("style", button.f252167m);
                        jSONArray.mo162put(jSONObject2);
                    }
                }
                jSONObject.put("action", jSONArray);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("code", 0);
                jSONObject3.put("data", jSONObject);
                this.f252350k.f(jSONObject3);
            }
        } catch (JSONException unused) {
            QLog.e("MutualMarkDetailListHelper", 2, "notifyWebToRefresh fail");
        }
    }

    public void r(ArrayList<MutualMarkModel> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) arrayList);
            return;
        }
        t(arrayList);
        this.f252342c.clear();
        this.f252342c.addAll(arrayList);
        com.tencent.mobileqq.mutualmark.widget.detailcard.a aVar = this.f252341b;
        if (aVar != null) {
            aVar.m0(arrayList);
            this.f252341b.notifyDataSetChanged();
        }
    }

    public void w(ab1.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) aVar);
        } else {
            this.f252350k = aVar;
        }
    }

    public void x(RecyclerView recyclerView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) recyclerView);
        } else {
            this.f252349j = recyclerView;
        }
    }

    public void z(int i3, int i16, int i17, int i18, MutualMarkModel mutualMarkModel, Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), mutualMarkModel, context);
            return;
        }
        if (y()) {
            A(context);
            return;
        }
        if (context == null) {
            return;
        }
        f252336n = true;
        this.f252344e.setVisibility(4);
        A(context);
        final MutualMarkDetailAnimView mutualMarkDetailAnimView = new MutualMarkDetailAnimView(context);
        mutualMarkDetailAnimView.setData(mutualMarkModel);
        mutualMarkDetailAnimView.setMode(1);
        mutualMarkDetailAnimView.setOriginParams(i3, i16, i17, i18);
        mutualMarkDetailAnimView.d(this.f252346g, new MutualMarkDetailAnimView.c() { // from class: com.tencent.mobileqq.mutualmark.widget.detailcard.e
            @Override // com.tencent.mobileqq.mutualmark.widget.detailcard.MutualMarkDetailAnimView.c
            public final void onFinish() {
                MutualMarkDetailListHelper.this.n(mutualMarkDetailAnimView);
            }
        });
        s(true);
    }
}
