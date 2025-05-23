package com.qzone.reborn.feedpro.block;

import android.os.Bundle;
import android.view.ViewGroup;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.reborn.feedpro.scroller.QzoneFeedProPlayScroller;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.richframework.data.base.UIStateData;
import java.util.ArrayList;
import java.util.List;
import vd.b;

/* compiled from: P */
/* loaded from: classes37.dex */
public class t extends vd.b<CommonFeed> {
    private com.qzone.reborn.feedpro.viewmodel.m D;

    public t(Bundle bundle) {
        super(bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r0(UIStateData uIStateData) {
        if (uIStateData.getIsLoadMore()) {
            return;
        }
        o0();
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return getDataList().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        return com.qzone.reborn.feedpro.itemview.c.a(getItem(i3), i3);
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public int getViewTypeCount() {
        return 10000;
    }

    @Override // vd.b
    protected List<hh.b> l0() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.qzone.reborn.feedx.scroller.l((com.qzone.reborn.feedpro.viewmodel.n) getViewModel(com.qzone.reborn.feedpro.viewmodel.n.class)));
        arrayList.add(new QzoneFeedProPlayScroller());
        arrayList.add(new com.qzone.reborn.feedpro.scroller.b());
        arrayList.add(new com.qzone.reborn.feedx.scroller.c());
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(LoadInfo loadInfo) {
        if (loadInfo.isInitState()) {
            this.D.a2();
        } else {
            if (!loadInfo.isRefreshState() || this.D.getIsTimeLineClick()) {
                return;
            }
            this.D.a2();
        }
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadMoreData(LoadInfo loadInfo) {
        this.D.s2();
    }

    @Override // vd.b, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        super.onBindViewHolder(viewHolder, i3);
        if (viewHolder instanceof b.C11413b) {
            ((b.C11413b) viewHolder).l(getItem(i3), i3);
            jm.b.f410600a.d(getActivity());
        }
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle bundle) {
        j0(new com.qzone.reborn.feedx.scroller.l((com.qzone.reborn.feedx.viewmodel.r) getViewModel(com.qzone.reborn.feedx.viewmodel.r.class)));
        j0(new com.qzone.reborn.feedx.scroller.k(2));
        com.qzone.reborn.feedpro.viewmodel.m mVar = (com.qzone.reborn.feedpro.viewmodel.m) getViewModel(com.qzone.reborn.feedpro.viewmodel.m.class);
        this.D = mVar;
        if (mVar == null || k0() == null) {
            return;
        }
        this.D.N1().observe(k0(), new Observer() { // from class: com.qzone.reborn.feedpro.block.s
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                t.this.r0((UIStateData) obj);
            }
        });
    }

    @Override // com.qzone.reborn.base.j
    /* renamed from: s0, reason: merged with bridge method [inline-methods] */
    public b.C11413b onCreateItemViewHolder(ViewGroup viewGroup, int i3) {
        return new b.C11413b(com.qzone.reborn.feedpro.itemview.c.b(viewGroup, i3));
    }
}
