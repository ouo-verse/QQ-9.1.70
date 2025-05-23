package com.qzone.reborn.feedpro.block;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.reborn.feedpro.scroller.QzoneFeedProPlayScroller;
import com.qzone.reborn.feedpro.viewmodel.QzoneFeedProMoodListViewModel;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.richframework.data.base.UIStateData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import vd.b;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \"2\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001#B\u0011\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b \u0010!J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rH\u0014J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0012\u0010\u0013\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u0018\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0005H\u0016J\b\u0010\u0018\u001a\u00020\u0005H\u0016J\b\u0010\u0019\u001a\u00020\u0005H\u0016J\u0010\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005H\u0016R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006$"}, d2 = {"Lcom/qzone/reborn/feedpro/block/QzoneFeedProMoodListAdapter;", "Lvd/b;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "Lvd/b$b;", "r0", "Landroid/os/Bundle;", "bundle", "", "onInitBlock", "", "Lhh/b;", "l0", "Lcom/tencent/biz/richframework/part/block/base/LoadInfo;", "loadInfo", "loadData", "loadMoreData", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "position", "onBindViewHolder", "getItemCount", "getViewTypeCount", "getItemViewType", "Lcom/qzone/reborn/feedpro/viewmodel/QzoneFeedProMoodListViewModel;", "D", "Lcom/qzone/reborn/feedpro/viewmodel/QzoneFeedProMoodListViewModel;", "mFeedDataViewModel", "initParams", "<init>", "(Landroid/os/Bundle;)V", "E", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QzoneFeedProMoodListAdapter extends vd.b<CommonFeed> {

    /* renamed from: D, reason: from kotlin metadata */
    private QzoneFeedProMoodListViewModel mFeedDataViewModel;

    public QzoneFeedProMoodListAdapter(Bundle bundle) {
        super(bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(Function1 tmp0, Object obj) {
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
        arrayList.add(new com.qzone.reborn.feedpro.scroller.b());
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(LoadInfo loadInfo) {
        QzoneFeedProMoodListViewModel qzoneFeedProMoodListViewModel;
        Intrinsics.checkNotNullParameter(loadInfo, "loadInfo");
        if (loadInfo.isInitState()) {
            QzoneFeedProMoodListViewModel qzoneFeedProMoodListViewModel2 = this.mFeedDataViewModel;
            if (qzoneFeedProMoodListViewModel2 != null) {
                qzoneFeedProMoodListViewModel2.X1();
                return;
            }
            return;
        }
        if (!loadInfo.isRefreshState() || (qzoneFeedProMoodListViewModel = this.mFeedDataViewModel) == null) {
            return;
        }
        qzoneFeedProMoodListViewModel.X1();
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadMoreData(LoadInfo loadInfo) {
        QzoneFeedProMoodListViewModel qzoneFeedProMoodListViewModel = this.mFeedDataViewModel;
        if (qzoneFeedProMoodListViewModel != null) {
            qzoneFeedProMoodListViewModel.e2();
        }
    }

    @Override // vd.b, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onBindViewHolder(holder, position);
        if (holder instanceof b.C11413b) {
            ((b.C11413b) holder).l(getItem(position), position);
            jm.b bVar = jm.b.f410600a;
            Activity activity = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "getActivity()");
            bVar.d(activity);
        }
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle bundle) {
        com.qzone.reborn.feedx.viewmodel.r titleViewModel = (com.qzone.reborn.feedx.viewmodel.r) getViewModel(com.qzone.reborn.feedx.viewmodel.r.class);
        Intrinsics.checkNotNullExpressionValue(titleViewModel, "titleViewModel");
        j0(new com.qzone.reborn.feedx.scroller.l(titleViewModel));
        j0(new com.qzone.reborn.feedx.scroller.k(10));
        QzoneFeedProMoodListViewModel qzoneFeedProMoodListViewModel = (QzoneFeedProMoodListViewModel) getViewModel(QzoneFeedProMoodListViewModel.class);
        this.mFeedDataViewModel = qzoneFeedProMoodListViewModel;
        if (qzoneFeedProMoodListViewModel == null || k0() == null) {
            return;
        }
        QzoneFeedProMoodListViewModel qzoneFeedProMoodListViewModel2 = this.mFeedDataViewModel;
        Intrinsics.checkNotNull(qzoneFeedProMoodListViewModel2);
        MutableLiveData<UIStateData<List<CommonFeed>>> N1 = qzoneFeedProMoodListViewModel2.N1();
        LifecycleOwner k06 = k0();
        Intrinsics.checkNotNull(k06);
        final Function1<UIStateData<List<? extends CommonFeed>>, Unit> function1 = new Function1<UIStateData<List<? extends CommonFeed>>, Unit>() { // from class: com.qzone.reborn.feedpro.block.QzoneFeedProMoodListAdapter$onInitBlock$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UIStateData<List<? extends CommonFeed>> uIStateData) {
                invoke2((UIStateData<List<CommonFeed>>) uIStateData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(UIStateData<List<CommonFeed>> uIStateData) {
                if (uIStateData.getIsLoadMore()) {
                    return;
                }
                QzoneFeedProMoodListAdapter.this.o0();
            }
        };
        N1.observe(k06, new Observer() { // from class: com.qzone.reborn.feedpro.block.o
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QzoneFeedProMoodListAdapter.s0(Function1.this, obj);
            }
        });
    }

    @Override // com.qzone.reborn.base.j
    /* renamed from: r0, reason: merged with bridge method [inline-methods] */
    public b.C11413b onCreateItemViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return new b.C11413b(com.qzone.reborn.feedpro.itemview.c.b(parent, viewType));
    }
}
