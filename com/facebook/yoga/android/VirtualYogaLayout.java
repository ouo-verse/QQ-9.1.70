package com.facebook.yoga.android;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.yoga.YogaNode;
import com.facebook.yoga.YogaNodeFactory;
import com.facebook.yoga.android.YogaLayout;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
public class VirtualYogaLayout extends ViewGroup {
    private final List<View> mChildren;
    private final YogaNode mYogaNode;
    private final Map<View, YogaNode> mYogaNodes;

    public VirtualYogaLayout(Context context) {
        super(context);
        this.mChildren = new LinkedList();
        this.mYogaNodes = new HashMap();
        this.mYogaNode = YogaNodeFactory.create();
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof VirtualYogaLayout) {
            VirtualYogaLayout virtualYogaLayout = (VirtualYogaLayout) view;
            virtualYogaLayout.transferChildren(this);
            YogaNode yogaNode = virtualYogaLayout.getYogaNode();
            YogaNode yogaNode2 = this.mYogaNode;
            yogaNode2.addChildAt(yogaNode, yogaNode2.getChildCount());
            return;
        }
        YogaNode create = YogaNodeFactory.create();
        YogaLayout.applyLayoutParams(new YogaLayout.LayoutParams(layoutParams), create, view);
        create.setData(view);
        create.setMeasureFunction(new YogaLayout.ViewMeasureFunction());
        YogaNode yogaNode3 = this.mYogaNode;
        yogaNode3.addChildAt(create, yogaNode3.getChildCount());
        addView(view, create);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof YogaLayout.LayoutParams;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new YogaLayout.LayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new YogaLayout.LayoutParams(getContext(), attributeSet);
    }

    public YogaNode getYogaNode() {
        return this.mYogaNode;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        throw new RuntimeException("Attempting to layout a VirtualYogaLayout");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void transferChildren(ViewGroup viewGroup) {
        if (viewGroup instanceof VirtualYogaLayout) {
            for (View view : this.mChildren) {
                ((VirtualYogaLayout) viewGroup).addView(view, this.mYogaNodes.get(view));
            }
        } else if (viewGroup instanceof YogaLayout) {
            for (View view2 : this.mChildren) {
                ((YogaLayout) viewGroup).addView(view2, this.mYogaNodes.get(view2));
            }
        } else {
            throw new RuntimeException("VirtualYogaLayout cannot transfer children to ViewGroup of type " + viewGroup.getClass().getCanonicalName() + ".  Must either be a VirtualYogaLayout or a YogaLayout.");
        }
        this.mChildren.clear();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new YogaLayout.LayoutParams(layoutParams);
    }

    public VirtualYogaLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VirtualYogaLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mChildren = new LinkedList();
        this.mYogaNodes = new HashMap();
        YogaNode create = YogaNodeFactory.create();
        this.mYogaNode = create;
        YogaLayout.applyLayoutParams(new YogaLayout.LayoutParams(context, attributeSet), create, this);
    }

    public void addView(View view, YogaNode yogaNode) {
        this.mChildren.add(view);
        this.mYogaNodes.put(view, yogaNode);
    }
}
