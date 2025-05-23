package com.tencent.luggage.wxa.rc;

import com.tencent.luggage.wxa.tn.w0;
import com.tencent.mm.plugin.appbrand.appstorage.FileStructStat;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class y implements r {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedList f139588a;

    /* renamed from: b, reason: collision with root package name */
    public final r f139589b = new h();

    public y(LinkedList linkedList) {
        LinkedList linkedList2 = new LinkedList();
        this.f139588a = linkedList2;
        linkedList2.addAll(linkedList);
    }

    public r a(Class cls) {
        Iterator it = this.f139588a.iterator();
        while (it.hasNext()) {
            r rVar = (r) it.next();
            if (cls.isInstance(rVar)) {
                return rVar;
            }
        }
        return null;
    }

    @Override // com.tencent.luggage.wxa.rc.r, com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing
    public boolean accept(String str) {
        String[] strArr = {"file://", "http://", "https://"};
        for (int i3 = 0; i3 < 3; i3++) {
            if (com.tencent.luggage.wxa.h6.o.a(str, strArr[i3])) {
                return false;
            }
        }
        return true;
    }

    @Override // com.tencent.luggage.wxa.rc.r, com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing
    public l access(String str) {
        return a(str).access(str);
    }

    public LinkedList b() {
        return this.f139588a;
    }

    @Override // com.tencent.luggage.wxa.rc.r
    public boolean canRenameFile(String str) {
        Iterator it = this.f139588a.iterator();
        while (it.hasNext()) {
            r rVar = (r) it.next();
            if (rVar.accept(str) && rVar.canRenameFile(str)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.rc.r
    public boolean canSaveToLocal(String str) {
        Iterator it = this.f139588a.iterator();
        while (it.hasNext()) {
            r rVar = (r) it.next();
            if (rVar.accept(str) && !rVar.canSaveToLocal(str)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.tencent.luggage.wxa.rc.r
    public l copyTo(String str, com.tencent.luggage.wxa.cp.v vVar, boolean z16) {
        return a(str).copyTo(str, vVar, z16);
    }

    @Override // com.tencent.luggage.wxa.rc.r
    public com.tencent.luggage.wxa.cp.v getAbsoluteFile(String str) {
        return getAbsoluteFile(str, false);
    }

    @Override // com.tencent.luggage.wxa.rc.r
    public com.tencent.luggage.wxa.cp.v getPrivateAbsoluteFile(String str) {
        return a(str).getPrivateAbsoluteFile(str);
    }

    @Override // com.tencent.luggage.wxa.rc.r
    public t getStorageSpaceStatistics() {
        return null;
    }

    @Override // com.tencent.luggage.wxa.rc.r
    public l getTempDirectory(com.tencent.luggage.wxa.tk.i iVar) {
        Iterator it = this.f139588a.iterator();
        while (it.hasNext()) {
            l tempDirectory = ((r) it.next()).getTempDirectory(iVar);
            if (tempDirectory != l.ERR_NOT_SUPPORTED) {
                return tempDirectory;
            }
        }
        return l.ERR_NOT_SUPPORTED;
    }

    @Override // com.tencent.luggage.wxa.rc.r, com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing
    public void initialize() {
        Iterator it = this.f139588a.iterator();
        while (it.hasNext()) {
            ((r) it.next()).initialize();
        }
        this.f139589b.initialize();
    }

    @Override // com.tencent.luggage.wxa.rc.r
    public boolean isSavedFile(String str) {
        return ((o) a(o.class)).isSavedFile(str);
    }

    @Override // com.tencent.luggage.wxa.rc.r, com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing
    public l isdir(String str) {
        return a(str).isdir(str);
    }

    @Override // com.tencent.luggage.wxa.rc.r
    public l mkdir(String str, boolean z16) {
        return a(str).mkdir(str, z16);
    }

    @Override // com.tencent.luggage.wxa.rc.r
    public l readDir(String str, com.tencent.luggage.wxa.tk.i iVar) {
        return a(str).readDir(str, iVar);
    }

    @Override // com.tencent.luggage.wxa.rc.r, com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing
    public l readFile(String str, com.tencent.luggage.wxa.tk.i iVar) {
        return a(str).readFile(str, iVar);
    }

    @Override // com.tencent.luggage.wxa.rc.r
    public final InputStream readStream(String str) {
        return a(str).readStream(str);
    }

    @Override // com.tencent.luggage.wxa.rc.r, com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing
    public l readZipEntry(String str, com.tencent.luggage.wxa.tk.i iVar, String str2, long j3, long j16) {
        return a(str).readZipEntry(str, iVar, str2, j3, j16);
    }

    @Override // com.tencent.luggage.wxa.rc.r, com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing
    public void release() {
        Iterator it = this.f139588a.iterator();
        while (it.hasNext()) {
            r rVar = (r) it.next();
            if (rVar instanceof o) {
                ((o) rVar).b();
            }
            rVar.release();
        }
        this.f139589b.release();
    }

    @Override // com.tencent.luggage.wxa.rc.r
    public boolean removeSavedFile(String str) {
        return ((o) a(o.class)).removeSavedFile(str);
    }

    @Override // com.tencent.luggage.wxa.rc.r
    public l rmdir(String str, boolean z16) {
        return a(str).rmdir(str, z16);
    }

    @Override // com.tencent.luggage.wxa.rc.r
    public l saveFile(com.tencent.luggage.wxa.cp.v vVar, String str, com.tencent.luggage.wxa.tk.i iVar) {
        Iterator it = this.f139588a.iterator();
        while (it.hasNext()) {
            l saveFile = ((r) it.next()).saveFile(vVar, str, iVar);
            if (saveFile != l.ERR_NOT_SUPPORTED) {
                return saveFile;
            }
        }
        return l.ERR_NOT_SUPPORTED;
    }

    @Override // com.tencent.luggage.wxa.rc.r, com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing
    public l stat(String str, FileStructStat fileStructStat) {
        return a(str).stat(str, fileStructStat);
    }

    @Override // com.tencent.luggage.wxa.rc.r, com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing
    public l statDir(String str, List list) {
        return a(str).statDir(str, list);
    }

    @Override // com.tencent.luggage.wxa.rc.r
    public l unlink(String str) {
        return a(str).unlink(str);
    }

    @Override // com.tencent.luggage.wxa.rc.r
    public l unzip(String str, com.tencent.luggage.wxa.cp.v vVar) {
        return a(str).unzip(str, vVar);
    }

    @Override // com.tencent.luggage.wxa.rc.r
    public l writeFile(String str, InputStream inputStream, boolean z16) {
        return a(str).writeFile(str, inputStream, z16);
    }

    @Override // com.tencent.luggage.wxa.rc.r, com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing
    public com.tencent.luggage.wxa.cp.v getAbsoluteFile(String str, boolean z16) {
        return a(str).getAbsoluteFile(str, z16);
    }

    @Override // com.tencent.luggage.wxa.rc.r, com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing
    public l readFile(String str, long j3, long j16, com.tencent.luggage.wxa.tk.i iVar) {
        return a(str).readFile(str, j3, j16, iVar);
    }

    public final r a(String str) {
        if (w0.c(str)) {
            return this.f139589b;
        }
        Iterator it = this.f139588a.iterator();
        while (it.hasNext()) {
            r rVar = (r) it.next();
            if (rVar.accept(str)) {
                return rVar;
            }
        }
        return this.f139589b;
    }
}
