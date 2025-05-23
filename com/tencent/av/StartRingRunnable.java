package com.tencent.av;

import android.text.TextUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.avcore.data.AVCoreSystemInfo;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes3.dex */
public class StartRingRunnable implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    String f72845d;

    /* renamed from: e, reason: collision with root package name */
    long f72846e = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public StartRingRunnable(String str) {
        this.f72845d = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (n.e().f().f73008c0 < 0) {
            AVCoreSystemInfo.getCpuInfo();
            long maxCpuFreq = AVCoreSystemInfo.getMaxCpuFreq();
            if (AVCoreSystemInfo.getCpuArchitecture() < 4 || maxCpuFreq / 1000 < 800) {
                n.e().f().f73008c0 = 0;
            }
        }
        if (n.e().f() != null && n.e().f().f73076s0 == 1 && !TextUtils.isEmpty(n.e().f().f73080t0)) {
            VideoAppInterface.N().k0(new Object[]{30, this.f72845d, n.e().f().f73080t0});
        } else {
            VideoAppInterface.N().k0(new Object[]{30, this.f72845d});
        }
        r.h0().z3(this.f72846e);
        r.h0().m3(null);
    }

    public String toString() {
        return this.f72846e + "";
    }
}
