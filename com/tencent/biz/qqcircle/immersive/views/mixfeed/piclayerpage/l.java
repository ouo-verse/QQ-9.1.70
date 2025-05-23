package com.tencent.biz.qqcircle.immersive.views.mixfeed.piclayerpage;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.bizparts.QCircleLightInteractListPart;
import com.tencent.biz.qqcircle.events.QCircleCommentCountUpdateEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSCommentInputButNotSendEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSDoublePraiseEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSNewContentDetailPicPositionChangeEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.ShowSharePanelEvent;
import com.tencent.biz.qqcircle.immersive.gallery.viewmodel.QFSGalleryDetailViewModel;
import com.tencent.biz.qqcircle.immersive.utils.au;
import com.tencent.biz.qqcircle.immersive.utils.r;
import com.tencent.biz.qqcircle.manager.QCirclePushInfoManager;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.richframework.widget.RoundCorneredFrameLayout;
import com.tencent.biz.qqcircle.utils.QFSAsyncUtils;
import com.tencent.biz.qqcircle.utils.cr;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.QCircleRecommendImageView;
import com.tencent.biz.qqcircle.widgets.QCircleRocketView;
import com.tencent.biz.qqcircle.widgets.QFSLikeImageView;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.MessageForQCircleFeed;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qcircle.weseevideo.model.utils.LocaleUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.richframework.data.base.UIStateData;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StLike;
import feedcloud.FeedCloudMeta$StPushList;
import feedcloud.FeedCloudMeta$StUser;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qqcircle.QQCircleFeedBase$StFeedBusiReqData;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00c2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u0082\u00012\u00020\u00012\u00020\u00022\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003:\u0002\u0083\u0001B\u0011\u0012\u0006\u0010D\u001a\u00020A\u00a2\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J\u0012\u0010\u000f\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u0010\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u0011\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u0013\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0014\u001a\u00020\tH\u0002J\"\u0010\u0018\u001a\u00020\t2\u0018\u0010\u0017\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0016\u0018\u00010\u0015H\u0002J\u0012\u0010\u001b\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0002J\u0012\u0010\u001c\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0012\u0010\u001e\u001a\u00020\t2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0019H\u0002J\u0010\u0010\u001f\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u0019H\u0002J\u0010\u0010\"\u001a\u00020\t2\u0006\u0010!\u001a\u00020 H\u0002J\b\u0010#\u001a\u00020\tH\u0002J\u0010\u0010%\u001a\u00020\t2\u0006\u0010$\u001a\u00020 H\u0002J\u0012\u0010'\u001a\u00020&2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0019H\u0002J\u0012\u0010(\u001a\u00020&2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0002J\u0010\u0010*\u001a\u00020\t2\u0006\u0010)\u001a\u00020\u0019H\u0002J\u0010\u0010,\u001a\u00020\t2\u0006\u0010+\u001a\u00020 H\u0002J\b\u0010-\u001a\u00020\tH\u0002J\b\u0010.\u001a\u00020\tH\u0002J\u0010\u00100\u001a\u00020\t2\u0006\u0010/\u001a\u00020\u0007H\u0002J\b\u00101\u001a\u00020\tH\u0002J\b\u00102\u001a\u00020\tH\u0002J\b\u00103\u001a\u00020\tH\u0002J\u0012\u00106\u001a\u00020\t2\b\u00105\u001a\u0004\u0018\u000104H\u0002J\u0010\u00108\u001a\u00020\t2\u0006\u00105\u001a\u000207H\u0002J\u0010\u0010:\u001a\u00020\t2\u0006\u00105\u001a\u000209H\u0002J\b\u0010;\u001a\u00020\tH\u0002J\u0012\u0010>\u001a\u00020\t2\b\u0010=\u001a\u0004\u0018\u00010<H\u0002J\b\u0010?\u001a\u00020\tH\u0002J\b\u0010@\u001a\u00020\tH\u0002R\u0014\u0010D\u001a\u00020A8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010H\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0018\u0010L\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0018\u0010N\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010KR\u0018\u0010P\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010KR\u0018\u0010T\u001a\u0004\u0018\u00010Q8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0018\u0010X\u001a\u0004\u0018\u00010U8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010WR\u0018\u0010\\\u001a\u0004\u0018\u00010Y8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u0018\u0010`\u001a\u0004\u0018\u00010]8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010_R\u0018\u0010b\u001a\u0004\u0018\u00010U8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\ba\u0010WR\u0018\u0010d\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bc\u0010KR\u0016\u0010g\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\be\u0010fR\u0016\u0010i\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bh\u0010hR\u0016\u0010k\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bj\u0010hR\u0016\u0010n\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bl\u0010mR\u0018\u0010r\u001a\u0004\u0018\u00010o8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bp\u0010qR\u0016\u0010t\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bs\u0010hR\u0018\u0010x\u001a\u0004\u0018\u00010u8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bv\u0010wR\u0018\u0010{\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\by\u0010zR\u0014\u0010\u007f\u001a\u00020|8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b}\u0010~\u00a8\u0006\u0084\u0001"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/views/mixfeed/piclayerpage/l;", "Lcom/tencent/biz/qqcircle/bizparts/b;", "Landroid/view/View$OnClickListener;", "Landroidx/lifecycle/Observer;", "Le30/b;", "", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "view", NodeProps.ON_CLICK, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "onPartPause", "onPartDestroy", "feedBlockData", "V9", "initViewModel", "Lcom/tencent/richframework/data/base/UIStateData;", "", "uiStateData", "R9", "Lfeedcloud/FeedCloudMeta$StFeed;", "feed", "J9", "Z9", "stFeed", LocaleUtils.L_JAPANESE, "ma", "", MessageForQCircleFeed.MSG_QCIRCLE_FEED_KEY_PUSH_COUNT, "ha", "K9", "commentNum", "da", "", "T9", "U9", "data", "ea", "likeNum", "ga", "I9", "X9", "v", "O9", "aa", "Q9", "ba", "Lcom/tencent/biz/qqcircle/events/QCircleCommentCountUpdateEvent;", "event", "M9", "Lcom/tencent/biz/qqcircle/immersive/feed/event/QFSDoublePraiseEvent;", "N9", "Lcom/tencent/biz/qqcircle/immersive/feed/event/QFSNewContentDetailPicPositionChangeEvent;", "P9", "Y9", "", "reqInfo", "ia", "L9", "ca", "Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;", "d", "Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;", "mInitBean", "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCorneredFrameLayout;", "e", "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCorneredFrameLayout;", "mInputRoundCorneredFrameLayout", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "mFeedLikeText", tl.h.F, "mFeedCommentText", "i", "mFeedPushText", "Lcom/tencent/biz/qqcircle/widgets/QFSLikeImageView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/biz/qqcircle/widgets/QFSLikeImageView;", "mLikeImg", "Landroid/widget/FrameLayout;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/FrameLayout;", "mCommentFl", "Lcom/tencent/biz/qqcircle/widgets/QCircleRecommendImageView;", "D", "Lcom/tencent/biz/qqcircle/widgets/QCircleRecommendImageView;", "mPushBtn", "Lcom/tencent/biz/qqcircle/widgets/QCircleRocketView;", "E", "Lcom/tencent/biz/qqcircle/widgets/QCircleRocketView;", "mRockeyView", UserInfo.SEX_FEMALE, "mShareFl", "G", "mShareText", "H", "Z", "mIsLiked", "I", "mUpdateLikeNum", "J", "mCommentCount", "K", "Lfeedcloud/FeedCloudMeta$StFeed;", "mFeed", "Lcom/tencent/biz/qqcircle/widgets/QCircleRecommendImageView$f;", "L", "Lcom/tencent/biz/qqcircle/widgets/QCircleRecommendImageView$f;", "mPushBtnClickDelegate", "M", "mPicHorizontalPos", "Lcom/tencent/biz/qqcircle/immersive/gallery/viewmodel/QFSGalleryDetailViewModel;", "N", "Lcom/tencent/biz/qqcircle/immersive/gallery/viewmodel/QFSGalleryDetailViewModel;", "mViewModel", "P", "Le30/b;", "mCenterFeedBlockData", "Lcom/tencent/biz/qqcircle/utils/cr;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/biz/qqcircle/utils/cr;", "eventListener", "<init>", "(Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;)V", BdhLogUtil.LogTag.Tag_Req, "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class l extends com.tencent.biz.qqcircle.bizparts.b implements View.OnClickListener, Observer<e30.b> {

    @Nullable
    private static final String S = com.tencent.biz.qqcircle.utils.h.a(R.string.f193704_x);

    @Nullable
    private static final String T = com.tencent.biz.qqcircle.utils.h.a(R.string.f183253io);

    @Nullable
    private static final String U = com.tencent.biz.qqcircle.utils.h.a(R.string.f184613mc);

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private FrameLayout mCommentFl;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private QCircleRecommendImageView mPushBtn;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private QCircleRocketView mRockeyView;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private FrameLayout mShareFl;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private TextView mShareText;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean mIsLiked;

    /* renamed from: I, reason: from kotlin metadata */
    private int mUpdateLikeNum;

    /* renamed from: J, reason: from kotlin metadata */
    private int mCommentCount;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private FeedCloudMeta$StFeed mFeed;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private QCircleRecommendImageView.f mPushBtnClickDelegate;

    /* renamed from: M, reason: from kotlin metadata */
    private int mPicHorizontalPos;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private QFSGalleryDetailViewModel mViewModel;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private e30.b mCenterFeedBlockData;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final cr eventListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QCircleInitBean mInitBean;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RoundCorneredFrameLayout mInputRoundCorneredFrameLayout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView mFeedLikeText;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView mFeedCommentText;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView mFeedPushText;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QFSLikeImageView mLikeImg;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/biz/qqcircle/immersive/views/mixfeed/piclayerpage/l$b", "Lcom/tencent/biz/qqcircle/widgets/QCircleRecommendImageView$d;", "", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class b implements QCircleRecommendImageView.d {
        b() {
        }

        @Override // com.tencent.biz.qqcircle.widgets.QCircleRecommendImageView.d
        public void a() {
            l.this.X9();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u0006\u001a\"\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u00030\u0002j\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003`\u0005H\u0014J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/biz/qqcircle/immersive/views/mixfeed/piclayerpage/l$c", "Lcom/tencent/biz/qqcircle/utils/cr;", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lkotlin/collections/ArrayList;", "a", "simpleBaseEvent", "", "onReceiveEvent", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class c extends cr {
        c() {
        }

        @Override // com.tencent.biz.qqcircle.utils.cr
        @NotNull
        protected ArrayList<Class<? extends SimpleBaseEvent>> a() {
            ArrayList<Class<? extends SimpleBaseEvent>> arrayListOf;
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QCircleCommentCountUpdateEvent.class, QFSDoublePraiseEvent.class, QFSNewContentDetailPicPositionChangeEvent.class, ShowSharePanelEvent.class);
            return arrayListOf;
        }

        @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
        public void onReceiveEvent(@Nullable SimpleBaseEvent simpleBaseEvent) {
            if (simpleBaseEvent instanceof QCircleCommentCountUpdateEvent) {
                l.this.M9((QCircleCommentCountUpdateEvent) simpleBaseEvent);
                return;
            }
            if (simpleBaseEvent instanceof QFSDoublePraiseEvent) {
                l.this.N9((QFSDoublePraiseEvent) simpleBaseEvent);
            } else if (simpleBaseEvent instanceof QFSNewContentDetailPicPositionChangeEvent) {
                l.this.P9((QFSNewContentDetailPicPositionChangeEvent) simpleBaseEvent);
            } else if (simpleBaseEvent instanceof ShowSharePanelEvent) {
                l.this.ba();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"com/tencent/biz/qqcircle/immersive/views/mixfeed/piclayerpage/l$d", "Lcom/tencent/biz/qqcircle/widgets/QFSLikeImageView$d;", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class d implements QFSLikeImageView.d {
        d() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/biz/qqcircle/immersive/views/mixfeed/piclayerpage/l$e", "Lcom/tencent/biz/qqcircle/widgets/QCircleRecommendImageView$f;", "", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class e implements QCircleRecommendImageView.f {
        e() {
        }

        @Override // com.tencent.biz.qqcircle.widgets.QCircleRecommendImageView.f
        public boolean a() {
            return false;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J)\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0016\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0003\"\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"com/tencent/biz/qqcircle/immersive/views/mixfeed/piclayerpage/l$f", "Lcom/tencent/biz/qqcircle/utils/QFSAsyncUtils$Callback;", "Ljava/lang/Void;", "", "param", "doBackgroundAction", "([Ljava/lang/Void;)Ljava/lang/Void;", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class f extends QFSAsyncUtils.Callback<Void, Void> {
        f() {
        }

        @Override // com.tencent.biz.qqcircle.utils.QFSAsyncUtils.Callback
        @Nullable
        public Void doBackgroundAction(@NotNull Void... param) {
            Intrinsics.checkNotNullParameter(param, "param");
            db0.d dVar = new db0.d();
            Map<String, Object> map = new QCircleDTParamBuilder().buildElementParams();
            Map<String, Object> d16 = ua0.c.d(new e30.b(l.this.mFeed));
            Intrinsics.checkNotNullExpressionValue(d16, "convertDataToDTParamsMap(FeedBlockData(mFeed))");
            map.putAll(d16);
            if (l.this.mFeed.poster != null && l.this.mFeed.poster.f398463id != null) {
                map.put("xsj_target_qq", l.this.mFeed.poster.f398463id.get());
            }
            map.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
            map.put("xsj_action_type", "clck");
            Intrinsics.checkNotNullExpressionValue(map, "map");
            map.put(QCircleDaTongConstant.ElementParamKey.XSJ_CLCK_TYPE, "clck");
            map.put(QCircleDaTongConstant.ElementParamKey.XSJ_COMMENT_IF_GENGWANG, Integer.valueOf(l.this.mFeed.poster.label.get() != 1 ? 0 : 1));
            VideoReport.setElementId(l.this.mPushBtn, QCircleDaTongConstant.ElementId.EM_XSJ_PUSH_BUTTON_EXPAND_ROCKET);
            VideoReport.setElementExposePolicy(l.this.mPushBtn, ExposurePolicy.REPORT_ALL);
            VideoReport.setElementClickPolicy(l.this.mPushBtn, ClickPolicy.REPORT_ALL);
            dVar.d(QCircleDaTongConstant.EventId.EV_XSJ_PUSH, l.this.mPushBtn, map);
            QCircleRecommendImageView qCircleRecommendImageView = l.this.mPushBtn;
            if (qCircleRecommendImageView == null) {
                return null;
            }
            qCircleRecommendImageView.setPushReportReqInterceptor(dVar);
            return null;
        }
    }

    public l(@NotNull QCircleInitBean mInitBean) {
        Intrinsics.checkNotNullParameter(mInitBean, "mInitBean");
        this.mInitBean = mInitBean;
        FeedCloudMeta$StFeed feed = mInitBean.getFeed();
        Intrinsics.checkNotNullExpressionValue(feed, "mInitBean.feed");
        this.mFeed = feed;
        this.eventListener = new c();
    }

    private final void I9() {
        QCircleRecommendImageView qCircleRecommendImageView = this.mPushBtn;
        if (qCircleRecommendImageView != null && qCircleRecommendImageView != null) {
            qCircleRecommendImageView.setRecommendViewActionListener(new b());
        }
    }

    private final void J9(FeedCloudMeta$StFeed feed) {
        if (feed == null) {
            return;
        }
        this.mFeed = feed;
        ea(feed);
        da(feed.commentCount.get());
        ja(feed);
        ma(feed);
        this.mCenterFeedBlockData = new e30.b(feed);
        w20.a.j().observerGlobalState(this.mCenterFeedBlockData, this);
    }

    private final void K9() {
        RoundCorneredFrameLayout roundCorneredFrameLayout = this.mInputRoundCorneredFrameLayout;
        if (roundCorneredFrameLayout != null && this.mCommentFl != null) {
            VideoReport.setElementId(roundCorneredFrameLayout, QCircleDaTongConstant.ElementId.EM_XSJ_EXCON_COMMENT_FRAME);
            VideoReport.setElementClickPolicy(this.mInputRoundCorneredFrameLayout, ClickPolicy.REPORT_ALL);
            VideoReport.setElementReuseIdentifier(this.mInputRoundCorneredFrameLayout, this.mFeed.f398449id.get());
            VideoReport.setElementId(this.mCommentFl, QCircleDaTongConstant.ElementId.EM_XSJ_COMMENT_BUTTON);
            VideoReport.setElementReuseIdentifier(this.mCommentFl, this.mFeed.f398449id.get());
        }
    }

    private final void L9() {
        String str;
        if (this.mFeed.poster == null) {
            return;
        }
        Map<String, Object> map = new QCircleDTParamBuilder().buildElementParams();
        if (this.mIsLiked) {
            str = "cancel";
        } else {
            str = "like";
        }
        map.put("xsj_action_type", str);
        map.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
        map.put("xsj_target_qq", this.mFeed.poster.f398463id.get());
        Intrinsics.checkNotNullExpressionValue(map, "map");
        map.put(QCircleDaTongConstant.ElementParamKey.XSJ_CLCK_TYPE, "clck");
        int i3 = 1;
        if (this.mFeed.poster.label.get() != 1) {
            i3 = 0;
        }
        map.put(QCircleDaTongConstant.ElementParamKey.XSJ_COMMENT_IF_GENGWANG, Integer.valueOf(i3));
        VideoReport.setElementId(this.mLikeImg, QCircleDaTongConstant.ElementId.EM_XSJ_PRODUCT);
        VideoReport.setElementParams(this.mLikeImg, map);
        VideoReport.setElementExposePolicy(this.mLikeImg, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(this.mLikeImg, ClickPolicy.REPORT_ALL);
        VideoReport.reportEvent(QCircleDaTongConstant.EventId.EV_XSJ_LIKE_WORK, this.mLikeImg, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M9(QCircleCommentCountUpdateEvent event) {
        if (event != null && TextUtils.equals(this.mFeed.f398449id.get(), event.getFeedId())) {
            da(event.getCount());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N9(QFSDoublePraiseEvent event) {
        QFSLikeImageView qFSLikeImageView;
        if (TextUtils.equals(event.getFeedId(), this.mFeed.f398449id.get()) && (qFSLikeImageView = this.mLikeImg) != null) {
            qFSLikeImageView.j();
        }
    }

    private final void O9(View v3) {
        ha0.b.h(this.mFeed, !this.mIsLiked, v3.getContext());
        L9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P9(QFSNewContentDetailPicPositionChangeEvent event) {
        if (TextUtils.equals(this.mFeed.f398449id.get(), event.getFeedId())) {
            this.mPicHorizontalPos = event.getPosition();
        }
    }

    private final void Q9() {
        ba();
    }

    private final void R9(UIStateData<List<e30.b>> uiStateData) {
        e30.b bVar;
        Object orNull;
        if (uiStateData == null) {
            QLog.e(getTAG(), 1, "[handleUiStatus] uiStateData == null");
            return;
        }
        int state = uiStateData.getState();
        QLog.d(getTAG(), 1, "[handleUiStatus] state = " + state);
        if (state == 2 || state == 3) {
            List<e30.b> data = uiStateData.getData();
            if (data != null) {
                orNull = CollectionsKt___CollectionsKt.getOrNull(data, 0);
                bVar = (e30.b) orNull;
            } else {
                bVar = null;
            }
            if (bVar != null) {
                J9(bVar.g());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S9(l this$0, UIStateData uIStateData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.R9(uIStateData);
    }

    private final boolean T9(FeedCloudMeta$StFeed stFeed) {
        if (stFeed == null) {
            return false;
        }
        if (h20.c.h() && stFeed.commentCount.get() == this.mCommentCount) {
            return false;
        }
        return true;
    }

    private final boolean U9(FeedCloudMeta$StFeed feed) {
        FeedCloudMeta$StLike feedCloudMeta$StLike;
        boolean z16;
        if (feed != null) {
            feedCloudMeta$StLike = feed.likeInfo;
        } else {
            feedCloudMeta$StLike = null;
        }
        if (feedCloudMeta$StLike == null) {
            return false;
        }
        if (!h20.c.h()) {
            return true;
        }
        if (feedCloudMeta$StLike.status.get() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        int i3 = feedCloudMeta$StLike.count.get();
        if (z16 == this.mIsLiked && i3 == this.mUpdateLikeNum) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W9(QFSLikeImageView qFSLikeImageView, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        qFSLikeImageView.performClick();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X9() {
        broadcastMessage("open_push_mission_panel", this.mFeed.f398449id.get());
    }

    private final void Y9() {
        QCircleLightInteractListPart.g gVar = new QCircleLightInteractListPart.g();
        gVar.f82702b = this.mFeed;
        gVar.f82704d = 0;
        gVar.f82705e = 1;
        broadcastMessage("light_interact_list_show", gVar);
    }

    private final void Z9(View view) {
        if (view != null) {
            view.setFocusable(true);
            view.setFocusableInTouchMode(true);
        }
    }

    private final void aa() {
        if (fb0.a.a("QFSNewContentDetailBottomPart.showCommentInputWindow")) {
            QLog.e(getTAG(), 1, "[showCommentInputWindow] fast double click");
        } else {
            QLog.d(getTAG(), 1, "[showCommentInputWindow]");
            SimpleEventBus.getInstance().dispatchEvent(new QFSCommentInputButNotSendEvent());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ba() {
        QCircleShareInfo c16 = au.c(this.mFeed);
        c16.isEnableShareToMutual = com.tencent.biz.qqcircle.immersive.utils.a.c();
        c16.type = 15;
        c16.isShowBarrageSwitch = false;
        c16.isShareBottomBarrageSwitch = com.tencent.biz.qqcircle.immersive.utils.o.e(this.mFeed);
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.mFeed;
        c16.feed = feedCloudMeta$StFeed;
        c16.feedBlockData = new e30.b(feedCloudMeta$StFeed);
        if (this.mFeed.type.get() == 2) {
            c16.picDownPos = this.mPicHorizontalPos;
        }
        c16.mReportBean = getReportBean();
        broadcastMessage("share_action_show_share_sheet", c16);
    }

    private final void ca() {
        QFSAsyncUtils.executeSub(new f(), new Void[0]);
    }

    private final void da(int commentNum) {
        String str;
        TextView textView = this.mFeedCommentText;
        if (textView == null) {
            QLog.e("QFSNewContentDetailBottomPart", 1, "[updateFeedCommentText] comment text should not be null.");
            return;
        }
        this.mCommentCount = commentNum;
        if (commentNum > 0) {
            str = r.f(commentNum);
        } else {
            str = T;
        }
        textView.setText(str);
    }

    private final void ea(FeedCloudMeta$StFeed data) {
        FeedCloudMeta$StLike feedCloudMeta$StLike;
        boolean z16 = true;
        if (this.mFeedLikeText != null && this.mLikeImg != null && (feedCloudMeta$StLike = data.likeInfo) != null) {
            int i3 = feedCloudMeta$StLike.count.get();
            this.mUpdateLikeNum = i3;
            ga(i3);
            if (data.likeInfo.status.get() != 1) {
                z16 = false;
            }
            this.mIsLiked = z16;
            QFSLikeImageView qFSLikeImageView = this.mLikeImg;
            if (qFSLikeImageView != null) {
                qFSLikeImageView.setDisplayDrawables(RFWApplication.getApplication().getDrawable(R.drawable.ooe), RFWApplication.getApplication().getDrawable(R.drawable.l8f));
            }
            QFSLikeImageView qFSLikeImageView2 = this.mLikeImg;
            if (qFSLikeImageView2 != null) {
                qFSLikeImageView2.setAnimationUrls(QCircleSkinHelper.getInstance().getUrl("https://qq-video.cdn-go.cn/ios/latest/defaultmode/9050/zhengwen/qvideo_skin_feedzhengwen_icon_animation_like.json"), QCircleSkinHelper.getInstance().getUrl("https://qq-video.cdn-go.cn/ios/latest/defaultmode/9050/zhengwen/qvideo_skin_feedzhengwen_icon_animation_cancellike.json"));
            }
            QFSLikeImageView qFSLikeImageView3 = this.mLikeImg;
            if (qFSLikeImageView3 != null) {
                qFSLikeImageView3.setDrawablePadding(cx.a(7.0f));
            }
            QFSLikeImageView qFSLikeImageView4 = this.mLikeImg;
            if (qFSLikeImageView4 != null) {
                qFSLikeImageView4.n(this.mIsLiked);
                return;
            }
            return;
        }
        QLog.d("QFSNewContentDetailBottomPart", 1, "[updateFeedLike] like text and mLikeImg should not be null.");
    }

    private final void ga(int likeNum) {
        TextView textView = this.mFeedLikeText;
        if (textView == null) {
            QLog.d("QFSNewContentDetailBottomPart", 1, "[updateFeedCommentText] like text should not be null.");
            return;
        }
        if (likeNum != 0) {
            if (textView != null) {
                textView.setText(r.f(likeNum));
            }
        } else if (textView != null) {
            textView.setText(S);
        }
    }

    private final void ha(int pushCount) {
        String str;
        TextView textView = this.mFeedPushText;
        if (textView == null) {
            QLog.e("QFSNewContentDetailBottomPart", 1, "[updatePushCount] mFeedPushText == null");
            return;
        }
        if (pushCount > 0) {
            str = r.f(pushCount);
        } else {
            str = U;
        }
        textView.setText(str);
    }

    private final void ia(Object reqInfo) {
        if (reqInfo instanceof QQCircleFeedBase$StFeedBusiReqData) {
            ha(((QQCircleFeedBase$StFeedBusiReqData) reqInfo).pushList.totalClickCount.get());
        }
    }

    private final void initViewModel() {
        QFSGalleryDetailViewModel qFSGalleryDetailViewModel = (QFSGalleryDetailViewModel) getViewModel(QFSGalleryDetailViewModel.class);
        qFSGalleryDetailViewModel.j().observe(getHostFragment(), new Observer() { // from class: com.tencent.biz.qqcircle.immersive.views.mixfeed.piclayerpage.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                l.S9(l.this, (UIStateData) obj);
            }
        });
        this.mViewModel = qFSGalleryDetailViewModel;
    }

    private final void ja(final FeedCloudMeta$StFeed stFeed) {
        if (stFeed == null) {
            return;
        }
        QCircleRecommendImageView qCircleRecommendImageView = this.mPushBtn;
        if (qCircleRecommendImageView != null) {
            qCircleRecommendImageView.setVisibility(0);
            qCircleRecommendImageView.setFeedData(new e30.b(stFeed), 6);
            ca();
            qCircleRecommendImageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.views.mixfeed.piclayerpage.k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    l.la(FeedCloudMeta$StFeed.this, this, view);
                }
            });
        }
        QCircleRocketView qCircleRocketView = this.mRockeyView;
        if (qCircleRocketView != null) {
            qCircleRocketView.setFeedId(stFeed.f398449id.get());
            qCircleRocketView.setPageType(6);
        }
        FeedCloudMeta$StPushList f16 = QCirclePushInfoManager.e().f(stFeed.f398449id.get());
        if (f16 != null) {
            ha(f16.totalClickCount.get());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void la(FeedCloudMeta$StFeed feedCloudMeta$StFeed, l this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FeedCloudMeta$StUser feedCloudMeta$StUser = feedCloudMeta$StFeed.poster;
        if (feedCloudMeta$StUser != null && QCirclePluginUtil.isOwner(feedCloudMeta$StUser.f398463id.get())) {
            this$0.Y9();
        } else {
            QCircleToast.u(com.tencent.biz.qqcircle.immersive.personal.utils.k.d(), 0, true);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void ma(FeedCloudMeta$StFeed stFeed) {
        TextView textView = this.mShareText;
        if (textView == null) {
            QLog.e("QFSNewContentDetailBottomPart", 1, "[updateShareTxt] mShareText");
        } else if (stFeed.share.sharedCount.get() <= 0) {
            textView.setText(R.string.f184893n4);
        } else {
            textView.setText(r.f(stFeed.share.sharedCount.get()));
        }
    }

    @Override // androidx.lifecycle.Observer
    /* renamed from: V9, reason: merged with bridge method [inline-methods] */
    public void onChanged(@Nullable e30.b feedBlockData) {
        if (QLog.isColorLevel()) {
            QLog.d("QFSNewContentDetailBottomPart", 1, "[onChanged] onChanged...");
        }
        if (feedBlockData != null && feedBlockData.g() != null) {
            if (U9(feedBlockData.g())) {
                FeedCloudMeta$StFeed g16 = feedBlockData.g();
                Intrinsics.checkNotNullExpressionValue(g16, "feedBlockData.getSourceData()");
                ea(g16);
            }
            if (T9(feedBlockData.g())) {
                da(feedBlockData.g().commentCount.get());
            }
            ia(feedBlockData.b("DITTO_FEED_BUSI_REQ_DATA"));
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSNewContentDetailBottomPart";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(view, "view");
        int id5 = view.getId();
        if (id5 != R.id.f47251ws && id5 != R.id.f42931l4) {
            if (id5 == R.id.f42951l6) {
                Q9();
            } else if (id5 == R.id.f42941l5) {
                O9(view);
            }
        } else {
            aa();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        RoundCorneredFrameLayout roundCorneredFrameLayout = (RoundCorneredFrameLayout) rootView.findViewById(R.id.f47251ws);
        roundCorneredFrameLayout.setRadius(cx.a(4.0f));
        roundCorneredFrameLayout.a(true);
        roundCorneredFrameLayout.setOnClickListener(this);
        this.mInputRoundCorneredFrameLayout = roundCorneredFrameLayout;
        this.mFeedLikeText = (TextView) rootView.findViewById(R.id.f42981l9);
        this.mFeedCommentText = (TextView) rootView.findViewById(R.id.f42921l3);
        this.mFeedPushText = (TextView) rootView.findViewById(R.id.f43001la);
        final QFSLikeImageView qFSLikeImageView = (QFSLikeImageView) rootView.findViewById(R.id.f42971l8);
        qFSLikeImageView.setItemPreClickListener(new d());
        rootView.findViewById(R.id.f42941l5).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.views.mixfeed.piclayerpage.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                l.W9(QFSLikeImageView.this, view);
            }
        });
        this.mLikeImg = qFSLikeImageView;
        FrameLayout frameLayout = (FrameLayout) rootView.findViewById(R.id.f42931l4);
        frameLayout.setOnClickListener(this);
        this.mCommentFl = frameLayout;
        QCircleRecommendImageView qCircleRecommendImageView = (QCircleRecommendImageView) rootView.findViewById(R.id.f42991l_);
        Z9(qCircleRecommendImageView);
        qCircleRecommendImageView.setPageType(6);
        qCircleRecommendImageView.setEnableCancelPush(true);
        this.mPushBtn = qCircleRecommendImageView;
        this.mRockeyView = (QCircleRocketView) rootView.findViewById(R.id.u26);
        FrameLayout frameLayout2 = (FrameLayout) rootView.findViewById(R.id.f42951l6);
        frameLayout2.setOnClickListener(this);
        this.mShareText = (TextView) rootView.findViewById(R.id.f43011lb);
        this.mShareFl = frameLayout2;
        this.mPushBtnClickDelegate = new e();
        I9();
        if (!this.mInitBean.isForceFromNetwork()) {
            J9(this.mInitBean.getFeed());
        }
        initViewModel();
        K9();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        w20.a.j().removeObserverGlobalState(this.mCenterFeedBlockData, this);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(@Nullable Activity activity) {
        super.onPartPause(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this.eventListener);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        super.onPartResume(activity);
        SimpleEventBus.getInstance().registerReceiver(this.eventListener);
    }
}
