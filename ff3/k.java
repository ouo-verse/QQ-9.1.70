package ff3;

import com.tencent.mobileqq.zplan.avatar.api.hippy.BaseHippyUeActionHandler;
import com.tencent.mobileqq.zplan.avatar.api.hippy.HippyUeActionType;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import l13.ZPlanHippyResult;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB!\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0010"}, d2 = {"Lff3/k;", "Lcom/tencent/mobileqq/zplan/avatar/api/hippy/BaseHippyUeActionHandler;", "", "j", "", "c", "", "actionType", "Lorg/json/JSONObject;", "param", "Lcom/tencent/mtt/hippy/modules/Promise;", "promise", "<init>", "(ILorg/json/JSONObject;Lcom/tencent/mtt/hippy/modules/Promise;)V", "e", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class k extends BaseHippyUeActionHandler {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(@HippyUeActionType int i3, JSONObject param, Promise promise) {
        super(i3, param, promise);
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(promise, "promise");
    }

    @Override // com.tencent.mobileqq.zplan.avatar.api.hippy.BaseHippyUeActionHandler
    public void c() {
        String ueBgPath = getParam().optString("bgPath");
        Intrinsics.checkNotNullExpressionValue(ueBgPath, "ueBgPath");
        if (ueBgPath.length() == 0) {
            i(ZPlanHippyResult.INSTANCE.a("bgPath isEmpty"));
            QLog.e("SetUeBgActionHandler_", 1, "bgPath isEmpty");
            return;
        }
        com.tencent.mobileqq.zplan.avatar.api.hippy.a d16 = d();
        if (d16 == null) {
            h();
        } else {
            d16.f(ueBgPath);
            i(ZPlanHippyResult.Companion.c(ZPlanHippyResult.INSTANCE, null, 1, null));
        }
    }

    @Override // com.tencent.mobileqq.zplan.avatar.api.hippy.BaseHippyUeActionHandler
    public String j() {
        return "SetUeBgActionHandler_";
    }
}
