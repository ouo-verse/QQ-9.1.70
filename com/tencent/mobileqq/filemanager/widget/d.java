package com.tencent.mobileqq.filemanager.widget;

import android.R;
import android.content.res.ColorStateList;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

/* compiled from: P */
/* loaded from: classes12.dex */
public class d extends ClickableSpan {

    /* renamed from: d, reason: collision with root package name */
    private boolean f209531d;

    /* renamed from: e, reason: collision with root package name */
    private ColorStateList f209532e;

    /* renamed from: f, reason: collision with root package name */
    private ColorStateList f209533f;

    /* renamed from: h, reason: collision with root package name */
    private View.OnClickListener f209534h;

    public d(View.OnClickListener onClickListener, ColorStateList colorStateList, ColorStateList colorStateList2) {
        this.f209534h = onClickListener;
        this.f209532e = colorStateList;
        this.f209533f = colorStateList2;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        View.OnClickListener onClickListener = this.f209534h;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        int colorForState;
        int colorForState2;
        super.updateDrawState(textPaint);
        textPaint.setUnderlineText(false);
        ColorStateList colorStateList = this.f209532e;
        if (colorStateList != null) {
            if (this.f209531d) {
                colorForState2 = colorStateList.getColorForState(new int[]{R.attr.state_pressed}, 0);
            } else {
                colorForState2 = colorStateList.getColorForState(new int[0], 0);
            }
            textPaint.setColor(colorForState2);
        } else {
            textPaint.setColor(-16777216);
        }
        ColorStateList colorStateList2 = this.f209533f;
        if (colorStateList2 != null) {
            if (this.f209531d) {
                colorForState = colorStateList2.getColorForState(new int[]{R.attr.state_pressed}, 0);
            } else {
                colorForState = colorStateList2.getColorForState(new int[0], 0);
            }
            textPaint.bgColor = colorForState;
            return;
        }
        textPaint.bgColor = 0;
    }

    public d(View.OnClickListener onClickListener, ColorStateList colorStateList) {
        this(onClickListener, colorStateList, null);
    }
}
