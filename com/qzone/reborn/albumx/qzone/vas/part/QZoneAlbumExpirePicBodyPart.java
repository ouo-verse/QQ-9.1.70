package com.qzone.reborn.albumx.qzone.vas.part;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.feedcomponent.model.CellPictureInfo;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.reborn.albumx.common.bean.CommonGridItemData;
import com.qzone.reborn.albumx.common.convert.bean.CommonStImage;
import com.qzone.reborn.albumx.common.convert.bean.CommonStMedia;
import com.qzone.reborn.albumx.qzone.bean.init.QZoneAlbumxExpicPicInitBean;
import com.qzone.reborn.albumx.qzone.vas.widget.QZoneAlbumExpirePicItemView;
import com.qzone.reborn.base.k;
import com.qzone.reborn.feedx.block.aa;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.gallery.RFWLayerLaunchUtil;
import com.tencent.richframework.gallery.anim.RFWTransAnimBean;
import com.tencent.richframework.gallery.anim.RFWTransitionHelper;
import com.tencent.richframework.thread.RFWThreadManager;
import ho.i;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import mqq.app.Constants;
import qzone.QZonePhotoDegrade$QueryNotifyMsgRsp;
import tl.h;

@Metadata(d1 = {"\u0000\u00dc\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 `2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0001aB\u0007\u00a2\u0006\u0004\b^\u0010_J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u001a\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J,\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00132\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u001c\u0010\u0019\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u0006H\u0016J\u0010\u0010 \u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\u0012\u0010!\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u001c\u0010%\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u000f0$0#0\"H\u0016J\u001c\u0010&\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u000f0$0#0\"H\u0016J\u001c\u0010'\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u000f0$0#0\"H\u0016J0\u00100\u001a\u00020\u00062\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020\n2\u0006\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020\n2\u0006\u0010/\u001a\u00020.H\u0016J\u0012\u00101\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u001a\u00106\u001a\u0004\u0018\u0001052\u0006\u00103\u001a\u0002022\u0006\u00104\u001a\u00020\u0011H\u0016J \u00108\u001a\u00020\u00062\u0006\u00103\u001a\u0002022\u0006\u00104\u001a\u00020\u00112\u0006\u00107\u001a\u00020\u001eH\u0016R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010J\u001a\u00020G8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010N\u001a\u00020K8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010R\u001a\u00020O8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0018\u0010V\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0018\u0010Z\u001a\u0004\u0018\u00010W8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010]\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010\\\u00a8\u0006b"}, d2 = {"Lcom/qzone/reborn/albumx/qzone/vas/part/QZoneAlbumExpirePicBodyPart;", "Lcom/qzone/reborn/base/k;", "Lcom/tencent/biz/richframework/preload/recyclerview/ILoadMoreProvider$LoadMoreListener;", "Ll9/b;", "Ll9/a;", "Lcom/tencent/richframework/gallery/anim/RFWTransitionHelper$TransAnimCreator;", "", "K9", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "index", "Lcom/qzone/reborn/albumx/qzone/vas/widget/QZoneAlbumExpirePicItemView;", "H9", "", "Lcom/qzone/reborn/albumx/common/bean/CommonGridItemData;", "batchList", "", "picId", "Lkotlin/Pair;", "G9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "onLoadMoreStart", "", "hasMore", "onLoadMoreEnd", "onPartResume", "", "Ljava/lang/Class;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "B4", "r6", "K2", "Lcom/qzone/reborn/albumx/common/bean/a;", "batchBean", "batchPos", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStMedia;", QAdVrReportParams.ParamKey.MEDIA, "mediaPos", "Landroid/widget/ImageView;", "view", "A8", "onPartDestroy", "Ljava/util/UUID;", "uuid", "id", "Lcom/tencent/richframework/gallery/anim/RFWTransAnimBean;", "generateTransAnimBean", ViewStickEventHelper.IS_SHOW, "updateOriginContainer", "d", "Landroidx/recyclerview/widget/RecyclerView;", "Li9/a;", "e", "Li9/a;", "batchListAdapter", "Lcom/qzone/reborn/feedx/block/aa;", "f", "Lcom/qzone/reborn/feedx/block/aa;", "loadMoreAdapter", "Lma/a;", h.F, "Lma/a;", "topTipsAdapter", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "i", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "concatAdapter", "Lcom/qzone/reborn/albumx/qzone/vas/d;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/qzone/reborn/albumx/qzone/vas/d;", "viewModel", "Laa/c;", BdhLogUtil.LogTag.Tag_Conn, "Laa/c;", "gridDecorationHelper", "Landroid/content/BroadcastReceiver;", "D", "Landroid/content/BroadcastReceiver;", "mWebViewEventReceiver", "Lcom/qzone/reborn/albumx/qzone/bean/init/QZoneAlbumxExpicPicInitBean;", "E", "Lcom/qzone/reborn/albumx/qzone/bean/init/QZoneAlbumxExpicPicInitBean;", "initBean", UserInfo.SEX_FEMALE, "I", "transCreatorKey", "<init>", "()V", "G", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneAlbumExpirePicBodyPart extends k implements ILoadMoreProvider$LoadMoreListener, l9.b, l9.a, RFWTransitionHelper.TransAnimCreator {

    /* renamed from: C, reason: from kotlin metadata */
    private aa.c gridDecorationHelper = new aa.c();

    /* renamed from: D, reason: from kotlin metadata */
    private BroadcastReceiver mWebViewEventReceiver;

    /* renamed from: E, reason: from kotlin metadata */
    private QZoneAlbumxExpicPicInitBean initBean;

    /* renamed from: F, reason: from kotlin metadata */
    private int transCreatorKey;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private RecyclerView recyclerView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private i9.a batchListAdapter;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private aa loadMoreAdapter;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ma.a topTipsAdapter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private RFWConcatAdapter concatAdapter;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private com.qzone.reborn.albumx.qzone.vas.d viewModel;

    private final Pair<Integer, CommonGridItemData> G9(List<CommonGridItemData> batchList, String picId) {
        Iterator<CommonGridItemData> it = batchList.iterator();
        int i3 = 0;
        while (true) {
            ma.a aVar = null;
            if (!it.hasNext()) {
                return null;
            }
            int i16 = i3 + 1;
            CommonGridItemData next = it.next();
            if (next.getItemType() == CommonGridItemData.ItemType.PIC_SECTION_ITEM && Intrinsics.areEqual(next.f().getImage().getLloc(), picId)) {
                ma.a aVar2 = this.topTipsAdapter;
                if (aVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("topTipsAdapter");
                } else {
                    aVar = aVar2;
                }
                return new Pair<>(Integer.valueOf(i3 + aVar.getItemCount()), next);
            }
            i3 = i16;
        }
    }

    private final QZoneAlbumExpirePicItemView H9(RecyclerView recyclerView, int index) {
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
        if (findViewByPosition instanceof QZoneAlbumExpirePicItemView) {
            return (QZoneAlbumExpirePicItemView) findViewByPosition;
        }
        if (!(findViewByPosition instanceof ViewGroup)) {
            return null;
        }
        until = RangesKt___RangesKt.until(0, ((ViewGroup) findViewByPosition).getChildCount());
        asSequence = CollectionsKt___CollectionsKt.asSequence(until);
        map = SequencesKt___SequencesKt.map(asSequence, new Function1<Integer, View>() { // from class: com.qzone.reborn.albumx.qzone.vas.part.QZoneAlbumExpirePicBodyPart$findPicWidgetByAbsoluteIndex$1
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
        filter = SequencesKt___SequencesKt.filter(map, new Function1<Object, Boolean>() { // from class: com.qzone.reborn.albumx.qzone.vas.part.QZoneAlbumExpirePicBodyPart$findPicWidgetByAbsoluteIndex$$inlined$filterIsInstance$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Object obj) {
                return Boolean.valueOf(obj instanceof QZoneAlbumExpirePicItemView);
            }
        });
        Intrinsics.checkNotNull(filter, "null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesKt.filterIsInstance>");
        firstOrNull = SequencesKt___SequencesKt.firstOrNull(filter);
        return (QZoneAlbumExpirePicItemView) firstOrNull;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I9(QZoneAlbumExpirePicBodyPart this$0, ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        i9.a aVar = this$0.batchListAdapter;
        com.qzone.reborn.albumx.qzone.vas.d dVar = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("batchListAdapter");
            aVar = null;
        }
        aVar.setItems(arrayList);
        this$0.gridDecorationHelper.u();
        aa aaVar = this$0.loadMoreAdapter;
        if (aaVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadMoreAdapter");
            aaVar = null;
        }
        com.qzone.reborn.albumx.qzone.vas.d dVar2 = this$0.viewModel;
        if (dVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            dVar = dVar2;
        }
        aaVar.setLoadState(false, dVar.getHasLoadMore());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J9(QZoneAlbumExpirePicBodyPart this$0, QZonePhotoDegrade$QueryNotifyMsgRsp qZonePhotoDegrade$QueryNotifyMsgRsp) {
        List mutableListOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ma.a aVar = this$0.topTipsAdapter;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topTipsAdapter");
            aVar = null;
        }
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(qZonePhotoDegrade$QueryNotifyMsgRsp);
        aVar.setItems(mutableListOf);
    }

    private final void K9() {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.qzone.reborn.albumx.qzone.vas.part.c
            @Override // java.lang.Runnable
            public final void run() {
                QZoneAlbumExpirePicBodyPart.L9(QZoneAlbumExpirePicBodyPart.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(QZoneAlbumExpirePicBodyPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IntentFilter intentFilter = new IntentFilter("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
        this$0.mWebViewEventReceiver = new QZoneAlbumExpirePicBodyPart$registerRecoveryEvent$1$1(this$0);
        Activity activity = this$0.getActivity();
        if (activity != null) {
            activity.registerReceiver(this$0.mWebViewEventReceiver, intentFilter);
        }
    }

    @Override // l9.a
    public void A8(com.qzone.reborn.albumx.common.bean.a batchBean, int batchPos, CommonStMedia media, int mediaPos, ImageView view) {
        List<CommonGridItemData> subList;
        Intrinsics.checkNotNullParameter(batchBean, "batchBean");
        Intrinsics.checkNotNullParameter(media, "media");
        Intrinsics.checkNotNullParameter(view, "view");
        rk.d dVar = new rk.d();
        com.qzone.reborn.albumx.qzone.vas.d dVar2 = this.viewModel;
        com.qzone.reborn.albumx.qzone.vas.d dVar3 = null;
        if (dVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            dVar2 = null;
        }
        ArrayList<CommonGridItemData> value = dVar2.P1().getValue();
        CellPictureInfo cellPictureInfo = new CellPictureInfo();
        cellPictureInfo.pics = new ArrayList<>();
        int i3 = 0;
        if (value != null) {
            ArrayList<CommonGridItemData> arrayList = new ArrayList();
            for (Object obj : value) {
                if (((CommonGridItemData) obj).getItemType() == CommonGridItemData.ItemType.PIC_SECTION_ITEM) {
                    arrayList.add(obj);
                }
            }
            for (CommonGridItemData commonGridItemData : arrayList) {
                ArrayList<PictureItem> arrayList2 = cellPictureInfo.pics;
                PictureItem pictureItem = new PictureItem();
                pictureItem.originUrl.url = commonGridItemData.f().l();
                pictureItem.lloc = commonGridItemData.f().getImage().getLloc();
                pictureItem.bigUrl = pictureItem.originUrl;
                arrayList2.add(pictureItem);
            }
        }
        dVar.v(cellPictureInfo);
        view.setTag(R.id.f100755tc, Integer.valueOf(this.transCreatorKey));
        if (value != null && (subList = value.subList(0, mediaPos)) != null) {
            ArrayList arrayList3 = new ArrayList();
            for (Object obj2 : subList) {
                if (((CommonGridItemData) obj2).getItemType() == CommonGridItemData.ItemType.HEAD_SECTION_ITEM) {
                    arrayList3.add(obj2);
                }
            }
            i3 = arrayList3.size();
        }
        dVar.g(mediaPos - i3);
        dVar.i(1204);
        dVar.f(view);
        dVar.s(true);
        com.qzone.reborn.albumx.qzone.vas.d dVar4 = this.viewModel;
        if (dVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            dVar4 = null;
        }
        String valueOf = String.valueOf(dVar4.getDataRepo().hashCode());
        fj.a aVar = fj.a.f399444a;
        com.qzone.reborn.albumx.qzone.vas.d dVar5 = this.viewModel;
        if (dVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            dVar3 = dVar5;
        }
        aVar.c(valueOf, dVar3.getDataRepo());
        Bundle bundle = new Bundle();
        bundle.putString("layer_outside_data", valueOf);
        dVar.q(bundle);
        ((rk.e) i.t(rk.e.class)).s(getActivity(), dVar);
    }

    @Override // l9.b
    public List<Class<? extends Section<CommonGridItemData>>> K2() {
        return new ArrayList();
    }

    @Override // com.tencent.richframework.gallery.anim.RFWTransitionHelper.TransAnimCreator
    public RFWTransAnimBean generateTransAnimBean(UUID uuid, String id5) {
        CommonStImage cover;
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(id5, "id");
        i9.a aVar = this.batchListAdapter;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("batchListAdapter");
            aVar = null;
        }
        List<CommonGridItemData> items = aVar.getItems();
        Intrinsics.checkNotNullExpressionValue(items, "batchListAdapter.items");
        Pair<Integer, CommonGridItemData> G9 = G9(items, id5);
        if (G9 == null) {
            return null;
        }
        int intValue = G9.component1().intValue();
        CommonGridItemData component2 = G9.component2();
        QLog.d("QZoneAlbumExpirePicBodyPart", 1, "cur index: " + intValue + ", " + component2.getBatchPos() + ", " + component2.getMediaPos());
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        QZoneAlbumExpirePicItemView H9 = H9(recyclerView, intValue);
        if (k9.a.h(component2.f())) {
            cover = component2.f().getImage();
        } else {
            cover = component2.f().getVideo().getCover();
        }
        return RFWLayerLaunchUtil.getTransAnimBean(uuid, H9 != null ? H9.getImageView() : null, mj.a.g(cover), true);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        registerIoc(this, l9.b.class);
        this.transCreatorKey = RFWTransitionHelper.INSTANCE.registerTransitionBeanCreator(this);
        RFWIocAbilityProvider.g().registerIoc(rootView, this, l9.a.class);
        View findViewById = rootView.findViewById(R.id.f162918nb3);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.qzone_rv_pic_list)");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.recyclerView = recyclerView;
        com.qzone.reborn.albumx.qzone.vas.d dVar = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        recyclerView.setNestedScrollingEnabled(true);
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView2 = null;
        }
        recyclerView2.setItemAnimator(null);
        RecyclerView recyclerView3 = this.recyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView3 = null;
        }
        recyclerView3.setOverScrollMode(2);
        this.batchListAdapter = new i9.a();
        this.loadMoreAdapter = new aa();
        this.topTipsAdapter = new ma.a();
        aa aaVar = this.loadMoreAdapter;
        if (aaVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadMoreAdapter");
            aaVar = null;
        }
        aaVar.registerLoadMoreListener(this);
        i9.a aVar = this.batchListAdapter;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("batchListAdapter");
            aVar = null;
        }
        aVar.setHasStableIds(true);
        aa aaVar2 = this.loadMoreAdapter;
        if (aaVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadMoreAdapter");
            aaVar2 = null;
        }
        aaVar2.setHasStableIds(true);
        ma.a aVar2 = this.topTipsAdapter;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topTipsAdapter");
            aVar2 = null;
        }
        aVar2.setHasStableIds(true);
        aa aaVar3 = this.loadMoreAdapter;
        if (aaVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadMoreAdapter");
            aaVar3 = null;
        }
        aaVar3.p0(new aa.a().e(HardCodeUtil.qqStr(R.string.to_)).f("").d(""));
        RFWConcatAdapter.Config build = new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build();
        RecyclerView.Adapter[] adapterArr = new RecyclerView.Adapter[3];
        ma.a aVar3 = this.topTipsAdapter;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topTipsAdapter");
            aVar3 = null;
        }
        adapterArr[0] = aVar3;
        i9.a aVar4 = this.batchListAdapter;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("batchListAdapter");
            aVar4 = null;
        }
        adapterArr[1] = aVar4;
        aa aaVar4 = this.loadMoreAdapter;
        if (aaVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadMoreAdapter");
            aaVar4 = null;
        }
        adapterArr[2] = aaVar4;
        this.concatAdapter = new RFWConcatAdapter(build, (RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) adapterArr);
        aa.c cVar = this.gridDecorationHelper;
        RecyclerView recyclerView4 = this.recyclerView;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView4 = null;
        }
        RFWConcatAdapter rFWConcatAdapter = this.concatAdapter;
        if (rFWConcatAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("concatAdapter");
            rFWConcatAdapter = null;
        }
        i9.a aVar5 = this.batchListAdapter;
        if (aVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("batchListAdapter");
            aVar5 = null;
        }
        aa aaVar5 = this.loadMoreAdapter;
        if (aaVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadMoreAdapter");
            aaVar5 = null;
        }
        cVar.p(recyclerView4, rFWConcatAdapter, aVar5, aaVar5);
        RecyclerView recyclerView5 = this.recyclerView;
        if (recyclerView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView5 = null;
        }
        RFWConcatAdapter rFWConcatAdapter2 = this.concatAdapter;
        if (rFWConcatAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("concatAdapter");
            rFWConcatAdapter2 = null;
        }
        recyclerView5.setAdapter(rFWConcatAdapter2);
        ViewModel viewModel = getViewModel(com.qzone.reborn.albumx.qzone.vas.d.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZoneAlbumE\u2026PicViewModel::class.java)");
        com.qzone.reborn.albumx.qzone.vas.d dVar2 = (com.qzone.reborn.albumx.qzone.vas.d) viewModel;
        this.viewModel = dVar2;
        if (dVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            dVar2 = null;
        }
        dVar2.P1().observe(getHostFragment(), new Observer() { // from class: com.qzone.reborn.albumx.qzone.vas.part.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZoneAlbumExpirePicBodyPart.I9(QZoneAlbumExpirePicBodyPart.this, (ArrayList) obj);
            }
        });
        com.qzone.reborn.albumx.qzone.vas.d dVar3 = this.viewModel;
        if (dVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            dVar3 = null;
        }
        dVar3.O1().observe(getHostFragment(), new Observer() { // from class: com.qzone.reborn.albumx.qzone.vas.part.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZoneAlbumExpirePicBodyPart.J9(QZoneAlbumExpirePicBodyPart.this, (QZonePhotoDegrade$QueryNotifyMsgRsp) obj);
            }
        });
        com.qzone.reborn.albumx.qzone.vas.d dVar4 = this.viewModel;
        if (dVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            dVar = dVar4;
        }
        QZoneAlbumxExpicPicInitBean qZoneAlbumxExpicPicInitBean = this.initBean;
        dVar.S1(false, qZoneAlbumxExpicPicInitBean != null ? qZoneAlbumxExpicPicInitBean.getPhotoStatus() : 0);
        QZoneAlbumxExpicPicInitBean qZoneAlbumxExpicPicInitBean2 = this.initBean;
        if (qZoneAlbumxExpicPicInitBean2 != null && qZoneAlbumxExpicPicInitBean2.getPhotoStatus() == 1) {
            K9();
        }
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreStart() {
        com.qzone.reborn.albumx.qzone.vas.d dVar = this.viewModel;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            dVar = null;
        }
        QZoneAlbumxExpicPicInitBean qZoneAlbumxExpicPicInitBean = this.initBean;
        dVar.S1(true, qZoneAlbumxExpicPicInitBean != null ? qZoneAlbumxExpicPicInitBean.getPhotoStatus() : 0);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        Intent intent;
        super.onPartCreate(activity, savedInstanceState);
        Serializable serializableExtra = (activity == null || (intent = activity.getIntent()) == null) ? null : intent.getSerializableExtra("key_bundle_common_init_bean");
        QZoneAlbumxExpicPicInitBean qZoneAlbumxExpicPicInitBean = serializableExtra instanceof QZoneAlbumxExpicPicInitBean ? (QZoneAlbumxExpicPicInitBean) serializableExtra : null;
        this.initBean = qZoneAlbumxExpicPicInitBean;
        QLog.d("QZoneAlbumExpirePicBodyPart", 1, "onPartCreate: " + qZoneAlbumxExpicPicInitBean);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        fj.a aVar = fj.a.f399444a;
        com.qzone.reborn.albumx.qzone.vas.d dVar = this.viewModel;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            dVar = null;
        }
        aVar.b(String.valueOf(dVar.getDataRepo().hashCode()));
        BroadcastReceiver broadcastReceiver = this.mWebViewEventReceiver;
        if (broadcastReceiver == null || activity == null) {
            return;
        }
        activity.unregisterReceiver(broadcastReceiver);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        com.qzone.reborn.albumx.qzone.vas.d dVar = this.viewModel;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            dVar = null;
        }
        dVar.T1();
    }

    @Override // l9.b
    public List<Class<? extends Section<CommonGridItemData>>> r6() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(oa.a.class);
        return arrayList;
    }

    @Override // com.tencent.richframework.gallery.anim.RFWTransitionHelper.TransAnimCreator
    public void updateOriginContainer(UUID uuid, String id5, boolean isShow) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(id5, "id");
    }

    @Override // l9.b
    public List<Class<? extends Section<CommonGridItemData>>> B4() {
        List<Class<? extends Section<CommonGridItemData>>> mutableListOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(oa.b.class);
        return mutableListOf;
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreEnd(boolean hasMore) {
    }
}
