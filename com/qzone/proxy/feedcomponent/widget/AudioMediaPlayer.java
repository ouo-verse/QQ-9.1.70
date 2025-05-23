package com.qzone.proxy.feedcomponent.widget;

import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Looper;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ref.WeakReference;

/* loaded from: classes39.dex */
public class AudioMediaPlayer {

    /* renamed from: k, reason: collision with root package name */
    public static volatile int f50916k;

    /* renamed from: l, reason: collision with root package name */
    static AudioMediaPlayer f50917l;

    /* renamed from: a, reason: collision with root package name */
    WeakReference<MediaPlayer.OnCompletionListener> f50918a;

    /* renamed from: b, reason: collision with root package name */
    WeakReference<MediaPlayer.OnErrorListener> f50919b;

    /* renamed from: c, reason: collision with root package name */
    WeakReference<c> f50920c;

    /* renamed from: d, reason: collision with root package name */
    MediaPlayer f50921d;

    /* renamed from: e, reason: collision with root package name */
    WeakReference<d> f50922e;

    /* renamed from: g, reason: collision with root package name */
    String f50924g;

    /* renamed from: i, reason: collision with root package name */
    String f50926i;

    /* renamed from: f, reason: collision with root package name */
    Handler f50923f = new Handler(Looper.getMainLooper());

    /* renamed from: h, reason: collision with root package name */
    Runnable f50925h = new Runnable() { // from class: com.qzone.proxy.feedcomponent.widget.AudioMediaPlayer.3

        /* renamed from: d, reason: collision with root package name */
        private int f50928d = 50;

        @Override // java.lang.Runnable
        public void run() {
            MediaPlayer mediaPlayer;
            AudioMediaPlayer audioMediaPlayer = AudioMediaPlayer.this;
            if (audioMediaPlayer.f50920c == null || (mediaPlayer = audioMediaPlayer.f50921d) == null || !mediaPlayer.isPlaying()) {
                return;
            }
            c cVar = AudioMediaPlayer.this.f50920c.get();
            if (cVar != null) {
                cVar.onProgress(AudioMediaPlayer.this.f50921d.getCurrentPosition(), AudioMediaPlayer.this.f50921d.getDuration());
            }
            synchronized (AudioMediaPlayer.this) {
                if (AudioMediaPlayer.f50916k != 0) {
                    AudioMediaPlayer audioMediaPlayer2 = AudioMediaPlayer.this;
                    audioMediaPlayer2.f50923f.postDelayed(audioMediaPlayer2.f50925h, this.f50928d);
                }
            }
        }
    };

    /* renamed from: j, reason: collision with root package name */
    int f50927j = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class a implements MediaPlayer.OnCompletionListener {
        a() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            MediaPlayer.OnCompletionListener onCompletionListener;
            com.qzone.proxy.feedcomponent.b.e("AudioMediaPlayer", "onCompletion");
            WeakReference<MediaPlayer.OnCompletionListener> weakReference = AudioMediaPlayer.this.f50918a;
            if (weakReference != null && (onCompletionListener = weakReference.get()) != null) {
                onCompletionListener.onCompletion(mediaPlayer);
            }
            AudioMediaPlayer.this.n();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class b implements MediaPlayer.OnErrorListener {
        b() {
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i3, int i16) {
            MediaPlayer.OnErrorListener onErrorListener;
            com.qzone.proxy.feedcomponent.b.e("AudioMediaPlayer", "onError");
            WeakReference<MediaPlayer.OnErrorListener> weakReference = AudioMediaPlayer.this.f50919b;
            if (weakReference != null && (onErrorListener = weakReference.get()) != null) {
                onErrorListener.onError(mediaPlayer, i3, i16);
            }
            AudioMediaPlayer.this.e();
            return false;
        }
    }

    /* loaded from: classes39.dex */
    public interface c {
        void onProgress(int i3, int i16);
    }

    AudioMediaPlayer() {
        e();
    }

    public static AudioMediaPlayer a() {
        if (f50917l == null) {
            f50917l = new AudioMediaPlayer();
        }
        return f50917l;
    }

    public String b() {
        return this.f50926i;
    }

    public d c() {
        WeakReference<d> weakReference = this.f50922e;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public long d(String str) {
        MediaPlayer.OnErrorListener onErrorListener;
        MediaPlayer.OnErrorListener onErrorListener2;
        com.qzone.proxy.feedcomponent.b.e("AudioMediaPlayer", "prepare");
        FileInputStream fileInputStream = null;
        try {
            try {
                if (this.f50921d == null) {
                    e();
                }
                this.f50921d.setAudioStreamType(3);
                if (this.f50921d.isPlaying()) {
                    this.f50921d.stop();
                }
                this.f50921d.reset();
                if (this.f50927j == -1) {
                    this.f50927j = 3;
                }
                this.f50921d.setAudioStreamType(this.f50927j);
                LockMethodProxy.sleep(200L);
                if (!str.startsWith("http://") && !str.startsWith("https://")) {
                    File file = new File(str);
                    if (file.exists() && file.length() != 0) {
                        FileInputStream fileInputStream2 = new FileInputStream(file);
                        try {
                            this.f50921d.setDataSource(fileInputStream2.getFD());
                            this.f50921d.prepare();
                            long duration = this.f50921d.getDuration();
                            try {
                                fileInputStream2.close();
                            } catch (IOException e16) {
                                e16.printStackTrace();
                            }
                            return duration;
                        } catch (FileNotFoundException e17) {
                            fileInputStream = fileInputStream2;
                            e = e17;
                            com.qzone.proxy.feedcomponent.widget.b.a();
                            com.qzone.proxy.feedcomponent.widget.b.i();
                            WeakReference<MediaPlayer.OnErrorListener> weakReference = this.f50919b;
                            if (weakReference != null && this.f50921d != null && (onErrorListener2 = weakReference.get()) != null) {
                                onErrorListener2.onError(this.f50921d, -2, 0);
                            }
                            e();
                            com.qzone.proxy.feedcomponent.b.d("ShowOnDevice", "AudioMediaPlayer prepare: " + e.getMessage(), e);
                            if (fileInputStream == null) {
                                return 1L;
                            }
                            try {
                                fileInputStream.close();
                                return 1L;
                            } catch (IOException e18) {
                                e18.printStackTrace();
                                return 1L;
                            }
                        } catch (Exception e19) {
                            fileInputStream = fileInputStream2;
                            e = e19;
                            com.qzone.proxy.feedcomponent.widget.b.a();
                            com.qzone.proxy.feedcomponent.widget.b.i();
                            WeakReference<MediaPlayer.OnErrorListener> weakReference2 = this.f50919b;
                            if (weakReference2 != null && this.f50921d != null && (onErrorListener = weakReference2.get()) != null) {
                                onErrorListener.onError(this.f50921d, -1, 0);
                            }
                            e();
                            com.qzone.proxy.feedcomponent.b.d("ShowOnDevice", "AudioMediaPlayer prepare: " + e.getMessage(), e);
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e26) {
                                    e26.printStackTrace();
                                }
                            }
                            return 2L;
                        } catch (Throwable th5) {
                            fileInputStream = fileInputStream2;
                            th = th5;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e27) {
                                    e27.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    }
                    throw new FileNotFoundException();
                }
                this.f50921d.setDataSource(str);
                this.f50921d.prepare();
                return 1L;
            } catch (FileNotFoundException e28) {
                e = e28;
            } catch (Exception e29) {
                e = e29;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    void e() {
        com.qzone.proxy.feedcomponent.b.e("AudioMediaPlayer", "recoverRecorder");
        MediaPlayer mediaPlayer = this.f50921d;
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        ReportMediaPlayer reportMediaPlayer = new ReportMediaPlayer();
        this.f50921d = reportMediaPlayer;
        reportMediaPlayer.setLooping(false);
        this.f50921d.setOnCompletionListener(new a());
        this.f50921d.setOnErrorListener(new b());
        this.f50924g = null;
    }

    public void f() {
        com.qzone.proxy.feedcomponent.b.e("AudioMediaPlayer", "release");
        n();
        MediaPlayer mediaPlayer = this.f50921d;
        if (mediaPlayer != null) {
            mediaPlayer.release();
            this.f50921d = null;
        }
        this.f50927j = -1;
        this.f50918a = null;
        this.f50919b = null;
        this.f50922e = null;
        this.f50924g = null;
    }

    public void g(int i3) {
        this.f50921d.stop();
        this.f50927j = i3;
        long d16 = d(this.f50926i);
        com.qzone.proxy.feedcomponent.widget.b.c(i3);
        if (d16 != 0) {
            this.f50921d.start();
        } else {
            ToastUtils.b(FeedGlobalEnv.getContext(), "\u6587\u4ef6\u4e0d\u5b58\u5728,\u64ad\u653e\u5931\u8d25");
        }
    }

    public void h(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.f50918a = new WeakReference<>(onCompletionListener);
    }

    public void i(MediaPlayer.OnErrorListener onErrorListener) {
        this.f50919b = new WeakReference<>(onErrorListener);
    }

    public void j(c cVar) {
        this.f50920c = new WeakReference<>(cVar);
    }

    public void k(d dVar, String str) {
        this.f50922e = new WeakReference<>(dVar);
        l(str);
    }

    public void m(String str, int i3) {
        MediaPlayer.OnErrorListener onErrorListener;
        com.qzone.proxy.feedcomponent.b.e("AudioMediaPlayer", "play");
        try {
            if (d(str) > 0) {
                if (i3 > 0) {
                    this.f50921d.seekTo(i3);
                }
                this.f50921d.start();
                this.f50926i = str;
                f50916k = 1;
                com.qzone.proxy.feedcomponent.widget.b.d();
                com.qzone.proxy.feedcomponent.widget.b.g();
                com.qzone.proxy.feedcomponent.widget.b.h();
                this.f50923f.post(this.f50925h);
                this.f50924g = str;
                return;
            }
            n();
            this.f50924g = null;
        } catch (Exception e16) {
            com.qzone.proxy.feedcomponent.widget.b.a();
            com.qzone.proxy.feedcomponent.widget.b.i();
            WeakReference<MediaPlayer.OnErrorListener> weakReference = this.f50919b;
            if (weakReference != null && this.f50921d != null && (onErrorListener = weakReference.get()) != null) {
                onErrorListener.onError(this.f50921d, -1, 0);
            }
            e();
            com.qzone.proxy.feedcomponent.b.d("ShowOnDevice", "AudioMediaPlayer play: " + e16.getMessage(), e16);
        }
    }

    public void n() {
        com.qzone.proxy.feedcomponent.b.e("AudioMediaPlayer", "stop");
        synchronized (this) {
            f50916k = 0;
        }
        try {
            try {
                MediaPlayer mediaPlayer = this.f50921d;
                if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                    this.f50921d.stop();
                }
                this.f50923f.removeCallbacks(this.f50925h);
            } catch (Exception e16) {
                e();
                com.qzone.proxy.feedcomponent.b.d("ShowOnDevice", "AudioMediaPlayer stop: " + e16.getMessage(), e16);
            }
        } finally {
            this.f50927j = -1;
            com.qzone.proxy.feedcomponent.widget.b.a();
            com.qzone.proxy.feedcomponent.widget.b.f();
            com.qzone.proxy.feedcomponent.widget.b.i();
            this.f50924g = null;
        }
    }

    public void l(String str) {
        m(str, 0);
    }
}
