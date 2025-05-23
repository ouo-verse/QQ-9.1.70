package com.tencent.biz.subscribe.account_folder.recommend_banner;

import NS_COMM.COMM;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.subscribe.account_folder.recommend_banner.FollowedRecommendBannerModel;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class FollowedRecommendBannerView extends LinearLayout implements FollowedRecommendBannerModel.a {

    /* renamed from: d, reason: collision with root package name */
    private RecyclerView f95603d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f95604e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f95605f;

    /* renamed from: h, reason: collision with root package name */
    private FollowedRecommendBannerModel f95606h;

    /* renamed from: i, reason: collision with root package name */
    private com.tencent.biz.subscribe.account_folder.recommend_banner.b f95607i;

    /* renamed from: m, reason: collision with root package name */
    private String f95608m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements com.tencent.biz.subscribe.account_folder.recommend_banner.a {
        a() {
        }

        @Override // com.tencent.biz.subscribe.account_folder.recommend_banner.a
        public void a(boolean z16, int i3) {
            if (z16 && (FollowedRecommendBannerView.this.f95607i == null || FollowedRecommendBannerView.this.f95607i.p() == null || i3 >= FollowedRecommendBannerView.this.f95607i.p().size())) {
                return;
            }
            VSReporter.n(FollowedRecommendBannerView.this.f95608m, "auth_person", "reco_follow", 0, 0, new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            FollowedRecommendBannerView.this.j();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            FollowedRecommendBannerView.this.j();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class d extends AnimatorListenerAdapter {
        d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            FollowedRecommendBannerView.this.f95607i.notifyDataSetChanged();
            FollowedRecommendBannerView.this.clearAnimation();
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class e extends AnimatorListenerAdapter {
        e() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            FollowedRecommendBannerView.this.clearAnimation();
            FollowedRecommendBannerView.this.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class f implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        private View f95614d;

        f(View view) {
            this.f95614d = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ViewGroup.LayoutParams layoutParams = this.f95614d.getLayoutParams();
            layoutParams.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            this.f95614d.setLayoutParams(layoutParams);
        }
    }

    public FollowedRecommendBannerView(Context context) {
        super(context);
        h(context);
    }

    private COMM.StCommonExt g() {
        FollowedRecommendBannerModel followedRecommendBannerModel = this.f95606h;
        if (followedRecommendBannerModel != null) {
            return followedRecommendBannerModel.d();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        StringBuilder sb5 = new StringBuilder(com.tencent.biz.subscribe.b.d(BaseApplicationImpl.getApplication().getRuntime().getAccount()));
        if (g() != null) {
            try {
                sb5.append(URLEncoder.encode(g().attachInfo.get(), "UTF-8"));
            } catch (UnsupportedEncodingException e16) {
                e16.printStackTrace();
            }
        } else {
            QLog.d("FollowedRecommendBanner", 2, "jump more recommend H5 page with no attach info!");
        }
        VSReporter.p(this.f95608m, "auth_person", "reco_more", 0, 0, new String[0]);
        com.tencent.biz.subscribe.d.l(sb5.toString());
    }

    private void k() {
        setVisibility(0);
        View view = (View) getParent();
        if (view != null) {
            measure(View.MeasureSpec.makeMeasureSpec(view.getMeasuredWidth(), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(0, getMeasuredHeight());
        ofInt.addUpdateListener(new f(this));
        ofInt.addListener(new d());
        ofInt.start();
        VSReporter.n(this.f95608m, "auth_person", "reco_exp", 0, 0, new String[0]);
    }

    @Override // com.tencent.biz.subscribe.account_folder.recommend_banner.FollowedRecommendBannerModel.a
    public void a(List<ve0.a> list, boolean z16) {
        if (list != null && list.size() != 0) {
            com.tencent.biz.subscribe.account_folder.recommend_banner.b bVar = this.f95607i;
            if (bVar != null) {
                bVar.v(null, list);
            }
            k();
        }
    }

    public void e(String str) {
        this.f95608m = str;
        FollowedRecommendBannerModel followedRecommendBannerModel = this.f95606h;
        if (followedRecommendBannerModel != null) {
            followedRecommendBannerModel.f(str);
        }
    }

    public void f() {
        if (getVisibility() == 8) {
            clearAnimation();
            return;
        }
        View view = (View) getParent();
        if (view != null) {
            measure(View.MeasureSpec.makeMeasureSpec(view.getMeasuredWidth(), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(getMeasuredHeight(), 0);
        ofInt.addUpdateListener(new f(this));
        ofInt.addListener(new e());
        ofInt.start();
        VSReporter.n(this.f95608m, "auth_person", "reco_pack_up", 0, 0, new String[0]);
    }

    protected void h(Context context) {
        setOrientation(1);
        View.inflate(context, R.layout.c6y, this);
        this.f95603d = (RecyclerView) findViewById(R.id.a5c);
        this.f95604e = (TextView) findViewById(R.id.gxs);
        this.f95605f = (ImageView) findViewById(R.id.g0k);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(0);
        FollowedRecommendBannerModel followedRecommendBannerModel = new FollowedRecommendBannerModel();
        this.f95606h = followedRecommendBannerModel;
        followedRecommendBannerModel.e(this);
        this.f95603d.setLayoutManager(linearLayoutManager);
        this.f95603d.addItemDecoration(new com.tencent.biz.subscribe.account_folder.recommend_banner.c());
        this.f95603d.setItemAnimator(new DefaultItemAnimator());
        TopRecommendBannerAdapter topRecommendBannerAdapter = new TopRecommendBannerAdapter(this.f95603d);
        this.f95607i = topRecommendBannerAdapter;
        topRecommendBannerAdapter.u(true);
        this.f95603d.setAdapter(this.f95607i);
        this.f95607i.w(new a());
        this.f95604e.setOnClickListener(new b());
        this.f95605f.setOnClickListener(new c());
    }

    public boolean i() {
        if (getVisibility() == 0) {
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        clearAnimation();
        super.onDetachedFromWindow();
    }

    public FollowedRecommendBannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        h(context);
    }
}
