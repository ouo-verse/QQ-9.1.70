package com.tencent.sqshow.utils.featureswitch.model;

import com.google.gson.annotations.SerializedName;
import com.tencent.ams.dsdk.monitor.metric.event.TagName;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.lite.IZPlanFilamentSwitch;
import com.tencent.zplan.record.model.RenderSwitches;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\"\u0010\u0014\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\f\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/sqshow/utils/featureswitch/model/af;", "", "Lcom/tencent/zplan/record/a;", "scene", "", "b", "a", "Lcom/tencent/zplan/record/model/d;", "d", "c", "Lcom/tencent/sqshow/utils/featureswitch/model/ag;", "engineTypeEnableList", "Lcom/tencent/sqshow/utils/featureswitch/model/ag;", "getEngineTypeEnableList", "()Lcom/tencent/sqshow/utils/featureswitch/model/ag;", "setEngineTypeEnableList", "(Lcom/tencent/sqshow/utils/featureswitch/model/ag;)V", "customAAEnableList", "getCustomAAEnableList", "setCustomAAEnableList", "disableGlassesMetallicList", "getDisableGlassesMetallicList", "setDisableGlassesMetallicList", "<init>", "()V", "superqqshow-base-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class af {

    /* renamed from: b, reason: collision with root package name */
    private static Boolean f369857b;

    @SerializedName(TagName.ENGINE_TYPE)
    private ag engineTypeEnableList = new ag();

    @SerializedName("zplan_record_enableAntiAliasing")
    private ag customAAEnableList = new ag();

    @SerializedName("enable_cancel_glasses_metallic")
    private ag disableGlassesMetallicList = new ag();

    private final boolean a(com.tencent.zplan.record.a scene) {
        return this.disableGlassesMetallicList.a(scene, c(scene));
    }

    private final boolean b(com.tencent.zplan.record.a scene) {
        return this.customAAEnableList.a(scene, c(scene));
    }

    public final boolean c(com.tencent.zplan.record.a scene) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        if (f369857b == null) {
            f369857b = Boolean.valueOf(this.engineTypeEnableList.b().contains(Integer.valueOf(scene.getValue())) && ((IZPlanFilamentSwitch) QRoute.api(IZPlanFilamentSwitch.class)).enableZPlanFilamentBase());
        }
        Boolean bool = f369857b;
        Intrinsics.checkNotNull(bool);
        return bool.booleanValue();
    }

    public final RenderSwitches d(com.tencent.zplan.record.a scene) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        return new RenderSwitches(c(scene), b(scene), a(scene));
    }
}
