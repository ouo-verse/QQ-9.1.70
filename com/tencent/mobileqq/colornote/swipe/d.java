package com.tencent.mobileqq.colornote.swipe;

import android.content.Context;
import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.WindowManager;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes5.dex */
public class d {

    /* renamed from: c, reason: collision with root package name */
    private static double f201720c = 0.25d;

    /* renamed from: d, reason: collision with root package name */
    private static double f201721d = 0.5d;

    /* renamed from: e, reason: collision with root package name */
    private static float f201722e;

    /* renamed from: f, reason: collision with root package name */
    private static float f201723f;

    /* renamed from: g, reason: collision with root package name */
    private static float f201724g;

    /* renamed from: a, reason: collision with root package name */
    private int f201725a;

    /* renamed from: b, reason: collision with root package name */
    private int f201726b;

    public d(Context context) {
        a(context);
        Resources resources = context.getResources();
        f201722e = resources.getDimensionPixelSize(R.dimen.b7j);
        f201723f = resources.getDimensionPixelSize(R.dimen.b7k);
        f201724g = resources.getDimensionPixelSize(R.dimen.b7i);
    }

    private void a(Context context) {
        try {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            this.f201725a = windowManager.getDefaultDisplay().getWidth();
            this.f201726b = windowManager.getDefaultDisplay().getHeight();
        } catch (Exception e16) {
            QLog.e("TouchStateDetector", 1, e16, new Object[0]);
        }
    }

    public boolean b(MotionEvent motionEvent, Context context) {
        if (c(motionEvent) + 1.0E-8d > 1.0d && motionEvent.getRawX() > this.f201725a - f201723f && motionEvent.getRawY() > (this.f201726b - f201722e) - f201724g) {
            return true;
        }
        return false;
    }

    public double c(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        motionEvent.getRawY();
        double d16 = rawX;
        double d17 = f201720c;
        int i3 = this.f201725a;
        if (d16 <= i3 * d17) {
            return 0.0d;
        }
        double d18 = f201721d;
        if (d16 >= i3 * d18) {
            return 1.0d;
        }
        return (d16 - (i3 * d17)) / ((d18 - d17) * i3);
    }
}
