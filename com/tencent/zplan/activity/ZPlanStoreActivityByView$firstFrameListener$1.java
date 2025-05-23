package com.tencent.zplan.activity;

import com.epicgames.ue4.GameActivityThunk;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/zplan/activity/ZPlanStoreActivityByView$firstFrameListener$1", "Lcom/epicgames/ue4/GameActivityThunk$CMShowEngineFirstFrameListener;", "onFirstFrame", "", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class ZPlanStoreActivityByView$firstFrameListener$1 implements GameActivityThunk.CMShowEngineFirstFrameListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ZPlanStoreActivityByView f385227a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ZPlanStoreActivityByView$firstFrameListener$1(ZPlanStoreActivityByView zPlanStoreActivityByView) {
        this.f385227a = zPlanStoreActivityByView;
    }

    @Override // com.epicgames.ue4.GameActivityThunk.CMShowEngineFirstFrameListener
    public void onFirstFrame() {
        this.f385227a.runOnUiThread(new Runnable() { // from class: com.tencent.zplan.activity.ZPlanStoreActivityByView$firstFrameListener$1$onFirstFrame$1
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanStoreActivityByView$firstFrameListener$1.this.f385227a.L2();
            }
        });
    }
}
