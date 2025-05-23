package com.qq.e.comm.plugin.i.e;

import com.qq.e.comm.plugin.i.d.b;
import com.qq.e.comm.plugin.i.e;
import com.qq.e.comm.plugin.i.h;
import com.qq.e.comm.plugin.i.i;
import com.qq.e.comm.plugin.k.g;
import com.qq.e.comm.util.GDTLogger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class c extends a {
    public c(e eVar, com.qq.e.comm.plugin.i.b.a aVar, b.a aVar2, h hVar, com.qq.e.comm.plugin.i.c cVar) {
        super(eVar, aVar, aVar2, hVar, cVar);
    }

    public List<com.qq.e.comm.plugin.i.d.b> a() {
        String str;
        ArrayList arrayList = new ArrayList();
        long j3 = this.f39528c;
        if (j3 > 1048576) {
            List<i> a16 = a(j3);
            if (g.b(a16)) {
                return arrayList;
            }
            GDTLogger.d("DownloaderImplMulti threadInfo : " + Arrays.toString(a16.toArray()));
            this.f39529d.b((long) 0);
            Iterator<i> it = a16.iterator();
            while (it.hasNext()) {
                arrayList.add(new com.qq.e.comm.plugin.i.core.e(this.f39529d, it.next(), this.f39530e, this.f39531f));
            }
        } else {
            i a17 = a(0L, j3);
            arrayList.add(new com.qq.e.comm.plugin.i.core.g(this.f39529d, this.f39530e, a17, this.f39531f));
            StringBuilder sb5 = new StringBuilder();
            sb5.append("DownloaderImpl SingleDownloadTask info url: ");
            if (a17 != null) {
                str = a17.f();
            } else {
                str = "";
            }
            sb5.append(str);
            GDTLogger.d(sb5.toString());
            GDTLogger.d("DownloaderImpl SingleDownloadTask info length: " + this.f39528c);
        }
        return arrayList;
    }
}
