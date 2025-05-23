package com.tencent.biz.qqstory.playvideo.player.mediaplayer;

import android.annotation.TargetApi;
import android.media.AudioTrack;
import android.media.MediaFormat;
import android.util.Log;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportAudioTrack;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class AudioPlayback {

    /* renamed from: q, reason: collision with root package name */
    public static long f94125q = Long.MIN_VALUE;

    /* renamed from: a, reason: collision with root package name */
    private MediaFormat f94126a;

    /* renamed from: b, reason: collision with root package name */
    private AudioTrack f94127b;

    /* renamed from: c, reason: collision with root package name */
    private byte[] f94128c;

    /* renamed from: e, reason: collision with root package name */
    private int f94130e;

    /* renamed from: f, reason: collision with root package name */
    private int f94131f;

    /* renamed from: h, reason: collision with root package name */
    private int f94133h;

    /* renamed from: i, reason: collision with root package name */
    private AudioThread f94134i;

    /* renamed from: j, reason: collision with root package name */
    private long f94135j;

    /* renamed from: o, reason: collision with root package name */
    private long f94140o;

    /* renamed from: p, reason: collision with root package name */
    private long f94141p;

    /* renamed from: m, reason: collision with root package name */
    private float f94138m = 1.0f;

    /* renamed from: n, reason: collision with root package name */
    private float f94139n = 1.0f;

    /* renamed from: d, reason: collision with root package name */
    private int f94129d = 8192;

    /* renamed from: g, reason: collision with root package name */
    protected a f94132g = new a();

    /* renamed from: k, reason: collision with root package name */
    private int f94136k = 0;

    /* renamed from: l, reason: collision with root package name */
    private int f94137l = 3;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class AudioThread extends BaseThread {
        private final Object C;
        private boolean D;

        AudioThread() {
            super("AudioPlayback");
            this.C = new Object();
            this.D = true;
        }

        public void o() {
            synchronized (this.C) {
                this.C.notify();
            }
        }

        void p(boolean z16) {
            this.D = z16;
            synchronized (this) {
                notify();
            }
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            a.C0944a e16;
            while (!isInterrupted()) {
                try {
                    synchronized (this) {
                        while (this.D) {
                            LockMethodProxy.wait(this);
                        }
                    }
                    synchronized (this.C) {
                        while (true) {
                            e16 = AudioPlayback.this.f94132g.e();
                            if (e16 != null) {
                                break;
                            } else {
                                LockMethodProxy.wait(this.C);
                            }
                        }
                    }
                    AudioPlayback.this.u(e16.f94146a, e16.f94147b);
                    AudioPlayback.this.f94132g.c(e16);
                } catch (InterruptedException unused) {
                    interrupt();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private int f94142a;

        /* renamed from: b, reason: collision with root package name */
        private Queue<C0944a> f94143b = new LinkedList();

        /* renamed from: c, reason: collision with root package name */
        private List<C0944a> f94144c = new ArrayList();

        /* renamed from: d, reason: collision with root package name */
        private int f94145d;

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.tencent.biz.qqstory.playvideo.player.mediaplayer.AudioPlayback$a$a, reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public static class C0944a {

            /* renamed from: a, reason: collision with root package name */
            protected ByteBuffer f94146a;

            /* renamed from: b, reason: collision with root package name */
            protected long f94147b;

            C0944a(int i3) {
                this.f94146a = ByteBuffer.allocate(i3);
            }
        }

        a() {
        }

        synchronized void b() {
            while (true) {
                C0944a poll = this.f94143b.poll();
                if (poll != null) {
                    c(poll);
                } else {
                    this.f94145d = 0;
                }
            }
        }

        synchronized void c(C0944a c0944a) {
            if (c0944a.f94146a.capacity() != this.f94142a) {
                return;
            }
            c0944a.f94146a.rewind();
            this.f94144c.add(c0944a);
        }

        synchronized void d(ByteBuffer byteBuffer, long j3) {
            C0944a c0944a;
            if (byteBuffer.remaining() > this.f94142a) {
                this.f94144c.clear();
                this.f94142a = byteBuffer.remaining();
            }
            if (!this.f94144c.isEmpty()) {
                c0944a = this.f94144c.remove(0);
            } else {
                c0944a = new C0944a(byteBuffer.remaining());
            }
            c0944a.f94146a.limit(byteBuffer.remaining());
            c0944a.f94146a.mark();
            c0944a.f94146a.put(byteBuffer);
            c0944a.f94146a.reset();
            c0944a.f94147b = j3;
            this.f94143b.add(c0944a);
            this.f94145d += c0944a.f94146a.remaining();
        }

        synchronized C0944a e() {
            C0944a poll;
            poll = this.f94143b.poll();
            if (poll != null) {
                this.f94145d -= poll.f94146a.remaining();
            }
            return poll;
        }
    }

    @TargetApi(16)
    private boolean a(MediaFormat mediaFormat) {
        if (this.f94126a.getInteger("channel-count") == mediaFormat.getInteger("channel-count") && this.f94126a.getInteger("sample-rate") == mediaFormat.getInteger("sample-rate") && this.f94126a.getString("mime").equals(mediaFormat.getString("mime"))) {
            return false;
        }
        return true;
    }

    private long g() {
        return (long) (((this.f94127b.getPlaybackHeadPosition() & 4294967295L) / this.f94131f) * 1000000.0d);
    }

    private void s(boolean z16) {
        if (j()) {
            if (z16) {
                this.f94134i.interrupt();
            }
            this.f94127b.stop();
            this.f94127b.release();
        }
        this.f94127b = null;
    }

    public void b() {
        if (j()) {
            boolean k3 = k();
            if (k3) {
                this.f94127b.pause();
            }
            this.f94127b.flush();
            this.f94132g.b();
            this.f94140o = f94125q;
            if (k3) {
                this.f94127b.play();
                return;
            }
            return;
        }
        throw new IllegalStateException();
    }

    public int c() {
        return this.f94136k;
    }

    public int d() {
        return this.f94137l;
    }

    public long e() {
        long j3 = this.f94140o;
        long j16 = f94125q;
        if (j3 == j16) {
            return j16;
        }
        long g16 = g();
        if (g16 < this.f94141p) {
            Log.d("AudioPlayback", "playback head has wrapped");
            this.f94140o += (long) (((-1.0d) / this.f94131f) * 1000000.0d);
        }
        this.f94141p = g16;
        return this.f94140o + g16;
    }

    public long f() {
        return (long) (((this.f94133h / this.f94130e) / this.f94131f) * 1000000.0d);
    }

    public long h() {
        return (long) (((this.f94132g.f94145d / this.f94130e) / this.f94131f) * 1000000.0d);
    }

    @TargetApi(16)
    public void i(MediaFormat mediaFormat) {
        int i3;
        Log.d("AudioPlayback", "init");
        int i16 = 1;
        boolean z16 = false;
        if (j()) {
            if (!a(mediaFormat)) {
                this.f94126a = mediaFormat;
                return;
            }
            boolean k3 = k();
            l();
            s(false);
            z16 = k3;
        } else {
            AudioThread audioThread = new AudioThread();
            this.f94134i = audioThread;
            audioThread.p(true);
            this.f94134i.start();
        }
        this.f94126a = mediaFormat;
        int integer = mediaFormat.getInteger("channel-count");
        this.f94130e = integer * 2;
        int integer2 = mediaFormat.getInteger("sample-rate");
        this.f94131f = integer2;
        if (integer != 1) {
            if (integer != 2) {
                if (integer != 4) {
                    if (integer != 6) {
                        if (integer == 8) {
                            i16 = 1020;
                        }
                    } else {
                        i16 = 252;
                    }
                } else {
                    i16 = 204;
                }
            } else {
                i16 = 12;
            }
            i3 = i16;
        } else {
            i3 = 4;
        }
        int i17 = this.f94129d * integer;
        this.f94133h = i17;
        ReportAudioTrack reportAudioTrack = new ReportAudioTrack(this.f94137l, integer2, i3, 2, i17, 1, this.f94136k);
        this.f94127b = reportAudioTrack;
        this.f94136k = reportAudioTrack.getAudioSessionId();
        this.f94137l = this.f94127b.getStreamType();
        q(this.f94138m, this.f94139n);
        this.f94140o = f94125q;
        if (z16) {
            n();
        }
    }

    public boolean j() {
        if (this.f94127b != null) {
            return true;
        }
        return false;
    }

    public boolean k() {
        if (this.f94127b.getPlayState() == 3) {
            return true;
        }
        return false;
    }

    public void l() {
        m(true);
    }

    public void m(boolean z16) {
        if (j()) {
            this.f94134i.p(true);
            this.f94127b.pause();
            if (z16) {
                b();
                return;
            }
            return;
        }
        throw new IllegalStateException();
    }

    public void n() {
        if (j()) {
            this.f94127b.play();
            this.f94134i.p(false);
            return;
        }
        throw new IllegalStateException();
    }

    public void o(int i3) {
        if (!j()) {
            this.f94136k = i3;
            return;
        }
        throw new IllegalStateException("cannot set session id on an initialized audio track");
    }

    public void p(float f16) {
        if (j()) {
            this.f94127b.setPlaybackRate((int) (this.f94131f * f16));
            return;
        }
        throw new IllegalStateException();
    }

    public void q(float f16, float f17) {
        this.f94138m = f16;
        this.f94139n = f17;
        AudioTrack audioTrack = this.f94127b;
        if (audioTrack != null) {
            audioTrack.setStereoVolume(f16, f17);
        }
    }

    public void r() {
        s(true);
    }

    public void t(ByteBuffer byteBuffer, long j3) {
        int remaining = byteBuffer.remaining();
        if (this.f94129d < remaining) {
            Log.d("AudioPlayback", "incoming frame chunk size increased to " + remaining);
            this.f94129d = remaining;
            i(this.f94126a);
        }
        if (this.f94140o == f94125q) {
            this.f94140o = j3;
            this.f94141p = 0L;
            long g16 = g();
            if (g16 > 0) {
                this.f94140o -= g16;
                Log.d("AudioPlayback", "playback head not reset");
            }
        }
        this.f94132g.d(byteBuffer, j3);
        this.f94134i.o();
    }

    protected void u(ByteBuffer byteBuffer, long j3) {
        int remaining = byteBuffer.remaining();
        byte[] bArr = this.f94128c;
        if (bArr == null || bArr.length < remaining) {
            this.f94128c = new byte[remaining];
        }
        byteBuffer.get(this.f94128c, 0, remaining);
        this.f94135j = j3;
        this.f94127b.write(this.f94128c, 0, remaining);
    }
}
