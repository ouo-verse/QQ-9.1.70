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
public final class d extends b {

    /* renamed from: e, reason: collision with root package name */
    public static final ByteOrder f135619e = ByteOrder.BIG_ENDIAN;

    /* renamed from: a, reason: collision with root package name */
    public volatile int f135620a = -1;

    /* renamed from: b, reason: collision with root package name */
    public volatile int f135621b = 0;

    /* renamed from: c, reason: collision with root package name */
    public volatile int f135622c = 0;

    /* renamed from: d, reason: collision with root package name */
    public volatile int f135623d = -1;

    @Override // com.tencent.luggage.wxa.nc.a
    public InputStream a(a0.a aVar) {
        return null;
    }

    @Override // com.tencent.luggage.wxa.nc.a
    public boolean b(a0.a aVar) {
        return false;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f135620a = -1;
        this.f135621b = 0;
        this.f135622c = 0;
        this.f135623d = -1;
    }

    @Override // com.tencent.luggage.wxa.nc.a
    public int i() {
        return this.f135623d;
    }

    @Override // com.tencent.luggage.wxa.nc.a
    public int n() {
        return this.f135621b;
    }

    @Override // com.tencent.luggage.wxa.nc.a
    public boolean a(FileChannel fileChannel) {
        if (fileChannel == null) {
            return false;
        }
        fileChannel.position(0L);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(14);
        allocateDirect.order(f135619e);
        fileChannel.read(allocateDirect);
        if (-66 != allocateDirect.get(0) || -19 != allocateDirect.get(13)) {
            return false;
        }
        byte[] a16 = com.tencent.luggage.wxa.tk.c.a(allocateDirect);
        this.f135620a = b.a(a16, 1, 4);
        this.f135621b = b.a(a16, 5, 4);
        this.f135622c = b.a(a16, 9, 4);
        return true;
    }

    @Override // com.tencent.luggage.wxa.nc.a
    public Map a(FileChannel fileChannel, v vVar) {
        b.a aVar = null;
        if (fileChannel == null) {
            w.b("MicroMsg.WxaPkgNormalImpl", "fileChannel is null");
            return null;
        }
        if (vVar == null) {
            w.b("MicroMsg.WxaPkgNormalImpl", "file is null");
            return null;
        }
        fileChannel.position(14L);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.f135621b);
        allocateDirect.order(f135619e);
        fileChannel.read(allocateDirect);
        byte[] a16 = com.tencent.luggage.wxa.tk.c.a(allocateDirect);
        this.f135623d = b.a(a16, 0, 4);
        ArrayMap arrayMap = new ArrayMap();
        int i3 = 0;
        int i16 = 4;
        while (i3 < this.f135623d) {
            int a17 = b.a(a16, i16, 4);
            int i17 = i16 + 4;
            String str = new String(a16, i17, a17);
            int i18 = i17 + a17;
            int a18 = b.a(a16, i18, 4);
            int i19 = i18 + 4;
            int a19 = b.a(a16, i19, 4);
            i16 = i19 + 4;
            b.a aVar2 = new b.a(vVar.g(), str, a18, a19);
            arrayMap.put(str, aVar2);
            i3++;
            aVar = aVar2;
        }
        if (aVar != null && aVar.f134264c + aVar.f134265d > vVar.s()) {
            w.b("MicroMsg.WxaPkgNormalImpl", "getInfo, lastFileOffset(%d) + lastFileLength(%d) > totalFileLength(%d), infoMap.size(%d), filesCount(%d)", Integer.valueOf(aVar.f134264c), Integer.valueOf(aVar.f134265d), Long.valueOf(vVar.s()), Integer.valueOf(arrayMap.size()), Integer.valueOf(this.f135623d));
        }
        return arrayMap;
    }
}
