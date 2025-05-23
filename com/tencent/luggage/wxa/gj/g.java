package com.tencent.luggage.wxa.gj;

import com.tencent.luggage.wxa.rc.r;
import com.tencent.luggage.wxa.tn.w0;

/* compiled from: P */
/* loaded from: classes8.dex */
public class g extends com.tencent.luggage.wxa.ej.d {
    @Override // com.tencent.luggage.wxa.ej.a
    public int a() {
        return 12;
    }

    @Override // com.tencent.luggage.wxa.ej.d
    public String a(com.tencent.luggage.wxa.xa.h hVar, com.tencent.luggage.wxa.ej.c cVar) {
        if (w0.c(hVar.optString("filePath", ""))) {
            return cVar.b();
        }
        r fileSystem = cVar.a().getFileSystem();
        if (fileSystem == null) {
            return cVar.b();
        }
        fileSystem.getStorageSpaceStatistics();
        return cVar.b();
    }
}
