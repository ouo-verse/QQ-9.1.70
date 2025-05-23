package com.tencent.mtt.hippy.views.refresh;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.mtt.hippy.views.hippylist.HippyRecyclerView;
import com.tencent.mtt.hippy.views.view.HippyViewGroup;

/* loaded from: classes20.dex */
public class HippyPullFooterView extends HippyViewGroup {
    private View mRecyclerView;
    private boolean mStickEnabled;

    public HippyPullFooterView(Context context) {
        super(context);
        this.mStickEnabled = false;
    }

    public View getRecyclerView() {
        return this.mRecyclerView;
    }

    public boolean getStickEnabled() {
        return this.mStickEnabled;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onDestroy() {
        View view = this.mRecyclerView;
        if ((view instanceof HippyRecyclerView) && ((HippyRecyclerView) view).getAdapter() != null) {
            ((HippyRecyclerView) this.mRecyclerView).getAdapter().onFooterDestroy();
        }
    }

    public void setRecyclerView(@NonNull View view) {
        this.mRecyclerView = view;
    }

    public void setStickEnabled(boolean z16) {
        this.mStickEnabled = z16;
    }
}
