package com.qzone.reborn.albumx.qzonex.part.pictab;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.reborn.albumx.common.convert.bean.CommonPhotoInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonStImage;
import com.qzone.reborn.albumx.common.convert.bean.CommonStMedia;
import com.qzone.reborn.albumx.common.convert.bean.CommonStVideo;
import com.qzone.reborn.albumx.qzonex.bean.upload.QZAlbumxUploadAlbumInitBean;
import com.qzone.reborn.albumx.qzonex.event.QZAlbumxTopAndRefreshEvent;
import com.qzone.reborn.albumx.qzonex.event.QZAlbumxUploadAlbumEvent;
import com.qzone.reborn.feedx.block.aa;
import com.qzone.reborn.widget.QZoneBlankStateView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.bl;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.gallery.RFWLayerLaunchUtil;
import com.tencent.richframework.gallery.anim.RFWTransAnimBean;
import com.tencent.richframework.gallery.anim.RFWTransitionHelper;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.richframework.widget.refresh.layout.SmartRefreshLayout;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshLayout;
import com.tencent.richframework.widget.refresh.layout.listener.OnRefreshListener;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import nc.bp;

@Metadata(d1 = {"\u0000\u00ca\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\b\u0012\u0004\u0012\u00020\u00060\u0005B\u000f\u0012\u0006\u0010E\u001a\u00020@\u00a2\u0006\u0004\bq\u0010rJ\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J,\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\f\u0018\u00010\u00102\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u001a\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0011H\u0002J\b\u0010\u0018\u001a\u00020\tH\u0002J\b\u0010\u0019\u001a\u00020\tH\u0002J\u0016\u0010\u001d\u001a\u00020\t2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0002J\u0016\u0010\u001e\u001a\u00020\t2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0002J\u0016\u0010\u001f\u001a\u00020\t2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0002J\u0016\u0010 \u001a\u00020\t2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0002J\b\u0010!\u001a\u00020\u000eH\u0016J\u0010\u0010\"\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u001a\u0010'\u001a\u0004\u0018\u00010&2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u000eH\u0016J \u0010*\u001a\u00020\t2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020(H\u0016J\u0016\u0010,\u001a\u00020\t2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0014J\u0016\u0010-\u001a\u00020\t2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0014J\u0016\u0010.\u001a\u00020\t2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0014J\b\u0010/\u001a\u00020\tH\u0016J\u0010\u00101\u001a\u00020\t2\u0006\u00100\u001a\u00020(H\u0016J\u000e\u00103\u001a\u00020\t2\u0006\u00102\u001a\u00020\u0011J\b\u00104\u001a\u00020\u0011H\u0016J\u0012\u00107\u001a\u00020\t2\b\u00106\u001a\u0004\u0018\u000105H\u0016J$\u0010;\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060908j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000609`:H\u0016J\u0012\u0010=\u001a\u00020\t2\b\u0010<\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010?\u001a\u00020\t2\u0006\u0010<\u001a\u00020>H\u0014R\u0017\u0010E\u001a\u00020@8\u0006\u00a2\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010DR\u0016\u0010I\u001a\u00020F8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bG\u0010HR\"\u0010\u0014\u001a\u00020\u00138\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u0016\u0010S\u001a\u00020P8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\"\u0010[\u001a\u00020T8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\bU\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\u0016\u0010_\u001a\u00020\\8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b]\u0010^R\"\u0010g\u001a\u00020`8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\ba\u0010b\u001a\u0004\bc\u0010d\"\u0004\be\u0010fR\u0016\u0010k\u001a\u00020h8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bi\u0010jR\u001b\u0010p\u001a\u00020\u00118BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bl\u0010m\u001a\u0004\bn\u0010o\u00a8\u0006s"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/part/pictab/QZAlbumTabListPart;", "Lcom/qzone/reborn/base/k;", "Lcom/tencent/biz/richframework/preload/recyclerview/ILoadMoreProvider$LoadMoreListener;", "Lcom/tencent/richframework/gallery/anim/RFWTransitionHelper$TransAnimCreator;", "Lhb/e;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "X9", "", "Lcb/b;", "list", "", "picId", "Lkotlin/Pair;", "", "I9", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "index", "Landroid/widget/ImageView;", "J9", "H9", "initData", "Lcom/tencent/richframework/data/base/UIStateData;", "Lcb/a;", "listUIStateData", "Q9", "ga", "P9", "ea", "getLogTag", "onInitView", "Ljava/util/UUID;", "uuid", "id", "Lcom/tencent/richframework/gallery/anim/RFWTransAnimBean;", "generateTransAnimBean", "", ViewStickEventHelper.IS_SHOW, "updateOriginContainer", "uiStateData", "R9", "U9", "da", "onLoadMoreStart", "hasMore", "onLoadMoreEnd", IProfileCardConst.KEY_FROM_TYPE, "Z9", "C5", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "event", "onReceiveEvent", "Lcom/qzone/reborn/albumx/qzonex/event/QZAlbumxTopAndRefreshEvent;", "T9", "Lnc/bp;", "d", "Lnc/bp;", "M9", "()Lnc/bp;", "mediaViewModel", "Lsa/a;", "e", "Lsa/a;", "mediaAdapter", "f", "Landroidx/recyclerview/widget/RecyclerView;", "N9", "()Landroidx/recyclerview/widget/RecyclerView;", "ba", "(Landroidx/recyclerview/widget/RecyclerView;)V", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", tl.h.F, "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "concatAdapter", "Lcom/tencent/richframework/widget/refresh/layout/SmartRefreshLayout;", "i", "Lcom/tencent/richframework/widget/refresh/layout/SmartRefreshLayout;", "O9", "()Lcom/tencent/richframework/widget/refresh/layout/SmartRefreshLayout;", "ca", "(Lcom/tencent/richframework/widget/refresh/layout/SmartRefreshLayout;)V", "refreshLayout", "Lsa/e;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lsa/e;", "loadMoreAdapter", "Lcom/qzone/reborn/widget/QZoneBlankStateView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/reborn/widget/QZoneBlankStateView;", "K9", "()Lcom/qzone/reborn/widget/QZoneBlankStateView;", "aa", "(Lcom/qzone/reborn/widget/QZoneBlankStateView;)V", "blankView", "Lcom/qzone/reborn/albumx/qzonex/utils/a;", "D", "Lcom/qzone/reborn/albumx/qzonex/utils/a;", "decorationHelper", "E", "Lkotlin/Lazy;", "L9", "()I", "creatorKey", "<init>", "(Lnc/bp;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public class QZAlbumTabListPart extends com.qzone.reborn.base.k implements ILoadMoreProvider$LoadMoreListener, RFWTransitionHelper.TransAnimCreator, hb.e, SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: C, reason: from kotlin metadata */
    protected QZoneBlankStateView blankView;

    /* renamed from: D, reason: from kotlin metadata */
    private com.qzone.reborn.albumx.qzonex.utils.a decorationHelper;

    /* renamed from: E, reason: from kotlin metadata */
    private final Lazy creatorKey;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final bp mediaViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private sa.a mediaAdapter;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    protected RecyclerView recyclerView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private RFWConcatAdapter concatAdapter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    protected SmartRefreshLayout refreshLayout;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private sa.e loadMoreAdapter;

    public QZAlbumTabListPart(bp mediaViewModel) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(mediaViewModel, "mediaViewModel");
        this.mediaViewModel = mediaViewModel;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.qzone.reborn.albumx.qzonex.part.pictab.QZAlbumTabListPart$creatorKey$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                return Integer.valueOf(RFWTransitionHelper.INSTANCE.registerTransitionBeanCreator(QZAlbumTabListPart.this));
            }
        });
        this.creatorKey = lazy;
    }

    private final void H9() {
        this.mediaAdapter = new sa.a();
        sa.e eVar = new sa.e();
        this.loadMoreAdapter = eVar;
        eVar.registerLoadMoreListener(this);
        sa.a aVar = this.mediaAdapter;
        RFWConcatAdapter rFWConcatAdapter = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaAdapter");
            aVar = null;
        }
        aVar.setHasStableIds(true);
        sa.e eVar2 = this.loadMoreAdapter;
        if (eVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadMoreAdapter");
            eVar2 = null;
        }
        eVar2.setHasStableIds(true);
        sa.e eVar3 = this.loadMoreAdapter;
        if (eVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadMoreAdapter");
            eVar3 = null;
        }
        eVar3.p0(new aa.a().e(HardCodeUtil.qqStr(R.string.w_3)).f("").d(""));
        sa.e eVar4 = this.loadMoreAdapter;
        if (eVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadMoreAdapter");
            eVar4 = null;
        }
        eVar4.setMaxAutoLoadMoreTimes(3);
        RFWConcatAdapter.Config build = new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build();
        RecyclerView.Adapter[] adapterArr = new RecyclerView.Adapter[2];
        sa.a aVar2 = this.mediaAdapter;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaAdapter");
            aVar2 = null;
        }
        adapterArr[0] = aVar2;
        sa.e eVar5 = this.loadMoreAdapter;
        if (eVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadMoreAdapter");
            eVar5 = null;
        }
        adapterArr[1] = eVar5;
        this.concatAdapter = new RFWConcatAdapter(build, (RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) adapterArr);
        com.qzone.reborn.albumx.qzonex.utils.a aVar3 = new com.qzone.reborn.albumx.qzonex.utils.a();
        this.decorationHelper = aVar3;
        RecyclerView N9 = N9();
        RFWConcatAdapter rFWConcatAdapter2 = this.concatAdapter;
        if (rFWConcatAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("concatAdapter");
            rFWConcatAdapter2 = null;
        }
        sa.a aVar4 = this.mediaAdapter;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaAdapter");
            aVar4 = null;
        }
        sa.e eVar6 = this.loadMoreAdapter;
        if (eVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadMoreAdapter");
            eVar6 = null;
        }
        aVar3.n(N9, rFWConcatAdapter2, aVar4, eVar6);
        com.qzone.reborn.albumx.qzonex.utils.a aVar5 = this.decorationHelper;
        if (aVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("decorationHelper");
            aVar5 = null;
        }
        aVar5.j(this.mediaViewModel.R1());
        RecyclerView N92 = N9();
        RFWConcatAdapter rFWConcatAdapter3 = this.concatAdapter;
        if (rFWConcatAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("concatAdapter");
        } else {
            rFWConcatAdapter = rFWConcatAdapter3;
        }
        N92.setAdapter(rFWConcatAdapter);
    }

    private final Pair<Integer, cb.b> I9(List<cb.b> list, String picId) {
        int i3 = 0;
        for (cb.b bVar : list) {
            int i16 = i3 + 1;
            if (bVar.getItemType() != 1 && Intrinsics.areEqual(bVar.getMediaId(), picId)) {
                return new Pair<>(Integer.valueOf(i3), bVar);
            }
            i3 = i16;
        }
        return null;
    }

    private final ImageView J9(RecyclerView recyclerView, int index) {
        IntRange until;
        Sequence asSequence;
        Sequence map;
        Sequence filter;
        Object firstOrNull;
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
        if (linearLayoutManager == null) {
            return null;
        }
        if (!(linearLayoutManager.findFirstVisibleItemPosition() <= index && index <= linearLayoutManager.findLastVisibleItemPosition())) {
            return null;
        }
        final View findViewByPosition = linearLayoutManager.findViewByPosition(index);
        if (findViewByPosition instanceof ImageView) {
            return (ImageView) findViewByPosition;
        }
        if (!(findViewByPosition instanceof ViewGroup)) {
            return null;
        }
        until = RangesKt___RangesKt.until(0, ((ViewGroup) findViewByPosition).getChildCount());
        asSequence = CollectionsKt___CollectionsKt.asSequence(until);
        map = SequencesKt___SequencesKt.map(asSequence, new Function1<Integer, View>() { // from class: com.qzone.reborn.albumx.qzonex.part.pictab.QZAlbumTabListPart$findPicWidgetByAbsoluteIndex$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final View invoke(int i3) {
                return ((ViewGroup) findViewByPosition).getChildAt(i3);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ View invoke(Integer num) {
                return invoke(num.intValue());
            }
        });
        filter = SequencesKt___SequencesKt.filter(map, new Function1<Object, Boolean>() { // from class: com.qzone.reborn.albumx.qzonex.part.pictab.QZAlbumTabListPart$findPicWidgetByAbsoluteIndex$$inlined$filterIsInstance$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Object obj) {
                return Boolean.valueOf(obj instanceof ImageView);
            }
        });
        Intrinsics.checkNotNull(filter, "null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesKt.filterIsInstance>");
        firstOrNull = SequencesKt___SequencesKt.firstOrNull(filter);
        return (ImageView) firstOrNull;
    }

    private final int L9() {
        return ((Number) this.creatorKey.getValue()).intValue();
    }

    private final void P9(UIStateData<cb.a> listUIStateData) {
        sa.a aVar = this.mediaAdapter;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaAdapter");
            aVar = null;
        }
        aVar.setItems(new ArrayList(listUIStateData.getData().g()));
        this.mediaViewModel.T1().postValue(Boolean.valueOf(listUIStateData.getData().g().isEmpty()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q9(UIStateData<cb.a> listUIStateData) {
        QLog.i(getTAG(), 1, "handleMessageListRsp()  state = " + listUIStateData.getState() + " isFinish: " + listUIStateData.getIsFinish());
        ga(listUIStateData);
        int state = listUIStateData.getState();
        if (state == 0) {
            da(listUIStateData);
        } else if (state == 2 || state == 3) {
            R9(listUIStateData);
        } else if (state == 4) {
            ea(listUIStateData);
        } else if (state == 6 || state == 7) {
            P9(listUIStateData);
        }
        O9().finishRefresh();
        sa.e eVar = this.loadMoreAdapter;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadMoreAdapter");
            eVar = null;
        }
        eVar.setLoadState(listUIStateData.isLoading(), !listUIStateData.getIsFinish());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S9(QZAlbumTabListPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.N9().scrollToPosition(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W9(QZAlbumTabListPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        bp.Q1(this$0.mediaViewModel, false, true, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y9(QZAlbumTabListPart this$0, IRefreshLayout it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        if (!this$0.mediaViewModel.Z1()) {
            sa.e eVar = this$0.loadMoreAdapter;
            if (eVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadMoreAdapter");
                eVar = null;
            }
            eVar.resetAutoLoadMoreTimes();
        }
        this$0.mediaViewModel.f2();
    }

    private final void ea(UIStateData<cb.a> listUIStateData) {
        if (listUIStateData.getIsLoadMore()) {
            return;
        }
        N9().setVisibility(4);
        this.mediaViewModel.T1().postValue(Boolean.TRUE);
        if (K9().getData() == null) {
            U9(listUIStateData);
        }
        K9().showErrorView();
    }

    private final void ga(UIStateData<cb.a> listUIStateData) {
        boolean isFinish = listUIStateData.getIsFinish();
        sa.e eVar = null;
        if (isFinish && listUIStateData.getData().getPageEndMsg().getCode() == 10087) {
            String desc = listUIStateData.getData().getPageEndMsg().getDesc();
            if (!(desc == null || desc.length() == 0)) {
                sa.e eVar2 = this.loadMoreAdapter;
                if (eVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("loadMoreAdapter");
                } else {
                    eVar = eVar2;
                }
                eVar.p0(new aa.a().e(HardCodeUtil.qqStr(R.string.w_3)).f(listUIStateData.getData().getPageEndMsg().getDesc()).d(""));
                return;
            }
        }
        if (isFinish) {
            sa.e eVar3 = this.loadMoreAdapter;
            if (eVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadMoreAdapter");
            } else {
                eVar = eVar3;
            }
            eVar.p0(new aa.a().e(HardCodeUtil.qqStr(R.string.w_3)).f("").d(""));
        }
    }

    private final void initData() {
        MutableLiveData<UIStateData<cb.a>> W1 = this.mediaViewModel.W1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<UIStateData<cb.a>, Unit> function1 = new Function1<UIStateData<cb.a>, Unit>() { // from class: com.qzone.reborn.albumx.qzonex.part.pictab.QZAlbumTabListPart$initData$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UIStateData<cb.a> uIStateData) {
                invoke2(uIStateData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(UIStateData<cb.a> it) {
                QZAlbumTabListPart qZAlbumTabListPart = QZAlbumTabListPart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                qZAlbumTabListPart.Q9(it);
            }
        };
        W1.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.albumx.qzonex.part.pictab.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZAlbumTabListPart.V9(Function1.this, obj);
            }
        });
        bp bpVar = this.mediaViewModel;
        Context context = getContext();
        Activity activity = context instanceof Activity ? (Activity) context : null;
        Intent intent = activity != null ? activity.getIntent() : null;
        if (intent == null) {
            intent = new Intent();
        }
        bpVar.O1(intent);
        getMainHandler().postDelayed(new Runnable() { // from class: com.qzone.reborn.albumx.qzonex.part.pictab.e
            @Override // java.lang.Runnable
            public final void run() {
                QZAlbumTabListPart.W9(QZAlbumTabListPart.this);
            }
        }, 500L);
    }

    @Override // hb.e
    public int C5() {
        return L9();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final QZoneBlankStateView K9() {
        QZoneBlankStateView qZoneBlankStateView = this.blankView;
        if (qZoneBlankStateView != null) {
            return qZoneBlankStateView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("blankView");
        return null;
    }

    /* renamed from: M9, reason: from getter */
    public final bp getMediaViewModel() {
        return this.mediaViewModel;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final RecyclerView N9() {
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView != null) {
            return recyclerView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final SmartRefreshLayout O9() {
        SmartRefreshLayout smartRefreshLayout = this.refreshLayout;
        if (smartRefreshLayout != null) {
            return smartRefreshLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void R9(UIStateData<cb.a> uiStateData) {
        Intrinsics.checkNotNullParameter(uiStateData, "uiStateData");
        if (bl.b(uiStateData.getData().g())) {
            da(uiStateData);
            return;
        }
        N9().setVisibility(0);
        this.mediaViewModel.T1().postValue(Boolean.FALSE);
        K9().o0();
        sa.a aVar = this.mediaAdapter;
        com.qzone.reborn.albumx.qzonex.utils.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaAdapter");
            aVar = null;
        }
        aVar.setItems(new ArrayList(uiStateData.getData().g()));
        com.qzone.reborn.albumx.qzonex.utils.a aVar3 = this.decorationHelper;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("decorationHelper");
            aVar3 = null;
        }
        aVar3.o();
        com.qzone.reborn.albumx.qzonex.utils.a aVar4 = this.decorationHelper;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("decorationHelper");
        } else {
            aVar2 = aVar4;
        }
        aVar2.p(this.mediaViewModel.R1());
        if (uiStateData.getData().getIsNeedScrollToFirst()) {
            RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.qzone.reborn.albumx.qzonex.part.pictab.f
                @Override // java.lang.Runnable
                public final void run() {
                    QZAlbumTabListPart.S9(QZAlbumTabListPart.this);
                }
            }, 100L);
        }
    }

    protected void T9(QZAlbumxTopAndRefreshEvent event) {
        throw null;
    }

    protected void U9(UIStateData<cb.a> listUIStateData) {
        throw null;
    }

    public final void Z9(int fromType) {
        QZAlbumxUploadAlbumInitBean qZAlbumxUploadAlbumInitBean = new QZAlbumxUploadAlbumInitBean(this.mediaViewModel.getUin(), 0, true, null, fromType);
        vb.b x16 = ho.i.x();
        Intrinsics.checkNotNullExpressionValue(x16, "qzAlbumx()");
        vb.b.m(x16, getContext(), qZAlbumxUploadAlbumInitBean, null, 4, null);
    }

    protected final void aa(QZoneBlankStateView qZoneBlankStateView) {
        Intrinsics.checkNotNullParameter(qZoneBlankStateView, "<set-?>");
        this.blankView = qZoneBlankStateView;
    }

    protected final void ba(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "<set-?>");
        this.recyclerView = recyclerView;
    }

    protected final void ca(SmartRefreshLayout smartRefreshLayout) {
        Intrinsics.checkNotNullParameter(smartRefreshLayout, "<set-?>");
        this.refreshLayout = smartRefreshLayout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void da(UIStateData<cb.a> uiStateData) {
        Intrinsics.checkNotNullParameter(uiStateData, "uiStateData");
        N9().setVisibility(4);
        this.mediaViewModel.T1().postValue(Boolean.TRUE);
        U9(uiStateData);
        K9().s0();
    }

    @Override // com.tencent.richframework.gallery.anim.RFWTransitionHelper.TransAnimCreator
    public RFWTransAnimBean generateTransAnimBean(UUID uuid, String id5) {
        CommonStMedia media;
        CommonStVideo video;
        CommonStMedia media2;
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(id5, "id");
        sa.a aVar = this.mediaAdapter;
        CommonStImage commonStImage = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaAdapter");
            aVar = null;
        }
        List<cb.b> items = aVar.getItems();
        Intrinsics.checkNotNullExpressionValue(items, "mediaAdapter.items");
        Pair<Integer, cb.b> I9 = I9(items, id5);
        if (I9 == null) {
            return null;
        }
        int intValue = I9.component1().intValue();
        cb.b component2 = I9.component2();
        QLog.d(getTAG(), 1, "cur index: " + intValue + ", " + component2.getMediaPos() + ", " + component2.getMediaPos());
        ImageView J9 = J9(N9(), intValue);
        if (component2.getItemType() == 2) {
            CommonPhotoInfo mediaData = component2.getMediaData();
            if (mediaData != null && (media2 = mediaData.getMedia()) != null) {
                commonStImage = media2.getImage();
            }
        } else {
            CommonPhotoInfo mediaData2 = component2.getMediaData();
            if (mediaData2 != null && (media = mediaData2.getMedia()) != null && (video = media.getVideo()) != null) {
                commonStImage = video.getCover();
            }
        }
        return RFWLayerLaunchUtil.getTransAnimBean(uuid, J9, mj.a.g(commonStImage), true);
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        throw null;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        SimpleEventBus.getInstance().registerReceiver(this);
        X9(rootView);
        H9();
        initData();
        registerIoc(rootView, this, hb.e.class);
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreEnd(boolean hasMore) {
        QLog.d(getTAG(), 1, "onLoadMoreEnd  hasMore = " + hasMore);
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreStart() {
        QLog.d(getTAG(), 1, "onLoadMoreStart ");
        this.mediaViewModel.b2();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        if (event instanceof QZAlbumxUploadAlbumEvent) {
            bp.Q1(this.mediaViewModel, true, false, 2, null);
        } else if (event instanceof QZAlbumxTopAndRefreshEvent) {
            T9((QZAlbumxTopAndRefreshEvent) event);
        }
    }

    @Override // com.tencent.richframework.gallery.anim.RFWTransitionHelper.TransAnimCreator
    public void updateOriginContainer(UUID uuid, String id5, boolean isShow) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(id5, "id");
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QZAlbumxUploadAlbumEvent.class, QZAlbumxTopAndRefreshEvent.class);
        return arrayListOf;
    }

    private final void X9(View rootView) {
        View findViewById = rootView.findViewById(R.id.mqu);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.qzone_blank_view)");
        aa((QZoneBlankStateView) findViewById);
        View findViewById2 = rootView.findViewById(R.id.f162917nb2);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.qzone_rv_list)");
        ba((RecyclerView) findViewById2);
        int dimension = (int) getContext().getResources().getDimension(R.dimen.f9669);
        N9().setPadding(N9().getPaddingLeft(), N9().getPaddingTop(), N9().getPaddingRight(), dimension);
        com.tencent.mobileqq.qui.b.f276860a.f(N9(), dimension);
        View findViewById3 = rootView.findViewById(R.id.nbb);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.\u2026one_smart_refresh_layout)");
        ca((SmartRefreshLayout) findViewById3);
        O9().setOnRefreshListener(new OnRefreshListener() { // from class: com.qzone.reborn.albumx.qzonex.part.pictab.c
            @Override // com.tencent.richframework.widget.refresh.layout.listener.OnRefreshListener
            public final void onRefresh(IRefreshLayout iRefreshLayout) {
                QZAlbumTabListPart.Y9(QZAlbumTabListPart.this, iRefreshLayout);
            }
        });
        O9().setEnableOverScrollDrag(false);
        O9().setEnableOverScrollBounce(false);
        N9().setNestedScrollingEnabled(true);
        N9().setItemAnimator(null);
    }
}
