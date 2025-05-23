package com.qq.e.comm.plugin.i.c;

import com.qq.e.comm.plugin.i.c;
import com.qq.e.comm.plugin.i.d.b;
import com.qq.e.comm.plugin.i.e;
import com.qq.e.comm.plugin.i.h;
import com.qq.e.comm.util.GDTLogger;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b {
    public static List<com.qq.e.comm.plugin.i.d.b> a(e eVar, com.qq.e.comm.plugin.i.b.a aVar, b.a aVar2, h hVar, c cVar) {
        if (eVar != null && aVar != null && aVar2 != null && hVar != null && cVar != null) {
            try {
                if (eVar.f() && eVar.d() > 0) {
                    return new com.qq.e.comm.plugin.i.e.c(eVar, aVar, aVar2, hVar, cVar).a();
                }
                return new com.qq.e.comm.plugin.i.e.b(eVar, aVar, aVar2, hVar, cVar).a();
            } catch (Throwable th5) {
                GDTLogger.e("DownloadTaskFactory getDownloadTask :", th5);
                return null;
            }
        }
        GDTLogger.e("DownloadTaskFactory getDownloadTask params invalid !");
        return null;
    }
}
