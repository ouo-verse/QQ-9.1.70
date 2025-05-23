package com.qzone.reborn.albumx.qzone.part;

import androidx.recyclerview.widget.RecyclerView;
import com.qzone.reborn.feedx.util.ag;
import com.tencent.biz.richframework.localupload.recommend.bean.RFWUploadRecommendInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "it", "", "Lcom/tencent/biz/richframework/localupload/recommend/bean/RFWUploadRecommendInfo;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QZoneAlbumxLocalPhotoRecommendStandaloneFeedListPart$initViewModel$1 extends Lambda implements Function1<List<? extends RFWUploadRecommendInfo>, Unit> {
    final /* synthetic */ QZoneAlbumxLocalPhotoRecommendStandaloneFeedListPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneAlbumxLocalPhotoRecommendStandaloneFeedListPart$initViewModel$1(QZoneAlbumxLocalPhotoRecommendStandaloneFeedListPart qZoneAlbumxLocalPhotoRecommendStandaloneFeedListPart) {
        super(1);
        this.this$0 = qZoneAlbumxLocalPhotoRecommendStandaloneFeedListPart;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(QZoneAlbumxLocalPhotoRecommendStandaloneFeedListPart this$0, List videoList) {
        ca.e eVar;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(videoList, "$videoList");
        eVar = this$0.mVideoListAdapter;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVideoListAdapter");
            eVar = null;
        }
        eVar.j0(videoList);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends RFWUploadRecommendInfo> list) {
        invoke2((List<RFWUploadRecommendInfo>) list);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<RFWUploadRecommendInfo> it) {
        int J9;
        final List take;
        RecyclerView recyclerView;
        if (it.isEmpty()) {
            QLog.d(this.this$0.getTAG(), 1, "[addMakeVideoHeaderView] video data is empty");
            return;
        }
        Intrinsics.checkNotNullExpressionValue(it, "it");
        J9 = this.this$0.J9();
        take = CollectionsKt___CollectionsKt.take(it, J9);
        ag agVar = ag.f55738a;
        final QZoneAlbumxLocalPhotoRecommendStandaloneFeedListPart qZoneAlbumxLocalPhotoRecommendStandaloneFeedListPart = this.this$0;
        Runnable runnable = new Runnable() { // from class: com.qzone.reborn.albumx.qzone.part.k
            @Override // java.lang.Runnable
            public final void run() {
                QZoneAlbumxLocalPhotoRecommendStandaloneFeedListPart$initViewModel$1.b(QZoneAlbumxLocalPhotoRecommendStandaloneFeedListPart.this, take);
            }
        };
        recyclerView = this.this$0.mRecyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView = null;
        }
        agVar.b(5, runnable, recyclerView);
    }
}
