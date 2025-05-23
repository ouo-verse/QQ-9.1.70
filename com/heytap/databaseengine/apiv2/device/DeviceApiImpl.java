package com.heytap.databaseengine.apiv2.device;

import com.heytap.databaseengine.apiv2.device.game.IGameApi;
import com.heytap.databaseengine.apiv2.device.game.business.GameApiImpl;
import com.heytap.databaseengine.apiv2.device.info.DeviceInfoApiImpl;
import com.heytap.databaseengine.apiv2.device.info.IDeviceInfoApi;

/* compiled from: P */
/* loaded from: classes2.dex */
public class DeviceApiImpl implements IDeviceApi {
    private IDeviceInfoApi mDeviceInfo;
    private IGameApi mGameApi;

    @Override // com.heytap.databaseengine.apiv2.device.IDeviceApi
    public IDeviceInfoApi deviceInfoApi() {
        if (this.mDeviceInfo == null) {
            this.mDeviceInfo = new DeviceInfoApiImpl();
        }
        return this.mDeviceInfo;
    }

    @Override // com.heytap.databaseengine.apiv2.device.IDeviceApi
    public IGameApi gameApi() {
        if (this.mGameApi == null) {
            this.mGameApi = new GameApiImpl();
        }
        return this.mGameApi;
    }
}
