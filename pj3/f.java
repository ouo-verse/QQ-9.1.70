package pj3;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004H\u0016\u00a8\u0006\f"}, d2 = {"Lpj3/f;", "Ldl0/e;", "", "key", "", RemoteHandleConst.PARAM_DEFAULT_VALUE, "getInt", "value", "", "setInt", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class f implements dl0.e {
    @Override // dl0.e
    public int getInt(String key, int defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        return ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).getInt(key, defaultValue);
    }

    @Override // dl0.e
    public void setInt(String key, int value) {
        Intrinsics.checkNotNullParameter(key, "key");
        ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).setInt(key, value);
    }
}
