package com.tencent.biz.lebasearch.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.widget.BounceScrollView;

/* compiled from: P */
/* loaded from: classes2.dex */
public class LebaSearchBounceScrollView extends BounceScrollView {
    float Q;
    int R;
    int S;
    boolean T;
    boolean U;

    public LebaSearchBounceScrollView(Context context) {
        super(context);
        this.T = false;
        this.U = true;
        AccessibilityUtil.n(this, false);
        float f16 = context.getResources().getDisplayMetrics().density;
        this.Q = f16;
        this.R = (int) (f16 * 320.0f);
        this.S = 0;
    }

    public boolean b() {
        return this.T;
    }

    @Override // com.tencent.mobileqq.widget.BounceScrollView, com.tencent.widget.ScrollView
    public void fling(int i3) {
        this.T = true;
        super.fling(i3);
    }

    @Override // com.tencent.mobileqq.widget.BounceScrollView, com.tencent.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.T = false;
        }
        return super.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.ScrollView, android.view.View
    public boolean overScrollBy(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, boolean z16) {
        if (this.U) {
            return super.overScrollBy(i3, i16, i17, i18, i19, this.S, i27, this.R, z16);
        }
        return super.overScrollBy(i3, i16, i17, i18, i19, i26, i27, 0, z16);
    }

    public void setMaxOverScrollY(int i3) {
        this.R = i3;
    }

    public void setUseBounce(boolean z16) {
        this.U = z16;
    }

    public LebaSearchBounceScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.T = false;
        this.U = true;
        float f16 = context.getResources().getDisplayMetrics().density;
        this.Q = f16;
        this.R = (int) (f16 * 320.0f);
        this.S = 0;
    }
}
