package com.tencent.ads.monitor;

import android.text.TextUtils;
import com.tencent.ads.utility.SystemUtil;
import java.util.Queue;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes37.dex */
public final class c implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ PingService f61670d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PingService pingService) {
        this.f61670d = pingService;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Queue queue;
        Queue queue2;
        boolean doGetPing;
        Queue queue3;
        if (!SystemUtil.isNetworkAvailable()) {
            return;
        }
        queue = this.f61670d.f61662g;
        int size = queue.size();
        if (size == 0) {
            PingService.b(this.f61670d);
        }
        while (true) {
            int i3 = size - 1;
            if (size <= 0) {
                return;
            }
            queue2 = this.f61670d.f61662g;
            e eVar = (e) queue2.poll();
            if (eVar != null) {
                eVar.g();
                String a16 = eVar.a();
                if (!TextUtils.isEmpty(eVar.d())) {
                    doGetPing = PingService.doPostPing(a16, eVar.d());
                } else {
                    if (eVar.h() && eVar.b() > 0) {
                        a16 = String.valueOf(a16) + "&rt=" + eVar.b();
                    }
                    doGetPing = PingService.doGetPing(a16);
                }
                if (!doGetPing && eVar.b() < 5) {
                    queue3 = this.f61670d.f61662g;
                    queue3.offer(eVar);
                    PingService.a(this.f61670d, eVar);
                } else {
                    PingService.a(this.f61670d, eVar.e());
                }
            }
            size = i3;
        }
    }
}
