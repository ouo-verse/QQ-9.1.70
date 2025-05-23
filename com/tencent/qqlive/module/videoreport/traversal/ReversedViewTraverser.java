package com.tencent.qqlive.module.videoreport.traversal;

import android.view.ViewGroup;

/* compiled from: P */
/* loaded from: classes22.dex */
public class ReversedViewTraverser extends ViewTraverser {

    /* compiled from: P */
    /* loaded from: classes22.dex */
    private static class InstanceHolder {
        static final ReversedViewTraverser INSTANCE = new ReversedViewTraverser();

        InstanceHolder() {
        }
    }

    public static ReversedViewTraverser getInstance() {
        return InstanceHolder.INSTANCE;
    }

    @Override // com.tencent.qqlive.module.videoreport.traversal.ViewTraverser
    protected int getChildEndIndex(ViewGroup viewGroup) {
        return -1;
    }

    @Override // com.tencent.qqlive.module.videoreport.traversal.ViewTraverser
    protected int getChildStartIndex(ViewGroup viewGroup) {
        return viewGroup.getChildCount() - 1;
    }

    @Override // com.tencent.qqlive.module.videoreport.traversal.ViewTraverser
    protected int getNextChildIndex(int i3) {
        return i3 - 1;
    }

    ReversedViewTraverser() {
    }
}
