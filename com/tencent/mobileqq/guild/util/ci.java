package com.tencent.mobileqq.guild.util;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes14.dex */
public class ci {
    public static void a(@NonNull View view, int i3) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams.height != i3) {
            layoutParams.height = i3;
            view.requestLayout();
        }
    }
}
