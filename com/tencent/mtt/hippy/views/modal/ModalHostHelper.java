package com.tencent.mtt.hippy.views.modal;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;

/* compiled from: P */
/* loaded from: classes20.dex */
class ModalHostHelper {
    private static final Point MIN_POINT = new Point();
    private static final Point MAX_POINT = new Point();
    private static final Point SIZE_POINT = new Point();

    ModalHostHelper() {
    }

    @TargetApi(16)
    public static Point getModalHostSize(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = MIN_POINT;
        Point point2 = MAX_POINT;
        defaultDisplay.getCurrentSizeRange(point, point2);
        Point point3 = SIZE_POINT;
        defaultDisplay.getSize(point3);
        if (point3.x < point3.y) {
            return new Point(point.x, point2.y);
        }
        return new Point(point2.x, point.y);
    }
}
