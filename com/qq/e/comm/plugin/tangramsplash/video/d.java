package com.qq.e.comm.plugin.tangramsplash.video;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import com.qq.e.comm.pi.ITangramPlayer;
import com.qq.e.comm.plugin.router.PublicApi;
import com.qq.e.comm.plugin.router.PublicApiHelper;
import com.qq.e.comm.plugin.tangramsplash.report.SplashLinkReporter;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.tg.TangramAlphaVideoPlayInfo;
import com.qq.e.tg.splash.ITangramPlayerListener;
import com.tencent.ams.fusion.widget.alphaplayer.AlphaPlayer;
import com.tencent.ams.fusion.widget.alphaplayer.AlphaVideoView;
import com.tencent.ams.fusion.widget.alphaplayer.PlayInfo;
import com.tencent.ams.fusion.widget.alphaplayer.gl.FormatType;
import com.tencent.ams.fusion.widget.alphaplayer.gl.ScaleType;
import com.tencent.ams.fusion.widget.alphaplayer.player.IPlayer;

/* compiled from: P */
/* loaded from: classes3.dex */
public class d implements ITangramPlayer, AlphaPlayer.AlphaPlayerListener {

    /* renamed from: a, reason: collision with root package name */
    ITangramPlayerListener f40405a;

    /* renamed from: b, reason: collision with root package name */
    private final AlphaVideoView f40406b;

    /* renamed from: c, reason: collision with root package name */
    private TangramAlphaVideoPlayInfo f40407c;

    /* renamed from: d, reason: collision with root package name */
    private volatile boolean f40408d = false;

    /* renamed from: e, reason: collision with root package name */
    private volatile boolean f40409e = false;

    /* renamed from: f, reason: collision with root package name */
    private boolean f40410f;

    /* renamed from: g, reason: collision with root package name */
    private AudioManager f40411g;

    /* renamed from: h, reason: collision with root package name */
    private AudioFocusRequest f40412h;

    /* renamed from: i, reason: collision with root package name */
    private IPlayer f40413i;

    public d(Context context, TangramAlphaVideoPlayInfo tangramAlphaVideoPlayInfo) {
        this.f40410f = false;
        AlphaVideoView alphaVideoView = new AlphaVideoView(context, com.qq.e.comm.plugin.j.c.a("alphaVideoViewRenderMode", 2));
        this.f40406b = alphaVideoView;
        alphaVideoView.setPlayerListener(this);
        this.f40407c = tangramAlphaVideoPlayInfo;
        if (tangramAlphaVideoPlayInfo != null) {
            this.f40410f = tangramAlphaVideoPlayInfo.isOutputMute();
        }
        a(context);
    }

    private void a(Context context) {
        AudioFocusRequest.Builder audioAttributes;
        AudioFocusRequest build;
        if (context == null) {
            return;
        }
        try {
            this.f40411g = (AudioManager) context.getSystemService("audio");
            if (Build.VERSION.SDK_INT >= 26) {
                audioAttributes = new AudioFocusRequest.Builder(2).setAudioAttributes(new AudioAttributes.Builder().setUsage(1).setContentType(2).build());
                build = audioAttributes.build();
                this.f40412h = build;
            }
        } catch (Throwable th5) {
            GDTLogger.e(th5.getMessage());
        }
    }

    public static boolean b() {
        String str = null;
        String a16 = com.qq.e.comm.plugin.j.c.a((String) null, "transparentVideoBlackList", "");
        if (TextUtils.isEmpty(a16)) {
            return true;
        }
        try {
            str = ((PublicApi.DeviceInfoApi) PublicApiHelper.getModuleApi(PublicApi.DeviceInfoApi.class)).getBuildModel();
        } catch (Throwable th5) {
            GDTLogger.e("isValid error ", th5);
        }
        return TextUtils.isEmpty(str) || !a16.contains(str);
    }

    private void c() {
        if (this.f40411g == null || this.f40412h == null) {
            return;
        }
        GDTLogger.d("tryRequestAudioFocus");
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                this.f40411g.requestAudioFocus(this.f40412h);
            } else {
                this.f40411g.requestAudioFocus(null, 3, 2);
            }
        } catch (Throwable th5) {
            GDTLogger.e(th5.getMessage());
        }
    }

    private void d() {
        if (this.f40411g != null && this.f40412h != null) {
            GDTLogger.d("tryAbandonAudioFocus");
            try {
                if (Build.VERSION.SDK_INT >= 26) {
                    this.f40411g.abandonAudioFocusRequest(this.f40412h);
                } else {
                    this.f40411g.abandonAudioFocus(null);
                }
            } catch (Throwable th5) {
                GDTLogger.e(th5.getMessage());
            }
        }
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.AlphaPlayer.AlphaPlayerListener
    public boolean executeTask(Runnable runnable) {
        return false;
    }

    @Override // com.qq.e.comm.pi.ITangramPlayer
    public void free() {
        stop();
    }

    @Override // com.qq.e.comm.pi.ITangramPlayer
    public int getCurrentPosition() {
        long j3;
        AlphaVideoView alphaVideoView = this.f40406b;
        if (alphaVideoView != null) {
            j3 = alphaVideoView.getPosition();
        } else {
            j3 = 0;
        }
        return (int) j3;
    }

    @Override // com.qq.e.comm.pi.ITangramPlayer
    public int getDuration() {
        long j3;
        AlphaVideoView alphaVideoView = this.f40406b;
        if (alphaVideoView != null) {
            j3 = alphaVideoView.getDuration();
        } else {
            j3 = 0;
        }
        return (int) j3;
    }

    @Override // com.qq.e.comm.pi.ITangramPlayer
    public boolean isPlaying() {
        AlphaVideoView alphaVideoView = this.f40406b;
        if (alphaVideoView != null && alphaVideoView.isPlaying()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.AlphaPlayer.AlphaPlayerListener
    public void onComplete() {
        boolean z16;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("TGAlphaVideoView onComplete ");
        if (this.f40405a != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        GDTLogger.d(sb5.toString());
        this.f40408d = true;
        a(7010010);
        ITangramPlayerListener iTangramPlayerListener = this.f40405a;
        if (iTangramPlayerListener != null) {
            iTangramPlayerListener.onVideoComplete();
        }
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.AlphaPlayer.AlphaPlayerListener
    public void onError(int i3) {
        GDTLogger.d("TGAlphaVideoView onError ");
        a(7010012);
        ITangramPlayerListener iTangramPlayerListener = this.f40405a;
        if (iTangramPlayerListener != null) {
            iTangramPlayerListener.onVideoError();
        }
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.AlphaPlayer.AlphaPlayerListener
    public boolean onInfo(int i3, int i16) {
        return false;
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.AlphaPlayer.AlphaPlayerListener
    public void onPause() {
        boolean z16;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("TGAlphaVideoView onPause ");
        if (this.f40405a != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        GDTLogger.d(sb5.toString());
        ITangramPlayerListener iTangramPlayerListener = this.f40405a;
        if (iTangramPlayerListener != null) {
            iTangramPlayerListener.onVideoPause();
        }
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.AlphaPlayer.AlphaPlayerListener
    public void onPrepared(int i3, int i16) {
        boolean z16;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("TGAlphaVideoView onPrepared ");
        if (this.f40405a != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        GDTLogger.d(sb5.toString());
        ITangramPlayerListener iTangramPlayerListener = this.f40405a;
        if (iTangramPlayerListener != null) {
            iTangramPlayerListener.onVideoReady();
        }
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.AlphaPlayer.AlphaPlayerListener
    public void onSeekComplete() {
        boolean z16;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("TGAlphaVideoView onSeekComplete ");
        if (this.f40405a != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        GDTLogger.d(sb5.toString());
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.AlphaPlayer.AlphaPlayerListener
    public void onStart() {
        boolean z16;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("TGAlphaVideoView onStart ");
        if (this.f40405a != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        GDTLogger.d(sb5.toString());
        a(7010009);
        ITangramPlayerListener iTangramPlayerListener = this.f40405a;
        if (iTangramPlayerListener != null) {
            iTangramPlayerListener.onVideoStart();
        }
    }

    @Override // com.tencent.ams.fusion.widget.alphaplayer.AlphaPlayer.AlphaPlayerListener
    public void onStop() {
        boolean z16;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("TGAlphaVideoView onStop ");
        if (this.f40405a != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        GDTLogger.d(sb5.toString());
        a(7010011);
        ITangramPlayerListener iTangramPlayerListener = this.f40405a;
        if (iTangramPlayerListener != null) {
            iTangramPlayerListener.onVideoStop();
        }
    }

    @Override // com.qq.e.comm.pi.ITangramPlayer
    public void pause() {
        AlphaVideoView alphaVideoView = this.f40406b;
        if (alphaVideoView != null) {
            alphaVideoView.pause();
        }
        GDTLogger.e("TangramSplashAlphaVideoPlayer pause");
    }

    @Override // com.qq.e.comm.pi.ITangramPlayer
    public void play() {
        if (this.f40407c != null && this.f40406b != null) {
            PlayInfo playInfo = new PlayInfo();
            playInfo.setLoopPlay(this.f40407c.isLoopPlay());
            playInfo.setOutputMute(this.f40407c.isOutputMute());
            playInfo.setVideoPath(this.f40407c.getVideoPath());
            playInfo.setScaleType(ScaleType.CENTER_CROP);
            playInfo.setSurfaceViewMediaOverlay(true);
            IPlayer iPlayer = this.f40413i;
            if (iPlayer != null) {
                playInfo.setDecoderPlayer(iPlayer);
            }
            playInfo.setFormatType(c(this.f40407c.getFormatType()));
            this.f40406b.setPlayInfo(playInfo);
            this.f40408d = false;
            this.f40409e = false;
            this.f40406b.start();
        }
    }

    @Override // com.qq.e.comm.pi.ITangramPlayer
    public void setDataSource(String str) {
        TangramAlphaVideoPlayInfo tangramAlphaVideoPlayInfo = this.f40407c;
        if (tangramAlphaVideoPlayInfo != null) {
            tangramAlphaVideoPlayInfo.setVideoPath(str);
        }
    }

    @Override // com.qq.e.comm.pi.ITangramPlayer
    public void setVideoPlayerListener(ITangramPlayerListener iTangramPlayerListener) {
        this.f40405a = iTangramPlayerListener;
    }

    @Override // com.qq.e.comm.pi.ITangramPlayer
    public void setVolume(float f16) {
        TangramAlphaVideoPlayInfo tangramAlphaVideoPlayInfo;
        if (this.f40406b != null && (tangramAlphaVideoPlayInfo = this.f40407c) != null) {
            this.f40410f = false;
            tangramAlphaVideoPlayInfo.setOutputMute(false);
            this.f40406b.setVolume(f16);
            c();
        }
    }

    @Override // com.qq.e.comm.pi.ITangramPlayer
    public void setVolumeOff() {
        TangramAlphaVideoPlayInfo tangramAlphaVideoPlayInfo;
        GDTLogger.d("Set volume off.");
        if (this.f40406b != null && (tangramAlphaVideoPlayInfo = this.f40407c) != null && !this.f40410f) {
            this.f40410f = true;
            tangramAlphaVideoPlayInfo.setOutputMute(true);
            this.f40406b.setVolumeOff();
            d();
        }
    }

    @Override // com.qq.e.comm.pi.ITangramPlayer
    public void setVolumeOn() {
        TangramAlphaVideoPlayInfo tangramAlphaVideoPlayInfo;
        GDTLogger.d("Set volume off.");
        if (this.f40406b != null && (tangramAlphaVideoPlayInfo = this.f40407c) != null && this.f40410f) {
            this.f40410f = false;
            tangramAlphaVideoPlayInfo.setOutputMute(false);
            this.f40406b.setVolumeOn();
            c();
        }
    }

    @Override // com.qq.e.comm.pi.ITangramPlayer
    public void stop() {
        AlphaVideoView alphaVideoView = this.f40406b;
        if (alphaVideoView != null) {
            alphaVideoView.stop();
        }
        if (!this.f40408d && !this.f40409e && this.f40407c != null) {
            this.f40409e = true;
        }
    }

    public void b(int i3) {
        AlphaVideoView alphaVideoView = this.f40406b;
        if (alphaVideoView != null) {
            alphaVideoView.seekTo(i3);
        }
    }

    private static FormatType c(int i3) {
        return i3 == 3 ? FormatType.COMPRESS : FormatType.ALIGNED;
    }

    public View a() {
        return this.f40406b;
    }

    public void a(int i3) {
        TangramAlphaVideoPlayInfo tangramAlphaVideoPlayInfo = this.f40407c;
        if (tangramAlphaVideoPlayInfo != null) {
            SplashLinkReporter.a(i3, tangramAlphaVideoPlayInfo.getPosId(), this.f40407c.getAdData());
        }
    }

    public void a(IPlayer iPlayer) {
        this.f40413i = iPlayer;
    }
}
