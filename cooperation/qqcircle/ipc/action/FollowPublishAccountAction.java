package cooperation.qqcircle.ipc.action;

import android.os.Bundle;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qcircle.api.IQCircleIPCApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.ipc.QCircleIPCModule;
import eipc.EIPCResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016\u00a8\u0006\n"}, d2 = {"Lcooperation/qqcircle/ipc/action/FollowPublishAccountAction;", "Lcooperation/qqcircle/ipc/action/IQCircleIPCAction;", "()V", "doAction", "Leipc/EIPCResult;", "params", "Landroid/os/Bundle;", "callbackId", "", "Companion", "qcircle-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class FollowPublishAccountAction implements IQCircleIPCAction {

    @NotNull
    private static final String FROM = "qcircle";

    @NotNull
    private static final String TAG = " FollowPublishAccountAction";

    @Override // cooperation.qqcircle.ipc.action.IQCircleIPCAction
    @Nullable
    public EIPCResult doAction(@NotNull Bundle params, int callbackId) {
        boolean z16;
        EIPCResult createResult;
        Intrinsics.checkNotNullParameter(params, "params");
        String string = params.getString(IQCircleIPCApi.BUNDLE_KEY_PUBLISH_ACCOUNT_ACTION_TYPE);
        if (string == null) {
            string = IQCircleIPCApi.BUNDLE_VALUE_PUBLISH_ACCOUNT_ACTION_TYPE_CHECK_IS_FOLLOW;
        }
        String string2 = params.getString(IQCircleIPCApi.BUNDLE_KEY_TARGET_UIN);
        if (string2 != null && string2.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        EIPCResult eIPCResult = null;
        if (!z16) {
            QLog.d(TAG, 1, "[doAction],actionType:" + string + ", target uin:" + string2);
            AppRuntime appRuntime = MobileQQ.sMobileQQ.peekAppRuntime().getAppRuntime("peak");
            Intrinsics.checkNotNull(appRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
            AppInterface appInterface = (AppInterface) appRuntime;
            if (Intrinsics.areEqual(string, IQCircleIPCApi.BUNDLE_VALUE_PUBLISH_ACCOUNT_ACTION_TYPE_CHECK_IS_FOLLOW)) {
                if (((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).isFollowUin(appInterface, string2)) {
                    params.putString(IQCircleIPCApi.BUNDLE_KEY_PUBLISH_ACCOUNT_IS_FOLLOW, "1");
                } else {
                    params.putString(IQCircleIPCApi.BUNDLE_KEY_PUBLISH_ACCOUNT_IS_FOLLOW, "0");
                }
                createResult = EIPCResult.createSuccessResult(params);
            } else if (Intrinsics.areEqual(string, IQCircleIPCApi.BUNDLE_VALUE_PUBLISH_ACCOUNT_ACTION_TYPE_DO_FOLLOW)) {
                ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).followUin(appInterface, MobileQQ.sMobileQQ.getApplicationContext(), string2, null);
                createResult = EIPCResult.createSuccessResult(params);
            } else {
                QLog.e(TAG, 1, "invalid action type:" + string);
                createResult = EIPCResult.createResult(-2, params);
            }
            eIPCResult = createResult;
        }
        QCircleIPCModule.getInstance().callbackResult(callbackId, eIPCResult);
        return eIPCResult;
    }
}
