package com.tencent.biz.qqcircle.richframework.widget.looplist;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b extends RecyclerView.Adapter {
    private RecyclerView.Adapter C;

    /* renamed from: m, reason: collision with root package name */
    private LoopLayoutManagerHelper f92169m;

    public b(LoopLayoutManagerHelper loopLayoutManagerHelper, RecyclerView.Adapter adapter) {
        this.C = adapter;
        this.f92169m = loopLayoutManagerHelper;
    }

    private int i0(int i3) {
        if (k0()) {
            return j0(i3);
        }
        return i3;
    }

    private boolean k0() {
        return this.f92169m.g();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (((IAppSettingApi) QRoute.api(IAppSettingApi.class)).enableTalkBack()) {
            return this.C.getItemCount();
        }
        if (k0() && this.C.getItemCount() != 0) {
            return Integer.MAX_VALUE;
        }
        return this.C.getItemCount();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i3) {
        return this.C.getItemId(i0(i3));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        return this.C.getItemViewType(i0(i3));
    }

    public int j0(int i3) {
        int itemCount = this.C.getItemCount();
        if (itemCount == 0) {
            return -1;
        }
        if (i3 >= itemCount) {
            return i3 % itemCount;
        }
        return i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        this.C.onBindViewHolder(viewHolder, i0(i3));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
        return this.C.onCreateViewHolder(viewGroup, i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void registerAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
        super.registerAdapterDataObserver(adapterDataObserver);
        this.C.registerAdapterDataObserver(adapterDataObserver);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void setHasStableIds(boolean z16) {
        super.setHasStableIds(z16);
        this.C.setHasStableIds(z16);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void unregisterAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
        super.unregisterAdapterDataObserver(adapterDataObserver);
        this.C.unregisterAdapterDataObserver(adapterDataObserver);
    }
}
