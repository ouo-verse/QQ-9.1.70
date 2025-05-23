package com.huawei.hms.hwid;

import android.content.Context;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.BaseHmsClient;
import com.huawei.hms.common.internal.ClientSettings;
import com.huawei.hms.support.account.request.AccountAuthParams;

/* compiled from: P */
/* loaded from: classes2.dex */
public class d extends AbstractClientBuilder<c, AccountAuthParams> {
    @Override // com.huawei.hms.common.internal.AbstractClientBuilder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public c buildClient(Context context, ClientSettings clientSettings, BaseHmsClient.OnConnectionFailedListener onConnectionFailedListener, BaseHmsClient.ConnectionCallbacks connectionCallbacks) {
        return new c(context, clientSettings, onConnectionFailedListener, connectionCallbacks);
    }
}
