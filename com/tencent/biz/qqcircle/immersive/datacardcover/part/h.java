package com.tencent.biz.qqcircle.immersive.datacardcover.part;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.events.QCircleConfigChangeEvent;
import com.tencent.biz.qqcircle.immersive.views.QFSVideoView;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.video.rfw.RFWPlayer;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import feedcloud.FeedCloudMeta$StFeed;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 <2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001=B\u0007\u00a2\u0006\u0004\b:\u0010;J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J \u0010\u000e\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0013\u001a\u00020\u0004H\u0002J\b\u0010\u0014\u001a\u00020\u0004H\u0002J\b\u0010\u0015\u001a\u00020\u0004H\u0002J\b\u0010\u0016\u001a\u00020\u0004H\u0002J\b\u0010\u0017\u001a\u00020\u0004H\u0002J\b\u0010\u0018\u001a\u00020\u0004H\u0002J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\u001a\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\u0010\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\tH\u0016J\u0010\u0010\"\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u0010\u0010#\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u0010\u0010$\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u0012\u0010&\u001a\u00020\u00042\b\u0010%\u001a\u0004\u0018\u00010\u0003H\u0016J\u0014\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030(0'H\u0016R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b7\u00108\u00a8\u0006>"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/datacardcover/part/h;", "Lcom/tencent/biz/qqcircle/bizparts/b;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "initData", "D9", "B9", "z9", "Landroid/view/View;", "view", "", "videoW", "videoH", "H9", "A9", "", NodeProps.VISIBLE, "G9", "C9", "J9", "I9", "K9", "E9", "F9", "", "getLogTag", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "onPartResume", "onPartPause", "onPartDestroy", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "Landroid/widget/FrameLayout;", "d", "Landroid/widget/FrameLayout;", "videoContainer", "Lcom/tencent/biz/qqcircle/immersive/views/QFSVideoView;", "e", "Lcom/tencent/biz/qqcircle/immersive/views/QFSVideoView;", "videoView", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "videoCover", "Lfeedcloud/FeedCloudMeta$StFeed;", tl.h.F, "Lfeedcloud/FeedCloudMeta$StFeed;", "feed", "<init>", "()V", "i", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class h extends com.tencent.biz.qqcircle.bizparts.b implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private FrameLayout videoContainer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private QFSVideoView videoView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ImageView videoCover;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private FeedCloudMeta$StFeed feed;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/biz/qqcircle/immersive/datacardcover/part/h$b", "Lcom/tencent/biz/richframework/video/rfw/player/listener/IRFWPlayerPrepareListener;", "Lcom/tencent/biz/richframework/video/rfw/RFWPlayer;", "player", "", "onVideoPrepared", "onFirstFrameRendered", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class b implements IRFWPlayerPrepareListener {
        b() {
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener
        public void onFirstFrameRendered(@NotNull RFWPlayer player) {
            Intrinsics.checkNotNullParameter(player, "player");
            QLog.d("QFSPersonalCoverPlayPart", 1, "startANewPlayer, onFirstFrameRendered ");
            h.this.G9(false);
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener
        public void onVideoPrepared(@NotNull RFWPlayer player) {
            Intrinsics.checkNotNullParameter(player, "player");
            QLog.d("QFSPersonalCoverPlayPart", 1, "startANewPlayer, onVideoPrepared ");
            ISuperPlayer realPlayer = player.getRealPlayer();
            if (realPlayer != null) {
                realPlayer.setXYaxis(2);
            }
            player.setLoopback(true);
            player.start();
        }
    }

    private final void A9() {
        G9(true);
        Option obtain = Option.obtain();
        ImageView imageView = this.videoCover;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoCover");
            imageView = null;
        }
        Option targetView = obtain.setTargetView(imageView);
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.feed;
        if (feedCloudMeta$StFeed == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
            feedCloudMeta$StFeed = null;
        }
        Option preferDecodeFormat = targetView.setUrl(feedCloudMeta$StFeed.cover.picUrl.get()).setPreferDecodeFormat(DecodeFormat.PREFER_RGB_565);
        ImageView imageView3 = this.videoCover;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoCover");
            imageView3 = null;
        }
        Option requestWidth = preferDecodeFormat.setRequestWidth(imageView3.getLayoutParams().width);
        ImageView imageView4 = this.videoCover;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoCover");
        } else {
            imageView2 = imageView4;
        }
        Option requestHeight = requestWidth.setRequestHeight(imageView2.getLayoutParams().height);
        requestHeight.setSupportRecycler(true);
        QCircleFeedPicLoader.g().loadImage(requestHeight);
    }

    private final void B9() {
        z9();
        A9();
        C9();
    }

    private final void C9() {
        J9();
    }

    private final void D9() {
        QCircleToast.h(R.string.f189383z9, 0);
        getActivity().finish();
    }

    private final void E9() {
        QLog.d("QFSPersonalCoverPlayPart", 1, "pausePlayer ");
        QFSVideoView qFSVideoView = this.videoView;
        QFSVideoView qFSVideoView2 = null;
        if (qFSVideoView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoView");
            qFSVideoView = null;
        }
        if (qFSVideoView.getSuperPlayer().isPlaying()) {
            QFSVideoView qFSVideoView3 = this.videoView;
            if (qFSVideoView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videoView");
            } else {
                qFSVideoView2 = qFSVideoView3;
            }
            qFSVideoView2.pause();
        }
    }

    private final void F9() {
        QLog.d("QFSPersonalCoverPlayPart", 1, "releasePlayer ");
        QFSVideoView qFSVideoView = this.videoView;
        if (qFSVideoView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoView");
            qFSVideoView = null;
        }
        qFSVideoView.release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G9(boolean visible) {
        int i3;
        ImageView imageView = this.videoCover;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoCover");
            imageView = null;
        }
        if (visible) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        imageView.setVisibility(i3);
    }

    private final void H9(View view, int videoW, int videoH) {
        FrameLayout.LayoutParams layoutParams;
        int instantScreenWidth = DisplayUtil.getInstantScreenWidth(view.getContext());
        float f16 = ((instantScreenWidth * 1.0f) / videoW) * videoH;
        int i3 = -1;
        try {
            if (!Float.isNaN(f16)) {
                i3 = (int) f16;
            }
        } catch (Exception e16) {
            QLog.w("QFSPersonalCoverPlayPart", 1, "setSize, error ", e16);
        }
        QLog.d("QFSPersonalCoverPlayPart", 1, "setSize, targetH: " + i3);
        ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
        if (layoutParams2 instanceof FrameLayout.LayoutParams) {
            layoutParams = (FrameLayout.LayoutParams) layoutParams2;
        } else {
            layoutParams = null;
        }
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(instantScreenWidth, i3);
        }
        layoutParams.width = instantScreenWidth;
        layoutParams.height = i3;
        layoutParams.gravity = 17;
        view.setLayoutParams(layoutParams);
    }

    private final void I9() {
        QLog.d("QFSPersonalCoverPlayPart", 1, "startANewPlayer ");
        RFWPlayerOptions obtain = RFWPlayerOptions.obtain(QCircleHostConstants._SceneID.QQ_CIRCLE_VIDEO());
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.feed;
        QFSVideoView qFSVideoView = null;
        if (feedCloudMeta$StFeed == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
            feedCloudMeta$StFeed = null;
        }
        RFWPlayerOptions playUrl = obtain.setPlayUrl(feedCloudMeta$StFeed.video.playUrl.get());
        FeedCloudMeta$StFeed feedCloudMeta$StFeed2 = this.feed;
        if (feedCloudMeta$StFeed2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
            feedCloudMeta$StFeed2 = null;
        }
        RFWPlayerOptions fileId = playUrl.setFileId(feedCloudMeta$StFeed2.video.fileId.get());
        FeedCloudMeta$StFeed feedCloudMeta$StFeed3 = this.feed;
        if (feedCloudMeta$StFeed3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
            feedCloudMeta$StFeed3 = null;
        }
        RFWPlayerOptions fromType = fileId.setStVideo(gb0.b.k(feedCloudMeta$StFeed3.video)).setFromType(3);
        fromType.getListenerSet().addPrepareListeners(new b());
        QFSVideoView qFSVideoView2 = this.videoView;
        if (qFSVideoView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoView");
        } else {
            qFSVideoView = qFSVideoView2;
        }
        qFSVideoView.loadPlayOptions(fromType);
    }

    private final void J9() {
        QFSVideoView qFSVideoView = this.videoView;
        QFSVideoView qFSVideoView2 = null;
        if (qFSVideoView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoView");
            qFSVideoView = null;
        }
        if (qFSVideoView.getSuperPlayer() == null) {
            QLog.d("QFSPersonalCoverPlayPart", 1, "startPlay, superPlayer is null ");
            I9();
            return;
        }
        QFSVideoView qFSVideoView3 = this.videoView;
        if (qFSVideoView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoView");
            qFSVideoView3 = null;
        }
        if (qFSVideoView3.isRelease()) {
            QLog.d("QFSPersonalCoverPlayPart", 1, "startPlay, released ");
            I9();
            return;
        }
        QFSVideoView qFSVideoView4 = this.videoView;
        if (qFSVideoView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoView");
            qFSVideoView4 = null;
        }
        if (qFSVideoView4.getSuperPlayer().isPlaying()) {
            QLog.d("QFSPersonalCoverPlayPart", 1, "startPlay, playing ");
            return;
        }
        QFSVideoView qFSVideoView5 = this.videoView;
        if (qFSVideoView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoView");
        } else {
            qFSVideoView2 = qFSVideoView5;
        }
        if (qFSVideoView2.getSuperPlayer().isPausing()) {
            QLog.d("QFSPersonalCoverPlayPart", 1, "startPlay, pausing ");
            K9();
        } else {
            QLog.d("QFSPersonalCoverPlayPart", 1, "startPlay ");
            I9();
        }
    }

    private final void K9() {
        QLog.d("QFSPersonalCoverPlayPart", 1, "startPlayerFromPause");
        QFSVideoView qFSVideoView = this.videoView;
        QFSVideoView qFSVideoView2 = null;
        if (qFSVideoView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoView");
            qFSVideoView = null;
        }
        if (qFSVideoView.getSuperPlayer().isPausing()) {
            QFSVideoView qFSVideoView3 = this.videoView;
            if (qFSVideoView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videoView");
            } else {
                qFSVideoView2 = qFSVideoView3;
            }
            qFSVideoView2.start();
        }
    }

    private final void initData() {
        QCircleInitBean qCircleInitBean;
        if (getActivity() == null) {
            D9();
            return;
        }
        if (!getActivity().getIntent().hasExtra("key_bundle_common_init_bean")) {
            D9();
            return;
        }
        Serializable serializableExtra = getActivity().getIntent().getSerializableExtra("key_bundle_common_init_bean");
        if (serializableExtra instanceof QCircleInitBean) {
            qCircleInitBean = (QCircleInitBean) serializableExtra;
        } else {
            qCircleInitBean = null;
        }
        if (qCircleInitBean == null) {
            D9();
            return;
        }
        FeedCloudMeta$StFeed feed = qCircleInitBean.getFeed();
        Intrinsics.checkNotNullExpressionValue(feed, "initBean.feed");
        this.feed = feed;
    }

    private final void z9() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.feed;
        FrameLayout frameLayout = null;
        if (feedCloudMeta$StFeed == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
            feedCloudMeta$StFeed = null;
        }
        int i3 = feedCloudMeta$StFeed.video.width.get();
        FeedCloudMeta$StFeed feedCloudMeta$StFeed2 = this.feed;
        if (feedCloudMeta$StFeed2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
            feedCloudMeta$StFeed2 = null;
        }
        int i16 = feedCloudMeta$StFeed2.video.height.get();
        FrameLayout frameLayout2 = this.videoContainer;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoContainer");
        } else {
            frameLayout = frameLayout2;
        }
        H9(frameLayout, i3, i16);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(QCircleConfigChangeEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSPersonalCoverPlayPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.f57002m5);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.qfs_video_container)");
        this.videoContainer = (FrameLayout) findViewById;
        View findViewById2 = rootView.findViewById(R.id.f57262mu);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.qfs_video_view)");
        this.videoView = (QFSVideoView) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.f57012m6);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.qfs_video_cover)");
        this.videoCover = (ImageView) findViewById3;
        B9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartCreate(activity, savedInstanceState);
        initData();
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartDestroy(activity);
        QLog.d("QFSPersonalCoverPlayPart", 1, "onPartDestroy ");
        F9();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartPause(activity);
        QLog.d("QFSPersonalCoverPlayPart", 1, "onPartPause ");
        E9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartResume(activity);
        QLog.d("QFSPersonalCoverPlayPart", 1, "onPartResume ");
        J9();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        if (event instanceof QCircleConfigChangeEvent) {
            z9();
        }
    }
}
