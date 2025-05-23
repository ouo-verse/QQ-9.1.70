package cooperation.qqcircle.ipc.action;

import android.os.Bundle;
import com.tencent.hippy.qq.api.IHippyUpdate;
import com.tencent.hippy.qq.api.IUpdateListener;
import com.tencent.mobileqq.qcircle.api.IQCircleIPCApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016\u00a8\u0006\n"}, d2 = {"Lcooperation/qqcircle/ipc/action/PreLoadHippyJsBundleAction;", "Lcooperation/qqcircle/ipc/action/IQCircleIPCAction;", "()V", "doAction", "Leipc/EIPCResult;", "params", "Landroid/os/Bundle;", "callbackId", "", "Companion", "qcircle-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class PreLoadHippyJsBundleAction implements IQCircleIPCAction {

    @NotNull
    private static final String FROM = "qcircle";

    @NotNull
    private static final String TAG = "PreLoadHippyJsBundleAction";

    @Override // cooperation.qqcircle.ipc.action.IQCircleIPCAction
    @Nullable
    public EIPCResult doAction(@NotNull Bundle params, int callbackId) {
        Intrinsics.checkNotNullParameter(params, "params");
        ArrayList<String> stringArrayList = params.getStringArrayList(IQCircleIPCApi.BUNDLE_KEY_HIPPY_JS_BUNDLE_NAME);
        if (stringArrayList != null) {
            Iterator<T> it = stringArrayList.iterator();
            while (it.hasNext()) {
                ((IHippyUpdate) QRoute.api(IHippyUpdate.class)).commonUpdateJsBundle((String) it.next(), "qcircle", new IUpdateListener() { // from class: cooperation.qqcircle.ipc.action.PreLoadHippyJsBundleAction$doAction$1$1
                    @Override // com.tencent.hippy.qq.api.IUpdateListener
                    public void onUpdateFailed(int requestId, int retCode, @Nullable String errMsg, @Nullable String bundleName, @Nullable HashMap<String, String> updateJSCosts) {
                        QLog.i("PreLoadHippyJsBundleAction", 1, "preload hippy js bundle success, request id : " + requestId + ", bundle name : " + bundleName + ", retCode:" + retCode + ",errMsg:" + errMsg);
                    }

                    @Override // com.tencent.hippy.qq.api.IUpdateListener
                    public void onUpdateSuccess(int requestId, @Nullable String bundleName, @Nullable HashMap<String, String> updateJSCosts) {
                        QLog.i("PreLoadHippyJsBundleAction", 1, "preload hippy js bundle success, request id : " + requestId + " , bundle name : " + bundleName);
                    }
                });
            }
            return null;
        }
        return null;
    }
}
