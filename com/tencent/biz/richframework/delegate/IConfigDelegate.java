package com.tencent.biz.richframework.delegate;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes5.dex */
public interface IConfigDelegate {
    float getConfigValue(@NonNull String str, float f16);

    int getConfigValue(@NonNull String str, int i3);

    long getConfigValue(@NonNull String str, long j3);

    @Nullable
    String getConfigValue(@NonNull String str, @Nullable String str2);

    boolean getConfigValue(@NonNull String str, @NonNull String str2, boolean z16);

    boolean getConfigValue(@NonNull String str, boolean z16);
}
