package com.tencent.luggage.wxa.rc;

import com.tencent.luggage.wxa.tn.w0;
import com.tencent.mm.plugin.appbrand.appstorage.FileStructStat;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: P */
/* loaded from: classes8.dex */
public class g extends h {

    /* renamed from: a, reason: collision with root package name */
    public final String f139531a;

    /* renamed from: b, reason: collision with root package name */
    public final String f139532b;

    /* renamed from: c, reason: collision with root package name */
    public String f139533c;

    /* renamed from: d, reason: collision with root package name */
    public final x f139534d;

    /* renamed from: e, reason: collision with root package name */
    public volatile long f139535e = -1;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface a {
        com.tencent.luggage.wxa.xd.d a();
    }

    public g(String str, String str2, String str3, a aVar) {
        this.f139533c = str;
        String g16 = new com.tencent.luggage.wxa.cp.v(str).g();
        this.f139531a = str2;
        this.f139532b = str3;
        this.f139534d = new x(g16, str2, str3, aVar);
    }

    @Override // com.tencent.luggage.wxa.rc.h, com.tencent.luggage.wxa.rc.r, com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing
    public boolean accept(String str) {
        return w0.d(str).startsWith(this.f139532b);
    }

    @Override // com.tencent.luggage.wxa.rc.h, com.tencent.luggage.wxa.rc.r, com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing
    public l access(String str) {
        if (this.f139534d.a(str) == null) {
            return l.RET_NOT_EXISTS;
        }
        return l.OK;
    }

    @Override // com.tencent.luggage.wxa.rc.h, com.tencent.luggage.wxa.rc.r
    public boolean canSaveToLocal(String str) {
        return false;
    }

    @Override // com.tencent.luggage.wxa.rc.h, com.tencent.luggage.wxa.rc.r
    public com.tencent.luggage.wxa.cp.v getPrivateAbsoluteFile(String str) {
        return this.f139534d.c(str);
    }

    @Override // com.tencent.luggage.wxa.rc.h, com.tencent.luggage.wxa.rc.r, com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing
    public void initialize() {
        if (!com.tencent.luggage.wxa.cp.x.m(this.f139533c)) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.Luggage.BlobFileSystem", "Initialization Failed");
        }
    }

    @Override // com.tencent.luggage.wxa.rc.h, com.tencent.luggage.wxa.rc.r, com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing
    public l readFile(String str, com.tencent.luggage.wxa.tk.i iVar) {
        if (!accept(str)) {
            return l.ERR_NOT_SUPPORTED;
        }
        ByteBuffer a16 = this.f139534d.a(str);
        if (a16 == null) {
            return l.RET_NOT_EXISTS;
        }
        iVar.f141499a = a16;
        return l.OK;
    }

    @Override // com.tencent.luggage.wxa.rc.h, com.tencent.luggage.wxa.rc.r, com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing
    public void release() {
        this.f139534d.a();
    }

    @Override // com.tencent.luggage.wxa.rc.h
    public void setMaxTotalSize(long j3) {
        this.f139535e = j3;
    }

    @Override // com.tencent.luggage.wxa.rc.h, com.tencent.luggage.wxa.rc.r, com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing
    public l stat(String str, FileStructStat fileStructStat) {
        if (!accept(str)) {
            return l.ERR_NOT_SUPPORTED;
        }
        if (this.f139534d.a(str) == null) {
            return l.RET_NOT_EXISTS;
        }
        if (fileStructStat == null) {
            return l.ERR_OP_FAIL;
        }
        fileStructStat.st_mode = 33152;
        fileStructStat.st_size = r3.limit();
        return l.OK;
    }

    @Override // com.tencent.luggage.wxa.rc.h, com.tencent.luggage.wxa.rc.r, com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing
    public l readFile(String str, long j3, long j16, com.tencent.luggage.wxa.tk.i iVar) {
        if (!accept(str)) {
            return l.ERR_NOT_SUPPORTED;
        }
        ByteBuffer a16 = this.f139534d.a(str);
        if (a16 == null) {
            return l.RET_NOT_EXISTS;
        }
        int limit = a16.limit();
        if (j16 > TTL.MAX_VALUE) {
            j16 = limit - j3;
        }
        l a17 = a(j3, j16, limit);
        l lVar = l.OK;
        if (a17 != lVar) {
            return a17;
        }
        int i3 = (int) j16;
        byte[] bArr = new byte[i3];
        a16.get(bArr, (int) j3, i3);
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        wrap.order(ByteOrder.BIG_ENDIAN);
        iVar.f141499a = wrap;
        return lVar;
    }
}
