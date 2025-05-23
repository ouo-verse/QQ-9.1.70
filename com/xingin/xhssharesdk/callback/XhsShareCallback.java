package com.xingin.xhssharesdk.callback;

import androidx.annotation.Keep;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: P */
@Keep
/* loaded from: classes28.dex */
public interface XhsShareCallback {
    @MainThread
    @Deprecated
    void onError(@NonNull String str, int i3, @NonNull String str2, @Nullable Throwable th5);

    @MainThread
    void onError2(@NonNull String str, int i3, @Deprecated int i16, @NonNull String str2, @Nullable Throwable th5);

    @MainThread
    void onSuccess(String str);
}
