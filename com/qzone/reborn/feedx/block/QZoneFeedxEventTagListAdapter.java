package com.qzone.reborn.feedx.block;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.feedx.scroller.QZoneFeedPlayScroller;
import com.qzone.reborn.feedx.util.QZoneFeedEventTagItemViewFactory;
import com.qzone.reborn.feedx.viewmodel.QZoneFeedxEventTagViewModel;
import com.qzone.reborn.feedx.widget.eventtag.QZoneEventTagBaseItemView;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 /2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u000201B\u0011\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0004\b-\u0010.J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0005H\u0016J\b\u0010\r\u001a\u00020\u0005H\u0016J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005H\u0016J\u0012\u0010\u0012\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0014J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u0012\u0010\u001a\u001a\u00020\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u001b\u001a\u00020\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u0018\u0010\u001d\u001a\u00020\u000b2\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0013H\u0016J\u0006\u0010\u001e\u001a\u00020\u000bJ(\u0010&\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!2\u0006\u0010\u0004\u001a\u00020#2\u0006\u0010%\u001a\u00020$H\u0014J\b\u0010'\u001a\u00020\u0005H\u0016J\u0010\u0010(\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0016R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+\u00a8\u00062"}, d2 = {"Lcom/qzone/reborn/feedx/block/QZoneFeedxEventTagListAdapter;", "Lwe/b;", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onCreateItemViewHolder", "holder", "position", "", "onBindViewHolder", "getItemCount", "localPos", "getSpanCount", "Landroid/os/Bundle;", "initParams", "onInitBlock", "", "Lhh/b;", "l0", "", "getItemId", "Lcom/tencent/biz/richframework/part/block/base/LoadInfo;", "loadInfo", "loadData", "loadMoreData", "list", "setDatas", "u0", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "getItemOffsets", "getViewTypeCount", "getItemViewType", "Lcom/qzone/reborn/feedx/viewmodel/QZoneFeedxEventTagViewModel;", "D", "Lcom/qzone/reborn/feedx/viewmodel/QZoneFeedxEventTagViewModel;", "mFeedViewModel", "<init>", "(Landroid/os/Bundle;)V", "E", "a", "b", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneFeedxEventTagListAdapter extends we.b<BusinessFeedData> {

    /* renamed from: E, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int F = ViewUtils.dpToPx(3.5f);

    /* renamed from: D, reason: from kotlin metadata */
    private QZoneFeedxEventTagViewModel mFeedViewModel;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/qzone/reborn/feedx/block/QZoneFeedxEventTagListAdapter$a;", "", "", "SPACE_SIDE_MARGIN", "I", "a", "()I", "", "NOTIFY_DELAY_TIME", "J", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.reborn.feedx.block.QZoneFeedxEventTagListAdapter$a, reason: from kotlin metadata */
    /* loaded from: classes37.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return QZoneFeedxEventTagListAdapter.F;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\f"}, d2 = {"Lcom/qzone/reborn/feedx/block/QZoneFeedxEventTagListAdapter$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", "", "position", "", "l", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b extends RecyclerView.ViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
        }

        public final void l(BusinessFeedData feedData, int position) {
            Intrinsics.checkNotNullParameter(feedData, "feedData");
            View view = this.itemView;
            if (view instanceof QZoneEventTagBaseItemView) {
                Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.qzone.reborn.feedx.widget.eventtag.QZoneEventTagBaseItemView");
                ((QZoneEventTagBaseItemView) view).setData(feedData, position);
            }
        }
    }

    public QZoneFeedxEventTagListAdapter(Bundle bundle) {
        super(bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v0(QZoneFeedxEventTagListAdapter this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.notifyDataSetChanged();
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return getDataList().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        return position;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(outRect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        super.getItemOffsets(outRect, view, parent, state);
        int i3 = F;
        outRect.left = i3;
        outRect.right = i3;
        outRect.top = i3;
        outRect.bottom = i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        QZoneFeedEventTagItemViewFactory qZoneFeedEventTagItemViewFactory = QZoneFeedEventTagItemViewFactory.f55699a;
        BusinessFeedData item = getItem(position);
        Intrinsics.checkNotNullExpressionValue(item, "getItem(position)");
        return qZoneFeedEventTagItemViewFactory.b(item).getType();
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public int getSpanCount(int localPos) {
        return 2;
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public int getViewTypeCount() {
        return QZoneFeedEventTagItemViewFactory.f55699a.c();
    }

    @Override // we.b
    protected List<hh.b> l0() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new QZoneFeedPlayScroller());
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadMoreData(LoadInfo loadInfo) {
        QZoneFeedxEventTagViewModel qZoneFeedxEventTagViewModel = this.mFeedViewModel;
        if (qZoneFeedxEventTagViewModel != null) {
            qZoneFeedxEventTagViewModel.f2();
        }
    }

    @Override // we.b, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof b) {
            BusinessFeedData item = getItem(position);
            Intrinsics.checkNotNullExpressionValue(item, "getItem(position)");
            ((b) holder).l(item, position);
        }
    }

    @Override // com.qzone.reborn.base.j
    public RecyclerView.ViewHolder onCreateItemViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return new b(QZoneFeedEventTagItemViewFactory.f55699a.a(parent, viewType));
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle initParams) {
        QZoneFeedxEventTagViewModel qZoneFeedxEventTagViewModel;
        MutableLiveData<UIStateData<List<BusinessFeedData>>> x26;
        com.qzone.reborn.feedx.viewmodel.r titleViewModel = (com.qzone.reborn.feedx.viewmodel.r) getViewModel(com.qzone.reborn.feedx.viewmodel.r.class);
        Intrinsics.checkNotNullExpressionValue(titleViewModel, "titleViewModel");
        j0(new com.qzone.reborn.feedx.scroller.l(titleViewModel));
        QZoneFeedxEventTagViewModel qZoneFeedxEventTagViewModel2 = (QZoneFeedxEventTagViewModel) getViewModel(QZoneFeedxEventTagViewModel.class);
        this.mFeedViewModel = qZoneFeedxEventTagViewModel2;
        if (qZoneFeedxEventTagViewModel2 == null || k0() == null || (qZoneFeedxEventTagViewModel = this.mFeedViewModel) == null || (x26 = qZoneFeedxEventTagViewModel.x2()) == null) {
            return;
        }
        LifecycleOwner k06 = k0();
        Intrinsics.checkNotNull(k06);
        final Function1<UIStateData<List<? extends BusinessFeedData>>, Unit> function1 = new Function1<UIStateData<List<? extends BusinessFeedData>>, Unit>() { // from class: com.qzone.reborn.feedx.block.QZoneFeedxEventTagListAdapter$onInitBlock$1
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
            public final void invoke2(UIStateData<List<BusinessFeedData>> listUIStateData) {
                Intrinsics.checkNotNullParameter(listUIStateData, "listUIStateData");
                if (listUIStateData.getIsLoadMore()) {
                    return;
                }
                QZoneFeedxEventTagListAdapter.this.o0();
            }
        };
        x26.observe(k06, new Observer() { // from class: com.qzone.reborn.feedx.block.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZoneFeedxEventTagListAdapter.t0(Function1.this, obj);
            }
        });
    }

    public final void u0() {
        if (getRecyclerView() != null) {
            if (getRecyclerView().isComputingLayout()) {
                getRecyclerView().postDelayed(new Runnable() { // from class: com.qzone.reborn.feedx.block.m
                    @Override // java.lang.Runnable
                    public final void run() {
                        QZoneFeedxEventTagListAdapter.v0(QZoneFeedxEventTagListAdapter.this);
                    }
                }, 100L);
            } else {
                notifyDataSetChanged();
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public void setDatas(List<? extends BusinessFeedData> list) {
        if (list != null && getDataList() != null) {
            getDataList().clear();
            getDataList().addAll(list);
            u0();
            return;
        }
        QLog.e("QZoneFeedxEventTagListAdapter", 1, "[setDatas] list = " + list + " dataList = " + getDataList());
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(LoadInfo loadInfo) {
        QZoneFeedxEventTagViewModel qZoneFeedxEventTagViewModel;
        if (loadInfo == null) {
            return;
        }
        if (loadInfo.isInitState()) {
            QZoneFeedxEventTagViewModel qZoneFeedxEventTagViewModel2 = this.mFeedViewModel;
            if (qZoneFeedxEventTagViewModel2 != null) {
                qZoneFeedxEventTagViewModel2.J2();
                return;
            }
            return;
        }
        if (!loadInfo.isRefreshState() || (qZoneFeedxEventTagViewModel = this.mFeedViewModel) == null) {
            return;
        }
        qZoneFeedxEventTagViewModel.P1();
    }
}
