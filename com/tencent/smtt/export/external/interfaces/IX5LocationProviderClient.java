package com.tencent.smtt.export.external.interfaces;

import android.location.Location;
import android.os.Bundle;
import android.webkit.ValueCallback;

/* loaded from: classes22.dex */
public interface IX5LocationProviderClient {
    void onGeolocationStartUpdating(ValueCallback<Location> valueCallback, ValueCallback<Bundle> valueCallback2, boolean z16);

    void onGeolocationStopUpdating();
}
