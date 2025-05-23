package com.tencent.zplan.activity;

import com.epicgames.ue4.GameActivityThunk;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/zplan/activity/ZPlanStoreActivityByView$initListener$1", "Lcom/epicgames/ue4/GameActivityThunk$CMShowEngineInitFinishListener;", "onEngineInitFinish", "", "success", "", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class ZPlanStoreActivityByView$initListener$1 implements GameActivityThunk.CMShowEngineInitFinishListener {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ ZPlanStoreActivityByView f385228d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ZPlanStoreActivityByView$initListener$1(ZPlanStoreActivityByView zPlanStoreActivityByView) {
        this.f385228d = zPlanStoreActivityByView;
    }

    @Override // com.epicgames.ue4.GameActivityThunk.CMShowEngineInitFinishListener
    public void onEngineInitFinish(boolean success) {
        this.f385228d.isEngineInited = success;
        this.f385228d.runOnUiThread(new Runnable() { // from class: com.tencent.zplan.activity.ZPlanStoreActivityByView$initListener$1$onEngineInitFinish$1
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanStoreActivityByView$initListener$1.this.f385228d.I2();
            }
        });
    }
}
