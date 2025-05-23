package com.qzone.reborn.qzmoment.part;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager2.widget.ViewPager2;
import com.qzone.reborn.qzmoment.comment.QZMFeedCommentInfo;
import com.qzone.reborn.qzmoment.fragment.QZMCommentListFragment;
import com.qzone.reborn.qzmoment.fragment.QZMPraiseListFragment;
import com.qzone.reborn.qzmoment.util.QZMSlidBottomView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import qzonemoment.QZMomentMeta$StLike;

/* loaded from: classes37.dex */
public class QZMCommentPanelPart extends com.qzone.reborn.base.k implements SimpleEventReceiver, gn.d {
    private boolean C;
    private int D = 0;
    private ViewPager2 E;
    private cn.b F;
    private FrameLayout G;
    private FrameLayout H;
    private TextView I;
    private TextView J;
    private TextView K;
    private TextView L;
    private ImageView M;
    private ImageView N;
    private ImageView P;

    /* renamed from: d, reason: collision with root package name */
    private QZMSlidBottomView f58921d;

    /* renamed from: e, reason: collision with root package name */
    private QZMFeedCommentInfo f58922e;

    /* renamed from: f, reason: collision with root package name */
    private LinearLayout f58923f;

    /* renamed from: h, reason: collision with root package name */
    private LinearLayout f58924h;

    /* renamed from: i, reason: collision with root package name */
    private LinearLayout f58925i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f58926m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class b extends ViewPager2.OnPageChangeCallback {
        b() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i3) {
            super.onPageSelected(i3);
            QZMCommentPanelPart.this.ca(i3);
        }
    }

    private void I9() {
        if (getActivity() == null || getActivity().getIntent() == null) {
            return;
        }
        getActivity().getIntent().putExtra(QZMFeedCommentInfo.FEED_COMMENT_INFO_KEY, this.f58922e);
    }

    private void J9() {
        TextView textView = this.I;
        if (textView == null || this.M == null || this.J == null || this.N == null) {
            return;
        }
        textView.setTextColor(getContext().getResources().getColor(R.color.qui_common_text_primary));
        this.J.setTextColor(getContext().getResources().getColor(R.color.qui_common_text_secondary));
        this.M.setVisibility(0);
        this.N.setVisibility(4);
    }

    private void K9() {
        QZMSlidBottomView qZMSlidBottomView;
        if (this.P == null || (qZMSlidBottomView = this.f58921d) == null) {
            return;
        }
        qZMSlidBottomView.c();
    }

    private void L9() {
        ViewPager2 viewPager2 = this.E;
        if (viewPager2 == null) {
            return;
        }
        viewPager2.setCurrentItem(0);
    }

    private void M9() {
        ViewPager2 viewPager2 = this.E;
        if (viewPager2 == null) {
            return;
        }
        viewPager2.setCurrentItem(1);
    }

    private void P9() {
        QZMSlidBottomView qZMSlidBottomView = this.f58921d;
        if (qZMSlidBottomView == null) {
            return;
        }
        qZMSlidBottomView.setSlidAnimListener(new a());
    }

    private void Q9() {
        ViewPager2 viewPager2 = this.E;
        if (viewPager2 == null) {
            QLog.d("QZMHostCommentListPart", 1, "view pager is null");
            return;
        }
        viewPager2.registerOnPageChangeCallback(new b());
        ArrayList arrayList = new ArrayList();
        arrayList.add(new QZMCommentListFragment());
        if (!this.C) {
            arrayList.add(new QZMPraiseListFragment());
        }
        cn.b bVar = new cn.b(getHostFragment());
        this.F = bVar;
        this.E.setAdapter(bVar);
        this.F.i0(arrayList);
        this.E.post(new Runnable() { // from class: com.qzone.reborn.qzmoment.part.QZMCommentPanelPart.3
            @Override // java.lang.Runnable
            public void run() {
                QZMCommentPanelPart.this.E.setCurrentItem(QZMCommentPanelPart.this.D);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R9(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        L9();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S9(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        M9();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T9(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        K9();
        EventCollector.getInstance().onViewClicked(view);
    }

    private void U9() {
        TextView textView = this.I;
        if (textView == null || this.M == null || this.J == null || this.N == null) {
            return;
        }
        textView.setTextColor(getContext().getResources().getColor(R.color.qui_common_text_secondary));
        this.J.setTextColor(getContext().getResources().getColor(R.color.qui_common_text_primary));
        this.M.setVisibility(4);
        this.N.setVisibility(0);
    }

    private void V9(boolean z16) {
        aa(z16);
        ba();
    }

    private void W9(String str) {
        if (this.L == null || TextUtils.isEmpty(str)) {
            return;
        }
        QLog.d("QZMHostCommentListPart", 1, "set permission text is " + str);
        this.L.setText(str);
        this.L.setVisibility(0);
    }

    private void X9(int i3) {
        if (this.K == null) {
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        if (i3 == 0) {
            sb5.append(getContext().getResources().getString(R.string.f133636n));
        } else {
            sb5.append(getContext().getResources().getString(R.string.f133636n));
            sb5.append("(");
            sb5.append(i3);
            sb5.append(")");
        }
        this.K.setText(sb5);
    }

    private void Y9(int i3) {
        if (this.I == null) {
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        if (i3 == 0) {
            sb5.append(getContext().getResources().getString(R.string.f133636n));
        } else {
            sb5.append(getContext().getResources().getString(R.string.f133636n));
            sb5.append("(");
            sb5.append(i3);
            sb5.append(")");
        }
        this.I.setText(sb5);
    }

    private void Z9(int i3) {
        if (this.J == null) {
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        if (i3 == 0) {
            sb5.append(getContext().getResources().getString(R.string.f133676r));
        } else {
            sb5.append(getContext().getResources().getString(R.string.f133676r));
            sb5.append("(");
            sb5.append(i3);
            sb5.append(")");
        }
        this.J.setText(sb5);
    }

    private void aa(boolean z16) {
        LinearLayout linearLayout = this.f58924h;
        if (linearLayout == null || this.f58925i == null) {
            return;
        }
        linearLayout.setVisibility(z16 ? 8 : 0);
        this.f58925i.setVisibility(z16 ? 0 : 8);
        if (z16) {
            N9();
        } else {
            O9();
        }
    }

    private void ba() {
        QZMFeedCommentInfo qZMFeedCommentInfo = this.f58922e;
        if (qZMFeedCommentInfo == null) {
            QLog.e("QZMHostCommentListPart", 1, "comment info is null");
            return;
        }
        QZMomentMeta$StLike qZMomentMeta$StLike = qZMFeedCommentInfo.mFeed.likeInfo;
        if (qZMomentMeta$StLike == null) {
            QLog.e("QZMHostCommentListPart", 1, "likeInfo info is null");
        } else {
            if (this.C) {
                return;
            }
            Z9(qZMomentMeta$StLike.count.get());
        }
    }

    @Override // gn.d
    public void L2(String str) {
        if (this.C) {
            W9(str);
        }
    }

    @Override // gn.d
    public void b8(int i3) {
        if (this.C) {
            X9(i3);
        } else {
            Y9(i3);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        return new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.Part
    public int getInitRelyViewStubId() {
        return R.id.nld;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        QZMSlidBottomView qZMSlidBottomView = this.f58921d;
        if (qZMSlidBottomView != null && qZMSlidBottomView.getVisibility() == 0) {
            this.f58921d.c();
            return true;
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        if (view == null) {
            return;
        }
        QZMSlidBottomView qZMSlidBottomView = (QZMSlidBottomView) view.findViewById(R.id.mjt);
        this.f58921d = qZMSlidBottomView;
        this.f58923f = (LinearLayout) qZMSlidBottomView.findViewById(R.id.mju);
        this.E = (ViewPager2) this.f58921d.findViewById(R.id.f162775mk3);
        this.f58924h = (LinearLayout) this.f58921d.findViewById(R.id.mkm);
        this.f58925i = (LinearLayout) this.f58921d.findViewById(R.id.mkl);
        this.G = (FrameLayout) this.f58921d.findViewById(R.id.mlk);
        this.H = (FrameLayout) this.f58921d.findViewById(R.id.mlo);
        this.I = (TextView) this.f58921d.findViewById(R.id.mli);
        this.J = (TextView) this.f58921d.findViewById(R.id.mlm);
        this.M = (ImageView) this.f58921d.findViewById(R.id.mlj);
        this.N = (ImageView) this.f58921d.findViewById(R.id.mln);
        this.K = (TextView) this.f58921d.findViewById(R.id.mkk);
        this.P = (ImageView) this.f58921d.findViewById(R.id.mjz);
        this.L = (TextView) this.f58921d.findViewById(R.id.f162772mk0);
        this.G.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.qzmoment.part.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                QZMCommentPanelPart.this.R9(view2);
            }
        });
        this.H.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.qzmoment.part.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                QZMCommentPanelPart.this.S9(view2);
            }
        });
        P9();
        this.P.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.qzmoment.part.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                QZMCommentPanelPart.this.T9(view2);
            }
        });
        V9(this.C);
        Q9();
        this.f58921d.g(this.f58923f);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        SimpleEventBus.getInstance().registerReceiver(this);
        registerIoc(this, gn.d.class);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // gn.d
    public void r5(int i3) {
        if (this.C) {
            QLog.d("QZMHostCommentListPart", 1, "guest comment panel not show praise list");
        } else {
            Z9(i3);
        }
    }

    protected void showCommentPanel() {
        if (this.f58921d == null || this.f58923f == null) {
            return;
        }
        Q9();
        this.f58921d.g(this.f58923f);
    }

    private void N9() {
        X9(0);
    }

    private void O9() {
        Y9(0);
        Z9(0);
    }

    @Override // gn.d
    public void J6(QZMFeedCommentInfo qZMFeedCommentInfo) {
        if (qZMFeedCommentInfo == null) {
            QLog.e("QZMHostCommentListPart", 1, "comment info is null");
            return;
        }
        this.C = qZMFeedCommentInfo.mIsGuest;
        this.f58922e = qZMFeedCommentInfo;
        I9();
        V9(this.C);
        this.D = qZMFeedCommentInfo.mIsFromHostPraise ? 1 : 0;
        if (this.f58926m) {
            showCommentPanel();
        } else {
            this.f58926m = true;
            startInit();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ca(int i3) {
        if (i3 == 0) {
            J9();
        } else {
            if (i3 != 1) {
                return;
            }
            U9();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class a implements QZMSlidBottomView.c {
        a() {
        }

        @Override // com.qzone.reborn.qzmoment.util.QZMSlidBottomView.c
        public void a() {
        }

        @Override // com.qzone.reborn.qzmoment.util.QZMSlidBottomView.c
        public void b() {
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
    }
}
