package com.tencent.bypass.nativeinterface;

import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes5.dex */
public interface IGlobalAdapter {
    public static final int DEBUG_LEVEL = 0;
    public static final int ERROR_LEVEL = 3;
    public static final int INFO_LEVEL = 1;
    public static final int WARN_LEVEL = 2;

    void onLog(int i3, @NonNull String str);
}
