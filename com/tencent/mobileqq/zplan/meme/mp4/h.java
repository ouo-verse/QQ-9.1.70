package com.tencent.mobileqq.zplan.meme.mp4;

import com.tencent.mobileqq.zplan.meme.mp4.Mp4MediaEncoder;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes34.dex */
public class h {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes34.dex */
    public static class a extends c {
        public a(e eVar) {
            super(eVar);
        }

        @Override // com.tencent.mobileqq.zplan.meme.mp4.h.c
        public void a(int i3, int i16, g gVar) {
            e eVar = this.f334183a;
            byte[] bArr = eVar.f334189f;
            int i17 = eVar.f334190g;
            eVar.f334190g = i17 + 1;
            bArr[i17] = h.b(gVar.d());
            if ((i3 & 1) == 0 && (i16 & 1) == 0) {
                e eVar2 = this.f334183a;
                eVar2.f334189f[eVar2.f334191h] = h.b(gVar.b());
                e eVar3 = this.f334183a;
                eVar3.f334191h += 2;
                eVar3.f334189f[eVar3.f334192i] = h.b(gVar.c());
                this.f334183a.f334192i += 2;
            }
        }

        @Override // com.tencent.mobileqq.zplan.meme.mp4.h.c
        public void b() {
            e eVar = this.f334183a;
            eVar.f334190g = 0;
            int i3 = eVar.f334188e;
            eVar.f334191h = i3;
            eVar.f334192i = i3 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes34.dex */
    public static class b extends c {
        public b(e eVar) {
            super(eVar);
        }

        @Override // com.tencent.mobileqq.zplan.meme.mp4.h.c
        public void a(int i3, int i16, g gVar) {
            e eVar = this.f334183a;
            byte[] bArr = eVar.f334189f;
            int i17 = eVar.f334190g;
            eVar.f334190g = i17 + 1;
            bArr[i17] = h.b(gVar.d());
            if ((i3 & 1) == 0 && (i16 & 1) == 0) {
                e eVar2 = this.f334183a;
                byte[] bArr2 = eVar2.f334189f;
                int i18 = eVar2.f334191h;
                eVar2.f334191h = i18 + 1;
                bArr2[i18] = h.b(gVar.b());
                e eVar3 = this.f334183a;
                byte[] bArr3 = eVar3.f334189f;
                int i19 = eVar3.f334192i;
                eVar3.f334192i = i19 + 1;
                bArr3[i19] = h.b(gVar.c());
            }
        }

        @Override // com.tencent.mobileqq.zplan.meme.mp4.h.c
        public void b() {
            e eVar = this.f334183a;
            eVar.f334190g = 0;
            int i3 = eVar.f334188e;
            eVar.f334191h = i3;
            eVar.f334192i = i3 + (i3 / 4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes34.dex */
    public static abstract class c {

        /* renamed from: a, reason: collision with root package name */
        protected e f334183a;

        public c(e eVar) {
            this.f334183a = eVar;
            b();
        }

        public abstract void a(int i3, int i16, g gVar);

        public abstract void b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes34.dex */
    public static class f {

        /* renamed from: a, reason: collision with root package name */
        private final g f334198a = new g();

        f() {
        }

        public g a(int i3, int i16, int i17, int i18) {
            this.f334198a.a(i3, i16, i17, i18);
            return this.f334198a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes34.dex */
    public static class g {

        /* renamed from: a, reason: collision with root package name */
        private int f334199a;

        /* renamed from: b, reason: collision with root package name */
        private int f334200b;

        /* renamed from: c, reason: collision with root package name */
        private int f334201c;

        /* renamed from: d, reason: collision with root package name */
        private int f334202d;

        /* renamed from: e, reason: collision with root package name */
        private int f334203e;

        /* renamed from: f, reason: collision with root package name */
        private int f334204f;

        /* renamed from: g, reason: collision with root package name */
        private int f334205g;

        g() {
        }

        public void a(int i3, int i16, int i17, int i18) {
            this.f334199a = i3;
            this.f334200b = i16;
            this.f334201c = i17;
            this.f334202d = i18;
            this.f334203e = (((((i16 * 66) + (i17 * 129)) + (i18 * 25)) + 128) >> 8) + 16;
            this.f334204f = (((((i16 * (-38)) - (i17 * 74)) + (i18 * 112)) + 128) >> 8) + 128;
            this.f334205g = (((((i16 * 112) - (i17 * 94)) - (i18 * 18)) + 128) >> 8) + 128;
        }

        public int b() {
            return this.f334204f;
        }

        public int c() {
            return this.f334205g;
        }

        public int d() {
            return this.f334203e;
        }

        public String toString() {
            return "PixelInfo{alpha=" + this.f334199a + ", red=" + this.f334200b + ", green=" + this.f334201c + ", blue=" + this.f334202d + ", yLuma=" + this.f334203e + ", uChrominance=" + this.f334204f + ", vChroma=" + this.f334205g + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte b(int i3) {
        if (i3 < 0) {
            i3 = 0;
        } else if (i3 > 255) {
            i3 = 255;
        }
        return (byte) i3;
    }

    public static byte[] c(Mp4MediaEncoder.b bVar, byte[] bArr) {
        if (QLog.isColorLevel()) {
            QLog.d("SR_MP4_YUV", 1, "covertToNV12, colorFormat:" + bVar.f334091c);
        }
        if (bVar.f334090b) {
            d(bVar.f334093e, bVar.f334092d * 4, bArr);
        }
        try {
            int i3 = bVar.f334094f;
            int i16 = bVar.f334095g;
            byte[] bArr2 = new byte[((i3 * i16) * 3) / 2];
            new e(bVar.f334092d, bVar.f334093e, i3, i16, bVar.f334091c, bArr, bArr2).b();
            return bArr2;
        } catch (OutOfMemoryError e16) {
            QLog.e("SR_MP4_YUV", 1, "covertToNV12 OOM", e16);
            return null;
        }
    }

    public static void d(int i3, int i16, byte[] bArr) {
        long nanoTime = System.nanoTime();
        int i17 = i3 / 2;
        int i18 = 0;
        while (i18 < i17) {
            int i19 = i18 * i16;
            i18++;
            int length = bArr.length - (i18 * i16);
            for (int i26 = 0; i26 < i16; i26++) {
                int i27 = i19 + i26;
                byte b16 = bArr[i27];
                int i28 = length + i26;
                bArr[i27] = bArr[i28];
                bArr[i28] = b16;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("SR_MP4_YUV", 1, "flipData, const:" + (System.nanoTime() - nanoTime));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes34.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        final int f334184a;

        /* renamed from: b, reason: collision with root package name */
        final int f334185b;

        /* renamed from: c, reason: collision with root package name */
        final int f334186c;

        /* renamed from: d, reason: collision with root package name */
        final int f334187d;

        /* renamed from: e, reason: collision with root package name */
        final int f334188e;

        /* renamed from: f, reason: collision with root package name */
        byte[] f334189f;

        /* renamed from: g, reason: collision with root package name */
        int f334190g = 0;

        /* renamed from: h, reason: collision with root package name */
        int f334191h = 0;

        /* renamed from: i, reason: collision with root package name */
        int f334192i = 0;

        /* renamed from: j, reason: collision with root package name */
        int f334193j = 0;

        /* renamed from: k, reason: collision with root package name */
        private f f334194k = new f();

        /* renamed from: l, reason: collision with root package name */
        private byte[] f334195l;

        /* renamed from: m, reason: collision with root package name */
        private c f334196m;

        /* renamed from: n, reason: collision with root package name */
        private int f334197n;

        public e(int i3, int i16, int i17, int i18, int i19, byte[] bArr, byte[] bArr2) {
            this.f334184a = i3;
            this.f334185b = i16;
            this.f334186c = i17;
            this.f334187d = i18;
            this.f334188e = i17 * i18;
            this.f334195l = bArr;
            this.f334189f = bArr2;
            this.f334197n = i19;
            this.f334196m = d.a(this, i19);
        }

        private g a(int i3, int i16) {
            int i17 = (i3 * this.f334184a * 4) + (i16 * 4);
            f fVar = this.f334194k;
            byte[] bArr = this.f334195l;
            return fVar.a(bArr[i17 + 3] & 255, bArr[i17 + 2] & 255, bArr[i17 + 1] & 255, bArr[i17 + 0] & 255);
        }

        public void b() {
            for (int i3 = 0; i3 < this.f334185b && i3 < this.f334187d; i3++) {
                for (int i16 = 0; i16 < this.f334184a && i16 < this.f334186c; i16++) {
                    this.f334196m.a(i3, i16, a(i3, i16));
                    this.f334193j++;
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes34.dex */
    private static class d {
        public static c a(e eVar, int i3) {
            if (i3 != 39) {
                switch (i3) {
                    case 19:
                        return new b(eVar);
                    case 20:
                        return new b(eVar);
                    case 21:
                        return new a(eVar);
                    default:
                        return new a(eVar);
                }
            }
            return new a(eVar);
        }
    }
}
