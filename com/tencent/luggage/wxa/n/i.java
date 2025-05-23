package com.tencent.luggage.wxa.n;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.view.Surface;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.luggage.wxa.m.p;
import com.tencent.luggage.wxa.n.e;
import com.tencent.luggage.wxa.n.f;
import com.tencent.luggage.wxa.n0.v;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes8.dex */
public class i extends com.tencent.luggage.wxa.z.b implements com.tencent.luggage.wxa.n0.h {

    /* renamed from: h0, reason: collision with root package name */
    public final e.a f134997h0;

    /* renamed from: i0, reason: collision with root package name */
    public final f f134998i0;

    /* renamed from: j0, reason: collision with root package name */
    public boolean f134999j0;

    /* renamed from: k0, reason: collision with root package name */
    public boolean f135000k0;

    /* renamed from: l0, reason: collision with root package name */
    public MediaFormat f135001l0;

    /* renamed from: m0, reason: collision with root package name */
    public int f135002m0;

    /* renamed from: n0, reason: collision with root package name */
    public int f135003n0;

    /* renamed from: o0, reason: collision with root package name */
    public long f135004o0;

    /* renamed from: p0, reason: collision with root package name */
    public boolean f135005p0;

    public i(com.tencent.luggage.wxa.z.c cVar, com.tencent.luggage.wxa.p.b bVar, boolean z16, Handler handler, e eVar, c cVar2, d... dVarArr) {
        super(1, cVar, bVar, z16);
        this.f134998i0 = new f(cVar2, dVarArr, new b());
        this.f134997h0 = new e.a(handler, eVar);
    }

    public static boolean g(String str) {
        if (v.f135103a < 24 && "OMX.SEC.aac.dec".equals(str) && CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_SANXING.equals(v.f135105c)) {
            String str2 = v.f135104b;
            if (str2.startsWith("zeroflte") || str2.startsWith("herolte") || str2.startsWith("heroqlte")) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.z.b
    public void D() {
        try {
            this.f134998i0.s();
        } catch (f.j e16) {
            throw com.tencent.luggage.wxa.m.d.a(e16, o());
        }
    }

    public void a(int i3, long j3, long j16) {
    }

    public void b(int i3) {
    }

    public boolean f(String str) {
        return this.f134998i0.b(str);
    }

    @Override // com.tencent.luggage.wxa.n0.h
    public p h() {
        return this.f134998i0.d();
    }

    @Override // com.tencent.luggage.wxa.z.b, com.tencent.luggage.wxa.m.r
    public boolean isReady() {
        if (!this.f134998i0.i() && !super.isReady()) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.luggage.wxa.n0.h
    public long j() {
        long a16 = this.f134998i0.a(b());
        if (a16 != Long.MIN_VALUE) {
            if (!this.f135005p0) {
                a16 = Math.max(this.f135004o0, a16);
            }
            this.f135004o0 = a16;
            this.f135005p0 = false;
        }
        return this.f135004o0;
    }

    @Override // com.tencent.luggage.wxa.z.b, com.tencent.luggage.wxa.m.a
    public void q() {
        try {
            this.f134998i0.t();
            try {
                super.q();
            } finally {
            }
        } catch (Throwable th5) {
            try {
                super.q();
                throw th5;
            } finally {
            }
        }
    }

    @Override // com.tencent.luggage.wxa.z.b, com.tencent.luggage.wxa.m.a
    public void r() {
        super.r();
        this.f134998i0.r();
    }

    @Override // com.tencent.luggage.wxa.z.b, com.tencent.luggage.wxa.m.a
    public void s() {
        this.f134998i0.q();
        super.s();
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public final class b implements f.h {
        public b() {
        }

        @Override // com.tencent.luggage.wxa.n.f.h
        public void a(int i3) {
            i.this.f134997h0.a(i3);
            i.this.b(i3);
        }

        @Override // com.tencent.luggage.wxa.n.f.h
        public void a() {
            i.this.E();
            i.this.f135005p0 = true;
        }

        @Override // com.tencent.luggage.wxa.n.f.h
        public void a(int i3, long j3, long j16) {
            i.this.f134997h0.a(i3, j3, j16);
            i.this.a(i3, j3, j16);
        }
    }

    @Override // com.tencent.luggage.wxa.z.b
    public void b(com.tencent.luggage.wxa.m.j jVar) {
        super.b(jVar);
        this.f134997h0.a(jVar);
        this.f135002m0 = "audio/raw".equals(jVar.f133896f) ? jVar.I : 2;
        this.f135003n0 = jVar.G;
    }

    @Override // com.tencent.luggage.wxa.z.b
    public int a(com.tencent.luggage.wxa.z.c cVar, com.tencent.luggage.wxa.m.j jVar) {
        int i3;
        int i16;
        String str = jVar.f133896f;
        boolean z16 = false;
        if (!com.tencent.luggage.wxa.n0.i.g(str)) {
            return 0;
        }
        int i17 = v.f135103a;
        int i18 = i17 >= 21 ? 32 : 0;
        if (f(str) && cVar.a() != null) {
            return i18 | 8 | 4;
        }
        com.tencent.luggage.wxa.z.a a16 = cVar.a(str, false);
        if (a16 == null) {
            return 1;
        }
        if (i17 < 21 || (((i3 = jVar.H) == -1 || a16.b(i3)) && ((i16 = jVar.G) == -1 || a16.a(i16)))) {
            z16 = true;
        }
        return i18 | 8 | (z16 ? 4 : 3);
    }

    @Override // com.tencent.luggage.wxa.z.b, com.tencent.luggage.wxa.m.r
    public boolean b() {
        return super.b() && this.f134998i0.l();
    }

    @Override // com.tencent.luggage.wxa.z.b
    public com.tencent.luggage.wxa.z.a a(com.tencent.luggage.wxa.z.c cVar, com.tencent.luggage.wxa.m.j jVar, boolean z16) {
        com.tencent.luggage.wxa.z.a a16;
        if (f(jVar.f133896f) && (a16 = cVar.a()) != null) {
            this.f134999j0 = true;
            return a16;
        }
        this.f134999j0 = false;
        return super.a(cVar, jVar, z16);
    }

    @Override // com.tencent.luggage.wxa.z.b
    public void a(com.tencent.luggage.wxa.z.a aVar, MediaCodec mediaCodec, com.tencent.luggage.wxa.m.j jVar, MediaCrypto mediaCrypto) {
        this.f135000k0 = g(aVar.f146140a);
        if (this.f134999j0) {
            MediaFormat a16 = jVar.a();
            this.f135001l0 = a16;
            a16.setString("mime", "audio/raw");
            mediaCodec.configure(this.f135001l0, (Surface) null, mediaCrypto, 0);
            this.f135001l0.setString("mime", jVar.f133896f);
            return;
        }
        mediaCodec.configure(jVar.a(), (Surface) null, mediaCrypto, 0);
        this.f135001l0 = null;
    }

    public void E() {
    }

    @Override // com.tencent.luggage.wxa.m.a, com.tencent.luggage.wxa.m.r
    public com.tencent.luggage.wxa.n0.h m() {
        return this;
    }

    @Override // com.tencent.luggage.wxa.z.b
    public void a(String str, long j3, long j16) {
        this.f134997h0.a(str, j3, j16);
    }

    @Override // com.tencent.luggage.wxa.z.b
    public void a(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        int[] iArr;
        int i3;
        MediaFormat mediaFormat2 = this.f135001l0;
        boolean z16 = mediaFormat2 != null;
        String string = z16 ? mediaFormat2.getString("mime") : "audio/raw";
        if (z16) {
            mediaFormat = this.f135001l0;
        }
        int integer = mediaFormat.getInteger("channel-count");
        int integer2 = mediaFormat.getInteger("sample-rate");
        if (this.f135000k0 && integer == 6 && (i3 = this.f135003n0) < 6) {
            iArr = new int[i3];
            for (int i16 = 0; i16 < this.f135003n0; i16++) {
                iArr[i16] = i16;
            }
        } else {
            iArr = null;
        }
        try {
            this.f134998i0.a(string, integer, integer2, this.f135002m0, 0, iArr);
        } catch (f.e e16) {
            throw com.tencent.luggage.wxa.m.d.a(e16, o());
        }
    }

    @Override // com.tencent.luggage.wxa.z.b, com.tencent.luggage.wxa.m.a
    public void a(boolean z16) {
        super.a(z16);
        this.f134997h0.b(this.f146152f0);
        int i3 = n().f133924a;
        if (i3 != 0) {
            this.f134998i0.a(i3);
        } else {
            this.f134998i0.b();
        }
    }

    @Override // com.tencent.luggage.wxa.z.b, com.tencent.luggage.wxa.m.a
    public void a(long j3, boolean z16) {
        super.a(j3, z16);
        this.f134998i0.v();
        this.f135004o0 = j3;
        this.f135005p0 = true;
    }

    @Override // com.tencent.luggage.wxa.n0.h
    public p a(p pVar) {
        return this.f134998i0.a(pVar);
    }

    @Override // com.tencent.luggage.wxa.z.b
    public boolean a(long j3, long j16, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i3, int i16, long j17, boolean z16) {
        if (this.f134999j0 && (i16 & 2) != 0) {
            mediaCodec.releaseOutputBuffer(i3, false);
            return true;
        }
        if (z16) {
            mediaCodec.releaseOutputBuffer(i3, false);
            this.f146152f0.f135952e++;
            this.f134998i0.g();
            return true;
        }
        try {
            if (!this.f134998i0.a(byteBuffer, j17)) {
                return false;
            }
            mediaCodec.releaseOutputBuffer(i3, false);
            this.f146152f0.f135951d++;
            return true;
        } catch (f.C6492f | f.j e16) {
            throw com.tencent.luggage.wxa.m.d.a(e16, o());
        }
    }

    @Override // com.tencent.luggage.wxa.m.a, com.tencent.luggage.wxa.m.e.b
    public void a(int i3, Object obj) {
        if (i3 == 2) {
            this.f134998i0.a(((Float) obj).floatValue());
        } else if (i3 != 3) {
            super.a(i3, obj);
        } else {
            this.f134998i0.a((com.tencent.luggage.wxa.n.b) obj);
        }
    }
}
