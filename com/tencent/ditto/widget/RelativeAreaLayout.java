package com.tencent.ditto.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.Pools;
import android.view.View;
import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.area.DittoAreaGroup;
import com.tencent.ditto.area.DittoHost;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.ditto.shell.LayoutAttrSet;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RelativeAreaLayout extends DittoAreaGroup {
    private boolean mAllowBrokenMeasureSpecs;
    private boolean mDirtyHierarchy;
    private final DependencyGraph mGraph;
    private int mGravity;
    private boolean mMeasureVerticalWithPaddingMargin;
    private int mOrientation;
    private DittoArea[] mSortedHorizontalChildren;
    private DittoArea[] mSortedVerticalChildren;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class DependencyGraph {
        private Map<String, Node> mKeyNodes;
        private ArrayList<Node> mNodes;
        private ArrayDeque<Node> mRoots;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes5.dex */
        public static class Node {
            private static final int POOL_LIMIT = 100;
            private static final Pools.SynchronizedPool<Node> sPool = new Pools.SynchronizedPool<>(100);
            DittoArea area;
            final Map<Node, DependencyGraph> dependents = new HashMap();
            final Map<String, Node> dependencies = new HashMap();

            Node() {
            }

            static Node acquire(DittoArea dittoArea) {
                Node acquire = sPool.acquire();
                if (acquire == null) {
                    acquire = new Node();
                }
                acquire.area = dittoArea;
                return acquire;
            }

            void release() {
                this.area = null;
                this.dependents.clear();
                this.dependencies.clear();
                sPool.release(this);
            }
        }

        DependencyGraph() {
            this.mNodes = new ArrayList<>();
            this.mKeyNodes = new ArrayMap();
            this.mRoots = new ArrayDeque<>();
        }

        private ArrayDeque<Node> findRoots(String[] strArr) {
            Node node;
            Map<String, Node> map = this.mKeyNodes;
            ArrayList<Node> arrayList = this.mNodes;
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                Node node2 = arrayList.get(i3);
                node2.dependents.clear();
                node2.dependencies.clear();
            }
            for (int i16 = 0; i16 < size; i16++) {
                Node node3 = arrayList.get(i16);
                Map<String, Object> map2 = node3.area.getLayoutAttr().mAttrs;
                for (String str : strArr) {
                    String str2 = (String) map2.get(str);
                    if (str2 != null && (node = map.get(str2)) != null && node != node3) {
                        node.dependents.put(node3, this);
                        node3.dependencies.put(str2, node);
                    }
                }
            }
            ArrayDeque<Node> arrayDeque = this.mRoots;
            arrayDeque.clear();
            for (int i17 = 0; i17 < size; i17++) {
                Node node4 = arrayList.get(i17);
                if (node4.dependencies.size() == 0) {
                    arrayDeque.addLast(node4);
                }
            }
            return arrayDeque;
        }

        void add(DittoArea dittoArea) {
            String id5 = dittoArea.getId();
            Node acquire = Node.acquire(dittoArea);
            if (id5 != null && !id5.equals("")) {
                this.mKeyNodes.put(id5, acquire);
            }
            this.mNodes.add(acquire);
        }

        void clear() {
            ArrayList<Node> arrayList = this.mNodes;
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                arrayList.get(i3).release();
            }
            arrayList.clear();
            this.mKeyNodes.clear();
            this.mRoots.clear();
        }

        void getSortedViews(DittoArea[] dittoAreaArr, String... strArr) {
            ArrayDeque<Node> findRoots = findRoots(strArr);
            int i3 = 0;
            while (true) {
                Node pollLast = findRoots.pollLast();
                if (pollLast == null) {
                    break;
                }
                DittoArea dittoArea = pollLast.area;
                String id5 = dittoArea.getId();
                int i16 = i3 + 1;
                dittoAreaArr[i3] = dittoArea;
                for (Node node : pollLast.dependents.keySet()) {
                    Map<String, Node> map = node.dependencies;
                    map.remove(id5);
                    if (map.size() == 0) {
                        findRoots.add(node);
                    }
                }
                i3 = i16;
            }
            if (i3 < dittoAreaArr.length) {
                throw new IllegalStateException("Circular dependencies cannot exist in RelativeLayout");
            }
        }
    }

    public RelativeAreaLayout(DittoHost dittoHost, LayoutAttrSet layoutAttrSet) {
        super(dittoHost, layoutAttrSet);
        this.mOrientation = 1;
        this.mAllowBrokenMeasureSpecs = false;
        this.mMeasureVerticalWithPaddingMargin = false;
        this.mGravity = 8388659;
        this.mGraph = new DependencyGraph();
        setOrientation(layoutAttrSet.orientation);
        queryCompatibilityModes(dittoHost.getContext());
    }

    private void applyHorizontalSizeRules(LayoutAttrSet layoutAttrSet, int i3, Map<String, Object> map) {
        layoutAttrSet.left = Integer.MIN_VALUE;
        layoutAttrSet.right = Integer.MIN_VALUE;
        LayoutAttrSet relatedViewParams = getRelatedViewParams(map, LayoutAttrDefine.TO_LEFT_OF);
        if (relatedViewParams != null) {
            layoutAttrSet.right = relatedViewParams.left - (relatedViewParams.leftMargin + layoutAttrSet.rightMargin);
        } else if (layoutAttrSet.alignWithParentIfMissing && map.get(LayoutAttrDefine.TO_LEFT_OF) != null && i3 >= 0) {
            layoutAttrSet.right = (i3 - this.paddingRight) - layoutAttrSet.rightMargin;
        }
        LayoutAttrSet relatedViewParams2 = getRelatedViewParams(map, LayoutAttrDefine.TO_RIGHT_OF);
        if (relatedViewParams2 != null) {
            layoutAttrSet.left = relatedViewParams2.right + relatedViewParams2.rightMargin + layoutAttrSet.leftMargin;
        } else if (layoutAttrSet.alignWithParentIfMissing && map.get(LayoutAttrDefine.TO_RIGHT_OF) != null) {
            layoutAttrSet.left = this.paddingLeft + layoutAttrSet.leftMargin;
        }
        LayoutAttrSet relatedViewParams3 = getRelatedViewParams(map, LayoutAttrDefine.ALIGN_LEFT);
        if (relatedViewParams3 != null) {
            layoutAttrSet.left = relatedViewParams3.left + layoutAttrSet.leftMargin;
        } else if (layoutAttrSet.alignWithParentIfMissing && map.get(LayoutAttrDefine.ALIGN_LEFT) != null) {
            layoutAttrSet.left = this.paddingLeft + layoutAttrSet.leftMargin;
        }
        LayoutAttrSet relatedViewParams4 = getRelatedViewParams(map, LayoutAttrDefine.ALIGN_RIGHT);
        if (relatedViewParams4 != null) {
            layoutAttrSet.right = relatedViewParams4.right - layoutAttrSet.rightMargin;
        } else if (layoutAttrSet.alignWithParentIfMissing && map.get(LayoutAttrDefine.ALIGN_RIGHT) != null && i3 >= 0) {
            layoutAttrSet.right = (i3 - this.paddingRight) - layoutAttrSet.rightMargin;
        }
        if (map.get(LayoutAttrDefine.ALIGN_PARENT_LEFT) != null && ((Boolean) map.get(LayoutAttrDefine.ALIGN_PARENT_LEFT)).booleanValue()) {
            layoutAttrSet.left = this.paddingLeft + layoutAttrSet.leftMargin;
        }
        if (map.get(LayoutAttrDefine.ALIGN_PARENT_RIGHT) != null && ((Boolean) map.get(LayoutAttrDefine.ALIGN_PARENT_RIGHT)).booleanValue() && i3 >= 0) {
            layoutAttrSet.right = (i3 - this.paddingRight) - layoutAttrSet.rightMargin;
        }
    }

    private void applyVerticalSizeRules(LayoutAttrSet layoutAttrSet, int i3) {
        Map<String, Object> map = layoutAttrSet.mAttrs;
        layoutAttrSet.top = Integer.MIN_VALUE;
        layoutAttrSet.bottom = Integer.MIN_VALUE;
        LayoutAttrSet relatedViewParams = getRelatedViewParams(map, LayoutAttrDefine.ABOVE);
        if (relatedViewParams != null) {
            layoutAttrSet.bottom = relatedViewParams.top - (relatedViewParams.topMargin + layoutAttrSet.bottomMargin);
        } else if (layoutAttrSet.alignWithParentIfMissing && map.get(LayoutAttrDefine.ABOVE) != null && i3 >= 0) {
            layoutAttrSet.bottom = (i3 - this.paddingBottom) - layoutAttrSet.bottomMargin;
        }
        LayoutAttrSet relatedViewParams2 = getRelatedViewParams(map, LayoutAttrDefine.BELOW);
        if (relatedViewParams2 != null) {
            layoutAttrSet.top = relatedViewParams2.bottom + relatedViewParams2.bottomMargin + layoutAttrSet.topMargin;
        } else if (layoutAttrSet.alignWithParentIfMissing && map.get(LayoutAttrDefine.BELOW) != null) {
            layoutAttrSet.top = this.paddingTop + layoutAttrSet.topMargin;
        }
        LayoutAttrSet relatedViewParams3 = getRelatedViewParams(map, LayoutAttrDefine.ALIGN_TOP);
        if (relatedViewParams3 != null) {
            layoutAttrSet.top = relatedViewParams3.top + layoutAttrSet.topMargin;
        } else if (layoutAttrSet.alignWithParentIfMissing && map.get(LayoutAttrDefine.ALIGN_TOP) != null) {
            layoutAttrSet.top = this.paddingTop + layoutAttrSet.topMargin;
        }
        LayoutAttrSet relatedViewParams4 = getRelatedViewParams(map, LayoutAttrDefine.ALIGN_BOTTOM);
        if (relatedViewParams4 != null) {
            layoutAttrSet.bottom = relatedViewParams4.bottom - layoutAttrSet.bottomMargin;
        } else if (layoutAttrSet.alignWithParentIfMissing && map.get(LayoutAttrDefine.ALIGN_BOTTOM) != null && i3 >= 0) {
            layoutAttrSet.bottom = (i3 - this.paddingBottom) - layoutAttrSet.bottomMargin;
        }
        if (map.get(LayoutAttrDefine.ALIGN_PARENT_TOP) != null && ((Boolean) map.get(LayoutAttrDefine.ALIGN_PARENT_TOP)).booleanValue()) {
            layoutAttrSet.top = this.paddingTop + layoutAttrSet.topMargin;
        }
        if (map.get(LayoutAttrDefine.ALIGN_PARENT_BOTTOM) != null && ((Boolean) map.get(LayoutAttrDefine.ALIGN_PARENT_BOTTOM)).booleanValue() && i3 >= 0) {
            layoutAttrSet.bottom = (i3 - this.paddingBottom) - layoutAttrSet.bottomMargin;
        }
    }

    private static void centerHorizontal(DittoArea dittoArea, LayoutAttrSet layoutAttrSet, int i3) {
        int measuredWidth = dittoArea.getMeasuredWidth();
        int i16 = (i3 - measuredWidth) / 2;
        layoutAttrSet.left = i16;
        layoutAttrSet.right = i16 + measuredWidth;
    }

    private static void centerVertical(DittoArea dittoArea, LayoutAttrSet layoutAttrSet, int i3) {
        int measuredHeight = dittoArea.getMeasuredHeight();
        int i16 = (i3 - measuredHeight) / 2;
        layoutAttrSet.top = i16;
        layoutAttrSet.bottom = i16 + measuredHeight;
    }

    private int getChildMeasureSpec(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        int i29;
        int i36;
        int i37 = 1073741824;
        if (i28 < 0 && !this.mAllowBrokenMeasureSpecs) {
            if (i3 != Integer.MIN_VALUE && i16 != Integer.MIN_VALUE) {
                i17 = Math.max(0, i16 - i3);
            } else if (i17 < 0) {
                i17 = 0;
                i37 = 0;
            }
            return View.MeasureSpec.makeMeasureSpec(i17, i37);
        }
        if (i3 == Integer.MIN_VALUE) {
            i29 = i26 + i18;
        } else {
            i29 = i3;
        }
        if (i16 == Integer.MIN_VALUE) {
            i36 = (i28 - i27) - i19;
        } else {
            i36 = i16;
        }
        int i38 = i36 - i29;
        if (i3 == Integer.MIN_VALUE || i16 == Integer.MIN_VALUE) {
            if (i17 >= 0) {
                if (i38 >= 0) {
                    i17 = Math.min(i38, i17);
                }
            } else if (i17 != -1) {
                if (i17 == -2 && i38 >= 0) {
                    i17 = i38;
                    i37 = Integer.MIN_VALUE;
                } else {
                    i17 = 0;
                    i37 = 0;
                }
            }
            return View.MeasureSpec.makeMeasureSpec(i17, i37);
        }
        i17 = i38;
        return View.MeasureSpec.makeMeasureSpec(i17, i37);
    }

    private DittoArea getRelatedView(Map<String, Object> map, String str) {
        DependencyGraph.Node node;
        String str2 = (String) map.get(str);
        if (str2 == null || (node = (DependencyGraph.Node) this.mGraph.mKeyNodes.get(str2)) == null) {
            return null;
        }
        DittoArea dittoArea = node.area;
        while (dittoArea.getVisibility() == 8) {
            DependencyGraph.Node node2 = (DependencyGraph.Node) this.mGraph.mKeyNodes.get(dittoArea.getLayoutAttr().mAttrs.get(str));
            if (node2 == null) {
                return null;
            }
            dittoArea = node2.area;
        }
        return dittoArea;
    }

    private LayoutAttrSet getRelatedViewParams(Map<String, Object> map, String str) {
        DittoArea relatedView = getRelatedView(map, str);
        if (relatedView != null && relatedView.getLayoutAttr() != null) {
            return relatedView.getLayoutAttr();
        }
        return null;
    }

    private void measureChild(DittoArea dittoArea, LayoutAttrSet layoutAttrSet, int i3, int i16) {
        dittoArea.measure(getChildMeasureSpec(layoutAttrSet.left, layoutAttrSet.right, layoutAttrSet.width, layoutAttrSet.leftMargin, layoutAttrSet.rightMargin, this.paddingLeft, this.paddingRight, i3), getChildMeasureSpec(layoutAttrSet.top, layoutAttrSet.bottom, layoutAttrSet.height, layoutAttrSet.topMargin, layoutAttrSet.bottomMargin, this.paddingTop, this.paddingBottom, i16));
    }

    private void measureChildHorizontal(DittoArea dittoArea, LayoutAttrSet layoutAttrSet, int i3, int i16) {
        int i17;
        int makeMeasureSpec;
        int childMeasureSpec = getChildMeasureSpec(layoutAttrSet.left, layoutAttrSet.right, layoutAttrSet.width, layoutAttrSet.leftMargin, layoutAttrSet.rightMargin, this.paddingLeft, this.paddingRight, i3);
        if (this.mMeasureVerticalWithPaddingMargin) {
            i17 = Math.max(0, (((i16 - this.paddingTop) - this.paddingBottom) - layoutAttrSet.topMargin) - layoutAttrSet.bottomMargin);
        } else {
            i17 = i16;
        }
        if (i16 < 0 && !this.mAllowBrokenMeasureSpecs) {
            int i18 = layoutAttrSet.height;
            if (i18 >= 0) {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i18, 1073741824);
            } else {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            }
        } else if (layoutAttrSet.height == -1) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i17, 1073741824);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i17, Integer.MIN_VALUE);
        }
        dittoArea.measure(childMeasureSpec, makeMeasureSpec);
    }

    private boolean positionChildHorizontal(DittoArea dittoArea, LayoutAttrSet layoutAttrSet, int i3, boolean z16) {
        int i16;
        Map<String, Object> map = layoutAttrSet.mAttrs;
        int i17 = layoutAttrSet.left;
        if (i17 == Integer.MIN_VALUE && (i16 = layoutAttrSet.right) != Integer.MIN_VALUE) {
            layoutAttrSet.left = i16 - dittoArea.getMeasuredWidth();
        } else if (i17 != Integer.MIN_VALUE && layoutAttrSet.right == Integer.MIN_VALUE) {
            layoutAttrSet.right = i17 + dittoArea.getMeasuredWidth();
        } else if (i17 == Integer.MIN_VALUE && layoutAttrSet.right == Integer.MIN_VALUE) {
            if ((map.get(LayoutAttrDefine.CENTER_IN_PARENT) != null && ((Boolean) map.get(LayoutAttrDefine.CENTER_IN_PARENT)).booleanValue()) || (map.get(LayoutAttrDefine.CENTER_HORIZONTAL) != null && ((Boolean) map.get(LayoutAttrDefine.CENTER_HORIZONTAL)).booleanValue())) {
                if (!z16) {
                    centerHorizontal(dittoArea, layoutAttrSet, i3);
                } else {
                    int i18 = this.paddingLeft + layoutAttrSet.leftMargin;
                    layoutAttrSet.left = i18;
                    layoutAttrSet.right = i18 + dittoArea.getMeasuredWidth();
                }
                return true;
            }
            int i19 = this.paddingLeft + layoutAttrSet.leftMargin;
            layoutAttrSet.left = i19;
            layoutAttrSet.right = i19 + dittoArea.getMeasuredWidth();
        }
        if (map.get(LayoutAttrDefine.ALIGN_PARENT_RIGHT) != null && ((Boolean) map.get(LayoutAttrDefine.ALIGN_PARENT_RIGHT)).booleanValue()) {
            return true;
        }
        return false;
    }

    private boolean positionChildVertical(DittoArea dittoArea, LayoutAttrSet layoutAttrSet, int i3, boolean z16) {
        int i16;
        Map<String, Object> map = layoutAttrSet.mAttrs;
        int i17 = layoutAttrSet.top;
        if (i17 == Integer.MIN_VALUE && (i16 = layoutAttrSet.bottom) != Integer.MIN_VALUE) {
            layoutAttrSet.top = i16 - dittoArea.getMeasuredHeight();
        } else if (i17 != Integer.MIN_VALUE && layoutAttrSet.bottom == Integer.MIN_VALUE) {
            layoutAttrSet.bottom = i17 + dittoArea.getMeasuredHeight();
        } else if (i17 == Integer.MIN_VALUE && layoutAttrSet.bottom == Integer.MIN_VALUE) {
            if ((map.get(LayoutAttrDefine.CENTER_IN_PARENT) != null && ((Boolean) map.get(LayoutAttrDefine.CENTER_IN_PARENT)).booleanValue()) || (map.get(LayoutAttrDefine.CENTER_VERTICAL) != null && ((Boolean) map.get(LayoutAttrDefine.CENTER_VERTICAL)).booleanValue())) {
                if (!z16) {
                    centerVertical(dittoArea, layoutAttrSet, i3);
                } else {
                    int i18 = this.paddingTop + layoutAttrSet.topMargin;
                    layoutAttrSet.top = i18;
                    layoutAttrSet.bottom = i18 + dittoArea.getMeasuredHeight();
                }
                return true;
            }
            int i19 = this.paddingTop + layoutAttrSet.topMargin;
            layoutAttrSet.top = i19;
            layoutAttrSet.bottom = i19 + dittoArea.getMeasuredHeight();
        }
        if (map.get(LayoutAttrDefine.ALIGN_PARENT_BOTTOM) != null && ((Boolean) map.get(LayoutAttrDefine.ALIGN_PARENT_BOTTOM)).booleanValue()) {
            return true;
        }
        return false;
    }

    private void queryCompatibilityModes(Context context) {
        boolean z16;
        int i3 = context.getApplicationInfo().targetSdkVersion;
        boolean z17 = true;
        if (i3 <= 17) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.mAllowBrokenMeasureSpecs = z16;
        if (i3 < 18) {
            z17 = false;
        }
        this.mMeasureVerticalWithPaddingMargin = z17;
    }

    private void sortChildren() {
        int childCount = getChildCount();
        DittoArea[] dittoAreaArr = this.mSortedVerticalChildren;
        if (dittoAreaArr == null || dittoAreaArr.length != childCount) {
            this.mSortedVerticalChildren = new DittoArea[childCount];
        }
        DittoArea[] dittoAreaArr2 = this.mSortedHorizontalChildren;
        if (dittoAreaArr2 == null || dittoAreaArr2.length != childCount) {
            this.mSortedHorizontalChildren = new DittoArea[childCount];
        }
        DependencyGraph dependencyGraph = this.mGraph;
        dependencyGraph.clear();
        for (int i3 = 0; i3 < childCount; i3++) {
            dependencyGraph.add(getChildAt(i3));
        }
        dependencyGraph.getSortedViews(this.mSortedVerticalChildren, LayoutAttrDefine.RULES_VERTICAL);
        dependencyGraph.getSortedViews(this.mSortedHorizontalChildren, LayoutAttrDefine.RULES_HORIZONTAL);
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public int getSuggestedMinimumHeight() {
        Drawable drawable = this.mBackground;
        if (drawable == null) {
            return 0;
        }
        return Math.max(0, drawable.getMinimumHeight());
    }

    public int getSuggestedMinimumWidth() {
        Drawable drawable = this.mBackground;
        if (drawable == null) {
            return 0;
        }
        return Math.max(0, drawable.getMinimumWidth());
    }

    @Override // com.tencent.ditto.area.DittoArea
    public void onLayout(int i3, int i16, int i17, int i18) {
        int childCount = getChildCount();
        for (int i19 = 0; i19 < childCount; i19++) {
            DittoArea childAt = getChildAt(i19);
            if (childAt.getVisibility() != 8) {
                LayoutAttrSet layoutAttr = childAt.getLayoutAttr();
                childAt.layout(layoutAttr.left, layoutAttr.top, layoutAttr.right, layoutAttr.bottom);
            }
        }
        super.onLayout(i3, i16, i17, i18);
    }

    @Override // com.tencent.ditto.area.DittoArea
    public void onMeasure(int i3, int i16) {
        int i17;
        int i18;
        boolean z16;
        boolean z17;
        int i19;
        int max;
        sortChildren();
        int mode = View.MeasureSpec.getMode(i3);
        int mode2 = View.MeasureSpec.getMode(i16);
        int size = View.MeasureSpec.getSize(i3);
        int size2 = View.MeasureSpec.getSize(i16);
        if (mode == 0) {
            size = -1;
        }
        if (mode2 == 0) {
            size2 = -1;
        }
        if (mode == 1073741824) {
            i17 = size;
        } else {
            i17 = 0;
        }
        if (mode2 == 1073741824) {
            i18 = size2;
        } else {
            i18 = 0;
        }
        if (mode != 1073741824) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (mode2 != 1073741824) {
            z17 = true;
        } else {
            z17 = false;
        }
        DittoArea[] dittoAreaArr = this.mSortedHorizontalChildren;
        int length = dittoAreaArr.length;
        int i26 = 0;
        boolean z18 = false;
        while (true) {
            i19 = 8;
            if (i26 >= length) {
                break;
            }
            DittoArea dittoArea = dittoAreaArr[i26];
            if (dittoArea.getVisibility() != 8) {
                LayoutAttrSet layoutAttr = dittoArea.getLayoutAttr();
                applyHorizontalSizeRules(layoutAttr, size, layoutAttr.mAttrs);
                measureChildHorizontal(dittoArea, layoutAttr, size, size2);
                if (positionChildHorizontal(dittoArea, layoutAttr, size, z16)) {
                    z18 = true;
                }
            }
            i26++;
        }
        DittoArea[] dittoAreaArr2 = this.mSortedVerticalChildren;
        int length2 = dittoAreaArr2.length;
        int i27 = getContext().getApplicationInfo().targetSdkVersion;
        int i28 = 0;
        boolean z19 = false;
        while (i28 < length2) {
            DittoArea dittoArea2 = dittoAreaArr2[i28];
            if (dittoArea2.getVisibility() != i19) {
                LayoutAttrSet layoutAttr2 = dittoArea2.getLayoutAttr();
                applyVerticalSizeRules(layoutAttr2, size2);
                measureChild(dittoArea2, layoutAttr2, size, size2);
                if (positionChildVertical(dittoArea2, layoutAttr2, size2, z17)) {
                    z19 = true;
                }
                if (z16) {
                    if (i27 < 19) {
                        i17 = Math.max(i17, layoutAttr2.right);
                    } else {
                        i17 = Math.max(i17, layoutAttr2.right + layoutAttr2.rightMargin);
                    }
                }
                if (z17) {
                    if (i27 < 19) {
                        max = Math.max(i18, layoutAttr2.bottom);
                    } else {
                        max = Math.max(i18, layoutAttr2.bottom + layoutAttr2.bottomMargin);
                    }
                    i18 = max;
                }
            }
            i28++;
            i19 = 8;
        }
        if (z16) {
            int i29 = i17 + this.paddingRight;
            if (getLayoutAttr() != null && getLayoutAttr().width >= 0) {
                i29 = Math.max(i29, getLayoutAttr().width);
            }
            i17 = resolveSize(Math.max(i29, getSuggestedMinimumWidth()), i3);
            if (z18) {
                for (int i36 = 0; i36 < length2; i36++) {
                    DittoArea childAt = getChildAt(i36);
                    if (childAt.getVisibility() != 8) {
                        LayoutAttrSet layoutAttr3 = childAt.getLayoutAttr();
                        Map<String, Object> map = layoutAttr3.mAttrs;
                        if ((map.get(LayoutAttrDefine.CENTER_IN_PARENT) != null && ((Boolean) map.get(LayoutAttrDefine.CENTER_IN_PARENT)).booleanValue()) || (map.get(LayoutAttrDefine.CENTER_HORIZONTAL) != null && ((Boolean) map.get(LayoutAttrDefine.CENTER_HORIZONTAL)).booleanValue())) {
                            centerHorizontal(childAt, layoutAttr3, i17);
                        } else if (map.get(LayoutAttrDefine.ALIGN_PARENT_RIGHT) != null && ((Boolean) map.get(LayoutAttrDefine.ALIGN_PARENT_RIGHT)).booleanValue()) {
                            int measuredWidth = childAt.getMeasuredWidth();
                            int i37 = (i17 - this.paddingRight) - measuredWidth;
                            layoutAttr3.left = i37;
                            layoutAttr3.right = i37 + measuredWidth;
                        }
                    }
                }
            }
        }
        if (z17) {
            int i38 = i18 + this.paddingBottom;
            if (getLayoutAttr() != null && getLayoutAttr().height >= 0) {
                i38 = Math.max(i38, getLayoutAttr().height);
            }
            i18 = resolveSize(Math.max(i38, getSuggestedMinimumHeight()), i16);
            if (z19) {
                for (int i39 = 0; i39 < length2; i39++) {
                    DittoArea childAt2 = getChildAt(i39);
                    if (childAt2.getVisibility() != 8) {
                        LayoutAttrSet layoutAttr4 = childAt2.getLayoutAttr();
                        Map<String, Object> map2 = layoutAttr4.mAttrs;
                        if ((map2.get(LayoutAttrDefine.CENTER_IN_PARENT) != null && ((Boolean) map2.get(LayoutAttrDefine.CENTER_IN_PARENT)).booleanValue()) || (map2.get(LayoutAttrDefine.CENTER_VERTICAL) != null && ((Boolean) map2.get(LayoutAttrDefine.CENTER_VERTICAL)).booleanValue())) {
                            centerVertical(childAt2, layoutAttr4, i18);
                        } else if (map2.get(LayoutAttrDefine.ALIGN_PARENT_BOTTOM) != null && ((Boolean) map2.get(LayoutAttrDefine.ALIGN_PARENT_BOTTOM)).booleanValue()) {
                            int measuredHeight = childAt2.getMeasuredHeight();
                            int i46 = (i18 - this.paddingBottom) - measuredHeight;
                            layoutAttr4.top = i46;
                            layoutAttr4.bottom = i46 + measuredHeight;
                        }
                    }
                }
            }
        }
        setMeasuredDimension(i17, i18);
    }

    @Override // com.tencent.ditto.area.DittoArea, com.tencent.ditto.area.DittoElement
    public void requestLayout() {
        super.requestLayout();
        this.mDirtyHierarchy = true;
    }

    public void setOrientation(int i3) {
        if (this.mOrientation != i3) {
            this.mOrientation = i3;
            requestLayout();
        }
    }
}
