package com.qzone.reborn.groupalbum.part.albumlist;

import android.content.Context;
import android.util.Pair;
import android.view.View;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ba.o;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.albumx.common.bean.CommonAlbumListBean;
import com.qzone.reborn.feedx.block.aa;
import com.qzone.reborn.groupalbum.block.GroupAlbumAlbumListHeaderAdapter;
import com.qzone.reborn.widget.QZoneBlankStateView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.biz.richframework.part.block.base.SafeGridLayoutManager;
import com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.richframework.widget.refresh.layout.SmartRefreshLayout;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshLayout;
import com.tencent.richframework.widget.refresh.layout.listener.OnRefreshListener;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 F2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001GB\u0007\u00a2\u0006\u0004\bD\u0010EJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\u001c\u0010\u000f\u001a\u00020\u00042\u0012\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000bH\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J\b\u0010\u0011\u001a\u00020\u0004H\u0002J\u001c\u0010\u0012\u001a\u00020\u00042\u0012\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000bH\u0002J\u001c\u0010\u0013\u001a\u00020\u00042\u0012\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000bH\u0002J\u001e\u0010\u0014\u001a\u00020\u00042\u0014\u0010\u000e\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0018\u00010\u000bH\u0002J\b\u0010\u0015\u001a\u00020\u0004H\u0002J\b\u0010\u0016\u001a\u00020\u0004H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\u001a\u001a\u00020\u0004H\u0016J\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001bH\u0016R\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010@\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010C\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010B\u00a8\u0006H"}, d2 = {"Lcom/qzone/reborn/groupalbum/part/albumlist/g;", "Lcom/qzone/reborn/base/k;", "Lcom/tencent/biz/richframework/preload/recyclerview/ILoadMoreProvider$LoadMoreListener;", "Lai/b;", "", "R9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "S9", "initViewModel", "J9", "Lcom/tencent/richframework/data/base/UIStateData;", "", "Lcom/qzone/reborn/albumx/common/bean/CommonAlbumListBean;", "listUIStateData", "K9", "X9", "P9", "Y9", "M9", "N9", "W9", "e", "", "getLogTag", "onInitView", "onLoadMoreStart", "", "hasMore", "onLoadMoreEnd", "Lcom/tencent/richframework/widget/refresh/layout/SmartRefreshLayout;", "d", "Lcom/tencent/richframework/widget/refresh/layout/SmartRefreshLayout;", "mRefreshLayout", "Lcom/qzone/reborn/widget/QZoneBlankStateView;", "Lcom/qzone/reborn/widget/QZoneBlankStateView;", "mBlankView", "Landroidx/recyclerview/widget/RecyclerView;", "f", "Landroidx/recyclerview/widget/RecyclerView;", "mRecyclerView", "Lcom/qzone/reborn/groupalbum/viewmodel/g;", tl.h.F, "Lcom/qzone/reborn/groupalbum/viewmodel/g;", "mAlbumViewModel", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "i", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "mConcatAdapter", "Lcom/qzone/reborn/groupalbum/block/GroupAlbumAlbumListHeaderAdapter;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/qzone/reborn/groupalbum/block/GroupAlbumAlbumListHeaderAdapter;", "mHeaderInfoAdapter", "Li9/b;", BdhLogUtil.LogTag.Tag_Conn, "Li9/b;", "mAlbumListAdapter", "Lcom/qzone/reborn/feedx/block/aa;", "D", "Lcom/qzone/reborn/feedx/block/aa;", "mLoadMoreAdapter", "Lba/o;", "E", "Lba/o;", "mRecyclerViewDecoration", UserInfo.SEX_FEMALE, "Z", "mIsSetupItemDecoration", "<init>", "()V", "G", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class g extends com.qzone.reborn.base.k implements ILoadMoreProvider$LoadMoreListener, ai.b {

    /* renamed from: C, reason: from kotlin metadata */
    private i9.b mAlbumListAdapter;

    /* renamed from: D, reason: from kotlin metadata */
    private aa mLoadMoreAdapter;

    /* renamed from: E, reason: from kotlin metadata */
    private o mRecyclerViewDecoration;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean mIsSetupItemDecoration;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private SmartRefreshLayout mRefreshLayout;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private QZoneBlankStateView mBlankView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private RecyclerView mRecyclerView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private com.qzone.reborn.groupalbum.viewmodel.g mAlbumViewModel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private RFWConcatAdapter mConcatAdapter;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private GroupAlbumAlbumListHeaderAdapter mHeaderInfoAdapter;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/qzone/reborn/groupalbum/part/albumlist/g$b", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "", "position", "getSpanSize", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b extends GridLayoutManager.SpanSizeLookup {
        b() {
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int position) {
            RFWConcatAdapter rFWConcatAdapter = g.this.mConcatAdapter;
            if (rFWConcatAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mConcatAdapter");
                rFWConcatAdapter = null;
            }
            Pair<RecyclerView.Adapter<? extends RecyclerView.ViewHolder>, Integer> wrappedAdapterAndPosition = rFWConcatAdapter.getWrappedAdapterAndPosition(position);
            Intrinsics.checkNotNullExpressionValue(wrappedAdapterAndPosition, "mConcatAdapter.getWrappe\u2026pterAndPosition(position)");
            return ((RecyclerView.Adapter) wrappedAdapterAndPosition.first) instanceof i9.b ? 1 : 2;
        }
    }

    private final void J9() {
        this.mHeaderInfoAdapter = new GroupAlbumAlbumListHeaderAdapter();
        this.mAlbumListAdapter = new i9.b();
        aa aaVar = new aa();
        this.mLoadMoreAdapter = aaVar;
        aaVar.registerLoadMoreListener(this);
        aa aaVar2 = this.mLoadMoreAdapter;
        RFWConcatAdapter rFWConcatAdapter = null;
        if (aaVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLoadMoreAdapter");
            aaVar2 = null;
        }
        aaVar2.p0(new aa.a().e(HardCodeUtil.qqStr(R.string.v1u)).f(""));
        i9.b bVar = this.mAlbumListAdapter;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumListAdapter");
            bVar = null;
        }
        bVar.setHasStableIds(true);
        aa aaVar3 = this.mLoadMoreAdapter;
        if (aaVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLoadMoreAdapter");
            aaVar3 = null;
        }
        aaVar3.setHasStableIds(true);
        RFWConcatAdapter.Config build = new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build();
        RecyclerView.Adapter[] adapterArr = new RecyclerView.Adapter[3];
        i9.b bVar2 = this.mAlbumListAdapter;
        if (bVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumListAdapter");
            bVar2 = null;
        }
        adapterArr[0] = bVar2;
        GroupAlbumAlbumListHeaderAdapter groupAlbumAlbumListHeaderAdapter = this.mHeaderInfoAdapter;
        if (groupAlbumAlbumListHeaderAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHeaderInfoAdapter");
            groupAlbumAlbumListHeaderAdapter = null;
        }
        adapterArr[1] = groupAlbumAlbumListHeaderAdapter;
        aa aaVar4 = this.mLoadMoreAdapter;
        if (aaVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLoadMoreAdapter");
            aaVar4 = null;
        }
        adapterArr[2] = aaVar4;
        this.mConcatAdapter = new RFWConcatAdapter(build, (RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) adapterArr);
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView = null;
        }
        RFWConcatAdapter rFWConcatAdapter2 = this.mConcatAdapter;
        if (rFWConcatAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mConcatAdapter");
        } else {
            rFWConcatAdapter = rFWConcatAdapter2;
        }
        recyclerView.setAdapter(rFWConcatAdapter);
    }

    private final void K9(final UIStateData<List<CommonAlbumListBean>> listUIStateData) {
        int state = listUIStateData.getState();
        if (state == 0) {
            X9();
        } else if (state == 2 || state == 3) {
            N9(listUIStateData);
        } else if (state == 4) {
            Y9(listUIStateData);
        } else if (state == 6 || state == 7) {
            M9(listUIStateData);
        }
        SmartRefreshLayout smartRefreshLayout = this.mRefreshLayout;
        GroupAlbumAlbumListHeaderAdapter groupAlbumAlbumListHeaderAdapter = null;
        if (smartRefreshLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRefreshLayout");
            smartRefreshLayout = null;
        }
        smartRefreshLayout.finishRefresh();
        aa aaVar = this.mLoadMoreAdapter;
        if (aaVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLoadMoreAdapter");
            aaVar = null;
        }
        aaVar.setLoadState(listUIStateData.isLoading(), !listUIStateData.getIsFinish());
        if (listUIStateData.getIsFinish()) {
            RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.qzone.reborn.groupalbum.part.albumlist.d
                @Override // java.lang.Runnable
                public final void run() {
                    g.L9(g.this, listUIStateData);
                }
            }, 100L);
            return;
        }
        GroupAlbumAlbumListHeaderAdapter groupAlbumAlbumListHeaderAdapter2 = this.mHeaderInfoAdapter;
        if (groupAlbumAlbumListHeaderAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHeaderInfoAdapter");
        } else {
            groupAlbumAlbumListHeaderAdapter = groupAlbumAlbumListHeaderAdapter2;
        }
        groupAlbumAlbumListHeaderAdapter.l0(listUIStateData.getIsFinish());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(g this$0, UIStateData listUIStateData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(listUIStateData, "$listUIStateData");
        GroupAlbumAlbumListHeaderAdapter groupAlbumAlbumListHeaderAdapter = this$0.mHeaderInfoAdapter;
        if (groupAlbumAlbumListHeaderAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHeaderInfoAdapter");
            groupAlbumAlbumListHeaderAdapter = null;
        }
        groupAlbumAlbumListHeaderAdapter.l0(listUIStateData.getIsFinish());
    }

    private final void M9(UIStateData<List<CommonAlbumListBean>> listUIStateData) {
        i9.b bVar = this.mAlbumListAdapter;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumListAdapter");
            bVar = null;
        }
        bVar.setItems(new ArrayList(listUIStateData.getData()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O9(g this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RecyclerView recyclerView = this$0.mRecyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView = null;
        }
        recyclerView.scrollToPosition(0);
    }

    private final void P9() {
        QZoneBlankStateView qZoneBlankStateView = this.mBlankView;
        com.qzone.reborn.groupalbum.viewmodel.g gVar = null;
        if (qZoneBlankStateView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBlankView");
            qZoneBlankStateView = null;
        }
        Context context = getContext();
        com.qzone.reborn.groupalbum.viewmodel.g gVar2 = this.mAlbumViewModel;
        if (gVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
        } else {
            gVar = gVar2;
        }
        qZoneBlankStateView.setData(com.qzone.reborn.feedx.util.k.b(context, gVar.R1(), new View.OnClickListener() { // from class: com.qzone.reborn.groupalbum.part.albumlist.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                g.Q9(g.this, view);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q9(g this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.e();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void R9() {
        registerIoc(this, ai.b.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T9(g this$0, IRefreshLayout it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        com.qzone.reborn.groupalbum.viewmodel.g gVar = this$0.mAlbumViewModel;
        if (gVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
            gVar = null;
        }
        gVar.f2(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U9(g this$0, UIStateData listUIStateData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(listUIStateData, "listUIStateData");
        this$0.K9(listUIStateData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V9(g this$0, GroupAlbumAlbumListHeaderAdapter.GroupAlbumHeadInfoBean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        GroupAlbumAlbumListHeaderAdapter groupAlbumAlbumListHeaderAdapter = this$0.mHeaderInfoAdapter;
        if (groupAlbumAlbumListHeaderAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHeaderInfoAdapter");
            groupAlbumAlbumListHeaderAdapter = null;
        }
        Intrinsics.checkNotNullExpressionValue(it, "it");
        groupAlbumAlbumListHeaderAdapter.k0(it);
    }

    private final void W9() {
        if (this.mIsSetupItemDecoration || getActivity() == null) {
            return;
        }
        this.mIsSetupItemDecoration = true;
        this.mRecyclerViewDecoration = new o(false);
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView = null;
        }
        o oVar = this.mRecyclerViewDecoration;
        Intrinsics.checkNotNull(oVar);
        recyclerView.addItemDecoration(oVar);
    }

    private final void X9() {
        P9();
        RecyclerView recyclerView = this.mRecyclerView;
        QZoneBlankStateView qZoneBlankStateView = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView = null;
        }
        recyclerView.setVisibility(4);
        QZoneBlankStateView qZoneBlankStateView2 = this.mBlankView;
        if (qZoneBlankStateView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBlankView");
        } else {
            qZoneBlankStateView = qZoneBlankStateView2;
        }
        qZoneBlankStateView.s0();
    }

    private final void Y9(UIStateData<List<CommonAlbumListBean>> listUIStateData) {
        P9();
        if (listUIStateData.getIsLoadMore()) {
            return;
        }
        RecyclerView recyclerView = this.mRecyclerView;
        QZoneBlankStateView qZoneBlankStateView = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView = null;
        }
        recyclerView.setVisibility(4);
        QZoneBlankStateView qZoneBlankStateView2 = this.mBlankView;
        if (qZoneBlankStateView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBlankView");
        } else {
            qZoneBlankStateView = qZoneBlankStateView2;
        }
        qZoneBlankStateView.showErrorView();
    }

    private final void e() {
        ai.a aVar = (ai.a) getIocInterface(ai.a.class);
        if (aVar != null) {
            aVar.e();
        }
    }

    private final void initViewModel() {
        ViewModel viewModel = getViewModel(com.qzone.reborn.groupalbum.viewmodel.g.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(GroupAlbumA\u2026istViewModel::class.java)");
        com.qzone.reborn.groupalbum.viewmodel.g gVar = (com.qzone.reborn.groupalbum.viewmodel.g) viewModel;
        this.mAlbumViewModel = gVar;
        com.qzone.reborn.groupalbum.viewmodel.g gVar2 = null;
        if (gVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
            gVar = null;
        }
        gVar.U1().observe(getPartHost().getLifecycleOwner(), new Observer() { // from class: com.qzone.reborn.groupalbum.part.albumlist.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                g.U9(g.this, (UIStateData) obj);
            }
        });
        com.qzone.reborn.groupalbum.viewmodel.g gVar3 = this.mAlbumViewModel;
        if (gVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
            gVar3 = null;
        }
        gVar3.f2(false);
        com.qzone.reborn.groupalbum.viewmodel.g gVar4 = this.mAlbumViewModel;
        if (gVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
        } else {
            gVar2 = gVar4;
        }
        gVar2.W1().observe(getPartHost().getLifecycleOwner(), new Observer() { // from class: com.qzone.reborn.groupalbum.part.albumlist.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                g.V9(g.this, (GroupAlbumAlbumListHeaderAdapter.GroupAlbumHeadInfoBean) obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "GroupAlbumAlbumListBlockPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        R9();
        S9(rootView);
        J9();
        initViewModel();
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreStart() {
        com.qzone.reborn.groupalbum.viewmodel.g gVar = this.mAlbumViewModel;
        if (gVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
            gVar = null;
        }
        gVar.f2(true);
    }

    private final void N9(UIStateData<List<CommonAlbumListBean>> listUIStateData) {
        if (listUIStateData == null) {
            QLog.e("GroupAlbumAlbumListBlockPart", 1, "ui state data is null");
            return;
        }
        RecyclerView recyclerView = this.mRecyclerView;
        i9.b bVar = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView = null;
        }
        recyclerView.setVisibility(0);
        QZoneBlankStateView qZoneBlankStateView = this.mBlankView;
        if (qZoneBlankStateView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBlankView");
            qZoneBlankStateView = null;
        }
        qZoneBlankStateView.o0();
        i9.b bVar2 = this.mAlbumListAdapter;
        if (bVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumListAdapter");
        } else {
            bVar = bVar2;
        }
        bVar.setItems(new ArrayList(listUIStateData.getData()));
        if (!listUIStateData.getIsLoadMore()) {
            RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.qzone.reborn.groupalbum.part.albumlist.f
                @Override // java.lang.Runnable
                public final void run() {
                    g.O9(g.this);
                }
            }, 100L);
        }
        W9();
    }

    private final void S9(View rootView) {
        View findViewById = rootView.findViewById(R.id.k6r);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026oup_album_refresh_layout)");
        this.mRefreshLayout = (SmartRefreshLayout) findViewById;
        View findViewById2 = rootView.findViewById(R.id.jvr);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.group_album_blank_view)");
        this.mBlankView = (QZoneBlankStateView) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.nf5);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.rv_album_list)");
        RecyclerView recyclerView = (RecyclerView) findViewById3;
        this.mRecyclerView = recyclerView;
        SmartRefreshLayout smartRefreshLayout = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView = null;
        }
        recyclerView.setNestedScrollingEnabled(true);
        SafeGridLayoutManager safeGridLayoutManager = new SafeGridLayoutManager(getContext(), 2);
        safeGridLayoutManager.setSpanSizeLookup(new b());
        RecyclerView recyclerView2 = this.mRecyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView2 = null;
        }
        recyclerView2.setLayoutManager(safeGridLayoutManager);
        RecyclerView recyclerView3 = this.mRecyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView3 = null;
        }
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
        defaultItemAnimator.setSupportsChangeAnimations(false);
        recyclerView3.setItemAnimator(defaultItemAnimator);
        SmartRefreshLayout smartRefreshLayout2 = this.mRefreshLayout;
        if (smartRefreshLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRefreshLayout");
            smartRefreshLayout2 = null;
        }
        smartRefreshLayout2.setOnRefreshListener(new OnRefreshListener() { // from class: com.qzone.reborn.groupalbum.part.albumlist.a
            @Override // com.tencent.richframework.widget.refresh.layout.listener.OnRefreshListener
            public final void onRefresh(IRefreshLayout iRefreshLayout) {
                g.T9(g.this, iRefreshLayout);
            }
        });
        SmartRefreshLayout smartRefreshLayout3 = this.mRefreshLayout;
        if (smartRefreshLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRefreshLayout");
            smartRefreshLayout3 = null;
        }
        smartRefreshLayout3.setEnableOverScrollDrag(true);
        SmartRefreshLayout smartRefreshLayout4 = this.mRefreshLayout;
        if (smartRefreshLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRefreshLayout");
        } else {
            smartRefreshLayout = smartRefreshLayout4;
        }
        smartRefreshLayout.setEnableLoadMoreWhenContentNotFull(true);
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreEnd(boolean hasMore) {
    }
}
