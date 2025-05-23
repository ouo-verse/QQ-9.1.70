package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class Platform implements Serializable {
    public static final int PLATFORM_ANDROID = 2;
    public static final int PLATFORM_INVALID = 0;
    public static final int PLATFORM_IPAD = 3;
    public static final int PLATFORM_IPHONE = 1;
    public static final int PLATFORM_TIM = 4;
    long serialVersionUID = 1;

    public String toString() {
        return "Platform{}";
    }
}
