package androidx.constraintlayout.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;

/* compiled from: P */
/* loaded from: classes.dex */
public class Guideline extends View {
    public Guideline(Context context) {
        super(context);
        super.setVisibility(8);
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        setMeasuredDimension(0, 0);
    }

    public void setGuidelineBegin(int i3) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        layoutParams.guideBegin = i3;
        setLayoutParams(layoutParams);
    }

    public void setGuidelineEnd(int i3) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        layoutParams.guideEnd = i3;
        setLayoutParams(layoutParams);
    }

    public void setGuidelinePercent(float f16) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        layoutParams.guidePercent = f16;
        setLayoutParams(layoutParams);
    }

    public Guideline(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setVisibility(8);
    }

    public Guideline(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        super.setVisibility(8);
    }

    public Guideline(Context context, AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3);
        super.setVisibility(8);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
    }
}
