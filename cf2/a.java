package cf2;

import com.tencent.ecommerce.base.rmonitor.api.IECRMonitorManager;
import com.tencent.mobileqq.qqperf.api.IPerfApi;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lcf2/a;", "Lcom/tencent/ecommerce/base/rmonitor/api/IECRMonitorManager;", "", "stage", "", "traceStart", "traceEnd", "<init>", "()V", "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class a implements IECRMonitorManager {
    @Override // com.tencent.ecommerce.base.rmonitor.api.IECRMonitorManager
    public void traceEnd(String stage) {
        Intrinsics.checkNotNullParameter(stage, "stage");
        ((IPerfApi) QRoute.api(IPerfApi.class)).traceEnd(stage);
    }

    @Override // com.tencent.ecommerce.base.rmonitor.api.IECRMonitorManager
    public void traceStart(String stage) {
        Intrinsics.checkNotNullParameter(stage, "stage");
        ((IPerfApi) QRoute.api(IPerfApi.class)).traceStart(stage);
    }
}
