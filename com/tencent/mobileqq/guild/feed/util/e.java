package com.tencent.mobileqq.guild.feed.util;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Size;
import android.view.WindowManager;

/* compiled from: P */
/* loaded from: classes13.dex */
public class e {
    public static int a(Context context, float f16) {
        return (int) ((f16 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static Size b(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return new Size(displayMetrics.widthPixels, displayMetrics.heightPixels);
    }
}
