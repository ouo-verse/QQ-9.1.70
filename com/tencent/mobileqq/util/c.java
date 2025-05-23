package com.tencent.mobileqq.util;

import android.annotation.TargetApi;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

/* compiled from: P */
/* loaded from: classes20.dex */
public class c {
    @TargetApi(16)
    public static boolean a(View view, String str) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(16384);
        obtain.setPackageName(view.getContext().getPackageName());
        obtain.setClassName(view.getClass().getName());
        obtain.setSource(view);
        obtain.getText().add(str);
        if (view.getParent() != null) {
            view.getParent().requestSendAccessibilityEvent(view, obtain);
            return true;
        }
        return true;
    }

    @TargetApi(16)
    public static boolean b(View view, String str, String str2, boolean z16) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(4);
        obtain.setPackageName(view.getContext().getPackageName());
        obtain.setSource(view);
        obtain.getText().add(str);
        obtain.setChecked(z16);
        obtain.setClassName(str2);
        if (view.getParent() != null) {
            view.getParent().requestSendAccessibilityEvent(view, obtain);
            return true;
        }
        return true;
    }
}
