package com.tencent.biz.qqcircle.immersive.personal.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.animation.PathInterpolatorCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.immersive.personal.bean.QFSPersonalInfo;
import com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalDetailsFragment;
import com.tencent.biz.qqcircle.immersive.personal.publishguide.BannerInfo;
import com.tencent.biz.qqcircle.immersive.personal.publishguide.PublishGuideData;
import com.tencent.biz.qqcircle.immersive.personal.publishguide.QFSPersonalPublishGuideViewModel;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarDecorateView;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.biz.richframework.part.PartLifecycleCallbacks;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import cooperation.qqcircle.report.QCircleReportBean;
import java.util.ArrayList;
import java.util.Iterator;
import n60.w;
import org.slf4j.Marker;

/* loaded from: classes4.dex */
public class QFSPersonalInfoWidget extends QCircleBaseWidgetView<QFSPersonalInfo> implements LifecycleOwner, n60.a, PartLifecycleCallbacks {
    private TextView C;
    private QCircleAvatarDecorateView D;
    private com.tencent.biz.qqcircle.immersive.personal.publishguide.h E;
    private ViewGroup F;
    RecyclerView.ViewHolder G;
    private boolean H;
    private PublishGuideData I;

    /* renamed from: d, reason: collision with root package name */
    private ArrayList<n60.b> f89262d;

    /* renamed from: e, reason: collision with root package name */
    private final LifecycleRegistry f89263e;

    /* renamed from: f, reason: collision with root package name */
    private final QFSPersonalDetailsFragment f89264f;

    /* renamed from: h, reason: collision with root package name */
    private com.tencent.biz.qqcircle.immersive.personal.viewmodel.r f89265h;

    /* renamed from: i, reason: collision with root package name */
    protected QFSPersonalPublishGuideViewModel f89266i;

    /* renamed from: m, reason: collision with root package name */
    private QFSPersonalInfo f89267m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b implements com.tencent.biz.qqcircle.immersive.personal.publishguide.f {
        b() {
        }

        @Override // com.tencent.biz.qqcircle.immersive.personal.publishguide.f
        public void a(@NonNull BannerInfo bannerInfo) {
            Activity p06 = QFSPersonalInfoWidget.this.p0();
            if (p06 != null) {
                QFSPersonalInfoWidget.this.f89266i.T1(p06, bannerInfo);
            }
        }

        @Override // com.tencent.biz.qqcircle.immersive.personal.publishguide.f
        public void b(@NonNull BannerInfo bannerInfo) {
            QFSPersonalInfoWidget.this.f89266i.U1(bannerInfo);
        }
    }

    public QFSPersonalInfoWidget(Context context, QFSPersonalDetailsFragment qFSPersonalDetailsFragment) {
        super(context);
        this.H = false;
        initView();
        LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);
        this.f89263e = lifecycleRegistry;
        lifecycleRegistry.setCurrentState(Lifecycle.State.CREATED);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.f89264f = qFSPersonalDetailsFragment;
        s0();
    }

    private void B0() {
        F0();
    }

    private void D0(QFSPersonalInfo qFSPersonalInfo) {
        if (this.C == null) {
            return;
        }
        if (qFSPersonalInfo != null && qFSPersonalInfo.f88425l && qFSPersonalInfo.h() != 0 && !qFSPersonalInfo.f88424k) {
            this.C.setVisibility(0);
            this.C.setText(Marker.ANY_NON_NULL_MARKER + com.tencent.biz.qqcircle.immersive.utils.r.f(qFSPersonalInfo.h()));
            this.C.startAnimation(o0());
            return;
        }
        this.C.setVisibility(8);
    }

    private void E0(QFSPersonalInfo qFSPersonalInfo) {
        if (qFSPersonalInfo != null && qFSPersonalInfo.f88416c != null) {
            this.f89267m = qFSPersonalInfo;
            B0();
            QFSPersonalInfo qFSPersonalInfo2 = this.f89267m;
            if (qFSPersonalInfo2.f88425l) {
                com.tencent.biz.qqcircle.f.g0("SP_KEY_IS_PENGUIN_USER", qFSPersonalInfo2.k());
                return;
            }
            return;
        }
        QLog.e("QFSPersonalInfoWidget", 1, "mPersonalInfo is null");
    }

    private void initView() {
        u0();
        findViewById(R.id.f164587t53);
        TextView textView = (TextView) findViewById(R.id.f56072jm);
        this.C = textView;
        if (textView != null) {
            textView.setTypeface(Typeface.DEFAULT_BOLD);
        }
        this.D = (QCircleAvatarDecorateView) findViewById(R.id.y4q);
        r0();
        this.F = (ViewGroup) findViewById(R.id.xm9);
    }

    private Animation o0() {
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.f154908td);
        loadAnimation.setAnimationListener(new a());
        loadAnimation.setInterpolator(PathInterpolatorCompat.create(0.42f, 0.0f, 0.58f, 1.0f));
        return loadAnimation;
    }

    private void s0() {
        LifecycleOwner lifecycleOwner;
        QFSPersonalDetailsFragment qFSPersonalDetailsFragment = this.f89264f;
        if (qFSPersonalDetailsFragment == null) {
            return;
        }
        this.f89265h = (com.tencent.biz.qqcircle.immersive.personal.viewmodel.r) getViewModel(qFSPersonalDetailsFragment, com.tencent.biz.qqcircle.immersive.personal.viewmodel.r.class);
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_personal_use_fragment_lifecycle", true)) {
            lifecycleOwner = this.f89264f;
        } else {
            lifecycleOwner = this;
        }
        this.f89265h.g2().observe(lifecycleOwner, new Observer() { // from class: com.tencent.biz.qqcircle.immersive.personal.widget.p
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSPersonalInfoWidget.this.v0((QFSPersonalInfo) obj);
            }
        });
        this.f89265h.W1();
        this.f89265h.X.observe(this, new Observer() { // from class: com.tencent.biz.qqcircle.immersive.personal.widget.q
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSPersonalInfoWidget.this.w0((Pair) obj);
            }
        });
        QFSPersonalPublishGuideViewModel qFSPersonalPublishGuideViewModel = (QFSPersonalPublishGuideViewModel) getViewModel(this.f89264f, QFSPersonalPublishGuideViewModel.class);
        this.f89266i = qFSPersonalPublishGuideViewModel;
        qFSPersonalPublishGuideViewModel.R1(this.f89265h.g2());
        this.f89266i.Q1().observe(this, new Observer() { // from class: com.tencent.biz.qqcircle.immersive.personal.widget.r
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSPersonalInfoWidget.this.q0((PublishGuideData) obj);
            }
        });
        Iterator<n60.b> it = this.f89262d.iterator();
        while (it.hasNext()) {
            n60.b next = it.next();
            if (next.k()) {
                next.j(this.f89264f);
            }
        }
    }

    private void u0() {
        this.f89262d = new ArrayList<>();
        if (C0()) {
            this.f89262d.add(new n60.n(this));
        }
        this.f89262d.add(new n60.u(this));
        this.f89262d.add(new w(this));
        this.f89262d.add(new n60.s(this));
        Iterator<n60.b> it = this.f89262d.iterator();
        while (it.hasNext()) {
            n60.b next = it.next();
            if (next.k()) {
                next.o();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v0(QFSPersonalInfo qFSPersonalInfo) {
        E0(qFSPersonalInfo);
        D0(qFSPersonalInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w0(Pair pair) {
        if (pair == null) {
            return;
        }
        this.H = false;
        q0(this.I);
    }

    public void A0(Activity activity) {
        Iterator<n60.b> it = this.f89262d.iterator();
        while (it.hasNext()) {
            n60.b next = it.next();
            if (next.k()) {
                next.s(activity);
            }
        }
    }

    protected boolean C0() {
        return false;
    }

    @Override // n60.a
    public int F() {
        return getPageId();
    }

    @Override // n60.a
    public int K() {
        return getParentPageId();
    }

    @Override // n60.a
    public BasePartFragment getFragment() {
        return this.f89264f;
    }

    @Override // n60.a
    public QCircleInitBean getInitBean() {
        QFSPersonalDetailsFragment qFSPersonalDetailsFragment = this.f89264f;
        if (qFSPersonalDetailsFragment != null && qFSPersonalDetailsFragment.getQCircleInitBean() != null) {
            return this.f89264f.getQCircleInitBean();
        }
        return null;
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.f168723gl3;
    }

    @Override // androidx.lifecycle.LifecycleOwner
    @NonNull
    public Lifecycle getLifecycle() {
        return this.f89263e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSPersonalInfoWidget";
    }

    @Override // n60.a
    public QCircleReportBean m() {
        return getReportBean();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f89263e.setCurrentState(Lifecycle.State.STARTED);
        QLog.d("QFSPersonalInfoWidget", 1, NodeProps.ON_ATTACHED_TO_WINDOW + hashCode());
        Iterator<n60.b> it = this.f89262d.iterator();
        while (it.hasNext()) {
            n60.b next = it.next();
            if (next.k()) {
                next.l();
            }
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ArrayList<n60.b> arrayList = this.f89262d;
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<n60.b> it = this.f89262d.iterator();
            while (it.hasNext()) {
                n60.b next = it.next();
                if (next != null && next.k()) {
                    next.m(configuration);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        QLog.d("QFSPersonalInfoWidget", 1, NodeProps.ON_DETACHED_FROM_WINDOW + hashCode());
        this.f89263e.setCurrentState(Lifecycle.State.DESTROYED);
        Iterator<n60.b> it = this.f89262d.iterator();
        while (it.hasNext()) {
            n60.b next = it.next();
            if (next.k()) {
                next.n();
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        Iterator<n60.b> it = this.f89262d.iterator();
        while (it.hasNext()) {
            n60.b next = it.next();
            if (next.k()) {
                next.onPartDestroy(activity);
            }
        }
    }

    public Activity p0() {
        QFSPersonalDetailsFragment qFSPersonalDetailsFragment = this.f89264f;
        if (qFSPersonalDetailsFragment == null) {
            return null;
        }
        return qFSPersonalDetailsFragment.getActivity();
    }

    public void q0(PublishGuideData publishGuideData) {
        if (this.E == null) {
            com.tencent.biz.qqcircle.immersive.personal.publishguide.h hVar = new com.tencent.biz.qqcircle.immersive.personal.publishguide.h(new b());
            this.E = hVar;
            RecyclerView.ViewHolder b16 = hVar.b(this.F);
            this.G = b16;
            this.F.addView(b16.itemView);
        }
        if (publishGuideData != null) {
            this.I = publishGuideData;
        }
        if (publishGuideData != null && !publishGuideData.a().isEmpty() && this.H) {
            QLog.i("QFSPersonalInfoWidget", 1, "show bannerView");
            this.F.setVisibility(8);
            this.E.d(publishGuideData);
            this.E.a(this.G);
            return;
        }
        QLog.i("QFSPersonalInfoWidget", 1, "hide bannerView");
        this.F.setVisibility(8);
    }

    public void x0(Activity activity) {
        Iterator<n60.b> it = this.f89262d.iterator();
        while (it.hasNext()) {
            n60.b next = it.next();
            if (next.k()) {
                next.p(activity);
            }
        }
    }

    public void y0(Activity activity) {
        Iterator<n60.b> it = this.f89262d.iterator();
        while (it.hasNext()) {
            n60.b next = it.next();
            if (next.k()) {
                next.q(activity);
            }
        }
    }

    public void z0(Activity activity) {
        Iterator<n60.b> it = this.f89262d.iterator();
        while (it.hasNext()) {
            n60.b next = it.next();
            if (next.k()) {
                next.r(activity);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements Animation.AnimationListener {
        a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (QFSPersonalInfoWidget.this.C != null) {
                QFSPersonalInfoWidget.this.C.clearAnimation();
                QFSPersonalInfoWidget.this.C.setVisibility(8);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            animation.cancel();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    private void F0() {
    }

    private void r0() {
    }

    @Override // n60.a
    public View z() {
        return this;
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public void bindData(QFSPersonalInfo qFSPersonalInfo, int i3) {
    }
}
