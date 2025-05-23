package com.tencent.rmonitor;

import android.app.Activity;
import com.tencent.rmonitor.base.config.g;

/* compiled from: P */
/* loaded from: classes25.dex */
public interface DebugInterface {
    void addConfigUpdaterForDebug(Activity activity, g gVar);

    void refreshConfigForDebug(Activity activity);

    void removeConfigUpdaterForDebug(Activity activity, g gVar);

    void setDebugMode(Activity activity, boolean z16);
}
