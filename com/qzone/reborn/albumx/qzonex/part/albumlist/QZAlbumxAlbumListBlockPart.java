package com.qzone.reborn.albumx.qzonex.part.albumlist;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.albumx.common.bean.CommonAlbumListBean;
import com.qzone.reborn.albumx.qzone.vas.event.QZonePhotoDegradeEvent;
import com.qzone.reborn.albumx.qzonex.event.QZAlbumxTopAndRefreshEvent;
import com.qzone.reborn.feedx.block.aa;
import com.qzone.reborn.widget.QZoneBlankStateView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.ioc.callback.OnPromiseResolved;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.biz.richframework.part.block.base.SafeGridLayoutManager;
import com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcircle.api.event.QFSDeleteQZoneVideoAlbumEvent;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.AlbumPageInfo;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.richframework.widget.refresh.layout.SmartRefreshLayout;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshLayout;
import com.tencent.richframework.widget.refresh.layout.listener.OnRefreshListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import nc.ae;
import nc.bn;
import qzone.QZonePhotoDegrade$Button;
import qzone.QZonePhotoDegrade$QueryNotifyMsgRsp;
import qzone.QZonePhotoDegrade$Text;

@Metadata(d1 = {"\u0000\u00ba\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 _2\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001`B\u0007\u00a2\u0006\u0004\b]\u0010^J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\u0012\u0010\f\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\b\u0010\r\u001a\u00020\u0007H\u0002J\u001c\u0010\u0012\u001a\u00020\u00072\u0012\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000eH\u0002J\b\u0010\u0013\u001a\u00020\u0007H\u0002J\b\u0010\u0014\u001a\u00020\u0007H\u0002J\u001c\u0010\u0015\u001a\u00020\u00072\u0012\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000eH\u0002J\u001c\u0010\u0016\u001a\u00020\u00072\u0012\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000eH\u0002J\u001e\u0010\u0017\u001a\u00020\u00072\u0014\u0010\u0011\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f\u0018\u00010\u000eH\u0002J\b\u0010\u0018\u001a\u00020\u0007H\u0002J\b\u0010\u0019\u001a\u00020\u0007H\u0002J\b\u0010\u001a\u001a\u00020\u0007H\u0002J\b\u0010\u001b\u001a\u00020\u0007H\u0002J\b\u0010\u001c\u001a\u00020\u0007H\u0002J\u0010\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\u0010\u0010!\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020 H\u0002J\b\u0010#\u001a\u00020\"H\u0016J\u0010\u0010$\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0012\u0010'\u001a\u00020\u00072\b\u0010&\u001a\u0004\u0018\u00010%H\u0016J\u0012\u0010(\u001a\u00020\u00072\b\u0010&\u001a\u0004\u0018\u00010%H\u0016J\b\u0010)\u001a\u00020\u0007H\u0016J\u0010\u0010,\u001a\u00020\u00072\u0006\u0010+\u001a\u00020*H\u0016J\u0012\u0010-\u001a\u00020\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\u0004H\u0016J\u0014\u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040/0.H\u0016R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00107\u001a\u0002058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u00106R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010O\u001a\u00020L8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0018\u0010S\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010V\u001a\u00020*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0018\u0010Z\u001a\u0004\u0018\u00010W8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010\\\u001a\u00020*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010U\u00a8\u0006a"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/part/albumlist/QZAlbumxAlbumListBlockPart;", "Lcom/qzone/reborn/base/k;", "Lcom/tencent/biz/richframework/preload/recyclerview/ILoadMoreProvider$LoadMoreListener;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "W9", "initViewModel", "Lqzone/QZonePhotoDegrade$QueryNotifyMsgRsp;", "queryNotifyMsgRsp", "O9", "L9", "Lcom/tencent/richframework/data/base/UIStateData;", "", "Lcom/qzone/reborn/albumx/common/bean/CommonAlbumListBean;", "listUIStateData", "M9", "ca", "T9", "da", "N9", "Q9", "ha", "ea", "ga", "ba", "e", "Lcom/tencent/mobileqq/qcircle/api/event/QFSDeleteQZoneVideoAlbumEvent;", "event", "P9", "Lcom/qzone/reborn/albumx/qzonex/event/QZAlbumxTopAndRefreshEvent;", "S9", "", "getLogTag", "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "onPartDestroy", "onLoadMoreStart", "", "hasMore", "onLoadMoreEnd", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "Lcom/tencent/richframework/widget/refresh/layout/SmartRefreshLayout;", "d", "Lcom/tencent/richframework/widget/refresh/layout/SmartRefreshLayout;", "mRefreshLayout", "Lcom/qzone/reborn/widget/QZoneBlankStateView;", "Lcom/qzone/reborn/widget/QZoneBlankStateView;", "mBlankView", "Landroidx/recyclerview/widget/RecyclerView;", "f", "Landroidx/recyclerview/widget/RecyclerView;", "mRecyclerView", "Lnc/ae;", tl.h.F, "Lnc/ae;", "mAlbumViewModel", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "i", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "mConcatAdapter", "Li9/b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Li9/b;", "mAlbumListAdapter", "Lsa/j;", BdhLogUtil.LogTag.Tag_Conn, "Lsa/j;", "mPhotoDegradeAdapter", "Lcom/qzone/reborn/feedx/block/aa;", "D", "Lcom/qzone/reborn/feedx/block/aa;", "mLoadMoreAdapter", "Lrc/c;", "E", "Lrc/c;", "mRecyclerViewDecoration", UserInfo.SEX_FEMALE, "Z", "mIsSetupItemDecoration", "Lnc/bn;", "G", "Lnc/bn;", "mMainPageTabViewModel", "H", "mIsForceHideDegradeTips", "<init>", "()V", "I", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZAlbumxAlbumListBlockPart extends com.qzone.reborn.base.k implements ILoadMoreProvider$LoadMoreListener, SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: C, reason: from kotlin metadata */
    private sa.j mPhotoDegradeAdapter;

    /* renamed from: D, reason: from kotlin metadata */
    private aa mLoadMoreAdapter;

    /* renamed from: E, reason: from kotlin metadata */
    private rc.c mRecyclerViewDecoration;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean mIsSetupItemDecoration;

    /* renamed from: G, reason: from kotlin metadata */
    private bn mMainPageTabViewModel;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean mIsForceHideDegradeTips;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private SmartRefreshLayout mRefreshLayout;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private QZoneBlankStateView mBlankView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private RecyclerView mRecyclerView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ae mAlbumViewModel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private RFWConcatAdapter mConcatAdapter;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private i9.b mAlbumListAdapter;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/qzone/reborn/albumx/qzonex/part/albumlist/QZAlbumxAlbumListBlockPart$b", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "", "position", "getSpanSize", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b extends GridLayoutManager.SpanSizeLookup {
        b() {
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int position) {
            RFWConcatAdapter rFWConcatAdapter = QZAlbumxAlbumListBlockPart.this.mConcatAdapter;
            RFWConcatAdapter rFWConcatAdapter2 = null;
            if (rFWConcatAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mConcatAdapter");
                rFWConcatAdapter = null;
            }
            Pair<RecyclerView.Adapter<? extends RecyclerView.ViewHolder>, Integer> wrappedAdapterAndPosition = rFWConcatAdapter.getWrappedAdapterAndPosition(position);
            Intrinsics.checkNotNullExpressionValue(wrappedAdapterAndPosition, "mConcatAdapter.getWrappe\u2026pterAndPosition(position)");
            if (wrappedAdapterAndPosition.first instanceof sa.j) {
                return 2;
            }
            RFWConcatAdapter rFWConcatAdapter3 = QZAlbumxAlbumListBlockPart.this.mConcatAdapter;
            if (rFWConcatAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mConcatAdapter");
            } else {
                rFWConcatAdapter2 = rFWConcatAdapter3;
            }
            return position == rFWConcatAdapter2.getItemCount() - 1 ? 2 : 1;
        }
    }

    private final void L9() {
        this.mAlbumListAdapter = new i9.b();
        this.mPhotoDegradeAdapter = new sa.j();
        aa aaVar = new aa();
        this.mLoadMoreAdapter = aaVar;
        aaVar.registerLoadMoreListener(this);
        aa aaVar2 = this.mLoadMoreAdapter;
        RecyclerView recyclerView = null;
        if (aaVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLoadMoreAdapter");
            aaVar2 = null;
        }
        aaVar2.p0(new aa.a().e(HardCodeUtil.qqStr(R.string.v1u)).f(""));
        i9.b bVar = this.mAlbumListAdapter;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumListAdapter");
            bVar = null;
        }
        bVar.setHasStableIds(true);
        aa aaVar3 = this.mLoadMoreAdapter;
        if (aaVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLoadMoreAdapter");
            aaVar3 = null;
        }
        aaVar3.setHasStableIds(true);
        RFWConcatAdapter.Config build = new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build();
        RecyclerView.Adapter[] adapterArr = new RecyclerView.Adapter[3];
        sa.j jVar = this.mPhotoDegradeAdapter;
        if (jVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPhotoDegradeAdapter");
            jVar = null;
        }
        adapterArr[0] = jVar;
        i9.b bVar2 = this.mAlbumListAdapter;
        if (bVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumListAdapter");
            bVar2 = null;
        }
        adapterArr[1] = bVar2;
        aa aaVar4 = this.mLoadMoreAdapter;
        if (aaVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLoadMoreAdapter");
            aaVar4 = null;
        }
        adapterArr[2] = aaVar4;
        this.mConcatAdapter = new RFWConcatAdapter(build, (RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) adapterArr);
        RecyclerView recyclerView2 = this.mRecyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView2 = null;
        }
        RFWConcatAdapter rFWConcatAdapter = this.mConcatAdapter;
        if (rFWConcatAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mConcatAdapter");
            rFWConcatAdapter = null;
        }
        recyclerView2.setAdapter(rFWConcatAdapter);
        RecyclerView recyclerView3 = this.mRecyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        } else {
            recyclerView = recyclerView3;
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type com.tencent.biz.richframework.part.block.base.SafeGridLayoutManager");
        ((SafeGridLayoutManager) layoutManager).setSpanSizeLookup(new b());
    }

    private final void M9(UIStateData<List<CommonAlbumListBean>> listUIStateData) {
        int state = listUIStateData.getState();
        if (state == 0) {
            ca();
        } else if (state == 2 || state == 3) {
            Q9(listUIStateData);
        } else if (state == 4) {
            da(listUIStateData);
        } else if (state == 6 || state == 7) {
            N9(listUIStateData);
        }
        SmartRefreshLayout smartRefreshLayout = this.mRefreshLayout;
        aa aaVar = null;
        if (smartRefreshLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRefreshLayout");
            smartRefreshLayout = null;
        }
        smartRefreshLayout.finishRefresh();
        aa aaVar2 = this.mLoadMoreAdapter;
        if (aaVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLoadMoreAdapter");
        } else {
            aaVar = aaVar2;
        }
        aaVar.setLoadState(listUIStateData.isLoading(), !listUIStateData.getIsFinish());
    }

    private final void N9(UIStateData<List<CommonAlbumListBean>> listUIStateData) {
        i9.b bVar = this.mAlbumListAdapter;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumListAdapter");
            bVar = null;
        }
        bVar.setItems(new ArrayList(listUIStateData.getData()));
    }

    private final void P9(QFSDeleteQZoneVideoAlbumEvent event) {
        QLog.d(getTAG(), 1, "[handleQFSDeleteQZoneVideoAlbumEvent]  | mIsDeleteAll=" + event.isDeleteAll() + " | mFeedId=" + event.getFeedId());
        SmartRefreshLayout smartRefreshLayout = this.mRefreshLayout;
        if (smartRefreshLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRefreshLayout");
            smartRefreshLayout = null;
        }
        smartRefreshLayout.autoRefresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R9(QZAlbumxAlbumListBlockPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RecyclerView recyclerView = this$0.mRecyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView = null;
        }
        recyclerView.scrollToPosition(0);
    }

    private final void S9(QZAlbumxTopAndRefreshEvent event) {
        QLog.d(getTAG(), 1, "[handleTopAndRefreshEvent] albumId = " + event.getAlbumId());
        if (event.getFrom() == 0) {
            RecyclerView recyclerView = this.mRecyclerView;
            SmartRefreshLayout smartRefreshLayout = null;
            if (recyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
                recyclerView = null;
            }
            recyclerView.scrollToPosition(0);
            SmartRefreshLayout smartRefreshLayout2 = this.mRefreshLayout;
            if (smartRefreshLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRefreshLayout");
            } else {
                smartRefreshLayout = smartRefreshLayout2;
            }
            smartRefreshLayout.autoRefresh();
        }
    }

    private final void T9() {
        QZoneBlankStateView qZoneBlankStateView = this.mBlankView;
        ae aeVar = null;
        if (qZoneBlankStateView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBlankView");
            qZoneBlankStateView = null;
        }
        Context context = getContext();
        ae aeVar2 = this.mAlbumViewModel;
        if (aeVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
            aeVar2 = null;
        }
        boolean z16 = !aeVar2.d2();
        ae aeVar3 = this.mAlbumViewModel;
        if (aeVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
        } else {
            aeVar = aeVar3;
        }
        qZoneBlankStateView.setData(com.qzone.reborn.feedx.util.k.A(context, z16, aeVar.Q1(), new View.OnClickListener() { // from class: com.qzone.reborn.albumx.qzonex.part.albumlist.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZAlbumxAlbumListBlockPart.U9(QZAlbumxAlbumListBlockPart.this, view);
            }
        }, new View.OnClickListener() { // from class: com.qzone.reborn.albumx.qzonex.part.albumlist.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZAlbumxAlbumListBlockPart.V9(QZAlbumxAlbumListBlockPart.this, view);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U9(QZAlbumxAlbumListBlockPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.e();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V9(QZAlbumxAlbumListBlockPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SmartRefreshLayout smartRefreshLayout = this$0.mRefreshLayout;
        if (smartRefreshLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRefreshLayout");
            smartRefreshLayout = null;
        }
        smartRefreshLayout.autoRefresh();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X9(QZAlbumxAlbumListBlockPart this$0, IRefreshLayout it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        ae aeVar = this$0.mAlbumViewModel;
        ae aeVar2 = null;
        if (aeVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
            aeVar = null;
        }
        aeVar.h2(false, false);
        if (this$0.mIsForceHideDegradeTips) {
            return;
        }
        ae aeVar3 = this$0.mAlbumViewModel;
        if (aeVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
        } else {
            aeVar2 = aeVar3;
        }
        aeVar2.k2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y9(QZAlbumxAlbumListBlockPart this$0, hb.i iVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mMainPageTabViewModel = iVar.A7();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z9(QZAlbumxAlbumListBlockPart this$0, UIStateData listUIStateData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(listUIStateData, "listUIStateData");
        this$0.M9(listUIStateData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void aa(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void ba() {
        if (this.mIsSetupItemDecoration || getActivity() == null) {
            return;
        }
        this.mIsSetupItemDecoration = true;
        RFWConcatAdapter rFWConcatAdapter = this.mConcatAdapter;
        RecyclerView recyclerView = null;
        if (rFWConcatAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mConcatAdapter");
            rFWConcatAdapter = null;
        }
        this.mRecyclerViewDecoration = new rc.c(rFWConcatAdapter);
        RecyclerView recyclerView2 = this.mRecyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        } else {
            recyclerView = recyclerView2;
        }
        rc.c cVar = this.mRecyclerViewDecoration;
        Intrinsics.checkNotNull(cVar);
        recyclerView.addItemDecoration(cVar);
    }

    private final void ca() {
        T9();
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
        ga();
        ha();
        ea();
    }

    private final void da(UIStateData<List<CommonAlbumListBean>> listUIStateData) {
        T9();
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
        qZoneBlankStateView.showErrorView();
        ga();
    }

    private final void e() {
        hb.a aVar = (hb.a) getIocInterface(hb.a.class);
        if (aVar != null) {
            aVar.e();
        }
    }

    private final void ea() {
        bn bnVar;
        ae aeVar = this.mAlbumViewModel;
        if (aeVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
            aeVar = null;
        }
        AlbumPageInfo pageInfo = aeVar.getPageInfo();
        if (pageInfo == null || (bnVar = this.mMainPageTabViewModel) == null) {
            return;
        }
        bnVar.n2(pageInfo);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0049, code lost:
    
        if (r0.videoNum == 0) goto L44;
     */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void ga() {
        String str;
        bn bnVar;
        ae aeVar = this.mAlbumViewModel;
        if (aeVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
            aeVar = null;
        }
        if (aeVar.getPageInfo() != null) {
            ae aeVar2 = this.mAlbumViewModel;
            if (aeVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
                aeVar2 = null;
            }
            AlbumPageInfo pageInfo = aeVar2.getPageInfo();
            Intrinsics.checkNotNull(pageInfo);
            if (pageInfo.albumNum == 0) {
                ae aeVar3 = this.mAlbumViewModel;
                if (aeVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
                    aeVar3 = null;
                }
                AlbumPageInfo pageInfo2 = aeVar3.getPageInfo();
                Intrinsics.checkNotNull(pageInfo2);
                if (pageInfo2.photoNum == 0) {
                    ae aeVar4 = this.mAlbumViewModel;
                    if (aeVar4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
                        aeVar4 = null;
                    }
                    AlbumPageInfo pageInfo3 = aeVar4.getPageInfo();
                    Intrinsics.checkNotNull(pageInfo3);
                }
            }
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = getContext().getString(R.string.jit);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026umx_tab_album_title_desc)");
            Object[] objArr = new Object[3];
            ae aeVar5 = this.mAlbumViewModel;
            if (aeVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
                aeVar5 = null;
            }
            AlbumPageInfo pageInfo4 = aeVar5.getPageInfo();
            objArr[0] = pageInfo4 != null ? Integer.valueOf(pageInfo4.albumNum) : null;
            ae aeVar6 = this.mAlbumViewModel;
            if (aeVar6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
                aeVar6 = null;
            }
            AlbumPageInfo pageInfo5 = aeVar6.getPageInfo();
            objArr[1] = pageInfo5 != null ? Integer.valueOf(pageInfo5.photoNum) : null;
            ae aeVar7 = this.mAlbumViewModel;
            if (aeVar7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
                aeVar7 = null;
            }
            AlbumPageInfo pageInfo6 = aeVar7.getPageInfo();
            objArr[2] = pageInfo6 != null ? Integer.valueOf(pageInfo6.videoNum) : null;
            str = String.format(string, Arrays.copyOf(objArr, 3));
            Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
            bnVar = this.mMainPageTabViewModel;
            if (bnVar == null) {
                bnVar.p2(str);
                return;
            }
            return;
        }
        str = "";
        bnVar = this.mMainPageTabViewModel;
        if (bnVar == null) {
        }
    }

    private final void ha() {
        bn bnVar = this.mMainPageTabViewModel;
        if (bnVar != null) {
            ae aeVar = this.mAlbumViewModel;
            if (aeVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
                aeVar = null;
            }
            bnVar.t2(aeVar.S1());
        }
    }

    private final void initViewModel() {
        RFWIocAbilityProvider.g().getIoc(hb.i.class).originView(getPartRootView()).done(new OnPromiseResolved() { // from class: com.qzone.reborn.albumx.qzonex.part.albumlist.c
            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
            public final void onDone(Object obj) {
                QZAlbumxAlbumListBlockPart.Y9(QZAlbumxAlbumListBlockPart.this, (hb.i) obj);
            }
        }).run();
        ViewModel viewModel = getViewModel(ae.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZAlbumxAlb\u2026istViewModel::class.java)");
        ae aeVar = (ae) viewModel;
        this.mAlbumViewModel = aeVar;
        ae aeVar2 = null;
        if (aeVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
            aeVar = null;
        }
        aeVar.W1().observe(getPartHost().getLifecycleOwner(), new Observer() { // from class: com.qzone.reborn.albumx.qzonex.part.albumlist.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZAlbumxAlbumListBlockPart.Z9(QZAlbumxAlbumListBlockPart.this, (UIStateData) obj);
            }
        });
        ae aeVar3 = this.mAlbumViewModel;
        if (aeVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
            aeVar3 = null;
        }
        MutableLiveData<QZonePhotoDegrade$QueryNotifyMsgRsp> Z1 = aeVar3.Z1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<QZonePhotoDegrade$QueryNotifyMsgRsp, Unit> function1 = new Function1<QZonePhotoDegrade$QueryNotifyMsgRsp, Unit>() { // from class: com.qzone.reborn.albumx.qzonex.part.albumlist.QZAlbumxAlbumListBlockPart$initViewModel$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QZonePhotoDegrade$QueryNotifyMsgRsp qZonePhotoDegrade$QueryNotifyMsgRsp) {
                invoke2(qZonePhotoDegrade$QueryNotifyMsgRsp);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(QZonePhotoDegrade$QueryNotifyMsgRsp qZonePhotoDegrade$QueryNotifyMsgRsp) {
                QZAlbumxAlbumListBlockPart.this.O9(qZonePhotoDegrade$QueryNotifyMsgRsp);
            }
        };
        Z1.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.albumx.qzonex.part.albumlist.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZAlbumxAlbumListBlockPart.aa(Function1.this, obj);
            }
        });
        ae aeVar4 = this.mAlbumViewModel;
        if (aeVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
            aeVar4 = null;
        }
        aeVar4.h2(false, true);
        ae aeVar5 = this.mAlbumViewModel;
        if (aeVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
        } else {
            aeVar2 = aeVar5;
        }
        aeVar2.k2();
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZAlbumxAlbumListBlockPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        W9(rootView);
        L9();
        initViewModel();
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreStart() {
        ae aeVar = this.mAlbumViewModel;
        if (aeVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
            aeVar = null;
        }
        aeVar.h2(true, false);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        if (this.mIsForceHideDegradeTips) {
            return;
        }
        ae aeVar = this.mAlbumViewModel;
        if (aeVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
            aeVar = null;
        }
        aeVar.k2();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        if (event instanceof QZonePhotoDegradeEvent) {
            if (((QZonePhotoDegradeEvent) event).getIsForceClose()) {
                ae aeVar = this.mAlbumViewModel;
                if (aeVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
                    aeVar = null;
                }
                aeVar.Z1().setValue(null);
                this.mIsForceHideDegradeTips = true;
                return;
            }
            return;
        }
        if (event instanceof QZAlbumxTopAndRefreshEvent) {
            S9((QZAlbumxTopAndRefreshEvent) event);
        } else if (event instanceof QFSDeleteQZoneVideoAlbumEvent) {
            P9((QFSDeleteQZoneVideoAlbumEvent) event);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QZonePhotoDegradeEvent.class, QZAlbumxTopAndRefreshEvent.class, QFSDeleteQZoneVideoAlbumEvent.class);
        return arrayListOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O9(QZonePhotoDegrade$QueryNotifyMsgRsp queryNotifyMsgRsp) {
        List mutableListOf;
        sa.j jVar = null;
        if ((queryNotifyMsgRsp != null ? queryNotifyMsgRsp.f430342msg : null) != null) {
            na.c cVar = na.c.f419539a;
            List<QZonePhotoDegrade$Text> list = queryNotifyMsgRsp.f430342msg.texts.get();
            Intrinsics.checkNotNullExpressionValue(list, "queryNotifyMsgRsp.msg.texts.get()");
            String j3 = cVar.j(list);
            List<QZonePhotoDegrade$Button> list2 = queryNotifyMsgRsp.f430342msg.buttons.get();
            RFWLog.d("QZAlbumxAlbumListBlockPart", RFWLog.USR, "requestPhotoDegradeNotify onSuccess: " + j3 + ", button: " + list2.size());
            if (!TextUtils.isEmpty(j3) && list2.size() > 0) {
                sa.j jVar2 = this.mPhotoDegradeAdapter;
                if (jVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPhotoDegradeAdapter");
                } else {
                    jVar = jVar2;
                }
                mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(queryNotifyMsgRsp);
                jVar.setItems(mutableListOf);
                return;
            }
            sa.j jVar3 = this.mPhotoDegradeAdapter;
            if (jVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPhotoDegradeAdapter");
            } else {
                jVar = jVar3;
            }
            jVar.setItems(new ArrayList());
            return;
        }
        sa.j jVar4 = this.mPhotoDegradeAdapter;
        if (jVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPhotoDegradeAdapter");
        } else {
            jVar = jVar4;
        }
        jVar.setItems(new ArrayList());
    }

    private final void Q9(UIStateData<List<CommonAlbumListBean>> listUIStateData) {
        if (listUIStateData == null) {
            QLog.e("QZAlbumxAlbumListBlockPart", 1, "ui state data is null");
            return;
        }
        RecyclerView recyclerView = this.mRecyclerView;
        i9.b bVar = null;
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
        i9.b bVar2 = this.mAlbumListAdapter;
        if (bVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumListAdapter");
        } else {
            bVar = bVar2;
        }
        bVar.setItems(new ArrayList(listUIStateData.getData()));
        if (!listUIStateData.getIsLoadMore()) {
            RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.qzone.reborn.albumx.qzonex.part.albumlist.g
                @Override // java.lang.Runnable
                public final void run() {
                    QZAlbumxAlbumListBlockPart.R9(QZAlbumxAlbumListBlockPart.this);
                }
            }, 100L);
            ga();
            ha();
            ea();
        }
        ba();
    }

    private final void W9(View rootView) {
        View findViewById = rootView.findViewById(R.id.mpv);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026ne_albumx_refresh_layout)");
        this.mRefreshLayout = (SmartRefreshLayout) findViewById;
        View findViewById2 = rootView.findViewById(R.id.mo5);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026.qzone_albumx_blank_view)");
        this.mBlankView = (QZoneBlankStateView) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.nf5);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.rv_album_list)");
        RecyclerView recyclerView = (RecyclerView) findViewById3;
        this.mRecyclerView = recyclerView;
        SmartRefreshLayout smartRefreshLayout = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView = null;
        }
        recyclerView.setNestedScrollingEnabled(true);
        RecyclerView recyclerView2 = this.mRecyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView2 = null;
        }
        recyclerView2.setLayoutManager(new SafeGridLayoutManager(getContext(), 2));
        RecyclerView recyclerView3 = this.mRecyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView3 = null;
        }
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
        defaultItemAnimator.setSupportsChangeAnimations(false);
        recyclerView3.setItemAnimator(defaultItemAnimator);
        com.tencent.mobileqq.qui.b bVar = com.tencent.mobileqq.qui.b.f276860a;
        RecyclerView recyclerView4 = this.mRecyclerView;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView4 = null;
        }
        com.tencent.mobileqq.qui.b.d(bVar, recyclerView4, 0, 2, null);
        int dimension = (int) getContext().getResources().getDimension(R.dimen.f9669);
        RecyclerView recyclerView5 = this.mRecyclerView;
        if (recyclerView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView5 = null;
        }
        RecyclerView recyclerView6 = this.mRecyclerView;
        if (recyclerView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView6 = null;
        }
        int paddingLeft = recyclerView6.getPaddingLeft();
        RecyclerView recyclerView7 = this.mRecyclerView;
        if (recyclerView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView7 = null;
        }
        int paddingTop = recyclerView7.getPaddingTop();
        RecyclerView recyclerView8 = this.mRecyclerView;
        if (recyclerView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView8 = null;
        }
        recyclerView5.setPadding(paddingLeft, paddingTop, recyclerView8.getPaddingRight(), dimension);
        RecyclerView recyclerView9 = this.mRecyclerView;
        if (recyclerView9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView9 = null;
        }
        bVar.f(recyclerView9, dimension);
        SmartRefreshLayout smartRefreshLayout2 = this.mRefreshLayout;
        if (smartRefreshLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRefreshLayout");
            smartRefreshLayout2 = null;
        }
        smartRefreshLayout2.setOnRefreshListener(new OnRefreshListener() { // from class: com.qzone.reborn.albumx.qzonex.part.albumlist.f
            @Override // com.tencent.richframework.widget.refresh.layout.listener.OnRefreshListener
            public final void onRefresh(IRefreshLayout iRefreshLayout) {
                QZAlbumxAlbumListBlockPart.X9(QZAlbumxAlbumListBlockPart.this, iRefreshLayout);
            }
        });
        SmartRefreshLayout smartRefreshLayout3 = this.mRefreshLayout;
        if (smartRefreshLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRefreshLayout");
            smartRefreshLayout3 = null;
        }
        smartRefreshLayout3.setEnableOverScrollDrag(true);
        SmartRefreshLayout smartRefreshLayout4 = this.mRefreshLayout;
        if (smartRefreshLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRefreshLayout");
        } else {
            smartRefreshLayout = smartRefreshLayout4;
        }
        smartRefreshLayout.setEnableLoadMoreWhenContentNotFull(true);
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreEnd(boolean hasMore) {
    }
}
