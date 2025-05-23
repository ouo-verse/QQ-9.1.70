package com.tencent.rfw.barrage.core;

import java.util.ArrayList;
import java.util.List;
import tz3.i;

/* compiled from: P */
/* loaded from: classes25.dex */
class RFWBarrageMeasureManager$2 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ List f365018d;
    final /* synthetic */ e this$0;

    @Override // java.lang.Runnable
    public void run() {
        i iVar;
        for (com.tencent.rfw.barrage.data.a aVar : new ArrayList(this.f365018d)) {
            iVar = this.this$0.f365049b;
            e.c(iVar, aVar);
        }
    }
}
