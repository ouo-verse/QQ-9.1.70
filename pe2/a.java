package pe2;

import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.qqlive.tvkplayer.tools.config.ITVKConfigRequester;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vf0.ECTabExpEntityInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lpe2/a;", "", "", ITVKConfigRequester.ConfigRequestListener.EXTRA_KEY_EXP_NAME, "Lvf0/a;", "a", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f426057a = new a();

    a() {
    }

    public final ECTabExpEntityInfo a(String expName) {
        Intrinsics.checkNotNullParameter(expName, "expName");
        ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity(expName);
        Intrinsics.checkNotNullExpressionValue(expEntity, "getInstance().getExpEntity(expName)");
        expEntity.reportExpExposure();
        String expName2 = expEntity.getExpName();
        Intrinsics.checkNotNullExpressionValue(expName2, "expEntityInfo.expName");
        String assignment = expEntity.getAssignment();
        Intrinsics.checkNotNullExpressionValue(assignment, "expEntityInfo.assignment");
        String grayId = expEntity.getGrayId();
        Intrinsics.checkNotNullExpressionValue(grayId, "expEntityInfo.grayId");
        Map<String, String> tabParams = expEntity.getTabParams();
        Intrinsics.checkNotNullExpressionValue(tabParams, "expEntityInfo.tabParams");
        return new ECTabExpEntityInfo(null, expName2, null, assignment, grayId, tabParams, 5, null);
    }
}
