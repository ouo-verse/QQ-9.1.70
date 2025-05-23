package com.qzone.reborn.feedx.block;

import android.os.Bundle;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.feedx.scroller.QZoneFeedPlayScroller;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import we.b;

/* compiled from: P */
/* loaded from: classes37.dex */
public class h extends we.b<BusinessFeedData> {
    private com.qzone.reborn.feedx.viewmodel.h D;

    public h(Bundle bundle) {
        super(bundle);
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return getDataList().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        return com.qzone.reborn.feedx.itemview.d.a(getItem(i3), i3);
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public int getViewTypeCount() {
        return 10000;
    }

    @Override // we.b
    protected List<hh.b> l0() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new QZoneFeedPlayScroller());
        arrayList.add(new com.qzone.reborn.feedx.scroller.c());
        return arrayList;
    }

    @Override // we.b, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        super.onBindViewHolder(viewHolder, i3);
        if (viewHolder instanceof b.C11479b) {
            ((b.C11479b) viewHolder).l(getItem(i3), i3);
        }
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle bundle) {
        this.D = (com.qzone.reborn.feedx.viewmodel.h) getViewModel(com.qzone.reborn.feedx.viewmodel.h.class);
    }

    @Override // com.qzone.reborn.base.j
    /* renamed from: q0, reason: merged with bridge method [inline-methods] */
    public b.C11479b onCreateItemViewHolder(ViewGroup viewGroup, int i3) {
        return new b.C11479b(com.qzone.reborn.feedx.itemview.d.f(viewGroup, i3));
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(LoadInfo loadInfo) {
        QLog.d("QZoneFeedxDetailAdapter", 1, "loadData  refreshData");
        this.D.K2();
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadMoreData(LoadInfo loadInfo) {
    }
}
