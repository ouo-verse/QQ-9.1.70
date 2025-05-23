package com.tencent.biz.subscribe.part.block;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes5.dex */
class BlockMerger$1 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ MultiViewBlock f96139d;
    final /* synthetic */ a this$0;

    @Override // java.lang.Runnable
    public void run() {
        ArrayList arrayList;
        try {
            this.f96139d.onDetachedFromRecyclerView(this.this$0.a0().g());
            this.this$0.q0(this.f96139d);
            arrayList = ((com.tencent.biz.subscribe.part.block.base.a) this.this$0).f96195d;
            arrayList.remove(this.f96139d);
            this.this$0.f0(this.f96139d, 2);
            this.this$0.notifyDataSetChanged();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }
}
