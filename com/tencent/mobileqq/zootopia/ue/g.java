package com.tencent.mobileqq.zootopia.ue;

import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zootopia.lua.ar;
import com.tencent.mobileqq.zootopia.ue.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\u0002H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/zootopia/ue/g;", "Lcom/tencent/mobileqq/zootopia/ue/c;", "", "a", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/zootopia/ue/d;", DownloadInfo.spKey_Config, "u9", "destroy", "engineFirstFrame", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class g implements c {
    private final void a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", 2);
        ar.f328509a.a("N2L_SetRecordAvatarImageType", jSONObject.toString());
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void engineDestroy() {
        c.a.a(this);
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void engineFirstFrame() {
        c.a.b(this);
        a();
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void engineInitFinish(boolean z16) {
        c.a.c(this, z16);
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void engineInversePurged() {
        c.a.d(this);
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void enginePurged() {
        c.a.e(this);
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void enginePurging() {
        c.a.f(this);
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void engineSuspended() {
        c.a.g(this);
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void hotPatchDownloadFailed(int i3, String str) {
        c.a.h(this, i3, str);
    }

    @Override // com.tencent.mobileqq.zootopia.ue.c
    public void pause() {
        c.a.i(this);
    }

    @Override // com.tencent.mobileqq.zootopia.ue.c
    public void resume() {
        c.a.j(this);
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void serviceConnected(boolean z16) {
        c.a.k(this, z16);
    }

    @Override // com.tencent.mobileqq.zootopia.ue.c
    public void u9(FragmentActivity activity, d config) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(config, "config");
    }

    @Override // com.tencent.mobileqq.zootopia.ue.c
    public void destroy() {
    }
}
