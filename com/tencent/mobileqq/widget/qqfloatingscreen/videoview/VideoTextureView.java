package com.tencent.mobileqq.widget.qqfloatingscreen.videoview;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.os.Handler;
import android.view.Surface;
import android.view.TextureView;
import com.tencent.mobileqq.qqfloatingwindow.listener.IVideoOuterStatusListener;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes20.dex */
public class VideoTextureView extends TextureView implements TextureView.SurfaceTextureListener {
    private static IVideoOuterStatusListener D;
    final Runnable C;

    /* renamed from: d, reason: collision with root package name */
    private MediaPlayer f317192d;

    /* renamed from: e, reason: collision with root package name */
    private Surface f317193e;

    /* renamed from: f, reason: collision with root package name */
    private e f317194f;

    /* renamed from: h, reason: collision with root package name */
    private WeakReference<Context> f317195h;

    /* renamed from: i, reason: collision with root package name */
    private int f317196i;

    /* renamed from: m, reason: collision with root package name */
    private String f317197m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements MediaPlayer.OnPreparedListener {
        a() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            if (VideoTextureView.this.f317192d != null) {
                VideoTextureView.this.f317192d.start();
                VideoTextureView videoTextureView = VideoTextureView.this;
                videoTextureView.f317196i = videoTextureView.f317192d.getDuration();
            }
            if (VideoTextureView.D != null && VideoTextureView.this.f317192d != null) {
                VideoTextureView.D.onVideoStart(VideoTextureView.this.f317196i);
                VideoTextureView.D.onVideoProgressUpdate(0);
                VideoTextureView.D.onVideoSize(VideoTextureView.this.f317192d.getVideoWidth(), VideoTextureView.this.f317192d.getVideoHeight());
            }
            if (VideoTextureView.this.f317194f != null) {
                VideoTextureView.this.f317194f.post(VideoTextureView.this.C);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class b implements MediaPlayer.OnCompletionListener {
        b() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (VideoTextureView.D != null) {
                VideoTextureView.D.onVideoComplete(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class c implements MediaPlayer.OnSeekCompleteListener {
        c() {
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (VideoTextureView.D != null) {
                VideoTextureView.D.onVideoStart(VideoTextureView.this.f317196i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class d implements MediaPlayer.OnErrorListener {
        d() {
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i3, int i16) {
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    static class e extends Handler {

        /* renamed from: a, reason: collision with root package name */
        WeakReference<Context> f317202a;

        e(Context context) {
            this.f317202a = new WeakReference<>(context);
        }
    }

    public VideoTextureView(Context context) {
        super(context);
        this.f317196i = 0;
        this.f317197m = "https://www.w3schools.com/html/movie.mp4";
        this.C = new Runnable() { // from class: com.tencent.mobileqq.widget.qqfloatingscreen.videoview.VideoTextureView.6
            @Override // java.lang.Runnable
            public void run() {
                if (VideoTextureView.this.f317192d != null) {
                    try {
                        int currentPosition = VideoTextureView.this.f317192d.getCurrentPosition();
                        if (VideoTextureView.D != null) {
                            VideoTextureView.D.onVideoProgressUpdate(currentPosition);
                        }
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                }
                if (VideoTextureView.this.f317194f != null) {
                    VideoTextureView.this.f317194f.postDelayed(VideoTextureView.this.C, 1000L);
                }
            }
        };
        setSurfaceTextureListener(this);
        this.f317195h = new WeakReference<>(context);
        this.f317194f = new e(context);
    }

    public void f(String str) {
        MediaPlayer mediaPlayer = this.f317192d;
        if (mediaPlayer == null) {
            return;
        }
        try {
            mediaPlayer.setDataSource(str);
            this.f317192d.setAudioStreamType(3);
            this.f317192d.setOnPreparedListener(new a());
            this.f317192d.prepareAsync();
            this.f317192d.setOnCompletionListener(new b());
            this.f317192d.setOnSeekCompleteListener(new c());
            this.f317192d.setOnErrorListener(new d());
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i3, int i16) {
        this.f317193e = new Surface(surfaceTexture);
        if (this.f317192d == null) {
            this.f317192d = new ReportMediaPlayer();
        }
        this.f317192d.setSurface(this.f317193e);
        f(this.f317197m);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return false;
    }

    public void setVideoPath(String str) {
        this.f317197m = str;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i3, int i16) {
    }
}
