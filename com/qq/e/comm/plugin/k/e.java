package com.qq.e.comm.plugin.k;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import com.qq.e.comm.util.GDTLogger;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class e {

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface a {
        void b(View view, boolean z16);
    }

    public static void a(View view, final boolean z16, final a aVar) {
        if (view == null) {
            return;
        }
        GDTLogger.d("ab shield click ?" + z16);
        view.setAccessibilityDelegate(new View.AccessibilityDelegate() { // from class: com.qq.e.comm.plugin.k.e.1

            /* renamed from: a, reason: collision with root package name */
            boolean f39657a = false;

            @Override // android.view.View.AccessibilityDelegate
            public void onInitializeAccessibilityNodeInfo(View view2, AccessibilityNodeInfo accessibilityNodeInfo) {
                Context context;
                if (z16) {
                    if (view2 != null) {
                        try {
                            context = view2.getContext();
                        } catch (Throwable th5) {
                            GDTLogger.e(th5.getMessage());
                        }
                    } else {
                        context = null;
                    }
                    if (context == null) {
                        return;
                    }
                    AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
                    if (accessibilityManager != null && !accessibilityManager.isTouchExplorationEnabled()) {
                        GDTLogger.d("isTouchExplorationEnabled ");
                        if (accessibilityNodeInfo != null) {
                            accessibilityNodeInfo.setCheckable(false);
                            accessibilityNodeInfo.setBoundsInScreen(new Rect(-1, -1, -1, -1));
                        }
                    }
                }
                super.onInitializeAccessibilityNodeInfo(view2, accessibilityNodeInfo);
            }

            @Override // android.view.View.AccessibilityDelegate
            public boolean performAccessibilityAction(View view2, int i3, Bundle bundle) {
                if (16 == i3 || 32 == i3) {
                    if (!this.f39657a) {
                        this.f39657a = true;
                        a aVar2 = aVar;
                        if (aVar2 != null) {
                            aVar2.b(view2, z16);
                        }
                    }
                    if (z16) {
                        GDTLogger.d("AccessibilityInjector shield");
                        return true;
                    }
                }
                return super.performAccessibilityAction(view2, i3, bundle);
            }

            @Override // android.view.View.AccessibilityDelegate
            public void sendAccessibilityEvent(View view2, int i3) {
                super.sendAccessibilityEvent(view2, i3);
            }
        });
    }
}
