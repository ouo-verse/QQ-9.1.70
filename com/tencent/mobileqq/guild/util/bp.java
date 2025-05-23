package com.tencent.mobileqq.guild.util;

import android.R;
import android.app.Activity;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.View;

/* compiled from: P */
/* loaded from: classes14.dex */
public class bp {
    public static int a(Activity activity) {
        if (activity == null) {
            return 0;
        }
        Display defaultDisplay = activity.getWindow().getWindowManager().getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getRealSize(point);
        View decorView = activity.getWindow().getDecorView();
        if (2 == activity.getResources().getConfiguration().orientation) {
            return Math.abs(point.x - decorView.findViewById(R.id.content).getWidth());
        }
        Rect rect = new Rect();
        decorView.getWindowVisibleDisplayFrame(rect);
        return Math.abs(rect.bottom - point.y);
    }
}
