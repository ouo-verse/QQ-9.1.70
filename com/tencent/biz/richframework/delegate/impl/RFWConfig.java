package com.tencent.biz.richframework.delegate.impl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.richframework.delegate.IConfigDelegate;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RFWConfig {
    public static volatile IConfigDelegate sIConfigDelegate;

    private static IConfigDelegate getConfigDelegate() {
        if (sIConfigDelegate == null) {
            synchronized (RFWConfig.class) {
                if (sIConfigDelegate == null) {
                    sIConfigDelegate = (IConfigDelegate) RFWDelegate.getDelegate(IConfigDelegate.class);
                }
            }
        }
        return sIConfigDelegate;
    }

    public static int getConfigValue(@NonNull String str, int i3) {
        return getConfigDelegate() != null ? getConfigDelegate().getConfigValue(str, i3) : i3;
    }

    @Nullable
    public static String getConfigValue(@NonNull String str, @Nullable String str2) {
        return getConfigDelegate() != null ? getConfigDelegate().getConfigValue(str, str2) : str2;
    }

    public static boolean getConfigValue(@NonNull String str, boolean z16) {
        return getConfigDelegate() != null ? getConfigDelegate().getConfigValue(str, z16) : z16;
    }

    public static boolean getConfigValue(@NonNull String str, @NonNull String str2, boolean z16) {
        return getConfigDelegate() != null ? getConfigDelegate().getConfigValue(str, str2, z16) : z16;
    }

    public static float getConfigValue(@NonNull String str, float f16) {
        return getConfigDelegate() != null ? getConfigDelegate().getConfigValue(str, f16) : f16;
    }

    public static long getConfigValue(@NonNull String str, long j3) {
        return getConfigDelegate() != null ? getConfigDelegate().getConfigValue(str, j3) : j3;
    }
}
