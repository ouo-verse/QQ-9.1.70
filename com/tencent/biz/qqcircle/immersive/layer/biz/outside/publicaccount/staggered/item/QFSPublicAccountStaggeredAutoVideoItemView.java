package com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.item;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSVideoFeedPlayEvent;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.events.QFSPublicAccountStaggerLifecycleEvent;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.item.QFSPublicAccountStaggeredAutoVideoItemView;
import com.tencent.biz.qqcircle.immersive.utils.ba;
import com.tencent.biz.qqcircle.immersive.views.QFSVideoView;
import com.tencent.biz.qqcircle.utils.cv;
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
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.event.QCircleKeyVolumeChangeEvent;
import com.tencent.mobileqq.qcircle.api.event.QCircleVolumeMuteChangeEvent;
import com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.screen.ScreenUtils;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.superplayer.api.ISuperPlayer;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.time.Duration;
import kotlin.time.TimeSource;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u00b2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 ]2\u00020\u0001:\u0002 ^B\u001f\u0012\u0006\u0010X\u001a\u00020W\u0012\u0006\u00108\u001a\u000205\u0012\u0006\u0010Z\u001a\u00020Y\u00a2\u0006\u0004\b[\u0010\\J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\u0002H\u0002J\u001c\u0010\u0013\u001a\u00020\u0002*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\fH\u0002J\b\u0010\u0014\u001a\u00020\u0002H\u0002J\u001c\u0010\u0018\u001a\u00020\u0002*\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\f\u0010\u001a\u001a\u00020\u0002*\u00020\u0019H\u0002J\u0010\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\b\u0010\u001e\u001a\u00020\u0002H\u0002J\b\u0010\u001f\u001a\u00020\u0002H\u0002J\b\u0010 \u001a\u00020\u0002H\u0002J\b\u0010!\u001a\u00020\u0016H\u0014J\b\u0010\"\u001a\u00020\fH\u0016J\u001a\u0010&\u001a\u00020\u00022\b\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010%\u001a\u00020\fH\u0014J\b\u0010'\u001a\u00020\fH\u0016J\n\u0010)\u001a\u0004\u0018\u00010(H\u0016J\b\u0010+\u001a\u00020*H\u0016J\b\u0010,\u001a\u00020\u0002H\u0014J\b\u0010-\u001a\u00020\u0002H\u0014J\u0010\u00100\u001a\u00020\u00022\u0006\u0010/\u001a\u00020.H\u0016J$\u00104\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0201j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020.02`3H\u0016R\u0014\u00108\u001a\u0002058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010;\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010=\u001a\u00020*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u00106R\u0018\u0010A\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010E\u001a\u00020B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0014\u0010I\u001a\u00020F8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0014\u0010M\u001a\u00020J8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0014\u0010P\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0014\u0010T\u001a\u00020Q8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0014\u0010V\u001a\u00020J8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bU\u0010L\u00a8\u0006_"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/item/QFSPublicAccountStaggeredAutoVideoItemView;", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/item/QFSPublicAccountStaggeredBaseItemView;", "", "e1", "Lfeedcloud/FeedCloudMeta$StFeed;", "feed", ICustomDataEditor.STRING_ARRAY_PARAM_1, "Lcom/tencent/libra/request/Option;", "g1", "newFeed", "f1", "b1", "", "from", "i1", "Y0", "Landroid/view/View;", "targetWidth", "targetHeight", "m1", "Z0", "Lcom/tencent/biz/richframework/video/rfw/player/RFWPlayerOptions;", "", "playUrlKey", "j1", "Lcom/tencent/biz/qqcircle/immersive/views/QFSVideoView;", "l1", "Lcom/tencent/superplayer/api/ISuperPlayer;", "player", "onVideoPrepared", "h1", "d1", "a", "getLogTag", "getLayoutId", "Le30/b;", "objData", "position", "bindData", "y0", "Landroid/graphics/drawable/Drawable;", "A0", "", "u0", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;", "J", "Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;", "initBean", "K", "Lfeedcloud/FeedCloudMeta$StFeed;", "currentFeed", "L", "currentPlayPosition", "Landroid/graphics/Bitmap;", "M", "Landroid/graphics/Bitmap;", "transitionBitmap", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/item/QFSPublicAccountStaggeredAutoVideoItemView$MuteOption;", "N", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/item/QFSPublicAccountStaggeredAutoVideoItemView$MuteOption;", "muteOption", "Landroid/widget/RelativeLayout;", "P", "Landroid/widget/RelativeLayout;", "videoAreaLayout", "Landroid/widget/ImageView;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/widget/ImageView;", "coverBlurView", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/biz/qqcircle/immersive/views/QFSVideoView;", "feedVideoView", "Landroid/widget/TextView;", ExifInterface.LATITUDE_SOUTH, "Landroid/widget/TextView;", "progressView", "T", "muteIcon", "Landroid/content/Context;", "context", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/presentation/a;", "feedsOperator", "<init>", "(Landroid/content/Context;Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/presentation/a;)V", "U", "MuteOption", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSPublicAccountStaggeredAutoVideoItemView extends QFSPublicAccountStaggeredBaseItemView {
    private static final int V;
    private static final int W;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final QCircleInitBean initBean;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private FeedCloudMeta$StFeed currentFeed;

    /* renamed from: L, reason: from kotlin metadata */
    private long currentPlayPosition;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private Bitmap transitionBitmap;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private MuteOption muteOption;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final RelativeLayout videoAreaLayout;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final ImageView coverBlurView;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final QFSVideoView feedVideoView;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final TextView progressView;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final ImageView muteIcon;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/item/QFSPublicAccountStaggeredAutoVideoItemView$MuteOption;", "", "(Ljava/lang/String;I)V", "NOT_SET", "IS_MUTE", "IS_NOT_MUTE", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes4.dex */
    public enum MuteOption {
        NOT_SET,
        IS_MUTE,
        IS_NOT_MUTE
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/item/QFSPublicAccountStaggeredAutoVideoItemView$b", "Lcom/tencent/mobileqq/qcircle/picload/listener/QCirclePicStateListener;", "Lcom/tencent/libra/LoadState;", "state", "Lcom/tencent/libra/request/Option;", "option", "", "onStateChange", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class b extends QCirclePicStateListener {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v1, types: [T, android.graphics.Bitmap] */
        public static final void c(final Ref.ObjectRef resultBitMap, final QFSPublicAccountStaggeredAutoVideoItemView this$0) {
            Intrinsics.checkNotNullParameter(resultBitMap, "$resultBitMap");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            long m1963markNowz9LOYto = TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto();
            i40.a aVar = i40.a.f407180a;
            Context context = this$0.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            T resultBitMap2 = resultBitMap.element;
            Intrinsics.checkNotNullExpressionValue(resultBitMap2, "resultBitMap");
            resultBitMap.element = i40.a.b(aVar, context, (Bitmap) resultBitMap2, 0.0f, 2, 0, 20, null);
            QLog.i("QFSPublicAccountStaggeredAutoVideoItemView", 1, "blur image cost: " + Duration.m1875toStringimpl(TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(m1963markNowz9LOYto)));
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.item.i
                @Override // java.lang.Runnable
                public final void run() {
                    QFSPublicAccountStaggeredAutoVideoItemView.b.d(QFSPublicAccountStaggeredAutoVideoItemView.this, resultBitMap);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public static final void d(QFSPublicAccountStaggeredAutoVideoItemView this$0, Ref.ObjectRef resultBitMap) {
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
                final QFSPublicAccountStaggeredAutoVideoItemView qFSPublicAccountStaggeredAutoVideoItemView = QFSPublicAccountStaggeredAutoVideoItemView.this;
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.item.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        QFSPublicAccountStaggeredAutoVideoItemView.b.c(Ref.ObjectRef.this, qFSPublicAccountStaggeredAutoVideoItemView);
                    }
                }, 16, null, true);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/item/QFSPublicAccountStaggeredAutoVideoItemView$c", "Lcom/tencent/mobileqq/qcircle/picload/listener/QCirclePicStateListener;", "Lcom/tencent/libra/LoadState;", "state", "Lcom/tencent/libra/request/Option;", "option", "", "onStateChange", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class c extends QCirclePicStateListener {
        c() {
        }

        @Override // com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener, com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(@NotNull LoadState state, @NotNull Option option) {
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(option, "option");
            if (state == LoadState.STATE_SUCCESS) {
                QFSPublicAccountStaggeredAutoVideoItemView.this.transitionBitmap = option.getResultBitMap();
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\f\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/item/QFSPublicAccountStaggeredAutoVideoItemView$d", "Lcom/tencent/biz/richframework/video/rfw/player/ioc/RFWPlayerIOC;", "", AppConstants.Key.COLUMN_IS_VALID, "Lcom/tencent/biz/richframework/video/rfw/player/stinfo/RFWPlayerReportInfo;", "getBusinessReportInfo", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class d extends RFWPlayerIOC {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ FeedCloudMeta$StFeed f86795e;

        d(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
            this.f86795e = feedCloudMeta$StFeed;
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.ioc.RFWPlayerIOC
        @NotNull
        public RFWPlayerReportInfo<?> getBusinessReportInfo() {
            RFWPlayerReportInfo<e30.b> m3 = gb0.b.m(new e30.b(this.f86795e).o("KEY_RFW_VIDEO_FEED_POI", QFSPublicAccountStaggeredAutoVideoItemView.this.getMPoi()));
            Intrinsics.checkNotNullExpressionValue(m3, "coverToReportInfo(\n     \u2026_POI, mPoi)\n            )");
            return m3;
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.ioc.RFWPlayerIOC
        public boolean isValid() {
            return QFSPublicAccountStaggeredAutoVideoItemView.this.isAttachedToWindow();
        }
    }

    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J \u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007H\u0016\u00a8\u0006\u0011"}, d2 = {"com/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/item/QFSPublicAccountStaggeredAutoVideoItemView$e", "Lcom/tencent/biz/richframework/video/rfw/player/listener/IRFWPlayerSeekListener;", "Landroid/widget/SeekBar;", "seekBar", "", "onStartTrackingTouch", "onStopTrackingTouch", "", "progress", "", "fromUser", "onSeekBarProgressChanged", "", "timeString", "videoDuration", "currentDuration", "onProgress", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class e implements IRFWPlayerSeekListener {
        e() {
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSeekListener
        public void onProgress(@NotNull String timeString, int videoDuration, int currentDuration) {
            Intrinsics.checkNotNullParameter(timeString, "timeString");
            QFSPublicAccountStaggeredAutoVideoItemView.this.progressView.setText(cv.c(videoDuration - currentDuration));
            QFSPublicAccountStaggeredAutoVideoItemView.this.currentPlayPosition = currentDuration;
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

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/item/QFSPublicAccountStaggeredAutoVideoItemView$f", "Lcom/tencent/biz/richframework/video/rfw/player/listener/IRFWPlayerPrepareListener;", "Lcom/tencent/biz/richframework/video/rfw/RFWPlayer;", "player", "", "onVideoPrepared", "onFirstFrameRendered", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class f implements IRFWPlayerPrepareListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f86797d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QFSPublicAccountStaggeredAutoVideoItemView f86798e;

        f(String str, QFSPublicAccountStaggeredAutoVideoItemView qFSPublicAccountStaggeredAutoVideoItemView) {
            this.f86797d = str;
            this.f86798e = qFSPublicAccountStaggeredAutoVideoItemView;
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener
        public void onFirstFrameRendered(@NotNull RFWPlayer player) {
            Intrinsics.checkNotNullParameter(player, "player");
            QLog.d("QFSPublicAccountStaggeredAutoVideoItemView", 1, "onFirstFrameRendered urlKey: " + this.f86797d);
            this.f86798e.h1();
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener
        public void onVideoPrepared(@NotNull RFWPlayer player) {
            Intrinsics.checkNotNullParameter(player, "player");
            QLog.d("QFSPublicAccountStaggeredAutoVideoItemView", 1, "onVideoPrepared urlKey: " + this.f86797d);
            QFSPublicAccountStaggeredAutoVideoItemView qFSPublicAccountStaggeredAutoVideoItemView = this.f86798e;
            ISuperPlayer realPlayer = player.getRealPlayer();
            Intrinsics.checkNotNullExpressionValue(realPlayer, "player.realPlayer");
            qFSPublicAccountStaggeredAutoVideoItemView.onVideoPrepared(realPlayer);
        }
    }

    static {
        int screenWidth = ScreenUtils.getScreenWidth(BaseApplication.getContext()) - (com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.o.INSTANCE.b() * 2);
        V = screenWidth;
        W = (screenWidth * 9) / 16;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QFSPublicAccountStaggeredAutoVideoItemView(@NotNull Context context, @NotNull QCircleInitBean initBean, @NotNull com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.a feedsOperator) {
        super(context, initBean, feedsOperator);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        Intrinsics.checkNotNullParameter(feedsOperator, "feedsOperator");
        this.initBean = initBean;
        this.muteOption = MuteOption.NOT_SET;
        View findViewById = findViewById(R.id.f1172470x);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.video_area_layout)");
        this.videoAreaLayout = (RelativeLayout) findViewById;
        View findViewById2 = findViewById(R.id.u_t);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.cover_blur_view)");
        this.coverBlurView = (ImageView) findViewById2;
        View findViewById3 = findViewById(R.id.f57262mu);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.qfs_video_view)");
        this.feedVideoView = (QFSVideoView) findViewById3;
        View findViewById4 = findViewById(R.id.g27);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.progress_text)");
        this.progressView = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.zkm);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.mute_icon)");
        this.muteIcon = (ImageView) findViewById5;
    }

    private final void Y0() {
        RelativeLayout relativeLayout = this.videoAreaLayout;
        int i3 = V;
        int i16 = W;
        relativeLayout.setLayoutParams(new LinearLayout.LayoutParams(i3, i16));
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.currentFeed;
        if (feedCloudMeta$StFeed == null) {
            QLog.e("QFSPublicAccountStaggeredAutoVideoItemView", 1, "currentFeed is null, adjustViewSize failed.");
            return;
        }
        int i17 = feedCloudMeta$StFeed.video.width.get();
        int i18 = feedCloudMeta$StFeed.video.height.get();
        if (i17 > 0 && i18 > 0) {
            if (i17 / i18 > 1.7777778f) {
                m1(this.feedVideoView, i3, (i18 * i3) / i17);
            } else {
                m1(this.feedVideoView, (i17 * i16) / i18, i16);
            }
            ISuperPlayer superPlayer = this.feedVideoView.getSuperPlayer();
            if (superPlayer != null) {
                superPlayer.setXYaxis(0);
                this.feedVideoView.requestLayout();
                return;
            }
            return;
        }
        QLog.e("QFSPublicAccountStaggeredAutoVideoItemView", 1, "video size is invalid, adjustViewSize failed.");
    }

    private final void Z0() {
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
        playerOptions.setStartOffset(this.currentPlayPosition);
        playerOptions.setFromType(14);
        Intrinsics.checkNotNullExpressionValue(playerOptions, "playerOptions");
        Intrinsics.checkNotNullExpressionValue(playUrlKey, "playUrlKey");
        j1(playerOptions, feedCloudMeta$StFeed, playUrlKey);
        l1(this.feedVideoView);
        this.feedVideoView.loadPlayOptions(playerOptions);
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

    private final void a1(FeedCloudMeta$StFeed feed) {
        Option targetView = g1(feed).setTargetView(getFeedCoverView());
        int i3 = V;
        Option requestWidth = targetView.setRequestWidth(i3);
        int i16 = W;
        Option requestHeight = requestWidth.setRequestHeight(i16);
        q50.b.e().q(requestHeight, false);
        QCircleFeedPicLoader.g().loadImage(requestHeight);
        QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(feed.cover.picUrl.get()).disableHardwareDecode().setPreferDecodeFormat(DecodeFormat.PREFER_ARGB_8888).setRequestWidth(i3 / 2).setRequestHeight(i16 / 2), new b());
        QCircleFeedPicLoader.g().loadImage(g1(feed).setRequestWidth(feed.cover.width.get()).setRequestHeight(feed.cover.height.get()), new c());
    }

    private final void b1() {
        this.muteIcon.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.item.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QFSPublicAccountStaggeredAutoVideoItemView.c1(QFSPublicAccountStaggeredAutoVideoItemView.this, view);
            }
        });
        i1(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c1(QFSPublicAccountStaggeredAutoVideoItemView this$0, View view) {
        MuteOption muteOption;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean z16 = !this$0.feedVideoView.getOutPutMute();
        this$0.feedVideoView.setOutPutMute(z16);
        if (z16) {
            muteOption = MuteOption.IS_MUTE;
        } else {
            muteOption = MuteOption.IS_NOT_MUTE;
        }
        this$0.muteOption = muteOption;
        this$0.i1(4);
        com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.report.g.f87070a.n(z16);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void d1() {
        MuteOption muteOption = this.muteOption;
        boolean z16 = true;
        if (muteOption == MuteOption.NOT_SET) {
            this.feedVideoView.setOutPutMute(true);
            this.muteOption = MuteOption.IS_MUTE;
        } else {
            QFSVideoView qFSVideoView = this.feedVideoView;
            if (muteOption == MuteOption.IS_NOT_MUTE) {
                z16 = false;
            }
            qFSVideoView.setOutPutMute(z16);
        }
        i1(3);
    }

    private final void e1() {
        getAuthorView().setTextColor(getContext().getResources().getColor(R.color.cla));
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
            this.currentPlayPosition = 0L;
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
        d1();
        getFeedCoverView().setVisibility(8);
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.currentFeed;
        if (feedCloudMeta$StFeed != null && (pBStringField = feedCloudMeta$StFeed.content) != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        QLog.d("QFSPublicAccountStaggeredAutoVideoItemView", 1, "onVideoStart: " + str);
    }

    private final void i1(int from) {
        boolean z16;
        int i3;
        if (this.muteOption != MuteOption.IS_NOT_MUTE) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.i("QFSPublicAccountStaggeredAutoVideoItemView", 1, "refreshMuteLayout: from: " + from + ", muteOption: " + z16);
        if (z16) {
            i3 = R.drawable.nrv;
        } else {
            i3 = R.drawable.f162061ns0;
        }
        this.muteIcon.setImageResource(i3);
    }

    private final void j1(RFWPlayerOptions rFWPlayerOptions, FeedCloudMeta$StFeed feedCloudMeta$StFeed, String str) {
        rFWPlayerOptions.setPlayIOC(new d(feedCloudMeta$StFeed));
        rFWPlayerOptions.getListenerSet().addSDKInitListeners(new IRFWPlayerSdkInitListener() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.item.g
            @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSdkInitListener
            public final void onInitSuccess(RFWPlayer rFWPlayer) {
                QFSPublicAccountStaggeredAutoVideoItemView.k1(QFSPublicAccountStaggeredAutoVideoItemView.this, rFWPlayer);
            }
        });
        rFWPlayerOptions.getListenerSet().addSeekListeners(new e());
        rFWPlayerOptions.getListenerSet().addPrepareListeners(new f(str, this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k1(QFSPublicAccountStaggeredAutoVideoItemView this$0, RFWPlayer rFWPlayer) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QFSVideoView qFSVideoView = this$0.feedVideoView;
        if (this$0.muteOption != MuteOption.IS_NOT_MUTE) {
            z16 = true;
        } else {
            z16 = false;
        }
        qFSVideoView.setOutPutMute(z16);
        this$0.feedVideoView.setLoopBack(true);
    }

    private final void l1(QFSVideoView qFSVideoView) {
        Integer num;
        int i3;
        Object tag = getInteractArea().getTag();
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
            VideoReport.bindVideoPlayerInfo(qFSVideoView.getSuperPlayer(), com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.report.l.f87082a.f(qFSVideoView, i16, y0() + 1, new e30.b(this.currentFeed), this.initBean));
        }
    }

    private final void m1(View view, int i3, int i16) {
        QLog.d("QFSPublicAccountStaggeredAutoVideoItemView", 1, "updateSize targetWidth: " + i3 + ", targetHeight: " + i16);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        layoutParams2.width = i3;
        layoutParams2.height = i16;
        view.setLayoutParams(layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onVideoPrepared(ISuperPlayer player) {
        if (!isAttachedToWindow()) {
            return;
        }
        player.setXYaxis(2);
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
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QFSPublicAccountStaggerLifecycleEvent.class, QCircleKeyVolumeChangeEvent.class, QCircleVolumeMuteChangeEvent.class, QFSVideoFeedPlayEvent.class);
        plus = CollectionsKt___CollectionsKt.plus((Collection) eventClass, (Iterable) arrayListOf);
        Intrinsics.checkNotNull(plus, "null cannot be cast to non-null type java.util.ArrayList<java.lang.Class<com.tencent.biz.richframework.eventbus.SimpleBaseEvent>>{ kotlin.collections.TypeAliasesKt.ArrayList<java.lang.Class<com.tencent.biz.richframework.eventbus.SimpleBaseEvent>> }");
        return (ArrayList) plus;
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.go8;
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
        Z0();
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
            Z0();
            return;
        }
        if (event instanceof QCircleKeyVolumeChangeEvent) {
            i1(2);
            return;
        }
        if (event instanceof QCircleVolumeMuteChangeEvent) {
            this.feedVideoView.setOutPutMute(((QCircleVolumeMuteChangeEvent) event).isMute());
            i1(3);
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
                this.currentPlayPosition = r5.progress;
                return;
            }
            return;
        }
        super.onReceiveEvent(event);
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.item.QFSPublicAccountStaggeredBaseItemView
    /* renamed from: u0, reason: from getter */
    public long getCurrentPlayPosition() {
        return this.currentPlayPosition;
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.item.QFSPublicAccountStaggeredBaseItemView
    public int y0() {
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.item.QFSPublicAccountStaggeredBaseItemView, com.tencent.biz.richframework.widget.BaseWidgetView
    public void bindData(@Nullable e30.b objData, int position) {
        super.bindData(objData, position);
        FeedCloudMeta$StFeed g16 = objData != null ? objData.g() : null;
        if (g16 == null) {
            return;
        }
        e1();
        a1(g16);
        f1(g16);
        b1();
        Y0();
    }
}
