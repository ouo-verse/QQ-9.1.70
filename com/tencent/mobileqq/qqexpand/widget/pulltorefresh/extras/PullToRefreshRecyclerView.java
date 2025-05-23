package com.tencent.mobileqq.qqexpand.widget.pulltorefresh.extras;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.qqexpand.widget.pulltorefresh.PullToRefreshBase;

/* loaded from: classes16.dex */
public class PullToRefreshRecyclerView extends PullToRefreshBase<RecyclerView> {
    public PullToRefreshRecyclerView(Context context) {
        super(context);
    }

    private int U() {
        View childAt = ((RecyclerView) this.f264230f).getChildAt(0);
        if (childAt != null) {
            return ((RecyclerView) this.f264230f).getChildPosition(childAt);
        }
        return -1;
    }

    private int V() {
        View childAt = ((RecyclerView) this.f264230f).getChildAt(((RecyclerView) r0).getChildCount() - 1);
        if (childAt != null) {
            return ((RecyclerView) this.f264230f).getChildPosition(childAt);
        }
        return -1;
    }

    private boolean W() {
        RecyclerView.Adapter adapter = s().getAdapter();
        if (adapter == null || adapter.getItemCount() == 0) {
            return true;
        }
        if (U() == 0 && ((RecyclerView) this.f264230f).getChildAt(0).getTop() >= ((RecyclerView) this.f264230f).getTop()) {
            return true;
        }
        return false;
    }

    private boolean X() {
        RecyclerView.Adapter adapter = s().getAdapter();
        if (adapter == null || adapter.getItemCount() == 0) {
            return true;
        }
        if (V() < ((RecyclerView) this.f264230f).getAdapter().getItemCount() - 1) {
            return false;
        }
        T t16 = this.f264230f;
        if (((RecyclerView) t16).getChildAt(((RecyclerView) t16).getChildCount() - 1).getBottom() <= ((RecyclerView) this.f264230f).getBottom()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qqexpand.widget.pulltorefresh.PullToRefreshBase
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public RecyclerView i(Context context, AttributeSet attributeSet) {
        return new RecyclerView(context, attributeSet);
    }

    @Override // com.tencent.mobileqq.qqexpand.widget.pulltorefresh.PullToRefreshBase
    public final PullToRefreshBase.Orientation q() {
        return PullToRefreshBase.Orientation.VERTICAL;
    }

    @Override // com.tencent.mobileqq.qqexpand.widget.pulltorefresh.PullToRefreshBase
    protected boolean y() {
        return X();
    }

    @Override // com.tencent.mobileqq.qqexpand.widget.pulltorefresh.PullToRefreshBase
    protected boolean z() {
        return W();
    }

    public PullToRefreshRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
