package com.qzone.reborn.feedpro.block;

import android.os.Bundle;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.reborn.feedpro.scroller.QzoneFeedProPlayScroller;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vd.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \"2\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001#B\u0011\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b \u0010!J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0014J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0018\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0005H\u0016J\b\u0010\u0018\u001a\u00020\u0005H\u0016J\b\u0010\u0019\u001a\u00020\u0005H\u0016J\u0010\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005H\u0016R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006$"}, d2 = {"Lcom/qzone/reborn/feedpro/block/f;", "Lvd/b;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "Lvd/b$b;", "q0", "Landroid/os/Bundle;", "bundle", "", "onInitBlock", "", "Lhh/b;", "l0", "Lcom/tencent/biz/richframework/part/block/base/LoadInfo;", "loadInfo", "loadData", "loadMoreData", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "position", "onBindViewHolder", "getItemCount", "getViewTypeCount", "getItemViewType", "Lcom/qzone/reborn/feedpro/viewmodel/i;", "D", "Lcom/qzone/reborn/feedpro/viewmodel/i;", "mDetailViewModel", "initParams", "<init>", "(Landroid/os/Bundle;)V", "E", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class f extends vd.b<CommonFeed> {

    /* renamed from: D, reason: from kotlin metadata */
    private com.qzone.reborn.feedpro.viewmodel.i mDetailViewModel;

    public f(Bundle bundle) {
        super(bundle);
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return getDataList().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return com.qzone.reborn.feedpro.itemview.c.a(getItem(position), position);
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public int getViewTypeCount() {
        return 10000;
    }

    @Override // vd.b
    protected List<hh.b> l0() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new QzoneFeedProPlayScroller());
        arrayList.add(new com.qzone.reborn.feedx.scroller.c());
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(LoadInfo loadInfo) {
        Intrinsics.checkNotNullParameter(loadInfo, "loadInfo");
        QLog.d("QzoneFeedProDetailBlock", 1, "loadData  refreshData");
        com.qzone.reborn.feedpro.viewmodel.i iVar = this.mDetailViewModel;
        if (iVar != null) {
            iVar.y2();
        }
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadMoreData(LoadInfo loadInfo) {
        Intrinsics.checkNotNullParameter(loadInfo, "loadInfo");
    }

    @Override // vd.b, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onBindViewHolder(holder, position);
        if (holder instanceof b.C11413b) {
            ((b.C11413b) holder).l(getItem(position), position);
        }
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle bundle) {
        this.mDetailViewModel = (com.qzone.reborn.feedpro.viewmodel.i) getViewModel(com.qzone.reborn.feedpro.viewmodel.i.class);
    }

    @Override // com.qzone.reborn.base.j
    /* renamed from: q0, reason: merged with bridge method [inline-methods] */
    public b.C11413b onCreateItemViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return new b.C11413b(com.qzone.reborn.feedpro.itemview.c.b(parent, viewType));
    }
}
