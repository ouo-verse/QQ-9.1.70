package com.tencent.richframework.gallery.video;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.SeekBar;
import androidx.annotation.CallSuper;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.gallery.RFWLayerIOCUtil;
import com.tencent.richframework.gallery.delegate.inner.IVideoPlayerProvider;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.richframework.video.IPlayer;
import com.tencent.richframework.video.IPlayerManager;
import com.tencent.richframework.video.IPlayerStateCallback;
import com.tencent.richframework.video.RFWPlayerVideoInfo;
import com.tencent.richframework.video.SwitchUrlType;
import com.tencent.richframework.video.timer.IPlayerTimerCallback;
import com.tencent.richframework.video.timer.RFWVideoTimerManager;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00c6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u009c\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0002\u009c\u0001B.\b\u0007\u0012\b\u0010\u0096\u0001\u001a\u00030\u0095\u0001\u0012\f\b\u0002\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u0097\u0001\u0012\t\b\u0002\u0010\u0099\u0001\u001a\u00020 \u00a2\u0006\u0006\b\u009a\u0001\u0010\u009b\u0001J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u0006H\u0002J\b\u0010\r\u001a\u00020\u0006H\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0002J\b\u0010\u000f\u001a\u00020\u0006H\u0002J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0013\u001a\u00020\u0006H\u0002J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u001a\u0010\u0018\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0017\u001a\u00020\u0014H\u0002J\u000e\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0019J\u0010\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0014H\u0016J\b\u0010\u001e\u001a\u00020\u0006H\u0016J\b\u0010\u001f\u001a\u00020\u0006H\u0016J(\u0010&\u001a\u00020\u00062\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020 2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020#H\u0016J\b\u0010'\u001a\u00020\u0006H\u0016J\u0006\u0010(\u001a\u00020\u0006J\u0016\u0010+\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010*\u001a\u00020)J\u0006\u0010,\u001a\u00020\u0006J\u000e\u0010.\u001a\u00020\u00062\u0006\u0010-\u001a\u00020#J\u0006\u0010/\u001a\u00020\u0006J\u000e\u00102\u001a\u00020\u00062\u0006\u00101\u001a\u000200J\u0010\u00103\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u00104\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J \u00107\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u00105\u001a\u00020 2\u0006\u00106\u001a\u00020\u0014H\u0016J\u0006\u00108\u001a\u00020\u0006J\b\u00109\u001a\u00020\u0006H\u0005J\u000e\u0010;\u001a\u00020\u00062\u0006\u0010:\u001a\u00020\u0014J\u000e\u0010>\u001a\u00020\u00062\u0006\u0010=\u001a\u00020<J\b\u0010?\u001a\u00020\u0006H\u0014J\b\u0010@\u001a\u00020\u0006H\u0014J\u0010\u0010C\u001a\u00020\u00142\u0006\u0010B\u001a\u00020AH\u0016J\b\u0010D\u001a\u00020\u0006H\u0016J\b\u0010E\u001a\u00020\u0006H\u0016J\u0010\u0010H\u001a\u00020\u00062\b\u0010G\u001a\u0004\u0018\u00010FJ\u0016\u0010H\u001a\u00020\u00062\u0006\u0010G\u001a\u00020F2\u0006\u0010I\u001a\u00020 J\u000e\u0010J\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0014J\b\u0010K\u001a\u00020\u0006H\u0016J\b\u0010L\u001a\u00020\u0006H\u0016J*\u0010Q\u001a\u00020\u00062\u0006\u0010M\u001a\u00020 2\u0006\u0010N\u001a\u00020 2\u0006\u0010O\u001a\u00020 2\b\u0010P\u001a\u0004\u0018\u00010\tH\u0016J\u000e\u0010S\u001a\u00020\u00062\u0006\u0010=\u001a\u00020RJ\b\u0010T\u001a\u00020\u0006H\u0016J\b\u0010U\u001a\u00020\u0006H\u0016J\b\u0010V\u001a\u00020\u0006H\u0016J \u0010Z\u001a\u00020\u00062\u0006\u0010W\u001a\u00020#2\u0006\u0010X\u001a\u00020#2\u0006\u0010Y\u001a\u00020#H\u0016J\b\u0010[\u001a\u00020\u0006H\u0016R\"\u0010\\\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\\\u0010]\u001a\u0004\b\\\u0010^\"\u0004\b_\u0010`R\"\u0010a\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\ba\u0010]\u001a\u0004\ba\u0010^\"\u0004\bb\u0010`R$\u0010d\u001a\u0004\u0018\u00010c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bd\u0010e\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR\u001c\u0010k\u001a\b\u0012\u0004\u0012\u00020<0j8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bk\u0010lR\u0016\u0010m\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bm\u0010]R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010nR(\u0010q\u001a\u0004\u0018\u00010o2\b\u0010p\u001a\u0004\u0018\u00010o8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bq\u0010r\u001a\u0004\bs\u0010tR\u001d\u0010z\u001a\u0004\u0018\u00010u8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bv\u0010w\u001a\u0004\bx\u0010yR\u0016\u0010{\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b{\u0010|R\u0016\u0010G\u001a\u00020}8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010~R\u0017\u0010\u007f\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u007f\u0010\u0080\u0001R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010]R*\u0010\u0082\u0001\u001a\u00030\u0081\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u0082\u0001\u0010\u0083\u0001\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001\"\u0006\b\u0086\u0001\u0010\u0087\u0001R\u0016\u0010\u0088\u0001\u001a\u00020\u00148BX\u0082\u0004\u00a2\u0006\u0007\u001a\u0005\b\u0088\u0001\u0010^R\u001a\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u0089\u00018BX\u0082\u0004\u00a2\u0006\b\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001R(\u0010\u008d\u0001\u001a\u00020\u00142\u0007\u0010\u008d\u0001\u001a\u00020\u00148F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u008e\u0001\u0010^\"\u0005\b\u008f\u0001\u0010`R-\u0010\u0094\u0001\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00108F@FX\u0086\u000e\u00a2\u0006\u0010\u001a\u0006\b\u0090\u0001\u0010\u0091\u0001\"\u0006\b\u0092\u0001\u0010\u0093\u0001\u00a8\u0006\u009d\u0001"}, d2 = {"Lcom/tencent/richframework/gallery/video/RFWLayerVideoView;", "Landroid/widget/FrameLayout;", "Landroid/os/Handler$Callback;", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "Lcom/tencent/richframework/video/IPlayerStateCallback;", "Lcom/tencent/richframework/video/timer/IPlayerTimerCallback;", "", "addVideoView", "initPlayer", "", "url", "generateUniqueKey", "resetVariablesWhenChangeDataSource", "resetUI", "firstFrameRenderCallBack", "cleanOldISPlayer", "Landroid/widget/SeekBar;", "seekBar", "setSeekBarDuration", "releaseTimer", "", "isOn", "keepScreenOnOff", "isSupportSeek", "setSeekChangeEnabled", "Lcom/tencent/richframework/video/RFWPlayerVideoInfo;", QCircleScheme.AttrDetail.VIDEO_INFO, "setVideoInfo", "firstInit", "onInitSuccess", "onFirstFrameRendered", "onVideoPrepared", "", "what", "model", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_PLAY_TIME, "soloTime", "onVideoPassivePause", "onCompletion", "start", "Lcom/tencent/richframework/video/SwitchUrlType;", "mode", "switchDefinitionForUrl", "pause", "position", InnerAudioPlugin.AUDIO_OPERATE_SEEK, "release", "", "playRate", "setPlayRate", "onStopTrackingTouch", "onStartTrackingTouch", "progress", "fromUser", "onProgressChanged", "playTimer", "timeUpdateCallBack", "loopBack", "setLoopBack", "Lcom/tencent/richframework/gallery/video/ILayerVideoListener;", "listener", "addVideoListener", NodeProps.ON_DETACHED_FROM_WINDOW, NodeProps.ON_ATTACHED_TO_WINDOW, "Landroid/os/Message;", "msg", "handleMessage", "onSeekComplete", "onTimerCallback", "Landroid/view/View;", "loadingView", "setLoadingView", "orientation", "setSupportSeek", "onVideoLoopStart", "onVideoLoopEnd", "module", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ERROR_TYPE, "errorCode", "extraInfo", "onVideoPlayError", "Lcom/tencent/richframework/gallery/delegate/inner/IVideoPlayerProvider$ICaptureListener;", "captureCurFrame", "onDownloadAllFinish", "onBufferStart", "onBufferEnd", "downloadSpeed", "downloadSize", "totalSize", "updateDownloadState", "onRelease", "isInterrupt", "Z", "()Z", "setInterrupt", "(Z)V", "isDraggingSeekBar", "setDraggingSeekBar", "Landroid/widget/ImageView;", "videoCover", "Landroid/widget/ImageView;", "getVideoCover", "()Landroid/widget/ImageView;", "setVideoCover", "(Landroid/widget/ImageView;)V", "", "videoListeners", "Ljava/util/List;", "hasDetachedWindow", "Landroid/widget/SeekBar;", "Lcom/tencent/richframework/video/IPlayer;", "<set-?>", "currentPlayer", "Lcom/tencent/richframework/video/IPlayer;", "getCurrentPlayer", "()Lcom/tencent/richframework/video/IPlayer;", "Lcom/tencent/richframework/video/IPlayerManager;", "playerManager$delegate", "Lkotlin/Lazy;", "getPlayerManager", "()Lcom/tencent/richframework/video/IPlayerManager;", "playerManager", "playUniqueKey", "Ljava/lang/String;", "Lcom/tencent/richframework/gallery/video/RFWProgressLoadingView;", "Lcom/tencent/richframework/gallery/video/RFWProgressLoadingView;", "currentProgress", "I", "Landroid/os/Handler;", "mainHandler", "Landroid/os/Handler;", "getMainHandler", "()Landroid/os/Handler;", "setMainHandler", "(Landroid/os/Handler;)V", "isNeedSeekWhenDragging", "Landroid/view/TextureView;", "getRenderView", "()Landroid/view/TextureView;", "renderView", "outPutMute", "getOutPutMute", "setOutPutMute", "getProgressBar", "()Landroid/widget/SeekBar;", "setProgressBar", "(Landroid/widget/SeekBar;)V", "progressBar", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "function-gallery_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class RFWLayerVideoView extends FrameLayout implements Handler.Callback, SeekBar.OnSeekBarChangeListener, IPlayerStateCallback, IPlayerTimerCallback {

    @Nullable
    private IPlayer currentPlayer;
    private int currentProgress;
    private boolean hasDetachedWindow;
    private boolean isDraggingSeekBar;
    private boolean isInterrupt;
    private boolean isSupportSeek;
    private RFWProgressLoadingView loadingView;

    @NotNull
    private Handler mainHandler;
    private volatile String playUniqueKey;

    /* renamed from: playerManager$delegate, reason: from kotlin metadata */
    private final Lazy playerManager;
    private SeekBar seekBar;

    @Nullable
    private ImageView videoCover;
    private List<ILayerVideoListener> videoListeners;

    @JvmOverloads
    public RFWLayerVideoView(@NotNull Context context) {
        this(context, null, 0, 6, null);
    }

    private final void addVideoView() {
        IPlayer iPlayer = this.currentPlayer;
        if (iPlayer != null) {
            if (!iPlayer.isReady()) {
                RFWLog.w("RFWLayerVideoView", RFWLog.USR, "[addVideoView] player not ready");
                return;
            }
            cleanOldISPlayer();
            addView(iPlayer.getVideoView(), 0, new FrameLayout.LayoutParams(-1, -1));
            RFWLog.w("RFWLayerVideoView", RFWLog.USR, "[addVideoView] player  ready");
        }
    }

    private final void cleanOldISPlayer() {
        Class<?> cls;
        View videoView;
        View childAt = getChildAt(0);
        if (childAt != null) {
            Class<?> cls2 = childAt.getClass();
            IPlayer iPlayer = this.currentPlayer;
            if (iPlayer != null && (videoView = iPlayer.getVideoView()) != null) {
                cls = videoView.getClass();
            } else {
                cls = null;
            }
            if (Intrinsics.areEqual(cls2, cls)) {
                removeView(childAt);
                RFWLog.d("RFWLayerVideoView", RFWLog.USR, "remove is player");
            }
        }
    }

    private final void firstFrameRenderCallBack() {
        this.loadingView.hideAnimation();
        SeekBar seekBar = getSeekBar();
        if (seekBar != null) {
            seekBar.setVisibility(0);
            seekBar.setOnSeekBarChangeListener(this);
            setSeekChangeEnabled(seekBar, this.isSupportSeek);
        }
        Iterator<T> it = this.videoListeners.iterator();
        while (it.hasNext()) {
            ((ILayerVideoListener) it.next()).onFirstFrameRendered();
        }
    }

    private final void generateUniqueKey(String url) {
        if (TextUtils.isEmpty(url)) {
            RFWLog.d("RFWLayerVideoView", RFWLog.USR, "generateUniqueKey():playUrl is empty");
            return;
        }
        this.playUniqueKey = String.valueOf(hashCode()) + "_" + url;
    }

    private final IPlayerManager getPlayerManager() {
        return (IPlayerManager) this.playerManager.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextureView getRenderView() {
        IPlayer iPlayer = this.currentPlayer;
        if (iPlayer != null) {
            return iPlayer.getRenderTextureView();
        }
        return null;
    }

    private final void initPlayer() {
        IPlayer iPlayer;
        IPlayerManager playerManager = getPlayerManager();
        if (playerManager != null && (iPlayer = this.currentPlayer) != null) {
            iPlayer.init(this, null, playerManager.getPlayScene());
        }
    }

    private final boolean isNeedSeekWhenDragging() {
        return false;
    }

    private final void keepScreenOnOff(final boolean isOn) {
        this.mainHandler.post(new Runnable() { // from class: com.tencent.richframework.gallery.video.RFWLayerVideoView$keepScreenOnOff$1
            @Override // java.lang.Runnable
            public final void run() {
                RFWLayerIOCUtil rFWLayerIOCUtil = RFWLayerIOCUtil.INSTANCE;
                Context context = RFWLayerVideoView.this.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                Context activityContext = rFWLayerIOCUtil.getActivityContext(context);
                if (activityContext instanceof Activity) {
                    if (isOn) {
                        ((Activity) activityContext).getWindow().addFlags(128);
                    } else {
                        ((Activity) activityContext).getWindow().clearFlags(128);
                    }
                }
            }
        });
    }

    private final void releaseTimer() {
        RFWVideoTimerManager.g().unRegisterTimerListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void resetUI() {
        ImageView imageView = this.videoCover;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        SeekBar seekBar = getSeekBar();
        if (seekBar != null) {
            seekBar.setProgress(0);
        }
    }

    private final void resetVariablesWhenChangeDataSource() {
        releaseTimer();
        this.mainHandler.removeCallbacksAndMessages(null);
        this.mainHandler.post(new Runnable() { // from class: com.tencent.richframework.gallery.video.RFWLayerVideoView$resetVariablesWhenChangeDataSource$1
            @Override // java.lang.Runnable
            public final void run() {
                RFWLayerVideoView.this.resetUI();
            }
        });
    }

    private final void setSeekBarDuration(SeekBar seekBar) {
        IPlayer iPlayer = this.currentPlayer;
        if (iPlayer != null) {
            Message obtain = Message.obtain();
            obtain.what = -1001;
            obtain.arg1 = seekBar.getProgress();
            obtain.arg2 = (int) iPlayer.getDurationMs();
            obtain.obj = Boolean.FALSE;
            if (isNeedSeekWhenDragging()) {
                seek(seekBar.getProgress());
            }
            this.mainHandler.sendMessage(obtain);
        }
    }

    private final void setSeekChangeEnabled(SeekBar seekBar, boolean isSupportSeek) {
        if (seekBar == null) {
            return;
        }
        seekBar.setEnabled(isSupportSeek);
    }

    public final void addVideoListener(@NotNull ILayerVideoListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.videoListeners.add(listener);
    }

    public final void captureCurFrame(@NotNull final IVideoPlayerProvider.ICaptureListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (this.currentPlayer == null) {
            RFWLog.e("RFWLayerVideoView", RFWLog.USR, "captureCurFrame failed, mPlayer is null.");
            listener.onResult(false, null);
        } else {
            RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: com.tencent.richframework.gallery.video.RFWLayerVideoView$captureCurFrame$1
                @Override // java.lang.Runnable
                public final void run() {
                    TextureView renderView;
                    renderView = RFWLayerVideoView.this.getRenderView();
                    if (renderView == null) {
                        RFWLog.e("RFWLayerVideoView", RFWLog.USR, "captureCurFrame failed, renderView is not TextureView.");
                        listener.onResult(false, null);
                    } else if (!renderView.isAvailable()) {
                        RFWLog.e("RFWLayerVideoView", RFWLog.USR, "captureCurFrame failed, current surface is not available.");
                        listener.onResult(false, null);
                    } else {
                        try {
                            listener.onResult(true, renderView.getBitmap());
                        } catch (Throwable th5) {
                            RFWLog.e("RFWLayerVideoView", RFWLog.USR, "captureCurFrame failed! ", th5);
                        }
                    }
                }
            });
        }
    }

    @Nullable
    public final IPlayer getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Nullable
    /* renamed from: getProgressBar, reason: from getter */
    public final SeekBar getSeekBar() {
        return this.seekBar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NotNull Message msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (msg2.what == -1001) {
            Iterator<T> it = this.videoListeners.iterator();
            while (it.hasNext()) {
                ((ILayerVideoListener) it.next()).onProgress("", msg2.arg2, msg2.arg1);
            }
            return false;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.hasDetachedWindow = false;
    }

    @Override // com.tencent.richframework.video.IPlayerStateCallback
    public void onBufferEnd() {
        Iterator<T> it = this.videoListeners.iterator();
        while (it.hasNext()) {
            ((ILayerVideoListener) it.next()).onBufferEnd();
        }
    }

    @Override // com.tencent.richframework.video.IPlayerStateCallback
    public void onBufferStart() {
        Iterator<T> it = this.videoListeners.iterator();
        while (it.hasNext()) {
            ((ILayerVideoListener) it.next()).onBufferStart();
        }
    }

    @Override // com.tencent.richframework.video.IPlayerStateCallback
    public void onCompletion() {
        this.mainHandler.post(new Runnable() { // from class: com.tencent.richframework.gallery.video.RFWLayerVideoView$onCompletion$1
            @Override // java.lang.Runnable
            public final void run() {
                List list;
                SeekBar seekBar = RFWLayerVideoView.this.getSeekBar();
                if (seekBar != null) {
                    seekBar.setProgress(0);
                }
                list = RFWLayerVideoView.this.videoListeners;
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((ILayerVideoListener) it.next()).onCompletion();
                }
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mainHandler.removeCallbacksAndMessages(null);
        this.hasDetachedWindow = true;
    }

    @Override // com.tencent.richframework.video.IPlayerStateCallback
    public void onDownloadAllFinish() {
        Iterator<T> it = this.videoListeners.iterator();
        while (it.hasNext()) {
            ((ILayerVideoListener) it.next()).onDownloadAllFinish();
        }
    }

    @Override // com.tencent.richframework.video.IPlayerStateCallback
    public void onFirstFrameRendered() {
        firstFrameRenderCallBack();
    }

    @Override // com.tencent.richframework.video.IPlayerStateCallback
    public void onInitSuccess(boolean firstInit) {
        addVideoView();
        Iterator<T> it = this.videoListeners.iterator();
        while (it.hasNext()) {
            ((ILayerVideoListener) it.next()).onInitSuccess(firstInit);
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(@NotNull SeekBar seekBar, int progress, boolean fromUser) {
        Intrinsics.checkNotNullParameter(seekBar, "seekBar");
        if (this.isDraggingSeekBar) {
            setSeekBarDuration(seekBar);
            Iterator<T> it = this.videoListeners.iterator();
            while (it.hasNext()) {
                ((ILayerVideoListener) it.next()).onSeekBarProgressChanged(seekBar, progress, fromUser);
            }
        }
    }

    @Override // com.tencent.richframework.video.IPlayerStateCallback
    public void onRelease() {
        Iterator<T> it = this.videoListeners.iterator();
        while (it.hasNext()) {
            ((ILayerVideoListener) it.next()).onRelease();
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(@NotNull SeekBar seekBar) {
        Intrinsics.checkNotNullParameter(seekBar, "seekBar");
        IPlayer iPlayer = this.currentPlayer;
        if (iPlayer != null) {
            this.isDraggingSeekBar = true;
            if (!iPlayer.isReady()) {
                RFWLog.w("RFWLayerVideoView", RFWLog.USR, "[onStartTrackingTouch] player not ready");
                return;
            }
            Iterator<T> it = this.videoListeners.iterator();
            while (it.hasNext()) {
                ((ILayerVideoListener) it.next()).onStartTrackingTouch(seekBar);
            }
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(@NotNull SeekBar seekBar) {
        EventCollector.getInstance().onStopTrackingTouchBefore(seekBar);
        Intrinsics.checkNotNullParameter(seekBar, "seekBar");
        IPlayer iPlayer = this.currentPlayer;
        if (iPlayer != null) {
            this.isDraggingSeekBar = false;
            if (!iPlayer.isReady()) {
                RFWLog.w("RFWLayerVideoView", RFWLog.USR, "[onStopTrackingTouch] player not ready");
            } else {
                seek(seekBar.getProgress());
                Iterator<T> it = this.videoListeners.iterator();
                while (it.hasNext()) {
                    ((ILayerVideoListener) it.next()).onStopTrackingTouch(seekBar);
                }
            }
        }
        EventCollector.getInstance().onStopTrackingTouch(seekBar);
    }

    @Override // com.tencent.richframework.video.IPlayerStateCallback
    public void onTimerCallback() {
        timeUpdateCallBack();
    }

    @Override // com.tencent.richframework.video.IPlayerStateCallback
    public void onVideoLoopEnd() {
        Iterator<T> it = this.videoListeners.iterator();
        while (it.hasNext()) {
            ((ILayerVideoListener) it.next()).onVideoLoopEnd();
        }
    }

    @Override // com.tencent.richframework.video.IPlayerStateCallback
    public void onVideoLoopStart() {
        Iterator<T> it = this.videoListeners.iterator();
        while (it.hasNext()) {
            ((ILayerVideoListener) it.next()).onVideoLoopStart();
        }
    }

    @Override // com.tencent.richframework.video.IPlayerStateCallback
    public void onVideoPlayError(int module, int errorType, int errorCode, @Nullable String extraInfo) {
        Iterator<T> it = this.videoListeners.iterator();
        while (it.hasNext()) {
            ((ILayerVideoListener) it.next()).onVideoPlayError(module, errorType, errorCode, extraInfo);
        }
    }

    @Override // com.tencent.richframework.video.IPlayerStateCallback
    public void onVideoPrepared() {
        IPlayer iPlayer = this.currentPlayer;
        if (iPlayer != null) {
            SeekBar seekBar = getSeekBar();
            if (seekBar != null) {
                seekBar.setMax((int) iPlayer.getDurationMs());
            }
            Iterator<T> it = this.videoListeners.iterator();
            while (it.hasNext()) {
                ((ILayerVideoListener) it.next()).onVideoPrepared();
            }
        }
    }

    public final void pause() {
        IPlayer iPlayer = this.currentPlayer;
        if (iPlayer != null) {
            if (!iPlayer.isReady()) {
                RFWLog.w("RFWLayerVideoView", RFWLog.USR, "[pause] player not ready");
            } else if (iPlayer.isPlaying()) {
                iPlayer.pause();
                keepScreenOnOff(false);
            }
        }
    }

    public final void playTimer() {
        releaseTimer();
        RFWVideoTimerManager.g().registerTimerListener(this);
    }

    public final void release() {
        if (this.currentPlayer != null) {
            IPlayerManager playerManager = getPlayerManager();
            if (playerManager != null) {
                playerManager.releasePlayer(this.playUniqueKey);
            }
            cleanOldISPlayer();
            releaseTimer();
            SeekBar seekBar = getSeekBar();
            if (seekBar != null) {
                seekBar.setProgress(0);
            }
            SeekBar seekBar2 = getSeekBar();
            if (seekBar2 != null) {
                seekBar2.setOnSeekBarChangeListener(null);
            }
            this.videoCover = null;
            this.mainHandler.removeCallbacksAndMessages(null);
        }
    }

    public final void seek(long position) {
        IPlayer iPlayer = this.currentPlayer;
        if (iPlayer != null) {
            if (!iPlayer.isReady()) {
                RFWLog.w("RFWLayerVideoView", RFWLog.USR, "[seek] player not ready");
            } else {
                iPlayer.seek(position);
            }
        }
    }

    public final void setDraggingSeekBar(boolean z16) {
        this.isDraggingSeekBar = z16;
    }

    public final void setInterrupt(boolean z16) {
        this.isInterrupt = z16;
    }

    public final void setLoadingView(@Nullable View loadingView) {
        if (loadingView != null) {
            this.loadingView.setLoadingView(loadingView);
        }
    }

    public final void setLoopBack(boolean loopBack) {
        IPlayer iPlayer = this.currentPlayer;
        if (iPlayer != null) {
            if (!iPlayer.isReady()) {
                RFWLog.w("RFWLayerVideoView", RFWLog.USR, "[setLoopBack] player not ready");
            }
            iPlayer.setLoopback(loopBack);
        }
    }

    public final void setMainHandler(@NotNull Handler handler) {
        Intrinsics.checkNotNullParameter(handler, "<set-?>");
        this.mainHandler = handler;
    }

    public final void setOutPutMute(boolean z16) {
        IPlayer iPlayer = this.currentPlayer;
        if (iPlayer == null) {
            return;
        }
        Intrinsics.checkNotNull(iPlayer);
        if (!iPlayer.isReady()) {
            RFWLog.w("RFWLayerVideoView", RFWLog.USR, "[setOutPutMute] player not ready");
            return;
        }
        IPlayer iPlayer2 = this.currentPlayer;
        Intrinsics.checkNotNull(iPlayer2);
        iPlayer2.setOutputMute(z16);
    }

    public final void setPlayRate(float playRate) {
        IPlayer iPlayer = this.currentPlayer;
        if (iPlayer != null) {
            iPlayer.setPlayRate(playRate);
        }
    }

    public final void setProgressBar(@Nullable SeekBar seekBar) {
        this.seekBar = seekBar;
        if (seekBar != null) {
            seekBar.setOnSeekBarChangeListener(this);
        }
    }

    public final void setSupportSeek(boolean isSupportSeek) {
        setSeekChangeEnabled(getSeekBar(), isSupportSeek);
        this.isSupportSeek = isSupportSeek;
    }

    public final void setVideoCover(@Nullable ImageView imageView) {
        this.videoCover = imageView;
    }

    public final void setVideoInfo(@NotNull RFWPlayerVideoInfo videoInfo) {
        IPlayer iPlayer;
        Intrinsics.checkNotNullParameter(videoInfo, "videoInfo");
        String str = videoInfo.mUrl;
        Intrinsics.checkNotNullExpressionValue(str, "videoInfo.mUrl");
        generateUniqueKey(str);
        resetVariablesWhenChangeDataSource();
        IPlayerManager playerManager = getPlayerManager();
        if (playerManager != null) {
            iPlayer = playerManager.obtain(this.playUniqueKey);
        } else {
            iPlayer = null;
        }
        this.currentPlayer = iPlayer;
        if (iPlayer == null) {
            return;
        }
        initPlayer();
        IPlayer iPlayer2 = this.currentPlayer;
        if (iPlayer2 != null) {
            iPlayer2.setVideoInfo(videoInfo);
        }
    }

    public final void start() {
        IPlayer iPlayer = this.currentPlayer;
        if (iPlayer != null) {
            if (!iPlayer.isReady()) {
                RFWLog.w("RFWLayerVideoView", RFWLog.USR, "[start] player not ready");
            } else if (!iPlayer.isPlaying()) {
                this.isInterrupt = false;
                iPlayer.start();
                playTimer();
                keepScreenOnOff(true);
            }
        }
    }

    public final void switchDefinitionForUrl(@NotNull String url, @NotNull SwitchUrlType mode) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(mode, "mode");
        IPlayer iPlayer = this.currentPlayer;
        if (iPlayer == null || TextUtils.isEmpty(url)) {
            return;
        }
        if (!iPlayer.isReady()) {
            RFWLog.w("RFWLayerVideoView", RFWLog.USR, "[start] player not ready");
            return;
        }
        RFWLog.w("RFWLayerVideoView", RFWLog.USR, "[switchDefinitionForUrl] url:" + url + " mode:" + mode);
        iPlayer.switchDefinitionForUrl(url, mode);
    }

    @CallSuper
    protected final void timeUpdateCallBack() {
        final int max;
        SeekBar seekBar;
        IPlayer iPlayer = this.currentPlayer;
        if (iPlayer != null) {
            double currentPositionMs = iPlayer.getCurrentPositionMs();
            float durationMs = (float) iPlayer.getDurationMs();
            if (durationMs == 0.0f && (seekBar = getSeekBar()) != null) {
                seekBar.setProgress(0);
            }
            if (this.isDraggingSeekBar || currentPositionMs == 0.0d || iPlayer.isPausing()) {
                return;
            }
            Message obtain = Message.obtain();
            obtain.what = -1001;
            obtain.arg1 = (int) currentPositionMs;
            obtain.arg2 = (int) durationMs;
            obtain.obj = Boolean.TRUE;
            this.mainHandler.sendMessage(obtain);
            final SeekBar seekBar2 = getSeekBar();
            if (seekBar2 != null && this.currentProgress != (max = (int) (seekBar2.getMax() * (currentPositionMs / durationMs)))) {
                this.mainHandler.post(new Runnable() { // from class: com.tencent.richframework.gallery.video.RFWLayerVideoView$timeUpdateCallBack$1$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        seekBar2.setProgress(max);
                    }
                });
                this.currentProgress = max;
            }
        }
    }

    @Override // com.tencent.richframework.video.IPlayerStateCallback
    public void updateDownloadState(long downloadSpeed, long downloadSize, long totalSize) {
        Iterator<T> it = this.videoListeners.iterator();
        while (it.hasNext()) {
            ((ILayerVideoListener) it.next()).updateDownloadState(downloadSpeed, downloadSize, totalSize);
        }
    }

    @JvmOverloads
    public RFWLayerVideoView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public final void setLoadingView(@NotNull View loadingView, int orientation) {
        Intrinsics.checkNotNullParameter(loadingView, "loadingView");
        this.loadingView.setLoadingView(loadingView);
        this.loadingView.setScreenOrientation(orientation);
    }

    public /* synthetic */ RFWLayerVideoView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RFWLayerVideoView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        this.videoListeners = new CopyOnWriteArrayList();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<IPlayerManager>() { // from class: com.tencent.richframework.gallery.video.RFWLayerVideoView$playerManager$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final IPlayerManager invoke() {
                return RFWLayerIOCUtil.getPlayerManager(RFWLayerVideoView.this);
            }
        });
        this.playerManager = lazy;
        this.playUniqueKey = "";
        this.isSupportSeek = true;
        this.loadingView = new RFWProgressLoadingView(context);
        this.mainHandler = new Handler(Looper.getMainLooper(), this);
    }

    @Override // com.tencent.richframework.video.IPlayerStateCallback
    public void onSeekComplete() {
    }

    @Override // com.tencent.richframework.video.IPlayerStateCallback
    public void onVideoPassivePause(int what, int model, long playTime, long soloTime) {
    }
}
