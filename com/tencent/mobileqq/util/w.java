package com.tencent.mobileqq.util;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.immersive.ImmersiveUtils;

/* compiled from: P */
/* loaded from: classes20.dex */
public class w {
    public static void a(Activity activity, View view) {
        Window window;
        if (activity != null && view != null && (window = activity.getWindow()) != null) {
            boolean z16 = true;
            if (Build.VERSION.SDK_INT >= 28) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.layoutInDisplayCutoutMode = 1;
                window.setAttributes(attributes);
            } else if (!LiuHaiUtils.hasNotchInScreen_AndroidO(activity)) {
                z16 = false;
            }
            if (z16) {
                View decorView = window.getDecorView();
                if (decorView != null) {
                    decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 1024);
                }
                view.setPadding(0, ImmersiveUtils.getStatusBarHeight(activity), 0, 0);
            }
        }
    }
}
