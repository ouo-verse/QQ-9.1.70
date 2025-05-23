package com.tencent.biz.qqcircle.widgets.pymk;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleSettingBean;
import com.tencent.biz.qqcircle.d;
import com.tencent.biz.qqcircle.immersive.personal.data.w;
import com.tencent.biz.qqcircle.scrollers.QCircleFeedReportScroller;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.qqcircle.widgets.pymk.QCirclePYMKRecommendRecyclerView;
import com.tencent.biz.qqcircle.widgets.pymk.QCirclePYMKRecommendView;
import com.tencent.biz.qqcircle.widgets.pymk.a;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.message.TVKQQLiveAssetPlayerMsg;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.richframework.widget.scroll.OverScrollDecorator;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StDittoFeed;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.Map;
import qc0.j;
import qqcircle.QQCircleDitto$StItemContainer;
import ua0.c;

/* loaded from: classes5.dex */
public class QCirclePYMKRecommendView extends QCircleBaseWidgetView implements View.OnClickListener {
    protected com.tencent.biz.qqcircle.widgets.pymk.a C;
    protected RecyclerView.LayoutManager D;
    protected FeedCloudMeta$StFeed E;
    protected w F;
    protected QQCircleDitto$StItemContainer G;
    protected QCircleExtraTypeInfo H;
    protected View I;
    protected int J;
    protected int K;
    protected int L;
    protected QCircleFeedReportScroller M;
    private final Runnable N;

    /* renamed from: d, reason: collision with root package name */
    protected TextView f93818d;

    /* renamed from: e, reason: collision with root package name */
    protected ImageView f93819e;

    /* renamed from: f, reason: collision with root package name */
    protected TextView f93820f;

    /* renamed from: h, reason: collision with root package name */
    protected TextView f93821h;

    /* renamed from: i, reason: collision with root package name */
    protected ImageView f93822i;

    /* renamed from: m, reason: collision with root package name */
    protected RecyclerView f93823m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a extends RecyclerView.OnScrollListener {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i3) {
            super.onScrollStateChanged(recyclerView, i3);
            ((QCirclePYMKRecommendRecyclerView) QCirclePYMKRecommendView.this.f93823m).E(recyclerView.canScrollHorizontally(1));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i3, int i16) {
            super.onScrolled(recyclerView, i3, i16);
        }
    }

    public QCirclePYMKRecommendView(@NonNull Context context) {
        super(context);
        this.H = new QCircleExtraTypeInfo();
        this.J = -1;
        this.K = 0;
        this.L = -1;
        this.N = new Runnable() { // from class: qc0.b
            @Override // java.lang.Runnable
            public final void run() {
                QCirclePYMKRecommendView.this.n0();
            }
        };
        initView();
    }

    private void A0() {
        com.tencent.biz.qqcircle.widgets.pymk.a aVar = this.C;
        if (aVar == null) {
            QLog.d("PYMK-QCirclePYMKRecommendView", 1, "[updatePYMKViewPageId] recommend adapter should not be null.");
        } else {
            aVar.A0(this.K);
        }
    }

    private void B0() {
        if (this.f93818d != null && this.f93819e != null) {
            if (j.f428831a.d()) {
                this.f93819e.setVisibility(0);
            } else {
                this.f93819e.setVisibility(8);
            }
        }
    }

    private void C0() {
        RecyclerView recyclerView = this.f93823m;
        if (recyclerView == null) {
            QLog.d("PYMK-QCirclePYMKRecommendView", 1, "[updateRecyclerMargin] recommend recycler should not be null.");
        } else {
            if (this.K == 94) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = recyclerView.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                ((FrameLayout.LayoutParams) layoutParams).topMargin = 0;
            }
        }
    }

    private void D0(e30.b bVar, int i3) {
        String str;
        if (this.I == null) {
            return;
        }
        QCircleExtraTypeInfo qCircleExtraTypeInfo = this.H;
        if (qCircleExtraTypeInfo != null) {
            qCircleExtraTypeInfo.mFeed = bVar.g();
            QCircleExtraTypeInfo qCircleExtraTypeInfo2 = this.H;
            qCircleExtraTypeInfo2.mPlayScene = 1;
            qCircleExtraTypeInfo2.mDataPosition = i3;
        } else {
            QLog.d("PYMK-QCirclePYMKRecommendView", 1, "[updateReportInfo] current report info should not be null.");
        }
        VideoReport.setElementId(this.I, QCircleDaTongConstant.ElementId.EM_XSJ_PYMK_BOX);
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.putAll(c.d(bVar));
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_INDEX, Integer.valueOf(i3 + 1));
        QQCircleDitto$StItemContainer qQCircleDitto$StItemContainer = this.G;
        if (qQCircleDitto$StItemContainer == null) {
            str = "";
        } else {
            str = qQCircleDitto$StItemContainer.title.get();
        }
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_RECOM_TITLE, str);
        VideoReport.setElementParams(this.I, buildElementParams);
        VideoReport.setElementReuseIdentifier(this.I, QCircleDaTongConstant.ElementId.EM_XSJ_PYMK_BOX + this.I.hashCode());
        VideoReport.setElementExposePolicy(this.I, ExposurePolicy.REPORT_ALL);
    }

    private void E0() {
        com.tencent.biz.qqcircle.widgets.pymk.a aVar = this.C;
        if (aVar == null) {
            QLog.d("PYMK-QCirclePYMKRecommendView", 1, "[updateSplashFlag] update splash flag fail, adapter should not be null.");
        } else {
            aVar.B0(true);
        }
    }

    private void F0() {
        TextView textView = this.f93821h;
        if (textView == null) {
            return;
        }
        if (this.K == 94) {
            textView.setVisibility(0);
            this.f93821h.setText(this.G.title.get());
        } else {
            textView.setVisibility(8);
        }
    }

    private void initView() {
        this.I = getRootView();
        this.f93818d = (TextView) findViewById(R.id.f29690mb);
        ImageView imageView = (ImageView) findViewById(R.id.f29650m8);
        this.f93819e = imageView;
        imageView.setOnClickListener(this);
        ImageView imageView2 = (ImageView) findViewById(R.id.f29670m_);
        this.f93822i = imageView2;
        imageView2.setOnClickListener(this);
        TextView textView = (TextView) findViewById(R.id.f29580m1);
        this.f93820f = textView;
        textView.setOnClickListener(this);
        int dpToPx = ImmersiveUtils.dpToPx(10.0f);
        QCirclePluginUtil.expandViewTouchDelegate(this.f93822i, dpToPx, dpToPx, dpToPx, dpToPx);
        QCirclePluginUtil.expandViewTouchDelegate(this.f93820f, dpToPx, dpToPx, dpToPx, dpToPx);
        this.f93823m = (RecyclerView) findViewById(R.id.f29660m9);
        SafeLinearLayoutManager safeLinearLayoutManager = new SafeLinearLayoutManager(getContext(), 0, false);
        this.D = safeLinearLayoutManager;
        this.f93823m.setLayoutManager(safeLinearLayoutManager);
        this.f93823m.setItemAnimator(new DefaultItemAnimator());
        com.tencent.biz.qqcircle.widgets.pymk.a aVar = new com.tencent.biz.qqcircle.widgets.pymk.a();
        this.C = aVar;
        aVar.q0(this);
        this.C.setReportBean(this.mReportBean);
        this.C.A0(this.K);
        this.C.p0(this.f93823m);
        this.C.y0(this.M);
        this.f93823m.setAdapter(this.C);
        if (j.f428831a.d()) {
            o0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n0() {
        QQCircleDitto$StItemContainer qQCircleDitto$StItemContainer = this.G;
        if (qQCircleDitto$StItemContainer == null) {
            QLog.d("PYMK-QCirclePYMKRecommendView", 1, "[onClick] container should not be null.");
            return;
        }
        com.tencent.biz.qqcircle.launcher.c.o0(getContext(), d.d(qQCircleDitto$StItemContainer.urlInfo.get(), "personRecomListUrl"), null, -1);
        v0();
    }

    private void o0() {
        RecyclerView recyclerView = this.f93823m;
        if (recyclerView == null || !(recyclerView instanceof QCirclePYMKRecommendRecyclerView)) {
            return;
        }
        new OverScrollDecorator(recyclerView).serHorizontalOverScrollEnable(true, true);
        ((QCirclePYMKRecommendRecyclerView) this.f93823m).F(true);
        ((QCirclePYMKRecommendRecyclerView) this.f93823m).C(new QCirclePYMKRecommendRecyclerView.a() { // from class: qc0.d
            @Override // com.tencent.biz.qqcircle.widgets.pymk.QCirclePYMKRecommendRecyclerView.a
            public final void onDragEnd() {
                QCirclePYMKRecommendView.this.s0();
            }
        });
        this.f93823m.addOnScrollListener(new a());
    }

    private void p0() {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        TextView textView = this.f93820f;
        if (textView != null) {
            VideoReport.setElementId(textView, QCircleDaTongConstant.ElementId.EM_XSJ_PYMK_MORE);
            VideoReport.setElementParams(this.f93820f, buildElementParams);
            VideoReport.setElementReuseIdentifier(this.f93820f, "em_xsj_pymk_more_" + this.f93820f.hashCode());
        }
        ImageView imageView = this.f93822i;
        if (imageView != null) {
            VideoReport.setElementId(imageView, QCircleDaTongConstant.ElementId.EM_XSJ_PYMK_MORE);
            VideoReport.setElementParams(this.f93822i, buildElementParams);
            VideoReport.setElementReuseIdentifier(this.f93822i, "em_xsj_pymk_more_" + this.f93822i.hashCode());
        }
    }

    private void q0(e30.b bVar, FeedCloudMeta$StDittoFeed feedCloudMeta$StDittoFeed) {
        if (bVar == null) {
            QLog.d("PYMK-QCirclePYMKRecommendView", 1, "[fillContainerSource] blockData should not be null.");
            return;
        }
        if (feedCloudMeta$StDittoFeed == null) {
            QLog.d("PYMK-QCirclePYMKRecommendView", 1, "[fillContainerSource] dittoFeed should not be null.");
            return;
        }
        try {
            this.G = new QQCircleDitto$StItemContainer();
            Object b16 = bVar.b(String.valueOf(feedCloudMeta$StDittoFeed.dittoId.get()));
            if (b16 instanceof QQCircleDitto$StItemContainer) {
                this.G = (QQCircleDitto$StItemContainer) b16;
                QLog.d("PYMK-QCirclePYMKRecommendView", 4, "[bindData] get data from blockData");
            } else {
                this.G.mergeFrom(feedCloudMeta$StDittoFeed.dittoData.get().toByteArray());
                QLog.d("PYMK-QCirclePYMKRecommendView", 4, "[bindData] get data from merger");
            }
        } catch (Exception e16) {
            QLog.e("PYMK-QCirclePYMKRecommendView", 1, "[bindData] Exception:", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s0() {
        RFWThreadManager.getUIHandler().removeCallbacks(this.N);
        RFWThreadManager.getUIHandler().postDelayed(this.N, 160L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u0(DialogInterface dialogInterface, int i3) {
        if (i3 == 1) {
            QCircleSettingBean qCircleSettingBean = new QCircleSettingBean();
            qCircleSettingBean.setFromPage(TVKQQLiveAssetPlayerMsg.PLAYER_INFO_ON_RICH_MEDIA_PREPARE_FAILED);
            com.tencent.biz.qqcircle.launcher.c.C0(getContext(), qCircleSettingBean);
        }
    }

    private void v0() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        String str;
        int i3;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed2;
        QCircleExtraTypeInfo qCircleExtraTypeInfo = this.H;
        if (qCircleExtraTypeInfo != null) {
            feedCloudMeta$StFeed = qCircleExtraTypeInfo.mFeed;
        } else {
            feedCloudMeta$StFeed = null;
        }
        QCircleLpReportDc05501.DataBuilder subActionType = c.a(feedCloudMeta$StFeed).setActionType(29).setSubActionType(2);
        QCircleExtraTypeInfo qCircleExtraTypeInfo2 = this.H;
        if (qCircleExtraTypeInfo2 != null && (feedCloudMeta$StFeed2 = qCircleExtraTypeInfo2.mFeed) != null) {
            str = feedCloudMeta$StFeed2.poster.f398463id.get();
        } else {
            str = "";
        }
        QCircleLpReportDc05501.DataBuilder toUin = subActionType.setToUin(str);
        QCircleExtraTypeInfo qCircleExtraTypeInfo3 = this.H;
        if (qCircleExtraTypeInfo3 != null) {
            i3 = qCircleExtraTypeInfo3.mDataPosition;
        } else {
            i3 = -1;
        }
        QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(toUin.setIndex(i3).setPageId(this.K)));
    }

    private void w0(int i3, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (this.C == null) {
            QLog.d("PYMK-QCirclePYMKRecommendView", 1, "[setAdapterSource] recommend adapter should not be null.");
            return;
        }
        QQCircleDitto$StItemContainer qQCircleDitto$StItemContainer = this.G;
        if (qQCircleDitto$StItemContainer == null) {
            QLog.d("PYMK-QCirclePYMKRecommendView", 1, "[setDataSource] container should not be null.");
            return;
        }
        QLog.d("PYMK-QCirclePYMKRecommendView", 1, "[setAdapterSource] dittoFeed pos: ", Integer.valueOf(i3), " | itemSize: ", Integer.valueOf(qQCircleDitto$StItemContainer.items.size()), " | styleType: ", Integer.valueOf(this.G.styleType.get()));
        this.C.o0(this.G);
        this.C.x0(feedCloudMeta$StFeed, i3, this.G.items.get(), this.G.styleType.get());
    }

    private void x0() {
        DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: qc0.c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                QCirclePYMKRecommendView.this.u0(dialogInterface, i3);
            }
        };
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(getContext(), 230);
        createCustomDialog.getMessageTextView().setMaxHeight(ViewUtils.getScreenHeight());
        createCustomDialog.setTitle("\u8bf4\u660e");
        createCustomDialog.setMessage(HardCodeUtil.qqStr(R.string.f194374bq));
        createCustomDialog.setNegativeButton("\u53d6\u6d88", onClickListener);
        createCustomDialog.setPositiveButton("\u53bb\u8bbe\u7f6e", onClickListener);
        createCustomDialog.show();
    }

    private void y0() {
        QQCircleDitto$StItemContainer qQCircleDitto$StItemContainer = this.G;
        boolean z16 = true;
        if (qQCircleDitto$StItemContainer == null) {
            QLog.w("PYMK-QCirclePYMKRecommendView", 1, "[checkChangeStyleType] container == null.");
            return;
        }
        if (this.L == qQCircleDitto$StItemContainer.styleType.get()) {
            z16 = false;
        }
        if (z16) {
            this.f93823m.removeAllViews();
        }
        this.L = this.G.styleType.get();
    }

    private void z0() {
        View view = this.I;
        if (view == null) {
            return;
        }
        View findViewById = view.findViewById(R.id.f29570m0);
        if (findViewById == null) {
            QLog.w("PYMK-QCirclePYMKRecommendView", 1, "[updateMainRecommendParentBackground] main recommend layout should not be null.");
            return;
        }
        findViewById.setVisibility(8);
        Object parent = findViewById.getParent();
        if (parent instanceof View) {
            ((View) parent).setBackgroundColor(getResources().getColor(R.color.aju));
        } else {
            QLog.d("PYMK-QCirclePYMKRecommendView", 1, "[updateMainRecommendParentBackground] current recommend parent not a view.");
        }
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public void bindData(Object obj, int i3) {
        FeedCloudMeta$StDittoFeed feedCloudMeta$StDittoFeed;
        if (this.C == null) {
            QLog.d("PYMK-QCirclePYMKRecommendView", 1, "[bindData] current adapter should not be null.");
            return;
        }
        if (!(obj instanceof e30.b)) {
            QLog.d("PYMK-QCirclePYMKRecommendView", 1, "[bindData] current obj data not is FeedBlockData type.");
            return;
        }
        e30.b bVar = (e30.b) obj;
        FeedCloudMeta$StFeed g16 = bVar.g();
        if (g16 == this.E) {
            QLog.d("PYMK-QCirclePYMKRecommendView", 1, "[bindData] feed == mFeed, return.");
            return;
        }
        this.f93823m.scrollToPosition(0);
        this.E = g16;
        if (g16 == null) {
            feedCloudMeta$StDittoFeed = null;
        } else {
            feedCloudMeta$StDittoFeed = g16.dittoFeed.get();
        }
        q0(bVar, feedCloudMeta$StDittoFeed);
        D0(bVar, i3);
        y0();
        w0(i3, g16);
        p0();
        F0();
        B0();
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.g38;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "PYMK-QCirclePYMKRecommendView";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.f29670m_) {
            n0();
        } else if (id5 == R.id.f29580m1) {
            n0();
        } else if (id5 == R.id.f29650m8) {
            x0();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        RFWThreadManager.getUIHandler().removeCallbacks(this.N);
    }

    public RecyclerView r0() {
        return this.f93823m;
    }

    public void setPageId(int i3) {
        this.K = i3;
        com.tencent.biz.qqcircle.widgets.pymk.a aVar = this.C;
        if (aVar != null) {
            aVar.A0(i3);
        }
    }

    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public void setReportBean(QCircleReportBean qCircleReportBean) {
        super.setReportBean(qCircleReportBean);
        com.tencent.biz.qqcircle.widgets.pymk.a aVar = this.C;
        if (aVar == null) {
            QLog.w("PYMK-QCirclePYMKRecommendView", 1, "[setReportBean] recommend adapter should not be null.");
        } else {
            this.mReportBean = qCircleReportBean;
            aVar.setReportBean(qCircleReportBean);
        }
    }

    public void setReportScroller(QCircleFeedReportScroller qCircleFeedReportScroller) {
        this.M = qCircleFeedReportScroller;
        com.tencent.biz.qqcircle.widgets.pymk.a aVar = this.C;
        if (aVar == null) {
            QLog.d("PYMK-QCirclePYMKRecommendView", 1, "[setFeedReportScroller] recommend adapter should not be null.");
        } else {
            aVar.y0(qCircleFeedReportScroller);
        }
    }

    public void setSplashRecommendPageId(int i3) {
        this.K = i3;
        this.J = 50002;
        E0();
        C0();
        z0();
        A0();
    }

    public void setUserInfo(w wVar) {
        this.F = wVar;
    }

    public void setWidgetHideIntercept(a.InterfaceC0939a interfaceC0939a) {
        com.tencent.biz.qqcircle.widgets.pymk.a aVar = this.C;
        if (aVar == null) {
            QLog.d("PYMK-QCirclePYMKRecommendView", 1, "[setWidgetHideIntercept] recommend adapter should not be null.");
        } else {
            aVar.C0(interfaceC0939a);
        }
    }

    public QCirclePYMKRecommendView(@NonNull Context context, Integer num) {
        super(context, num.intValue());
        this.H = new QCircleExtraTypeInfo();
        this.J = -1;
        this.K = 0;
        this.L = -1;
        this.N = new Runnable() { // from class: qc0.b
            @Override // java.lang.Runnable
            public final void run() {
                QCirclePYMKRecommendView.this.n0();
            }
        };
        initView();
    }
}
