package com.tencent.aelight.camera.aioeditor.takevideo.view.widget;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.widget.EdgeEffect;
import android.widget.HorizontalScrollView;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes32.dex */
public class EditVideoScrollView extends HorizontalScrollView {
    public EditVideoScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        try {
            Field declaredField = HorizontalScrollView.class.getDeclaredField("mEdgeGlowLeft");
            Field declaredField2 = HorizontalScrollView.class.getDeclaredField("mEdgeGlowRight");
            declaredField.setAccessible(true);
            declaredField2.setAccessible(true);
            Object obj = declaredField.get(this);
            Object obj2 = declaredField2.get(this);
            Field declaredField3 = EdgeEffect.class.getDeclaredField("mPaint");
            declaredField3.setAccessible(true);
            Object obj3 = declaredField3.get(obj);
            Object obj4 = declaredField3.get(obj2);
            Method method = Paint.class.getMethod("setXfermode", Xfermode.class);
            method.invoke(obj3, new PorterDuffXfermode(PorterDuff.Mode.DST));
            method.invoke(obj4, new PorterDuffXfermode(PorterDuff.Mode.DST));
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    protected float getLeftFadingEdgeStrength() {
        return 0.0f;
    }

    @Override // android.view.View
    protected boolean overScrollBy(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, boolean z16) {
        int i29 = (int) (i3 * 1.0f);
        if (i17 + i3 == 0 || (i17 - i19) + i3 == 0) {
            i29 = i3;
        }
        return super.overScrollBy(i29, i16, i17, i18, i19, i26, 100, i28, z16);
    }
}
