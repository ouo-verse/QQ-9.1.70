package com.tencent.biz.qqstory.utils;

import com.tencent.biz.qqstory.utils.h;

/* loaded from: classes5.dex */
class PollWidgetUtils$WidgetWrapper$2 implements Runnable {
    final /* synthetic */ h.g this$0;

    @Override // java.lang.Runnable
    public void run() {
        boolean z16;
        boolean z17;
        h.g gVar = this.this$0;
        z16 = gVar.S;
        gVar.S = !z16;
        h.g gVar2 = this.this$0;
        h.d dVar = gVar2.f94462d;
        z17 = gVar2.S;
        dVar.e(z17);
    }
}
