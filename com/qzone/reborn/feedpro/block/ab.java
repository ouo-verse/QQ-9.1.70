package com.qzone.reborn.feedpro.block;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.reborn.feedpro.scroller.QzoneFeedProPlayScroller;
import com.qzone.reborn.feedx.util.ag;
import com.tencent.biz.richframework.delegate.impl.RFWConfig;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.util.CommonFeedExtKt;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.richframework.data.base.UIStateData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vd.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 $2\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001%B\u0011\u0012\b\u0010!\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b\"\u0010#J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0014J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\u0010\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0018\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\b\u0010\u001a\u001a\u00020\u0005H\u0016J\b\u0010\u001b\u001a\u00020\u0005H\u0016J\u0010\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005H\u0016R\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006&"}, d2 = {"Lcom/qzone/reborn/feedpro/block/ab;", "Lvd/b;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "Lvd/b$b;", "t0", "Landroid/os/Bundle;", "bundle", "", "onInitBlock", "", "Lhh/b;", "l0", "position", "", "getItemId", "Lcom/tencent/biz/richframework/part/block/base/LoadInfo;", "loadInfo", "loadData", "loadMoreData", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "onBindViewHolder", "getItemCount", "getViewTypeCount", "getItemViewType", "Lcom/qzone/reborn/feedpro/viewmodel/p;", "D", "Lcom/qzone/reborn/feedpro/viewmodel/p;", "mFeedDataViewModel", "initParams", "<init>", "(Landroid/os/Bundle;)V", "E", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class ab extends vd.b<CommonFeed> {
    private static boolean F = RFWConfig.getConfigValue("argus_qzone_feed", false);

    /* renamed from: D, reason: from kotlin metadata */
    private com.qzone.reborn.feedpro.viewmodel.p mFeedDataViewModel;

    public ab(Bundle bundle) {
        super(bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(ab this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.delete(i3);
        this$0.notifyItemRemoved(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(ab this$0, UIStateData listUIStateData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(listUIStateData, "listUIStateData");
        if (listUIStateData.getIsLoadMore()) {
            return;
        }
        this$0.o0();
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return getDataList().size();
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0027, code lost:
    
        if ((r0.length() > 0) == true) goto L15;
     */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long getItemId(int position) {
        boolean z16;
        if (getDataList().size() > position) {
            CommonFeed commonFeed = getDataList().get(position);
            if (commonFeed != null && (r0 = CommonFeedExtKt.getFeedUniqueKey(commonFeed)) != null) {
                z16 = true;
            }
            z16 = false;
            if (z16) {
                CommonFeed commonFeed2 = getDataList().get(position);
                return (commonFeed2 != null ? CommonFeedExtKt.getFeedUniqueKey(commonFeed2) : null) != null ? r4.hashCode() : 0;
            }
        }
        return super.getItemId(position);
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
        com.qzone.reborn.feedpro.viewmodel.n titleViewModel = (com.qzone.reborn.feedpro.viewmodel.n) getViewModel(com.qzone.reborn.feedpro.viewmodel.n.class);
        Intrinsics.checkNotNullExpressionValue(titleViewModel, "titleViewModel");
        arrayList.add(new com.qzone.reborn.feedx.scroller.l(titleViewModel));
        arrayList.add(new com.qzone.reborn.feedx.scroller.k(12));
        arrayList.add(new QzoneFeedProPlayScroller());
        arrayList.add(new com.qzone.reborn.feedx.scroller.c());
        arrayList.add(new com.qzone.reborn.feedpro.scroller.b());
        arrayList.add(new hh.a());
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(LoadInfo loadInfo) {
        com.qzone.reborn.feedpro.viewmodel.p pVar;
        Intrinsics.checkNotNullParameter(loadInfo, "loadInfo");
        if (loadInfo.isInitState()) {
            com.qzone.reborn.feedpro.viewmodel.p pVar2 = this.mFeedDataViewModel;
            if (pVar2 != null) {
                pVar2.Z1();
                return;
            }
            return;
        }
        if (!loadInfo.isRefreshState() || (pVar = this.mFeedDataViewModel) == null) {
            return;
        }
        pVar.a2();
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadMoreData(LoadInfo loadInfo) {
        Intrinsics.checkNotNullParameter(loadInfo, "loadInfo");
        com.qzone.reborn.feedpro.viewmodel.p pVar = this.mFeedDataViewModel;
        if (pVar != null) {
            pVar.d2();
        }
    }

    @Override // vd.b, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        try {
            super.onBindViewHolder(holder, position);
            if (holder instanceof b.C11413b) {
                ((b.C11413b) holder).l(getItem(position), position);
                if (F) {
                    return;
                }
                jm.b bVar = jm.b.f410600a;
                Activity activity = getActivity();
                Intrinsics.checkNotNullExpressionValue(activity, "activity");
                bVar.d(activity);
            }
        } catch (Throwable th5) {
            if (lm.a.f414989a.p(holder.itemView)) {
                ag.f55738a.b(5, new Runnable() { // from class: com.qzone.reborn.feedpro.block.aa
                    @Override // java.lang.Runnable
                    public final void run() {
                        ab.s0(ab.this, position);
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
        com.qzone.reborn.feedpro.viewmodel.p pVar = (com.qzone.reborn.feedpro.viewmodel.p) getViewModel(com.qzone.reborn.feedpro.viewmodel.p.class);
        this.mFeedDataViewModel = pVar;
        if (pVar == null || k0() == null) {
            return;
        }
        com.qzone.reborn.feedpro.viewmodel.p pVar2 = this.mFeedDataViewModel;
        Intrinsics.checkNotNull(pVar2);
        MutableLiveData<UIStateData<List<CommonFeed>>> N1 = pVar2.N1();
        LifecycleOwner k06 = k0();
        Intrinsics.checkNotNull(k06);
        N1.observe(k06, new Observer() { // from class: com.qzone.reborn.feedpro.block.z
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ab.u0(ab.this, (UIStateData) obj);
            }
        });
    }

    @Override // com.qzone.reborn.base.j
    /* renamed from: t0, reason: merged with bridge method [inline-methods] */
    public b.C11413b onCreateItemViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return new b.C11413b(com.qzone.reborn.feedpro.itemview.c.b(parent, viewType));
    }
}
