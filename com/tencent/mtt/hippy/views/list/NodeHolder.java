package com.tencent.mtt.hippy.views.list;

import com.tencent.mtt.hippy.uimanager.RenderNode;
import com.tencent.mtt.supportui.views.recyclerview.ContentHolder;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase;

/* compiled from: P */
/* loaded from: classes20.dex */
public class NodeHolder extends ContentHolder {
    public boolean isCreated = true;
    public RenderNode mBindNode;

    @Override // com.tencent.mtt.supportui.views.recyclerview.ContentHolder
    public void inTraversals(int i3, int i16, RecyclerViewBase recyclerViewBase) {
        super.inTraversals(i3, i16, recyclerViewBase);
        if (recyclerViewBase != null) {
            recyclerViewBase.handleInTraversal(i3, i16, this.mContentView);
        }
    }
}
