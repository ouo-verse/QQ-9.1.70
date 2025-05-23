package com.huawei.hms.opendevice;

import android.content.Context;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.support.api.entity.opendevice.HuaweiOpendeviceNaming;
import com.huawei.hms.support.api.opendevice.OdidResult;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;
import com.huawei.hms.utils.JsonUtil;

/* compiled from: P */
/* loaded from: classes2.dex */
public class OpenDeviceClientImpl extends HuaweiApi<OpenDeviceOptions> implements OpenDeviceClient {

    /* renamed from: a, reason: collision with root package name */
    public static final OpenDeviceHmsClientBuilder f37334a = new OpenDeviceHmsClientBuilder();

    /* renamed from: b, reason: collision with root package name */
    public static final Api<OpenDeviceOptions> f37335b = new Api<>(HuaweiApiAvailability.HMS_API_NAME_OD);

    /* renamed from: c, reason: collision with root package name */
    public static OpenDeviceOptions f37336c = new OpenDeviceOptions();

    public OpenDeviceClientImpl(Context context) {
        super(context, f37335b, f37336c, f37334a);
        super.setKitSdkVersion(60300305);
    }

    @Override // com.huawei.hms.opendevice.OpenDeviceClient
    public Task<OdidResult> getOdid() {
        return doWrite(new OpenDeviceTaskApiCall(HuaweiOpendeviceNaming.getOdid, JsonUtil.createJsonString(null), HiAnalyticsClient.reportEntry(getContext(), HuaweiOpendeviceNaming.getOdid, 60300305)));
    }
}
