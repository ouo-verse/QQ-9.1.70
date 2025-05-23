package com.tencent.gdtad.basics.motivevideo.hippy.video;

import android.content.Context;
import android.media.AudioManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.ams.dsdk.view.video.DKVideoPlayer;
import com.tencent.gdtad.views.GdtUIUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.view.ISPlayerVideoView;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class GdtMotiveHippyVideoView extends FrameLayout implements DKVideoPlayer {
    private volatile String C;
    private volatile boolean D;
    private final WeakReference<com.tencent.gdtad.basics.motivevideo.hippy.video.a> E;

    /* renamed from: d, reason: collision with root package name */
    private ISuperPlayer f109014d;

    /* renamed from: e, reason: collision with root package name */
    private ISPlayerVideoView f109015e;

    /* renamed from: f, reason: collision with root package name */
    private volatile DKVideoPlayer.OnVideoPlayListener f109016f;

    /* renamed from: h, reason: collision with root package name */
    private volatile DKVideoPlayer.ObjectFit f109017h;

    /* renamed from: i, reason: collision with root package name */
    private volatile boolean f109018i;

    /* renamed from: m, reason: collision with root package name */
    private volatile boolean f109019m;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class GdtOnVideoPreparedListener implements ISuperPlayer.OnVideoPreparedListener {

        /* renamed from: d, reason: collision with root package name */
        WeakReference<GdtMotiveHippyVideoView> f109025d;

        public GdtOnVideoPreparedListener(WeakReference<GdtMotiveHippyVideoView> weakReference) {
            this.f109025d = weakReference;
        }

        @Override // com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener
        public void onVideoPrepared(ISuperPlayer iSuperPlayer) {
            final GdtMotiveHippyVideoView gdtMotiveHippyVideoView;
            boolean z16;
            WeakReference<GdtMotiveHippyVideoView> weakReference = this.f109025d;
            if (weakReference != null) {
                gdtMotiveHippyVideoView = weakReference.get();
            } else {
                gdtMotiveHippyVideoView = null;
            }
            if (gdtMotiveHippyVideoView == null) {
                QLog.e("GdtMotiveHippyVideoView", 1, "[GdtOnVideoPreparedListener][onVideoPrepared] error, videoView is null");
                return;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[GdtOnVideoPreparedListener][onVideoPrepared] videoPlayListener:");
            if (gdtMotiveHippyVideoView.f109016f != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            QLog.i("GdtMotiveHippyVideoView", 1, sb5.toString());
            AdThreadManager.getInstance().post(new Runnable() { // from class: com.tencent.gdtad.basics.motivevideo.hippy.video.GdtMotiveHippyVideoView.GdtOnVideoPreparedListener.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        gdtMotiveHippyVideoView.r();
                    } catch (Throwable th5) {
                        QLog.e("GdtMotiveHippyVideoView", 1, "[onVideoPrepared]", th5);
                    }
                }
            }, 0);
            DKVideoPlayer.OnVideoPlayListener onVideoPlayListener = gdtMotiveHippyVideoView.f109016f;
            if (onVideoPlayListener != null) {
                onVideoPlayListener.onReady();
            }
            gdtMotiveHippyVideoView.f109019m = true;
            if (gdtMotiveHippyVideoView.f109018i || gdtMotiveHippyVideoView.D) {
                gdtMotiveHippyVideoView.p();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class a implements ISuperPlayer.OnCompletionListener {

        /* renamed from: d, reason: collision with root package name */
        WeakReference<GdtMotiveHippyVideoView> f109027d;

        public a(WeakReference<GdtMotiveHippyVideoView> weakReference) {
            this.f109027d = weakReference;
        }

        @Override // com.tencent.superplayer.api.ISuperPlayer.OnCompletionListener
        public void onCompletion(ISuperPlayer iSuperPlayer) {
            GdtMotiveHippyVideoView gdtMotiveHippyVideoView;
            boolean z16;
            WeakReference<GdtMotiveHippyVideoView> weakReference = this.f109027d;
            if (weakReference != null) {
                gdtMotiveHippyVideoView = weakReference.get();
            } else {
                gdtMotiveHippyVideoView = null;
            }
            if (gdtMotiveHippyVideoView != null) {
                DKVideoPlayer.OnVideoPlayListener onVideoPlayListener = gdtMotiveHippyVideoView.f109016f;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("[GdtOnCompletionListener][onCompletion] videoPlayListener:");
                if (onVideoPlayListener != null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                sb5.append(z16);
                QLog.i("GdtMotiveHippyVideoView", 1, sb5.toString());
                if (onVideoPlayListener != null) {
                    onVideoPlayListener.onEnded();
                    return;
                }
                return;
            }
            QLog.e("GdtMotiveHippyVideoView", 1, "[GdtOnCompletionListener][onCompletion] error, videoView is null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class b implements ISuperPlayer.OnErrorListener {

        /* renamed from: d, reason: collision with root package name */
        WeakReference<GdtMotiveHippyVideoView> f109028d;

        public b(WeakReference<GdtMotiveHippyVideoView> weakReference) {
            this.f109028d = weakReference;
        }

        @Override // com.tencent.superplayer.api.ISuperPlayer.OnErrorListener
        public boolean onError(ISuperPlayer iSuperPlayer, int i3, int i16, int i17, String str) {
            GdtMotiveHippyVideoView gdtMotiveHippyVideoView;
            com.tencent.gdtad.basics.motivevideo.hippy.video.a aVar;
            boolean z16;
            WeakReference<GdtMotiveHippyVideoView> weakReference = this.f109028d;
            DKVideoPlayer.OnVideoPlayListener onVideoPlayListener = null;
            if (weakReference != null) {
                gdtMotiveHippyVideoView = weakReference.get();
            } else {
                gdtMotiveHippyVideoView = null;
            }
            if (gdtMotiveHippyVideoView != null && gdtMotiveHippyVideoView.E != null) {
                aVar = (com.tencent.gdtad.basics.motivevideo.hippy.video.a) gdtMotiveHippyVideoView.E.get();
            } else {
                aVar = null;
            }
            if (aVar != null) {
                aVar.onError(i3, i16, i17, str);
            }
            if (gdtMotiveHippyVideoView != null) {
                onVideoPlayListener = gdtMotiveHippyVideoView.f109016f;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[GdtOnErrorListener][onError] videoPlayListener:");
            if (onVideoPlayListener != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            sb5.append("module:");
            sb5.append(i3);
            sb5.append(" errorType:");
            sb5.append(i16);
            sb5.append(" errorCode:");
            sb5.append(i17);
            sb5.append(" extraInfo:");
            sb5.append(str);
            QLog.e("GdtMotiveHippyVideoView", 1, sb5.toString());
            if (onVideoPlayListener != null) {
                onVideoPlayListener.onError(i17, str);
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class c implements ISuperPlayer.OnInfoListener {

        /* renamed from: d, reason: collision with root package name */
        WeakReference<GdtMotiveHippyVideoView> f109029d;

        public c(WeakReference<GdtMotiveHippyVideoView> weakReference) {
            this.f109029d = weakReference;
        }

        @Override // com.tencent.superplayer.api.ISuperPlayer.OnInfoListener
        public boolean onInfo(ISuperPlayer iSuperPlayer, int i3, long j3, long j16, Object obj) {
            GdtMotiveHippyVideoView gdtMotiveHippyVideoView;
            WeakReference<GdtMotiveHippyVideoView> weakReference = this.f109029d;
            com.tencent.gdtad.basics.motivevideo.hippy.video.a aVar = null;
            if (weakReference != null) {
                gdtMotiveHippyVideoView = weakReference.get();
            } else {
                gdtMotiveHippyVideoView = null;
            }
            if (gdtMotiveHippyVideoView != null) {
                DKVideoPlayer.OnVideoPlayListener onVideoPlayListener = gdtMotiveHippyVideoView.f109016f;
                if (onVideoPlayListener == null) {
                    QLog.e("GdtMotiveHippyVideoView", 1, "[GdtOnInfoListener][onInfo] error, videoPlayListener is null, what:" + i3);
                }
                if (gdtMotiveHippyVideoView.E != null) {
                    aVar = (com.tencent.gdtad.basics.motivevideo.hippy.video.a) gdtMotiveHippyVideoView.E.get();
                }
                if (aVar == null) {
                    QLog.e("GdtMotiveHippyVideoView", 1, "[GdtOnInfoListener][onInfo] error, videoNativeListener is null, what:" + i3);
                }
                if (i3 != 105) {
                    if (i3 != 108) {
                        QLog.i("GdtMotiveHippyVideoView", 1, "[GdtOnInfoListener][onInfo] do nothing, what:" + i3);
                    } else {
                        QLog.i("GdtMotiveHippyVideoView", 1, "[GdtOnInfoListener][onInfo] loop end, what:" + i3);
                        if (onVideoPlayListener != null) {
                            onVideoPlayListener.onEnded();
                        }
                    }
                } else {
                    QLog.i("GdtMotiveHippyVideoView", 1, "[GdtOnInfoListener][onInfo] first video frame rendered, what:" + i3);
                    if (onVideoPlayListener != null) {
                        onVideoPlayListener.onPlay();
                    }
                    if (aVar != null) {
                        aVar.onFirstFrameRendered();
                    }
                }
                return false;
            }
            QLog.e("GdtMotiveHippyVideoView", 1, "[GdtOnInfoListener][onInfo] error, videoView is null, what:" + i3);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class d implements ISuperPlayer.OnSeekCompleteListener {

        /* renamed from: d, reason: collision with root package name */
        WeakReference<GdtMotiveHippyVideoView> f109030d;

        public d(WeakReference<GdtMotiveHippyVideoView> weakReference) {
            this.f109030d = weakReference;
        }

        @Override // com.tencent.superplayer.api.ISuperPlayer.OnSeekCompleteListener
        public void onSeekComplete(ISuperPlayer iSuperPlayer) {
            GdtMotiveHippyVideoView gdtMotiveHippyVideoView;
            boolean z16;
            if (iSuperPlayer == null) {
                QLog.e("GdtMotiveHippyVideoView", 1, "[GdtOnSeekCompleteListener][onSeekComplete] error, iSuperPlayer is null");
                return;
            }
            WeakReference<GdtMotiveHippyVideoView> weakReference = this.f109030d;
            if (weakReference != null) {
                gdtMotiveHippyVideoView = weakReference.get();
            } else {
                gdtMotiveHippyVideoView = null;
            }
            if (gdtMotiveHippyVideoView != null) {
                DKVideoPlayer.OnVideoPlayListener onVideoPlayListener = gdtMotiveHippyVideoView.f109016f;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("[GdtOnSeekCompleteListener][onSeekComplete] videoPlayListener:");
                if (onVideoPlayListener != null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                sb5.append(z16);
                QLog.i("GdtMotiveHippyVideoView", 1, sb5.toString());
                if (onVideoPlayListener != null) {
                    onVideoPlayListener.onSeeked((int) iSuperPlayer.getCurrentPositionMs());
                    return;
                }
                return;
            }
            QLog.e("GdtMotiveHippyVideoView", 1, "[GdtOnSeekCompleteListener][onSeekComplete] error, videoView is null");
        }
    }

    public GdtMotiveHippyVideoView(Context context, WeakReference<com.tencent.gdtad.basics.motivevideo.hippy.video.a> weakReference) {
        super(context);
        this.f109018i = false;
        this.E = weakReference;
        o();
        n();
    }

    private void n() {
        if (this.f109014d != null && this.f109015e != null) {
            QLog.i("GdtMotiveHippyVideoView", 1, "[initListeners]");
            this.f109014d.setOnVideoPreparedListener(new GdtOnVideoPreparedListener(new WeakReference(this)));
            this.f109014d.setOnErrorListener(new b(new WeakReference(this)));
            this.f109014d.setOnSeekCompleteListener(new d(new WeakReference(this)));
            this.f109014d.setOnCompletionListener(new a(new WeakReference(this)));
            this.f109014d.setOnInfoListener(new c(new WeakReference(this)));
            return;
        }
        QLog.e("GdtMotiveHippyVideoView", 1, "[initListeners] error, mVideoPlayer is null");
    }

    private void o() {
        ISPlayerVideoView iSPlayerVideoView;
        this.f109015e = SuperPlayerFactory.createPlayerVideoView(getContext());
        ISuperPlayer createMediaPlayer = SuperPlayerFactory.createMediaPlayer(getContext(), 110, this.f109015e);
        this.f109014d = createMediaPlayer;
        if (createMediaPlayer != null && (iSPlayerVideoView = this.f109015e) != null) {
            if (iSPlayerVideoView instanceof View) {
                QLog.i("GdtMotiveHippyVideoView", 1, "[initPlayerAndView]");
                addView((View) this.f109015e, 0);
                return;
            } else {
                QLog.e("GdtMotiveHippyVideoView", 1, "[initPlayerAndView] error, mVideoView not instanceof View)");
                return;
            }
        }
        QLog.e("GdtMotiveHippyVideoView", 1, "[initPlayerAndView] error");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(final String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("GdtMotiveHippyVideoView", 1, "[prepare] error, videoUrl is empty");
        } else {
            AdThreadManager.getInstance().post(new Runnable() { // from class: com.tencent.gdtad.basics.motivevideo.hippy.video.GdtMotiveHippyVideoView.1
                @Override // java.lang.Runnable
                public void run() {
                    boolean z16;
                    com.tencent.gdtad.basics.motivevideo.hippy.video.a aVar;
                    if (GdtMotiveHippyVideoView.this.f109019m) {
                        QLog.e("GdtMotiveHippyVideoView", 1, "[prepare] error, too frequently, mIsPrepared:" + GdtMotiveHippyVideoView.this.f109019m);
                        return;
                    }
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("[prepare] videoUrl:");
                    sb5.append(str);
                    sb5.append(" mVideoPlayer:");
                    if (GdtMotiveHippyVideoView.this.f109014d != null) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    sb5.append(z16);
                    QLog.i("GdtMotiveHippyVideoView", 1, sb5.toString());
                    if (GdtMotiveHippyVideoView.this.E != null) {
                        aVar = (com.tencent.gdtad.basics.motivevideo.hippy.video.a) GdtMotiveHippyVideoView.this.E.get();
                    } else {
                        aVar = null;
                    }
                    if (aVar != null) {
                        aVar.a();
                    }
                    SuperPlayerVideoInfo createVideoInfoForUrl = SuperPlayerFactory.createVideoInfoForUrl(str, 104, (String) null, (String) null);
                    if (GdtMotiveHippyVideoView.this.f109014d != null) {
                        GdtMotiveHippyVideoView.this.f109014d.openMediaPlayer(GdtMotiveHippyVideoView.this.getContext(), createVideoInfoForUrl, 0L);
                    }
                }
            }, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        ISuperPlayer iSuperPlayer = this.f109014d;
        Object obj = this.f109015e;
        DKVideoPlayer.ObjectFit objectFit = this.f109017h;
        if (iSuperPlayer != null && obj != null && objectFit != null) {
            float videoWidth = iSuperPlayer.getVideoWidth();
            float videoHeight = iSuperPlayer.getVideoHeight();
            if (GdtUIUtils.isFloatEqual(videoHeight, 0.0f)) {
                QLog.e("GdtMotiveHippyVideoView", 1, "[setVideoScale] error, videoHeight not valid");
                return;
            }
            if (!(obj instanceof View)) {
                QLog.e("GdtMotiveHippyVideoView", 1, "[setVideoScale] error, videoView not instanceof View");
                return;
            }
            View view = (View) obj;
            float width = view.getWidth();
            float height = view.getHeight();
            if (GdtUIUtils.isFloatEqual(height, 0.0f)) {
                QLog.e("GdtMotiveHippyVideoView", 1, "[setVideoScale] error, viewHeight not valid");
                return;
            }
            float f16 = videoWidth / videoHeight;
            float f17 = width / height;
            if (!GdtUIUtils.isFloatEqual(f16, 0.0f) && !GdtUIUtils.isFloatEqual(f17, 0.0f)) {
                float f18 = f16 / f17;
                if (f18 >= 1.0f) {
                    if (objectFit == DKVideoPlayer.ObjectFit.CONTAIN) {
                        view.setScaleX(1.0f);
                        view.setScaleY(1.0f / f18);
                        return;
                    } else if (objectFit == DKVideoPlayer.ObjectFit.COVER) {
                        view.setScaleX(f18);
                        view.setScaleY(1.0f);
                        return;
                    } else {
                        view.setScaleX(1.0f);
                        view.setScaleY(1.0f);
                        return;
                    }
                }
                if (!GdtUIUtils.isFloatEqual(f18, 0.0f)) {
                    if (objectFit == DKVideoPlayer.ObjectFit.CONTAIN) {
                        view.setScaleX(f18);
                        view.setScaleY(1.0f);
                        return;
                    } else if (objectFit == DKVideoPlayer.ObjectFit.COVER) {
                        view.setScaleX(1.0f);
                        view.setScaleY(1.0f / f18);
                        return;
                    } else {
                        view.setScaleX(1.0f);
                        view.setScaleY(1.0f);
                        return;
                    }
                }
                return;
            }
            QLog.e("GdtMotiveHippyVideoView", 1, "[setVideoScale] error, screenRatio|videoRatio not valid");
            return;
        }
        QLog.e("GdtMotiveHippyVideoView", 1, "[setVideoScale] error, videoView|videoPlayer|objectFit is null");
    }

    @Override // com.tencent.ams.dsdk.view.video.DKVideoPlayer
    public int getCurrentPosition() {
        ISuperPlayer iSuperPlayer = this.f109014d;
        if (iSuperPlayer != null) {
            return (int) iSuperPlayer.getCurrentPositionMs();
        }
        return 0;
    }

    @Override // com.tencent.ams.dsdk.view.video.DKVideoPlayer
    public int getDuration() {
        ISuperPlayer iSuperPlayer = this.f109014d;
        if (iSuperPlayer != null) {
            return (int) iSuperPlayer.getDurationMs();
        }
        return 0;
    }

    @Override // com.tencent.ams.dsdk.view.video.DKVideoPlayer
    public boolean isPlaying() {
        ISuperPlayer iSuperPlayer = this.f109014d;
        if (iSuperPlayer != null) {
            return iSuperPlayer.isPlaying();
        }
        return false;
    }

    @Override // com.tencent.ams.dsdk.view.video.DKVideoPlayer
    public void onDestroy() {
        QLog.i("GdtMotiveHippyVideoView", 1, "[onDestroy]");
        AdThreadManager.getInstance().post(new Runnable() { // from class: com.tencent.gdtad.basics.motivevideo.hippy.video.GdtMotiveHippyVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (GdtMotiveHippyVideoView.this.f109014d != null) {
                    GdtMotiveHippyVideoView.this.f109014d.release();
                }
                GdtMotiveHippyVideoView.this.f109014d = null;
            }
        }, 0);
        this.f109015e = null;
        this.f109016f = null;
        this.f109018i = false;
        this.f109019m = false;
        this.D = false;
    }

    public void p() {
        this.D = false;
        AdThreadManager.getInstance().post(new Runnable() { // from class: com.tencent.gdtad.basics.motivevideo.hippy.video.GdtMotiveHippyVideoView.4
            @Override // java.lang.Runnable
            public void run() {
                QLog.i("GdtMotiveHippyVideoView", 1, "[innerStart]");
                if (GdtMotiveHippyVideoView.this.f109014d != null && GdtMotiveHippyVideoView.this.f109019m) {
                    GdtMotiveHippyVideoView.this.f109014d.start();
                }
            }
        }, 0);
    }

    @Override // com.tencent.ams.dsdk.view.video.DKVideoPlayer, android.widget.MediaController.MediaPlayerControl
    public void pause() {
        AdThreadManager.getInstance().post(new Runnable() { // from class: com.tencent.gdtad.basics.motivevideo.hippy.video.GdtMotiveHippyVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                boolean z16;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("[pause] mVideoPlayer:");
                if (GdtMotiveHippyVideoView.this.f109014d != null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                sb5.append(z16);
                QLog.i("GdtMotiveHippyVideoView", 1, sb5.toString());
                if (GdtMotiveHippyVideoView.this.f109014d != null) {
                    GdtMotiveHippyVideoView.this.D = false;
                    GdtMotiveHippyVideoView.this.f109014d.pause();
                    DKVideoPlayer.OnVideoPlayListener onVideoPlayListener = GdtMotiveHippyVideoView.this.f109016f;
                    if (onVideoPlayListener != null) {
                        onVideoPlayListener.onPause();
                    }
                }
            }
        }, 0);
    }

    @Override // com.tencent.ams.dsdk.view.video.DKVideoPlayer, android.widget.MediaController.MediaPlayerControl
    public void seekTo(final int i3) {
        boolean z16;
        DKVideoPlayer.OnVideoPlayListener onVideoPlayListener = this.f109016f;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[seekTo] positionMs:");
        sb5.append(i3);
        sb5.append(" videoPlayListener:");
        if (onVideoPlayListener != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        QLog.i("GdtMotiveHippyVideoView", 1, sb5.toString());
        if (onVideoPlayListener != null) {
            onVideoPlayListener.onSeeking(i3);
        }
        AdThreadManager.getInstance().post(new Runnable() { // from class: com.tencent.gdtad.basics.motivevideo.hippy.video.GdtMotiveHippyVideoView.8
            @Override // java.lang.Runnable
            public void run() {
                boolean z17;
                StringBuilder sb6 = new StringBuilder();
                sb6.append("[seekTo] on main thread, positionMs:");
                sb6.append(i3);
                sb6.append(" mVideoPlayer:");
                if (GdtMotiveHippyVideoView.this.f109014d != null) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                sb6.append(z17);
                QLog.i("GdtMotiveHippyVideoView", 1, sb6.toString());
                if (GdtMotiveHippyVideoView.this.f109014d != null) {
                    GdtMotiveHippyVideoView.this.f109014d.seekTo(i3);
                }
            }
        }, 0);
    }

    @Override // com.tencent.ams.dsdk.view.video.DKVideoPlayer
    public void setAutoPlay(boolean z16) {
        QLog.i("GdtMotiveHippyVideoView", 1, "[setAutoPlay]:" + z16);
        this.f109018i = z16;
    }

    @Override // com.tencent.ams.dsdk.view.video.DKVideoPlayer
    public void setLoop(final boolean z16) {
        AdThreadManager.getInstance().post(new Runnable() { // from class: com.tencent.gdtad.basics.motivevideo.hippy.video.GdtMotiveHippyVideoView.3
            @Override // java.lang.Runnable
            public void run() {
                boolean z17;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("[setLoop] isLoop:");
                sb5.append(z16);
                sb5.append(" mVideoPlayer:");
                if (GdtMotiveHippyVideoView.this.f109014d != null) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                sb5.append(z17);
                QLog.i("GdtMotiveHippyVideoView", 1, sb5.toString());
                if (GdtMotiveHippyVideoView.this.f109014d != null) {
                    GdtMotiveHippyVideoView.this.f109014d.setLoopback(z16);
                }
            }
        }, 0);
    }

    @Override // com.tencent.ams.dsdk.view.video.DKVideoPlayer
    public void setMute(final boolean z16) {
        AdThreadManager.getInstance().post(new Runnable() { // from class: com.tencent.gdtad.basics.motivevideo.hippy.video.GdtMotiveHippyVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                boolean z17;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("[setMute] isMute:");
                sb5.append(z16);
                sb5.append(" mVideoPlayer:");
                if (GdtMotiveHippyVideoView.this.f109014d != null) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                sb5.append(z17);
                QLog.i("GdtMotiveHippyVideoView", 1, sb5.toString());
                if (GdtMotiveHippyVideoView.this.f109014d != null) {
                    GdtMotiveHippyVideoView.this.f109014d.setOutputMute(z16);
                }
            }
        }, 0);
    }

    @Override // com.tencent.ams.dsdk.view.video.DKVideoPlayer
    public void setObjectFit(DKVideoPlayer.ObjectFit objectFit) {
        QLog.i("GdtMotiveHippyVideoView", 1, "[setObjectFit] objectFit: " + objectFit);
        this.f109017h = objectFit;
    }

    @Override // com.tencent.ams.dsdk.view.video.DKVideoPlayer
    public void setVid(String str) {
        QLog.i("GdtMotiveHippyVideoView", 1, "[setVid] vid:" + str);
    }

    @Override // com.tencent.ams.dsdk.view.video.DKVideoPlayer
    public void setVideoPath(final String str) {
        AdThreadManager.getInstance().post(new Runnable() { // from class: com.tencent.gdtad.basics.motivevideo.hippy.video.GdtMotiveHippyVideoView.2
            @Override // java.lang.Runnable
            public void run() {
                if (!TextUtils.isEmpty(GdtMotiveHippyVideoView.this.C)) {
                    QLog.e("GdtMotiveHippyVideoView", 1, "[setVideoPath] error, too frequently videoUrl:" + str + " mVideoUrl:" + GdtMotiveHippyVideoView.this.C);
                    return;
                }
                QLog.e("GdtMotiveHippyVideoView", 1, "[setVideoPath] videoUrl:" + str);
                GdtMotiveHippyVideoView.this.C = str;
                GdtMotiveHippyVideoView.this.q(str);
            }
        }, 0);
    }

    @Override // com.tencent.ams.dsdk.view.video.DKVideoPlayer
    public void setVideoPlayListener(DKVideoPlayer.OnVideoPlayListener onVideoPlayListener) {
        this.f109016f = onVideoPlayListener;
    }

    @Override // com.tencent.ams.dsdk.view.video.DKVideoPlayer
    public void setVolume(float f16) {
        QLog.i("GdtMotiveHippyVideoView", 1, "[setVolume] volume:" + f16);
        try {
            AudioManager audioManager = (AudioManager) BaseApplication.getContext().getSystemService("audio");
            if (audioManager != null) {
                audioManager.setStreamVolume(3, (int) (audioManager.getStreamMaxVolume(3) * f16), 0);
            }
        } catch (Throwable th5) {
            QLog.e("GdtMotiveHippyVideoView", 1, "[setVolume] volume:" + f16, th5);
        }
    }

    @Override // com.tencent.ams.dsdk.view.video.DKVideoPlayer
    public void start() {
        QLog.i("GdtMotiveHippyVideoView", 1, "[start] mIsPrepared:" + this.f109019m);
        if (this.f109019m) {
            p();
        } else {
            this.D = true;
        }
    }

    @Override // com.tencent.ams.dsdk.view.video.DKVideoPlayer
    public void stop() {
        AdThreadManager.getInstance().post(new Runnable() { // from class: com.tencent.gdtad.basics.motivevideo.hippy.video.GdtMotiveHippyVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                boolean z16;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("[stop] mVideoPlayer:");
                if (GdtMotiveHippyVideoView.this.f109014d != null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                sb5.append(z16);
                QLog.i("GdtMotiveHippyVideoView", 1, sb5.toString());
                if (GdtMotiveHippyVideoView.this.f109014d != null) {
                    GdtMotiveHippyVideoView.this.f109014d.stop();
                }
            }
        }, 0);
    }

    @Override // com.tencent.ams.dsdk.view.video.DKVideoPlayer
    public View getView() {
        return this;
    }

    @Override // com.tencent.ams.dsdk.view.video.DKVideoPlayer
    public void setVideoParams(JSONObject jSONObject) {
    }
}
