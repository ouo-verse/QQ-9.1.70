package com.tencent.mtt.hippy.views.refresh;

import android.content.Context;
import android.view.View;
import com.tencent.mtt.hippy.views.hippylist.HippyRecyclerView;
import com.tencent.mtt.hippy.views.view.HippyViewGroup;

/* loaded from: classes20.dex */
public class HippyPullHeaderView extends HippyViewGroup {
    private View mRecyclerView;

    public HippyPullHeaderView(Context context) {
        super(context);
    }

    public View getRecyclerView() {
        return this.mRecyclerView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onDestroy() {
        View view = this.mRecyclerView;
        if ((view instanceof HippyRecyclerView) && ((HippyRecyclerView) view).getAdapter() != null) {
            ((HippyRecyclerView) this.mRecyclerView).getAdapter().onHeaderDestroy();
        }
    }

    public void setRecyclerView(View view) {
        this.mRecyclerView = view;
    }
}
