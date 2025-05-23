package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.layout.helper;

import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.layout.RelativeLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class RelativeLayoutHelper {
    private static final int VALUE_NOT_SET = Integer.MIN_VALUE;
    private Map<String, Node> keyNodes;
    private RelativeLayout parent;
    private List<ViewBase> subViews;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class Node {
        final List<Node> lastItem = new ArrayList();
        final List<Node> thisRuleNode = new ArrayList();
        ViewBase view;

        Node() {
        }
    }

    private static void centerHorizontal(ViewBase viewBase, RelativeLayout.Params params, int i3) {
        int comMeasuredWidth = viewBase.getComMeasuredWidth();
        if (comMeasuredWidth > i3) {
            comMeasuredWidth = i3;
        }
        int i16 = (i3 - comMeasuredWidth) / 2;
        params.mLeft = i16;
        params.mRight = i16 + comMeasuredWidth;
    }

    private static void centerVertical(ViewBase viewBase, RelativeLayout.Params params, int i3, boolean z16) {
        int comMeasuredHeight = viewBase.getComMeasuredHeight();
        if (z16 && comMeasuredHeight > i3) {
            i3 = comMeasuredHeight;
        }
        int i16 = (i3 - comMeasuredHeight) / 2;
        params.mTop = i16;
        params.mBottom = i16 + comMeasuredHeight;
    }

    private List<Node> findRoots(List<ViewBase> list, int[] iArr) {
        Node node;
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            Node node2 = this.keyNodes.get(list.get(i3).getName());
            String[] rule = ((RelativeLayout.Params) node2.view.getComLayoutParams()).getRule();
            for (int i16 : iArr) {
                String str = rule[i16];
                if (str != null && (node = this.keyNodes.get(str)) != null && node != node2) {
                    node.lastItem.add(node2);
                    node2.thisRuleNode.add(node);
                }
            }
        }
        Iterator<Map.Entry<String, Node>> it = this.keyNodes.entrySet().iterator();
        while (it.hasNext()) {
            Node value = it.next().getValue();
            if (value.thisRuleNode.isEmpty()) {
                arrayList.add(value);
            }
        }
        return arrayList;
    }

    private int getChildMeasureSpec(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        boolean z16;
        int i29;
        int i36;
        int i37 = 0;
        if (i28 < 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        int i38 = 1073741824;
        if (z16) {
            if (i3 != Integer.MIN_VALUE && i16 != Integer.MIN_VALUE) {
                i17 = Math.max(0, i16 - i3);
            } else if (i17 < 0) {
                i17 = 0;
                return View.MeasureSpec.makeMeasureSpec(i17, i37);
            }
            i37 = 1073741824;
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
        int i39 = i36 - i29;
        if (i3 != Integer.MIN_VALUE && i16 != Integer.MIN_VALUE) {
            if (z16) {
                i38 = 0;
            }
            i17 = Math.max(0, i39);
        } else if (i17 >= 0) {
            if (i39 >= 0) {
                i17 = Math.min(i39, i17);
            }
        } else if (i17 == -1) {
            if (z16) {
                i38 = 0;
            }
            i17 = Math.max(0, i39);
        } else {
            i17 = 0;
            return View.MeasureSpec.makeMeasureSpec(i17, i37);
        }
        i37 = i38;
        return View.MeasureSpec.makeMeasureSpec(i17, i37);
    }

    private static Map<String, Node> getNodes(List<ViewBase> list) {
        HashMap hashMap = new HashMap(list.size());
        ArrayList<ViewBase> arrayList = new ArrayList();
        for (ViewBase viewBase : list) {
            if (TextUtils.isEmpty(viewBase.getName())) {
                arrayList.add(viewBase);
            } else {
                Node node = new Node();
                node.view = viewBase;
                hashMap.put(viewBase.getName(), node);
            }
        }
        int i3 = 10000;
        for (ViewBase viewBase2 : arrayList) {
            Node node2 = new Node();
            node2.view = viewBase2;
            String valueOf = String.valueOf(i3);
            while (hashMap.containsKey(valueOf)) {
                i3++;
                valueOf = String.valueOf(i3);
            }
            viewBase2.setName(valueOf);
            hashMap.put(viewBase2.getName(), node2);
        }
        return hashMap;
    }

    private RelativeLayout.Params getRelatedViewParams(String[] strArr, int i3) {
        Node node;
        String str = strArr[i3];
        if (str == null || (node = this.keyNodes.get(str)) == null || node.view.isGone()) {
            return null;
        }
        return (RelativeLayout.Params) node.view.getComLayoutParams();
    }

    public static boolean hasVerticleCenterRule(RelativeLayout.Params params) {
        String[] rule = params.getRule();
        if (rule[10] == null && rule[8] == null) {
            return false;
        }
        return true;
    }

    private void initCheck() {
        RelativeLayout relativeLayout = this.parent;
        if (relativeLayout != null && this.subViews != null) {
            if (relativeLayout.getSubViews() != this.subViews || this.parent.getSubViews().size() != this.subViews.size()) {
                this.subViews = this.parent.getSubViews();
            }
            this.keyNodes = getNodes(this.subViews);
            return;
        }
        throw new IllegalArgumentException("subViews \u4e3a null");
    }

    private static void removeNode(List<Node> list, String str) {
        Node node;
        Iterator<Node> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                node = it.next();
                if (node.view.getName().equals(str)) {
                    break;
                }
            } else {
                node = null;
                break;
            }
        }
        list.remove(node);
    }

    public void applyHorizontalSizeRules(RelativeLayout.Params params, int i3) {
        String[] rule = params.getRule();
        params.mLeft = Integer.MIN_VALUE;
        params.mRight = Integer.MIN_VALUE;
        RelativeLayout.Params relatedViewParams = getRelatedViewParams(rule, 2);
        if (relatedViewParams != null) {
            params.mRight = relatedViewParams.mLeft - (relatedViewParams.mLayoutMarginLeft + params.mLayoutMarginRight);
        }
        RelativeLayout.Params relatedViewParams2 = getRelatedViewParams(rule, 3);
        if (relatedViewParams2 != null) {
            params.mLeft = relatedViewParams2.mRight + relatedViewParams2.mLayoutMarginRight + params.mLayoutMarginLeft;
        }
        if (rule[4] != null) {
            params.mLeft = this.parent.getComPaddingLeft() + params.mLayoutMarginLeft;
        }
        if (rule[5] != null && i3 >= 0) {
            params.mRight = (i3 - this.parent.getComPaddingRight()) - params.mLayoutMarginRight;
        }
    }

    public void applyVerticalSizeRules(RelativeLayout.Params params, int i3) {
        String[] rule = params.getRule();
        params.mTop = Integer.MIN_VALUE;
        params.mBottom = Integer.MIN_VALUE;
        RelativeLayout.Params relatedViewParams = getRelatedViewParams(rule, 0);
        if (relatedViewParams != null) {
            params.mBottom = relatedViewParams.mTop - (relatedViewParams.mLayoutMarginTop + params.mLayoutMarginBottom);
        } else if (params.alignWithParent && rule[0] != null && i3 >= 0) {
            params.mBottom = (i3 - this.parent.getComPaddingBottom()) - params.mLayoutMarginBottom;
        }
        RelativeLayout.Params relatedViewParams2 = getRelatedViewParams(rule, 1);
        if (relatedViewParams2 != null) {
            params.mTop = relatedViewParams2.mBottom + relatedViewParams2.mLayoutMarginBottom + params.mLayoutMarginTop;
        } else if (params.alignWithParent && rule[1] != null) {
            params.mTop = this.parent.getComPaddingTop() + params.mLayoutMarginTop;
        }
        if (rule[6] != null) {
            params.mTop = this.parent.getComPaddingTop() + params.mLayoutMarginTop;
        }
        if (rule[7] != null && i3 >= 0) {
            params.mBottom = (i3 - this.parent.getComPaddingBottom()) - params.mLayoutMarginBottom;
        }
    }

    public List<ViewBase> getHorizontalSortedView() {
        List<ViewBase> sortedViews = getSortedViews(RelativeLayout.Params.RULES_HORIZONTAL);
        ArrayList arrayList = new ArrayList();
        for (ViewBase viewBase : sortedViews) {
            if (viewBase.getComLayoutParams().mLayoutWidth == -1) {
                arrayList.add(viewBase);
            }
        }
        sortedViews.removeAll(arrayList);
        sortedViews.addAll(arrayList);
        return sortedViews;
    }

    public RelativeLayout getParent() {
        return this.parent;
    }

    public List<ViewBase> getSortedViews(int[] iArr) {
        initCheck();
        ArrayList arrayList = new ArrayList(this.subViews.size());
        List<Node> findRoots = findRoots(this.subViews, iArr);
        for (int i3 = 0; i3 < findRoots.size(); i3++) {
            Node node = findRoots.get(i3);
            ViewBase viewBase = node.view;
            String name = viewBase.getName();
            arrayList.add(viewBase);
            List<Node> list = node.lastItem;
            int size = list.size();
            for (int i16 = 0; i16 < size; i16++) {
                Node node2 = list.get(i16);
                List<Node> list2 = node2.thisRuleNode;
                removeNode(list2, name);
                if (list2.size() == 0) {
                    findRoots.add(node2);
                }
            }
        }
        findRoots.size();
        this.subViews.size();
        return arrayList;
    }

    public List<ViewBase> getVerticalSortedView() {
        List<ViewBase> sortedViews = getSortedViews(RelativeLayout.Params.RULES_VERTICAL);
        ArrayList arrayList = new ArrayList();
        for (ViewBase viewBase : sortedViews) {
            if (viewBase.getComLayoutParams().mLayoutHeight == -1) {
                arrayList.add(viewBase);
            }
        }
        sortedViews.removeAll(arrayList);
        sortedViews.addAll(arrayList);
        return sortedViews;
    }

    public void measureChild(ViewBase viewBase, RelativeLayout.Params params, int i3, int i16) {
        viewBase.measureComponent(getChildMeasureSpec(params.mLeft, params.mRight, params.mLayoutWidth, params.mLayoutMarginLeft, params.mLayoutMarginRight, this.parent.getComPaddingLeft(), this.parent.getComPaddingRight(), i3), getChildMeasureSpec(params.mTop, params.mBottom, params.mLayoutHeight, params.mLayoutMarginTop, params.mLayoutMarginBottom, this.parent.getComPaddingTop(), this.parent.getComPaddingBottom(), i16));
    }

    public void measureChildHorizontal(ViewBase viewBase, RelativeLayout.Params params, int i3, int i16) {
        int makeMeasureSpec;
        int childMeasureSpec = getChildMeasureSpec(params.mLeft, params.mRight, params.mLayoutWidth, params.mLayoutMarginLeft, params.mLayoutMarginRight, this.parent.getComPaddingLeft(), this.parent.getComPaddingRight(), i3);
        int i17 = 1073741824;
        if (i16 < 0) {
            int i18 = params.mLayoutHeight;
            if (i18 >= 0) {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i18, 1073741824);
            } else {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            }
        } else {
            int max = Math.max(0, (((i16 - this.parent.getComPaddingTop()) - this.parent.getComPaddingBottom()) - params.mLayoutMarginTop) - params.mLayoutMarginBottom);
            if (params.mLayoutHeight != -1) {
                i17 = Integer.MIN_VALUE;
            }
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(max, i17);
        }
        viewBase.measureComponent(childMeasureSpec, makeMeasureSpec);
    }

    public void positionChildHorizontal(ViewBase viewBase, RelativeLayout.Params params, int i3, boolean z16) {
        int comPaddingRight;
        int i16;
        String[] rule = params.getRule();
        int i17 = params.mLeft;
        if (i17 == Integer.MIN_VALUE && (i16 = params.mRight) != Integer.MIN_VALUE) {
            params.mLeft = i16 - viewBase.getComMeasuredWidth();
            int comPaddingLeft = this.parent.getComPaddingLeft() + params.mLayoutMarginLeft;
            if (params.mLeft < comPaddingLeft) {
                params.mLeft = comPaddingLeft;
                return;
            }
            return;
        }
        if (i17 != Integer.MIN_VALUE && params.mRight == Integer.MIN_VALUE) {
            params.mRight = i17 + viewBase.getComMeasuredWidth();
            if (i3 > 0 && params.mRight > (comPaddingRight = (i3 - this.parent.getComPaddingRight()) - params.mLayoutMarginRight)) {
                params.mRight = comPaddingRight;
                return;
            }
            return;
        }
        if (i17 == Integer.MIN_VALUE && params.mRight == Integer.MIN_VALUE) {
            if (rule[10] == null && rule[9] == null) {
                int comPaddingLeft2 = this.parent.getComPaddingLeft() + params.mLayoutMarginLeft;
                params.mLeft = comPaddingLeft2;
                params.mRight = comPaddingLeft2 + viewBase.getComMeasuredWidth();
            } else {
                if (!z16) {
                    centerHorizontal(viewBase, params, i3);
                    return;
                }
                int comPaddingLeft3 = this.parent.getComPaddingLeft() + params.mLayoutMarginLeft;
                params.mLeft = comPaddingLeft3;
                params.mRight = comPaddingLeft3 + viewBase.getComMeasuredWidth();
            }
        }
    }

    public boolean positionChildVertical(ViewBase viewBase, RelativeLayout.Params params, int i3, boolean z16) {
        int i16;
        String[] rule = params.getRule();
        int i17 = params.mTop;
        if (i17 == Integer.MIN_VALUE && (i16 = params.mBottom) != Integer.MIN_VALUE) {
            params.mTop = i16 - viewBase.getComMeasuredHeight();
        } else if (i17 != Integer.MIN_VALUE && params.mBottom == Integer.MIN_VALUE) {
            params.mBottom = i17 + viewBase.getComMeasuredHeight();
        } else if (i17 == Integer.MIN_VALUE && params.mBottom == Integer.MIN_VALUE) {
            if (hasVerticleCenterRule(params)) {
                if (z16 && i3 <= 0) {
                    int comPaddingTop = this.parent.getComPaddingTop() + params.mLayoutMarginTop;
                    params.mTop = comPaddingTop;
                    params.mBottom = comPaddingTop + viewBase.getComMeasuredHeight();
                } else {
                    centerVertical(viewBase, params, i3, z16);
                }
                return true;
            }
            int comPaddingTop2 = this.parent.getComPaddingTop() + params.mLayoutMarginTop;
            params.mTop = comPaddingTop2;
            params.mBottom = comPaddingTop2 + viewBase.getComMeasuredHeight();
        }
        if (rule[7] != null) {
            return true;
        }
        return false;
    }

    public void setParent(RelativeLayout relativeLayout) {
        this.parent = relativeLayout;
        List<ViewBase> subViews = relativeLayout.getSubViews();
        this.subViews = subViews;
        this.keyNodes = getNodes(subViews);
    }
}
