package com.tencent.mobileqq.wink.publish.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.widget.Switch;

/* compiled from: P */
/* loaded from: classes21.dex */
public class FSSwitch extends Switch {

    /* renamed from: d, reason: collision with root package name */
    private View.OnClickListener f326084d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f326085e;

    public FSSwitch(Context context) {
        super(context);
        this.f326085e = true;
    }

    @Override // com.tencent.widget.Switch, android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z16) {
        if (this.f326085e) {
            super.setChecked(z16);
            return;
        }
        View.OnClickListener onClickListener = this.f326084d;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    public void setCityRecommendationCheck(boolean z16) {
        this.f326085e = z16;
    }

    public void setCityRecommendationCheckClick(View.OnClickListener onClickListener) {
        this.f326084d = onClickListener;
    }

    public void setSwitchChecked(boolean z16) {
        super.setChecked(z16);
    }

    public FSSwitch(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f326085e = true;
    }

    public FSSwitch(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f326085e = true;
    }
}
