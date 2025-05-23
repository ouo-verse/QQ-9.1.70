package com.tencent.luggage.wxa.g9;

import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.text.TextUtils;
import com.tencent.luggage.wxa.cp.v;
import com.tencent.luggage.wxa.t9.r;
import com.tencent.tmassistantbase.common.TMAssistantDownloadErrorCode;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes8.dex */
public class e extends c {
    public static int I;
    public static int J;
    public long A;
    public long B;
    public int C;
    public byte[] D;
    public byte[] E;
    public int F;
    public byte[] G;
    public int H;

    /* renamed from: v, reason: collision with root package name */
    public MediaExtractor f126643v;

    /* renamed from: w, reason: collision with root package name */
    public r f126644w;

    /* renamed from: x, reason: collision with root package name */
    public i f126645x;

    /* renamed from: y, reason: collision with root package name */
    public String f126646y;

    /* renamed from: z, reason: collision with root package name */
    public int f126647z;

    public e(com.tencent.luggage.wxa.j9.d dVar, com.tencent.luggage.wxa.l9.c cVar) {
        super(dVar, cVar);
        this.f126646y = null;
        this.f126647z = 2;
        this.A = 0L;
        this.B = 0L;
        this.C = 14144;
        this.D = new byte[14144];
        this.E = new byte[3536];
        this.F = 3536;
        this.G = new byte[3536];
        this.H = 0;
    }

    public void a(com.tencent.luggage.wxa.c9.d dVar, ByteBuffer byteBuffer, int i3) {
        if (this.f126625e != null) {
            a(byteBuffer, i3);
        } else {
            b(dVar, byteBuffer, i3);
        }
    }

    public void b(com.tencent.luggage.wxa.c9.d dVar, ByteBuffer byteBuffer, int i3) {
        byte[] bArr;
        if (3536 == i3) {
            bArr = new byte[i3];
            byteBuffer.get(bArr);
        } else {
            if (i3 != this.F) {
                this.F = i3;
                this.E = new byte[i3];
            }
            Arrays.fill(this.E, 0, this.F, (byte) 0);
            byteBuffer.get(this.E, 0, this.F);
            bArr = this.E;
        }
        if (this.f126622b.c().A) {
            com.tencent.luggage.wxa.f9.a.a(bArr, b().f138575l);
        }
        a(dVar, bArr, this.A);
    }

    public void c(com.tencent.luggage.wxa.c9.d dVar) {
        com.tencent.luggage.wxa.f9.i iVar = this.f126625e;
        if (iVar != null) {
            iVar.b();
            com.tencent.luggage.wxa.d9.a.e().a(dVar.f123421c);
            if (g()) {
                com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDecoderMediaCodec", "flushCache");
                this.f126625e.a();
                return;
            } else if (d()) {
                com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDecoderMediaCodec", "flushCache and readCacheAndPlay");
                this.f126625e.a();
                v();
                return;
            } else {
                com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDecoderMediaCodec", "writeCacheAndPlay");
                a(dVar);
                return;
            }
        }
        b(dVar);
        dVar.c();
    }

    @Override // com.tencent.luggage.wxa.g9.n
    public void f() {
        z();
        y();
        com.tencent.luggage.wxa.f9.i iVar = this.f126625e;
        if (iVar != null) {
            iVar.b();
            this.f126625e.release();
            this.f126625e = null;
        }
        this.f126627g = null;
        this.f126646y = null;
        this.f126636p = 0;
        this.f126637q = 0;
        this.A = 0L;
        this.B = 0L;
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x018d, code lost:
    
        r10 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0423 A[Catch: all -> 0x04c0, Exception -> 0x04c2, TRY_ENTER, TryCatch #8 {Exception -> 0x04c2, blocks: (B:90:0x0293, B:92:0x029b, B:94:0x02a2, B:96:0x02ae, B:98:0x02bb, B:99:0x02e5, B:102:0x02f2, B:104:0x02fd, B:105:0x0327, B:107:0x0333, B:110:0x0339, B:112:0x033d, B:113:0x0340, B:120:0x034f, B:125:0x035f, B:128:0x0376, B:130:0x03a3, B:132:0x03c6, B:143:0x0403, B:134:0x0423, B:136:0x042f, B:138:0x0433, B:139:0x0448, B:141:0x044d, B:146:0x03aa, B:148:0x03b0, B:150:0x03b8, B:153:0x03c2, B:154:0x0460, B:156:0x02c8, B:160:0x02de, B:161:0x0303, B:165:0x047a, B:169:0x048e, B:172:0x04a6, B:174:0x04b8, B:175:0x04bc), top: B:89:0x0293, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0403 A[SYNTHETIC] */
    @Override // com.tencent.luggage.wxa.g9.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void r() {
        MediaFormat mediaFormat;
        int i3;
        int i16;
        boolean z16;
        ByteBuffer[] byteBufferArr;
        boolean z17;
        boolean z18;
        int i17;
        char c16;
        int i18;
        int i19;
        boolean z19;
        boolean z26;
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDecoderMediaCodec", "onDecode");
        this.f126643v = new MediaExtractor();
        try {
            if (this.f126623c.f138565b != null && this.f126623c.f138565b.startsWith("wxblob://") && this.f126623c.C != null) {
                com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDecoderMediaCodec", "decode AudioMediaDataSource");
                com.tencent.luggage.wxa.um.a aVar = new com.tencent.luggage.wxa.um.a(this.f126623c.C, this.f126623c.f138565b);
                i iVar = this.f126645x;
                if (iVar != null) {
                    iVar.close();
                }
                i iVar2 = new i(aVar);
                this.f126645x = iVar2;
                this.f126643v.setDataSource(iVar2);
            } else {
                this.f126643v.setDataSource(this.f126627g);
            }
            try {
                int trackCount = this.f126643v.getTrackCount();
                com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDecoderMediaCodec", "tractCount is %d", Integer.valueOf(trackCount));
                int i26 = 0;
                while (true) {
                    if (i26 < trackCount) {
                        mediaFormat = this.f126643v.getTrackFormat(i26);
                        String string = mediaFormat.getString("mime");
                        this.f126646y = string;
                        if (!TextUtils.isEmpty(string) && this.f126646y.startsWith("audio/")) {
                            break;
                        } else {
                            i26++;
                        }
                    } else {
                        mediaFormat = null;
                        break;
                    }
                }
                if (mediaFormat == null) {
                    com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioDecoderMediaCodec", "format is null");
                    this.f126626f = 703;
                    b(703);
                    z();
                    return;
                }
                com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDecoderMediaCodec", "format:%s", mediaFormat);
                this.f126636p = mediaFormat.getInteger("sample-rate");
                this.f126637q = mediaFormat.getInteger("channel-count");
                this.B = mediaFormat.getLong("durationUs");
                if (com.tencent.luggage.wxa.d9.a.e().d(this.f126627g)) {
                    v vVar = new v(com.tencent.luggage.wxa.m9.a.a(this.f126627g));
                    v vVar2 = new v(com.tencent.luggage.wxa.m9.a.b(this.f126623c.f138577n, this.f126627g));
                    if (!vVar.e() && !vVar2.e()) {
                        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDecoderMediaCodec", "cache file is not exist");
                        com.tencent.luggage.wxa.d9.a.e().b(this.f126627g);
                    } else {
                        com.tencent.luggage.wxa.c9.d e16 = e();
                        e16.k();
                        e16.a(this.B / 1000);
                        String str = this.f126627g;
                        if (!vVar.e() && vVar2.e()) {
                            z19 = true;
                        } else {
                            z19 = false;
                        }
                        com.tencent.luggage.wxa.f9.b bVar = new com.tencent.luggage.wxa.f9.b(str, z19, this.f126623c.f138577n);
                        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDecoderMediaCodec", "read cache begin");
                        while (true) {
                            if (!g()) {
                                w();
                                byte[] a16 = bVar.a(3536);
                                if (a16 != null) {
                                    this.f126636p = 44100;
                                    this.f126637q = 2;
                                    this.f126647z = 2;
                                    a(e16, a16);
                                }
                                if (e16.m() > 0 && a16 == null) {
                                    e16.c();
                                    I++;
                                    z26 = true;
                                    break;
                                } else if (e16.m() == 0 && a16 == null) {
                                    e16.l();
                                    break;
                                } else if (a16 == null) {
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDecoderMediaCodec", "read cache end\uff0cloadSuc:%b", Boolean.valueOf(z26));
                        bVar.a();
                        if (z26) {
                            e16.a(this.f126622b.c().f138589z);
                            z();
                            com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDecoderMediaCodec", "read cache success loadCacheFromPcmCount:%d", Integer.valueOf(I));
                            return;
                        }
                    }
                }
                try {
                    r a17 = r.a(this.f126646y);
                    this.f126644w = a17;
                    try {
                        a17.a(mediaFormat, null, null, 0);
                        this.f126644w.f();
                        try {
                            ByteBuffer[] a18 = this.f126644w.a();
                            ByteBuffer[] b16 = this.f126644w.b();
                            com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDecoderMediaCodec", "Track info: extractorFormat: %s mime: %s", mediaFormat, this.f126646y);
                            com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDecoderMediaCodec", "sampleRate:%d, channels:%d, bitDepth:%d, duration:%d, audioId:%s,", Integer.valueOf(this.f126636p), Integer.valueOf(this.f126637q), Integer.valueOf(this.f126647z), Long.valueOf(this.B), this.f126622b.c().f138564a);
                            try {
                            } catch (Exception e17) {
                                e = e17;
                                i16 = 0;
                            }
                            try {
                                this.f126643v.selectTrack(0);
                                MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
                                com.tencent.luggage.wxa.c9.d e18 = e();
                                e18.k();
                                if (!com.tencent.luggage.wxa.j9.a.a(this.f126636p, this.f126637q, this.f126647z)) {
                                    com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioDecoderMediaCodec", "track param is not support config");
                                    this.f126625e = new com.tencent.luggage.wxa.f9.f(e18, this.f126636p, this.f126637q, this.f126647z, this.f126627g);
                                } else {
                                    int i27 = J + 1;
                                    J = i27;
                                    com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDecoderMediaCodec", "track support supportConfigCount:%d", Integer.valueOf(i27));
                                }
                                e18.a(this.B / 1000);
                                int i28 = 0;
                                boolean z27 = false;
                                boolean z28 = false;
                                while (!z27 && i28 < 50) {
                                    try {
                                        try {
                                            if (g()) {
                                                break;
                                            }
                                            w();
                                            int i29 = i28 + 1;
                                            if (!z28) {
                                                i17 = i29;
                                                int a19 = this.f126644w.a(1000L);
                                                if (a19 >= 0) {
                                                    byteBufferArr = a18;
                                                    int readSampleData = this.f126643v.readSampleData(a18[a19], 0);
                                                    if (readSampleData < 0) {
                                                        com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioDecoderMediaCodec", "saw input EOS. Stopping playback");
                                                        z17 = z27;
                                                        z18 = true;
                                                        i18 = 0;
                                                    } else {
                                                        z17 = z27;
                                                        long sampleTime = this.f126643v.getSampleTime();
                                                        this.A = sampleTime;
                                                        z18 = z28;
                                                        long j3 = this.B;
                                                        if (j3 != 0) {
                                                            long j16 = (sampleTime * 100) / j3;
                                                        }
                                                        i18 = readSampleData;
                                                    }
                                                    r rVar = this.f126644w;
                                                    long j17 = this.A;
                                                    if (z18) {
                                                        i19 = 4;
                                                    } else {
                                                        i19 = 0;
                                                    }
                                                    rVar.a(a19, 0, i18, j17, i19);
                                                    if (!z18) {
                                                        this.f126643v.advance();
                                                    }
                                                } else {
                                                    byteBufferArr = a18;
                                                    z17 = z27;
                                                    z18 = z28;
                                                    com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioDecoderMediaCodec", "inputBufIndex " + a19);
                                                }
                                            } else {
                                                byteBufferArr = a18;
                                                z17 = z27;
                                                z18 = z28;
                                                i17 = i29;
                                            }
                                            z28 = z18;
                                            int a26 = this.f126644w.a(bufferInfo, 1000L);
                                            if (a26 >= 0) {
                                                int i36 = bufferInfo.size;
                                                if (i36 > 0) {
                                                    i17 = 0;
                                                }
                                                ByteBuffer byteBuffer = b16[a26];
                                                if (i36 > 0) {
                                                    a(e18, byteBuffer, i36);
                                                }
                                                byteBuffer.clear();
                                                this.f126644w.a(a26, false);
                                                if ((bufferInfo.flags & 4) != 0) {
                                                    com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioDecoderMediaCodec", "saw output EOS.");
                                                    i28 = i17;
                                                    a18 = byteBufferArr;
                                                    z27 = true;
                                                }
                                            } else if (a26 == -3) {
                                                b16 = this.f126644w.b();
                                                com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDecoderMediaCodec", "output buffers have changed.");
                                            } else if (a26 == -2) {
                                                MediaFormat c17 = this.f126644w.c();
                                                com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDecoderMediaCodec", "output format has changed to " + c17);
                                                this.f126636p = c17.getInteger("sample-rate");
                                                this.f126637q = c17.getInteger("channel-count");
                                                if (c17.containsKey("pcm-encoding")) {
                                                    this.f126647z = c17.getInteger("pcm-encoding");
                                                } else if (c17.containsKey("bit-width")) {
                                                    int integer = c17.getInteger("bit-width");
                                                    if (integer == 16) {
                                                        this.f126647z = 2;
                                                        c16 = 3;
                                                    } else {
                                                        c16 = 3;
                                                        if (integer == 8) {
                                                            this.f126647z = 3;
                                                        }
                                                    }
                                                    Object[] objArr = new Object[5];
                                                    objArr[0] = Integer.valueOf(this.f126636p);
                                                    objArr[1] = Integer.valueOf(this.f126637q);
                                                    objArr[2] = Integer.valueOf(this.f126647z);
                                                    objArr[c16] = this.f126622b.c().f138564a;
                                                    objArr[4] = this.f126627g;
                                                    com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDecoderMediaCodec", "sampleRate:%d, channels:%d, bitDepth:%d, audioId:%s, sourcePath:%s", objArr);
                                                    if (com.tencent.luggage.wxa.j9.a.c(this.f126647z)) {
                                                        com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioDecoderMediaCodec", "bitDepth:%d is not support!", Integer.valueOf(this.f126647z));
                                                        this.f126626f = TMAssistantDownloadErrorCode.DownloadSDKErrorCode_REDIRECT_TOO_MANY_TIMES;
                                                        b(TMAssistantDownloadErrorCode.DownloadSDKErrorCode_REDIRECT_TOO_MANY_TIMES);
                                                        return;
                                                    } else if (com.tencent.luggage.wxa.j9.a.a(this.f126636p, this.f126637q, this.f126647z) && this.f126625e != null) {
                                                        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDecoderMediaCodec", "support audio Config");
                                                        this.f126625e.b();
                                                        this.f126625e.release();
                                                        this.f126625e = null;
                                                    } else if (this.f126625e != null) {
                                                        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDecoderMediaCodec", "update config param");
                                                        this.f126625e.a(this.f126636p, this.f126637q, this.f126647z);
                                                    }
                                                }
                                                c16 = 3;
                                                Object[] objArr2 = new Object[5];
                                                objArr2[0] = Integer.valueOf(this.f126636p);
                                                objArr2[1] = Integer.valueOf(this.f126637q);
                                                objArr2[2] = Integer.valueOf(this.f126647z);
                                                objArr2[c16] = this.f126622b.c().f138564a;
                                                objArr2[4] = this.f126627g;
                                                com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDecoderMediaCodec", "sampleRate:%d, channels:%d, bitDepth:%d, audioId:%s, sourcePath:%s", objArr2);
                                                if (com.tencent.luggage.wxa.j9.a.c(this.f126647z)) {
                                                }
                                            } else {
                                                com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDecoderMediaCodec", "dequeueOutputBuffer returned " + a26);
                                            }
                                            i28 = i17;
                                            a18 = byteBufferArr;
                                            z27 = z17;
                                        } catch (Exception e19) {
                                            com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioDecoderMediaCodec", e19, "onDecode", new Object[0]);
                                            this.f126626f = 706;
                                            b(706);
                                        }
                                    } finally {
                                        z();
                                        y();
                                    }
                                }
                                if ((this.B / 1000) - (this.A / 1000) < 2000) {
                                    z16 = true;
                                } else {
                                    z16 = false;
                                }
                                if (i28 >= 50) {
                                    com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioDecoderMediaCodec", "onError, noOutputCounter:%d", Integer.valueOf(i28));
                                    this.f126626f = 706;
                                    b(706);
                                } else {
                                    com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDecoderMediaCodec", "onStop, isComplete:%b", Boolean.valueOf(z16));
                                    if (z16) {
                                        c(e18);
                                    } else {
                                        e18.k();
                                    }
                                }
                                z();
                                y();
                                e18.a(this.f126622b.c().f138589z);
                                com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioDecoderMediaCodec", "stopping...");
                            } catch (Exception e26) {
                                e = e26;
                                i16 = 0;
                                com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioDecoderMediaCodec", e, "selectTrack", new Object[i16]);
                                this.f126626f = 716;
                                b(716);
                            }
                        } catch (IllegalArgumentException e27) {
                            com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioDecoderMediaCodec", e27, "getInputBuffers or getOutputBuffers", new Object[0]);
                            this.f126626f = 716;
                            b(716);
                        } catch (IllegalStateException e28) {
                            com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioDecoderMediaCodec", e28, "getInputBuffers or getOutputBuffers", new Object[0]);
                            this.f126626f = 716;
                            b(716);
                        }
                    } catch (Exception e29) {
                        e = e29;
                        i3 = 0;
                        com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioDecoderMediaCodec", e, "createDecoderByType", new Object[i3]);
                        this.f126626f = 704;
                        b(704);
                    }
                } catch (Exception e36) {
                    e = e36;
                    i3 = 0;
                }
            } catch (Exception e37) {
                com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioDecoderMediaCodec", e37, "get media format from media extractor", new Object[0]);
                this.f126626f = 705;
                b(705);
                z();
            }
        } catch (Exception e38) {
            com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioDecoderMediaCodec", e38, "set extractor data source, sourcePath:%s", this.f126627g);
            this.f126626f = 702;
            a(true);
            x();
        }
    }

    public final void x() {
        try {
            i iVar = this.f126645x;
            if (iVar != null) {
                iVar.close();
                this.f126645x = null;
            }
        } catch (Exception e16) {
            com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioDecoderMediaCodec", e16, "releaseDataSource", new Object[0]);
        }
    }

    public final void y() {
        try {
            r rVar = this.f126644w;
            if (rVar != null) {
                rVar.g();
                this.f126644w.d();
                this.f126644w = null;
            }
        } catch (Exception e16) {
            com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioDecoderMediaCodec", e16, "releaseMediaCodec", new Object[0]);
        }
    }

    public final void z() {
        try {
            MediaExtractor mediaExtractor = this.f126643v;
            if (mediaExtractor != null) {
                mediaExtractor.release();
                this.f126643v = null;
            }
        } catch (Exception e16) {
            com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioDecoderMediaCodec", e16, "releaseMediaExtractor", new Object[0]);
        }
        x();
    }

    public void a(ByteBuffer byteBuffer, int i3) {
        if (i3 != this.F) {
            this.F = i3;
            this.E = new byte[i3];
        }
        byteBuffer.get(this.E);
        if (this.f126622b.c().A) {
            com.tencent.luggage.wxa.f9.a.a(this.E, b().f138575l);
        }
        this.f126625e.a(this.E);
    }

    public final void a(com.tencent.luggage.wxa.c9.d dVar, byte[] bArr, long j3) {
        int i3;
        if (bArr == null) {
            com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioDecoderMediaCodec", "pushBuffer chunk is null");
            return;
        }
        int length = bArr.length;
        if (length == 3536) {
            if (this.H > 0) {
                b(dVar);
            }
            a(dVar, bArr);
            return;
        }
        if (length != 3536) {
            if (length > this.C) {
                while (true) {
                    i3 = this.C;
                    if (i3 >= length) {
                        break;
                    } else {
                        this.C = i3 + 3536;
                    }
                }
                byte[] bArr2 = new byte[i3];
                int i16 = this.H;
                if (i16 > 0) {
                    System.arraycopy(this.D, 0, bArr2, 0, i16);
                }
                this.D = bArr2;
            }
            int i17 = this.H;
            int i18 = i17 + length;
            System.arraycopy(bArr, 0, this.D, i17, length);
            int i19 = i18 / 3536;
            int i26 = i18 % 3536;
            for (int i27 = 0; i27 < i19; i27++) {
                byte[] bArr3 = new byte[3536];
                System.arraycopy(this.D, i27 * 3536, bArr3, 0, 3536);
                a(dVar, bArr3);
            }
            System.arraycopy(this.D, i19 * 3536, this.G, 0, i26);
            Arrays.fill(this.D, 0, this.C, (byte) 0);
            System.arraycopy(this.G, 0, this.D, 0, i26);
            this.H = i26;
        }
    }

    public void b(com.tencent.luggage.wxa.c9.d dVar) {
        int i3 = this.H;
        if (i3 <= 0) {
            return;
        }
        if (i3 > 3536) {
            int i16 = i3 / 3536;
            int i17 = i3 % 3536;
            for (int i18 = 0; i18 < i16; i18++) {
                byte[] bArr = new byte[3536];
                System.arraycopy(this.D, i18 * 3536, bArr, 0, 3536);
                a(dVar, bArr);
            }
            System.arraycopy(this.D, i16 * 3536, this.G, 0, i17);
            Arrays.fill(this.D, 0, this.C, (byte) 0);
            System.arraycopy(this.G, 0, this.D, 0, i17);
            this.H = i17;
        }
        int i19 = this.H;
        if (i19 <= 3536) {
            byte[] bArr2 = new byte[3536];
            System.arraycopy(this.D, 0, bArr2, 0, i19);
            a(dVar, bArr2);
            this.H = 0;
        }
    }

    public void a(com.tencent.luggage.wxa.c9.d dVar, byte[] bArr) {
        com.tencent.luggage.wxa.c9.e b16 = com.tencent.luggage.wxa.d9.e.a().b();
        b16.f123439f = bArr;
        b16.f123435b = this.f126636p;
        b16.f123436c = this.f126637q;
        b16.f123437d = this.f126647z;
        dVar.b(b16);
        b(b16);
    }
}
