package com.tencent.luggage.wxa.gj;

import com.tencent.luggage.wxa.rc.r;
import com.tencent.luggage.wxa.tn.w;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d extends com.tencent.luggage.wxa.ej.d {
    @Override // com.tencent.luggage.wxa.ej.a
    public int a() {
        return 11;
    }

    @Override // com.tencent.luggage.wxa.ej.d
    public String a(com.tencent.luggage.wxa.xa.h hVar, com.tencent.luggage.wxa.ej.c cVar) {
        w.d("GetFileSysFolderSizeSync", "[execute] reqArgs:" + hVar);
        hVar.optString("dirPath", "");
        hVar.optString("filePath", "");
        HashMap hashMap = new HashMap();
        r fileSystem = cVar.a().getFileSystem();
        if (fileSystem != null) {
            fileSystem.getStorageSpaceStatistics();
        }
        hashMap.put("size", -1);
        return cVar.b();
    }
}
