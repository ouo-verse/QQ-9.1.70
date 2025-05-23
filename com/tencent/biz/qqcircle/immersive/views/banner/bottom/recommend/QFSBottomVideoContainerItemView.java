package com.tencent.biz.qqcircle.immersive.views.banner.bottom.recommend;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Size;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants;
import com.tencent.biz.qqcircle.immersive.manager.g;
import com.tencent.biz.qqcircle.immersive.utils.ac;
import com.tencent.biz.qqcircle.immersive.utils.r;
import com.tencent.biz.qqcircle.immersive.views.QFSVideoView;
import com.tencent.biz.qqcircle.immersive.views.banner.bottom.recommend.QFSBottomVideoContainerItemView;
import com.tencent.biz.qqcircle.richframework.widget.RoundCorneredFrameLayout;
import com.tencent.biz.qqcircle.utils.QFSQUIUtilsKt;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutLoaderStrategy;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoader;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoaderFactory;
import com.tencent.biz.richframework.video.rfw.RFWPlayer;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;
import com.tencent.biz.richframework.video.rfw.player.ioc.RFWPlayerIOC;
import com.tencent.biz.richframework.video.rfw.player.ioc.RFWPlayerUpperData;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerLifeCycle;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSeekListener;
import com.tencent.biz.richframework.video.rfw.player.playerprender.RFWPlayerPreRenderBean;
import com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerPreRenderHelper;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.MessageForQCircleFeed;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.view.ISPlayerVideoView;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StVideo;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import uq3.o;

/* compiled from: P */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 =2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002RSB\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\bP\u0010QJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u001a\u0010\u0013\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\rH\u0014J\b\u0010\u0015\u001a\u00020\u0014H\u0014J\b\u0010\u0016\u001a\u00020\rH\u0016J\u001a\u0010\u0019\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0018\u001a\u00020\rH\u0014J\u0012\u0010\u001c\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\u0006\u0010\u001d\u001a\u00020\u0004J\u0006\u0010\u001e\u001a\u00020\u0004J\b\u0010\u001f\u001a\u00020\u0004H\u0016J\u000e\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00100\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u0010)R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0018\u00107\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010;\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010\u0018\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010?\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010=R\u0016\u0010A\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010=R$\u0010G\u001a\u0004\u0018\u0001088\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bB\u0010:\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR$\u0010O\u001a\u0004\u0018\u00010H8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010N\u00a8\u0006T"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/views/banner/bottom/recommend/QFSBottomVideoContainerItemView;", "Lcom/tencent/biz/qqcircle/widgets/QCircleBaseWidgetView;", "Le30/b;", "Landroid/view/View$OnClickListener;", "", "r0", "s0", "v0", "u0", "x0", "Lcom/tencent/biz/richframework/video/rfw/player/RFWPlayerOptions;", "options", "q0", "", "index", "w0", "Landroid/content/Context;", "context", "viewType", "initView", "Lcom/tencent/biz/richframework/layoutinflater/RFWLayoutPreLoader;", "getLayoutPreLoader", "getLayoutId", "objData", com.tencent.luggage.wxa.c8.c.G, "bindData", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "y0", "pause", "release", "Lcom/tencent/biz/qqcircle/immersive/views/banner/bottom/recommend/QFSBottomVideoContainerItemView$b;", "listener", "setListener", "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCorneredFrameLayout;", "d", "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCorneredFrameLayout;", ParseCommon.CONTAINER, "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", ComicCancelRedPointPopItemData.JSON_KEY_COVER_IMG, "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", MessageForQCircleFeed.MSG_QCIRCLE_FEED_KEY_LIKE_COUNT, h.F, "likeImg", "Lcom/tencent/biz/qqcircle/immersive/views/QFSVideoView;", "i", "Lcom/tencent/biz/qqcircle/immersive/views/QFSVideoView;", "playView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/biz/qqcircle/immersive/views/banner/bottom/recommend/QFSBottomVideoContainerItemView$b;", "playListener", "Lfeedcloud/FeedCloudMeta$StFeed;", BdhLogUtil.LogTag.Tag_Conn, "Lfeedcloud/FeedCloudMeta$StFeed;", "feed", "D", "I", "E", "itemWidth", UserInfo.SEX_FEMALE, "itemHeight", "G", "getContainerFeed", "()Lfeedcloud/FeedCloudMeta$StFeed;", "setContainerFeed", "(Lfeedcloud/FeedCloudMeta$StFeed;)V", "containerFeed", "Landroid/util/Size;", "H", "Landroid/util/Size;", "getItemSize", "()Landroid/util/Size;", "setItemSize", "(Landroid/util/Size;)V", "itemSize", "<init>", "(Landroid/content/Context;)V", "a", "b", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSBottomVideoContainerItemView extends QCircleBaseWidgetView<e30.b> implements View.OnClickListener {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private FeedCloudMeta$StFeed feed;

    /* renamed from: D, reason: from kotlin metadata */
    private int pos;

    /* renamed from: E, reason: from kotlin metadata */
    private int itemWidth;

    /* renamed from: F, reason: from kotlin metadata */
    private int itemHeight;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private FeedCloudMeta$StFeed containerFeed;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private Size itemSize;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private RoundCorneredFrameLayout container;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ImageView coverImg;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView likeCount;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView likeImg;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private QFSVideoView playView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b playListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/views/banner/bottom/recommend/QFSBottomVideoContainerItemView$b;", "", "", "currentIndex", "", HippyQQPagView.EventName.ON_PLAY_END, "index", NodeProps.ON_CLICK, "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public interface b {
        void onClick(int index);

        void onPlayEnd(int currentIndex);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/biz/qqcircle/immersive/views/banner/bottom/recommend/QFSBottomVideoContainerItemView$c", "Lcom/tencent/biz/richframework/video/rfw/player/ioc/RFWPlayerIOC;", "Lcom/tencent/biz/richframework/video/rfw/player/ioc/RFWPlayerUpperData;", "getPlayerUpperData", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class c extends RFWPlayerIOC {
        c() {
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.ioc.RFWPlayerIOC
        @NotNull
        /* renamed from: getPlayerUpperData */
        public RFWPlayerUpperData getUpperData() {
            RFWPlayerUpperData rFWPlayerUpperData = new RFWPlayerUpperData();
            rFWPlayerUpperData.addValue("QFS_PLAYER_MUTE_KEY", Boolean.FALSE);
            return rFWPlayerUpperData;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/biz/qqcircle/immersive/views/banner/bottom/recommend/QFSBottomVideoContainerItemView$d", "Lcom/tencent/biz/richframework/video/rfw/player/listener/IRFWPlayerPrepareListener;", "Lcom/tencent/biz/richframework/video/rfw/RFWPlayer;", "player", "", "onVideoPrepared", "onFirstFrameRendered", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class d implements IRFWPlayerPrepareListener {
        d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(QFSBottomVideoContainerItemView this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            ImageView imageView = this$0.coverImg;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ComicCancelRedPointPopItemData.JSON_KEY_COVER_IMG);
                imageView = null;
            }
            imageView.setVisibility(8);
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener
        public void onFirstFrameRendered(@NotNull RFWPlayer player) {
            Intrinsics.checkNotNullParameter(player, "player");
            Handler uIHandler = RFWThreadManager.getUIHandler();
            final QFSBottomVideoContainerItemView qFSBottomVideoContainerItemView = QFSBottomVideoContainerItemView.this;
            uIHandler.post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.views.banner.bottom.recommend.d
                @Override // java.lang.Runnable
                public final void run() {
                    QFSBottomVideoContainerItemView.d.b(QFSBottomVideoContainerItemView.this);
                }
            });
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener
        public void onVideoPrepared(@NotNull RFWPlayer player) {
            ISPlayerVideoView iSPlayerVideoView;
            Intrinsics.checkNotNullParameter(player, "player");
            QFSVideoView qFSVideoView = QFSBottomVideoContainerItemView.this.playView;
            QFSVideoView qFSVideoView2 = null;
            if (qFSVideoView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("playView");
                qFSVideoView = null;
            }
            KeyEvent.Callback videoView = qFSVideoView.getQCirclePlayer().getVideoView();
            if (videoView instanceof ISPlayerVideoView) {
                iSPlayerVideoView = (ISPlayerVideoView) videoView;
            } else {
                iSPlayerVideoView = null;
            }
            if (QFSBottomVideoContainerItemView.this.feed != null && iSPlayerVideoView != null) {
                iSPlayerVideoView.setXYaxis(2);
            }
            player.setOutputMute(true);
            QFSVideoView qFSVideoView3 = QFSBottomVideoContainerItemView.this.playView;
            if (qFSVideoView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("playView");
            } else {
                qFSVideoView2 = qFSVideoView3;
            }
            qFSVideoView2.start();
            if (QFSBottomVideoContainerItemView.this.pos == 0) {
                QFSBottomVideoContainerItemView.this.w0(0);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/biz/qqcircle/immersive/views/banner/bottom/recommend/QFSBottomVideoContainerItemView$e", "Lcom/tencent/biz/richframework/video/rfw/player/listener/IRFWPlayerSeekListener;", "", "timeString", "", "videoDuration", "currentDuration", "", "onProgress", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class e implements IRFWPlayerSeekListener {
        e() {
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSeekListener
        public void onProgress(@Nullable String timeString, int videoDuration, int currentDuration) {
            if (currentDuration >= 5000 || currentDuration >= videoDuration) {
                QFSVideoView qFSVideoView = QFSBottomVideoContainerItemView.this.playView;
                QFSVideoView qFSVideoView2 = null;
                if (qFSVideoView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("playView");
                    qFSVideoView = null;
                }
                qFSVideoView.pause();
                QFSVideoView qFSVideoView3 = QFSBottomVideoContainerItemView.this.playView;
                if (qFSVideoView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("playView");
                } else {
                    qFSVideoView2 = qFSVideoView3;
                }
                qFSVideoView2.release();
                b bVar = QFSBottomVideoContainerItemView.this.playListener;
                if (bVar != null) {
                    bVar.onPlayEnd(QFSBottomVideoContainerItemView.this.pos);
                }
            }
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSeekListener
        public /* synthetic */ void onSeekBarProgressChanged(SeekBar seekBar, int i3, boolean z16) {
            re0.b.b(this, seekBar, i3, z16);
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSeekListener
        public /* synthetic */ void onStartTrackingTouch(SeekBar seekBar) {
            re0.b.c(this, seekBar);
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSeekListener
        public /* synthetic */ void onStopTrackingTouch(SeekBar seekBar) {
            re0.b.d(this, seekBar);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/biz/qqcircle/immersive/views/banner/bottom/recommend/QFSBottomVideoContainerItemView$f", "Lcom/tencent/biz/richframework/video/rfw/player/listener/IRFWPlayerLifeCycle;", "Lcom/tencent/biz/richframework/video/rfw/RFWPlayer;", "player", "", "onRelease", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class f implements IRFWPlayerLifeCycle {
        f() {
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
            ImageView imageView = QFSBottomVideoContainerItemView.this.coverImg;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ComicCancelRedPointPopItemData.JSON_KEY_COVER_IMG);
                imageView = null;
            }
            imageView.setVisibility(0);
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QFSBottomVideoContainerItemView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.itemWidth = ImmersiveUtils.dpToPx(72.0f);
        this.itemHeight = ImmersiveUtils.dpToPx(96.0f);
    }

    private final void q0(RFWPlayerOptions options) {
        if (options == null) {
            return;
        }
        options.setPlayIOC(new c());
        options.getListenerSet().addPrepareListeners(new d());
        options.getListenerSet().addSeekListeners(new e());
        options.getListenerSet().addLifeCycleListeners(new f());
    }

    private final void r0() {
        Size size = this.itemSize;
        if (size != null) {
            this.itemWidth = size.getWidth();
            this.itemHeight = size.getHeight();
        }
        RoundCorneredFrameLayout roundCorneredFrameLayout = this.container;
        RoundCorneredFrameLayout roundCorneredFrameLayout2 = null;
        if (roundCorneredFrameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
            roundCorneredFrameLayout = null;
        }
        roundCorneredFrameLayout.getLayoutParams().width = this.itemWidth;
        RoundCorneredFrameLayout roundCorneredFrameLayout3 = this.container;
        if (roundCorneredFrameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
        } else {
            roundCorneredFrameLayout2 = roundCorneredFrameLayout3;
        }
        roundCorneredFrameLayout2.getLayoutParams().height = this.itemHeight;
    }

    private final void s0() {
        String str;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.feed;
        ImageView imageView = null;
        if (feedCloudMeta$StFeed != null) {
            if (TextUtils.isEmpty(feedCloudMeta$StFeed.cover.layerPicUrl.get())) {
                str = feedCloudMeta$StFeed.cover.picUrl.get();
            } else {
                str = feedCloudMeta$StFeed.cover.layerPicUrl.get();
            }
            Option requestHeight = Option.obtain().setUrl(str).setRequestWidth(this.itemWidth).setRequestHeight(this.itemHeight);
            ImageView imageView2 = this.coverImg;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ComicCancelRedPointPopItemData.JSON_KEY_COVER_IMG);
                imageView2 = null;
            }
            Option loadingDrawableColor = requestHeight.setTargetView(imageView2).setLoadingDrawableColor(0);
            loadingDrawableColor.setSupportRecycler(true);
            QCircleFeedPicLoader.g().loadImage(loadingDrawableColor);
        }
        ImageView imageView3 = this.coverImg;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ComicCancelRedPointPopItemData.JSON_KEY_COVER_IMG);
        } else {
            imageView = imageView3;
        }
        imageView.setVisibility(0);
    }

    private final void u0() {
        String str;
        PBStringField pBStringField;
        PBStringField pBStringField2;
        Map<String, Object> params = new QCircleDTParamBuilder().buildElementParams();
        Map<String, Object> e16 = ua0.c.e(this.containerFeed);
        Intrinsics.checkNotNullExpressionValue(e16, "convertDataToDTParamsMap(containerFeed)");
        params.putAll(e16);
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put("xsj_item_index", Integer.valueOf(this.pos + 1));
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.feed;
        String str2 = null;
        if (feedCloudMeta$StFeed != null && (pBStringField2 = feedCloudMeta$StFeed.f398449id) != null) {
            str = pBStringField2.get();
        } else {
            str = null;
        }
        params.put(QCircleDaTongConstant.ElementParamKey.XSJ_TARGET_FEED_ID, str);
        RoundCorneredFrameLayout roundCorneredFrameLayout = this.container;
        if (roundCorneredFrameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
            roundCorneredFrameLayout = null;
        }
        VideoReport.setElementId(roundCorneredFrameLayout, QCircleDaTongConstant.ElementId.EM_XSJ_SOON_CONTAINER_LIST);
        RoundCorneredFrameLayout roundCorneredFrameLayout2 = this.container;
        if (roundCorneredFrameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
            roundCorneredFrameLayout2 = null;
        }
        VideoReport.setElementParams(roundCorneredFrameLayout2, params);
        RoundCorneredFrameLayout roundCorneredFrameLayout3 = this.container;
        if (roundCorneredFrameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
            roundCorneredFrameLayout3 = null;
        }
        VideoReport.setElementClickPolicy(roundCorneredFrameLayout3, ClickPolicy.REPORT_ALL);
        RoundCorneredFrameLayout roundCorneredFrameLayout4 = this.container;
        if (roundCorneredFrameLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
            roundCorneredFrameLayout4 = null;
        }
        VideoReport.setElementExposePolicy(roundCorneredFrameLayout4, ExposurePolicy.REPORT_ALL);
        RoundCorneredFrameLayout roundCorneredFrameLayout5 = this.container;
        if (roundCorneredFrameLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
            roundCorneredFrameLayout5 = null;
        }
        VideoReport.setElementEndExposePolicy(roundCorneredFrameLayout5, EndExposurePolicy.REPORT_ALL);
        RoundCorneredFrameLayout roundCorneredFrameLayout6 = this.container;
        if (roundCorneredFrameLayout6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
            roundCorneredFrameLayout6 = null;
        }
        FeedCloudMeta$StFeed feedCloudMeta$StFeed2 = this.feed;
        if (feedCloudMeta$StFeed2 != null && (pBStringField = feedCloudMeta$StFeed2.f398449id) != null) {
            str2 = pBStringField.get();
        }
        VideoReport.setElementReuseIdentifier(roundCorneredFrameLayout6, str2);
    }

    private final void v0() {
        String f16;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.feed;
        if (feedCloudMeta$StFeed != null) {
            if (feedCloudMeta$StFeed.likeInfo.count.get() == 0) {
                f16 = com.tencent.biz.qqcircle.utils.h.a(R.string.f193704_x);
            } else {
                f16 = r.f(feedCloudMeta$StFeed.likeInfo.count.get());
            }
            TextView textView = this.likeCount;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException(MessageForQCircleFeed.MSG_QCIRCLE_FEED_KEY_LIKE_COUNT);
                textView = null;
            }
            textView.setText(f16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w0(int index) {
        FeedCloudMeta$StVideo feedCloudMeta$StVideo;
        if (index != this.pos) {
            return;
        }
        boolean z16 = true;
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_fluency_9055", true)) {
            return;
        }
        RFWPlayerOptions obtain = RFWPlayerOptions.obtain(QCircleHostConstants._SceneID.QQ_CIRCLE_VIDEO());
        obtain.setFromType(10013);
        RFWPlayerPreRenderHelper rFWPlayerPreRenderHelper = RFWPlayerPreRenderHelper.getInstance();
        RFWPlayerPreRenderBean rFWPlayerPreRenderBean = new RFWPlayerPreRenderBean(QCircleHostConstants._SceneID.QQ_CIRCLE_VIDEO(), 10009);
        Context context = getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        RFWPlayerPreRenderBean sourceType = rFWPlayerPreRenderBean.setActivity((Activity) context).setSourceType(g.e().i(getReportBean()));
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.feed;
        if (feedCloudMeta$StFeed != null) {
            feedCloudMeta$StVideo = feedCloudMeta$StFeed.video;
        } else {
            feedCloudMeta$StVideo = null;
        }
        RFWPlayerPreRenderBean multiLevel = sourceType.setPreloadVideo(gb0.b.k(feedCloudMeta$StVideo)).setMultiLevel(true);
        if (!o.U0() || index <= 0) {
            z16 = false;
        }
        rFWPlayerPreRenderHelper.playerRender(gb0.b.f(multiLevel.setIsJumpTrigger(z16).setPlayerOptions(obtain)));
    }

    private final void x0() {
        String str;
        String str2;
        FeedCloudMeta$StVideo feedCloudMeta$StVideo;
        String str3;
        PBStringField pBStringField;
        FeedCloudMeta$StVideo feedCloudMeta$StVideo2;
        FeedCloudMeta$StVideo feedCloudMeta$StVideo3;
        PBStringField pBStringField2;
        FeedCloudMeta$StVideo feedCloudMeta$StVideo4;
        PBStringField pBStringField3;
        QFSVideoView qFSVideoView = this.playView;
        QFSVideoView qFSVideoView2 = null;
        if (qFSVideoView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playView");
            qFSVideoView = null;
        }
        qFSVideoView.setData(this.feed, this.pos);
        RFWPlayerOptions obtain = RFWPlayerOptions.obtain(QCircleHostConstants._SceneID.QQ_CIRCLE_VIDEO());
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.feed;
        if (feedCloudMeta$StFeed != null && (feedCloudMeta$StVideo4 = feedCloudMeta$StFeed.video) != null && (pBStringField3 = feedCloudMeta$StVideo4.playUrl) != null) {
            str = pBStringField3.get();
        } else {
            str = null;
        }
        RFWPlayerOptions playUrl = obtain.setPlayUrl(str);
        FeedCloudMeta$StFeed feedCloudMeta$StFeed2 = this.feed;
        if (feedCloudMeta$StFeed2 != null && (feedCloudMeta$StVideo3 = feedCloudMeta$StFeed2.video) != null && (pBStringField2 = feedCloudMeta$StVideo3.fileId) != null) {
            str2 = pBStringField2.get();
        } else {
            str2 = null;
        }
        RFWPlayerOptions fileId = playUrl.setFileId(str2);
        FeedCloudMeta$StFeed feedCloudMeta$StFeed3 = this.feed;
        if (feedCloudMeta$StFeed3 != null && (feedCloudMeta$StVideo2 = feedCloudMeta$StFeed3.video) != null) {
            feedCloudMeta$StVideo = feedCloudMeta$StVideo2.get();
        } else {
            feedCloudMeta$StVideo = null;
        }
        RFWPlayerOptions fromType = fileId.setStVideo(gb0.b.k(feedCloudMeta$StVideo)).setIsMutualExclusion(false).setFromType(16);
        String str4 = "QFSBottomVideoContainerItemView_" + fromType.tag();
        ac acVar = ac.f90062a;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed4 = this.feed;
        if (feedCloudMeta$StFeed4 != null && (pBStringField = feedCloudMeta$StFeed4.content) != null) {
            str3 = pBStringField.get();
        } else {
            str3 = null;
        }
        QLog.d(str4, 1, "fs_lifecycle  startANewPlayer:" + acVar.a(str3));
        q0(fromType);
        QFSVideoView qFSVideoView3 = this.playView;
        if (qFSVideoView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playView");
            qFSVideoView3 = null;
        }
        qFSVideoView3.loadPlayOptions(fromType);
        QFSVideoView qFSVideoView4 = this.playView;
        if (qFSVideoView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playView");
        } else {
            qFSVideoView2 = qFSVideoView4;
        }
        ISuperPlayer superPlayer = qFSVideoView2.getSuperPlayer();
        if (superPlayer != null) {
            superPlayer.setBusinessDownloadStrategy(5000, 5000, 5000, 5000);
        }
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.g8n;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    @NotNull
    public RFWLayoutPreLoader getLayoutPreLoader() {
        RFWLayoutLoaderStrategy c16 = l30.a.a().c();
        Intrinsics.checkNotNullExpressionValue(c16, "getInstance().layoutLoaderStrategy");
        return RFWLayoutPreLoaderFactory.getLayoutLoader(c16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public void initView(@Nullable Context context, int viewType) {
        super.initView(context, viewType);
        View findViewById = findViewById(R.id.f34640zp);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qfs_bo\u2026_recommend_video_item_fl)");
        RoundCorneredFrameLayout roundCorneredFrameLayout = (RoundCorneredFrameLayout) findViewById;
        this.container = roundCorneredFrameLayout;
        ImageView imageView = null;
        if (roundCorneredFrameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
            roundCorneredFrameLayout = null;
        }
        roundCorneredFrameLayout.setRadius(DisplayUtil.dip2px(context, 4.0f));
        RoundCorneredFrameLayout roundCorneredFrameLayout2 = this.container;
        if (roundCorneredFrameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
            roundCorneredFrameLayout2 = null;
        }
        roundCorneredFrameLayout2.setOnClickListener(this);
        View findViewById2 = findViewById(R.id.f74163vi);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.rfw_video_view_id)");
        this.playView = (QFSVideoView) findViewById2;
        View findViewById3 = findViewById(R.id.f517528y);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.qfs_recommend_video_cover)");
        this.coverImg = (ImageView) findViewById3;
        View findViewById4 = findViewById(R.id.f34650zq);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.qfs_bo\u2026mend_video_item_info_img)");
        this.likeImg = (ImageView) findViewById4;
        View findViewById5 = findViewById(R.id.f5177290);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.qfs_re\u2026mmend_video_playing_text)");
        this.likeCount = (TextView) findViewById5;
        ImageView imageView2 = this.likeImg;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("likeImg");
        } else {
            imageView = imageView2;
        }
        imageView.setImageDrawable(QFSQUIUtilsKt.f(context, R.drawable.qui_heart_filled, R.color.qui_common_icon_allwhite_primary));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        w0(this.pos);
        QFSVideoView qFSVideoView = this.playView;
        QFSVideoView qFSVideoView2 = null;
        if (qFSVideoView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playView");
            qFSVideoView = null;
        }
        qFSVideoView.pause();
        QFSVideoView qFSVideoView3 = this.playView;
        if (qFSVideoView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playView");
        } else {
            qFSVideoView2 = qFSVideoView3;
        }
        qFSVideoView2.release();
        b bVar = this.playListener;
        if (bVar != null) {
            bVar.onClick(this.pos);
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    public final void pause() {
        QFSVideoView qFSVideoView = this.playView;
        if (qFSVideoView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playView");
            qFSVideoView = null;
        }
        qFSVideoView.pause();
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public void release() {
        super.release();
        QFSVideoView qFSVideoView = this.playView;
        if (qFSVideoView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playView");
            qFSVideoView = null;
        }
        qFSVideoView.release();
        QLog.d("QFSBottomVideoContainerItemView", 1, "release");
    }

    public final void setContainerFeed(@Nullable FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        this.containerFeed = feedCloudMeta$StFeed;
    }

    public final void setItemSize(@Nullable Size size) {
        this.itemSize = size;
    }

    public final void setListener(@NotNull b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.playListener = listener;
    }

    public final void y0() {
        boolean z16;
        QFSVideoView qFSVideoView = this.playView;
        QFSVideoView qFSVideoView2 = null;
        if (qFSVideoView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playView");
            qFSVideoView = null;
        }
        RFWPlayer qCirclePlayer = qFSVideoView.getQCirclePlayer();
        boolean z17 = false;
        if (qCirclePlayer != null && qCirclePlayer.isPlaying()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QLog.d("QFSBottomVideoContainerItemView", 1, "[startPlay] isPlaying.");
            return;
        }
        QFSVideoView qFSVideoView3 = this.playView;
        if (qFSVideoView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playView");
            qFSVideoView3 = null;
        }
        RFWPlayer qCirclePlayer2 = qFSVideoView3.getQCirclePlayer();
        if (qCirclePlayer2 != null && qCirclePlayer2.isPausing()) {
            z17 = true;
        }
        if (z17) {
            QFSVideoView qFSVideoView4 = this.playView;
            if (qFSVideoView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("playView");
            } else {
                qFSVideoView2 = qFSVideoView4;
            }
            qFSVideoView2.start();
            QLog.d("QFSBottomVideoContainerItemView", 1, "[startPlay] start from pause.");
            return;
        }
        x0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public void bindData(@Nullable e30.b objData, int pos) {
        QFSVideoView qFSVideoView = null;
        this.feed = objData != null ? objData.g() : null;
        this.pos = pos;
        r0();
        s0();
        v0();
        QFSVideoView qFSVideoView2 = this.playView;
        if (qFSVideoView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playView");
        } else {
            qFSVideoView = qFSVideoView2;
        }
        qFSVideoView.setReportBean(getReportBean());
        u0();
    }
}
