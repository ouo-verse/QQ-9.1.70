package com.qzone.reborn.util;

import android.view.ViewConfiguration;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes37.dex */
public class p {
    public static boolean a(float f16, float f17, float f18, float f19) {
        if (BaseApplication.getContext() != null && ViewConfiguration.get(BaseApplication.getContext()) != null) {
            int scaledTouchSlop = ViewConfiguration.get(BaseApplication.getContext()).getScaledTouchSlop();
            float abs = Math.abs(f16 - f18);
            float f26 = scaledTouchSlop;
            if (abs <= f26 && Math.abs(f17 - f19) <= f26) {
                return false;
            }
        }
        return true;
    }

    public static boolean b(float f16, float f17, float f18, float f19) {
        if (BaseApplication.getContext() == null || ViewConfiguration.get(BaseApplication.getContext()) == null) {
            return false;
        }
        int scaledTouchSlop = ViewConfiguration.get(BaseApplication.getContext()).getScaledTouchSlop();
        float abs = Math.abs(f16 - f18);
        return Math.abs(abs) > ((float) (scaledTouchSlop * 2)) && Math.abs(Math.abs(f17 - f19) / abs) < 0.5f;
    }
}
