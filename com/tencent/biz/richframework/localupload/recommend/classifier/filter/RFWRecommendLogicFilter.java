package com.tencent.biz.richframework.localupload.recommend.classifier.filter;

import com.tencent.biz.richframework.localupload.recommend.RecommendContext;
import com.tencent.biz.richframework.localupload.recommend.bean.RFWUploadRecommendInfo;
import com.tencent.biz.richframework.localupload.recommend.classifier.video.RFWFootprintVideoClassifier;
import com.tencent.biz.richframework.localupload.recommend.classifier.video.RFWTravelVideoClassifier;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/biz/richframework/localupload/recommend/classifier/filter/RFWRecommendLogicFilter;", "Lcom/tencent/biz/richframework/localupload/recommend/classifier/filter/RFWBaseRecommendFilter;", "context", "Lcom/tencent/biz/richframework/localupload/recommend/RecommendContext;", "(Lcom/tencent/biz/richframework/localupload/recommend/RecommendContext;)V", "getTag", "", "isRecommendCanShow", "", "recommendInfo", "Lcom/tencent/biz/richframework/localupload/recommend/bean/RFWUploadRecommendInfo;", "Companion", "local-upload-recommend-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class RFWRecommendLogicFilter extends RFWBaseRecommendFilter {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RFWRecommendLogicFilter(@NotNull RecommendContext context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.tencent.biz.richframework.localupload.recommend.classifier.filter.RFWBaseRecommendFilter
    @NotNull
    public String getTag() {
        return "RFWRecommendLogicFilter";
    }

    @Override // com.tencent.biz.richframework.localupload.recommend.classifier.filter.RFWBaseRecommendFilter
    public boolean isRecommendCanShow(@NotNull RFWUploadRecommendInfo recommendInfo) {
        Intrinsics.checkNotNullParameter(recommendInfo, "recommendInfo");
        if (recommendInfo.getClassifier() instanceof RFWFootprintVideoClassifier) {
            if (recommendInfo.getMediaStatistics().getPoiMap().size() < 3) {
                return false;
            }
        } else if ((recommendInfo.getClassifier() instanceof RFWTravelVideoClassifier) && recommendInfo.getMediaStatistics().getPoiMap().size() < 1) {
            return false;
        }
        return true;
    }
}
