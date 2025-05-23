package hu2;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.playerinterface.IQAdPlayerView;
import com.tencent.qqlive.playerinterface.QAdUserInfo;
import com.tencent.qqlive.playerinterface.QAdVideoItem;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerOption;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.utils.CommonUtil;
import com.tencent.thumbplayer.api.asset.ITPMediaAsset;
import com.tencent.thumbplayer.api.asset.ITPMultiMediaAsset;
import com.tencent.thumbplayer.api.asset.ITPUrlMediaAsset;
import com.tencent.thumbplayer.api.asset.TPMediaAssetFactory;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kt3.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00162\u00020\u0001:\u0001\u001eB\u001b\u0012\b\u0010/\u001a\u0004\u0018\u00010)\u0012\b\u00105\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b@\u0010AJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u001a\u0010\f\u001a\u0004\u0018\u00010\u000b2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0002J\u0012\u0010\u000e\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\u000f\u001a\u00020\u0002H\u0002J\b\u0010\u0010\u001a\u00020\u0002H\u0002J\u0012\u0010\u0013\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0016\u001a\u00020\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0002H\u0016J\b\u0010\u0018\u001a\u00020\u0002H\u0016J\b\u0010\u0019\u001a\u00020\u0002H\u0016J \u0010\u001b\u001a\u00020\u00022\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0006\u0010\u001a\u001a\u00020\u0014H\u0016J\b\u0010\u001c\u001a\u00020\u0002H\u0016J\u0012\u0010\u001e\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u001f\u001a\u00020\u0002H\u0016J\u0010\u0010\"\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 H\u0016J\u0010\u0010$\u001a\u00020\r2\u0006\u0010#\u001a\u00020\rH\u0016J\u0010\u0010&\u001a\u00020\r2\u0006\u0010%\u001a\u00020\rH\u0016J\u0010\u0010(\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u0014H\u0016R$\u0010/\u001a\u0004\u0018\u00010)8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u00105\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0018\u00108\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u00107R\u0016\u0010;\u001a\u0004\u0018\u0001098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010:R\u0014\u0010?\u001a\u00020<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u0010>\u00a8\u0006B"}, d2 = {"Lhu2/h;", "Lkt3/b;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/qqlive/playerinterface/IQAdPlayerView;", "view", "Landroid/view/Surface;", ReportConstant.COSTREPORT_PREFIX, "", "Lcom/tencent/qqlive/playerinterface/QAdVideoItem;", "adVideoItemList", "Lcom/tencent/thumbplayer/api/asset/ITPMediaAsset;", "r", "", "t", "v", "w", "Lkt3/b$b;", "mediaPlayerCallback", "g", "", "getCurrentPositionMs", "f", "start", "stop", "pause", "startPositionMillisecond", "d", "release", "qAdPlayerView", "a", "b", "", "gainRatio", "setAudioGainRatio", "isOutputMute", "setOutputMute", "isLoop", "setLoopPlay", "positionMs", "c", "Landroid/content/Context;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "context", "Lcom/tencent/qqlive/playerinterface/IQAdPlayerView;", "getAdPlayerView", "()Lcom/tencent/qqlive/playerinterface/IQAdPlayerView;", "setAdPlayerView", "(Lcom/tencent/qqlive/playerinterface/IQAdPlayerView;)V", "adPlayerView", "Lhu2/i;", "Lhu2/i;", "midAdPlayerCallback", "Lcom/tencent/superplayer/api/ISuperPlayer;", "Lcom/tencent/superplayer/api/ISuperPlayer;", "superPlayer", "Ljava/lang/Runnable;", "e", "Ljava/lang/Runnable;", "notifyStuckRunnable", "<init>", "(Landroid/content/Context;Lcom/tencent/qqlive/playerinterface/IQAdPlayerView;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class h implements kt3.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IQAdPlayerView adPlayerView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private i midAdPlayerCallback;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final ISuperPlayer superPlayer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Runnable notifyStuckRunnable;

    public h(@Nullable Context context, @Nullable IQAdPlayerView iQAdPlayerView) {
        this.context = context;
        this.adPlayerView = iQAdPlayerView;
        ISuperPlayer createMediaPlayer = SuperPlayerFactory.createMediaPlayer(context, QCircleHostConstants._SceneID.TENCENT_VIDEO_PLAYER(), null);
        this.superPlayer = createMediaPlayer;
        this.notifyStuckRunnable = new Runnable() { // from class: hu2.g
            @Override // java.lang.Runnable
            public final void run() {
                h.u(h.this);
            }
        };
        if (createMediaPlayer != null) {
            createMediaPlayer.setSurface(s(this.adPlayerView));
        }
    }

    private final void m() {
        ISuperPlayer iSuperPlayer = this.superPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.setOnCompletionListener(new ISuperPlayer.OnCompletionListener() { // from class: hu2.c
                @Override // com.tencent.superplayer.api.ISuperPlayer.OnCompletionListener
                public final void onCompletion(ISuperPlayer iSuperPlayer2) {
                    h.n(h.this, iSuperPlayer2);
                }
            });
        }
        ISuperPlayer iSuperPlayer2 = this.superPlayer;
        if (iSuperPlayer2 != null) {
            iSuperPlayer2.setOnVideoPreparedListener(new ISuperPlayer.OnVideoPreparedListener() { // from class: hu2.d
                @Override // com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener
                public final void onVideoPrepared(ISuperPlayer iSuperPlayer3) {
                    h.o(h.this, iSuperPlayer3);
                }
            });
        }
        ISuperPlayer iSuperPlayer3 = this.superPlayer;
        if (iSuperPlayer3 != null) {
            iSuperPlayer3.setOnErrorListener(new ISuperPlayer.OnErrorListener() { // from class: hu2.e
                @Override // com.tencent.superplayer.api.ISuperPlayer.OnErrorListener
                public final boolean onError(ISuperPlayer iSuperPlayer4, int i3, int i16, int i17, String str) {
                    boolean p16;
                    p16 = h.p(h.this, iSuperPlayer4, i3, i16, i17, str);
                    return p16;
                }
            });
        }
        ISuperPlayer iSuperPlayer4 = this.superPlayer;
        if (iSuperPlayer4 != null) {
            iSuperPlayer4.setOnInfoListener(new ISuperPlayer.OnInfoListener() { // from class: hu2.f
                @Override // com.tencent.superplayer.api.ISuperPlayer.OnInfoListener
                public final boolean onInfo(ISuperPlayer iSuperPlayer5, int i3, long j3, long j16, Object obj) {
                    boolean q16;
                    q16 = h.q(h.this, iSuperPlayer5, i3, j3, j16, obj);
                    return q16;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(h this$0, ISuperPlayer iSuperPlayer) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("MidAdPlayer", 1, "OnCompletionListener");
        i iVar = this$0.midAdPlayerCallback;
        if (iVar != null) {
            iVar.a();
        }
        this$0.w();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(h this$0, ISuperPlayer iSuperPlayer) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("MidAdPlayer", 1, "OnVideoPreparedListener");
        i iVar = this$0.midAdPlayerCallback;
        if (iVar != null) {
            iVar.c();
        }
        this$0.w();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean p(h this$0, ISuperPlayer iSuperPlayer, int i3, int i16, int i17, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("MidAdPlayer", 1, "onError " + str);
        i iVar = this$0.midAdPlayerCallback;
        if (iVar != null) {
            iVar.b();
        }
        this$0.w();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean q(h this$0, ISuperPlayer iSuperPlayer, int i3, long j3, long j16, Object obj) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 != 112) {
            if (i3 == 113) {
                this$0.w();
                return true;
            }
            return true;
        }
        this$0.v();
        return true;
    }

    private final ITPMediaAsset r(List<QAdVideoItem> adVideoItemList) {
        ITPMultiMediaAsset createMultiMediaAsset = TPMediaAssetFactory.createMultiMediaAsset();
        Intrinsics.checkNotNullExpressionValue(createMultiMediaAsset, "createMultiMediaAsset()");
        if (adVideoItemList == null) {
            QLog.i("MidAdPlayer", 1, "createMediaAsset null list");
            return createMultiMediaAsset;
        }
        for (QAdVideoItem qAdVideoItem : adVideoItemList) {
            QLog.i("MidAdPlayer", 1, "createMediaAsset item url=" + qAdVideoItem.c());
            if (!TextUtils.isEmpty(qAdVideoItem.c())) {
                ITPUrlMediaAsset createUrlMediaAsset = TPMediaAssetFactory.createUrlMediaAsset(qAdVideoItem.c());
                Intrinsics.checkNotNullExpressionValue(createUrlMediaAsset, "createUrlMediaAsset(adVideoItem.playUrl)");
                createUrlMediaAsset.setParam("dl_param_file_duration", String.valueOf(qAdVideoItem.a() * 1000));
                createUrlMediaAsset.setParam("dl_param_file_size", String.valueOf(qAdVideoItem.b()));
                createUrlMediaAsset.setParam("dl_param_play_clip_count", String.valueOf(adVideoItemList.size()));
                createUrlMediaAsset.setParam("dl_param_play_clip_keyid", CommonUtil.b(qAdVideoItem.c()));
                createMultiMediaAsset.addAsset(createUrlMediaAsset, qAdVideoItem.a() * 1000);
            }
        }
        return createMultiMediaAsset;
    }

    private final Surface s(IQAdPlayerView view) {
        if (view == null || view.c() == null || !view.b()) {
            return null;
        }
        Object c16 = view.c();
        if (c16 instanceof SurfaceHolder) {
            return ((SurfaceHolder) c16).getSurface();
        }
        if (c16 instanceof SurfaceTexture) {
            return new Surface((SurfaceTexture) c16);
        }
        if (!(c16 instanceof Surface)) {
            return null;
        }
        return (Surface) c16;
    }

    private final boolean t(IQAdPlayerView view) {
        if (view == null || view.c() == null) {
            return false;
        }
        return view.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(h this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        i iVar = this$0.midAdPlayerCallback;
        if (iVar != null) {
            iVar.d();
        }
    }

    @Override // kt3.b
    public void a(@Nullable IQAdPlayerView qAdPlayerView) {
        QLog.i("MidAdPlayer", 1, "updateRenderSurface:" + qAdPlayerView);
        if (!t(qAdPlayerView)) {
            QLog.i("MidAdPlayer", 1, "updateRenderSurface:invalid");
            return;
        }
        this.adPlayerView = qAdPlayerView;
        Surface s16 = s(qAdPlayerView);
        if (s16 != null && !s16.isValid()) {
            QLog.i("MidAdPlayer", 1, "updateRenderSurface:invalid surface");
            return;
        }
        ISuperPlayer iSuperPlayer = this.superPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.setSurface(s16);
        }
        QLog.i("MidAdPlayer", 1, "updateRenderSurface:do setSurface");
    }

    @Override // kt3.b
    public void d(@Nullable List<QAdVideoItem> adVideoItemList, long startPositionMillisecond) {
        Integer num;
        ISuperPlayer iSuperPlayer;
        if (adVideoItemList != null) {
            num = Integer.valueOf(adVideoItemList.size());
        } else {
            num = null;
        }
        QLog.i("MidAdPlayer", 1, "openPlayer itemSize=" + num + " context=" + this.context);
        if (adVideoItemList != null && !adVideoItemList.isEmpty()) {
            Surface s16 = s(this.adPlayerView);
            if (s16 != null && (iSuperPlayer = this.superPlayer) != null) {
                iSuperPlayer.setSurface(s16);
            }
            if (this.context != null) {
                SuperPlayerVideoInfo createVideoInfoForUrl = SuperPlayerFactory.createVideoInfoForUrl(adVideoItemList.get(0).c(), 101, (String) null);
                createVideoInfoForUrl.setMediaAssert(r(adVideoItemList));
                m();
                SuperPlayerOption obtain = SuperPlayerOption.obtain();
                obtain.prepareTimeoutMs = 8000L;
                obtain.bufferTimeoutMs = 8000L;
                ISuperPlayer iSuperPlayer2 = this.superPlayer;
                if (iSuperPlayer2 != null) {
                    iSuperPlayer2.openMediaPlayer(this.context, createVideoInfoForUrl, startPositionMillisecond, obtain);
                }
                v();
            }
        }
    }

    @Override // kt3.b
    public /* synthetic */ void e(QAdUserInfo qAdUserInfo) {
        kt3.a.c(this, qAdUserInfo);
    }

    @Override // kt3.b
    public long f() {
        ISuperPlayer iSuperPlayer = this.superPlayer;
        if (iSuperPlayer != null) {
            return iSuperPlayer.getDurationMs();
        }
        return 0L;
    }

    @Override // kt3.b
    public void g(@Nullable b.InterfaceC10678b mediaPlayerCallback) {
        QLog.i("MidAdPlayer", 1, "setQAdMediaPlayerCallback: " + mediaPlayerCallback);
        this.midAdPlayerCallback = new i(mediaPlayerCallback);
    }

    @Override // kt3.b
    public long getCurrentPositionMs() {
        ISuperPlayer iSuperPlayer = this.superPlayer;
        if (iSuperPlayer != null) {
            return iSuperPlayer.getCurrentPositionMs();
        }
        return 0L;
    }

    @Override // kt3.b
    public /* synthetic */ boolean isPlaying() {
        return kt3.a.a(this);
    }

    @Override // kt3.b
    public void pause() {
        QLog.i("MidAdPlayer", 1, "pause");
        ISuperPlayer iSuperPlayer = this.superPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.pause();
        }
        w();
    }

    @Override // kt3.b
    public void release() {
        QLog.i("MidAdPlayer", 1, "release");
        this.adPlayerView = null;
        this.context = null;
        ISuperPlayer iSuperPlayer = this.superPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.release();
        }
        w();
        kt3.a.b(this);
    }

    @Override // kt3.b
    public boolean setLoopPlay(boolean isLoop) {
        return true;
    }

    @Override // kt3.b
    public boolean setOutputMute(boolean isOutputMute) {
        ISuperPlayer iSuperPlayer = this.superPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.setOutputMute(isOutputMute);
            return true;
        }
        return true;
    }

    @Override // kt3.b
    public void start() {
        QLog.i("MidAdPlayer", 1, "start");
        ISuperPlayer iSuperPlayer = this.superPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.start();
        }
    }

    @Override // kt3.b
    public void stop() {
        QLog.i("MidAdPlayer", 1, "stop");
        ISuperPlayer iSuperPlayer = this.superPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.stop();
        }
        w();
    }

    private final void v() {
    }

    private final void w() {
    }

    @Override // kt3.b
    public void b() {
    }

    @Override // kt3.b
    public void c(long positionMs) {
    }

    @Override // kt3.b
    public void setAudioGainRatio(float gainRatio) {
    }
}
