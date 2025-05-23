package com.tencent.luggage.wxaapi;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes9.dex */
public interface a {
    void debugXWeb(@NonNull Context context, int i3);

    void deleteLibFile();

    @NonNull
    String getDebugIP();

    boolean getIsDebugIP();

    boolean isMultiTaskModeEnabledForWxaApp();

    boolean isRunningWithJSCoverageCollect();

    long launchByQRRawData(@Nullable Context context, @NonNull String str, @Nullable d dVar);

    void setDebugIP(@NonNull String str);

    void setIsDebugIP(boolean z16);

    void setIsRunningWithJSCoverageCollect(boolean z16);

    void setMultiTaskModeEnabledForWxaApp(boolean z16);

    void testIlinkProcessRecreate();
}
