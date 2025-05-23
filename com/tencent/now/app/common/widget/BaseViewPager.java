package com.tencent.now.app.common.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import androidx.viewpager.widget.ViewPager;
import com.tencent.component.core.log.LogUtil;
import java.lang.reflect.Field;

/* loaded from: classes22.dex */
public class BaseViewPager extends ViewPager {

    /* renamed from: d, reason: collision with root package name */
    private static final Interpolator f337902d = new a();

    /* loaded from: classes22.dex */
    class a implements Interpolator {
        a() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f16) {
            float f17 = f16 - 1.0f;
            return (f17 * f17 * f17 * f17 * f17) + 1.0f;
        }
    }

    public BaseViewPager(Context context) {
        super(context);
        b();
    }

    private boolean a(Object obj) {
        boolean z16;
        boolean z17;
        Object obj2;
        boolean z18 = false;
        try {
            Field[] declaredFields = Scroller.class.getDeclaredFields();
            int length = declaredFields.length;
            int i3 = 0;
            while (true) {
                z16 = true;
                if (i3 < length) {
                    Field field = declaredFields[i3];
                    if (!field.isAccessible()) {
                        field.setAccessible(true);
                    }
                    if (TextUtils.equals(field.getName(), "mPerf")) {
                        z17 = true;
                        break;
                    }
                    i3++;
                } else {
                    z17 = false;
                    break;
                }
            }
            if (!z17) {
                LogUtil.w("BaseViewPager", "Scroller\u4e2d\u6ca1\u6709mPerf\u5b57\u6bb5!!", new Object[0]);
                return false;
            }
            Field declaredField = Scroller.class.getDeclaredField("mPerf");
            boolean isAccessible = declaredField.isAccessible();
            if (!isAccessible) {
                declaredField.setAccessible(true);
            }
            if ("android.widget.Scroller".compareToIgnoreCase(obj.getClass().getName()) != 0 || (obj2 = declaredField.get(obj)) == null || "org.codeaurora.Performance".compareToIgnoreCase(obj2.getClass().getName()) != 0) {
                z16 = false;
            }
            if (!isAccessible) {
                try {
                    declaredField.setAccessible(false);
                    return z16;
                } catch (Exception e16) {
                    e = e16;
                    z18 = z16;
                    LogUtil.printStackTrace(e);
                    return z18;
                }
            }
            return z16;
        } catch (Exception e17) {
            e = e17;
        }
    }

    private void b() {
        try {
            Field declaredField = ViewPager.class.getDeclaredField("mScroller");
            boolean isAccessible = declaredField.isAccessible();
            if (!isAccessible) {
                declaredField.setAccessible(true);
            }
            if (a(declaredField.get(this))) {
                LogUtil.i("CycleViewPager", "has performance, just repeat Scroller", new Object[0]);
                declaredField.set(this, new com.tencent.now.app.common.widget.a(getContext(), f337902d));
            }
            if (!isAccessible) {
                declaredField.setAccessible(false);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public BaseViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }
}
