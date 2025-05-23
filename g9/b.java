package g9;

import android.os.Bundle;
import android.view.ViewGroup;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.configx.g;
import com.qzone.reborn.feedx.scroller.QZoneFeedPlayScroller;
import com.qzone.reborn.feedx.scroller.j;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.richframework.data.base.UIStateData;
import java.util.ArrayList;
import java.util.List;
import we.b;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b extends we.b<BusinessFeedData> {
    private h9.a D;

    public b(Bundle bundle) {
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
        arrayList.add(new com.qzone.reborn.feedx.scroller.b());
        arrayList.add(new j());
        arrayList.add(new com.qzone.reborn.feedx.scroller.c());
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(LoadInfo loadInfo) {
        if (loadInfo.isInitState()) {
            this.D.r2();
        } else if (loadInfo.isRefreshState()) {
            this.D.P1();
        }
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadMoreData(LoadInfo loadInfo) {
        this.D.f2();
    }

    @Override // we.b, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        super.onBindViewHolder(viewHolder, i3);
        if (viewHolder instanceof b.C11479b) {
            ((b.C11479b) viewHolder).l(getItem(i3), i3);
            jm.b.f410600a.d(getActivity());
        }
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle bundle) {
        if (!g.f53821a.b().s()) {
            j0(new com.qzone.reborn.feedx.scroller.a());
        }
        h9.a aVar = (h9.a) getViewModel(h9.a.class);
        this.D = aVar;
        if (aVar == null || k0() == null) {
            return;
        }
        this.D.T1().observe(k0(), new Observer() { // from class: g9.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                b.this.r0((UIStateData) obj);
            }
        });
    }

    @Override // we.b, com.tencent.biz.richframework.part.block.MultiViewBlock, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        super.onViewAttachedToWindow(viewHolder);
    }

    @Override // we.b, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        super.onViewDetachedFromWindow(viewHolder);
    }

    @Override // com.qzone.reborn.base.j
    /* renamed from: s0, reason: merged with bridge method [inline-methods] */
    public b.C11479b onCreateItemViewHolder(ViewGroup viewGroup, int i3) {
        return new b.C11479b(com.qzone.reborn.feedx.itemview.d.f(viewGroup, i3));
    }
}
