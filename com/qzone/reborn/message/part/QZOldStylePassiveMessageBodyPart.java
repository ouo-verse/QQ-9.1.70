package com.qzone.reborn.message.part;

import android.app.Activity;
import android.view.View;
import androidx.core.content.res.ResourcesCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import bl.CommonNoticeBean;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
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
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\bD\u0010EJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0007H\u0002J\u001c\u0010\u000f\u001a\u00020\u00072\u0012\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000bH\u0002J\u001c\u0010\u0010\u001a\u00020\u00072\u0012\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000bH\u0002J\u001c\u0010\u0012\u001a\u00020\u00072\u0012\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000bH\u0002J\b\u0010\u0013\u001a\u00020\u0007H\u0002J\b\u0010\u0014\u001a\u00020\u0007H\u0002J\b\u0010\u0015\u001a\u00020\u0007H\u0002J\u001c\u0010\u0016\u001a\u00020\u00072\u0012\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000bH\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\u0010\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0012\u0010\u001c\u001a\u00020\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u0007H\u0016J\u0010\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0003H\u0016R\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u001c\u00108\u001a\b\u0012\u0004\u0012\u000205048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u001b\u0010>\u001a\u0002098BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u0016\u0010A\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010C\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010@\u00a8\u0006F"}, d2 = {"Lcom/qzone/reborn/message/part/QZOldStylePassiveMessageBodyPart;", "Lcom/qzone/reborn/base/k;", "Lcom/tencent/biz/richframework/preload/recyclerview/ILoadMoreProvider$LoadMoreListener;", "", "Q9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "O9", "G9", "initData", "Lcom/tencent/richframework/data/base/UIStateData;", "", "Lbl/a;", "listUIStateData", "J9", "I9", "uiStateData", "K9", "R9", "M9", "S9", "T9", "", "getLogTag", "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "onLoadMoreStart", "hasMore", "onLoadMoreEnd", "Landroidx/recyclerview/widget/RecyclerView;", "d", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/tencent/richframework/widget/refresh/layout/SmartRefreshLayout;", "e", "Lcom/tencent/richframework/widget/refresh/layout/SmartRefreshLayout;", "refreshLayout", "Lcom/qzone/reborn/widget/QZoneBlankStateView;", "f", "Lcom/qzone/reborn/widget/QZoneBlankStateView;", "blankView", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", tl.h.F, "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "concatAdapter", "Lcom/qzone/reborn/feedx/block/aa;", "i", "Lcom/qzone/reborn/feedx/block/aa;", "loadMoreAdapter", "Lcom/qzone/reborn/base/h;", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/qzone/reborn/base/h;", "messageAdapter", "Lhl/d;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "H9", "()Lhl/d;", "messageViewModel", "D", "Z", "hasInitData", "E", "hasInitItemDecoration", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZOldStylePassiveMessageBodyPart extends com.qzone.reborn.base.k implements ILoadMoreProvider$LoadMoreListener {

    /* renamed from: C, reason: from kotlin metadata */
    private final Lazy messageViewModel;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean hasInitData;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean hasInitItemDecoration;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private RecyclerView recyclerView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private SmartRefreshLayout refreshLayout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private QZoneBlankStateView blankView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private RFWConcatAdapter concatAdapter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private aa loadMoreAdapter = new aa();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private com.qzone.reborn.base.h<BusinessFeedData> messageAdapter = new al.a();

    public QZOldStylePassiveMessageBodyPart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<hl.a>() { // from class: com.qzone.reborn.message.part.QZOldStylePassiveMessageBodyPart$messageViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final hl.a invoke() {
                hl.a aVar = (hl.a) QZOldStylePassiveMessageBodyPart.this.getViewModel(hl.a.class);
                aVar.c2(QZOldStylePassiveMessageBodyPart.this.getActivity().getIntent());
                return aVar;
            }
        });
        this.messageViewModel = lazy;
    }

    private final void G9() {
        this.messageAdapter.setHasStableIds(true);
        aa aaVar = this.loadMoreAdapter;
        aaVar.registerLoadMoreListener(this);
        aaVar.setHasStableIds(true);
        aaVar.p0(new aa.a().e(HardCodeUtil.qqStr(R.string.w_3)).f(HardCodeUtil.qqStr(R.string.w_x)));
        RFWConcatAdapter rFWConcatAdapter = new RFWConcatAdapter(new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build(), (RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) new RecyclerView.Adapter[]{this.messageAdapter, this.loadMoreAdapter});
        this.concatAdapter = rFWConcatAdapter;
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView == null) {
            return;
        }
        recyclerView.setAdapter(rFWConcatAdapter);
    }

    private final hl.d H9() {
        Object value = this.messageViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-messageViewModel>(...)");
        return (hl.d) value;
    }

    private final void I9(UIStateData<List<CommonNoticeBean>> listUIStateData) {
        int collectionSizeOrDefault;
        com.qzone.reborn.base.h<BusinessFeedData> hVar = this.messageAdapter;
        List<CommonNoticeBean> data = listUIStateData.getData();
        Intrinsics.checkNotNullExpressionValue(data, "listUIStateData.data");
        List<CommonNoticeBean> list = data;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            Object obj = ((CommonNoticeBean) it.next()).getNotice().getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.EXTRA_DATA java.lang.String();
            if (!(obj instanceof BusinessFeedData)) {
                obj = null;
            }
            arrayList.add((BusinessFeedData) obj);
        }
        hVar.setItems(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J9(UIStateData<List<CommonNoticeBean>> listUIStateData) {
        QLog.i(getTAG(), 1, "handleMessageListRsp()  state = " + listUIStateData.getState());
        int state = listUIStateData.getState();
        if (state == 0) {
            S9();
        } else if (state == 2 || state == 3) {
            K9(listUIStateData);
        } else if (state == 4) {
            T9(listUIStateData);
        } else if (state == 6 || state == 7) {
            I9(listUIStateData);
        }
        SmartRefreshLayout smartRefreshLayout = this.refreshLayout;
        if (smartRefreshLayout != null) {
            smartRefreshLayout.finishRefresh();
        }
        this.loadMoreAdapter.setLoadState(listUIStateData.isLoading(), !listUIStateData.getIsFinish());
    }

    private final void K9(UIStateData<List<CommonNoticeBean>> uiStateData) {
        int collectionSizeOrDefault;
        if (bl.b(uiStateData.getData())) {
            S9();
            return;
        }
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView != null) {
            recyclerView.setVisibility(0);
        }
        QZoneBlankStateView qZoneBlankStateView = this.blankView;
        if (qZoneBlankStateView != null) {
            qZoneBlankStateView.o0();
        }
        com.qzone.reborn.base.h<BusinessFeedData> hVar = this.messageAdapter;
        List<CommonNoticeBean> data = uiStateData.getData();
        Intrinsics.checkNotNullExpressionValue(data, "uiStateData.data");
        List<CommonNoticeBean> list = data;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            Object obj = ((CommonNoticeBean) it.next()).getNotice().getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.EXTRA_DATA java.lang.String();
            if (!(obj instanceof BusinessFeedData)) {
                obj = null;
            }
            arrayList.add((BusinessFeedData) obj);
        }
        hVar.setItems(arrayList);
        if (!uiStateData.getIsLoadMore()) {
            RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.qzone.reborn.message.part.c
                @Override // java.lang.Runnable
                public final void run() {
                    QZOldStylePassiveMessageBodyPart.L9(QZOldStylePassiveMessageBodyPart.this);
                }
            }, 100L);
        }
        this.loadMoreAdapter.resetAutoLoadMoreTimes();
        this.loadMoreAdapter.setMaxAutoLoadMoreTimes(3);
        R9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(QZOldStylePassiveMessageBodyPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RecyclerView recyclerView = this$0.recyclerView;
        if (recyclerView != null) {
            recyclerView.scrollToPosition(0);
        }
    }

    private final void M9() {
        String A = com.qzone.reborn.configx.g.f53821a.h().A();
        QZoneBlankStateView qZoneBlankStateView = this.blankView;
        if (qZoneBlankStateView != null) {
            qZoneBlankStateView.setData(com.qzone.reborn.feedx.util.k.e(getContext(), A));
        }
        QLog.d(getTAG(), 1, "[initBlankViewData] emptyMsg = " + A);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(QZOldStylePassiveMessageBodyPart this$0, IRefreshLayout it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.H9().S0();
    }

    private final boolean Q9() {
        return false;
    }

    private final void R9() {
        if (this.hasInitItemDecoration || getActivity() == null) {
            return;
        }
        this.hasInitItemDecoration = true;
        com.qzone.reborn.intimate.widget.y yVar = new com.qzone.reborn.intimate.widget.y(getContext(), 0, ef.d.b(8), ResourcesCompat.getColor(getActivity().getResources(), R.color.qui_common_border_light, null));
        yVar.e(true);
        yVar.f(false);
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView != null) {
            recyclerView.addItemDecoration(yVar);
        }
    }

    private final void S9() {
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView != null) {
            recyclerView.setVisibility(4);
        }
        QZoneBlankStateView qZoneBlankStateView = this.blankView;
        if (qZoneBlankStateView != null) {
            qZoneBlankStateView.s0();
        }
    }

    private final void T9(UIStateData<List<CommonNoticeBean>> listUIStateData) {
        if (listUIStateData.getIsLoadMore()) {
            return;
        }
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView != null) {
            recyclerView.setVisibility(4);
        }
        QZoneBlankStateView qZoneBlankStateView = this.blankView;
        if (qZoneBlankStateView != null) {
            qZoneBlankStateView.showErrorView();
        }
    }

    private final void initData() {
        LiveData<UIStateData<List<CommonNoticeBean>>> v3 = H9().v();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<UIStateData<List<? extends CommonNoticeBean>>, Unit> function1 = new Function1<UIStateData<List<? extends CommonNoticeBean>>, Unit>() { // from class: com.qzone.reborn.message.part.QZOldStylePassiveMessageBodyPart$initData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UIStateData<List<? extends CommonNoticeBean>> uIStateData) {
                invoke2((UIStateData<List<CommonNoticeBean>>) uIStateData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(UIStateData<List<CommonNoticeBean>> it) {
                QZOldStylePassiveMessageBodyPart qZOldStylePassiveMessageBodyPart = QZOldStylePassiveMessageBodyPart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                qZOldStylePassiveMessageBodyPart.J9(it);
            }
        };
        v3.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.message.part.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZOldStylePassiveMessageBodyPart.N9(Function1.this, obj);
            }
        });
        if (Q9()) {
            return;
        }
        H9().S0();
        QLog.d(getTAG(), 1, "[initData] auto refresh");
        this.hasInitData = true;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZOldStylePassiveMessageBodyPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        O9(rootView);
        G9();
        M9();
        initData();
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreEnd(boolean hasMore) {
        QLog.d(getTAG(), 1, "onLoadMoreEnd  hasMore = " + hasMore);
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreStart() {
        QLog.d(getTAG(), 1, "onLoadMoreStart ");
        hl.d H9 = H9();
        if (H9 != null) {
            H9.F();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        if (this.hasInitData) {
            return;
        }
        SmartRefreshLayout smartRefreshLayout = this.refreshLayout;
        if (smartRefreshLayout != null) {
            smartRefreshLayout.autoRefresh(0);
        }
        this.hasInitData = true;
    }

    private final void O9(View rootView) {
        this.blankView = (QZoneBlankStateView) rootView.findViewById(R.id.mqu);
        this.recyclerView = (RecyclerView) rootView.findViewById(R.id.f162917nb2);
        SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) rootView.findViewById(R.id.nbb);
        this.refreshLayout = smartRefreshLayout;
        if (smartRefreshLayout != null) {
            smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() { // from class: com.qzone.reborn.message.part.a
                @Override // com.tencent.richframework.widget.refresh.layout.listener.OnRefreshListener
                public final void onRefresh(IRefreshLayout iRefreshLayout) {
                    QZOldStylePassiveMessageBodyPart.P9(QZOldStylePassiveMessageBodyPart.this, iRefreshLayout);
                }
            });
        }
        SmartRefreshLayout smartRefreshLayout2 = this.refreshLayout;
        if (smartRefreshLayout2 != null) {
            smartRefreshLayout2.setEnableOverScrollDrag(true);
        }
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView != null) {
            recyclerView.setNestedScrollingEnabled(true);
        }
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 != null) {
            recyclerView2.setLayoutManager(new SafeLinearLayoutManager(getContext()));
        }
        RecyclerView recyclerView3 = this.recyclerView;
        if (recyclerView3 == null) {
            return;
        }
        recyclerView3.setItemAnimator(null);
    }
}
