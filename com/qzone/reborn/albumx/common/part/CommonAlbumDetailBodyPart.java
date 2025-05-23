package com.qzone.reborn.albumx.common.part;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.albumx.common.bean.CommonGridItemData;
import com.qzone.reborn.albumx.common.convert.bean.CommonStImage;
import com.qzone.reborn.albumx.common.convert.bean.CommonStMedia;
import com.qzone.reborn.albumx.common.widget.CommonAlbumDetailPicWidgetView;
import com.qzone.reborn.feedx.block.aa;
import com.qzone.reborn.widget.QZoneBlankStateView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.bl;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.mtt.hippy.views.scroll.HippyScrollViewEventHelper;
import com.tencent.qcircle.weseevideo.model.utils.LocaleUtils;
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
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import mqq.app.Constants;

@Metadata(d1 = {"\u0000\u00d8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0016\u0018\u0000 \u0098\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002\u0099\u0001B\t\u00a2\u0006\u0006\b\u0096\u0001\u0010\u0097\u0001J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u001c\u0010\f\u001a\u00020\u00052\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bH\u0002J\u001c\u0010\r\u001a\u00020\u00052\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bH\u0002J\u0014\u0010\u0010\u001a\u00020\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J,\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00172\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0016\u001a\u00020\u000eH\u0002J\u001a\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0011H\u0002J\b\u0010\u001e\u001a\u00020\u000eH\u0016J\u001c\u0010#\u001a\u00020\u00052\b\u0010 \u001a\u0004\u0018\u00010\u001f2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016J\u0010\u0010&\u001a\u00020\u00052\u0006\u0010%\u001a\u00020$H\u0016J\b\u0010(\u001a\u00020'H\u0016J\b\u0010*\u001a\u00020)H\u0016J\b\u0010+\u001a\u00020\u0005H\u0016J\b\u0010,\u001a\u00020\u0005H\u0016J\u001c\u0010.\u001a\u00020\u00052\u0012\u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bH\u0016J\u001c\u0010/\u001a\u00020\u00052\u0012\u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bH\u0016J\"\u00100\u001a\b\u0012\u0004\u0012\u00020\u00140\t2\u0012\u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bH\u0016J\u001c\u00101\u001a\u00020\u00052\u0012\u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bH\u0016J\b\u00102\u001a\u00020\u0005H\u0004J\b\u00103\u001a\u00020\u0005H\u0016J\u0010\u00106\u001a\u00020\u00052\u0006\u00105\u001a\u000204H\u0016J\u0012\u00107\u001a\u00020\u00052\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016J\u001a\u0010<\u001a\u0004\u0018\u00010;2\u0006\u00109\u001a\u0002082\u0006\u0010:\u001a\u00020\u000eH\u0016J \u0010>\u001a\u00020\u00052\u0006\u00109\u001a\u0002082\u0006\u0010:\u001a\u00020\u000e2\u0006\u0010=\u001a\u000204H\u0016J0\u0010F\u001a\u00020\u00052\u0006\u0010?\u001a\u00020\n2\u0006\u0010@\u001a\u00020\u00112\u0006\u0010B\u001a\u00020A2\u0006\u0010C\u001a\u00020\u00112\u0006\u0010E\u001a\u00020DH\u0016J\b\u0010G\u001a\u000204H\u0004R\"\u0010O\u001a\u00020H8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\"\u0010W\u001a\u00020P8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\"\u0010\u001a\u001a\u00020\u00198\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\"\u0010d\u001a\u00020'8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b^\u0010_\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR\"\u0010l\u001a\u00020e8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\bf\u0010g\u001a\u0004\bh\u0010i\"\u0004\bj\u0010kR\"\u0010s\u001a\u00020)8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bm\u0010n\u001a\u0004\bo\u0010p\"\u0004\bq\u0010rR$\u0010{\u001a\u0004\u0018\u00010t8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bu\u0010v\u001a\u0004\bw\u0010x\"\u0004\by\u0010zR&\u0010\u0083\u0001\u001a\u00020|8\u0004@\u0004X\u0084.\u00a2\u0006\u0015\n\u0004\b}\u0010~\u001a\u0005\b\u007f\u0010\u0080\u0001\"\u0006\b\u0081\u0001\u0010\u0082\u0001R)\u0010\u008a\u0001\u001a\u00020\u00118\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0018\n\u0006\b\u0084\u0001\u0010\u0085\u0001\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001\"\u0006\b\u0088\u0001\u0010\u0089\u0001R*\u0010\u0092\u0001\u001a\u00030\u008b\u00018\u0006@\u0006X\u0086.\u00a2\u0006\u0018\n\u0006\b\u008c\u0001\u0010\u008d\u0001\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001\"\u0006\b\u0090\u0001\u0010\u0091\u0001R\u001b\u0010\u0095\u0001\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0093\u0001\u0010\u0094\u0001\u00a8\u0006\u009a\u0001"}, d2 = {"Lcom/qzone/reborn/albumx/common/part/CommonAlbumDetailBodyPart;", "Lcom/qzone/reborn/base/k;", "Lcom/tencent/biz/richframework/preload/recyclerview/ILoadMoreProvider$LoadMoreListener;", "Ll9/a;", "Lcom/tencent/richframework/gallery/anim/RFWTransitionHelper$TransAnimCreator;", "", "G9", "initData", "Lcom/tencent/richframework/data/base/UIStateData;", "", "Lcom/qzone/reborn/albumx/common/bean/a;", "listUIStateData", "U9", "qa", "", HippyControllerProps.STRING, "X9", "", "L9", "", "Lcom/qzone/reborn/albumx/common/bean/CommonGridItemData;", "batchList", "picId", "Lkotlin/Pair;", "I9", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "index", "Lcom/qzone/reborn/albumx/common/widget/CommonAlbumDetailPicWidgetView;", "J9", "getLogTag", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "Y9", "Lcom/qzone/reborn/feedx/block/aa;", "H9", "ba", HippyScrollViewEventHelper.EVENT_TYPE_REFRESH, "uiStateData", "sa", "V9", "ra", "pa", "ea", "onLoadMoreStart", "", "hasMore", "onLoadMoreEnd", "onPartDestroy", "Ljava/util/UUID;", "uuid", "id", "Lcom/tencent/richframework/gallery/anim/RFWTransAnimBean;", "generateTransAnimBean", ViewStickEventHelper.IS_SHOW, "updateOriginContainer", "batchBean", "batchPos", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStMedia;", QAdVrReportParams.ParamKey.MEDIA, "mediaPos", "Landroid/widget/ImageView;", "view", "A8", "ca", "Lcom/qzone/reborn/albumx/common/viewmodel/b;", "d", "Lcom/qzone/reborn/albumx/common/viewmodel/b;", "K9", "()Lcom/qzone/reborn/albumx/common/viewmodel/b;", "ga", "(Lcom/qzone/reborn/albumx/common/viewmodel/b;)V", "albumViewModel", "Li9/a;", "e", "Li9/a;", "M9", "()Li9/a;", "ha", "(Li9/a;)V", "batchListAdapter", "f", "Landroidx/recyclerview/widget/RecyclerView;", "S9", "()Landroidx/recyclerview/widget/RecyclerView;", "na", "(Landroidx/recyclerview/widget/RecyclerView;)V", tl.h.F, "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "O9", "()Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", LocaleUtils.L_JAPANESE, "(Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;)V", "concatAdapter", "Lcom/tencent/richframework/widget/refresh/layout/SmartRefreshLayout;", "i", "Lcom/tencent/richframework/widget/refresh/layout/SmartRefreshLayout;", "T9", "()Lcom/tencent/richframework/widget/refresh/layout/SmartRefreshLayout;", "oa", "(Lcom/tencent/richframework/widget/refresh/layout/SmartRefreshLayout;)V", "refreshLayout", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/qzone/reborn/feedx/block/aa;", "Q9", "()Lcom/qzone/reborn/feedx/block/aa;", "ma", "(Lcom/qzone/reborn/feedx/block/aa;)V", "loadMoreAdapter", "Lcom/qzone/reborn/albumx/common/viewmodel/e;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/reborn/albumx/common/viewmodel/e;", "R9", "()Lcom/qzone/reborn/albumx/common/viewmodel/e;", "setOperateViewModel", "(Lcom/qzone/reborn/albumx/common/viewmodel/e;)V", "operateViewModel", "Lcom/qzone/reborn/widget/QZoneBlankStateView;", "D", "Lcom/qzone/reborn/widget/QZoneBlankStateView;", "N9", "()Lcom/qzone/reborn/widget/QZoneBlankStateView;", "ia", "(Lcom/qzone/reborn/widget/QZoneBlankStateView;)V", "blankView", "E", "I", "C5", "()I", "setTransCreatorKey", "(I)V", "transCreatorKey", "Laa/c;", UserInfo.SEX_FEMALE, "Laa/c;", "P9", "()Laa/c;", "la", "(Laa/c;)V", "gridDecorationHelper", "G", "Lcom/qzone/reborn/albumx/common/widget/CommonAlbumDetailPicWidgetView;", "mSelectedPicItemView", "<init>", "()V", "H", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public class CommonAlbumDetailBodyPart extends com.qzone.reborn.base.k implements ILoadMoreProvider$LoadMoreListener, l9.a, RFWTransitionHelper.TransAnimCreator {

    /* renamed from: C, reason: from kotlin metadata */
    private com.qzone.reborn.albumx.common.viewmodel.e operateViewModel;

    /* renamed from: D, reason: from kotlin metadata */
    protected QZoneBlankStateView blankView;

    /* renamed from: E, reason: from kotlin metadata */
    private int transCreatorKey;

    /* renamed from: F, reason: from kotlin metadata */
    public aa.c gridDecorationHelper;

    /* renamed from: G, reason: from kotlin metadata */
    private CommonAlbumDetailPicWidgetView mSelectedPicItemView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public com.qzone.reborn.albumx.common.viewmodel.b albumViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public i9.a batchListAdapter;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    protected RecyclerView recyclerView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    protected RFWConcatAdapter concatAdapter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    protected SmartRefreshLayout refreshLayout;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public aa loadMoreAdapter;

    private final void G9() {
        ha(new i9.a());
        ma(H9());
        Q9().registerLoadMoreListener(this);
        M9().setHasStableIds(true);
        Q9().setHasStableIds(true);
        Q9().p0(new aa.a().e(HardCodeUtil.qqStr(R.string.to_)).f("").d(""));
        ja(Y9());
        P9().p(S9(), O9(), M9(), Q9());
        S9().setAdapter(O9());
    }

    private final Pair<Integer, CommonGridItemData> I9(List<CommonGridItemData> batchList, String picId) {
        String lloc;
        int i3 = 0;
        for (CommonGridItemData commonGridItemData : batchList) {
            int i16 = i3 + 1;
            if (commonGridItemData.getItemType() == CommonGridItemData.ItemType.PIC_SECTION_ITEM) {
                if (k9.a.h(commonGridItemData.f())) {
                    lloc = commonGridItemData.f().getImage().getLloc();
                } else {
                    lloc = commonGridItemData.f().getVideo().getCover().getLloc();
                }
                if (Intrinsics.areEqual(lloc, picId)) {
                    return new Pair<>(Integer.valueOf(i3), commonGridItemData);
                }
            }
            i3 = i16;
        }
        return null;
    }

    private final CommonAlbumDetailPicWidgetView J9(RecyclerView recyclerView, int index) {
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
        try {
            if (!(linearLayoutManager.findFirstVisibleItemPosition() <= index && index <= linearLayoutManager.findLastVisibleItemPosition())) {
                return null;
            }
            final View findViewByPosition = linearLayoutManager.findViewByPosition(index);
            if (findViewByPosition instanceof CommonAlbumDetailPicWidgetView) {
                return (CommonAlbumDetailPicWidgetView) findViewByPosition;
            }
            if (!(findViewByPosition instanceof ViewGroup)) {
                return null;
            }
            until = RangesKt___RangesKt.until(0, ((ViewGroup) findViewByPosition).getChildCount());
            asSequence = CollectionsKt___CollectionsKt.asSequence(until);
            map = SequencesKt___SequencesKt.map(asSequence, new Function1<Integer, View>() { // from class: com.qzone.reborn.albumx.common.part.CommonAlbumDetailBodyPart$findPicWidgetByAbsoluteIndex$1
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
            filter = SequencesKt___SequencesKt.filter(map, new Function1<Object, Boolean>() { // from class: com.qzone.reborn.albumx.common.part.CommonAlbumDetailBodyPart$findPicWidgetByAbsoluteIndex$$inlined$filterIsInstance$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(Object obj) {
                    return Boolean.valueOf(obj instanceof CommonAlbumDetailPicWidgetView);
                }
            });
            Intrinsics.checkNotNull(filter, "null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesKt.filterIsInstance>");
            firstOrNull = SequencesKt___SequencesKt.firstOrNull(filter);
            return (CommonAlbumDetailPicWidgetView) firstOrNull;
        } catch (NullPointerException e16) {
            QLog.e(getTAG(), 1, "LinearLayoutManager#findFirstVisibleItemPosition NPE: " + e16);
            return null;
        }
    }

    private final int L9() {
        List<? extends RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> adapters = O9().getAdapters();
        Intrinsics.checkNotNullExpressionValue(adapters, "concatAdapter.adapters");
        Iterator<T> it = adapters.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            RecyclerView.Adapter adapter = (RecyclerView.Adapter) it.next();
            if (adapter instanceof i9.a) {
                return i3;
            }
            i3 += adapter.getNUM_BACKGOURND_ICON();
        }
        return i3;
    }

    private final void U9(UIStateData<List<com.qzone.reborn.albumx.common.bean.a>> listUIStateData) {
        QLog.i(getTAG(), 1, "handleBatchListRsp()  state = " + listUIStateData.getState());
        int state = listUIStateData.getState();
        if (state == 0) {
            pa(listUIStateData);
        } else if (state == 2 || state == 3) {
            V9(listUIStateData);
        } else if (state == 4) {
            qa(listUIStateData);
        }
        T9().finishRefresh();
        sa(listUIStateData);
        if (Q9() instanceof sa.g) {
            aa Q9 = Q9();
            Intrinsics.checkNotNull(Q9, "null cannot be cast to non-null type com.qzone.reborn.albumx.qzonex.adapter.QZAlbumxListLoadMoreAndPreviewAdapter");
            ((sa.g) Q9).z0(false, true ^ listUIStateData.getIsFinish(), listUIStateData.getIsUpTurning());
            return;
        }
        Q9().setLoadState(false, !listUIStateData.getIsFinish());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W9(CommonAlbumDetailBodyPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.S9().scrollToPosition(0);
    }

    private final void X9(String string) {
        if (TextUtils.isEmpty(string)) {
            if (!NetworkUtil.isNetworkAvailable()) {
                string = K9().R1();
            } else {
                string = K9().Q1();
            }
        }
        N9().setData(com.qzone.reborn.feedx.util.k.D(getContext(), string));
        QLog.d(getTAG(), 1, "[initBlankViewData] emptyMsg = " + string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z9(CommonAlbumDetailBodyPart this$0, UIStateData it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.U9(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void aa(CommonAlbumDetailBodyPart this$0, Boolean bool) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.T9().setEnableRefresh(Intrinsics.areEqual(bool, Boolean.FALSE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void da(CommonAlbumDetailBodyPart this$0, IRefreshLayout it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.onRefresh();
    }

    private final void initData() {
        l9.c cVar = (l9.c) RFWIocAbilityProvider.g().getIocInterface(l9.c.class, getPartRootView(), null);
        com.qzone.reborn.albumx.common.viewmodel.b Ne = cVar != null ? cVar.Ne() : null;
        Intrinsics.checkNotNull(Ne);
        Ne.O1().observe(getHostFragment(), new Observer() { // from class: com.qzone.reborn.albumx.common.part.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CommonAlbumDetailBodyPart.Z9(CommonAlbumDetailBodyPart.this, (UIStateData) obj);
            }
        });
        ga(Ne);
        l9.c cVar2 = (l9.c) RFWIocAbilityProvider.g().getIocInterface(l9.c.class, getPartRootView(), null);
        com.qzone.reborn.albumx.common.viewmodel.e qf5 = cVar2 != null ? cVar2.qf() : null;
        Intrinsics.checkNotNull(qf5);
        qf5.d2().observe(getHostFragment(), new Observer() { // from class: com.qzone.reborn.albumx.common.part.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CommonAlbumDetailBodyPart.aa(CommonAlbumDetailBodyPart.this, (Boolean) obj);
            }
        });
        this.operateViewModel = qf5;
        K9().b2(false);
    }

    private final void qa(UIStateData<List<com.qzone.reborn.albumx.common.bean.a>> listUIStateData) {
        if (listUIStateData.getIsLoadMore()) {
            return;
        }
        S9().setVisibility(4);
        N9().showErrorView();
        ea();
    }

    @Override // l9.a
    public void A8(com.qzone.reborn.albumx.common.bean.a batchBean, int batchPos, CommonStMedia media, int mediaPos, ImageView view) {
        Intrinsics.checkNotNullParameter(batchBean, "batchBean");
        Intrinsics.checkNotNullParameter(media, "media");
        Intrinsics.checkNotNullParameter(view, "view");
        K9().a2(batchBean, batchPos, media, mediaPos, view, this.transCreatorKey);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: C5, reason: from getter */
    public final int getTransCreatorKey() {
        return this.transCreatorKey;
    }

    public aa H9() {
        return new aa();
    }

    public final com.qzone.reborn.albumx.common.viewmodel.b K9() {
        com.qzone.reborn.albumx.common.viewmodel.b bVar = this.albumViewModel;
        if (bVar != null) {
            return bVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("albumViewModel");
        return null;
    }

    public final i9.a M9() {
        i9.a aVar = this.batchListAdapter;
        if (aVar != null) {
            return aVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("batchListAdapter");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final QZoneBlankStateView N9() {
        QZoneBlankStateView qZoneBlankStateView = this.blankView;
        if (qZoneBlankStateView != null) {
            return qZoneBlankStateView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("blankView");
        return null;
    }

    protected final RFWConcatAdapter O9() {
        RFWConcatAdapter rFWConcatAdapter = this.concatAdapter;
        if (rFWConcatAdapter != null) {
            return rFWConcatAdapter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("concatAdapter");
        return null;
    }

    public final aa.c P9() {
        aa.c cVar = this.gridDecorationHelper;
        if (cVar != null) {
            return cVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("gridDecorationHelper");
        return null;
    }

    public final aa Q9() {
        aa aaVar = this.loadMoreAdapter;
        if (aaVar != null) {
            return aaVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("loadMoreAdapter");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: R9, reason: from getter */
    public final com.qzone.reborn.albumx.common.viewmodel.e getOperateViewModel() {
        return this.operateViewModel;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final RecyclerView S9() {
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView != null) {
            return recyclerView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final SmartRefreshLayout T9() {
        SmartRefreshLayout smartRefreshLayout = this.refreshLayout;
        if (smartRefreshLayout != null) {
            return smartRefreshLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
        return null;
    }

    public void V9(UIStateData<List<com.qzone.reborn.albumx.common.bean.a>> uiStateData) {
        Intrinsics.checkNotNullParameter(uiStateData, "uiStateData");
        if (bl.b(uiStateData.getData())) {
            pa(uiStateData);
            return;
        }
        S9().setVisibility(0);
        N9().o0();
        List<CommonGridItemData> ra5 = ra(uiStateData);
        com.qzone.reborn.feedx.scroller.g.f().d(uiStateData.getIsLoadMore() ? M9().getNUM_BACKGOURND_ICON() : 0, new ArrayList(ra5), uiStateData.getIsUpTurning());
        M9().setItems(ra5);
        if (!uiStateData.getIsLoadMore()) {
            RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.qzone.reborn.albumx.common.part.d
                @Override // java.lang.Runnable
                public final void run() {
                    CommonAlbumDetailBodyPart.W9(CommonAlbumDetailBodyPart.this);
                }
            }, 100L);
        }
        P9().u();
    }

    public RFWConcatAdapter Y9() {
        return new RFWConcatAdapter(new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build(), (RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) new RecyclerView.Adapter[]{M9(), Q9()});
    }

    public void ba() {
        la(new aa.c());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean ca() {
        return this.albumViewModel != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void ea() {
        ViewGroup.LayoutParams layoutParams = N9().getLayoutParams();
        if (layoutParams != null) {
            View findViewById = getPartRootView().findViewById(R.id.f18553a);
            Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.ablum_detail_head_view)");
            layoutParams.height = ImmersiveUtils.getScreenHeight() - findViewById.getHeight();
        }
    }

    public final void ga(com.qzone.reborn.albumx.common.viewmodel.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<set-?>");
        this.albumViewModel = bVar;
    }

    @Override // com.tencent.richframework.gallery.anim.RFWTransitionHelper.TransAnimCreator
    public RFWTransAnimBean generateTransAnimBean(UUID uuid, String id5) {
        CommonStImage cover;
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(id5, "id");
        List<CommonGridItemData> items = M9().getItems();
        Intrinsics.checkNotNullExpressionValue(items, "batchListAdapter.items");
        Pair<Integer, CommonGridItemData> I9 = I9(items, id5);
        if (I9 == null) {
            return null;
        }
        int intValue = I9.component1().intValue();
        CommonGridItemData component2 = I9.component2();
        int L9 = intValue + L9();
        QLog.d(getTAG(), 1, "cur index: " + L9 + ", " + component2.getBatchPos() + ", " + component2.getMediaPos());
        CommonAlbumDetailPicWidgetView J9 = J9(S9(), L9);
        if (k9.a.h(component2.f())) {
            cover = component2.f().getImage();
        } else {
            cover = component2.f().getVideo().getCover();
        }
        return RFWLayerLaunchUtil.getTransAnimBean(uuid, J9 != null ? J9.getIvPicImage() : null, mj.a.g(cover), true);
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "CommonAlbumDetailBodyPart";
    }

    public final void ha(i9.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.batchListAdapter = aVar;
    }

    protected final void ia(QZoneBlankStateView qZoneBlankStateView) {
        Intrinsics.checkNotNullParameter(qZoneBlankStateView, "<set-?>");
        this.blankView = qZoneBlankStateView;
    }

    protected final void ja(RFWConcatAdapter rFWConcatAdapter) {
        Intrinsics.checkNotNullParameter(rFWConcatAdapter, "<set-?>");
        this.concatAdapter = rFWConcatAdapter;
    }

    public final void la(aa.c cVar) {
        Intrinsics.checkNotNullParameter(cVar, "<set-?>");
        this.gridDecorationHelper = cVar;
    }

    public final void ma(aa aaVar) {
        Intrinsics.checkNotNullParameter(aaVar, "<set-?>");
        this.loadMoreAdapter = aaVar;
    }

    protected final void na(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "<set-?>");
        this.recyclerView = recyclerView;
    }

    protected final void oa(SmartRefreshLayout smartRefreshLayout) {
        Intrinsics.checkNotNullParameter(smartRefreshLayout, "<set-?>");
        this.refreshLayout = smartRefreshLayout;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        this.transCreatorKey = RFWTransitionHelper.INSTANCE.registerTransitionBeanCreator(this);
        RFWIocAbilityProvider.g().registerIoc(rootView, this, l9.a.class);
        View findViewById = rootView.findViewById(R.id.mqu);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.qzone_blank_view)");
        ia((QZoneBlankStateView) findViewById);
        View findViewById2 = rootView.findViewById(R.id.nf7);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.rv_feed_list)");
        na((RecyclerView) findViewById2);
        S9().setNestedScrollingEnabled(true);
        S9().setOverScrollMode(2);
        View findViewById3 = rootView.findViewById(R.id.f162941ng1);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.smart_refresh_layout)");
        oa((SmartRefreshLayout) findViewById3);
        T9().setOnRefreshListener(new OnRefreshListener() { // from class: com.qzone.reborn.albumx.common.part.a
            @Override // com.tencent.richframework.widget.refresh.layout.listener.OnRefreshListener
            public final void onRefresh(IRefreshLayout iRefreshLayout) {
                CommonAlbumDetailBodyPart.da(CommonAlbumDetailBodyPart.this, iRefreshLayout);
            }
        });
        T9().setEnableOverScrollDrag(true);
        T9().setEnableLoadMoreWhenContentNotFull(true);
        S9().setItemAnimator(null);
        ba();
        P9().q(ef.d.b(16));
        G9();
        initData();
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreEnd(boolean hasMore) {
        QLog.d(getTAG(), 1, "onLoadMoreEnd  hasMore = " + hasMore);
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreStart() {
        QLog.d(getTAG(), 1, "onLoadMoreStart ");
        K9().b2(true);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        K9().c2();
    }

    public void onRefresh() {
        K9().b2(false);
    }

    public void pa(UIStateData<List<com.qzone.reborn.albumx.common.bean.a>> uiStateData) {
        String str;
        Intrinsics.checkNotNullParameter(uiStateData, "uiStateData");
        if (((int) uiStateData.getRetCode()) == 10071) {
            str = HardCodeUtil.qqStr(R.string.v1d);
            Intrinsics.checkNotNullExpressionValue(str, "qqStr(R.string.qzone_intimate_album_is_deleted)");
        } else {
            str = "";
        }
        X9(str);
        S9().setVisibility(4);
        N9().s0();
        ea();
    }

    public List<CommonGridItemData> ra(UIStateData<List<com.qzone.reborn.albumx.common.bean.a>> uiStateData) {
        Intrinsics.checkNotNullParameter(uiStateData, "uiStateData");
        aa.d dVar = aa.d.f25752a;
        List<com.qzone.reborn.albumx.common.bean.a> data = uiStateData.getData();
        Intrinsics.checkNotNullExpressionValue(data, "uiStateData.data");
        return dVar.c(data);
    }

    public void sa(UIStateData<List<com.qzone.reborn.albumx.common.bean.a>> uiStateData) {
        Intrinsics.checkNotNullParameter(uiStateData, "uiStateData");
    }

    @Override // com.tencent.richframework.gallery.anim.RFWTransitionHelper.TransAnimCreator
    public void updateOriginContainer(UUID uuid, String id5, boolean isShow) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(id5, "id");
        if (id5.length() == 0) {
            CommonAlbumDetailPicWidgetView commonAlbumDetailPicWidgetView = this.mSelectedPicItemView;
            if (commonAlbumDetailPicWidgetView != null) {
                commonAlbumDetailPicWidgetView.setLabelAndPlayIconVisibility(isShow);
                return;
            }
            return;
        }
        List<CommonGridItemData> items = M9().getItems();
        Intrinsics.checkNotNullExpressionValue(items, "batchListAdapter.items");
        Pair<Integer, CommonGridItemData> I9 = I9(items, id5);
        if (I9 == null) {
            return;
        }
        int intValue = I9.component1().intValue();
        I9.component2();
        CommonAlbumDetailPicWidgetView J9 = J9(S9(), intValue);
        CommonAlbumDetailPicWidgetView commonAlbumDetailPicWidgetView2 = this.mSelectedPicItemView;
        if (commonAlbumDetailPicWidgetView2 != null) {
            commonAlbumDetailPicWidgetView2.setLabelAndPlayIconVisibility(isShow);
        }
        this.mSelectedPicItemView = J9;
    }
}
