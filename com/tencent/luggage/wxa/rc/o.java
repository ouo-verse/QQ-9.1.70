package com.tencent.luggage.wxa.rc;

import android.text.TextUtils;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.mm.plugin.appbrand.appstorage.FileStat;
import com.tencent.mm.plugin.appbrand.appstorage.FileStructStat;
import com.tencent.mm.plugin.appbrand.appstorage.LuggageLocalFileObjectManager;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public class o extends h {

    /* renamed from: b, reason: collision with root package name */
    public final String f139551b;

    /* renamed from: c, reason: collision with root package name */
    public final String f139552c;

    /* renamed from: d, reason: collision with root package name */
    public final String f139553d;

    /* renamed from: e, reason: collision with root package name */
    public final LuggageLocalFileObjectManager f139554e;

    /* renamed from: a, reason: collision with root package name */
    public volatile boolean f139550a = false;

    /* renamed from: f, reason: collision with root package name */
    public String f139555f = "tmp";

    /* renamed from: g, reason: collision with root package name */
    public volatile long f139556g = -1;

    public o(String str, String str2, String str3) {
        String g16 = new com.tencent.luggage.wxa.cp.v(str).g();
        this.f139551b = g16;
        this.f139552c = str2;
        this.f139553d = str3;
        this.f139554e = new LuggageLocalFileObjectManager(g16, str2, str3);
    }

    public String a(String str) {
        a0 d16 = this.f139554e.d(str);
        if (d16 == null) {
            return null;
        }
        return d16.f139454b;
    }

    @Override // com.tencent.luggage.wxa.rc.h, com.tencent.luggage.wxa.rc.r, com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing
    public boolean accept(String str) {
        return w0.d(str).startsWith(this.f139553d);
    }

    @Override // com.tencent.luggage.wxa.rc.h, com.tencent.luggage.wxa.rc.r, com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing
    public l access(String str) {
        a0 d16 = this.f139554e.d(str);
        if (d16 != null && com.tencent.luggage.wxa.cp.x.d(d16.f139454b)) {
            return l.OK;
        }
        return l.RET_NOT_EXISTS;
    }

    @Override // com.tencent.luggage.wxa.rc.h, com.tencent.luggage.wxa.rc.r
    public com.tencent.luggage.wxa.cp.v allocTempFile(String str) {
        com.tencent.luggage.wxa.cp.x.m(this.f139551b);
        return new com.tencent.luggage.wxa.cp.v(this.f139551b + "/" + str);
    }

    public void b() {
        com.tencent.luggage.wxa.cp.x.c(this.f139551b + "/dir.lock");
    }

    public String c() {
        return this.f139553d;
    }

    @Override // com.tencent.luggage.wxa.rc.h, com.tencent.luggage.wxa.rc.r
    public l createTempFileFrom(com.tencent.luggage.wxa.cp.v vVar, String str, boolean z16, com.tencent.luggage.wxa.tk.i iVar) {
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.Luggage.FlattenFileSystem", "createTempFileFrom src[%s] suffix[%s] deleteSrc[%b] released[%b]", vVar, str, Boolean.valueOf(z16), Boolean.valueOf(this.f139550a));
        if (this.f139550a) {
            return l.ERR_FS_NOT_MOUNTED;
        }
        a0 a16 = this.f139554e.a(vVar.g(), str, z16);
        if (a16 == null) {
            return l.ERR_OP_FAIL;
        }
        iVar.f141499a = a16.f139453a;
        return l.OK;
    }

    public String e() {
        return this.f139551b;
    }

    @Override // com.tencent.luggage.wxa.rc.h, com.tencent.luggage.wxa.rc.r, com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing
    public com.tencent.luggage.wxa.cp.v getAbsoluteFile(String str, boolean z16) {
        return getAbsoluteFile(str);
    }

    @Override // com.tencent.luggage.wxa.rc.h, com.tencent.luggage.wxa.rc.r
    public List getSavedFileList() {
        return this.f139554e.f();
    }

    @Override // com.tencent.luggage.wxa.rc.h, com.tencent.luggage.wxa.rc.r
    public t getStorageSpaceStatistics() {
        return null;
    }

    @Override // com.tencent.luggage.wxa.rc.h, com.tencent.luggage.wxa.rc.r
    public l getTempDirectory(com.tencent.luggage.wxa.tk.i iVar) {
        iVar.f141499a = this.f139551b;
        return l.OK;
    }

    @Override // com.tencent.luggage.wxa.rc.h, com.tencent.luggage.wxa.rc.r, com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing
    public void initialize() {
        if (!com.tencent.luggage.wxa.cp.x.m(this.f139551b)) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.Luggage.FlattenFileSystem", "Initialization Failed");
        }
    }

    @Override // com.tencent.luggage.wxa.rc.h, com.tencent.luggage.wxa.rc.r
    public boolean isSavedFile(String str) {
        a0 d16 = this.f139554e.d(str);
        if (d16 != null && d16.f139457e) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.rc.h, com.tencent.luggage.wxa.rc.r
    public l readDir(String str, com.tencent.luggage.wxa.tk.i iVar) {
        LinkedList<a0> linkedList = new LinkedList();
        com.tencent.luggage.wxa.h6.c.a(linkedList, this.f139554e.f());
        com.tencent.luggage.wxa.h6.c.a(linkedList, this.f139554e.h());
        LinkedList linkedList2 = new LinkedList();
        for (a0 a0Var : linkedList) {
            j jVar = new j();
            jVar.f139536a = a0Var.f139453a;
            linkedList2.add(jVar);
        }
        iVar.f141499a = linkedList2;
        return l.OK;
    }

    @Override // com.tencent.luggage.wxa.rc.h, com.tencent.luggage.wxa.rc.r, com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing
    public l readFile(String str, com.tencent.luggage.wxa.tk.i iVar) {
        a0 d16 = this.f139554e.d(str);
        if (d16 != null && com.tencent.luggage.wxa.cp.x.d(d16.f139454b)) {
            iVar.f141499a = m.c(new com.tencent.luggage.wxa.cp.v(d16.f139454b));
            return l.OK;
        }
        return l.RET_NOT_EXISTS;
    }

    @Override // com.tencent.luggage.wxa.rc.h, com.tencent.luggage.wxa.rc.r
    public final InputStream readStream(String str) {
        a0 d16 = this.f139554e.d(str);
        if (d16 != null && com.tencent.luggage.wxa.cp.x.d(d16.f139454b)) {
            try {
                return com.tencent.luggage.wxa.cp.x.n(d16.f139454b);
            } catch (FileNotFoundException unused) {
            }
        }
        return null;
    }

    @Override // com.tencent.luggage.wxa.rc.h, com.tencent.luggage.wxa.rc.r, com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing
    public l readZipEntry(String str, com.tencent.luggage.wxa.tk.i iVar, String str2, long j3, long j16) {
        a0 d16 = this.f139554e.d(str);
        if (d16 != null && com.tencent.luggage.wxa.cp.x.d(d16.f139454b)) {
            return m.a(d16.f139454b, iVar, str2, j3, j16);
        }
        return l.RET_NOT_EXISTS;
    }

    @Override // com.tencent.luggage.wxa.rc.h, com.tencent.luggage.wxa.rc.r, com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing
    public void release() {
        super.release();
        this.f139550a = true;
    }

    @Override // com.tencent.luggage.wxa.rc.h, com.tencent.luggage.wxa.rc.r
    public boolean removeSavedFile(String str) {
        a0 d16 = this.f139554e.d(str);
        if (d16 != null && d16.f139457e) {
            return new com.tencent.luggage.wxa.cp.v(d16.f139454b).d();
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.rc.h, com.tencent.luggage.wxa.rc.r
    public l saveFile(com.tencent.luggage.wxa.cp.v vVar, String str, com.tencent.luggage.wxa.tk.i iVar) {
        if (vVar != null && vVar.e()) {
            if (TextUtils.isEmpty(str) && iVar != null) {
                if (this.f139556g > 0 && this.f139554e.e() + vVar.s() > this.f139556g) {
                    return l.ERR_EXCEED_DIRECTORY_MAX_SIZE;
                }
                a0 c16 = this.f139554e.c(vVar.i());
                if (c16 != null) {
                    if (c16.f139457e) {
                        iVar.f141499a = c16.f139453a;
                        return l.OK;
                    }
                    iVar.f141499a = this.f139554e.a(c16).f139453a;
                    return l.OK;
                }
                a0 a16 = this.f139554e.a(vVar.g());
                long j3 = a16.f139458f;
                iVar.f141499a = this.f139554e.a(a16).f139453a;
                return l.OK;
            }
            return l.ERR_NOT_SUPPORTED;
        }
        return l.ERR_OP_FAIL;
    }

    @Override // com.tencent.luggage.wxa.rc.h
    public void setMaxTotalSize(long j3) {
        this.f139556g = j3;
    }

    @Override // com.tencent.luggage.wxa.rc.h, com.tencent.luggage.wxa.rc.r, com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing
    public l stat(String str, FileStructStat fileStructStat) {
        a0 d16 = this.f139554e.d(str);
        if (d16 != null && com.tencent.luggage.wxa.cp.x.d(d16.f139454b)) {
            if (fileStructStat == null) {
                return l.ERR_OP_FAIL;
            }
            if (FileStat.vfsStat(d16.f139454b, fileStructStat) == 0) {
                return l.OK;
            }
            return l.ERR_OP_FAIL;
        }
        return l.RET_NOT_EXISTS;
    }

    @Override // com.tencent.luggage.wxa.rc.h, com.tencent.luggage.wxa.rc.r
    public l unlink(String str) {
        return l.ERR_PERMISSION_DENIED;
    }

    @Override // com.tencent.luggage.wxa.rc.h, com.tencent.luggage.wxa.rc.r
    public com.tencent.luggage.wxa.cp.v getAbsoluteFile(String str) {
        a0 d16 = this.f139554e.d(str);
        if (d16 == null) {
            return null;
        }
        return new com.tencent.luggage.wxa.cp.v(d16.f139454b);
    }

    @Override // com.tencent.luggage.wxa.rc.h, com.tencent.luggage.wxa.rc.r, com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing
    public l readFile(String str, long j3, long j16, com.tencent.luggage.wxa.tk.i iVar) {
        a0 d16 = this.f139554e.d(str);
        if (d16 != null && com.tencent.luggage.wxa.cp.x.d(d16.f139454b)) {
            com.tencent.luggage.wxa.cp.v vVar = new com.tencent.luggage.wxa.cp.v(d16.f139454b);
            if (j16 == Long.MAX_VALUE) {
                j16 = vVar.s() - j3;
            }
            l a16 = a(j3, j16, vVar.s());
            l lVar = l.OK;
            if (a16 != lVar) {
                return a16;
            }
            iVar.f141499a = m.a(vVar, j3, j16);
            return lVar;
        }
        return l.RET_NOT_EXISTS;
    }
}
