package androidx.recyclerview.widget;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mtt.hippy.views.hippylistpager.HippyRecyclerPagerView;

/* loaded from: classes.dex */
public class HippyPagerLinearLayoutManager extends HippyLinearLayoutManager {
    public HippyPagerLinearLayoutManager(Context context) {
        super(context);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    protected int getExtraLayoutSpace(RecyclerView.State state) {
        int i3;
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView instanceof HippyRecyclerPagerView) {
            i3 = ((HippyRecyclerPagerView) recyclerView).getPreCreateRowsNumber();
        } else {
            i3 = 0;
        }
        return this.mRecyclerView.getHeight() * i3;
    }
}
