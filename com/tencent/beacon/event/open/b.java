package com.tencent.beacon.event.open;

import com.tencent.beacon.a.b.i;
import com.tencent.beacon.a.c.j;
import com.tencent.beacon.base.util.c;
import com.tencent.mobileqq.vas.theme.ThemeReporter;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ BeaconConfig f78051a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ BeaconReport f78052b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BeaconReport beaconReport, BeaconConfig beaconConfig) {
        this.f78052b = beaconReport;
        this.f78051a = beaconConfig;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            j.a();
            j.g();
            this.f78052b.a(this.f78051a);
            this.f78052b.a();
            c.a("BeaconReport", "App: %s start success!", com.tencent.beacon.a.c.c.c().e());
        } catch (Throwable th5) {
            i.e().a(ThemeReporter.FROM_DIY, "sdk init error! package name: " + com.tencent.beacon.a.c.b.b() + " , msg:" + th5.getMessage(), th5);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("BeaconReport init error: ");
            sb5.append(th5.getMessage());
            c.b(sb5.toString(), new Object[0]);
            c.a(th5);
        }
    }
}
