package com.tencent.biz.pubaccount.weishi.drama.gallery;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi.drama.WSDramaMiddlePart;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.widget.pull2refresh.BaseViewHolder;
import lz.d;

/* compiled from: P */
/* loaded from: classes32.dex */
public class WSDramaGalleryAdapter extends d<mz.d, a> {

    /* renamed from: i, reason: collision with root package name */
    private final String f80692i;

    public WSDramaGalleryAdapter(WSDramaMiddlePart wSDramaMiddlePart, RecyclerView recyclerView) {
        super(wSDramaMiddlePart.o(), recyclerView);
        this.f80692i = wSDramaMiddlePart.getFrom();
    }

    @Override // com.tencent.widget.pull2refresh.BaseAdapter
    public int getCustomItemViewType(int i3) {
        return 0;
    }

    @Override // com.tencent.widget.pull2refresh.HeaderAndFooterAdapter
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public void onBindCustomViewHolder(a aVar, int i3) {
        aVar.bindData((mz.d) getDataList().get(i3));
    }

    @Override // com.tencent.widget.pull2refresh.HeaderAndFooterAdapter
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public a onCreateCustomViewHolder(ViewGroup viewGroup, int i3) {
        return new a(viewGroup, this.f80692i, this);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void onViewAttachedToWindow(final BaseViewHolder<mz.d> baseViewHolder) {
        super.onViewAttachedToWindow(baseViewHolder);
        baseViewHolder.itemView.post(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.drama.gallery.WSDramaGalleryAdapter.1
            @Override // java.lang.Runnable
            public void run() {
                int findLastVisibleItemPosition = WSDramaGalleryAdapter.this.q().findLastVisibleItemPosition();
                int adapterPosition = baseViewHolder.getAdapterPosition();
                x.i("WSAbsSingleCheckAdapter-nel-log", "[WSDramaGalleryAdapter.java][onViewAttachedToWindow] currPosition:" + adapterPosition + ", lastVisibleItemPosition:" + findLastVisibleItemPosition);
                BaseViewHolder baseViewHolder2 = baseViewHolder;
                if (!(baseViewHolder2 instanceof a) || adapterPosition > findLastVisibleItemPosition) {
                    return;
                }
                a aVar = (a) baseViewHolder2;
                aVar.k(aVar);
            }
        });
    }
}
