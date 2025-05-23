package com.huawei.hms.opendevice;

import com.huawei.hmf.tasks.Task;
import com.huawei.hms.support.api.opendevice.OdidResult;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface OpenDeviceClient {
    Task<OdidResult> getOdid();
}
