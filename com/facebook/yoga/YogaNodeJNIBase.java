package com.facebook.yoga;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.yoga.YogaNode;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: P */
@DoNotStrip
/* loaded from: classes2.dex */
public abstract class YogaNodeJNIBase extends YogaNode implements Cloneable {
    private static final byte BORDER = 4;
    private static final byte DOES_LEGACY_STRETCH_BEHAVIOUR = 8;
    private static final byte HAS_NEW_LAYOUT = 16;
    private static final byte LAYOUT_BORDER_START_INDEX = 14;
    private static final byte LAYOUT_DIRECTION_INDEX = 5;
    private static final byte LAYOUT_EDGE_SET_FLAG_INDEX = 0;
    private static final byte LAYOUT_HEIGHT_INDEX = 2;
    private static final byte LAYOUT_LEFT_INDEX = 3;
    private static final byte LAYOUT_MARGIN_START_INDEX = 6;
    private static final byte LAYOUT_PADDING_START_INDEX = 10;
    private static final byte LAYOUT_TOP_INDEX = 4;
    private static final byte LAYOUT_WIDTH_INDEX = 1;
    private static final byte MARGIN = 1;
    private static final byte PADDING = 2;

    @DoNotStrip
    @Nullable
    private float[] arr;

    @Nullable
    private YogaBaselineFunction mBaselineFunction;

    @Nullable
    private List<YogaNodeJNIBase> mChildren;

    @Nullable
    private Object mData;
    private boolean mHasNewLayout;

    @DoNotStrip
    private int mLayoutDirection;

    @Nullable
    private YogaMeasureFunction mMeasureFunction;
    protected long mNativePointer;

    @Nullable
    private YogaNodeJNIBase mOwner;

    /* compiled from: P */
    /* renamed from: com.facebook.yoga.YogaNodeJNIBase$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$yoga$YogaEdge;

        static {
            int[] iArr = new int[YogaEdge.values().length];
            $SwitchMap$com$facebook$yoga$YogaEdge = iArr;
            try {
                iArr[YogaEdge.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$facebook$yoga$YogaEdge[YogaEdge.TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$facebook$yoga$YogaEdge[YogaEdge.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$facebook$yoga$YogaEdge[YogaEdge.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$facebook$yoga$YogaEdge[YogaEdge.START.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$facebook$yoga$YogaEdge[YogaEdge.END.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    YogaNodeJNIBase(long j3) {
        this.arr = null;
        this.mLayoutDirection = 0;
        this.mHasNewLayout = true;
        if (j3 != 0) {
            this.mNativePointer = j3;
            return;
        }
        throw new IllegalStateException("Failed to allocate native memory");
    }

    private void clearChildren() {
        this.mChildren = null;
        YogaNative.jni_YGNodeClearChildrenJNI(this.mNativePointer);
    }

    private void freeze(YogaNode yogaNode) {
        Object data = getData();
        if (data instanceof YogaNode.Inputs) {
            ((YogaNode.Inputs) data).freeze(this, yogaNode);
        }
    }

    @DoNotStrip
    private final long replaceChild(YogaNodeJNIBase yogaNodeJNIBase, int i3) {
        List<YogaNodeJNIBase> list = this.mChildren;
        if (list != null) {
            list.remove(i3);
            this.mChildren.add(i3, yogaNodeJNIBase);
            yogaNodeJNIBase.mOwner = this;
            return yogaNodeJNIBase.mNativePointer;
        }
        throw new IllegalStateException("Cannot replace child. YogaNode does not have children");
    }

    private static YogaValue valueFromLong(long j3) {
        return new YogaValue(Float.intBitsToFloat((int) j3), (int) (j3 >> 32));
    }

    @Override // com.facebook.yoga.YogaNode
    public void addChildAt(YogaNode yogaNode, int i3) {
        if (!(yogaNode instanceof YogaNodeJNIBase)) {
            return;
        }
        YogaNodeJNIBase yogaNodeJNIBase = (YogaNodeJNIBase) yogaNode;
        if (yogaNodeJNIBase.mOwner == null) {
            if (this.mChildren == null) {
                this.mChildren = new ArrayList(4);
            }
            this.mChildren.add(i3, yogaNodeJNIBase);
            yogaNodeJNIBase.mOwner = this;
            YogaNative.jni_YGNodeInsertChildJNI(this.mNativePointer, yogaNodeJNIBase.mNativePointer, i3);
            return;
        }
        throw new IllegalStateException("Child already has a parent, it must be removed first.");
    }

    @DoNotStrip
    public final float baseline(float f16, float f17) {
        return this.mBaselineFunction.baseline(this, f16, f17);
    }

    @Override // com.facebook.yoga.YogaNode
    public void calculateLayout(float f16, float f17) {
        freeze(null);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this);
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            YogaNodeJNIBase yogaNodeJNIBase = (YogaNodeJNIBase) arrayList.get(i3);
            List<YogaNodeJNIBase> list = yogaNodeJNIBase.mChildren;
            if (list != null) {
                for (YogaNodeJNIBase yogaNodeJNIBase2 : list) {
                    yogaNodeJNIBase2.freeze(yogaNodeJNIBase);
                    arrayList.add(yogaNodeJNIBase2);
                }
            }
        }
        YogaNodeJNIBase[] yogaNodeJNIBaseArr = (YogaNodeJNIBase[]) arrayList.toArray(new YogaNodeJNIBase[arrayList.size()]);
        long[] jArr = new long[yogaNodeJNIBaseArr.length];
        for (int i16 = 0; i16 < yogaNodeJNIBaseArr.length; i16++) {
            jArr[i16] = yogaNodeJNIBaseArr[i16].mNativePointer;
        }
        YogaNative.jni_YGNodeCalculateLayoutJNI(this.mNativePointer, f16, f17, jArr, yogaNodeJNIBaseArr);
    }

    @Override // com.facebook.yoga.YogaNode
    public void copyStyle(YogaNode yogaNode) {
        if (!(yogaNode instanceof YogaNodeJNIBase)) {
            return;
        }
        YogaNative.jni_YGNodeCopyStyleJNI(this.mNativePointer, ((YogaNodeJNIBase) yogaNode).mNativePointer);
    }

    @Override // com.facebook.yoga.YogaNode
    public void dirty() {
        YogaNative.jni_YGNodeMarkDirtyJNI(this.mNativePointer);
    }

    public void dirtyAllDescendants() {
        YogaNative.jni_YGNodeMarkDirtyAndPropogateToDescendantsJNI(this.mNativePointer);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public YogaAlign getAlignContent() {
        return YogaAlign.fromInt(YogaNative.jni_YGNodeStyleGetAlignContentJNI(this.mNativePointer));
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public YogaAlign getAlignItems() {
        return YogaAlign.fromInt(YogaNative.jni_YGNodeStyleGetAlignItemsJNI(this.mNativePointer));
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public YogaAlign getAlignSelf() {
        return YogaAlign.fromInt(YogaNative.jni_YGNodeStyleGetAlignSelfJNI(this.mNativePointer));
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public float getAspectRatio() {
        return YogaNative.jni_YGNodeStyleGetAspectRatioJNI(this.mNativePointer);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public float getBorder(YogaEdge yogaEdge) {
        return YogaNative.jni_YGNodeStyleGetBorderJNI(this.mNativePointer, yogaEdge.intValue());
    }

    @Override // com.facebook.yoga.YogaNode
    public int getChildCount() {
        List<YogaNodeJNIBase> list = this.mChildren;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // com.facebook.yoga.YogaNode
    @Nullable
    public Object getData() {
        return this.mData;
    }

    @Override // com.facebook.yoga.YogaNode
    public YogaDisplay getDisplay() {
        return YogaDisplay.fromInt(YogaNative.jni_YGNodeStyleGetDisplayJNI(this.mNativePointer));
    }

    public boolean getDoesLegacyStretchFlagAffectsLayout() {
        float[] fArr = this.arr;
        if (fArr == null || (((int) fArr[0]) & 8) != 8) {
            return false;
        }
        return true;
    }

    @Override // com.facebook.yoga.YogaNode
    public float getFlex() {
        return YogaNative.jni_YGNodeStyleGetFlexJNI(this.mNativePointer);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public YogaValue getFlexBasis() {
        return valueFromLong(YogaNative.jni_YGNodeStyleGetFlexBasisJNI(this.mNativePointer));
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public YogaFlexDirection getFlexDirection() {
        return YogaFlexDirection.fromInt(YogaNative.jni_YGNodeStyleGetFlexDirectionJNI(this.mNativePointer));
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public float getFlexGrow() {
        return YogaNative.jni_YGNodeStyleGetFlexGrowJNI(this.mNativePointer);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public float getFlexShrink() {
        return YogaNative.jni_YGNodeStyleGetFlexShrinkJNI(this.mNativePointer);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public YogaValue getHeight() {
        return valueFromLong(YogaNative.jni_YGNodeStyleGetHeightJNI(this.mNativePointer));
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public YogaJustify getJustifyContent() {
        return YogaJustify.fromInt(YogaNative.jni_YGNodeStyleGetJustifyContentJNI(this.mNativePointer));
    }

    @Override // com.facebook.yoga.YogaNode
    public float getLayoutBorder(YogaEdge yogaEdge) {
        int i3;
        float[] fArr = this.arr;
        if (fArr != null) {
            int i16 = 0;
            float f16 = fArr[0];
            if ((((int) f16) & 4) == 4) {
                if ((((int) f16) & 1) == 1) {
                    i3 = 0;
                } else {
                    i3 = 4;
                }
                int i17 = 14 - i3;
                if ((((int) f16) & 2) != 2) {
                    i16 = 4;
                }
                int i18 = i17 - i16;
                switch (AnonymousClass1.$SwitchMap$com$facebook$yoga$YogaEdge[yogaEdge.ordinal()]) {
                    case 1:
                        return this.arr[i18];
                    case 2:
                        return this.arr[i18 + 1];
                    case 3:
                        return this.arr[i18 + 2];
                    case 4:
                        return this.arr[i18 + 3];
                    case 5:
                        if (getLayoutDirection() == YogaDirection.RTL) {
                            return this.arr[i18 + 2];
                        }
                        return this.arr[i18];
                    case 6:
                        if (getLayoutDirection() == YogaDirection.RTL) {
                            return this.arr[i18];
                        }
                        return this.arr[i18 + 2];
                    default:
                        throw new IllegalArgumentException("Cannot get layout border of multi-edge shorthands");
                }
            }
            return 0.0f;
        }
        return 0.0f;
    }

    @Override // com.facebook.yoga.YogaNode
    public YogaDirection getLayoutDirection() {
        int i3;
        float[] fArr = this.arr;
        if (fArr != null) {
            i3 = (int) fArr[5];
        } else {
            i3 = this.mLayoutDirection;
        }
        return YogaDirection.fromInt(i3);
    }

    @Override // com.facebook.yoga.YogaNode
    public float getLayoutHeight() {
        float[] fArr = this.arr;
        if (fArr != null) {
            return fArr[2];
        }
        return 0.0f;
    }

    @Override // com.facebook.yoga.YogaNode
    public float getLayoutMargin(YogaEdge yogaEdge) {
        float[] fArr = this.arr;
        if (fArr != null && (((int) fArr[0]) & 1) == 1) {
            switch (AnonymousClass1.$SwitchMap$com$facebook$yoga$YogaEdge[yogaEdge.ordinal()]) {
                case 1:
                    return this.arr[6];
                case 2:
                    return this.arr[7];
                case 3:
                    return this.arr[8];
                case 4:
                    return this.arr[9];
                case 5:
                    if (getLayoutDirection() == YogaDirection.RTL) {
                        return this.arr[8];
                    }
                    return this.arr[6];
                case 6:
                    if (getLayoutDirection() == YogaDirection.RTL) {
                        return this.arr[6];
                    }
                    return this.arr[8];
                default:
                    throw new IllegalArgumentException("Cannot get layout margins of multi-edge shorthands");
            }
        }
        return 0.0f;
    }

    @Override // com.facebook.yoga.YogaNode
    public float getLayoutPadding(YogaEdge yogaEdge) {
        float[] fArr = this.arr;
        if (fArr != null) {
            int i3 = 0;
            float f16 = fArr[0];
            if ((((int) f16) & 2) == 2) {
                if ((((int) f16) & 1) != 1) {
                    i3 = 4;
                }
                int i16 = 10 - i3;
                switch (AnonymousClass1.$SwitchMap$com$facebook$yoga$YogaEdge[yogaEdge.ordinal()]) {
                    case 1:
                        return this.arr[i16];
                    case 2:
                        return this.arr[i16 + 1];
                    case 3:
                        return this.arr[i16 + 2];
                    case 4:
                        return this.arr[i16 + 3];
                    case 5:
                        if (getLayoutDirection() == YogaDirection.RTL) {
                            return this.arr[i16 + 2];
                        }
                        return this.arr[i16];
                    case 6:
                        if (getLayoutDirection() == YogaDirection.RTL) {
                            return this.arr[i16];
                        }
                        return this.arr[i16 + 2];
                    default:
                        throw new IllegalArgumentException("Cannot get layout paddings of multi-edge shorthands");
                }
            }
            return 0.0f;
        }
        return 0.0f;
    }

    @Override // com.facebook.yoga.YogaNode
    public float getLayoutWidth() {
        float[] fArr = this.arr;
        if (fArr != null) {
            return fArr[1];
        }
        return 0.0f;
    }

    @Override // com.facebook.yoga.YogaNode
    public float getLayoutX() {
        float[] fArr = this.arr;
        if (fArr != null) {
            return fArr[3];
        }
        return 0.0f;
    }

    @Override // com.facebook.yoga.YogaNode
    public float getLayoutY() {
        float[] fArr = this.arr;
        if (fArr != null) {
            return fArr[4];
        }
        return 0.0f;
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public YogaValue getMargin(YogaEdge yogaEdge) {
        return valueFromLong(YogaNative.jni_YGNodeStyleGetMarginJNI(this.mNativePointer, yogaEdge.intValue()));
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public YogaValue getMaxHeight() {
        return valueFromLong(YogaNative.jni_YGNodeStyleGetMaxHeightJNI(this.mNativePointer));
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public YogaValue getMaxWidth() {
        return valueFromLong(YogaNative.jni_YGNodeStyleGetMaxWidthJNI(this.mNativePointer));
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public YogaValue getMinHeight() {
        return valueFromLong(YogaNative.jni_YGNodeStyleGetMinHeightJNI(this.mNativePointer));
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public YogaValue getMinWidth() {
        return valueFromLong(YogaNative.jni_YGNodeStyleGetMinWidthJNI(this.mNativePointer));
    }

    @Override // com.facebook.yoga.YogaNode
    public YogaOverflow getOverflow() {
        return YogaOverflow.fromInt(YogaNative.jni_YGNodeStyleGetOverflowJNI(this.mNativePointer));
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public YogaValue getPadding(YogaEdge yogaEdge) {
        return valueFromLong(YogaNative.jni_YGNodeStyleGetPaddingJNI(this.mNativePointer, yogaEdge.intValue()));
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public YogaValue getPosition(YogaEdge yogaEdge) {
        return valueFromLong(YogaNative.jni_YGNodeStyleGetPositionJNI(this.mNativePointer, yogaEdge.intValue()));
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public YogaPositionType getPositionType() {
        return YogaPositionType.fromInt(YogaNative.jni_YGNodeStyleGetPositionTypeJNI(this.mNativePointer));
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public YogaDirection getStyleDirection() {
        return YogaDirection.fromInt(YogaNative.jni_YGNodeStyleGetDirectionJNI(this.mNativePointer));
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public YogaValue getWidth() {
        return valueFromLong(YogaNative.jni_YGNodeStyleGetWidthJNI(this.mNativePointer));
    }

    @Override // com.facebook.yoga.YogaNode
    public YogaWrap getWrap() {
        return YogaWrap.fromInt(YogaNative.jni_YGNodeStyleGetFlexWrapJNI(this.mNativePointer));
    }

    @Override // com.facebook.yoga.YogaNode
    public boolean hasNewLayout() {
        float[] fArr = this.arr;
        if (fArr != null) {
            if ((((int) fArr[0]) & 16) != 16) {
                return false;
            }
            return true;
        }
        return this.mHasNewLayout;
    }

    @Override // com.facebook.yoga.YogaNode
    public int indexOf(YogaNode yogaNode) {
        List<YogaNodeJNIBase> list = this.mChildren;
        if (list == null) {
            return -1;
        }
        return list.indexOf(yogaNode);
    }

    @Override // com.facebook.yoga.YogaNode
    public boolean isBaselineDefined() {
        if (this.mBaselineFunction != null) {
            return true;
        }
        return false;
    }

    @Override // com.facebook.yoga.YogaNode
    public boolean isDirty() {
        return YogaNative.jni_YGNodeIsDirtyJNI(this.mNativePointer);
    }

    @Override // com.facebook.yoga.YogaNode
    public boolean isMeasureDefined() {
        if (this.mMeasureFunction != null) {
            return true;
        }
        return false;
    }

    @Override // com.facebook.yoga.YogaNode
    public boolean isReferenceBaseline() {
        return YogaNative.jni_YGNodeIsReferenceBaselineJNI(this.mNativePointer);
    }

    @Override // com.facebook.yoga.YogaNode
    public void markLayoutSeen() {
        float[] fArr = this.arr;
        if (fArr != null) {
            fArr[0] = ((int) fArr[0]) & (-17);
        }
        this.mHasNewLayout = false;
    }

    @DoNotStrip
    public final long measure(float f16, int i3, float f17, int i16) {
        if (isMeasureDefined()) {
            return this.mMeasureFunction.measure(this, f16, YogaMeasureMode.fromInt(i3), f17, YogaMeasureMode.fromInt(i16));
        }
        throw new RuntimeException("Measure function isn't defined!");
    }

    @Override // com.facebook.yoga.YogaNode
    public void print() {
        YogaNative.jni_YGNodePrintJNI(this.mNativePointer);
    }

    @Override // com.facebook.yoga.YogaNode
    public void reset() {
        this.mMeasureFunction = null;
        this.mBaselineFunction = null;
        this.mData = null;
        this.arr = null;
        this.mHasNewLayout = true;
        this.mLayoutDirection = 0;
        YogaNative.jni_YGNodeResetJNI(this.mNativePointer);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setAlignContent(YogaAlign yogaAlign) {
        YogaNative.jni_YGNodeStyleSetAlignContentJNI(this.mNativePointer, yogaAlign.intValue());
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setAlignItems(YogaAlign yogaAlign) {
        YogaNative.jni_YGNodeStyleSetAlignItemsJNI(this.mNativePointer, yogaAlign.intValue());
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setAlignSelf(YogaAlign yogaAlign) {
        YogaNative.jni_YGNodeStyleSetAlignSelfJNI(this.mNativePointer, yogaAlign.intValue());
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setAspectRatio(float f16) {
        YogaNative.jni_YGNodeStyleSetAspectRatioJNI(this.mNativePointer, f16);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setBaselineFunction(YogaBaselineFunction yogaBaselineFunction) {
        boolean z16;
        this.mBaselineFunction = yogaBaselineFunction;
        long j3 = this.mNativePointer;
        if (yogaBaselineFunction != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        YogaNative.jni_YGNodeSetHasBaselineFuncJNI(j3, z16);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setBorder(YogaEdge yogaEdge, float f16) {
        YogaNative.jni_YGNodeStyleSetBorderJNI(this.mNativePointer, yogaEdge.intValue(), f16);
    }

    @Override // com.facebook.yoga.YogaNode
    public void setData(Object obj) {
        this.mData = obj;
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setDirection(YogaDirection yogaDirection) {
        YogaNative.jni_YGNodeStyleSetDirectionJNI(this.mNativePointer, yogaDirection.intValue());
    }

    @Override // com.facebook.yoga.YogaNode
    public void setDisplay(YogaDisplay yogaDisplay) {
        YogaNative.jni_YGNodeStyleSetDisplayJNI(this.mNativePointer, yogaDisplay.intValue());
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setFlex(float f16) {
        YogaNative.jni_YGNodeStyleSetFlexJNI(this.mNativePointer, f16);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setFlexBasis(float f16) {
        YogaNative.jni_YGNodeStyleSetFlexBasisJNI(this.mNativePointer, f16);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setFlexBasisAuto() {
        YogaNative.jni_YGNodeStyleSetFlexBasisAutoJNI(this.mNativePointer);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setFlexBasisPercent(float f16) {
        YogaNative.jni_YGNodeStyleSetFlexBasisPercentJNI(this.mNativePointer, f16);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setFlexDirection(YogaFlexDirection yogaFlexDirection) {
        YogaNative.jni_YGNodeStyleSetFlexDirectionJNI(this.mNativePointer, yogaFlexDirection.intValue());
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setFlexGrow(float f16) {
        YogaNative.jni_YGNodeStyleSetFlexGrowJNI(this.mNativePointer, f16);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setFlexShrink(float f16) {
        YogaNative.jni_YGNodeStyleSetFlexShrinkJNI(this.mNativePointer, f16);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setHeight(float f16) {
        YogaNative.jni_YGNodeStyleSetHeightJNI(this.mNativePointer, f16);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setHeightAuto() {
        YogaNative.jni_YGNodeStyleSetHeightAutoJNI(this.mNativePointer);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setHeightPercent(float f16) {
        YogaNative.jni_YGNodeStyleSetHeightPercentJNI(this.mNativePointer, f16);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setIsReferenceBaseline(boolean z16) {
        YogaNative.jni_YGNodeSetIsReferenceBaselineJNI(this.mNativePointer, z16);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setJustifyContent(YogaJustify yogaJustify) {
        YogaNative.jni_YGNodeStyleSetJustifyContentJNI(this.mNativePointer, yogaJustify.intValue());
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setMargin(YogaEdge yogaEdge, float f16) {
        YogaNative.jni_YGNodeStyleSetMarginJNI(this.mNativePointer, yogaEdge.intValue(), f16);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setMarginAuto(YogaEdge yogaEdge) {
        YogaNative.jni_YGNodeStyleSetMarginAutoJNI(this.mNativePointer, yogaEdge.intValue());
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setMarginPercent(YogaEdge yogaEdge, float f16) {
        YogaNative.jni_YGNodeStyleSetMarginPercentJNI(this.mNativePointer, yogaEdge.intValue(), f16);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setMaxHeight(float f16) {
        YogaNative.jni_YGNodeStyleSetMaxHeightJNI(this.mNativePointer, f16);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setMaxHeightPercent(float f16) {
        YogaNative.jni_YGNodeStyleSetMaxHeightPercentJNI(this.mNativePointer, f16);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setMaxWidth(float f16) {
        YogaNative.jni_YGNodeStyleSetMaxWidthJNI(this.mNativePointer, f16);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setMaxWidthPercent(float f16) {
        YogaNative.jni_YGNodeStyleSetMaxWidthPercentJNI(this.mNativePointer, f16);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setMeasureFunction(YogaMeasureFunction yogaMeasureFunction) {
        boolean z16;
        this.mMeasureFunction = yogaMeasureFunction;
        long j3 = this.mNativePointer;
        if (yogaMeasureFunction != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        YogaNative.jni_YGNodeSetHasMeasureFuncJNI(j3, z16);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setMinHeight(float f16) {
        YogaNative.jni_YGNodeStyleSetMinHeightJNI(this.mNativePointer, f16);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setMinHeightPercent(float f16) {
        YogaNative.jni_YGNodeStyleSetMinHeightPercentJNI(this.mNativePointer, f16);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setMinWidth(float f16) {
        YogaNative.jni_YGNodeStyleSetMinWidthJNI(this.mNativePointer, f16);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setMinWidthPercent(float f16) {
        YogaNative.jni_YGNodeStyleSetMinWidthPercentJNI(this.mNativePointer, f16);
    }

    @Override // com.facebook.yoga.YogaNode
    public void setOverflow(YogaOverflow yogaOverflow) {
        YogaNative.jni_YGNodeStyleSetOverflowJNI(this.mNativePointer, yogaOverflow.intValue());
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setPadding(YogaEdge yogaEdge, float f16) {
        YogaNative.jni_YGNodeStyleSetPaddingJNI(this.mNativePointer, yogaEdge.intValue(), f16);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setPaddingPercent(YogaEdge yogaEdge, float f16) {
        YogaNative.jni_YGNodeStyleSetPaddingPercentJNI(this.mNativePointer, yogaEdge.intValue(), f16);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setPosition(YogaEdge yogaEdge, float f16) {
        YogaNative.jni_YGNodeStyleSetPositionJNI(this.mNativePointer, yogaEdge.intValue(), f16);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setPositionPercent(YogaEdge yogaEdge, float f16) {
        YogaNative.jni_YGNodeStyleSetPositionPercentJNI(this.mNativePointer, yogaEdge.intValue(), f16);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setPositionType(YogaPositionType yogaPositionType) {
        YogaNative.jni_YGNodeStyleSetPositionTypeJNI(this.mNativePointer, yogaPositionType.intValue());
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setWidth(float f16) {
        YogaNative.jni_YGNodeStyleSetWidthJNI(this.mNativePointer, f16);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setWidthAuto() {
        YogaNative.jni_YGNodeStyleSetWidthAutoJNI(this.mNativePointer);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setWidthPercent(float f16) {
        YogaNative.jni_YGNodeStyleSetWidthPercentJNI(this.mNativePointer, f16);
    }

    @Override // com.facebook.yoga.YogaNode, com.facebook.yoga.YogaProps
    public void setWrap(YogaWrap yogaWrap) {
        YogaNative.jni_YGNodeStyleSetFlexWrapJNI(this.mNativePointer, yogaWrap.intValue());
    }

    public void swapChildAt(YogaNode yogaNode, int i3) {
        if (!(yogaNode instanceof YogaNodeJNIBase)) {
            return;
        }
        YogaNodeJNIBase yogaNodeJNIBase = (YogaNodeJNIBase) yogaNode;
        this.mChildren.remove(i3);
        this.mChildren.add(i3, yogaNodeJNIBase);
        yogaNodeJNIBase.mOwner = this;
        YogaNative.jni_YGNodeSwapChildJNI(this.mNativePointer, yogaNodeJNIBase.mNativePointer, i3);
    }

    @Override // com.facebook.yoga.YogaNode
    public YogaNodeJNIBase cloneWithChildren() {
        try {
            YogaNodeJNIBase yogaNodeJNIBase = (YogaNodeJNIBase) super.clone();
            if (yogaNodeJNIBase.mChildren != null) {
                yogaNodeJNIBase.mChildren = new ArrayList(yogaNodeJNIBase.mChildren);
            }
            long jni_YGNodeCloneJNI = YogaNative.jni_YGNodeCloneJNI(this.mNativePointer);
            yogaNodeJNIBase.mOwner = null;
            yogaNodeJNIBase.mNativePointer = jni_YGNodeCloneJNI;
            for (int i3 = 0; i3 < yogaNodeJNIBase.getChildCount(); i3++) {
                yogaNodeJNIBase.swapChildAt(yogaNodeJNIBase.getChildAt(i3).cloneWithChildren(), i3);
            }
            return yogaNodeJNIBase;
        } catch (CloneNotSupportedException e16) {
            throw new RuntimeException(e16);
        }
    }

    @Override // com.facebook.yoga.YogaNode
    public YogaNodeJNIBase cloneWithoutChildren() {
        try {
            YogaNodeJNIBase yogaNodeJNIBase = (YogaNodeJNIBase) super.clone();
            long jni_YGNodeCloneJNI = YogaNative.jni_YGNodeCloneJNI(this.mNativePointer);
            yogaNodeJNIBase.mOwner = null;
            yogaNodeJNIBase.mNativePointer = jni_YGNodeCloneJNI;
            yogaNodeJNIBase.clearChildren();
            return yogaNodeJNIBase;
        } catch (CloneNotSupportedException e16) {
            throw new RuntimeException(e16);
        }
    }

    @Override // com.facebook.yoga.YogaNode
    public YogaNodeJNIBase getChildAt(int i3) {
        List<YogaNodeJNIBase> list = this.mChildren;
        if (list != null) {
            return list.get(i3);
        }
        throw new IllegalStateException("YogaNode does not have children");
    }

    @Override // com.facebook.yoga.YogaNode
    @Nullable
    public YogaNodeJNIBase getOwner() {
        return this.mOwner;
    }

    @Override // com.facebook.yoga.YogaNode
    @Nullable
    @Deprecated
    public YogaNodeJNIBase getParent() {
        return getOwner();
    }

    @Override // com.facebook.yoga.YogaNode
    public YogaNodeJNIBase removeChildAt(int i3) {
        List<YogaNodeJNIBase> list = this.mChildren;
        if (list != null) {
            YogaNodeJNIBase remove = list.remove(i3);
            remove.mOwner = null;
            YogaNative.jni_YGNodeRemoveChildJNI(this.mNativePointer, remove.mNativePointer);
            return remove;
        }
        throw new IllegalStateException("Trying to remove a child of a YogaNode that does not have children");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public YogaNodeJNIBase() {
        this(YogaNative.jni_YGNodeNewJNI());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public YogaNodeJNIBase(YogaConfig yogaConfig) {
        this(YogaNative.jni_YGNodeNewWithConfigJNI(((YogaConfigJNIBase) yogaConfig).mNativePointer));
    }
}
