package com.tencent.mobileqq.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQUIAppSetting;

/* loaded from: classes20.dex */
public class PatchedTextView extends TextView {

    /* renamed from: d, reason: collision with root package name */
    private boolean f315955d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f315956e;

    public PatchedTextView(Context context) {
        super(context);
        this.f315956e = true;
    }

    @Override // android.view.View
    public boolean isEnabled() {
        if (this.f315956e && super.isEnabled()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i3, int i16) {
        try {
            super.onMeasure(i3, i16);
        } catch (Exception e16) {
            if (!QQUIAppSetting.isDebugVersion()) {
                if (QLog.isColorLevel()) {
                    QLog.e("PatchedTextView", 2, "Error : Exception thrown in PatchedTextView.onMeasure", e16);
                }
                setText(getText().toString());
                super.onMeasure(i3, i16);
                return;
            }
            throw new RuntimeException("Error : Exception thrown in PatchedTextView.onMeasure", e16);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.f315955d = false;
        }
        if (this.f315955d && action == 1) {
            this.f315956e = false;
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            this.f315956e = true;
            this.f315955d = false;
            return onTouchEvent;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean performLongClick() {
        boolean performLongClick = super.performLongClick();
        if (performLongClick) {
            this.f315955d = true;
        }
        return performLongClick;
    }

    @Override // android.widget.TextView
    public void setGravity(int i3) {
        try {
            super.setGravity(i3);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("PatchedTextView", 2, "Error : Exception thrown in PatchedTextView.setGravity", e16);
            }
            setText(getText().toString());
            super.setGravity(i3);
        }
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        try {
            super.setText(charSequence, bufferType);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("PatchedTextView", 2, "Error : Exception thrown in PatchedTextView.setText", e16);
            }
            super.setText(charSequence.toString());
        }
    }

    public PatchedTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f315956e = true;
    }

    public PatchedTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f315956e = true;
    }
}
