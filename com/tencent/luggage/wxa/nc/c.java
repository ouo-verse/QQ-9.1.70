package com.tencent.luggage.wxa.nc;

import androidx.collection.ArrayMap;
import com.tencent.luggage.wxa.cp.v;
import com.tencent.luggage.wxa.mc.a0;
import com.tencent.luggage.wxa.nc.b;
import com.tencent.luggage.wxa.tn.w;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c extends b {

    /* renamed from: f, reason: collision with root package name */
    public static final ByteOrder f135612f = ByteOrder.BIG_ENDIAN;

    /* renamed from: a, reason: collision with root package name */
    public volatile int f135613a = -1;

    /* renamed from: b, reason: collision with root package name */
    public volatile int f135614b = 0;

    /* renamed from: c, reason: collision with root package name */
    public volatile int f135615c = 0;

    /* renamed from: d, reason: collision with root package name */
    public volatile int f135616d = 0;

    /* renamed from: e, reason: collision with root package name */
    public volatile int f135617e = -1;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class a extends b.a {

        /* renamed from: e, reason: collision with root package name */
        public final int f135618e;

        public a(String str, String str2, int i3, int i16, int i17) {
            super(str, str2, i3, i16);
            this.f135618e = i17;
        }
    }

    @Override // com.tencent.luggage.wxa.nc.a
    public InputStream a(a0.a aVar) {
        return null;
    }

    @Override // com.tencent.luggage.wxa.nc.a
    public boolean b(a0.a aVar) {
        if ((aVar instanceof a) && aVar.f134263b != null && ((a) aVar).f135618e == 1) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.nc.a
    public int i() {
        return this.f135617e;
    }

    @Override // com.tencent.luggage.wxa.nc.a
    public int n() {
        return this.f135614b;
    }

    @Override // com.tencent.luggage.wxa.nc.a
    public boolean a(FileChannel fileChannel) {
        if (fileChannel == null) {
            return false;
        }
        fileChannel.position(0L);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(18);
        allocateDirect.order(f135612f);
        fileChannel.read(allocateDirect);
        if (-66 != allocateDirect.get(0) || -19 != allocateDirect.get(17)) {
            return false;
        }
        byte[] a16 = com.tencent.luggage.wxa.tk.c.a(allocateDirect);
        this.f135613a = b.a(a16, 1, 4);
        this.f135614b = b.a(a16, 5, 4);
        this.f135615c = b.a(a16, 9, 4);
        this.f135616d = b.a(a16, 13, 4);
        return true;
    }

    @Override // com.tencent.luggage.wxa.nc.a
    public Map a(FileChannel fileChannel, v vVar) {
        int i3;
        int i16;
        a aVar = null;
        if (fileChannel == null) {
            w.b("MicroMsg.WxaPkgMixedImpl", "fileChannel is null");
            return null;
        }
        if (vVar == null) {
            w.b("MicroMsg.WxaPkgMixedImpl", "file is null");
            return null;
        }
        fileChannel.position(18L);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.f135614b);
        allocateDirect.order(f135612f);
        fileChannel.read(allocateDirect);
        byte[] a16 = com.tencent.luggage.wxa.tk.c.a(allocateDirect);
        this.f135617e = b.a(a16, 0, 4);
        ArrayMap arrayMap = new ArrayMap();
        int i17 = 0;
        int i18 = 4;
        while (i17 < this.f135617e) {
            int a17 = b.a(a16, i18, 4);
            int i19 = i18 + 4;
            String str = new String(a16, i19, a17);
            int i26 = i19 + a17;
            int a18 = b.a(a16, i26, 1);
            int i27 = i26 + 1;
            int a19 = b.a(a16, i27, 4);
            int i28 = i27 + 4;
            int a26 = b.a(a16, i28, 4);
            i18 = i28 + 4;
            if (a18 == 0) {
                i16 = this.f135614b + 18 + this.f135615c;
            } else if (a18 == 1) {
                i16 = this.f135614b + 18;
            } else {
                w.b("MicroMsg.WxaPkgMixedImpl", "encType error: %d", Integer.valueOf(a18));
                i3 = 0;
                a aVar2 = new a(vVar.g(), str, i3, a26, a18);
                arrayMap.put(str, aVar2);
                i17++;
                aVar = aVar2;
            }
            i3 = i16 + a19;
            a aVar22 = new a(vVar.g(), str, i3, a26, a18);
            arrayMap.put(str, aVar22);
            i17++;
            aVar = aVar22;
        }
        if (aVar != null && aVar.f134264c + aVar.f134265d > vVar.s()) {
            w.b("MicroMsg.WxaPkgMixedImpl", "getInfo, lastFileOffset(%d) + lastFileLength(%d) > totalFileLength(%d), infoMap.size(%d), filesCount(%d)", Integer.valueOf(aVar.f134264c), Integer.valueOf(aVar.f134265d), Long.valueOf(vVar.s()), Integer.valueOf(arrayMap.size()), Integer.valueOf(this.f135617e));
        }
        return arrayMap;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }
}
