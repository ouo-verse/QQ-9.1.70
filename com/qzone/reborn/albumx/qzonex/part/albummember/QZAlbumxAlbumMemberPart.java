package com.qzone.reborn.albumx.qzonex.part.albummember;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.reborn.albumx.qzonex.bean.initbean.QZAlbumxAlbumMemberInitBean;
import com.qzone.reborn.albumx.qzonex.event.QZAlbumxUpdateAlbumEvent;
import com.qzone.reborn.base.k;
import com.qzone.reborn.widget.QZoneBlankStateView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.bl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.widget.refresh.layout.SmartRefreshLayout;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshLayout;
import com.tencent.richframework.widget.refresh.layout.listener.OnRefreshListener;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import nc.ao;
import tl.h;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 22\u00020\u0001:\u00013B\u0007\u00a2\u0006\u0004\b0\u00101J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\u0016\u0010\u000e\u001a\u00020\u00022\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\u0016\u0010\u000f\u001a\u00020\u00022\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\u0016\u0010\u0011\u001a\u00020\u00022\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0014\u001a\u00020\u0002H\u0002J\b\u0010\u0015\u001a\u00020\u0002H\u0002J\u0016\u0010\u0016\u001a\u00020\u00022\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\b\u0010\u0017\u001a\u00020\u0012H\u0016J\u0010\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0012\u0010\u001b\u001a\u00020\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016R\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.\u00a8\u00064"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/part/albummember/QZAlbumxAlbumMemberPart;", "Lcom/qzone/reborn/base/k;", "", "M9", "Lnc/ao;", "G9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "O9", "F9", "initData", "Lcom/tencent/richframework/data/base/UIStateData;", "Lya/a;", "listUIStateData", "I9", "J9", "uiStateData", "K9", "", "H9", "L9", "Q9", "R9", "getLogTag", "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "Lsa/c;", "d", "Lsa/c;", "albumAdapter", "Landroidx/recyclerview/widget/RecyclerView;", "e", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "f", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "concatAdapter", "Lcom/tencent/richframework/widget/refresh/layout/SmartRefreshLayout;", h.F, "Lcom/tencent/richframework/widget/refresh/layout/SmartRefreshLayout;", "refreshLayout", "Lcom/qzone/reborn/widget/QZoneBlankStateView;", "i", "Lcom/qzone/reborn/widget/QZoneBlankStateView;", "blankView", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZAlbumxAlbumMemberPart extends k {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private sa.c albumAdapter;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private RecyclerView recyclerView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private RFWConcatAdapter concatAdapter;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private SmartRefreshLayout refreshLayout;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private QZoneBlankStateView blankView;

    private final void F9() {
        sa.c cVar = new sa.c();
        this.albumAdapter = cVar;
        cVar.setHasStableIds(true);
        RFWConcatAdapter.Config build = new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build();
        RecyclerView.Adapter[] adapterArr = new RecyclerView.Adapter[1];
        sa.c cVar2 = this.albumAdapter;
        RFWConcatAdapter rFWConcatAdapter = null;
        if (cVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("albumAdapter");
            cVar2 = null;
        }
        adapterArr[0] = cVar2;
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

    private final ao G9() {
        return (ao) getViewModel(ao.class);
    }

    private final String H9() {
        String string = getContext().getString(R.string.f1341784);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026lbumx_album_member_empty)");
        return string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I9(UIStateData<ya.a> listUIStateData) {
        QLog.i("QZAlbumxAlbumMemberPart", 1, "handleAlbumListRsp()  state = " + listUIStateData.getState());
        int state = listUIStateData.getState();
        if (state == 0) {
            Q9();
        } else if (state == 2 || state == 3) {
            K9(listUIStateData);
        } else if (state == 4) {
            R9(listUIStateData);
        } else if (state == 6 || state == 7) {
            J9(listUIStateData);
        }
        SmartRefreshLayout smartRefreshLayout = this.refreshLayout;
        if (smartRefreshLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
            smartRefreshLayout = null;
        }
        smartRefreshLayout.finishRefresh();
    }

    private final void J9(UIStateData<ya.a> listUIStateData) {
        sa.c cVar = this.albumAdapter;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("albumAdapter");
            cVar = null;
        }
        cVar.setItems(new ArrayList(listUIStateData.getData().a()));
    }

    private final void K9(UIStateData<ya.a> uiStateData) {
        if (bl.b(uiStateData.getData().a())) {
            Q9();
            return;
        }
        RecyclerView recyclerView = this.recyclerView;
        sa.c cVar = null;
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
        sa.c cVar2 = this.albumAdapter;
        if (cVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("albumAdapter");
        } else {
            cVar = cVar2;
        }
        cVar.setItems(new ArrayList(uiStateData.getData().a()));
    }

    private final void L9() {
        String H9 = H9();
        QZoneBlankStateView qZoneBlankStateView = this.blankView;
        if (qZoneBlankStateView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blankView");
            qZoneBlankStateView = null;
        }
        qZoneBlankStateView.setData(com.qzone.reborn.feedx.util.k.n(getContext(), H9));
        QLog.d("QZAlbumxAlbumMemberPart", 1, "[initBlankViewData] emptyMsg = " + H9);
    }

    private final void M9() {
        ao G9;
        MutableLiveData<UIStateData<ya.a>> U1;
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        if (lifecycleOwner == null || (G9 = G9()) == null || (U1 = G9.U1()) == null) {
            return;
        }
        final Function1<UIStateData<ya.a>, Unit> function1 = new Function1<UIStateData<ya.a>, Unit>() { // from class: com.qzone.reborn.albumx.qzonex.part.albummember.QZAlbumxAlbumMemberPart$initObserve$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UIStateData<ya.a> uIStateData) {
                invoke2(uIStateData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(UIStateData<ya.a> uIStateData) {
                if (uIStateData == null) {
                    return;
                }
                QZAlbumxAlbumMemberPart.this.I9(uIStateData);
            }
        };
        U1.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.albumx.qzonex.part.albummember.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZAlbumxAlbumMemberPart.N9(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(QZAlbumxAlbumMemberPart this$0, IRefreshLayout it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        ao G9 = this$0.G9();
        if (G9 != null) {
            G9.W1();
        }
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

    private final void R9(UIStateData<ya.a> listUIStateData) {
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
        M9();
        ao G9 = G9();
        if (G9 != null) {
            G9.W1();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZAlbumxAlbumMemberPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        O9(rootView);
        F9();
        initData();
        L9();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        String str;
        QZAlbumxAlbumMemberInitBean initBean;
        super.onPartDestroy(activity);
        ao G9 = G9();
        boolean z16 = false;
        if (G9 != null && G9.getIsRemoveMember()) {
            z16 = true;
        }
        if (z16) {
            SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
            ao G92 = G9();
            if (G92 == null || (initBean = G92.getInitBean()) == null || (str = initBean.getAlbumId()) == null) {
                str = "";
            }
            simpleEventBus.dispatchEvent(new QZAlbumxUpdateAlbumEvent(str));
        }
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
        RecyclerView recyclerView = null;
        if (smartRefreshLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
            smartRefreshLayout = null;
        }
        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() { // from class: com.qzone.reborn.albumx.qzonex.part.albummember.c
            @Override // com.tencent.richframework.widget.refresh.layout.listener.OnRefreshListener
            public final void onRefresh(IRefreshLayout iRefreshLayout) {
                QZAlbumxAlbumMemberPart.P9(QZAlbumxAlbumMemberPart.this, iRefreshLayout);
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
            recyclerView5 = null;
        }
        recyclerView5.setBackground(getContext().getDrawable(R.drawable.f14011a));
        RecyclerView recyclerView6 = this.recyclerView;
        if (recyclerView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        } else {
            recyclerView = recyclerView6;
        }
        ViewGroup.LayoutParams layoutParams = recyclerView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        layoutParams2.height = -2;
        layoutParams2.leftMargin = ViewUtils.dip2px(16.0f);
        layoutParams2.topMargin = ViewUtils.dip2px(16.0f);
        layoutParams2.rightMargin = ViewUtils.dip2px(16.0f);
    }
}
