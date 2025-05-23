package com.huawei.hms.activity.internal;

import android.app.Activity;
import android.content.Intent;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface BusResponseCallback {
    BusResponseResult innerError(Activity activity, int i3, String str);

    BusResponseResult succeedReturn(Activity activity, int i3, Intent intent);
}
