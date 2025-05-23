package com.huawei.hms.opendevice;

import android.content.Context;
import com.huawei.hms.utils.Checker;

/* compiled from: P */
/* loaded from: classes2.dex */
public class OpenDevice {
    public static OpenDeviceClient getOpenDeviceClient(Context context) {
        Checker.assertNonNull(context);
        return new OpenDeviceClientImpl(context);
    }
}
