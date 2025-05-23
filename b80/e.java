package b80;

import com.tencent.mobileqq.qcircle.api.IQCircleABTestApi;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u0006\u0010\u0002\u001a\u00020\u0000\u00a8\u0006\u0003"}, d2 = {"", "b", "a", "qcircle-plugin-module_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class e {
    public static final boolean a() {
        return ((IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class)).isExpHit("exp_xsj_fabuqi_caogaotanchuangyouhua", "exp_xsj_fabuqi_caogaotanchuangyouhua_C");
    }

    public static final boolean b() {
        return ((IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class)).isExpHit("exp_xsj_fabuqi_caogaotanchuangyouhua", "exp_xsj_fabuqi_caogaotanchuangyouhua_B");
    }
}
