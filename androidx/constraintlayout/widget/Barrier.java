package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.HelperWidget;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

/* compiled from: P */
/* loaded from: classes.dex */
public class Barrier extends ConstraintHelper {
    public static final int BOTTOM = 3;
    public static final int END = 6;
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int START = 5;
    public static final int TOP = 2;
    private androidx.constraintlayout.solver.widgets.Barrier mBarrier;
    private int mIndicatedType;
    private int mResolvedType;

    public Barrier(Context context) {
        super(context);
        super.setVisibility(8);
    }

    private void updateType(ConstraintWidget constraintWidget, int i3, boolean z16) {
        this.mResolvedType = i3;
        if (z16) {
            int i16 = this.mIndicatedType;
            if (i16 == 5) {
                this.mResolvedType = 1;
            } else if (i16 == 6) {
                this.mResolvedType = 0;
            }
        } else {
            int i17 = this.mIndicatedType;
            if (i17 == 5) {
                this.mResolvedType = 0;
            } else if (i17 == 6) {
                this.mResolvedType = 1;
            }
        }
        if (constraintWidget instanceof androidx.constraintlayout.solver.widgets.Barrier) {
            ((androidx.constraintlayout.solver.widgets.Barrier) constraintWidget).setBarrierType(this.mResolvedType);
        }
    }

    public boolean allowsGoneWidget() {
        return this.mBarrier.allowsGoneWidget();
    }

    public int getMargin() {
        return this.mBarrier.getMargin();
    }

    public int getType() {
        return this.mIndicatedType;
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    protected void init(AttributeSet attributeSet) {
        super.init(attributeSet);
        this.mBarrier = new androidx.constraintlayout.solver.widgets.Barrier();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = obtainStyledAttributes.getIndex(i3);
                if (index == R.styleable.ConstraintLayout_Layout_barrierDirection) {
                    setType(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_barrierAllowsGoneWidgets) {
                    this.mBarrier.setAllowsGoneWidget(obtainStyledAttributes.getBoolean(index, true));
                } else if (index == R.styleable.ConstraintLayout_Layout_barrierMargin) {
                    this.mBarrier.setMargin(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.mHelperWidget = this.mBarrier;
        validateParams();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void loadParameters(ConstraintSet.Constraint constraint, HelperWidget helperWidget, ConstraintLayout.LayoutParams layoutParams, SparseArray<ConstraintWidget> sparseArray) {
        super.loadParameters(constraint, helperWidget, layoutParams, sparseArray);
        if (helperWidget instanceof androidx.constraintlayout.solver.widgets.Barrier) {
            androidx.constraintlayout.solver.widgets.Barrier barrier = (androidx.constraintlayout.solver.widgets.Barrier) helperWidget;
            updateType(barrier, constraint.layout.mBarrierDirection, ((ConstraintWidgetContainer) helperWidget.getParent()).isRtl());
            barrier.setAllowsGoneWidget(constraint.layout.mBarrierAllowsGoneWidgets);
            barrier.setMargin(constraint.layout.mBarrierMargin);
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void resolveRtl(ConstraintWidget constraintWidget, boolean z16) {
        updateType(constraintWidget, this.mIndicatedType, z16);
    }

    public void setAllowsGoneWidget(boolean z16) {
        this.mBarrier.setAllowsGoneWidget(z16);
    }

    public void setDpMargin(int i3) {
        this.mBarrier.setMargin((int) ((i3 * getResources().getDisplayMetrics().density) + 0.5f));
    }

    public void setMargin(int i3) {
        this.mBarrier.setMargin(i3);
    }

    public void setType(int i3) {
        this.mIndicatedType = i3;
    }

    public Barrier(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setVisibility(8);
    }

    public Barrier(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        super.setVisibility(8);
    }
}
