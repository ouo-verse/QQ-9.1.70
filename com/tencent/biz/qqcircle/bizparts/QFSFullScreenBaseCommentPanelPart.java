package com.tencent.biz.qqcircle.bizparts;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.Outline;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.adapter.QFSCommentBlock;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QFSCommentInfo;
import com.tencent.biz.qqcircle.beans.QFSCommentInputWindowConfig;
import com.tencent.biz.qqcircle.beans.QFSCommentItemInfo;
import com.tencent.biz.qqcircle.beans.QFSReplyItemInfo;
import com.tencent.biz.qqcircle.comment.QFSCommentReportHelper;
import com.tencent.biz.qqcircle.comment.effect.QFSCommentEffectUtil;
import com.tencent.biz.qqcircle.comment.wrapper.QFSCommentGuildCardWrapper;
import com.tencent.biz.qqcircle.events.QCircleCommentUpdateEvent;
import com.tencent.biz.qqcircle.events.QCirclePanelStateEvent;
import com.tencent.biz.qqcircle.events.QCircleResetCommentBlockEvent;
import com.tencent.biz.qqcircle.events.QFSCommentCloseEvent;
import com.tencent.biz.qqcircle.events.QFSCommentLocateEvent;
import com.tencent.biz.qqcircle.events.QFSCommentTabSelectEvent;
import com.tencent.biz.qqcircle.events.QFSGoodsUpdateEvent;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.qqcircle.fragments.QCircleBlockMerger;
import com.tencent.biz.qqcircle.hodor.QFSHodorCollectManager;
import com.tencent.biz.qqcircle.immersive.events.QFSCommentOpenPicPanel;
import com.tencent.biz.qqcircle.immersive.events.QFSEnableSlideRightActionEvent;
import com.tencent.biz.qqcircle.immersive.manager.QFSEcommercePreloadManager;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.utils.QCircleNetWorkTestHelper;
import com.tencent.biz.qqcircle.utils.QFSCommentHelper;
import com.tencent.biz.qqcircle.utils.QFSHalfScreenFloatingView;
import com.tencent.biz.qqcircle.utils.QFSQUIUtilsKt;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.biz.qqcircle.widgets.QFSPagAnimView;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoaderFactory;
import com.tencent.biz.richframework.network.util.VSNetworkSpeedHelper;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.richframework.part.block.BlockMerger;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.auto.engine.event.ASEngineTabStatusEvent;
import com.tencent.mobileqq.auto.engine.lib.ASEngineConstants;
import com.tencent.mobileqq.engineering.preload.PreLoader;
import com.tencent.mobileqq.engineering.preload.inter.OnTaskListener;
import com.tencent.mobileqq.qcircle.api.global.QCircleUserLabelConfig;
import com.tencent.mobileqq.qqecommerce.biz.consumer.api.IQQGoodsViewModel;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.compat.immersive.RFWNavigationBarImmersiveHelper;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.text.rich.RFWAsyncRichTextView;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.QCircleReportHelper;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StComment;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StReply;
import feedcloud.FeedCloudMeta$StUser;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;
import qqcircle.QQCircleFeedBase$StBusiInfoCommentListData;

/* loaded from: classes4.dex */
public class QFSFullScreenBaseCommentPanelPart extends ag implements r20.a {

    /* renamed from: i0, reason: collision with root package name */
    private static final int f82765i0 = com.tencent.biz.qqcircle.utils.cx.a(8.0f);

    /* renamed from: j0, reason: collision with root package name */
    private static final int f82766j0 = (RFWApplication.getApplication().getResources().getDimensionPixelSize(R.dimen.d0m) - RFWApplication.getApplication().getResources().getDimensionPixelSize(R.dimen.d0l)) / 2;
    private RelativeLayout C;
    private QCircleAsyncTextView D;
    private ImageView E;
    private ImageView F;
    protected ImageView G;
    private ImageView H;
    private View I;
    private ImageView J;
    private QFSPagAnimView K;
    private ViewGroup L;
    private ImageView M;
    private ImageView N;
    private View P;
    private View Q;
    private ViewGroup R;
    private FeedCloudMeta$StFeed S;
    private boolean T;
    private long U;
    private boolean V;
    protected boolean W;
    private IQQGoodsViewModel X;
    private com.tencent.biz.qqcircle.comment.emoji.o Y;
    private com.tencent.biz.qqcircle.comment.effect.e Z;

    /* renamed from: a0, reason: collision with root package name */
    private com.tencent.biz.qqcircle.comment.emoji.a f82767a0;

    /* renamed from: b0, reason: collision with root package name */
    protected com.tencent.biz.qqcircle.adapter.r f82768b0;

    /* renamed from: c0, reason: collision with root package name */
    private QFSCommentGuildCardWrapper f82769c0;

    /* renamed from: d, reason: collision with root package name */
    protected FrameLayout f82770d;

    /* renamed from: d0, reason: collision with root package name */
    private int f82771d0;

    /* renamed from: e, reason: collision with root package name */
    private FrameLayout f82772e;

    /* renamed from: e0, reason: collision with root package name */
    private boolean f82773e0;

    /* renamed from: f, reason: collision with root package name */
    private QFSHalfScreenFloatingView f82774f;

    /* renamed from: f0, reason: collision with root package name */
    private int f82775f0;

    /* renamed from: g0, reason: collision with root package name */
    private QFSCommentInputWindowConfig f82776g0;

    /* renamed from: h, reason: collision with root package name */
    private boolean f82777h;

    /* renamed from: h0, reason: collision with root package name */
    private final QCircleBlockMerger.a f82778h0;

    /* renamed from: i, reason: collision with root package name */
    private FrameLayout f82779i;

    /* renamed from: m, reason: collision with root package name */
    private QCircleBlockContainer f82780m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements QFSPagAnimView.c {
        a() {
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSPagAnimView.c
        public /* synthetic */ void onAnimationCancel(QFSPagAnimView qFSPagAnimView) {
            com.tencent.biz.qqcircle.widgets.bc.a(this, qFSPagAnimView);
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSPagAnimView.c
        public /* synthetic */ void onAnimationEnd(QFSPagAnimView qFSPagAnimView) {
            com.tencent.biz.qqcircle.widgets.bc.b(this, qFSPagAnimView);
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSPagAnimView.c
        public /* synthetic */ void onAnimationRepeat(QFSPagAnimView qFSPagAnimView) {
            com.tencent.biz.qqcircle.widgets.bc.c(this, qFSPagAnimView);
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSPagAnimView.c
        public /* synthetic */ void onAnimationStart(QFSPagAnimView qFSPagAnimView) {
            com.tencent.biz.qqcircle.widgets.bc.d(this, qFSPagAnimView);
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSPagAnimView.c
        public void onAnimationUpdate(QFSPagAnimView qFSPagAnimView) {
            QLog.d("QFSFullScreenBaseCommentPanelPart", 1, "[tryShowBtnPublishAnim] show comment pic entrance pag anim. ");
            QFSFullScreenBaseCommentPanelPart.this.K.setVisibility(0);
            QFSFullScreenBaseCommentPanelPart.this.M.setVisibility(8);
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSPagAnimView.c
        public /* synthetic */ void onPagPlayError(QFSPagAnimView qFSPagAnimView, String str) {
            com.tencent.biz.qqcircle.widgets.bc.f(this, qFSPagAnimView, str);
        }
    }

    /* loaded from: classes4.dex */
    class b implements QCircleBlockMerger.a {
        b() {
        }

        @Override // com.tencent.biz.qqcircle.fragments.QCircleBlockMerger.a
        public void onLoadMoreDisplay() {
            QFSFullScreenBaseCommentPanelPart qFSFullScreenBaseCommentPanelPart = QFSFullScreenBaseCommentPanelPart.this;
            qFSFullScreenBaseCommentPanelPart.reportFooterAbnormalImp(qFSFullScreenBaseCommentPanelPart.f82780m);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class c extends ViewOutlineProvider {
        c() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), QFSFullScreenBaseCommentPanelPart.f82765i0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class d implements QUSBaseHalfScreenFloatingView.n {
        d() {
        }

        @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.n
        public void onFinishDrag() {
            QFSFullScreenBaseCommentPanelPart.this.f82777h = false;
        }

        @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.n
        public void onStartDrag() {
            QFSFullScreenBaseCommentPanelPart.this.f82777h = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class e extends com.tencent.mobileqq.widget.qus.e {
        e() {
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public boolean canScrollDown(float f16, float f17) {
            com.tencent.biz.qqcircle.adapter.r rVar = QFSFullScreenBaseCommentPanelPart.this.f82768b0;
            if (rVar == null) {
                return false;
            }
            if (!rVar.p0() && !QFSFullScreenBaseCommentPanelPart.this.blockCanScrollDown()) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public boolean canScrollUp(float f16, float f17) {
            com.tencent.biz.qqcircle.adapter.r rVar;
            QFSFullScreenBaseCommentPanelPart qFSFullScreenBaseCommentPanelPart = QFSFullScreenBaseCommentPanelPart.this;
            if (qFSFullScreenBaseCommentPanelPart.W && (rVar = qFSFullScreenBaseCommentPanelPart.f82768b0) != null && !rVar.o0()) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mobileqq.widget.qus.d
        @Nullable
        /* renamed from: createContentView */
        public View getF57419d() {
            QFSFullScreenBaseCommentPanelPart qFSFullScreenBaseCommentPanelPart = QFSFullScreenBaseCommentPanelPart.this;
            qFSFullScreenBaseCommentPanelPart.f82779i = (FrameLayout) LayoutInflater.from(qFSFullScreenBaseCommentPanelPart.getContext()).inflate(R.layout.g9u, (ViewGroup) null, false);
            return QFSFullScreenBaseCommentPanelPart.this.f82779i;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int initState() {
            return super.initState();
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int maxHeight() {
            return QFSFullScreenBaseCommentPanelPart.this.ca();
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int showMode() {
            return 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class f extends com.tencent.mobileqq.widget.qus.a {

        /* loaded from: classes4.dex */
        class a implements OnTaskListener<QCircleCommentUpdateEvent> {
            a() {
            }

            @Override // com.tencent.mobileqq.engineering.preload.inter.OnTaskListener
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onComplete(QCircleCommentUpdateEvent... qCircleCommentUpdateEventArr) {
                if (qCircleCommentUpdateEventArr.length > 0) {
                    QFSFullScreenBaseCommentPanelPart.this.handleGetCommentListInternal(qCircleCommentUpdateEventArr[0]);
                }
            }
        }

        f() {
        }

        @Override // com.tencent.mobileqq.widget.qus.a, com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.p
        public void onShowTotal() {
            QFSFullScreenBaseCommentPanelPart qFSFullScreenBaseCommentPanelPart = QFSFullScreenBaseCommentPanelPart.this;
            qFSFullScreenBaseCommentPanelPart.W = true;
            qFSFullScreenBaseCommentPanelPart.enableSlide(true);
            QFSFullScreenBaseCommentPanelPart.this.registerUiDisplayListener();
            if (PreLoader.exists(QFSFullScreenBaseCommentPanelPart.this.getCommentDataPreloadId())) {
                PreLoader.addListener(QFSFullScreenBaseCommentPanelPart.this.getCommentDataPreloadId(), new a());
                PreLoader.remove(QFSFullScreenBaseCommentPanelPart.this.getCommentDataPreloadId());
            }
        }

        @Override // com.tencent.mobileqq.widget.qus.a, com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.p
        public void onShowTotalStart() {
            String str;
            AbstractGifImage.resumeAll();
            QFSFullScreenBaseCommentPanelPart.this.f82770d.setVisibility(0);
            QCircleReportHelper.getInstance().recordPageStartShow(61);
            FeedCloudMeta$StFeed feedData = QFSFullScreenBaseCommentPanelPart.this.getFeedData();
            if (feedData == null) {
                str = null;
            } else {
                str = feedData.f398449id.get();
            }
            QCirclePanelStateEvent qCirclePanelStateEvent = new QCirclePanelStateEvent(0, str, true);
            if (QFSFullScreenBaseCommentPanelPart.this.getContext() != null) {
                com.tencent.biz.qqcircle.helpers.i.f84624a.c(QFSFullScreenBaseCommentPanelPart.this.getContextHashcode(), 1);
            }
            qCirclePanelStateEvent.setArg(Boolean.valueOf(QFSFullScreenBaseCommentPanelPart.this.needResetBlockWhenShowPanel()));
            SimpleEventBus.getInstance().dispatchEvent(qCirclePanelStateEvent);
            com.tencent.biz.qqcircle.immersive.utils.ax.g(QFSFullScreenBaseCommentPanelPart.this.getContext(), false);
            QFSFullScreenBaseCommentPanelPart.this.reportCommentAction(76);
            SimpleEventBus.getInstance().dispatchEvent(new QFSEnableSlideRightActionEvent(false, QFSFullScreenBaseCommentPanelPart.this.getContext()));
            com.tencent.biz.qqcircle.immersive.utils.as.c(QCircleDaTongConstant.ElementId.EM_XSJ_CMTPANEL, QFSFullScreenBaseCommentPanelPart.this.getClass().getSimpleName());
            QFSFullScreenBaseCommentPanelPart qFSFullScreenBaseCommentPanelPart = QFSFullScreenBaseCommentPanelPart.this;
            qFSFullScreenBaseCommentPanelPart.f82775f0 = com.tencent.biz.qqcircle.immersive.utils.r.p(qFSFullScreenBaseCommentPanelPart.getContext());
            com.tencent.biz.qqcircle.immersive.utils.r.a1(QFSFullScreenBaseCommentPanelPart.this.getContext(), QFSQUIUtilsKt.d(QFSFullScreenBaseCommentPanelPart.this.getContext(), R.color.qui_common_bg_middle_light));
        }
    }

    /* loaded from: classes4.dex */
    class g implements RFWAsyncRichTextView.OnClickableImageSpanListener {
        g() {
        }

        @Override // com.tencent.richframework.text.rich.RFWAsyncRichTextView.OnClickableImageSpanListener
        public void onClick(int i3, String str) {
            com.tencent.biz.qqcircle.utils.an E = QFSCommentHelper.L().E(QFSFullScreenBaseCommentPanelPart.this.getFeedData(), null, null);
            if (E != null && E.b() != null) {
                com.tencent.biz.qqcircle.utils.be b16 = E.b();
                if (TextUtils.equals(str, b16.c())) {
                    com.tencent.biz.qqcircle.helpers.l.e().j(b16.a(), true);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class h extends QQPermission.BasePermissionsListener {
        h() {
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            QFSFullScreenBaseCommentPanelPart.this.showInputWindowWithPicPanel();
        }
    }

    public QFSFullScreenBaseCommentPanelPart() {
        super(new QFSCommentBlock(null));
        this.f82778h0 = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aa() {
        com.tencent.biz.qqcircle.adapter.r rVar = this.f82768b0;
        if (rVar == null) {
            QLog.e(getTAG(), 1, "[adjustCommentBottomWidgetHeight] mBottomBlock == null");
        } else {
            rVar.j0(getBlockContainerHeight());
        }
    }

    private int ba() {
        View view = this.P;
        if (view != null && view.getVisibility() == 0) {
            return this.P.getMeasuredHeight();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean blockCanScrollDown() {
        QCircleBlockContainer qCircleBlockContainer = this.f82780m;
        if (qCircleBlockContainer != null && qCircleBlockContainer.getRecyclerView() != null) {
            return this.f82780m.getRecyclerView().canScrollVertically(-1);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ca() {
        int i3 = this.f82771d0;
        if (i3 != 0) {
            return i3;
        }
        int screenWidth = DisplayUtil.getScreenWidth();
        int screenHeight = DisplayUtil.getScreenHeight();
        if (!com.tencent.biz.qqcircle.utils.bz.r()) {
            screenWidth = Math.min(DisplayUtil.getScreenHeight(), DisplayUtil.getScreenWidth());
            screenHeight = Math.max(DisplayUtil.getScreenHeight(), DisplayUtil.getScreenWidth());
        }
        int i16 = (int) (screenWidth * 0.5625f);
        int ba5 = (screenHeight - i16) - ba();
        if (ba5 < i16) {
            ba5 = ((int) (com.tencent.biz.qqcircle.utils.cx.b(this.f82770d.getContext()) * 0.7d)) - ba();
        }
        this.f82771d0 = ba5;
        QLog.d("QFSFullScreenBaseCommentPanelPart", 1, "[getCommentPanelHeight] panelHeight: " + ba5 + ", topSpaceHeight: " + i16 + ", bottomBarHeight: " + ba() + ", screenHeight: " + DisplayUtil.getScreenHeight());
        return ba5;
    }

    private boolean canHandleTargetReplyItemTopAnimation(int i3) {
        if (i3 != 1002) {
            return true;
        }
        return false;
    }

    private boolean checkNeedAddOrRemoveTopFeedDesc() {
        if (hasTopFeedDesc() != needShowTopFeedDesc(getFeedData())) {
            return true;
        }
        return false;
    }

    private void dismissInputPopupWindow() {
        com.tencent.biz.qqcircle.comment.u K = QFSCommentHelper.L().K();
        if (K != null && K.isShowing()) {
            K.dismiss();
            this.f82776g0 = K.R4();
        }
    }

    private void dtReportBottomBarIcon(boolean z16, String str, Map<String, Object> map) {
        String str2;
        String str3;
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        if (map != null) {
            buildElementParams.putAll(map);
        }
        buildElementParams.put("xsj_custom_pgid", getDtPageId());
        if (getFeedData() == null) {
            str2 = "";
        } else {
            str2 = getFeedData().f398449id.get();
        }
        buildElementParams.put("xsj_feed_id", str2);
        buildElementParams.put("xsj_eid", str);
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_TYPE, "cmt");
        if (z16) {
            str3 = "ev_xsj_abnormal_clck";
        } else {
            str3 = "ev_xsj_abnormal_imp";
        }
        VideoReport.reportEvent(str3, buildElementParams);
    }

    private void dtReportPublishIcon(boolean z16) {
        String str;
        ViewGroup viewGroup = this.L;
        if (viewGroup != null && viewGroup.getVisibility() != 8) {
            HashMap hashMap = new HashMap();
            if (showPicEntranceRedPoint()) {
                hashMap.put("xsj_if_red_dot", 1);
            }
            if (showingBtnPublishAnim()) {
                hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_IF_DIFF, 1);
            }
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_UI_MODULE, com.tencent.biz.qqcircle.comment.af.v());
            if (getFeedData() != null && getFeedData().poster != null) {
                str = getFeedData().poster.f398463id.get();
            } else {
                str = "";
            }
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, str);
            dtReportBottomBarIcon(z16, QCircleDaTongConstant.ElementId.EM_XSJ_CMTBOX_VIDEO_ICON, hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getCommentDataPreloadId() {
        return "2004_" + getFeedData().f398449id.get();
    }

    private int getItemCount(@NonNull QFSCommentItemInfo qFSCommentItemInfo, String str) {
        if (RFSafeListUtils.isEmpty(qFSCommentItemInfo.replyItemList)) {
            return 1;
        }
        if (!TextUtils.isEmpty(str)) {
            for (int i3 = 0; i3 < qFSCommentItemInfo.replyItemList.size(); i3++) {
                FeedCloudMeta$StReply feedCloudMeta$StReply = qFSCommentItemInfo.replyItemList.get(i3).reply;
                if (feedCloudMeta$StReply != null && TextUtils.equals(feedCloudMeta$StReply.f398460id.get(), str)) {
                    return 1 + i3 + 1;
                }
            }
            return 1;
        }
        return 1 + qFSCommentItemInfo.replyItemList.size();
    }

    private void handleAtClick() {
        if (isFullScreenComment()) {
            QCircleToast.l(QCircleToast.f91644d, com.tencent.biz.qqcircle.utils.h.a(R.string.f1905442d), 0, true, false);
        } else if (!uq3.c.K()) {
            getMainHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.bizparts.QFSFullScreenBaseCommentPanelPart.7
                @Override // java.lang.Runnable
                public void run() {
                    QFSFullScreenBaseCommentPanelPart.this.showCommentInputWindow();
                }
            }, 50L);
            QFSCommentHelper.p0(getContext());
        } else {
            getMainHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.bizparts.QFSFullScreenBaseCommentPanelPart.8
                @Override // java.lang.Runnable
                public void run() {
                    QFSFullScreenBaseCommentPanelPart.this.showInputWindowWithAt();
                }
            }, 50L);
        }
    }

    private void handleCommentLocateEvent(QFSCommentLocateEvent qFSCommentLocateEvent) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        QLog.d("CommentPicTag", 1, "event: " + qFSCommentLocateEvent);
        QFSCommentInfo qFSCommentInfo = this.mInfo;
        if (qFSCommentInfo == null || (feedCloudMeta$StFeed = qFSCommentInfo.mFeed) == null || !TextUtils.equals(feedCloudMeta$StFeed.f398449id.get(), qFSCommentLocateEvent.getFeedId()) || this.f82768b0 == null || TextUtils.isEmpty(qFSCommentLocateEvent.getCommentId())) {
            return;
        }
        int tryGetCommentReplyPos = tryGetCommentReplyPos(qFSCommentLocateEvent.getCommentId(), qFSCommentLocateEvent.getReplyId());
        QLog.d("CommentPicTag", 1, "[locateRecyclerViewByPos] comment:" + tryGetCommentReplyPos + ", smoothScroll: " + qFSCommentLocateEvent.smoothScroll);
        if (tryGetCommentReplyPos == -1) {
            return;
        }
        if (qFSCommentLocateEvent.smoothScroll) {
            this.f82768b0.r0(tryGetCommentReplyPos);
        } else {
            this.f82768b0.q0(tryGetCommentReplyPos, false);
        }
    }

    private void handleCommentShow(String str, Object obj) {
        startInit();
        registerKeyboardEvent();
        if (obj instanceof QFSCommentInfo) {
            initCommentInfo((QFSCommentInfo) obj);
            initLabelIconAndInputView();
            setSendPreActionType(this.mInfo.mSendPreActionType);
            QFSCommentReportHelper.c(this.f82770d, this.mInfo);
            showCommentGoodsView();
            initAiCommentIconVisible();
            str.hashCode();
            boolean z16 = true;
            if (!str.equals("comment_input_window_show")) {
                if (str.equals("comment_panel_show")) {
                    if (com.tencent.biz.qqcircle.utils.cq.f92752a.r(getFeedData())) {
                        setCommentBottomBarVisibility(8);
                        this.f82770d.setVisibility(0);
                        updateListEmptyTextView(com.tencent.biz.qqcircle.utils.h.a(R.string.f188333we));
                        showCommentPanel();
                        QFSCommentReportHelper.m(this.f82770d);
                        this.U = System.currentTimeMillis();
                        return;
                    }
                    setCommentBottomBarVisibility(8);
                    tryResetBtnPublishAnim();
                    setPublishIconVisible();
                    tryResetBlockWhenShowPanel();
                    requestCommentList(false);
                    this.f82770d.setVisibility(0);
                    if (getCommentBlockMerger() != null) {
                        getCommentBlockMerger().resetTryToLoadMoreCount();
                    }
                    showCommentPanel();
                    QFSCommentReportHelper.m(this.f82770d);
                    tryShowLoadingAndTopFeedDesc();
                    if (MobileQQ.sProcessId == 1) {
                        if (this.f82767a0 == null) {
                            this.f82767a0 = new com.tencent.biz.qqcircle.comment.emoji.a() { // from class: com.tencent.biz.qqcircle.bizparts.be
                                @Override // com.tencent.biz.qqcircle.comment.emoji.a
                                public final void a(int i3) {
                                    QFSFullScreenBaseCommentPanelPart.lambda$handleCommentShow$2(i3);
                                }
                            };
                        }
                        com.tencent.biz.qqcircle.comment.emoji.e.f83623a.d(new WeakReference<>(this.f82767a0), false);
                    }
                    showEcommerceCardView();
                    showContainerMask(this.mInfo.mIsShowMask);
                    QFSCommentEffectUtil.n();
                    this.U = System.currentTimeMillis();
                    return;
                }
                return;
            }
            QFSCommentInputWindowConfig qFSCommentInputWindowConfig = this.mInfo.mInputWinConfig;
            if (qFSCommentInputWindowConfig == null) {
                qFSCommentInputWindowConfig = new QFSCommentInputWindowConfig();
            }
            qFSCommentInputWindowConfig.isFullScreen = isFullScreenComment();
            QFSCommentInfo qFSCommentInfo = this.mInfo;
            qFSCommentInputWindowConfig.isShowEmoji = qFSCommentInfo.mIsShowEmotion;
            qFSCommentInputWindowConfig.relocationType = qFSCommentInfo.mRelocationScrollType;
            qFSCommentInputWindowConfig.isAllowAiComment = qFSCommentInfo.mIsShowAiComment;
            QFSCommentInfo.ActionBean actionBean = qFSCommentInfo.mActionBean;
            if (actionBean == null || !actionBean.mNeedShowAt) {
                z16 = false;
            }
            qFSCommentInputWindowConfig.needShowAt = z16;
            showCommentInputWindow(qFSCommentInfo.mTargetComment, qFSCommentInfo.mTargetReply, qFSCommentInputWindowConfig);
        }
    }

    private void handleCommentTabSelectEvent(QFSCommentTabSelectEvent qFSCommentTabSelectEvent) {
        if (qFSCommentTabSelectEvent != null && qFSCommentTabSelectEvent.getCurTabIndex() == 0) {
            this.mNeedShowBubbleGuide = true;
            com.tencent.biz.qqcircle.comment.emoji.o oVar = this.Y;
            if (oVar != null) {
                oVar.a();
            }
        }
    }

    private void handleDoCommentPraise() {
        QFSCommentInfo.ActionBean actionBean;
        UIStateData<List<QFSCommentItemInfo>> value;
        QFSCommentInfo qFSCommentInfo = this.mInfo;
        if (qFSCommentInfo == null || (actionBean = qFSCommentInfo.mActionBean) == null || !actionBean.mNeedDoCommentPraise || (value = this.mCommentBlockViewModel.c2().getValue()) == null) {
            return;
        }
        List<QFSCommentItemInfo> data = value.getData();
        int i3 = 0;
        while (true) {
            if (i3 >= data.size()) {
                break;
            }
            QFSCommentItemInfo qFSCommentItemInfo = data.get(i3);
            if (TextUtils.equals(this.mInfo.mCommentId, qFSCommentItemInfo.comment.f398447id.get())) {
                qFSCommentItemInfo.mNeedDoCommentPraise = true;
                break;
            }
            i3++;
        }
        this.mInfo.mActionBean.mNeedDoCommentPraise = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleGetCommentListInternal(QCircleCommentUpdateEvent qCircleCommentUpdateEvent) {
        super.handleGetCommentList(qCircleCommentUpdateEvent);
        if (!qCircleCommentUpdateEvent.feedId.equals(getRealCellId())) {
            return;
        }
        tryShowBtnPublishAnim();
        showBubbleGuide();
        if (qCircleCommentUpdateEvent.needShowCommentPanel) {
            tryShowKeyboard();
        }
        handleItemTopAnimation();
        handleNoComment();
        handleDoCommentPraise();
        QFSCommentGuildCardWrapper qFSCommentGuildCardWrapper = this.f82769c0;
        if (qFSCommentGuildCardWrapper != null && qFSCommentGuildCardWrapper.M(qCircleCommentUpdateEvent, needShowEcommerceCardView())) {
            getMainHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.bizparts.QFSFullScreenBaseCommentPanelPart.10
                @Override // java.lang.Runnable
                public void run() {
                    QFSFullScreenBaseCommentPanelPart.this.aa();
                }
            });
        }
        dtReportPublishIcon(false);
        if (QCircleUserLabelConfig.INSTANCE.getIsEDaxia()) {
            initLabelIconAndInputView();
        }
    }

    private void handleItemTopAnimation() {
        QFSCommentInfo.ActionBean actionBean;
        QFSCommentInfo qFSCommentInfo = this.mInfo;
        if (qFSCommentInfo != null && (actionBean = qFSCommentInfo.mActionBean) != null && actionBean.mIsNeedShowTopAnim) {
            QCircleInitBean.QCircleActionBean qCircleActionBean = actionBean.mCommentInitBeanActionBean;
            QCircleExtraTypeInfo qCircleExtraTypeInfo = qFSCommentInfo.mExtraTypeInfo;
            handleItemTopAnimation(qCircleActionBean, qCircleExtraTypeInfo != null ? qCircleExtraTypeInfo.sourceType : 0);
        } else {
            QCircleInitBean initBean = getInitBean();
            if (initBean == null) {
                QLog.e(getTAG(), 1, "[handleItemTopAnimation] intBean == null");
            } else {
                handleItemTopAnimation(initBean.getActionBean(), initBean.getExtraTypeInfo().sourceType);
            }
        }
    }

    private void handleNoComment() {
        boolean z16;
        FrameLayout frameLayout;
        UIStateData<List<QFSCommentItemInfo>> value = this.mCommentBlockViewModel.c2().getValue();
        if (value != null && !RFSafeListUtils.isEmpty(value.getData())) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16 && needShowTopFeedDesc(getFeedData()) && (frameLayout = this.f82770d) != null) {
            frameLayout.post(new Runnable() { // from class: com.tencent.biz.qqcircle.bizparts.bf
                @Override // java.lang.Runnable
                public final void run() {
                    QFSFullScreenBaseCommentPanelPart.this.lambda$handleNoComment$4();
                }
            });
        } else {
            aa();
        }
    }

    private void handleResetCommentBlockEvent(QCircleResetCommentBlockEvent qCircleResetCommentBlockEvent) {
        this.V = true;
        if (this.f82768b0 != null && uq3.o.j() && !com.tencent.biz.qqcircle.helpers.i.f84624a.a(getContextHashcode())) {
            this.f82768b0.k0(qCircleResetCommentBlockEvent.feedId);
        }
    }

    private void handleSharePanelStateEvent(QCirclePanelStateEvent qCirclePanelStateEvent) {
        if (qCirclePanelStateEvent.getPanelType() != 1) {
            return;
        }
        enableSlide(!qCirclePanelStateEvent.isShowing());
    }

    private void handleTabStatusEvent(ASEngineTabStatusEvent aSEngineTabStatusEvent) {
        if (!ASEngineConstants.BusinessKey.BUSINESS_QCIRCLE.equals(aSEngineTabStatusEvent.getBusinessKey())) {
            return;
        }
        if (!aSEngineTabStatusEvent.isSelected()) {
            dismissCommentPanel();
        }
        if (!aSEngineTabStatusEvent.isSelected() && this.f82768b0 != null) {
            this.V = true;
            QLog.d("QFSFullScreenBaseCommentPanelPart", 1, "[handleTabStatusEvent] before: " + getCommentSize());
            this.f82768b0.k0("");
            QLog.d("QFSFullScreenBaseCommentPanelPart", 1, "[handleTabStatusEvent] after: " + getCommentSize());
        }
    }

    private void handleTargetReplyItemTopAnimation(List<QFSReplyItemInfo> list, String str) {
        FeedCloudMeta$StReply feedCloudMeta$StReply;
        for (QFSReplyItemInfo qFSReplyItemInfo : list) {
            if (qFSReplyItemInfo != null) {
                feedCloudMeta$StReply = qFSReplyItemInfo.reply;
            } else {
                feedCloudMeta$StReply = null;
            }
            if (feedCloudMeta$StReply != null && TextUtils.equals(str, feedCloudMeta$StReply.f398460id.get())) {
                qFSReplyItemInfo.mDefaultExpanded = true;
                qFSReplyItemInfo.mNeedTopAnimation = true;
                return;
            }
        }
    }

    private boolean hasTopFeedDesc() {
        return Boolean.TRUE.equals(this.mCommentBlockViewModel.k2().getValue());
    }

    private void initAiCommentIconVisible() {
        if (this.N == null) {
            return;
        }
        int i3 = 0;
        if (isAllowAiComment()) {
            dtReportBottomBarIcon(false, QCircleDaTongConstant.ElementId.EM_XSJ_CMTBOX_AI_ICON, null);
        }
        ImageView imageView = this.N;
        if (!isAllowAiComment()) {
            i3 = 8;
        }
        imageView.setVisibility(i3);
    }

    private void initCommentGoodsView() {
        ViewStub viewStub = (ViewStub) getPartRootView().findViewById(R.id.f1204179h);
        if (viewStub == null) {
            return;
        }
        View inflate = viewStub.inflate();
        this.Q = inflate;
        if (inflate == null) {
            return;
        }
        int a16 = com.tencent.biz.qqcircle.utils.cx.a(8.0f);
        this.Q.setPadding(a16, a16, a16, a16);
        this.Q.findViewById(R.id.yns).setOnClickListener(this);
        this.Q.findViewById(R.id.yns).setBackground(com.tencent.biz.qqcircle.comment.af.j(R.color.qui_common_bg_middle_light, R.color.qui_common_text_secondary));
    }

    private void initHalfScreenView() {
        this.f82774f.q();
        this.f82774f.v(false);
        this.f82774f.r();
        this.f82774f.setIgnoreHorizontalMove(true);
        this.f82774f.i(new d());
        this.f82774f.setQUSDragFloatController(new e());
        this.f82774f.j(new f());
        this.f82774f.T(new QUSBaseHalfScreenFloatingView.l() { // from class: com.tencent.biz.qqcircle.bizparts.bg
            @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.l
            public final void onDismiss() {
                QFSFullScreenBaseCommentPanelPart.this.lambda$initHalfScreenView$1();
            }
        });
        if (this.f82774f.x() instanceof ViewGroup) {
            ((ViewGroup) this.f82774f.x()).setClipToPadding(false);
            ((ViewGroup) this.f82774f.x()).setClipChildren(false);
        }
        this.f82774f.setClipToPadding(false);
        this.f82774f.setClipChildren(false);
    }

    private void initLabelIconAndInputView() {
        FeedCloudMeta$StUser m3 = QCirclePluginGlobalInfo.m();
        initTextInputView();
        com.tencent.biz.qqcircle.utils.cm.d(getContext(), this.E, m3);
        com.tencent.biz.qqcircle.utils.cm.c(this.F, m3);
    }

    private boolean isNeedScrollFirst() {
        UIStateData<List<QFSCommentItemInfo>> value;
        boolean z16;
        QFSCommentInfo qFSCommentInfo = this.mInfo;
        if (qFSCommentInfo == null || qFSCommentInfo.mTargetComment == null || !qFSCommentInfo.mNeedLocateComment || (value = this.mCommentBlockViewModel.c2().getValue()) == null) {
            return false;
        }
        int w3 = com.tencent.biz.qqcircle.comment.af.w(value.getData(), this.mInfo.mTargetComment.f398447id.get());
        QFSCommentInfo qFSCommentInfo2 = this.mInfo;
        if (w3 == -1) {
            z16 = true;
        } else {
            z16 = false;
        }
        qFSCommentInfo2.mNeedLocateComment = z16;
        if (w3 == -1) {
            return false;
        }
        return true;
    }

    private boolean isTopViewShowing() {
        ViewGroup viewGroup;
        QFSCommentGuildCardWrapper qFSCommentGuildCardWrapper = this.f82769c0;
        if ((qFSCommentGuildCardWrapper != null && qFSCommentGuildCardWrapper.z()) || ((viewGroup = this.R) != null && viewGroup.getVisibility() == 0)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$handleCommentShow$2(int i3) {
        QLog.d("QFSFullScreenBaseCommentPanelPart", 1, "emoji count: " + i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleNoComment$4() {
        int n06 = this.f82768b0.n0();
        int a16 = com.tencent.biz.qqcircle.utils.cx.a(300.0f);
        int blockContainerHeight = getBlockContainerHeight();
        QLog.d("QFSFullScreenBaseCommentPanelPart", 1, "feedDescHeight: " + n06 + ", btnHeight: " + a16 + ", containerHeight: " + blockContainerHeight);
        int i3 = n06 + a16;
        if (i3 > blockContainerHeight) {
            this.f82768b0.j0(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initHalfScreenView$1() {
        boolean z16;
        boolean z17;
        String str;
        IQQGoodsViewModel iQQGoodsViewModel;
        if (this.f82774f == null) {
            return;
        }
        this.W = false;
        com.tencent.biz.qqcircle.immersive.utils.r.a1(getContext(), this.f82775f0);
        if ((this.f82774f.getTag() instanceof Boolean) && ((Boolean) this.f82774f.getTag()).booleanValue()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && com.tencent.biz.qqcircle.utils.bz.r()) {
            this.f82774f.L();
        }
        QLog.d("QFSFullScreenBaseCommentPanelPart", 1, "[onDismiss] isShowing:" + isShow());
        AbstractGifImage.pauseAll();
        com.tencent.biz.qqcircle.comment.emoji.e.f83623a.c();
        QCircleReportHelper qCircleReportHelper = QCircleReportHelper.getInstance();
        if ((getHostFragment() instanceof QCircleBaseFragment) && ((QCircleBaseFragment) getHostFragment()).isHaveInteractive()) {
            z17 = true;
        } else {
            z17 = false;
        }
        qCircleReportHelper.recordPageEndShow(61, z17);
        FeedCloudMeta$StFeed feedData = getFeedData();
        if (feedData == null) {
            str = null;
        } else {
            str = feedData.f398449id.get();
        }
        SimpleEventBus.getInstance().dispatchEvent(new QCirclePanelStateEvent(0, str, false));
        if (getContext() != null) {
            com.tencent.biz.qqcircle.helpers.i.f84624a.c(getContextHashcode(), 0);
        }
        com.tencent.biz.qqcircle.immersive.utils.ax.g(getContext(), true);
        this.f82770d.setVisibility(8);
        reportCommentAction(77);
        SimpleEventBus.getInstance().dispatchEvent(new QFSCommentCloseEvent(str));
        SimpleEventBus.getInstance().dispatchEvent(new QFSEnableSlideRightActionEvent(true, getContext()));
        QFSCommentReportHelper.A(this.f82770d, this.mInfo.mExtraTypeInfo, this.U, getPageId(), getParentPageId());
        if (this.R != null && (iQQGoodsViewModel = this.X) != null) {
            iQQGoodsViewModel.onWrapperViewDisappear();
        }
        com.tencent.biz.qqcircle.comment.effect.e eVar = this.Z;
        if (eVar != null) {
            eVar.c();
        }
        QFSCommentGuildCardWrapper qFSCommentGuildCardWrapper = this.f82769c0;
        if (qFSCommentGuildCardWrapper != null) {
            qFSCommentGuildCardWrapper.r();
        }
        com.tencent.biz.qqcircle.comment.emoji.o oVar = this.Y;
        if (oVar != null) {
            oVar.d();
        }
        stopBtnPublishAnim();
        com.tencent.biz.qqcircle.immersive.utils.as.b(QCircleDaTongConstant.ElementId.EM_XSJ_CMTPANEL, getClass().getSimpleName());
        com.tencent.biz.qqcircle.immersive.utils.as.c(getDtPageId(), getClass().getSimpleName());
        QFSHodorCollectManager.f84689a.b("qfs_comment_panel_end_business");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onClick$3(DialogInterface dialogInterface, int i3) {
        showInputWindowWithAiComment();
        uq3.k.a().j("sp_key_show_ai_comment_agreement_dialog", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onInitView$0(Boolean bool) {
        int i3;
        View view = this.I;
        if (view != null) {
            if (bool.booleanValue()) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            view.setVisibility(i3);
        }
    }

    private void locateRecyclerViewByPos(int i3, boolean z16) {
        com.tencent.biz.qqcircle.adapter.r rVar;
        if (i3 >= 0 && (rVar = this.f82768b0) != null) {
            rVar.q0(i3, z16);
        }
    }

    private boolean needShowEcommerceCardView() {
        return getFeedData().commentExtraInfo.displayShopEntrance.get();
    }

    private void openPicSelectPage() {
        dtReportPublishIcon(true);
        com.tencent.biz.qqcircle.comment.emoji.o.i(3);
        this.Y.a();
        com.tencent.biz.qqcircle.utils.z.b(getActivity(), 2, new h(), new BusinessConfig(QQPermissionConstants.Business.ID.QQ_QCIRCLE, QQPermissionConstants.Business.SCENE.QCIRCLE_SHARE_SAVE), QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE, QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE);
    }

    private void preInflateTabViews() {
        if (this.f82773e0) {
            return;
        }
        Context context = getContext();
        if (context == null) {
            QLog.e(getTAG(), 1, "[preInflateTabViews] context == null, direct return");
            return;
        }
        this.f82773e0 = true;
        if (!l30.a.a().b() || !((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_pre_inflate_comment_tab_views", true)) {
            return;
        }
        RFWLayoutPreLoaderFactory.getLayoutLoader(l30.a.a().c()).preloadView(context, R.layout.g8z, 1);
        QLog.d(getTAG(), 1, "[preInflateTabViews] done");
    }

    private void registerCommentPartIoc() {
        RFWIocAbilityProvider.g().registerIoc(getContainer(), this, r20.a.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registerUiDisplayListener() {
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_comment_load_more_report", true)) {
            return;
        }
        BlockContainer commentBlockContainer = getCommentBlockContainer();
        if (commentBlockContainer == null) {
            QLog.e(getTAG(), 1, "[registerUiDisplayListener] commentBlockContainer is null");
            return;
        }
        BlockMerger blockMerger = commentBlockContainer.getBlockMerger();
        QLog.d(getTAG(), 1, "[registerUiDisplayListener] blockMerger :" + blockMerger);
        if (blockMerger instanceof QCircleBlockMerger) {
            ((QCircleBlockMerger) blockMerger).l0(this.f82778h0);
        }
    }

    private boolean sameFeed() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.S;
        if (feedCloudMeta$StFeed != null && TextUtils.equals(feedCloudMeta$StFeed.f398449id.get(), getFeedData().f398449id.get())) {
            return true;
        }
        return false;
    }

    private void setCommentNumText(int i3) {
        com.tencent.biz.qqcircle.viewmodels.n nVar = this.mCommentBlockViewModel;
        if (nVar != null) {
            nVar.a2().setValue(Integer.valueOf(i3));
        }
    }

    private void setPublishIconVisible() {
        int i3;
        if (this.L != null && this.M != null) {
            if (isAllowCommentVideo()) {
                ViewGroup viewGroup = this.L;
                int i16 = 4;
                if (showingBtnPublishAnim()) {
                    i3 = 4;
                } else {
                    i3 = 0;
                }
                viewGroup.setVisibility(i3);
                ImageView imageView = this.M;
                if (!showingBtnPublishAnim()) {
                    i16 = 0;
                }
                imageView.setVisibility(i16);
                return;
            }
            this.L.setVisibility(8);
        }
    }

    private void showBubbleGuide() {
        if (!this.mNeedShowBubbleGuide) {
            return;
        }
        boolean z16 = false;
        this.mNeedShowBubbleGuide = false;
        com.tencent.biz.qqcircle.comment.emoji.o oVar = this.Y;
        if (isAllowCommentVideo() && !showingBtnPublishAnim()) {
            z16 = true;
        }
        oVar.g(z16);
    }

    private void showCommentGoodsView() {
        if (com.tencent.biz.qqcircle.helpers.l.e().h(getFeedData(), null, null)) {
            if (this.Q == null) {
                initCommentGoodsView();
            }
            View view = this.Q;
            if (view != null) {
                view.setVisibility(0);
                return;
            }
            return;
        }
        View view2 = this.Q;
        if (view2 != null) {
            view2.setVisibility(8);
        }
    }

    private void showContainerMask(boolean z16) {
        if (z16) {
            this.f82770d.setBackgroundColor(getContext().getResources().getColor(R.color.bd9));
        }
    }

    private void showEcommerceCardView() {
        ViewGroup viewGroup = this.R;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
        adjustCloseBtnSize(0);
        if (!needShowEcommerceCardView()) {
            this.X = null;
            return;
        }
        QLog.i("QFSFullScreenBaseCommentPanelPart", 1, "showEcommerceCardView  show");
        if (this.R == null) {
            this.R = (ViewGroup) ((ViewStub) getContainer().findViewById(R.id.upd)).inflate();
        }
        adjustCloseBtnSize(f82766j0);
        this.R.setVisibility(0);
        FrameLayout frameLayout = (FrameLayout) this.R.findViewById(R.id.lhw);
        IQQGoodsViewModel i3 = QFSEcommercePreloadManager.j().i(getContext(), getFeedData(), 4, getPageId());
        this.X = i3;
        if (i3 != null) {
            i3.setWrapperView(frameLayout, null);
            this.X.onWrapperViewAppear(false);
        }
    }

    private boolean showingBtnPublishAnim() {
        QFSPagAnimView qFSPagAnimView = this.K;
        if (qFSPagAnimView != null && qFSPagAnimView.getVisibility() == 8) {
            return false;
        }
        return true;
    }

    private void stopBtnPublishAnim() {
        if (this.K != null && showingBtnPublishAnim()) {
            this.K.setStaticImageMode(true);
            this.K.L();
        }
    }

    private int tryGetCommentReplyPos(String str, String str2) {
        UIStateData<List<QFSCommentItemInfo>> value;
        int itemCount;
        com.tencent.biz.qqcircle.viewmodels.n nVar = this.mCommentBlockViewModel;
        int i3 = -1;
        if (nVar == null || (value = nVar.c2().getValue()) == null || RFSafeListUtils.isEmpty(value.getData())) {
            return -1;
        }
        List<QFSCommentItemInfo> data = value.getData();
        for (int i16 = 0; i16 < data.size(); i16++) {
            QFSCommentItemInfo qFSCommentItemInfo = data.get(i16);
            if (TextUtils.equals(str, qFSCommentItemInfo.comment.f398447id.get())) {
                if (TextUtils.isEmpty(str2)) {
                    itemCount = 1;
                } else {
                    itemCount = getItemCount(qFSCommentItemInfo, str2);
                }
                return i3 + itemCount;
            }
            i3 += getItemCount(qFSCommentItemInfo, "");
        }
        return i3;
    }

    private void tryResetBlockWhenShowPanel() {
        boolean z16;
        QFSCommentInfo qFSCommentInfo = this.mInfo;
        if (qFSCommentInfo != null && qFSCommentInfo.mRelocationScrollType == 104) {
            this.f82768b0.q0(0, false);
            this.f82780m.getRecyclerView().scrollToPosition(0);
        }
        if (needResetBlockWhenShowPanel()) {
            this.f82768b0.q0(0, false);
            this.f82780m.getRecyclerView().scrollToPosition(0);
            this.mCommentBlockViewModel.p2();
            setCommentNumText(getFeedData().commentCount.get());
            QFSCommentHelper.L().s();
        }
        QFSCommentGuildCardWrapper qFSCommentGuildCardWrapper = this.f82769c0;
        if (!this.V && sameFeed()) {
            z16 = false;
        } else {
            z16 = true;
        }
        qFSCommentGuildCardWrapper.F(z16, this.mInfo);
        this.f82769c0.I(getDtPageId(), getPageId());
        if (!com.tencent.biz.qqcircle.comment.af.q()) {
            this.V = false;
        }
        this.S = getFeedData();
    }

    private void tryResetBtnPublishAnim() {
        QFSPagAnimView qFSPagAnimView = this.K;
        if (qFSPagAnimView != null && this.V) {
            qFSPagAnimView.V();
            this.K.setStaticImageMode(false);
            if (showingBtnPublishAnim()) {
                this.M.setVisibility(0);
                this.K.setVisibility(8);
            }
        }
    }

    private void tryShowBtnPublishAnim() {
        if (!showingBtnPublishAnim() && isAllowCommentVideo() && !QQTheme.isCustomTheme("", false)) {
            String B = com.tencent.biz.qqcircle.comment.h.G().B(getRealCellId());
            if (TextUtils.isEmpty(B)) {
                return;
            }
            this.K.setVisibility(4);
            this.K.setPagAnimListener(new a());
            this.K.setRepeatTimes(1);
            this.K.M(B);
        }
    }

    private void tryShowKeyboard() {
        QQCircleFeedBase$StBusiInfoCommentListData busiInfo;
        QCircleInitBean initBean = getInitBean();
        if (initBean != null && initBean.getActionBean() != null && initBean.getActionBean().mShowInputKeyboard && !this.T && (busiInfo = getBusiInfo()) != null && showInputWindowFromReply(busiInfo.comment, busiInfo.reply)) {
            this.T = true;
        }
    }

    private void tryShowLoadingAndTopFeedDesc() {
        if (getCommentSize() > 0) {
            return;
        }
        setCommentNumText(getFeedData().commentCount.get());
        setLoadingStatus(true);
        if (needShowTopFeedDesc(getFeedData())) {
            this.f82780m.setVisibility(0);
            this.mCommentBlockViewModel.b2().setValue(getFeedData());
            showTopFeedDesc();
            return;
        }
        removeTopFeedDesc();
    }

    protected void adjustCloseBtnSize(int i3) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.G.getLayoutParams();
        layoutParams.topMargin = i3;
        this.G.setLayoutParams(layoutParams);
    }

    protected void dismissCommentPanel() {
        FrameLayout frameLayout = this.f82770d;
        if (frameLayout != null && this.f82774f != null && frameLayout.getVisibility() == 0) {
            this.f82774f.t();
        }
        w20.a.j().a();
        uq3.k.b().m("sp_key_emoji_last_selected_emoji_tab", 7);
    }

    @Override // com.tencent.biz.qqcircle.bizparts.ag
    protected boolean enableLoadMore() {
        return false;
    }

    @Override // com.tencent.biz.qqcircle.bizparts.ag
    protected void enableSlide(boolean z16) {
        QFSHalfScreenFloatingView qFSHalfScreenFloatingView = this.f82774f;
        if (qFSHalfScreenFloatingView == null) {
            return;
        }
        qFSHalfScreenFloatingView.setDraggable(z16);
        this.f82774f.setCanSlide(z16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.bizparts.ag
    public QCircleBlockContainer getBlockContainer() {
        return this.f82780m;
    }

    public int getBlockContainerHeight() {
        int i3 = 0;
        if (getBlockContainer() == null || getBlockContainer().getRecyclerView() == null) {
            return 0;
        }
        int height = getBlockContainer().getRecyclerView().getHeight();
        if (height < ca() && uq3.c.q0()) {
            if (isTopViewShowing()) {
                i3 = this.f82772e.getMeasuredHeight();
            }
            QLog.d("QFSFullScreenBaseCommentPanelPart", 1, "[getBlockContainerHeight] containerH: " + height + "panelHeight: " + ca() + "topViewHeight: " + i3);
            return ca() - i3;
        }
        return height;
    }

    @Override // r20.a
    public QFSCommentBlock getCmtBlock() {
        return super.getCommentBlock();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.bizparts.ag
    public BlockContainer getCommentBlockContainer() {
        com.tencent.biz.qqcircle.adapter.r rVar = this.f82768b0;
        if (rVar == null) {
            return super.getCommentBlockContainer();
        }
        return rVar.m0();
    }

    @Override // com.tencent.biz.qqcircle.bizparts.ag
    protected View getCommentBottomBar() {
        return this.P;
    }

    @Override // r20.a
    public QFSCommentInfo getCommentInfo() {
        return this.mInfo;
    }

    @Override // r20.a
    public IPartHost getCommentPartHost() {
        return getPartHost();
    }

    @Override // com.tencent.biz.qqcircle.bizparts.ag
    protected View getContainer() {
        return this.f82770d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getContextHashcode() {
        if (getContext() != null) {
            return String.valueOf(getContext().hashCode());
        }
        return "";
    }

    @Override // com.tencent.biz.qqcircle.bizparts.ag, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> eventClass = super.getEventClass();
        if (eventClass == null) {
            eventClass = new ArrayList<>();
        }
        eventClass.add(QCircleResetCommentBlockEvent.class);
        eventClass.add(QFSGoodsUpdateEvent.class);
        eventClass.add(ASEngineTabStatusEvent.class);
        eventClass.add(QFSCommentLocateEvent.class);
        eventClass.add(QFSCommentTabSelectEvent.class);
        eventClass.add(QCirclePanelStateEvent.class);
        eventClass.add(QFSCommentOpenPicPanel.class);
        return eventClass;
    }

    public Map<String, Object> getFooterDynamicParams() {
        UIStateData<List<FeedCloudMeta$StComment>> value;
        int i3;
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_WEAK_NETWORK_FLAG, Integer.valueOf(QCircleNetWorkTestHelper.f92533b.get() ? 1 : 0));
        Pair<Double, Double> speedAndSucceedRate = VSNetworkSpeedHelper.getNetworkSpeedTest().getSpeedAndSucceedRate();
        if (speedAndSucceedRate != null) {
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AVG_CMD_COST, speedAndSucceedRate.first);
        }
        com.tencent.biz.qqcircle.viewmodels.n nVar = this.mCommentBlockViewModel;
        if (nVar != null) {
            MutableLiveData<Boolean> g26 = nVar.g2();
            if (g26 != null && g26.getValue() != null) {
                if (g26.getValue().booleanValue()) {
                    i3 = 2;
                } else {
                    i3 = 1;
                }
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_FOOTER_STATUS, Integer.valueOf(i3));
            }
            if (this.mCommentBlockViewModel.e2() != null && (value = this.mCommentBlockViewModel.e2().getValue()) != null && value.getData() != null) {
                buildElementParams.put("xsj_index", Integer.valueOf(value.getData().size()));
            }
        }
        return buildElementParams;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public int getInitRelyViewStubId() {
        return R.id.u29;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSFullScreenBaseCommentPanelPart";
    }

    @Override // com.tencent.biz.qqcircle.bizparts.ag
    protected QCircleAsyncTextView getTextInputView() {
        return this.D;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String str, Object obj) {
        str.hashCode();
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case -775642345:
                if (str.equals("comment_input_window_show")) {
                    c16 = 0;
                    break;
                }
                break;
            case -700087299:
                if (str.equals("tab_changed_new_layer")) {
                    c16 = 1;
                    break;
                }
                break;
            case -282709448:
                if (str.equals("comment_panel_show")) {
                    c16 = 2;
                    break;
                }
                break;
            case -161821329:
                if (str.equals("comment_panel_dismiss")) {
                    c16 = 3;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
            case 2:
                handleCommentShow(str, obj);
                return;
            case 1:
            case 3:
                dismissCommentPanel();
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.bizparts.ag
    public com.tencent.biz.qqcircle.comment.effect.d handleCommentOrReplyAdded(FeedCloudMeta$StComment feedCloudMeta$StComment, FeedCloudMeta$StReply feedCloudMeta$StReply, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        super.handleCommentOrReplyAdded(feedCloudMeta$StComment, feedCloudMeta$StReply, feedCloudMeta$StFeed);
        if (this.Z == null) {
            this.Z = new com.tencent.biz.qqcircle.comment.effect.e();
        }
        return this.Z.b(this.f82770d, this.C, feedCloudMeta$StComment, feedCloudMeta$StReply, feedCloudMeta$StFeed);
    }

    protected void handleConfigChange() {
        QFSHalfScreenFloatingView qFSHalfScreenFloatingView = this.f82774f;
        if (qFSHalfScreenFloatingView == null) {
            return;
        }
        this.f82771d0 = 0;
        qFSHalfScreenFloatingView.setTag(Boolean.valueOf(QCirclePanelStateEvent.isSpecifiedPanelShowing(0)));
        dismissCommentPanel();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.bizparts.ag
    public void handleGetCommentList(QCircleCommentUpdateEvent qCircleCommentUpdateEvent) {
        if (!qCircleCommentUpdateEvent.feedId.equals(getRealCellId())) {
            return;
        }
        if (com.tencent.biz.qqcircle.comment.af.q()) {
            this.V = false;
        }
        if (this.W) {
            handleGetCommentListInternal(qCircleCommentUpdateEvent);
        } else {
            PreLoader.preLoad(getCommentDataPreloadId(), new com.tencent.biz.qqcircle.preload.task.a(qCircleCommentUpdateEvent));
        }
    }

    @Override // r20.a
    public boolean hasReceiveNeedResetBlockEvent() {
        return this.V;
    }

    @Override // com.tencent.biz.qqcircle.bizparts.ag
    public void initCommentInfo(@NonNull QFSCommentInfo qFSCommentInfo) {
        super.initCommentInfo(qFSCommentInfo);
        com.tencent.biz.qqcircle.adapter.r rVar = this.f82768b0;
        if (rVar != null) {
            rVar.s0(this.mInfo);
        }
        com.tencent.biz.qqcircle.viewmodels.n nVar = this.mCommentBlockViewModel;
        if (nVar != null) {
            nVar.n2(getFeedData().f398449id.get());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.bizparts.ag
    public void initListener() {
        super.initListener();
        this.H.setOnClickListener(this);
        this.J.setOnClickListener(this);
        this.M.setOnClickListener(this);
        this.K.setOnClickListener(this);
        this.N.setOnClickListener(this);
        this.D.seOnClickableImageSpanListener(new g());
    }

    protected void initSlideView() {
        FrameLayout frameLayout = this.f82770d;
        if (frameLayout == null) {
            return;
        }
        this.f82774f = (QFSHalfScreenFloatingView) frameLayout.findViewById(R.id.f356412e);
        initHalfScreenView();
    }

    @Override // com.tencent.biz.qqcircle.bizparts.ag
    public void initView() {
        View partRootView = getPartRootView();
        if (partRootView == null) {
            return;
        }
        FrameLayout frameLayout = (FrameLayout) partRootView.findViewById(R.id.u28);
        this.f82770d = frameLayout;
        frameLayout.setVisibility(8);
        initSlideView();
        this.f82772e = (FrameLayout) this.f82770d.findViewById(R.id.v8w);
        this.f82780m = (QCircleBlockContainer) this.f82770d.findViewById(R.id.f30820pd);
        RelativeLayout relativeLayout = (RelativeLayout) this.f82770d.findViewById(R.id.f30800pb);
        this.C = relativeLayout;
        relativeLayout.setOutlineProvider(new c());
        this.C.setClipToOutline(true);
        ImageView imageView = (ImageView) this.f82770d.findViewById(R.id.y3a);
        this.G = imageView;
        imageView.setOnClickListener(this);
        View findViewById = this.f82770d.findViewById(R.id.u1e);
        this.P = findViewById;
        com.tencent.mobileqq.qui.b.f276860a.a(findViewById, RFWNavigationBarImmersiveHelper.ImmersiveType.IMMERSIVE);
        this.D = (QCircleAsyncTextView) this.f82770d.findViewById(R.id.jha);
        this.E = (ImageView) this.f82770d.findViewById(R.id.yce);
        ImageView imageView2 = (ImageView) this.f82770d.findViewById(R.id.f3702165);
        this.F = imageView2;
        imageView2.setOnClickListener(this);
        this.H = (ImageView) this.f82770d.findViewById(R.id.ah5);
        this.I = this.f82770d.findViewById(R.id.teg);
        this.J = (ImageView) this.f82770d.findViewById(R.id.tfi);
        this.K = (QFSPagAnimView) this.f82770d.findViewById(R.id.f164676tg0);
        this.L = (ViewGroup) this.f82770d.findViewById(R.id.f164677tg1);
        this.M = (ImageView) this.f82770d.findViewById(R.id.tfz);
        this.N = (ImageView) this.f82770d.findViewById(R.id.tcm);
        this.Y = new com.tencent.biz.qqcircle.comment.emoji.o(this.f82770d);
        super.initView();
    }

    public boolean isShow() {
        FrameLayout frameLayout = this.f82770d;
        if (frameLayout != null && frameLayout.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    @Override // r20.a
    public void loadMoreComments(LoadInfo loadInfo) {
        if (loadInfo != null && loadInfo.isLoadMoreState()) {
            requestCommentList(true);
        }
    }

    @Override // com.tencent.biz.qqcircle.bizparts.ag
    protected boolean needCloseContainerWhenSoftKeyboardClosed() {
        QFSHalfScreenFloatingView qFSHalfScreenFloatingView = this.f82774f;
        if (qFSHalfScreenFloatingView != null && qFSHalfScreenFloatingView.getVisibility() != 0) {
            return true;
        }
        return false;
    }

    public boolean needResetBlockWhenShowPanel() {
        boolean z16;
        if (!this.V && sameFeed()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16 && !checkNeedAddOrRemoveTopFeedDesc()) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        if (isShow()) {
            dismissCommentPanel();
            return true;
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.biz.qqcircle.bizparts.ag, android.view.View.OnClickListener
    public void onClick(View view) {
        String dtPageId;
        EventCollector.getInstance().onViewClickedBefore(view);
        super.onClick(view);
        int id5 = view.getId();
        if (id5 == R.id.y3a) {
            dismissCommentPanel();
        }
        if (!checkNotAllowComment()) {
            if (id5 == R.id.tfi) {
                handleAtClick();
            } else if (id5 == R.id.ah5) {
                this.mCommentBlockViewModel.m2();
                showInputWindowWithEmoji();
            } else if (id5 == R.id.yns) {
                com.tencent.biz.qqcircle.helpers.l.e().g(getFeedData());
            } else if (id5 != R.id.tfz && id5 != R.id.f164676tg0) {
                if (id5 == R.id.tcm) {
                    dtReportBottomBarIcon(true, QCircleDaTongConstant.ElementId.EM_XSJ_CMTBOX_AI_ICON, null);
                    if (!uq3.k.a().c("sp_key_show_ai_comment_agreement_dialog", false)) {
                        Context context = getContext();
                        DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: com.tencent.biz.qqcircle.bizparts.bc
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i3) {
                                QFSFullScreenBaseCommentPanelPart.this.lambda$onClick$3(dialogInterface, i3);
                            }
                        };
                        if (getReportBean() == null) {
                            dtPageId = "";
                        } else {
                            dtPageId = getReportBean().getDtPageId();
                        }
                        com.tencent.biz.qqcircle.comment.af.K(context, onClickListener, dtPageId);
                    } else {
                        showInputWindowWithAiComment();
                    }
                } else if (id5 == R.id.f3702165) {
                    com.tencent.biz.qqcircle.utils.cm.g(getContext(), this.f82780m);
                }
            } else {
                openPicSelectPage();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        handleConfigChange();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        initView();
        registerCommentPartIoc();
        this.f82769c0 = new QFSCommentGuildCardWrapper(getContainer());
        this.mCommentBlockViewModel.f2().observe(getPartHost().getLifecycleOwner(), new Observer() { // from class: com.tencent.biz.qqcircle.bizparts.bd
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSFullScreenBaseCommentPanelPart.this.lambda$onInitView$0((Boolean) obj);
            }
        });
    }

    @Override // com.tencent.biz.qqcircle.bizparts.ag, com.tencent.biz.qqcircle.widgets.comment.c
    public void onLongClick(View view, int i3, int i16, Object obj) {
        if (this.f82777h) {
            return;
        }
        super.onLongClick(view, i3, i16, obj);
    }

    @Override // com.tencent.biz.qqcircle.bizparts.ag, com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        preInflateTabViews();
    }

    @Override // com.tencent.biz.qqcircle.bizparts.ag, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        com.tencent.biz.qqcircle.helpers.i.f84624a.c(getContextHashcode(), 0);
        dismissCommentPanel();
        com.tencent.biz.qqcircle.immersive.utils.ax.h(getContext(), true);
    }

    @Override // com.tencent.biz.qqcircle.bizparts.ag, com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        com.tencent.biz.qqcircle.comment.emoji.o oVar;
        super.onPartResume(activity);
        QCirclePluginUtil.setIsECFloatWebViewOnShow(false);
        if (!com.tencent.biz.qqcircle.comment.emoji.o.c() && (oVar = this.Y) != null) {
            oVar.a();
        }
        if (this.f82776g0 != null) {
            uq3.k.b().r("sp_key_emoji_last_selected_emoji_tab");
            QFSCommentHelper.L().w0(this.f82776g0);
            this.f82776g0 = null;
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartStop(Activity activity) {
        super.onPartStop(activity);
        stopBtnPublishAnim();
        dismissInputPopupWindow();
    }

    @Override // com.tencent.biz.qqcircle.bizparts.ag, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        if (simpleBaseEvent instanceof QCircleResetCommentBlockEvent) {
            handleResetCommentBlockEvent((QCircleResetCommentBlockEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof QFSGoodsUpdateEvent) {
            showCommentGoodsView();
            return;
        }
        if (simpleBaseEvent instanceof ASEngineTabStatusEvent) {
            handleTabStatusEvent((ASEngineTabStatusEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof QFSCommentLocateEvent) {
            handleCommentLocateEvent((QFSCommentLocateEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof QFSCommentTabSelectEvent) {
            handleCommentTabSelectEvent((QFSCommentTabSelectEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof QCirclePanelStateEvent) {
            handleSharePanelStateEvent((QCirclePanelStateEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof QFSCommentOpenPicPanel) {
            QFSCommentOpenPicPanel qFSCommentOpenPicPanel = (QFSCommentOpenPicPanel) simpleBaseEvent;
            if (getPartHost() == null) {
                QLog.w("QFSFullScreenBaseCommentPanelPart", 1, "[openPicSelectPage] no partHost");
                return;
            }
            String str = getPartHost().hashCode() + "";
            QLog.d("QFSFullScreenBaseCommentPanelPart", 1, "[openPicSelectPage] target: " + qFSCommentOpenPicPanel.getTargetHashCode() + ", current: " + str);
            if (!TextUtils.equals(qFSCommentOpenPicPanel.getTargetHashCode(), str)) {
                QLog.d("QFSFullScreenBaseCommentPanelPart", 1, "[openPicSelectPage] not the same partHost");
            } else {
                openPicSelectPage();
            }
        }
    }

    @Override // com.tencent.biz.qqcircle.bizparts.ag
    protected ArrayList<MultiViewBlock> prepareAdapters() {
        if (this.f82768b0 == null) {
            com.tencent.biz.qqcircle.adapter.r rVar = new com.tencent.biz.qqcircle.adapter.r(null);
            this.f82768b0 = rVar;
            rVar.setReportBean(getReportBean());
        }
        ArrayList<MultiViewBlock> arrayList = new ArrayList<>();
        arrayList.add(this.f82768b0);
        return arrayList;
    }

    public void reportFooterAbnormalImp(View view) {
        Map<String, Object> footerDynamicParams = getFooterDynamicParams();
        footerDynamicParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_CMTPANEL_BLANK_TIP);
        VideoReport.reportEvent("ev_xsj_abnormal_imp", view, footerDynamicParams);
    }

    @Override // com.tencent.biz.qqcircle.bizparts.ag
    protected void scrollItemToVisibleAboveInputLayout(View view) {
        adjustKeyboardStateToView(view);
    }

    @Override // r20.a
    public void setCommentBottomBarVisibility(int i3) {
        View view = this.P;
        if (view == null) {
            return;
        }
        view.setVisibility(i3);
        this.P.post(new Runnable() { // from class: com.tencent.biz.qqcircle.bizparts.bh
            @Override // java.lang.Runnable
            public final void run() {
                QFSFullScreenBaseCommentPanelPart.this.aa();
            }
        });
    }

    @Override // com.tencent.biz.qqcircle.bizparts.ag
    protected void setLoadingStatus(boolean z16) {
        com.tencent.biz.qqcircle.viewmodels.n nVar = this.mCommentBlockViewModel;
        if (nVar != null) {
            nVar.Z1().setValue(Boolean.valueOf(z16));
        }
    }

    protected void showCommentPanel() {
        QFSHalfScreenFloatingView qFSHalfScreenFloatingView = this.f82774f;
        if (qFSHalfScreenFloatingView != null) {
            qFSHalfScreenFloatingView.P(0);
        }
        QFSHodorCollectManager.f84689a.b("qfs_comment_panel_begin_business");
    }

    @Override // com.tencent.biz.qqcircle.bizparts.ag
    protected boolean showPicEntranceRedPoint() {
        com.tencent.biz.qqcircle.comment.emoji.o oVar = this.Y;
        if (oVar != null && oVar.h()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.bizparts.ag
    public void updateCommentNum(int i3) {
        super.updateCommentNum(i3);
        setCommentNumText(i3);
    }

    @Override // com.tencent.biz.qqcircle.bizparts.ag
    protected void updateListEmptyTextView(String str) {
        com.tencent.biz.qqcircle.viewmodels.n nVar = this.mCommentBlockViewModel;
        if (nVar != null) {
            nVar.d2().setValue(str);
        }
        handleNoComment();
    }

    private void handleItemTopAnimation(QCircleInitBean.QCircleActionBean qCircleActionBean, int i3) {
        UIStateData<List<QFSCommentItemInfo>> value;
        if (qCircleActionBean == null || TextUtils.isEmpty(qCircleActionBean.mItemTopAnimationCommentId) || (value = this.mCommentBlockViewModel.c2().getValue()) == null) {
            return;
        }
        List<QFSCommentItemInfo> data = value.getData();
        boolean z16 = !TextUtils.isEmpty(qCircleActionBean.mItemTopAnimationReplyId);
        int i16 = 0;
        while (true) {
            if (i16 >= data.size()) {
                break;
            }
            QFSCommentItemInfo qFSCommentItemInfo = data.get(i16);
            if (!TextUtils.equals(qCircleActionBean.mItemTopAnimationCommentId, qFSCommentItemInfo.comment.f398447id.get())) {
                i16++;
            } else if (TextUtils.isEmpty(qCircleActionBean.mItemTopAnimationReplyId)) {
                qFSCommentItemInfo.mNeedTopAnimation = true;
                qFSCommentItemInfo.mDefaultExpanded = true;
                if (qCircleActionBean.mNeedCancelLikeToast && qFSCommentItemInfo.comment.likeInfo.count.get() <= 0) {
                    QCircleToast.o(com.tencent.biz.qqcircle.utils.h.a(R.string.f188833xr), 0);
                }
            } else {
                List<QFSReplyItemInfo> list = qFSCommentItemInfo.replyItemList;
                if (!RFSafeListUtils.isEmpty(list)) {
                    for (QFSReplyItemInfo qFSReplyItemInfo : list) {
                        FeedCloudMeta$StReply feedCloudMeta$StReply = qFSReplyItemInfo.reply;
                        if (feedCloudMeta$StReply != null && TextUtils.equals(qCircleActionBean.mItemTopAnimationReplyId, feedCloudMeta$StReply.f398460id.get())) {
                            qFSReplyItemInfo.mNeedTopAnimation = true;
                            qFSReplyItemInfo.mDefaultExpanded = true;
                            if (qCircleActionBean.mNeedCancelLikeToast && feedCloudMeta$StReply.likeInfo.count.get() <= 0) {
                                QCircleToast.o(com.tencent.biz.qqcircle.utils.h.a(R.string.f188833xr), 0);
                            }
                            if (!TextUtils.isEmpty(feedCloudMeta$StReply.targetReplyID.get()) && canHandleTargetReplyItemTopAnimation(i3)) {
                                handleTargetReplyItemTopAnimation(list, feedCloudMeta$StReply.targetReplyID.get());
                            }
                            z16 = false;
                        }
                    }
                }
            }
        }
        int w3 = com.tencent.biz.qqcircle.comment.af.w(data, qCircleActionBean.mItemTopAnimationCommentId);
        locateRecyclerViewByPos(w3, isNeedScrollFirst());
        if (z16) {
            QCircleToast.k(QCircleToast.f91644d, com.tencent.biz.qqcircle.utils.h.a(R.string.f194834cz), 0, false);
        } else if (w3 < 0) {
            QCircleToast.k(QCircleToast.f91644d, com.tencent.biz.qqcircle.utils.h.a(R.string.f189053yc), 0, false);
        }
        qCircleActionBean.mItemTopAnimationCommentId = null;
        qCircleActionBean.mItemTopAnimationReplyId = null;
    }
}
