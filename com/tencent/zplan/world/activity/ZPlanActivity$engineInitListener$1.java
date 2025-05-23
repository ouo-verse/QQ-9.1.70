package com.tencent.zplan.world.activity;

import android.os.Handler;
import android.widget.FrameLayout;
import com.epicgames.ue4.GameActivityThunk;
import com.tencent.zplan.utils.ZLog;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/zplan/world/activity/ZPlanActivity$engineInitListener$1", "Lcom/epicgames/ue4/GameActivityThunk$CMShowEngineInitFinishListener;", "onEngineInitFinish", "", "success", "", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class ZPlanActivity$engineInitListener$1 implements GameActivityThunk.CMShowEngineInitFinishListener {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ ZPlanActivity f386232d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ZPlanActivity$engineInitListener$1(ZPlanActivity zPlanActivity) {
        this.f386232d = zPlanActivity;
    }

    @Override // com.epicgames.ue4.GameActivityThunk.CMShowEngineInitFinishListener
    public void onEngineInitFinish(boolean success) {
        boolean z16;
        boolean z17;
        Handler handler;
        if (success) {
            ZLog zLog = ZLog.f386189b;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onEngineInitFinish renderDestroy is ");
            z16 = this.f386232d.renderDestroy;
            sb5.append(z16);
            zLog.k("ZPlanActivity", sb5.toString());
            z17 = this.f386232d.renderDestroy;
            if (!z17) {
                handler = this.f386232d.uiHandler;
                handler.post(new Runnable() { // from class: com.tencent.zplan.world.activity.ZPlanActivity$engineInitListener$1$onEngineInitFinish$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        FrameLayout frameLayout;
                        frameLayout = ZPlanActivity$engineInitListener$1.this.f386232d.com.tencent.ams.mosaic.MosaicConstants$JsProperty.PROP_ROOT_VIEW java.lang.String;
                        if (frameLayout != null) {
                            ZPlanActivity$engineInitListener$1.this.f386232d.L2(frameLayout);
                        }
                    }
                });
            }
        }
    }
}
