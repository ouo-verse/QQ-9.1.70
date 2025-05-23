package com.qzone.commoncode.module.gdt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes39.dex */
class GdtVideoPCDNManagerForQZone$1 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ List f46192d;
    final /* synthetic */ c this$0;

    @Override // java.lang.Runnable
    public void run() {
        HashMap f16;
        f16 = c.f(new ArrayList(this.f46192d));
        if (f16 != null) {
            this.this$0.f46206a = f16;
        }
    }
}
