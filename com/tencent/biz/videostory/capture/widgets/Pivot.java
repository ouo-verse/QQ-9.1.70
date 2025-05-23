package com.tencent.biz.videostory.capture.widgets;

import android.view.View;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes5.dex */
public class Pivot {

    /* renamed from: a, reason: collision with root package name */
    private int f97055a;

    /* renamed from: b, reason: collision with root package name */
    private int f97056b;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes5.dex */
    public @interface Axis {
    }

    public Pivot(int i3, int i16) {
        this.f97055a = i3;
        this.f97056b = i16;
    }

    public static Pivot a(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    return new Pivot(0, -1);
                }
                return new Pivot(0, -2);
            }
            return new Pivot(0, -1);
        }
        return new Pivot(0, 0);
    }

    public static Pivot b(int i3) {
        if (i3 != 1) {
            if (i3 != 3) {
                if (i3 != 4) {
                    return new Pivot(1, -1);
                }
                return new Pivot(1, -2);
            }
            return new Pivot(1, 0);
        }
        return new Pivot(1, -1);
    }

    public void c(View view) {
        int i3 = this.f97055a;
        if (i3 == 0) {
            int i16 = this.f97056b;
            if (i16 != -2) {
                if (i16 != -1) {
                    view.setPivotX(i16);
                    return;
                } else {
                    view.setPivotX(view.getWidth() * 0.5f);
                    return;
                }
            }
            view.setPivotX(view.getWidth());
            return;
        }
        if (i3 == 1) {
            int i17 = this.f97056b;
            if (i17 != -2) {
                if (i17 != -1) {
                    view.setPivotY(i17);
                    return;
                } else {
                    view.setPivotY(view.getHeight() * 0.5f);
                    return;
                }
            }
            view.setPivotY(view.getHeight());
        }
    }
}
