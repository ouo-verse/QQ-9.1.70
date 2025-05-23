package cooperation.qqcircle.ipc.action;

import android.os.Bundle;
import com.tencent.mobileqq.qcircle.api.IQCircleIPCApi;
import com.tencent.mobileqq.qqecommerce.biz.sdk.api.IQQECommerceSdk;
import com.tencent.mobileqq.qroute.QRoute;
import cooperation.qqcircle.ipc.QCircleIPCModule;
import eipc.EIPCResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016\u00a8\u0006\n"}, d2 = {"Lcooperation/qqcircle/ipc/action/SchemaJumpToQQECommercePageWithCallBackAction;", "Lcooperation/qqcircle/ipc/action/IQCircleIPCAction;", "()V", "doAction", "Leipc/EIPCResult;", "params", "Landroid/os/Bundle;", "callbackId", "", "Companion", "qcircle-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class SchemaJumpToQQECommercePageWithCallBackAction implements IQCircleIPCAction {

    @NotNull
    private static final String JSON_KEY = "data";

    @Override // cooperation.qqcircle.ipc.action.IQCircleIPCAction
    @Nullable
    public EIPCResult doAction(@NotNull Bundle params, final int callbackId) {
        Intrinsics.checkNotNullParameter(params, "params");
        String string = params.getString(IQCircleIPCApi.BUNDLE_KEY_SCHEMA_TO_EC_PAGE);
        if (string == null) {
            return null;
        }
        ((IQQECommerceSdk) QRoute.api(IQQECommerceSdk.class)).handleScheme(string, new Function1<JSONObject, Unit>() { // from class: cooperation.qqcircle.ipc.action.SchemaJumpToQQECommercePageWithCallBackAction$doAction$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(JSONObject jSONObject) {
                invoke2(jSONObject);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull JSONObject jsonObject) {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                Bundle bundle = new Bundle();
                bundle.putString("data", jsonObject.toString());
                QCircleIPCModule.getInstance().callbackResult(callbackId, EIPCResult.createSuccessResult(bundle));
            }
        });
        return null;
    }
}
