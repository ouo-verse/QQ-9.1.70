package oc2;

import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.v;
import com.tencent.qqnt.kernel.nativeinterface.RegisterRes;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import mqq.app.BuiltInServlet;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\r"}, d2 = {"Loc2/a;", "Lcom/tencent/qqnt/kernel/api/v;", "", "result", "", "errMsg", "Lcom/tencent/qqnt/kernel/nativeinterface/RegisterRes;", "registerRes", "", "onUserOnlineResult", "<init>", "()V", "a", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class a implements v {
    @Override // com.tencent.qqnt.kernel.api.v
    public void onUserOnlineResult(int result, @Nullable String errMsg, @Nullable RegisterRes registerRes) {
        QLog.d("MSFOnlineRegisterListener", 1, "onUserOnlineResult result: " + result + " errMsg: " + errMsg + " registerRes: " + registerRes);
        if (result == 0 && registerRes != null) {
            long j3 = registerRes.serverTime;
            if (j3 <= 0) {
                QLog.d("MSFOnlineRegisterListener", 1, "return for serverTime=" + j3);
                return;
            }
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null) {
                return;
            }
            try {
                NewIntent newIntent = new NewIntent(MobileQQ.sMobileQQ.getApplicationContext(), BuiltInServlet.class);
                newIntent.putExtra("action", Constants.Action.ACTION_NOTIFY_MSF_ONLINE_REGISTER);
                newIntent.putExtra(BaseConstants.ATTRIBUTE_KEY_SERVER_TIME, registerRes.serverTime);
                peekAppRuntime.startServlet(newIntent);
            } catch (Exception e16) {
                QLog.e("MSFOnlineRegisterListener", 1, "[onUserOnlineResult] notify MSF error, ", e16);
            }
        }
    }
}
