package com.qq.e.comm.plugin.i.core;

import com.qq.e.comm.plugin.i.b.a;
import com.qq.e.comm.plugin.i.d.b;
import com.qq.e.comm.plugin.i.e;
import com.qq.e.comm.plugin.i.i;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes3.dex */
public class g extends c {
    public g(e eVar, a aVar, i iVar, b.a aVar2) {
        super(eVar, iVar, aVar2, aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.i.core.c
    public void a(i iVar) {
        super.a(iVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.i.core.c
    public void b(i iVar) {
        super.b(iVar);
    }

    @Override // com.qq.e.comm.plugin.i.core.c
    protected Map<String, String> c(i iVar) {
        if (iVar != null && iVar.d() != 0) {
            HashMap hashMap = new HashMap();
            hashMap.put("Range", "bytes=" + (iVar.d() + iVar.b()) + "-" + iVar.a());
            return hashMap;
        }
        return null;
    }

    @Override // com.qq.e.comm.plugin.i.core.c
    protected int j() {
        if (h() != null && h().d() != 0) {
            return 206;
        }
        return 200;
    }

    @Override // com.qq.e.comm.plugin.i.core.c
    protected RandomAccessFile a(File file, String str, long j3) throws IOException {
        if (!file.exists()) {
            file.mkdirs();
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(new File(file, str), "rwd");
        if (h() != null) {
            randomAccessFile.seek(h().d());
        }
        return randomAccessFile;
    }

    @Override // com.qq.e.comm.plugin.i.core.c
    protected void e() {
    }

    @Override // com.qq.e.comm.plugin.i.core.c
    protected void f() {
    }

    @Override // com.qq.e.comm.plugin.i.core.c
    protected void g() {
    }
}
