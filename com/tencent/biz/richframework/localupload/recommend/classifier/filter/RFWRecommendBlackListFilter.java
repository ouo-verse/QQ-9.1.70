package com.tencent.biz.richframework.localupload.recommend.classifier.filter;

import com.tencent.biz.richframework.localupload.recommend.RecommendContext;
import com.tencent.biz.richframework.localupload.recommend.bean.RFWUploadRecommendInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/biz/richframework/localupload/recommend/classifier/filter/RFWRecommendBlackListFilter;", "Lcom/tencent/biz/richframework/localupload/recommend/classifier/filter/RFWBaseRecommendFilter;", "context", "Lcom/tencent/biz/richframework/localupload/recommend/RecommendContext;", "(Lcom/tencent/biz/richframework/localupload/recommend/RecommendContext;)V", "getTag", "", "isRecommendCanShow", "", "recommendInfo", "Lcom/tencent/biz/richframework/localupload/recommend/bean/RFWUploadRecommendInfo;", "Companion", "local-upload-recommend-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class RFWRecommendBlackListFilter extends RFWBaseRecommendFilter {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RFWRecommendBlackListFilter(@NotNull RecommendContext context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.tencent.biz.richframework.localupload.recommend.classifier.filter.RFWBaseRecommendFilter
    @NotNull
    public String getTag() {
        return "RFWRecommendBlackListFilter";
    }

    @Override // com.tencent.biz.richframework.localupload.recommend.classifier.filter.RFWBaseRecommendFilter
    public boolean isRecommendCanShow(@NotNull RFWUploadRecommendInfo recommendInfo) {
        Intrinsics.checkNotNullParameter(recommendInfo, "recommendInfo");
        if (!recommendInfo.getClassifier().isClassifierEnabled()) {
            return false;
        }
        return true;
    }
}
