package com.tencent.mobileqq.matchfriend.reborn.content.signal.square.part;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.qqnt.widget.smartrefreshlayout.layout.SmartRefreshLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.biz.richframework.part.block.base.SafeGridLayoutManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.matchfriend.reborn.content.main.framework.widget.refresh.MainRefreshFooter;
import com.tencent.mobileqq.matchfriend.reborn.content.main.framework.widget.refresh.MainRefreshHeader;
import com.tencent.mobileqq.matchfriend.reborn.content.signal.event.QQStrangerSignalSquareEmptyEvent;
import com.tencent.mobileqq.matchfriend.reborn.content.signal.event.QQStrangerSignalSquareErrorEvent;
import com.tencent.mobileqq.matchfriend.reborn.content.signal.event.QQStrangerSignalSquareRefreshEvent;
import com.tencent.mobileqq.matchfriend.reborn.content.signal.event.QQStrangerSignalSquareShowContentViewEvent;
import com.tencent.mobileqq.matchfriend.reborn.content.signal.square.repository.QQStrangerSignalInfoResult;
import com.tencent.mobileqq.matchfriend.reborn.content.signal.square.viewmodel.QQStrangerSignalSquareViewModel;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.utils.ViewUtils;
import com.tencent.qqnt.aio.utils.l;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\b\u0018\u0000 U2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001VB\u0007\u00a2\u0006\u0004\bS\u0010TJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\bH\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\u0002J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0014\u001a\u00020\u0004H\u0002J\b\u0010\u0015\u001a\u00020\u0004H\u0002J\b\u0010\u0016\u001a\u00020\u0004H\u0002J\u0018\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017H\u0002J\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u001a\u0010\"\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001e2\b\u0010!\u001a\u0004\u0018\u00010 H\u0016J\u0012\u0010#\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\u0012\u0010&\u001a\u00020\u00042\b\u0010%\u001a\u0004\u0018\u00010$H\u0016J\u0010\u0010(\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u0003H\u0016J$\u0010,\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030*0)j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030*`+H\u0016R\u0016\u0010/\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bE\u0010FR#\u0010N\u001a\n I*\u0004\u0018\u00010H0H8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010MR\u0016\u0010R\u001a\u00020O8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010Q\u00a8\u0006W"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/square/part/QQStrangerSignalSquareSmartRefreshPart;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "L9", "N9", "M9", "", "G9", "F9", "spanCount", "U9", "Q9", "count", "D9", "E9", "Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/square/repository/a;", "result", "T9", "J9", "I9", "K9", "", "noMoreData", "isEmpty", "V9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "Landroid/content/res/Configuration;", "configuration", "onConfigurationChanged", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "d", "I", "width", "Lcom/qqnt/widget/smartrefreshlayout/layout/SmartRefreshLayout;", "e", "Lcom/qqnt/widget/smartrefreshlayout/layout/SmartRefreshLayout;", "refreshLayout", "Landroidx/recyclerview/widget/RecyclerView;", "f", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", tl.h.F, "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "concatAdapter", "Li82/a;", "i", "Li82/a;", "dataListAdapter", "Lj82/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lj82/a;", "itemDecoration", "Landroidx/recyclerview/widget/GridLayoutManager;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/recyclerview/widget/GridLayoutManager;", "layoutManager", "Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/square/viewmodel/QQStrangerSignalSquareViewModel;", "kotlin.jvm.PlatformType", "D", "Lkotlin/Lazy;", "H9", "()Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/square/viewmodel/QQStrangerSignalSquareViewModel;", "viewModel", "", "E", "J", "partnerId", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerSignalSquareSmartRefreshPart extends Part implements SimpleEventReceiver<SimpleBaseEvent> {
    private static final int G = l.b(168);
    private static final int H = l.b(11);
    private static final int I = l.b(14);
    private static final int J = l.b(14);

    /* renamed from: C, reason: from kotlin metadata */
    private GridLayoutManager layoutManager;

    /* renamed from: D, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* renamed from: E, reason: from kotlin metadata */
    private long partnerId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int width;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private SmartRefreshLayout refreshLayout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private RecyclerView recyclerView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private RFWConcatAdapter concatAdapter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private i82.a dataListAdapter;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private j82.a itemDecoration;

    public QQStrangerSignalSquareSmartRefreshPart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QQStrangerSignalSquareViewModel>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.signal.square.part.QQStrangerSignalSquareSmartRefreshPart$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final QQStrangerSignalSquareViewModel invoke() {
                return (QQStrangerSignalSquareViewModel) QQStrangerSignalSquareSmartRefreshPart.this.getViewModel(QQStrangerSignalSquareViewModel.class);
            }
        });
        this.viewModel = lazy;
    }

    private final int D9(int count) {
        if (b71.a.a(getContext())) {
            return E9(count);
        }
        return H;
    }

    private final int E9(int count) {
        int i3 = this.width - (G * count);
        return count == 1 ? i3 : i3 / (count - 1);
    }

    private final int F9() {
        int i3 = this.width;
        int i16 = G;
        int i17 = H;
        int i18 = i3 / (i16 + i17);
        return i3 - ((i16 * i18) + (i17 * (i18 + (-1)))) >= i16 ? i18 + 1 : i18;
    }

    private final int G9() {
        if (b71.a.a(getContext())) {
            return F9();
        }
        return 2;
    }

    private final QQStrangerSignalSquareViewModel H9() {
        return (QQStrangerSignalSquareViewModel) this.viewModel.getValue();
    }

    private final void I9() {
        SmartRefreshLayout smartRefreshLayout = this.refreshLayout;
        if (smartRefreshLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
            smartRefreshLayout = null;
        }
        smartRefreshLayout.setVisibility(8);
        SimpleEventBus.getInstance().dispatchEvent(QQStrangerSignalSquareEmptyEvent.INSTANCE);
    }

    private final void J9() {
        SmartRefreshLayout smartRefreshLayout = this.refreshLayout;
        if (smartRefreshLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
            smartRefreshLayout = null;
        }
        smartRefreshLayout.setVisibility(8);
        SimpleEventBus.getInstance().dispatchEvent(QQStrangerSignalSquareErrorEvent.INSTANCE);
    }

    private final void K9() {
        SmartRefreshLayout smartRefreshLayout = this.refreshLayout;
        if (smartRefreshLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
            smartRefreshLayout = null;
        }
        smartRefreshLayout.setVisibility(0);
        SimpleEventBus.getInstance().dispatchEvent(QQStrangerSignalSquareShowContentViewEvent.INSTANCE);
    }

    private final void L9() {
        i82.a aVar = new i82.a();
        aVar.setHasStableIds(true);
        this.dataListAdapter = aVar;
        RFWConcatAdapter.Config build = new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build();
        RecyclerView.Adapter[] adapterArr = new RecyclerView.Adapter[1];
        i82.a aVar2 = this.dataListAdapter;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataListAdapter");
            aVar2 = null;
        }
        adapterArr[0] = aVar2;
        this.concatAdapter = new RFWConcatAdapter(build, (RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) adapterArr);
    }

    private final void M9() {
        View findViewById = getPartRootView().findViewById(R.id.f163177oq1);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026nger_square_recyclerview)");
        this.recyclerView = (RecyclerView) findViewById;
        int G9 = G9();
        this.layoutManager = new SafeGridLayoutManager(getContext(), G9);
        RecyclerView recyclerView = this.recyclerView;
        RFWConcatAdapter rFWConcatAdapter = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        GridLayoutManager gridLayoutManager = this.layoutManager;
        if (gridLayoutManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
            gridLayoutManager = null;
        }
        recyclerView.setLayoutManager(gridLayoutManager);
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView2 = null;
        }
        RFWConcatAdapter rFWConcatAdapter2 = this.concatAdapter;
        if (rFWConcatAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("concatAdapter");
        } else {
            rFWConcatAdapter = rFWConcatAdapter2;
        }
        recyclerView2.setAdapter(rFWConcatAdapter);
        U9(G9);
    }

    private final void N9() {
        View findViewById = getPartRootView().findViewById(R.id.f163178oq2);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026ger_square_refreshlayout)");
        SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) findViewById;
        this.refreshLayout = smartRefreshLayout;
        if (smartRefreshLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
            smartRefreshLayout = null;
        }
        smartRefreshLayout.a(true);
        smartRefreshLayout.setEnableLoadMore(true);
        smartRefreshLayout.Q(true);
        smartRefreshLayout.setEnableOverScrollDrag(true);
        smartRefreshLayout.S(false);
        smartRefreshLayout.R(true);
        Context context = smartRefreshLayout.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        MainRefreshHeader mainRefreshHeader = new MainRefreshHeader(context);
        mainRefreshHeader.setLoadingText(R.string.x19);
        smartRefreshLayout.b(mainRefreshHeader);
        Context context2 = smartRefreshLayout.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        smartRefreshLayout.X(new MainRefreshFooter(context2));
        smartRefreshLayout.l(new r3.h() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.signal.square.part.b
            @Override // r3.h
            public final void e(q3.f fVar) {
                QQStrangerSignalSquareSmartRefreshPart.O9(QQStrangerSignalSquareSmartRefreshPart.this, fVar);
            }
        });
        smartRefreshLayout.W(new r3.e() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.signal.square.part.c
            @Override // r3.e
            public final void E6(q3.f fVar) {
                QQStrangerSignalSquareSmartRefreshPart.P9(QQStrangerSignalSquareSmartRefreshPart.this, fVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O9(QQStrangerSignalSquareSmartRefreshPart this$0, q3.f it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.H9().P1(this$0.partnerId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(QQStrangerSignalSquareSmartRefreshPart this$0, q3.f it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.H9().O1(this$0.partnerId);
    }

    private final void Q9() {
        int e16;
        int i3;
        Configuration configuration = getContext().getResources().getConfiguration();
        boolean z16 = false;
        if (configuration != null && configuration.orientation == 2) {
            z16 = true;
        }
        if (z16) {
            e16 = ViewUtils.f352270a.d() - I;
            i3 = J;
        } else {
            e16 = ViewUtils.f352270a.e() - I;
            i3 = J;
        }
        this.width = e16 - i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T9(QQStrangerSignalInfoResult result) {
        QLog.d("QQStrangerSquareSmartRefreshPart", 1, "onUpdateSignalList isRefresh=" + result.getIsRefresh() + " isSuccess=" + result.getIsSuccess() + " feedListSize=" + result.b().size() + " noMore=" + result.getNoMore());
        i82.a aVar = this.dataListAdapter;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataListAdapter");
            aVar = null;
        }
        aVar.setItems(result.b());
        V9(result.getNoMore(), result.b().isEmpty());
        if (result.getIsRefresh() && !result.getIsSuccess()) {
            J9();
        } else if (result.getIsRefresh() && result.b().isEmpty() && !result.getIsCacheData()) {
            I9();
        } else {
            K9();
        }
        if (result.getIsSuccess() || !(!result.b().isEmpty())) {
            return;
        }
        QQToast.makeText(getContext(), 1, R.string.x3b, 0).show();
    }

    private final void U9(int spanCount) {
        j82.a aVar = new j82.a(spanCount, l.b(10), D9(spanCount));
        this.itemDecoration = aVar;
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        recyclerView.addItemDecoration(aVar);
    }

    private final void V9(boolean noMoreData, boolean isEmpty) {
        SmartRefreshLayout smartRefreshLayout = this.refreshLayout;
        if (smartRefreshLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
            smartRefreshLayout = null;
        }
        if (smartRefreshLayout.K()) {
            if (noMoreData) {
                smartRefreshLayout.V(true);
            } else {
                smartRefreshLayout.finishRefresh();
            }
        } else if (smartRefreshLayout.J()) {
            smartRefreshLayout.z(200, true, noMoreData);
        } else {
            smartRefreshLayout.V(noMoreData);
        }
        smartRefreshLayout.S(!isEmpty);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Q9();
        int G9 = G9();
        GridLayoutManager gridLayoutManager = this.layoutManager;
        RecyclerView recyclerView = null;
        if (gridLayoutManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
            gridLayoutManager = null;
        }
        gridLayoutManager.setSpanCount(G9);
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView2 = null;
        }
        j82.a aVar = this.itemDecoration;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemDecoration");
            aVar = null;
        }
        recyclerView2.removeItemDecoration(aVar);
        U9(G9);
        GridLayoutManager gridLayoutManager2 = this.layoutManager;
        if (gridLayoutManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
            gridLayoutManager2 = null;
        }
        gridLayoutManager2.requestLayout();
        RecyclerView recyclerView3 = this.recyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        } else {
            recyclerView = recyclerView3;
        }
        recyclerView.requestLayout();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        Q9();
        N9();
        L9();
        M9();
        H9().P1(this.partnerId);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartCreate(activity, savedInstanceState);
        this.partnerId = activity.getIntent().getLongExtra("param_partner_id", 0L);
        SimpleEventBus.getInstance().registerReceiver(this);
        LiveData<QQStrangerSignalInfoResult> N1 = H9().N1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final QQStrangerSignalSquareSmartRefreshPart$onPartCreate$1 qQStrangerSignalSquareSmartRefreshPart$onPartCreate$1 = new QQStrangerSignalSquareSmartRefreshPart$onPartCreate$1(this);
        N1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.signal.square.part.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQStrangerSignalSquareSmartRefreshPart.R9(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        LiveData<QQStrangerSignalInfoResult> N1 = H9().N1();
        final QQStrangerSignalSquareSmartRefreshPart$onPartDestroy$1 qQStrangerSignalSquareSmartRefreshPart$onPartDestroy$1 = new QQStrangerSignalSquareSmartRefreshPart$onPartDestroy$1(this);
        N1.removeObserver(new Observer() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.signal.square.part.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQStrangerSignalSquareSmartRefreshPart.S9(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof QQStrangerSignalSquareRefreshEvent) {
            H9().P1(this.partnerId);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QQStrangerSignalSquareRefreshEvent.class);
        return arrayListOf;
    }
}
