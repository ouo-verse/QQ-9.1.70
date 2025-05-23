package com.qzone.reborn.notice.part;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.reborn.base.k;
import com.qzone.reborn.configx.g;
import com.qzone.reborn.feedx.block.aa;
import com.qzone.reborn.groupalbum.viewmodel.am;
import com.qzone.reborn.widget.QZoneBlankStateView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.bl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.richframework.widget.refresh.layout.SmartRefreshLayout;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshLayout;
import com.tencent.richframework.widget.refresh.layout.listener.OnRefreshListener;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b8\u00109J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\u001c\u0010\r\u001a\u00020\u00052\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tH\u0002J\u001c\u0010\u000e\u001a\u00020\u00052\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tH\u0002J\u001c\u0010\u0010\u001a\u00020\u00052\u0012\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tH\u0002J\b\u0010\u0011\u001a\u00020\u0005H\u0002J\b\u0010\u0012\u001a\u00020\u0005H\u0002J\u001c\u0010\u0013\u001a\u00020\u00052\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tH\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0017\u001a\u00020\u0014H\u0014J\b\u0010\u0018\u001a\u00020\u0005H\u0016J\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0019H\u0016R\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00106\u00a8\u0006:"}, d2 = {"Lcom/qzone/reborn/notice/part/QZoneNoticeListPart;", "Lcom/qzone/reborn/base/k;", "Lcom/tencent/biz/richframework/preload/recyclerview/ILoadMoreProvider$LoadMoreListener;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "O9", "G9", "initData", "Lcom/tencent/richframework/data/base/UIStateData;", "", "Lkl/a;", "listUIStateData", "J9", "I9", "uiStateData", "K9", "M9", "Q9", "R9", "", "getLogTag", "onInitView", "H9", "onLoadMoreStart", "", "hasMore", "onLoadMoreEnd", "Ljl/a;", "d", "Ljl/a;", "messageAdapter", "Landroidx/recyclerview/widget/RecyclerView;", "e", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "f", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "concatAdapter", "Lcom/tencent/richframework/widget/refresh/layout/SmartRefreshLayout;", h.F, "Lcom/tencent/richframework/widget/refresh/layout/SmartRefreshLayout;", "refreshLayout", "Lcom/qzone/reborn/feedx/block/aa;", "i", "Lcom/qzone/reborn/feedx/block/aa;", "loadMoreAdapter", "Lcom/qzone/reborn/groupalbum/viewmodel/am;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/qzone/reborn/groupalbum/viewmodel/am;", "messageViewModel", "Lcom/qzone/reborn/widget/QZoneBlankStateView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/reborn/widget/QZoneBlankStateView;", "blankView", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public class QZoneNoticeListPart extends k implements ILoadMoreProvider$LoadMoreListener {

    /* renamed from: C, reason: from kotlin metadata */
    private QZoneBlankStateView blankView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private jl.a messageAdapter;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private RecyclerView recyclerView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private RFWConcatAdapter concatAdapter;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private SmartRefreshLayout refreshLayout;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private aa loadMoreAdapter;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private am messageViewModel;

    private final void G9() {
        this.messageAdapter = new jl.a();
        aa aaVar = new aa();
        this.loadMoreAdapter = aaVar;
        aaVar.registerLoadMoreListener(this);
        jl.a aVar = this.messageAdapter;
        RFWConcatAdapter rFWConcatAdapter = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageAdapter");
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
        jl.a aVar2 = this.messageAdapter;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageAdapter");
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

    private final void I9(UIStateData<List<kl.a>> listUIStateData) {
        jl.a aVar = this.messageAdapter;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageAdapter");
            aVar = null;
        }
        aVar.setItems(new ArrayList(listUIStateData.getData()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J9(UIStateData<List<kl.a>> listUIStateData) {
        QLog.i(getLogTag(), 1, "handleMessageListRsp()  state = " + listUIStateData.getState());
        int state = listUIStateData.getState();
        if (state == 0) {
            Q9();
        } else if (state == 2 || state == 3) {
            K9(listUIStateData);
        } else if (state == 4) {
            R9(listUIStateData);
        } else if (state == 6 || state == 7) {
            I9(listUIStateData);
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

    private final void K9(UIStateData<List<kl.a>> uiStateData) {
        if (bl.b(uiStateData.getData())) {
            Q9();
            return;
        }
        RecyclerView recyclerView = this.recyclerView;
        jl.a aVar = null;
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
        jl.a aVar2 = this.messageAdapter;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageAdapter");
        } else {
            aVar = aVar2;
        }
        aVar.setItems(new ArrayList(uiStateData.getData()));
        if (uiStateData.getIsLoadMore()) {
            return;
        }
        RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.qzone.reborn.notice.part.c
            @Override // java.lang.Runnable
            public final void run() {
                QZoneNoticeListPart.L9(QZoneNoticeListPart.this);
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(QZoneNoticeListPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RecyclerView recyclerView = this$0.recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        recyclerView.scrollToPosition(0);
    }

    private final void M9() {
        String H9 = H9();
        QZoneBlankStateView qZoneBlankStateView = this.blankView;
        if (qZoneBlankStateView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blankView");
            qZoneBlankStateView = null;
        }
        qZoneBlankStateView.setData(com.qzone.reborn.feedx.util.k.c(getContext(), H9));
        QLog.d(getLogTag(), 4, "[initBlankViewData] emptyMsg = " + H9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(QZoneNoticeListPart this$0, IRefreshLayout it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        am amVar = this$0.messageViewModel;
        if (amVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageViewModel");
            amVar = null;
        }
        amVar.P1();
    }

    private final void Q9() {
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

    private final void R9(UIStateData<List<kl.a>> listUIStateData) {
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
        ViewModel viewModel = getViewModel(am.class);
        am amVar = (am) viewModel;
        MutableLiveData<UIStateData<List<kl.a>>> R1 = amVar.R1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<UIStateData<List<? extends kl.a>>, Unit> function1 = new Function1<UIStateData<List<? extends kl.a>>, Unit>() { // from class: com.qzone.reborn.notice.part.QZoneNoticeListPart$initData$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UIStateData<List<? extends kl.a>> uIStateData) {
                invoke2((UIStateData<List<kl.a>>) uIStateData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(UIStateData<List<kl.a>> it) {
                QZoneNoticeListPart qZoneNoticeListPart = QZoneNoticeListPart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                qZoneNoticeListPart.J9(it);
            }
        };
        R1.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.notice.part.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZoneNoticeListPart.N9(Function1.this, obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(GroupAlbumN\u2026)\n            }\n        }");
        this.messageViewModel = amVar;
        am amVar2 = null;
        if (amVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageViewModel");
            amVar = null;
        }
        Context context = getContext();
        Activity activity = context instanceof Activity ? (Activity) context : null;
        Intent intent = activity != null ? activity.getIntent() : null;
        if (intent == null) {
            intent = new Intent();
        }
        amVar.O1(intent);
        am amVar3 = this.messageViewModel;
        if (amVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageViewModel");
        } else {
            amVar2 = amVar3;
        }
        amVar2.P1();
    }

    protected String H9() {
        return g.f53821a.h().A();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public String getLogTag() {
        return "QZoneNoticeListPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        O9(rootView);
        G9();
        initData();
        M9();
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreEnd(boolean hasMore) {
        QLog.d(getLogTag(), 1, "onLoadMoreEnd  hasMore = " + hasMore);
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreStart() {
        QLog.d(getLogTag(), 1, "onLoadMoreStart ");
        am amVar = this.messageViewModel;
        if (amVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageViewModel");
            amVar = null;
        }
        amVar.S1();
    }

    private final void O9(View rootView) {
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
        if (smartRefreshLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
            smartRefreshLayout = null;
        }
        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() { // from class: com.qzone.reborn.notice.part.a
            @Override // com.tencent.richframework.widget.refresh.layout.listener.OnRefreshListener
            public final void onRefresh(IRefreshLayout iRefreshLayout) {
                QZoneNoticeListPart.P9(QZoneNoticeListPart.this, iRefreshLayout);
            }
        });
        SmartRefreshLayout smartRefreshLayout2 = this.refreshLayout;
        if (smartRefreshLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
            smartRefreshLayout2 = null;
        }
        smartRefreshLayout2.setEnableOverScrollDrag(true);
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        recyclerView.setNestedScrollingEnabled(true);
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView2 = null;
        }
        recyclerView2.setLayoutManager(new SafeLinearLayoutManager(getContext()));
        RecyclerView recyclerView3 = this.recyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView3 = null;
        }
        recyclerView3.setItemAnimator(null);
    }
}
