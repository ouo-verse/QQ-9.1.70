package com.huawei.hms.health;

import android.content.Context;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.BaseHmsClient;
import com.huawei.hms.common.internal.ClientSettings;

/* compiled from: P */
/* loaded from: classes2.dex */
public class aabi extends AbstractClientBuilder<aabh, aabl> {
    @Override // com.huawei.hms.common.internal.AbstractClientBuilder
    public aabh buildClient(Context context, ClientSettings clientSettings, BaseHmsClient.OnConnectionFailedListener onConnectionFailedListener, BaseHmsClient.ConnectionCallbacks connectionCallbacks) {
        aabz.aabb("ClientBuilder", "HealthHmsClientBluilder : buildClient");
        return new aabh(context, clientSettings, onConnectionFailedListener, connectionCallbacks);
    }
}
