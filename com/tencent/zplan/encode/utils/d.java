package com.tencent.zplan.encode.utils;

import android.util.Log;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes38.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static ByteBuffer f385479a;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static class b extends AbstractC10057d {
        public b(f fVar) {
            super(fVar);
        }

        @Override // com.tencent.zplan.encode.utils.d.AbstractC10057d
        public void a(int i3, int i16, h hVar) {
            f fVar = this.f385480a;
            byte[] bArr = fVar.f385487g;
            int i17 = fVar.f385488h;
            fVar.f385488h = i17 + 1;
            bArr[i17] = d.b(hVar.d());
            if ((i3 & 1) == 0 && (i16 & 1) == 0) {
                f fVar2 = this.f385480a;
                fVar2.f385487g[fVar2.f385489i] = d.b(hVar.b());
                f fVar3 = this.f385480a;
                fVar3.f385489i += 2;
                fVar3.f385487g[fVar3.f385490j] = d.b(hVar.c());
                this.f385480a.f385490j += 2;
            }
        }

        @Override // com.tencent.zplan.encode.utils.d.AbstractC10057d
        public void b() {
            f fVar = this.f385480a;
            fVar.f385488h = 0;
            int i3 = fVar.f385486f;
            fVar.f385489i = i3;
            fVar.f385490j = i3 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static class c extends AbstractC10057d {
        public c(f fVar) {
            super(fVar);
        }

        @Override // com.tencent.zplan.encode.utils.d.AbstractC10057d
        public void a(int i3, int i16, h hVar) {
            f fVar = this.f385480a;
            byte[] bArr = fVar.f385487g;
            int i17 = fVar.f385488h;
            fVar.f385488h = i17 + 1;
            bArr[i17] = d.b(hVar.d());
            if ((i3 & 1) == 0 && (i16 & 1) == 0) {
                f fVar2 = this.f385480a;
                byte[] bArr2 = fVar2.f385487g;
                int i18 = fVar2.f385489i;
                fVar2.f385489i = i18 + 1;
                bArr2[i18] = d.b(hVar.b());
                f fVar3 = this.f385480a;
                byte[] bArr3 = fVar3.f385487g;
                int i19 = fVar3.f385490j;
                fVar3.f385490j = i19 + 1;
                bArr3[i19] = d.b(hVar.c());
            }
        }

        @Override // com.tencent.zplan.encode.utils.d.AbstractC10057d
        public void b() {
            f fVar = this.f385480a;
            fVar.f385488h = 0;
            int i3 = fVar.f385486f;
            fVar.f385489i = i3;
            fVar.f385490j = i3 + (i3 / 4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* renamed from: com.tencent.zplan.encode.utils.d$d, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public static abstract class AbstractC10057d {

        /* renamed from: a, reason: collision with root package name */
        protected f f385480a;

        public AbstractC10057d(f fVar) {
            this.f385480a = fVar;
            b();
        }

        public abstract void a(int i3, int i16, h hVar);

        public abstract void b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static class g {

        /* renamed from: a, reason: collision with root package name */
        private final h f385496a;

        g() {
            this.f385496a = new h();
        }

        public h a(int i3, int i16, int i17, int i18) {
            this.f385496a.a(i3, i16, i17, i18);
            return this.f385496a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static class h {

        /* renamed from: a, reason: collision with root package name */
        private int f385497a;

        /* renamed from: b, reason: collision with root package name */
        private int f385498b;

        /* renamed from: c, reason: collision with root package name */
        private int f385499c;

        /* renamed from: d, reason: collision with root package name */
        private int f385500d;

        /* renamed from: e, reason: collision with root package name */
        private int f385501e;

        /* renamed from: f, reason: collision with root package name */
        private int f385502f;

        /* renamed from: g, reason: collision with root package name */
        private int f385503g;

        h() {
        }

        public void a(int i3, int i16, int i17, int i18) {
            this.f385497a = i3;
            this.f385498b = i16;
            this.f385499c = i17;
            this.f385500d = i18;
            this.f385501e = (((((i16 * 66) + (i17 * 129)) + (i18 * 25)) + 128) >> 8) + 16;
            this.f385502f = (((((i16 * (-38)) - (i17 * 74)) + (i18 * 112)) + 128) >> 8) + 128;
            this.f385503g = (((((i16 * 112) - (i17 * 94)) - (i18 * 18)) + 128) >> 8) + 128;
        }

        public int b() {
            return this.f385502f;
        }

        public int c() {
            return this.f385503g;
        }

        public int d() {
            return this.f385501e;
        }

        public String toString() {
            return "PixelInfo{alpha=" + this.f385497a + ", red=" + this.f385498b + ", green=" + this.f385499c + ", blue=" + this.f385500d + ", yLuma=" + this.f385501e + ", uChrominance=" + this.f385502f + ", vChroma=" + this.f385503g + '}';
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

    public static void c() {
        ByteBuffer byteBuffer = f385479a;
        if (byteBuffer != null) {
            byteBuffer.clear();
            f385479a = null;
        }
    }

    public static byte[] d(com.tencent.zplan.encode.utils.a aVar, byte[] bArr, i iVar, int i3) {
        if (aVar.f385464b) {
            e(aVar.f385467e, aVar.f385466d * 4, bArr);
        }
        try {
            boolean z16 = f385479a.capacity() < ((aVar.f385468f * aVar.f385469g) * 3) / 2;
            ByteBuffer byteBuffer = f385479a;
            if (byteBuffer != null && !z16) {
                byteBuffer.clear();
                f385479a.position(0);
                new f(aVar.f385466d * i3, aVar.f385467e, aVar.f385468f, aVar.f385469g, aVar.f385465c, bArr, f385479a.array(), iVar).b();
                return f385479a.array();
            }
            return null;
        } catch (OutOfMemoryError e16) {
            Log.e("SR_MP4_YUV", "covertToNV12 OOM", e16);
            return null;
        }
    }

    public static void e(int i3, int i16, byte[] bArr) {
        System.nanoTime();
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
    }

    public static void f(com.tencent.zplan.encode.utils.a aVar) {
        f385479a = ByteBuffer.allocate(((aVar.f385468f * aVar.f385469g) * 3) / 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static class f {

        /* renamed from: a, reason: collision with root package name */
        final i f385481a;

        /* renamed from: b, reason: collision with root package name */
        final int f385482b;

        /* renamed from: c, reason: collision with root package name */
        final int f385483c;

        /* renamed from: d, reason: collision with root package name */
        final int f385484d;

        /* renamed from: e, reason: collision with root package name */
        final int f385485e;

        /* renamed from: f, reason: collision with root package name */
        final int f385486f;

        /* renamed from: g, reason: collision with root package name */
        byte[] f385487g;

        /* renamed from: h, reason: collision with root package name */
        int f385488h = 0;

        /* renamed from: i, reason: collision with root package name */
        int f385489i = 0;

        /* renamed from: j, reason: collision with root package name */
        int f385490j = 0;

        /* renamed from: k, reason: collision with root package name */
        int f385491k = 0;

        /* renamed from: l, reason: collision with root package name */
        private g f385492l = new g();

        /* renamed from: m, reason: collision with root package name */
        private byte[] f385493m;

        /* renamed from: n, reason: collision with root package name */
        private AbstractC10057d f385494n;

        /* renamed from: o, reason: collision with root package name */
        private int f385495o;

        public f(int i3, int i16, int i17, int i18, int i19, byte[] bArr, byte[] bArr2, i iVar) {
            this.f385482b = i3;
            this.f385483c = i16;
            this.f385484d = i17;
            this.f385485e = i18;
            this.f385486f = i17 * i18;
            this.f385493m = bArr;
            this.f385487g = bArr2;
            this.f385495o = i19;
            this.f385494n = e.a(this, i19);
            this.f385481a = iVar;
        }

        private h a(int i3, int i16) {
            int i17 = (i3 * this.f385482b * 4) + (i16 * 4);
            g gVar = this.f385492l;
            byte[] bArr = this.f385493m;
            i iVar = this.f385481a;
            return gVar.a(bArr[iVar.f385504a + i17] & 255, bArr[iVar.f385505b + i17] & 255, bArr[iVar.f385506c + i17] & 255, bArr[i17 + iVar.f385507d] & 255);
        }

        public void b() {
            for (int i3 = 0; i3 < this.f385483c && i3 < this.f385485e; i3++) {
                for (int i16 = 0; i16 < this.f385482b && i16 < this.f385484d; i16++) {
                    this.f385494n.a(i3, i16, a(i3, i16));
                    this.f385491k++;
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static class i {

        /* renamed from: a, reason: collision with root package name */
        public int f385504a;

        /* renamed from: b, reason: collision with root package name */
        public int f385505b;

        /* renamed from: c, reason: collision with root package name */
        public int f385506c;

        /* renamed from: d, reason: collision with root package name */
        public int f385507d;

        public i() {
            this.f385504a = 3;
            this.f385505b = 2;
            this.f385506c = 1;
            this.f385507d = 0;
        }

        public i(int i3, int i16, int i17, int i18) {
            this.f385504a = i3;
            this.f385505b = i16;
            this.f385506c = i17;
            this.f385507d = i18;
        }
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    private static class e {
        public static AbstractC10057d a(f fVar, int i3) {
            if (i3 != 39) {
                switch (i3) {
                    case 19:
                        return new c(fVar);
                    case 20:
                        return new c(fVar);
                    case 21:
                        return new b(fVar);
                    default:
                        return new b(fVar);
                }
            }
            return new b(fVar);
        }
    }
}
