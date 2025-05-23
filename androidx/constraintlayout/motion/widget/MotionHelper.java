package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R;

/* compiled from: P */
/* loaded from: classes.dex */
public class MotionHelper extends ConstraintHelper implements Animatable, MotionLayout.TransitionListener {
    private float mProgress;
    private boolean mUseOnHide;
    private boolean mUseOnShow;
    protected View[] views;

    public MotionHelper(Context context) {
        super(context);
        this.mUseOnShow = false;
        this.mUseOnHide = false;
    }

    @Override // androidx.constraintlayout.motion.widget.Animatable
    public float getProgress() {
        return this.mProgress;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void init(AttributeSet attributeSet) {
        super.init(attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.MotionHelper);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = obtainStyledAttributes.getIndex(i3);
                if (index == R.styleable.MotionHelper_onShow) {
                    this.mUseOnShow = obtainStyledAttributes.getBoolean(index, this.mUseOnShow);
                } else if (index == R.styleable.MotionHelper_onHide) {
                    this.mUseOnHide = obtainStyledAttributes.getBoolean(index, this.mUseOnHide);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public boolean isUseOnHide() {
        return this.mUseOnHide;
    }

    public boolean isUsedOnShow() {
        return this.mUseOnShow;
    }

    public void setProgress(View view, float f16) {
    }

    @Override // androidx.constraintlayout.motion.widget.Animatable
    public void setProgress(float f16) {
        this.mProgress = f16;
        int i3 = 0;
        if (this.mCount > 0) {
            this.views = getViews((ConstraintLayout) getParent());
            while (i3 < this.mCount) {
                setProgress(this.views[i3], f16);
                i3++;
            }
            return;
        }
        ViewGroup viewGroup = (ViewGroup) getParent();
        int childCount = viewGroup.getChildCount();
        while (i3 < childCount) {
            View childAt = viewGroup.getChildAt(i3);
            if (!(childAt instanceof MotionHelper)) {
                setProgress(childAt, f16);
            }
            i3++;
        }
    }

    public MotionHelper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mUseOnShow = false;
        this.mUseOnHide = false;
        init(attributeSet);
    }

    public MotionHelper(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mUseOnShow = false;
        this.mUseOnHide = false;
        init(attributeSet);
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
    public void onTransitionCompleted(MotionLayout motionLayout, int i3) {
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
    public void onTransitionStarted(MotionLayout motionLayout, int i3, int i16) {
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
    public void onTransitionChange(MotionLayout motionLayout, int i3, int i16, float f16) {
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
    public void onTransitionTrigger(MotionLayout motionLayout, int i3, boolean z16, float f16) {
    }
}
