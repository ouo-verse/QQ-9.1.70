package com.tencent.mobileqq.wink.publish.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes21.dex */
public class FSCheckBox extends CheckBox {

    /* renamed from: d, reason: collision with root package name */
    public boolean f326081d;

    /* renamed from: e, reason: collision with root package name */
    View.OnClickListener f326082e;

    /* renamed from: f, reason: collision with root package name */
    View.OnClickListener f326083f;

    public FSCheckBox(Context context) {
        this(context, null);
    }

    @Override // android.widget.CompoundButton, android.view.View
    public boolean performClick() {
        boolean z16 = false;
        if (this.f326082e != null) {
            playSoundEffect(0);
            this.f326082e.onClick(this);
            z16 = true;
        }
        sendAccessibilityEvent(1);
        return z16;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z16) {
        if (this.f326081d) {
            super.setChecked(z16);
            return;
        }
        View.OnClickListener onClickListener = this.f326083f;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f326082e = onClickListener;
    }

    public void setSyncChecked(boolean z16) {
        super.setChecked(z16);
    }

    public void setmShareClickListener(View.OnClickListener onClickListener) {
        this.f326083f = onClickListener;
    }

    public FSCheckBox(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.style.f174312vi);
    }

    public FSCheckBox(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f326081d = true;
    }
}
