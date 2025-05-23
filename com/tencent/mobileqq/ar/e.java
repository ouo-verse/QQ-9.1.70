package com.tencent.mobileqq.ar;

import android.media.MediaPlayer;
import android.media.SoundPool;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

/* compiled from: P */
/* loaded from: classes11.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private SoundPool f198347a;

    /* renamed from: b, reason: collision with root package name */
    MediaPlayer f198348b;

    /* renamed from: c, reason: collision with root package name */
    private int f198349c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f198350d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f198351e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f198352f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f198353g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f198354h;

    /* renamed from: i, reason: collision with root package name */
    private HashMap<String, Integer> f198355i;

    /* renamed from: j, reason: collision with root package name */
    private HashSet<Integer> f198356j;

    /* renamed from: k, reason: collision with root package name */
    private HashSet<Integer> f198357k;

    /* renamed from: l, reason: collision with root package name */
    private String f198358l;

    /* renamed from: m, reason: collision with root package name */
    private String f198359m;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a implements SoundPool.OnLoadCompleteListener {
        a() {
        }

        @Override // android.media.SoundPool.OnLoadCompleteListener
        public void onLoadComplete(SoundPool soundPool, int i3, int i16) {
            try {
                if (i16 != 0) {
                    QLog.e("ARMusicController", 2, "load fire music failed. " + e.this.f198359m);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("ARMusicController", 2, "load fire music success. : " + e.this.f198359m);
                }
                e.this.f198350d = true;
                if (e.this.f198352f) {
                    soundPool.play(i3, 1.0f, 1.0f, 1, 0, 1.0f);
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class b implements MediaPlayer.OnPreparedListener {
        b() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            try {
                if (QLog.isColorLevel()) {
                    QLog.d("ARMusicController", 2, "load bg music success. : " + e.this.f198358l);
                }
                e.this.f198348b.seekTo(0);
                e.this.f198351e = true;
                if (e.this.f198353g) {
                    e.this.f198348b.start();
                    e.this.f198353g = false;
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class c implements MediaPlayer.OnErrorListener {
        c() {
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i3, int i16) {
            if (QLog.isColorLevel()) {
                QLog.e("ARMusicController", 2, "ARMusicController, onError, what=" + i3 + ", extra=" + i16);
                return false;
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class d implements SoundPool.OnLoadCompleteListener {
        d() {
        }

        @Override // android.media.SoundPool.OnLoadCompleteListener
        public void onLoadComplete(SoundPool soundPool, int i3, int i16) {
            try {
                if (i16 != 0) {
                    QLog.e("ARMusicController", 2, "load fire music failed. id=" + i3);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("ARMusicController", 2, "load fire music success. id=" + i3);
                }
                e.this.f198357k.add(Integer.valueOf(i3));
                if (e.this.f198356j.contains(Integer.valueOf(i3))) {
                    soundPool.play(i3, 1.0f, 1.0f, 1, 0, 1.0f);
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.ar.e$e, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    class C7405e implements MediaPlayer.OnPreparedListener {
        C7405e() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            try {
                if (QLog.isColorLevel()) {
                    QLog.d("ARMusicController", 2, "load bg music success. : " + e.this.f198358l);
                }
                e.this.f198348b.seekTo(0);
                e.this.f198351e = true;
                if (e.this.f198353g) {
                    e.this.f198348b.start();
                    e.this.f198353g = false;
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    public e(String str, String str2) {
        this.f198348b = new ReportMediaPlayer();
        this.f198349c = 0;
        this.f198350d = false;
        this.f198351e = false;
        this.f198352f = false;
        this.f198353g = false;
        this.f198354h = false;
        try {
            this.f198358l = str;
            this.f198359m = str2;
            SoundPool soundPool = new SoundPool(1, 3, 0);
            this.f198347a = soundPool;
            soundPool.setOnLoadCompleteListener(new a());
            ReportMediaPlayer reportMediaPlayer = new ReportMediaPlayer();
            this.f198348b = reportMediaPlayer;
            reportMediaPlayer.setOnPreparedListener(new b());
            this.f198348b.setOnErrorListener(new c());
            this.f198349c = this.f198347a.load(str2, 1);
            try {
                this.f198348b.setDataSource(str);
                this.f198348b.prepareAsync();
            } catch (IOException e16) {
                e16.printStackTrace();
            }
        } catch (Exception e17) {
            e17.printStackTrace();
        }
    }

    public void j() {
        try {
            this.f198348b.release();
            this.f198347a.release();
            this.f198355i = null;
            this.f198356j = null;
            this.f198357k = null;
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public void k() {
        m(false);
    }

    public void l(String str, boolean z16, boolean z17) {
        try {
            if (!TextUtils.isEmpty(str)) {
                if (!new File(str).exists()) {
                    QLog.d("ARMusicController", 2, "playBgMusic file not exist" + str);
                    return;
                }
                if (this.f198348b.isPlaying()) {
                    this.f198348b.stop();
                }
                this.f198358l = str;
                this.f198348b.reset();
                this.f198348b.setDataSource(str);
                this.f198348b.setLooping(z16);
                this.f198348b.prepareAsync();
                this.f198353g = z17;
            }
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.e("ARMusicController", 2, "playBgMusic exception", th5);
                return;
            }
            QLog.d("ARMusicController", 1, "playBgMusic exception" + th5.getMessage());
        }
    }

    public void m(boolean z16) {
        try {
            if (this.f198351e) {
                this.f198348b.start();
            } else {
                this.f198353g = true;
            }
            if (QLog.isColorLevel()) {
                QLog.d("ARMusicController", 2, "playBgMusic : " + this.f198358l);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public void n(String str, boolean z16) {
        int i3;
        try {
            if (!this.f198354h) {
                return;
            }
            if (this.f198355i.containsKey(str)) {
                i3 = this.f198355i.get(str).intValue();
            } else {
                i3 = -1;
            }
            if (QLog.isColorLevel()) {
                QLog.d("ARMusicController", 2, "playSound path=" + str + ", id=" + i3);
            }
            if (i3 == -1) {
                return;
            }
            if (this.f198357k.contains(Integer.valueOf(i3))) {
                this.f198347a.play(i3, 1.0f, 1.0f, 1, 0, 1.0f);
            } else if (z16) {
                this.f198356j.add(Integer.valueOf(i3));
            } else {
                this.f198356j.remove(Integer.valueOf(i3));
            }
        } catch (Exception e16) {
            QLog.e("ARMusicController", 2, e16, new Object[0]);
        }
    }

    public void o() {
        try {
            this.f198348b.stop();
            this.f198351e = false;
            this.f198348b.prepareAsync();
            if (QLog.isColorLevel()) {
                QLog.d("ARMusicController", 2, "stopAllMusic");
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public e(int i3, String... strArr) {
        this.f198348b = new ReportMediaPlayer();
        this.f198349c = 0;
        this.f198350d = false;
        this.f198351e = false;
        this.f198352f = false;
        this.f198353g = false;
        try {
            this.f198354h = true;
            this.f198355i = new HashMap<>();
            this.f198356j = new HashSet<>();
            this.f198357k = new HashSet<>();
            SoundPool soundPool = new SoundPool(i3, 3, 0);
            this.f198347a = soundPool;
            soundPool.setOnLoadCompleteListener(new d());
            ReportMediaPlayer reportMediaPlayer = new ReportMediaPlayer();
            this.f198348b = reportMediaPlayer;
            reportMediaPlayer.setOnPreparedListener(new C7405e());
            if (strArr == null || strArr.length <= 0) {
                return;
            }
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str)) {
                    int load = this.f198347a.load(str, 1);
                    this.f198355i.put(str, Integer.valueOf(load));
                    if (QLog.isColorLevel()) {
                        QLog.d("ARMusicController", 2, "load file:" + str + ", id=" + load);
                    }
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }
}
