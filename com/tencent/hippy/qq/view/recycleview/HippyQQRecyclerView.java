package com.tencent.hippy.qq.view.recycleview;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mtt.hippy.views.hippylist.HippyRecyclerView;

/* compiled from: P */
/* loaded from: classes7.dex */
public class HippyQQRecyclerView extends HippyRecyclerView {
    public HippyQQRecyclerView(Context context) {
        super(context);
    }

    @Override // com.tencent.mtt.hippy.views.hippylist.HippyRecyclerView, androidx.recyclerview.widget.RecyclerView
    public void setAdapter(RecyclerView.Adapter adapter) {
        if (adapter != null) {
            adapter.setHasStableIds(true);
        }
        super.setAdapter(adapter);
    }
}
