package com.qzone.reborn.albumx.qzonex.part.albumselectcover;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.reborn.albumx.common.bean.CommonGridItemData;
import com.qzone.reborn.albumx.common.convert.bean.CommonStMedia;
import com.qzone.reborn.albumx.common.viewmodel.e;
import com.qzone.reborn.base.k;
import com.qzone.reborn.feedx.block.aa;
import com.qzone.reborn.widget.QZoneBlankStateView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.mobileqq.utils.bl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import nc.ap;
import nc.y;
import sa.d;
import tl.h;

@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0007\u00a2\u0006\u0004\bF\u0010GJ\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u001c\u0010\f\u001a\u00020\u00052\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bH\u0002J\u001c\u0010\u000e\u001a\u00020\u00052\u0012\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bH\u0002J\b\u0010\u000f\u001a\u00020\u0005H\u0002J\b\u0010\u0010\u001a\u00020\u0005H\u0002J\u001c\u0010\u0011\u001a\u00020\u00052\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bH\u0002J\u0012\u0010\u0014\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0005H\u0016J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J0\u0010!\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u001fH\u0016J\b\u0010#\u001a\u00020\"H\u0016J\b\u0010%\u001a\u00020$H\u0016R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010E\u001a\u00020B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010D\u00a8\u0006H"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/part/albumselectcover/QZAlbumxSelectCoverBodyPart;", "Lcom/qzone/reborn/base/k;", "Lcom/tencent/biz/richframework/preload/recyclerview/ILoadMoreProvider$LoadMoreListener;", "Ll9/c;", "Ll9/a;", "", "F9", "initData", "Lcom/tencent/richframework/data/base/UIStateData;", "", "Lcom/qzone/reborn/albumx/common/bean/a;", "listUIStateData", "G9", "uiStateData", "H9", "L9", "J9", "M9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "onLoadMoreStart", "", "hasMore", "onLoadMoreEnd", "batchBean", "", "batchPos", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStMedia;", QAdVrReportParams.ParamKey.MEDIA, "mediaPos", "Landroid/widget/ImageView;", "view", "A8", "Lcom/qzone/reborn/albumx/common/viewmodel/b;", "Ne", "Lcom/qzone/reborn/albumx/common/viewmodel/e;", "qf", "Landroidx/recyclerview/widget/RecyclerView;", "d", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lsa/d;", "e", "Lsa/d;", "batchListAdapter", "Lcom/qzone/reborn/feedx/block/aa;", "f", "Lcom/qzone/reborn/feedx/block/aa;", "loadMoreAdapter", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", h.F, "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "concatAdapter", "Lcom/qzone/reborn/widget/QZoneBlankStateView;", "i", "Lcom/qzone/reborn/widget/QZoneBlankStateView;", "blankView", "Lnc/y;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lnc/y;", "albumViewModel", "Lnc/ap;", BdhLogUtil.LogTag.Tag_Conn, "Lnc/ap;", "operateViewModel", "Laa/c;", "D", "Laa/c;", "gridDecorationHelper", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZAlbumxSelectCoverBodyPart extends k implements ILoadMoreProvider$LoadMoreListener, l9.c, l9.a {

    /* renamed from: C, reason: from kotlin metadata */
    private ap operateViewModel;

    /* renamed from: D, reason: from kotlin metadata */
    private aa.c gridDecorationHelper = new aa.c();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private RecyclerView recyclerView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private d batchListAdapter;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private aa loadMoreAdapter;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private RFWConcatAdapter concatAdapter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private QZoneBlankStateView blankView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private y albumViewModel;

    private final void F9() {
        d dVar = new d();
        dVar.setHasStableIds(true);
        this.batchListAdapter = dVar;
        aa aaVar = new aa();
        aaVar.registerLoadMoreListener(this);
        aaVar.setHasStableIds(true);
        aaVar.p0(new aa.a().e(HardCodeUtil.qqStr(R.string.to_)).f(HardCodeUtil.qqStr(R.string.toa)));
        this.loadMoreAdapter = aaVar;
        RFWConcatAdapter.Config build = new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build();
        RecyclerView.Adapter[] adapterArr = new RecyclerView.Adapter[2];
        d dVar2 = this.batchListAdapter;
        RFWConcatAdapter rFWConcatAdapter = null;
        if (dVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("batchListAdapter");
            dVar2 = null;
        }
        adapterArr[0] = dVar2;
        aa aaVar2 = this.loadMoreAdapter;
        if (aaVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadMoreAdapter");
            aaVar2 = null;
        }
        adapterArr[1] = aaVar2;
        this.concatAdapter = new RFWConcatAdapter(build, (RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) adapterArr);
        aa.c cVar = this.gridDecorationHelper;
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        RFWConcatAdapter rFWConcatAdapter2 = this.concatAdapter;
        if (rFWConcatAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("concatAdapter");
            rFWConcatAdapter2 = null;
        }
        d dVar3 = this.batchListAdapter;
        if (dVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("batchListAdapter");
            dVar3 = null;
        }
        aa aaVar3 = this.loadMoreAdapter;
        if (aaVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadMoreAdapter");
            aaVar3 = null;
        }
        cVar.p(recyclerView, rFWConcatAdapter2, dVar3, aaVar3);
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView2 = null;
        }
        RFWConcatAdapter rFWConcatAdapter3 = this.concatAdapter;
        if (rFWConcatAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("concatAdapter");
        } else {
            rFWConcatAdapter = rFWConcatAdapter3;
        }
        recyclerView2.setAdapter(rFWConcatAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G9(UIStateData<List<com.qzone.reborn.albumx.common.bean.a>> listUIStateData) {
        QLog.i(getTAG(), 1, "handleBatchListRsp()  state = " + listUIStateData.getState());
        int state = listUIStateData.getState();
        if (state == 0) {
            L9();
        } else if (state == 2 || state == 3) {
            H9(listUIStateData);
        } else if (state == 4) {
            M9(listUIStateData);
        }
        aa aaVar = this.loadMoreAdapter;
        if (aaVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadMoreAdapter");
            aaVar = null;
        }
        aaVar.setLoadState(listUIStateData.isLoading(), !listUIStateData.getIsFinish());
    }

    private final void H9(UIStateData<List<com.qzone.reborn.albumx.common.bean.a>> uiStateData) {
        if (bl.b(uiStateData.getData())) {
            L9();
            return;
        }
        RecyclerView recyclerView = this.recyclerView;
        d dVar = null;
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
        aa.d dVar2 = aa.d.f25752a;
        List<com.qzone.reborn.albumx.common.bean.a> data = uiStateData.getData();
        Intrinsics.checkNotNullExpressionValue(data, "uiStateData.data");
        List<CommonGridItemData> d16 = dVar2.d(data);
        d dVar3 = this.batchListAdapter;
        if (dVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("batchListAdapter");
        } else {
            dVar = dVar3;
        }
        dVar.setItems(new ArrayList(d16));
        if (!uiStateData.getIsLoadMore()) {
            RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.qzone.reborn.albumx.qzonex.part.albumselectcover.b
                @Override // java.lang.Runnable
                public final void run() {
                    QZAlbumxSelectCoverBodyPart.I9(QZAlbumxSelectCoverBodyPart.this);
                }
            }, 100L);
        }
        this.gridDecorationHelper.u();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I9(QZAlbumxSelectCoverBodyPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RecyclerView recyclerView = this$0.recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        recyclerView.scrollToPosition(0);
    }

    private final void J9() {
        y yVar = this.albumViewModel;
        QZoneBlankStateView qZoneBlankStateView = null;
        if (yVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("albumViewModel");
            yVar = null;
        }
        String Q1 = yVar.Q1();
        QZoneBlankStateView qZoneBlankStateView2 = this.blankView;
        if (qZoneBlankStateView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blankView");
        } else {
            qZoneBlankStateView = qZoneBlankStateView2;
        }
        qZoneBlankStateView.setData(com.qzone.reborn.feedx.util.k.e(getContext(), Q1));
        QLog.d(getTAG(), 1, "[initBlankViewData] emptyMsg = " + Q1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void L9() {
        J9();
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

    private final void M9(UIStateData<List<com.qzone.reborn.albumx.common.bean.a>> listUIStateData) {
        J9();
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
        ViewModel viewModel = getViewModel(y.class);
        y yVar = (y) viewModel;
        yVar.W2(getActivity());
        MutableLiveData<UIStateData<List<com.qzone.reborn.albumx.common.bean.a>>> O1 = yVar.O1();
        Fragment hostFragment = getHostFragment();
        final Function1<UIStateData<List<com.qzone.reborn.albumx.common.bean.a>>, Unit> function1 = new Function1<UIStateData<List<com.qzone.reborn.albumx.common.bean.a>>, Unit>() { // from class: com.qzone.reborn.albumx.qzonex.part.albumselectcover.QZAlbumxSelectCoverBodyPart$initData$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UIStateData<List<com.qzone.reborn.albumx.common.bean.a>> uIStateData) {
                invoke2(uIStateData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(UIStateData<List<com.qzone.reborn.albumx.common.bean.a>> it) {
                QZAlbumxSelectCoverBodyPart qZAlbumxSelectCoverBodyPart = QZAlbumxSelectCoverBodyPart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                qZAlbumxSelectCoverBodyPart.G9(it);
            }
        };
        O1.observe(hostFragment, new Observer() { // from class: com.qzone.reborn.albumx.qzonex.part.albumselectcover.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZAlbumxSelectCoverBodyPart.K9(Function1.this, obj);
            }
        });
        yVar.b2(false);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZAlbumxAlb\u2026atchList(false)\n        }");
        this.albumViewModel = yVar;
        ViewModel viewModel2 = getViewModel(ap.class);
        Intrinsics.checkNotNullExpressionValue(viewModel2, "getViewModel(QZAlbumxAlb\u2026ateViewModel::class.java)");
        this.operateViewModel = (ap) viewModel2;
    }

    @Override // l9.a
    public void A8(com.qzone.reborn.albumx.common.bean.a batchBean, int batchPos, CommonStMedia media, int mediaPos, ImageView view) {
        Intrinsics.checkNotNullParameter(batchBean, "batchBean");
        Intrinsics.checkNotNullParameter(media, "media");
        Intrinsics.checkNotNullParameter(view, "view");
        Activity activity = getActivity();
        Intent intent = new Intent();
        intent.putExtra("SELECTED_COVER", media);
        Unit unit = Unit.INSTANCE;
        activity.setResult(-1, intent);
        activity.finish();
    }

    @Override // l9.c
    public com.qzone.reborn.albumx.common.viewmodel.b Ne() {
        y yVar = this.albumViewModel;
        if (yVar != null) {
            return yVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("albumViewModel");
        return null;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        RFWIocAbilityProvider.g().registerIoc(rootView, this, l9.c.class);
        RFWIocAbilityProvider.g().registerIoc(rootView, this, l9.a.class);
        if (rootView != null) {
            View findViewById = rootView.findViewById(R.id.mqu);
            Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.qzone_blank_view)");
            this.blankView = (QZoneBlankStateView) findViewById;
            View findViewById2 = rootView.findViewById(R.id.nf7);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById<RecyclerView>(R.id.rv_feed_list)");
            RecyclerView recyclerView = (RecyclerView) findViewById2;
            this.recyclerView = recyclerView;
            if (recyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                recyclerView = null;
            }
            recyclerView.setItemAnimator(null);
            F9();
            initData();
        }
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreEnd(boolean hasMore) {
        QLog.d(getTAG(), 1, "onLoadMoreEnd  hasMore = " + hasMore);
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreStart() {
        QLog.d(getTAG(), 1, "onLoadMoreStart ");
        y yVar = this.albumViewModel;
        if (yVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("albumViewModel");
            yVar = null;
        }
        yVar.b2(true);
    }

    @Override // l9.c
    public e qf() {
        ap apVar = this.operateViewModel;
        if (apVar != null) {
            return apVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("operateViewModel");
        return null;
    }
}
