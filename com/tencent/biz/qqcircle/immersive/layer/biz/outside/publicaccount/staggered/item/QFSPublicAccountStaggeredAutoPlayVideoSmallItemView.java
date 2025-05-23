package com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.item;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSVideoFeedPlayEvent;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.events.QFSPublicAccountStaggerLifecycleEvent;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.item.QFSPublicAccountStaggeredAutoPlayVideoSmallItemView;
import com.tencent.biz.qqcircle.immersive.utils.ba;
import com.tencent.biz.qqcircle.immersive.views.QFSVideoView;
import com.tencent.biz.qqcircle.immersive.views.mixfeed.QFSMixFeedTagView;
import com.tencent.biz.qqcircle.utils.cv;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.video.rfw.RFWPlayer;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;
import com.tencent.biz.richframework.video.rfw.player.ioc.RFWPlayerIOC;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSdkInitListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSeekListener;
import com.tencent.biz.richframework.video.rfw.player.stinfo.RFWPlayerReportInfo;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.Option;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoEntity;
import com.tencent.superplayer.api.ISuperPlayer;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import feedcloud.FeedCloudMeta$RecomReasonV2;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StRecomInfo;
import feedcloud.FeedCloudMeta$StUser;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u00b6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 _2\u00020\u0001:\u0001\u0016B\u001f\u0012\u0006\u0010Z\u001a\u00020Y\u0012\u0006\u00101\u001a\u00020.\u0012\u0006\u0010\\\u001a\u00020[\u00a2\u0006\u0004\b]\u0010^J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\u001c\u0010\u000e\u001a\u00020\u0004*\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0002J\f\u0010\u0010\u001a\u00020\u0004*\u00020\u000fH\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0014\u001a\u00020\u0004H\u0002J\b\u0010\u0015\u001a\u00020\u0004H\u0002J\b\u0010\u0016\u001a\u00020\u0004H\u0002J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0019\u001a\u00020\fH\u0014J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\u001a\u0010\u001f\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001e\u001a\u00020\u001aH\u0014J\b\u0010 \u001a\u00020\u001aH\u0016J\n\u0010\"\u001a\u0004\u0018\u00010!H\u0016J\b\u0010$\u001a\u00020#H\u0016J\b\u0010%\u001a\u00020\u0004H\u0014J\b\u0010&\u001a\u00020\u0004H\u0014J\u0010\u0010)\u001a\u00020\u00042\u0006\u0010(\u001a\u00020'H\u0016J$\u0010-\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020'0+0*j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020'0+`,H\u0016R\u0014\u00101\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0018\u00104\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0018\u00108\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0014\u0010<\u001a\u0002098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0014\u0010@\u001a\u00020=8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0014\u0010C\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0014\u0010G\u001a\u00020D8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0014\u0010K\u001a\u00020H8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0014\u0010O\u001a\u00020L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0014\u0010S\u001a\u00020P8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u0014\u0010U\u001a\u00020=8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bT\u0010?R\u0018\u0010X\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010W\u00a8\u0006`"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/item/QFSPublicAccountStaggeredAutoPlayVideoSmallItemView;", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/item/QFSPublicAccountStaggeredBaseItemView;", "Lfeedcloud/FeedCloudMeta$StFeed;", "feed", "", "c1", "Lcom/tencent/libra/request/Option;", "g1", "newFeed", "f1", "b1", "Lcom/tencent/biz/richframework/video/rfw/player/RFWPlayerOptions;", "", "playUrlKey", "i1", "Lcom/tencent/biz/qqcircle/immersive/views/QFSVideoView;", "k1", "Lcom/tencent/superplayer/api/ISuperPlayer;", "player", "onVideoPrepared", "Y0", "h1", "a", "d1", "e1", "getLogTag", "", "getLayoutId", "Le30/b;", "objData", "position", "bindData", "y0", "Landroid/graphics/drawable/Drawable;", "A0", "", "u0", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;", "J", "Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;", "initBean", "K", "Lfeedcloud/FeedCloudMeta$StFeed;", "currentFeed", "Landroid/graphics/Bitmap;", "L", "Landroid/graphics/Bitmap;", "transitionBitmap", "Landroid/widget/RelativeLayout;", "M", "Landroid/widget/RelativeLayout;", "videoAreaLayout", "Landroid/widget/ImageView;", "N", "Landroid/widget/ImageView;", "coverBlurView", "P", "Lcom/tencent/biz/qqcircle/immersive/views/QFSVideoView;", "feedVideoView", "Landroid/widget/TextView;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/widget/TextView;", "feedDurationText", "Lcom/tencent/biz/qqcircle/immersive/views/mixfeed/QFSMixFeedTagView;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/biz/qqcircle/immersive/views/mixfeed/QFSMixFeedTagView;", "tagView", "Landroid/widget/LinearLayout;", ExifInterface.LATITUDE_SOUTH, "Landroid/widget/LinearLayout;", "mBannerLayout", "Lcom/tencent/biz/qqcircle/widgets/QCircleAsyncTextView;", "T", "Lcom/tencent/biz/qqcircle/widgets/QCircleAsyncTextView;", "mBannerText", "U", "mBannerIcon", "V", "Le30/b;", "currentFeedBlockData", "Landroid/content/Context;", "context", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/presentation/a;", "feedsOperator", "<init>", "(Landroid/content/Context;Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/presentation/a;)V", "W", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSPublicAccountStaggeredAutoPlayVideoSmallItemView extends QFSPublicAccountStaggeredBaseItemView {

    /* renamed from: a0, reason: collision with root package name */
    private static long f86784a0;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final QCircleInitBean initBean;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private FeedCloudMeta$StFeed currentFeed;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private Bitmap transitionBitmap;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final RelativeLayout videoAreaLayout;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final ImageView coverBlurView;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final QFSVideoView feedVideoView;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final TextView feedDurationText;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final QFSMixFeedTagView tagView;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final LinearLayout mBannerLayout;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final QCircleAsyncTextView mBannerText;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final ImageView mBannerIcon;

    /* renamed from: V, reason: from kotlin metadata */
    @Nullable
    private e30.b currentFeedBlockData;

    /* renamed from: b0, reason: collision with root package name */
    private static final int f86785b0 = com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.o.INSTANCE.a();

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/item/QFSPublicAccountStaggeredAutoPlayVideoSmallItemView$b", "Lcom/tencent/mobileqq/qcircle/picload/listener/QCirclePicStateListener;", "Lcom/tencent/libra/LoadState;", "state", "Lcom/tencent/libra/request/Option;", "option", "", "onStateChange", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class b extends QCirclePicStateListener {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(final QFSPublicAccountStaggeredAutoPlayVideoSmallItemView this$0, final Ref.ObjectRef resultBitMap) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(resultBitMap, "$resultBitMap");
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.item.e
                @Override // java.lang.Runnable
                public final void run() {
                    QFSPublicAccountStaggeredAutoPlayVideoSmallItemView.b.d(QFSPublicAccountStaggeredAutoPlayVideoSmallItemView.this, resultBitMap);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public static final void d(QFSPublicAccountStaggeredAutoPlayVideoSmallItemView this$0, Ref.ObjectRef resultBitMap) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(resultBitMap, "$resultBitMap");
            this$0.coverBlurView.setImageBitmap((Bitmap) resultBitMap.element);
        }

        /* JADX WARN: Type inference failed for: r4v1, types: [T, android.graphics.Bitmap] */
        @Override // com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener, com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(@NotNull LoadState state, @NotNull Option option) {
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(option, "option");
            if (state == LoadState.STATE_SUCCESS) {
                final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                objectRef.element = option.getResultBitMap();
                final QFSPublicAccountStaggeredAutoPlayVideoSmallItemView qFSPublicAccountStaggeredAutoPlayVideoSmallItemView = QFSPublicAccountStaggeredAutoPlayVideoSmallItemView.this;
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.item.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        QFSPublicAccountStaggeredAutoPlayVideoSmallItemView.b.c(QFSPublicAccountStaggeredAutoPlayVideoSmallItemView.this, objectRef);
                    }
                }, 16, null, true);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/item/QFSPublicAccountStaggeredAutoPlayVideoSmallItemView$c", "Lcom/tencent/mobileqq/qcircle/picload/listener/QCirclePicStateListener;", "Lcom/tencent/libra/LoadState;", "state", "Lcom/tencent/libra/request/Option;", "option", "", "onStateChange", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class c extends QCirclePicStateListener {
        c() {
        }

        @Override // com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener, com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(@NotNull LoadState state, @NotNull Option option) {
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(option, "option");
            if (state == LoadState.STATE_SUCCESS) {
                QFSPublicAccountStaggeredAutoPlayVideoSmallItemView.this.transitionBitmap = option.getResultBitMap();
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\f\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/item/QFSPublicAccountStaggeredAutoPlayVideoSmallItemView$d", "Lcom/tencent/biz/richframework/video/rfw/player/ioc/RFWPlayerIOC;", "", AppConstants.Key.COLUMN_IS_VALID, "Lcom/tencent/biz/richframework/video/rfw/player/stinfo/RFWPlayerReportInfo;", "getBusinessReportInfo", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class d extends RFWPlayerIOC {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ FeedCloudMeta$StFeed f86789e;

        d(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
            this.f86789e = feedCloudMeta$StFeed;
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.ioc.RFWPlayerIOC
        @NotNull
        public RFWPlayerReportInfo<?> getBusinessReportInfo() {
            RFWPlayerReportInfo<e30.b> m3 = gb0.b.m(new e30.b(this.f86789e).o("KEY_RFW_VIDEO_FEED_POI", QFSPublicAccountStaggeredAutoPlayVideoSmallItemView.this.getMPoi()));
            Intrinsics.checkNotNullExpressionValue(m3, "coverToReportInfo(\n     \u2026_POI, mPoi)\n            )");
            return m3;
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.ioc.RFWPlayerIOC
        public boolean isValid() {
            return QFSPublicAccountStaggeredAutoPlayVideoSmallItemView.this.isAttachedToWindow();
        }
    }

    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J \u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007H\u0016\u00a8\u0006\u0011"}, d2 = {"com/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/item/QFSPublicAccountStaggeredAutoPlayVideoSmallItemView$e", "Lcom/tencent/biz/richframework/video/rfw/player/listener/IRFWPlayerSeekListener;", "Landroid/widget/SeekBar;", "seekBar", "", "onStartTrackingTouch", "onStopTrackingTouch", "", "progress", "", "fromUser", "onSeekBarProgressChanged", "", "timeString", "videoDuration", "currentDuration", "onProgress", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class e implements IRFWPlayerSeekListener {
        e() {
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSeekListener
        public void onProgress(@NotNull String timeString, int videoDuration, int currentDuration) {
            Intrinsics.checkNotNullParameter(timeString, "timeString");
            QFSPublicAccountStaggeredAutoPlayVideoSmallItemView.f86784a0 = currentDuration;
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSeekListener
        public void onSeekBarProgressChanged(@NotNull SeekBar seekBar, int progress, boolean fromUser) {
            Intrinsics.checkNotNullParameter(seekBar, "seekBar");
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSeekListener
        public void onStartTrackingTouch(@NotNull SeekBar seekBar) {
            Intrinsics.checkNotNullParameter(seekBar, "seekBar");
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSeekListener
        public void onStopTrackingTouch(@NotNull SeekBar seekBar) {
            Intrinsics.checkNotNullParameter(seekBar, "seekBar");
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/item/QFSPublicAccountStaggeredAutoPlayVideoSmallItemView$f", "Lcom/tencent/biz/richframework/video/rfw/player/listener/IRFWPlayerPrepareListener;", "Lcom/tencent/biz/richframework/video/rfw/RFWPlayer;", "player", "", "onVideoPrepared", "onFirstFrameRendered", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class f implements IRFWPlayerPrepareListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f86790d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QFSPublicAccountStaggeredAutoPlayVideoSmallItemView f86791e;

        f(String str, QFSPublicAccountStaggeredAutoPlayVideoSmallItemView qFSPublicAccountStaggeredAutoPlayVideoSmallItemView) {
            this.f86790d = str;
            this.f86791e = qFSPublicAccountStaggeredAutoPlayVideoSmallItemView;
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener
        public void onFirstFrameRendered(@NotNull RFWPlayer player) {
            Intrinsics.checkNotNullParameter(player, "player");
            QLog.d("QFSPublicAccountStaggeredAutoVideoItemView", 1, "onFirstFrameRendered urlKey: " + this.f86790d);
            this.f86791e.h1();
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener
        public void onVideoPrepared(@NotNull RFWPlayer player) {
            Intrinsics.checkNotNullParameter(player, "player");
            QLog.d("QFSPublicAccountStaggeredAutoVideoItemView", 1, "onVideoPrepared urlKey: " + this.f86790d);
            QFSPublicAccountStaggeredAutoPlayVideoSmallItemView qFSPublicAccountStaggeredAutoPlayVideoSmallItemView = this.f86791e;
            ISuperPlayer realPlayer = player.getRealPlayer();
            Intrinsics.checkNotNullExpressionValue(realPlayer, "player.realPlayer");
            qFSPublicAccountStaggeredAutoPlayVideoSmallItemView.onVideoPrepared(realPlayer);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QFSPublicAccountStaggeredAutoPlayVideoSmallItemView(@NotNull Context context, @NotNull QCircleInitBean initBean, @NotNull com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.a feedsOperator) {
        super(context, initBean, feedsOperator);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        Intrinsics.checkNotNullParameter(feedsOperator, "feedsOperator");
        this.initBean = initBean;
        View findViewById = findViewById(R.id.u_x);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.cover_image_container)");
        this.videoAreaLayout = (RelativeLayout) findViewById;
        View findViewById2 = findViewById(R.id.u_t);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.cover_blur_view)");
        this.coverBlurView = (ImageView) findViewById2;
        View findViewById3 = findViewById(R.id.f57262mu);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.qfs_video_view)");
        this.feedVideoView = (QFSVideoView) findViewById3;
        View findViewById4 = findViewById(R.id.uoy);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.duration_time)");
        this.feedDurationText = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.f47301wx);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.qfs_mix_feed_tag_view)");
        this.tagView = (QFSMixFeedTagView) findViewById5;
        View findViewById6 = findViewById(R.id.f54622fp);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.qfs_stagger_banner_layout)");
        this.mBannerLayout = (LinearLayout) findViewById6;
        View findViewById7 = findViewById(R.id.f54642fr);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.qfs_stagger_banner_text)");
        this.mBannerText = (QCircleAsyncTextView) findViewById7;
        View findViewById8 = findViewById(R.id.f54612fo);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.qfs_stagger_banner_icon)");
        this.mBannerIcon = (ImageView) findViewById8;
    }

    private final void Y0() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        e30.b bVar = this.currentFeedBlockData;
        if (bVar != null) {
            feedCloudMeta$StFeed = bVar.g();
        } else {
            feedCloudMeta$StFeed = null;
        }
        if (feedCloudMeta$StFeed == null) {
            QLog.e("QFSPublicAccountStaggeredAutoVideoItemView", 1, "currentFeed is null, adjustViewSize failed.");
            return;
        }
        int i3 = feedCloudMeta$StFeed.video.width.get();
        int i16 = feedCloudMeta$StFeed.video.height.get();
        Pair<Integer, Integer> b16 = com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.ktx.d.b(feedCloudMeta$StFeed);
        QLog.d("QFSPublicAccountStaggeredAutoVideoItemView", 2, "adjustViewSize coverRatio: " + b16 + ", videoWidth: " + i3 + ", videoHeight: " + i16);
        if (i3 > 0 && i16 > 0) {
            int i17 = f86785b0;
            int intValue = (b16.getSecond().intValue() * i17) / b16.getFirst().intValue();
            int i18 = (i17 * i16) / i3;
            QLog.d("QFSPublicAccountStaggeredAutoVideoItemView", 2, "adjustViewSize cardWidth: " + i17 + ", cardHeight: " + intValue + ", height: " + i18);
            ISuperPlayer superPlayer = this.feedVideoView.getSuperPlayer();
            if (superPlayer != null) {
                if (i16 > i3) {
                    superPlayer.getVideoView().setFixedSize(i17, intValue);
                    superPlayer.setXYaxis(3);
                } else {
                    superPlayer.getVideoView().setFixedSize(i17, i18);
                    superPlayer.setXYaxis(0);
                }
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.item.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        QFSPublicAccountStaggeredAutoPlayVideoSmallItemView.Z0(QFSPublicAccountStaggeredAutoPlayVideoSmallItemView.this);
                    }
                }, 16, null, true);
                return;
            }
            return;
        }
        QLog.e("QFSPublicAccountStaggeredAutoVideoItemView", 1, "video size is invalid, adjustViewSize failed.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z0(final QFSPublicAccountStaggeredAutoPlayVideoSmallItemView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.item.c
            @Override // java.lang.Runnable
            public final void run() {
                QFSPublicAccountStaggeredAutoPlayVideoSmallItemView.a1(QFSPublicAccountStaggeredAutoPlayVideoSmallItemView.this);
            }
        });
    }

    private final void a() {
        String str;
        PBStringField pBStringField;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.currentFeed;
        if (feedCloudMeta$StFeed != null && (pBStringField = feedCloudMeta$StFeed.content) != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        QLog.d("QFSPublicAccountStaggeredAutoVideoItemView", 1, "release player: " + str);
        getFeedCoverView().setVisibility(0);
        VideoReport.unbindVideoPlayerInfo(this.feedVideoView);
        this.feedVideoView.release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a1(QFSPublicAccountStaggeredAutoPlayVideoSmallItemView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.feedVideoView.requestLayout();
    }

    private final void b1() {
        QLog.d("QFSPublicAccountStaggeredAutoVideoItemView", 1, "initAndStartPlayer");
        if (!isAttachedToWindow()) {
            return;
        }
        getFeedCoverView().setVisibility(0);
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.currentFeed;
        if (feedCloudMeta$StFeed == null) {
            return;
        }
        String playUrlKey = com.tencent.biz.qqcircle.immersive.utils.r.N(feedCloudMeta$StFeed.video.playUrl.get());
        this.feedVideoView.setData(feedCloudMeta$StFeed, 0);
        this.feedVideoView.setReportBean(getReportBean());
        QLog.d("QFSPublicAccountStaggeredAutoVideoItemView", 1, "initOrResetPlayer playUrlKey: " + playUrlKey + " feedId = " + feedCloudMeta$StFeed.f398449id.get() + APLogFileUtil.SEPARATOR_LOG + feedCloudMeta$StFeed.content + " traceId: " + ba.d(feedCloudMeta$StFeed));
        RFWPlayerOptions playerOptions = RFWPlayerOptions.obtain(QCircleHostConstants._SceneID.QQ_CIRCLE_VIDEO());
        playerOptions.setPlayUrl(feedCloudMeta$StFeed.video.playUrl.get());
        playerOptions.setFileId(feedCloudMeta$StFeed.video.fileId.get());
        playerOptions.setStVideo(gb0.b.k(feedCloudMeta$StFeed.video));
        playerOptions.setStartOffset(f86784a0);
        playerOptions.setFromType(14);
        Intrinsics.checkNotNullExpressionValue(playerOptions, "playerOptions");
        Intrinsics.checkNotNullExpressionValue(playUrlKey, "playUrlKey");
        i1(playerOptions, feedCloudMeta$StFeed, playUrlKey);
        k1(this.feedVideoView);
        this.feedVideoView.loadPlayOptions(playerOptions);
    }

    private final void c1(FeedCloudMeta$StFeed feed) {
        Pair<Integer, Integer> b16 = com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.ktx.d.b(feed);
        int i3 = f86785b0;
        int intValue = (b16.getSecond().intValue() * i3) / b16.getFirst().intValue();
        RelativeLayout relativeLayout = this.videoAreaLayout;
        ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
        layoutParams.height = intValue;
        relativeLayout.setLayoutParams(layoutParams);
        Option requestHeight = g1(feed).setTargetView(getFeedCoverView()).setRequestWidth(i3).setRequestHeight(intValue);
        q50.b.e().q(requestHeight, false);
        QCircleFeedPicLoader.g().loadImage(requestHeight);
        QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(feed.cover.picUrl.get()).disableHardwareDecode().setPreferDecodeFormat(DecodeFormat.PREFER_ARGB_8888).setRequestWidth(i3).setRequestHeight(intValue), new b());
        QCircleFeedPicLoader.g().loadImage(g1(feed).setRequestWidth(i3).setRequestHeight(intValue), new c());
    }

    private final void d1(FeedCloudMeta$StFeed feed) {
        boolean z16;
        String c16;
        int i3 = 8;
        this.feedDurationText.setVisibility(8);
        if (feed.type.get() == 3) {
            long j3 = feed.video.duration.get();
            if (60000 <= j3 && j3 < 86400001) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                if (feed.video.duration.get() > 3600000) {
                    c16 = cv.b(feed.video.duration.get());
                } else {
                    c16 = cv.c(feed.video.duration.get());
                }
                if (TextUtils.isEmpty(c16)) {
                    return;
                }
                this.feedDurationText.setText(c16);
                TextView textView = this.feedDurationText;
                if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("101454", true)) {
                    i3 = 0;
                }
                textView.setVisibility(i3);
            }
        }
    }

    private final void e1(FeedCloudMeta$StFeed feed) {
        boolean z16;
        List<FeedCloudMeta$StUser> list;
        FeedCloudMeta$RecomReasonV2 feedCloudMeta$RecomReasonV2;
        PBRepeatMessageField<FeedCloudMeta$StUser> pBRepeatMessageField;
        if (L0()) {
            this.mBannerLayout.setVisibility(8);
            QFSMixFeedTagView qFSMixFeedTagView = this.tagView;
            FeedCloudMeta$StFeed g16 = getData().g();
            Intrinsics.checkNotNullExpressionValue(g16, "data.sourceData");
            qFSMixFeedTagView.b(g16);
            return;
        }
        this.tagView.setVisibility(8);
        String recommendItem = feed.recomInfo.recomReasonV2.recomReason.get();
        Intrinsics.checkNotNullExpressionValue(recommendItem, "recommendItem");
        if (recommendItem.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this.mBannerLayout.setVisibility(8);
            return;
        }
        this.mBannerLayout.setVisibility(0);
        this.mBannerIcon.setVisibility(8);
        FeedCloudMeta$StRecomInfo feedCloudMeta$StRecomInfo = feed.recomInfo;
        String str = null;
        if (feedCloudMeta$StRecomInfo != null && (feedCloudMeta$RecomReasonV2 = feedCloudMeta$StRecomInfo.recomReasonV2) != null && (pBRepeatMessageField = feedCloudMeta$RecomReasonV2.recomUserInfo) != null) {
            list = pBRepeatMessageField.get();
        } else {
            list = null;
        }
        if (list != null) {
            str = com.tencent.biz.qqcircle.utils.o.b(list, list.size());
        }
        if (str == null) {
            str = "";
        }
        TextPaint paint = this.mBannerText.getPaint();
        int a16 = (com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.o.INSTANCE.a() - cx.a(6.0f)) - cx.a(60.0f);
        QCircleAsyncTextView qCircleAsyncTextView = this.mBannerText;
        h50.b bVar = h50.b.f404331a;
        Intrinsics.checkNotNullExpressionValue(paint, "paint");
        qCircleAsyncTextView.setText(bVar.a(str, recommendItem, paint, a16));
    }

    private final void f1(FeedCloudMeta$StFeed newFeed) {
        boolean z16;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.currentFeed;
        if (feedCloudMeta$StFeed != null && com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.ktx.d.g(newFeed, feedCloudMeta$StFeed.f398449id.get())) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            this.currentFeed = newFeed;
        }
    }

    private final Option g1(FeedCloudMeta$StFeed feed) {
        Option preferDecodeFormat = Option.obtain().setUrl(feed.cover.picUrl.get()).setFromPreLoad(false).setPredecode(true).setSupportRecycler(true).disableHardwareDecode().setLoadingDrawableColor(QCircleSkinHelper.getInstance().getColor(R.color.qvideo_skin_color_tag_selected)).setFailedDrawableId(R.drawable.ojc).setPreferDecodeFormat(DecodeFormat.PREFER_RGB_565);
        Intrinsics.checkNotNullExpressionValue(preferDecodeFormat, "obtain()\n            .se\u2026odeFormat.PREFER_RGB_565)");
        return preferDecodeFormat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h1() {
        String str;
        PBStringField pBStringField;
        if (!isAttachedToWindow()) {
            return;
        }
        this.feedVideoView.setOutPutMute(true);
        getFeedCoverView().setVisibility(8);
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.currentFeed;
        if (feedCloudMeta$StFeed != null && (pBStringField = feedCloudMeta$StFeed.content) != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        QLog.d("QFSPublicAccountStaggeredAutoVideoItemView", 1, "onVideoStart: " + str);
    }

    private final void i1(RFWPlayerOptions rFWPlayerOptions, FeedCloudMeta$StFeed feedCloudMeta$StFeed, String str) {
        rFWPlayerOptions.setPlayIOC(new d(feedCloudMeta$StFeed));
        rFWPlayerOptions.getListenerSet().addSDKInitListeners(new IRFWPlayerSdkInitListener() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.item.a
            @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSdkInitListener
            public final void onInitSuccess(RFWPlayer rFWPlayer) {
                QFSPublicAccountStaggeredAutoPlayVideoSmallItemView.j1(QFSPublicAccountStaggeredAutoPlayVideoSmallItemView.this, rFWPlayer);
            }
        });
        rFWPlayerOptions.getListenerSet().addSeekListeners(new e());
        rFWPlayerOptions.getListenerSet().addPrepareListeners(new f(str, this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j1(QFSPublicAccountStaggeredAutoPlayVideoSmallItemView this$0, RFWPlayer rFWPlayer) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.feedVideoView.setOutPutMute(true);
        this$0.feedVideoView.setLoopBack(true);
    }

    private final void k1(QFSVideoView qFSVideoView) {
        Integer num;
        int i3;
        Object tag = getInteractArea().getTag();
        VideoEntity videoEntity = null;
        if (tag instanceof Integer) {
            num = (Integer) tag;
        } else {
            num = null;
        }
        if (num != null) {
            i3 = num.intValue();
        } else {
            i3 = 0;
        }
        int i16 = i3 + 1;
        if (qFSVideoView.getSuperPlayer() != null) {
            ISuperPlayer superPlayer = qFSVideoView.getSuperPlayer();
            e30.b bVar = this.currentFeedBlockData;
            if (bVar != null) {
                videoEntity = com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.report.l.f87082a.f(qFSVideoView, i16, y0() + 1, bVar, this.initBean);
            }
            VideoReport.bindVideoPlayerInfo(superPlayer, videoEntity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onVideoPrepared(ISuperPlayer player) {
        if (!isAttachedToWindow()) {
            return;
        }
        player.setXYaxis(3);
        Y0();
        this.feedVideoView.start();
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.item.QFSPublicAccountStaggeredBaseItemView
    @Nullable
    public Drawable A0() {
        Bitmap bitmap = this.transitionBitmap;
        if (bitmap != null) {
            return new BitmapDrawable(getResources(), bitmap);
        }
        return getFeedCoverView().getDrawable();
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.item.QFSPublicAccountStaggeredBaseItemView, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList arrayListOf;
        List plus;
        ArrayList<Class<SimpleBaseEvent>> eventClass = super.getEventClass();
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QFSPublicAccountStaggerLifecycleEvent.class, QFSVideoFeedPlayEvent.class);
        plus = CollectionsKt___CollectionsKt.plus((Collection) eventClass, (Iterable) arrayListOf);
        Intrinsics.checkNotNull(plus, "null cannot be cast to non-null type java.util.ArrayList<java.lang.Class<com.tencent.biz.richframework.eventbus.SimpleBaseEvent>>{ kotlin.collections.TypeAliasesKt.ArrayList<java.lang.Class<com.tencent.biz.richframework.eventbus.SimpleBaseEvent>> }");
        return (ArrayList) plus;
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.go9;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    @NotNull
    public String getLogTag() {
        return "QFSPublicAccountStaggeredAutoVideoItemView";
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.item.QFSPublicAccountStaggeredBaseItemView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        b1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.item.QFSPublicAccountStaggeredBaseItemView, com.tencent.biz.richframework.widget.BaseWidgetView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a();
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.item.QFSPublicAccountStaggeredBaseItemView, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@NotNull SimpleBaseEvent event) {
        String str;
        PBStringField pBStringField;
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof QFSPublicAccountStaggerLifecycleEvent) {
            QFSPublicAccountStaggerLifecycleEvent qFSPublicAccountStaggerLifecycleEvent = (QFSPublicAccountStaggerLifecycleEvent) event;
            if (qFSPublicAccountStaggerLifecycleEvent.getStatus() != 1 && qFSPublicAccountStaggerLifecycleEvent.getStatus() != 3) {
                if (qFSPublicAccountStaggerLifecycleEvent.getStatus() == 2) {
                    a();
                    return;
                }
                return;
            }
            b1();
            return;
        }
        if (event instanceof QFSVideoFeedPlayEvent) {
            String str2 = ((QFSVideoFeedPlayEvent) event).feedId;
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.currentFeed;
            if (feedCloudMeta$StFeed != null && (pBStringField = feedCloudMeta$StFeed.f398449id) != null) {
                str = pBStringField.get();
            } else {
                str = null;
            }
            if (Intrinsics.areEqual(str2, str)) {
                f86784a0 = r3.progress;
                return;
            }
            return;
        }
        super.onReceiveEvent(event);
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.item.QFSPublicAccountStaggeredBaseItemView
    /* renamed from: u0 */
    public long getCurrentPlayPosition() {
        return f86784a0;
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.item.QFSPublicAccountStaggeredBaseItemView
    public int y0() {
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.item.QFSPublicAccountStaggeredBaseItemView, com.tencent.biz.richframework.widget.BaseWidgetView
    public void bindData(@Nullable e30.b objData, int position) {
        super.bindData(objData, position);
        QLog.i("QFSPublicAccountStaggeredAutoVideoItemView", 1, "[bindData] position: " + position);
        this.currentFeedBlockData = objData;
        FeedCloudMeta$StFeed g16 = objData != null ? objData.g() : null;
        if (g16 == null) {
            return;
        }
        f1(g16);
        c1(g16);
        d1(g16);
        e1(g16);
    }
}
