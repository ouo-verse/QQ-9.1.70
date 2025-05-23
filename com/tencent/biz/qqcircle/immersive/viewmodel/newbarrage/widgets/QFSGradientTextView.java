package com.tencent.biz.qqcircle.immersive.viewmodel.newbarrage.widgets;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes4.dex */
public class QFSGradientTextView extends TextView {
    public QFSGradientTextView(Context context) {
        this(context, null);
    }

    public void a() {
        TextPaint paint = getPaint();
        CharSequence text = getText();
        if (paint != null && text != null) {
            paint.setShader(null);
            invalidate();
        }
    }

    public void setGradient(float f16, float f17, float f18, float f19, int i3, int i16) {
        TextPaint paint = getPaint();
        CharSequence text = getText();
        if (paint != null && text != null) {
            paint.setShader(new LinearGradient(f16, f17, f18, f19, i3, i16, Shader.TileMode.CLAMP));
            invalidate();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
        super.setVisibility(i3);
        QLog.d("QFSGradientTextView", 1, "[setVisibility] visibility: " + i3);
    }

    public QFSGradientTextView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QFSGradientTextView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
