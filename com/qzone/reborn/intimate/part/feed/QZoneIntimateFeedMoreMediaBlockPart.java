package com.qzone.reborn.intimate.part.feed;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.reborn.albumx.common.bean.CommonGridItemData;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonStMedia;
import com.qzone.reborn.feedx.block.aa;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateAlbumDetailInitBean;
import com.qzone.reborn.intimate.widget.z;
import com.qzone.reborn.widget.QZoneBlankStateView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.biz.richframework.part.block.base.SafeGridLayoutManager;
import com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.mobileqq.utils.bl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import nk.w;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 A2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001BB\u0007\u00a2\u0006\u0004\b?\u0010@J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u0006H\u0002J\u001c\u0010\u000f\u001a\u00020\u00062\u0012\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000bH\u0002J\u001c\u0010\u0011\u001a\u00020\u00062\u0012\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000bH\u0002J\b\u0010\u0012\u001a\u00020\u0006H\u0002J\b\u0010\u0013\u001a\u00020\u0006H\u0002J\b\u0010\u0014\u001a\u00020\u0006H\u0002J\u001c\u0010\u0015\u001a\u00020\u00062\u0012\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000bH\u0002J\u0012\u0010\u0016\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0017\u001a\u00020\u0006H\u0016J\u0010\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J0\u0010#\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020!H\u0016R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010>\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=\u00a8\u0006C"}, d2 = {"Lcom/qzone/reborn/intimate/part/feed/QZoneIntimateFeedMoreMediaBlockPart;", "Lcom/qzone/reborn/base/k;", "Lcom/tencent/biz/richframework/preload/recyclerview/ILoadMoreProvider$LoadMoreListener;", "Ll9/a;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "N9", "H9", "initData", "P9", "Lcom/tencent/richframework/data/base/UIStateData;", "", "Lcom/qzone/reborn/albumx/common/bean/a;", "listUIStateData", "I9", "uiStateData", "J9", "Q9", "R9", "L9", "S9", "onInitView", "onLoadMoreStart", "", "hasMore", "onLoadMoreEnd", "batchBean", "", "batchPos", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStMedia;", QAdVrReportParams.ParamKey.MEDIA, "mediaPos", "Landroid/widget/ImageView;", "view", "A8", "Landroidx/recyclerview/widget/RecyclerView;", "d", "Landroidx/recyclerview/widget/RecyclerView;", "mRecyclerView", "Lgj/c;", "e", "Lgj/c;", "mBatchListAdapter", "Lcom/qzone/reborn/feedx/block/aa;", "f", "Lcom/qzone/reborn/feedx/block/aa;", "mLoadMoreAdapter", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", tl.h.F, "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "mConcatAdapter", "Lcom/qzone/reborn/widget/QZoneBlankStateView;", "i", "Lcom/qzone/reborn/widget/QZoneBlankStateView;", "mBlankView", "Lnk/w;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lnk/w;", "mAlbumViewModel", BdhLogUtil.LogTag.Tag_Conn, "Z", "mIsItemDecorationSetup", "<init>", "()V", "D", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneIntimateFeedMoreMediaBlockPart extends com.qzone.reborn.base.k implements ILoadMoreProvider$LoadMoreListener, l9.a {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean mIsItemDecorationSetup;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private RecyclerView mRecyclerView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private gj.c mBatchListAdapter;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private aa mLoadMoreAdapter;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private RFWConcatAdapter mConcatAdapter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private QZoneBlankStateView mBlankView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private w mAlbumViewModel;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/qzone/reborn/intimate/part/feed/QZoneIntimateFeedMoreMediaBlockPart$b", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "", "position", "getSpanSize", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b extends GridLayoutManager.SpanSizeLookup {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ SafeGridLayoutManager f57514b;

        b(SafeGridLayoutManager safeGridLayoutManager) {
            this.f57514b = safeGridLayoutManager;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int position) {
            gj.c cVar = QZoneIntimateFeedMoreMediaBlockPart.this.mBatchListAdapter;
            gj.c cVar2 = null;
            if (cVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBatchListAdapter");
                cVar = null;
            }
            if (cVar.getNUM_BACKGOURND_ICON() > 0) {
                gj.c cVar3 = QZoneIntimateFeedMoreMediaBlockPart.this.mBatchListAdapter;
                if (cVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBatchListAdapter");
                } else {
                    cVar2 = cVar3;
                }
                return position == cVar2.getNUM_BACKGOURND_ICON() ? 3 : 1;
            }
            return this.f57514b.getSpanCount();
        }
    }

    private final void H9() {
        gj.c cVar = new gj.c();
        cVar.setHasStableIds(true);
        this.mBatchListAdapter = cVar;
        aa aaVar = new aa();
        aaVar.registerLoadMoreListener(this);
        aaVar.setHasStableIds(true);
        aaVar.p0(new aa.a().e(HardCodeUtil.qqStr(R.string.to_)).f(HardCodeUtil.qqStr(R.string.toa)));
        this.mLoadMoreAdapter = aaVar;
        RFWConcatAdapter.Config build = new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build();
        RecyclerView.Adapter[] adapterArr = new RecyclerView.Adapter[2];
        gj.c cVar2 = this.mBatchListAdapter;
        RFWConcatAdapter rFWConcatAdapter = null;
        if (cVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBatchListAdapter");
            cVar2 = null;
        }
        adapterArr[0] = cVar2;
        aa aaVar2 = this.mLoadMoreAdapter;
        if (aaVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLoadMoreAdapter");
            aaVar2 = null;
        }
        adapterArr[1] = aaVar2;
        this.mConcatAdapter = new RFWConcatAdapter(build, (RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) adapterArr);
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView = null;
        }
        RFWConcatAdapter rFWConcatAdapter2 = this.mConcatAdapter;
        if (rFWConcatAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mConcatAdapter");
        } else {
            rFWConcatAdapter = rFWConcatAdapter2;
        }
        recyclerView.setAdapter(rFWConcatAdapter);
        P9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I9(UIStateData<List<com.qzone.reborn.albumx.common.bean.a>> listUIStateData) {
        QLog.i(getTAG(), 1, "handleBatchListRsp()  state = " + listUIStateData.getState());
        int state = listUIStateData.getState();
        if (state == 0) {
            R9();
        } else if (state == 2 || state == 3) {
            J9(listUIStateData);
        } else if (state == 4) {
            S9(listUIStateData);
        }
        aa aaVar = this.mLoadMoreAdapter;
        if (aaVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLoadMoreAdapter");
            aaVar = null;
        }
        aaVar.setLoadState(listUIStateData.isLoading(), !listUIStateData.getIsFinish());
    }

    private final void J9(UIStateData<List<com.qzone.reborn.albumx.common.bean.a>> uiStateData) {
        if (bl.b(uiStateData.getData())) {
            R9();
            return;
        }
        RecyclerView recyclerView = this.mRecyclerView;
        gj.c cVar = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView = null;
        }
        recyclerView.setVisibility(0);
        QZoneBlankStateView qZoneBlankStateView = this.mBlankView;
        if (qZoneBlankStateView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBlankView");
            qZoneBlankStateView = null;
        }
        qZoneBlankStateView.o0();
        ArrayList arrayList = new ArrayList();
        List<com.qzone.reborn.albumx.common.bean.a> data = uiStateData.getData();
        Intrinsics.checkNotNullExpressionValue(data, "uiStateData.data");
        Iterator<T> it = data.iterator();
        while (it.hasNext()) {
            arrayList.addAll(((com.qzone.reborn.albumx.common.bean.a) it.next()).getBatchInfo().j());
        }
        ArrayList arrayList2 = new ArrayList();
        int i3 = 0;
        for (Object obj : arrayList) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            CommonGridItemData commonGridItemData = new CommonGridItemData(uiStateData.getData().get(0), CommonGridItemData.ItemType.PIC_SECTION_ITEM, 0, i3);
            commonGridItemData.h((CommonStMedia) obj);
            arrayList2.add(commonGridItemData);
            i3 = i16;
        }
        gj.c cVar2 = this.mBatchListAdapter;
        if (cVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBatchListAdapter");
            cVar2 = null;
        }
        cVar2.setItems(arrayList2);
        gj.c cVar3 = this.mBatchListAdapter;
        if (cVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBatchListAdapter");
        } else {
            cVar = cVar3;
        }
        cVar.notifyDataSetChanged();
        if (!uiStateData.getIsLoadMore()) {
            RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.qzone.reborn.intimate.part.feed.q
                @Override // java.lang.Runnable
                public final void run() {
                    QZoneIntimateFeedMoreMediaBlockPart.K9(QZoneIntimateFeedMoreMediaBlockPart.this);
                }
            }, 100L);
        }
        Q9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K9(QZoneIntimateFeedMoreMediaBlockPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RecyclerView recyclerView = this$0.mRecyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView = null;
        }
        recyclerView.scrollToPosition(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O9(QZoneIntimateFeedMoreMediaBlockPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Activity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void P9() {
        RecyclerView recyclerView = this.mRecyclerView;
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView = null;
        }
        if (recyclerView.getLayoutManager() instanceof SafeGridLayoutManager) {
            RecyclerView recyclerView3 = this.mRecyclerView;
            if (recyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            } else {
                recyclerView2 = recyclerView3;
            }
            RecyclerView.LayoutManager layoutManager = recyclerView2.getLayoutManager();
            Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type com.tencent.biz.richframework.part.block.base.SafeGridLayoutManager");
            SafeGridLayoutManager safeGridLayoutManager = (SafeGridLayoutManager) layoutManager;
            safeGridLayoutManager.setSpanSizeLookup(new b(safeGridLayoutManager));
        }
    }

    private final void Q9() {
        if (this.mIsItemDecorationSetup || getActivity() == null) {
            return;
        }
        this.mIsItemDecorationSetup = true;
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView = null;
        }
        recyclerView.addItemDecoration(new z(3));
    }

    private final void R9() {
        RecyclerView recyclerView = this.mRecyclerView;
        QZoneBlankStateView qZoneBlankStateView = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView = null;
        }
        recyclerView.setVisibility(4);
        QZoneBlankStateView qZoneBlankStateView2 = this.mBlankView;
        if (qZoneBlankStateView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBlankView");
        } else {
            qZoneBlankStateView = qZoneBlankStateView2;
        }
        qZoneBlankStateView.s0();
    }

    private final void S9(UIStateData<List<com.qzone.reborn.albumx.common.bean.a>> listUIStateData) {
        if (listUIStateData.getIsLoadMore()) {
            return;
        }
        RecyclerView recyclerView = this.mRecyclerView;
        QZoneBlankStateView qZoneBlankStateView = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView = null;
        }
        recyclerView.setVisibility(4);
        QZoneBlankStateView qZoneBlankStateView2 = this.mBlankView;
        if (qZoneBlankStateView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBlankView");
        } else {
            qZoneBlankStateView = qZoneBlankStateView2;
        }
        qZoneBlankStateView.s0();
    }

    private final void initData() {
        ViewModel viewModel = getViewModel(w.class);
        w wVar = (w) viewModel;
        MutableLiveData<UIStateData<List<com.qzone.reborn.albumx.common.bean.a>>> O1 = wVar.O1();
        Fragment hostFragment = getHostFragment();
        final Function1<UIStateData<List<com.qzone.reborn.albumx.common.bean.a>>, Unit> function1 = new Function1<UIStateData<List<com.qzone.reborn.albumx.common.bean.a>>, Unit>() { // from class: com.qzone.reborn.intimate.part.feed.QZoneIntimateFeedMoreMediaBlockPart$initData$1$1
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
                QZoneIntimateFeedMoreMediaBlockPart qZoneIntimateFeedMoreMediaBlockPart = QZoneIntimateFeedMoreMediaBlockPart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                qZoneIntimateFeedMoreMediaBlockPart.I9(it);
            }
        };
        O1.observe(hostFragment, new Observer() { // from class: com.qzone.reborn.intimate.part.feed.o
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZoneIntimateFeedMoreMediaBlockPart.M9(Function1.this, obj);
            }
        });
        wVar.b2(false);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZoneIntima\u2026atchList(false)\n        }");
        this.mAlbumViewModel = wVar;
    }

    @Override // l9.a
    public void A8(com.qzone.reborn.albumx.common.bean.a batchBean, int batchPos, CommonStMedia media, int mediaPos, ImageView view) {
        String str;
        String str2;
        String spaceId;
        Intrinsics.checkNotNullParameter(batchBean, "batchBean");
        Intrinsics.checkNotNullParameter(media, "media");
        Intrinsics.checkNotNullParameter(view, "view");
        w wVar = this.mAlbumViewModel;
        w wVar2 = null;
        if (wVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
            wVar = null;
        }
        CommonAlbumInfo value = wVar.M1().getValue();
        String str3 = "";
        if (value == null || (str = value.getAlbumId()) == null) {
            str = "";
        }
        batchBean.g(str);
        w wVar3 = this.mAlbumViewModel;
        if (wVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
            wVar3 = null;
        }
        CommonAlbumInfo value2 = wVar3.M1().getValue();
        if (value2 == null || (str2 = value2.getName()) == null) {
            str2 = "";
        }
        batchBean.h(str2);
        sj.g gVar = sj.g.f433870a;
        Context context = getContext();
        vj.d dVar = vj.d.f441734a;
        w wVar4 = this.mAlbumViewModel;
        if (wVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
            wVar4 = null;
        }
        QZoneIntimateAlbumDetailInitBean initBean = wVar4.getInitBean();
        if (initBean != null && (spaceId = initBean.getSpaceId()) != null) {
            str3 = spaceId;
        }
        w wVar5 = this.mAlbumViewModel;
        if (wVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
            wVar5 = null;
        }
        QZoneIntimateAlbumDetailInitBean initBean2 = wVar5.getInitBean();
        sj.f c16 = dVar.c(str3, initBean2 != null ? initBean2.getSpaceType() : 0);
        w wVar6 = this.mAlbumViewModel;
        if (wVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
        } else {
            wVar2 = wVar6;
        }
        gVar.i(context, view, mediaPos, c16, batchBean, "", wVar2.getInitBean());
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        RFWIocAbilityProvider.g().registerIoc(rootView, this, l9.a.class);
        if (rootView != null) {
            N9(rootView);
            H9();
            initData();
            L9();
        }
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreEnd(boolean hasMore) {
        QLog.d(getTAG(), 1, "onLoadMoreEnd  hasMore = " + hasMore);
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreStart() {
        QLog.d(getTAG(), 1, "onLoadMoreStart ");
        w wVar = this.mAlbumViewModel;
        if (wVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
            wVar = null;
        }
        wVar.b2(true);
    }

    private final void L9() {
        String qqStr = HardCodeUtil.qqStr(R.string.w9a);
        QZoneBlankStateView qZoneBlankStateView = this.mBlankView;
        if (qZoneBlankStateView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBlankView");
            qZoneBlankStateView = null;
        }
        qZoneBlankStateView.setData(com.qzone.reborn.feedx.util.k.e(getContext(), qqStr));
        QLog.d(getTAG(), 1, "[initBlankViewData] emptyMsg = " + qqStr);
    }

    private final void N9(View rootView) {
        ((ImageView) rootView.findViewById(R.id.n3r)).setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.intimate.part.feed.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZoneIntimateFeedMoreMediaBlockPart.O9(QZoneIntimateFeedMoreMediaBlockPart.this, view);
            }
        });
        View findViewById = rootView.findViewById(R.id.mqu);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.qzone_blank_view)");
        this.mBlankView = (QZoneBlankStateView) findViewById;
        View findViewById2 = rootView.findViewById(R.id.nf9);
        RecyclerView recyclerView = (RecyclerView) findViewById2;
        recyclerView.setNestedScrollingEnabled(true);
        recyclerView.setLayoutManager(new SafeGridLayoutManager(recyclerView.getContext(), 3));
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
        defaultItemAnimator.setSupportsChangeAnimations(false);
        recyclerView.setItemAnimator(defaultItemAnimator);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById<Re\u2026e\n            }\n        }");
        this.mRecyclerView = recyclerView;
    }
}
