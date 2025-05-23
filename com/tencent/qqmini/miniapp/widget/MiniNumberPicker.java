package com.tencent.qqmini.miniapp.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.NumberPicker;

@TargetApi(16)
/* loaded from: classes23.dex */
public class MiniNumberPicker extends NumberPicker {
    public MiniNumberPicker(Context context) {
        super(context);
    }

    private void setEditTextStyle(View view) {
        if (view instanceof EditText) {
            ((EditText) view).setTextSize(1, 14.0f);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        super.addView(view);
        setEditTextStyle(view);
    }

    public MiniNumberPicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MiniNumberPicker(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i3) {
        super.addView(view, i3);
        setEditTextStyle(view);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i3, int i16) {
        super.addView(view, i3, i16);
        setEditTextStyle(view);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, layoutParams);
        setEditTextStyle(view);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i3, layoutParams);
        setEditTextStyle(view);
    }
}
