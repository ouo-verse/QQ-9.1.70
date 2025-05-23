package com.tencent.biz.qqstory.playvideo.player.mediaplayer;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.SystemClock;
import android.util.Log;
import android.view.Surface;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.MediaPlayer;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@TargetApi(16)
/* loaded from: classes5.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    protected String f94182a;

    /* renamed from: b, reason: collision with root package name */
    private e f94183b;

    /* renamed from: c, reason: collision with root package name */
    private int f94184c;

    /* renamed from: d, reason: collision with root package name */
    private MediaFormat f94185d;

    /* renamed from: e, reason: collision with root package name */
    private MediaCodec f94186e;

    /* renamed from: f, reason: collision with root package name */
    private ByteBuffer[] f94187f;

    /* renamed from: g, reason: collision with root package name */
    private ByteBuffer[] f94188g;

    /* renamed from: h, reason: collision with root package name */
    private MediaCodec.BufferInfo f94189h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f94190i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f94191j;

    /* renamed from: k, reason: collision with root package name */
    private List<a> f94192k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f94193l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f94194m;

    /* renamed from: n, reason: collision with root package name */
    private b f94195n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f94196o;

    /* renamed from: p, reason: collision with root package name */
    private long f94197p;

    /* renamed from: q, reason: collision with root package name */
    private a f94198q;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        int f94199a;

        /* renamed from: b, reason: collision with root package name */
        ByteBuffer f94200b;

        /* renamed from: c, reason: collision with root package name */
        long f94201c;

        /* renamed from: d, reason: collision with root package name */
        boolean f94202d;

        /* renamed from: e, reason: collision with root package name */
        boolean f94203e;

        public a() {
            a();
        }

        public void a() {
            this.f94199a = -1;
            this.f94200b = null;
            this.f94201c = -1L;
            this.f94202d = false;
            this.f94203e = false;
        }

        public String toString() {
            return "FrameInfo{buffer=" + this.f94199a + ", data=" + this.f94200b + ", presentationTimeUs=" + this.f94201c + ", endOfStream=" + this.f94202d + ", representationChanged=" + this.f94203e + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface b {
        void a(c cVar);
    }

    public c(e eVar, boolean z16, int i3, b bVar) throws IllegalStateException, IOException {
        this.f94182a = c.class.getSimpleName();
        this.f94182a = getClass().getSimpleName();
        if (eVar != null && i3 != -1) {
            this.f94183b = eVar;
            this.f94196o = z16;
            this.f94184c = i3;
            MediaFormat f16 = eVar.f(i3);
            this.f94185d = f16;
            this.f94195n = bVar;
            this.f94186e = MediaCodec.createDecoderByType(f16.getString("mime"));
            this.f94197p = Long.MIN_VALUE;
            return;
        }
        throw new IllegalArgumentException("no track specified");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        mediaCodec.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 0);
    }

    public final a b(boolean z16, boolean z17) {
        while (!this.f94191j) {
            a c16 = c();
            do {
            } while (n(z16));
            if (c16 != null) {
                return c16;
            }
            if (!z17) {
                return null;
            }
        }
        Log.d(this.f94182a, "EOS NULL");
        return null;
    }

    public final a c() {
        boolean z16;
        if (this.f94191j) {
            return null;
        }
        int dequeueOutputBuffer = this.f94186e.dequeueOutputBuffer(this.f94189h, 0L);
        if (dequeueOutputBuffer >= 0 && (this.f94189h.flags & 4) != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.f94191j = z16;
        if (z16 && this.f94193l) {
            o();
            this.f94191j = false;
            this.f94193l = false;
            this.f94194m = true;
        } else {
            if (dequeueOutputBuffer >= 0) {
                ByteBuffer byteBuffer = this.f94188g[dequeueOutputBuffer];
                if (byteBuffer != null) {
                    MediaCodec.BufferInfo bufferInfo = this.f94189h;
                    if (bufferInfo.size != 0) {
                        byteBuffer.position(bufferInfo.offset);
                        MediaCodec.BufferInfo bufferInfo2 = this.f94189h;
                        byteBuffer.limit(bufferInfo2.offset + bufferInfo2.size);
                    }
                }
                a aVar = this.f94192k.get(0);
                aVar.f94199a = dequeueOutputBuffer;
                aVar.f94200b = byteBuffer;
                long j3 = this.f94189h.presentationTimeUs;
                aVar.f94201c = j3;
                boolean z17 = this.f94191j;
                aVar.f94202d = z17;
                if (this.f94194m) {
                    this.f94194m = false;
                    aVar.f94203e = true;
                }
                if (z17) {
                    Log.d(this.f94182a, "EOS output");
                } else {
                    this.f94197p = j3;
                }
                return aVar;
            }
            if (dequeueOutputBuffer == -3) {
                this.f94188g = this.f94186e.getOutputBuffers();
                Log.d(this.f94182a, "output buffers have changed.");
            } else if (dequeueOutputBuffer == -2) {
                MediaFormat outputFormat = this.f94186e.getOutputFormat();
                Log.d(this.f94182a, "output format has changed to " + outputFormat);
                m(outputFormat);
            }
        }
        return null;
    }

    public void d() {
        a aVar = this.f94198q;
        if (aVar != null) {
            e(aVar);
        }
    }

    public void e(a aVar) {
        q(aVar);
    }

    public long f() {
        return this.f94183b.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final MediaCodec g() {
        return this.f94186e;
    }

    public long h() {
        return this.f94197p;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final MediaFormat i() {
        return this.f94185d;
    }

    public boolean j() {
        return this.f94183b.g();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean k() {
        return this.f94191j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean l() {
        return this.f94196o;
    }

    public final boolean n(boolean z16) {
        int i3;
        long c16;
        boolean z17;
        b bVar;
        b bVar2;
        int i16 = 0;
        if (this.f94190i || !w()) {
            return false;
        }
        if (this.f94183b.d() != -1 && this.f94183b.d() != this.f94184c) {
            if (!z16) {
                return false;
            }
            return this.f94183b.a();
        }
        int dequeueInputBuffer = this.f94186e.dequeueInputBuffer(0L);
        if (dequeueInputBuffer < 0) {
            return false;
        }
        ByteBuffer byteBuffer = this.f94187f[dequeueInputBuffer];
        if (this.f94183b.h()) {
            this.f94193l = true;
            this.f94186e.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
            if (this.f94183b.b() <= -1 || (bVar2 = this.f94195n) == null) {
                return false;
            }
            bVar2.a(this);
            return false;
        }
        if (this.f94183b.b() > -1 && (bVar = this.f94195n) != null) {
            bVar.a(this);
        }
        int i17 = this.f94183b.i(byteBuffer, 0);
        if (i17 < 0) {
            Log.d(this.f94182a, "EOS input");
            this.f94190i = true;
            z17 = false;
            i3 = 0;
            c16 = 0;
        } else {
            i3 = i17;
            c16 = this.f94183b.c();
            z17 = true;
        }
        MediaCodec mediaCodec = this.f94186e;
        if (this.f94190i) {
            i16 = 4;
        }
        mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, i3, c16, i16);
        if (!this.f94190i) {
            this.f94183b.a();
        }
        return z17;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void o() {
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.f94185d = this.f94183b.f(this.f94184c);
            this.f94186e.stop();
            a(this.f94186e, this.f94185d);
            this.f94186e.start();
            this.f94187f = this.f94186e.getInputBuffers();
            this.f94188g = this.f94186e.getOutputBuffers();
            this.f94189h = new MediaCodec.BufferInfo();
            this.f94190i = false;
            this.f94191j = false;
            this.f94192k = new ArrayList();
            for (int i3 = 0; i3 < this.f94188g.length; i3++) {
                this.f94192k.add(new a());
            }
            Log.d(this.f94182a, "reinitCodec " + (SystemClock.elapsedRealtime() - elapsedRealtime) + "ms");
        } catch (IllegalArgumentException e16) {
            this.f94186e.release();
            Log.e(this.f94182a, "reinitCodec: invalid surface or format");
            throw e16;
        } catch (IllegalStateException e17) {
            this.f94186e.release();
            Log.e(this.f94182a, "reinitCodec: illegal state");
            throw e17;
        }
    }

    public void p() {
        this.f94186e.stop();
        this.f94186e.release();
        Log.d(this.f94182a, "decoder released");
    }

    public void q(a aVar) {
        this.f94186e.releaseOutputBuffer(aVar.f94199a, false);
        r(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void r(a aVar) {
        aVar.a();
        this.f94192k.add(aVar);
    }

    public void s() {
        a aVar = this.f94198q;
        if (aVar != null) {
            t(aVar, 0L);
        }
    }

    public void t(a aVar, long j3) {
        q(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a u(MediaPlayer.c cVar, long j3, e eVar, MediaCodec mediaCodec) throws IOException {
        if (this.f94196o) {
            this.f94190i = false;
            this.f94191j = false;
            mediaCodec.flush();
            return null;
        }
        Log.d(this.f94182a, "seeking to:                 " + j3);
        Log.d(this.f94182a, "extractor current position: " + eVar.c());
        eVar.l(j3, cVar.a());
        Log.d(this.f94182a, "extractor new position:     " + eVar.c());
        this.f94190i = false;
        this.f94191j = false;
        mediaCodec.flush();
        if (eVar.h()) {
            o();
            this.f94194m = true;
        }
        return b(true, true);
    }

    public final void v(MediaPlayer.c cVar, long j3) throws IOException {
        this.f94197p = Long.MIN_VALUE;
        this.f94198q = u(cVar, j3, this.f94183b, this.f94186e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean w() {
        return true;
    }

    public final void x() {
        if (this.f94196o) {
            return;
        }
        while (true) {
            int d16 = this.f94183b.d();
            if (d16 != -1 && d16 != this.f94184c && !this.f94190i) {
                this.f94183b.a();
            } else {
                return;
            }
        }
    }

    protected void m(MediaFormat mediaFormat) {
    }
}
