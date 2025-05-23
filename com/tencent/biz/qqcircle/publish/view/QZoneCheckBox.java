package com.tencent.biz.qqcircle.publish.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QZoneCheckBox extends CheckBox {

    /* renamed from: d, reason: collision with root package name */
    View.OnClickListener f91769d;

    public QZoneCheckBox(Context context) {
        this(context, null);
    }

    @Override // android.widget.CompoundButton, android.view.View
    public boolean performClick() {
        boolean z16 = false;
        if (this.f91769d != null) {
            playSoundEffect(0);
            this.f91769d.onClick(this);
            z16 = true;
        }
        sendAccessibilityEvent(1);
        return z16;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f91769d = onClickListener;
    }

    public QZoneCheckBox(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.style.f174312vi);
    }

    public QZoneCheckBox(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
