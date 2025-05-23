package com.qzone.reborn.feedx.block;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.feedx.scroller.QZoneFeedPlayScroller;
import com.tencent.biz.richframework.delegate.impl.RFWConfig;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.richframework.data.base.UIStateData;
import java.util.ArrayList;
import java.util.List;
import we.b;

/* compiled from: P */
/* loaded from: classes37.dex */
public class y extends we.b<BusinessFeedData> {
    public static boolean E = RFWConfig.getConfigValue("argus_qzone_feed", false);
    private com.qzone.reborn.feedx.viewmodel.q D;

    public y(Bundle bundle) {
        super(bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s0(int i3) {
        delete(i3);
        notifyItemRemoved(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t0(UIStateData uIStateData) {
        if (uIStateData.getIsLoadMore()) {
            return;
        }
        o0();
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return getDataList().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i3) {
        if (getDataList().size() > i3 && !TextUtils.isEmpty(getDataList().get(i3).getFeedCommInfo().feedskey)) {
            return getDataList().get(i3).getFeedCommInfo().feedskey.hashCode();
        }
        return super.getItemId(i3);
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
        arrayList.add(new hh.d());
        arrayList.add(new com.qzone.reborn.feedx.scroller.j());
        arrayList.add(new hh.a());
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(LoadInfo loadInfo) {
        if (loadInfo.isInitState()) {
            this.D.u2();
        } else if (loadInfo.isRefreshState()) {
            this.D.P1();
        }
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadMoreData(LoadInfo loadInfo) {
        this.D.f2();
    }

    @Override // we.b, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int i3) {
        try {
            super.onBindViewHolder(viewHolder, i3);
            if (viewHolder instanceof b.C11479b) {
                ((b.C11479b) viewHolder).l(getItem(i3), i3);
                if (E) {
                    return;
                }
                jm.b.f410600a.d(getActivity());
            }
        } catch (Throwable th5) {
            if (lm.a.f414989a.p(viewHolder.itemView)) {
                com.qzone.reborn.feedx.util.ag.f55738a.b(5, new Runnable() { // from class: com.qzone.reborn.feedx.block.x
                    @Override // java.lang.Runnable
                    public final void run() {
                        y.this.s0(i3);
                    }
                }, this.mRecyclerView);
                xe.b.f447841a.d(th5);
                return;
            }
            throw th5;
        }
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle bundle) {
        j0(new com.qzone.reborn.feedx.scroller.l((com.qzone.reborn.feedx.viewmodel.r) getViewModel(com.qzone.reborn.feedx.viewmodel.r.class)));
        j0(new com.qzone.reborn.feedx.scroller.k(12));
        com.qzone.reborn.feedx.viewmodel.q qVar = (com.qzone.reborn.feedx.viewmodel.q) getViewModel(com.qzone.reborn.feedx.viewmodel.q.class);
        this.D = qVar;
        if (qVar == null || k0() == null) {
            return;
        }
        this.D.T1().observe(k0(), new Observer() { // from class: com.qzone.reborn.feedx.block.w
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                y.this.t0((UIStateData) obj);
            }
        });
    }

    @Override // com.qzone.reborn.base.j
    /* renamed from: u0, reason: merged with bridge method [inline-methods] */
    public b.C11479b onCreateItemViewHolder(ViewGroup viewGroup, int i3) {
        return new b.C11479b(com.qzone.reborn.feedx.itemview.d.f(viewGroup, i3));
    }
}
