package com.tencent.mobileqq.qqlive.widget.player;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.util.Size;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.View;
import com.tencent.biz.richframework.video.RFWMediaFocusManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.config.QQLiveBusinessConfig;
import com.tencent.mobileqq.qqlive.context.QQLiveContext;
import com.tencent.mobileqq.qqlive.player.IQQLivePlayer;
import com.tencent.mobileqq.qqlive.widget.util.SizeParcelable;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.common.api.IQQLiveReportApi;
import com.tencent.qqlive.common.report.constant.QQLiveQualityReportData;
import com.tencent.qqlive.common.report.constant.QQLiveReportConstants;
import com.tencent.superplayer.view.ISPlayerVideoView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mi2.g;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000\u00a1\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\t*\u0001G\u0018\u0000 M2\u00020\u0001:\u0001NB\u001b\u0012\b\u00108\u001a\u0004\u0018\u000106\u0012\b\u0010;\u001a\u0004\u0018\u000109\u00a2\u0006\u0004\bK\u0010LJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u0012\u0010\u000b\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\f\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u00020\u0002H\u0016J\b\u0010\u000e\u001a\u00020\u0002H\u0016J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\bH\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\b\u0010\u0016\u001a\u00020\u0012H\u0016J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\n\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\n\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\u0012\u0010\"\u001a\u00020\u00022\b\u0010!\u001a\u0004\u0018\u00010 H\u0016J\u0012\u0010$\u001a\u00020\u00022\b\u0010!\u001a\u0004\u0018\u00010#H\u0016J\u0012\u0010%\u001a\u00020\u00022\b\u0010!\u001a\u0004\u0018\u00010#H\u0016J\u0012\u0010&\u001a\u00020\u00022\b\u0010!\u001a\u0004\u0018\u00010 H\u0016J\u0012\u0010(\u001a\u00020\u00022\b\u0010!\u001a\u0004\u0018\u00010'H\u0016J\u0012\u0010)\u001a\u00020\u00022\b\u0010!\u001a\u0004\u0018\u00010'H\u0016J\u0012\u0010+\u001a\u00020\u00022\b\u0010!\u001a\u0004\u0018\u00010*H\u0016J\u0012\u0010,\u001a\u00020\u00022\b\u0010!\u001a\u0004\u0018\u00010*H\u0016J\u0012\u0010.\u001a\u00020\u00022\b\u0010!\u001a\u0004\u0018\u00010-H\u0016J\u0012\u0010/\u001a\u00020\u00022\b\u0010!\u001a\u0004\u0018\u00010-H\u0016J\u0012\u00101\u001a\u00020\u00022\b\u0010!\u001a\u0004\u0018\u000100H\u0016J\u0012\u00102\u001a\u00020\u00022\b\u0010!\u001a\u0004\u0018\u000100H\u0016J\u0012\u00104\u001a\u00020\u00022\b\u0010!\u001a\u0004\u0018\u000103H\u0016J\u0012\u00105\u001a\u00020\u00022\b\u0010!\u001a\u0004\u0018\u000103H\u0016R\u0016\u00108\u001a\u0004\u0018\u0001068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u00107R\u0016\u0010;\u001a\u0004\u0018\u0001098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010:R\u0018\u0010?\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u001e\u0010F\u001a\n C*\u0004\u0018\u00010B0B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0014\u0010J\u001a\u00020G8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bH\u0010I\u00a8\u0006O"}, d2 = {"Lcom/tencent/mobileqq/qqlive/widget/player/QQLiveRemotePlayer;", "Lcom/tencent/mobileqq/qqlive/player/IQQLivePlayer;", "", "d", "e", "Landroid/view/Surface;", "surface", "c", "", AppConstants.Key.KEY_QZONE_VIDEO_URL, "prepare", "startPlay", "pause", "replay", "stop", "release", "url", "switchStream", "", "isOutputMute", "mute", "setOutputMute", "isPlaying", "Landroid/util/Size;", "getVideoSize", "Landroid/view/View;", "getVideoView", "Lcom/tencent/mobileqq/qqlive/player/IQQLivePlayer$XYAxis;", "axis", "setXYAxis", "Lcom/tencent/mobileqq/qqlive/sail/model/player/a;", "getPlayerQuality", "Lmi2/d;", "listener", "registerFirstFrameRenderedListener", "Lmi2/g;", "registerVideoPreparedListener", "unRegisterVideoPreparedListener", "unRegisterFirstFrameRenderedListener", "Lmi2/h;", "registerVideoSizeChangedListener", "unRegisterVideoSizeChangedListener", "Lmi2/c;", "registerErrorListener", "unRegisterErrorListener", "Lmi2/a;", "registerBufferListener", "unRegisterBufferListener", "Lmi2/f;", "registerSwitchDefinitionListener", "unRegisterSwitchDefinitionListener", "Lmi2/e;", "registerSeiInfoListener", "unRegisterSeiInfoListener", "Lcom/tencent/mobileqq/qqlive/widget/player/a;", "Lcom/tencent/mobileqq/qqlive/widget/player/a;", "player", "Lcom/tencent/superplayer/view/ISPlayerVideoView;", "Lcom/tencent/superplayer/view/ISPlayerVideoView;", "videoView", "Lcom/tencent/mobileqq/qqlive/widget/player/RemotePlayerListenerDispatcher;", "f", "Lcom/tencent/mobileqq/qqlive/widget/player/RemotePlayerListenerDispatcher;", "dispatcher", h.F, "Landroid/view/Surface;", "Lcom/tencent/biz/richframework/video/RFWMediaFocusManager;", "kotlin.jvm.PlatformType", "i", "Lcom/tencent/biz/richframework/video/RFWMediaFocusManager;", "mRFWMediaFocusManager", "com/tencent/mobileqq/qqlive/widget/player/QQLiveRemotePlayer$avBlockReceiver$1", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/qqlive/widget/player/QQLiveRemotePlayer$avBlockReceiver$1;", "avBlockReceiver", "<init>", "(Lcom/tencent/mobileqq/qqlive/widget/player/a;Lcom/tencent/superplayer/view/ISPlayerVideoView;)V", BdhLogUtil.LogTag.Tag_Conn, "b", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLiveRemotePlayer implements IQQLivePlayer {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final com.tencent.mobileqq.qqlive.widget.player.a player;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final ISPlayerVideoView videoView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RemotePlayerListenerDispatcher dispatcher;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Surface surface;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private RFWMediaFocusManager mRFWMediaFocusManager;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QQLiveRemotePlayer$avBlockReceiver$1 avBlockReceiver;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/qqlive/widget/player/QQLiveRemotePlayer$a", "Lcom/tencent/superplayer/view/ISPlayerVideoView$IVideoViewCallBack;", "", "surfaceOrHolder", "", "onSurfaceCreated", "onSurfaceDestroy", "onSurfaceChanged", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class a implements ISPlayerVideoView.IVideoViewCallBack {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLiveRemotePlayer.this);
            }
        }

        @Override // com.tencent.superplayer.view.ISPlayerVideoView.IVideoViewCallBack
        public void onSurfaceChanged(@Nullable Object surfaceOrHolder) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, surfaceOrHolder);
            } else {
                AegisLogger.INSTANCE.i("QQLive_Player|QQLiveRemotePlayer", "onSurfaceChanged");
            }
        }

        @Override // com.tencent.superplayer.view.ISPlayerVideoView.IVideoViewCallBack
        public void onSurfaceCreated(@Nullable Object surfaceOrHolder) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, surfaceOrHolder);
                return;
            }
            AegisLogger.Companion companion = AegisLogger.INSTANCE;
            companion.i("QQLive_Player|QQLiveRemotePlayer", "onSurfaceCreated");
            if (surfaceOrHolder instanceof SurfaceTexture) {
                QQLiveRemotePlayer.this.c(new Surface((SurfaceTexture) surfaceOrHolder));
            } else if (surfaceOrHolder instanceof SurfaceHolder) {
                QQLiveRemotePlayer.this.c(((SurfaceHolder) surfaceOrHolder).getSurface());
            } else {
                companion.w("QQLive_Player|QQLiveRemotePlayer", "onSurfaceCreated", "invalid surface");
            }
        }

        @Override // com.tencent.superplayer.view.ISPlayerVideoView.IVideoViewCallBack
        public void onSurfaceDestroy(@Nullable Object surfaceOrHolder) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, surfaceOrHolder);
            } else {
                AegisLogger.INSTANCE.i("QQLive_Player|QQLiveRemotePlayer", "onSurfaceDestroy");
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/qqlive/widget/player/QQLiveRemotePlayer$b;", "", "", "ACTION_AV_BLOCK", "Ljava/lang/String;", "EXTRA_BLOCK_BUSINESS", "TAG", "<init>", "()V", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.widget.player.QQLiveRemotePlayer$b, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35754);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 33)) {
            redirector.redirect((short) 33);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: Type inference failed for: r4v4, types: [com.tencent.mobileqq.qqlive.widget.player.QQLiveRemotePlayer$avBlockReceiver$1] */
    public QQLiveRemotePlayer(@Nullable com.tencent.mobileqq.qqlive.widget.player.a aVar, @Nullable ISPlayerVideoView iSPlayerVideoView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar, (Object) iSPlayerVideoView);
            return;
        }
        this.player = aVar;
        this.videoView = iSPlayerVideoView;
        this.dispatcher = new RemotePlayerListenerDispatcher();
        this.mRFWMediaFocusManager = RFWMediaFocusManager.createMediaFocusManager("QQ\u76f4\u64ad");
        if (iSPlayerVideoView != null) {
            iSPlayerVideoView.addViewCallBack(new a());
        }
        this.avBlockReceiver = new BroadcastReceiver() { // from class: com.tencent.mobileqq.qqlive.widget.player.QQLiveRemotePlayer$avBlockReceiver$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveRemotePlayer.this);
                }
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(@Nullable Context context, @Nullable Intent intent) {
                Object obj;
                String str;
                RFWMediaFocusManager rFWMediaFocusManager;
                Bundle extras;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                    return;
                }
                String str2 = null;
                if (intent != null && (extras = intent.getExtras()) != null) {
                    obj = extras.get("extra_block_business");
                } else {
                    obj = null;
                }
                if (Intrinsics.areEqual("QQ\u76f4\u64ad", obj)) {
                    QQLiveContext c16 = QQLiveContext.INSTANCE.c(QQLiveBusinessConfig.QQLIVE_APP_ID);
                    if (c16 != null) {
                        str2 = c16.n();
                    }
                    boolean isPlaying = QQLiveRemotePlayer.this.isPlaying();
                    QLog.d("QQLive_Player|QQLiveRemotePlayer", 1, "action_av_block, isPlaying:" + isPlaying);
                    if (!isPlaying) {
                        rFWMediaFocusManager = QQLiveRemotePlayer.this.mRFWMediaFocusManager;
                        if (rFWMediaFocusManager != null) {
                            rFWMediaFocusManager.requestMediaUnFocus();
                        }
                        QQLiveRemotePlayer.this.e();
                    }
                    IQQLiveReportApi iQQLiveReportApi = (IQQLiveReportApi) QRoute.api(IQQLiveReportApi.class);
                    QQLiveQualityReportData.Builder builder = new QQLiveQualityReportData.Builder(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 67108863, null);
                    if (str2 == null) {
                        str2 = "";
                    }
                    QQLiveQualityReportData.Builder ext6 = builder.traceId(str2).eventId(QQLiveReportConstants.Event.E_QQ_LIVE_AV_BLOCK).ext6("2");
                    if (isPlaying) {
                        str = "1";
                    } else {
                        str = "0";
                    }
                    iQQLiveReportApi.qualityReport(ext6.ext7(str));
                }
            }
        };
    }

    private final void d() {
        QLog.d("QQLive_Player|QQLiveRemotePlayer", 1, "registerAVBlockReceiver");
        try {
            MobileQQ.sMobileQQ.registerReceiver(this.avBlockReceiver, new IntentFilter("action_av_block"));
        } catch (Throwable th5) {
            QLog.e("QQLive_Player|QQLiveRemotePlayer", 1, "registerAVBlockReceiver exception:", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e() {
        QLog.d("QQLive_Player|QQLiveRemotePlayer", 1, "unRegisterAVBlockReceiver");
        try {
            MobileQQ.sMobileQQ.unregisterReceiver(this.avBlockReceiver);
        } catch (Throwable th5) {
            QLog.e("QQLive_Player|QQLiveRemotePlayer", 1, "unRegisterAVBlockReceiver exception:", th5);
        }
    }

    public final void c(@Nullable Surface surface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) surface);
            return;
        }
        if (this.surface != null && surface != null) {
            surface.release();
        }
        this.surface = surface;
        try {
            com.tencent.mobileqq.qqlive.widget.player.a aVar = this.player;
            if (aVar != null) {
                aVar.o2(surface);
            }
        } catch (Exception e16) {
            AegisLogger.INSTANCE.e("QQLive_Player|QQLiveRemotePlayer", "changeSurface", "error, ", e16);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.player.IQQLivePlayer
    @Nullable
    public com.tencent.mobileqq.qqlive.sail.model.player.a getPlayerQuality() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (com.tencent.mobileqq.qqlive.sail.model.player.a) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.qqlive.player.IQQLivePlayer
    @Nullable
    public Size getVideoSize() {
        SizeParcelable videoSize;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Size) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        try {
            com.tencent.mobileqq.qqlive.widget.player.a aVar = this.player;
            if (aVar != null && (videoSize = aVar.getVideoSize()) != null) {
                return new Size(videoSize.getWidth(), videoSize.getHeight());
            }
            return null;
        } catch (Exception e16) {
            AegisLogger.INSTANCE.e("QQLive_Player|QQLiveRemotePlayer", "getVideoSize", "error, ", e16);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.qqlive.player.IQQLivePlayer
    @Nullable
    public View getVideoView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (View) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        Object obj = this.videoView;
        if (obj instanceof View) {
            return (View) obj;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.qqlive.player.IQQLivePlayer
    public boolean isOutputMute() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        try {
            com.tencent.mobileqq.qqlive.widget.player.a aVar = this.player;
            if (aVar == null) {
                return false;
            }
            return aVar.isOutputMute();
        } catch (Exception e16) {
            AegisLogger.INSTANCE.e("QQLive_Player|QQLiveRemotePlayer", "isOutputMute", "error, ", e16);
            return false;
        }
    }

    @Override // com.tencent.mobileqq.qqlive.player.IQQLivePlayer
    public boolean isPlaying() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        try {
            com.tencent.mobileqq.qqlive.widget.player.a aVar = this.player;
            if (aVar == null) {
                return false;
            }
            return aVar.isPlaying();
        } catch (Exception e16) {
            AegisLogger.INSTANCE.e("QQLive_Player|QQLiveRemotePlayer", "isPlaying", "error, ", e16);
            return false;
        }
    }

    @Override // com.tencent.mobileqq.qqlive.player.IQQLivePlayer
    public void pause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        try {
            com.tencent.mobileqq.qqlive.widget.player.a aVar = this.player;
            if (aVar != null) {
                aVar.pause();
            }
            RFWMediaFocusManager rFWMediaFocusManager = this.mRFWMediaFocusManager;
            if (rFWMediaFocusManager != null) {
                rFWMediaFocusManager.requestMediaUnFocus();
            }
        } catch (Exception e16) {
            AegisLogger.INSTANCE.e("QQLive_Player|QQLiveRemotePlayer", "pause", "error, ", e16);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.player.IQQLivePlayer
    public void prepare(@NotNull String videoUrl) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) videoUrl);
            return;
        }
        Intrinsics.checkNotNullParameter(videoUrl, "videoUrl");
        try {
            com.tencent.mobileqq.qqlive.widget.player.a aVar = this.player;
            if (aVar != null) {
                aVar.prepare(videoUrl);
            }
        } catch (Exception e16) {
            AegisLogger.INSTANCE.e("QQLive_Player|QQLiveRemotePlayer", "prepare", "error, ", e16);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.player.IQQLivePlayer
    public void registerBufferListener(@Nullable mi2.a listener) {
        b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) listener);
            return;
        }
        try {
            com.tencent.mobileqq.qqlive.widget.player.a aVar = this.player;
            if (aVar != null) {
                RemotePlayerListenerDispatcher remotePlayerListenerDispatcher = this.dispatcher;
                if (remotePlayerListenerDispatcher != null) {
                    bVar = remotePlayerListenerDispatcher.u();
                } else {
                    bVar = null;
                }
                aVar.V3(bVar);
            }
            RemotePlayerListenerDispatcher remotePlayerListenerDispatcher2 = this.dispatcher;
            if (remotePlayerListenerDispatcher2 != null) {
                remotePlayerListenerDispatcher2.p(listener);
            }
        } catch (Exception e16) {
            AegisLogger.INSTANCE.e("QQLive_Player|QQLiveRemotePlayer", "registerBufferListener", "error, ", e16);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.player.IQQLivePlayer
    public void registerErrorListener(@Nullable mi2.c listener) {
        c cVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) listener);
            return;
        }
        try {
            com.tencent.mobileqq.qqlive.widget.player.a aVar = this.player;
            if (aVar != null) {
                RemotePlayerListenerDispatcher remotePlayerListenerDispatcher = this.dispatcher;
                if (remotePlayerListenerDispatcher != null) {
                    cVar = remotePlayerListenerDispatcher.w();
                } else {
                    cVar = null;
                }
                aVar.a2(cVar);
            }
            RemotePlayerListenerDispatcher remotePlayerListenerDispatcher2 = this.dispatcher;
            if (remotePlayerListenerDispatcher2 != null) {
                remotePlayerListenerDispatcher2.r(listener);
            }
        } catch (Exception e16) {
            AegisLogger.INSTANCE.e("QQLive_Player|QQLiveRemotePlayer", "registerErrorListener", "error, ", e16);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.player.IQQLivePlayer
    public void registerFirstFrameRenderedListener(@Nullable mi2.d listener) {
        d dVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) listener);
            return;
        }
        try {
            com.tencent.mobileqq.qqlive.widget.player.a aVar = this.player;
            if (aVar != null) {
                RemotePlayerListenerDispatcher remotePlayerListenerDispatcher = this.dispatcher;
                if (remotePlayerListenerDispatcher != null) {
                    dVar = remotePlayerListenerDispatcher.x();
                } else {
                    dVar = null;
                }
                aVar.K3(dVar);
            }
            RemotePlayerListenerDispatcher remotePlayerListenerDispatcher2 = this.dispatcher;
            if (remotePlayerListenerDispatcher2 != null) {
                remotePlayerListenerDispatcher2.s(listener);
            }
        } catch (Exception e16) {
            AegisLogger.INSTANCE.e("QQLive_Player|QQLiveRemotePlayer", "registerFirstFrameRenderedListener", "error, ", e16);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.player.IQQLivePlayer
    public void registerSeiInfoListener(@Nullable mi2.e listener) {
        e eVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) listener);
            return;
        }
        try {
            com.tencent.mobileqq.qqlive.widget.player.a aVar = this.player;
            if (aVar != null) {
                RemotePlayerListenerDispatcher remotePlayerListenerDispatcher = this.dispatcher;
                if (remotePlayerListenerDispatcher != null) {
                    eVar = remotePlayerListenerDispatcher.y();
                } else {
                    eVar = null;
                }
                aVar.Y2(eVar);
            }
            RemotePlayerListenerDispatcher remotePlayerListenerDispatcher2 = this.dispatcher;
            if (remotePlayerListenerDispatcher2 != null) {
                remotePlayerListenerDispatcher2.t(listener);
            }
        } catch (Exception e16) {
            AegisLogger.INSTANCE.e("QQLive_Player|QQLiveRemotePlayer", "registerSeiInfoListener", "error, ", e16);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.player.IQQLivePlayer
    public void registerSwitchDefinitionListener(@Nullable mi2.f listener) {
        f fVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) listener);
            return;
        }
        try {
            com.tencent.mobileqq.qqlive.widget.player.a aVar = this.player;
            if (aVar != null) {
                RemotePlayerListenerDispatcher remotePlayerListenerDispatcher = this.dispatcher;
                if (remotePlayerListenerDispatcher != null) {
                    fVar = remotePlayerListenerDispatcher.v();
                } else {
                    fVar = null;
                }
                aVar.J0(fVar);
            }
            RemotePlayerListenerDispatcher remotePlayerListenerDispatcher2 = this.dispatcher;
            if (remotePlayerListenerDispatcher2 != null) {
                remotePlayerListenerDispatcher2.q(listener);
            }
        } catch (Exception e16) {
            AegisLogger.INSTANCE.e("QQLive_Player|QQLiveRemotePlayer", "registerSwitchDefinitionListener", "error, ", e16);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.player.IQQLivePlayer
    public void registerVideoPreparedListener(@Nullable g listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) listener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.player.IQQLivePlayer
    public void registerVideoSizeChangedListener(@Nullable mi2.h listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) listener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.player.IQQLivePlayer
    public void release() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        companion.i("QQLive_Player|QQLiveRemotePlayer", "release");
        RemotePlayerListenerDispatcher remotePlayerListenerDispatcher = this.dispatcher;
        if (remotePlayerListenerDispatcher != null) {
            remotePlayerListenerDispatcher.z();
        }
        this.dispatcher = null;
        Surface surface = this.surface;
        if (surface != null) {
            surface.release();
        }
        this.surface = null;
        try {
            com.tencent.mobileqq.qqlive.widget.player.a aVar = this.player;
            if (aVar != null) {
                aVar.release();
            }
            companion.i("QQLive_Player|QQLiveRemotePlayer", "release", "requestMediaUnFocus mRFWMediaFocusManager:" + this.mRFWMediaFocusManager);
            RFWMediaFocusManager rFWMediaFocusManager = this.mRFWMediaFocusManager;
            if (rFWMediaFocusManager != null) {
                rFWMediaFocusManager.requestMediaUnFocus();
            }
            e();
        } catch (Exception e16) {
            AegisLogger.INSTANCE.e("QQLive_Player|QQLiveRemotePlayer", "release", "error, ", e16);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.player.IQQLivePlayer
    public void replay() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        try {
            com.tencent.mobileqq.qqlive.widget.player.a aVar = this.player;
            if (aVar != null) {
                aVar.replay();
            }
        } catch (Exception e16) {
            AegisLogger.INSTANCE.e("QQLive_Player|QQLiveRemotePlayer", "replay", "error, ", e16);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.player.IQQLivePlayer
    public void setOutputMute(boolean mute) {
        RFWMediaFocusManager rFWMediaFocusManager;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, mute);
            return;
        }
        try {
            com.tencent.mobileqq.qqlive.widget.player.a aVar = this.player;
            if (aVar != null) {
                aVar.setOutputMute(mute);
            }
            if (!mute && (rFWMediaFocusManager = this.mRFWMediaFocusManager) != null) {
                rFWMediaFocusManager.requestMediaFocus();
            }
        } catch (Exception e16) {
            AegisLogger.INSTANCE.e("QQLive_Player|QQLiveRemotePlayer", "setOutputMute", "error, ", e16);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.player.IQQLivePlayer
    public void setXYAxis(@NotNull IQQLivePlayer.XYAxis axis) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) axis);
            return;
        }
        Intrinsics.checkNotNullParameter(axis, "axis");
        try {
            com.tencent.mobileqq.qqlive.widget.player.a aVar = this.player;
            if (aVar != null) {
                aVar.setXYAxis(axis.getValue());
            }
        } catch (Exception e16) {
            AegisLogger.INSTANCE.e("QQLive_Player|QQLiveRemotePlayer", "setXYAxis", "error, ", e16);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.player.IQQLivePlayer
    public void startPlay(@Nullable String videoUrl) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) videoUrl);
            return;
        }
        try {
            com.tencent.mobileqq.qqlive.widget.player.a aVar = this.player;
            if (aVar != null) {
                aVar.start(videoUrl);
            }
            AegisLogger.INSTANCE.i("QQLive_Player|QQLiveRemotePlayer", "startPlay", "requestMediaFocus");
            RFWMediaFocusManager rFWMediaFocusManager = this.mRFWMediaFocusManager;
            if (rFWMediaFocusManager != null) {
                rFWMediaFocusManager.requestMediaFocus();
            }
            d();
        } catch (Exception e16) {
            AegisLogger.INSTANCE.e("QQLive_Player|QQLiveRemotePlayer", "startPlay", "error, ", e16);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.player.IQQLivePlayer
    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        try {
            com.tencent.mobileqq.qqlive.widget.player.a aVar = this.player;
            if (aVar != null) {
                aVar.stop();
            }
            AegisLogger.INSTANCE.i("QQLive_Player|QQLiveRemotePlayer", "stop", "requestMediaUnFocus mRFWMediaFocusManager:" + this.mRFWMediaFocusManager);
            RFWMediaFocusManager rFWMediaFocusManager = this.mRFWMediaFocusManager;
            if (rFWMediaFocusManager != null) {
                rFWMediaFocusManager.requestMediaUnFocus();
            }
            e();
        } catch (Exception e16) {
            AegisLogger.INSTANCE.e("QQLive_Player|QQLiveRemotePlayer", "stop", "error, ", e16);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.player.IQQLivePlayer
    public void switchStream(@NotNull String url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) url);
            return;
        }
        Intrinsics.checkNotNullParameter(url, "url");
        try {
            com.tencent.mobileqq.qqlive.widget.player.a aVar = this.player;
            if (aVar != null) {
                aVar.switchStream(url);
            }
        } catch (Exception e16) {
            AegisLogger.INSTANCE.e("QQLive_Player|QQLiveRemotePlayer", "switchStream", "error, ", e16);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.player.IQQLivePlayer
    public void unRegisterBufferListener(@Nullable mi2.a listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) listener);
            return;
        }
        RemotePlayerListenerDispatcher remotePlayerListenerDispatcher = this.dispatcher;
        if (remotePlayerListenerDispatcher != null) {
            remotePlayerListenerDispatcher.A(listener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.player.IQQLivePlayer
    public void unRegisterErrorListener(@Nullable mi2.c listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) listener);
            return;
        }
        RemotePlayerListenerDispatcher remotePlayerListenerDispatcher = this.dispatcher;
        if (remotePlayerListenerDispatcher != null) {
            remotePlayerListenerDispatcher.C(listener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.player.IQQLivePlayer
    public void unRegisterFirstFrameRenderedListener(@Nullable mi2.d listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) listener);
            return;
        }
        RemotePlayerListenerDispatcher remotePlayerListenerDispatcher = this.dispatcher;
        if (remotePlayerListenerDispatcher != null) {
            remotePlayerListenerDispatcher.D(listener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.player.IQQLivePlayer
    public void unRegisterSeiInfoListener(@Nullable mi2.e listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) listener);
            return;
        }
        RemotePlayerListenerDispatcher remotePlayerListenerDispatcher = this.dispatcher;
        if (remotePlayerListenerDispatcher != null) {
            remotePlayerListenerDispatcher.E(listener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.player.IQQLivePlayer
    public void unRegisterSwitchDefinitionListener(@Nullable mi2.f listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) listener);
            return;
        }
        RemotePlayerListenerDispatcher remotePlayerListenerDispatcher = this.dispatcher;
        if (remotePlayerListenerDispatcher != null) {
            remotePlayerListenerDispatcher.B(listener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.player.IQQLivePlayer
    public void unRegisterVideoPreparedListener(@Nullable g listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) listener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.player.IQQLivePlayer
    public void unRegisterVideoSizeChangedListener(@Nullable mi2.h listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) listener);
        }
    }
}
