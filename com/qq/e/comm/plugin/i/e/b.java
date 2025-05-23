package com.qq.e.comm.plugin.i.e;

import com.qq.e.comm.plugin.i.core.f;
import com.qq.e.comm.plugin.i.core.g;
import com.qq.e.comm.plugin.i.d.b;
import com.qq.e.comm.plugin.i.e;
import com.qq.e.comm.plugin.i.h;
import com.qq.e.comm.plugin.i.i;
import com.qq.e.comm.util.GDTLogger;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b extends a {
    public b(e eVar, com.qq.e.comm.plugin.i.b.a aVar, b.a aVar2, h hVar, com.qq.e.comm.plugin.i.c cVar) {
        super(eVar, aVar, aVar2, hVar, cVar);
    }

    public List<com.qq.e.comm.plugin.i.d.b> a() {
        ArrayList arrayList = new ArrayList();
        h hVar = this.f39526a;
        if (hVar == null) {
            return arrayList;
        }
        double e16 = hVar.e();
        if (e16 > 0.0d && e16 < 1.0d) {
            long j3 = this.f39528c;
            if (j3 <= this.f39533h) {
                GDTLogger.e("DownloaderImpl partial download size too small :" + this.f39528c);
                arrayList.add(new f(this.f39529d, this.f39530e, a(0L, this.f39528c), this.f39531f, null));
            } else {
                double ceil = Math.ceil(j3 * e16);
                if (ceil < this.f39533h) {
                    GDTLogger.e("DownloaderImpl partial download size too small :" + ceil);
                    ceil = (double) this.f39533h;
                }
                i a16 = a(0L, Double.valueOf(ceil).longValue());
                i a17 = a(Double.valueOf(ceil + 1.0d).longValue(), this.f39528c);
                arrayList.add(new f(this.f39529d, this.f39530e, a16, this.f39531f, new f(this.f39529d, this.f39530e, a17, this.f39531f, null)));
                GDTLogger.d("DownloaderImpl PartialDownloadTask one :" + a16);
                GDTLogger.d("DownloaderImpl PartialDownloadTask two :" + a17);
            }
            return arrayList;
        }
        long f16 = this.f39526a.f();
        if (f16 != 0) {
            long j16 = this.f39528c;
            if (f16 < j16) {
                i a18 = a(f16, j16);
                if (this.f39526a.g()) {
                    arrayList.add(new g(this.f39529d, this.f39530e, a18, this.f39531f));
                    GDTLogger.d("DownloaderImpl SingleDownloadTask offset :" + f16);
                } else {
                    arrayList.add(new f(this.f39529d, this.f39530e, a18, this.f39531f, null));
                    GDTLogger.d("DownloaderImpl PartialDownloadTask offset :" + f16);
                }
                return arrayList;
            }
        }
        i a19 = a(0L, this.f39528c);
        arrayList.add(new g(this.f39529d, this.f39530e, a19, this.f39531f));
        GDTLogger.d("DownloaderImpl SingleDownloadTask info url: " + a19.f());
        GDTLogger.d("DownloaderImpl SingleDownloadTask info length: " + this.f39528c);
        return arrayList;
    }
}
