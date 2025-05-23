package com.tencent.gamematrix.gmcg.api;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.tencent.gamematrix.gmcg.api.model.GmCgAllocateDeviceInfo;

/* loaded from: classes6.dex */
public interface GmCgPlayAllocatorListener {
    @MainThread
    void onGmCgAllocatorError(@NonNull GmCgError gmCgError);

    @MainThread
    void onGmCgAllocatorUpdate(int i3, boolean z16, GmCgAllocateDeviceInfo gmCgAllocateDeviceInfo);
}
