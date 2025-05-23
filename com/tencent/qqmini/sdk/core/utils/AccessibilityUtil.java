package com.tencent.qqmini.sdk.core.utils;

import android.annotation.TargetApi;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;

/* compiled from: P */
/* loaded from: classes23.dex */
public class AccessibilityUtil {
    public static void changeAccessibilityForView(View view, String str) {
        changeAccessibilityForView(view, null, str);
    }

    @TargetApi(14)
    public static void changeAccessibilityForView(View view, final CharSequence charSequence, final String str) {
        view.setAccessibilityDelegate(new View.AccessibilityDelegate() { // from class: com.tencent.qqmini.sdk.core.utils.AccessibilityUtil.1
            @Override // android.view.View.AccessibilityDelegate
            public void onInitializeAccessibilityNodeInfo(View view2, AccessibilityNodeInfo accessibilityNodeInfo) {
                super.onInitializeAccessibilityNodeInfo(view2, accessibilityNodeInfo);
                CharSequence charSequence2 = charSequence;
                if (charSequence2 != null) {
                    accessibilityNodeInfo.setContentDescription(charSequence2);
                }
                accessibilityNodeInfo.setClassName(str);
            }
        });
    }
}
