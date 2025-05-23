package com.tencent.mobileqq.search.base.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes18.dex */
public class RightArrowTextView extends TextView {
    public RightArrowTextView(Context context) {
        this(context, null);
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        Drawable drawable = getResources().getDrawable(R.drawable.skin_more_arrow);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        SpannableString spannableString = new SpannableString(charSequence.toString() + "[arrow]");
        spannableString.setSpan(new ImageSpan(drawable, 1), charSequence.length(), charSequence.length() + 7, 17);
        super.setText(spannableString, bufferType);
        setContentDescription(charSequence);
    }

    public RightArrowTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RightArrowTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
