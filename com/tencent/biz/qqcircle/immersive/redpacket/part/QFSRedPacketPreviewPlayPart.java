package com.tencent.biz.qqcircle.immersive.redpacket.part;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants;
import com.tencent.biz.qqcircle.immersive.redpacket.bean.QFSRedPacketPreviewBean;
import com.tencent.biz.qqcircle.immersive.views.QFSVideoView;
import com.tencent.biz.richframework.video.rfw.RFWPlayer;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayErrorStatusListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerLooperListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 92\u00020\u0001:\u0001:B\u0007\u00a2\u0006\u0004\b7\u00108J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u0012\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002J\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0006\u0010\u0017\u001a\u00020\u0002J\u0010\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u001c\u0010 \u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u00122\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016R\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010+R#\u00103\u001a\n .*\u0004\u0018\u00010-0-8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u0016\u00106\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105\u00a8\u0006;"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/redpacket/part/QFSRedPacketPreviewPlayPart;", "Lcom/tencent/biz/qqcircle/bizparts/b;", "", "C9", "", NodeProps.VISIBLE, "J9", "E9", "startNewPlayer", "M9", "K9", "O9", "H9", "I9", "", "startTime", "endTime", "G9", "", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "D9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "onPartPause", "onPartDestroy", "action", "", "args", "handleBroadcastMessage", "Landroid/widget/FrameLayout;", "d", "Landroid/widget/FrameLayout;", "videoContainer", "Lcom/tencent/biz/qqcircle/immersive/views/QFSVideoView;", "e", "Lcom/tencent/biz/qqcircle/immersive/views/QFSVideoView;", "videoView", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "videoCover", "Lcom/tencent/biz/qqcircle/immersive/redpacket/viewmodel/h;", "kotlin.jvm.PlatformType", tl.h.F, "Lkotlin/Lazy;", "F9", "()Lcom/tencent/biz/qqcircle/immersive/redpacket/viewmodel/h;", "viewModel", "i", "I", "loopStartTime", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSRedPacketPreviewPlayPart extends com.tencent.biz.qqcircle.bizparts.b {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private FrameLayout videoContainer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private QFSVideoView videoView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ImageView videoCover;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private volatile int loopStartTime;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/biz/qqcircle/immersive/redpacket/part/QFSRedPacketPreviewPlayPart$b", "Lcom/tencent/biz/richframework/video/rfw/player/listener/IRFWPlayerPrepareListener;", "Lcom/tencent/biz/richframework/video/rfw/RFWPlayer;", "player", "", "onVideoPrepared", "onFirstFrameRendered", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class b implements IRFWPlayerPrepareListener {
        b() {
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener
        public void onFirstFrameRendered(@NotNull RFWPlayer player) {
            Intrinsics.checkNotNullParameter(player, "player");
            QLog.d("QFSRedPacketPreviewPlayPart", 1, "startANewPlayer, onFirstFrameRendered ");
            QFSRedPacketPreviewPlayPart.this.J9(false);
            ISuperPlayer realPlayer = player.getRealPlayer();
            if (realPlayer != null) {
                realPlayer.setOutputMute(true);
            }
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener
        public void onVideoPrepared(@NotNull RFWPlayer player) {
            Intrinsics.checkNotNullParameter(player, "player");
            QLog.d("QFSRedPacketPreviewPlayPart", 1, "startANewPlayer, onVideoPrepared ");
            ISuperPlayer realPlayer = player.getRealPlayer();
            if (realPlayer != null) {
                realPlayer.setXYaxis(2);
                realPlayer.setOutputMute(true);
            }
            player.setLoopback(true);
            player.start();
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/biz/qqcircle/immersive/redpacket/part/QFSRedPacketPreviewPlayPart$c", "Lcom/tencent/biz/richframework/video/rfw/player/listener/IRFWPlayerLooperListener;", "", "onVideoLoopStart", "onVideoLoopEnd", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class c implements IRFWPlayerLooperListener {
        c() {
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerLooperListener
        public void onVideoLoopEnd() {
            QLog.d("QFSRedPacketPreviewPlayPart", 1, "startANewPlayer, onVideoLoopEnd ");
            QFSVideoView qFSVideoView = QFSRedPacketPreviewPlayPart.this.videoView;
            if (qFSVideoView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videoView");
                qFSVideoView = null;
            }
            ISuperPlayer superPlayer = qFSVideoView.getSuperPlayer();
            if (superPlayer != null) {
                superPlayer.seekTo(QFSRedPacketPreviewPlayPart.this.loopStartTime, 3);
            }
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerLooperListener
        public void onVideoLoopStart() {
            QLog.d("QFSRedPacketPreviewPlayPart", 1, "startANewPlayer, onVideoLoopStart ");
        }
    }

    public QFSRedPacketPreviewPlayPart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.biz.qqcircle.immersive.redpacket.viewmodel.h>() { // from class: com.tencent.biz.qqcircle.immersive.redpacket.part.QFSRedPacketPreviewPlayPart$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.biz.qqcircle.immersive.redpacket.viewmodel.h invoke() {
                return (com.tencent.biz.qqcircle.immersive.redpacket.viewmodel.h) QFSRedPacketPreviewPlayPart.this.getViewModel(com.tencent.biz.qqcircle.immersive.redpacket.viewmodel.h.class);
            }
        });
        this.viewModel = lazy;
    }

    private final void C9() {
        boolean z16;
        String str;
        J9(true);
        QFSRedPacketPreviewBean P1 = F9().P1();
        if (P1.getLocalCoverPath().length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            str = P1.getLocalCoverPath();
        } else {
            str = P1.getFeed().cover.picUrl.get();
        }
        QLog.d("QFSRedPacketPreviewPlayPart", 1, "bindCoverData, coverPath:" + str);
        Option obtain = Option.obtain();
        ImageView imageView = this.videoCover;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoCover");
            imageView = null;
        }
        Option preferDecodeFormat = obtain.setTargetView(imageView).setUrl(str).setPreferDecodeFormat(DecodeFormat.PREFER_RGB_565);
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

    private final void E9() {
        M9(true);
    }

    private final com.tencent.biz.qqcircle.immersive.redpacket.viewmodel.h F9() {
        return (com.tencent.biz.qqcircle.immersive.redpacket.viewmodel.h) this.viewModel.getValue();
    }

    private final void G9(int startTime, int endTime) {
        QFSVideoView qFSVideoView = this.videoView;
        Unit unit = null;
        if (qFSVideoView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoView");
            qFSVideoView = null;
        }
        ISuperPlayer superPlayer = qFSVideoView.getSuperPlayer();
        if (superPlayer != null) {
            long j3 = startTime;
            long j16 = endTime;
            QLog.d("QFSRedPacketPreviewPlayPart", 1, "handleClipVideo, startTime:" + j3 + ", endTime:" + j16);
            superPlayer.pause();
            superPlayer.seekTo(startTime, 3);
            superPlayer.setLoopback(true, j3, j16);
            superPlayer.setOutputMute(true);
            superPlayer.start();
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            QLog.w("QFSRedPacketPreviewPlayPart", 1, "handleClipVideo, superPlayer is null ");
        }
    }

    private final void H9() {
        QFSVideoView qFSVideoView = this.videoView;
        QFSVideoView qFSVideoView2 = null;
        if (qFSVideoView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoView");
            qFSVideoView = null;
        }
        ISuperPlayer superPlayer = qFSVideoView.getSuperPlayer();
        boolean z16 = false;
        if (superPlayer != null && superPlayer.isPlaying()) {
            z16 = true;
        }
        if (z16) {
            QLog.d("QFSRedPacketPreviewPlayPart", 1, "pausePlayer ");
            QFSVideoView qFSVideoView3 = this.videoView;
            if (qFSVideoView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videoView");
            } else {
                qFSVideoView2 = qFSVideoView3;
            }
            qFSVideoView2.pause();
        }
    }

    private final void I9() {
        QLog.d("QFSRedPacketPreviewPlayPart", 1, "releasePlayer ");
        QFSVideoView qFSVideoView = this.videoView;
        if (qFSVideoView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoView");
            qFSVideoView = null;
        }
        qFSVideoView.release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J9(boolean visible) {
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

    private final void K9() {
        QLog.d("QFSRedPacketPreviewPlayPart", 1, "startANewPlayer ");
        RFWPlayerOptions fromType = RFWPlayerOptions.obtain(QCircleHostConstants._SceneID.QQ_CIRCLE_VIDEO()).setPlayUrl(F9().P1().getLocalVideoPath()).setFromType(13);
        fromType.getListenerSet().addPrepareListeners(new b());
        fromType.getListenerSet().addLooperListeners(new c());
        fromType.getListenerSet().addErrorStatusListener(new IRFWPlayErrorStatusListener() { // from class: com.tencent.biz.qqcircle.immersive.redpacket.part.ao
            @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayErrorStatusListener
            public final void onVideoPlayError(int i3, int i16, int i17, String str) {
                QFSRedPacketPreviewPlayPart.L9(i3, i16, i17, str);
            }
        });
        QFSVideoView qFSVideoView = this.videoView;
        if (qFSVideoView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoView");
            qFSVideoView = null;
        }
        qFSVideoView.loadPlayOptions(fromType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(int i3, int i16, int i17, String str) {
        QLog.w("QFSRedPacketPreviewPlayPart", 1, "startANewPlayer, onVideoPlayError, module:" + i3 + ", errorType:" + i16 + ", errorCode:" + i17 + ", extraInfo:" + str);
    }

    private final void M9(boolean startNewPlayer) {
        QLog.d("QFSRedPacketPreviewPlayPart", 1, "startPlay, startNewPlayer:" + startNewPlayer);
        if (!startNewPlayer) {
            QFSVideoView qFSVideoView = this.videoView;
            QFSVideoView qFSVideoView2 = null;
            if (qFSVideoView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videoView");
                qFSVideoView = null;
            }
            if (qFSVideoView.getSuperPlayer() != null) {
                QFSVideoView qFSVideoView3 = this.videoView;
                if (qFSVideoView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("videoView");
                    qFSVideoView3 = null;
                }
                if (qFSVideoView3.isRelease()) {
                    QLog.d("QFSRedPacketPreviewPlayPart", 1, "startPlay, released ");
                    K9();
                    return;
                }
                QFSVideoView qFSVideoView4 = this.videoView;
                if (qFSVideoView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("videoView");
                    qFSVideoView4 = null;
                }
                if (qFSVideoView4.getSuperPlayer().isPlaying()) {
                    QLog.d("QFSRedPacketPreviewPlayPart", 1, "startPlay, playing ");
                    return;
                }
                QFSVideoView qFSVideoView5 = this.videoView;
                if (qFSVideoView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("videoView");
                } else {
                    qFSVideoView2 = qFSVideoView5;
                }
                if (qFSVideoView2.getSuperPlayer().isPausing()) {
                    QLog.d("QFSRedPacketPreviewPlayPart", 1, "startPlay, pausing ");
                    O9();
                    return;
                } else {
                    QLog.d("QFSRedPacketPreviewPlayPart", 1, "startPlay ");
                    K9();
                    return;
                }
            }
        }
        QLog.d("QFSRedPacketPreviewPlayPart", 1, "startPlay, superPlayer is null ");
        K9();
    }

    static /* synthetic */ void N9(QFSRedPacketPreviewPlayPart qFSRedPacketPreviewPlayPart, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        qFSRedPacketPreviewPlayPart.M9(z16);
    }

    private final void O9() {
        QFSVideoView qFSVideoView = this.videoView;
        QFSVideoView qFSVideoView2 = null;
        if (qFSVideoView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoView");
            qFSVideoView = null;
        }
        ISuperPlayer superPlayer = qFSVideoView.getSuperPlayer();
        boolean z16 = false;
        if (superPlayer != null && superPlayer.isPausing()) {
            z16 = true;
        }
        if (z16) {
            QLog.d("QFSRedPacketPreviewPlayPart", 1, "startPlayerFromPause");
            QFSVideoView qFSVideoView3 = this.videoView;
            if (qFSVideoView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videoView");
                qFSVideoView3 = null;
            }
            qFSVideoView3.start();
            QFSVideoView qFSVideoView4 = this.videoView;
            if (qFSVideoView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videoView");
            } else {
                qFSVideoView2 = qFSVideoView4;
            }
            qFSVideoView2.setOutPutMute(true);
        }
    }

    public final void D9() {
        QLog.d("QFSRedPacketPreviewPlayPart", 1, "bindData ");
        C9();
        E9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSRedPacketPreviewPlayPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        String joinToString$default;
        if (Intrinsics.areEqual(action, "EVENT_CLIP_VIDEO_DONE") && (args instanceof int[])) {
            int[] iArr = (int[]) args;
            if (iArr.length == 2) {
                joinToString$default = ArraysKt___ArraysKt.joinToString$default(iArr, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null);
                QLog.d("QFSRedPacketPreviewPlayPart", 1, "handleBroadcastMessage, args:" + joinToString$default);
                this.loopStartTime = iArr[0];
                G9(iArr[0], iArr[1]);
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.li7);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.fl_video_container)");
        this.videoContainer = (FrameLayout) findViewById;
        View findViewById2 = rootView.findViewById(R.id.f57262mu);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.qfs_video_view)");
        this.videoView = (QFSVideoView) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.f57012m6);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.qfs_video_cover)");
        this.videoCover = (ImageView) findViewById3;
        D9();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartDestroy(activity);
        QLog.d("QFSRedPacketPreviewPlayPart", 1, "onPartDestroy ");
        I9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartPause(activity);
        QLog.d("QFSRedPacketPreviewPlayPart", 1, "onPartPause ");
        H9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartResume(activity);
        QLog.d("QFSRedPacketPreviewPlayPart", 1, "onPartResume ");
        N9(this, false, 1, null);
    }
}
