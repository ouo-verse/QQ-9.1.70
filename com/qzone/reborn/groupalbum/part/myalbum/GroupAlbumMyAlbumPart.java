package com.qzone.reborn.groupalbum.part.myalbum;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.reborn.base.k;
import com.qzone.reborn.feedx.block.aa;
import com.qzone.reborn.groupalbum.viewmodel.al;
import com.qzone.reborn.widget.QZoneBlankStateView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.bl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.GetAllAlbumListItem;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.richframework.widget.refresh.layout.SmartRefreshLayout;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshLayout;
import com.tencent.richframework.widget.refresh.layout.listener.OnRefreshListener;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 :2\u00020\u00012\u00020\u0002:\u0001;B\u0007\u00a2\u0006\u0004\b8\u00109J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0003H\u0002J\b\u0010\u000b\u001a\u00020\u0003H\u0002J&\u0010\u0011\u001a\u00020\u00032\u001c\u0010\u0010\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f0\fH\u0002J&\u0010\u0012\u001a\u00020\u00032\u001c\u0010\u0010\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f0\fH\u0002J&\u0010\u0014\u001a\u00020\u00032\u001c\u0010\u0013\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f0\fH\u0002J\b\u0010\u0015\u001a\u00020\u0003H\u0002J\b\u0010\u0016\u001a\u00020\u0003H\u0002J&\u0010\u0017\u001a\u00020\u00032\u001c\u0010\u0010\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f0\fH\u0002J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\u001b\u001a\u00020\u0018H\u0014J\b\u0010\u001c\u001a\u00020\u0003H\u0016J\u0010\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001dH\u0016R\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00106\u00a8\u0006<"}, d2 = {"Lcom/qzone/reborn/groupalbum/part/myalbum/GroupAlbumMyAlbumPart;", "Lcom/qzone/reborn/base/k;", "Lcom/tencent/biz/richframework/preload/recyclerview/ILoadMoreProvider$LoadMoreListener;", "", "O9", "Lcom/qzone/reborn/groupalbum/viewmodel/al;", "I9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Q9", "G9", "initData", "Lcom/tencent/richframework/data/base/UIStateData;", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/GetAllAlbumListItem;", "Lkotlin/collections/ArrayList;", "listUIStateData", "J9", "K9", "uiStateData", "L9", "N9", "S9", "T9", "", "getLogTag", "onInitView", "H9", "onLoadMoreStart", "", "hasMore", "onLoadMoreEnd", "Lf9/a;", "d", "Lf9/a;", "albumAdapter", "Landroidx/recyclerview/widget/RecyclerView;", "e", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "f", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "concatAdapter", "Lcom/tencent/richframework/widget/refresh/layout/SmartRefreshLayout;", h.F, "Lcom/tencent/richframework/widget/refresh/layout/SmartRefreshLayout;", "refreshLayout", "Lcom/qzone/reborn/feedx/block/aa;", "i", "Lcom/qzone/reborn/feedx/block/aa;", "loadMoreAdapter", "Lcom/qzone/reborn/widget/QZoneBlankStateView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/qzone/reborn/widget/QZoneBlankStateView;", "blankView", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class GroupAlbumMyAlbumPart extends k implements ILoadMoreProvider$LoadMoreListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private f9.a albumAdapter;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private RecyclerView recyclerView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private RFWConcatAdapter concatAdapter;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private SmartRefreshLayout refreshLayout;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private aa loadMoreAdapter;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private QZoneBlankStateView blankView;

    private final void G9() {
        this.albumAdapter = new f9.a();
        aa aaVar = new aa();
        this.loadMoreAdapter = aaVar;
        aaVar.registerLoadMoreListener(this);
        f9.a aVar = this.albumAdapter;
        RFWConcatAdapter rFWConcatAdapter = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("albumAdapter");
            aVar = null;
        }
        aVar.setHasStableIds(true);
        aa aaVar2 = this.loadMoreAdapter;
        if (aaVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadMoreAdapter");
            aaVar2 = null;
        }
        aaVar2.setHasStableIds(true);
        aa aaVar3 = this.loadMoreAdapter;
        if (aaVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadMoreAdapter");
            aaVar3 = null;
        }
        aaVar3.p0(new aa.a().e(HardCodeUtil.qqStr(R.string.w_3)).f(""));
        RFWConcatAdapter.Config build = new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build();
        RecyclerView.Adapter[] adapterArr = new RecyclerView.Adapter[2];
        f9.a aVar2 = this.albumAdapter;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("albumAdapter");
            aVar2 = null;
        }
        adapterArr[0] = aVar2;
        aa aaVar4 = this.loadMoreAdapter;
        if (aaVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadMoreAdapter");
            aaVar4 = null;
        }
        adapterArr[1] = aaVar4;
        this.concatAdapter = new RFWConcatAdapter(build, (RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) adapterArr);
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        RFWConcatAdapter rFWConcatAdapter2 = this.concatAdapter;
        if (rFWConcatAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("concatAdapter");
        } else {
            rFWConcatAdapter = rFWConcatAdapter2;
        }
        recyclerView.setAdapter(rFWConcatAdapter);
    }

    private final al I9() {
        return (al) getViewModel(al.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J9(UIStateData<ArrayList<GetAllAlbumListItem>> listUIStateData) {
        QLog.i("GroupAlbumMyAlbumPart", 1, "handleMessageListRsp()  state = " + listUIStateData.getState());
        int state = listUIStateData.getState();
        if (state == 0) {
            S9();
        } else if (state == 2 || state == 3) {
            L9(listUIStateData);
        } else if (state == 4) {
            T9(listUIStateData);
        } else if (state == 6 || state == 7) {
            K9(listUIStateData);
        }
        SmartRefreshLayout smartRefreshLayout = this.refreshLayout;
        aa aaVar = null;
        if (smartRefreshLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
            smartRefreshLayout = null;
        }
        smartRefreshLayout.finishRefresh();
        aa aaVar2 = this.loadMoreAdapter;
        if (aaVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadMoreAdapter");
        } else {
            aaVar = aaVar2;
        }
        aaVar.setLoadState(listUIStateData.isLoading(), !listUIStateData.getIsFinish());
    }

    private final void K9(UIStateData<ArrayList<GetAllAlbumListItem>> listUIStateData) {
        f9.a aVar = this.albumAdapter;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("albumAdapter");
            aVar = null;
        }
        aVar.setItems(listUIStateData.getData());
    }

    private final void L9(UIStateData<ArrayList<GetAllAlbumListItem>> uiStateData) {
        if (bl.b(uiStateData.getData())) {
            S9();
            return;
        }
        RecyclerView recyclerView = this.recyclerView;
        f9.a aVar = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        recyclerView.setVisibility(0);
        QZoneBlankStateView qZoneBlankStateView = this.blankView;
        if (qZoneBlankStateView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blankView");
            qZoneBlankStateView = null;
        }
        qZoneBlankStateView.o0();
        f9.a aVar2 = this.albumAdapter;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("albumAdapter");
        } else {
            aVar = aVar2;
        }
        aVar.setItems(new ArrayList(uiStateData.getData()));
        if (uiStateData.getIsLoadMore()) {
            return;
        }
        RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.qzone.reborn.groupalbum.part.myalbum.e
            @Override // java.lang.Runnable
            public final void run() {
                GroupAlbumMyAlbumPart.M9(GroupAlbumMyAlbumPart.this);
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(GroupAlbumMyAlbumPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RecyclerView recyclerView = this$0.recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        recyclerView.scrollToPosition(0);
    }

    private final void N9() {
        String H9 = H9();
        QZoneBlankStateView qZoneBlankStateView = this.blankView;
        if (qZoneBlankStateView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blankView");
            qZoneBlankStateView = null;
        }
        qZoneBlankStateView.setData(com.qzone.reborn.feedx.util.k.D(getContext(), H9));
        QLog.d("GroupAlbumMyAlbumPart", 1, "[initBlankViewData] emptyMsg = " + H9);
    }

    private final void O9() {
        al I9;
        MutableLiveData<UIStateData<ArrayList<GetAllAlbumListItem>>> Q1;
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        if (lifecycleOwner == null || (I9 = I9()) == null || (Q1 = I9.Q1()) == null) {
            return;
        }
        final Function1<UIStateData<ArrayList<GetAllAlbumListItem>>, Unit> function1 = new Function1<UIStateData<ArrayList<GetAllAlbumListItem>>, Unit>() { // from class: com.qzone.reborn.groupalbum.part.myalbum.GroupAlbumMyAlbumPart$initObserve$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UIStateData<ArrayList<GetAllAlbumListItem>> uIStateData) {
                invoke2(uIStateData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(UIStateData<ArrayList<GetAllAlbumListItem>> uIStateData) {
                if (uIStateData == null) {
                    return;
                }
                GroupAlbumMyAlbumPart.this.J9(uIStateData);
            }
        };
        Q1.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.groupalbum.part.myalbum.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GroupAlbumMyAlbumPart.P9(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R9(GroupAlbumMyAlbumPart this$0, IRefreshLayout it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        al I9 = this$0.I9();
        if (I9 != null) {
            I9.O1(false);
        }
    }

    private final void S9() {
        RecyclerView recyclerView = this.recyclerView;
        QZoneBlankStateView qZoneBlankStateView = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        recyclerView.setVisibility(4);
        QZoneBlankStateView qZoneBlankStateView2 = this.blankView;
        if (qZoneBlankStateView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blankView");
        } else {
            qZoneBlankStateView = qZoneBlankStateView2;
        }
        qZoneBlankStateView.s0();
    }

    private final void T9(UIStateData<ArrayList<GetAllAlbumListItem>> listUIStateData) {
        if (listUIStateData.getIsLoadMore()) {
            return;
        }
        RecyclerView recyclerView = this.recyclerView;
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        recyclerView.setVisibility(4);
        QZoneBlankStateView qZoneBlankStateView = this.blankView;
        if (qZoneBlankStateView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blankView");
            qZoneBlankStateView = null;
        }
        qZoneBlankStateView.showErrorView();
        RecyclerView recyclerView3 = this.recyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        } else {
            recyclerView2 = recyclerView3;
        }
        QQToast.makeText(recyclerView2.getContext(), 1, R.string.jhn, 0).show();
    }

    private final void initData() {
        O9();
        al I9 = I9();
        if (I9 != null) {
            I9.O1(false);
        }
    }

    protected String H9() {
        String string = getContext().getString(R.string.f1331058);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026bum_my_group_album_empty)");
        return string;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "GroupAlbumMyAlbumPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        Q9(rootView);
        G9();
        initData();
        N9();
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreEnd(boolean hasMore) {
        QLog.d("GroupAlbumMyAlbumPart", 1, "onLoadMoreEnd  hasMore = " + hasMore);
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreStart() {
        QLog.d("GroupAlbumMyAlbumPart", 1, "onLoadMoreStart ");
        al I9 = I9();
        if (I9 != null) {
            I9.O1(true);
        }
    }

    private final void Q9(View rootView) {
        View findViewById = rootView.findViewById(R.id.mqu);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.qzone_blank_view)");
        this.blankView = (QZoneBlankStateView) findViewById;
        View findViewById2 = rootView.findViewById(R.id.f162917nb2);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.qzone_rv_list)");
        this.recyclerView = (RecyclerView) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.nbb);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.\u2026one_smart_refresh_layout)");
        SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) findViewById3;
        this.refreshLayout = smartRefreshLayout;
        RecyclerView recyclerView = null;
        if (smartRefreshLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
            smartRefreshLayout = null;
        }
        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() { // from class: com.qzone.reborn.groupalbum.part.myalbum.c
            @Override // com.tencent.richframework.widget.refresh.layout.listener.OnRefreshListener
            public final void onRefresh(IRefreshLayout iRefreshLayout) {
                GroupAlbumMyAlbumPart.R9(GroupAlbumMyAlbumPart.this, iRefreshLayout);
            }
        });
        SmartRefreshLayout smartRefreshLayout2 = this.refreshLayout;
        if (smartRefreshLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
            smartRefreshLayout2 = null;
        }
        smartRefreshLayout2.setEnableOverScrollDrag(true);
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView2 = null;
        }
        recyclerView2.setNestedScrollingEnabled(true);
        RecyclerView recyclerView3 = this.recyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView3 = null;
        }
        recyclerView3.setLayoutManager(new SafeLinearLayoutManager(getContext()));
        RecyclerView recyclerView4 = this.recyclerView;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView4 = null;
        }
        recyclerView4.setItemAnimator(null);
        SmartRefreshLayout smartRefreshLayout3 = this.refreshLayout;
        if (smartRefreshLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
            smartRefreshLayout3 = null;
        }
        smartRefreshLayout3.setBackground(getContext().getDrawable(R.drawable.qui_common_bg_bottom_standard_bg));
        RecyclerView recyclerView5 = this.recyclerView;
        if (recyclerView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        } else {
            recyclerView = recyclerView5;
        }
        ViewGroup.LayoutParams layoutParams = recyclerView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        layoutParams2.leftMargin = ViewUtils.dip2px(16.0f);
        layoutParams2.topMargin = ViewUtils.dip2px(16.0f);
        layoutParams2.rightMargin = ViewUtils.dip2px(16.0f);
    }
}
