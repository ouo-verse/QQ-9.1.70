package nc2;

import android.os.Bundle;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.onlinestatus.utils.ae;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.v;
import com.tencent.qqnt.kernel.nativeinterface.RegisterRes;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import mqq.observer.AccountObserver;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\r"}, d2 = {"Lnc2/a;", "Lcom/tencent/qqnt/kernel/api/v;", "", "result", "", "errMsg", "Lcom/tencent/qqnt/kernel/nativeinterface/RegisterRes;", "registerRes", "", "onUserOnlineResult", "<init>", "()V", "a", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class a implements v {
    @Override // com.tencent.qqnt.kernel.api.v
    public void onUserOnlineResult(int result, @Nullable String errMsg, @Nullable RegisterRes registerRes) {
        AppRuntime peekAppRuntime;
        QLog.d("OnlineRegisterCallback", 1, "onUserOnlineResult result: " + result + " errMsg: " + errMsg + " registerRes: " + registerRes);
        if (result != 0 || registerRes == null || (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) == null) {
            return;
        }
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IOnlineStatusService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "runtime.getRuntimeServic\u2026va, ProcessConstant.MAIN)");
        IOnlineStatusService iOnlineStatusService = (IOnlineStatusService) runtimeService;
        AppRuntime.Status b16 = ae.b(registerRes.status);
        long j3 = registerRes.extStatus;
        iOnlineStatusService.setOnlineStatus(b16, "OnlineRegisterCallback onUserOnlineResult");
        iOnlineStatusService.setExtOnlineStatus(j3);
        Bundle bundle = new Bundle();
        bundle.putSerializable("onlineStatus", b16);
        bundle.putLong("extOnlineStatus", j3);
        peekAppRuntime.notifyObservers(AccountObserver.class, Constants.Action.ACTION_ONLINE_STATUS_PUSH, true, bundle);
    }
}
