package com.heytap.databaseengine.apiv2.device.info;

import com.heytap.databaseengine.apiv2.HResponse;
import com.heytap.databaseengine.model.proxy.UserDeviceInfoProxy;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface IDeviceInfoApi {
    void queryBoundDevice(HResponse<List<UserDeviceInfoProxy>> hResponse);
}
