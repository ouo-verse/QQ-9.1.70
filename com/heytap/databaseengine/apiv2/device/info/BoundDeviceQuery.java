package com.heytap.databaseengine.apiv2.device.info;

import android.content.pm.PackageManager;
import com.heytap.databaseengine.apiv2.HResponse;
import com.heytap.databaseengine.apiv2.common.HRemoteService;
import com.heytap.databaseengine.apiv2.common.HRunnable;
import com.heytap.databaseengine.apiv2.device.IDeviceInfoManager;
import com.heytap.databaseengine.callback.ICommonListener;
import com.heytap.databaseengine.model.proxy.UserDeviceInfoProxy;
import com.heytap.databaseengine.utils.HLog;
import java.util.List;

/* compiled from: P */
@Deprecated
/* loaded from: classes2.dex */
class BoundDeviceQuery extends HRunnable {
    private static final String TAG = "BoundDeviceQuery";
    private HResponse<List<UserDeviceInfoProxy>> mCallBack;

    public BoundDeviceQuery(HResponse<List<UserDeviceInfoProxy>> hResponse) {
        this.mCallBack = hResponse;
    }

    @Override // com.heytap.databaseengine.apiv2.common.HRunnable
    public void onException(Exception exc) {
        HLog.e(TAG, exc.getMessage());
        if (exc.getClass().isInstance(PackageManager.NameNotFoundException.class)) {
            this.mCallBack.onFailure(100007);
        } else {
            this.mCallBack.onFailure(100003);
        }
    }

    @Override // com.heytap.databaseengine.apiv2.common.HRunnable
    public void realRun() throws Exception {
        ((IDeviceInfoManager) HRemoteService.getInstance().remoteApi(IDeviceInfoManager.class)).getUserBoundDevices(new ICommonListener.Stub() { // from class: com.heytap.databaseengine.apiv2.device.info.BoundDeviceQuery.1
            @Override // com.heytap.databaseengine.callback.ICommonListener
            public void onFailure(int i3, List list) {
                HLog.e(BoundDeviceQuery.TAG, "getUserBoundDevices onFailure: " + list);
                BoundDeviceQuery.this.mCallBack.onFailure(i3);
            }

            @Override // com.heytap.databaseengine.callback.ICommonListener
            public void onSuccess(int i3, List list) {
                HLog.i(BoundDeviceQuery.TAG, "getUserBoundDevices onSuccess: endTime = " + System.currentTimeMillis());
                BoundDeviceQuery.this.mCallBack.onSuccess(list);
            }
        });
    }
}
