package cooperation.qwallet.plugin.ipc;

import android.os.Bundle;
import com.qwallet.temp.IQWalletApiProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.IQWalletHelper;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes28.dex */
public class TickReq extends BaseReq {
    public static final int TICK_TYPE_EXIT_QWALLET_TIME = 2;
    public static final int TICK_TYPE_QWALLET_ONRESUME = 4;
    public static final int TICK_TYPE_REDPOINT = 1;
    public static final int TICK_TYPE_SET_BASE_ACTIVITY_UNLOCK_SUCCESS = 3;
    public long exitQWalletTime;
    public String redpointPath;
    public int tickType;

    private void onRedpoint() {
        try {
            AppRuntime runtime = ((IQWalletHelper) QRoute.api(IQWalletHelper.class)).getRuntime();
            if (runtime != null) {
                IRedTouchManager iRedTouchManager = (IRedTouchManager) runtime.getRuntimeService(IRedTouchManager.class, "");
                iRedTouchManager.onRedTouchItemClick(this.redpointPath);
                String str = this.redpointPath;
                if (str == null || !str.equals("100007.102000") || iRedTouchManager.getNumRedPathListByAppId(100007) == null) {
                    return;
                }
                iRedTouchManager.onReportNumRedPoint(100007, this.redpointPath);
            }
        } catch (Exception e16) {
            if (QLog.isDevelopLevel()) {
                QLog.d("Q.qwallet.pay.dc", 4, "onRedpoint:" + e16.getMessage());
            }
        }
    }

    @Override // cooperation.qwallet.plugin.ipc.BaseReq, cooperation.qwallet.plugin.ipc.BaseIpc
    public void fromBundle(Bundle bundle) {
        super.fromBundle(bundle);
        this.tickType = bundle.getInt("_qwallet_ipc_TickReq_tickType");
        this.redpointPath = bundle.getString("_qwallet_ipc_TickReq_redpointPath");
        this.exitQWalletTime = bundle.getLong("_qwallet_ipc_TickReq_exitQWalletTime");
    }

    @Override // cooperation.qwallet.plugin.ipc.BaseReq
    public void onReceive() {
        int i3 = this.tickType;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        ((IQWalletHelper) QRoute.api(IQWalletHelper.class)).resetLaunchTime();
                        return;
                    }
                    return;
                }
                ((IQWalletApiProxy) QRoute.api(IQWalletApiProxy.class)).onSetBaseActivityUnlockSuceess();
                return;
            }
            ((IQWalletApiProxy) QRoute.api(IQWalletApiProxy.class)).setLastExitWalletTime(this.exitQWalletTime, this);
            return;
        }
        onRedpoint();
    }

    @Override // cooperation.qwallet.plugin.ipc.BaseReq, cooperation.qwallet.plugin.ipc.BaseIpc
    public void toBundle(Bundle bundle) {
        super.toBundle(bundle);
        bundle.putInt("_qwallet_ipc_TickReq_tickType", this.tickType);
        bundle.putString("_qwallet_ipc_TickReq_redpointPath", this.redpointPath);
        bundle.putLong("_qwallet_ipc_TickReq_exitQWalletTime", this.exitQWalletTime);
    }
}
