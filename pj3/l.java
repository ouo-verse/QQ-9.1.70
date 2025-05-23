package pj3;

import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.zplan.utils.bb;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u000f"}, d2 = {"Lpj3/l;", "Ldl0/k;", "Lcom/tencent/mobileqq/qqfeatureswitch/IFeatureRuntimeService;", "e", "", "toggleName", "", "c", "", "default", "d", "a", "b", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class l implements dl0.k {
    private final IFeatureRuntimeService e() {
        AppRuntime d16 = bb.f335811a.d();
        if (d16 != null) {
            return (IFeatureRuntimeService) d16.getRuntimeService(IFeatureRuntimeService.class, "all");
        }
        return null;
    }

    @Override // dl0.k
    public String a(String toggleName) {
        JSONObject jSONObject;
        Intrinsics.checkNotNullParameter(toggleName, "toggleName");
        IFeatureRuntimeService e16 = e();
        String jSONObject2 = (e16 == null || (jSONObject = e16.getJSONObject(toggleName, "")) == null) ? null : jSONObject.toString();
        return jSONObject2 == null ? "" : jSONObject2;
    }

    @Override // dl0.k
    public String b(String toggleName) {
        Intrinsics.checkNotNullParameter(toggleName, "toggleName");
        IFeatureRuntimeService e16 = e();
        String string = e16 != null ? e16.getString(toggleName, "") : null;
        return string == null ? "" : string;
    }

    @Override // dl0.k
    public boolean c(String toggleName) {
        Intrinsics.checkNotNullParameter(toggleName, "toggleName");
        IFeatureRuntimeService e16 = e();
        if (e16 != null) {
            return e16.isFeatureSwitchEnable(toggleName, false);
        }
        return false;
    }

    @Override // dl0.k
    public int d(String toggleName, int r36) {
        Intrinsics.checkNotNullParameter(toggleName, "toggleName");
        IFeatureRuntimeService e16 = e();
        return e16 != null ? e16.getInt(toggleName, r36) : r36;
    }
}
