package com.tencent.ad.tangram.process;

import android.support.annotation.NonNull;
import com.tencent.ad.tangram.annotation.AdKeep;

@AdKeep
/* loaded from: classes3.dex */
public interface AdProcessManagerAdapter {
    @NonNull
    String getMainProcessName();

    @NonNull
    String getWebProcessName();

    @NonNull
    Boolean isOnMainProcess();

    @NonNull
    Boolean isOnWebProcess();

    @NonNull
    Boolean isWebProcessRunning();

    @NonNull
    Boolean isWebProcessRunningForPreloading();
}
