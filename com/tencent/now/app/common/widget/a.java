package com.tencent.now.app.common.widget;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.tencent.component.core.log.LogUtil;
import java.lang.reflect.Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a extends Scroller {
    public a(Context context, Interpolator interpolator) {
        this(context, interpolator, context.getApplicationInfo().targetSdkVersion >= 11);
    }

    public a(Context context, Interpolator interpolator, boolean z16) {
        super(context, interpolator, z16);
        try {
            Field declaredField = Scroller.class.getDeclaredField("mPerf");
            boolean isAccessible = declaredField.isAccessible();
            if (!isAccessible) {
                declaredField.setAccessible(true);
            }
            Object obj = declaredField.get(this);
            String name = obj.getClass().getName();
            if ("org.codeaurora.Performance".compareToIgnoreCase(name) == 0) {
                LogUtil.i("MyScroller", "mPerf  = " + obj + ", name is " + name, new Object[0]);
                declaredField.set(this, null);
            }
            if (isAccessible) {
                return;
            }
            declaredField.setAccessible(false);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }
}
