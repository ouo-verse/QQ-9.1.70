package com.tencent.luggage.wxa.gj;

import com.tencent.luggage.wxa.rc.r;
import com.tencent.luggage.wxa.tn.w;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c extends com.tencent.luggage.wxa.ej.b {
    @Override // com.tencent.luggage.wxa.ej.a
    public int a() {
        return 10;
    }

    @Override // com.tencent.luggage.wxa.ej.b
    public void a(com.tencent.luggage.wxa.xa.h hVar, com.tencent.luggage.wxa.ej.c cVar) {
        w.d("GetFileSysFolderSizeAsync", "[execute] reqArgs:" + hVar);
        hVar.optString("dirPath", "");
        hVar.optString("filePath", "");
        HashMap hashMap = new HashMap();
        r fileSystem = cVar.a().getFileSystem();
        if (fileSystem != null) {
            fileSystem.getStorageSpaceStatistics();
        }
        hashMap.put("size", -1);
        cVar.b(hashMap);
    }
}
