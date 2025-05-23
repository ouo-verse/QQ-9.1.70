package com.tencent.luggage.wxa.gj;

import com.tencent.luggage.wxa.rc.r;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a extends com.tencent.luggage.wxa.ej.d {
    @Override // com.tencent.luggage.wxa.ej.a
    public int a() {
        return 9;
    }

    @Override // com.tencent.luggage.wxa.ej.d
    public String a(com.tencent.luggage.wxa.xa.h hVar, com.tencent.luggage.wxa.ej.c cVar) {
        r fileSystem = cVar.a().getFileSystem();
        if (fileSystem == null) {
            return cVar.b();
        }
        fileSystem.getStorageSpaceStatistics();
        return cVar.b();
    }
}
