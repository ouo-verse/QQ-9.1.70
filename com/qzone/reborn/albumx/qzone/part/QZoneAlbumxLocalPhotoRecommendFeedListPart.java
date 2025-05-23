package com.qzone.reborn.albumx.qzone.part;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.Pair;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.reborn.albumx.qzone.bean.init.QZoneAlbumxMediaListInitBean;
import com.qzone.reborn.albumx.qzone.local.QZoneUploadRecommendDirector;
import com.qzone.reborn.feedx.util.ag;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.localupload.recommend.RFWUploadRecommendDirectorV2;
import com.tencent.biz.richframework.localupload.recommend.bean.RFWMediaInfo;
import com.tencent.biz.richframework.localupload.recommend.bean.RFWUploadRecommendInfo;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.biz.richframework.part.block.base.SafeGridLayoutManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 G2\u00020\u00012\u00020\u0002:\u0002HIB\u0007\u00a2\u0006\u0004\bE\u0010FJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0016\u0010\b\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002J\u0016\u0010\n\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002J\b\u0010\u000b\u001a\u00020\u0003H\u0002J\u0016\u0010\r\u001a\u00020\u00032\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0006H\u0002J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0006H\u0002J(\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0013j\b\u0012\u0004\u0012\u00020\u0014`\u00152\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0005H\u0002J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0012\u0010\u001c\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0016J\"\u0010\"\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u00172\u0006\u0010!\u001a\u00020 2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0016J\"\u0010#\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u00172\u0006\u0010!\u001a\u00020 2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0016J\"\u0010$\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u00172\u0006\u0010!\u001a\u00020 2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0016J\u000e\u0010'\u001a\u00020\u00032\u0006\u0010&\u001a\u00020%R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010.\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010D\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010-\u00a8\u0006J"}, d2 = {"Lcom/qzone/reborn/albumx/qzone/part/QZoneAlbumxLocalPhotoRecommendFeedListPart;", "Lcom/qzone/reborn/base/k;", "Lia/a;", "", "initViewModel", "", "Lcom/tencent/biz/richframework/localupload/recommend/bean/RFWUploadRecommendInfo;", "photoRecommendList", "P9", "videoRecommendList", "R9", "N9", "recommendInfoList", "L9", "data", "V9", "U9", "Lcom/tencent/biz/richframework/localupload/recommend/bean/RFWMediaInfo;", "rfwMediaInfoList", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "Lkotlin/collections/ArrayList;", "O9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "", "getLogTag", "itemView", "", "position", "m9", "N3", "R8", "", "isSelected", "W9", "Lcom/qzone/reborn/albumx/qzone/local/j;", "d", "Lcom/qzone/reborn/albumx/qzone/local/j;", "recommendUpdateFlagLogic", "e", "Z", "isTabSelected", "Landroidx/recyclerview/widget/RecyclerView;", "f", "Landroidx/recyclerview/widget/RecyclerView;", "mRecyclerView", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", tl.h.F, "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "mConcatAdapter", "Lca/a;", "i", "Lca/a;", "mMakeVideoHeaderAdapter", "Lca/b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lca/b;", "mRecommendListAdapter", "Lqa/a;", BdhLogUtil.LogTag.Tag_Conn, "Lqa/a;", "mRecommendListViewModel", "D", "mAddedMakeVideoHeaderView", "<init>", "()V", "E", "a", "b", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneAlbumxLocalPhotoRecommendFeedListPart extends com.qzone.reborn.base.k implements ia.a {

    /* renamed from: C, reason: from kotlin metadata */
    private qa.a mRecommendListViewModel;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean mAddedMakeVideoHeaderView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.qzone.reborn.albumx.qzone.local.j recommendUpdateFlagLogic;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isTabSelected;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private RecyclerView mRecyclerView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private RFWConcatAdapter mConcatAdapter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ca.a mMakeVideoHeaderAdapter;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ca.b mRecommendListAdapter;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\f\u00a2\u0006\u0004\b\u0010\u0010\u0011J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/qzone/reborn/albumx/qzone/part/QZoneAlbumxLocalPhotoRecommendFeedListPart$b;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "", "d", "I", "spacing", "<init>", "(Lcom/qzone/reborn/albumx/qzone/part/QZoneAlbumxLocalPhotoRecommendFeedListPart;I)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public final class b extends RecyclerView.ItemDecoration {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int spacing;

        public b(int i3) {
            this.spacing = i3;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            int i3 = this.spacing;
            outRect.top = i3;
            outRect.bottom = i3;
            outRect.left = i3;
            outRect.right = i3;
        }
    }

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/qzone/reborn/albumx/qzone/part/QZoneAlbumxLocalPhotoRecommendFeedListPart$c", "Lcom/tencent/biz/richframework/localupload/recommend/RFWUploadRecommendDirectorV2$QueryCallBack;", "", "Lcom/tencent/biz/richframework/localupload/recommend/bean/RFWMediaInfo;", "queryResult", "", "queryFinish", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class c implements RFWUploadRecommendDirectorV2.QueryCallBack {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ RFWUploadRecommendInfo f52688b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f52689c;

        c(RFWUploadRecommendInfo rFWUploadRecommendInfo, String str) {
            this.f52688b = rFWUploadRecommendInfo;
            this.f52689c = str;
        }

        @Override // com.tencent.biz.richframework.localupload.recommend.RFWUploadRecommendDirectorV2.QueryCallBack
        public void queryFinish(List<RFWMediaInfo> queryResult) {
            Intrinsics.checkNotNullParameter(queryResult, "queryResult");
            ArrayList O9 = QZoneAlbumxLocalPhotoRecommendFeedListPart.this.O9(queryResult);
            QLog.d(QZoneAlbumxLocalPhotoRecommendFeedListPart.this.getTAG(), 1, "[jumpToTemplatePreviewPage] " + this.f52688b.getClassifyInfo() + ", mediaInfoList.size=" + O9.size() + ", templateId=" + this.f52689c);
            ka.a y16 = ho.i.y();
            Intrinsics.checkNotNullExpressionValue(y16, "qzoneAlbumx()");
            Context context = QZoneAlbumxLocalPhotoRecommendFeedListPart.this.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            String str = this.f52689c;
            RFWMediaInfo firstMediaInfo = this.f52688b.getFirstMediaInfo();
            ka.a.l(y16, context, str, firstMediaInfo != null ? firstMediaInfo.getMPath() : null, O9, this.f52688b.getClassifyInfo().getClassifyId(), 0, 32, null);
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/qzone/reborn/albumx/qzone/part/QZoneAlbumxLocalPhotoRecommendFeedListPart$d", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "", "position", "getSpanSize", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class d extends GridLayoutManager.SpanSizeLookup {
        d() {
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int position) {
            RFWConcatAdapter rFWConcatAdapter = QZoneAlbumxLocalPhotoRecommendFeedListPart.this.mConcatAdapter;
            Object obj = null;
            ca.b bVar = null;
            if (rFWConcatAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mConcatAdapter");
                rFWConcatAdapter = null;
            }
            Pair<RecyclerView.Adapter<? extends RecyclerView.ViewHolder>, Integer> wrappedAdapterAndPosition = rFWConcatAdapter.getWrappedAdapterAndPosition(position);
            Intrinsics.checkNotNullExpressionValue(wrappedAdapterAndPosition, "mConcatAdapter.getWrappe\u2026pterAndPosition(position)");
            RecyclerView.Adapter adapter = (RecyclerView.Adapter) wrappedAdapterAndPosition.first;
            if ((adapter instanceof ca.b ? (ca.b) adapter : null) != null) {
                ca.b bVar2 = QZoneAlbumxLocalPhotoRecommendFeedListPart.this.mRecommendListAdapter;
                if (bVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRecommendListAdapter");
                } else {
                    bVar = bVar2;
                }
                List<RFWUploadRecommendInfo> items = bVar.getItems();
                Intrinsics.checkNotNullExpressionValue(items, "mRecommendListAdapter.items");
                Object obj2 = wrappedAdapterAndPosition.second;
                Intrinsics.checkNotNullExpressionValue(obj2, "wrappedAdapterAndPosition.second");
                obj = CollectionsKt___CollectionsKt.getOrNull(items, ((Number) obj2).intValue());
            }
            RFWUploadRecommendInfo rFWUploadRecommendInfo = (RFWUploadRecommendInfo) obj;
            return (rFWUploadRecommendInfo == null || ga.b.e(rFWUploadRecommendInfo) != 1) ? 2 : 1;
        }
    }

    private final void L9(final List<RFWUploadRecommendInfo> recommendInfoList) {
        if (recommendInfoList.isEmpty()) {
            QLog.d(getTAG(), 1, "[addMakeVideoHeaderView] video data is empty");
            return;
        }
        RecyclerView recyclerView = null;
        if (!this.mAddedMakeVideoHeaderView) {
            this.mAddedMakeVideoHeaderView = true;
            RFWConcatAdapter rFWConcatAdapter = this.mConcatAdapter;
            if (rFWConcatAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mConcatAdapter");
                rFWConcatAdapter = null;
            }
            ca.a aVar = this.mMakeVideoHeaderAdapter;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMakeVideoHeaderAdapter");
                aVar = null;
            }
            rFWConcatAdapter.addAdapter(0, aVar);
        }
        ag agVar = ag.f55738a;
        Runnable runnable = new Runnable() { // from class: com.qzone.reborn.albumx.qzone.part.d
            @Override // java.lang.Runnable
            public final void run() {
                QZoneAlbumxLocalPhotoRecommendFeedListPart.M9(QZoneAlbumxLocalPhotoRecommendFeedListPart.this, recommendInfoList);
            }
        };
        RecyclerView recyclerView2 = this.mRecyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        } else {
            recyclerView = recyclerView2;
        }
        agVar.b(5, runnable, recyclerView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(QZoneAlbumxLocalPhotoRecommendFeedListPart this$0, List recommendInfoList) {
        List listOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(recommendInfoList, "$recommendInfoList");
        ca.a aVar = this$0.mMakeVideoHeaderAdapter;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMakeVideoHeaderAdapter");
            aVar = null;
        }
        listOf = CollectionsKt__CollectionsJVMKt.listOf(recommendInfoList);
        aVar.setItems(listOf);
    }

    private final void N9() {
        ca.a aVar = new ca.a();
        this.mMakeVideoHeaderAdapter = aVar;
        aVar.setHasStableIds(true);
        ca.b bVar = new ca.b();
        this.mRecommendListAdapter = bVar;
        bVar.setHasStableIds(true);
        RFWConcatAdapter.Config build = new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build();
        RecyclerView.Adapter[] adapterArr = new RecyclerView.Adapter[1];
        ca.b bVar2 = this.mRecommendListAdapter;
        if (bVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecommendListAdapter");
            bVar2 = null;
        }
        adapterArr[0] = bVar2;
        this.mConcatAdapter = new RFWConcatAdapter(build, (RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) adapterArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ArrayList<LocalMediaInfo> O9(List<RFWMediaInfo> rfwMediaInfoList) {
        ArrayList<LocalMediaInfo> arrayList = new ArrayList<>();
        if (rfwMediaInfoList != null) {
            for (RFWMediaInfo rFWMediaInfo : rfwMediaInfoList) {
                LocalMediaInfo localMediaInfo = new LocalMediaInfo();
                localMediaInfo.path = rFWMediaInfo.getMPath();
                arrayList.add(localMediaInfo);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P9(final List<RFWUploadRecommendInfo> photoRecommendList) {
        QLog.d(getTAG(), 1, "[handlePhotoRecommendChanged] photoRecommendList.size = " + photoRecommendList.size());
        ag agVar = ag.f55738a;
        Runnable runnable = new Runnable() { // from class: com.qzone.reborn.albumx.qzone.part.c
            @Override // java.lang.Runnable
            public final void run() {
                QZoneAlbumxLocalPhotoRecommendFeedListPart.Q9(QZoneAlbumxLocalPhotoRecommendFeedListPart.this, photoRecommendList);
            }
        };
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView = null;
        }
        agVar.b(5, runnable, recyclerView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q9(QZoneAlbumxLocalPhotoRecommendFeedListPart this$0, List photoRecommendList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(photoRecommendList, "$photoRecommendList");
        ca.b bVar = this$0.mRecommendListAdapter;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecommendListAdapter");
            bVar = null;
        }
        bVar.setItems(photoRecommendList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R9(List<RFWUploadRecommendInfo> videoRecommendList) {
        QLog.d(getTAG(), 1, "[handleVideoRecommendChanged] videoRecommendList.size = " + videoRecommendList.size());
        L9(videoRecommendList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void U9(RFWUploadRecommendInfo data) {
        QZoneAlbumxMediaListInitBean qZoneAlbumxMediaListInitBean = new QZoneAlbumxMediaListInitBean();
        qZoneAlbumxMediaListInitBean.setClassifyId(data.getClassifyInfo().getClassifyId());
        qZoneAlbumxMediaListInitBean.setSubClassifyId(data.getClassifyInfo().getSubClassifyId());
        qZoneAlbumxMediaListInitBean.setSelectArg(data.getClassifyInfo().getSelectArg());
        qa.a aVar = this.mRecommendListViewModel;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecommendListViewModel");
            aVar = null;
        }
        qZoneAlbumxMediaListInitBean.setTemplateId(aVar.R1(data.getClassifyInfo()));
        qZoneAlbumxMediaListInitBean.setMediaCount(data.getRecommendCount());
        qZoneAlbumxMediaListInitBean.setMediaDisplayName(data.getDisplayName());
        QLog.d(getTAG(), 1, "[jumpToMediaListPage] " + qZoneAlbumxMediaListInitBean);
        Context context = getContext();
        if (context != null) {
            ho.i.y().d(context, qZoneAlbumxMediaListInitBean);
        }
    }

    private final void V9(RFWUploadRecommendInfo data) {
        if (com.qzone.reborn.feedx.util.l.b(getTAG() + "jumpToTemplatePreviewPage", 500L)) {
            QLog.e(getTAG(), 1, "[jumpToTemplatePreviewPage] fast double click");
            return;
        }
        qa.a aVar = this.mRecommendListViewModel;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecommendListViewModel");
            aVar = null;
        }
        QZoneUploadRecommendDirector.INSTANCE.a().queryMediaListByClassifyInfo(data.getClassifyInfo(), new c(data, aVar.R1(data.getClassifyInfo())));
    }

    private final void initViewModel() {
        ViewModel viewModel = getViewModel(qa.a.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZoneAlbumx\u2026istViewModel::class.java)");
        qa.a aVar = (qa.a) viewModel;
        this.mRecommendListViewModel = aVar;
        qa.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecommendListViewModel");
            aVar = null;
        }
        MutableLiveData<List<RFWUploadRecommendInfo>> P1 = aVar.P1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<List<? extends RFWUploadRecommendInfo>, Unit> function1 = new Function1<List<? extends RFWUploadRecommendInfo>, Unit>() { // from class: com.qzone.reborn.albumx.qzone.part.QZoneAlbumxLocalPhotoRecommendFeedListPart$initViewModel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends RFWUploadRecommendInfo> list) {
                invoke2((List<RFWUploadRecommendInfo>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<RFWUploadRecommendInfo> it) {
                QZoneAlbumxLocalPhotoRecommendFeedListPart qZoneAlbumxLocalPhotoRecommendFeedListPart = QZoneAlbumxLocalPhotoRecommendFeedListPart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                qZoneAlbumxLocalPhotoRecommendFeedListPart.P9(it);
            }
        };
        P1.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.albumx.qzone.part.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZoneAlbumxLocalPhotoRecommendFeedListPart.S9(Function1.this, obj);
            }
        });
        qa.a aVar3 = this.mRecommendListViewModel;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecommendListViewModel");
        } else {
            aVar2 = aVar3;
        }
        MutableLiveData<List<RFWUploadRecommendInfo>> S1 = aVar2.S1();
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<List<? extends RFWUploadRecommendInfo>, Unit> function12 = new Function1<List<? extends RFWUploadRecommendInfo>, Unit>() { // from class: com.qzone.reborn.albumx.qzone.part.QZoneAlbumxLocalPhotoRecommendFeedListPart$initViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends RFWUploadRecommendInfo> list) {
                invoke2((List<RFWUploadRecommendInfo>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<RFWUploadRecommendInfo> it) {
                QZoneAlbumxLocalPhotoRecommendFeedListPart qZoneAlbumxLocalPhotoRecommendFeedListPart = QZoneAlbumxLocalPhotoRecommendFeedListPart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                qZoneAlbumxLocalPhotoRecommendFeedListPart.R9(it);
            }
        };
        S1.observe(lifecycleOwner2, new Observer() { // from class: com.qzone.reborn.albumx.qzone.part.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZoneAlbumxLocalPhotoRecommendFeedListPart.T9(Function1.this, obj);
            }
        });
    }

    @Override // ia.a
    public void N3(View itemView, int position, RFWUploadRecommendInfo data) {
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        if (data == null) {
            QLog.d(getTAG(), 1, "[onMultiPhotoItemClick] data is null");
        }
        if (data != null) {
            U9(data);
        }
    }

    @Override // ia.a
    public void R8(View itemView, int position, RFWUploadRecommendInfo data) {
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        if (data == null) {
            QLog.d(getTAG(), 1, "[onVideoItemClick] data is null");
        }
        if (data != null) {
            V9(data);
        }
    }

    public final void W9(boolean isSelected) {
        this.isTabSelected = isSelected;
        if (!isSelected) {
            com.qzone.reborn.albumx.qzone.local.j jVar = this.recommendUpdateFlagLogic;
            ca.b bVar = null;
            if (jVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recommendUpdateFlagLogic");
                jVar = null;
            }
            ca.b bVar2 = this.mRecommendListAdapter;
            if (bVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRecommendListAdapter");
            } else {
                bVar = bVar2;
            }
            List<RFWUploadRecommendInfo> items = bVar.getItems();
            Intrinsics.checkNotNullExpressionValue(items, "mRecommendListAdapter.items");
            jVar.c(items);
            return;
        }
        if (QZoneUploadRecommendDirector.INSTANCE.a().deviceHaveEnoughSpace()) {
            return;
        }
        QLog.d(getTAG(), 1, "show no space toast");
        com.qzone.reborn.util.o.f59556a.b(BaseApplication.getContext().getString(R.string.jfs));
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneAlbumxLocalPhotoRecommendFeedListPart";
    }

    @Override // ia.a
    public void m9(View itemView, int position, RFWUploadRecommendInfo data) {
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        if (data == null) {
            QLog.d(getTAG(), 1, "[onSinglePhotoItemClick] data is null");
        }
        if (data != null) {
            U9(data);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        RFWIocAbilityProvider.g().registerIoc(rootView, this, ia.a.class);
        this.recommendUpdateFlagLogic = new com.qzone.reborn.albumx.qzone.local.j();
        RFWIocAbilityProvider g16 = RFWIocAbilityProvider.g();
        com.qzone.reborn.albumx.qzone.local.j jVar = this.recommendUpdateFlagLogic;
        RFWConcatAdapter rFWConcatAdapter = null;
        if (jVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recommendUpdateFlagLogic");
            jVar = null;
        }
        g16.registerIoc(rootView, jVar, ia.d.class);
        View findViewById = rootView.findViewById(R.id.nf7);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.rv_feed_list)");
        this.mRecyclerView = (RecyclerView) findViewById;
        int dimension = (int) getContext().getResources().getDimension(R.dimen.f9669);
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView = null;
        }
        RecyclerView recyclerView2 = this.mRecyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView2 = null;
        }
        int paddingLeft = recyclerView2.getPaddingLeft();
        RecyclerView recyclerView3 = this.mRecyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView3 = null;
        }
        int paddingTop = recyclerView3.getPaddingTop();
        RecyclerView recyclerView4 = this.mRecyclerView;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView4 = null;
        }
        recyclerView.setPadding(paddingLeft, paddingTop, recyclerView4.getPaddingRight(), dimension);
        com.tencent.mobileqq.qui.b bVar = com.tencent.mobileqq.qui.b.f276860a;
        RecyclerView recyclerView5 = this.mRecyclerView;
        if (recyclerView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView5 = null;
        }
        bVar.f(recyclerView5, dimension);
        N9();
        RecyclerView recyclerView6 = this.mRecyclerView;
        if (recyclerView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView6 = null;
        }
        recyclerView6.setNestedScrollingEnabled(true);
        SafeGridLayoutManager safeGridLayoutManager = new SafeGridLayoutManager(getContext(), 2);
        safeGridLayoutManager.setSpanSizeLookup(new d());
        RecyclerView recyclerView7 = this.mRecyclerView;
        if (recyclerView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView7 = null;
        }
        recyclerView7.setLayoutManager(safeGridLayoutManager);
        b bVar2 = new b(DisplayUtil.dip2px(getContext(), 8.0f));
        RecyclerView recyclerView8 = this.mRecyclerView;
        if (recyclerView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView8 = null;
        }
        recyclerView8.addItemDecoration(bVar2);
        RecyclerView recyclerView9 = this.mRecyclerView;
        if (recyclerView9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView9 = null;
        }
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
        defaultItemAnimator.setSupportsChangeAnimations(false);
        recyclerView9.setItemAnimator(defaultItemAnimator);
        RecyclerView recyclerView10 = this.mRecyclerView;
        if (recyclerView10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView10 = null;
        }
        RFWConcatAdapter rFWConcatAdapter2 = this.mConcatAdapter;
        if (rFWConcatAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mConcatAdapter");
        } else {
            rFWConcatAdapter = rFWConcatAdapter2;
        }
        recyclerView10.setAdapter(rFWConcatAdapter);
        initViewModel();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        qa.a aVar = this.mRecommendListViewModel;
        ca.b bVar = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecommendListViewModel");
            aVar = null;
        }
        aVar.a2();
        if (this.isTabSelected) {
            com.qzone.reborn.albumx.qzone.local.j jVar = this.recommendUpdateFlagLogic;
            if (jVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recommendUpdateFlagLogic");
                jVar = null;
            }
            ca.b bVar2 = this.mRecommendListAdapter;
            if (bVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRecommendListAdapter");
            } else {
                bVar = bVar2;
            }
            List<RFWUploadRecommendInfo> items = bVar.getItems();
            Intrinsics.checkNotNullExpressionValue(items, "mRecommendListAdapter.items");
            jVar.c(items);
        }
    }
}
