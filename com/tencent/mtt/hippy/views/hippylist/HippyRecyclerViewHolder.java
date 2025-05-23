package com.tencent.mtt.hippy.views.hippylist;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mtt.hippy.uimanager.ListItemRenderNode;

/* compiled from: P */
/* loaded from: classes20.dex */
public class HippyRecyclerViewHolder extends RecyclerView.ViewHolder {
    public ListItemRenderNode bindNode;

    public HippyRecyclerViewHolder(@NonNull View view, ListItemRenderNode listItemRenderNode) {
        super(view);
        this.bindNode = listItemRenderNode;
    }

    public boolean isRenderDeleted() {
        ListItemRenderNode listItemRenderNode = this.bindNode;
        if (listItemRenderNode != null) {
            return listItemRenderNode.isDelete();
        }
        return false;
    }
}
