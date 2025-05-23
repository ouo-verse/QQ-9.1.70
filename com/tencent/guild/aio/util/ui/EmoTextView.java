package com.tencent.guild.aio.util.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Spanned;
import android.text.style.DynamicDrawableSpan;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes6.dex */
public class EmoTextView extends AppCompatTextView {

    /* renamed from: h, reason: collision with root package name */
    private Drawable[] f112418h;

    /* renamed from: i, reason: collision with root package name */
    private Drawable[] f112419i;

    public EmoTextView(@NonNull Context context) {
        super(context);
    }

    private void a(CharSequence charSequence) {
        this.f112418h = null;
        this.f112419i = null;
        if (getText() != charSequence && (getText() instanceof Spanned)) {
            Spanned spanned = (Spanned) getText();
            EmoticonSpan[] emoticonSpanArr = (EmoticonSpan[]) spanned.getSpans(0, spanned.length(), EmoticonSpan.class);
            Drawable[] drawableArr = new Drawable[emoticonSpanArr.length];
            for (int i3 = 0; i3 < emoticonSpanArr.length; i3++) {
                Drawable drawable = emoticonSpanArr[i3].getDrawable();
                drawableArr[i3] = drawable;
                if (drawable != null) {
                    drawable.setCallback(this);
                }
            }
            this.f112418h = drawableArr;
            DynamicDrawableSpan[] dynamicDrawableSpanArr = (DynamicDrawableSpan[]) spanned.getSpans(0, spanned.length(), DynamicDrawableSpan.class);
            Drawable[] drawableArr2 = new Drawable[dynamicDrawableSpanArr.length];
            for (int i16 = 0; i16 < dynamicDrawableSpanArr.length; i16++) {
                Drawable drawable2 = dynamicDrawableSpanArr[i16].getDrawable();
                drawableArr2[i16] = drawable2;
                if (drawable2 != null) {
                    drawable2.setCallback(this);
                }
            }
            this.f112419i = drawableArr2;
        }
    }

    @Override // android.widget.TextView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        invalidate();
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        super.setText(charSequence, bufferType);
        try {
            a(charSequence);
        } catch (Exception e16) {
            QLog.i("EmoTextView", 2, "setText. exception: " + e16.getMessage());
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return true;
    }

    public EmoTextView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public EmoTextView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
