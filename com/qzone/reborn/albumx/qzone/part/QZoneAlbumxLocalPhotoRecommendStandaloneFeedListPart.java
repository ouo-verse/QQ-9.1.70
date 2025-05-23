package com.qzone.reborn.albumx.qzone.part;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.reborn.albumx.qzone.local.QZoneUploadRecommendDirector;
import com.qzone.util.ar;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.localupload.recommend.RFWUploadRecommendDirectorV2;
import com.tencent.biz.richframework.localupload.recommend.bean.RFWMediaInfo;
import com.tencent.biz.richframework.localupload.recommend.bean.RFWUploadRecommendInfo;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 '2\u00020\u0001:\u0002()B\u0007\u00a2\u0006\u0004\b%\u0010&J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J(\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0012\u0010\u0016\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#\u00a8\u0006*"}, d2 = {"Lcom/qzone/reborn/albumx/qzone/part/QZoneAlbumxLocalPhotoRecommendStandaloneFeedListPart;", "Lcom/qzone/reborn/base/k;", "", "initViewModel", "Lcom/tencent/biz/richframework/localupload/recommend/bean/RFWUploadRecommendInfo;", "data", "M9", "L9", "", "Lcom/tencent/biz/richframework/localupload/recommend/bean/RFWMediaInfo;", "rfwMediaInfoList", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "Lkotlin/collections/ArrayList;", "I9", "", "J9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "", "getLogTag", "Landroidx/recyclerview/widget/RecyclerView;", "d", "Landroidx/recyclerview/widget/RecyclerView;", "mRecyclerView", "Lca/e;", "e", "Lca/e;", "mVideoListAdapter", "Lqa/a;", "f", "Lqa/a;", "mRecommendListViewModel", "<init>", "()V", tl.h.F, "a", "b", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneAlbumxLocalPhotoRecommendStandaloneFeedListPart extends com.qzone.reborn.base.k {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private RecyclerView mRecyclerView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ca.e mVideoListAdapter;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private qa.a mRecommendListViewModel;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\f\u00a2\u0006\u0004\b\u0010\u0010\u0011J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/qzone/reborn/albumx/qzone/part/QZoneAlbumxLocalPhotoRecommendStandaloneFeedListPart$b;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "", "d", "I", "spacing", "<init>", "(Lcom/qzone/reborn/albumx/qzone/part/QZoneAlbumxLocalPhotoRecommendStandaloneFeedListPart;I)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
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
        }
    }

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/qzone/reborn/albumx/qzone/part/QZoneAlbumxLocalPhotoRecommendStandaloneFeedListPart$c", "Lcom/tencent/biz/richframework/localupload/recommend/RFWUploadRecommendDirectorV2$QueryCallBack;", "", "Lcom/tencent/biz/richframework/localupload/recommend/bean/RFWMediaInfo;", "queryResult", "", "queryFinish", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class c implements RFWUploadRecommendDirectorV2.QueryCallBack {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ RFWUploadRecommendInfo f52708b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f52709c;

        c(RFWUploadRecommendInfo rFWUploadRecommendInfo, String str) {
            this.f52708b = rFWUploadRecommendInfo;
            this.f52709c = str;
        }

        @Override // com.tencent.biz.richframework.localupload.recommend.RFWUploadRecommendDirectorV2.QueryCallBack
        public void queryFinish(List<RFWMediaInfo> queryResult) {
            Intrinsics.checkNotNullParameter(queryResult, "queryResult");
            ArrayList I9 = QZoneAlbumxLocalPhotoRecommendStandaloneFeedListPart.this.I9(queryResult);
            QLog.d(QZoneAlbumxLocalPhotoRecommendStandaloneFeedListPart.this.getLogTag(), 1, "[jumpToTemplatePreviewPage] " + this.f52708b.getClassifyInfo() + ", mediaInfoList.size=" + I9.size() + ", templateId=" + this.f52709c);
            ka.a y16 = ho.i.y();
            Intrinsics.checkNotNullExpressionValue(y16, "qzoneAlbumx()");
            Context context = QZoneAlbumxLocalPhotoRecommendStandaloneFeedListPart.this.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            String str = this.f52709c;
            RFWMediaInfo firstMediaInfo = this.f52708b.getFirstMediaInfo();
            ka.a.l(y16, context, str, firstMediaInfo != null ? firstMediaInfo.getMPath() : null, I9, this.f52708b.getClassifyInfo().getClassifyId(), 0, 32, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ArrayList<LocalMediaInfo> I9(List<RFWMediaInfo> rfwMediaInfoList) {
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
    /* JADX WARN: Code restructure failed: missing block: B:3:0x0011, code lost:
    
        r0 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int J9() {
        Integer intOrNull;
        String str = com.qzone.reborn.albumx.qzone.local.l.f52668a.b().get("standalone_video_feed_max_count");
        if (str == null || intOrNull == null) {
            return 10;
        }
        return intOrNull.intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void L9(RFWUploadRecommendInfo data) {
        if (com.qzone.reborn.feedx.util.l.b(getLogTag() + "jumpToTemplatePreviewPage", 500L)) {
            QLog.e(getLogTag(), 1, "[jumpToTemplatePreviewPage] fast double click");
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
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecommendListViewModel");
            aVar = null;
        }
        MutableLiveData<List<RFWUploadRecommendInfo>> S1 = aVar.S1();
        LifecycleOwner hostLifecycleOwner = getPartHost().getHostLifecycleOwner();
        final QZoneAlbumxLocalPhotoRecommendStandaloneFeedListPart$initViewModel$1 qZoneAlbumxLocalPhotoRecommendStandaloneFeedListPart$initViewModel$1 = new QZoneAlbumxLocalPhotoRecommendStandaloneFeedListPart$initViewModel$1(this);
        S1.observe(hostLifecycleOwner, new Observer() { // from class: com.qzone.reborn.albumx.qzone.part.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZoneAlbumxLocalPhotoRecommendStandaloneFeedListPart.K9(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    public String getLogTag() {
        return "QZoneAlbumxLocalPhotoRecommendStandaloneFeedListPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.nfc);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026.rv_standalone_feed_list)");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.mRecyclerView = recyclerView;
        ca.e eVar = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView = null;
        }
        recyclerView.setLayoutManager(new SafeLinearLayoutManager(getContext(), 1, false));
        RecyclerView recyclerView2 = this.mRecyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView2 = null;
        }
        recyclerView2.addItemDecoration(new b(ar.d(14.0f)));
        RecyclerView recyclerView3 = this.mRecyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView3 = null;
        }
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
        defaultItemAnimator.setSupportsChangeAnimations(false);
        recyclerView3.setItemAnimator(defaultItemAnimator);
        this.mVideoListAdapter = new ca.e(new Function1<RFWUploadRecommendInfo, Unit>() { // from class: com.qzone.reborn.albumx.qzone.part.QZoneAlbumxLocalPhotoRecommendStandaloneFeedListPart$onInitView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RFWUploadRecommendInfo rFWUploadRecommendInfo) {
                invoke2(rFWUploadRecommendInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(RFWUploadRecommendInfo rFWUploadRecommendInfo) {
                QZoneAlbumxLocalPhotoRecommendStandaloneFeedListPart.this.M9(rFWUploadRecommendInfo);
            }
        });
        RecyclerView recyclerView4 = this.mRecyclerView;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView4 = null;
        }
        ca.e eVar2 = this.mVideoListAdapter;
        if (eVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVideoListAdapter");
        } else {
            eVar = eVar2;
        }
        recyclerView4.setAdapter(eVar);
        initViewModel();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        qa.a aVar = this.mRecommendListViewModel;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecommendListViewModel");
            aVar = null;
        }
        aVar.a2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M9(RFWUploadRecommendInfo data) {
        if (data != null) {
            L9(data);
        }
    }
}
