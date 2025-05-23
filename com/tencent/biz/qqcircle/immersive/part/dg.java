package com.tencent.biz.qqcircle.immersive.part;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Size;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.biz.qqcircle.beans.QCircleFolderBean;
import com.tencent.biz.qqcircle.immersive.views.QFSPageTurnContainer;
import com.tencent.biz.qqcircle.utils.QCircleSlidBottomView;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.qqcircle.widgets.QCircleRoundCorneredRelativeLayout;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StRecomInfo;
import java.util.List;
import java.util.Map;
import qqcircle.QQCircleDitto$StItemContainer;
import qqcircle.QQCircleDitto$StItemInfo;
import qqcircle.QQCircleFeedBase$StReportInfoForClient;

/* compiled from: P */
/* loaded from: classes4.dex */
public class dg extends u {
    private Size C;
    private final GestureDetector D = new GestureDetector(getContext(), new a());
    private QCircleSlidBottomView.d E = new b();
    private float F;

    /* renamed from: d, reason: collision with root package name */
    private final Class<? extends com.tencent.biz.qqcircle.viewmodels.a> f87966d;

    /* renamed from: e, reason: collision with root package name */
    private View f87967e;

    /* renamed from: f, reason: collision with root package name */
    private View f87968f;

    /* renamed from: h, reason: collision with root package name */
    private com.tencent.biz.qqcircle.immersive.layer.base.e f87969h;

    /* renamed from: i, reason: collision with root package name */
    private QCircleSlidBottomView f87970i;

    /* renamed from: m, reason: collision with root package name */
    private QFSPageTurnContainer f87971m;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a extends GestureDetector.SimpleOnGestureListener {
        a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
            if (Math.abs(f17) > Math.abs(f16)) {
                if (f17 > 0.0f) {
                    if (f17 > dg.this.F) {
                        dg.this.U9();
                        return true;
                    }
                    return true;
                }
                if ((-f17) > dg.this.F) {
                    dg.this.V9();
                    return true;
                }
                return true;
            }
            return true;
        }
    }

    public dg(Class<? extends com.tencent.biz.qqcircle.viewmodels.a> cls) {
        this.f87966d = cls;
    }

    private void I9(final View view, final FeedCloudMeta$StFeed feedCloudMeta$StFeed, final int i3) {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.de
            @Override // java.lang.Runnable
            public final void run() {
                dg.L9(view, feedCloudMeta$StFeed, i3);
            }
        });
    }

    private void J9(View view, QQCircleDitto$StItemContainer qQCircleDitto$StItemContainer) {
        if (qQCircleDitto$StItemContainer == null) {
            QLog.e("QFSMiddlePageNewUserGuidePart", 1, "initGoCircleButtonInfo stItemContainer is null");
            return;
        }
        TextView textView = (TextView) view.findViewById(R.id.f108336cu);
        String str = qQCircleDitto$StItemContainer.title.get();
        if (TextUtils.isEmpty(str)) {
            str = com.tencent.biz.qqcircle.utils.h.a(R.string.f183943kj);
        }
        textView.setText(str);
        final String c16 = com.tencent.biz.qqcircle.immersive.utils.t.c(qQCircleDitto$StItemContainer.urlInfo, "title_jump_url");
        view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.part.dc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                dg.M9(view2);
            }
        });
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.part.dd
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                dg.this.N9(c16, view2);
            }
        });
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        VideoReport.setElementId(textView, QCircleDaTongConstant.ElementId.EM_XSJ_DRAFT_GUIDE_TEXT);
        VideoReport.setElementExposePolicy(textView, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementParams(textView, buildElementParams);
        VideoReport.setElementClickPolicy(textView, ClickPolicy.REPORT_ALL);
    }

    private void K9(View view, QQCircleDitto$StItemContainer qQCircleDitto$StItemContainer) {
        if (qQCircleDitto$StItemContainer != null && qQCircleDitto$StItemContainer.items != null) {
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_RECOMMENDATION_MODULE);
            VideoReport.setElementParams(view, buildElementParams);
            VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
            VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
            View findViewById = view.findViewById(R.id.f45251rd);
            View findViewById2 = view.findViewById(R.id.f45261re);
            View findViewById3 = view.findViewById(R.id.f45271rf);
            Y9(findViewById, qQCircleDitto$StItemContainer.items, 0);
            Y9(findViewById2, qQCircleDitto$StItemContainer.items, 1);
            Y9(findViewById3, qQCircleDitto$StItemContainer.items, 2);
            J9(view.findViewById(R.id.yvm), qQCircleDitto$StItemContainer);
            VideoReport.traversePage(getPartRootView());
            return;
        }
        QLog.e("QFSMiddlePageNewUserGuidePart", 1, "initNewUserGuideFeedLayout stItemContainer is null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void L9(View view, FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_FEED_CARD);
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_feed_id", feedCloudMeta$StFeed.f398449id.get());
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, feedCloudMeta$StFeed.poster.f398463id.get());
        QQCircleFeedBase$StReportInfoForClient qQCircleFeedBase$StReportInfoForClient = new QQCircleFeedBase$StReportInfoForClient();
        try {
            qQCircleFeedBase$StReportInfoForClient.mergeFrom(feedCloudMeta$StFeed.reportInfoForClient.get().toByteArray());
            if (!TextUtils.isEmpty(qQCircleFeedBase$StReportInfoForClient.datongJsonData.get())) {
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_TRANSFER_INFO, qQCircleFeedBase$StReportInfoForClient.datongJsonData.get());
            }
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_INDEX, Integer.valueOf(i3));
        VideoReport.setElementParams(view, buildElementParams);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void M9(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N9(String str, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        W9(str, false);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O9(e30.b bVar) {
        if (bVar == null) {
            return;
        }
        QLog.e("QFSMiddlePageNewUserGuidePart", 1, "newUserGuideFeed change");
        Object b16 = bVar.b(String.valueOf(bVar.g().dittoFeed.dittoId.get()));
        if (b16 instanceof QQCircleDitto$StItemContainer) {
            aa((QQCircleDitto$StItemContainer) b16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P9(String str, boolean z16) {
        QLog.d("QFSMiddlePageNewUserGuidePart", 1, "openQcircleAndJumpScheme succeed");
        S9(str, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q9(FeedCloudCommon$Entry feedCloudCommon$Entry, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        W9(feedCloudCommon$Entry.value.get(), true);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R9(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        this.f87970i.g();
        EventCollector.getInstance().onViewClicked(view);
    }

    private void S9(String str, boolean z16) {
        QCircleFolderBean qCircleFolderBean = new QCircleFolderBean();
        qCircleFolderBean.setAssignShowTabType(6);
        qCircleFolderBean.setFromReportBean(getReportBean().m466clone());
        qCircleFolderBean.setEnableSplash(true);
        qCircleFolderBean.setLastPageScheme(str);
        qCircleFolderBean.setForceFromNetwork(z16);
        com.tencent.biz.qqcircle.launcher.c.I(getContext(), qCircleFolderBean);
    }

    private void T9(ImageView imageView, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        QCircleFeedPicLoader.g().loadImage(Option.obtain().setTargetView(imageView).setUrl(feedCloudMeta$StFeed.cover.picUrl.get()).setFailDrawable(com.tencent.biz.qqcircle.immersive.manager.d.c().d(R.drawable.naw)).setPredecode(true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V9() {
        ViewPager2 B;
        List<e30.b> O1;
        QFSPageTurnContainer qFSPageTurnContainer = this.f87971m;
        if (qFSPageTurnContainer == null || (B = qFSPageTurnContainer.B()) == null || B.getAdapter() == null || (O1 = this.f87969h.O1()) == null) {
            return;
        }
        if (O1.size() == B.getCurrentItem() + 1) {
            Z9();
        }
    }

    private void W9(final String str, final boolean z16) {
        QLog.d("QFSMiddlePageNewUserGuidePart", 1, "openQcircleAndJumpScheme");
        com.tencent.biz.qqcircle.utils.t.b(str, new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.df
            @Override // java.lang.Runnable
            public final void run() {
                dg.this.P9(str, z16);
            }
        });
    }

    private void Y9(View view, PBRepeatMessageField<QQCircleDitto$StItemInfo> pBRepeatMessageField, int i3) {
        if (pBRepeatMessageField != null && pBRepeatMessageField.size() > i3) {
            QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo = pBRepeatMessageField.get(i3);
            PBRepeatMessageField<FeedCloudMeta$StFeed> pBRepeatMessageField2 = qQCircleDitto$StItemInfo.feeds;
            if (pBRepeatMessageField2.size() == 0) {
                QLog.e("QFSMiddlePageNewUserGuidePart", 1, "setQfsNewUserGuideItemValue stFeedList is empty");
                return;
            }
            PBRepeatMessageField<FeedCloudCommon$Entry> pBRepeatMessageField3 = qQCircleDitto$StItemInfo.urlInfo;
            if (pBRepeatMessageField3.size() == 0) {
                QLog.e("QFSMiddlePageNewUserGuidePart", 1, "setQfsNewUserGuideItemValue urlInfoList is empty");
                return;
            }
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = pBRepeatMessageField2.get(0);
            final FeedCloudCommon$Entry feedCloudCommon$Entry = pBRepeatMessageField3.get(0);
            if (feedCloudMeta$StFeed != null && feedCloudMeta$StFeed.poster != null && feedCloudCommon$Entry != null) {
                ((QCircleAvatarView) view.findViewById(R.id.f165907du1)).setUser(feedCloudMeta$StFeed.poster, this.C);
                ((TextView) view.findViewById(R.id.k5h)).setText(feedCloudMeta$StFeed.poster.nick.get());
                if (view instanceof QCircleRoundCorneredRelativeLayout) {
                    float a16 = com.tencent.biz.qqcircle.utils.cx.a(4.0f);
                    ((QCircleRoundCorneredRelativeLayout) view).setRadius(a16, a16, a16, a16);
                }
                T9((ImageView) view.findViewById(R.id.lnn), feedCloudMeta$StFeed);
                X9((TextView) view.findViewById(R.id.k98), feedCloudMeta$StFeed);
                view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.part.db
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        dg.this.Q9(feedCloudCommon$Entry, view2);
                    }
                });
                I9(view, feedCloudMeta$StFeed, i3);
                return;
            }
            QLog.e("QFSMiddlePageNewUserGuidePart", 1, "setQfsNewUserGuideItemValue stFeed is null or urlInfo is null");
        }
    }

    private void Z9() {
        QCircleSlidBottomView qCircleSlidBottomView;
        Integer value = this.f87969h.a2().getValue();
        if (value != null && value.intValue() == 1 && (qCircleSlidBottomView = this.f87970i) != null) {
            qCircleSlidBottomView.x(this.f87967e);
        }
    }

    private void aa(QQCircleDitto$StItemContainer qQCircleDitto$StItemContainer) {
        View view = this.f87968f;
        if (view == null || this.f87967e != null) {
            return;
        }
        View inflate = ((ViewStub) view.findViewById(R.id.f45281rg)).inflate();
        QCircleSlidBottomView qCircleSlidBottomView = (QCircleSlidBottomView) inflate.findViewById(R.id.f31730ru);
        this.f87970i = qCircleSlidBottomView;
        qCircleSlidBottomView.e(this.E);
        View findViewById = inflate.findViewById(R.id.yvp);
        this.f87967e = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.part.da
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                dg.this.R9(view2);
            }
        });
        K9(this.f87967e, qQCircleDitto$StItemContainer);
    }

    private void initViewModel() {
        com.tencent.biz.qqcircle.immersive.layer.base.e eVar = (com.tencent.biz.qqcircle.immersive.layer.base.e) getViewModel(this.f87966d);
        this.f87969h = eVar;
        eVar.b2().observeForever(new Observer() { // from class: com.tencent.biz.qqcircle.immersive.part.cz
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                dg.this.O9((e30.b) obj);
            }
        });
    }

    public void X9(TextView textView, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        FeedCloudMeta$StRecomInfo feedCloudMeta$StRecomInfo;
        PBStringField pBStringField;
        String str;
        if (feedCloudMeta$StFeed != null && (feedCloudMeta$StRecomInfo = feedCloudMeta$StFeed.recomInfo) != null && (pBStringField = feedCloudMeta$StRecomInfo.recomReason) != null && pBStringField.get() != null && textView != null && (str = feedCloudMeta$StFeed.recomInfo.recomReason.get()) != null) {
            textView.setText(str);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSMiddlePageNewUserGuidePart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.F = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.f87968f = view;
        QFSPageTurnContainer qFSPageTurnContainer = (QFSPageTurnContainer) view.findViewById(R.id.f165301vg1);
        this.f87971m = qFSPageTurnContainer;
        qFSPageTurnContainer.setGestureDetector(this.D);
        initViewModel();
        this.C = com.tencent.biz.qqcircle.immersive.utils.n.a(view.getContext(), R.dimen.d38);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        com.tencent.biz.qqcircle.immersive.utils.ax.b(this.f87970i);
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class b implements QCircleSlidBottomView.d {
        b() {
        }

        @Override // com.tencent.biz.qqcircle.utils.QCircleSlidBottomView.d
        public /* synthetic */ void a() {
            com.tencent.biz.qqcircle.utils.ad.c(this);
        }

        @Override // com.tencent.biz.qqcircle.utils.QCircleSlidBottomView.d
        public /* synthetic */ void onConfigurationChanged() {
            com.tencent.biz.qqcircle.utils.ad.a(this);
        }

        @Override // com.tencent.biz.qqcircle.utils.QCircleSlidBottomView.d
        public void onShow() {
            VideoReport.traversePage(dg.this.getPartRootView());
        }

        @Override // com.tencent.biz.qqcircle.utils.QCircleSlidBottomView.d
        public void onDismiss() {
        }

        @Override // com.tencent.biz.qqcircle.utils.QCircleSlidBottomView.d
        public void onStatusChange(int i3) {
        }

        @Override // com.tencent.biz.qqcircle.utils.QCircleSlidBottomView.d
        public void onScrollChanged(int i3, int i16, int i17, int i18) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U9() {
    }
}
