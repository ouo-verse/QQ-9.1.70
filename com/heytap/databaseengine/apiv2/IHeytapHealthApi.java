package com.heytap.databaseengine.apiv2;

import com.heytap.databaseengine.apiv2.auth.IAuthorityApi;
import com.heytap.databaseengine.apiv2.device.IDeviceApi;
import com.heytap.databaseengine.apiv2.health.business.ISportHealthApi;
import com.heytap.databaseengine.apiv2.userinfo.IUserInfoApi;
import com.heytap.databaseengine.apiv3.business.IHealthDataApi;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface IHeytapHealthApi {
    IAuthorityApi authorityApi();

    IHealthDataApi dataApi();

    IDeviceApi deviceApi();

    @Deprecated
    ISportHealthApi sportHealthApi();

    IUserInfoApi userInfoApi();
}
