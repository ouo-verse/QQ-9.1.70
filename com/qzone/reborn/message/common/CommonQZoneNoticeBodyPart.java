package com.qzone.reborn.message.common;

import android.app.Activity;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import bl.CommonNoticeBean;
import com.qzone.reborn.base.k;
import com.qzone.reborn.configx.g;
import com.qzone.reborn.feedx.block.aa;
import com.qzone.reborn.message.common.CommonQZoneNoticeBodyPart;
import com.qzone.reborn.widget.QZoneBlankStateView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
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
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import tl.h;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\bH\u0010IJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\u001c\u0010\r\u001a\u00020\u00052\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tH\u0002J\u001c\u0010\u000e\u001a\u00020\u00052\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tH\u0002J\b\u0010\u000f\u001a\u00020\u0005H\u0002J\b\u0010\u0010\u001a\u00020\u0005H\u0002J\u001c\u0010\u0011\u001a\u00020\u00052\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tH\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\u0012\u0010\u0019\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u001a\u001a\u00020\u0005H\u0016J\b\u0010\u001c\u001a\u00020\u001bH&J\u000e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001dH&J\u001c\u0010 \u001a\u00020\u00052\u0012\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tH\u0016J\b\u0010!\u001a\u00020\u0005H\u0016J\u0010\u0010#\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u0015H\u0016J\u000e\u0010&\u001a\u00020\u00052\u0006\u0010%\u001a\u00020$R\"\u0010.\u001a\u00020'8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u001c\u0010A\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010D\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010G\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010F\u00a8\u0006J"}, d2 = {"Lcom/qzone/reborn/message/common/CommonQZoneNoticeBodyPart;", "Lcom/qzone/reborn/base/k;", "Lcom/tencent/biz/richframework/preload/recyclerview/ILoadMoreProvider$LoadMoreListener;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "R9", "G9", "initData", "Lcom/tencent/richframework/data/base/UIStateData;", "", "Lbl/a;", "listUIStateData", "L9", "K9", "P9", "V9", "W9", "", "getLogTag", "onInitView", "", "T9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "initViewModel", "Lcom/qzone/reborn/message/common/e;", "I9", "Lcom/qzone/reborn/base/h;", "H9", "uiStateData", "M9", "onLoadMoreStart", "hasMore", "onLoadMoreEnd", "", "itemCount", "O9", "Landroidx/recyclerview/widget/RecyclerView;", "d", "Landroidx/recyclerview/widget/RecyclerView;", "J9", "()Landroidx/recyclerview/widget/RecyclerView;", "U9", "(Landroidx/recyclerview/widget/RecyclerView;)V", "recyclerView", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "e", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "concatAdapter", "Lcom/tencent/richframework/widget/refresh/layout/SmartRefreshLayout;", "f", "Lcom/tencent/richframework/widget/refresh/layout/SmartRefreshLayout;", "refreshLayout", "Lcom/qzone/reborn/feedx/block/aa;", h.F, "Lcom/qzone/reborn/feedx/block/aa;", "loadMoreAdapter", "Lcom/qzone/reborn/widget/QZoneBlankStateView;", "i", "Lcom/qzone/reborn/widget/QZoneBlankStateView;", "blankView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/qzone/reborn/base/h;", "messageAdapter", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/reborn/message/common/e;", "messageViewModel", "D", "Z", "hasInit", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public abstract class CommonQZoneNoticeBodyPart extends k implements ILoadMoreProvider$LoadMoreListener {

    /* renamed from: C, reason: from kotlin metadata */
    private e messageViewModel;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean hasInit;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    protected RecyclerView recyclerView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private RFWConcatAdapter concatAdapter;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private SmartRefreshLayout refreshLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private aa loadMoreAdapter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private QZoneBlankStateView blankView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private com.qzone.reborn.base.h<CommonNoticeBean> messageAdapter;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/qzone/reborn/message/common/CommonQZoneNoticeBodyPart$a", "Landroidx/recyclerview/widget/RecyclerView$OnChildAttachStateChangeListener;", "Landroid/view/View;", "view", "", "onChildViewAttachedToWindow", "onChildViewDetachedFromWindow", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class a implements RecyclerView.OnChildAttachStateChangeListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f58240e;

        a(int i3) {
            this.f58240e = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(List containerViews) {
            Intrinsics.checkNotNullParameter(containerViews, "$containerViews");
            Iterator it = containerViews.iterator();
            while (it.hasNext()) {
                View view = (View) it.next();
                if (view != null) {
                    view.setBackgroundResource(R.drawable.qui_common_fill_light_primary_bg_selector);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
        public void onChildViewAttachedToWindow(View view) {
            IntRange until;
            int collectionSizeOrDefault;
            View view2;
            Intrinsics.checkNotNullParameter(view, "view");
            int childAdapterPosition = CommonQZoneNoticeBodyPart.this.J9().getChildAdapterPosition(view);
            RFWLog.d(CommonQZoneNoticeBodyPart.this.getTAG(), RFWLog.USR, "[OnChildAttach] pos: " + childAdapterPosition);
            if (childAdapterPosition < this.f58240e) {
                return;
            }
            CommonQZoneNoticeBodyPart.this.J9().removeOnChildAttachStateChangeListener(this);
            until = RangesKt___RangesKt.until(0, this.f58240e);
            CommonQZoneNoticeBodyPart commonQZoneNoticeBodyPart = CommonQZoneNoticeBodyPart.this;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(until, 10);
            final ArrayList<View> arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<Integer> it = until.iterator();
            while (it.hasNext()) {
                RecyclerView.ViewHolder findViewHolderForAdapterPosition = commonQZoneNoticeBodyPart.J9().findViewHolderForAdapterPosition(((IntIterator) it).nextInt());
                arrayList.add((findViewHolderForAdapterPosition == null || (view2 = findViewHolderForAdapterPosition.itemView) == null) ? null : view2.findViewById(R.id.n7c));
            }
            int color = CommonQZoneNoticeBodyPart.this.getContext().getColor(R.color.qui_common_overlay_light);
            for (View view3 : arrayList) {
                if (view3 != null) {
                    view3.setBackgroundResource(0);
                }
                if (view3 != null) {
                    view3.setBackgroundColor(color);
                }
            }
            CommonQZoneNoticeBodyPart.this.J9().postDelayed(new Runnable() { // from class: com.qzone.reborn.message.common.d
                @Override // java.lang.Runnable
                public final void run() {
                    CommonQZoneNoticeBodyPart.a.b(arrayList);
                }
            }, 3000L);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
        public void onChildViewDetachedFromWindow(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
        }
    }

    private final void G9() {
        com.qzone.reborn.base.h<CommonNoticeBean> H9 = H9();
        H9.setHasStableIds(true);
        this.messageAdapter = H9;
        aa aaVar = new aa();
        aaVar.registerLoadMoreListener(this);
        aaVar.setHasStableIds(true);
        aaVar.p0(new aa.a().e(HardCodeUtil.qqStr(R.string.w_3)).f(HardCodeUtil.qqStr(R.string.w_x)));
        this.loadMoreAdapter = aaVar;
        RFWConcatAdapter.Config build = new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build();
        RecyclerView.Adapter[] adapterArr = new RecyclerView.Adapter[2];
        com.qzone.reborn.base.h<CommonNoticeBean> hVar = this.messageAdapter;
        RFWConcatAdapter rFWConcatAdapter = null;
        if (hVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageAdapter");
            hVar = null;
        }
        adapterArr[0] = hVar;
        aa aaVar2 = this.loadMoreAdapter;
        if (aaVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadMoreAdapter");
            aaVar2 = null;
        }
        adapterArr[1] = aaVar2;
        this.concatAdapter = new RFWConcatAdapter(build, (RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) adapterArr);
        RecyclerView J9 = J9();
        RFWConcatAdapter rFWConcatAdapter2 = this.concatAdapter;
        if (rFWConcatAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("concatAdapter");
        } else {
            rFWConcatAdapter = rFWConcatAdapter2;
        }
        J9.setAdapter(rFWConcatAdapter);
    }

    private final void K9(UIStateData<List<CommonNoticeBean>> listUIStateData) {
        com.qzone.reborn.base.h<CommonNoticeBean> hVar = this.messageAdapter;
        if (hVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageAdapter");
            hVar = null;
        }
        hVar.setItems(listUIStateData.getData());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L9(UIStateData<List<CommonNoticeBean>> listUIStateData) {
        QLog.i(getTAG(), 1, "handleMessageListRsp()  state = " + listUIStateData.getState());
        int state = listUIStateData.getState();
        if (state == 0) {
            V9();
        } else if (state == 2 || state == 3) {
            M9(listUIStateData);
        } else if (state == 4) {
            W9(listUIStateData);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(CommonQZoneNoticeBodyPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.J9().scrollToPosition(0);
    }

    private final void P9() {
        String A = g.f53821a.h().A();
        QZoneBlankStateView qZoneBlankStateView = this.blankView;
        if (qZoneBlankStateView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blankView");
            qZoneBlankStateView = null;
        }
        qZoneBlankStateView.setData(com.qzone.reborn.feedx.util.k.e(getContext(), A));
        QLog.d(getTAG(), 1, "[initBlankViewData] emptyMsg = " + A);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S9(CommonQZoneNoticeBodyPart this$0, IRefreshLayout it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        e eVar = this$0.messageViewModel;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageViewModel");
            eVar = null;
        }
        eVar.S0();
    }

    private final void V9() {
        J9().setVisibility(4);
        QZoneBlankStateView qZoneBlankStateView = this.blankView;
        if (qZoneBlankStateView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blankView");
            qZoneBlankStateView = null;
        }
        qZoneBlankStateView.s0();
    }

    private final void W9(UIStateData<List<CommonNoticeBean>> listUIStateData) {
        if (listUIStateData.getIsLoadMore()) {
            return;
        }
        J9().setVisibility(4);
        QZoneBlankStateView qZoneBlankStateView = this.blankView;
        if (qZoneBlankStateView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blankView");
            qZoneBlankStateView = null;
        }
        qZoneBlankStateView.showErrorView();
    }

    private final void initData() {
        e eVar = this.messageViewModel;
        e eVar2 = null;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageViewModel");
            eVar = null;
        }
        LiveData<UIStateData<List<CommonNoticeBean>>> v3 = eVar.v();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<UIStateData<List<? extends CommonNoticeBean>>, Unit> function1 = new Function1<UIStateData<List<? extends CommonNoticeBean>>, Unit>() { // from class: com.qzone.reborn.message.common.CommonQZoneNoticeBodyPart$initData$1
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
                CommonQZoneNoticeBodyPart commonQZoneNoticeBodyPart = CommonQZoneNoticeBodyPart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                commonQZoneNoticeBodyPart.L9(it);
            }
        };
        v3.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.message.common.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CommonQZoneNoticeBodyPart.Q9(Function1.this, obj);
            }
        });
        if (T9()) {
            return;
        }
        e eVar3 = this.messageViewModel;
        if (eVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageViewModel");
        } else {
            eVar2 = eVar3;
        }
        eVar2.S0();
        this.hasInit = true;
    }

    public abstract com.qzone.reborn.base.h<CommonNoticeBean> H9();

    public abstract e I9();

    protected final RecyclerView J9() {
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView != null) {
            return recyclerView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        return null;
    }

    public void M9(UIStateData<List<CommonNoticeBean>> uiStateData) {
        Intrinsics.checkNotNullParameter(uiStateData, "uiStateData");
        if (bl.b(uiStateData.getData())) {
            V9();
            return;
        }
        J9().setVisibility(0);
        QZoneBlankStateView qZoneBlankStateView = this.blankView;
        aa aaVar = null;
        if (qZoneBlankStateView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blankView");
            qZoneBlankStateView = null;
        }
        qZoneBlankStateView.o0();
        com.qzone.reborn.base.h<CommonNoticeBean> hVar = this.messageAdapter;
        if (hVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageAdapter");
            hVar = null;
        }
        hVar.setItems(uiStateData.getData());
        if (!uiStateData.getIsLoadMore()) {
            RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.qzone.reborn.message.common.c
                @Override // java.lang.Runnable
                public final void run() {
                    CommonQZoneNoticeBodyPart.N9(CommonQZoneNoticeBodyPart.this);
                }
            }, 100L);
        }
        aa aaVar2 = this.loadMoreAdapter;
        if (aaVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadMoreAdapter");
            aaVar2 = null;
        }
        aaVar2.resetAutoLoadMoreTimes();
        aa aaVar3 = this.loadMoreAdapter;
        if (aaVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadMoreAdapter");
        } else {
            aaVar = aaVar3;
        }
        aaVar.setMaxAutoLoadMoreTimes(3);
    }

    public boolean T9() {
        return false;
    }

    protected final void U9(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "<set-?>");
        this.recyclerView = recyclerView;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "CommonQZoneNoticeBodyPart";
    }

    public void initViewModel() {
        this.messageViewModel = I9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        R9(rootView);
        G9();
        P9();
        initViewModel();
        initData();
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreEnd(boolean hasMore) {
        QLog.d(getTAG(), 1, "onLoadMoreEnd  hasMore = " + hasMore);
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreStart() {
        QLog.d(getTAG(), 1, "onLoadMoreStart ");
        e eVar = this.messageViewModel;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageViewModel");
            eVar = null;
        }
        eVar.F();
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

    public final void O9(int itemCount) {
        if (itemCount <= 0) {
            RFWLog.d(getTAG(), RFWLog.USR, "[highlightLatestItemView] itemCount: " + itemCount + " is invalid");
            return;
        }
        J9().addOnChildAttachStateChangeListener(new a(itemCount));
    }

    private final void R9(View rootView) {
        View findViewById = rootView.findViewById(R.id.mqu);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.qzone_blank_view)");
        this.blankView = (QZoneBlankStateView) findViewById;
        View findViewById2 = rootView.findViewById(R.id.f162917nb2);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.qzone_rv_list)");
        U9((RecyclerView) findViewById2);
        View findViewById3 = rootView.findViewById(R.id.nbb);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.\u2026one_smart_refresh_layout)");
        SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) findViewById3;
        this.refreshLayout = smartRefreshLayout;
        if (smartRefreshLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
            smartRefreshLayout = null;
        }
        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() { // from class: com.qzone.reborn.message.common.b
            @Override // com.tencent.richframework.widget.refresh.layout.listener.OnRefreshListener
            public final void onRefresh(IRefreshLayout iRefreshLayout) {
                CommonQZoneNoticeBodyPart.S9(CommonQZoneNoticeBodyPart.this, iRefreshLayout);
            }
        });
        SmartRefreshLayout smartRefreshLayout2 = this.refreshLayout;
        if (smartRefreshLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
            smartRefreshLayout2 = null;
        }
        smartRefreshLayout2.setEnableOverScrollDrag(true);
        J9().setNestedScrollingEnabled(true);
        J9().setLayoutManager(new SafeLinearLayoutManager(getContext()));
        J9().setItemAnimator(null);
    }
}
