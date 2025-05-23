package com.tencent.biz.pubaccount.weishi.drama;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.widget.pull2refresh.BaseAdapter;
import com.tencent.widget.pull2refresh.BaseViewHolder;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class a extends BaseAdapter<mz.d, BaseViewHolder<mz.d>> {

    /* renamed from: d, reason: collision with root package name */
    private boolean f80676d;

    /* renamed from: e, reason: collision with root package name */
    private final WSDramaPageFragment f80677e;

    /* renamed from: f, reason: collision with root package name */
    private WSPlayerManager f80678f;

    /* renamed from: h, reason: collision with root package name */
    private pz.b f80679h;

    public a(Context context, WSDramaPageFragment wSDramaPageFragment) {
        super(context);
        this.f80677e = wSDramaPageFragment;
    }

    @Override // com.tencent.widget.pull2refresh.BaseAdapter
    public int getCustomItemViewType(int i3) {
        return 0;
    }

    @Override // com.tencent.widget.pull2refresh.HeaderAndFooterAdapter
    public void onBindCustomViewHolder(BaseViewHolder<mz.d> baseViewHolder, int i3) {
        x.j("WSDramaPageAdapterLog", "[WSDramaPageAdapter.java][onBindCustomViewHolder] position:" + i3 + ", holder:" + baseViewHolder);
        mz.d item = getItem(i3);
        if (item == null) {
            return;
        }
        baseViewHolder.bindData(item);
        if (this.f80676d || i3 != 0) {
            return;
        }
        this.f80676d = true;
        this.f80677e.Y9(baseViewHolder);
    }

    @Override // com.tencent.widget.pull2refresh.HeaderAndFooterAdapter
    public BaseViewHolder<mz.d> onCreateCustomViewHolder(ViewGroup viewGroup, int i3) {
        return pz.f.a(viewGroup, i3, this.f80677e);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        int childCount = recyclerView.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            pz.a aVar = (pz.a) recyclerView.getChildViewHolder(recyclerView.getChildAt(i3));
            if (aVar != null) {
                aVar.f428077e.recycle();
            }
        }
    }

    public void p(List<mz.d> list) {
        List<mz.d> dataList = getDataList();
        if (dataList == null || !dataList.addAll(list)) {
            return;
        }
        notifyItemRangeChanged(dataList.size() - list.size(), list.size());
    }

    public WSPlayerManager q() {
        return this.f80678f;
    }

    public pz.b r() {
        return this.f80679h;
    }

    public void s(BaseViewHolder<mz.d> baseViewHolder, int i3) {
        if (baseViewHolder instanceof pz.a) {
            ((pz.a) baseViewHolder).e(i3);
        }
        if (baseViewHolder instanceof pz.b) {
            t((pz.b) baseViewHolder);
        }
    }

    public void t(pz.b bVar) {
        x();
        u(bVar);
    }

    public void u(pz.b bVar) {
        this.f80679h = bVar;
        this.f80678f.L0(bVar.i(), false);
        kz.c.d().j(bVar.i());
        kz.c.d().i(this.f80679h.f428078f);
    }

    public void v(WSPlayerManager wSPlayerManager) {
        this.f80678f = wSPlayerManager;
        f fVar = new f();
        fVar.j(this.f80677e);
        wSPlayerManager.X(fVar);
    }

    public void w(pz.b bVar) {
        this.f80679h = bVar;
    }

    public void x() {
        this.f80678f.Y0();
    }
}
