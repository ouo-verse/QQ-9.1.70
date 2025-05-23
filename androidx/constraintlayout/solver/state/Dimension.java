package androidx.constraintlayout.solver.state;

import androidx.constraintlayout.solver.widgets.ConstraintWidget;

/* compiled from: P */
/* loaded from: classes.dex */
public class Dimension {
    private final int WRAP_CONTENT;
    Object mInitialValue;
    boolean mIsSuggested;
    int mMax;
    int mMin;
    float mPercent;
    float mRatio;
    int mValue;
    public static final Object FIXED_DIMENSION = new Object();
    public static final Object WRAP_DIMENSION = new Object();
    public static final Object SPREAD_DIMENSION = new Object();
    public static final Object PARENT_DIMENSION = new Object();
    public static final Object PERCENT_DIMENSION = new Object();

    /* compiled from: P */
    /* loaded from: classes.dex */
    public enum Type {
        FIXED,
        WRAP,
        MATCH_PARENT,
        MATCH_CONSTRAINT
    }

    Dimension() {
        this.WRAP_CONTENT = -2;
        this.mMin = 0;
        this.mMax = Integer.MAX_VALUE;
        this.mPercent = 1.0f;
        this.mValue = 0;
        this.mRatio = 1.0f;
        this.mInitialValue = WRAP_DIMENSION;
        this.mIsSuggested = false;
    }

    public static Dimension Fixed(int i3) {
        Dimension dimension = new Dimension(FIXED_DIMENSION);
        dimension.fixed(i3);
        return dimension;
    }

    public static Dimension Parent() {
        return new Dimension(PARENT_DIMENSION);
    }

    public static Dimension Percent(Object obj, float f16) {
        Dimension dimension = new Dimension(PERCENT_DIMENSION);
        dimension.percent(obj, f16);
        return dimension;
    }

    public static Dimension Spread() {
        return new Dimension(SPREAD_DIMENSION);
    }

    public static Dimension Suggested(int i3) {
        Dimension dimension = new Dimension();
        dimension.suggested(i3);
        return dimension;
    }

    public static Dimension Wrap() {
        return new Dimension(WRAP_DIMENSION);
    }

    public void apply(State state, ConstraintWidget constraintWidget, int i3) {
        int i16 = 2;
        if (i3 == 0) {
            if (this.mIsSuggested) {
                constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
                Object obj = this.mInitialValue;
                if (obj == WRAP_DIMENSION) {
                    i16 = 1;
                } else if (obj != PERCENT_DIMENSION) {
                    i16 = 0;
                }
                constraintWidget.setHorizontalMatchStyle(i16, this.mMin, this.mMax, this.mPercent);
                return;
            }
            int i17 = this.mMin;
            if (i17 > 0) {
                constraintWidget.setMinWidth(i17);
            }
            int i18 = this.mMax;
            if (i18 < Integer.MAX_VALUE) {
                constraintWidget.setMaxWidth(i18);
            }
            Object obj2 = this.mInitialValue;
            if (obj2 == WRAP_DIMENSION) {
                constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
                return;
            }
            if (obj2 == PARENT_DIMENSION) {
                constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
                return;
            } else {
                if (obj2 == null) {
                    constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                    constraintWidget.setWidth(this.mValue);
                    return;
                }
                return;
            }
        }
        if (this.mIsSuggested) {
            constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
            Object obj3 = this.mInitialValue;
            if (obj3 == WRAP_DIMENSION) {
                i16 = 1;
            } else if (obj3 != PERCENT_DIMENSION) {
                i16 = 0;
            }
            constraintWidget.setVerticalMatchStyle(i16, this.mMin, this.mMax, this.mPercent);
            return;
        }
        int i19 = this.mMin;
        if (i19 > 0) {
            constraintWidget.setMinHeight(i19);
        }
        int i26 = this.mMax;
        if (i26 < Integer.MAX_VALUE) {
            constraintWidget.setMaxHeight(i26);
        }
        Object obj4 = this.mInitialValue;
        if (obj4 == WRAP_DIMENSION) {
            constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
            return;
        }
        if (obj4 == PARENT_DIMENSION) {
            constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
        } else if (obj4 == null) {
            constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
            constraintWidget.setHeight(this.mValue);
        }
    }

    public Dimension fixed(Object obj) {
        this.mInitialValue = obj;
        if (obj instanceof Integer) {
            this.mValue = ((Integer) obj).intValue();
            this.mInitialValue = null;
        }
        return this;
    }

    float getRatio() {
        return this.mRatio;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getValue() {
        return this.mValue;
    }

    public Dimension max(int i3) {
        if (this.mMax >= 0) {
            this.mMax = i3;
        }
        return this;
    }

    public Dimension min(int i3) {
        if (i3 >= 0) {
            this.mMin = i3;
        }
        return this;
    }

    public Dimension percent(Object obj, float f16) {
        this.mPercent = f16;
        return this;
    }

    void setRatio(float f16) {
        this.mRatio = f16;
    }

    void setValue(int i3) {
        this.mIsSuggested = false;
        this.mInitialValue = null;
        this.mValue = i3;
    }

    public Dimension suggested(int i3) {
        this.mIsSuggested = true;
        return this;
    }

    public Dimension min(Object obj) {
        if (obj == WRAP_DIMENSION) {
            this.mMin = -2;
        }
        return this;
    }

    public Dimension suggested(Object obj) {
        this.mInitialValue = obj;
        this.mIsSuggested = true;
        return this;
    }

    public static Dimension Fixed(Object obj) {
        Dimension dimension = new Dimension(FIXED_DIMENSION);
        dimension.fixed(obj);
        return dimension;
    }

    public static Dimension Suggested(Object obj) {
        Dimension dimension = new Dimension();
        dimension.suggested(obj);
        return dimension;
    }

    public Dimension max(Object obj) {
        Object obj2 = WRAP_DIMENSION;
        if (obj == obj2 && this.mIsSuggested) {
            this.mInitialValue = obj2;
            this.mMax = Integer.MAX_VALUE;
        }
        return this;
    }

    public Dimension fixed(int i3) {
        this.mInitialValue = null;
        this.mValue = i3;
        return this;
    }

    Dimension(Object obj) {
        this.WRAP_CONTENT = -2;
        this.mMin = 0;
        this.mMax = Integer.MAX_VALUE;
        this.mPercent = 1.0f;
        this.mValue = 0;
        this.mRatio = 1.0f;
        this.mIsSuggested = false;
        this.mInitialValue = obj;
    }

    public Dimension ratio(float f16) {
        return this;
    }
}
