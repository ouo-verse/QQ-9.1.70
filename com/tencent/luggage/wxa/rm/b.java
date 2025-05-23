package com.tencent.luggage.wxa.rm;

import android.media.MediaPlayer;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mobileqq.perf.block.LockMethodProxy;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b extends com.tencent.luggage.wxa.sm.b {

    /* renamed from: i, reason: collision with root package name */
    private static final String f139842i = "MicroMsg.Music.MMMediaPlayer";

    /* renamed from: e, reason: collision with root package name */
    private e f139843e;

    /* renamed from: f, reason: collision with root package name */
    private MediaPlayer f139844f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f139845g = true;

    /* renamed from: h, reason: collision with root package name */
    private boolean f139846h = false;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements MediaPlayer.OnCompletionListener {
        public a() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            w.b(b.f139842i, "onCompletion, stop music");
            if (b.this.f139846h) {
                b.this.b(false);
            } else {
                b.this.b(true);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.rm.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6691b implements MediaPlayer.OnSeekCompleteListener {
        public C6691b() {
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (b.this.f139844f != null && b.this.f139844f.isPlaying()) {
                w.d(b.f139842i, "onSeekComplete");
                try {
                    b.this.f139844f.start();
                } catch (Exception e16) {
                    w.a(b.f139842i, e16, "start", new Object[0]);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements MediaPlayer.OnPreparedListener {
        public c() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            if (b.this.f139844f != null) {
                w.d(b.f139842i, "onPrepared");
                try {
                    b.this.f139844f.start();
                } catch (Exception e16) {
                    w.a(b.f139842i, e16, "start", new Object[0]);
                }
                b.this.f139845g = false;
                b.this.f();
                if (b.this.f139843e != null) {
                    b.this.f139843e.c();
                }
                b bVar = b.this;
                bVar.f139843e = new e(bVar, null);
                b.this.f139843e.b();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements MediaPlayer.OnErrorListener {
        public d() {
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i3, int i16) {
            w.b(b.f139842i, "onError, what:%d, extra:%d", Integer.valueOf(i3), Integer.valueOf(i16));
            b.this.f139846h = true;
            b.this.a(false);
            return false;
        }
    }

    public b() {
        com.tencent.luggage.wxa.k0.d.a(com.tencent.luggage.wxa.tm.b.a(com.tencent.luggage.wxa.qm.c.class));
        w.b(f139842i, "mediaResService is null");
        if (this.f139844f == null) {
            this.f139844f = new MediaPlayer();
        }
        this.f139844f.setAudioStreamType(3);
        this.f139844f.setOnCompletionListener(new a());
        this.f139844f.setOnSeekCompleteListener(new C6691b());
        this.f139844f.setOnPreparedListener(new c());
        this.f139844f.setOnErrorListener(new d());
    }

    @Override // com.tencent.luggage.wxa.sm.b
    public String c() {
        return null;
    }

    @Override // com.tencent.luggage.wxa.sm.b
    public void g() {
        w.d(f139842i, "pause");
        if (!d()) {
            return;
        }
        this.f139844f.pause();
    }

    @Override // com.tencent.luggage.wxa.sm.b
    public void h() {
        w.d(f139842i, "play");
        if (d()) {
            try {
                if (!this.f139844f.isPlaying()) {
                    this.f139844f.start();
                    return;
                }
                return;
            } catch (Exception e16) {
                w.a(f139842i, e16, "start", new Object[0]);
                return;
            }
        }
        try {
            this.f139844f.prepareAsync();
        } catch (Exception e17) {
            w.a(f139842i, e17, "prepareAsync", new Object[0]);
        }
    }

    @Override // com.tencent.luggage.wxa.sm.b
    public void i() {
        w.d(f139842i, "stop");
        this.f139845g = true;
        try {
            MediaPlayer mediaPlayer = this.f139844f;
            if (mediaPlayer != null) {
                mediaPlayer.stop();
                this.f139844f.release();
            }
            e eVar = this.f139843e;
            if (eVar != null) {
                eVar.c();
                this.f139843e = null;
            }
        } catch (Exception e16) {
            w.a(f139842i, e16, "stop", new Object[0]);
        }
        b(false);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private boolean f139851a;

        e() {
            this.f139851a = true;
        }

        public boolean a() {
            return this.f139851a;
        }

        public void b() {
            this.f139851a = false;
            com.tencent.luggage.wxa.co.a.a(this, "music_play_progress_runnable");
        }

        public void c() {
            this.f139851a = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            w.d(b.f139842i, "start run play progress task");
            while (!this.f139851a) {
                try {
                    if (b.this.f139844f != null && b.this.f139844f.isPlaying()) {
                        int currentPosition = b.this.f139844f.getCurrentPosition();
                        int duration = b.this.f139844f.getDuration();
                        if (currentPosition > 0 && duration > 0) {
                            b.this.a((currentPosition * 100) / duration);
                        }
                    }
                } catch (Exception e16) {
                    w.a(b.f139842i, e16, "onPlayUpdate", new Object[0]);
                }
                try {
                    LockMethodProxy.sleep(200L);
                } catch (InterruptedException e17) {
                    w.a(b.f139842i, e17, "sleep", new Object[0]);
                }
            }
        }

        public /* synthetic */ e(b bVar, a aVar) {
            this();
        }
    }

    @Override // com.tencent.luggage.wxa.sm.b
    public boolean e() {
        try {
            return this.f139844f.isPlaying();
        } catch (Exception e16) {
            w.a(f139842i, e16, "setSourcePath", new Object[0]);
            return false;
        }
    }

    @Override // com.tencent.luggage.wxa.sm.b
    public int b() {
        try {
            return this.f139844f.getDuration();
        } catch (Exception e16) {
            w.a(f139842i, e16, "getDuration", new Object[0]);
            return 0;
        }
    }

    @Override // com.tencent.luggage.wxa.sm.b
    public boolean d() {
        return !this.f139845g;
    }

    @Override // com.tencent.luggage.wxa.sm.b
    public void a(String str) {
        w.d(f139842i, "setSourcePath, sourcePath:%s", str);
        try {
            this.f139844f.setDataSource(str);
        } catch (Exception e16) {
            w.a(f139842i, e16, "setSourcePath", new Object[0]);
        }
    }

    @Override // com.tencent.luggage.wxa.sm.b
    public int a() {
        try {
            return this.f139844f.getCurrentPosition();
        } catch (Exception e16) {
            w.a(f139842i, e16, "getCurrentPos", new Object[0]);
            return 0;
        }
    }

    @Override // com.tencent.luggage.wxa.sm.b
    public void a(long j3) {
        w.d(f139842i, "seek %d", Long.valueOf(j3));
        this.f139844f.seekTo((int) j3);
    }
}
