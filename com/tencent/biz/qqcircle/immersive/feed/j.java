package com.tencent.biz.qqcircle.immersive.feed;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants;
import com.tencent.biz.qqcircle.events.QCircleConfigChangeEvent;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.events.QCirclePanelStateEvent;
import com.tencent.biz.qqcircle.immersive.utils.bi;
import com.tencent.biz.qqcircle.immersive.views.QFSVideoView;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.widgets.RoundFrameLayout;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.video.rfw.RFWPlayer;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;
import com.tencent.biz.richframework.video.rfw.player.ioc.RFWPlayerIOC;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerLifeCycle;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSdkInitListener;
import com.tencent.biz.richframework.video.rfw.player.videopreload.RFWVideoPreloadManager;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.libra.request.Option;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.auto.engine.event.ASEngineTabStatusEvent;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.helper.HostUIHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.qqnt.chats.view.shimmer.Shimmer;
import com.tencent.qqnt.chats.view.shimmer.ShimmerFrameLayout;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qqcircle.QQCircleDitto$StCircleDittoDataNew;
import qqcircle.QQCircleDitto$StItemInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u0087\u00012\u00020\u0001:\u0004\u0088\u0001\u0089\u0001B\t\u00a2\u0006\u0006\b\u0085\u0001\u0010\u0086\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0003J\b\u0010\f\u001a\u00020\u0002H\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002J\b\u0010\u000e\u001a\u00020\u0002H\u0002J\u0012\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0002J\u0010\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0018\u001a\u00020\u0002H\u0002J\u0010\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\b\u0010\u001c\u001a\u00020\u000fH\u0002J\u0010\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\u0010\u0010 \u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\"\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u000fH\u0002J\u0010\u0010%\u001a\u00020\u00022\u0006\u0010$\u001a\u00020#H\u0002J\b\u0010&\u001a\u00020\u0002H\u0002J\b\u0010'\u001a\u00020\u0002H\u0002J\b\u0010(\u001a\u00020\u0002H\u0002J\b\u0010)\u001a\u00020\u0002H\u0002J\u0018\u0010,\u001a\u00020\u00022\u0006\u0010*\u001a\u00020\u00122\u0006\u0010+\u001a\u00020\u0012H\u0002J\b\u0010-\u001a\u00020\u0019H\u0002J\b\u0010.\u001a\u00020\u0019H\u0002J\u0010\u0010/\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u00100\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u00101\u001a\u00020\u0012H\u0002J\u0010\u00103\u001a\u00020\u00022\u0006\u00102\u001a\u00020\u0012H\u0002J\b\u00104\u001a\u00020\u000fH\u0002J\b\u00105\u001a\u00020\u0002H\u0002J\u0010\u00106\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u00108\u001a\u00020\u00022\b\u0010$\u001a\u0004\u0018\u000107H\u0016J(\u0010<\u001a\"\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u0002070:09j\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u0002070:`;H\u0016J\u0018\u0010>\u001a\u00020\u00022\u0006\u0010=\u001a\u00020\u00152\u0006\u00102\u001a\u00020\u0012H\u0016J\b\u0010?\u001a\u00020\u000fH\u0016J\u0012\u0010B\u001a\u00020\u00022\b\u0010A\u001a\u0004\u0018\u00010@H\u0016J\u0012\u0010C\u001a\u00020\u00022\b\u0010A\u001a\u0004\u0018\u00010@H\u0016J\u0012\u0010D\u001a\u00020\u00022\b\u0010A\u001a\u0004\u0018\u00010@H\u0016J\u0012\u0010E\u001a\u00020\u00022\b\u0010A\u001a\u0004\u0018\u00010@H\u0016J\b\u0010F\u001a\u00020\u0019H\u0016R\u0016\u0010J\u001a\u00020G8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010N\u001a\u00020K8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010P\u001a\u00020K8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bO\u0010MR\u0016\u0010R\u001a\u00020K8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bQ\u0010MR\u0016\u0010V\u001a\u00020S8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010X\u001a\u00020S8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bW\u0010UR\u0016\u0010Z\u001a\u00020S8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bY\u0010UR\u0016\u0010^\u001a\u00020[8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\\\u0010]R\u0016\u0010`\u001a\u00020[8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b_\u0010]R\u0016\u0010d\u001a\u00020a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bb\u0010cR\u0018\u0010h\u001a\u0004\u0018\u00010e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bf\u0010gR\u0018\u0010k\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bi\u0010jR\u0018\u0010m\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bl\u0010MR\u0014\u0010q\u001a\u00020n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bo\u0010pR\u001a\u0010u\u001a\b\u0012\u0004\u0012\u00020\u00190r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bs\u0010tR\u0016\u0010w\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bv\u0010\\R\u0016\u0010z\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bx\u0010yR\u0016\u0010|\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b{\u0010yR\u0017\u0010\u0080\u0001\u001a\u00020}8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b~\u0010\u007fR\u0018\u0010\u0084\u0001\u001a\u00030\u0081\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0082\u0001\u0010\u0083\u0001\u00a8\u0006\u008a\u0001"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/feed/j;", "Lcom/tencent/biz/qqcircle/immersive/feed/b;", "", SemanticAttributes.DbSystemValues.H2, "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "S1", "e2", "H1", "T1", "Z1", "q2", "V1", "o2", "m2", "", "isConfigChanged", "E1", "", com.tencent.luggage.wxa.c8.c.G, "p2", "Lfeedcloud/FeedCloudMeta$StFeed;", "L1", "K1", "l2", "", "feedId", "f2", Constants.APK_CERTIFICATE, "Lcom/tencent/biz/richframework/video/rfw/player/RFWPlayerOptions;", "options", "C1", "U1", "show", "k2", "Lcom/tencent/mobileqq/auto/engine/event/ASEngineTabStatusEvent;", "event", "R1", "d2", "J1", DomainData.DOMAIN_NAME, "I1", "actionType", "subActionType", "g2", "M1", "N1", "P1", "O1", "Q1", "position", "i2", ICustomDataEditor.STRING_ARRAY_PARAM_2, "j2", "N0", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "data", "j1", "E0", "Lcom/tencent/biz/richframework/video/rfw/drive/RFWFeedSelectInfo;", "selectInfo", "onResumed", "onPaused", "onFeedSelected", "onFeedUnSelected", "w0", "Lqqcircle/QQCircleDitto$StCircleDittoDataNew;", ExifInterface.LATITUDE_SOUTH, "Lqqcircle/QQCircleDitto$StCircleDittoDataNew;", "mDittoData", "Landroid/widget/TextView;", "T", "Landroid/widget/TextView;", "mTitle", "U", "mBottomHint", "V", "mLeftBtn", "Lcom/tencent/biz/qqcircle/widgets/RoundFrameLayout;", "W", "Lcom/tencent/biz/qqcircle/widgets/RoundFrameLayout;", "mFeedContainer", "X", "mLeftContainer", "Y", "mRightContainer", "Landroid/widget/ImageView;", "Z", "Landroid/widget/ImageView;", "mCoverImage", "a0", "mTransCoverImage", "Lcom/tencent/biz/qqcircle/immersive/views/QFSVideoView;", "b0", "Lcom/tencent/biz/qqcircle/immersive/views/QFSVideoView;", "mPlayView", "Lcom/tencent/qqnt/chats/view/shimmer/ShimmerFrameLayout;", "c0", "Lcom/tencent/qqnt/chats/view/shimmer/ShimmerFrameLayout;", "mShimmerContainer", "d0", "Landroid/view/View;", "mShimmerBg", "e0", "mRightBtn", "Ljava/util/concurrent/atomic/AtomicBoolean;", "f0", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mIsTabSelected", "", "g0", "Ljava/util/List;", "mHasExposedFeedIdList", "h0", "mNeedShowShimmer", "i0", "I", "mFeedPos", "j0", "mFeedListSize", "", "k0", "J", "mVideoCardExposeTimestamp", "Ljava/lang/Runnable;", "l0", "Ljava/lang/Runnable;", "mStartShimmerRunnable", "<init>", "()V", "m0", "a", "b", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class j extends com.tencent.biz.qqcircle.immersive.feed.b {

    /* renamed from: S, reason: from kotlin metadata */
    private QQCircleDitto$StCircleDittoDataNew mDittoData;

    /* renamed from: T, reason: from kotlin metadata */
    private TextView mTitle;

    /* renamed from: U, reason: from kotlin metadata */
    private TextView mBottomHint;

    /* renamed from: V, reason: from kotlin metadata */
    private TextView mLeftBtn;

    /* renamed from: W, reason: from kotlin metadata */
    private RoundFrameLayout mFeedContainer;

    /* renamed from: X, reason: from kotlin metadata */
    private RoundFrameLayout mLeftContainer;

    /* renamed from: Y, reason: from kotlin metadata */
    private RoundFrameLayout mRightContainer;

    /* renamed from: Z, reason: from kotlin metadata */
    private ImageView mCoverImage;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private ImageView mTransCoverImage;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private QFSVideoView mPlayView;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ShimmerFrameLayout mShimmerContainer;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View mShimmerBg;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView mRightBtn;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    private int mFeedPos;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    private int mFeedListSize;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    private long mVideoCardExposeTimestamp;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AtomicBoolean mIsTabSelected = new AtomicBoolean(false);

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<String> mHasExposedFeedIdList = new ArrayList();

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private boolean mNeedShowShimmer = true;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Runnable mStartShimmerRunnable = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.e
        @Override // java.lang.Runnable
        public final void run() {
            j.c2(j.this);
        }
    };

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001e\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/feed/j$b;", "Lcom/tencent/qqlive/module/videoreport/data/IDynamicParams;", "", "p", "", "", "getDynamicParams", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/biz/qqcircle/immersive/feed/j;", "a", "Ljava/lang/ref/WeakReference;", "presenterWrf", "b", "Ljava/lang/String;", "text", "<init>", "(Lcom/tencent/biz/qqcircle/immersive/feed/j;Ljava/lang/ref/WeakReference;Ljava/lang/String;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public final class b implements IDynamicParams {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<j> presenterWrf;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String text;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ j f86220c;

        public b(@NotNull j jVar, @NotNull WeakReference<j> presenterWrf, String text) {
            Intrinsics.checkNotNullParameter(presenterWrf, "presenterWrf");
            Intrinsics.checkNotNullParameter(text, "text");
            this.f86220c = jVar;
            this.presenterWrf = presenterWrf;
            this.text = text;
        }

        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
        @NotNull
        public Map<String, Object> getDynamicParams(@Nullable String p16) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (this.presenterWrf.get() != null) {
                j jVar = this.presenterWrf.get();
                Intrinsics.checkNotNull(jVar);
                linkedHashMap.put("xsj_feed_id", jVar.M1());
            }
            linkedHashMap.put("xsj_item_name", this.text);
            return linkedHashMap;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/biz/qqcircle/immersive/feed/j$c", "Lcom/tencent/biz/richframework/video/rfw/player/ioc/RFWPlayerIOC;", "", AppConstants.Key.COLUMN_IS_VALID, "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class c extends RFWPlayerIOC {
        c() {
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.ioc.RFWPlayerIOC
        public boolean isValid() {
            return j.this.E0();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/biz/qqcircle/immersive/feed/j$d", "Lcom/tencent/biz/richframework/video/rfw/player/listener/IRFWPlayerPrepareListener;", "Lcom/tencent/biz/richframework/video/rfw/RFWPlayer;", "player", "", "onVideoPrepared", "onFirstFrameRendered", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class d implements IRFWPlayerPrepareListener {
        d() {
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener
        public void onFirstFrameRendered(@NotNull RFWPlayer player) {
            Intrinsics.checkNotNullParameter(player, "player");
            j.this.k2(false);
            QFSVideoView qFSVideoView = j.this.mPlayView;
            if (qFSVideoView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayView");
                qFSVideoView = null;
            }
            qFSVideoView.setAlpha(1.0f);
            if (j.this.mFeedPos + 1 < j.this.mFeedListSize) {
                j jVar = j.this;
                jVar.U1(jVar.mFeedPos + 1);
                j jVar2 = j.this;
                jVar2.p2(jVar2.mFeedPos + 1);
            }
            j jVar3 = j.this;
            jVar3.f2(jVar3.M1());
            j.this.mVideoCardExposeTimestamp = System.currentTimeMillis();
            QLog.d("QFSFeedBigVideoCardPresenter", 1, "record expose timestamp: " + j.this.mVideoCardExposeTimestamp + ", feedId: " + j.this.M1());
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener
        public void onVideoPrepared(@NotNull RFWPlayer player) {
            Intrinsics.checkNotNullParameter(player, "player");
            player.getRealPlayer().setXYaxis(0);
            QFSVideoView qFSVideoView = j.this.mPlayView;
            if (qFSVideoView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayView");
                qFSVideoView = null;
            }
            qFSVideoView.start();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/biz/qqcircle/immersive/feed/j$e", "Lcom/tencent/biz/richframework/video/rfw/player/listener/IRFWPlayerLifeCycle;", "Lcom/tencent/biz/richframework/video/rfw/RFWPlayer;", "player", "", "onRelease", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class e implements IRFWPlayerLifeCycle {
        e() {
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerLifeCycle
        public /* synthetic */ void onDeInit(RFWPlayer rFWPlayer) {
            re0.a.a(this, rFWPlayer);
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerLifeCycle
        public /* synthetic */ void onPause(RFWPlayer rFWPlayer) {
            re0.a.b(this, rFWPlayer);
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerLifeCycle
        public void onRelease(@Nullable RFWPlayer player) {
            re0.a.c(this, player);
            j jVar = j.this;
            jVar.U1(jVar.mFeedPos);
            j.this.k2(true);
            QFSVideoView qFSVideoView = j.this.mPlayView;
            if (qFSVideoView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayView");
                qFSVideoView = null;
            }
            qFSVideoView.setData(null, j.this.f85018i);
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerLifeCycle
        public /* synthetic */ void onStart(RFWPlayer rFWPlayer) {
            re0.a.d(this, rFWPlayer);
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerLifeCycle
        public /* synthetic */ void onStop(RFWPlayer rFWPlayer) {
            re0.a.e(this, rFWPlayer);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/biz/qqcircle/immersive/feed/j$f", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "onAnimationCancel", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class f extends AnimatorListenerAdapter {
        f() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator animation) {
            ImageView imageView = j.this.mTransCoverImage;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTransCoverImage");
                imageView = null;
            }
            imageView.setVisibility(8);
            j.this.l2();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            ImageView imageView = j.this.mTransCoverImage;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTransCoverImage");
                imageView = null;
            }
            imageView.setVisibility(8);
            j.this.l2();
        }
    }

    private final void C1(RFWPlayerOptions options) {
        options.setPlayIOC(new c());
        options.getListenerSet().addSDKInitListeners(new IRFWPlayerSdkInitListener() { // from class: com.tencent.biz.qqcircle.immersive.feed.h
            @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSdkInitListener
            public final void onInitSuccess(RFWPlayer rFWPlayer) {
                j.D1(j.this, rFWPlayer);
            }
        });
        options.getListenerSet().addPrepareListeners(new d());
        options.getListenerSet().addLifeCycleListeners(new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D1(j this$0, RFWPlayer rFWPlayer) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QFSVideoView qFSVideoView = this$0.mPlayView;
        if (qFSVideoView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayView");
            qFSVideoView = null;
        }
        qFSVideoView.setLoopBack(true);
    }

    private final void E1(boolean isConfigChanged) {
        ImageView imageView = this.mCoverImage;
        RoundFrameLayout roundFrameLayout = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCoverImage");
            imageView = null;
        }
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        int P1 = P1(isConfigChanged);
        int O1 = O1(isConfigChanged);
        QLog.d("QFSFeedBigVideoCardPresenter", 1, "[adjustContainerSize] width | height: " + P1 + APLogFileUtil.SEPARATOR_LOG + O1);
        layoutParams.width = P1;
        layoutParams.height = O1;
        ImageView imageView2 = this.mCoverImage;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCoverImage");
            imageView2 = null;
        }
        imageView2.setLayoutParams(layoutParams);
        QFSVideoView qFSVideoView = this.mPlayView;
        if (qFSVideoView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayView");
            qFSVideoView = null;
        }
        ViewGroup.LayoutParams layoutParams2 = qFSVideoView.getLayoutParams();
        layoutParams2.width = P1;
        layoutParams2.height = O1;
        QFSVideoView qFSVideoView2 = this.mPlayView;
        if (qFSVideoView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayView");
            qFSVideoView2 = null;
        }
        qFSVideoView2.setLayoutParams(layoutParams2);
        RoundFrameLayout roundFrameLayout2 = this.mFeedContainer;
        if (roundFrameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFeedContainer");
            roundFrameLayout2 = null;
        }
        ViewGroup.LayoutParams layoutParams3 = roundFrameLayout2.getLayoutParams();
        layoutParams3.width = P1;
        layoutParams3.height = O1;
        RoundFrameLayout roundFrameLayout3 = this.mFeedContainer;
        if (roundFrameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFeedContainer");
        } else {
            roundFrameLayout = roundFrameLayout3;
        }
        roundFrameLayout.setLayoutParams(layoutParams3);
    }

    static /* synthetic */ void F1(j jVar, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        jVar.E1(z16);
    }

    private final boolean G1() {
        if (E0()) {
            return false;
        }
        RFWLog.d("QFSFeedBigVideoCardPresenter", RFWLog.USR, "canNotPlay");
        return true;
    }

    private final void H1() {
        TextView textView = this.mLeftBtn;
        CharSequence charSequence = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLeftBtn");
            textView = null;
        }
        VideoReport.setElementId(textView, QCircleDaTongConstant.ElementId.EM_XSJ_VIDEO_QUESTIONNAIRE_ANSWER_BUTTON);
        TextView textView2 = this.mLeftBtn;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLeftBtn");
            textView2 = null;
        }
        WeakReference weakReference = new WeakReference(this);
        TextView textView3 = this.mLeftBtn;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLeftBtn");
            textView3 = null;
        }
        VideoReport.setEventDynamicParams(textView2, new b(this, weakReference, textView3.getText().toString()));
        TextView textView4 = this.mLeftBtn;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLeftBtn");
            textView4 = null;
        }
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_NONE;
        VideoReport.setElementExposePolicy(textView4, exposurePolicy);
        VideoReport.setElementId(this.mRightBtn, QCircleDaTongConstant.ElementId.EM_XSJ_VIDEO_QUESTIONNAIRE_ANSWER_BUTTON);
        TextView textView5 = this.mRightBtn;
        WeakReference weakReference2 = new WeakReference(this);
        TextView textView6 = this.mRightBtn;
        if (textView6 != null) {
            charSequence = textView6.getText();
        }
        VideoReport.setEventDynamicParams(textView5, new b(this, weakReference2, String.valueOf(charSequence)));
        VideoReport.setElementExposePolicy(this.mRightBtn, exposurePolicy);
    }

    private final void I1() {
        boolean z16;
        QFSVideoView qFSVideoView = this.mPlayView;
        if (qFSVideoView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayView");
            qFSVideoView = null;
        }
        RFWPlayer qCirclePlayer = qFSVideoView.getQCirclePlayer();
        if (qCirclePlayer != null && qCirclePlayer.isPlaying()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            RFWLog.d("QFSFeedBigVideoCardPresenter", RFWLog.USR, "executeFromSelected return is playing");
            return;
        }
        if (!E0()) {
            RFWLog.d("QFSFeedBigVideoCardPresenter", RFWLog.USR, "isFeedOnScreen: false");
            return;
        }
        RFWLog.d("QFSFeedBigVideoCardPresenter", RFWLog.USR, "executeFromSelected");
        l2();
        if (this.mNeedShowShimmer) {
            long parseLong = Long.parseLong(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_recommend_video_card_shimmer_post_delay_time", "5000"));
            QLog.d("QFSFeedBigVideoCardPresenter", 1, "post show shimmer. delay: " + parseLong);
            RFWThreadManager.getUIHandler().postDelayed(this.mStartShimmerRunnable, parseLong);
            com.tencent.biz.qqcircle.immersive.utils.bc.a(50L);
        }
        h2();
    }

    private final void J1() {
        if (G1()) {
            return;
        }
        QFSVideoView qFSVideoView = this.mPlayView;
        QFSVideoView qFSVideoView2 = null;
        if (qFSVideoView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayView");
            qFSVideoView = null;
        }
        if (qFSVideoView.getSuperPlayer() == null) {
            RFWLog.d("QFSFeedBigVideoCardPresenter", RFWLog.USR, "execute a new player" + hashCode());
            l2();
            return;
        }
        QFSVideoView qFSVideoView3 = this.mPlayView;
        if (qFSVideoView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayView");
            qFSVideoView3 = null;
        }
        if (!qFSVideoView3.isRelease()) {
            QFSVideoView qFSVideoView4 = this.mPlayView;
            if (qFSVideoView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayView");
                qFSVideoView4 = null;
            }
            if (!qFSVideoView4.getQCirclePlayer().isDeInit()) {
                QFSVideoView qFSVideoView5 = this.mPlayView;
                if (qFSVideoView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPlayView");
                    qFSVideoView5 = null;
                }
                if (qFSVideoView5.getSuperPlayer().isPlaying()) {
                    RFWLog.d("QFSFeedBigVideoCardPresenter", RFWLog.USR, "isPlaying when resume:" + hashCode());
                    return;
                }
                QFSVideoView qFSVideoView6 = this.mPlayView;
                if (qFSVideoView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPlayView");
                } else {
                    qFSVideoView2 = qFSVideoView6;
                }
                if (qFSVideoView2.getSuperPlayer().isPausing()) {
                    n();
                    RFWLog.d("QFSFeedBigVideoCardPresenter", RFWLog.USR, "startFromPause hashCode:" + hashCode());
                    return;
                }
                l2();
                return;
            }
        }
        RFWLog.d("QFSFeedBigVideoCardPresenter", RFWLog.USR, "execute a new player released" + hashCode());
        l2();
    }

    private final FeedCloudMeta$StFeed K1(int pos) {
        if (pos >= this.mFeedListSize) {
            return new FeedCloudMeta$StFeed();
        }
        QQCircleDitto$StCircleDittoDataNew qQCircleDitto$StCircleDittoDataNew = this.mDittoData;
        if (qQCircleDitto$StCircleDittoDataNew == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDittoData");
            qQCircleDitto$StCircleDittoDataNew = null;
        }
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = qQCircleDitto$StCircleDittoDataNew.itemContainter.items.get(pos).feeds.get(0);
        Intrinsics.checkNotNullExpressionValue(feedCloudMeta$StFeed, "mDittoData.itemContainter.items[pos].feeds[0]");
        return feedCloudMeta$StFeed;
    }

    private final FeedCloudMeta$StFeed L1() {
        return K1(this.mFeedPos);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String M1() {
        String str = L1().f398449id.get();
        Intrinsics.checkNotNullExpressionValue(str, "getCurCardFeed().id.get()");
        return str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final String N1() {
        String str = ((FeedCloudMeta$StFeed) this.f85017h).f398449id.get();
        Intrinsics.checkNotNullExpressionValue(str, "mData.id.get()");
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int O1(boolean isConfigChanged) {
        int screenHeight;
        int P1 = P1(isConfigChanged);
        int dip2px = DisplayUtil.dip2px(m0(), 300.0f);
        int i3 = (P1 * 16) / 9;
        ViewGroup viewGroup = this.G;
        if (viewGroup != null) {
            Intrinsics.checkNotNull(viewGroup);
            if (viewGroup.getMeasuredHeight() > 0 && !isConfigChanged) {
                ViewGroup viewGroup2 = this.G;
                Intrinsics.checkNotNull(viewGroup2);
                screenHeight = viewGroup2.getMeasuredHeight();
                if (i3 + dip2px <= screenHeight) {
                    return screenHeight - dip2px;
                }
                return i3;
            }
        }
        screenHeight = DisplayUtil.getScreenHeight() - HostUIHelper.getInstance().getHostTabHeight();
        if (i3 + dip2px <= screenHeight) {
        }
    }

    private final int P1(boolean isConfigChanged) {
        int screenWidth;
        int dip2px = DisplayUtil.dip2px(m0(), 73.0f) * 2;
        ViewGroup viewGroup = this.G;
        if (viewGroup != null) {
            Intrinsics.checkNotNull(viewGroup);
            if (viewGroup.getMeasuredWidth() > 0 && !isConfigChanged) {
                ViewGroup viewGroup2 = this.G;
                Intrinsics.checkNotNull(viewGroup2);
                screenWidth = viewGroup2.getMeasuredWidth();
                return screenWidth - dip2px;
            }
        }
        screenWidth = DisplayUtil.getScreenWidth();
        return screenWidth - dip2px;
    }

    private final int Q1() {
        return uq3.k.a().e(N1() + "_videoCardPlayPos", 0);
    }

    private final void R1(ASEngineTabStatusEvent event) {
        this.mIsTabSelected.set(event.isSelected());
        QLog.d("QFSFeedBigVideoCardPresenter", 1, "[handlerEngineTabStatusEvent] event selected: " + this.mIsTabSelected);
        if (this.mIsTabSelected.get()) {
            I1();
        } else {
            d2();
            k2(true);
        }
    }

    private final void S1(View rootView) {
        ImageView imageView = (ImageView) rootView.findViewById(R.id.f44851qa);
        if (imageView == null) {
            return;
        }
        String url = QCircleSkinHelper.getInstance().getUrl("pymk_feed_bg");
        if (TextUtils.isEmpty(url)) {
            RFWLog.i("QFSFeedBigVideoCardPresenter", RFWLog.USR, "[initBg] -> bgUrl is empty");
            return;
        }
        Option loadingDrawableColor = Option.obtain().setUrl(url).setRequestWidth(ViewUtils.getScreenWidth()).setRequestHeight(ViewUtils.getScreenHeight()).setTargetView(imageView).setEnableAutoDeleteLocalCache(false).setLoadingDrawableColor(0);
        loadingDrawableColor.setSupportRecycler(true);
        QCircleFeedPicLoader.g().loadImage(loadingDrawableColor);
    }

    private final void T1() {
        QQCircleDitto$StCircleDittoDataNew qQCircleDitto$StCircleDittoDataNew = this.mDittoData;
        QQCircleDitto$StCircleDittoDataNew qQCircleDitto$StCircleDittoDataNew2 = null;
        if (qQCircleDitto$StCircleDittoDataNew == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDittoData");
            qQCircleDitto$StCircleDittoDataNew = null;
        }
        if (qQCircleDitto$StCircleDittoDataNew.itemContainter.buttons.size() == 2) {
            TextView textView = this.mLeftBtn;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLeftBtn");
                textView = null;
            }
            QQCircleDitto$StCircleDittoDataNew qQCircleDitto$StCircleDittoDataNew3 = this.mDittoData;
            if (qQCircleDitto$StCircleDittoDataNew3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDittoData");
                qQCircleDitto$StCircleDittoDataNew3 = null;
            }
            textView.setText(qQCircleDitto$StCircleDittoDataNew3.itemContainter.buttons.get(0).name.get());
            TextView textView2 = this.mRightBtn;
            if (textView2 != null) {
                QQCircleDitto$StCircleDittoDataNew qQCircleDitto$StCircleDittoDataNew4 = this.mDittoData;
                if (qQCircleDitto$StCircleDittoDataNew4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mDittoData");
                } else {
                    qQCircleDitto$StCircleDittoDataNew2 = qQCircleDitto$StCircleDittoDataNew4;
                }
                textView2.setText(qQCircleDitto$StCircleDittoDataNew2.itemContainter.buttons.get(1).name.get());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U1(int pos) {
        QQCircleDitto$StCircleDittoDataNew qQCircleDitto$StCircleDittoDataNew = this.mDittoData;
        ImageView imageView = null;
        if (qQCircleDitto$StCircleDittoDataNew == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDittoData");
            qQCircleDitto$StCircleDittoDataNew = null;
        }
        Option requestHeight = Option.obtain().setUrl(qQCircleDitto$StCircleDittoDataNew.itemContainter.items.get(pos).feeds.get(0).cover.picUrl.get()).setRequestWidth(P1(false)).setRequestHeight(O1(false));
        ImageView imageView2 = this.mCoverImage;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCoverImage");
        } else {
            imageView = imageView2;
        }
        QCircleFeedPicLoader.g().loadImage(requestHeight.setTargetView(imageView));
    }

    private final void V1() {
        TextView textView = this.mLeftBtn;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLeftBtn");
            textView = null;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.feed.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                j.W1(j.this, view);
            }
        });
        TextView textView2 = this.mRightBtn;
        if (textView2 != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.feed.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    j.X1(j.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W1(j this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.g2(135, 2);
        this$0.o2();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X1(j this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.g2(136, 2);
        this$0.o2();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Z1() {
        q2();
        TextView textView = this.mBottomHint;
        QQCircleDitto$StCircleDittoDataNew qQCircleDitto$StCircleDittoDataNew = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBottomHint");
            textView = null;
        }
        QQCircleDitto$StCircleDittoDataNew qQCircleDitto$StCircleDittoDataNew2 = this.mDittoData;
        if (qQCircleDitto$StCircleDittoDataNew2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDittoData");
        } else {
            qQCircleDitto$StCircleDittoDataNew = qQCircleDitto$StCircleDittoDataNew2;
        }
        textView.setText(qQCircleDitto$StCircleDittoDataNew.itemContainter.subTitle.get());
    }

    private final boolean a2() {
        return uq3.k.a().c(N1() + "_videoCardShowFlag", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c2(j this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View view = this$0.mShimmerBg;
        if (view != null) {
            view.setAlpha(1.0f);
        }
        View view2 = this$0.mShimmerBg;
        if (view2 != null) {
            view2.setBackgroundColor(Color.parseColor("#80FFFFFF"));
        }
        TextView textView = this$0.mRightBtn;
        if (textView != null) {
            textView.setBackground(null);
        }
        ShimmerFrameLayout shimmerFrameLayout = this$0.mShimmerContainer;
        if (shimmerFrameLayout != null) {
            shimmerFrameLayout.d(new Shimmer.a().f(0.33f).n(1.0f).a());
        }
        ShimmerFrameLayout shimmerFrameLayout2 = this$0.mShimmerContainer;
        if (shimmerFrameLayout2 != null) {
            shimmerFrameLayout2.e(true);
        }
        QLog.d("QFSFeedBigVideoCardPresenter", 1, "startShimmer");
    }

    private final void d2() {
        QFSVideoView qFSVideoView = this.mPlayView;
        QFSVideoView qFSVideoView2 = null;
        if (qFSVideoView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayView");
            qFSVideoView = null;
        }
        if (qFSVideoView.getSuperPlayer() == null) {
            return;
        }
        QFSVideoView qFSVideoView3 = this.mPlayView;
        if (qFSVideoView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayView");
            qFSVideoView3 = null;
        }
        VideoReport.unbindVideoPlayerInfo(qFSVideoView3);
        QFSVideoView qFSVideoView4 = this.mPlayView;
        if (qFSVideoView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayView");
        } else {
            qFSVideoView2 = qFSVideoView4;
        }
        qFSVideoView2.pause();
        RFWLog.d("QFSFeedBigVideoCardPresenter", RFWLog.USR, "pause success");
        f2(M1());
    }

    private final void e2() {
        ArrayList arrayList = new ArrayList();
        QQCircleDitto$StCircleDittoDataNew qQCircleDitto$StCircleDittoDataNew = this.mDittoData;
        if (qQCircleDitto$StCircleDittoDataNew == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDittoData");
            qQCircleDitto$StCircleDittoDataNew = null;
        }
        Iterator<QQCircleDitto$StItemInfo> it = qQCircleDitto$StCircleDittoDataNew.itemContainter.items.get().iterator();
        while (it.hasNext()) {
            String str = it.next().get().feeds.get(0).f398449id.get();
            Intrinsics.checkNotNullExpressionValue(str, "stItemInfo.get().feeds.get(0).id.get()");
            arrayList.add(str);
        }
        QLog.d("QFSFeedBigVideoCardPresenter", 1, "feedIdList: " + arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f2(String feedId) {
        long currentTimeMillis;
        Map<String, Object> map = new QCircleDTParamBuilder().buildElementParams();
        Intrinsics.checkNotNullExpressionValue(map, "map");
        map.put("xsj_feed_id", feedId);
        if (this.mVideoCardExposeTimestamp == 0) {
            currentTimeMillis = 0;
        } else {
            currentTimeMillis = System.currentTimeMillis() - this.mVideoCardExposeTimestamp;
        }
        map.put(QCircleDaTongConstant.ElementParamKey.XSJ_EM_LVTM, Long.valueOf(currentTimeMillis));
        QLog.d("QFSFeedBigVideoCardPresenter", 1, "[reportAbnormalImp] feedId: " + feedId + ", time: " + map.get(QCircleDaTongConstant.ElementParamKey.XSJ_EM_LVTM));
        map.put("xsj_custom_pgid", "pg_xsj_explore_page");
        map.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_VIDEO_QUESTIONNAIRE_CARD);
        RoundFrameLayout roundFrameLayout = this.mFeedContainer;
        RoundFrameLayout roundFrameLayout2 = null;
        if (roundFrameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFeedContainer");
            roundFrameLayout = null;
        }
        VideoReport.setElementId(roundFrameLayout, QCircleDaTongConstant.ElementId.EM_XSJ_VIDEO_QUESTIONNAIRE_CARD);
        RoundFrameLayout roundFrameLayout3 = this.mFeedContainer;
        if (roundFrameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFeedContainer");
        } else {
            roundFrameLayout2 = roundFrameLayout3;
        }
        VideoReport.reportEvent("ev_xsj_abnormal_imp", roundFrameLayout2, map);
        this.mVideoCardExposeTimestamp = 0L;
    }

    private final void g2(int actionType, int subActionType) {
        if (r() == null) {
            QLog.d("QCircleReporter_" + getTAG(), 1, "extraTypeInfo is null. actionType: " + actionType + ", subActionType: " + subActionType);
            return;
        }
        QCircleLpReportDc05507.DataBuilder dataBuilder = new QCircleLpReportDc05507.DataBuilder(ua0.c.c(L1()));
        dataBuilder.setActionType(actionType);
        dataBuilder.setSubActionType(subActionType);
        dataBuilder.setPageId(dataBuilder.getPageId());
        dataBuilder.setPlayScene(11);
        QCircleLpReportDc05507.report(dataBuilder);
    }

    private final void h2() {
        View view = this.mShimmerBg;
        if (view != null) {
            view.setAlpha(0.33f);
        }
    }

    private final void i2(int position) {
        uq3.k.a().m(N1() + "_videoCardPlayPos", position);
    }

    private final void j2() {
        if (!this.mNeedShowShimmer) {
            return;
        }
        RFWThreadManager.getUIHandler().removeCallbacks(this.mStartShimmerRunnable);
        ShimmerFrameLayout shimmerFrameLayout = this.mShimmerContainer;
        if (shimmerFrameLayout != null) {
            shimmerFrameLayout.a();
        }
        View view = this.mShimmerBg;
        if (view != null) {
            view.setBackground(null);
        }
        TextView textView = this.mRightBtn;
        if (textView != null) {
            textView.setBackground(ResourcesCompat.getDrawable(m0().getResources(), R.drawable.kiy, null));
        }
        this.mNeedShowShimmer = false;
        uq3.k.a().j(N1() + "_videoCardShowFlag", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k2(boolean show) {
        int i3;
        ImageView imageView = this.mCoverImage;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCoverImage");
            imageView = null;
        }
        if (show) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        imageView.setVisibility(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l2() {
        RFWVideoPreloadManager.g(QCircleHostConstants._SceneID.QQ_CIRCLE_VIDEO()).stopPreload(L1().video.fileId.get());
        QLog.d("QFSFeedBigVideoCardPresenter", 1, "[startANewPlayer] ");
        if (!this.mHasExposedFeedIdList.contains(M1())) {
            this.mHasExposedFeedIdList.add(M1());
            g2(1, 1);
        }
        FeedCloudMeta$StFeed L1 = L1();
        QFSVideoView qFSVideoView = this.mPlayView;
        QFSVideoView qFSVideoView2 = null;
        if (qFSVideoView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayView");
            qFSVideoView = null;
        }
        qFSVideoView.setData(L1, this.f85018i);
        RFWPlayerOptions playerOptions = RFWPlayerOptions.obtain(QCircleHostConstants._SceneID.QQ_CIRCLE_VIDEO()).setPlayUrl(L1.video.playUrl.get()).setStVideo(gb0.b.k(L1.video));
        Intrinsics.checkNotNullExpressionValue(playerOptions, "playerOptions");
        C1(playerOptions);
        QFSVideoView qFSVideoView3 = this.mPlayView;
        if (qFSVideoView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayView");
        } else {
            qFSVideoView2 = qFSVideoView3;
        }
        qFSVideoView2.loadPlayOptions(playerOptions);
    }

    private final void m2() {
        com.tencent.biz.qqcircle.immersive.utils.be c16 = com.tencent.biz.qqcircle.immersive.utils.be.c();
        QFSVideoView qFSVideoView = this.mPlayView;
        if (qFSVideoView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayView");
            qFSVideoView = null;
        }
        c16.h(qFSVideoView, L1(), new bi.a() { // from class: com.tencent.biz.qqcircle.immersive.feed.i
            @Override // com.tencent.biz.qqcircle.immersive.utils.bi.a
            public final void a(Pair pair) {
                j.n2(j.this, pair);
            }
        });
    }

    private final void n() {
        QFSVideoView qFSVideoView = this.mPlayView;
        QFSVideoView qFSVideoView2 = null;
        if (qFSVideoView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayView");
            qFSVideoView = null;
        }
        if (qFSVideoView.getSuperPlayer() == null) {
            RFWLog.d("QFSFeedBigVideoCardPresenter", 1, "[startFromPause] current play view or player is null, end flow.");
            return;
        }
        QFSVideoView qFSVideoView3 = this.mPlayView;
        if (qFSVideoView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayView");
            qFSVideoView3 = null;
        }
        if (qFSVideoView3.getSuperPlayer().isPausing()) {
            String str = L1().f398449id.get();
            Intrinsics.checkNotNullExpressionValue(str, "feed.id.get()");
            f2(str);
            long currentTimeMillis = System.currentTimeMillis();
            this.mVideoCardExposeTimestamp = currentTimeMillis;
            RFWLog.d("QFSFeedBigVideoCardPresenter", 1, "[startFromPause] current player is pause, try start play. reportAbnormalImp time: " + currentTimeMillis);
            QFSVideoView qFSVideoView4 = this.mPlayView;
            if (qFSVideoView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayView");
            } else {
                qFSVideoView2 = qFSVideoView4;
            }
            qFSVideoView2.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n2(j this$0, Pair bitmapInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(bitmapInfo, "bitmapInfo");
        if (bitmapInfo.second == null) {
            QLog.d("QFSFeedBigVideoCardPresenter", 1, "startAlphaAnim, save frame error. ");
            this$0.k2(true);
            this$0.l2();
            return;
        }
        QLog.d("QFSFeedBigVideoCardPresenter", 1, "startAlphaAnim");
        ImageView imageView = this$0.mTransCoverImage;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTransCoverImage");
            imageView = null;
        }
        imageView.setImageBitmap((Bitmap) bitmapInfo.second);
        QFSVideoView qFSVideoView = this$0.mPlayView;
        if (qFSVideoView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayView");
            qFSVideoView = null;
        }
        qFSVideoView.setAlpha(0.0f);
        ImageView imageView3 = this$0.mCoverImage;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCoverImage");
            imageView3 = null;
        }
        imageView3.setAlpha(0.0f);
        ImageView imageView4 = this$0.mTransCoverImage;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTransCoverImage");
            imageView4 = null;
        }
        imageView4.setAlpha(1.0f);
        ImageView imageView5 = this$0.mCoverImage;
        if (imageView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCoverImage");
            imageView5 = null;
        }
        imageView5.setVisibility(0);
        ImageView imageView6 = this$0.mTransCoverImage;
        if (imageView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTransCoverImage");
            imageView6 = null;
        }
        imageView6.setVisibility(0);
        ImageView imageView7 = this$0.mTransCoverImage;
        if (imageView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTransCoverImage");
            imageView7 = null;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView7, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
        ImageView imageView8 = this$0.mCoverImage;
        if (imageView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCoverImage");
        } else {
            imageView2 = imageView8;
        }
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView2, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
        AnimatorSet duration = new AnimatorSet().setDuration(200L);
        duration.playTogether(ofFloat, ofFloat2);
        duration.addListener(new f());
        duration.start();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void o2() {
        PBStringField pBStringField;
        if (fb0.a.b("QFSFeedBigVideoCardPresenter", 500L)) {
            QLog.d("QFSFeedBigVideoCardPresenter", 1, "fast click. ");
            return;
        }
        h2();
        j2();
        f2(M1());
        if (this.mFeedPos >= this.mFeedListSize - 1) {
            QQCircleDitto$StCircleDittoDataNew qQCircleDitto$StCircleDittoDataNew = this.mDittoData;
            String str = null;
            if (qQCircleDitto$StCircleDittoDataNew == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDittoData");
                qQCircleDitto$StCircleDittoDataNew = null;
            }
            String str2 = qQCircleDitto$StCircleDittoDataNew.itemContainter.toast.get();
            QLog.d("QFSFeedBigVideoCardPresenter", 1, "[switchNextVideo] toast: " + str2);
            QCircleToast.o(str2, 0);
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = (FeedCloudMeta$StFeed) this.f85017h;
            if (feedCloudMeta$StFeed != null && (pBStringField = feedCloudMeta$StFeed.f398449id) != null) {
                str = pBStringField.get();
            }
            SimpleEventBus.getInstance().dispatchEvent(new QCircleFeedEvent(str, 3));
            return;
        }
        m2();
        int i3 = this.mFeedPos + 1;
        this.mFeedPos = i3;
        QLog.d("QFSFeedBigVideoCardPresenter", 1, "[switchNextVideo] curFeedPos: " + i3);
        i2(this.mFeedPos);
        q2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p2(int pos) {
        QLog.d("QFSFeedBigVideoCardPresenter", 1, "triggerPreloadVideo pos: " + pos);
        RFWVideoPreloadManager.g(QCircleHostConstants._SceneID.QQ_CIRCLE_VIDEO()).preloadVideo(gb0.b.n(K1(pos), false), "source_recommend_video_card");
    }

    @SuppressLint({"SetTextI18n"})
    private final void q2() {
        TextView textView = this.mTitle;
        QQCircleDitto$StCircleDittoDataNew qQCircleDitto$StCircleDittoDataNew = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitle");
            textView = null;
        }
        QQCircleDitto$StCircleDittoDataNew qQCircleDitto$StCircleDittoDataNew2 = this.mDittoData;
        if (qQCircleDitto$StCircleDittoDataNew2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDittoData");
        } else {
            qQCircleDitto$StCircleDittoDataNew = qQCircleDitto$StCircleDittoDataNew2;
        }
        textView.setText(qQCircleDitto$StCircleDittoDataNew.itemContainter.title.get() + "(" + (this.mFeedPos + 1) + "/" + this.mFeedListSize + ")");
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public boolean E0() {
        if (s0() != null) {
            return s0().isContainerOnScreen();
        }
        return false;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.b, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.N0(rootView);
        S1(rootView);
        View findViewById = rootView.findViewById(R.id.f40171dn);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.qfs_feed_container)");
        this.mFeedContainer = (RoundFrameLayout) findViewById;
        View findViewById2 = rootView.findViewById(R.id.f166040yh2);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.left_container)");
        this.mLeftContainer = (RoundFrameLayout) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.i_z);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.right_container)");
        this.mRightContainer = (RoundFrameLayout) findViewById3;
        RoundFrameLayout roundFrameLayout = this.mFeedContainer;
        RoundFrameLayout roundFrameLayout2 = null;
        if (roundFrameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFeedContainer");
            roundFrameLayout = null;
        }
        roundFrameLayout.setRadius(DisplayUtil.dip2px(m0(), 8.0f));
        RoundFrameLayout roundFrameLayout3 = this.mLeftContainer;
        if (roundFrameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLeftContainer");
            roundFrameLayout3 = null;
        }
        roundFrameLayout3.setRadius(DisplayUtil.dip2px(m0(), 4.0f));
        RoundFrameLayout roundFrameLayout4 = this.mRightContainer;
        if (roundFrameLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRightContainer");
        } else {
            roundFrameLayout2 = roundFrameLayout4;
        }
        roundFrameLayout2.setRadius(DisplayUtil.dip2px(m0(), 4.0f));
        View findViewById4 = rootView.findViewById(R.id.f40431ec);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.\u2026s_feed_hobby_label_title)");
        this.mTitle = (TextView) findViewById4;
        View findViewById5 = rootView.findViewById(R.id.f40421eb);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.\u2026eed_hobby_label_subtitle)");
        this.mBottomHint = (TextView) findViewById5;
        View findViewById6 = rootView.findViewById(R.id.v_z);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "rootView.findViewById(R.\u2026h_show_feed_player_cover)");
        this.mCoverImage = (ImageView) findViewById6;
        View findViewById7 = rootView.findViewById(R.id.f363814e);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "rootView.findViewById(R.id.qfs_cover_iv)");
        this.mTransCoverImage = (ImageView) findViewById7;
        View findViewById8 = rootView.findViewById(R.id.f74163vi);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "rootView.findViewById(R.id.rfw_video_view_id)");
        this.mPlayView = (QFSVideoView) findViewById8;
        View findViewById9 = rootView.findViewById(R.id.e7d);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "rootView.findViewById(R.id.left_btn)");
        this.mLeftBtn = (TextView) findViewById9;
        this.mRightBtn = (TextView) rootView.findViewById(R.id.i_w);
        this.mShimmerContainer = (ShimmerFrameLayout) rootView.findViewById(R.id.f84644mt);
        this.mShimmerBg = rootView.findViewById(R.id.f516428n);
        h2();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.b, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<? extends SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<? extends SimpleBaseEvent>> eventClass = super.getEventClass();
        eventClass.add(QCircleConfigChangeEvent.class);
        eventClass.add(ASEngineTabStatusEvent.class);
        eventClass.add(QCirclePanelStateEvent.class);
        Intrinsics.checkNotNullExpressionValue(eventClass, "eventClass");
        return eventClass;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: j1 */
    public void L0(@NotNull FeedCloudMeta$StFeed data, int position) {
        Intrinsics.checkNotNullParameter(data, "data");
        super.L0(data, position);
        Object b16 = this.E.b(String.valueOf(data.dittoFeed.dittoId.get()));
        if (b16 == null) {
            QLog.e("QFSFeedBigVideoCardPresenter", 1, "[onBindData] dittoData is null");
            return;
        }
        this.mDittoData = (QQCircleDitto$StCircleDittoDataNew) b16;
        this.mNeedShowShimmer = a2();
        this.mFeedPos = Q1();
        QQCircleDitto$StCircleDittoDataNew qQCircleDitto$StCircleDittoDataNew = this.mDittoData;
        if (qQCircleDitto$StCircleDittoDataNew == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDittoData");
            qQCircleDitto$StCircleDittoDataNew = null;
        }
        this.mFeedListSize = qQCircleDitto$StCircleDittoDataNew.itemContainter.items.size();
        QQCircleDitto$StCircleDittoDataNew qQCircleDitto$StCircleDittoDataNew2 = this.mDittoData;
        if (qQCircleDitto$StCircleDittoDataNew2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDittoData");
            qQCircleDitto$StCircleDittoDataNew2 = null;
        }
        QLog.d("QFSFeedBigVideoCardPresenter", 1, "[onBindData] size: " + qQCircleDitto$StCircleDittoDataNew2.itemContainter.items.size());
        e2();
        F1(this, false, 1, null);
        U1(this.mFeedPos);
        Z1();
        T1();
        k2(true);
        V1();
        H1();
        p2(this.mFeedPos);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.b, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(@Nullable RFWFeedSelectInfo selectInfo) {
        super.onFeedSelected(selectInfo);
        if (selectInfo == null) {
            return;
        }
        RFWLog.d("QFSFeedBigVideoCardPresenter", RFWLog.USR, "fs_lifecycle onSelected:" + selectInfo + " | mPos:" + this.f85018i + " | hashCode:" + hashCode() + " | pageId:" + y0());
        if (selectInfo.getPosition() != this.f85018i) {
            return;
        }
        I1();
        com.tencent.biz.qqcircle.immersive.manager.f.f().i();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.b, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedUnSelected(@Nullable RFWFeedSelectInfo selectInfo) {
        super.onFeedUnSelected(selectInfo);
        f2(M1());
        j2();
        h2();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onPaused(@Nullable RFWFeedSelectInfo selectInfo) {
        super.onPaused(selectInfo);
        QLog.d("QFSFeedBigVideoCardPresenter", RFWLog.USR, "onPaused");
        d2();
        j2();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.b, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        super.onReceiveEvent(event);
        if (event instanceof QCircleConfigChangeEvent) {
            E1(true);
        } else if (event instanceof ASEngineTabStatusEvent) {
            R1((ASEngineTabStatusEvent) event);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onResumed(@Nullable RFWFeedSelectInfo selectInfo) {
        super.onResumed(selectInfo);
        if (selectInfo == null) {
            return;
        }
        if (this.f85018i == selectInfo.getPosition()) {
            J1();
        }
        RFWLog.d("QFSFeedBigVideoCardPresenter", RFWLog.USR, "fs_lifecycle onResumed:" + selectInfo + " | mPos:" + this.f85018i + " | hashCode:" + hashCode() + " | pageId:" + y0());
        h2();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    @NotNull
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSFeedBigVideoCardPresenter";
    }
}
