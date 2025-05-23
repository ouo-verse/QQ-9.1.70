package com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.download;

import androidx.annotation.WorkerThread;
import java.util.HashMap;
import java.util.Map;
import pw2.n;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes19.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private volatile Map<String, b> f303772a = new HashMap();

    @WorkerThread
    public synchronized void a(String str, b bVar) {
        b c16 = c(str);
        if (c16 != null) {
            long j3 = c16.f303771b;
            if (j3 > 0 && bVar != null) {
                bVar.f303771b = j3;
            }
        }
        this.f303772a.put(str, bVar);
        d.d().h(bVar);
    }

    public synchronized void b(String str) {
        this.f303772a.remove(str);
        d.d().a(str);
    }

    @WorkerThread
    public synchronized b c(String str) {
        b bVar;
        bVar = this.f303772a.get(str);
        if (bVar == null && (bVar = d.d().f(str)) != null) {
            this.f303772a.put(str, bVar);
        }
        if (bVar != null) {
            n.e("QADDownloadInfoCache", "size=" + bVar.f303771b);
        }
        return bVar;
    }

    public synchronized void d(String str, b bVar) {
        this.f303772a.put(str, bVar);
        d.d().k(bVar);
    }
}
