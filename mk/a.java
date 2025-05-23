package mk;

import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.mobileqq.zplan.lite.IZPlanFilamentSwitch;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0006"}, d2 = {"Lmk/a;", "", "", "a", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f416872a = new a();

    a() {
    }

    public final boolean a() {
        if (!((IZPlanFilamentSwitch) QRoute.api(IZPlanFilamentSwitch.class)).enableZPlanFilamentBase()) {
            QLog.e("QZIntimateLoveTreeUtil", RFWLog.USR, "enableFilament: false");
            return false;
        }
        ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity("exp_qzone_intimate_space_love_tree_v1");
        Intrinsics.checkNotNullExpressionValue(expEntity, "getInstance().getExpEnti\u2026mate_space_love_tree_v1\")");
        expEntity.reportExpExposure();
        boolean isExperiment = expEntity.isExperiment();
        if (!isExperiment) {
            QLog.e("QZIntimateLoveTreeUtil", RFWLog.USR, "isExperiment: false");
        }
        return isExperiment;
    }
}
