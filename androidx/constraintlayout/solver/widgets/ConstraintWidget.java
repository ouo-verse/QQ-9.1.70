package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.Cache;
import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.Metrics;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.analyzer.ChainRun;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun;
import androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetRun;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes.dex */
public class ConstraintWidget {
    public static final int ANCHOR_BASELINE = 4;
    public static final int ANCHOR_BOTTOM = 3;
    public static final int ANCHOR_LEFT = 0;
    public static final int ANCHOR_RIGHT = 1;
    public static final int ANCHOR_TOP = 2;
    private static final boolean AUTOTAG_CENTER = false;
    public static final int BOTH = 2;
    public static final int CHAIN_PACKED = 2;
    public static final int CHAIN_SPREAD = 0;
    public static final int CHAIN_SPREAD_INSIDE = 1;
    public static float DEFAULT_BIAS = 0.5f;
    static final int DIMENSION_HORIZONTAL = 0;
    static final int DIMENSION_VERTICAL = 1;
    protected static final int DIRECT = 2;
    public static final int GONE = 8;
    public static final int HORIZONTAL = 0;
    public static final int INVISIBLE = 4;
    public static final int MATCH_CONSTRAINT_PERCENT = 2;
    public static final int MATCH_CONSTRAINT_RATIO = 3;
    public static final int MATCH_CONSTRAINT_RATIO_RESOLVED = 4;
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    protected static final int SOLVER = 1;
    public static final int UNKNOWN = -1;
    private static final boolean USE_WRAP_DIMENSION_FOR_SPREAD = false;
    public static final int VERTICAL = 1;
    public static final int VISIBLE = 0;
    private static final int WRAP = -2;
    private boolean OPTIMIZE_WRAP;
    private boolean OPTIMIZE_WRAP_ON_RESOLVED;
    private boolean hasBaseline;
    public ChainRun horizontalChainRun;
    public int horizontalGroup;
    public HorizontalWidgetRun horizontalRun;
    private boolean inPlaceholder;
    public boolean[] isTerminalWidget;
    protected ArrayList<ConstraintAnchor> mAnchors;
    public ConstraintAnchor mBaseline;
    int mBaselineDistance;
    public ConstraintAnchor mBottom;
    boolean mBottomHasCentered;
    public ConstraintAnchor mCenter;
    ConstraintAnchor mCenterX;
    ConstraintAnchor mCenterY;
    private float mCircleConstraintAngle;
    private Object mCompanionWidget;
    private int mContainerItemSkip;
    private String mDebugName;
    public float mDimensionRatio;
    protected int mDimensionRatioSide;
    int mDistToBottom;
    int mDistToLeft;
    int mDistToRight;
    int mDistToTop;
    boolean mGroupsToSolver;
    int mHeight;
    float mHorizontalBiasPercent;
    boolean mHorizontalChainFixedPosition;
    int mHorizontalChainStyle;
    ConstraintWidget mHorizontalNextWidget;
    public int mHorizontalResolution;
    boolean mHorizontalWrapVisited;
    private boolean mInVirtuaLayout;
    public boolean mIsHeightWrapContent;
    private boolean[] mIsInBarrier;
    public boolean mIsWidthWrapContent;
    private int mLastHorizontalMeasureSpec;
    private int mLastVerticalMeasureSpec;
    public ConstraintAnchor mLeft;
    boolean mLeftHasCentered;
    public ConstraintAnchor[] mListAnchors;
    public DimensionBehaviour[] mListDimensionBehaviors;
    protected ConstraintWidget[] mListNextMatchConstraintsWidget;
    public int mMatchConstraintDefaultHeight;
    public int mMatchConstraintDefaultWidth;
    public int mMatchConstraintMaxHeight;
    public int mMatchConstraintMaxWidth;
    public int mMatchConstraintMinHeight;
    public int mMatchConstraintMinWidth;
    public float mMatchConstraintPercentHeight;
    public float mMatchConstraintPercentWidth;
    private int[] mMaxDimension;
    private boolean mMeasureRequested;
    protected int mMinHeight;
    protected int mMinWidth;
    protected ConstraintWidget[] mNextChainWidget;
    protected int mOffsetX;
    protected int mOffsetY;
    public ConstraintWidget mParent;
    int mRelX;
    int mRelY;
    float mResolvedDimensionRatio;
    int mResolvedDimensionRatioSide;
    boolean mResolvedHasRatio;
    public int[] mResolvedMatchConstraintDefault;
    public ConstraintAnchor mRight;
    boolean mRightHasCentered;
    public ConstraintAnchor mTop;
    boolean mTopHasCentered;
    private String mType;
    float mVerticalBiasPercent;
    boolean mVerticalChainFixedPosition;
    int mVerticalChainStyle;
    ConstraintWidget mVerticalNextWidget;
    public int mVerticalResolution;
    boolean mVerticalWrapVisited;
    private int mVisibility;
    public float[] mWeight;
    int mWidth;
    protected int mX;
    protected int mY;
    public boolean measured;
    private boolean resolvedHorizontal;
    private boolean resolvedVertical;
    public WidgetRun[] run;
    public ChainRun verticalChainRun;
    public int verticalGroup;
    public VerticalWidgetRun verticalRun;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: androidx.constraintlayout.solver.widgets.ConstraintWidget$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type;
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour;

        static {
            int[] iArr = new int[DimensionBehaviour.values().length];
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour = iArr;
            try {
                iArr[DimensionBehaviour.FIXED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[DimensionBehaviour.WRAP_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[DimensionBehaviour.MATCH_PARENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[DimensionBehaviour.MATCH_CONSTRAINT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[ConstraintAnchor.Type.values().length];
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type = iArr2;
            try {
                iArr2[ConstraintAnchor.Type.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.BASELINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public enum DimensionBehaviour {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public ConstraintWidget() {
        this.measured = false;
        this.run = new WidgetRun[2];
        this.horizontalRun = null;
        this.verticalRun = null;
        this.isTerminalWidget = new boolean[]{true, true};
        this.mResolvedHasRatio = false;
        this.mMeasureRequested = true;
        this.OPTIMIZE_WRAP = false;
        this.OPTIMIZE_WRAP_ON_RESOLVED = true;
        this.resolvedHorizontal = false;
        this.resolvedVertical = false;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mResolvedMatchConstraintDefault = new int[2];
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMaxWidth = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintMinHeight = 0;
        this.mMatchConstraintMaxHeight = 0;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mMaxDimension = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.mCircleConstraintAngle = 0.0f;
        this.hasBaseline = false;
        this.mInVirtuaLayout = false;
        this.mLastHorizontalMeasureSpec = 0;
        this.mLastVerticalMeasureSpec = 0;
        this.mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.mCenterX = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.mCenterY = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        ConstraintAnchor constraintAnchor = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mCenter = constraintAnchor;
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, constraintAnchor};
        this.mAnchors = new ArrayList<>();
        this.mIsInBarrier = new boolean[2];
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        this.mListDimensionBehaviors = new DimensionBehaviour[]{dimensionBehaviour, dimensionBehaviour};
        this.mParent = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mRelX = 0;
        this.mRelY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        float f16 = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = f16;
        this.mVerticalBiasPercent = f16;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mDebugName = null;
        this.mType = null;
        this.mGroupsToSolver = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mWeight = new float[]{-1.0f, -1.0f};
        this.mListNextMatchConstraintsWidget = new ConstraintWidget[]{null, null};
        this.mNextChainWidget = new ConstraintWidget[]{null, null};
        this.mHorizontalNextWidget = null;
        this.mVerticalNextWidget = null;
        this.horizontalGroup = -1;
        this.verticalGroup = -1;
        addAnchors();
    }

    private void addAnchors() {
        this.mAnchors.add(this.mLeft);
        this.mAnchors.add(this.mTop);
        this.mAnchors.add(this.mRight);
        this.mAnchors.add(this.mBottom);
        this.mAnchors.add(this.mCenterX);
        this.mAnchors.add(this.mCenterY);
        this.mAnchors.add(this.mCenter);
        this.mAnchors.add(this.mBaseline);
    }

    /* JADX WARN: Removed duplicated region for block: B:102:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0399  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x03f6  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0437  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0487  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x041d  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x03db  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x04ea  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:351:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:352:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x04f7 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:73:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x04bd A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void applyConstraints(LinearSystem linearSystem, boolean z16, boolean z17, boolean z18, boolean z19, SolverVariable solverVariable, SolverVariable solverVariable2, DimensionBehaviour dimensionBehaviour, boolean z26, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i3, int i16, int i17, int i18, float f16, boolean z27, boolean z28, boolean z29, boolean z36, boolean z37, int i19, int i26, int i27, int i28, float f17, boolean z38) {
        int i29;
        boolean z39;
        int i36;
        SolverVariable solverVariable3;
        int i37;
        int i38;
        int i39;
        int i46;
        SolverVariable solverVariable4;
        SolverVariable solverVariable5;
        SolverVariable solverVariable6;
        int i47;
        int i48;
        boolean z46;
        boolean z47;
        SolverVariable createObjectVariable;
        SolverVariable createObjectVariable2;
        SolverVariable solverVariable7;
        SolverVariable solverVariable8;
        SolverVariable solverVariable9;
        int i49;
        SolverVariable solverVariable10;
        int i56;
        int i57;
        int i58;
        ConstraintAnchor constraintAnchor3;
        int i59;
        SolverVariable solverVariable11;
        int i65;
        int i66;
        int i67;
        SolverVariable solverVariable12;
        int i68;
        int i69;
        int i75;
        int i76;
        boolean z48;
        int i77;
        ConstraintWidget constraintWidget;
        ConstraintWidget constraintWidget2;
        SolverVariable solverVariable13;
        SolverVariable solverVariable14;
        int i78;
        boolean z49;
        SolverVariable solverVariable15;
        int i79;
        int i85;
        SolverVariable solverVariable16;
        int i86;
        ConstraintWidget constraintWidget3;
        boolean z55;
        int i87;
        int i88;
        int i89;
        int i95;
        int i96;
        ConstraintWidget constraintWidget4;
        ConstraintWidget constraintWidget5;
        int i97;
        SolverVariable createObjectVariable3 = linearSystem.createObjectVariable(constraintAnchor);
        SolverVariable createObjectVariable4 = linearSystem.createObjectVariable(constraintAnchor2);
        SolverVariable createObjectVariable5 = linearSystem.createObjectVariable(constraintAnchor.getTarget());
        SolverVariable createObjectVariable6 = linearSystem.createObjectVariable(constraintAnchor2.getTarget());
        if (LinearSystem.getMetrics() != null) {
            LinearSystem.getMetrics().nonresolvedWidgets++;
        }
        boolean isConnected = constraintAnchor.isConnected();
        boolean isConnected2 = constraintAnchor2.isConnected();
        boolean isConnected3 = this.mCenter.isConnected();
        int i98 = isConnected2 ? (isConnected ? 1 : 0) + 1 : isConnected ? 1 : 0;
        if (isConnected3) {
            i98++;
        }
        int i99 = z27 ? 3 : i19;
        int i100 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[dimensionBehaviour.ordinal()];
        if (i100 == 1 || i100 == 2 || i100 == 3 || i100 != 4) {
            i29 = i99;
        } else {
            i29 = i99;
            if (i29 != 4) {
                z39 = true;
                if (this.mVisibility != 8) {
                    i36 = 0;
                    z39 = false;
                } else {
                    i36 = i16;
                }
                if (z38) {
                    solverVariable3 = createObjectVariable6;
                    i37 = 8;
                } else {
                    if (!isConnected && !isConnected2 && !isConnected3) {
                        linearSystem.addEquality(createObjectVariable3, i3);
                    } else if (isConnected && !isConnected2) {
                        solverVariable3 = createObjectVariable6;
                        i37 = 8;
                        linearSystem.addEquality(createObjectVariable3, createObjectVariable5, constraintAnchor.getMargin(), 8);
                    }
                    solverVariable3 = createObjectVariable6;
                    i37 = 8;
                }
                if (z39) {
                    if (z26) {
                        i97 = 0;
                        linearSystem.addEquality(createObjectVariable4, createObjectVariable3, 0, 3);
                        if (i17 > 0) {
                            linearSystem.addGreaterThan(createObjectVariable4, createObjectVariable3, i17, 8);
                        }
                        if (i18 < Integer.MAX_VALUE) {
                            linearSystem.addLowerThan(createObjectVariable4, createObjectVariable3, i18, 8);
                        }
                    } else {
                        int i101 = i37;
                        i97 = 0;
                        linearSystem.addEquality(createObjectVariable4, createObjectVariable3, i36, i101);
                    }
                    i48 = i27;
                    i38 = i28;
                    i46 = i97;
                    solverVariable4 = createObjectVariable5;
                    solverVariable5 = createObjectVariable4;
                } else {
                    if (i98 != 2 && !z27 && (i29 == 1 || i29 == 0)) {
                        int max = Math.max(i27, i36);
                        if (i28 > 0) {
                            max = Math.min(i28, max);
                        }
                        linearSystem.addEquality(createObjectVariable4, createObjectVariable3, max, 8);
                        z47 = z19;
                        i48 = i27;
                        i38 = i28;
                        i46 = 0;
                        z46 = false;
                        solverVariable4 = createObjectVariable5;
                        solverVariable5 = createObjectVariable4;
                        solverVariable6 = solverVariable3;
                        i47 = i98;
                        if (z38) {
                        }
                        if (i56 >= i57) {
                            return;
                        } else {
                            return;
                        }
                    }
                    int i102 = i27 == -2 ? i36 : i27;
                    i38 = i28 == -2 ? i36 : i28;
                    if (i36 > 0 && i29 != 1) {
                        i36 = 0;
                    }
                    if (i102 > 0) {
                        linearSystem.addGreaterThan(createObjectVariable4, createObjectVariable3, i102, 8);
                        i36 = Math.max(i36, i102);
                    }
                    if (i38 > 0) {
                        if ((z17 && i29 == 1) ? false : true) {
                            i39 = 8;
                            linearSystem.addLowerThan(createObjectVariable4, createObjectVariable3, i38, 8);
                        } else {
                            i39 = 8;
                        }
                        i36 = Math.min(i36, i38);
                    } else {
                        i39 = 8;
                    }
                    if (i29 != 1) {
                        if (i29 == 2) {
                            ConstraintAnchor.Type type = constraintAnchor.getType();
                            ConstraintAnchor.Type type2 = ConstraintAnchor.Type.TOP;
                            if (type != type2 && constraintAnchor.getType() != ConstraintAnchor.Type.BOTTOM) {
                                createObjectVariable = linearSystem.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.LEFT));
                                createObjectVariable2 = linearSystem.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.RIGHT));
                            } else {
                                createObjectVariable = linearSystem.createObjectVariable(this.mParent.getAnchor(type2));
                                createObjectVariable2 = linearSystem.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.BOTTOM));
                            }
                            int i103 = i102;
                            solverVariable6 = solverVariable3;
                            i46 = 0;
                            i47 = i98;
                            solverVariable4 = createObjectVariable5;
                            solverVariable5 = createObjectVariable4;
                            linearSystem.addConstraint(linearSystem.createRow().createRowDimensionRatio(createObjectVariable4, createObjectVariable3, createObjectVariable2, createObjectVariable, f17));
                            z47 = z19;
                            i48 = i103;
                            z46 = false;
                        } else {
                            i46 = 0;
                            solverVariable4 = createObjectVariable5;
                            solverVariable5 = createObjectVariable4;
                            int i104 = i102;
                            solverVariable6 = solverVariable3;
                            i47 = i98;
                            i48 = i104;
                            z46 = z39;
                            z47 = true;
                        }
                        if (z38) {
                            solverVariable7 = solverVariable;
                            solverVariable8 = solverVariable2;
                            solverVariable9 = solverVariable5;
                            i49 = i46;
                            solverVariable10 = createObjectVariable3;
                            i56 = i47;
                            i57 = 2;
                        } else if (z29) {
                            solverVariable7 = solverVariable;
                            solverVariable8 = solverVariable2;
                            solverVariable9 = solverVariable5;
                            i49 = i46;
                            i56 = i47;
                            i57 = 2;
                            solverVariable10 = createObjectVariable3;
                        } else {
                            if ((isConnected || isConnected2 || isConnected3) && (!isConnected || isConnected2)) {
                                if (isConnected || !isConnected2) {
                                    i59 = i46;
                                    if (isConnected && isConnected2) {
                                        ConstraintWidget constraintWidget6 = constraintAnchor.mTarget.mOwner;
                                        ConstraintWidget constraintWidget7 = constraintAnchor2.mTarget.mOwner;
                                        ConstraintWidget parent = getParent();
                                        int i105 = 6;
                                        if (!z46) {
                                            if (solverVariable4.isFinalValue && solverVariable6.isFinalValue) {
                                                linearSystem.addCentering(createObjectVariable3, solverVariable4, constraintAnchor.getMargin(), f16, solverVariable6, solverVariable5, constraintAnchor2.getMargin(), 8);
                                                if (z17 && z47) {
                                                    if (constraintAnchor2.mTarget != null) {
                                                        i68 = constraintAnchor2.getMargin();
                                                        solverVariable12 = solverVariable2;
                                                    } else {
                                                        solverVariable12 = solverVariable2;
                                                        i68 = 0;
                                                    }
                                                    if (solverVariable6 != solverVariable12) {
                                                        linearSystem.addGreaterThan(solverVariable12, solverVariable5, i68, 5);
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            }
                                            solverVariable11 = solverVariable2;
                                            i65 = 6;
                                            i66 = 1;
                                            i67 = 1;
                                        } else {
                                            if (i29 == 0) {
                                                if (i38 != 0 || i48 != 0) {
                                                    i95 = i59;
                                                    i66 = 1;
                                                    i67 = 1;
                                                    i96 = 5;
                                                    i75 = 5;
                                                } else if (solverVariable4.isFinalValue && solverVariable6.isFinalValue) {
                                                    linearSystem.addEquality(createObjectVariable3, solverVariable4, constraintAnchor.getMargin(), 8);
                                                    linearSystem.addEquality(solverVariable5, solverVariable6, -constraintAnchor2.getMargin(), 8);
                                                    return;
                                                } else {
                                                    i66 = i59;
                                                    i67 = i66;
                                                    i95 = 1;
                                                    i96 = 8;
                                                    i75 = 8;
                                                }
                                                if ((constraintWidget6 instanceof Barrier) || (constraintWidget7 instanceof Barrier)) {
                                                    solverVariable11 = solverVariable2;
                                                    i76 = i96;
                                                    i75 = 4;
                                                } else {
                                                    solverVariable11 = solverVariable2;
                                                    i76 = i96;
                                                }
                                                i69 = i95;
                                                i65 = 6;
                                            } else {
                                                if (i29 == 1) {
                                                    solverVariable11 = solverVariable2;
                                                    i65 = 6;
                                                    i66 = 1;
                                                    i67 = 1;
                                                    i69 = 0;
                                                    i75 = 4;
                                                } else if (i29 != 3) {
                                                    solverVariable11 = solverVariable2;
                                                    i65 = 6;
                                                    i66 = 0;
                                                    i67 = 0;
                                                } else if (this.mResolvedDimensionRatioSide == -1) {
                                                    if (z36) {
                                                        solverVariable11 = solverVariable2;
                                                        i66 = 1;
                                                        i65 = z17 ? 5 : 4;
                                                    } else {
                                                        solverVariable11 = solverVariable2;
                                                        i66 = 1;
                                                        i65 = 8;
                                                    }
                                                    i67 = 1;
                                                    i69 = 1;
                                                    i75 = 5;
                                                } else if (z27) {
                                                    if (i26 == 2 || i26 == 1) {
                                                        i88 = 5;
                                                        i89 = 4;
                                                    } else {
                                                        i88 = 8;
                                                        i89 = 5;
                                                    }
                                                    solverVariable11 = solverVariable2;
                                                    i76 = i88;
                                                    i75 = i89;
                                                    i65 = 6;
                                                    i66 = 1;
                                                    i67 = 1;
                                                    i69 = 1;
                                                } else {
                                                    if (i38 > 0) {
                                                        solverVariable11 = solverVariable2;
                                                        i65 = 6;
                                                        i66 = 1;
                                                        i67 = 1;
                                                        i69 = 1;
                                                        i75 = 5;
                                                    } else if (i38 != 0 || i48 != 0) {
                                                        solverVariable11 = solverVariable2;
                                                        i65 = 6;
                                                        i66 = 1;
                                                        i67 = 1;
                                                        i69 = 1;
                                                        i75 = 4;
                                                    } else if (z36) {
                                                        solverVariable11 = solverVariable2;
                                                        i76 = (constraintWidget6 == parent || constraintWidget7 == parent) ? 5 : 4;
                                                        i65 = 6;
                                                        i66 = 1;
                                                        i67 = 1;
                                                        i69 = 1;
                                                        i75 = 4;
                                                    } else {
                                                        solverVariable11 = solverVariable2;
                                                        i65 = 6;
                                                        i66 = 1;
                                                        i67 = 1;
                                                        i69 = 1;
                                                        i75 = 8;
                                                    }
                                                    i76 = 5;
                                                }
                                                i76 = 8;
                                            }
                                            if (i67 == 0 && solverVariable4 == solverVariable6 && constraintWidget6 != parent) {
                                                i67 = 0;
                                                z48 = false;
                                            } else {
                                                z48 = true;
                                            }
                                            if (i66 == 0) {
                                                if (z46 || z28 || z36 || solverVariable4 != solverVariable || solverVariable6 != solverVariable11) {
                                                    i78 = i76;
                                                    z55 = z48;
                                                    z49 = z17;
                                                    i87 = i65;
                                                } else {
                                                    z49 = false;
                                                    i87 = 8;
                                                    z55 = false;
                                                    i78 = 8;
                                                }
                                                i77 = i29;
                                                constraintWidget = parent;
                                                constraintWidget2 = constraintWidget7;
                                                SolverVariable solverVariable17 = solverVariable5;
                                                solverVariable13 = solverVariable5;
                                                solverVariable14 = createObjectVariable3;
                                                linearSystem.addCentering(createObjectVariable3, solverVariable4, constraintAnchor.getMargin(), f16, solverVariable6, solverVariable17, constraintAnchor2.getMargin(), i87);
                                                z48 = z55;
                                            } else {
                                                i77 = i29;
                                                constraintWidget = parent;
                                                constraintWidget2 = constraintWidget7;
                                                solverVariable13 = solverVariable5;
                                                solverVariable14 = createObjectVariable3;
                                                i78 = i76;
                                                z49 = z17;
                                            }
                                            if (this.mVisibility == 8 || constraintAnchor2.hasDependents()) {
                                                if (i67 == 0) {
                                                    int i106 = (!z49 || solverVariable4 == solverVariable6 || z46 || !((constraintWidget6 instanceof Barrier) || (constraintWidget2 instanceof Barrier))) ? i78 : 6;
                                                    linearSystem.addGreaterThan(solverVariable14, solverVariable4, constraintAnchor.getMargin(), i106);
                                                    solverVariable15 = solverVariable13;
                                                    linearSystem.addLowerThan(solverVariable15, solverVariable6, -constraintAnchor2.getMargin(), i106);
                                                    i78 = i106;
                                                } else {
                                                    solverVariable15 = solverVariable13;
                                                }
                                                if (z49 || !z37 || (constraintWidget6 instanceof Barrier) || (constraintWidget2 instanceof Barrier)) {
                                                    i79 = i75;
                                                    i85 = i78;
                                                } else {
                                                    i79 = 6;
                                                    i85 = 6;
                                                    z48 = true;
                                                }
                                                if (z48) {
                                                    if (i69 == 0 || (z36 && !z18)) {
                                                        constraintWidget3 = constraintWidget;
                                                    } else {
                                                        constraintWidget3 = constraintWidget;
                                                        if (constraintWidget6 != constraintWidget3 && constraintWidget2 != constraintWidget3) {
                                                            i105 = i79;
                                                        }
                                                        if ((constraintWidget6 instanceof Guideline) || (constraintWidget2 instanceof Guideline)) {
                                                            i105 = 5;
                                                        }
                                                        if ((constraintWidget6 instanceof Barrier) || (constraintWidget2 instanceof Barrier)) {
                                                            i105 = 5;
                                                        }
                                                        i79 = Math.max(z36 ? 5 : i105, i79);
                                                    }
                                                    if (z49) {
                                                        i79 = Math.min(i85, i79);
                                                        if (z27 && !z36 && (constraintWidget6 == constraintWidget3 || constraintWidget2 == constraintWidget3)) {
                                                            i79 = 4;
                                                        }
                                                    }
                                                    linearSystem.addEquality(solverVariable14, solverVariable4, constraintAnchor.getMargin(), i79);
                                                    linearSystem.addEquality(solverVariable15, solverVariable6, -constraintAnchor2.getMargin(), i79);
                                                }
                                                if (z49) {
                                                    int margin = solverVariable == solverVariable4 ? constraintAnchor.getMargin() : 0;
                                                    if (solverVariable4 != solverVariable) {
                                                        linearSystem.addGreaterThan(solverVariable14, solverVariable, margin, 5);
                                                    }
                                                }
                                                if (z49 || !z46) {
                                                    solverVariable16 = solverVariable15;
                                                } else {
                                                    solverVariable16 = solverVariable15;
                                                    if (i17 == 0 && i48 == 0) {
                                                        if (z46 && i77 == 3) {
                                                            i86 = 0;
                                                            linearSystem.addGreaterThan(solverVariable16, solverVariable14, 0, 8);
                                                        } else {
                                                            i86 = 0;
                                                            linearSystem.addGreaterThan(solverVariable16, solverVariable14, 0, 5);
                                                        }
                                                        if (z49 && z47) {
                                                            if (constraintAnchor2.mTarget != null) {
                                                                i86 = constraintAnchor2.getMargin();
                                                            }
                                                            if (solverVariable6 != solverVariable2) {
                                                                if (this.OPTIMIZE_WRAP && solverVariable16.isFinalValue && (constraintWidget5 = this.mParent) != null) {
                                                                    ConstraintWidgetContainer constraintWidgetContainer = (ConstraintWidgetContainer) constraintWidget5;
                                                                    if (z16) {
                                                                        constraintWidgetContainer.addHorizontalWrapMaxVariable(constraintAnchor2);
                                                                        return;
                                                                    } else {
                                                                        constraintWidgetContainer.addVerticalWrapMaxVariable(constraintAnchor2);
                                                                        return;
                                                                    }
                                                                }
                                                                linearSystem.addGreaterThan(solverVariable2, solverVariable16, i86, 5);
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                }
                                                i86 = 0;
                                                if (z49) {
                                                    return;
                                                } else {
                                                    return;
                                                }
                                            }
                                            return;
                                        }
                                        i69 = 0;
                                        i75 = 4;
                                        i76 = 5;
                                        if (i67 == 0) {
                                        }
                                        z48 = true;
                                        if (i66 == 0) {
                                        }
                                        if (this.mVisibility == 8) {
                                        }
                                        if (i67 == 0) {
                                        }
                                        if (z49) {
                                        }
                                        i79 = i75;
                                        i85 = i78;
                                        if (z48) {
                                        }
                                        if (z49) {
                                        }
                                        if (z49) {
                                        }
                                        solverVariable16 = solverVariable15;
                                        i86 = 0;
                                        if (z49) {
                                        }
                                    }
                                } else {
                                    linearSystem.addEquality(solverVariable5, solverVariable6, -constraintAnchor2.getMargin(), 8);
                                    if (z17) {
                                        if (this.OPTIMIZE_WRAP && createObjectVariable3.isFinalValue && (constraintWidget4 = this.mParent) != null) {
                                            ConstraintWidgetContainer constraintWidgetContainer2 = (ConstraintWidgetContainer) constraintWidget4;
                                            if (z16) {
                                                i59 = i46;
                                                constraintWidgetContainer2.addHorizontalWrapMinVariable(constraintAnchor);
                                            } else {
                                                i59 = i46;
                                                constraintWidgetContainer2.addVerticalWrapMinVariable(constraintAnchor);
                                            }
                                        } else {
                                            i59 = i46;
                                            linearSystem.addGreaterThan(createObjectVariable3, solverVariable, i59, 5);
                                        }
                                    }
                                }
                                i86 = i59;
                                solverVariable16 = solverVariable5;
                                z49 = z17;
                                if (z49) {
                                }
                            }
                            solverVariable16 = solverVariable5;
                            i86 = i46;
                            z49 = z17;
                            if (z49) {
                            }
                        }
                        if (i56 >= i57 && z17 && z47) {
                            linearSystem.addGreaterThan(solverVariable10, solverVariable7, i49, 8);
                            int i107 = (z16 || this.mBaseline.mTarget == null) ? 1 : i49;
                            if (z16 || (constraintAnchor3 = this.mBaseline.mTarget) == null) {
                                i58 = i107;
                            } else {
                                ConstraintWidget constraintWidget8 = constraintAnchor3.mOwner;
                                if (constraintWidget8.mDimensionRatio != 0.0f) {
                                    DimensionBehaviour[] dimensionBehaviourArr = constraintWidget8.mListDimensionBehaviors;
                                    DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[i49];
                                    DimensionBehaviour dimensionBehaviour3 = DimensionBehaviour.MATCH_CONSTRAINT;
                                    if (dimensionBehaviour2 == dimensionBehaviour3 && dimensionBehaviourArr[1] == dimensionBehaviour3) {
                                        i58 = 1;
                                    }
                                }
                                i58 = i49;
                            }
                            if (i58 != 0) {
                                linearSystem.addGreaterThan(solverVariable8, solverVariable9, i49, 8);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    if (z17) {
                        linearSystem.addEquality(createObjectVariable4, createObjectVariable3, i36, i39);
                    } else if (z29) {
                        linearSystem.addEquality(createObjectVariable4, createObjectVariable3, i36, 5);
                        linearSystem.addLowerThan(createObjectVariable4, createObjectVariable3, i36, i39);
                    } else {
                        linearSystem.addEquality(createObjectVariable4, createObjectVariable3, i36, 5);
                        linearSystem.addLowerThan(createObjectVariable4, createObjectVariable3, i36, i39);
                    }
                    i46 = 0;
                    solverVariable4 = createObjectVariable5;
                    solverVariable5 = createObjectVariable4;
                    i48 = i102;
                }
                z46 = z39;
                solverVariable6 = solverVariable3;
                z47 = z19;
                i47 = i98;
                if (z38) {
                }
                if (i56 >= i57) {
                }
            }
        }
        z39 = false;
        if (this.mVisibility != 8) {
        }
        if (z38) {
        }
        if (z39) {
        }
        z46 = z39;
        solverVariable6 = solverVariable3;
        z47 = z19;
        i47 = i98;
        if (z38) {
        }
        if (i56 >= i57) {
        }
    }

    private boolean isChainHead(int i3) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        int i16 = i3 * 2;
        ConstraintAnchor[] constraintAnchorArr = this.mListAnchors;
        ConstraintAnchor constraintAnchor3 = constraintAnchorArr[i16];
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
        if (constraintAnchor4 != null && constraintAnchor4.mTarget != constraintAnchor3 && (constraintAnchor2 = (constraintAnchor = constraintAnchorArr[i16 + 1]).mTarget) != null && constraintAnchor2.mTarget == constraintAnchor) {
            return true;
        }
        return false;
    }

    public void addChildrenToSolverByDependency(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, HashSet<ConstraintWidget> hashSet, int i3, boolean z16) {
        if (z16) {
            if (!hashSet.contains(this)) {
                return;
            }
            Optimizer.checkMatchParent(constraintWidgetContainer, linearSystem, this);
            hashSet.remove(this);
            addToSolver(linearSystem, constraintWidgetContainer.optimizeFor(64));
        }
        if (i3 == 0) {
            HashSet<ConstraintAnchor> dependents = this.mLeft.getDependents();
            if (dependents != null) {
                Iterator<ConstraintAnchor> it = dependents.iterator();
                while (it.hasNext()) {
                    it.next().mOwner.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, i3, true);
                }
            }
            HashSet<ConstraintAnchor> dependents2 = this.mRight.getDependents();
            if (dependents2 != null) {
                Iterator<ConstraintAnchor> it5 = dependents2.iterator();
                while (it5.hasNext()) {
                    it5.next().mOwner.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, i3, true);
                }
                return;
            }
            return;
        }
        HashSet<ConstraintAnchor> dependents3 = this.mTop.getDependents();
        if (dependents3 != null) {
            Iterator<ConstraintAnchor> it6 = dependents3.iterator();
            while (it6.hasNext()) {
                it6.next().mOwner.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, i3, true);
            }
        }
        HashSet<ConstraintAnchor> dependents4 = this.mBottom.getDependents();
        if (dependents4 != null) {
            Iterator<ConstraintAnchor> it7 = dependents4.iterator();
            while (it7.hasNext()) {
                it7.next().mOwner.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, i3, true);
            }
        }
        HashSet<ConstraintAnchor> dependents5 = this.mBaseline.getDependents();
        if (dependents5 != null) {
            Iterator<ConstraintAnchor> it8 = dependents5.iterator();
            while (it8.hasNext()) {
                it8.next().mOwner.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, i3, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean addFirst() {
        if (!(this instanceof VirtualLayout) && !(this instanceof Guideline)) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:125:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x02df  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x02f4  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x02fd  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0319  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0332  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0438  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x04b0  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x04b5  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0546  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x058f  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x05c4  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x05ba  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x0549  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x04b2  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x049c  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x037c  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x038c  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x039b  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x03c4  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x03c7  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x03a4  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0395  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x0300  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x02da  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void addToSolver(LinearSystem linearSystem, boolean z16) {
        boolean z17;
        boolean z18;
        ConstraintWidget constraintWidget;
        ConstraintWidget constraintWidget2;
        boolean z19;
        boolean z26;
        boolean z27;
        boolean z28;
        int i3;
        int i16;
        int i17;
        int i18;
        boolean z29;
        int i19;
        boolean z36;
        boolean z37;
        DimensionBehaviour dimensionBehaviour;
        DimensionBehaviour dimensionBehaviour2;
        boolean z38;
        int i26;
        boolean z39;
        boolean z46;
        boolean z47;
        DimensionBehaviour dimensionBehaviour3;
        DimensionBehaviour dimensionBehaviour4;
        boolean z48;
        SolverVariable solverVariable;
        SolverVariable solverVariable2;
        SolverVariable solverVariable3;
        SolverVariable solverVariable4;
        boolean z49;
        int i27;
        int i28;
        int i29;
        ConstraintWidget constraintWidget3;
        LinearSystem linearSystem2;
        SolverVariable solverVariable5;
        SolverVariable solverVariable6;
        SolverVariable solverVariable7;
        int i36;
        int i37;
        SolverVariable solverVariable8;
        SolverVariable solverVariable9;
        ConstraintWidget constraintWidget4;
        boolean z55;
        SolverVariable solverVariable10;
        SolverVariable solverVariable11;
        boolean z56;
        DimensionBehaviour[] dimensionBehaviourArr;
        boolean z57;
        ConstraintWidget constraintWidget5;
        SolverVariable solverVariable12;
        ConstraintWidget constraintWidget6;
        SolverVariable solverVariable13;
        DimensionBehaviour[] dimensionBehaviourArr2;
        boolean z58;
        HorizontalWidgetRun horizontalWidgetRun;
        DependencyNode dependencyNode;
        int i38;
        boolean isInHorizontalChain;
        boolean isInVerticalChain;
        HorizontalWidgetRun horizontalWidgetRun2;
        VerticalWidgetRun verticalWidgetRun;
        boolean z59;
        boolean z65;
        boolean z66;
        SolverVariable createObjectVariable = linearSystem.createObjectVariable(this.mLeft);
        SolverVariable createObjectVariable2 = linearSystem.createObjectVariable(this.mRight);
        SolverVariable createObjectVariable3 = linearSystem.createObjectVariable(this.mTop);
        SolverVariable createObjectVariable4 = linearSystem.createObjectVariable(this.mBottom);
        SolverVariable createObjectVariable5 = linearSystem.createObjectVariable(this.mBaseline);
        ConstraintWidget constraintWidget7 = this.mParent;
        if (constraintWidget7 != null) {
            if (constraintWidget7 != null && constraintWidget7.mListDimensionBehaviors[0] == DimensionBehaviour.WRAP_CONTENT) {
                z65 = true;
            } else {
                z65 = false;
            }
            if (constraintWidget7 != null && constraintWidget7.mListDimensionBehaviors[1] == DimensionBehaviour.WRAP_CONTENT) {
                z66 = true;
            } else {
                z66 = false;
            }
            z18 = z66;
            z17 = z65;
        } else {
            z17 = false;
            z18 = false;
        }
        if (this.mVisibility == 8 && !hasDependencies()) {
            boolean[] zArr = this.mIsInBarrier;
            if (!zArr[0] && !zArr[1]) {
                return;
            }
        }
        boolean z67 = this.resolvedHorizontal;
        if (z67 || this.resolvedVertical) {
            if (z67) {
                linearSystem.addEquality(createObjectVariable, this.mX);
                linearSystem.addEquality(createObjectVariable2, this.mX + this.mWidth);
                if (z17 && (constraintWidget2 = this.mParent) != null) {
                    if (this.OPTIMIZE_WRAP_ON_RESOLVED) {
                        ConstraintWidgetContainer constraintWidgetContainer = (ConstraintWidgetContainer) constraintWidget2;
                        constraintWidgetContainer.addVerticalWrapMinVariable(this.mLeft);
                        constraintWidgetContainer.addHorizontalWrapMaxVariable(this.mRight);
                    } else {
                        linearSystem.addGreaterThan(linearSystem.createObjectVariable(constraintWidget2.mRight), createObjectVariable2, 0, 5);
                    }
                }
            }
            if (this.resolvedVertical) {
                linearSystem.addEquality(createObjectVariable3, this.mY);
                linearSystem.addEquality(createObjectVariable4, this.mY + this.mHeight);
                if (this.mBaseline.hasDependents()) {
                    linearSystem.addEquality(createObjectVariable5, this.mY + this.mBaselineDistance);
                }
                if (z18 && (constraintWidget = this.mParent) != null) {
                    if (this.OPTIMIZE_WRAP_ON_RESOLVED) {
                        ConstraintWidgetContainer constraintWidgetContainer2 = (ConstraintWidgetContainer) constraintWidget;
                        constraintWidgetContainer2.addVerticalWrapMinVariable(this.mTop);
                        constraintWidgetContainer2.addVerticalWrapMaxVariable(this.mBottom);
                    } else {
                        linearSystem.addGreaterThan(linearSystem.createObjectVariable(constraintWidget.mBottom), createObjectVariable4, 0, 5);
                    }
                }
            }
            if (this.resolvedHorizontal && this.resolvedVertical) {
                this.resolvedHorizontal = false;
                this.resolvedVertical = false;
                return;
            }
        }
        Metrics metrics = LinearSystem.sMetrics;
        if (metrics != null) {
            metrics.widgets++;
        }
        if (z16 && (horizontalWidgetRun2 = this.horizontalRun) != null && (verticalWidgetRun = this.verticalRun) != null) {
            DependencyNode dependencyNode2 = horizontalWidgetRun2.start;
            if (dependencyNode2.resolved && horizontalWidgetRun2.end.resolved && verticalWidgetRun.start.resolved && verticalWidgetRun.end.resolved) {
                if (metrics != null) {
                    metrics.graphSolved++;
                }
                linearSystem.addEquality(createObjectVariable, dependencyNode2.value);
                linearSystem.addEquality(createObjectVariable2, this.horizontalRun.end.value);
                linearSystem.addEquality(createObjectVariable3, this.verticalRun.start.value);
                linearSystem.addEquality(createObjectVariable4, this.verticalRun.end.value);
                linearSystem.addEquality(createObjectVariable5, this.verticalRun.baseline.value);
                if (this.mParent != null) {
                    if (z17 && this.isTerminalWidget[0] && !isInHorizontalChain()) {
                        linearSystem.addGreaterThan(linearSystem.createObjectVariable(this.mParent.mRight), createObjectVariable2, 0, 8);
                    }
                    if (z18 && this.isTerminalWidget[1] && !isInVerticalChain()) {
                        z59 = false;
                        linearSystem.addGreaterThan(linearSystem.createObjectVariable(this.mParent.mBottom), createObjectVariable4, 0, 8);
                        this.resolvedHorizontal = z59;
                        this.resolvedVertical = z59;
                        return;
                    }
                }
                z59 = false;
                this.resolvedHorizontal = z59;
                this.resolvedVertical = z59;
                return;
            }
        }
        if (metrics != null) {
            metrics.linearSolved++;
        }
        if (this.mParent != null) {
            if (isChainHead(0)) {
                ((ConstraintWidgetContainer) this.mParent).addChain(this, 0);
                isInHorizontalChain = true;
            } else {
                isInHorizontalChain = isInHorizontalChain();
            }
            if (isChainHead(1)) {
                ((ConstraintWidgetContainer) this.mParent).addChain(this, 1);
                isInVerticalChain = true;
            } else {
                isInVerticalChain = isInVerticalChain();
            }
            if (!isInHorizontalChain && z17 && this.mVisibility != 8 && this.mLeft.mTarget == null && this.mRight.mTarget == null) {
                linearSystem.addGreaterThan(linearSystem.createObjectVariable(this.mParent.mRight), createObjectVariable2, 0, 1);
            }
            if (!isInVerticalChain && z18 && this.mVisibility != 8 && this.mTop.mTarget == null && this.mBottom.mTarget == null && this.mBaseline == null) {
                linearSystem.addGreaterThan(linearSystem.createObjectVariable(this.mParent.mBottom), createObjectVariable4, 0, 1);
            }
            z26 = isInHorizontalChain;
            z19 = isInVerticalChain;
        } else {
            z19 = false;
            z26 = false;
        }
        int i39 = this.mWidth;
        int i46 = this.mMinWidth;
        if (i39 >= i46) {
            i46 = i39;
        }
        int i47 = this.mHeight;
        int i48 = this.mMinHeight;
        if (i47 >= i48) {
            i48 = i47;
        }
        DimensionBehaviour[] dimensionBehaviourArr3 = this.mListDimensionBehaviors;
        DimensionBehaviour dimensionBehaviour5 = dimensionBehaviourArr3[0];
        DimensionBehaviour dimensionBehaviour6 = DimensionBehaviour.MATCH_CONSTRAINT;
        int i49 = i46;
        if (dimensionBehaviour5 != dimensionBehaviour6) {
            z27 = true;
        } else {
            z27 = false;
        }
        DimensionBehaviour dimensionBehaviour7 = dimensionBehaviourArr3[1];
        int i56 = i48;
        if (dimensionBehaviour7 != dimensionBehaviour6) {
            z28 = true;
        } else {
            z28 = false;
        }
        int i57 = this.mDimensionRatioSide;
        this.mResolvedDimensionRatioSide = i57;
        float f16 = this.mDimensionRatio;
        this.mResolvedDimensionRatio = f16;
        int i58 = this.mMatchConstraintDefaultWidth;
        SolverVariable solverVariable14 = createObjectVariable2;
        int i59 = this.mMatchConstraintDefaultHeight;
        if (f16 > 0.0f && this.mVisibility != 8) {
            if (dimensionBehaviour5 == dimensionBehaviour6 && i58 == 0) {
                i58 = 3;
            }
            if (dimensionBehaviour7 == dimensionBehaviour6 && i59 == 0) {
                i59 = 3;
            }
            if (dimensionBehaviour5 == dimensionBehaviour6 && dimensionBehaviour7 == dimensionBehaviour6 && i58 == 3 && i59 == 3) {
                setupDimensionRatio(z17, z18, z27, z28);
            } else {
                if (dimensionBehaviour5 == dimensionBehaviour6 && i58 == 3) {
                    this.mResolvedDimensionRatioSide = 0;
                    int i65 = (int) (f16 * i47);
                    if (dimensionBehaviour7 != dimensionBehaviour6) {
                        i3 = 4;
                        i16 = i59;
                        i18 = i56;
                        z29 = false;
                        i17 = i65;
                        int[] iArr = this.mResolvedMatchConstraintDefault;
                        iArr[0] = i3;
                        iArr[1] = i16;
                        this.mResolvedHasRatio = z29;
                        if (z29) {
                        }
                        z36 = false;
                        if (!z29) {
                        }
                        z37 = false;
                        dimensionBehaviour = this.mListDimensionBehaviors[0];
                        dimensionBehaviour2 = DimensionBehaviour.WRAP_CONTENT;
                        if (dimensionBehaviour != dimensionBehaviour2) {
                        }
                        z38 = false;
                        if (!z38) {
                        }
                        z39 = !this.mCenter.isConnected();
                        boolean[] zArr2 = this.mIsInBarrier;
                        z46 = zArr2[0];
                        boolean z68 = zArr2[1];
                        if (this.mHorizontalResolution != 2) {
                        }
                        z47 = z17;
                        dimensionBehaviour3 = dimensionBehaviour6;
                        dimensionBehaviour4 = dimensionBehaviour2;
                        z48 = z29;
                        solverVariable = createObjectVariable5;
                        solverVariable2 = createObjectVariable4;
                        solverVariable3 = createObjectVariable3;
                        solverVariable4 = createObjectVariable;
                        z49 = z18;
                        if (z16) {
                        }
                        i36 = i29;
                        if (constraintWidget3.mVerticalResolution != 2) {
                        }
                        if (i37 == 0) {
                        }
                        solverVariable8 = solverVariable6;
                        solverVariable9 = solverVariable7;
                        if (!z48) {
                        }
                        if (constraintWidget4.mCenter.isConnected()) {
                        }
                        constraintWidget4.resolvedHorizontal = false;
                        constraintWidget4.resolvedVertical = false;
                    }
                    i17 = i65;
                    i3 = i58;
                    i16 = i59;
                    i18 = i56;
                    z29 = true;
                    int[] iArr2 = this.mResolvedMatchConstraintDefault;
                    iArr2[0] = i3;
                    iArr2[1] = i16;
                    this.mResolvedHasRatio = z29;
                    if (z29) {
                    }
                    z36 = false;
                    if (!z29) {
                    }
                    z37 = false;
                    dimensionBehaviour = this.mListDimensionBehaviors[0];
                    dimensionBehaviour2 = DimensionBehaviour.WRAP_CONTENT;
                    if (dimensionBehaviour != dimensionBehaviour2) {
                    }
                    z38 = false;
                    if (!z38) {
                    }
                    z39 = !this.mCenter.isConnected();
                    boolean[] zArr22 = this.mIsInBarrier;
                    z46 = zArr22[0];
                    boolean z682 = zArr22[1];
                    if (this.mHorizontalResolution != 2) {
                    }
                    z47 = z17;
                    dimensionBehaviour3 = dimensionBehaviour6;
                    dimensionBehaviour4 = dimensionBehaviour2;
                    z48 = z29;
                    solverVariable = createObjectVariable5;
                    solverVariable2 = createObjectVariable4;
                    solverVariable3 = createObjectVariable3;
                    solverVariable4 = createObjectVariable;
                    z49 = z18;
                    if (z16) {
                    }
                    i36 = i29;
                    if (constraintWidget3.mVerticalResolution != 2) {
                    }
                    if (i37 == 0) {
                    }
                    solverVariable8 = solverVariable6;
                    solverVariable9 = solverVariable7;
                    if (!z48) {
                    }
                    if (constraintWidget4.mCenter.isConnected()) {
                    }
                    constraintWidget4.resolvedHorizontal = false;
                    constraintWidget4.resolvedVertical = false;
                }
                if (dimensionBehaviour7 == dimensionBehaviour6 && i59 == 3) {
                    this.mResolvedDimensionRatioSide = 1;
                    if (i57 == -1) {
                        this.mResolvedDimensionRatio = 1.0f / f16;
                    }
                    int i66 = (int) (this.mResolvedDimensionRatio * i39);
                    if (dimensionBehaviour5 != dimensionBehaviour6) {
                        i16 = 4;
                        i18 = i66;
                        i3 = i58;
                        i17 = i49;
                    } else {
                        i18 = i66;
                        i3 = i58;
                        i16 = i59;
                        i17 = i49;
                        z29 = true;
                        int[] iArr22 = this.mResolvedMatchConstraintDefault;
                        iArr22[0] = i3;
                        iArr22[1] = i16;
                        this.mResolvedHasRatio = z29;
                        if (z29) {
                            int i67 = this.mResolvedDimensionRatioSide;
                            i19 = -1;
                            if (i67 == 0 || i67 == -1) {
                                z36 = true;
                                if (!z29 && ((i38 = this.mResolvedDimensionRatioSide) == 1 || i38 == i19)) {
                                    z37 = true;
                                } else {
                                    z37 = false;
                                }
                                dimensionBehaviour = this.mListDimensionBehaviors[0];
                                dimensionBehaviour2 = DimensionBehaviour.WRAP_CONTENT;
                                if (dimensionBehaviour != dimensionBehaviour2 && (this instanceof ConstraintWidgetContainer)) {
                                    z38 = true;
                                } else {
                                    z38 = false;
                                }
                                if (!z38) {
                                    i26 = 0;
                                } else {
                                    i26 = i17;
                                }
                                z39 = !this.mCenter.isConnected();
                                boolean[] zArr222 = this.mIsInBarrier;
                                z46 = zArr222[0];
                                boolean z6822 = zArr222[1];
                                if (this.mHorizontalResolution != 2 && !this.resolvedHorizontal) {
                                    if (z16 && (horizontalWidgetRun = this.horizontalRun) != null) {
                                        dependencyNode = horizontalWidgetRun.start;
                                        if (dependencyNode.resolved && horizontalWidgetRun.end.resolved) {
                                            if (!z16) {
                                                linearSystem.addEquality(createObjectVariable, dependencyNode.value);
                                                linearSystem.addEquality(solverVariable14, this.horizontalRun.end.value);
                                                if (this.mParent != null && z17 && this.isTerminalWidget[0] && !isInHorizontalChain()) {
                                                    linearSystem.addGreaterThan(linearSystem.createObjectVariable(this.mParent.mRight), solverVariable14, 0, 8);
                                                }
                                                z47 = z17;
                                                z49 = z18;
                                                dimensionBehaviour3 = dimensionBehaviour6;
                                                solverVariable14 = solverVariable14;
                                                solverVariable4 = createObjectVariable;
                                                dimensionBehaviour4 = dimensionBehaviour2;
                                                z48 = z29;
                                                solverVariable = createObjectVariable5;
                                                solverVariable2 = createObjectVariable4;
                                                solverVariable3 = createObjectVariable3;
                                                if (z16) {
                                                    constraintWidget3 = this;
                                                    VerticalWidgetRun verticalWidgetRun2 = constraintWidget3.verticalRun;
                                                    if (verticalWidgetRun2 != null) {
                                                        DependencyNode dependencyNode3 = verticalWidgetRun2.start;
                                                        if (dependencyNode3.resolved && verticalWidgetRun2.end.resolved) {
                                                            linearSystem2 = linearSystem;
                                                            solverVariable7 = solverVariable3;
                                                            linearSystem2.addEquality(solverVariable7, dependencyNode3.value);
                                                            solverVariable6 = solverVariable2;
                                                            linearSystem2.addEquality(solverVariable6, constraintWidget3.verticalRun.end.value);
                                                            solverVariable5 = solverVariable;
                                                            linearSystem2.addEquality(solverVariable5, constraintWidget3.verticalRun.baseline.value);
                                                            ConstraintWidget constraintWidget8 = constraintWidget3.mParent;
                                                            if (constraintWidget8 != null && !z19 && z49) {
                                                                i29 = 1;
                                                                if (constraintWidget3.isTerminalWidget[1]) {
                                                                    i27 = 8;
                                                                    i28 = 0;
                                                                    linearSystem2.addGreaterThan(linearSystem2.createObjectVariable(constraintWidget8.mBottom), solverVariable6, 0, 8);
                                                                } else {
                                                                    i27 = 8;
                                                                    i28 = 0;
                                                                }
                                                            } else {
                                                                i27 = 8;
                                                                i28 = 0;
                                                                i29 = 1;
                                                            }
                                                            i36 = i28;
                                                            if (constraintWidget3.mVerticalResolution != 2) {
                                                                i37 = i28;
                                                            } else {
                                                                i37 = i36;
                                                            }
                                                            if (i37 == 0 && !constraintWidget3.resolvedVertical) {
                                                                if (constraintWidget3.mListDimensionBehaviors[i29] == dimensionBehaviour4 && (constraintWidget3 instanceof ConstraintWidgetContainer)) {
                                                                    z55 = i29;
                                                                } else {
                                                                    z55 = i28;
                                                                }
                                                                if (z55) {
                                                                    i18 = i28;
                                                                }
                                                                ConstraintWidget constraintWidget9 = constraintWidget3.mParent;
                                                                if (constraintWidget9 != null) {
                                                                    solverVariable10 = linearSystem2.createObjectVariable(constraintWidget9.mBottom);
                                                                } else {
                                                                    solverVariable10 = null;
                                                                }
                                                                ConstraintWidget constraintWidget10 = constraintWidget3.mParent;
                                                                if (constraintWidget10 != null) {
                                                                    solverVariable11 = linearSystem2.createObjectVariable(constraintWidget10.mTop);
                                                                } else {
                                                                    solverVariable11 = null;
                                                                }
                                                                if (constraintWidget3.mBaselineDistance > 0 || constraintWidget3.mVisibility == i27) {
                                                                    if (constraintWidget3.mBaseline.mTarget != null) {
                                                                        linearSystem2.addEquality(solverVariable5, solverVariable7, getBaselineDistance(), i27);
                                                                        linearSystem2.addEquality(solverVariable5, linearSystem2.createObjectVariable(constraintWidget3.mBaseline.mTarget), i28, i27);
                                                                        if (z49) {
                                                                            linearSystem2.addGreaterThan(solverVariable10, linearSystem2.createObjectVariable(constraintWidget3.mBottom), i28, 5);
                                                                        }
                                                                        z56 = i28;
                                                                        boolean z69 = constraintWidget3.isTerminalWidget[i29];
                                                                        dimensionBehaviourArr = constraintWidget3.mListDimensionBehaviors;
                                                                        DimensionBehaviour dimensionBehaviour8 = dimensionBehaviourArr[i29];
                                                                        ConstraintAnchor constraintAnchor = constraintWidget3.mTop;
                                                                        ConstraintAnchor constraintAnchor2 = constraintWidget3.mBottom;
                                                                        int i68 = constraintWidget3.mY;
                                                                        int i69 = constraintWidget3.mMinHeight;
                                                                        int i75 = constraintWidget3.mMaxDimension[i29];
                                                                        float f17 = constraintWidget3.mVerticalBiasPercent;
                                                                        if (dimensionBehaviourArr[0] != dimensionBehaviour3) {
                                                                            z57 = true;
                                                                        } else {
                                                                            z57 = false;
                                                                        }
                                                                        solverVariable8 = solverVariable6;
                                                                        solverVariable9 = solverVariable7;
                                                                        applyConstraints(linearSystem, false, z49, z47, z69, solverVariable11, solverVariable10, dimensionBehaviour8, z55, constraintAnchor, constraintAnchor2, i68, i18, i69, i75, f17, z37, z57, z19, z26, z6822, i16, i3, constraintWidget3.mMatchConstraintMinHeight, constraintWidget3.mMatchConstraintMaxHeight, constraintWidget3.mMatchConstraintPercentHeight, z56);
                                                                    } else if (constraintWidget3.mVisibility == i27) {
                                                                        linearSystem2.addEquality(solverVariable5, solverVariable7, i28, i27);
                                                                    } else {
                                                                        linearSystem2.addEquality(solverVariable5, solverVariable7, getBaselineDistance(), i27);
                                                                    }
                                                                }
                                                                z56 = z39;
                                                                boolean z692 = constraintWidget3.isTerminalWidget[i29];
                                                                dimensionBehaviourArr = constraintWidget3.mListDimensionBehaviors;
                                                                DimensionBehaviour dimensionBehaviour82 = dimensionBehaviourArr[i29];
                                                                ConstraintAnchor constraintAnchor3 = constraintWidget3.mTop;
                                                                ConstraintAnchor constraintAnchor22 = constraintWidget3.mBottom;
                                                                int i682 = constraintWidget3.mY;
                                                                int i692 = constraintWidget3.mMinHeight;
                                                                int i752 = constraintWidget3.mMaxDimension[i29];
                                                                float f172 = constraintWidget3.mVerticalBiasPercent;
                                                                if (dimensionBehaviourArr[0] != dimensionBehaviour3) {
                                                                }
                                                                solverVariable8 = solverVariable6;
                                                                solverVariable9 = solverVariable7;
                                                                applyConstraints(linearSystem, false, z49, z47, z692, solverVariable11, solverVariable10, dimensionBehaviour82, z55, constraintAnchor3, constraintAnchor22, i682, i18, i692, i752, f172, z37, z57, z19, z26, z6822, i16, i3, constraintWidget3.mMatchConstraintMinHeight, constraintWidget3.mMatchConstraintMaxHeight, constraintWidget3.mMatchConstraintPercentHeight, z56);
                                                            } else {
                                                                solverVariable8 = solverVariable6;
                                                                solverVariable9 = solverVariable7;
                                                            }
                                                            if (!z48) {
                                                                constraintWidget4 = this;
                                                                if (constraintWidget4.mResolvedDimensionRatioSide == 1) {
                                                                    linearSystem.addRatio(solverVariable8, solverVariable9, solverVariable14, solverVariable4, constraintWidget4.mResolvedDimensionRatio, 8);
                                                                } else {
                                                                    linearSystem.addRatio(solverVariable14, solverVariable4, solverVariable8, solverVariable9, constraintWidget4.mResolvedDimensionRatio, 8);
                                                                }
                                                            } else {
                                                                constraintWidget4 = this;
                                                            }
                                                            if (constraintWidget4.mCenter.isConnected()) {
                                                                linearSystem.addCenterPoint(constraintWidget4, constraintWidget4.mCenter.getTarget().getOwner(), (float) Math.toRadians(constraintWidget4.mCircleConstraintAngle + 90.0f), constraintWidget4.mCenter.getMargin());
                                                            }
                                                            constraintWidget4.resolvedHorizontal = false;
                                                            constraintWidget4.resolvedVertical = false;
                                                        }
                                                    }
                                                    linearSystem2 = linearSystem;
                                                    solverVariable5 = solverVariable;
                                                    solverVariable6 = solverVariable2;
                                                    solverVariable7 = solverVariable3;
                                                    i27 = 8;
                                                    i28 = 0;
                                                    i29 = 1;
                                                } else {
                                                    i27 = 8;
                                                    i28 = 0;
                                                    i29 = 1;
                                                    constraintWidget3 = this;
                                                    linearSystem2 = linearSystem;
                                                    solverVariable5 = solverVariable;
                                                    solverVariable6 = solverVariable2;
                                                    solverVariable7 = solverVariable3;
                                                }
                                                i36 = i29;
                                                if (constraintWidget3.mVerticalResolution != 2) {
                                                }
                                                if (i37 == 0) {
                                                }
                                                solverVariable8 = solverVariable6;
                                                solverVariable9 = solverVariable7;
                                                if (!z48) {
                                                }
                                                if (constraintWidget4.mCenter.isConnected()) {
                                                }
                                                constraintWidget4.resolvedHorizontal = false;
                                                constraintWidget4.resolvedVertical = false;
                                            }
                                        }
                                    }
                                    constraintWidget5 = this.mParent;
                                    if (constraintWidget5 == null) {
                                        solverVariable12 = linearSystem.createObjectVariable(constraintWidget5.mRight);
                                    } else {
                                        solverVariable12 = null;
                                    }
                                    constraintWidget6 = this.mParent;
                                    if (constraintWidget6 == null) {
                                        solverVariable13 = linearSystem.createObjectVariable(constraintWidget6.mLeft);
                                    } else {
                                        solverVariable13 = null;
                                    }
                                    boolean z75 = this.isTerminalWidget[0];
                                    dimensionBehaviourArr2 = this.mListDimensionBehaviors;
                                    DimensionBehaviour dimensionBehaviour9 = dimensionBehaviourArr2[0];
                                    ConstraintAnchor constraintAnchor4 = this.mLeft;
                                    ConstraintAnchor constraintAnchor5 = this.mRight;
                                    int i76 = this.mX;
                                    int i77 = this.mMinWidth;
                                    int i78 = this.mMaxDimension[0];
                                    float f18 = this.mHorizontalBiasPercent;
                                    if (dimensionBehaviourArr2[1] != dimensionBehaviour6) {
                                        z58 = true;
                                    } else {
                                        z58 = false;
                                    }
                                    z47 = z17;
                                    z49 = z18;
                                    dimensionBehaviour3 = dimensionBehaviour6;
                                    solverVariable = createObjectVariable5;
                                    solverVariable2 = createObjectVariable4;
                                    solverVariable3 = createObjectVariable3;
                                    solverVariable14 = solverVariable14;
                                    dimensionBehaviour4 = dimensionBehaviour2;
                                    solverVariable4 = createObjectVariable;
                                    z48 = z29;
                                    applyConstraints(linearSystem, true, z17, z18, z75, solverVariable13, solverVariable12, dimensionBehaviour9, z38, constraintAnchor4, constraintAnchor5, i76, i26, i77, i78, f18, z36, z58, z26, z19, z46, i3, i16, this.mMatchConstraintMinWidth, this.mMatchConstraintMaxWidth, this.mMatchConstraintPercentWidth, z39);
                                    if (z16) {
                                    }
                                    i36 = i29;
                                    if (constraintWidget3.mVerticalResolution != 2) {
                                    }
                                    if (i37 == 0) {
                                    }
                                    solverVariable8 = solverVariable6;
                                    solverVariable9 = solverVariable7;
                                    if (!z48) {
                                    }
                                    if (constraintWidget4.mCenter.isConnected()) {
                                    }
                                    constraintWidget4.resolvedHorizontal = false;
                                    constraintWidget4.resolvedVertical = false;
                                }
                                z47 = z17;
                                dimensionBehaviour3 = dimensionBehaviour6;
                                dimensionBehaviour4 = dimensionBehaviour2;
                                z48 = z29;
                                solverVariable = createObjectVariable5;
                                solverVariable2 = createObjectVariable4;
                                solverVariable3 = createObjectVariable3;
                                solverVariable4 = createObjectVariable;
                                z49 = z18;
                                if (z16) {
                                }
                                i36 = i29;
                                if (constraintWidget3.mVerticalResolution != 2) {
                                }
                                if (i37 == 0) {
                                }
                                solverVariable8 = solverVariable6;
                                solverVariable9 = solverVariable7;
                                if (!z48) {
                                }
                                if (constraintWidget4.mCenter.isConnected()) {
                                }
                                constraintWidget4.resolvedHorizontal = false;
                                constraintWidget4.resolvedVertical = false;
                            }
                        } else {
                            i19 = -1;
                        }
                        z36 = false;
                        if (!z29) {
                        }
                        z37 = false;
                        dimensionBehaviour = this.mListDimensionBehaviors[0];
                        dimensionBehaviour2 = DimensionBehaviour.WRAP_CONTENT;
                        if (dimensionBehaviour != dimensionBehaviour2) {
                        }
                        z38 = false;
                        if (!z38) {
                        }
                        z39 = !this.mCenter.isConnected();
                        boolean[] zArr2222 = this.mIsInBarrier;
                        z46 = zArr2222[0];
                        boolean z68222 = zArr2222[1];
                        if (this.mHorizontalResolution != 2) {
                            if (z16) {
                                dependencyNode = horizontalWidgetRun.start;
                                if (dependencyNode.resolved) {
                                    if (!z16) {
                                    }
                                }
                            }
                            constraintWidget5 = this.mParent;
                            if (constraintWidget5 == null) {
                            }
                            constraintWidget6 = this.mParent;
                            if (constraintWidget6 == null) {
                            }
                            boolean z752 = this.isTerminalWidget[0];
                            dimensionBehaviourArr2 = this.mListDimensionBehaviors;
                            DimensionBehaviour dimensionBehaviour92 = dimensionBehaviourArr2[0];
                            ConstraintAnchor constraintAnchor42 = this.mLeft;
                            ConstraintAnchor constraintAnchor52 = this.mRight;
                            int i762 = this.mX;
                            int i772 = this.mMinWidth;
                            int i782 = this.mMaxDimension[0];
                            float f182 = this.mHorizontalBiasPercent;
                            if (dimensionBehaviourArr2[1] != dimensionBehaviour6) {
                            }
                            z47 = z17;
                            z49 = z18;
                            dimensionBehaviour3 = dimensionBehaviour6;
                            solverVariable = createObjectVariable5;
                            solverVariable2 = createObjectVariable4;
                            solverVariable3 = createObjectVariable3;
                            solverVariable14 = solverVariable14;
                            dimensionBehaviour4 = dimensionBehaviour2;
                            solverVariable4 = createObjectVariable;
                            z48 = z29;
                            applyConstraints(linearSystem, true, z17, z18, z752, solverVariable13, solverVariable12, dimensionBehaviour92, z38, constraintAnchor42, constraintAnchor52, i762, i26, i772, i782, f182, z36, z58, z26, z19, z46, i3, i16, this.mMatchConstraintMinWidth, this.mMatchConstraintMaxWidth, this.mMatchConstraintPercentWidth, z39);
                            if (z16) {
                            }
                            i36 = i29;
                            if (constraintWidget3.mVerticalResolution != 2) {
                            }
                            if (i37 == 0) {
                            }
                            solverVariable8 = solverVariable6;
                            solverVariable9 = solverVariable7;
                            if (!z48) {
                            }
                            if (constraintWidget4.mCenter.isConnected()) {
                            }
                            constraintWidget4.resolvedHorizontal = false;
                            constraintWidget4.resolvedVertical = false;
                        }
                        z47 = z17;
                        dimensionBehaviour3 = dimensionBehaviour6;
                        dimensionBehaviour4 = dimensionBehaviour2;
                        z48 = z29;
                        solverVariable = createObjectVariable5;
                        solverVariable2 = createObjectVariable4;
                        solverVariable3 = createObjectVariable3;
                        solverVariable4 = createObjectVariable;
                        z49 = z18;
                        if (z16) {
                        }
                        i36 = i29;
                        if (constraintWidget3.mVerticalResolution != 2) {
                        }
                        if (i37 == 0) {
                        }
                        solverVariable8 = solverVariable6;
                        solverVariable9 = solverVariable7;
                        if (!z48) {
                        }
                        if (constraintWidget4.mCenter.isConnected()) {
                        }
                        constraintWidget4.resolvedHorizontal = false;
                        constraintWidget4.resolvedVertical = false;
                    }
                }
            }
            i3 = i58;
            i16 = i59;
            i17 = i49;
            i18 = i56;
            z29 = true;
            int[] iArr222 = this.mResolvedMatchConstraintDefault;
            iArr222[0] = i3;
            iArr222[1] = i16;
            this.mResolvedHasRatio = z29;
            if (z29) {
            }
            z36 = false;
            if (!z29) {
            }
            z37 = false;
            dimensionBehaviour = this.mListDimensionBehaviors[0];
            dimensionBehaviour2 = DimensionBehaviour.WRAP_CONTENT;
            if (dimensionBehaviour != dimensionBehaviour2) {
            }
            z38 = false;
            if (!z38) {
            }
            z39 = !this.mCenter.isConnected();
            boolean[] zArr22222 = this.mIsInBarrier;
            z46 = zArr22222[0];
            boolean z682222 = zArr22222[1];
            if (this.mHorizontalResolution != 2) {
            }
            z47 = z17;
            dimensionBehaviour3 = dimensionBehaviour6;
            dimensionBehaviour4 = dimensionBehaviour2;
            z48 = z29;
            solverVariable = createObjectVariable5;
            solverVariable2 = createObjectVariable4;
            solverVariable3 = createObjectVariable3;
            solverVariable4 = createObjectVariable;
            z49 = z18;
            if (z16) {
            }
            i36 = i29;
            if (constraintWidget3.mVerticalResolution != 2) {
            }
            if (i37 == 0) {
            }
            solverVariable8 = solverVariable6;
            solverVariable9 = solverVariable7;
            if (!z48) {
            }
            if (constraintWidget4.mCenter.isConnected()) {
            }
            constraintWidget4.resolvedHorizontal = false;
            constraintWidget4.resolvedVertical = false;
        }
        i3 = i58;
        i16 = i59;
        i17 = i49;
        i18 = i56;
        z29 = false;
        int[] iArr2222 = this.mResolvedMatchConstraintDefault;
        iArr2222[0] = i3;
        iArr2222[1] = i16;
        this.mResolvedHasRatio = z29;
        if (z29) {
        }
        z36 = false;
        if (!z29) {
        }
        z37 = false;
        dimensionBehaviour = this.mListDimensionBehaviors[0];
        dimensionBehaviour2 = DimensionBehaviour.WRAP_CONTENT;
        if (dimensionBehaviour != dimensionBehaviour2) {
        }
        z38 = false;
        if (!z38) {
        }
        z39 = !this.mCenter.isConnected();
        boolean[] zArr222222 = this.mIsInBarrier;
        z46 = zArr222222[0];
        boolean z6822222 = zArr222222[1];
        if (this.mHorizontalResolution != 2) {
        }
        z47 = z17;
        dimensionBehaviour3 = dimensionBehaviour6;
        dimensionBehaviour4 = dimensionBehaviour2;
        z48 = z29;
        solverVariable = createObjectVariable5;
        solverVariable2 = createObjectVariable4;
        solverVariable3 = createObjectVariable3;
        solverVariable4 = createObjectVariable;
        z49 = z18;
        if (z16) {
        }
        i36 = i29;
        if (constraintWidget3.mVerticalResolution != 2) {
        }
        if (i37 == 0) {
        }
        solverVariable8 = solverVariable6;
        solverVariable9 = solverVariable7;
        if (!z48) {
        }
        if (constraintWidget4.mCenter.isConnected()) {
        }
        constraintWidget4.resolvedHorizontal = false;
        constraintWidget4.resolvedVertical = false;
    }

    public boolean allowedInBarrier() {
        if (this.mVisibility != 8) {
            return true;
        }
        return false;
    }

    public void connect(ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i3) {
        if (constraintAnchor.getOwner() == this) {
            connect(constraintAnchor.getType(), constraintAnchor2.getOwner(), constraintAnchor2.getType(), i3);
        }
    }

    public void connectCircularConstraint(ConstraintWidget constraintWidget, float f16, int i3) {
        ConstraintAnchor.Type type = ConstraintAnchor.Type.CENTER;
        immediateConnect(type, constraintWidget, type, i3, 0);
        this.mCircleConstraintAngle = f16;
    }

    public void copy(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        ConstraintWidget constraintWidget2;
        ConstraintWidget constraintWidget3;
        this.mHorizontalResolution = constraintWidget.mHorizontalResolution;
        this.mVerticalResolution = constraintWidget.mVerticalResolution;
        this.mMatchConstraintDefaultWidth = constraintWidget.mMatchConstraintDefaultWidth;
        this.mMatchConstraintDefaultHeight = constraintWidget.mMatchConstraintDefaultHeight;
        int[] iArr = this.mResolvedMatchConstraintDefault;
        int[] iArr2 = constraintWidget.mResolvedMatchConstraintDefault;
        iArr[0] = iArr2[0];
        iArr[1] = iArr2[1];
        this.mMatchConstraintMinWidth = constraintWidget.mMatchConstraintMinWidth;
        this.mMatchConstraintMaxWidth = constraintWidget.mMatchConstraintMaxWidth;
        this.mMatchConstraintMinHeight = constraintWidget.mMatchConstraintMinHeight;
        this.mMatchConstraintMaxHeight = constraintWidget.mMatchConstraintMaxHeight;
        this.mMatchConstraintPercentHeight = constraintWidget.mMatchConstraintPercentHeight;
        this.mIsWidthWrapContent = constraintWidget.mIsWidthWrapContent;
        this.mIsHeightWrapContent = constraintWidget.mIsHeightWrapContent;
        this.mResolvedDimensionRatioSide = constraintWidget.mResolvedDimensionRatioSide;
        this.mResolvedDimensionRatio = constraintWidget.mResolvedDimensionRatio;
        int[] iArr3 = constraintWidget.mMaxDimension;
        this.mMaxDimension = Arrays.copyOf(iArr3, iArr3.length);
        this.mCircleConstraintAngle = constraintWidget.mCircleConstraintAngle;
        this.hasBaseline = constraintWidget.hasBaseline;
        this.inPlaceholder = constraintWidget.inPlaceholder;
        this.mLeft.reset();
        this.mTop.reset();
        this.mRight.reset();
        this.mBottom.reset();
        this.mBaseline.reset();
        this.mCenterX.reset();
        this.mCenterY.reset();
        this.mCenter.reset();
        this.mListDimensionBehaviors = (DimensionBehaviour[]) Arrays.copyOf(this.mListDimensionBehaviors, 2);
        ConstraintWidget constraintWidget4 = null;
        if (this.mParent == null) {
            constraintWidget2 = null;
        } else {
            constraintWidget2 = hashMap.get(constraintWidget.mParent);
        }
        this.mParent = constraintWidget2;
        this.mWidth = constraintWidget.mWidth;
        this.mHeight = constraintWidget.mHeight;
        this.mDimensionRatio = constraintWidget.mDimensionRatio;
        this.mDimensionRatioSide = constraintWidget.mDimensionRatioSide;
        this.mX = constraintWidget.mX;
        this.mY = constraintWidget.mY;
        this.mRelX = constraintWidget.mRelX;
        this.mRelY = constraintWidget.mRelY;
        this.mOffsetX = constraintWidget.mOffsetX;
        this.mOffsetY = constraintWidget.mOffsetY;
        this.mBaselineDistance = constraintWidget.mBaselineDistance;
        this.mMinWidth = constraintWidget.mMinWidth;
        this.mMinHeight = constraintWidget.mMinHeight;
        this.mHorizontalBiasPercent = constraintWidget.mHorizontalBiasPercent;
        this.mVerticalBiasPercent = constraintWidget.mVerticalBiasPercent;
        this.mCompanionWidget = constraintWidget.mCompanionWidget;
        this.mContainerItemSkip = constraintWidget.mContainerItemSkip;
        this.mVisibility = constraintWidget.mVisibility;
        this.mDebugName = constraintWidget.mDebugName;
        this.mType = constraintWidget.mType;
        this.mDistToTop = constraintWidget.mDistToTop;
        this.mDistToLeft = constraintWidget.mDistToLeft;
        this.mDistToRight = constraintWidget.mDistToRight;
        this.mDistToBottom = constraintWidget.mDistToBottom;
        this.mLeftHasCentered = constraintWidget.mLeftHasCentered;
        this.mRightHasCentered = constraintWidget.mRightHasCentered;
        this.mTopHasCentered = constraintWidget.mTopHasCentered;
        this.mBottomHasCentered = constraintWidget.mBottomHasCentered;
        this.mHorizontalWrapVisited = constraintWidget.mHorizontalWrapVisited;
        this.mVerticalWrapVisited = constraintWidget.mVerticalWrapVisited;
        this.mHorizontalChainStyle = constraintWidget.mHorizontalChainStyle;
        this.mVerticalChainStyle = constraintWidget.mVerticalChainStyle;
        this.mHorizontalChainFixedPosition = constraintWidget.mHorizontalChainFixedPosition;
        this.mVerticalChainFixedPosition = constraintWidget.mVerticalChainFixedPosition;
        float[] fArr = this.mWeight;
        float[] fArr2 = constraintWidget.mWeight;
        fArr[0] = fArr2[0];
        fArr[1] = fArr2[1];
        ConstraintWidget[] constraintWidgetArr = this.mListNextMatchConstraintsWidget;
        ConstraintWidget[] constraintWidgetArr2 = constraintWidget.mListNextMatchConstraintsWidget;
        constraintWidgetArr[0] = constraintWidgetArr2[0];
        constraintWidgetArr[1] = constraintWidgetArr2[1];
        ConstraintWidget[] constraintWidgetArr3 = this.mNextChainWidget;
        ConstraintWidget[] constraintWidgetArr4 = constraintWidget.mNextChainWidget;
        constraintWidgetArr3[0] = constraintWidgetArr4[0];
        constraintWidgetArr3[1] = constraintWidgetArr4[1];
        ConstraintWidget constraintWidget5 = constraintWidget.mHorizontalNextWidget;
        if (constraintWidget5 == null) {
            constraintWidget3 = null;
        } else {
            constraintWidget3 = hashMap.get(constraintWidget5);
        }
        this.mHorizontalNextWidget = constraintWidget3;
        ConstraintWidget constraintWidget6 = constraintWidget.mVerticalNextWidget;
        if (constraintWidget6 != null) {
            constraintWidget4 = hashMap.get(constraintWidget6);
        }
        this.mVerticalNextWidget = constraintWidget4;
    }

    public void createObjectVariables(LinearSystem linearSystem) {
        linearSystem.createObjectVariable(this.mLeft);
        linearSystem.createObjectVariable(this.mTop);
        linearSystem.createObjectVariable(this.mRight);
        linearSystem.createObjectVariable(this.mBottom);
        if (this.mBaselineDistance > 0) {
            linearSystem.createObjectVariable(this.mBaseline);
        }
    }

    public void ensureMeasureRequested() {
        this.mMeasureRequested = true;
    }

    public void ensureWidgetRuns() {
        if (this.horizontalRun == null) {
            this.horizontalRun = new HorizontalWidgetRun(this);
        }
        if (this.verticalRun == null) {
            this.verticalRun = new VerticalWidgetRun(this);
        }
    }

    public ConstraintAnchor getAnchor(ConstraintAnchor.Type type) {
        switch (AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[type.ordinal()]) {
            case 1:
                return this.mLeft;
            case 2:
                return this.mTop;
            case 3:
                return this.mRight;
            case 4:
                return this.mBottom;
            case 5:
                return this.mBaseline;
            case 6:
                return this.mCenter;
            case 7:
                return this.mCenterX;
            case 8:
                return this.mCenterY;
            case 9:
                return null;
            default:
                throw new AssertionError(type.name());
        }
    }

    public ArrayList<ConstraintAnchor> getAnchors() {
        return this.mAnchors;
    }

    public int getBaselineDistance() {
        return this.mBaselineDistance;
    }

    public float getBiasPercent(int i3) {
        if (i3 == 0) {
            return this.mHorizontalBiasPercent;
        }
        if (i3 == 1) {
            return this.mVerticalBiasPercent;
        }
        return -1.0f;
    }

    public int getBottom() {
        return getY() + this.mHeight;
    }

    public Object getCompanionWidget() {
        return this.mCompanionWidget;
    }

    public int getContainerItemSkip() {
        return this.mContainerItemSkip;
    }

    public String getDebugName() {
        return this.mDebugName;
    }

    public DimensionBehaviour getDimensionBehaviour(int i3) {
        if (i3 == 0) {
            return getHorizontalDimensionBehaviour();
        }
        if (i3 == 1) {
            return getVerticalDimensionBehaviour();
        }
        return null;
    }

    public float getDimensionRatio() {
        return this.mDimensionRatio;
    }

    public int getDimensionRatioSide() {
        return this.mDimensionRatioSide;
    }

    public boolean getHasBaseline() {
        return this.hasBaseline;
    }

    public int getHeight() {
        if (this.mVisibility == 8) {
            return 0;
        }
        return this.mHeight;
    }

    public float getHorizontalBiasPercent() {
        return this.mHorizontalBiasPercent;
    }

    public ConstraintWidget getHorizontalChainControlWidget() {
        ConstraintAnchor target;
        ConstraintWidget owner;
        ConstraintAnchor target2;
        if (!isInHorizontalChain()) {
            return null;
        }
        ConstraintWidget constraintWidget = this;
        ConstraintWidget constraintWidget2 = null;
        while (constraintWidget2 == null && constraintWidget != null) {
            ConstraintAnchor anchor = constraintWidget.getAnchor(ConstraintAnchor.Type.LEFT);
            if (anchor == null) {
                target = null;
            } else {
                target = anchor.getTarget();
            }
            if (target == null) {
                owner = null;
            } else {
                owner = target.getOwner();
            }
            if (owner == getParent()) {
                return constraintWidget;
            }
            if (owner == null) {
                target2 = null;
            } else {
                target2 = owner.getAnchor(ConstraintAnchor.Type.RIGHT).getTarget();
            }
            if (target2 != null && target2.getOwner() != constraintWidget) {
                constraintWidget2 = constraintWidget;
            } else {
                constraintWidget = owner;
            }
        }
        return constraintWidget2;
    }

    public int getHorizontalChainStyle() {
        return this.mHorizontalChainStyle;
    }

    public DimensionBehaviour getHorizontalDimensionBehaviour() {
        return this.mListDimensionBehaviors[0];
    }

    public int getHorizontalMargin() {
        ConstraintAnchor constraintAnchor = this.mLeft;
        int i3 = 0;
        if (constraintAnchor != null) {
            i3 = 0 + constraintAnchor.mMargin;
        }
        ConstraintAnchor constraintAnchor2 = this.mRight;
        if (constraintAnchor2 != null) {
            return i3 + constraintAnchor2.mMargin;
        }
        return i3;
    }

    public int getLastHorizontalMeasureSpec() {
        return this.mLastHorizontalMeasureSpec;
    }

    public int getLastVerticalMeasureSpec() {
        return this.mLastVerticalMeasureSpec;
    }

    public int getLeft() {
        return getX();
    }

    public int getLength(int i3) {
        if (i3 == 0) {
            return getWidth();
        }
        if (i3 == 1) {
            return getHeight();
        }
        return 0;
    }

    public int getMaxHeight() {
        return this.mMaxDimension[1];
    }

    public int getMaxWidth() {
        return this.mMaxDimension[0];
    }

    public int getMinHeight() {
        return this.mMinHeight;
    }

    public int getMinWidth() {
        return this.mMinWidth;
    }

    public ConstraintWidget getNextChainMember(int i3) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        if (i3 == 0) {
            ConstraintAnchor constraintAnchor3 = this.mRight;
            ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
            if (constraintAnchor4 != null && constraintAnchor4.mTarget == constraintAnchor3) {
                return constraintAnchor4.mOwner;
            }
            return null;
        }
        if (i3 == 1 && (constraintAnchor2 = (constraintAnchor = this.mBottom).mTarget) != null && constraintAnchor2.mTarget == constraintAnchor) {
            return constraintAnchor2.mOwner;
        }
        return null;
    }

    public int getOptimizerWrapHeight() {
        int i3;
        int i16 = this.mHeight;
        if (this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT) {
            if (this.mMatchConstraintDefaultHeight == 1) {
                i3 = Math.max(this.mMatchConstraintMinHeight, i16);
            } else {
                i3 = this.mMatchConstraintMinHeight;
                if (i3 > 0) {
                    this.mHeight = i3;
                } else {
                    i3 = 0;
                }
            }
            int i17 = this.mMatchConstraintMaxHeight;
            if (i17 > 0 && i17 < i3) {
                return i17;
            }
            return i3;
        }
        return i16;
    }

    public int getOptimizerWrapWidth() {
        int i3;
        int i16 = this.mWidth;
        if (this.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT) {
            if (this.mMatchConstraintDefaultWidth == 1) {
                i3 = Math.max(this.mMatchConstraintMinWidth, i16);
            } else {
                i3 = this.mMatchConstraintMinWidth;
                if (i3 > 0) {
                    this.mWidth = i3;
                } else {
                    i3 = 0;
                }
            }
            int i17 = this.mMatchConstraintMaxWidth;
            if (i17 > 0 && i17 < i3) {
                return i17;
            }
            return i3;
        }
        return i16;
    }

    public ConstraintWidget getParent() {
        return this.mParent;
    }

    public ConstraintWidget getPreviousChainMember(int i3) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        if (i3 == 0) {
            ConstraintAnchor constraintAnchor3 = this.mLeft;
            ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
            if (constraintAnchor4 != null && constraintAnchor4.mTarget == constraintAnchor3) {
                return constraintAnchor4.mOwner;
            }
            return null;
        }
        if (i3 == 1 && (constraintAnchor2 = (constraintAnchor = this.mTop).mTarget) != null && constraintAnchor2.mTarget == constraintAnchor) {
            return constraintAnchor2.mOwner;
        }
        return null;
    }

    int getRelativePositioning(int i3) {
        if (i3 == 0) {
            return this.mRelX;
        }
        if (i3 == 1) {
            return this.mRelY;
        }
        return 0;
    }

    public int getRight() {
        return getX() + this.mWidth;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getRootX() {
        return this.mX + this.mOffsetX;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getRootY() {
        return this.mY + this.mOffsetY;
    }

    public WidgetRun getRun(int i3) {
        if (i3 == 0) {
            return this.horizontalRun;
        }
        if (i3 == 1) {
            return this.verticalRun;
        }
        return null;
    }

    public int getTop() {
        return getY();
    }

    public String getType() {
        return this.mType;
    }

    public float getVerticalBiasPercent() {
        return this.mVerticalBiasPercent;
    }

    public ConstraintWidget getVerticalChainControlWidget() {
        ConstraintAnchor target;
        ConstraintWidget owner;
        ConstraintAnchor target2;
        if (!isInVerticalChain()) {
            return null;
        }
        ConstraintWidget constraintWidget = this;
        ConstraintWidget constraintWidget2 = null;
        while (constraintWidget2 == null && constraintWidget != null) {
            ConstraintAnchor anchor = constraintWidget.getAnchor(ConstraintAnchor.Type.TOP);
            if (anchor == null) {
                target = null;
            } else {
                target = anchor.getTarget();
            }
            if (target == null) {
                owner = null;
            } else {
                owner = target.getOwner();
            }
            if (owner == getParent()) {
                return constraintWidget;
            }
            if (owner == null) {
                target2 = null;
            } else {
                target2 = owner.getAnchor(ConstraintAnchor.Type.BOTTOM).getTarget();
            }
            if (target2 != null && target2.getOwner() != constraintWidget) {
                constraintWidget2 = constraintWidget;
            } else {
                constraintWidget = owner;
            }
        }
        return constraintWidget2;
    }

    public int getVerticalChainStyle() {
        return this.mVerticalChainStyle;
    }

    public DimensionBehaviour getVerticalDimensionBehaviour() {
        return this.mListDimensionBehaviors[1];
    }

    public int getVerticalMargin() {
        int i3 = 0;
        if (this.mLeft != null) {
            i3 = 0 + this.mTop.mMargin;
        }
        if (this.mRight != null) {
            return i3 + this.mBottom.mMargin;
        }
        return i3;
    }

    public int getVisibility() {
        return this.mVisibility;
    }

    public int getWidth() {
        if (this.mVisibility == 8) {
            return 0;
        }
        return this.mWidth;
    }

    public int getX() {
        ConstraintWidget constraintWidget = this.mParent;
        if (constraintWidget != null && (constraintWidget instanceof ConstraintWidgetContainer)) {
            return ((ConstraintWidgetContainer) constraintWidget).mPaddingLeft + this.mX;
        }
        return this.mX;
    }

    public int getY() {
        ConstraintWidget constraintWidget = this.mParent;
        if (constraintWidget != null && (constraintWidget instanceof ConstraintWidgetContainer)) {
            return ((ConstraintWidgetContainer) constraintWidget).mPaddingTop + this.mY;
        }
        return this.mY;
    }

    public boolean hasBaseline() {
        return this.hasBaseline;
    }

    public boolean hasDanglingDimension(int i3) {
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        if (i3 == 0) {
            if (this.mLeft.mTarget != null) {
                i19 = 1;
            } else {
                i19 = 0;
            }
            if (this.mRight.mTarget != null) {
                i26 = 1;
            } else {
                i26 = 0;
            }
            if (i19 + i26 < 2) {
                return true;
            }
            return false;
        }
        if (this.mTop.mTarget != null) {
            i16 = 1;
        } else {
            i16 = 0;
        }
        if (this.mBottom.mTarget != null) {
            i17 = 1;
        } else {
            i17 = 0;
        }
        int i27 = i16 + i17;
        if (this.mBaseline.mTarget != null) {
            i18 = 1;
        } else {
            i18 = 0;
        }
        if (i27 + i18 < 2) {
            return true;
        }
        return false;
    }

    public boolean hasDependencies() {
        int size = this.mAnchors.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (this.mAnchors.get(i3).hasDependents()) {
                return true;
            }
        }
        return false;
    }

    public void immediateConnect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i3, int i16) {
        getAnchor(type).connect(constraintWidget.getAnchor(type2), i3, i16, true);
    }

    public boolean isHeightWrapContent() {
        return this.mIsHeightWrapContent;
    }

    public boolean isInHorizontalChain() {
        ConstraintAnchor constraintAnchor = this.mLeft;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
        if (constraintAnchor2 == null || constraintAnchor2.mTarget != constraintAnchor) {
            ConstraintAnchor constraintAnchor3 = this.mRight;
            ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
            if (constraintAnchor4 != null && constraintAnchor4.mTarget == constraintAnchor3) {
                return true;
            }
            return false;
        }
        return true;
    }

    public boolean isInPlaceholder() {
        return this.inPlaceholder;
    }

    public boolean isInVerticalChain() {
        ConstraintAnchor constraintAnchor = this.mTop;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
        if (constraintAnchor2 == null || constraintAnchor2.mTarget != constraintAnchor) {
            ConstraintAnchor constraintAnchor3 = this.mBottom;
            ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
            if (constraintAnchor4 != null && constraintAnchor4.mTarget == constraintAnchor3) {
                return true;
            }
            return false;
        }
        return true;
    }

    public boolean isInVirtualLayout() {
        return this.mInVirtuaLayout;
    }

    public boolean isMeasureRequested() {
        if (this.mMeasureRequested && this.mVisibility != 8) {
            return true;
        }
        return false;
    }

    public boolean isResolvedHorizontally() {
        if (!this.resolvedHorizontal && (!this.mLeft.hasFinalValue() || !this.mRight.hasFinalValue())) {
            return false;
        }
        return true;
    }

    public boolean isResolvedVertically() {
        if (!this.resolvedVertical && (!this.mTop.hasFinalValue() || !this.mBottom.hasFinalValue())) {
            return false;
        }
        return true;
    }

    public boolean isRoot() {
        if (this.mParent == null) {
            return true;
        }
        return false;
    }

    public boolean isSpreadHeight() {
        if (this.mMatchConstraintDefaultHeight == 0 && this.mDimensionRatio == 0.0f && this.mMatchConstraintMinHeight == 0 && this.mMatchConstraintMaxHeight == 0 && this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT) {
            return true;
        }
        return false;
    }

    public boolean isSpreadWidth() {
        if (this.mMatchConstraintDefaultWidth != 0 || this.mDimensionRatio != 0.0f || this.mMatchConstraintMinWidth != 0 || this.mMatchConstraintMaxWidth != 0 || this.mListDimensionBehaviors[0] != DimensionBehaviour.MATCH_CONSTRAINT) {
            return false;
        }
        return true;
    }

    public boolean isWidthWrapContent() {
        return this.mIsWidthWrapContent;
    }

    public boolean oppositeDimensionDependsOn(int i3) {
        char c16;
        if (i3 == 0) {
            c16 = 1;
        } else {
            c16 = 0;
        }
        DimensionBehaviour[] dimensionBehaviourArr = this.mListDimensionBehaviors;
        DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[i3];
        DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[c16];
        DimensionBehaviour dimensionBehaviour3 = DimensionBehaviour.MATCH_CONSTRAINT;
        if (dimensionBehaviour == dimensionBehaviour3 && dimensionBehaviour2 == dimensionBehaviour3) {
            return true;
        }
        return false;
    }

    public boolean oppositeDimensionsTied() {
        DimensionBehaviour[] dimensionBehaviourArr = this.mListDimensionBehaviors;
        DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
        DimensionBehaviour dimensionBehaviour2 = DimensionBehaviour.MATCH_CONSTRAINT;
        if (dimensionBehaviour != dimensionBehaviour2 || dimensionBehaviourArr[1] != dimensionBehaviour2) {
            return false;
        }
        return true;
    }

    public void reset() {
        this.mLeft.reset();
        this.mTop.reset();
        this.mRight.reset();
        this.mBottom.reset();
        this.mBaseline.reset();
        this.mCenterX.reset();
        this.mCenterY.reset();
        this.mCenter.reset();
        this.mParent = null;
        this.mCircleConstraintAngle = 0.0f;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        float f16 = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = f16;
        this.mVerticalBiasPercent = f16;
        DimensionBehaviour[] dimensionBehaviourArr = this.mListDimensionBehaviors;
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        dimensionBehaviourArr[0] = dimensionBehaviour;
        dimensionBehaviourArr[1] = dimensionBehaviour;
        this.mCompanionWidget = null;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mType = null;
        this.mHorizontalWrapVisited = false;
        this.mVerticalWrapVisited = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mHorizontalChainFixedPosition = false;
        this.mVerticalChainFixedPosition = false;
        float[] fArr = this.mWeight;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        int[] iArr = this.mMaxDimension;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mMatchConstraintMaxWidth = Integer.MAX_VALUE;
        this.mMatchConstraintMaxHeight = Integer.MAX_VALUE;
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMinHeight = 0;
        this.mResolvedHasRatio = false;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mGroupsToSolver = false;
        boolean[] zArr = this.isTerminalWidget;
        zArr[0] = true;
        zArr[1] = true;
        this.mInVirtuaLayout = false;
        boolean[] zArr2 = this.mIsInBarrier;
        zArr2[0] = false;
        zArr2[1] = false;
        this.mMeasureRequested = true;
    }

    public void resetAllConstraints() {
        resetAnchors();
        setVerticalBiasPercent(DEFAULT_BIAS);
        setHorizontalBiasPercent(DEFAULT_BIAS);
    }

    public void resetAnchor(ConstraintAnchor constraintAnchor) {
        if (getParent() != null && (getParent() instanceof ConstraintWidgetContainer) && ((ConstraintWidgetContainer) getParent()).handlesInternalConstraints()) {
            return;
        }
        ConstraintAnchor anchor = getAnchor(ConstraintAnchor.Type.LEFT);
        ConstraintAnchor anchor2 = getAnchor(ConstraintAnchor.Type.RIGHT);
        ConstraintAnchor anchor3 = getAnchor(ConstraintAnchor.Type.TOP);
        ConstraintAnchor anchor4 = getAnchor(ConstraintAnchor.Type.BOTTOM);
        ConstraintAnchor anchor5 = getAnchor(ConstraintAnchor.Type.CENTER);
        ConstraintAnchor anchor6 = getAnchor(ConstraintAnchor.Type.CENTER_X);
        ConstraintAnchor anchor7 = getAnchor(ConstraintAnchor.Type.CENTER_Y);
        if (constraintAnchor == anchor5) {
            if (anchor.isConnected() && anchor2.isConnected() && anchor.getTarget() == anchor2.getTarget()) {
                anchor.reset();
                anchor2.reset();
            }
            if (anchor3.isConnected() && anchor4.isConnected() && anchor3.getTarget() == anchor4.getTarget()) {
                anchor3.reset();
                anchor4.reset();
            }
            this.mHorizontalBiasPercent = 0.5f;
            this.mVerticalBiasPercent = 0.5f;
        } else if (constraintAnchor == anchor6) {
            if (anchor.isConnected() && anchor2.isConnected() && anchor.getTarget().getOwner() == anchor2.getTarget().getOwner()) {
                anchor.reset();
                anchor2.reset();
            }
            this.mHorizontalBiasPercent = 0.5f;
        } else if (constraintAnchor == anchor7) {
            if (anchor3.isConnected() && anchor4.isConnected() && anchor3.getTarget().getOwner() == anchor4.getTarget().getOwner()) {
                anchor3.reset();
                anchor4.reset();
            }
            this.mVerticalBiasPercent = 0.5f;
        } else if (constraintAnchor != anchor && constraintAnchor != anchor2) {
            if ((constraintAnchor == anchor3 || constraintAnchor == anchor4) && anchor3.isConnected() && anchor3.getTarget() == anchor4.getTarget()) {
                anchor5.reset();
            }
        } else if (anchor.isConnected() && anchor.getTarget() == anchor2.getTarget()) {
            anchor5.reset();
        }
        constraintAnchor.reset();
    }

    public void resetAnchors() {
        ConstraintWidget parent = getParent();
        if (parent != null && (parent instanceof ConstraintWidgetContainer) && ((ConstraintWidgetContainer) getParent()).handlesInternalConstraints()) {
            return;
        }
        int size = this.mAnchors.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.mAnchors.get(i3).reset();
        }
    }

    public void resetFinalResolution() {
        this.resolvedHorizontal = false;
        this.resolvedVertical = false;
        int size = this.mAnchors.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.mAnchors.get(i3).resetFinalResolution();
        }
    }

    public void resetSolverVariables(Cache cache) {
        this.mLeft.resetSolverVariable(cache);
        this.mTop.resetSolverVariable(cache);
        this.mRight.resetSolverVariable(cache);
        this.mBottom.resetSolverVariable(cache);
        this.mBaseline.resetSolverVariable(cache);
        this.mCenter.resetSolverVariable(cache);
        this.mCenterX.resetSolverVariable(cache);
        this.mCenterY.resetSolverVariable(cache);
    }

    public void setBaselineDistance(int i3) {
        boolean z16;
        this.mBaselineDistance = i3;
        if (i3 > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.hasBaseline = z16;
    }

    public void setCompanionWidget(Object obj) {
        this.mCompanionWidget = obj;
    }

    public void setContainerItemSkip(int i3) {
        if (i3 >= 0) {
            this.mContainerItemSkip = i3;
        } else {
            this.mContainerItemSkip = 0;
        }
    }

    public void setDebugName(String str) {
        this.mDebugName = str;
    }

    public void setDebugSolverName(LinearSystem linearSystem, String str) {
        this.mDebugName = str;
        SolverVariable createObjectVariable = linearSystem.createObjectVariable(this.mLeft);
        SolverVariable createObjectVariable2 = linearSystem.createObjectVariable(this.mTop);
        SolverVariable createObjectVariable3 = linearSystem.createObjectVariable(this.mRight);
        SolverVariable createObjectVariable4 = linearSystem.createObjectVariable(this.mBottom);
        createObjectVariable.setName(str + ".left");
        createObjectVariable2.setName(str + ".top");
        createObjectVariable3.setName(str + ".right");
        createObjectVariable4.setName(str + ".bottom");
        linearSystem.createObjectVariable(this.mBaseline).setName(str + ".baseline");
    }

    public void setDimension(int i3, int i16) {
        this.mWidth = i3;
        int i17 = this.mMinWidth;
        if (i3 < i17) {
            this.mWidth = i17;
        }
        this.mHeight = i16;
        int i18 = this.mMinHeight;
        if (i16 < i18) {
            this.mHeight = i18;
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0088 -> B:31:0x0089). Please report as a decompilation issue!!! */
    public void setDimensionRatio(String str) {
        float f16;
        int i3 = 0;
        if (str != null && str.length() != 0) {
            int length = str.length();
            int indexOf = str.indexOf(44);
            int i16 = 0;
            int i17 = -1;
            if (indexOf > 0 && indexOf < length - 1) {
                String substring = str.substring(0, indexOf);
                if (!substring.equalsIgnoreCase("W")) {
                    i16 = substring.equalsIgnoreCase("H") ? 1 : -1;
                }
                i17 = i16;
                i16 = indexOf + 1;
            }
            int indexOf2 = str.indexOf(58);
            if (indexOf2 >= 0 && indexOf2 < length - 1) {
                String substring2 = str.substring(i16, indexOf2);
                String substring3 = str.substring(indexOf2 + 1);
                if (substring2.length() > 0 && substring3.length() > 0) {
                    float parseFloat = Float.parseFloat(substring2);
                    float parseFloat2 = Float.parseFloat(substring3);
                    if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                        if (i17 == 1) {
                            f16 = Math.abs(parseFloat2 / parseFloat);
                        } else {
                            f16 = Math.abs(parseFloat / parseFloat2);
                        }
                    }
                }
                f16 = i3;
            } else {
                String substring4 = str.substring(i16);
                if (substring4.length() > 0) {
                    f16 = Float.parseFloat(substring4);
                }
                f16 = i3;
            }
            i3 = (f16 > i3 ? 1 : (f16 == i3 ? 0 : -1));
            if (i3 > 0) {
                this.mDimensionRatio = f16;
                this.mDimensionRatioSide = i17;
                return;
            }
            return;
        }
        this.mDimensionRatio = 0.0f;
    }

    public void setFinalBaseline(int i3) {
        if (!this.hasBaseline) {
            return;
        }
        int i16 = i3 - this.mBaselineDistance;
        int i17 = this.mHeight + i16;
        this.mY = i16;
        this.mTop.setFinalValue(i16);
        this.mBottom.setFinalValue(i17);
        this.mBaseline.setFinalValue(i3);
        this.resolvedVertical = true;
    }

    public void setFinalFrame(int i3, int i16, int i17, int i18, int i19, int i26) {
        setFrame(i3, i16, i17, i18);
        setBaselineDistance(i19);
        if (i26 == 0) {
            this.resolvedHorizontal = true;
            this.resolvedVertical = false;
        } else if (i26 == 1) {
            this.resolvedHorizontal = false;
            this.resolvedVertical = true;
        } else if (i26 == 2) {
            this.resolvedHorizontal = true;
            this.resolvedVertical = true;
        } else {
            this.resolvedHorizontal = false;
            this.resolvedVertical = false;
        }
    }

    public void setFinalHorizontal(int i3, int i16) {
        this.mLeft.setFinalValue(i3);
        this.mRight.setFinalValue(i16);
        this.mX = i3;
        this.mWidth = i16 - i3;
        this.resolvedHorizontal = true;
    }

    public void setFinalLeft(int i3) {
        this.mLeft.setFinalValue(i3);
        this.mX = i3;
    }

    public void setFinalTop(int i3) {
        this.mTop.setFinalValue(i3);
        this.mY = i3;
    }

    public void setFinalVertical(int i3, int i16) {
        this.mTop.setFinalValue(i3);
        this.mBottom.setFinalValue(i16);
        this.mY = i3;
        this.mHeight = i16 - i3;
        if (this.hasBaseline) {
            this.mBaseline.setFinalValue(i3 + this.mBaselineDistance);
        }
        this.resolvedVertical = true;
    }

    public void setFrame(int i3, int i16, int i17, int i18) {
        int i19;
        int i26;
        int i27 = i17 - i3;
        int i28 = i18 - i16;
        this.mX = i3;
        this.mY = i16;
        if (this.mVisibility == 8) {
            this.mWidth = 0;
            this.mHeight = 0;
            return;
        }
        DimensionBehaviour[] dimensionBehaviourArr = this.mListDimensionBehaviors;
        DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
        DimensionBehaviour dimensionBehaviour2 = DimensionBehaviour.FIXED;
        if (dimensionBehaviour == dimensionBehaviour2 && i27 < (i26 = this.mWidth)) {
            i27 = i26;
        }
        if (dimensionBehaviourArr[1] == dimensionBehaviour2 && i28 < (i19 = this.mHeight)) {
            i28 = i19;
        }
        this.mWidth = i27;
        this.mHeight = i28;
        int i29 = this.mMinHeight;
        if (i28 < i29) {
            this.mHeight = i29;
        }
        int i36 = this.mMinWidth;
        if (i27 < i36) {
            this.mWidth = i36;
        }
    }

    public void setGoneMargin(ConstraintAnchor.Type type, int i3) {
        int i16 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[type.ordinal()];
        if (i16 != 1) {
            if (i16 != 2) {
                if (i16 != 3) {
                    if (i16 == 4) {
                        this.mBottom.mGoneMargin = i3;
                        return;
                    }
                    return;
                }
                this.mRight.mGoneMargin = i3;
                return;
            }
            this.mTop.mGoneMargin = i3;
            return;
        }
        this.mLeft.mGoneMargin = i3;
    }

    public void setHasBaseline(boolean z16) {
        this.hasBaseline = z16;
    }

    public void setHeight(int i3) {
        this.mHeight = i3;
        int i16 = this.mMinHeight;
        if (i3 < i16) {
            this.mHeight = i16;
        }
    }

    public void setHeightWrapContent(boolean z16) {
        this.mIsHeightWrapContent = z16;
    }

    public void setHorizontalBiasPercent(float f16) {
        this.mHorizontalBiasPercent = f16;
    }

    public void setHorizontalChainStyle(int i3) {
        this.mHorizontalChainStyle = i3;
    }

    public void setHorizontalDimension(int i3, int i16) {
        this.mX = i3;
        int i17 = i16 - i3;
        this.mWidth = i17;
        int i18 = this.mMinWidth;
        if (i17 < i18) {
            this.mWidth = i18;
        }
    }

    public void setHorizontalDimensionBehaviour(DimensionBehaviour dimensionBehaviour) {
        this.mListDimensionBehaviors[0] = dimensionBehaviour;
    }

    public void setHorizontalMatchStyle(int i3, int i16, int i17, float f16) {
        this.mMatchConstraintDefaultWidth = i3;
        this.mMatchConstraintMinWidth = i16;
        if (i17 == Integer.MAX_VALUE) {
            i17 = 0;
        }
        this.mMatchConstraintMaxWidth = i17;
        this.mMatchConstraintPercentWidth = f16;
        if (f16 > 0.0f && f16 < 1.0f && i3 == 0) {
            this.mMatchConstraintDefaultWidth = 2;
        }
    }

    public void setHorizontalWeight(float f16) {
        this.mWeight[0] = f16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setInBarrier(int i3, boolean z16) {
        this.mIsInBarrier[i3] = z16;
    }

    public void setInPlaceholder(boolean z16) {
        this.inPlaceholder = z16;
    }

    public void setInVirtualLayout(boolean z16) {
        this.mInVirtuaLayout = z16;
    }

    public void setLastMeasureSpec(int i3, int i16) {
        this.mLastHorizontalMeasureSpec = i3;
        this.mLastVerticalMeasureSpec = i16;
        setMeasureRequested(false);
    }

    public void setLength(int i3, int i16) {
        if (i16 == 0) {
            setWidth(i3);
        } else if (i16 == 1) {
            setHeight(i3);
        }
    }

    public void setMaxHeight(int i3) {
        this.mMaxDimension[1] = i3;
    }

    public void setMaxWidth(int i3) {
        this.mMaxDimension[0] = i3;
    }

    public void setMeasureRequested(boolean z16) {
        this.mMeasureRequested = z16;
    }

    public void setMinHeight(int i3) {
        if (i3 < 0) {
            this.mMinHeight = 0;
        } else {
            this.mMinHeight = i3;
        }
    }

    public void setMinWidth(int i3) {
        if (i3 < 0) {
            this.mMinWidth = 0;
        } else {
            this.mMinWidth = i3;
        }
    }

    public void setOffset(int i3, int i16) {
        this.mOffsetX = i3;
        this.mOffsetY = i16;
    }

    public void setOrigin(int i3, int i16) {
        this.mX = i3;
        this.mY = i16;
    }

    public void setParent(ConstraintWidget constraintWidget) {
        this.mParent = constraintWidget;
    }

    void setRelativePositioning(int i3, int i16) {
        if (i16 == 0) {
            this.mRelX = i3;
        } else if (i16 == 1) {
            this.mRelY = i3;
        }
    }

    public void setType(String str) {
        this.mType = str;
    }

    public void setVerticalBiasPercent(float f16) {
        this.mVerticalBiasPercent = f16;
    }

    public void setVerticalChainStyle(int i3) {
        this.mVerticalChainStyle = i3;
    }

    public void setVerticalDimension(int i3, int i16) {
        this.mY = i3;
        int i17 = i16 - i3;
        this.mHeight = i17;
        int i18 = this.mMinHeight;
        if (i17 < i18) {
            this.mHeight = i18;
        }
    }

    public void setVerticalDimensionBehaviour(DimensionBehaviour dimensionBehaviour) {
        this.mListDimensionBehaviors[1] = dimensionBehaviour;
    }

    public void setVerticalMatchStyle(int i3, int i16, int i17, float f16) {
        this.mMatchConstraintDefaultHeight = i3;
        this.mMatchConstraintMinHeight = i16;
        if (i17 == Integer.MAX_VALUE) {
            i17 = 0;
        }
        this.mMatchConstraintMaxHeight = i17;
        this.mMatchConstraintPercentHeight = f16;
        if (f16 > 0.0f && f16 < 1.0f && i3 == 0) {
            this.mMatchConstraintDefaultHeight = 2;
        }
    }

    public void setVerticalWeight(float f16) {
        this.mWeight[1] = f16;
    }

    public void setVisibility(int i3) {
        this.mVisibility = i3;
    }

    public void setWidth(int i3) {
        this.mWidth = i3;
        int i16 = this.mMinWidth;
        if (i3 < i16) {
            this.mWidth = i16;
        }
    }

    public void setWidthWrapContent(boolean z16) {
        this.mIsWidthWrapContent = z16;
    }

    public void setX(int i3) {
        this.mX = i3;
    }

    public void setY(int i3) {
        this.mY = i3;
    }

    public void setupDimensionRatio(boolean z16, boolean z17, boolean z18, boolean z19) {
        if (this.mResolvedDimensionRatioSide == -1) {
            if (z18 && !z19) {
                this.mResolvedDimensionRatioSide = 0;
            } else if (!z18 && z19) {
                this.mResolvedDimensionRatioSide = 1;
                if (this.mDimensionRatioSide == -1) {
                    this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                }
            }
        }
        if (this.mResolvedDimensionRatioSide == 0 && (!this.mTop.isConnected() || !this.mBottom.isConnected())) {
            this.mResolvedDimensionRatioSide = 1;
        } else if (this.mResolvedDimensionRatioSide == 1 && (!this.mLeft.isConnected() || !this.mRight.isConnected())) {
            this.mResolvedDimensionRatioSide = 0;
        }
        if (this.mResolvedDimensionRatioSide == -1 && (!this.mTop.isConnected() || !this.mBottom.isConnected() || !this.mLeft.isConnected() || !this.mRight.isConnected())) {
            if (this.mTop.isConnected() && this.mBottom.isConnected()) {
                this.mResolvedDimensionRatioSide = 0;
            } else if (this.mLeft.isConnected() && this.mRight.isConnected()) {
                this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                this.mResolvedDimensionRatioSide = 1;
            }
        }
        if (this.mResolvedDimensionRatioSide == -1) {
            int i3 = this.mMatchConstraintMinWidth;
            if (i3 > 0 && this.mMatchConstraintMinHeight == 0) {
                this.mResolvedDimensionRatioSide = 0;
            } else if (i3 == 0 && this.mMatchConstraintMinHeight > 0) {
                this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                this.mResolvedDimensionRatioSide = 1;
            }
        }
    }

    public String toString() {
        String str;
        StringBuilder sb5 = new StringBuilder();
        String str2 = "";
        if (this.mType == null) {
            str = "";
        } else {
            str = "type: " + this.mType + " ";
        }
        sb5.append(str);
        if (this.mDebugName != null) {
            str2 = "id: " + this.mDebugName + " ";
        }
        sb5.append(str2);
        sb5.append("(");
        sb5.append(this.mX);
        sb5.append(", ");
        sb5.append(this.mY);
        sb5.append(") - (");
        sb5.append(this.mWidth);
        sb5.append(" x ");
        sb5.append(this.mHeight);
        sb5.append(")");
        return sb5.toString();
    }

    public void updateFromRuns(boolean z16, boolean z17) {
        int i3;
        int i16;
        boolean isResolved = z16 & this.horizontalRun.isResolved();
        boolean isResolved2 = z17 & this.verticalRun.isResolved();
        HorizontalWidgetRun horizontalWidgetRun = this.horizontalRun;
        int i17 = horizontalWidgetRun.start.value;
        VerticalWidgetRun verticalWidgetRun = this.verticalRun;
        int i18 = verticalWidgetRun.start.value;
        int i19 = horizontalWidgetRun.end.value;
        int i26 = verticalWidgetRun.end.value;
        int i27 = i26 - i18;
        if (i19 - i17 < 0 || i27 < 0 || i17 == Integer.MIN_VALUE || i17 == Integer.MAX_VALUE || i18 == Integer.MIN_VALUE || i18 == Integer.MAX_VALUE || i19 == Integer.MIN_VALUE || i19 == Integer.MAX_VALUE || i26 == Integer.MIN_VALUE || i26 == Integer.MAX_VALUE) {
            i19 = 0;
            i17 = 0;
            i26 = 0;
            i18 = 0;
        }
        int i28 = i19 - i17;
        int i29 = i26 - i18;
        if (isResolved) {
            this.mX = i17;
        }
        if (isResolved2) {
            this.mY = i18;
        }
        if (this.mVisibility == 8) {
            this.mWidth = 0;
            this.mHeight = 0;
            return;
        }
        if (isResolved) {
            if (this.mListDimensionBehaviors[0] == DimensionBehaviour.FIXED && i28 < (i16 = this.mWidth)) {
                i28 = i16;
            }
            this.mWidth = i28;
            int i36 = this.mMinWidth;
            if (i28 < i36) {
                this.mWidth = i36;
            }
        }
        if (isResolved2) {
            if (this.mListDimensionBehaviors[1] == DimensionBehaviour.FIXED && i29 < (i3 = this.mHeight)) {
                i29 = i3;
            }
            this.mHeight = i29;
            int i37 = this.mMinHeight;
            if (i29 < i37) {
                this.mHeight = i37;
            }
        }
    }

    public void updateFromSolver(LinearSystem linearSystem, boolean z16) {
        VerticalWidgetRun verticalWidgetRun;
        HorizontalWidgetRun horizontalWidgetRun;
        int objectVariableValue = linearSystem.getObjectVariableValue(this.mLeft);
        int objectVariableValue2 = linearSystem.getObjectVariableValue(this.mTop);
        int objectVariableValue3 = linearSystem.getObjectVariableValue(this.mRight);
        int objectVariableValue4 = linearSystem.getObjectVariableValue(this.mBottom);
        if (z16 && (horizontalWidgetRun = this.horizontalRun) != null) {
            DependencyNode dependencyNode = horizontalWidgetRun.start;
            if (dependencyNode.resolved) {
                DependencyNode dependencyNode2 = horizontalWidgetRun.end;
                if (dependencyNode2.resolved) {
                    objectVariableValue = dependencyNode.value;
                    objectVariableValue3 = dependencyNode2.value;
                }
            }
        }
        if (z16 && (verticalWidgetRun = this.verticalRun) != null) {
            DependencyNode dependencyNode3 = verticalWidgetRun.start;
            if (dependencyNode3.resolved) {
                DependencyNode dependencyNode4 = verticalWidgetRun.end;
                if (dependencyNode4.resolved) {
                    objectVariableValue2 = dependencyNode3.value;
                    objectVariableValue4 = dependencyNode4.value;
                }
            }
        }
        int i3 = objectVariableValue4 - objectVariableValue2;
        if (objectVariableValue3 - objectVariableValue < 0 || i3 < 0 || objectVariableValue == Integer.MIN_VALUE || objectVariableValue == Integer.MAX_VALUE || objectVariableValue2 == Integer.MIN_VALUE || objectVariableValue2 == Integer.MAX_VALUE || objectVariableValue3 == Integer.MIN_VALUE || objectVariableValue3 == Integer.MAX_VALUE || objectVariableValue4 == Integer.MIN_VALUE || objectVariableValue4 == Integer.MAX_VALUE) {
            objectVariableValue = 0;
            objectVariableValue4 = 0;
            objectVariableValue2 = 0;
            objectVariableValue3 = 0;
        }
        setFrame(objectVariableValue, objectVariableValue2, objectVariableValue3, objectVariableValue4);
    }

    public void connect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2) {
        connect(type, constraintWidget, type2, 0);
    }

    public void connect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i3) {
        ConstraintAnchor.Type type3;
        ConstraintAnchor.Type type4;
        boolean z16;
        ConstraintAnchor.Type type5 = ConstraintAnchor.Type.CENTER;
        if (type == type5) {
            if (type2 == type5) {
                ConstraintAnchor.Type type6 = ConstraintAnchor.Type.LEFT;
                ConstraintAnchor anchor = getAnchor(type6);
                ConstraintAnchor.Type type7 = ConstraintAnchor.Type.RIGHT;
                ConstraintAnchor anchor2 = getAnchor(type7);
                ConstraintAnchor.Type type8 = ConstraintAnchor.Type.TOP;
                ConstraintAnchor anchor3 = getAnchor(type8);
                ConstraintAnchor.Type type9 = ConstraintAnchor.Type.BOTTOM;
                ConstraintAnchor anchor4 = getAnchor(type9);
                boolean z17 = true;
                if ((anchor == null || !anchor.isConnected()) && (anchor2 == null || !anchor2.isConnected())) {
                    connect(type6, constraintWidget, type6, 0);
                    connect(type7, constraintWidget, type7, 0);
                    z16 = true;
                } else {
                    z16 = false;
                }
                if ((anchor3 == null || !anchor3.isConnected()) && (anchor4 == null || !anchor4.isConnected())) {
                    connect(type8, constraintWidget, type8, 0);
                    connect(type9, constraintWidget, type9, 0);
                } else {
                    z17 = false;
                }
                if (z16 && z17) {
                    getAnchor(type5).connect(constraintWidget.getAnchor(type5), 0);
                    return;
                }
                if (z16) {
                    ConstraintAnchor.Type type10 = ConstraintAnchor.Type.CENTER_X;
                    getAnchor(type10).connect(constraintWidget.getAnchor(type10), 0);
                    return;
                } else {
                    if (z17) {
                        ConstraintAnchor.Type type11 = ConstraintAnchor.Type.CENTER_Y;
                        getAnchor(type11).connect(constraintWidget.getAnchor(type11), 0);
                        return;
                    }
                    return;
                }
            }
            ConstraintAnchor.Type type12 = ConstraintAnchor.Type.LEFT;
            if (type2 != type12 && type2 != ConstraintAnchor.Type.RIGHT) {
                ConstraintAnchor.Type type13 = ConstraintAnchor.Type.TOP;
                if (type2 == type13 || type2 == ConstraintAnchor.Type.BOTTOM) {
                    connect(type13, constraintWidget, type2, 0);
                    connect(ConstraintAnchor.Type.BOTTOM, constraintWidget, type2, 0);
                    getAnchor(type5).connect(constraintWidget.getAnchor(type2), 0);
                    return;
                }
                return;
            }
            connect(type12, constraintWidget, type2, 0);
            connect(ConstraintAnchor.Type.RIGHT, constraintWidget, type2, 0);
            getAnchor(type5).connect(constraintWidget.getAnchor(type2), 0);
            return;
        }
        ConstraintAnchor.Type type14 = ConstraintAnchor.Type.CENTER_X;
        if (type == type14 && (type2 == (type4 = ConstraintAnchor.Type.LEFT) || type2 == ConstraintAnchor.Type.RIGHT)) {
            ConstraintAnchor anchor5 = getAnchor(type4);
            ConstraintAnchor anchor6 = constraintWidget.getAnchor(type2);
            ConstraintAnchor anchor7 = getAnchor(ConstraintAnchor.Type.RIGHT);
            anchor5.connect(anchor6, 0);
            anchor7.connect(anchor6, 0);
            getAnchor(type14).connect(anchor6, 0);
            return;
        }
        ConstraintAnchor.Type type15 = ConstraintAnchor.Type.CENTER_Y;
        if (type == type15 && (type2 == (type3 = ConstraintAnchor.Type.TOP) || type2 == ConstraintAnchor.Type.BOTTOM)) {
            ConstraintAnchor anchor8 = constraintWidget.getAnchor(type2);
            getAnchor(type3).connect(anchor8, 0);
            getAnchor(ConstraintAnchor.Type.BOTTOM).connect(anchor8, 0);
            getAnchor(type15).connect(anchor8, 0);
            return;
        }
        if (type == type14 && type2 == type14) {
            ConstraintAnchor.Type type16 = ConstraintAnchor.Type.LEFT;
            getAnchor(type16).connect(constraintWidget.getAnchor(type16), 0);
            ConstraintAnchor.Type type17 = ConstraintAnchor.Type.RIGHT;
            getAnchor(type17).connect(constraintWidget.getAnchor(type17), 0);
            getAnchor(type14).connect(constraintWidget.getAnchor(type2), 0);
            return;
        }
        if (type == type15 && type2 == type15) {
            ConstraintAnchor.Type type18 = ConstraintAnchor.Type.TOP;
            getAnchor(type18).connect(constraintWidget.getAnchor(type18), 0);
            ConstraintAnchor.Type type19 = ConstraintAnchor.Type.BOTTOM;
            getAnchor(type19).connect(constraintWidget.getAnchor(type19), 0);
            getAnchor(type15).connect(constraintWidget.getAnchor(type2), 0);
            return;
        }
        ConstraintAnchor anchor9 = getAnchor(type);
        ConstraintAnchor anchor10 = constraintWidget.getAnchor(type2);
        if (anchor9.isValidConnection(anchor10)) {
            ConstraintAnchor.Type type20 = ConstraintAnchor.Type.BASELINE;
            if (type == type20) {
                ConstraintAnchor anchor11 = getAnchor(ConstraintAnchor.Type.TOP);
                ConstraintAnchor anchor12 = getAnchor(ConstraintAnchor.Type.BOTTOM);
                if (anchor11 != null) {
                    anchor11.reset();
                }
                if (anchor12 != null) {
                    anchor12.reset();
                }
                i3 = 0;
            } else if (type != ConstraintAnchor.Type.TOP && type != ConstraintAnchor.Type.BOTTOM) {
                if (type == ConstraintAnchor.Type.LEFT || type == ConstraintAnchor.Type.RIGHT) {
                    ConstraintAnchor anchor13 = getAnchor(type5);
                    if (anchor13.getTarget() != anchor10) {
                        anchor13.reset();
                    }
                    ConstraintAnchor opposite = getAnchor(type).getOpposite();
                    ConstraintAnchor anchor14 = getAnchor(type14);
                    if (anchor14.isConnected()) {
                        opposite.reset();
                        anchor14.reset();
                    }
                }
            } else {
                ConstraintAnchor anchor15 = getAnchor(type20);
                if (anchor15 != null) {
                    anchor15.reset();
                }
                ConstraintAnchor anchor16 = getAnchor(type5);
                if (anchor16.getTarget() != anchor10) {
                    anchor16.reset();
                }
                ConstraintAnchor opposite2 = getAnchor(type).getOpposite();
                ConstraintAnchor anchor17 = getAnchor(type15);
                if (anchor17.isConnected()) {
                    opposite2.reset();
                    anchor17.reset();
                }
            }
            anchor9.connect(anchor10, i3);
        }
    }

    public void setFrame(int i3, int i16, int i17) {
        if (i17 == 0) {
            setHorizontalDimension(i3, i16);
        } else if (i17 == 1) {
            setVerticalDimension(i3, i16);
        }
    }

    public void setDimensionRatio(float f16, int i3) {
        this.mDimensionRatio = f16;
        this.mDimensionRatioSide = i3;
    }

    public ConstraintWidget(String str) {
        this.measured = false;
        this.run = new WidgetRun[2];
        this.horizontalRun = null;
        this.verticalRun = null;
        this.isTerminalWidget = new boolean[]{true, true};
        this.mResolvedHasRatio = false;
        this.mMeasureRequested = true;
        this.OPTIMIZE_WRAP = false;
        this.OPTIMIZE_WRAP_ON_RESOLVED = true;
        this.resolvedHorizontal = false;
        this.resolvedVertical = false;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mResolvedMatchConstraintDefault = new int[2];
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMaxWidth = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintMinHeight = 0;
        this.mMatchConstraintMaxHeight = 0;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mMaxDimension = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.mCircleConstraintAngle = 0.0f;
        this.hasBaseline = false;
        this.mInVirtuaLayout = false;
        this.mLastHorizontalMeasureSpec = 0;
        this.mLastVerticalMeasureSpec = 0;
        this.mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.mCenterX = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.mCenterY = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        ConstraintAnchor constraintAnchor = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mCenter = constraintAnchor;
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, constraintAnchor};
        this.mAnchors = new ArrayList<>();
        this.mIsInBarrier = new boolean[2];
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        this.mListDimensionBehaviors = new DimensionBehaviour[]{dimensionBehaviour, dimensionBehaviour};
        this.mParent = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mRelX = 0;
        this.mRelY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        float f16 = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = f16;
        this.mVerticalBiasPercent = f16;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mDebugName = null;
        this.mType = null;
        this.mGroupsToSolver = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mWeight = new float[]{-1.0f, -1.0f};
        this.mListNextMatchConstraintsWidget = new ConstraintWidget[]{null, null};
        this.mNextChainWidget = new ConstraintWidget[]{null, null};
        this.mHorizontalNextWidget = null;
        this.mVerticalNextWidget = null;
        this.horizontalGroup = -1;
        this.verticalGroup = -1;
        addAnchors();
        setDebugName(str);
    }

    public ConstraintWidget(int i3, int i16, int i17, int i18) {
        this.measured = false;
        this.run = new WidgetRun[2];
        this.horizontalRun = null;
        this.verticalRun = null;
        this.isTerminalWidget = new boolean[]{true, true};
        this.mResolvedHasRatio = false;
        this.mMeasureRequested = true;
        this.OPTIMIZE_WRAP = false;
        this.OPTIMIZE_WRAP_ON_RESOLVED = true;
        this.resolvedHorizontal = false;
        this.resolvedVertical = false;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mResolvedMatchConstraintDefault = new int[2];
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMaxWidth = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintMinHeight = 0;
        this.mMatchConstraintMaxHeight = 0;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mMaxDimension = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.mCircleConstraintAngle = 0.0f;
        this.hasBaseline = false;
        this.mInVirtuaLayout = false;
        this.mLastHorizontalMeasureSpec = 0;
        this.mLastVerticalMeasureSpec = 0;
        this.mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.mCenterX = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.mCenterY = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        ConstraintAnchor constraintAnchor = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mCenter = constraintAnchor;
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, constraintAnchor};
        this.mAnchors = new ArrayList<>();
        this.mIsInBarrier = new boolean[2];
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        this.mListDimensionBehaviors = new DimensionBehaviour[]{dimensionBehaviour, dimensionBehaviour};
        this.mParent = null;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mRelX = 0;
        this.mRelY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        float f16 = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = f16;
        this.mVerticalBiasPercent = f16;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mDebugName = null;
        this.mType = null;
        this.mGroupsToSolver = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mWeight = new float[]{-1.0f, -1.0f};
        this.mListNextMatchConstraintsWidget = new ConstraintWidget[]{null, null};
        this.mNextChainWidget = new ConstraintWidget[]{null, null};
        this.mHorizontalNextWidget = null;
        this.mVerticalNextWidget = null;
        this.horizontalGroup = -1;
        this.verticalGroup = -1;
        this.mX = i3;
        this.mY = i16;
        this.mWidth = i17;
        this.mHeight = i18;
        addAnchors();
    }

    public ConstraintWidget(String str, int i3, int i16, int i17, int i18) {
        this(i3, i16, i17, i18);
        setDebugName(str);
    }

    public ConstraintWidget(int i3, int i16) {
        this(0, 0, i3, i16);
    }

    public ConstraintWidget(String str, int i3, int i16) {
        this(i3, i16);
        setDebugName(str);
    }
}
