package com.qzone.reborn.intimate.block;

import android.os.Bundle;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.feedx.scroller.QZoneFeedPlayScroller;
import com.qzone.reborn.feedx.scroller.l;
import com.qzone.reborn.feedx.viewmodel.r;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.richframework.data.base.UIStateData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import nk.ar;
import we.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0005H\u0016J\b\u0010\r\u001a\u00020\u0005H\u0016J\u0012\u0010\u0010\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u0013\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u0005H\u0016J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u0010\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0014R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/qzone/reborn/intimate/block/QZoneIntimateFeedAdapter;", "Lwe/b;", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onCreateItemViewHolder", "holder", "position", "", "onBindViewHolder", "getItemCount", "Landroid/os/Bundle;", "initParams", "onInitBlock", "Lcom/tencent/biz/richframework/part/block/base/LoadInfo;", "loadInfo", "loadData", "loadMoreData", "getViewTypeCount", "getItemViewType", "", "Lhh/b;", "l0", "Lnk/ar;", "D", "Lnk/ar;", "mFeedViewModel", "<init>", "(Landroid/os/Bundle;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneIntimateFeedAdapter extends we.b<BusinessFeedData> {

    /* renamed from: D, reason: from kotlin metadata */
    private ar mFeedViewModel;

    public QZoneIntimateFeedAdapter(Bundle bundle) {
        super(bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return getDataList().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return com.qzone.reborn.feedx.itemview.d.a(getItem(position), position);
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public int getViewTypeCount() {
        return 10000;
    }

    @Override // we.b
    protected List<hh.b> l0() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new QZoneFeedPlayScroller());
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(LoadInfo loadInfo) {
        ar arVar = this.mFeedViewModel;
        if (arVar != null) {
            arVar.Q1();
        }
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadMoreData(LoadInfo loadInfo) {
        ar arVar = this.mFeedViewModel;
        if (arVar != null) {
            arVar.W1();
        }
    }

    @Override // we.b, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onBindViewHolder(holder, position);
        if (holder instanceof b.C11479b) {
            ((b.C11479b) holder).l(getItem(position), position);
        }
    }

    @Override // com.qzone.reborn.base.j
    public RecyclerView.ViewHolder onCreateItemViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return new b.C11479b(com.qzone.reborn.feedx.itemview.d.f(parent, viewType));
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle initParams) {
        ar arVar;
        MutableLiveData<UIStateData<List<BusinessFeedData>>> T1;
        r titleViewModel = (r) getViewModel(r.class);
        Intrinsics.checkNotNullExpressionValue(titleViewModel, "titleViewModel");
        j0(new l(titleViewModel));
        ar arVar2 = (ar) getViewModel(ar.class);
        this.mFeedViewModel = arVar2;
        if (arVar2 == null || k0() == null || (arVar = this.mFeedViewModel) == null || (T1 = arVar.T1()) == null) {
            return;
        }
        LifecycleOwner k06 = k0();
        Intrinsics.checkNotNull(k06);
        final Function1<UIStateData<List<? extends BusinessFeedData>>, Unit> function1 = new Function1<UIStateData<List<? extends BusinessFeedData>>, Unit>() { // from class: com.qzone.reborn.intimate.block.QZoneIntimateFeedAdapter$onInitBlock$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UIStateData<List<? extends BusinessFeedData>> uIStateData) {
                invoke2((UIStateData<List<BusinessFeedData>>) uIStateData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(UIStateData<List<BusinessFeedData>> uIStateData) {
                if (uIStateData == null || uIStateData.getIsLoadMore()) {
                    return;
                }
                QZoneIntimateFeedAdapter.this.o0();
            }
        };
        T1.observe(k06, new Observer() { // from class: com.qzone.reborn.intimate.block.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZoneIntimateFeedAdapter.r0(Function1.this, obj);
            }
        });
    }
}
