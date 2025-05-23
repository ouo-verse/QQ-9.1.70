package com.facebook.yoga.android;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.yoga.YogaAlign;
import com.facebook.yoga.YogaDirection;
import com.facebook.yoga.YogaDisplay;
import com.facebook.yoga.YogaEdge;
import com.facebook.yoga.YogaFlexDirection;
import com.facebook.yoga.YogaJustify;
import com.facebook.yoga.YogaMeasureFunction;
import com.facebook.yoga.YogaMeasureMode;
import com.facebook.yoga.YogaMeasureOutput;
import com.facebook.yoga.YogaNode;
import com.facebook.yoga.YogaNodeFactory;
import com.facebook.yoga.YogaOverflow;
import com.facebook.yoga.YogaPositionType;
import com.facebook.yoga.YogaWrap;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
public class YogaLayout extends ViewGroup {
    private final YogaNode mYogaNode;
    private final Map<View, YogaNode> mYogaNodes;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class ViewMeasureFunction implements YogaMeasureFunction {
        private int viewMeasureSpecFromYogaMeasureMode(YogaMeasureMode yogaMeasureMode) {
            if (yogaMeasureMode == YogaMeasureMode.AT_MOST) {
                return Integer.MIN_VALUE;
            }
            if (yogaMeasureMode == YogaMeasureMode.EXACTLY) {
                return 1073741824;
            }
            return 0;
        }

        @Override // com.facebook.yoga.YogaMeasureFunction
        public long measure(YogaNode yogaNode, float f16, YogaMeasureMode yogaMeasureMode, float f17, YogaMeasureMode yogaMeasureMode2) {
            View view = (View) yogaNode.getData();
            if (view != null && !(view instanceof YogaLayout)) {
                view.measure(View.MeasureSpec.makeMeasureSpec((int) f16, viewMeasureSpecFromYogaMeasureMode(yogaMeasureMode)), View.MeasureSpec.makeMeasureSpec((int) f17, viewMeasureSpecFromYogaMeasureMode(yogaMeasureMode2)));
                return YogaMeasureOutput.make(view.getMeasuredWidth(), view.getMeasuredHeight());
            }
            return YogaMeasureOutput.make(0, 0);
        }
    }

    public YogaLayout(Context context) {
        this(context, null, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void applyLayoutParams(LayoutParams layoutParams, YogaNode yogaNode, View view) {
        if (view.getResources().getConfiguration().getLayoutDirection() == 1) {
            yogaNode.setDirection(YogaDirection.RTL);
        }
        Drawable background = view.getBackground();
        if (background != null) {
            if (background.getPadding(new Rect())) {
                yogaNode.setPadding(YogaEdge.LEFT, r0.left);
                yogaNode.setPadding(YogaEdge.TOP, r0.top);
                yogaNode.setPadding(YogaEdge.RIGHT, r0.right);
                yogaNode.setPadding(YogaEdge.BOTTOM, r0.bottom);
            }
        }
        for (int i3 = 0; i3 < layoutParams.numericAttributes.size(); i3++) {
            int keyAt = layoutParams.numericAttributes.keyAt(i3);
            float floatValue = layoutParams.numericAttributes.valueAt(i3).floatValue();
            if (keyAt == R.styleable.yoga_yg_alignContent) {
                yogaNode.setAlignContent(YogaAlign.fromInt(Math.round(floatValue)));
            } else if (keyAt == R.styleable.yoga_yg_alignItems) {
                yogaNode.setAlignItems(YogaAlign.fromInt(Math.round(floatValue)));
            } else if (keyAt == R.styleable.yoga_yg_alignSelf) {
                yogaNode.setAlignSelf(YogaAlign.fromInt(Math.round(floatValue)));
            } else if (keyAt == R.styleable.yoga_yg_aspectRatio) {
                yogaNode.setAspectRatio(floatValue);
            } else if (keyAt == R.styleable.yoga_yg_borderLeft) {
                yogaNode.setBorder(YogaEdge.LEFT, floatValue);
            } else if (keyAt == R.styleable.yoga_yg_borderTop) {
                yogaNode.setBorder(YogaEdge.TOP, floatValue);
            } else if (keyAt == R.styleable.yoga_yg_borderRight) {
                yogaNode.setBorder(YogaEdge.RIGHT, floatValue);
            } else if (keyAt == R.styleable.yoga_yg_borderBottom) {
                yogaNode.setBorder(YogaEdge.BOTTOM, floatValue);
            } else if (keyAt == R.styleable.yoga_yg_borderStart) {
                yogaNode.setBorder(YogaEdge.START, floatValue);
            } else if (keyAt == R.styleable.yoga_yg_borderEnd) {
                yogaNode.setBorder(YogaEdge.END, floatValue);
            } else if (keyAt == R.styleable.yoga_yg_borderHorizontal) {
                yogaNode.setBorder(YogaEdge.HORIZONTAL, floatValue);
            } else if (keyAt == R.styleable.yoga_yg_borderVertical) {
                yogaNode.setBorder(YogaEdge.VERTICAL, floatValue);
            } else if (keyAt == R.styleable.yoga_yg_borderAll) {
                yogaNode.setBorder(YogaEdge.ALL, floatValue);
            } else if (keyAt == R.styleable.yoga_yg_direction) {
                yogaNode.setDirection(YogaDirection.fromInt(Math.round(floatValue)));
            } else if (keyAt == R.styleable.yoga_yg_display) {
                yogaNode.setDisplay(YogaDisplay.fromInt(Math.round(floatValue)));
            } else if (keyAt == R.styleable.yoga_yg_flex) {
                yogaNode.setFlex(floatValue);
            } else if (keyAt == R.styleable.yoga_yg_flexBasis) {
                yogaNode.setFlexBasis(floatValue);
            } else if (keyAt == R.styleable.yoga_yg_flexDirection) {
                yogaNode.setFlexDirection(YogaFlexDirection.fromInt(Math.round(floatValue)));
            } else if (keyAt == R.styleable.yoga_yg_flexGrow) {
                yogaNode.setFlexGrow(floatValue);
            } else if (keyAt == R.styleable.yoga_yg_flexShrink) {
                yogaNode.setFlexShrink(floatValue);
            } else if (keyAt == R.styleable.yoga_yg_height) {
                yogaNode.setHeight(floatValue);
            } else if (keyAt == R.styleable.yoga_yg_marginLeft) {
                yogaNode.setMargin(YogaEdge.LEFT, floatValue);
            } else if (keyAt == R.styleable.yoga_yg_justifyContent) {
                yogaNode.setJustifyContent(YogaJustify.fromInt(Math.round(floatValue)));
            } else if (keyAt == R.styleable.yoga_yg_marginTop) {
                yogaNode.setMargin(YogaEdge.TOP, floatValue);
            } else if (keyAt == R.styleable.yoga_yg_marginRight) {
                yogaNode.setMargin(YogaEdge.RIGHT, floatValue);
            } else if (keyAt == R.styleable.yoga_yg_marginBottom) {
                yogaNode.setMargin(YogaEdge.BOTTOM, floatValue);
            } else if (keyAt == R.styleable.yoga_yg_marginStart) {
                yogaNode.setMargin(YogaEdge.START, floatValue);
            } else if (keyAt == R.styleable.yoga_yg_marginEnd) {
                yogaNode.setMargin(YogaEdge.END, floatValue);
            } else if (keyAt == R.styleable.yoga_yg_marginHorizontal) {
                yogaNode.setMargin(YogaEdge.HORIZONTAL, floatValue);
            } else if (keyAt == R.styleable.yoga_yg_marginVertical) {
                yogaNode.setMargin(YogaEdge.VERTICAL, floatValue);
            } else if (keyAt == R.styleable.yoga_yg_marginAll) {
                yogaNode.setMargin(YogaEdge.ALL, floatValue);
            } else if (keyAt == R.styleable.yoga_yg_maxHeight) {
                yogaNode.setMaxHeight(floatValue);
            } else if (keyAt == R.styleable.yoga_yg_maxWidth) {
                yogaNode.setMaxWidth(floatValue);
            } else if (keyAt == R.styleable.yoga_yg_minHeight) {
                yogaNode.setMinHeight(floatValue);
            } else if (keyAt == R.styleable.yoga_yg_minWidth) {
                yogaNode.setMinWidth(floatValue);
            } else if (keyAt == R.styleable.yoga_yg_overflow) {
                yogaNode.setOverflow(YogaOverflow.fromInt(Math.round(floatValue)));
            } else if (keyAt == R.styleable.yoga_yg_paddingLeft) {
                yogaNode.setPadding(YogaEdge.LEFT, floatValue);
            } else if (keyAt == R.styleable.yoga_yg_paddingTop) {
                yogaNode.setPadding(YogaEdge.TOP, floatValue);
            } else if (keyAt == R.styleable.yoga_yg_paddingRight) {
                yogaNode.setPadding(YogaEdge.RIGHT, floatValue);
            } else if (keyAt == R.styleable.yoga_yg_paddingBottom) {
                yogaNode.setPadding(YogaEdge.BOTTOM, floatValue);
            } else if (keyAt == R.styleable.yoga_yg_paddingStart) {
                yogaNode.setPadding(YogaEdge.START, floatValue);
            } else if (keyAt == R.styleable.yoga_yg_paddingEnd) {
                yogaNode.setPadding(YogaEdge.END, floatValue);
            } else if (keyAt == R.styleable.yoga_yg_paddingHorizontal) {
                yogaNode.setPadding(YogaEdge.HORIZONTAL, floatValue);
            } else if (keyAt == R.styleable.yoga_yg_paddingVertical) {
                yogaNode.setPadding(YogaEdge.VERTICAL, floatValue);
            } else if (keyAt == R.styleable.yoga_yg_paddingAll) {
                yogaNode.setPadding(YogaEdge.ALL, floatValue);
            } else if (keyAt == R.styleable.yoga_yg_positionLeft) {
                yogaNode.setPosition(YogaEdge.LEFT, floatValue);
            } else if (keyAt == R.styleable.yoga_yg_positionTop) {
                yogaNode.setPosition(YogaEdge.TOP, floatValue);
            } else if (keyAt == R.styleable.yoga_yg_positionRight) {
                yogaNode.setPosition(YogaEdge.RIGHT, floatValue);
            } else if (keyAt == R.styleable.yoga_yg_positionBottom) {
                yogaNode.setPosition(YogaEdge.BOTTOM, floatValue);
            } else if (keyAt == R.styleable.yoga_yg_positionStart) {
                yogaNode.setPosition(YogaEdge.START, floatValue);
            } else if (keyAt == R.styleable.yoga_yg_positionEnd) {
                yogaNode.setPosition(YogaEdge.END, floatValue);
            } else if (keyAt == R.styleable.yoga_yg_positionHorizontal) {
                yogaNode.setPosition(YogaEdge.HORIZONTAL, floatValue);
            } else if (keyAt == R.styleable.yoga_yg_positionVertical) {
                yogaNode.setPosition(YogaEdge.VERTICAL, floatValue);
            } else if (keyAt == R.styleable.yoga_yg_positionAll) {
                yogaNode.setPosition(YogaEdge.ALL, floatValue);
            } else if (keyAt == R.styleable.yoga_yg_positionType) {
                yogaNode.setPositionType(YogaPositionType.fromInt(Math.round(floatValue)));
            } else if (keyAt == R.styleable.yoga_yg_width) {
                yogaNode.setWidth(floatValue);
            } else if (keyAt == R.styleable.yoga_yg_wrap) {
                yogaNode.setWrap(YogaWrap.fromInt(Math.round(floatValue)));
            }
        }
        for (int i16 = 0; i16 < layoutParams.stringAttributes.size(); i16++) {
            int keyAt2 = layoutParams.stringAttributes.keyAt(i16);
            String valueAt = layoutParams.stringAttributes.valueAt(i16);
            if (valueAt.equals("auto")) {
                if (keyAt2 == R.styleable.yoga_yg_marginLeft) {
                    yogaNode.setMarginAuto(YogaEdge.LEFT);
                } else if (keyAt2 == R.styleable.yoga_yg_marginTop) {
                    yogaNode.setMarginAuto(YogaEdge.TOP);
                } else if (keyAt2 == R.styleable.yoga_yg_marginRight) {
                    yogaNode.setMarginAuto(YogaEdge.RIGHT);
                } else if (keyAt2 == R.styleable.yoga_yg_marginBottom) {
                    yogaNode.setMarginAuto(YogaEdge.BOTTOM);
                } else if (keyAt2 == R.styleable.yoga_yg_marginStart) {
                    yogaNode.setMarginAuto(YogaEdge.START);
                } else if (keyAt2 == R.styleable.yoga_yg_marginEnd) {
                    yogaNode.setMarginAuto(YogaEdge.END);
                } else if (keyAt2 == R.styleable.yoga_yg_marginHorizontal) {
                    yogaNode.setMarginAuto(YogaEdge.HORIZONTAL);
                } else if (keyAt2 == R.styleable.yoga_yg_marginVertical) {
                    yogaNode.setMarginAuto(YogaEdge.VERTICAL);
                } else if (keyAt2 == R.styleable.yoga_yg_marginAll) {
                    yogaNode.setMarginAuto(YogaEdge.ALL);
                }
            }
            if (valueAt.endsWith("%")) {
                float parseFloat = Float.parseFloat(valueAt.substring(0, valueAt.length() - 1));
                if (keyAt2 == R.styleable.yoga_yg_flexBasis) {
                    yogaNode.setFlexBasisPercent(parseFloat);
                } else if (keyAt2 == R.styleable.yoga_yg_height) {
                    yogaNode.setHeightPercent(parseFloat);
                } else if (keyAt2 == R.styleable.yoga_yg_marginLeft) {
                    yogaNode.setMarginPercent(YogaEdge.LEFT, parseFloat);
                } else if (keyAt2 == R.styleable.yoga_yg_marginTop) {
                    yogaNode.setMarginPercent(YogaEdge.TOP, parseFloat);
                } else if (keyAt2 == R.styleable.yoga_yg_marginRight) {
                    yogaNode.setMarginPercent(YogaEdge.RIGHT, parseFloat);
                } else if (keyAt2 == R.styleable.yoga_yg_marginBottom) {
                    yogaNode.setMarginPercent(YogaEdge.BOTTOM, parseFloat);
                } else if (keyAt2 == R.styleable.yoga_yg_marginStart) {
                    yogaNode.setMarginPercent(YogaEdge.START, parseFloat);
                } else if (keyAt2 == R.styleable.yoga_yg_marginEnd) {
                    yogaNode.setMarginPercent(YogaEdge.END, parseFloat);
                } else if (keyAt2 == R.styleable.yoga_yg_marginHorizontal) {
                    yogaNode.setMarginPercent(YogaEdge.HORIZONTAL, parseFloat);
                } else if (keyAt2 == R.styleable.yoga_yg_marginVertical) {
                    yogaNode.setMarginPercent(YogaEdge.VERTICAL, parseFloat);
                } else if (keyAt2 == R.styleable.yoga_yg_marginAll) {
                    yogaNode.setMarginPercent(YogaEdge.ALL, parseFloat);
                } else if (keyAt2 == R.styleable.yoga_yg_maxHeight) {
                    yogaNode.setMaxHeightPercent(parseFloat);
                } else if (keyAt2 == R.styleable.yoga_yg_maxWidth) {
                    yogaNode.setMaxWidthPercent(parseFloat);
                } else if (keyAt2 == R.styleable.yoga_yg_minHeight) {
                    yogaNode.setMinHeightPercent(parseFloat);
                } else if (keyAt2 == R.styleable.yoga_yg_minWidth) {
                    yogaNode.setMinWidthPercent(parseFloat);
                } else if (keyAt2 == R.styleable.yoga_yg_paddingLeft) {
                    yogaNode.setPaddingPercent(YogaEdge.LEFT, parseFloat);
                } else if (keyAt2 == R.styleable.yoga_yg_paddingTop) {
                    yogaNode.setPaddingPercent(YogaEdge.TOP, parseFloat);
                } else if (keyAt2 == R.styleable.yoga_yg_paddingRight) {
                    yogaNode.setPaddingPercent(YogaEdge.RIGHT, parseFloat);
                } else if (keyAt2 == R.styleable.yoga_yg_paddingBottom) {
                    yogaNode.setPaddingPercent(YogaEdge.BOTTOM, parseFloat);
                } else if (keyAt2 == R.styleable.yoga_yg_paddingStart) {
                    yogaNode.setPaddingPercent(YogaEdge.START, parseFloat);
                } else if (keyAt2 == R.styleable.yoga_yg_paddingEnd) {
                    yogaNode.setPaddingPercent(YogaEdge.END, parseFloat);
                } else if (keyAt2 == R.styleable.yoga_yg_paddingHorizontal) {
                    yogaNode.setPaddingPercent(YogaEdge.HORIZONTAL, parseFloat);
                } else if (keyAt2 == R.styleable.yoga_yg_paddingVertical) {
                    yogaNode.setPaddingPercent(YogaEdge.VERTICAL, parseFloat);
                } else if (keyAt2 == R.styleable.yoga_yg_paddingAll) {
                    yogaNode.setPaddingPercent(YogaEdge.ALL, parseFloat);
                } else if (keyAt2 == R.styleable.yoga_yg_positionLeft) {
                    yogaNode.setPositionPercent(YogaEdge.LEFT, parseFloat);
                } else if (keyAt2 == R.styleable.yoga_yg_positionTop) {
                    yogaNode.setPositionPercent(YogaEdge.TOP, parseFloat);
                } else if (keyAt2 == R.styleable.yoga_yg_positionRight) {
                    yogaNode.setPositionPercent(YogaEdge.RIGHT, parseFloat);
                } else if (keyAt2 == R.styleable.yoga_yg_positionBottom) {
                    yogaNode.setPositionPercent(YogaEdge.BOTTOM, parseFloat);
                } else if (keyAt2 == R.styleable.yoga_yg_positionStart) {
                    yogaNode.setPositionPercent(YogaEdge.START, parseFloat);
                } else if (keyAt2 == R.styleable.yoga_yg_positionEnd) {
                    yogaNode.setPositionPercent(YogaEdge.END, parseFloat);
                } else if (keyAt2 == R.styleable.yoga_yg_positionHorizontal) {
                    yogaNode.setPositionPercent(YogaEdge.HORIZONTAL, parseFloat);
                } else if (keyAt2 == R.styleable.yoga_yg_positionVertical) {
                    yogaNode.setPositionPercent(YogaEdge.VERTICAL, parseFloat);
                } else if (keyAt2 == R.styleable.yoga_yg_positionAll) {
                    yogaNode.setPositionPercent(YogaEdge.ALL, parseFloat);
                } else if (keyAt2 == R.styleable.yoga_yg_width) {
                    yogaNode.setWidthPercent(parseFloat);
                }
            }
        }
    }

    private void applyLayoutRecursive(YogaNode yogaNode, float f16, float f17) {
        View view = (View) yogaNode.getData();
        if (view != null && view != this) {
            if (view.getVisibility() == 8) {
                return;
            }
            int round = Math.round(yogaNode.getLayoutX() + f16);
            int round2 = Math.round(yogaNode.getLayoutY() + f17);
            view.measure(View.MeasureSpec.makeMeasureSpec(Math.round(yogaNode.getLayoutWidth()), 1073741824), View.MeasureSpec.makeMeasureSpec(Math.round(yogaNode.getLayoutHeight()), 1073741824));
            view.layout(round, round2, view.getMeasuredWidth() + round, view.getMeasuredHeight() + round2);
        }
        int childCount = yogaNode.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            if (equals(view)) {
                applyLayoutRecursive(yogaNode.getChildAt(i3), f16, f17);
            } else if (!(view instanceof YogaLayout)) {
                applyLayoutRecursive(yogaNode.getChildAt(i3), yogaNode.getLayoutX() + f16, yogaNode.getLayoutY() + f17);
            }
        }
    }

    private void createLayout(int i3, int i16) {
        int size = View.MeasureSpec.getSize(i3);
        int size2 = View.MeasureSpec.getSize(i16);
        int mode = View.MeasureSpec.getMode(i3);
        int mode2 = View.MeasureSpec.getMode(i16);
        if (mode2 == 1073741824) {
            this.mYogaNode.setHeight(size2);
        }
        if (mode == 1073741824) {
            this.mYogaNode.setWidth(size);
        }
        if (mode2 == Integer.MIN_VALUE) {
            this.mYogaNode.setMaxHeight(size2);
        }
        if (mode == Integer.MIN_VALUE) {
            this.mYogaNode.setMaxWidth(size);
        }
        this.mYogaNode.calculateLayout(Float.NaN, Float.NaN);
    }

    private void removeViewFromYogaTree(View view, boolean z16) {
        YogaNode yogaNode = this.mYogaNodes.get(view);
        if (yogaNode == null) {
            return;
        }
        YogaNode owner = yogaNode.getOwner();
        int i3 = 0;
        while (true) {
            if (i3 >= owner.getChildCount()) {
                break;
            }
            if (owner.getChildAt(i3).equals(yogaNode)) {
                owner.removeChildAt(i3);
                break;
            }
            i3++;
        }
        yogaNode.setData(null);
        this.mYogaNodes.remove(view);
        if (z16) {
            this.mYogaNode.calculateLayout(Float.NaN, Float.NaN);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        YogaNode create;
        this.mYogaNode.setMeasureFunction(null);
        if (view instanceof VirtualYogaLayout) {
            VirtualYogaLayout virtualYogaLayout = (VirtualYogaLayout) view;
            virtualYogaLayout.transferChildren(this);
            YogaNode yogaNode = virtualYogaLayout.getYogaNode();
            YogaNode yogaNode2 = this.mYogaNode;
            yogaNode2.addChildAt(yogaNode, yogaNode2.getChildCount());
            return;
        }
        super.addView(view, i3, layoutParams);
        if (this.mYogaNodes.containsKey(view)) {
            return;
        }
        if (view instanceof YogaLayout) {
            create = ((YogaLayout) view).getYogaNode();
        } else {
            if (this.mYogaNodes.containsKey(view)) {
                create = this.mYogaNodes.get(view);
            } else {
                create = YogaNodeFactory.create();
            }
            create.setData(view);
            create.setMeasureFunction(new ViewMeasureFunction());
        }
        applyLayoutParams((LayoutParams) view.getLayoutParams(), create, view);
        this.mYogaNodes.put(view, create);
        YogaNode yogaNode3 = this.mYogaNode;
        yogaNode3.addChildAt(create, yogaNode3.getChildCount());
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public YogaNode getYogaNode() {
        return this.mYogaNode;
    }

    public YogaNode getYogaNodeForView(View view) {
        return this.mYogaNodes.get(view);
    }

    public void invalidate(View view) {
        if (this.mYogaNodes.containsKey(view)) {
            this.mYogaNodes.get(view).dirty();
            return;
        }
        int childCount = this.mYogaNode.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            YogaNode childAt = this.mYogaNode.getChildAt(i3);
            if (childAt.getData() instanceof YogaLayout) {
                ((YogaLayout) childAt.getData()).invalidate(view);
            }
        }
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        if (!(getParent() instanceof YogaLayout)) {
            createLayout(View.MeasureSpec.makeMeasureSpec(i17 - i3, 1073741824), View.MeasureSpec.makeMeasureSpec(i18 - i16, 1073741824));
        }
        applyLayoutRecursive(this.mYogaNode, 0.0f, 0.0f);
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        if (!(getParent() instanceof YogaLayout)) {
            createLayout(i3, i16);
        }
        setMeasuredDimension(Math.round(this.mYogaNode.getLayoutWidth()), Math.round(this.mYogaNode.getLayoutHeight()));
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            removeViewFromYogaTree(getChildAt(i3), false);
        }
        super.removeAllViews();
    }

    @Override // android.view.ViewGroup
    public void removeAllViewsInLayout() {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            removeViewFromYogaTree(getChildAt(i3), true);
        }
        super.removeAllViewsInLayout();
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        removeViewFromYogaTree(view, false);
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i3) {
        removeViewFromYogaTree(getChildAt(i3), false);
        super.removeViewAt(i3);
    }

    @Override // android.view.ViewGroup
    public void removeViewInLayout(View view) {
        removeViewFromYogaTree(view, true);
        super.removeViewInLayout(view);
    }

    @Override // android.view.ViewGroup
    public void removeViews(int i3, int i16) {
        for (int i17 = i3; i17 < i3 + i16; i17++) {
            removeViewFromYogaTree(getChildAt(i17), false);
        }
        super.removeViews(i3, i16);
    }

    @Override // android.view.ViewGroup
    public void removeViewsInLayout(int i3, int i16) {
        for (int i17 = i3; i17 < i3 + i16; i17++) {
            removeViewFromYogaTree(getChildAt(i17), true);
        }
        super.removeViewsInLayout(i3, i16);
    }

    public YogaLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public YogaLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        LayoutParams layoutParams;
        YogaNode create = YogaNodeFactory.create();
        this.mYogaNode = create;
        this.mYogaNodes = new HashMap();
        create.setData(this);
        create.setMeasureFunction(new ViewMeasureFunction());
        if (attributeSet != null) {
            layoutParams = new LayoutParams(context, attributeSet);
        } else {
            layoutParams = (LayoutParams) generateDefaultLayoutParams();
        }
        applyLayoutParams(layoutParams, create, this);
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class LayoutParams extends ViewGroup.LayoutParams {
        SparseArray<Float> numericAttributes;
        SparseArray<String> stringAttributes;

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            if (layoutParams instanceof LayoutParams) {
                LayoutParams layoutParams2 = (LayoutParams) layoutParams;
                this.numericAttributes = layoutParams2.numericAttributes.clone();
                this.stringAttributes = layoutParams2.stringAttributes.clone();
                return;
            }
            this.numericAttributes = new SparseArray<>();
            this.stringAttributes = new SparseArray<>();
            if (layoutParams.width >= 0) {
                this.numericAttributes.put(R.styleable.yoga_yg_width, Float.valueOf(((ViewGroup.LayoutParams) this).width));
            }
            if (layoutParams.height >= 0) {
                this.numericAttributes.put(R.styleable.yoga_yg_height, Float.valueOf(((ViewGroup.LayoutParams) this).height));
            }
        }

        public LayoutParams(int i3, int i16) {
            super(i3, i16);
            this.numericAttributes = new SparseArray<>();
            this.stringAttributes = new SparseArray<>();
            if (i3 >= 0) {
                this.numericAttributes.put(R.styleable.yoga_yg_width, Float.valueOf(i3));
            }
            if (i16 >= 0) {
                this.numericAttributes.put(R.styleable.yoga_yg_height, Float.valueOf(i16));
            }
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.numericAttributes = new SparseArray<>();
            this.stringAttributes = new SparseArray<>();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.yoga);
            int i3 = ((ViewGroup.LayoutParams) this).width;
            if (i3 >= 0) {
                this.numericAttributes.put(R.styleable.yoga_yg_width, Float.valueOf(i3));
            }
            int i16 = ((ViewGroup.LayoutParams) this).height;
            if (i16 >= 0) {
                this.numericAttributes.put(R.styleable.yoga_yg_height, Float.valueOf(i16));
            }
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i17 = 0; i17 < indexCount; i17++) {
                int index = obtainStyledAttributes.getIndex(i17);
                TypedValue typedValue = new TypedValue();
                obtainStyledAttributes.getValue(index, typedValue);
                int i18 = typedValue.type;
                if (i18 == 5) {
                    this.numericAttributes.put(index, Float.valueOf(obtainStyledAttributes.getDimensionPixelSize(index, 0)));
                } else if (i18 == 3) {
                    this.stringAttributes.put(index, obtainStyledAttributes.getString(index));
                } else {
                    this.numericAttributes.put(index, Float.valueOf(obtainStyledAttributes.getFloat(index, 0.0f)));
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public void addView(View view, YogaNode yogaNode) {
        this.mYogaNodes.put(view, yogaNode);
        addView(view);
    }
}
