package androidx.constraintlayout.widget;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.solver.Metrics;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Optimizer;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.internal.view.SupportMenu;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes.dex */
public class ConstraintLayout extends ViewGroup {
    private static final boolean DEBUG = false;
    private static final boolean DEBUG_DRAW_CONSTRAINTS = false;
    public static final int DESIGN_INFO_ID = 0;
    private static final boolean MEASURE = false;
    private static final String TAG = "ConstraintLayout";
    private static final boolean USE_CONSTRAINTS_HELPER = true;
    public static final String VERSION = "ConstraintLayout-2.0.4";
    SparseArray<View> mChildrenByIds;
    private ArrayList<ConstraintHelper> mConstraintHelpers;
    protected ConstraintLayoutStates mConstraintLayoutSpec;
    private ConstraintSet mConstraintSet;
    private int mConstraintSetId;
    private ConstraintsChangedListener mConstraintsChangedListener;
    private HashMap<String, Integer> mDesignIds;
    protected boolean mDirtyHierarchy;
    private int mLastMeasureHeight;
    int mLastMeasureHeightMode;
    int mLastMeasureHeightSize;
    private int mLastMeasureWidth;
    int mLastMeasureWidthMode;
    int mLastMeasureWidthSize;
    protected ConstraintWidgetContainer mLayoutWidget;
    private int mMaxHeight;
    private int mMaxWidth;
    Measurer mMeasurer;
    private Metrics mMetrics;
    private int mMinHeight;
    private int mMinWidth;
    private int mOnMeasureHeightMeasureSpec;
    private int mOnMeasureWidthMeasureSpec;
    private int mOptimizationLevel;
    private SparseArray<ConstraintWidget> mTempMapIdToWidget;

    /* compiled from: P */
    /* renamed from: androidx.constraintlayout.widget.ConstraintLayout$1, reason: invalid class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour;

        static {
            int[] iArr = new int[ConstraintWidget.DimensionBehaviour.values().length];
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour = iArr;
            try {
                iArr[ConstraintWidget.DimensionBehaviour.FIXED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[ConstraintWidget.DimensionBehaviour.WRAP_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[ConstraintWidget.DimensionBehaviour.MATCH_PARENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public class Measurer implements BasicMeasure.Measurer {
        ConstraintLayout layout;
        int layoutHeightSpec;
        int layoutWidthSpec;
        int paddingBottom;
        int paddingHeight;
        int paddingTop;
        int paddingWidth;

        public Measurer(ConstraintLayout constraintLayout) {
            this.layout = constraintLayout;
        }

        private boolean isSimilarSpec(int i3, int i16, int i17) {
            if (i3 == i16) {
                return true;
            }
            int mode = View.MeasureSpec.getMode(i3);
            View.MeasureSpec.getSize(i3);
            int mode2 = View.MeasureSpec.getMode(i16);
            int size = View.MeasureSpec.getSize(i16);
            if (mode2 == 1073741824) {
                if ((mode == Integer.MIN_VALUE || mode == 0) && i17 == size) {
                    return true;
                }
                return false;
            }
            return false;
        }

        public void captureLayoutInfos(int i3, int i16, int i17, int i18, int i19, int i26) {
            this.paddingTop = i17;
            this.paddingBottom = i18;
            this.paddingWidth = i19;
            this.paddingHeight = i26;
            this.layoutWidthSpec = i3;
            this.layoutHeightSpec = i16;
        }

        @Override // androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measurer
        public final void didMeasures() {
            int childCount = this.layout.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = this.layout.getChildAt(i3);
                if (childAt instanceof Placeholder) {
                    ((Placeholder) childAt).updatePostMeasure(this.layout);
                }
            }
            int size = this.layout.mConstraintHelpers.size();
            if (size > 0) {
                for (int i16 = 0; i16 < size; i16++) {
                    ((ConstraintHelper) this.layout.mConstraintHelpers.get(i16)).updatePostMeasure(this.layout);
                }
            }
        }

        @Override // androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measurer
        @SuppressLint({"WrongCall"})
        public final void measure(ConstraintWidget constraintWidget, BasicMeasure.Measure measure) {
            int makeMeasureSpec;
            int makeMeasureSpec2;
            boolean z16;
            boolean z17;
            boolean z18;
            boolean z19;
            boolean z26;
            boolean z27;
            int baseline;
            int i3;
            int i16;
            int i17;
            int i18;
            int i19;
            boolean z28;
            boolean z29;
            boolean z36;
            boolean z37;
            boolean z38;
            boolean z39;
            boolean z46;
            boolean z47;
            boolean z48;
            if (constraintWidget == null) {
                return;
            }
            if (constraintWidget.getVisibility() == 8 && !constraintWidget.isInPlaceholder()) {
                measure.measuredWidth = 0;
                measure.measuredHeight = 0;
                measure.measuredBaseline = 0;
                return;
            }
            if (constraintWidget.getParent() == null) {
                return;
            }
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = measure.horizontalBehavior;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = measure.verticalBehavior;
            int i26 = measure.horizontalDimension;
            int i27 = measure.verticalDimension;
            int i28 = this.paddingTop + this.paddingBottom;
            int i29 = this.paddingWidth;
            View view = (View) constraintWidget.getCompanionWidget();
            int[] iArr = AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour;
            int i36 = iArr[dimensionBehaviour.ordinal()];
            if (i36 != 1) {
                if (i36 != 2) {
                    if (i36 != 3) {
                        if (i36 != 4) {
                            makeMeasureSpec = 0;
                        } else {
                            makeMeasureSpec = ViewGroup.getChildMeasureSpec(this.layoutWidthSpec, i29, -2);
                            if (constraintWidget.mMatchConstraintDefaultWidth == 1) {
                                z46 = true;
                            } else {
                                z46 = false;
                            }
                            int i37 = measure.measureStrategy;
                            if (i37 == BasicMeasure.Measure.TRY_GIVEN_DIMENSIONS || i37 == BasicMeasure.Measure.USE_GIVEN_DIMENSIONS) {
                                if (view.getMeasuredHeight() == constraintWidget.getHeight()) {
                                    z47 = true;
                                } else {
                                    z47 = false;
                                }
                                if (measure.measureStrategy != BasicMeasure.Measure.USE_GIVEN_DIMENSIONS && z46 && ((!z46 || !z47) && !(view instanceof Placeholder) && !constraintWidget.isResolvedHorizontally())) {
                                    z48 = false;
                                } else {
                                    z48 = true;
                                }
                                if (z48) {
                                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(constraintWidget.getWidth(), 1073741824);
                                }
                            }
                        }
                    } else {
                        makeMeasureSpec = ViewGroup.getChildMeasureSpec(this.layoutWidthSpec, i29 + constraintWidget.getHorizontalMargin(), -1);
                    }
                } else {
                    makeMeasureSpec = ViewGroup.getChildMeasureSpec(this.layoutWidthSpec, i29, -2);
                }
            } else {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i26, 1073741824);
            }
            int i38 = iArr[dimensionBehaviour2.ordinal()];
            if (i38 != 1) {
                if (i38 != 2) {
                    if (i38 != 3) {
                        if (i38 != 4) {
                            makeMeasureSpec2 = 0;
                        } else {
                            makeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.layoutHeightSpec, i28, -2);
                            if (constraintWidget.mMatchConstraintDefaultHeight == 1) {
                                z37 = true;
                            } else {
                                z37 = false;
                            }
                            int i39 = measure.measureStrategy;
                            if (i39 == BasicMeasure.Measure.TRY_GIVEN_DIMENSIONS || i39 == BasicMeasure.Measure.USE_GIVEN_DIMENSIONS) {
                                if (view.getMeasuredWidth() == constraintWidget.getWidth()) {
                                    z38 = true;
                                } else {
                                    z38 = false;
                                }
                                if (measure.measureStrategy != BasicMeasure.Measure.USE_GIVEN_DIMENSIONS && z37 && ((!z37 || !z38) && !(view instanceof Placeholder) && !constraintWidget.isResolvedVertically())) {
                                    z39 = false;
                                } else {
                                    z39 = true;
                                }
                                if (z39) {
                                    makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(constraintWidget.getHeight(), 1073741824);
                                }
                            }
                        }
                    } else {
                        makeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.layoutHeightSpec, i28 + constraintWidget.getVerticalMargin(), -1);
                    }
                } else {
                    makeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.layoutHeightSpec, i28, -2);
                }
            } else {
                makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i27, 1073741824);
            }
            ConstraintWidgetContainer constraintWidgetContainer = (ConstraintWidgetContainer) constraintWidget.getParent();
            if (constraintWidgetContainer != null && Optimizer.enabled(ConstraintLayout.this.mOptimizationLevel, 256) && view.getMeasuredWidth() == constraintWidget.getWidth() && view.getMeasuredWidth() < constraintWidgetContainer.getWidth() && view.getMeasuredHeight() == constraintWidget.getHeight() && view.getMeasuredHeight() < constraintWidgetContainer.getHeight() && view.getBaseline() == constraintWidget.getBaselineDistance() && !constraintWidget.isMeasureRequested()) {
                if (isSimilarSpec(constraintWidget.getLastHorizontalMeasureSpec(), makeMeasureSpec, constraintWidget.getWidth()) && isSimilarSpec(constraintWidget.getLastVerticalMeasureSpec(), makeMeasureSpec2, constraintWidget.getHeight())) {
                    z36 = true;
                } else {
                    z36 = false;
                }
                if (z36) {
                    measure.measuredWidth = constraintWidget.getWidth();
                    measure.measuredHeight = constraintWidget.getHeight();
                    measure.measuredBaseline = constraintWidget.getBaselineDistance();
                    return;
                }
            }
            ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
            if (dimensionBehaviour == dimensionBehaviour3) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (dimensionBehaviour2 == dimensionBehaviour3) {
                z17 = true;
            } else {
                z17 = false;
            }
            ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
            if (dimensionBehaviour2 != dimensionBehaviour4 && dimensionBehaviour2 != ConstraintWidget.DimensionBehaviour.FIXED) {
                z18 = false;
            } else {
                z18 = true;
            }
            if (dimensionBehaviour != dimensionBehaviour4 && dimensionBehaviour != ConstraintWidget.DimensionBehaviour.FIXED) {
                z19 = false;
            } else {
                z19 = true;
            }
            if (z16 && constraintWidget.mDimensionRatio > 0.0f) {
                z26 = true;
            } else {
                z26 = false;
            }
            if (z17 && constraintWidget.mDimensionRatio > 0.0f) {
                z27 = true;
            } else {
                z27 = false;
            }
            if (view == null) {
                return;
            }
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            int i46 = measure.measureStrategy;
            if (i46 != BasicMeasure.Measure.TRY_GIVEN_DIMENSIONS && i46 != BasicMeasure.Measure.USE_GIVEN_DIMENSIONS && z16 && constraintWidget.mMatchConstraintDefaultWidth == 0 && z17 && constraintWidget.mMatchConstraintDefaultHeight == 0) {
                i19 = -1;
                i17 = 0;
                baseline = 0;
                i3 = 0;
            } else {
                if ((view instanceof VirtualLayout) && (constraintWidget instanceof androidx.constraintlayout.solver.widgets.VirtualLayout)) {
                    ((VirtualLayout) view).onMeasure((androidx.constraintlayout.solver.widgets.VirtualLayout) constraintWidget, makeMeasureSpec, makeMeasureSpec2);
                } else {
                    view.measure(makeMeasureSpec, makeMeasureSpec2);
                }
                constraintWidget.setLastMeasureSpec(makeMeasureSpec, makeMeasureSpec2);
                int measuredWidth = view.getMeasuredWidth();
                int measuredHeight = view.getMeasuredHeight();
                baseline = view.getBaseline();
                int i47 = constraintWidget.mMatchConstraintMinWidth;
                if (i47 > 0) {
                    i3 = Math.max(i47, measuredWidth);
                } else {
                    i3 = measuredWidth;
                }
                int i48 = constraintWidget.mMatchConstraintMaxWidth;
                if (i48 > 0) {
                    i3 = Math.min(i48, i3);
                }
                int i49 = constraintWidget.mMatchConstraintMinHeight;
                if (i49 > 0) {
                    i17 = Math.max(i49, measuredHeight);
                    i16 = makeMeasureSpec;
                } else {
                    i16 = makeMeasureSpec;
                    i17 = measuredHeight;
                }
                int i56 = constraintWidget.mMatchConstraintMaxHeight;
                if (i56 > 0) {
                    i17 = Math.min(i56, i17);
                }
                if (!Optimizer.enabled(ConstraintLayout.this.mOptimizationLevel, 1)) {
                    if (z26 && z18) {
                        i3 = (int) ((i17 * constraintWidget.mDimensionRatio) + 0.5f);
                    } else if (z27 && z19) {
                        i17 = (int) ((i3 / constraintWidget.mDimensionRatio) + 0.5f);
                    }
                }
                if (measuredWidth != i3 || measuredHeight != i17) {
                    if (measuredWidth != i3) {
                        i18 = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
                    } else {
                        i18 = i16;
                    }
                    if (measuredHeight != i17) {
                        makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i17, 1073741824);
                    }
                    view.measure(i18, makeMeasureSpec2);
                    constraintWidget.setLastMeasureSpec(i18, makeMeasureSpec2);
                    i3 = view.getMeasuredWidth();
                    i17 = view.getMeasuredHeight();
                    baseline = view.getBaseline();
                }
                i19 = -1;
            }
            if (baseline != i19) {
                z28 = true;
            } else {
                z28 = false;
            }
            if (i3 == measure.horizontalDimension && i17 == measure.verticalDimension) {
                z29 = false;
            } else {
                z29 = true;
            }
            measure.measuredNeedsSolverPass = z29;
            if (layoutParams.needsBaseline) {
                z28 = true;
            }
            if (z28 && baseline != -1 && constraintWidget.getBaselineDistance() != baseline) {
                measure.measuredNeedsSolverPass = true;
            }
            measure.measuredWidth = i3;
            measure.measuredHeight = i17;
            measure.measuredHasBaseline = z28;
            measure.measuredBaseline = baseline;
        }
    }

    public ConstraintLayout(@NonNull Context context) {
        super(context);
        this.mChildrenByIds = new SparseArray<>();
        this.mConstraintHelpers = new ArrayList<>(4);
        this.mLayoutWidget = new ConstraintWidgetContainer();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mDirtyHierarchy = true;
        this.mOptimizationLevel = 257;
        this.mConstraintSet = null;
        this.mConstraintLayoutSpec = null;
        this.mConstraintSetId = -1;
        this.mDesignIds = new HashMap<>();
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        this.mTempMapIdToWidget = new SparseArray<>();
        this.mMeasurer = new Measurer(this);
        this.mOnMeasureWidthMeasureSpec = 0;
        this.mOnMeasureHeightMeasureSpec = 0;
        init(null, 0, 0);
    }

    private int getPaddingWidth() {
        int max = Math.max(0, getPaddingLeft()) + Math.max(0, getPaddingRight());
        int max2 = Math.max(0, getPaddingStart()) + Math.max(0, getPaddingEnd());
        if (max2 > 0) {
            return max2;
        }
        return max;
    }

    private final ConstraintWidget getTargetWidget(int i3) {
        if (i3 == 0) {
            return this.mLayoutWidget;
        }
        View view = this.mChildrenByIds.get(i3);
        if (view == null && (view = findViewById(i3)) != null && view != this && view.getParent() == this) {
            onViewAdded(view);
        }
        if (view == this) {
            return this.mLayoutWidget;
        }
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).widget;
    }

    private void init(AttributeSet attributeSet, int i3, int i16) {
        this.mLayoutWidget.setCompanionWidget(this);
        this.mLayoutWidget.setMeasurer(this.mMeasurer);
        this.mChildrenByIds.put(getId(), this);
        this.mConstraintSet = null;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout, i3, i16);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i17 = 0; i17 < indexCount; i17++) {
                int index = obtainStyledAttributes.getIndex(i17);
                if (index == R.styleable.ConstraintLayout_Layout_android_minWidth) {
                    this.mMinWidth = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMinWidth);
                } else if (index == R.styleable.ConstraintLayout_Layout_android_minHeight) {
                    this.mMinHeight = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMinHeight);
                } else if (index == R.styleable.ConstraintLayout_Layout_android_maxWidth) {
                    this.mMaxWidth = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMaxWidth);
                } else if (index == R.styleable.ConstraintLayout_Layout_android_maxHeight) {
                    this.mMaxHeight = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMaxHeight);
                } else if (index == R.styleable.ConstraintLayout_Layout_layout_optimizationLevel) {
                    this.mOptimizationLevel = obtainStyledAttributes.getInt(index, this.mOptimizationLevel);
                } else if (index == R.styleable.ConstraintLayout_Layout_layoutDescription) {
                    int resourceId = obtainStyledAttributes.getResourceId(index, 0);
                    if (resourceId != 0) {
                        try {
                            parseLayoutDescription(resourceId);
                        } catch (Resources.NotFoundException unused) {
                            this.mConstraintLayoutSpec = null;
                        }
                    }
                } else if (index == R.styleable.ConstraintLayout_Layout_constraintSet) {
                    int resourceId2 = obtainStyledAttributes.getResourceId(index, 0);
                    try {
                        ConstraintSet constraintSet = new ConstraintSet();
                        this.mConstraintSet = constraintSet;
                        constraintSet.load(getContext(), resourceId2);
                    } catch (Resources.NotFoundException unused2) {
                        this.mConstraintSet = null;
                    }
                    this.mConstraintSetId = resourceId2;
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.mLayoutWidget.setOptimizationLevel(this.mOptimizationLevel);
    }

    private void markHierarchyDirty() {
        this.mDirtyHierarchy = true;
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
    }

    private void setChildrenConstraints() {
        boolean isInEditMode = isInEditMode();
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            ConstraintWidget viewWidget = getViewWidget(getChildAt(i3));
            if (viewWidget != null) {
                viewWidget.reset();
            }
        }
        if (isInEditMode) {
            for (int i16 = 0; i16 < childCount; i16++) {
                View childAt = getChildAt(i16);
                try {
                    String resourceName = getResources().getResourceName(childAt.getId());
                    setDesignInformation(0, resourceName, Integer.valueOf(childAt.getId()));
                    int indexOf = resourceName.indexOf(47);
                    if (indexOf != -1) {
                        resourceName = resourceName.substring(indexOf + 1);
                    }
                    getTargetWidget(childAt.getId()).setDebugName(resourceName);
                } catch (Resources.NotFoundException unused) {
                }
            }
        }
        if (this.mConstraintSetId != -1) {
            for (int i17 = 0; i17 < childCount; i17++) {
                View childAt2 = getChildAt(i17);
                if (childAt2.getId() == this.mConstraintSetId && (childAt2 instanceof Constraints)) {
                    this.mConstraintSet = ((Constraints) childAt2).getConstraintSet();
                }
            }
        }
        ConstraintSet constraintSet = this.mConstraintSet;
        if (constraintSet != null) {
            constraintSet.applyToInternal(this, true);
        }
        this.mLayoutWidget.removeAllChildren();
        int size = this.mConstraintHelpers.size();
        if (size > 0) {
            for (int i18 = 0; i18 < size; i18++) {
                this.mConstraintHelpers.get(i18).updatePreLayout(this);
            }
        }
        for (int i19 = 0; i19 < childCount; i19++) {
            View childAt3 = getChildAt(i19);
            if (childAt3 instanceof Placeholder) {
                ((Placeholder) childAt3).updatePreLayout(this);
            }
        }
        this.mTempMapIdToWidget.clear();
        this.mTempMapIdToWidget.put(0, this.mLayoutWidget);
        this.mTempMapIdToWidget.put(getId(), this.mLayoutWidget);
        for (int i26 = 0; i26 < childCount; i26++) {
            View childAt4 = getChildAt(i26);
            this.mTempMapIdToWidget.put(childAt4.getId(), getViewWidget(childAt4));
        }
        for (int i27 = 0; i27 < childCount; i27++) {
            View childAt5 = getChildAt(i27);
            ConstraintWidget viewWidget2 = getViewWidget(childAt5);
            if (viewWidget2 != null) {
                LayoutParams layoutParams = (LayoutParams) childAt5.getLayoutParams();
                this.mLayoutWidget.add(viewWidget2);
                applyConstraintsFromLayoutParams(isInEditMode, childAt5, viewWidget2, layoutParams, this.mTempMapIdToWidget);
            }
        }
    }

    private boolean updateHierarchy() {
        int childCount = getChildCount();
        boolean z16 = false;
        int i3 = 0;
        while (true) {
            if (i3 >= childCount) {
                break;
            }
            if (getChildAt(i3).isLayoutRequested()) {
                z16 = true;
                break;
            }
            i3++;
        }
        if (z16) {
            setChildrenConstraints();
        }
        return z16;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i3, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void applyConstraintsFromLayoutParams(boolean z16, View view, ConstraintWidget constraintWidget, LayoutParams layoutParams, SparseArray<ConstraintWidget> sparseArray) {
        float f16;
        ConstraintWidget constraintWidget2;
        ConstraintWidget constraintWidget3;
        ConstraintWidget constraintWidget4;
        ConstraintWidget constraintWidget5;
        int i3;
        layoutParams.validate();
        layoutParams.helped = false;
        constraintWidget.setVisibility(view.getVisibility());
        if (layoutParams.isInPlaceholder) {
            constraintWidget.setInPlaceholder(true);
            constraintWidget.setVisibility(8);
        }
        constraintWidget.setCompanionWidget(view);
        if (view instanceof ConstraintHelper) {
            ((ConstraintHelper) view).resolveRtl(constraintWidget, this.mLayoutWidget.isRtl());
        }
        if (layoutParams.isGuideline) {
            androidx.constraintlayout.solver.widgets.Guideline guideline = (androidx.constraintlayout.solver.widgets.Guideline) constraintWidget;
            int i16 = layoutParams.resolvedGuideBegin;
            int i17 = layoutParams.resolvedGuideEnd;
            float f17 = layoutParams.resolvedGuidePercent;
            if (f17 != -1.0f) {
                guideline.setGuidePercent(f17);
                return;
            } else if (i16 != -1) {
                guideline.setGuideBegin(i16);
                return;
            } else {
                if (i17 != -1) {
                    guideline.setGuideEnd(i17);
                    return;
                }
                return;
            }
        }
        int i18 = layoutParams.resolvedLeftToLeft;
        int i19 = layoutParams.resolvedLeftToRight;
        int i26 = layoutParams.resolvedRightToLeft;
        int i27 = layoutParams.resolvedRightToRight;
        int i28 = layoutParams.resolveGoneLeftMargin;
        int i29 = layoutParams.resolveGoneRightMargin;
        float f18 = layoutParams.resolvedHorizontalBias;
        int i36 = layoutParams.circleConstraint;
        if (i36 != -1) {
            ConstraintWidget constraintWidget6 = sparseArray.get(i36);
            if (constraintWidget6 != null) {
                constraintWidget.connectCircularConstraint(constraintWidget6, layoutParams.circleAngle, layoutParams.circleRadius);
            }
        } else {
            if (i18 != -1) {
                ConstraintWidget constraintWidget7 = sparseArray.get(i18);
                if (constraintWidget7 != null) {
                    ConstraintAnchor.Type type = ConstraintAnchor.Type.LEFT;
                    f16 = f18;
                    constraintWidget.immediateConnect(type, constraintWidget7, type, ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, i28);
                } else {
                    f16 = f18;
                }
            } else {
                f16 = f18;
                if (i19 != -1 && (constraintWidget2 = sparseArray.get(i19)) != null) {
                    constraintWidget.immediateConnect(ConstraintAnchor.Type.LEFT, constraintWidget2, ConstraintAnchor.Type.RIGHT, ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, i28);
                }
            }
            if (i26 != -1) {
                ConstraintWidget constraintWidget8 = sparseArray.get(i26);
                if (constraintWidget8 != null) {
                    constraintWidget.immediateConnect(ConstraintAnchor.Type.RIGHT, constraintWidget8, ConstraintAnchor.Type.LEFT, ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, i29);
                }
            } else if (i27 != -1 && (constraintWidget3 = sparseArray.get(i27)) != null) {
                ConstraintAnchor.Type type2 = ConstraintAnchor.Type.RIGHT;
                constraintWidget.immediateConnect(type2, constraintWidget3, type2, ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, i29);
            }
            int i37 = layoutParams.topToTop;
            if (i37 != -1) {
                ConstraintWidget constraintWidget9 = sparseArray.get(i37);
                if (constraintWidget9 != null) {
                    ConstraintAnchor.Type type3 = ConstraintAnchor.Type.TOP;
                    constraintWidget.immediateConnect(type3, constraintWidget9, type3, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, layoutParams.goneTopMargin);
                }
            } else {
                int i38 = layoutParams.topToBottom;
                if (i38 != -1 && (constraintWidget4 = sparseArray.get(i38)) != null) {
                    constraintWidget.immediateConnect(ConstraintAnchor.Type.TOP, constraintWidget4, ConstraintAnchor.Type.BOTTOM, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, layoutParams.goneTopMargin);
                }
            }
            int i39 = layoutParams.bottomToTop;
            if (i39 != -1) {
                ConstraintWidget constraintWidget10 = sparseArray.get(i39);
                if (constraintWidget10 != null) {
                    constraintWidget.immediateConnect(ConstraintAnchor.Type.BOTTOM, constraintWidget10, ConstraintAnchor.Type.TOP, ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, layoutParams.goneBottomMargin);
                }
            } else {
                int i46 = layoutParams.bottomToBottom;
                if (i46 != -1 && (constraintWidget5 = sparseArray.get(i46)) != null) {
                    ConstraintAnchor.Type type4 = ConstraintAnchor.Type.BOTTOM;
                    constraintWidget.immediateConnect(type4, constraintWidget5, type4, ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, layoutParams.goneBottomMargin);
                }
            }
            int i47 = layoutParams.baselineToBaseline;
            if (i47 != -1) {
                View view2 = this.mChildrenByIds.get(i47);
                ConstraintWidget constraintWidget11 = sparseArray.get(layoutParams.baselineToBaseline);
                if (constraintWidget11 != null && view2 != null && (view2.getLayoutParams() instanceof LayoutParams)) {
                    LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
                    layoutParams.needsBaseline = true;
                    layoutParams2.needsBaseline = true;
                    ConstraintAnchor.Type type5 = ConstraintAnchor.Type.BASELINE;
                    constraintWidget.getAnchor(type5).connect(constraintWidget11.getAnchor(type5), 0, -1, true);
                    constraintWidget.setHasBaseline(true);
                    layoutParams2.widget.setHasBaseline(true);
                    constraintWidget.getAnchor(ConstraintAnchor.Type.TOP).reset();
                    constraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM).reset();
                }
            }
            float f19 = f16;
            if (f19 >= 0.0f) {
                constraintWidget.setHorizontalBiasPercent(f19);
            }
            float f26 = layoutParams.verticalBias;
            if (f26 >= 0.0f) {
                constraintWidget.setVerticalBiasPercent(f26);
            }
        }
        if (z16 && ((i3 = layoutParams.editorAbsoluteX) != -1 || layoutParams.editorAbsoluteY != -1)) {
            constraintWidget.setOrigin(i3, layoutParams.editorAbsoluteY);
        }
        if (!layoutParams.horizontalDimensionFixed) {
            if (((ViewGroup.MarginLayoutParams) layoutParams).width == -1) {
                if (layoutParams.constrainedWidth) {
                    constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
                } else {
                    constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
                }
                constraintWidget.getAnchor(ConstraintAnchor.Type.LEFT).mMargin = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                constraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT).mMargin = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
            } else {
                constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
                constraintWidget.setWidth(0);
            }
        } else {
            constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
            constraintWidget.setWidth(((ViewGroup.MarginLayoutParams) layoutParams).width);
            if (((ViewGroup.MarginLayoutParams) layoutParams).width == -2) {
                constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
            }
        }
        if (!layoutParams.verticalDimensionFixed) {
            if (((ViewGroup.MarginLayoutParams) layoutParams).height == -1) {
                if (layoutParams.constrainedHeight) {
                    constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
                } else {
                    constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
                }
                constraintWidget.getAnchor(ConstraintAnchor.Type.TOP).mMargin = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                constraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM).mMargin = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
            } else {
                constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
                constraintWidget.setHeight(0);
            }
        } else {
            constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
            constraintWidget.setHeight(((ViewGroup.MarginLayoutParams) layoutParams).height);
            if (((ViewGroup.MarginLayoutParams) layoutParams).height == -2) {
                constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
            }
        }
        constraintWidget.setDimensionRatio(layoutParams.dimensionRatio);
        constraintWidget.setHorizontalWeight(layoutParams.horizontalWeight);
        constraintWidget.setVerticalWeight(layoutParams.verticalWeight);
        constraintWidget.setHorizontalChainStyle(layoutParams.horizontalChainStyle);
        constraintWidget.setVerticalChainStyle(layoutParams.verticalChainStyle);
        constraintWidget.setHorizontalMatchStyle(layoutParams.matchConstraintDefaultWidth, layoutParams.matchConstraintMinWidth, layoutParams.matchConstraintMaxWidth, layoutParams.matchConstraintPercentWidth);
        constraintWidget.setVerticalMatchStyle(layoutParams.matchConstraintDefaultHeight, layoutParams.matchConstraintMinHeight, layoutParams.matchConstraintMaxHeight, layoutParams.matchConstraintPercentHeight);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Object tag;
        int size;
        ArrayList<ConstraintHelper> arrayList = this.mConstraintHelpers;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            for (int i3 = 0; i3 < size; i3++) {
                this.mConstraintHelpers.get(i3).updatePreDraw(this);
            }
        }
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            int childCount = getChildCount();
            float width = getWidth();
            float height = getHeight();
            for (int i16 = 0; i16 < childCount; i16++) {
                View childAt = getChildAt(i16);
                if (childAt.getVisibility() != 8 && (tag = childAt.getTag()) != null && (tag instanceof String)) {
                    String[] split = ((String) tag).split(",");
                    if (split.length == 4) {
                        int parseInt = Integer.parseInt(split[0]);
                        int parseInt2 = Integer.parseInt(split[1]);
                        int parseInt3 = Integer.parseInt(split[2]);
                        int i17 = (int) ((parseInt / 1080.0f) * width);
                        int i18 = (int) ((parseInt2 / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(SupportMenu.CATEGORY_MASK);
                        float f16 = i17;
                        float f17 = i18;
                        float f18 = i17 + ((int) ((parseInt3 / 1080.0f) * width));
                        canvas.drawLine(f16, f17, f18, f17, paint);
                        float parseInt4 = i18 + ((int) ((Integer.parseInt(split[3]) / 1920.0f) * height));
                        canvas.drawLine(f18, f17, f18, parseInt4, paint);
                        canvas.drawLine(f18, parseInt4, f16, parseInt4, paint);
                        canvas.drawLine(f16, parseInt4, f16, f17, paint);
                        paint.setColor(-16711936);
                        canvas.drawLine(f16, f17, f18, parseInt4, paint);
                        canvas.drawLine(f16, parseInt4, f18, f17, paint);
                    }
                }
            }
        }
    }

    public void fillMetrics(Metrics metrics) {
        this.mMetrics = metrics;
        this.mLayoutWidget.fillMetrics(metrics);
    }

    @Override // android.view.View
    public void forceLayout() {
        markHierarchyDirty();
        super.forceLayout();
    }

    public Object getDesignInformation(int i3, Object obj) {
        if (i3 == 0 && (obj instanceof String)) {
            String str = (String) obj;
            HashMap<String, Integer> hashMap = this.mDesignIds;
            if (hashMap != null && hashMap.containsKey(str)) {
                return this.mDesignIds.get(str);
            }
            return null;
        }
        return null;
    }

    public int getMaxHeight() {
        return this.mMaxHeight;
    }

    public int getMaxWidth() {
        return this.mMaxWidth;
    }

    public int getMinHeight() {
        return this.mMinHeight;
    }

    public int getMinWidth() {
        return this.mMinWidth;
    }

    public int getOptimizationLevel() {
        return this.mLayoutWidget.getOptimizationLevel();
    }

    public View getViewById(int i3) {
        return this.mChildrenByIds.get(i3);
    }

    public final ConstraintWidget getViewWidget(View view) {
        if (view == this) {
            return this.mLayoutWidget;
        }
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).widget;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isRtl() {
        boolean z16;
        if ((getContext().getApplicationInfo().flags & 4194304) != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 || 1 != getLayoutDirection()) {
            return false;
        }
        return true;
    }

    public void loadLayoutDescription(int i3) {
        if (i3 != 0) {
            try {
                this.mConstraintLayoutSpec = new ConstraintLayoutStates(getContext(), this, i3);
                return;
            } catch (Resources.NotFoundException unused) {
                this.mConstraintLayoutSpec = null;
                return;
            }
        }
        this.mConstraintLayoutSpec = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        View content;
        int childCount = getChildCount();
        boolean isInEditMode = isInEditMode();
        for (int i19 = 0; i19 < childCount; i19++) {
            View childAt = getChildAt(i19);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            ConstraintWidget constraintWidget = layoutParams.widget;
            if ((childAt.getVisibility() != 8 || layoutParams.isGuideline || layoutParams.isHelper || layoutParams.isVirtualGroup || isInEditMode) && !layoutParams.isInPlaceholder) {
                int x16 = constraintWidget.getX();
                int y16 = constraintWidget.getY();
                int width = constraintWidget.getWidth() + x16;
                int height = constraintWidget.getHeight() + y16;
                childAt.layout(x16, y16, width, height);
                if ((childAt instanceof Placeholder) && (content = ((Placeholder) childAt).getContent()) != null) {
                    content.setVisibility(0);
                    content.layout(x16, y16, width, height);
                }
            }
        }
        int size = this.mConstraintHelpers.size();
        if (size > 0) {
            for (int i26 = 0; i26 < size; i26++) {
                this.mConstraintHelpers.get(i26).updatePostLayout(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i3, int i16) {
        if (!this.mDirtyHierarchy) {
            int childCount = getChildCount();
            int i17 = 0;
            while (true) {
                if (i17 >= childCount) {
                    break;
                }
                if (getChildAt(i17).isLayoutRequested()) {
                    this.mDirtyHierarchy = true;
                    break;
                }
                i17++;
            }
        }
        if (!this.mDirtyHierarchy) {
            int i18 = this.mOnMeasureWidthMeasureSpec;
            if (i18 == i3 && this.mOnMeasureHeightMeasureSpec == i16) {
                resolveMeasuredDimension(i3, i16, this.mLayoutWidget.getWidth(), this.mLayoutWidget.getHeight(), this.mLayoutWidget.isWidthMeasuredTooSmall(), this.mLayoutWidget.isHeightMeasuredTooSmall());
                return;
            }
            if (i18 == i3 && View.MeasureSpec.getMode(i3) == 1073741824 && View.MeasureSpec.getMode(i16) == Integer.MIN_VALUE && View.MeasureSpec.getMode(this.mOnMeasureHeightMeasureSpec) == Integer.MIN_VALUE && View.MeasureSpec.getSize(i16) >= this.mLayoutWidget.getHeight()) {
                this.mOnMeasureWidthMeasureSpec = i3;
                this.mOnMeasureHeightMeasureSpec = i16;
                resolveMeasuredDimension(i3, i16, this.mLayoutWidget.getWidth(), this.mLayoutWidget.getHeight(), this.mLayoutWidget.isWidthMeasuredTooSmall(), this.mLayoutWidget.isHeightMeasuredTooSmall());
                return;
            }
        }
        this.mOnMeasureWidthMeasureSpec = i3;
        this.mOnMeasureHeightMeasureSpec = i16;
        this.mLayoutWidget.setRtl(isRtl());
        if (this.mDirtyHierarchy) {
            this.mDirtyHierarchy = false;
            if (updateHierarchy()) {
                this.mLayoutWidget.updateHierarchy();
            }
        }
        resolveSystem(this.mLayoutWidget, this.mOptimizationLevel, i3, i16);
        resolveMeasuredDimension(i3, i16, this.mLayoutWidget.getWidth(), this.mLayoutWidget.getHeight(), this.mLayoutWidget.isWidthMeasuredTooSmall(), this.mLayoutWidget.isHeightMeasuredTooSmall());
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        ConstraintWidget viewWidget = getViewWidget(view);
        if ((view instanceof Guideline) && !(viewWidget instanceof androidx.constraintlayout.solver.widgets.Guideline)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            androidx.constraintlayout.solver.widgets.Guideline guideline = new androidx.constraintlayout.solver.widgets.Guideline();
            layoutParams.widget = guideline;
            layoutParams.isGuideline = true;
            guideline.setOrientation(layoutParams.orientation);
        }
        if (view instanceof ConstraintHelper) {
            ConstraintHelper constraintHelper = (ConstraintHelper) view;
            constraintHelper.validateParams();
            ((LayoutParams) view.getLayoutParams()).isHelper = true;
            if (!this.mConstraintHelpers.contains(constraintHelper)) {
                this.mConstraintHelpers.add(constraintHelper);
            }
        }
        this.mChildrenByIds.put(view.getId(), view);
        this.mDirtyHierarchy = true;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        this.mChildrenByIds.remove(view.getId());
        this.mLayoutWidget.remove(getViewWidget(view));
        this.mConstraintHelpers.remove(view);
        this.mDirtyHierarchy = true;
    }

    protected void parseLayoutDescription(int i3) {
        this.mConstraintLayoutSpec = new ConstraintLayoutStates(getContext(), this, i3);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        super.removeView(view);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        markHierarchyDirty();
        super.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void resolveMeasuredDimension(int i3, int i16, int i17, int i18, boolean z16, boolean z17) {
        Measurer measurer = this.mMeasurer;
        int i19 = measurer.paddingHeight;
        int resolveSizeAndState = View.resolveSizeAndState(i17 + measurer.paddingWidth, i3, 0);
        int resolveSizeAndState2 = View.resolveSizeAndState(i18 + i19, i16, 0) & 16777215;
        int min = Math.min(this.mMaxWidth, resolveSizeAndState & 16777215);
        int min2 = Math.min(this.mMaxHeight, resolveSizeAndState2);
        if (z16) {
            min |= 16777216;
        }
        if (z17) {
            min2 |= 16777216;
        }
        setMeasuredDimension(min, min2);
        this.mLastMeasureWidth = min;
        this.mLastMeasureHeight = min2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void resolveSystem(ConstraintWidgetContainer constraintWidgetContainer, int i3, int i16, int i17) {
        int i18;
        int mode = View.MeasureSpec.getMode(i16);
        int size = View.MeasureSpec.getSize(i16);
        int mode2 = View.MeasureSpec.getMode(i17);
        int size2 = View.MeasureSpec.getSize(i17);
        int max = Math.max(0, getPaddingTop());
        int max2 = Math.max(0, getPaddingBottom());
        int i19 = max + max2;
        int paddingWidth = getPaddingWidth();
        this.mMeasurer.captureLayoutInfos(i16, i17, max, max2, paddingWidth, i19);
        int max3 = Math.max(0, getPaddingStart());
        int max4 = Math.max(0, getPaddingEnd());
        if (max3 <= 0 && max4 <= 0) {
            i18 = Math.max(0, getPaddingLeft());
        } else if (isRtl()) {
            i18 = max4;
        } else {
            i18 = max3;
        }
        int i26 = size - paddingWidth;
        int i27 = size2 - i19;
        setSelfDimensionBehaviour(constraintWidgetContainer, mode, i26, mode2, i27);
        constraintWidgetContainer.measure(i3, mode, i26, mode2, i27, this.mLastMeasureWidth, this.mLastMeasureHeight, i18, max);
    }

    public void setConstraintSet(ConstraintSet constraintSet) {
        this.mConstraintSet = constraintSet;
    }

    public void setDesignInformation(int i3, Object obj, Object obj2) {
        if (i3 == 0 && (obj instanceof String) && (obj2 instanceof Integer)) {
            if (this.mDesignIds == null) {
                this.mDesignIds = new HashMap<>();
            }
            String str = (String) obj;
            int indexOf = str.indexOf("/");
            if (indexOf != -1) {
                str = str.substring(indexOf + 1);
            }
            this.mDesignIds.put(str, Integer.valueOf(((Integer) obj2).intValue()));
        }
    }

    @Override // android.view.View
    public void setId(int i3) {
        this.mChildrenByIds.remove(getId());
        super.setId(i3);
        this.mChildrenByIds.put(getId(), this);
    }

    public void setMaxHeight(int i3) {
        if (i3 == this.mMaxHeight) {
            return;
        }
        this.mMaxHeight = i3;
        requestLayout();
    }

    public void setMaxWidth(int i3) {
        if (i3 == this.mMaxWidth) {
            return;
        }
        this.mMaxWidth = i3;
        requestLayout();
    }

    public void setMinHeight(int i3) {
        if (i3 == this.mMinHeight) {
            return;
        }
        this.mMinHeight = i3;
        requestLayout();
    }

    public void setMinWidth(int i3) {
        if (i3 == this.mMinWidth) {
            return;
        }
        this.mMinWidth = i3;
        requestLayout();
    }

    public void setOnConstraintsChanged(ConstraintsChangedListener constraintsChangedListener) {
        this.mConstraintsChangedListener = constraintsChangedListener;
        ConstraintLayoutStates constraintLayoutStates = this.mConstraintLayoutSpec;
        if (constraintLayoutStates != null) {
            constraintLayoutStates.setOnConstraintsChanged(constraintsChangedListener);
        }
    }

    public void setOptimizationLevel(int i3) {
        this.mOptimizationLevel = i3;
        this.mLayoutWidget.setOptimizationLevel(i3);
    }

    protected void setSelfDimensionBehaviour(ConstraintWidgetContainer constraintWidgetContainer, int i3, int i16, int i17, int i18) {
        ConstraintWidget.DimensionBehaviour dimensionBehaviour;
        Measurer measurer = this.mMeasurer;
        int i19 = measurer.paddingHeight;
        int i26 = measurer.paddingWidth;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.FIXED;
        int childCount = getChildCount();
        if (i3 != Integer.MIN_VALUE) {
            if (i3 != 0) {
                if (i3 != 1073741824) {
                    dimensionBehaviour = dimensionBehaviour2;
                    i16 = 0;
                } else {
                    i16 = Math.min(this.mMaxWidth - i26, i16);
                    dimensionBehaviour = dimensionBehaviour2;
                }
            } else {
                dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                if (childCount == 0) {
                    i16 = Math.max(0, this.mMinWidth);
                }
                i16 = 0;
            }
        } else {
            dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            if (childCount == 0) {
                i16 = Math.max(0, this.mMinWidth);
            }
        }
        if (i17 != Integer.MIN_VALUE) {
            if (i17 != 0) {
                if (i17 == 1073741824) {
                    i18 = Math.min(this.mMaxHeight - i19, i18);
                }
                i18 = 0;
            } else {
                dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                if (childCount == 0) {
                    i18 = Math.max(0, this.mMinHeight);
                }
                i18 = 0;
            }
        } else {
            dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            if (childCount == 0) {
                i18 = Math.max(0, this.mMinHeight);
            }
        }
        if (i16 != constraintWidgetContainer.getWidth() || i18 != constraintWidgetContainer.getHeight()) {
            constraintWidgetContainer.invalidateMeasures();
        }
        constraintWidgetContainer.setX(0);
        constraintWidgetContainer.setY(0);
        constraintWidgetContainer.setMaxWidth(this.mMaxWidth - i26);
        constraintWidgetContainer.setMaxHeight(this.mMaxHeight - i19);
        constraintWidgetContainer.setMinWidth(0);
        constraintWidgetContainer.setMinHeight(0);
        constraintWidgetContainer.setHorizontalDimensionBehaviour(dimensionBehaviour);
        constraintWidgetContainer.setWidth(i16);
        constraintWidgetContainer.setVerticalDimensionBehaviour(dimensionBehaviour2);
        constraintWidgetContainer.setHeight(i18);
        constraintWidgetContainer.setMinWidth(this.mMinWidth - i26);
        constraintWidgetContainer.setMinHeight(this.mMinHeight - i19);
    }

    public void setState(int i3, int i16, int i17) {
        ConstraintLayoutStates constraintLayoutStates = this.mConstraintLayoutSpec;
        if (constraintLayoutStates != null) {
            constraintLayoutStates.updateConstraints(i3, i16, i17);
        }
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public ConstraintLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mChildrenByIds = new SparseArray<>();
        this.mConstraintHelpers = new ArrayList<>(4);
        this.mLayoutWidget = new ConstraintWidgetContainer();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mDirtyHierarchy = true;
        this.mOptimizationLevel = 257;
        this.mConstraintSet = null;
        this.mConstraintLayoutSpec = null;
        this.mConstraintSetId = -1;
        this.mDesignIds = new HashMap<>();
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        this.mTempMapIdToWidget = new SparseArray<>();
        this.mMeasurer = new Measurer(this);
        this.mOnMeasureWidthMeasureSpec = 0;
        this.mOnMeasureHeightMeasureSpec = 0;
        init(attributeSet, 0, 0);
    }

    public ConstraintLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mChildrenByIds = new SparseArray<>();
        this.mConstraintHelpers = new ArrayList<>(4);
        this.mLayoutWidget = new ConstraintWidgetContainer();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mDirtyHierarchy = true;
        this.mOptimizationLevel = 257;
        this.mConstraintSet = null;
        this.mConstraintLayoutSpec = null;
        this.mConstraintSetId = -1;
        this.mDesignIds = new HashMap<>();
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        this.mTempMapIdToWidget = new SparseArray<>();
        this.mMeasurer = new Measurer(this);
        this.mOnMeasureWidthMeasureSpec = 0;
        this.mOnMeasureHeightMeasureSpec = 0;
        init(attributeSet, i3, 0);
    }

    @TargetApi(21)
    public ConstraintLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        this.mChildrenByIds = new SparseArray<>();
        this.mConstraintHelpers = new ArrayList<>(4);
        this.mLayoutWidget = new ConstraintWidgetContainer();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mDirtyHierarchy = true;
        this.mOptimizationLevel = 257;
        this.mConstraintSet = null;
        this.mConstraintLayoutSpec = null;
        this.mConstraintSetId = -1;
        this.mDesignIds = new HashMap<>();
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        this.mTempMapIdToWidget = new SparseArray<>();
        this.mMeasurer = new Measurer(this);
        this.mOnMeasureWidthMeasureSpec = 0;
        this.mOnMeasureHeightMeasureSpec = 0;
        init(attributeSet, i3, i16);
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public static final int BASELINE = 5;
        public static final int BOTTOM = 4;
        public static final int CHAIN_PACKED = 2;
        public static final int CHAIN_SPREAD = 0;
        public static final int CHAIN_SPREAD_INSIDE = 1;
        public static final int END = 7;
        public static final int HORIZONTAL = 0;
        public static final int LEFT = 1;
        public static final int MATCH_CONSTRAINT = 0;
        public static final int MATCH_CONSTRAINT_PERCENT = 2;
        public static final int MATCH_CONSTRAINT_SPREAD = 0;
        public static final int MATCH_CONSTRAINT_WRAP = 1;
        public static final int PARENT_ID = 0;
        public static final int RIGHT = 2;
        public static final int START = 6;
        public static final int TOP = 3;
        public static final int UNSET = -1;
        public static final int VERTICAL = 1;
        public int baselineToBaseline;
        public int bottomToBottom;
        public int bottomToTop;
        public float circleAngle;
        public int circleConstraint;
        public int circleRadius;
        public boolean constrainedHeight;
        public boolean constrainedWidth;
        public String constraintTag;
        public String dimensionRatio;
        int dimensionRatioSide;
        float dimensionRatioValue;
        public int editorAbsoluteX;
        public int editorAbsoluteY;
        public int endToEnd;
        public int endToStart;
        public int goneBottomMargin;
        public int goneEndMargin;
        public int goneLeftMargin;
        public int goneRightMargin;
        public int goneStartMargin;
        public int goneTopMargin;
        public int guideBegin;
        public int guideEnd;
        public float guidePercent;
        public boolean helped;
        public float horizontalBias;
        public int horizontalChainStyle;
        boolean horizontalDimensionFixed;
        public float horizontalWeight;
        boolean isGuideline;
        boolean isHelper;
        boolean isInPlaceholder;
        boolean isVirtualGroup;
        public int leftToLeft;
        public int leftToRight;
        public int matchConstraintDefaultHeight;
        public int matchConstraintDefaultWidth;
        public int matchConstraintMaxHeight;
        public int matchConstraintMaxWidth;
        public int matchConstraintMinHeight;
        public int matchConstraintMinWidth;
        public float matchConstraintPercentHeight;
        public float matchConstraintPercentWidth;
        boolean needsBaseline;
        public int orientation;
        int resolveGoneLeftMargin;
        int resolveGoneRightMargin;
        int resolvedGuideBegin;
        int resolvedGuideEnd;
        float resolvedGuidePercent;
        float resolvedHorizontalBias;
        int resolvedLeftToLeft;
        int resolvedLeftToRight;
        int resolvedRightToLeft;
        int resolvedRightToRight;
        public int rightToLeft;
        public int rightToRight;
        public int startToEnd;
        public int startToStart;
        public int topToBottom;
        public int topToTop;
        public float verticalBias;
        public int verticalChainStyle;
        boolean verticalDimensionFixed;
        public float verticalWeight;
        ConstraintWidget widget;

        /* compiled from: P */
        /* loaded from: classes.dex */
        private static class Table {
            public static final int ANDROID_ORIENTATION = 1;
            public static final int LAYOUT_CONSTRAINED_HEIGHT = 28;
            public static final int LAYOUT_CONSTRAINED_WIDTH = 27;
            public static final int LAYOUT_CONSTRAINT_BASELINE_CREATOR = 43;
            public static final int LAYOUT_CONSTRAINT_BASELINE_TO_BASELINE_OF = 16;
            public static final int LAYOUT_CONSTRAINT_BOTTOM_CREATOR = 42;
            public static final int LAYOUT_CONSTRAINT_BOTTOM_TO_BOTTOM_OF = 15;
            public static final int LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF = 14;
            public static final int LAYOUT_CONSTRAINT_CIRCLE = 2;
            public static final int LAYOUT_CONSTRAINT_CIRCLE_ANGLE = 4;
            public static final int LAYOUT_CONSTRAINT_CIRCLE_RADIUS = 3;
            public static final int LAYOUT_CONSTRAINT_DIMENSION_RATIO = 44;
            public static final int LAYOUT_CONSTRAINT_END_TO_END_OF = 20;
            public static final int LAYOUT_CONSTRAINT_END_TO_START_OF = 19;
            public static final int LAYOUT_CONSTRAINT_GUIDE_BEGIN = 5;
            public static final int LAYOUT_CONSTRAINT_GUIDE_END = 6;
            public static final int LAYOUT_CONSTRAINT_GUIDE_PERCENT = 7;
            public static final int LAYOUT_CONSTRAINT_HEIGHT_DEFAULT = 32;
            public static final int LAYOUT_CONSTRAINT_HEIGHT_MAX = 37;
            public static final int LAYOUT_CONSTRAINT_HEIGHT_MIN = 36;
            public static final int LAYOUT_CONSTRAINT_HEIGHT_PERCENT = 38;
            public static final int LAYOUT_CONSTRAINT_HORIZONTAL_BIAS = 29;
            public static final int LAYOUT_CONSTRAINT_HORIZONTAL_CHAINSTYLE = 47;
            public static final int LAYOUT_CONSTRAINT_HORIZONTAL_WEIGHT = 45;
            public static final int LAYOUT_CONSTRAINT_LEFT_CREATOR = 39;
            public static final int LAYOUT_CONSTRAINT_LEFT_TO_LEFT_OF = 8;
            public static final int LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF = 9;
            public static final int LAYOUT_CONSTRAINT_RIGHT_CREATOR = 41;
            public static final int LAYOUT_CONSTRAINT_RIGHT_TO_LEFT_OF = 10;
            public static final int LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF = 11;
            public static final int LAYOUT_CONSTRAINT_START_TO_END_OF = 17;
            public static final int LAYOUT_CONSTRAINT_START_TO_START_OF = 18;
            public static final int LAYOUT_CONSTRAINT_TAG = 51;
            public static final int LAYOUT_CONSTRAINT_TOP_CREATOR = 40;
            public static final int LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF = 13;
            public static final int LAYOUT_CONSTRAINT_TOP_TO_TOP_OF = 12;
            public static final int LAYOUT_CONSTRAINT_VERTICAL_BIAS = 30;
            public static final int LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE = 48;
            public static final int LAYOUT_CONSTRAINT_VERTICAL_WEIGHT = 46;
            public static final int LAYOUT_CONSTRAINT_WIDTH_DEFAULT = 31;
            public static final int LAYOUT_CONSTRAINT_WIDTH_MAX = 34;
            public static final int LAYOUT_CONSTRAINT_WIDTH_MIN = 33;
            public static final int LAYOUT_CONSTRAINT_WIDTH_PERCENT = 35;
            public static final int LAYOUT_EDITOR_ABSOLUTEX = 49;
            public static final int LAYOUT_EDITOR_ABSOLUTEY = 50;
            public static final int LAYOUT_GONE_MARGIN_BOTTOM = 24;
            public static final int LAYOUT_GONE_MARGIN_END = 26;
            public static final int LAYOUT_GONE_MARGIN_LEFT = 21;
            public static final int LAYOUT_GONE_MARGIN_RIGHT = 23;
            public static final int LAYOUT_GONE_MARGIN_START = 25;
            public static final int LAYOUT_GONE_MARGIN_TOP = 22;
            public static final int UNUSED = 0;
            public static final SparseIntArray map;

            static {
                SparseIntArray sparseIntArray = new SparseIntArray();
                map = sparseIntArray;
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf, 8);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toRightOf, 9);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_toLeftOf, 10);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_toRightOf, 11);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_toTopOf, 12);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_toBottomOf, 13);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toTopOf, 14);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf, 15);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf, 16);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircle, 2);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircleRadius, 3);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircleAngle, 4);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_editor_absoluteX, 49);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_editor_absoluteY, 50);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_begin, 5);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_end, 6);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_percent, 7);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_android_orientation, 1);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintStart_toEndOf, 17);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintStart_toStartOf, 18);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toStartOf, 19);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toEndOf, 20);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginLeft, 21);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginTop, 22);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginRight, 23);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginBottom, 24);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginStart, 25);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginEnd, 26);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_bias, 29);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_bias, 30);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintDimensionRatio, 44);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_weight, 45);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_weight, 46);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle, 47);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_chainStyle, 48);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constrainedWidth, 27);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constrainedHeight, 28);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_default, 31);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_default, 32);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_min, 33);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_max, 34);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_percent, 35);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_min, 36);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_max, 37);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_percent, 38);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_creator, 39);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_creator, 40);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_creator, 41);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_creator, 42);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_creator, 43);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintTag, 51);
            }

            Table() {
            }
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.guideBegin = -1;
            this.guideEnd = -1;
            this.guidePercent = -1.0f;
            this.leftToLeft = -1;
            this.leftToRight = -1;
            this.rightToLeft = -1;
            this.rightToRight = -1;
            this.topToTop = -1;
            this.topToBottom = -1;
            this.bottomToTop = -1;
            this.bottomToBottom = -1;
            this.baselineToBaseline = -1;
            this.circleConstraint = -1;
            this.circleRadius = 0;
            this.circleAngle = 0.0f;
            this.startToEnd = -1;
            this.startToStart = -1;
            this.endToStart = -1;
            this.endToEnd = -1;
            this.goneLeftMargin = -1;
            this.goneTopMargin = -1;
            this.goneRightMargin = -1;
            this.goneBottomMargin = -1;
            this.goneStartMargin = -1;
            this.goneEndMargin = -1;
            this.horizontalBias = 0.5f;
            this.verticalBias = 0.5f;
            this.dimensionRatio = null;
            this.dimensionRatioValue = 0.0f;
            this.dimensionRatioSide = 1;
            this.horizontalWeight = -1.0f;
            this.verticalWeight = -1.0f;
            this.horizontalChainStyle = 0;
            this.verticalChainStyle = 0;
            this.matchConstraintDefaultWidth = 0;
            this.matchConstraintDefaultHeight = 0;
            this.matchConstraintMinWidth = 0;
            this.matchConstraintMinHeight = 0;
            this.matchConstraintMaxWidth = 0;
            this.matchConstraintMaxHeight = 0;
            this.matchConstraintPercentWidth = 1.0f;
            this.matchConstraintPercentHeight = 1.0f;
            this.editorAbsoluteX = -1;
            this.editorAbsoluteY = -1;
            this.orientation = -1;
            this.constrainedWidth = false;
            this.constrainedHeight = false;
            this.constraintTag = null;
            this.horizontalDimensionFixed = true;
            this.verticalDimensionFixed = true;
            this.needsBaseline = false;
            this.isGuideline = false;
            this.isHelper = false;
            this.isInPlaceholder = false;
            this.isVirtualGroup = false;
            this.resolvedLeftToLeft = -1;
            this.resolvedLeftToRight = -1;
            this.resolvedRightToLeft = -1;
            this.resolvedRightToRight = -1;
            this.resolveGoneLeftMargin = -1;
            this.resolveGoneRightMargin = -1;
            this.resolvedHorizontalBias = 0.5f;
            this.widget = new ConstraintWidget();
            this.helped = false;
            this.guideBegin = layoutParams.guideBegin;
            this.guideEnd = layoutParams.guideEnd;
            this.guidePercent = layoutParams.guidePercent;
            this.leftToLeft = layoutParams.leftToLeft;
            this.leftToRight = layoutParams.leftToRight;
            this.rightToLeft = layoutParams.rightToLeft;
            this.rightToRight = layoutParams.rightToRight;
            this.topToTop = layoutParams.topToTop;
            this.topToBottom = layoutParams.topToBottom;
            this.bottomToTop = layoutParams.bottomToTop;
            this.bottomToBottom = layoutParams.bottomToBottom;
            this.baselineToBaseline = layoutParams.baselineToBaseline;
            this.circleConstraint = layoutParams.circleConstraint;
            this.circleRadius = layoutParams.circleRadius;
            this.circleAngle = layoutParams.circleAngle;
            this.startToEnd = layoutParams.startToEnd;
            this.startToStart = layoutParams.startToStart;
            this.endToStart = layoutParams.endToStart;
            this.endToEnd = layoutParams.endToEnd;
            this.goneLeftMargin = layoutParams.goneLeftMargin;
            this.goneTopMargin = layoutParams.goneTopMargin;
            this.goneRightMargin = layoutParams.goneRightMargin;
            this.goneBottomMargin = layoutParams.goneBottomMargin;
            this.goneStartMargin = layoutParams.goneStartMargin;
            this.goneEndMargin = layoutParams.goneEndMargin;
            this.horizontalBias = layoutParams.horizontalBias;
            this.verticalBias = layoutParams.verticalBias;
            this.dimensionRatio = layoutParams.dimensionRatio;
            this.dimensionRatioValue = layoutParams.dimensionRatioValue;
            this.dimensionRatioSide = layoutParams.dimensionRatioSide;
            this.horizontalWeight = layoutParams.horizontalWeight;
            this.verticalWeight = layoutParams.verticalWeight;
            this.horizontalChainStyle = layoutParams.horizontalChainStyle;
            this.verticalChainStyle = layoutParams.verticalChainStyle;
            this.constrainedWidth = layoutParams.constrainedWidth;
            this.constrainedHeight = layoutParams.constrainedHeight;
            this.matchConstraintDefaultWidth = layoutParams.matchConstraintDefaultWidth;
            this.matchConstraintDefaultHeight = layoutParams.matchConstraintDefaultHeight;
            this.matchConstraintMinWidth = layoutParams.matchConstraintMinWidth;
            this.matchConstraintMaxWidth = layoutParams.matchConstraintMaxWidth;
            this.matchConstraintMinHeight = layoutParams.matchConstraintMinHeight;
            this.matchConstraintMaxHeight = layoutParams.matchConstraintMaxHeight;
            this.matchConstraintPercentWidth = layoutParams.matchConstraintPercentWidth;
            this.matchConstraintPercentHeight = layoutParams.matchConstraintPercentHeight;
            this.editorAbsoluteX = layoutParams.editorAbsoluteX;
            this.editorAbsoluteY = layoutParams.editorAbsoluteY;
            this.orientation = layoutParams.orientation;
            this.horizontalDimensionFixed = layoutParams.horizontalDimensionFixed;
            this.verticalDimensionFixed = layoutParams.verticalDimensionFixed;
            this.needsBaseline = layoutParams.needsBaseline;
            this.isGuideline = layoutParams.isGuideline;
            this.resolvedLeftToLeft = layoutParams.resolvedLeftToLeft;
            this.resolvedLeftToRight = layoutParams.resolvedLeftToRight;
            this.resolvedRightToLeft = layoutParams.resolvedRightToLeft;
            this.resolvedRightToRight = layoutParams.resolvedRightToRight;
            this.resolveGoneLeftMargin = layoutParams.resolveGoneLeftMargin;
            this.resolveGoneRightMargin = layoutParams.resolveGoneRightMargin;
            this.resolvedHorizontalBias = layoutParams.resolvedHorizontalBias;
            this.constraintTag = layoutParams.constraintTag;
            this.widget = layoutParams.widget;
        }

        public String getConstraintTag() {
            return this.constraintTag;
        }

        public ConstraintWidget getConstraintWidget() {
            return this.widget;
        }

        public void reset() {
            ConstraintWidget constraintWidget = this.widget;
            if (constraintWidget != null) {
                constraintWidget.reset();
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0048  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x004f  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0056  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x005c  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0062  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x0074  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x007c  */
        @Override // android.view.ViewGroup.MarginLayoutParams, android.view.ViewGroup.LayoutParams
        @TargetApi(17)
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void resolveLayoutDirection(int i3) {
            boolean z16;
            int i16;
            int i17;
            int i18;
            int i19;
            int i26 = ((ViewGroup.MarginLayoutParams) this).leftMargin;
            int i27 = ((ViewGroup.MarginLayoutParams) this).rightMargin;
            super.resolveLayoutDirection(i3);
            boolean z17 = false;
            if (1 == getLayoutDirection()) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.resolvedRightToLeft = -1;
            this.resolvedRightToRight = -1;
            this.resolvedLeftToLeft = -1;
            this.resolvedLeftToRight = -1;
            this.resolveGoneLeftMargin = this.goneLeftMargin;
            this.resolveGoneRightMargin = this.goneRightMargin;
            float f16 = this.horizontalBias;
            this.resolvedHorizontalBias = f16;
            int i28 = this.guideBegin;
            this.resolvedGuideBegin = i28;
            int i29 = this.guideEnd;
            this.resolvedGuideEnd = i29;
            float f17 = this.guidePercent;
            this.resolvedGuidePercent = f17;
            if (z16) {
                int i36 = this.startToEnd;
                if (i36 != -1) {
                    this.resolvedRightToLeft = i36;
                } else {
                    int i37 = this.startToStart;
                    if (i37 != -1) {
                        this.resolvedRightToRight = i37;
                    }
                    i16 = this.endToStart;
                    if (i16 != -1) {
                        this.resolvedLeftToRight = i16;
                        z17 = true;
                    }
                    i17 = this.endToEnd;
                    if (i17 != -1) {
                        this.resolvedLeftToLeft = i17;
                        z17 = true;
                    }
                    i18 = this.goneStartMargin;
                    if (i18 != -1) {
                        this.resolveGoneRightMargin = i18;
                    }
                    i19 = this.goneEndMargin;
                    if (i19 != -1) {
                        this.resolveGoneLeftMargin = i19;
                    }
                    if (z17) {
                        this.resolvedHorizontalBias = 1.0f - f16;
                    }
                    if (this.isGuideline && this.orientation == 1) {
                        if (f17 == -1.0f) {
                            this.resolvedGuidePercent = 1.0f - f17;
                            this.resolvedGuideBegin = -1;
                            this.resolvedGuideEnd = -1;
                        } else if (i28 != -1) {
                            this.resolvedGuideEnd = i28;
                            this.resolvedGuideBegin = -1;
                            this.resolvedGuidePercent = -1.0f;
                        } else if (i29 != -1) {
                            this.resolvedGuideBegin = i29;
                            this.resolvedGuideEnd = -1;
                            this.resolvedGuidePercent = -1.0f;
                        }
                    }
                }
                z17 = true;
                i16 = this.endToStart;
                if (i16 != -1) {
                }
                i17 = this.endToEnd;
                if (i17 != -1) {
                }
                i18 = this.goneStartMargin;
                if (i18 != -1) {
                }
                i19 = this.goneEndMargin;
                if (i19 != -1) {
                }
                if (z17) {
                }
                if (this.isGuideline) {
                    if (f17 == -1.0f) {
                    }
                }
            } else {
                int i38 = this.startToEnd;
                if (i38 != -1) {
                    this.resolvedLeftToRight = i38;
                }
                int i39 = this.startToStart;
                if (i39 != -1) {
                    this.resolvedLeftToLeft = i39;
                }
                int i46 = this.endToStart;
                if (i46 != -1) {
                    this.resolvedRightToLeft = i46;
                }
                int i47 = this.endToEnd;
                if (i47 != -1) {
                    this.resolvedRightToRight = i47;
                }
                int i48 = this.goneStartMargin;
                if (i48 != -1) {
                    this.resolveGoneLeftMargin = i48;
                }
                int i49 = this.goneEndMargin;
                if (i49 != -1) {
                    this.resolveGoneRightMargin = i49;
                }
            }
            if (this.endToStart == -1 && this.endToEnd == -1 && this.startToStart == -1 && this.startToEnd == -1) {
                int i56 = this.rightToLeft;
                if (i56 != -1) {
                    this.resolvedRightToLeft = i56;
                    if (((ViewGroup.MarginLayoutParams) this).rightMargin <= 0 && i27 > 0) {
                        ((ViewGroup.MarginLayoutParams) this).rightMargin = i27;
                    }
                } else {
                    int i57 = this.rightToRight;
                    if (i57 != -1) {
                        this.resolvedRightToRight = i57;
                        if (((ViewGroup.MarginLayoutParams) this).rightMargin <= 0 && i27 > 0) {
                            ((ViewGroup.MarginLayoutParams) this).rightMargin = i27;
                        }
                    }
                }
                int i58 = this.leftToLeft;
                if (i58 != -1) {
                    this.resolvedLeftToLeft = i58;
                    if (((ViewGroup.MarginLayoutParams) this).leftMargin <= 0 && i26 > 0) {
                        ((ViewGroup.MarginLayoutParams) this).leftMargin = i26;
                        return;
                    }
                    return;
                }
                int i59 = this.leftToRight;
                if (i59 != -1) {
                    this.resolvedLeftToRight = i59;
                    if (((ViewGroup.MarginLayoutParams) this).leftMargin <= 0 && i26 > 0) {
                        ((ViewGroup.MarginLayoutParams) this).leftMargin = i26;
                    }
                }
            }
        }

        public void setWidgetDebugName(String str) {
            this.widget.setDebugName(str);
        }

        public void validate() {
            this.isGuideline = false;
            this.horizontalDimensionFixed = true;
            this.verticalDimensionFixed = true;
            int i3 = ((ViewGroup.MarginLayoutParams) this).width;
            if (i3 == -2 && this.constrainedWidth) {
                this.horizontalDimensionFixed = false;
                if (this.matchConstraintDefaultWidth == 0) {
                    this.matchConstraintDefaultWidth = 1;
                }
            }
            int i16 = ((ViewGroup.MarginLayoutParams) this).height;
            if (i16 == -2 && this.constrainedHeight) {
                this.verticalDimensionFixed = false;
                if (this.matchConstraintDefaultHeight == 0) {
                    this.matchConstraintDefaultHeight = 1;
                }
            }
            if (i3 == 0 || i3 == -1) {
                this.horizontalDimensionFixed = false;
                if (i3 == 0 && this.matchConstraintDefaultWidth == 1) {
                    ((ViewGroup.MarginLayoutParams) this).width = -2;
                    this.constrainedWidth = true;
                }
            }
            if (i16 == 0 || i16 == -1) {
                this.verticalDimensionFixed = false;
                if (i16 == 0 && this.matchConstraintDefaultHeight == 1) {
                    ((ViewGroup.MarginLayoutParams) this).height = -2;
                    this.constrainedHeight = true;
                }
            }
            if (this.guidePercent != -1.0f || this.guideBegin != -1 || this.guideEnd != -1) {
                this.isGuideline = true;
                this.horizontalDimensionFixed = true;
                this.verticalDimensionFixed = true;
                if (!(this.widget instanceof androidx.constraintlayout.solver.widgets.Guideline)) {
                    this.widget = new androidx.constraintlayout.solver.widgets.Guideline();
                }
                ((androidx.constraintlayout.solver.widgets.Guideline) this.widget).setOrientation(this.orientation);
            }
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            int i3;
            this.guideBegin = -1;
            this.guideEnd = -1;
            this.guidePercent = -1.0f;
            this.leftToLeft = -1;
            this.leftToRight = -1;
            this.rightToLeft = -1;
            this.rightToRight = -1;
            this.topToTop = -1;
            this.topToBottom = -1;
            this.bottomToTop = -1;
            this.bottomToBottom = -1;
            this.baselineToBaseline = -1;
            this.circleConstraint = -1;
            this.circleRadius = 0;
            this.circleAngle = 0.0f;
            this.startToEnd = -1;
            this.startToStart = -1;
            this.endToStart = -1;
            this.endToEnd = -1;
            this.goneLeftMargin = -1;
            this.goneTopMargin = -1;
            this.goneRightMargin = -1;
            this.goneBottomMargin = -1;
            this.goneStartMargin = -1;
            this.goneEndMargin = -1;
            this.horizontalBias = 0.5f;
            this.verticalBias = 0.5f;
            this.dimensionRatio = null;
            this.dimensionRatioValue = 0.0f;
            this.dimensionRatioSide = 1;
            this.horizontalWeight = -1.0f;
            this.verticalWeight = -1.0f;
            this.horizontalChainStyle = 0;
            this.verticalChainStyle = 0;
            this.matchConstraintDefaultWidth = 0;
            this.matchConstraintDefaultHeight = 0;
            this.matchConstraintMinWidth = 0;
            this.matchConstraintMinHeight = 0;
            this.matchConstraintMaxWidth = 0;
            this.matchConstraintMaxHeight = 0;
            this.matchConstraintPercentWidth = 1.0f;
            this.matchConstraintPercentHeight = 1.0f;
            this.editorAbsoluteX = -1;
            this.editorAbsoluteY = -1;
            this.orientation = -1;
            this.constrainedWidth = false;
            this.constrainedHeight = false;
            this.constraintTag = null;
            this.horizontalDimensionFixed = true;
            this.verticalDimensionFixed = true;
            this.needsBaseline = false;
            this.isGuideline = false;
            this.isHelper = false;
            this.isInPlaceholder = false;
            this.isVirtualGroup = false;
            this.resolvedLeftToLeft = -1;
            this.resolvedLeftToRight = -1;
            this.resolvedRightToLeft = -1;
            this.resolvedRightToRight = -1;
            this.resolveGoneLeftMargin = -1;
            this.resolveGoneRightMargin = -1;
            this.resolvedHorizontalBias = 0.5f;
            this.widget = new ConstraintWidget();
            this.helped = false;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i16 = 0; i16 < indexCount; i16++) {
                int index = obtainStyledAttributes.getIndex(i16);
                int i17 = Table.map.get(index);
                switch (i17) {
                    case 1:
                        this.orientation = obtainStyledAttributes.getInt(index, this.orientation);
                        break;
                    case 2:
                        int resourceId = obtainStyledAttributes.getResourceId(index, this.circleConstraint);
                        this.circleConstraint = resourceId;
                        if (resourceId == -1) {
                            this.circleConstraint = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        this.circleRadius = obtainStyledAttributes.getDimensionPixelSize(index, this.circleRadius);
                        break;
                    case 4:
                        float f16 = obtainStyledAttributes.getFloat(index, this.circleAngle) % 360.0f;
                        this.circleAngle = f16;
                        if (f16 < 0.0f) {
                            this.circleAngle = (360.0f - f16) % 360.0f;
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        this.guideBegin = obtainStyledAttributes.getDimensionPixelOffset(index, this.guideBegin);
                        break;
                    case 6:
                        this.guideEnd = obtainStyledAttributes.getDimensionPixelOffset(index, this.guideEnd);
                        break;
                    case 7:
                        this.guidePercent = obtainStyledAttributes.getFloat(index, this.guidePercent);
                        break;
                    case 8:
                        int resourceId2 = obtainStyledAttributes.getResourceId(index, this.leftToLeft);
                        this.leftToLeft = resourceId2;
                        if (resourceId2 == -1) {
                            this.leftToLeft = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        int resourceId3 = obtainStyledAttributes.getResourceId(index, this.leftToRight);
                        this.leftToRight = resourceId3;
                        if (resourceId3 == -1) {
                            this.leftToRight = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        int resourceId4 = obtainStyledAttributes.getResourceId(index, this.rightToLeft);
                        this.rightToLeft = resourceId4;
                        if (resourceId4 == -1) {
                            this.rightToLeft = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        int resourceId5 = obtainStyledAttributes.getResourceId(index, this.rightToRight);
                        this.rightToRight = resourceId5;
                        if (resourceId5 == -1) {
                            this.rightToRight = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        int resourceId6 = obtainStyledAttributes.getResourceId(index, this.topToTop);
                        this.topToTop = resourceId6;
                        if (resourceId6 == -1) {
                            this.topToTop = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        int resourceId7 = obtainStyledAttributes.getResourceId(index, this.topToBottom);
                        this.topToBottom = resourceId7;
                        if (resourceId7 == -1) {
                            this.topToBottom = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        int resourceId8 = obtainStyledAttributes.getResourceId(index, this.bottomToTop);
                        this.bottomToTop = resourceId8;
                        if (resourceId8 == -1) {
                            this.bottomToTop = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        int resourceId9 = obtainStyledAttributes.getResourceId(index, this.bottomToBottom);
                        this.bottomToBottom = resourceId9;
                        if (resourceId9 == -1) {
                            this.bottomToBottom = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        int resourceId10 = obtainStyledAttributes.getResourceId(index, this.baselineToBaseline);
                        this.baselineToBaseline = resourceId10;
                        if (resourceId10 == -1) {
                            this.baselineToBaseline = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        int resourceId11 = obtainStyledAttributes.getResourceId(index, this.startToEnd);
                        this.startToEnd = resourceId11;
                        if (resourceId11 == -1) {
                            this.startToEnd = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        int resourceId12 = obtainStyledAttributes.getResourceId(index, this.startToStart);
                        this.startToStart = resourceId12;
                        if (resourceId12 == -1) {
                            this.startToStart = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 19:
                        int resourceId13 = obtainStyledAttributes.getResourceId(index, this.endToStart);
                        this.endToStart = resourceId13;
                        if (resourceId13 == -1) {
                            this.endToStart = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 20:
                        int resourceId14 = obtainStyledAttributes.getResourceId(index, this.endToEnd);
                        this.endToEnd = resourceId14;
                        if (resourceId14 == -1) {
                            this.endToEnd = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 21:
                        this.goneLeftMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneLeftMargin);
                        break;
                    case 22:
                        this.goneTopMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneTopMargin);
                        break;
                    case 23:
                        this.goneRightMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneRightMargin);
                        break;
                    case 24:
                        this.goneBottomMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneBottomMargin);
                        break;
                    case 25:
                        this.goneStartMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneStartMargin);
                        break;
                    case 26:
                        this.goneEndMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneEndMargin);
                        break;
                    case 27:
                        this.constrainedWidth = obtainStyledAttributes.getBoolean(index, this.constrainedWidth);
                        break;
                    case 28:
                        this.constrainedHeight = obtainStyledAttributes.getBoolean(index, this.constrainedHeight);
                        break;
                    case 29:
                        this.horizontalBias = obtainStyledAttributes.getFloat(index, this.horizontalBias);
                        break;
                    case 30:
                        this.verticalBias = obtainStyledAttributes.getFloat(index, this.verticalBias);
                        break;
                    case 31:
                        int i18 = obtainStyledAttributes.getInt(index, 0);
                        this.matchConstraintDefaultWidth = i18;
                        if (i18 == 1) {
                            Log.e(ConstraintLayout.TAG, "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
                            break;
                        } else {
                            break;
                        }
                    case 32:
                        int i19 = obtainStyledAttributes.getInt(index, 0);
                        this.matchConstraintDefaultHeight = i19;
                        if (i19 == 1) {
                            Log.e(ConstraintLayout.TAG, "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
                            break;
                        } else {
                            break;
                        }
                    case 33:
                        try {
                            this.matchConstraintMinWidth = obtainStyledAttributes.getDimensionPixelSize(index, this.matchConstraintMinWidth);
                            break;
                        } catch (Exception unused) {
                            if (obtainStyledAttributes.getInt(index, this.matchConstraintMinWidth) == -2) {
                                this.matchConstraintMinWidth = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 34:
                        try {
                            this.matchConstraintMaxWidth = obtainStyledAttributes.getDimensionPixelSize(index, this.matchConstraintMaxWidth);
                            break;
                        } catch (Exception unused2) {
                            if (obtainStyledAttributes.getInt(index, this.matchConstraintMaxWidth) == -2) {
                                this.matchConstraintMaxWidth = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 35:
                        this.matchConstraintPercentWidth = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.matchConstraintPercentWidth));
                        this.matchConstraintDefaultWidth = 2;
                        break;
                    case 36:
                        try {
                            this.matchConstraintMinHeight = obtainStyledAttributes.getDimensionPixelSize(index, this.matchConstraintMinHeight);
                            break;
                        } catch (Exception unused3) {
                            if (obtainStyledAttributes.getInt(index, this.matchConstraintMinHeight) == -2) {
                                this.matchConstraintMinHeight = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 37:
                        try {
                            this.matchConstraintMaxHeight = obtainStyledAttributes.getDimensionPixelSize(index, this.matchConstraintMaxHeight);
                            break;
                        } catch (Exception unused4) {
                            if (obtainStyledAttributes.getInt(index, this.matchConstraintMaxHeight) == -2) {
                                this.matchConstraintMaxHeight = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 38:
                        this.matchConstraintPercentHeight = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.matchConstraintPercentHeight));
                        this.matchConstraintDefaultHeight = 2;
                        break;
                    default:
                        switch (i17) {
                            case 44:
                                String string = obtainStyledAttributes.getString(index);
                                this.dimensionRatio = string;
                                this.dimensionRatioValue = Float.NaN;
                                this.dimensionRatioSide = -1;
                                if (string != null) {
                                    int length = string.length();
                                    int indexOf = this.dimensionRatio.indexOf(44);
                                    if (indexOf <= 0 || indexOf >= length - 1) {
                                        i3 = 0;
                                    } else {
                                        String substring = this.dimensionRatio.substring(0, indexOf);
                                        if (substring.equalsIgnoreCase("W")) {
                                            this.dimensionRatioSide = 0;
                                        } else if (substring.equalsIgnoreCase("H")) {
                                            this.dimensionRatioSide = 1;
                                        }
                                        i3 = indexOf + 1;
                                    }
                                    int indexOf2 = this.dimensionRatio.indexOf(58);
                                    if (indexOf2 >= 0 && indexOf2 < length - 1) {
                                        String substring2 = this.dimensionRatio.substring(i3, indexOf2);
                                        String substring3 = this.dimensionRatio.substring(indexOf2 + 1);
                                        if (substring2.length() > 0 && substring3.length() > 0) {
                                            try {
                                                float parseFloat = Float.parseFloat(substring2);
                                                float parseFloat2 = Float.parseFloat(substring3);
                                                if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                                                    if (this.dimensionRatioSide == 1) {
                                                        this.dimensionRatioValue = Math.abs(parseFloat2 / parseFloat);
                                                        break;
                                                    } else {
                                                        this.dimensionRatioValue = Math.abs(parseFloat / parseFloat2);
                                                        break;
                                                    }
                                                }
                                            } catch (NumberFormatException unused5) {
                                                break;
                                            }
                                        }
                                    } else {
                                        String substring4 = this.dimensionRatio.substring(i3);
                                        if (substring4.length() > 0) {
                                            this.dimensionRatioValue = Float.parseFloat(substring4);
                                            break;
                                        } else {
                                            break;
                                        }
                                    }
                                } else {
                                    break;
                                }
                                break;
                            case 45:
                                this.horizontalWeight = obtainStyledAttributes.getFloat(index, this.horizontalWeight);
                                break;
                            case 46:
                                this.verticalWeight = obtainStyledAttributes.getFloat(index, this.verticalWeight);
                                break;
                            case 47:
                                this.horizontalChainStyle = obtainStyledAttributes.getInt(index, 0);
                                break;
                            case 48:
                                this.verticalChainStyle = obtainStyledAttributes.getInt(index, 0);
                                break;
                            case 49:
                                this.editorAbsoluteX = obtainStyledAttributes.getDimensionPixelOffset(index, this.editorAbsoluteX);
                                break;
                            case 50:
                                this.editorAbsoluteY = obtainStyledAttributes.getDimensionPixelOffset(index, this.editorAbsoluteY);
                                break;
                            case 51:
                                this.constraintTag = obtainStyledAttributes.getString(index);
                                break;
                        }
                }
            }
            obtainStyledAttributes.recycle();
            validate();
        }

        public LayoutParams(int i3, int i16) {
            super(i3, i16);
            this.guideBegin = -1;
            this.guideEnd = -1;
            this.guidePercent = -1.0f;
            this.leftToLeft = -1;
            this.leftToRight = -1;
            this.rightToLeft = -1;
            this.rightToRight = -1;
            this.topToTop = -1;
            this.topToBottom = -1;
            this.bottomToTop = -1;
            this.bottomToBottom = -1;
            this.baselineToBaseline = -1;
            this.circleConstraint = -1;
            this.circleRadius = 0;
            this.circleAngle = 0.0f;
            this.startToEnd = -1;
            this.startToStart = -1;
            this.endToStart = -1;
            this.endToEnd = -1;
            this.goneLeftMargin = -1;
            this.goneTopMargin = -1;
            this.goneRightMargin = -1;
            this.goneBottomMargin = -1;
            this.goneStartMargin = -1;
            this.goneEndMargin = -1;
            this.horizontalBias = 0.5f;
            this.verticalBias = 0.5f;
            this.dimensionRatio = null;
            this.dimensionRatioValue = 0.0f;
            this.dimensionRatioSide = 1;
            this.horizontalWeight = -1.0f;
            this.verticalWeight = -1.0f;
            this.horizontalChainStyle = 0;
            this.verticalChainStyle = 0;
            this.matchConstraintDefaultWidth = 0;
            this.matchConstraintDefaultHeight = 0;
            this.matchConstraintMinWidth = 0;
            this.matchConstraintMinHeight = 0;
            this.matchConstraintMaxWidth = 0;
            this.matchConstraintMaxHeight = 0;
            this.matchConstraintPercentWidth = 1.0f;
            this.matchConstraintPercentHeight = 1.0f;
            this.editorAbsoluteX = -1;
            this.editorAbsoluteY = -1;
            this.orientation = -1;
            this.constrainedWidth = false;
            this.constrainedHeight = false;
            this.constraintTag = null;
            this.horizontalDimensionFixed = true;
            this.verticalDimensionFixed = true;
            this.needsBaseline = false;
            this.isGuideline = false;
            this.isHelper = false;
            this.isInPlaceholder = false;
            this.isVirtualGroup = false;
            this.resolvedLeftToLeft = -1;
            this.resolvedLeftToRight = -1;
            this.resolvedRightToLeft = -1;
            this.resolvedRightToRight = -1;
            this.resolveGoneLeftMargin = -1;
            this.resolveGoneRightMargin = -1;
            this.resolvedHorizontalBias = 0.5f;
            this.widget = new ConstraintWidget();
            this.helped = false;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.guideBegin = -1;
            this.guideEnd = -1;
            this.guidePercent = -1.0f;
            this.leftToLeft = -1;
            this.leftToRight = -1;
            this.rightToLeft = -1;
            this.rightToRight = -1;
            this.topToTop = -1;
            this.topToBottom = -1;
            this.bottomToTop = -1;
            this.bottomToBottom = -1;
            this.baselineToBaseline = -1;
            this.circleConstraint = -1;
            this.circleRadius = 0;
            this.circleAngle = 0.0f;
            this.startToEnd = -1;
            this.startToStart = -1;
            this.endToStart = -1;
            this.endToEnd = -1;
            this.goneLeftMargin = -1;
            this.goneTopMargin = -1;
            this.goneRightMargin = -1;
            this.goneBottomMargin = -1;
            this.goneStartMargin = -1;
            this.goneEndMargin = -1;
            this.horizontalBias = 0.5f;
            this.verticalBias = 0.5f;
            this.dimensionRatio = null;
            this.dimensionRatioValue = 0.0f;
            this.dimensionRatioSide = 1;
            this.horizontalWeight = -1.0f;
            this.verticalWeight = -1.0f;
            this.horizontalChainStyle = 0;
            this.verticalChainStyle = 0;
            this.matchConstraintDefaultWidth = 0;
            this.matchConstraintDefaultHeight = 0;
            this.matchConstraintMinWidth = 0;
            this.matchConstraintMinHeight = 0;
            this.matchConstraintMaxWidth = 0;
            this.matchConstraintMaxHeight = 0;
            this.matchConstraintPercentWidth = 1.0f;
            this.matchConstraintPercentHeight = 1.0f;
            this.editorAbsoluteX = -1;
            this.editorAbsoluteY = -1;
            this.orientation = -1;
            this.constrainedWidth = false;
            this.constrainedHeight = false;
            this.constraintTag = null;
            this.horizontalDimensionFixed = true;
            this.verticalDimensionFixed = true;
            this.needsBaseline = false;
            this.isGuideline = false;
            this.isHelper = false;
            this.isInPlaceholder = false;
            this.isVirtualGroup = false;
            this.resolvedLeftToLeft = -1;
            this.resolvedLeftToRight = -1;
            this.resolvedRightToLeft = -1;
            this.resolvedRightToRight = -1;
            this.resolveGoneLeftMargin = -1;
            this.resolveGoneRightMargin = -1;
            this.resolvedHorizontalBias = 0.5f;
            this.widget = new ConstraintWidget();
            this.helped = false;
        }
    }
}
