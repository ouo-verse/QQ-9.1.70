package com.tencent.biz.qqcircle.bizparts;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
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
import android.widget.TextView;
import android.widget.ViewFlipper;
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
import com.tencent.biz.qqcircle.beans.QFSFeedCommentInfo;
import com.tencent.biz.qqcircle.beans.QFSReplyItemInfo;
import com.tencent.biz.qqcircle.comment.QFSCommentReportHelper;
import com.tencent.biz.qqcircle.comment.effect.QFSCommentEffectUtil;
import com.tencent.biz.qqcircle.comment.recpic.QFSCommentRecPicClusterHelper;
import com.tencent.biz.qqcircle.comment.recpic.sorter.StrategyImage;
import com.tencent.biz.qqcircle.comment.wrapper.QFSCommentGuildCardWrapper;
import com.tencent.biz.qqcircle.events.QCircleCommentUpdateEvent;
import com.tencent.biz.qqcircle.events.QCirclePanelStateEvent;
import com.tencent.biz.qqcircle.events.QCircleResetCommentBlockEvent;
import com.tencent.biz.qqcircle.events.QFSCommentCloseEvent;
import com.tencent.biz.qqcircle.events.QFSCommentDoubleTapEvent;
import com.tencent.biz.qqcircle.events.QFSCommentLocateEvent;
import com.tencent.biz.qqcircle.events.QFSCommentTabSelectEvent;
import com.tencent.biz.qqcircle.events.QFSGoodsUpdateEvent;
import com.tencent.biz.qqcircle.events.QFSRecPicStateEvent;
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
import com.tencent.biz.qqcircle.utils.QFSCommentSheetView;
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
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.image.AbstractGifImage;
import com.tencent.libra.request.Option;
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
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.compat.immersive.RFWNavigationBarImmersiveHelper;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.text.rich.RFWAsyncRichTextView;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
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
public class QFSCommentPanelPart extends ag implements r20.a {
    private static final int DEFAULT_CLOSE_IV_TOP_MARGIN = 0;
    private static final int DELAY_SHOW_COMMENT_INPUT_WINDOW = 50;
    private static final int GOODS_VIEW_PADDING_DP = 8;
    private static final int RADIUS = com.tencent.biz.qqcircle.utils.cx.a(8.0f);
    private static final int SHOW_ECOMMERCE_CARD_CLOSE_IV_TOP_MARGIN = (RFWApplication.getApplication().getResources().getDimensionPixelSize(R.dimen.d0m) - RFWApplication.getApplication().getResources().getDimensionPixelSize(R.dimen.d0l)) / 2;
    private static final int STATUS_LOADING = 1;
    private static final int STATUS_NO_MORE = 2;
    private static final String TAG = "QFSCommentPanelPart";
    public static final String TAG_REC_PIC_SCENE = "RecPicSceneCommonTag";
    private View emotionRedPoint;
    private QFSCommentInputWindowConfig lastInputWindowConfig;
    private RelativeLayout mAniView;
    private QCircleBlockContainer mBlockContainer;
    private final QCircleBlockMerger.a mBlockUiDisplayListener;
    protected com.tencent.biz.qqcircle.adapter.r mBottomBlock;
    private View mBottomGuideContainer;
    private ImageView mBottomGuidePic;
    private ImageView mBottomGuideRedPoint;
    private TextView mBottomHintText;
    private ImageView mBtnAiComment;
    private ImageView mBtnEmotion;
    private ImageView mBtnMention;
    private ImageView mBtnPublish;
    private QFSPagAnimView mBtnPublishAnim;
    private ViewGroup mBtnPublishContainer;
    private View mCommentBottomBar;
    private FrameLayout mCommentContentView;
    private com.tencent.biz.qqcircle.comment.effect.e mCommentEffectController;
    private View mCommentGoodsView;
    private QFSCommentGuildCardWrapper mCommentGuildCardWrapper;
    private int mCommentPanelHeight;
    protected FrameLayout mContainer;
    private ImageView mEDaxiaIcon;
    private ViewGroup mEcommerceCardView;
    private IQQGoodsViewModel mEcommerceCardViewModel;
    private com.tencent.biz.qqcircle.comment.emoji.a mEmojiDataCallBack;
    private com.tencent.biz.qqcircle.comment.emoji.o mGuideBubbleManager;
    private QFSCommentSheetView mHalfScreenView;
    private boolean mHasPreInflateTabViews;
    private boolean mHasShowKeyboard;
    private ViewFlipper mInputTextViewFlipper;
    protected ImageView mIvFloatClose;
    private ImageView mLabelIcon;
    private FeedCloudMeta$StFeed mLastFeed;
    protected boolean mOnShowCompletely;
    private String mOutsideHintText;
    private long mPanelShowTime;
    private int mPreNavColor;
    private boolean mReceiveNeedResetBlockEvent;
    protected ImageView mSwitchBtn;
    private QCircleAsyncTextView mTextInput;
    private FrameLayout mTopView;
    private Drawable mZoomInDrawable;
    private Drawable mZoomOutDrawable;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.biz.qqcircle.bizparts.QFSCommentPanelPart$1 */
    /* loaded from: classes4.dex */
    public class AnonymousClass1 implements QCircleBlockMerger.a {
        AnonymousClass1() {
        }

        @Override // com.tencent.biz.qqcircle.fragments.QCircleBlockMerger.a
        public void onLoadMoreDisplay() {
            QFSCommentPanelPart qFSCommentPanelPart = QFSCommentPanelPart.this;
            qFSCommentPanelPart.reportFooterAbnormalImp(qFSCommentPanelPart.mBlockContainer);
        }
    }

    /* renamed from: com.tencent.biz.qqcircle.bizparts.QFSCommentPanelPart$10 */
    /* loaded from: classes4.dex */
    public class AnonymousClass10 implements QFSPagAnimView.c {
        AnonymousClass10() {
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSPagAnimView.c
        public /* bridge */ /* synthetic */ void onAnimationCancel(QFSPagAnimView qFSPagAnimView) {
            com.tencent.biz.qqcircle.widgets.bc.a(this, qFSPagAnimView);
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSPagAnimView.c
        public /* bridge */ /* synthetic */ void onAnimationEnd(QFSPagAnimView qFSPagAnimView) {
            com.tencent.biz.qqcircle.widgets.bc.b(this, qFSPagAnimView);
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSPagAnimView.c
        public /* bridge */ /* synthetic */ void onAnimationRepeat(QFSPagAnimView qFSPagAnimView) {
            com.tencent.biz.qqcircle.widgets.bc.c(this, qFSPagAnimView);
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSPagAnimView.c
        public /* bridge */ /* synthetic */ void onAnimationStart(QFSPagAnimView qFSPagAnimView) {
            com.tencent.biz.qqcircle.widgets.bc.d(this, qFSPagAnimView);
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSPagAnimView.c
        public void onAnimationUpdate(QFSPagAnimView qFSPagAnimView) {
            QLog.d(QFSCommentPanelPart.TAG, 1, "[tryShowBtnPublishAnim] show comment pic entrance pag anim. ");
            QFSCommentPanelPart.this.mBtnPublishAnim.setVisibility(0);
            QFSCommentPanelPart.this.mBtnPublish.setVisibility(8);
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSPagAnimView.c
        public /* bridge */ /* synthetic */ void onPagPlayError(QFSPagAnimView qFSPagAnimView, String str) {
            com.tencent.biz.qqcircle.widgets.bc.f(this, qFSPagAnimView, str);
        }
    }

    /* renamed from: com.tencent.biz.qqcircle.bizparts.QFSCommentPanelPart$2 */
    /* loaded from: classes4.dex */
    public class AnonymousClass2 extends ViewOutlineProvider {
        AnonymousClass2() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), QFSCommentPanelPart.RADIUS);
        }
    }

    /* renamed from: com.tencent.biz.qqcircle.bizparts.QFSCommentPanelPart$3 */
    /* loaded from: classes4.dex */
    public class AnonymousClass3 extends com.tencent.mobileqq.widget.qus.e {
        AnonymousClass3() {
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public boolean canScrollDown(float f16, float f17) {
            com.tencent.biz.qqcircle.adapter.r rVar = QFSCommentPanelPart.this.mBottomBlock;
            if (rVar == null) {
                return false;
            }
            if (!rVar.p0() && !QFSCommentPanelPart.this.blockCanScrollDown()) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public boolean canScrollUp(float f16, float f17) {
            com.tencent.biz.qqcircle.adapter.r rVar;
            QFSCommentPanelPart qFSCommentPanelPart = QFSCommentPanelPart.this;
            if (qFSCommentPanelPart.mOnShowCompletely && (rVar = qFSCommentPanelPart.mBottomBlock) != null && !rVar.o0()) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mobileqq.widget.qus.d
        @Nullable
        /* renamed from: createContentView */
        public View getF57419d() {
            QFSCommentPanelPart qFSCommentPanelPart = QFSCommentPanelPart.this;
            qFSCommentPanelPart.mCommentContentView = (FrameLayout) LayoutInflater.from(qFSCommentPanelPart.getContext()).inflate(R.layout.g9u, (ViewGroup) null, false);
            return QFSCommentPanelPart.this.mCommentContentView;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        /* renamed from: defaultHeight */
        public int getF57420e() {
            return QFSCommentPanelPart.this.getDefaultHeight();
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int initState() {
            return super.initState();
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int maxHeight() {
            return QFSCommentPanelPart.this.getMaxHeight();
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int showMode() {
            return 1;
        }
    }

    /* renamed from: com.tencent.biz.qqcircle.bizparts.QFSCommentPanelPart$4 */
    /* loaded from: classes4.dex */
    public class AnonymousClass4 implements QFSCommentSheetView.k {
        AnonymousClass4() {
        }

        @Override // com.tencent.biz.qqcircle.utils.QFSCommentSheetView.k
        public void onShowDefault() {
            QFSCommentPanelPart.this.showComplete();
        }

        @Override // com.tencent.biz.qqcircle.utils.QFSCommentSheetView.k
        public void onShowDefaultStart() {
            QFSCommentPanelPart.this.startShow();
            com.tencent.biz.qqcircle.helpers.i.f84624a.c(QFSCommentPanelPart.this.getContextHashcode(), 1);
        }

        @Override // com.tencent.biz.qqcircle.utils.QFSCommentSheetView.k
        public void onShowTotal() {
            QFSCommentPanelPart.this.showComplete();
        }

        @Override // com.tencent.biz.qqcircle.utils.QFSCommentSheetView.k
        public void onShowTotalStart() {
            QFSCommentPanelPart.this.startShow();
            com.tencent.biz.qqcircle.helpers.i.f84624a.c(QFSCommentPanelPart.this.getContextHashcode(), 2);
        }

        @Override // com.tencent.biz.qqcircle.utils.QFSCommentSheetView.k
        public void onStateChange(int i3) {
            boolean z16;
            QFSCommentPanelPart qFSCommentPanelPart = QFSCommentPanelPart.this;
            boolean z17 = false;
            if (i3 == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            qFSCommentPanelPart.adjustCommentBottomWidgetHeight(z16);
            QFSCommentPanelPart qFSCommentPanelPart2 = QFSCommentPanelPart.this;
            if (i3 == 1) {
                z17 = true;
            }
            qFSCommentPanelPart2.setSwitchState(z17);
            if (QFSCommentPanelPart.this.mBlockContainer != null) {
                VideoReport.traversePage(QFSCommentPanelPart.this.mBlockContainer.getRecyclerView());
            }
        }
    }

    /* renamed from: com.tencent.biz.qqcircle.bizparts.QFSCommentPanelPart$5 */
    /* loaded from: classes4.dex */
    public class AnonymousClass5 implements OnTaskListener<QCircleCommentUpdateEvent> {
        AnonymousClass5() {
        }

        @Override // com.tencent.mobileqq.engineering.preload.inter.OnTaskListener
        public void onComplete(QCircleCommentUpdateEvent... qCircleCommentUpdateEventArr) {
            if (qCircleCommentUpdateEventArr.length > 0) {
                QFSCommentPanelPart.this.handleGetCommentListInternal(qCircleCommentUpdateEventArr[0]);
            }
        }
    }

    /* renamed from: com.tencent.biz.qqcircle.bizparts.QFSCommentPanelPart$6 */
    /* loaded from: classes4.dex */
    class AnonymousClass6 implements RFWAsyncRichTextView.OnClickableImageSpanListener {
        AnonymousClass6() {
        }

        @Override // com.tencent.richframework.text.rich.RFWAsyncRichTextView.OnClickableImageSpanListener
        public void onClick(int i3, String str) {
            com.tencent.biz.qqcircle.utils.an E = QFSCommentHelper.L().E(QFSCommentPanelPart.this.getFeedData(), null, null);
            if (E != null && E.b() != null) {
                com.tencent.biz.qqcircle.utils.be b16 = E.b();
                if (TextUtils.equals(str, b16.c())) {
                    com.tencent.biz.qqcircle.helpers.l.e().j(b16.a(), true);
                }
            }
        }
    }

    /* renamed from: com.tencent.biz.qqcircle.bizparts.QFSCommentPanelPart$7 */
    /* loaded from: classes4.dex */
    public class AnonymousClass7 implements Runnable {
        AnonymousClass7() {
        }

        @Override // java.lang.Runnable
        public void run() {
            QFSCommentPanelPart.this.showCommentInputWindow();
        }
    }

    /* renamed from: com.tencent.biz.qqcircle.bizparts.QFSCommentPanelPart$8 */
    /* loaded from: classes4.dex */
    public class AnonymousClass8 implements Runnable {
        AnonymousClass8() {
        }

        @Override // java.lang.Runnable
        public void run() {
            QFSCommentPanelPart.this.showInputWindowWithAt();
        }
    }

    /* renamed from: com.tencent.biz.qqcircle.bizparts.QFSCommentPanelPart$9 */
    /* loaded from: classes4.dex */
    public class AnonymousClass9 extends QQPermission.BasePermissionsListener {
        AnonymousClass9() {
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            QFSCommentPanelPart.this.showInputWindowWithPicPanel();
        }
    }

    public QFSCommentPanelPart() {
        super(new QFSCommentBlock(null));
        this.mBlockUiDisplayListener = new QCircleBlockMerger.a() { // from class: com.tencent.biz.qqcircle.bizparts.QFSCommentPanelPart.1
            AnonymousClass1() {
            }

            @Override // com.tencent.biz.qqcircle.fragments.QCircleBlockMerger.a
            public void onLoadMoreDisplay() {
                QFSCommentPanelPart qFSCommentPanelPart = QFSCommentPanelPart.this;
                qFSCommentPanelPart.reportFooterAbnormalImp(qFSCommentPanelPart.mBlockContainer);
            }
        };
    }

    public void adjustCommentBottomWidgetHeight(boolean z16) {
        int maxHeight;
        if (this.mBottomBlock == null) {
            QLog.e(getTAG(), 1, "[adjustCommentBottomWidgetHeight] mBottomBlock == null");
            return;
        }
        if (z16) {
            maxHeight = getDefaultHeight();
        } else {
            maxHeight = getMaxHeight() - com.tencent.biz.qqcircle.utils.cx.h();
        }
        if (this.mBottomBlock.l0() != maxHeight) {
            QLog.d(TAG, 1, "[adjustCommentBottomWidgetHeight] adjustHeight: " + maxHeight);
            this.mBottomBlock.j0(maxHeight);
        }
    }

    public boolean blockCanScrollDown() {
        QCircleBlockContainer qCircleBlockContainer = this.mBlockContainer;
        if (qCircleBlockContainer != null && qCircleBlockContainer.getRecyclerView() != null) {
            return this.mBlockContainer.getRecyclerView().canScrollVertically(-1);
        }
        return false;
    }

    private boolean canHandleTargetReplyItemTopAnimation(int i3) {
        if (i3 != 1002) {
            return true;
        }
        return false;
    }

    private boolean canSwitchBottomTxt() {
        ImageView imageView = this.mBottomGuidePic;
        if (imageView != null && imageView.getVisibility() == 0) {
            return false;
        }
        String charSequence = getTextInputView().getHint().toString();
        String a16 = com.tencent.biz.qqcircle.utils.h.a(R.string.f181873ey);
        if (TextUtils.isEmpty(charSequence) || TextUtils.equals(charSequence, a16)) {
            return false;
        }
        return true;
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
            this.lastInputWindowConfig = K.R4();
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
        ViewGroup viewGroup = this.mBtnPublishContainer;
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

    private int getCommentBottomBarHeightUncaredVisible() {
        View view = this.mCommentBottomBar;
        if (view == null) {
            return 0;
        }
        if (view.getMeasuredHeight() != 0 && this.mCommentBottomBar.getMeasuredHeight() >= 0) {
            return this.mCommentBottomBar.getMeasuredHeight();
        }
        return (int) getActivity().getResources().getDimension(R.dimen.d0x);
    }

    private String getCommentDataPreloadId() {
        return "2004_" + getFeedData().f398449id.get();
    }

    public int getDefaultHeight() {
        int screenHeight;
        int screenWidth = DisplayUtil.getScreenWidth();
        QFSCommentSheetView qFSCommentSheetView = this.mHalfScreenView;
        if (qFSCommentSheetView != null) {
            screenHeight = qFSCommentSheetView.g();
        } else {
            screenHeight = DisplayUtil.getScreenHeight();
        }
        if (!com.tencent.biz.qqcircle.utils.bz.r()) {
            screenWidth = Math.min(screenHeight, DisplayUtil.getScreenWidth());
            screenHeight = Math.max(screenHeight, DisplayUtil.getScreenWidth());
        }
        int i3 = (int) (screenWidth * 0.5625f);
        int commentBottomBarHeightUncaredVisible = (screenHeight - i3) - getCommentBottomBarHeightUncaredVisible();
        if (commentBottomBarHeightUncaredVisible < i3) {
            commentBottomBarHeightUncaredVisible = ((int) (screenHeight * 0.7d)) - getCommentBottomBarHeightUncaredVisible();
        }
        if (commentBottomBarHeightUncaredVisible != this.mCommentPanelHeight) {
            QLog.d(TAG, 1, "[getDefaultHeight] panelHeight: " + commentBottomBarHeightUncaredVisible + ", topSpaceHeight: " + i3 + ", bottomBarHeight: " + getCommentBottomBarHeightUncaredVisible() + ", screenHeight: " + screenHeight);
        }
        this.mCommentPanelHeight = commentBottomBarHeightUncaredVisible;
        return commentBottomBarHeightUncaredVisible;
    }

    private String getFeedId() {
        if (getFeedData() == null) {
            return "";
        }
        return getFeedData().f398449id.get();
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

    public int getMaxHeight() {
        QFSCommentSheetView qFSCommentSheetView = this.mHalfScreenView;
        if (qFSCommentSheetView != null) {
            return qFSCommentSheetView.g();
        }
        return DisplayUtil.getScreenHeight();
    }

    private void handleAtClick() {
        if (isFullScreenComment()) {
            QCircleToast.l(QCircleToast.f91644d, com.tencent.biz.qqcircle.utils.h.a(R.string.f1905442d), 0, true, false);
        } else if (!uq3.c.K()) {
            getMainHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.bizparts.QFSCommentPanelPart.7
                AnonymousClass7() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    QFSCommentPanelPart.this.showCommentInputWindow();
                }
            }, 50L);
            QFSCommentHelper.p0(getContext());
        } else {
            getMainHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.bizparts.QFSCommentPanelPart.8
                AnonymousClass8() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    QFSCommentPanelPart.this.showInputWindowWithAt();
                }
            }, 50L);
        }
    }

    private void handleCommentDoubleTapEvent(QFSCommentDoubleTapEvent qFSCommentDoubleTapEvent) {
        if (getContext() != null && getContext().hashCode() == qFSCommentDoubleTapEvent.mHashCode) {
            com.tencent.biz.qqcircle.utils.am.f92635a.a(this.mContainer, (int) qFSCommentDoubleTapEvent.getX(), (int) qFSCommentDoubleTapEvent.getY(), qFSCommentDoubleTapEvent.getViewWrf());
        }
    }

    private void handleCommentLocateEvent(QFSCommentLocateEvent qFSCommentLocateEvent) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        QLog.d("CommentPicTag", 1, "event: " + qFSCommentLocateEvent);
        QFSCommentInfo qFSCommentInfo = this.mInfo;
        if (qFSCommentInfo == null || (feedCloudMeta$StFeed = qFSCommentInfo.mFeed) == null || !TextUtils.equals(feedCloudMeta$StFeed.f398449id.get(), qFSCommentLocateEvent.getFeedId()) || this.mBottomBlock == null || TextUtils.isEmpty(qFSCommentLocateEvent.getCommentId())) {
            return;
        }
        int tryGetCommentReplyPos = tryGetCommentReplyPos(qFSCommentLocateEvent.getCommentId(), qFSCommentLocateEvent.getReplyId());
        QLog.d("CommentPicTag", 1, "[locateRecyclerViewByPos] comment:" + tryGetCommentReplyPos + ", smoothScroll: " + qFSCommentLocateEvent.smoothScroll);
        if (tryGetCommentReplyPos == -1) {
            return;
        }
        if (qFSCommentLocateEvent.smoothScroll) {
            this.mBottomBlock.r0(tryGetCommentReplyPos);
        } else {
            this.mBottomBlock.q0(tryGetCommentReplyPos, false);
        }
    }

    private void handleCommentShow(String str, Object obj) {
        QFSHodorCollectManager.f84689a.a("qfs_comment_panel_cost");
        startInit();
        registerKeyboardEvent();
        if (obj instanceof QFSCommentInfo) {
            initCommentInfo((QFSCommentInfo) obj);
            QFSCommentInfo qFSCommentInfo = this.mInfo;
            if (qFSCommentInfo == null) {
                return;
            }
            this.mOutsideHintText = qFSCommentInfo.mHintText;
            initLabelIconAndInputView();
            setSendPreActionType(this.mInfo.mSendPreActionType);
            QFSCommentReportHelper.c(this.mContainer, this.mInfo);
            showCommentGoodsView();
            initAiCommentIconVisible();
            str.hashCode();
            boolean z16 = true;
            if (!str.equals("comment_input_window_show")) {
                if (str.equals("comment_panel_show")) {
                    if (com.tencent.biz.qqcircle.utils.cq.f92752a.r(getFeedData())) {
                        setCommentBottomBarVisibility(8);
                        this.mContainer.setVisibility(0);
                        updateListEmptyTextView(com.tencent.biz.qqcircle.utils.h.a(R.string.f188333we));
                        showCommentPanel();
                        QFSCommentReportHelper.m(this.mContainer);
                        this.mPanelShowTime = System.currentTimeMillis();
                        return;
                    }
                    setCommentBottomBarVisibility(8);
                    tryResetBtnPublishAnim();
                    setPublishIconVisible();
                    tryResetBlockWhenShowPanel();
                    requestCommentList(false);
                    this.mContainer.setVisibility(0);
                    if (getCommentBlockMerger() != null) {
                        getCommentBlockMerger().resetTryToLoadMoreCount();
                    }
                    showCommentPanel();
                    QFSCommentReportHelper.m(this.mContainer);
                    tryShowLoadingAndTopFeedDesc();
                    if (MobileQQ.sProcessId == 1) {
                        if (this.mEmojiDataCallBack == null) {
                            this.mEmojiDataCallBack = new com.tencent.biz.qqcircle.comment.emoji.a() { // from class: com.tencent.biz.qqcircle.bizparts.ap
                                @Override // com.tencent.biz.qqcircle.comment.emoji.a
                                public final void a(int i3) {
                                    QFSCommentPanelPart.lambda$handleCommentShow$2(i3);
                                }
                            };
                        }
                        com.tencent.biz.qqcircle.comment.emoji.e.f83623a.d(new WeakReference<>(this.mEmojiDataCallBack), false);
                    }
                    showEcommerceCardView();
                    showContainerMask(this.mInfo.mIsShowMask);
                    QFSCommentEffectUtil.n();
                    this.mPanelShowTime = System.currentTimeMillis();
                    return;
                }
                return;
            }
            QFSCommentInputWindowConfig qFSCommentInputWindowConfig = this.mInfo.mInputWinConfig;
            if (qFSCommentInputWindowConfig == null) {
                qFSCommentInputWindowConfig = new QFSCommentInputWindowConfig();
            }
            qFSCommentInputWindowConfig.isFullScreen = isFullScreenComment();
            QFSCommentInfo qFSCommentInfo2 = this.mInfo;
            qFSCommentInputWindowConfig.isShowEmoji = qFSCommentInfo2.mIsShowEmotion;
            qFSCommentInputWindowConfig.relocationType = qFSCommentInfo2.mRelocationScrollType;
            qFSCommentInputWindowConfig.isAllowAiComment = qFSCommentInfo2.mIsShowAiComment;
            QFSCommentInfo.ActionBean actionBean = qFSCommentInfo2.mActionBean;
            if (actionBean == null || !actionBean.mNeedShowAt) {
                z16 = false;
            }
            qFSCommentInputWindowConfig.needShowAt = z16;
            showCommentInputWindow(qFSCommentInfo2.mTargetComment, qFSCommentInfo2.mTargetReply, qFSCommentInputWindowConfig);
        }
    }

    private void handleCommentTabSelectEvent(QFSCommentTabSelectEvent qFSCommentTabSelectEvent) {
        if (qFSCommentTabSelectEvent != null && qFSCommentTabSelectEvent.getCurTabIndex() == 0) {
            this.mNeedShowBubbleGuide = true;
            com.tencent.biz.qqcircle.comment.emoji.o oVar = this.mGuideBubbleManager;
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
        if (this.mBottomBlock == null) {
            return;
        }
        UIStateData<List<QFSCommentItemInfo>> value = this.mCommentBlockViewModel.c2().getValue();
        if (value != null && !RFSafeListUtils.isEmpty(value.getData())) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16 && needShowTopFeedDesc(getFeedData()) && (frameLayout = this.mContainer) != null) {
            frameLayout.post(new Runnable() { // from class: com.tencent.biz.qqcircle.bizparts.aj
                @Override // java.lang.Runnable
                public final void run() {
                    QFSCommentPanelPart.this.lambda$handleNoComment$4();
                }
            });
        }
    }

    private void handleRecPicStateEvent(QFSRecPicStateEvent qFSRecPicStateEvent) {
        int state = qFSRecPicStateEvent.getState();
        if (state == 5) {
            if (com.tencent.biz.qqcircle.comment.recpic.aa.f83750a.h(getActivity())) {
                getMainHandler().postDelayed(new am(this), 250L);
            }
        } else {
            if (state != 2 || !this.mOnShowCompletely) {
                return;
            }
            if (hasNoCandidatePic() && this.mInputTextViewFlipper.getDisplayedChild() == 1) {
                showNext();
            } else if (com.tencent.biz.qqcircle.comment.recpic.aa.f83750a.j(getActivity())) {
                getMainHandler().postDelayed(new al(this), 250L);
            }
        }
    }

    private void handleResetCommentBlockEvent(QCircleResetCommentBlockEvent qCircleResetCommentBlockEvent) {
        this.mReceiveNeedResetBlockEvent = true;
        com.tencent.biz.qqcircle.comment.recpic.aa.f83750a.Q(null);
        if (this.mBottomBlock != null && uq3.o.j() && !com.tencent.biz.qqcircle.helpers.i.f84624a.a(getContextHashcode())) {
            this.mBottomBlock.k0(qCircleResetCommentBlockEvent.feedId);
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
            com.tencent.biz.qqcircle.comment.af.i();
        }
        if (!aSEngineTabStatusEvent.isSelected() && this.mBottomBlock != null) {
            this.mReceiveNeedResetBlockEvent = true;
            QLog.d(TAG, 1, "[handleTabStatusEvent] before: " + getCommentSize());
            this.mBottomBlock.k0("");
            QLog.d(TAG, 1, "[handleTabStatusEvent] after: " + getCommentSize());
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

    private boolean hasNoCandidatePic() {
        return !QFSCommentRecPicClusterHelper.f83716a.J(getFeedId());
    }

    private boolean hasTopFeedDesc() {
        return Boolean.TRUE.equals(this.mCommentBlockViewModel.k2().getValue());
    }

    private void hideEffectEntrance() {
        View findViewById;
        FrameLayout frameLayout = this.mContainer;
        if (frameLayout != null && (findViewById = frameLayout.findViewById(R.id.v7w)) != null && findViewById.getVisibility() == 0) {
            findViewById.setVisibility(8);
        }
    }

    private void initAiCommentIconVisible() {
        if (this.mBtnAiComment == null) {
            return;
        }
        int i3 = 0;
        if (isAllowAiComment()) {
            dtReportBottomBarIcon(false, QCircleDaTongConstant.ElementId.EM_XSJ_CMTBOX_AI_ICON, null);
        }
        ImageView imageView = this.mBtnAiComment;
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
        this.mCommentGoodsView = inflate;
        if (inflate == null) {
            return;
        }
        int a16 = com.tencent.biz.qqcircle.utils.cx.a(8.0f);
        this.mCommentGoodsView.setPadding(a16, a16, a16, a16);
        this.mCommentGoodsView.findViewById(R.id.yns).setOnClickListener(this);
        this.mCommentGoodsView.findViewById(R.id.yns).setBackground(com.tencent.biz.qqcircle.comment.af.j(R.color.qui_common_bg_middle_light, R.color.qui_common_text_secondary));
    }

    private void initHalfScreenView() {
        this.mHalfScreenView.i();
        this.mHalfScreenView.m(false);
        this.mHalfScreenView.j();
        this.mHalfScreenView.setIgnoreHorizontalMove(true);
        this.mHalfScreenView.setQUSDragFloatController(new com.tencent.mobileqq.widget.qus.e() { // from class: com.tencent.biz.qqcircle.bizparts.QFSCommentPanelPart.3
            AnonymousClass3() {
            }

            @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
            public boolean canScrollDown(float f16, float f17) {
                com.tencent.biz.qqcircle.adapter.r rVar = QFSCommentPanelPart.this.mBottomBlock;
                if (rVar == null) {
                    return false;
                }
                if (!rVar.p0() && !QFSCommentPanelPart.this.blockCanScrollDown()) {
                    return false;
                }
                return true;
            }

            @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
            public boolean canScrollUp(float f16, float f17) {
                com.tencent.biz.qqcircle.adapter.r rVar;
                QFSCommentPanelPart qFSCommentPanelPart = QFSCommentPanelPart.this;
                if (qFSCommentPanelPart.mOnShowCompletely && (rVar = qFSCommentPanelPart.mBottomBlock) != null && !rVar.o0()) {
                    return true;
                }
                return false;
            }

            @Override // com.tencent.mobileqq.widget.qus.d
            @Nullable
            /* renamed from: createContentView */
            public View getF57419d() {
                QFSCommentPanelPart qFSCommentPanelPart = QFSCommentPanelPart.this;
                qFSCommentPanelPart.mCommentContentView = (FrameLayout) LayoutInflater.from(qFSCommentPanelPart.getContext()).inflate(R.layout.g9u, (ViewGroup) null, false);
                return QFSCommentPanelPart.this.mCommentContentView;
            }

            @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
            /* renamed from: defaultHeight */
            public int getF57420e() {
                return QFSCommentPanelPart.this.getDefaultHeight();
            }

            @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
            public int initState() {
                return super.initState();
            }

            @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
            public int maxHeight() {
                return QFSCommentPanelPart.this.getMaxHeight();
            }

            @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
            public int showMode() {
                return 1;
            }
        });
        this.mHalfScreenView.d(new QFSCommentSheetView.k() { // from class: com.tencent.biz.qqcircle.bizparts.QFSCommentPanelPart.4
            AnonymousClass4() {
            }

            @Override // com.tencent.biz.qqcircle.utils.QFSCommentSheetView.k
            public void onShowDefault() {
                QFSCommentPanelPart.this.showComplete();
            }

            @Override // com.tencent.biz.qqcircle.utils.QFSCommentSheetView.k
            public void onShowDefaultStart() {
                QFSCommentPanelPart.this.startShow();
                com.tencent.biz.qqcircle.helpers.i.f84624a.c(QFSCommentPanelPart.this.getContextHashcode(), 1);
            }

            @Override // com.tencent.biz.qqcircle.utils.QFSCommentSheetView.k
            public void onShowTotal() {
                QFSCommentPanelPart.this.showComplete();
            }

            @Override // com.tencent.biz.qqcircle.utils.QFSCommentSheetView.k
            public void onShowTotalStart() {
                QFSCommentPanelPart.this.startShow();
                com.tencent.biz.qqcircle.helpers.i.f84624a.c(QFSCommentPanelPart.this.getContextHashcode(), 2);
            }

            @Override // com.tencent.biz.qqcircle.utils.QFSCommentSheetView.k
            public void onStateChange(int i3) {
                boolean z16;
                QFSCommentPanelPart qFSCommentPanelPart = QFSCommentPanelPart.this;
                boolean z17 = false;
                if (i3 == 1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                qFSCommentPanelPart.adjustCommentBottomWidgetHeight(z16);
                QFSCommentPanelPart qFSCommentPanelPart2 = QFSCommentPanelPart.this;
                if (i3 == 1) {
                    z17 = true;
                }
                qFSCommentPanelPart2.setSwitchState(z17);
                if (QFSCommentPanelPart.this.mBlockContainer != null) {
                    VideoReport.traversePage(QFSCommentPanelPart.this.mBlockContainer.getRecyclerView());
                }
            }
        });
        this.mHalfScreenView.c(new QFSCommentSheetView.i() { // from class: com.tencent.biz.qqcircle.bizparts.ao
            @Override // com.tencent.biz.qqcircle.utils.QFSCommentSheetView.i
            public final void onDismiss() {
                QFSCommentPanelPart.this.lambda$initHalfScreenView$1();
            }
        });
        if (this.mHalfScreenView.o() instanceof ViewGroup) {
            ((ViewGroup) this.mHalfScreenView.o()).setClipToPadding(false);
            ((ViewGroup) this.mHalfScreenView.o()).setClipChildren(false);
        }
        this.mHalfScreenView.setClipToPadding(false);
        this.mHalfScreenView.setClipChildren(false);
    }

    private void initLabelIconAndInputView() {
        FeedCloudMeta$StUser m3 = QCirclePluginGlobalInfo.m();
        initTextInputView();
        com.tencent.biz.qqcircle.utils.cm.d(getContext(), this.mLabelIcon, m3);
        com.tencent.biz.qqcircle.utils.cm.c(this.mEDaxiaIcon, m3);
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
        QFSCommentGuildCardWrapper qFSCommentGuildCardWrapper = this.mCommentGuildCardWrapper;
        if ((qFSCommentGuildCardWrapper != null && qFSCommentGuildCardWrapper.z()) || ((viewGroup = this.mEcommerceCardView) != null && viewGroup.getVisibility() == 0)) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ void lambda$handleCommentShow$2(int i3) {
        QLog.d(TAG, 1, "emoji count: " + i3);
    }

    public /* synthetic */ void lambda$handleNoComment$4() {
        int n06 = this.mBottomBlock.n0();
        int a16 = com.tencent.biz.qqcircle.utils.cx.a(300.0f);
        int blockContainerHeight = getBlockContainerHeight();
        QLog.d(TAG, 1, "feedDescHeight: " + n06 + ", btnHeight: " + a16 + ", containerHeight: " + blockContainerHeight);
        int i3 = n06 + a16;
        if (i3 > blockContainerHeight) {
            this.mBottomBlock.j0(i3);
        }
    }

    public /* synthetic */ void lambda$initHalfScreenView$1() {
        boolean z16;
        boolean z17;
        IQQGoodsViewModel iQQGoodsViewModel;
        if (this.mHalfScreenView == null) {
            return;
        }
        this.mOnShowCompletely = false;
        VideoReport.clearElementExposure(this.mSwitchBtn, false);
        adjustCommentBottomWidgetHeight(true);
        com.tencent.biz.qqcircle.immersive.utils.r.a1(getContext(), this.mPreNavColor);
        if ((this.mHalfScreenView.getTag() instanceof Boolean) && ((Boolean) this.mHalfScreenView.getTag()).booleanValue()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && com.tencent.biz.qqcircle.utils.bz.r()) {
            this.mHalfScreenView.D();
        }
        QLog.d(TAG, 1, "[onDismiss] isShowing:" + isShow());
        ViewFlipper viewFlipper = this.mInputTextViewFlipper;
        String str = null;
        if (viewFlipper != null) {
            viewFlipper.setOutAnimation(null);
            this.mInputTextViewFlipper.setInAnimation(null);
            resetBottomText();
        }
        ImageView imageView = this.mBottomGuidePic;
        if (imageView != null && this.mBottomGuideRedPoint != null) {
            imageView.setVisibility(8);
            this.mBottomGuideRedPoint.setVisibility(8);
        }
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
        if (feedData != null) {
            str = feedData.f398449id.get();
        }
        SimpleEventBus.getInstance().dispatchEvent(new QCirclePanelStateEvent(0, str, false));
        if (getContext() != null) {
            com.tencent.biz.qqcircle.helpers.i.f84624a.c(getContextHashcode(), 0);
        }
        com.tencent.biz.qqcircle.immersive.utils.ax.g(getContext(), true);
        this.mContainer.setVisibility(8);
        reportCommentAction(77);
        SimpleEventBus.getInstance().dispatchEvent(new QFSCommentCloseEvent(str));
        SimpleEventBus.getInstance().dispatchEvent(new QFSEnableSlideRightActionEvent(true, getContext()));
        QFSCommentReportHelper.A(this.mContainer, this.mInfo.mExtraTypeInfo, this.mPanelShowTime, getPageId(), getParentPageId());
        if (this.mEcommerceCardView != null && (iQQGoodsViewModel = this.mEcommerceCardViewModel) != null) {
            iQQGoodsViewModel.onWrapperViewDisappear();
        }
        com.tencent.biz.qqcircle.comment.effect.e eVar = this.mCommentEffectController;
        if (eVar != null) {
            eVar.c();
        }
        QFSCommentGuildCardWrapper qFSCommentGuildCardWrapper = this.mCommentGuildCardWrapper;
        if (qFSCommentGuildCardWrapper != null) {
            qFSCommentGuildCardWrapper.r();
        }
        com.tencent.biz.qqcircle.comment.emoji.o oVar = this.mGuideBubbleManager;
        if (oVar != null) {
            oVar.d();
        }
        stopBtnPublishAnim();
        com.tencent.biz.qqcircle.immersive.utils.as.b(QCircleDaTongConstant.ElementId.EM_XSJ_CMTPANEL, TAG);
        com.tencent.biz.qqcircle.immersive.utils.as.c(getDtPageId(), TAG);
        QFSHodorCollectManager.f84689a.b("qfs_comment_panel_end_business");
    }

    public /* synthetic */ void lambda$onClick$3(DialogInterface dialogInterface, int i3) {
        showInputWindowWithAiComment();
        uq3.k.a().j("sp_key_show_ai_comment_agreement_dialog", true);
    }

    public /* synthetic */ void lambda$onInitView$0(Boolean bool) {
        int i3;
        View view = this.emotionRedPoint;
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
        if (i3 >= 0 && (rVar = this.mBottomBlock) != null) {
            rVar.q0(i3, z16);
        }
    }

    private boolean needShowEcommerceCardView() {
        return getFeedData().commentExtraInfo.displayShopEntrance.get();
    }

    private void openPicSelectPage() {
        dtReportPublishIcon(true);
        com.tencent.biz.qqcircle.comment.emoji.o.i(3);
        this.mGuideBubbleManager.a();
        com.tencent.biz.qqcircle.utils.z.b(getActivity(), 2, new QQPermission.BasePermissionsListener() { // from class: com.tencent.biz.qqcircle.bizparts.QFSCommentPanelPart.9
            AnonymousClass9() {
            }

            @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
            public void onAllGranted() {
                super.onAllGranted();
                QFSCommentPanelPart.this.showInputWindowWithPicPanel();
            }
        }, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_QCIRCLE, QQPermissionConstants.Business.SCENE.QCIRCLE_SHARE_SAVE), QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE, QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE);
    }

    private void preInflateTabViews() {
        if (this.mHasPreInflateTabViews) {
            return;
        }
        Context context = getContext();
        if (context == null) {
            QLog.e(getTAG(), 1, "[preInflateTabViews] context == null, direct return");
            return;
        }
        this.mHasPreInflateTabViews = true;
        if (!l30.a.a().b() || !((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_pre_inflate_comment_tab_views", true)) {
            return;
        }
        RFWLayoutPreLoaderFactory.getLayoutLoader(l30.a.a().c()).preloadView(context, R.layout.g8z, 1);
        QLog.d(getTAG(), 1, "[preInflateTabViews] done");
    }

    private void registerCommentPartIoc() {
        RFWIocAbilityProvider.g().registerIoc(getContainer(), this, r20.a.class);
    }

    private void registerUiDisplayListener() {
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
            ((QCircleBlockMerger) blockMerger).l0(this.mBlockUiDisplayListener);
        }
    }

    private void resetBottomText() {
        ViewFlipper viewFlipper = this.mInputTextViewFlipper;
        if (viewFlipper == null) {
            return;
        }
        viewFlipper.setDisplayedChild(0);
    }

    private boolean sameFeed() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.mLastFeed;
        if (feedCloudMeta$StFeed != null && TextUtils.equals(feedCloudMeta$StFeed.f398449id.get(), getFeedData().f398449id.get())) {
            return true;
        }
        return false;
    }

    private void setCommentGoodsViewVisible(boolean z16) {
        int i3;
        View view = this.mCommentGoodsView;
        if (view != null) {
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            view.setVisibility(i3);
        }
    }

    private void setCommentNumText(int i3) {
        com.tencent.biz.qqcircle.viewmodels.n nVar = this.mCommentBlockViewModel;
        if (nVar != null) {
            nVar.a2().setValue(Integer.valueOf(i3));
        }
    }

    private void setPublishIconVisible() {
        int i3;
        if (this.mBtnPublishContainer != null && this.mBtnPublish != null) {
            if (isAllowCommentVideo()) {
                ViewGroup viewGroup = this.mBtnPublishContainer;
                int i16 = 4;
                if (showingBtnPublishAnim()) {
                    i3 = 4;
                } else {
                    i3 = 0;
                }
                viewGroup.setVisibility(i3);
                ImageView imageView = this.mBtnPublish;
                if (!showingBtnPublishAnim()) {
                    i16 = 0;
                }
                imageView.setVisibility(i16);
                return;
            }
            this.mBtnPublishContainer.setVisibility(8);
        }
    }

    public void setSwitchState(boolean z16) {
        Drawable drawable;
        ImageView imageView = this.mSwitchBtn;
        if (imageView == null) {
            return;
        }
        if (z16) {
            drawable = this.mZoomOutDrawable;
        } else {
            drawable = this.mZoomInDrawable;
        }
        imageView.setImageDrawable(drawable);
    }

    private void showBubbleGuide() {
        if (!this.mNeedShowBubbleGuide) {
            return;
        }
        boolean z16 = false;
        this.mNeedShowBubbleGuide = false;
        com.tencent.biz.qqcircle.comment.emoji.o oVar = this.mGuideBubbleManager;
        if (isAllowCommentVideo() && !showingBtnPublishAnim()) {
            z16 = true;
        }
        oVar.g(z16);
    }

    private void showCommentGoodsView() {
        if (com.tencent.biz.qqcircle.helpers.l.e().h(getFeedData(), null, null)) {
            if (this.mCommentGoodsView == null) {
                initCommentGoodsView();
            }
            setCommentGoodsViewVisible(true);
            return;
        }
        setCommentGoodsViewVisible(false);
    }

    public void showComplete() {
        if (this.mOnShowCompletely) {
            QLog.d(TAG, 1, "[onShowTotal] has show");
            return;
        }
        this.mOnShowCompletely = true;
        VideoReport.traversePage(this.mSwitchBtn);
        enableSlide(true);
        registerUiDisplayListener();
        if (PreLoader.exists(getCommentDataPreloadId())) {
            PreLoader.addListener(getCommentDataPreloadId(), new OnTaskListener<QCircleCommentUpdateEvent>() { // from class: com.tencent.biz.qqcircle.bizparts.QFSCommentPanelPart.5
                AnonymousClass5() {
                }

                @Override // com.tencent.mobileqq.engineering.preload.inter.OnTaskListener
                public void onComplete(QCircleCommentUpdateEvent... qCircleCommentUpdateEventArr) {
                    if (qCircleCommentUpdateEventArr.length > 0) {
                        QFSCommentPanelPart.this.handleGetCommentListInternal(qCircleCommentUpdateEventArr[0]);
                    }
                }
            });
            PreLoader.remove(getCommentDataPreloadId());
        }
        showVideoFrameIfNeed();
        QFSCommentRecPicClusterHelper.f83716a.g0(getFeedData());
        startAnalyseFeedDesc();
    }

    private void showContainerMask(boolean z16) {
        if (z16) {
            this.mContainer.setBackgroundColor(getContext().getResources().getColor(R.color.bd9));
        }
    }

    private void showEcommerceCardView() {
        ViewGroup viewGroup = this.mEcommerceCardView;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
        adjustCloseBtnSize(0);
        if (!needShowEcommerceCardView()) {
            this.mEcommerceCardViewModel = null;
            return;
        }
        QLog.i(TAG, 1, "showEcommerceCardView  show");
        if (this.mEcommerceCardView == null) {
            this.mEcommerceCardView = (ViewGroup) ((ViewStub) getContainer().findViewById(R.id.upd)).inflate();
        }
        adjustCloseBtnSize(SHOW_ECOMMERCE_CARD_CLOSE_IV_TOP_MARGIN);
        this.mEcommerceCardView.setVisibility(0);
        FrameLayout frameLayout = (FrameLayout) this.mEcommerceCardView.findViewById(R.id.lhw);
        IQQGoodsViewModel i3 = QFSEcommercePreloadManager.j().i(getContext(), getFeedData(), 4, getPageId());
        this.mEcommerceCardViewModel = i3;
        if (i3 != null) {
            i3.setWrapperView(frameLayout, null);
            this.mEcommerceCardViewModel.onWrapperViewAppear(false);
        }
    }

    private void showNext() {
        if (this.mInputTextViewFlipper == null) {
            return;
        }
        QLog.d(TAG, 1, "[showNext] show flipper");
        this.mInputTextViewFlipper.setInAnimation(getContext(), R.anim.f154904t9);
        this.mInputTextViewFlipper.setOutAnimation(getContext(), R.anim.f154905ta);
        this.mInputTextViewFlipper.showNext();
    }

    public void showPermissionBottomGuide() {
        int i3;
        if (this.mInputTextViewFlipper != null && this.mBottomGuideRedPoint != null && this.mBottomGuidePic != null) {
            com.tencent.biz.qqcircle.comment.recpic.aa aaVar = com.tencent.biz.qqcircle.comment.recpic.aa.f83750a;
            if (aaVar.r()) {
                QLog.d(TAG, 1, "[showPermissionBottomGuide] can not allow show guide");
                return;
            }
            if (!this.mOnShowCompletely || this.mInputTextViewFlipper.getDisplayedChild() == 1) {
                return;
            }
            ImageView imageView = this.mBottomGuideRedPoint;
            if (aaVar.i(getActivity())) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            imageView.setVisibility(i3);
            updateGuidePic();
            this.mBottomHintText.setText(com.tencent.biz.qqcircle.utils.h.a(R.string.f160831w3));
            showNext();
            aaVar.M();
            com.tencent.biz.qqcircle.comment.recpic.ak.f83788a.b(this.mBottomGuideContainer, getFeedData(), true);
        }
    }

    public void showRecBottomGuide() {
        if (this.mInputTextViewFlipper != null && this.mBottomGuideRedPoint != null && this.mBottomGuidePic != null && this.mBottomHintText != null) {
            com.tencent.biz.qqcircle.comment.recpic.aa aaVar = com.tencent.biz.qqcircle.comment.recpic.aa.f83750a;
            if (aaVar.r()) {
                QLog.d(TAG, 1, "[showRecBottomGuide] can not allow show guide");
                return;
            }
            if (!this.mOnShowCompletely) {
                QLog.d(TAG, 1, "[showRecBottomGuide] has not show panel");
                return;
            }
            if (hasNoCandidatePic() && this.mInputTextViewFlipper.getDisplayedChild() == 1) {
                showNext();
                return;
            }
            updateGuidePic();
            if (this.mInputTextViewFlipper.getDisplayedChild() == 1) {
                return;
            }
            this.mBottomHintText.setText(com.tencent.biz.qqcircle.utils.h.a(R.string.f181903f1));
            showNext();
            aaVar.N();
            com.tencent.biz.qqcircle.comment.recpic.ak.f83788a.b(this.mBottomGuideContainer, getFeedData(), true);
        }
    }

    private void showVideoFrameIfNeed() {
        if (!QFSCommentRecPicClusterHelper.f83716a.F(getFeedId()) && !TextUtils.equals(com.tencent.biz.qqcircle.comment.recpic.aa.f83750a.B(), getFeedId())) {
            return;
        }
        QLog.d(TAG, 1, "[showVideoFrameIfNeed]");
        if (com.tencent.biz.qqcircle.comment.recpic.aa.f83750a.E(getActivity())) {
            getMainHandler().postDelayed(new al(this), 250L);
        } else {
            getMainHandler().postDelayed(new am(this), 250L);
        }
    }

    private boolean showingBtnPublishAnim() {
        QFSPagAnimView qFSPagAnimView = this.mBtnPublishAnim;
        if (qFSPagAnimView != null && qFSPagAnimView.getVisibility() == 8) {
            return false;
        }
        return true;
    }

    private void startAnalyseFeedDesc() {
        int i3;
        com.tencent.biz.qqcircle.comment.recpic.aa aaVar = com.tencent.biz.qqcircle.comment.recpic.aa.f83750a;
        if (aaVar.x() && aaVar.E(getActivity()) && aaVar.z(getFeedData())) {
            QFSRecPicStateEvent qFSRecPicStateEvent = new QFSRecPicStateEvent(8, getFeedId());
            if (getContext() != null) {
                i3 = getContext().hashCode();
            } else {
                i3 = 0;
            }
            qFSRecPicStateEvent.mHashCode = i3;
            SimpleEventBus.getInstance().dispatchEvent(qFSRecPicStateEvent);
        }
    }

    public void startShow() {
        if (com.tencent.biz.qqcircle.helpers.i.f84624a.a(getContextHashcode())) {
            QLog.d(TAG, 1, "[onShowTotalStart] started show");
            return;
        }
        AbstractGifImage.resumeAll();
        this.mContainer.setVisibility(0);
        QCircleReportHelper.getInstance().recordPageStartShow(61);
        QCirclePanelStateEvent qCirclePanelStateEvent = new QCirclePanelStateEvent(0, getFeedId(), true);
        qCirclePanelStateEvent.setArg(Boolean.valueOf(needResetBlockWhenShowPanel()));
        SimpleEventBus.getInstance().dispatchEvent(qCirclePanelStateEvent);
        com.tencent.biz.qqcircle.immersive.utils.ax.g(getContext(), false);
        reportCommentAction(76);
        SimpleEventBus.getInstance().dispatchEvent(new QFSEnableSlideRightActionEvent(false, getContext()));
        com.tencent.biz.qqcircle.immersive.utils.as.c(QCircleDaTongConstant.ElementId.EM_XSJ_CMTPANEL, TAG);
        this.mPreNavColor = com.tencent.biz.qqcircle.immersive.utils.r.p(getContext());
        com.tencent.biz.qqcircle.immersive.utils.r.a1(getContext(), QFSQUIUtilsKt.d(getContext(), R.color.qui_common_bg_middle_light));
    }

    private void stopBtnPublishAnim() {
        if (this.mBtnPublishAnim != null && showingBtnPublishAnim()) {
            this.mBtnPublishAnim.setStaticImageMode(true);
            this.mBtnPublishAnim.L();
        }
    }

    private void switchBottomText() {
        TextView textView;
        if (this.mInputTextViewFlipper != null && canSwitchBottomTxt() && (textView = this.mBottomHintText) != null) {
            textView.setText(com.tencent.biz.qqcircle.utils.h.a(R.string.f181873ey));
            this.mInputTextViewFlipper.setInAnimation(getContext(), R.anim.f154904t9);
            this.mInputTextViewFlipper.setOutAnimation(getContext(), R.anim.f154905ta);
            this.mInputTextViewFlipper.showNext();
        }
    }

    private void switchPanelState() {
        if (FastClickUtils.isFastDoubleClick("SwitchPanelState", 100L)) {
            return;
        }
        this.mHalfScreenView.L();
        updateActionBean();
        hideEffectEntrance();
        switchBottomText();
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
            this.mBottomBlock.q0(0, false);
            this.mBlockContainer.getRecyclerView().scrollToPosition(0);
        }
        if (needResetBlockWhenShowPanel()) {
            this.mBottomBlock.q0(0, false);
            this.mBlockContainer.getRecyclerView().scrollToPosition(0);
            this.mCommentBlockViewModel.p2();
            setCommentNumText(getFeedData().commentCount.get());
            QFSCommentHelper.L().s();
            this.mCommentPanelHeight = 0;
        }
        QFSCommentGuildCardWrapper qFSCommentGuildCardWrapper = this.mCommentGuildCardWrapper;
        if (!this.mReceiveNeedResetBlockEvent && sameFeed()) {
            z16 = false;
        } else {
            z16 = true;
        }
        qFSCommentGuildCardWrapper.F(z16, this.mInfo);
        this.mCommentGuildCardWrapper.I(getDtPageId(), getPageId());
        if (!com.tencent.biz.qqcircle.comment.af.q()) {
            this.mReceiveNeedResetBlockEvent = false;
        }
        this.mLastFeed = getFeedData();
    }

    private void tryResetBtnPublishAnim() {
        QFSPagAnimView qFSPagAnimView = this.mBtnPublishAnim;
        if (qFSPagAnimView != null && this.mReceiveNeedResetBlockEvent) {
            qFSPagAnimView.V();
            this.mBtnPublishAnim.setStaticImageMode(false);
            if (showingBtnPublishAnim()) {
                this.mBtnPublish.setVisibility(0);
                this.mBtnPublishAnim.setVisibility(8);
            }
        }
    }

    private void tryShowBtnPublishAnim() {
        if (!showingBtnPublishAnim() && isAllowCommentVideo() && !QQTheme.isCustomTheme("", false)) {
            String B = com.tencent.biz.qqcircle.comment.h.G().B(getRealCellId());
            if (TextUtils.isEmpty(B)) {
                return;
            }
            this.mBtnPublishAnim.setVisibility(4);
            this.mBtnPublishAnim.setPagAnimListener(new QFSPagAnimView.c() { // from class: com.tencent.biz.qqcircle.bizparts.QFSCommentPanelPart.10
                AnonymousClass10() {
                }

                @Override // com.tencent.biz.qqcircle.widgets.QFSPagAnimView.c
                public /* bridge */ /* synthetic */ void onAnimationCancel(QFSPagAnimView qFSPagAnimView) {
                    com.tencent.biz.qqcircle.widgets.bc.a(this, qFSPagAnimView);
                }

                @Override // com.tencent.biz.qqcircle.widgets.QFSPagAnimView.c
                public /* bridge */ /* synthetic */ void onAnimationEnd(QFSPagAnimView qFSPagAnimView) {
                    com.tencent.biz.qqcircle.widgets.bc.b(this, qFSPagAnimView);
                }

                @Override // com.tencent.biz.qqcircle.widgets.QFSPagAnimView.c
                public /* bridge */ /* synthetic */ void onAnimationRepeat(QFSPagAnimView qFSPagAnimView) {
                    com.tencent.biz.qqcircle.widgets.bc.c(this, qFSPagAnimView);
                }

                @Override // com.tencent.biz.qqcircle.widgets.QFSPagAnimView.c
                public /* bridge */ /* synthetic */ void onAnimationStart(QFSPagAnimView qFSPagAnimView) {
                    com.tencent.biz.qqcircle.widgets.bc.d(this, qFSPagAnimView);
                }

                @Override // com.tencent.biz.qqcircle.widgets.QFSPagAnimView.c
                public void onAnimationUpdate(QFSPagAnimView qFSPagAnimView) {
                    QLog.d(QFSCommentPanelPart.TAG, 1, "[tryShowBtnPublishAnim] show comment pic entrance pag anim. ");
                    QFSCommentPanelPart.this.mBtnPublishAnim.setVisibility(0);
                    QFSCommentPanelPart.this.mBtnPublish.setVisibility(8);
                }

                @Override // com.tencent.biz.qqcircle.widgets.QFSPagAnimView.c
                public /* bridge */ /* synthetic */ void onPagPlayError(QFSPagAnimView qFSPagAnimView, String str) {
                    com.tencent.biz.qqcircle.widgets.bc.f(this, qFSPagAnimView, str);
                }
            });
            this.mBtnPublishAnim.setRepeatTimes(1);
            this.mBtnPublishAnim.M(B);
        }
    }

    private void tryShowKeyboard() {
        QQCircleFeedBase$StBusiInfoCommentListData busiInfo;
        QCircleInitBean initBean = getInitBean();
        if (initBean != null && initBean.getActionBean() != null && initBean.getActionBean().mShowInputKeyboard && !this.mHasShowKeyboard && (busiInfo = getBusiInfo()) != null && showInputWindowFromReply(busiInfo.comment, busiInfo.reply)) {
            this.mHasShowKeyboard = true;
        }
    }

    private void tryShowLoadingAndTopFeedDesc() {
        if (getCommentSize() > 0) {
            return;
        }
        setCommentNumText(getFeedData().commentCount.get());
        setLoadingStatus(true);
        if (needShowTopFeedDesc(getFeedData())) {
            this.mBlockContainer.setVisibility(0);
            this.mCommentBlockViewModel.b2().setValue(getFeedData());
            showTopFeedDesc();
            return;
        }
        removeTopFeedDesc();
    }

    private void updateActionBean() {
        String str;
        QFSCommentInfo qFSCommentInfo = this.mInfo;
        if (qFSCommentInfo.mActionBean == null) {
            qFSCommentInfo.mActionBean = new QFSCommentInfo.ActionBean();
        }
        boolean isShowMaxHeight = isShowMaxHeight();
        QFSCommentInfo qFSCommentInfo2 = this.mInfo;
        qFSCommentInfo2.mActionBean.mShowMaxHeight = isShowMaxHeight;
        if (isShowMaxHeight) {
            str = com.tencent.biz.qqcircle.utils.h.a(R.string.f181873ey);
        } else {
            str = this.mOutsideHintText;
        }
        qFSCommentInfo2.mHintText = str;
    }

    private void updateGuidePic() {
        if (this.mBottomGuidePic == null) {
            return;
        }
        List<StrategyImage> G = QFSCommentRecPicClusterHelper.f83716a.G(getFeedId());
        this.mBottomGuidePic.setVisibility(0);
        if (RFSafeListUtils.isEmpty(G)) {
            return;
        }
        Option obtain = Option.obtain();
        obtain.setUrl(G.get(0).getPath()).setTargetView(this.mBottomGuidePic);
        QCircleFeedPicLoader.g().loadImage(obtain);
    }

    protected void adjustCloseBtnSize(int i3) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mIvFloatClose.getLayoutParams();
        layoutParams.topMargin = i3;
        this.mIvFloatClose.setLayoutParams(layoutParams);
    }

    protected void dismissCommentPanel() {
        FrameLayout frameLayout = this.mContainer;
        if (frameLayout != null && this.mHalfScreenView != null && frameLayout.getVisibility() == 0) {
            this.mHalfScreenView.k();
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
        QFSCommentSheetView qFSCommentSheetView = this.mHalfScreenView;
        if (qFSCommentSheetView == null) {
            return;
        }
        qFSCommentSheetView.setDraggable(z16);
        this.mHalfScreenView.setCanSlide(z16);
    }

    @Override // com.tencent.biz.qqcircle.bizparts.ag
    protected QCircleBlockContainer getBlockContainer() {
        return this.mBlockContainer;
    }

    public int getBlockContainerHeight() {
        int i3 = 0;
        if (getBlockContainer() == null || getBlockContainer().getRecyclerView() == null) {
            return 0;
        }
        int height = getBlockContainer().getRecyclerView().getHeight();
        if (height < getDefaultHeight() && uq3.c.q0()) {
            if (isTopViewShowing()) {
                i3 = this.mTopView.getMeasuredHeight();
            }
            QLog.d(TAG, 1, "[getBlockContainerHeight] containerH: " + height + "panelHeight: " + getDefaultHeight() + "topViewHeight: " + i3);
            return getDefaultHeight() - i3;
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
        com.tencent.biz.qqcircle.adapter.r rVar = this.mBottomBlock;
        if (rVar == null) {
            return super.getCommentBlockContainer();
        }
        return rVar.m0();
    }

    @Override // com.tencent.biz.qqcircle.bizparts.ag
    protected View getCommentBottomBar() {
        return this.mCommentBottomBar;
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
        return this.mContainer;
    }

    protected String getContextHashcode() {
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
        eventClass.add(QFSCommentDoubleTapEvent.class);
        eventClass.add(QFSRecPicStateEvent.class);
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
        return R.id.u2_;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return TAG;
    }

    @Override // com.tencent.biz.qqcircle.bizparts.ag
    protected QCircleAsyncTextView getTextInputView() {
        return this.mTextInput;
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
        if (isShowMaxHeight()) {
            return null;
        }
        super.handleCommentOrReplyAdded(feedCloudMeta$StComment, feedCloudMeta$StReply, feedCloudMeta$StFeed);
        if (this.mCommentEffectController == null) {
            this.mCommentEffectController = new com.tencent.biz.qqcircle.comment.effect.e();
        }
        return this.mCommentEffectController.b(this.mContainer, this.mAniView, feedCloudMeta$StComment, feedCloudMeta$StReply, feedCloudMeta$StFeed);
    }

    protected void handleConfigChange() {
        if (this.mHalfScreenView == null || !com.tencent.biz.qqcircle.utils.bz.r()) {
            return;
        }
        QLog.d(TAG, 1, "[handleConfigChange] ");
        this.mCommentPanelHeight = 0;
        this.mHalfScreenView.setTag(Boolean.valueOf(QCirclePanelStateEvent.isSpecifiedPanelShowing(0)));
        dismissCommentPanel();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.bizparts.ag
    public void handleGetCommentList(QCircleCommentUpdateEvent qCircleCommentUpdateEvent) {
        if (!qCircleCommentUpdateEvent.feedId.equals(getRealCellId())) {
            return;
        }
        if (com.tencent.biz.qqcircle.comment.af.q()) {
            this.mReceiveNeedResetBlockEvent = false;
        }
        if (this.mOnShowCompletely) {
            handleGetCommentListInternal(qCircleCommentUpdateEvent);
        } else {
            PreLoader.preLoad(getCommentDataPreloadId(), new com.tencent.biz.qqcircle.preload.task.a(qCircleCommentUpdateEvent));
        }
    }

    @Override // r20.a
    public boolean hasReceiveNeedResetBlockEvent() {
        return this.mReceiveNeedResetBlockEvent;
    }

    @Override // com.tencent.biz.qqcircle.bizparts.ag
    public void initCommentInfo(@NonNull QFSCommentInfo qFSCommentInfo) {
        super.initCommentInfo(qFSCommentInfo);
        com.tencent.biz.qqcircle.adapter.r rVar = this.mBottomBlock;
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
        this.mBtnEmotion.setOnClickListener(this);
        this.mBtnMention.setOnClickListener(this);
        this.mBtnPublish.setOnClickListener(this);
        this.mBtnPublishAnim.setOnClickListener(this);
        this.mBtnAiComment.setOnClickListener(this);
        this.mTextInput.seOnClickableImageSpanListener(new RFWAsyncRichTextView.OnClickableImageSpanListener() { // from class: com.tencent.biz.qqcircle.bizparts.QFSCommentPanelPart.6
            AnonymousClass6() {
            }

            @Override // com.tencent.richframework.text.rich.RFWAsyncRichTextView.OnClickableImageSpanListener
            public void onClick(int i3, String str) {
                com.tencent.biz.qqcircle.utils.an E = QFSCommentHelper.L().E(QFSCommentPanelPart.this.getFeedData(), null, null);
                if (E != null && E.b() != null) {
                    com.tencent.biz.qqcircle.utils.be b16 = E.b();
                    if (TextUtils.equals(str, b16.c())) {
                        com.tencent.biz.qqcircle.helpers.l.e().j(b16.a(), true);
                    }
                }
            }
        });
    }

    protected void initSlideView() {
        FrameLayout frameLayout = this.mContainer;
        if (frameLayout == null) {
            return;
        }
        this.mHalfScreenView = (QFSCommentSheetView) frameLayout.findViewById(R.id.f47571xn);
        initHalfScreenView();
    }

    @Override // com.tencent.biz.qqcircle.bizparts.ag
    public void initView() {
        View partRootView = getPartRootView();
        if (partRootView == null) {
            return;
        }
        FrameLayout frameLayout = (FrameLayout) partRootView.findViewById(R.id.u28);
        this.mContainer = frameLayout;
        frameLayout.setVisibility(8);
        initSlideView();
        this.mTopView = (FrameLayout) this.mContainer.findViewById(R.id.v8w);
        this.mBlockContainer = (QCircleBlockContainer) this.mContainer.findViewById(R.id.f30820pd);
        RelativeLayout relativeLayout = (RelativeLayout) this.mContainer.findViewById(R.id.f30800pb);
        this.mAniView = relativeLayout;
        relativeLayout.setOutlineProvider(new ViewOutlineProvider() { // from class: com.tencent.biz.qqcircle.bizparts.QFSCommentPanelPart.2
            AnonymousClass2() {
            }

            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view, Outline outline) {
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), QFSCommentPanelPart.RADIUS);
            }
        });
        this.mAniView.setClipToOutline(true);
        this.mIvFloatClose = (ImageView) this.mContainer.findViewById(R.id.y3a);
        ImageView imageView = (ImageView) this.mContainer.findViewById(R.id.y3b);
        this.mSwitchBtn = imageView;
        imageView.setVisibility(0);
        QFSCommentReportHelper.d(this.mSwitchBtn, this);
        this.mIvFloatClose.setOnClickListener(this);
        this.mSwitchBtn.setOnClickListener(this);
        View findViewById = this.mContainer.findViewById(R.id.u1e);
        this.mCommentBottomBar = findViewById;
        findViewById.setVisibility(8);
        com.tencent.mobileqq.qui.b.f276860a.a(this.mCommentBottomBar, RFWNavigationBarImmersiveHelper.ImmersiveType.IMMERSIVE);
        ViewFlipper viewFlipper = (ViewFlipper) this.mContainer.findViewById(R.id.f353311k);
        this.mInputTextViewFlipper = viewFlipper;
        View findViewById2 = viewFlipper.findViewById(R.id.vvp);
        this.mBottomGuideContainer = findViewById2;
        findViewById2.setOnClickListener(this);
        this.mBottomGuidePic = (ImageView) this.mInputTextViewFlipper.findViewById(R.id.f164695am1);
        this.mBottomGuideRedPoint = (ImageView) this.mInputTextViewFlipper.findViewById(R.id.vg_);
        this.mBottomHintText = (TextView) this.mInputTextViewFlipper.findViewById(R.id.f353111i);
        this.mInputTextViewFlipper.setOnClickListener(this);
        this.mTextInput = (QCircleAsyncTextView) this.mContainer.findViewById(R.id.jha);
        this.mLabelIcon = (ImageView) this.mContainer.findViewById(R.id.yce);
        ImageView imageView2 = (ImageView) this.mContainer.findViewById(R.id.f3702165);
        this.mEDaxiaIcon = imageView2;
        imageView2.setOnClickListener(this);
        this.mBtnEmotion = (ImageView) this.mContainer.findViewById(R.id.ah5);
        this.emotionRedPoint = this.mContainer.findViewById(R.id.teg);
        this.mBtnMention = (ImageView) this.mContainer.findViewById(R.id.tfi);
        this.mBtnPublishAnim = (QFSPagAnimView) this.mContainer.findViewById(R.id.f164676tg0);
        this.mBtnPublishContainer = (ViewGroup) this.mContainer.findViewById(R.id.f164677tg1);
        this.mBtnPublish = (ImageView) this.mContainer.findViewById(R.id.tfz);
        this.mBtnAiComment = (ImageView) this.mContainer.findViewById(R.id.tcm);
        this.mGuideBubbleManager = new com.tencent.biz.qqcircle.comment.emoji.o(this.mContainer);
        this.mZoomOutDrawable = QFSQUIUtilsKt.f(getContext(), R.drawable.qui_zoom_out, R.color.qui_common_icon_primary);
        this.mZoomInDrawable = QFSQUIUtilsKt.f(getContext(), R.drawable.qui_zoom_in, R.color.qui_common_icon_primary);
        super.initView();
    }

    public boolean isShow() {
        FrameLayout frameLayout = this.mContainer;
        if (frameLayout != null && frameLayout.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    public boolean isShowMaxHeight() {
        QFSCommentSheetView qFSCommentSheetView = this.mHalfScreenView;
        if (qFSCommentSheetView != null && qFSCommentSheetView.q() == 2) {
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
        QFSCommentSheetView qFSCommentSheetView = this.mHalfScreenView;
        if (qFSCommentSheetView != null && qFSCommentSheetView.getVisibility() != 0) {
            return true;
        }
        return false;
    }

    public boolean needResetBlockWhenShowPanel() {
        boolean z16;
        if (!this.mReceiveNeedResetBlockEvent && sameFeed()) {
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
        EventCollector.getInstance().onViewClickedBefore(view);
        super.onClick(view);
        int id5 = view.getId();
        if (id5 == R.id.y3a) {
            dismissCommentPanel();
        }
        if (id5 == R.id.y3b) {
            switchPanelState();
        } else {
            String str = "";
            if (id5 == R.id.vvp) {
                com.tencent.biz.qqcircle.comment.recpic.ak.f83788a.b(view, getFeedData(), false);
                com.tencent.biz.qqcircle.comment.recpic.aa aaVar = com.tencent.biz.qqcircle.comment.recpic.aa.f83750a;
                if (aaVar.E(getActivity())) {
                    showInputWindowWithRecPicBar();
                } else {
                    Context context = getContext();
                    String str2 = getFeedData().f398449id.get();
                    if (getReportBean() != null) {
                        str = getReportBean().getDtPageId();
                    }
                    aaVar.R(context, str2, "cmt_box", str);
                    showNext();
                }
            } else if (id5 == R.id.f353311k) {
                getTextInputView().performClick();
            } else if (id5 == R.id.tfi) {
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
                        Context context2 = getContext();
                        DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: com.tencent.biz.qqcircle.bizparts.an
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i3) {
                                QFSCommentPanelPart.this.lambda$onClick$3(dialogInterface, i3);
                            }
                        };
                        if (getReportBean() != null) {
                            str = getReportBean().getDtPageId();
                        }
                        com.tencent.biz.qqcircle.comment.af.K(context2, onClickListener, str);
                    } else {
                        showInputWindowWithAiComment();
                    }
                } else if (id5 == R.id.f3702165) {
                    com.tencent.biz.qqcircle.utils.cm.g(getContext(), this.mBlockContainer);
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
        this.mCommentGuildCardWrapper = new QFSCommentGuildCardWrapper(getContainer());
        this.mCommentBlockViewModel.f2().observe(getPartHost().getLifecycleOwner(), new Observer() { // from class: com.tencent.biz.qqcircle.bizparts.ak
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSCommentPanelPart.this.lambda$onInitView$0((Boolean) obj);
            }
        });
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
        com.tencent.biz.qqcircle.comment.af.i();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public /* bridge */ /* synthetic */ void onPartPause(Activity activity) {
        com.tencent.biz.richframework.part.b.c(this, activity);
    }

    @Override // com.tencent.biz.qqcircle.bizparts.ag, com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        com.tencent.biz.qqcircle.comment.emoji.o oVar;
        super.onPartResume(activity);
        QCirclePluginUtil.setIsECFloatWebViewOnShow(false);
        if (!com.tencent.biz.qqcircle.comment.emoji.o.c() && (oVar = this.mGuideBubbleManager) != null) {
            oVar.a();
        }
        if (this.lastInputWindowConfig != null) {
            uq3.k.b().r("sp_key_emoji_last_selected_emoji_tab");
            QFSCommentHelper.L().w0(this.lastInputWindowConfig);
            this.lastInputWindowConfig = null;
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public /* bridge */ /* synthetic */ void onPartSaveInstanceState(Activity activity, Bundle bundle) {
        com.tencent.biz.richframework.part.b.e(this, activity, bundle);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public /* bridge */ /* synthetic */ void onPartStart(Activity activity) {
        com.tencent.biz.richframework.part.b.f(this, activity);
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
        if (simpleBaseEvent instanceof QFSCommentDoubleTapEvent) {
            handleCommentDoubleTapEvent((QFSCommentDoubleTapEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof QFSRecPicStateEvent) {
            handleRecPicStateEvent((QFSRecPicStateEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof QFSCommentOpenPicPanel) {
            QFSCommentOpenPicPanel qFSCommentOpenPicPanel = (QFSCommentOpenPicPanel) simpleBaseEvent;
            if (getPartHost() == null) {
                QLog.w(TAG, 1, "[openPicSelectPage] no partHost");
                return;
            }
            String str = getPartHost().hashCode() + "";
            QLog.d(TAG, 1, "[openPicSelectPage] target: " + qFSCommentOpenPicPanel.getTargetHashCode() + ", current: " + str);
            if (!TextUtils.equals(qFSCommentOpenPicPanel.getTargetHashCode(), str)) {
                QLog.d(TAG, 1, "[openPicSelectPage] not the same partHost");
            } else {
                openPicSelectPage();
            }
        }
    }

    @Override // com.tencent.biz.qqcircle.bizparts.ag
    protected ArrayList<MultiViewBlock> prepareAdapters() {
        if (this.mBottomBlock == null) {
            com.tencent.biz.qqcircle.adapter.r rVar = new com.tencent.biz.qqcircle.adapter.r(null);
            this.mBottomBlock = rVar;
            rVar.setReportBean(getReportBean());
        }
        ArrayList<MultiViewBlock> arrayList = new ArrayList<>();
        arrayList.add(this.mBottomBlock);
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
        boolean z16;
        View view = this.mCommentBottomBar;
        if (view != null && this.mBottomBlock != null && this.mHalfScreenView != null) {
            int i16 = 0;
            if (view.getVisibility() != i3) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("[setCommentBottomBarVisibility] visible: ");
                if (i3 == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                sb5.append(z16);
                QLog.d(TAG, 1, sb5.toString());
            }
            this.mCommentBottomBar.setVisibility(i3);
            com.tencent.biz.qqcircle.adapter.r rVar = this.mBottomBlock;
            if (i3 == 0) {
                i16 = getCommentBottomBarHeightUncaredVisible();
            }
            rVar.i0(i16);
        }
    }

    @Override // com.tencent.biz.qqcircle.bizparts.ag
    protected void setLoadingStatus(boolean z16) {
        com.tencent.biz.qqcircle.viewmodels.n nVar = this.mCommentBlockViewModel;
        if (nVar != null) {
            nVar.Z1().setValue(Boolean.valueOf(z16));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.bizparts.ag
    public void setOrUpdateBlockData(@NonNull List<FeedCloudMeta$StComment> list, int i3) {
        if (getContextHashCode() != i3) {
            dismissCommentPanel();
            this.mReceiveNeedResetBlockEvent = true;
            QLog.d(TAG, 1, "[setOrUpdateBlockData] curContextHashcode: " + getContextHashCode() + ", eventContextHashcode: " + i3);
            return;
        }
        super.setOrUpdateBlockData(list, i3);
    }

    public void showCommentInputWindow(String str) {
        QFSCommentInputWindowConfig qFSCommentInputWindowConfig = new QFSCommentInputWindowConfig();
        qFSCommentInputWindowConfig.commentInfo = new QFSFeedCommentInfo(getFeedData(), null, null, str);
        showCommentInputWindow(null, null, qFSCommentInputWindowConfig);
    }

    protected void showCommentPanel() {
        boolean z16;
        QFSCommentInfo.ActionBean actionBean;
        QFSCommentSheetView qFSCommentSheetView = this.mHalfScreenView;
        if (qFSCommentSheetView != null) {
            QFSCommentInfo qFSCommentInfo = this.mInfo;
            if (qFSCommentInfo != null && (actionBean = qFSCommentInfo.mActionBean) != null && actionBean.mShowMaxHeight) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                qFSCommentSheetView.I();
            } else {
                qFSCommentSheetView.G();
            }
            setSwitchState(!z16);
        }
        QFSHodorCollectManager.f84689a.b("qfs_comment_panel_begin_business");
    }

    protected void showInputWindowWithRecPicBar() {
        QFSCommentInputWindowConfig qFSCommentInputWindowConfig = new QFSCommentInputWindowConfig();
        qFSCommentInputWindowConfig.isShowRecPicBar = true;
        showCommentInputWindow(null, null, qFSCommentInputWindowConfig);
    }

    @Override // com.tencent.biz.qqcircle.bizparts.ag
    protected boolean showPicEntranceRedPoint() {
        com.tencent.biz.qqcircle.comment.emoji.o oVar = this.mGuideBubbleManager;
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
