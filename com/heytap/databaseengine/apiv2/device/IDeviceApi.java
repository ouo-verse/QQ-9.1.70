package com.heytap.databaseengine.apiv2.device;

import com.heytap.databaseengine.apiv2.device.game.IGameApi;
import com.heytap.databaseengine.apiv2.device.info.IDeviceInfoApi;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface IDeviceApi {
    IDeviceInfoApi deviceInfoApi();

    IGameApi gameApi();
}
