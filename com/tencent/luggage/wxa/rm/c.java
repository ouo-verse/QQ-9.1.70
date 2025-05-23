package com.tencent.luggage.wxa.rm;

import android.annotation.TargetApi;
import android.media.AudioTrack;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Process;
import com.tencent.luggage.wxa.t9.r;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import java.nio.ByteBuffer;

/* compiled from: P */
@TargetApi(16)
/* loaded from: classes8.dex */
public class c extends com.tencent.luggage.wxa.sm.b {

    /* renamed from: q, reason: collision with root package name */
    private static final String f139853q = "MicroMsg.Music.MMPlayer";

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.luggage.wxa.ba.a f139854e;

    /* renamed from: f, reason: collision with root package name */
    private r f139855f;

    /* renamed from: g, reason: collision with root package name */
    private AudioTrack f139856g;

    /* renamed from: h, reason: collision with root package name */
    private String f139857h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f139858i = true;

    /* renamed from: j, reason: collision with root package name */
    private String f139859j = null;

    /* renamed from: k, reason: collision with root package name */
    private int f139860k = 0;

    /* renamed from: l, reason: collision with root package name */
    private int f139861l = 0;

    /* renamed from: m, reason: collision with root package name */
    private long f139862m = 0;

    /* renamed from: n, reason: collision with root package name */
    private long f139863n = 0;

    /* renamed from: o, reason: collision with root package name */
    private int f139864o = 0;

    /* renamed from: p, reason: collision with root package name */
    private Runnable f139865p = new a();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public a() {
        }

        /* JADX WARN: Removed duplicated region for block: B:31:0x0194 A[Catch: all -> 0x038c, Exception -> 0x038e, TryCatch #2 {Exception -> 0x038e, blocks: (B:29:0x0185, B:31:0x0194, B:33:0x0198, B:35:0x01a4, B:37:0x01b2, B:38:0x01f1, B:41:0x0206, B:43:0x020d, B:45:0x01bc, B:48:0x01ea, B:49:0x01d7, B:50:0x0217, B:51:0x022c, B:53:0x023a, B:56:0x023f, B:58:0x024b, B:60:0x0253, B:64:0x025b, B:62:0x02a0, B:67:0x02a9, B:68:0x02b3, B:75:0x02c3, B:80:0x02d4, B:83:0x02ed, B:84:0x0324, B:87:0x033a, B:92:0x0358, B:95:0x0376), top: B:28:0x0185, outer: #4 }] */
        /* JADX WARN: Removed duplicated region for block: B:85:0x0192 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:89:0x0351  */
        /* JADX WARN: Removed duplicated region for block: B:92:0x0358 A[Catch: all -> 0x038c, Exception -> 0x038e, TryCatch #2 {Exception -> 0x038e, blocks: (B:29:0x0185, B:31:0x0194, B:33:0x0198, B:35:0x01a4, B:37:0x01b2, B:38:0x01f1, B:41:0x0206, B:43:0x020d, B:45:0x01bc, B:48:0x01ea, B:49:0x01d7, B:50:0x0217, B:51:0x022c, B:53:0x023a, B:56:0x023f, B:58:0x024b, B:60:0x0253, B:64:0x025b, B:62:0x02a0, B:67:0x02a9, B:68:0x02b3, B:75:0x02c3, B:80:0x02d4, B:83:0x02ed, B:84:0x0324, B:87:0x033a, B:92:0x0358, B:95:0x0376), top: B:28:0x0185, outer: #4 }] */
        /* JADX WARN: Removed duplicated region for block: B:95:0x0376 A[Catch: all -> 0x038c, Exception -> 0x038e, TRY_LEAVE, TryCatch #2 {Exception -> 0x038e, blocks: (B:29:0x0185, B:31:0x0194, B:33:0x0198, B:35:0x01a4, B:37:0x01b2, B:38:0x01f1, B:41:0x0206, B:43:0x020d, B:45:0x01bc, B:48:0x01ea, B:49:0x01d7, B:50:0x0217, B:51:0x022c, B:53:0x023a, B:56:0x023f, B:58:0x024b, B:60:0x0253, B:64:0x025b, B:62:0x02a0, B:67:0x02a9, B:68:0x02b3, B:75:0x02c3, B:80:0x02d4, B:83:0x02ed, B:84:0x0324, B:87:0x033a, B:92:0x0358, B:95:0x0376), top: B:28:0x0185, outer: #4 }] */
        /* JADX WARN: Removed duplicated region for block: B:96:0x0353  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            MediaFormat mediaFormat;
            boolean z16;
            int i3;
            boolean z17;
            char c16;
            int i16;
            int i17;
            int i18;
            w.d(c.f139853q, "starting...");
            Process.setThreadPriority(-19);
            int i19 = 0;
            if (!w0.c(c.this.f139857h)) {
                c.this.f139854e = new com.tencent.luggage.wxa.ba.a();
                try {
                    c.this.f139854e.a(c.this.f139857h);
                    try {
                        int c17 = c.this.f139854e.c();
                        w.b(c.f139853q, "tractCount is %d", Integer.valueOf(c17));
                        try {
                            for (int i26 = 0; i26 < c17; i26++) {
                                mediaFormat = c.this.f139854e.a(i26);
                                c.this.f139859j = mediaFormat.getString("mime");
                                if (w0.c(c.this.f139859j) || !c.this.f139859j.startsWith("audio/")) {
                                }
                                break;
                            }
                            break;
                            break;
                        } catch (Exception e16) {
                            e = e16;
                            w.a(c.f139853q, e, "get media format from media extractor", new Object[0]);
                            c.this.f139864o = 705;
                            try {
                                c cVar = c.this;
                                cVar.f139855f = r.a(cVar.f139859j);
                                c.this.f139855f.a(mediaFormat, null, null, 0);
                                c.this.f139855f.f();
                                ByteBuffer[] a16 = c.this.f139855f.a();
                                ByteBuffer[] b16 = c.this.f139855f.b();
                                w.d(c.f139853q, "Track info: extractorFormat: %s mime: %s sampleRate: %s channels: %s duration: %s", mediaFormat, c.this.f139859j, Integer.valueOf(c.this.f139860k), Integer.valueOf(c.this.f139861l), Long.valueOf(c.this.f139863n));
                                c.this.f139854e.b(0);
                                MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
                                ((com.tencent.luggage.wxa.sm.b) c.this).f140401c.a(3);
                                c.this.f();
                                z16 = false;
                                i3 = 0;
                                boolean z18 = false;
                                while (!z16) {
                                    try {
                                        try {
                                            c.this.p();
                                            if (c.this.d()) {
                                            }
                                        } finally {
                                            c.this.n();
                                            c.this.m();
                                            c.this.l();
                                            String str = null;
                                            c.this.f139857h = str;
                                            c.this.f139859j = str;
                                            int i27 = 0;
                                            c.this.f139860k = i27;
                                            c.this.f139861l = i27;
                                            long j3 = 0;
                                            c.this.f139862m = j3;
                                            c.this.f139863n = j3;
                                        }
                                    } catch (Exception e17) {
                                        w.a(c.f139853q, e17, "error", new Object[0]);
                                        c.this.f139864o = 706;
                                        c.this.a(true);
                                    }
                                }
                                if ((c.this.f139863n / 1000) - (c.this.f139862m / 1000) >= 2000) {
                                }
                                if (i3 < 50) {
                                }
                                c.this.n();
                                c.this.m();
                                c.this.l();
                                c.this.f139857h = null;
                                c.this.f139859j = null;
                                c.this.f139860k = 0;
                                c.this.f139861l = 0;
                                c.this.f139862m = 0L;
                                c.this.f139863n = 0L;
                                w.d(c.f139853q, "stopping...");
                                return;
                            } catch (Exception e18) {
                                w.a(c.f139853q, e18, "createDecoderByType", new Object[0]);
                                c.this.f139864o = 704;
                                c.this.a(true);
                                c.this.n();
                                c.this.m();
                                return;
                            }
                        }
                        mediaFormat = null;
                    } catch (Exception e19) {
                        e = e19;
                        mediaFormat = null;
                    }
                    if (mediaFormat == null) {
                        w.b(c.f139853q, "format is null");
                        c.this.f139864o = 703;
                        c.this.a(true);
                        c.this.n();
                        return;
                    }
                    w.d(c.f139853q, "format:%s", mediaFormat);
                    c.this.f139860k = mediaFormat.getInteger("sample-rate");
                    c.this.f139861l = mediaFormat.getInteger("channel-count");
                    c.this.f139863n = mediaFormat.getLong("durationUs");
                    c cVar2 = c.this;
                    cVar2.f139855f = r.a(cVar2.f139859j);
                    c.this.f139855f.a(mediaFormat, null, null, 0);
                    c.this.f139855f.f();
                    ByteBuffer[] a162 = c.this.f139855f.a();
                    ByteBuffer[] b162 = c.this.f139855f.b();
                    w.d(c.f139853q, "Track info: extractorFormat: %s mime: %s sampleRate: %s channels: %s duration: %s", mediaFormat, c.this.f139859j, Integer.valueOf(c.this.f139860k), Integer.valueOf(c.this.f139861l), Long.valueOf(c.this.f139863n));
                    c.this.f139854e.b(0);
                    MediaCodec.BufferInfo bufferInfo2 = new MediaCodec.BufferInfo();
                    ((com.tencent.luggage.wxa.sm.b) c.this).f140401c.a(3);
                    c.this.f();
                    z16 = false;
                    i3 = 0;
                    boolean z182 = false;
                    while (!z16 && i3 < 50) {
                        c.this.p();
                        if (c.this.d()) {
                            break;
                        }
                        i3++;
                        if (!z182) {
                            int a17 = c.this.f139855f.a(1000L);
                            if (a17 >= 0) {
                                int a18 = c.this.f139854e.a(a162[a17], i19);
                                if (a18 < 0) {
                                    w.b(c.f139853q, "saw input EOS. Stopping playback");
                                    i17 = i19;
                                    z182 = true;
                                } else {
                                    c cVar3 = c.this;
                                    cVar3.f139862m = cVar3.f139854e.b();
                                    if (c.this.f139863n == 0) {
                                        i16 = 0;
                                    } else {
                                        i16 = (int) ((c.this.f139862m * 100) / c.this.f139863n);
                                    }
                                    c.this.a(i16);
                                    i17 = a18;
                                }
                                r rVar = c.this.f139855f;
                                long j16 = c.this.f139862m;
                                if (z182) {
                                    i18 = 4;
                                } else {
                                    i18 = 0;
                                }
                                rVar.a(a17, 0, i17, j16, i18);
                                if (!z182) {
                                    c.this.f139854e.a();
                                }
                            } else {
                                w.b(c.f139853q, "inputBufIndex " + a17);
                            }
                        }
                        int a19 = c.this.f139855f.a(bufferInfo2, 1000L);
                        if (a19 >= 0) {
                            int i28 = bufferInfo2.size;
                            if (i28 > 0) {
                                i3 = 0;
                            }
                            ByteBuffer byteBuffer = b162[a19];
                            byte[] bArr = new byte[i28];
                            byteBuffer.get(bArr);
                            byteBuffer.clear();
                            if (i28 > 0) {
                                if (c.this.f139856g == null) {
                                    if (!c.this.j()) {
                                        w.b(c.f139853q, "audio track not initialized");
                                        c.this.f139864o = 707;
                                        c.this.a(true);
                                        return;
                                    }
                                    c.this.f139856g.play();
                                }
                                c.this.f139856g.write(bArr, 0, i28);
                            }
                            c.this.f139855f.a(a19, false);
                            c16 = 4;
                            if ((bufferInfo2.flags & 4) != 0) {
                                w.b(c.f139853q, "saw output EOS.");
                                i19 = 0;
                                z16 = true;
                            }
                        } else {
                            c16 = 4;
                            if (a19 == -3) {
                                b162 = c.this.f139855f.b();
                                w.d(c.f139853q, "output buffers have changed.");
                            } else if (a19 == -2) {
                                MediaFormat c18 = c.this.f139855f.c();
                                w.d(c.f139853q, "output format has changed to " + c18);
                                c.this.f139860k = c18.getInteger("sample-rate");
                                c.this.f139861l = c18.getInteger("channel-count");
                                c.this.l();
                            } else {
                                w.d(c.f139853q, "dequeueOutputBuffer returned " + a19);
                            }
                        }
                        i19 = 0;
                    }
                    if ((c.this.f139863n / 1000) - (c.this.f139862m / 1000) >= 2000) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (i3 < 50) {
                        w.b(c.f139853q, "onError, noOutputCounter:%d", Integer.valueOf(i3));
                        c.this.f139864o = 706;
                        c.this.a(true);
                    } else {
                        w.d(c.f139853q, "onStop, isComplete:%b", Boolean.valueOf(z17));
                        c.this.b(z17);
                    }
                    c.this.n();
                    c.this.m();
                    c.this.l();
                    c.this.f139857h = null;
                    c.this.f139859j = null;
                    c.this.f139860k = 0;
                    c.this.f139861l = 0;
                    c.this.f139862m = 0L;
                    c.this.f139863n = 0L;
                    w.d(c.f139853q, "stopping...");
                    return;
                } catch (Exception e26) {
                    w.a(c.f139853q, e26, "set extractor data source", new Object[0]);
                    c.this.f139864o = 702;
                    c.this.a(true);
                    return;
                }
            }
            w.b(c.f139853q, "source path is null");
            c.this.a(false);
        }
    }

    public synchronized void p() {
        while (d() && this.f140401c.c()) {
            try {
                w.d(f139853q, "wait play");
                LockMethodProxy.wait(this);
            } catch (InterruptedException e16) {
                w.a(f139853q, e16, "waitPlay", new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean j() {
        w.d(f139853q, "createAudioTrack");
        int i3 = this.f139861l == 1 ? 4 : 12;
        int minBufferSize = AudioTrack.getMinBufferSize(this.f139860k, i3, 2);
        com.tencent.luggage.wxa.k0.d.a(com.tencent.luggage.wxa.tm.b.a(com.tencent.luggage.wxa.qm.c.class));
        w.b(f139853q, "mediaResService null");
        if (this.f139856g == null) {
            w.b(f139853q, "audioTrack is null, new AudioTrack");
            this.f139856g = new AudioTrack(3, this.f139860k, i3, 2, minBufferSize, 1);
        }
        AudioTrack audioTrack = this.f139856g;
        if (audioTrack != null && audioTrack.getState() == 1) {
            return true;
        }
        w.b(f139853q, "audio track not initialized");
        AudioTrack audioTrack2 = this.f139856g;
        if (audioTrack2 == null) {
            return false;
        }
        try {
            audioTrack2.release();
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        try {
            AudioTrack audioTrack = this.f139856g;
            if (audioTrack != null) {
                audioTrack.flush();
                this.f139856g.release();
                this.f139856g = null;
            }
        } catch (Exception e16) {
            w.a(f139853q, e16, "releaseAudioTrack", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        try {
            r rVar = this.f139855f;
            if (rVar != null) {
                rVar.g();
                this.f139855f.d();
                this.f139855f = null;
            }
        } catch (Exception e16) {
            w.a(f139853q, e16, "releaseMediaCodec", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        try {
            com.tencent.luggage.wxa.ba.a aVar = this.f139854e;
            if (aVar != null) {
                aVar.d();
                this.f139854e = null;
            }
        } catch (Exception e16) {
            w.a(f139853q, e16, "releaseMediaExtractor", new Object[0]);
        }
    }

    @Override // com.tencent.luggage.wxa.sm.b
    public boolean e() {
        return this.f140401c.b();
    }

    @Override // com.tencent.luggage.wxa.sm.b
    public void g() {
        w.d(f139853q, "pause");
        if (d()) {
            this.f140401c.a(2);
        }
    }

    @Override // com.tencent.luggage.wxa.sm.b
    public void h() {
        w.d(f139853q, "play");
        if (!d()) {
            this.f139858i = false;
            com.tencent.luggage.wxa.co.a.a(this.f139865p, "music_player");
        } else if (d() && this.f140401c.c()) {
            this.f140401c.a(3);
            o();
        }
    }

    @Override // com.tencent.luggage.wxa.sm.b
    public void i() {
        w.d(f139853q, "stop");
        this.f139858i = true;
        if (this.f140401c.c()) {
            o();
        }
    }

    public int k() {
        return this.f139864o;
    }

    public synchronized void o() {
        w.d(f139853q, "sync notify");
        try {
            notify();
        } catch (Exception e16) {
            w.a(f139853q, e16, "syncNotify", new Object[0]);
        }
    }

    @Override // com.tencent.luggage.wxa.sm.b
    public String c() {
        return this.f139859j;
    }

    @Override // com.tencent.luggage.wxa.sm.b
    public boolean d() {
        return !this.f139858i;
    }

    @Override // com.tencent.luggage.wxa.sm.b
    public int b() {
        return (int) (this.f139863n / 1000);
    }

    public void b(int i3) {
        a((i3 * b()) / 100);
    }

    @Override // com.tencent.luggage.wxa.sm.b
    public void a(String str) {
        this.f139857h = str;
    }

    @Override // com.tencent.luggage.wxa.sm.b
    public int a() {
        return (int) (this.f139862m / 1000);
    }

    @Override // com.tencent.luggage.wxa.sm.b
    public void b(boolean z16) {
        this.f140401c.a(4);
        this.f139858i = true;
        super.b(z16);
    }

    @Override // com.tencent.luggage.wxa.sm.b
    public void a(long j3) {
        this.f139854e.a(j3 * 1000, 2);
    }

    @Override // com.tencent.luggage.wxa.sm.b
    public void a(boolean z16) {
        this.f140401c.a(4);
        this.f139858i = true;
        super.a(z16);
    }
}
