package com.tencent.luggage.wxa.mc;

import android.text.TextUtils;
import com.tencent.luggage.wxa.mc.a0;
import com.tencent.luggage.wxa.mc.m;
import com.tencent.luggage.wxa.mc.n;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.mm.plugin.appbrand.appstorage.FileStructStat;
import com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing;
import com.tencent.xweb.xwalk.plugin.XWalkReaderBasePlugin;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b0 extends com.tencent.luggage.wxa.rc.h implements IWxaFileSystemWithModularizing {

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.luggage.wxa.ic.g f134267a;

    /* renamed from: b, reason: collision with root package name */
    public final n[] f134268b = {null};

    /* renamed from: c, reason: collision with root package name */
    public Map f134269c = new HashMap();

    public b0(com.tencent.luggage.wxa.ic.g gVar) {
        this.f134267a = gVar;
    }

    public final com.tencent.luggage.wxa.rc.l a(String str) {
        if (!b().d(str)) {
            return com.tencent.luggage.wxa.rc.l.RET_NOT_EXISTS;
        }
        return com.tencent.luggage.wxa.rc.l.OK;
    }

    @Override // com.tencent.luggage.wxa.rc.h, com.tencent.luggage.wxa.rc.r, com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing
    public boolean accept(String str) {
        try {
            b().c(str);
            return true;
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    @Override // com.tencent.luggage.wxa.rc.h, com.tencent.luggage.wxa.rc.r, com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing
    public com.tencent.luggage.wxa.rc.l access(String str) {
        com.tencent.luggage.wxa.rc.l a16 = a(str);
        com.tencent.luggage.wxa.rc.l lVar = com.tencent.luggage.wxa.rc.l.RET_NOT_EXISTS;
        if (a16 == lVar) {
            if (str.length() == 0) {
                return lVar;
            }
            String a17 = com.tencent.luggage.wxa.rc.m.a(str);
            if (!a17.substring(a17.length() - 1).equals("/")) {
                a17 = a17 + "/";
            }
            List<String> c16 = b().c();
            if (c16 == null) {
                c16 = Collections.emptyList();
            }
            Iterator<String> it = c16.iterator();
            while (it.hasNext()) {
                if (w0.d(it.next()).startsWith(a17)) {
                    return com.tencent.luggage.wxa.rc.l.OK;
                }
            }
            return a16;
        }
        return a16;
    }

    public final n b() {
        n[] nVarArr = this.f134268b;
        n nVar = nVarArr[0];
        if (nVar == null || n.a.f134344a == nVar) {
            synchronized (nVarArr) {
                n[] nVarArr2 = this.f134268b;
                n nVar2 = nVarArr2[0];
                if (nVar2 == null || n.a.f134344a == nVar2) {
                    nVarArr2[0] = k0.b(this.f134267a);
                }
            }
        }
        return this.f134268b[0];
    }

    public final void d(String str) {
        if (!str.startsWith("/")) {
            str = "/" + str;
        }
        if (!str.contains("\\") && !str.trim().isEmpty()) {
            while (!str.equals("")) {
                if (!str.endsWith("/")) {
                    str = str.substring(0, str.lastIndexOf("/"));
                    if (str.equals("")) {
                        this.f134269c.put("/", Long.valueOf(System.currentTimeMillis() / 1000));
                    } else {
                        this.f134269c.put(str + "/", Long.valueOf(System.currentTimeMillis() / 1000));
                    }
                } else {
                    com.tencent.luggage.wxa.tn.w.b("Luggage.WXA.WxaPkgFileSystemWithModularizingNewImpl", "updateDirAccessTimeRecord: path = [%s] is illegal", str);
                    return;
                }
            }
            return;
        }
        com.tencent.luggage.wxa.tn.w.b("Luggage.WXA.WxaPkgFileSystemWithModularizingNewImpl", "updateDirAccessTimeRecord: path = [%s] is illegal", str);
    }

    @Override // com.tencent.luggage.wxa.rc.h, com.tencent.luggage.wxa.rc.r, com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing
    public com.tencent.luggage.wxa.cp.v getAbsoluteFile(String str, boolean z16) {
        boolean z17;
        if (!z16) {
            if (isdir(str) == com.tencent.luggage.wxa.rc.l.OK) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                return null;
            }
        }
        m.a openReadPartialInfo = b().openReadPartialInfo(str);
        if (openReadPartialInfo == null) {
            return null;
        }
        String a16 = q.a(openReadPartialInfo.f134338d, openReadPartialInfo.f134340f);
        if (TextUtils.isEmpty(a16)) {
            return null;
        }
        return new com.tencent.luggage.wxa.cp.v(a16);
    }

    @Override // com.tencent.luggage.wxa.rc.h, com.tencent.luggage.wxa.rc.r, com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing
    public com.tencent.luggage.wxa.rc.l isdir(String str) {
        return readDir(str, new com.tencent.luggage.wxa.tk.i());
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing
    public a0.a openReadPartialInfo(String str) {
        m.a openReadPartialInfo = b().openReadPartialInfo(str);
        if (openReadPartialInfo != null) {
            return openReadPartialInfo.a();
        }
        return null;
    }

    @Override // com.tencent.luggage.wxa.rc.h, com.tencent.luggage.wxa.rc.r
    public com.tencent.luggage.wxa.rc.l readDir(String str, com.tencent.luggage.wxa.tk.i iVar) {
        Object obj;
        if (a(str) == com.tencent.luggage.wxa.rc.l.OK) {
            return com.tencent.luggage.wxa.rc.l.ERR_IS_FILE;
        }
        String a16 = com.tencent.luggage.wxa.rc.m.a(str);
        List<String> c16 = b().c();
        if (c16 == null) {
            return com.tencent.luggage.wxa.rc.l.RET_NOT_EXISTS;
        }
        String quote = Pattern.quote(a16);
        for (String str2 : c16) {
            if (w0.d(str2).startsWith(a16)) {
                String replaceFirst = str2.replaceFirst(quote, "");
                if (replaceFirst.split("/").length <= 1) {
                    com.tencent.luggage.wxa.rc.j jVar = new com.tencent.luggage.wxa.rc.j();
                    jVar.f139536a = replaceFirst;
                    if (iVar.f141499a == null) {
                        obj = new LinkedList();
                    } else {
                        obj = (List) iVar.f141499a;
                    }
                    iVar.f141499a = obj;
                    ((List) iVar.f141499a).add(jVar);
                }
            }
        }
        if (iVar.f141499a == null) {
            return com.tencent.luggage.wxa.rc.l.RET_NOT_EXISTS;
        }
        return com.tencent.luggage.wxa.rc.l.OK;
    }

    @Override // com.tencent.luggage.wxa.rc.h, com.tencent.luggage.wxa.rc.r, com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing
    public com.tencent.luggage.wxa.rc.l readFile(String str, long j3, long j16, com.tencent.luggage.wxa.tk.i iVar) {
        long available;
        ByteBuffer byteBuffer;
        InputStream b16 = b().b(str);
        if (b16 == null) {
            return com.tencent.luggage.wxa.rc.l.RET_NOT_EXISTS;
        }
        try {
            if (j16 == Long.MAX_VALUE) {
                try {
                    available = b16.available() - j3;
                } catch (Exception e16) {
                    com.tencent.luggage.wxa.tn.w.a("Luggage.WXA.WxaPkgFileSystemWithModularizingNewImpl", e16, XWalkReaderBasePlugin.READ_METHOD_NAME, new Object[0]);
                    w0.a((Closeable) b16);
                    return com.tencent.luggage.wxa.rc.l.ERR_OP_FAIL;
                }
            } else {
                available = j16;
            }
            com.tencent.luggage.wxa.rc.l a16 = a(j3, available, b16.available());
            com.tencent.luggage.wxa.rc.l lVar = com.tencent.luggage.wxa.rc.l.OK;
            if (a16 != lVar) {
                return a16;
            }
            if ((j3 == 0 && available == ((long) b16.available())) && (b16 instanceof com.tencent.luggage.wxa.h6.a)) {
                byteBuffer = ByteBuffer.allocateDirect(b16.available());
                byteBuffer.put(((com.tencent.luggage.wxa.h6.a) b16).a());
            } else {
                byte[] a17 = com.tencent.luggage.wxa.tk.c.a(b16, j3, available);
                ByteBuffer allocateDirect = ByteBuffer.allocateDirect(a17.length);
                allocateDirect.put(ByteBuffer.wrap(a17));
                byteBuffer = allocateDirect;
            }
            byteBuffer.rewind();
            iVar.f141499a = byteBuffer;
            d(str);
            return lVar;
        } finally {
            w0.a((Closeable) b16);
        }
    }

    @Override // com.tencent.luggage.wxa.rc.h, com.tencent.luggage.wxa.rc.r, com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing
    public com.tencent.luggage.wxa.rc.l readZipEntry(String str, com.tencent.luggage.wxa.tk.i iVar, String str2, long j3, long j16) {
        return com.tencent.luggage.wxa.rc.m.a(getAbsoluteFile(str, false).g(), iVar, str2, j3, j16);
    }

    @Override // com.tencent.luggage.wxa.rc.h, com.tencent.luggage.wxa.rc.r, com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing
    public void release() {
        n[] nVarArr = this.f134268b;
        n nVar = nVarArr[0];
        if (nVar == null || n.a.f134344a == nVar) {
            synchronized (nVarArr) {
                n nVar2 = this.f134268b[0];
                if (nVar2 != null && n.a.f134344a != nVar2) {
                }
                return;
            }
        }
        this.f134268b[0].close();
    }

    @Override // com.tencent.luggage.wxa.rc.h, com.tencent.luggage.wxa.rc.r, com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing
    public com.tencent.luggage.wxa.rc.l stat(String str, FileStructStat fileStructStat) {
        m.a openReadPartialInfo = b().openReadPartialInfo(str);
        if (openReadPartialInfo == null) {
            return a(str, fileStructStat);
        }
        openReadPartialInfo.f134338d.p().fillAnother(fileStructStat);
        fileStructStat.st_size = openReadPartialInfo.f134342h;
        return com.tencent.luggage.wxa.rc.l.OK;
    }

    @Override // com.tencent.luggage.wxa.rc.h, com.tencent.luggage.wxa.rc.r, com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing
    public com.tencent.luggage.wxa.rc.l statDir(String str, List list) {
        if (!str.endsWith("/")) {
            str = str + "/";
        }
        if (!str.startsWith("/")) {
            str = "/" + str;
        }
        if (!str.contains("\\") && !str.trim().isEmpty()) {
            for (String str2 : b().c()) {
                if (str2 != null && str2.startsWith(str)) {
                    com.tencent.luggage.wxa.rc.z zVar = new com.tencent.luggage.wxa.rc.z(str2);
                    String name = stat(str2, zVar).name();
                    if (name.equals(com.tencent.luggage.wxa.rc.l.OK.name())) {
                        list.add(zVar);
                    } else {
                        com.tencent.luggage.wxa.tn.w.h("Luggage.WXA.WxaPkgFileSystemWithModularizingNewImpl", "statDir: stat [%s] fail:[%s]", str2, name);
                    }
                }
            }
            return com.tencent.luggage.wxa.rc.l.OK;
        }
        com.tencent.luggage.wxa.tn.w.b("Luggage.WXA.WxaPkgFileSystemWithModularizingNewImpl", "statDir: path = [%s] is illegal", str);
        return super.statDir(str, list);
    }

    public final com.tencent.luggage.wxa.rc.l a(String str, FileStructStat fileStructStat) {
        a0 e16;
        if (!str.endsWith("/")) {
            str = str + "/";
        }
        if (!str.startsWith("/")) {
            str = "/" + str;
        }
        com.tencent.luggage.wxa.rc.l a16 = a(str);
        com.tencent.luggage.wxa.rc.l lVar = com.tencent.luggage.wxa.rc.l.RET_NOT_EXISTS;
        if (a16 != lVar || (e16 = b().e(str)) == null) {
            return lVar;
        }
        e16.p().fillAnother(fileStructStat);
        fileStructStat.makeItIsDir();
        fileStructStat.st_size = 0L;
        Long l3 = (Long) this.f134269c.get(str);
        if (l3 != null) {
            fileStructStat.st_atime = l3.longValue();
        }
        return com.tencent.luggage.wxa.rc.l.OK;
    }

    @Override // com.tencent.luggage.wxa.rc.h, com.tencent.luggage.wxa.rc.r, com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing
    public void initialize() {
    }

    @Override // com.tencent.luggage.wxa.rc.h, com.tencent.luggage.wxa.rc.r, com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing
    public com.tencent.luggage.wxa.rc.l readFile(String str, com.tencent.luggage.wxa.tk.i iVar) {
        InputStream b16 = b().b(str);
        if (b16 == null) {
            return com.tencent.luggage.wxa.rc.l.RET_NOT_EXISTS;
        }
        try {
            try {
                int available = b16.available();
                w0.a((Closeable) b16);
                return readFile(str, 0L, available, iVar);
            } catch (IOException e16) {
                com.tencent.luggage.wxa.tn.w.a("Luggage.WXA.WxaPkgFileSystemWithModularizingNewImpl", e16, XWalkReaderBasePlugin.READ_METHOD_NAME, new Object[0]);
                com.tencent.luggage.wxa.rc.l lVar = com.tencent.luggage.wxa.rc.l.ERR_OP_FAIL;
                w0.a((Closeable) b16);
                return lVar;
            }
        } catch (Throwable th5) {
            w0.a((Closeable) b16);
            throw th5;
        }
    }
}
