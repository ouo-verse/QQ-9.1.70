package com.qzone.reborn.albumx.common.part.selectalbum;

import android.content.Intent;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.reborn.base.k;
import com.qzone.reborn.feedx.block.aa;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.richframework.widget.refresh.layout.SmartRefreshLayout;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshLayout;
import com.tencent.richframework.widget.refresh.layout.listener.OnRefreshListener;
import cooperation.qzone.QzoneIPCModule;
import i9.l;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import l9.i;
import l9.j;
import tl.h;

@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b&\u0018\u0000 @2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0001AB\u0007\u00a2\u0006\u0004\b>\u0010?J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u001e\u0010\r\u001a\u00020\u00062\u0014\u0010\f\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0018\u00010\tH\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0002J\u001c\u0010\u000f\u001a\u00020\u00062\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tH\u0002J\u001c\u0010\u0010\u001a\u00020\u00062\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tH\u0002J\b\u0010\u0012\u001a\u00020\u0011H$J\u0012\u0010\u0015\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0006H\u0016J\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\"\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001a2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016R\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u001b\u00101\u001a\u00020,8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b7\u00108R\u001b\u0010=\u001a\u00020\u00118DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b:\u0010.\u001a\u0004\b;\u0010<\u00a8\u0006B"}, d2 = {"Lcom/qzone/reborn/albumx/common/part/selectalbum/CommonSelectAlbumListPart;", "Lcom/qzone/reborn/base/k;", "Lcom/tencent/biz/richframework/preload/recyclerview/ILoadMoreProvider$LoadMoreListener;", "Ll9/i;", "Ll9/j;", "Ll9/k;", "", "G9", "initData", "Lcom/tencent/richframework/data/base/UIStateData;", "", "Lcom/qzone/reborn/albumx/common/bean/h;", "listUIStateData", "K9", "handleEmptyState", "L9", "M9", "Lcom/qzone/reborn/albumx/common/viewmodel/l;", "H9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "onLoadMoreStart", "", "hasMore", "onLoadMoreEnd", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "Lcom/tencent/richframework/widget/refresh/layout/SmartRefreshLayout;", "d", "Lcom/tencent/richframework/widget/refresh/layout/SmartRefreshLayout;", "refreshLayout", "Landroidx/recyclerview/widget/RecyclerView;", "e", "Landroidx/recyclerview/widget/RecyclerView;", "rv", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "f", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "concatAdapter", "Li9/k;", h.F, "Lkotlin/Lazy;", "I9", "()Li9/k;", "createAlbumAdapter", "Li9/l;", "i", "Li9/l;", "albumListAdapter", "Lcom/qzone/reborn/feedx/block/aa;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/qzone/reborn/feedx/block/aa;", "loadMoreAdapter", BdhLogUtil.LogTag.Tag_Conn, "J9", "()Lcom/qzone/reborn/albumx/common/viewmodel/l;", "vm", "<init>", "()V", "D", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public abstract class CommonSelectAlbumListPart extends k implements ILoadMoreProvider$LoadMoreListener, i, j, l9.k {

    /* renamed from: C, reason: from kotlin metadata */
    private final Lazy vm;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private SmartRefreshLayout refreshLayout;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private RecyclerView rv;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private RFWConcatAdapter concatAdapter;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Lazy createAlbumAdapter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private l albumListAdapter;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private aa loadMoreAdapter;

    public CommonSelectAlbumListPart() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<i9.k>() { // from class: com.qzone.reborn.albumx.common.part.selectalbum.CommonSelectAlbumListPart$createAlbumAdapter$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final i9.k invoke() {
                i9.k kVar = new i9.k();
                kVar.setHasStableIds(true);
                return kVar;
            }
        });
        this.createAlbumAdapter = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<com.qzone.reborn.albumx.common.viewmodel.l>() { // from class: com.qzone.reborn.albumx.common.part.selectalbum.CommonSelectAlbumListPart$vm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.qzone.reborn.albumx.common.viewmodel.l invoke() {
                return CommonSelectAlbumListPart.this.H9();
            }
        });
        this.vm = lazy2;
    }

    private final void G9() {
        l lVar = new l();
        lVar.setHasStableIds(true);
        this.albumListAdapter = lVar;
        aa aaVar = new aa();
        aaVar.setHasStableIds(true);
        aaVar.registerLoadMoreListener(this);
        aaVar.p0(new aa.a().e(HardCodeUtil.qqStr(R.string.to_)).f(HardCodeUtil.qqStr(R.string.toa)));
        this.loadMoreAdapter = aaVar;
        this.concatAdapter = new RFWConcatAdapter(new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build(), (RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) new RecyclerView.Adapter[0]);
        RFWConcatAdapter rFWConcatAdapter = null;
        if (J9().Q1()) {
            RFWConcatAdapter rFWConcatAdapter2 = this.concatAdapter;
            if (rFWConcatAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("concatAdapter");
                rFWConcatAdapter2 = null;
            }
            rFWConcatAdapter2.addAdapter(I9());
        }
        RFWConcatAdapter rFWConcatAdapter3 = this.concatAdapter;
        if (rFWConcatAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("concatAdapter");
            rFWConcatAdapter3 = null;
        }
        l lVar2 = this.albumListAdapter;
        if (lVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("albumListAdapter");
            lVar2 = null;
        }
        rFWConcatAdapter3.addAdapter(lVar2);
        aa aaVar2 = this.loadMoreAdapter;
        if (aaVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadMoreAdapter");
            aaVar2 = null;
        }
        rFWConcatAdapter3.addAdapter(aaVar2);
        RecyclerView recyclerView = this.rv;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rv");
            recyclerView = null;
        }
        RFWConcatAdapter rFWConcatAdapter4 = this.concatAdapter;
        if (rFWConcatAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("concatAdapter");
        } else {
            rFWConcatAdapter = rFWConcatAdapter4;
        }
        recyclerView.setAdapter(rFWConcatAdapter);
    }

    private final i9.k I9() {
        return (i9.k) this.createAlbumAdapter.getValue();
    }

    private final void L9(UIStateData<List<com.qzone.reborn.albumx.common.bean.h>> listUIStateData) {
        if (listUIStateData.getIsLoadMore()) {
            return;
        }
        RecyclerView recyclerView = this.rv;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rv");
            recyclerView = null;
        }
        recyclerView.setVisibility(4);
    }

    private final void M9(UIStateData<List<com.qzone.reborn.albumx.common.bean.h>> listUIStateData) {
        RFWLog.i("CommonSelectAlbumListPart", RFWLog.USR, "handleSuccessState, size:" + listUIStateData.getData().size());
        RecyclerView recyclerView = this.rv;
        l lVar = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rv");
            recyclerView = null;
        }
        recyclerView.setVisibility(0);
        l lVar2 = this.albumListAdapter;
        if (lVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("albumListAdapter");
        } else {
            lVar = lVar2;
        }
        lVar.setItems(new ArrayList(listUIStateData.getData()));
        if (listUIStateData.getIsLoadMore()) {
            return;
        }
        RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.qzone.reborn.albumx.common.part.selectalbum.d
            @Override // java.lang.Runnable
            public final void run() {
                CommonSelectAlbumListPart.N9(CommonSelectAlbumListPart.this);
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(CommonSelectAlbumListPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RecyclerView recyclerView = this$0.rv;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rv");
            recyclerView = null;
        }
        recyclerView.scrollToPosition(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(CommonSelectAlbumListPart this$0, IRefreshLayout it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.J9().T1(false);
    }

    private final void handleEmptyState() {
        RecyclerView recyclerView = this.rv;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rv");
            recyclerView = null;
        }
        recyclerView.setVisibility(4);
    }

    private final void initData() {
        LiveData<UIStateData<List<com.qzone.reborn.albumx.common.bean.h>>> M1 = J9().M1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<UIStateData<List<com.qzone.reborn.albumx.common.bean.h>>, Unit> function1 = new Function1<UIStateData<List<com.qzone.reborn.albumx.common.bean.h>>, Unit>() { // from class: com.qzone.reborn.albumx.common.part.selectalbum.CommonSelectAlbumListPart$initData$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UIStateData<List<com.qzone.reborn.albumx.common.bean.h>> uIStateData) {
                invoke2(uIStateData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(UIStateData<List<com.qzone.reborn.albumx.common.bean.h>> uIStateData) {
                CommonSelectAlbumListPart.this.K9(uIStateData);
            }
        };
        M1.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.albumx.common.part.selectalbum.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CommonSelectAlbumListPart.O9(Function1.this, obj);
            }
        });
        SmartRefreshLayout smartRefreshLayout = this.refreshLayout;
        if (smartRefreshLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
            smartRefreshLayout = null;
        }
        smartRefreshLayout.autoRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract com.qzone.reborn.albumx.common.viewmodel.l H9();

    /* JADX INFO: Access modifiers changed from: protected */
    public final com.qzone.reborn.albumx.common.viewmodel.l J9() {
        return (com.qzone.reborn.albumx.common.viewmodel.l) this.vm.getValue();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        RFWLog.i("CommonSelectAlbumListPart", RFWLog.USR, "onActivityResult, requestCode:" + requestCode + ", resultCode:" + resultCode);
        if (resultCode == -1 && requestCode == 111) {
            SmartRefreshLayout smartRefreshLayout = this.refreshLayout;
            if (smartRefreshLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
                smartRefreshLayout = null;
            }
            smartRefreshLayout.autoRefresh();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        RFWIocAbilityProvider.g().registerIoc(rootView, this, i.class);
        RFWIocAbilityProvider.g().registerIoc(rootView, this, j.class);
        RFWIocAbilityProvider.g().registerIoc(rootView, this, l9.k.class);
        if (rootView != null) {
            View findViewById = rootView.findViewById(R.id.f162941ng1);
            SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) findViewById;
            smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() { // from class: com.qzone.reborn.albumx.common.part.selectalbum.b
                @Override // com.tencent.richframework.widget.refresh.layout.listener.OnRefreshListener
                public final void onRefresh(IRefreshLayout iRefreshLayout) {
                    CommonSelectAlbumListPart.P9(CommonSelectAlbumListPart.this, iRefreshLayout);
                }
            });
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<SmartRefres\u2026          }\n            }");
            this.refreshLayout = smartRefreshLayout;
            View findViewById2 = rootView.findViewById(R.id.f18743t);
            RecyclerView recyclerView = (RecyclerView) findViewById2;
            recyclerView.setLayoutManager(new SafeLinearLayoutManager(recyclerView.getContext()));
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById<RecyclerVie\u2026er(context)\n            }");
            this.rv = recyclerView;
            G9();
        }
        initData();
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreStart() {
        J9().T1(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K9(UIStateData<List<com.qzone.reborn.albumx.common.bean.h>> listUIStateData) {
        if (listUIStateData == null) {
            return;
        }
        int state = listUIStateData.getState();
        if (state == 0) {
            handleEmptyState();
        } else if (state == 2 || state == 3) {
            M9(listUIStateData);
        } else if (state == 4) {
            L9(listUIStateData);
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

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreEnd(boolean hasMore) {
    }
}
