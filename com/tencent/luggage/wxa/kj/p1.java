package com.tencent.luggage.wxa.kj;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import androidx.core.content.ContextCompat;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class p1 {
    public static void a(c0 c0Var, ViewGroup viewGroup) {
        AccessibilityManager accessibilityManager;
        if (com.tencent.luggage.wxa.tn.e.f141559a && TextUtils.isEmpty(viewGroup.getContentDescription()) && (accessibilityManager = (AccessibilityManager) ContextCompat.getSystemService(com.tencent.luggage.wxa.tn.z.c(), AccessibilityManager.class)) != null && !accessibilityManager.isTouchExplorationEnabled()) {
            viewGroup.setContentDescription("ScreenCanvasContainer");
        }
        View c16 = c0Var.c();
        if (c16.getParent() instanceof ViewGroup) {
            ViewGroup viewGroup2 = (ViewGroup) c16.getParent();
            for (int childCount = viewGroup2.getChildCount() - 1; childCount >= 0; childCount--) {
                if (viewGroup2.getChildAt(childCount) == c16) {
                    viewGroup2.addView(viewGroup, childCount, new ViewGroup.LayoutParams(-1, -1));
                    return;
                }
            }
        }
    }
}
