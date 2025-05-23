package com.heytap.databaseengine.apiv2.device.info;

import com.heytap.databaseengine.apiv2.HResponse;
import com.heytap.databaseengine.model.proxy.UserDeviceInfoProxy;
import com.heytap.databaseengine.utils.HExecutorService;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class DeviceInfoApiImpl implements IDeviceInfoApi {
    @Override // com.heytap.databaseengine.apiv2.device.info.IDeviceInfoApi
    public void queryBoundDevice(HResponse<List<UserDeviceInfoProxy>> hResponse) {
        HExecutorService.create().execute(new BoundDeviceQuery(hResponse));
    }
}
