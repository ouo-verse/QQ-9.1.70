package com.tencent.luggage.wxa.l;

import android.content.Context;
import android.graphics.Point;
import android.view.WindowManager;
import com.tencent.luggage.wxa.k.e;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static WindowManager f132759a;

    public static Point a(Context context) {
        Point point = new Point();
        if (context == null) {
            return point;
        }
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealSize(point);
        return point;
    }

    public static int b(Context context) {
        if (f132759a == null) {
            f132759a = (WindowManager) context.getApplicationContext().getSystemService("window");
        }
        WindowManager windowManager = f132759a;
        if (windowManager == null) {
            return 0;
        }
        int rotation = windowManager.getDefaultDisplay().getRotation();
        if (rotation != 1) {
            if (rotation != 2) {
                if (rotation != 3) {
                    return 0;
                }
                return 270;
            }
            return 180;
        }
        return 90;
    }

    public static int a(int i3) {
        return ((i3 - b(e.b().a())) + 360) % 360;
    }
}
