package fj;

import android.content.Context;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;

/* compiled from: P */
/* loaded from: classes38.dex */
public class d extends SafeLinearLayoutManager {

    /* compiled from: P */
    /* loaded from: classes38.dex */
    private static class a extends LinearSmoothScroller {
        a(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public int calculateDtToFit(int i3, int i16, int i17, int i18, int i19) {
            return (i17 + ((i18 - i17) / 2)) - (i3 + ((i16 - i3) / 2));
        }
    }

    public d(Context context, int i3, boolean z16) {
        super(context, i3, z16);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i3) {
        a aVar = new a(recyclerView.getContext());
        aVar.setTargetPosition(i3);
        startSmoothScroll(aVar);
    }
}
