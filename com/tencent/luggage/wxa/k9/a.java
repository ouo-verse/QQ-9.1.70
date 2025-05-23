package com.tencent.luggage.wxa.k9;

import android.media.AudioTrack;
import android.media.PlaybackParams;
import com.tencent.luggage.wxa.c9.d;
import com.tencent.luggage.wxa.j9.f;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {

    /* renamed from: m, reason: collision with root package name */
    public static long f131782m = 120;

    /* renamed from: n, reason: collision with root package name */
    public static long f131783n = 240;

    /* renamed from: o, reason: collision with root package name */
    public static volatile AtomicInteger f131784o = new AtomicInteger(0);

    /* renamed from: p, reason: collision with root package name */
    public static volatile AtomicInteger f131785p = new AtomicInteger(0);

    /* renamed from: q, reason: collision with root package name */
    public static volatile AtomicInteger f131786q = new AtomicInteger(0);

    /* renamed from: a, reason: collision with root package name */
    public volatile AudioTrack f131787a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f131788b;

    /* renamed from: e, reason: collision with root package name */
    public int f131791e;

    /* renamed from: f, reason: collision with root package name */
    public int f131792f;

    /* renamed from: h, reason: collision with root package name */
    public d f131794h;

    /* renamed from: i, reason: collision with root package name */
    public f f131795i;

    /* renamed from: c, reason: collision with root package name */
    public int f131789c = 0;

    /* renamed from: d, reason: collision with root package name */
    public int f131790d = 0;

    /* renamed from: g, reason: collision with root package name */
    public double f131793g = 0.0d;

    /* renamed from: j, reason: collision with root package name */
    public int f131796j = 0;

    /* renamed from: k, reason: collision with root package name */
    public long f131797k = -1;

    /* renamed from: l, reason: collision with root package name */
    public float f131798l = 1.0f;

    public a(int i3, int i16, d dVar, f fVar) {
        this.f131791e = i3;
        this.f131792f = i16;
        this.f131794h = dVar;
        this.f131795i = fVar;
    }

    public void a(int i3) {
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioPcmBasePlayComponent", "seek startPos:%d", Integer.valueOf(this.f131796j));
        this.f131796j = i3;
    }

    public abstract void a(byte[] bArr);

    public void b() {
    }

    public void d() {
        e();
        this.f131795i = null;
        this.f131794h = null;
        this.f131788b = null;
        this.f131789c = 0;
        this.f131790d = 0;
    }

    public void e() {
        try {
            if (this.f131787a != null) {
                f131786q.decrementAndGet();
            }
            if (this.f131787a != null && this.f131787a.getState() != 0) {
                this.f131787a.stop();
                this.f131787a.flush();
            }
            if (this.f131787a != null) {
                this.f131787a.release();
                this.f131787a = null;
            }
        } catch (Exception e16) {
            com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioPcmBasePlayComponent", e16, "releaseAudioTrack", new Object[0]);
        }
    }

    public void f() {
        this.f131789c = 0;
        this.f131790d = 0;
        byte[] bArr = this.f131788b;
        if (bArr != null) {
            Arrays.fill(bArr, 0, bArr.length, (byte) 0);
        }
    }

    public void b(double d16) {
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioPcmBasePlayComponent", "setPlaybackRate:%f", Double.valueOf(d16));
        try {
            if (this.f131787a != null) {
                if (this.f131787a.getState() == 1 || this.f131787a.getState() == 2) {
                    PlaybackParams playbackParams = this.f131787a.getPlaybackParams();
                    playbackParams.setSpeed((float) d16);
                    this.f131787a.setPlaybackParams(playbackParams);
                }
            }
        } catch (IllegalStateException e16) {
            com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioPcmBasePlayComponent", e16, "setPlaybackRate", new Object[0]);
        } catch (Exception e17) {
            com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioPcmBasePlayComponent", e17, "setPlaybackRate", new Object[0]);
        }
    }

    public void a(float f16, float f17) {
        try {
            if (this.f131787a != null && (this.f131787a.getState() == 1 || this.f131787a.getState() == 2)) {
                this.f131787a.setStereoVolume(f16, f17);
            }
        } catch (IllegalStateException e16) {
            com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioPcmBasePlayComponent", e16, "setVolume", new Object[0]);
        } catch (Exception e17) {
            com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioPcmBasePlayComponent", e17, "setVolume", new Object[0]);
        }
        this.f131798l = f16;
    }

    public void a(double d16) {
        this.f131793g = d16;
    }

    public long a() {
        long j3 = -1;
        try {
            if (this.f131787a != null && this.f131787a.getState() != 0) {
                j3 = Math.round((this.f131787a.getPlaybackHeadPosition() / this.f131787a.getSampleRate()) * 1000.0d);
                this.f131797k = j3;
            } else {
                j3 = this.f131797k;
            }
        } catch (Exception e16) {
            com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioPcmBasePlayComponent", e16, "getCurrentPosition", new Object[0]);
        }
        return j3;
    }

    public void c() {
    }

    public void g() {
    }
}
