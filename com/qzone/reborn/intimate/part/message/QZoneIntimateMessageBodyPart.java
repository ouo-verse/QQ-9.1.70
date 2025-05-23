package com.qzone.reborn.intimate.part.message;

import android.app.Activity;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.reborn.base.k;
import com.qzone.reborn.feedx.block.aa;
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
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
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
import nk.ay;
import tl.h;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b=\u0010>J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\u001c\u0010\r\u001a\u00020\u00052\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tH\u0002J\u001c\u0010\u000e\u001a\u00020\u00052\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tH\u0002J\u001c\u0010\u0010\u001a\u00020\u00052\u0012\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tH\u0002J\b\u0010\u0011\u001a\u00020\u0005H\u0002J\b\u0010\u0012\u001a\u00020\u0005H\u0002J\u001c\u0010\u0013\u001a\u00020\u00052\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tH\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\u0012\u0010\u0018\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u001a\u001a\u00020\u0005H\u0016J\u0010\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001bH\u0016R\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010<\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;\u00a8\u0006?"}, d2 = {"Lcom/qzone/reborn/intimate/part/message/QZoneIntimateMessageBodyPart;", "Lcom/qzone/reborn/base/k;", "Lcom/tencent/biz/richframework/preload/recyclerview/ILoadMoreProvider$LoadMoreListener;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "N9", "G9", "initData", "Lcom/tencent/richframework/data/base/UIStateData;", "", "Lcom/qzone/reborn/message/data/a;", "listUIStateData", "I9", "H9", "uiStateData", "J9", "L9", "P9", "Q9", "", "getLogTag", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "onInitView", "onLoadMoreStart", "", "hasMore", "onLoadMoreEnd", "Lgj/f;", "d", "Lgj/f;", "messageAdapter", "Landroidx/recyclerview/widget/RecyclerView;", "e", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "f", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "concatAdapter", "Lcom/tencent/richframework/widget/refresh/layout/SmartRefreshLayout;", h.F, "Lcom/tencent/richframework/widget/refresh/layout/SmartRefreshLayout;", "refreshLayout", "Lcom/qzone/reborn/feedx/block/aa;", "i", "Lcom/qzone/reborn/feedx/block/aa;", "loadMoreAdapter", "Lnk/ay;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lnk/ay;", "messageViewModel", "Lcom/qzone/reborn/widget/QZoneBlankStateView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/reborn/widget/QZoneBlankStateView;", "blankView", "D", "Z", "hasInit", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneIntimateMessageBodyPart extends k implements ILoadMoreProvider$LoadMoreListener {

    /* renamed from: C, reason: from kotlin metadata */
    private QZoneBlankStateView blankView;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean hasInit;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private gj.f messageAdapter;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private RecyclerView recyclerView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private RFWConcatAdapter concatAdapter;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private SmartRefreshLayout refreshLayout;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private aa loadMoreAdapter;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ay messageViewModel;

    private final void G9() {
        this.messageAdapter = new gj.f();
        aa aaVar = new aa();
        this.loadMoreAdapter = aaVar;
        aaVar.registerLoadMoreListener(this);
        gj.f fVar = this.messageAdapter;
        RFWConcatAdapter rFWConcatAdapter = null;
        if (fVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageAdapter");
            fVar = null;
        }
        fVar.setHasStableIds(true);
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
        aaVar3.p0(new aa.a().e(HardCodeUtil.qqStr(R.string.w_3)).f(HardCodeUtil.qqStr(R.string.w_i)));
        RFWConcatAdapter.Config build = new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build();
        RecyclerView.Adapter[] adapterArr = new RecyclerView.Adapter[2];
        gj.f fVar2 = this.messageAdapter;
        if (fVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageAdapter");
            fVar2 = null;
        }
        adapterArr[0] = fVar2;
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

    private final void H9(UIStateData<List<com.qzone.reborn.message.data.a>> listUIStateData) {
        gj.f fVar = this.messageAdapter;
        if (fVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageAdapter");
            fVar = null;
        }
        fVar.setItems(new ArrayList(listUIStateData.getData()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I9(UIStateData<List<com.qzone.reborn.message.data.a>> listUIStateData) {
        QLog.i(getTAG(), 1, "handleMessageListRsp()  state = " + listUIStateData.getState());
        int state = listUIStateData.getState();
        if (state == 0) {
            P9();
        } else if (state == 2 || state == 3) {
            J9(listUIStateData);
        } else if (state == 4) {
            Q9(listUIStateData);
        } else if (state == 6 || state == 7) {
            H9(listUIStateData);
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

    private final void J9(UIStateData<List<com.qzone.reborn.message.data.a>> uiStateData) {
        if (bl.b(uiStateData.getData())) {
            P9();
            return;
        }
        RecyclerView recyclerView = this.recyclerView;
        gj.f fVar = null;
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
        gj.f fVar2 = this.messageAdapter;
        if (fVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageAdapter");
        } else {
            fVar = fVar2;
        }
        fVar.setItems(new ArrayList(uiStateData.getData()));
        if (uiStateData.getIsLoadMore()) {
            return;
        }
        RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.qzone.reborn.intimate.part.message.d
            @Override // java.lang.Runnable
            public final void run() {
                QZoneIntimateMessageBodyPart.K9(QZoneIntimateMessageBodyPart.this);
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K9(QZoneIntimateMessageBodyPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RecyclerView recyclerView = this$0.recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        recyclerView.scrollToPosition(0);
    }

    private final void L9() {
        String A = com.qzone.reborn.configx.g.f53821a.h().A();
        QZoneBlankStateView qZoneBlankStateView = this.blankView;
        if (qZoneBlankStateView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blankView");
            qZoneBlankStateView = null;
        }
        qZoneBlankStateView.setData(com.qzone.reborn.feedx.util.k.e(getContext(), A));
        QLog.d(getTAG(), 4, "[initBlankViewData] emptyMsg = " + A);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O9(QZoneIntimateMessageBodyPart this$0, IRefreshLayout it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        ay ayVar = this$0.messageViewModel;
        if (ayVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageViewModel");
            ayVar = null;
        }
        ayVar.d2();
    }

    private final void P9() {
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

    private final void Q9(UIStateData<List<com.qzone.reborn.message.data.a>> listUIStateData) {
        if (listUIStateData.getIsLoadMore()) {
            return;
        }
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
        qZoneBlankStateView.showErrorView();
    }

    private final void initData() {
        ViewModel viewModel = getViewModel(ay.class);
        ay ayVar = (ay) viewModel;
        MutableLiveData<UIStateData<List<com.qzone.reborn.message.data.a>>> W1 = ayVar.W1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<UIStateData<List<? extends com.qzone.reborn.message.data.a>>, Unit> function1 = new Function1<UIStateData<List<? extends com.qzone.reborn.message.data.a>>, Unit>() { // from class: com.qzone.reborn.intimate.part.message.QZoneIntimateMessageBodyPart$initData$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UIStateData<List<? extends com.qzone.reborn.message.data.a>> uIStateData) {
                invoke2((UIStateData<List<com.qzone.reborn.message.data.a>>) uIStateData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(UIStateData<List<com.qzone.reborn.message.data.a>> it) {
                QZoneIntimateMessageBodyPart qZoneIntimateMessageBodyPart = QZoneIntimateMessageBodyPart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                qZoneIntimateMessageBodyPart.I9(it);
            }
        };
        W1.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.intimate.part.message.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZoneIntimateMessageBodyPart.M9(Function1.this, obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZoneIntima\u2026)\n            }\n        }");
        this.messageViewModel = ayVar;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneIntimateMessageBodyPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        N9(rootView);
        G9();
        initData();
        L9();
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreEnd(boolean hasMore) {
        QLog.d(getTAG(), 1, "onLoadMoreEnd  hasMore = " + hasMore);
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreStart() {
        QLog.d(getTAG(), 1, "onLoadMoreStart ");
        ay ayVar = this.messageViewModel;
        if (ayVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageViewModel");
            ayVar = null;
        }
        ayVar.a2();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        if (this.hasInit) {
            return;
        }
        SmartRefreshLayout smartRefreshLayout = this.refreshLayout;
        if (smartRefreshLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
            smartRefreshLayout = null;
        }
        smartRefreshLayout.autoRefresh(0);
        this.hasInit = true;
    }

    private final void N9(View rootView) {
        View findViewById = rootView.findViewById(R.id.mqu);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.qzone_blank_view)");
        this.blankView = (QZoneBlankStateView) findViewById;
        View findViewById2 = rootView.findViewById(R.id.f162916nb1);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.qzone_rv_feed_list)");
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
        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() { // from class: com.qzone.reborn.intimate.part.message.b
            @Override // com.tencent.richframework.widget.refresh.layout.listener.OnRefreshListener
            public final void onRefresh(IRefreshLayout iRefreshLayout) {
                QZoneIntimateMessageBodyPart.O9(QZoneIntimateMessageBodyPart.this, iRefreshLayout);
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
        } else {
            recyclerView = recyclerView4;
        }
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
        defaultItemAnimator.setSupportsChangeAnimations(false);
        recyclerView.setItemAnimator(defaultItemAnimator);
    }
}
