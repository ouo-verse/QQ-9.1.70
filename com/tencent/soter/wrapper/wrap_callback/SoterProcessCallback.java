package com.tencent.soter.wrapper.wrap_callback;

import android.support.annotation.NonNull;
import com.tencent.soter.wrapper.wrap_callback.SoterProcessResultBase;

/* loaded from: classes25.dex */
public interface SoterProcessCallback<T extends SoterProcessResultBase> {
    void onResult(@NonNull T t16);
}
