package com.tencent.biz.richframework.localupload.recommend.classifier.video;

import com.tencent.biz.richframework.localupload.recommend.RFWUploadRecommendDbManager;
import com.tencent.biz.richframework.localupload.recommend.RecommendContext;
import com.tencent.biz.richframework.localupload.recommend.utils.RFWRecommendUtil;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\u001e\u0010\t\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\f\u0012\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000b0\nH\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/biz/richframework/localupload/recommend/classifier/video/RFWTravelVideoClassifier;", "Lcom/tencent/biz/richframework/localupload/recommend/classifier/video/RFWBaseTravelVideoClassifier;", "context", "Lcom/tencent/biz/richframework/localupload/recommend/RecommendContext;", "dbManager", "Lcom/tencent/biz/richframework/localupload/recommend/RFWUploadRecommendDbManager;", "(Lcom/tencent/biz/richframework/localupload/recommend/RecommendContext;Lcom/tencent/biz/richframework/localupload/recommend/RFWUploadRecommendDbManager;)V", "getClassifyId", "", "getQuerySelectInfo", "Lkotlin/Pair;", "", "Companion", "local-upload-recommend-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class RFWTravelVideoClassifier extends RFWBaseTravelVideoClassifier {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RFWTravelVideoClassifier(@NotNull RecommendContext context, @NotNull RFWUploadRecommendDbManager dbManager) {
        super(context, dbManager);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dbManager, "dbManager");
    }

    @Override // com.tencent.biz.richframework.localupload.recommend.classifier.RFWBaseClassifier
    @NotNull
    public String getClassifyId() {
        return "5_2";
    }

    @Override // com.tencent.biz.richframework.localupload.recommend.classifier.RFWBaseClassifier
    @NotNull
    public Pair<String, String[]> getQuerySelectInfo() {
        Object[] plus;
        String residentCityConfig = RFWRecommendUtil.INSTANCE.getResidentCityConfig(getMContext());
        long currentTimeMillis = System.currentTimeMillis();
        Pair<String, String[]> travelTagQueryInfo = getTravelTagQueryInfo();
        String str = "mCity!=? and mCity!=? and mCity!=? and mTakePicTime>? and mTakePicTime<? and (mFaceSize > 0 or " + ((Object) travelTagQueryInfo.getFirst()) + ")";
        plus = ArraysKt___ArraysJvmKt.plus((Object[]) new String[]{residentCityConfig, "none", "", String.valueOf(currentTimeMillis - 2592000000L), String.valueOf(currentTimeMillis)}, (Object[]) travelTagQueryInfo.getSecond());
        return new Pair<>(str, (String[]) plus);
    }
}
