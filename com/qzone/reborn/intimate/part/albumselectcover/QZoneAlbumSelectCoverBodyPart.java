package com.qzone.reborn.intimate.part.albumselectcover;

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
import gj.d;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import nk.w;
import tl.h;

@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007\u00a2\u0006\u0004\b=\u0010>J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u001c\u0010\u000b\u001a\u00020\u00042\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007H\u0002J\u001c\u0010\r\u001a\u00020\u00042\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007H\u0002J\b\u0010\u000e\u001a\u00020\u0004H\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\u001c\u0010\u0010\u001a\u00020\u00042\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007H\u0002J\u0012\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0004H\u0016J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J0\u0010 \u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u001eH\u0016R\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;\u00a8\u0006?"}, d2 = {"Lcom/qzone/reborn/intimate/part/albumselectcover/QZoneAlbumSelectCoverBodyPart;", "Lcom/qzone/reborn/base/k;", "Lcom/tencent/biz/richframework/preload/recyclerview/ILoadMoreProvider$LoadMoreListener;", "Ll9/a;", "", "F9", "initData", "Lcom/tencent/richframework/data/base/UIStateData;", "", "Lcom/qzone/reborn/albumx/common/bean/a;", "listUIStateData", "G9", "uiStateData", "H9", "L9", "J9", "M9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "onLoadMoreStart", "", "hasMore", "onLoadMoreEnd", "batchBean", "", "batchPos", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStMedia;", QAdVrReportParams.ParamKey.MEDIA, "mediaPos", "Landroid/widget/ImageView;", "view", "A8", "Landroidx/recyclerview/widget/RecyclerView;", "d", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lgj/d;", "e", "Lgj/d;", "batchListAdapter", "Lcom/qzone/reborn/feedx/block/aa;", "f", "Lcom/qzone/reborn/feedx/block/aa;", "loadMoreAdapter", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", h.F, "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "concatAdapter", "Lcom/qzone/reborn/widget/QZoneBlankStateView;", "i", "Lcom/qzone/reborn/widget/QZoneBlankStateView;", "blankView", "Lnk/w;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lnk/w;", "albumViewModel", "Laa/c;", BdhLogUtil.LogTag.Tag_Conn, "Laa/c;", "gridDecorationHelper", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneAlbumSelectCoverBodyPart extends k implements ILoadMoreProvider$LoadMoreListener, l9.a {

    /* renamed from: C, reason: from kotlin metadata */
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
    private w albumViewModel;

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
            RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.qzone.reborn.intimate.part.albumselectcover.b
                @Override // java.lang.Runnable
                public final void run() {
                    QZoneAlbumSelectCoverBodyPart.I9(QZoneAlbumSelectCoverBodyPart.this);
                }
            }, 100L);
        }
        this.gridDecorationHelper.u();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I9(QZoneAlbumSelectCoverBodyPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RecyclerView recyclerView = this$0.recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        recyclerView.scrollToPosition(0);
    }

    private final void J9() {
        w wVar = this.albumViewModel;
        QZoneBlankStateView qZoneBlankStateView = null;
        if (wVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("albumViewModel");
            wVar = null;
        }
        String Q1 = wVar.Q1();
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
        ViewModel viewModel = getViewModel(w.class);
        w wVar = (w) viewModel;
        wVar.m2(getActivity());
        MutableLiveData<UIStateData<List<com.qzone.reborn.albumx.common.bean.a>>> O1 = wVar.O1();
        Fragment hostFragment = getHostFragment();
        final Function1<UIStateData<List<com.qzone.reborn.albumx.common.bean.a>>, Unit> function1 = new Function1<UIStateData<List<com.qzone.reborn.albumx.common.bean.a>>, Unit>() { // from class: com.qzone.reborn.intimate.part.albumselectcover.QZoneAlbumSelectCoverBodyPart$initData$1$1
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
                QZoneAlbumSelectCoverBodyPart qZoneAlbumSelectCoverBodyPart = QZoneAlbumSelectCoverBodyPart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                qZoneAlbumSelectCoverBodyPart.G9(it);
            }
        };
        O1.observe(hostFragment, new Observer() { // from class: com.qzone.reborn.intimate.part.albumselectcover.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZoneAlbumSelectCoverBodyPart.K9(Function1.this, obj);
            }
        });
        wVar.b2(false);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZoneIntima\u2026atchList(false)\n        }");
        this.albumViewModel = wVar;
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

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
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
        w wVar = this.albumViewModel;
        if (wVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("albumViewModel");
            wVar = null;
        }
        wVar.b2(true);
    }
}
