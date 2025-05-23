package com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.ad;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ad.tangram.util.AdExposureChecker;
import com.tencent.ad.tangram.views.feedback.AdFeedbackDialogFragment;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.immersive.feed.ad.ae;
import com.tencent.biz.qqcircle.immersive.feed.ad.x;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.events.QFSPublicAccountScrollStateChangeEvent;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.events.QFSPublicAccountStaggerLifecycleEvent;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.QFSPublicAccountStaggerFragment;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.QFSPublicAccountStaggeredBlockContainer;
import com.tencent.biz.qqcircle.immersive.views.AdCoverVideoView;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.video.rfw.RFWPlayer;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;
import com.tencent.biz.richframework.video.rfw.player.ioc.RFWPlayerIOC;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerLooperListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener;
import com.tencent.biz.richframework.video.rfw.player.stinfo.RFWPlayerReportInfo;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.inject.GdtThirdProcessorProxy;
import com.tencent.gdtad.statistics.GdtOriginalExposureReporter;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.adv.api.MaskAdDisappearListener;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.tuxmetersdk.impl.ruleengine.JsonRuleKey;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import feedcloud.FeedCloudMeta$StFeed;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.gdt.qq_ad_get;

@Metadata(d1 = {"\u0000\u00d8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 \u0085\u00012\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001\u0017B#\u0012\b\u0010\u0082\u0001\u001a\u00030\u0081\u0001\u0012\u0006\u00109\u001a\u000204\u0012\u0006\u0010?\u001a\u00020:\u00a2\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0012\u001a\u00020\u0010H\u0002J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002J\f\u0010\u0015\u001a\u00020\u0005*\u00020\u0014H\u0002J\b\u0010\u0016\u001a\u00020\u0005H\u0002J\b\u0010\u0017\u001a\u00020\u0005H\u0002J\u0010\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\b\u0010\u001b\u001a\u00020\u0010H\u0002J\b\u0010\u001c\u001a\u00020\u0018H\u0014J\b\u0010\u001d\u001a\u00020\u000eH\u0016J\u001a\u0010 \u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001f\u001a\u00020\u000eH\u0014J\n\u0010\"\u001a\u0004\u0018\u00010!H\u0016J\u0006\u0010#\u001a\u00020\u0005J\b\u0010%\u001a\u0004\u0018\u00010$J\u0006\u0010&\u001a\u00020\u0005J\u0006\u0010'\u001a\u00020\u0005J\u0006\u0010(\u001a\u00020\u0005J\u0010\u0010+\u001a\u00020\u00052\u0006\u0010*\u001a\u00020)H\u0004J\b\u0010,\u001a\u00020\u0005H\u0014J\b\u0010-\u001a\u00020\u0005H\u0014J\u0010\u0010/\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u0004H\u0016J$\u00103\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040100j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000401`2H\u0016R\u0017\u00109\u001a\u0002048\u0006\u00a2\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u0017\u0010?\u001a\u00020:8\u0006\u00a2\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>R$\u0010F\u001a\u0004\u0018\u00010$8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\"\u0010M\u001a\u00020\u000e8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u0014\u0010Q\u001a\u00020N8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0018\u0010U\u001a\u0004\u0018\u00010R8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u0018\u0010Y\u001a\u0004\u0018\u00010V8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010XR\u0018\u0010\\\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u001a\u0010b\u001a\u00020]8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b^\u0010_\u001a\u0004\b`\u0010aR\u001a\u0010h\u001a\u00020c8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\bd\u0010e\u001a\u0004\bf\u0010gR\u0014\u0010l\u001a\u00020i8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bj\u0010kR\u0014\u0010p\u001a\u00020m8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bn\u0010oR\u0014\u0010s\u001a\u00020q8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bH\u0010rR\u0014\u0010w\u001a\u00020t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bu\u0010vR\u0014\u0010y\u001a\u00020c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bx\u0010eR\u0014\u0010}\u001a\u00020z8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b{\u0010|R\u0017\u0010\u0080\u0001\u001a\u00020~8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u007f\u0010u\u00a8\u0006\u0086\u0001"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/ad/QFSPublicAccountStaggeredAdItemView;", "Lcom/tencent/biz/qqcircle/widgets/QCircleBaseWidgetView;", "Le30/b;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "P0", "J0", "Lfeedcloud/FeedCloudMeta$StFeed;", "feed", "I0", "L0", "O0", "G0", "", "E0", "", "x0", "Q0", "F0", "Lcom/tencent/biz/richframework/video/rfw/player/RFWPlayerOptions;", "N0", ICustomDataEditor.STRING_ARRAY_PARAM_1, "a", "", AppConstants.Key.KEY_QZONE_VIDEO_URL, "b1", "S0", "getLogTag", "getLayoutId", "objData", "position", "bindData", "Lcom/tencent/biz/qqcircle/beans/QCircleExtraTypeInfo;", "getQCircleExtraTypeInfo", "X0", "Lcom/tencent/gdtad/aditem/GdtAd;", "z0", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/view/View;", "view", "V0", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;", "d", "Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;", "getInitBean", "()Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;", "initBean", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/presentation/a;", "e", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/presentation/a;", "getOperator", "()Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/presentation/a;", JsonRuleKey.OPERATOR, "f", "Lcom/tencent/gdtad/aditem/GdtAd;", "D0", "()Lcom/tencent/gdtad/aditem/GdtAd;", "setGdtAd", "(Lcom/tencent/gdtad/aditem/GdtAd;)V", "gdtAd", tl.h.F, "I", "A0", "()I", "setAdPosition", "(I)V", "adPosition", "Lcom/tencent/gdtad/inject/GdtThirdProcessorProxy;", "i", "Lcom/tencent/gdtad/inject/GdtThirdProcessorProxy;", "mProcessorProxy", "Lcom/tencent/ad/tangram/util/AdExposureChecker$ExposureCallback;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/ad/tangram/util/AdExposureChecker$ExposureCallback;", "mExposureCallback", "Lcom/tencent/ad/tangram/util/AdExposureChecker;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/ad/tangram/util/AdExposureChecker;", "mExposureChecker", "D", "Lfeedcloud/FeedCloudMeta$StFeed;", "currentFeed", "Landroid/widget/RelativeLayout;", "E", "Landroid/widget/RelativeLayout;", "B0", "()Landroid/widget/RelativeLayout;", "feedCoverContainer", "Landroid/widget/ImageView;", UserInfo.SEX_FEMALE, "Landroid/widget/ImageView;", "C0", "()Landroid/widget/ImageView;", "feedCoverView", "Lcom/tencent/biz/qqcircle/immersive/views/AdCoverVideoView;", "G", "Lcom/tencent/biz/qqcircle/immersive/views/AdCoverVideoView;", "feedCoverVideoView", "Lcom/tencent/biz/qqcircle/widgets/QCircleAsyncTextView;", "H", "Lcom/tencent/biz/qqcircle/widgets/QCircleAsyncTextView;", "titleView", "Lcom/tencent/biz/qqcircle/widgets/QCircleAvatarView;", "Lcom/tencent/biz/qqcircle/widgets/QCircleAvatarView;", "avatarView", "Landroid/widget/TextView;", "J", "Landroid/widget/TextView;", "userNameText", "K", "adFeedBackView", "Lcom/tencent/ad/tangram/views/feedback/AdFeedbackDialogFragment$Listener;", "L", "Lcom/tencent/ad/tangram/views/feedback/AdFeedbackDialogFragment$Listener;", "feedBackListener", "", "M", "mExposeTime", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/presentation/a;)V", "N", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public class QFSPublicAccountStaggeredAdItemView extends QCircleBaseWidgetView<e30.b> implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private AdExposureChecker mExposureChecker;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private FeedCloudMeta$StFeed currentFeed;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final RelativeLayout feedCoverContainer;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final ImageView feedCoverView;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final AdCoverVideoView feedCoverVideoView;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final QCircleAsyncTextView titleView;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final QCircleAvatarView avatarView;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final TextView userNameText;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final ImageView adFeedBackView;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final AdFeedbackDialogFragment.Listener feedBackListener;

    /* renamed from: M, reason: from kotlin metadata */
    private long mExposeTime;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QCircleInitBean initBean;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.a operator;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GdtAd gdtAd;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int adPosition;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GdtThirdProcessorProxy mProcessorProxy;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AdExposureChecker.ExposureCallback mExposureCallback;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\f\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/ad/QFSPublicAccountStaggeredAdItemView$b", "Lcom/tencent/biz/richframework/video/rfw/player/ioc/RFWPlayerIOC;", "", AppConstants.Key.COLUMN_IS_VALID, "Lcom/tencent/biz/richframework/video/rfw/player/stinfo/RFWPlayerReportInfo;", "getBusinessReportInfo", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class b extends RFWPlayerIOC {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ FeedCloudMeta$StFeed f86741e;

        b(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
            this.f86741e = feedCloudMeta$StFeed;
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.ioc.RFWPlayerIOC
        @NotNull
        public RFWPlayerReportInfo<?> getBusinessReportInfo() {
            RFWPlayerReportInfo<e30.b> m3 = gb0.b.m(new e30.b(this.f86741e).o("KEY_RFW_VIDEO_FEED_POI", Integer.valueOf(QFSPublicAccountStaggeredAdItemView.this.getAdPosition())));
            Intrinsics.checkNotNullExpressionValue(m3, "coverToReportInfo(\n     \u2026sition)\n                )");
            return m3;
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.ioc.RFWPlayerIOC
        public boolean isValid() {
            return QFSPublicAccountStaggeredAdItemView.this.isAttachedToWindow();
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/ad/QFSPublicAccountStaggeredAdItemView$c", "Lcom/tencent/biz/richframework/video/rfw/player/listener/IRFWPlayerPrepareListener;", "Lcom/tencent/biz/richframework/video/rfw/RFWPlayer;", "player", "", "onVideoPrepared", "onFirstFrameRendered", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class c implements IRFWPlayerPrepareListener {
        c() {
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener
        public void onFirstFrameRendered(@NotNull RFWPlayer player) {
            Intrinsics.checkNotNullParameter(player, "player");
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener
        public void onVideoPrepared(@NotNull RFWPlayer player) {
            Intrinsics.checkNotNullParameter(player, "player");
            if (!h.f86763a.e(QFSPublicAccountStaggeredAdItemView.this)) {
                QLog.e("QFSPublicAccountStaggeredAdItemView", 1, "not in screen, cancel play");
            } else {
                QLog.d("QFSPublicAccountStaggeredAdItemView", 2, "onVideoPrepared");
                QFSPublicAccountStaggeredAdItemView.this.a1();
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/ad/QFSPublicAccountStaggeredAdItemView$d", "Lcom/tencent/biz/richframework/video/rfw/player/listener/IRFWPlayerLooperListener;", "", "onVideoLoopStart", "onVideoLoopEnd", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class d implements IRFWPlayerLooperListener {
        d() {
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerLooperListener
        public void onVideoLoopEnd() {
            QLog.d("QFSPublicAccountStaggeredAdItemView", 2, "onVideoLoopEnd");
            com.tencent.biz.qqcircle.richframework.widget.video.a.c().i(QFSPublicAccountStaggeredAdItemView.this.getAdPosition());
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerLooperListener
        public void onVideoLoopStart() {
            QLog.d("QFSPublicAccountStaggeredAdItemView", 2, "onVideoLoopStart");
            com.tencent.biz.qqcircle.richframework.widget.video.a.c().g(QFSPublicAccountStaggeredAdItemView.this.getAdPosition());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QFSPublicAccountStaggeredAdItemView(@NotNull Context context, @NotNull QCircleInitBean initBean, @NotNull com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.a operator) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        Intrinsics.checkNotNullParameter(operator, "operator");
        this.initBean = initBean;
        this.operator = operator;
        this.mProcessorProxy = new GdtThirdProcessorProxy();
        View findViewById = findViewById(R.id.u_x);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.cover_image_container)");
        this.feedCoverContainer = (RelativeLayout) findViewById;
        View findViewById2 = findViewById(R.id.f164921bb4);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.cover_image)");
        this.feedCoverView = (ImageView) findViewById2;
        View findViewById3 = findViewById(R.id.uaa);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.cover_video)");
        this.feedCoverVideoView = (AdCoverVideoView) findViewById3;
        View findViewById4 = findViewById(R.id.f166992jq2);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.title_text)");
        this.titleView = (QCircleAsyncTextView) findViewById4;
        View findViewById5 = findViewById(R.id.l_k);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.avatar_image)");
        this.avatarView = (QCircleAvatarView) findViewById5;
        View findViewById6 = findViewById(R.id.f115616wi);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.user_name_text)");
        this.userNameText = (TextView) findViewById6;
        View findViewById7 = findViewById(R.id.f164904u80);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.content_ad_feed_back)");
        this.adFeedBackView = (ImageView) findViewById7;
        this.feedBackListener = new AdFeedbackDialogFragment.Listener() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.ad.r
            @Override // com.tencent.ad.tangram.views.feedback.AdFeedbackDialogFragment.Listener
            public final void onResult(AdFeedbackDialogFragment.Result result) {
                QFSPublicAccountStaggeredAdItemView.y0(QFSPublicAccountStaggeredAdItemView.this, result);
            }
        };
    }

    private final int E0() {
        StaggeredGridLayoutManager.LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2 = getLayoutParams();
        if (layoutParams2 instanceof StaggeredGridLayoutManager.LayoutParams) {
            layoutParams = (StaggeredGridLayoutManager.LayoutParams) layoutParams2;
        } else {
            layoutParams = null;
        }
        if (layoutParams != null) {
            return layoutParams.getSpanIndex();
        }
        return -1;
    }

    private final void F0(FeedCloudMeta$StFeed feed) {
        String str;
        if (!x0() || !isAttachedToWindow()) {
            return;
        }
        QLog.d("QFSPublicAccountStaggeredAdItemView", 1, "initAndStartPlayer");
        GdtAd gdtAd = this.gdtAd;
        String str2 = null;
        if (gdtAd != null) {
            str = gdtAd.getVideoUrl();
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            QLog.w("QFSPublicAccountStaggeredAdItemView", 1, "initAndStartPlayer error: ad video url is null");
            return;
        }
        this.feedCoverVideoView.setData(feed, this.adPosition);
        AdCoverVideoView adCoverVideoView = this.feedCoverVideoView;
        GdtAd gdtAd2 = this.gdtAd;
        if (gdtAd2 != null) {
            str2 = gdtAd2.getVideoReportUrl();
        }
        adCoverVideoView.setAdVideoReportUrl(str2);
        RFWPlayerOptions playerOptions = RFWPlayerOptions.obtain(QCircleHostConstants._SceneID.QQ_CIRCLE_VIDEO());
        playerOptions.setFromType(9);
        playerOptions.setPlayUrl(str);
        playerOptions.setFileId(feed.video.fileId.get());
        playerOptions.setStVideo(gb0.b.k(feed.video));
        playerOptions.setStartOffset(0L);
        playerOptions.setPlayIOC(new b(feed));
        Intrinsics.checkNotNullExpressionValue(playerOptions, "playerOptions");
        N0(playerOptions);
        this.feedCoverVideoView.loadPlayOptions(playerOptions);
    }

    private final void G0(final FeedCloudMeta$StFeed feed) {
        this.adFeedBackView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.ad.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QFSPublicAccountStaggeredAdItemView.H0(QFSPublicAccountStaggeredAdItemView.this, feed, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H0(QFSPublicAccountStaggeredAdItemView this$0, FeedCloudMeta$StFeed feed, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(feed, "$feed");
        x.c(this$0, this$0.gdtAd, feed, this$0.feedBackListener, 0);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void I0(FeedCloudMeta$StFeed feed) {
        Integer num;
        if (com.tencent.biz.qqcircle.immersive.feed.ad.u.h(this.gdtAd) && this.adPosition == 0) {
            QLog.d("QFSPublicAccountStaggeredAdItemView", 1, "mask ad, cancel init normal cover");
            return;
        }
        h hVar = h.f86763a;
        GdtAd gdtAd = this.gdtAd;
        if (gdtAd != null) {
            num = Integer.valueOf(gdtAd.getInnerShowType());
        } else {
            num = null;
        }
        Pair<Integer, Integer> a16 = hVar.a(num);
        int a17 = com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.o.INSTANCE.a();
        int intValue = (a16.getSecond().intValue() * a17) / a16.getFirst().intValue();
        RelativeLayout relativeLayout = this.feedCoverContainer;
        ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
        layoutParams.height = intValue;
        relativeLayout.setLayoutParams(layoutParams);
        Option failedDrawableId = Option.obtain().setUrl(feed.cover.picUrl.get()).setTargetView(this.feedCoverView).setFromPreLoad(false).setPredecode(true).setSupportRecycler(true).setRequestWidth(a17).setRequestHeight(intValue).setLoadingDrawableColor(QCircleSkinHelper.getInstance().getColor(R.color.qvideo_skin_color_tag_selected)).setFailedDrawableId(R.drawable.ojc);
        failedDrawableId.setPreferDecodeFormat(DecodeFormat.PREFER_RGB_565);
        q50.b.e().q(failedDrawableId, false);
        QCircleFeedPicLoader.g().loadImage(failedDrawableId);
    }

    private final void J0() {
        final qq_ad_get.QQAdGetRsp.AdInfo adInfo;
        GdtAd gdtAd = this.gdtAd;
        if (gdtAd != null) {
            adInfo = gdtAd.info;
        } else {
            adInfo = null;
        }
        if (adInfo == null) {
            QLog.e("QFSPublicAccountStaggeredAdItemView", 1, "origin expose cancel, adInfo is null");
            return;
        }
        this.mExposureChecker = new AdExposureChecker(gdtAd, new WeakReference(this));
        this.mExposureCallback = new AdExposureChecker.ExposureCallback() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.ad.q
            @Override // com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback
            public final void onExposure(WeakReference weakReference) {
                QFSPublicAccountStaggeredAdItemView.K0(qq_ad_get.QQAdGetRsp.AdInfo.this, this, weakReference);
            }
        };
        AdExposureChecker adExposureChecker = this.mExposureChecker;
        if (adExposureChecker != null) {
            adExposureChecker.setCallback(new WeakReference<>(this.mExposureCallback));
        }
        AdExposureChecker adExposureChecker2 = this.mExposureChecker;
        if (adExposureChecker2 != null) {
            adExposureChecker2.startCheck();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K0(qq_ad_get.QQAdGetRsp.AdInfo adInfo, QFSPublicAccountStaggeredAdItemView this$0, WeakReference weakReference) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.biz.qqcircle.immersive.utils.d dVar = com.tencent.biz.qqcircle.immersive.utils.d.f90201a;
        String str = adInfo.report_info.exposure_url.get();
        Intrinsics.checkNotNullExpressionValue(str, "adInfo.report_info.exposure_url.get()");
        dVar.d(str);
        this$0.mProcessorProxy.c2sReportAsync(0, 4, adInfo);
        GdtAd gdtAd = this$0.gdtAd;
        if (gdtAd != null) {
            g.f86760a.j(gdtAd.getAId());
        }
    }

    private final void L0(FeedCloudMeta$StFeed feed) {
        boolean z16;
        String str = feed.content.get();
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            this.titleView.setPreloadParserInfo(uc0.a.b(feed));
            this.titleView.setNeedSpecialAreaBold(false);
            this.titleView.setSpecialClickAreaColor(R.color.qvideo_skin_color_text_primary);
            this.titleView.setText(str);
        }
        this.titleView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.ad.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QFSPublicAccountStaggeredAdItemView.M0(QFSPublicAccountStaggeredAdItemView.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M0(QFSPublicAccountStaggeredAdItemView this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.V0(it);
        EventCollector.getInstance().onViewClicked(it);
    }

    private final void N0(RFWPlayerOptions rFWPlayerOptions) {
        if (S0()) {
            rFWPlayerOptions.getListenerSet().addPrepareListeners(new c());
        }
        rFWPlayerOptions.getListenerSet().addLooperListeners(new d());
    }

    private final void O0(FeedCloudMeta$StFeed feed) {
        int dpToPx = ImmersiveUtils.dpToPx(20.0f);
        this.avatarView.setAvatar(feed.poster, new Size(dpToPx, dpToPx));
        this.avatarView.i();
        this.userNameText.setText(feed.poster.nick.get());
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00a8 A[Catch: all -> 0x003a, TRY_LEAVE, TryCatch #0 {all -> 0x003a, blocks: (B:54:0x0023, B:56:0x0027, B:58:0x002b, B:60:0x0031, B:15:0x0040, B:17:0x0044, B:19:0x0048, B:21:0x004e, B:23:0x0058, B:25:0x005c, B:27:0x0060, B:29:0x0065, B:31:0x0069, B:33:0x006d, B:35:0x0072, B:37:0x0076, B:39:0x007a, B:41:0x0080, B:42:0x00a1, B:44:0x00a8), top: B:53:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void P0() {
        boolean z16;
        qq_ad_get.QQAdGetRsp.AdInfo adInfo;
        PBStringField pBStringField;
        String str;
        String S;
        GdtAd gdtAd;
        qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo reportInfo;
        PBStringField pBStringField2;
        String str2;
        qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo reportInfo2;
        PBStringField pBStringField3;
        qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo reportInfo3;
        PBStringField pBStringField4;
        qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo reportInfo4;
        PBStringField pBStringField5;
        String str3;
        GdtAd gdtAd2 = this.gdtAd;
        if (gdtAd2 != null) {
            if (gdtAd2 != null && !gdtAd2.isValid()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                GdtAd gdtAd3 = this.gdtAd;
                String str4 = null;
                if (gdtAd3 != null) {
                    adInfo = gdtAd3.info;
                } else {
                    adInfo = null;
                }
                if (adInfo != null) {
                    try {
                        qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo reportInfo5 = adInfo.report_info;
                        if (reportInfo5 != null && (pBStringField = reportInfo5.original_exposure_url) != null && (str = pBStringField.get()) != null) {
                            S = com.tencent.biz.qqcircle.immersive.utils.j.f90213a.S(str, this.adPosition);
                            if (adInfo != null && (reportInfo4 = adInfo.report_info) != null && (pBStringField5 = reportInfo4.exposure_url) != null && (str3 = pBStringField5.get()) != null) {
                                str4 = com.tencent.biz.qqcircle.immersive.utils.j.f90213a.S(str3, this.adPosition);
                            }
                            if (adInfo != null && (reportInfo3 = adInfo.report_info) != null && (pBStringField4 = reportInfo3.original_exposure_url) != null) {
                                pBStringField4.set(S);
                            }
                            if (adInfo != null && (reportInfo2 = adInfo.report_info) != null && (pBStringField3 = reportInfo2.exposure_url) != null) {
                                pBStringField3.set(str4);
                            }
                            if (adInfo != null && (reportInfo = adInfo.report_info) != null && (pBStringField2 = reportInfo.original_exposure_url) != null && (str2 = pBStringField2.get()) != null) {
                                com.tencent.biz.qqcircle.immersive.utils.d dVar = com.tencent.biz.qqcircle.immersive.utils.d.f90201a;
                                String replaceUrlMacros = GdtOriginalExposureReporter.replaceUrlMacros(str2, adInfo.product_type.get(), getContext(), adInfo.app_info.app_package_name.get());
                                Intrinsics.checkNotNullExpressionValue(replaceUrlMacros, "replaceUrlMacros(\n      \u2026                        )");
                                dVar.d(replaceUrlMacros);
                            }
                            J0();
                            gdtAd = this.gdtAd;
                            if (gdtAd == null) {
                                com.tencent.biz.qqcircle.immersive.utils.d.f90201a.f(gdtAd, 0, this.adPosition);
                                return;
                            }
                            return;
                        }
                    } catch (Throwable th5) {
                        QLog.i("QFSPublicAccountStaggeredAdItemView", 1, "reportAdExpose failed, error is = ", th5);
                        return;
                    }
                }
                S = null;
                if (adInfo != null) {
                    str4 = com.tencent.biz.qqcircle.immersive.utils.j.f90213a.S(str3, this.adPosition);
                }
                if (adInfo != null) {
                    pBStringField4.set(S);
                }
                if (adInfo != null) {
                    pBStringField3.set(str4);
                }
                if (adInfo != null) {
                    com.tencent.biz.qqcircle.immersive.utils.d dVar2 = com.tencent.biz.qqcircle.immersive.utils.d.f90201a;
                    String replaceUrlMacros2 = GdtOriginalExposureReporter.replaceUrlMacros(str2, adInfo.product_type.get(), getContext(), adInfo.app_info.app_package_name.get());
                    Intrinsics.checkNotNullExpressionValue(replaceUrlMacros2, "replaceUrlMacros(\n      \u2026                        )");
                    dVar2.d(replaceUrlMacros2);
                }
                J0();
                gdtAd = this.gdtAd;
                if (gdtAd == null) {
                }
            }
        }
        QLog.e("QFSPublicAccountStaggeredAdItemView", 1, "expose cancel, adInfo is null");
    }

    private final boolean Q0() {
        String str;
        GdtAd gdtAd = this.gdtAd;
        if (gdtAd != null) {
            if (gdtAd != null) {
                str = gdtAd.getVideoUrl();
            } else {
                str = null;
            }
            if (!TextUtils.isEmpty(str)) {
                return true;
            }
        }
        return false;
    }

    private final boolean S0() {
        QFSPublicAccountStaggeredBlockContainer qFSPublicAccountStaggeredBlockContainer;
        QCircleBaseFragment qCircleBaseFragment = getQCircleBaseFragment();
        if (!(qCircleBaseFragment instanceof QFSPublicAccountStaggerFragment)) {
            return true;
        }
        QFSPublicAccountStaggerFragment qFSPublicAccountStaggerFragment = (QFSPublicAccountStaggerFragment) qCircleBaseFragment;
        if (qFSPublicAccountStaggerFragment.getView() == null) {
            return false;
        }
        View view = qFSPublicAccountStaggerFragment.getView();
        if (view != null) {
            qFSPublicAccountStaggeredBlockContainer = (QFSPublicAccountStaggeredBlockContainer) view.findViewById(R.id.f34310yt);
        } else {
            qFSPublicAccountStaggeredBlockContainer = null;
        }
        if (qFSPublicAccountStaggeredBlockContainer != null && qFSPublicAccountStaggeredBlockContainer.getRecyclerView() != null && qFSPublicAccountStaggeredBlockContainer.getRecyclerView().getScrollState() == 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T0(QFSPublicAccountStaggeredAdItemView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this$0.currentFeed;
        if (feedCloudMeta$StFeed != null) {
            this$0.F0(feedCloudMeta$StFeed);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U0(QFSPublicAccountStaggeredAdItemView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.a();
        this$0.feedCoverVideoView.r0(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W0(QFSPublicAccountStaggeredAdItemView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.a1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y0(QFSPublicAccountStaggeredAdItemView this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.biz.qqcircle.richframework.widget.video.a.c().n(this$0.adPosition, true);
        v.f86780a.k(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z0(QFSPublicAccountStaggeredAdItemView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.P0();
    }

    private final void a() {
        QLog.d("QFSPublicAccountStaggeredAdItemView", 1, "release player");
        this.feedCoverVideoView.release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a1() {
        Integer num;
        this.feedCoverVideoView.r0(true);
        h hVar = h.f86763a;
        GdtAd gdtAd = this.gdtAd;
        if (gdtAd != null) {
            num = Integer.valueOf(gdtAd.getInnerShowType());
        } else {
            num = null;
        }
        if (hVar.d(num) && Intrinsics.areEqual(v.f86780a.c(), Boolean.TRUE)) {
            com.tencent.biz.qqcircle.richframework.widget.video.a.c().h(this.adPosition);
        } else {
            com.tencent.biz.qqcircle.richframework.widget.video.a.c().n(this.adPosition, true);
        }
    }

    private final void b1(String videoUrl) {
        if (S0() && this.feedCoverVideoView.p0() != null && !TextUtils.equals(videoUrl, this.feedCoverVideoView.p0().getPlayUrl())) {
            a();
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.currentFeed;
            if (feedCloudMeta$StFeed != null) {
                F0(feedCloudMeta$StFeed);
            }
            QLog.d("QFSPublicAccountStaggeredAdItemView", 1, "updateExistCoverVideo position:" + this.adPosition);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w0(QFSPublicAccountStaggeredAdItemView this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.V0(it);
        EventCollector.getInstance().onViewClicked(it);
    }

    private final boolean x0() {
        boolean z16;
        boolean z17;
        GdtAd gdtAd = this.gdtAd;
        if (gdtAd != null && h.f86763a.c(gdtAd)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (NetworkUtil.isWifiConnected(getContext())) {
            if (z16) {
                return true;
            }
            GdtAd gdtAd2 = this.gdtAd;
            if (gdtAd2 != null && !gdtAd2.getVideoNoAutoPlay()) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y0(QFSPublicAccountStaggeredAdItemView this$0, AdFeedbackDialogFragment.Result result) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.action == 3) {
            this$0.operator.removeAll(new Function1<e30.b, Boolean>() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.ad.QFSPublicAccountStaggeredAdItemView$feedBackListener$1$1
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull e30.b it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Boolean.valueOf(it.g().feedType.get() == 4);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: A0, reason: from getter */
    public final int getAdPosition() {
        return this.adPosition;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: B0, reason: from getter */
    public final RelativeLayout getFeedCoverContainer() {
        return this.feedCoverContainer;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: C0, reason: from getter */
    public final ImageView getFeedCoverView() {
        return this.feedCoverView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: D0, reason: from getter */
    public final GdtAd getGdtAd() {
        return this.gdtAd;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void V0(@NotNull View view) {
        Integer num;
        Intrinsics.checkNotNullParameter(view, "view");
        com.tencent.biz.qqcircle.immersive.utils.j.f90213a.K(this.gdtAd, view, this.adPosition, getQCircleExtraTypeInfo(), 99);
        int i3 = this.adPosition + 1;
        int E0 = E0() + 1;
        g gVar = g.f86760a;
        FeedCloudMeta$StFeed g16 = getData().g();
        Intrinsics.checkNotNullExpressionValue(g16, "data.sourceData");
        h hVar = h.f86763a;
        GdtAd gdtAd = this.gdtAd;
        if (gdtAd != null) {
            num = Integer.valueOf(gdtAd.getInnerShowType());
        } else {
            num = null;
        }
        gVar.f(g16, i3, E0, hVar.b(num));
        com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.report.l lVar = com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.report.l.f87082a;
        e30.b data = getData();
        Intrinsics.checkNotNullExpressionValue(data, "data");
        com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.report.l.i(lVar, i3, E0, data, this.initBean, false, 16, null);
    }

    public final void X0() {
        boolean contains;
        String traceId;
        String str = null;
        Activity activity = null;
        if (com.tencent.biz.qqcircle.immersive.feed.ad.u.h(this.gdtAd)) {
            if (getParent() != null && getParent().getParent() != null) {
                this.mExposeTime = System.currentTimeMillis();
                v vVar = v.f86780a;
                Context context = getContext();
                if (context instanceof Activity) {
                    activity = (Activity) context;
                }
                ViewParent parent = getParent().getParent();
                Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
                vVar.h(activity, (ViewGroup) parent, this.gdtAd);
                vVar.g(new MaskAdDisappearListener() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.ad.m
                    @Override // com.tencent.mobileqq.vas.adv.api.MaskAdDisappearListener
                    public final void sendMaskAdDisappear(String str2) {
                        QFSPublicAccountStaggeredAdItemView.Y0(QFSPublicAccountStaggeredAdItemView.this, str2);
                    }
                });
                return;
            }
            QLog.e("QFSPublicAccountStaggeredAdItemView", 1, "viewGroup is null, cancel show mask");
            return;
        }
        g gVar = g.f86760a;
        HashSet<String> e16 = gVar.e();
        GdtAd gdtAd = this.gdtAd;
        if (gdtAd != null) {
            str = gdtAd.getTraceId();
        }
        contains = CollectionsKt___CollectionsKt.contains(e16, str);
        if (contains) {
            return;
        }
        this.mExposeTime = System.currentTimeMillis();
        GdtAd gdtAd2 = this.gdtAd;
        if (gdtAd2 != null && (traceId = gdtAd2.getTraceId()) != null) {
            gVar.e().add(traceId);
        }
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.ad.n
            @Override // java.lang.Runnable
            public final void run() {
                QFSPublicAccountStaggeredAdItemView.Z0(QFSPublicAccountStaggeredAdItemView.this);
            }
        });
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QFSPublicAccountStaggerLifecycleEvent.class, QFSPublicAccountScrollStateChangeEvent.class);
        Intrinsics.checkNotNull(arrayListOf, "null cannot be cast to non-null type java.util.ArrayList<java.lang.Class<com.tencent.biz.richframework.eventbus.SimpleBaseEvent>>{ kotlin.collections.TypeAliasesKt.ArrayList<java.lang.Class<com.tencent.biz.richframework.eventbus.SimpleBaseEvent>> }");
        return arrayListOf;
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.go_;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    @NotNull
    public String getLogTag() {
        return "QFSPublicAccountStaggeredAdItemView";
    }

    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    @Nullable
    public QCircleExtraTypeInfo getQCircleExtraTypeInfo() {
        Serializable extraTypeInfo = getExtraTypeInfo();
        if (extraTypeInfo instanceof QCircleExtraTypeInfo) {
            return (QCircleExtraTypeInfo) extraTypeInfo;
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!Q0()) {
            return;
        }
        SimpleEventBus.getInstance().registerReceiver(this);
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.ad.l
            @Override // java.lang.Runnable
            public final void run() {
                QFSPublicAccountStaggeredAdItemView.T0(QFSPublicAccountStaggeredAdItemView.this);
            }
        });
    }

    public final void onDestroy() {
        AdExposureChecker adExposureChecker = this.mExposureChecker;
        if (adExposureChecker != null) {
            adExposureChecker.setCallback(null);
            adExposureChecker.onActivityDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        String str;
        super.onDetachedFromWindow();
        com.tencent.biz.qqcircle.immersive.utils.d dVar = com.tencent.biz.qqcircle.immersive.utils.d.f90201a;
        GdtAd gdtAd = this.gdtAd;
        if (gdtAd != null) {
            str = gdtAd.getAdSelectedUrl();
        } else {
            str = null;
        }
        dVar.j(str, this.mExposeTime, System.currentTimeMillis());
        if (!Q0()) {
            return;
        }
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.ad.i
            @Override // java.lang.Runnable
            public final void run() {
                QFSPublicAccountStaggeredAdItemView.U0(QFSPublicAccountStaggeredAdItemView.this);
            }
        });
    }

    public final void onPause() {
        String str;
        AdExposureChecker adExposureChecker = this.mExposureChecker;
        if (adExposureChecker != null) {
            adExposureChecker.onActivityPause();
        }
        com.tencent.biz.qqcircle.immersive.utils.d dVar = com.tencent.biz.qqcircle.immersive.utils.d.f90201a;
        GdtAd gdtAd = this.gdtAd;
        if (gdtAd != null) {
            str = gdtAd.getAdSelectedUrl();
        } else {
            str = null;
        }
        dVar.j(str, this.mExposeTime, System.currentTimeMillis());
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@NotNull SimpleBaseEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof QFSPublicAccountStaggerLifecycleEvent) {
            QFSPublicAccountStaggerLifecycleEvent qFSPublicAccountStaggerLifecycleEvent = (QFSPublicAccountStaggerLifecycleEvent) event;
            if (qFSPublicAccountStaggerLifecycleEvent.getStatus() == 1 && x0()) {
                if (Intrinsics.areEqual(v.f86780a.c(), Boolean.TRUE)) {
                    return;
                }
                com.tencent.biz.qqcircle.richframework.widget.video.a.c().n(this.adPosition, false);
                return;
            } else if (qFSPublicAccountStaggerLifecycleEvent.getStatus() == 2) {
                com.tencent.biz.qqcircle.richframework.widget.video.a.c().h(this.adPosition);
                return;
            } else {
                if (qFSPublicAccountStaggerLifecycleEvent.getStatus() == 3) {
                    X0();
                    a1();
                    onResume();
                    return;
                }
                return;
            }
        }
        if ((event instanceof QFSPublicAccountScrollStateChangeEvent) && ((QFSPublicAccountScrollStateChangeEvent) event).getStatus() == 1 && x0()) {
            QLog.d("QFSPublicAccountStaggeredAdItemView", 4, "onReceiveEvent EVENT_SCROLL_STATE_IDLE && isAttachedToWindow");
            RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.ad.k
                @Override // java.lang.Runnable
                public final void run() {
                    QFSPublicAccountStaggeredAdItemView.W0(QFSPublicAccountStaggeredAdItemView.this);
                }
            });
        }
    }

    public final void onResume() {
        AdExposureChecker adExposureChecker = this.mExposureChecker;
        if (adExposureChecker != null) {
            adExposureChecker.onActivityResume();
        }
        if (this.mExposeTime != 0) {
            this.mExposeTime = System.currentTimeMillis();
        }
    }

    @Nullable
    public final GdtAd z0() {
        return this.gdtAd;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public void bindData(@Nullable e30.b objData, int position) {
        String videoUrl;
        if (objData == null) {
            QLog.e("QFSPublicAccountStaggeredAdItemView", 1, "bindData failed, objData is null");
            return;
        }
        FeedCloudMeta$StFeed c16 = com.tencent.biz.qqcircle.immersive.feed.ad.u.c(objData);
        if (c16 == null) {
            QLog.e("QFSPublicAccountStaggeredAdItemView", 1, "bindData failed, feed is null");
            return;
        }
        this.gdtAd = new GdtAd(com.tencent.biz.qqcircle.immersive.feed.ad.u.e(objData));
        this.adPosition = position;
        I0(c16);
        L0(c16);
        O0(c16);
        G0(c16);
        this.currentFeed = c16;
        setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.ad.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QFSPublicAccountStaggeredAdItemView.w0(QFSPublicAccountStaggeredAdItemView.this, view);
            }
        });
        GdtAd gdtAd = this.gdtAd;
        if (gdtAd != null && (videoUrl = gdtAd.getVideoUrl()) != null) {
            b1(videoUrl);
        }
        setExtraTypeInfo(ae.b(c16, position));
    }
}
