package com.tencent.biz.richframework.localupload.recommend.classifier.filter;

import com.tencent.biz.richframework.localupload.recommend.RecommendContext;
import com.tencent.biz.richframework.localupload.recommend.bean.RFWClassifyID;
import com.tencent.biz.richframework.localupload.recommend.bean.RFWRecommendConfig;
import com.tencent.biz.richframework.localupload.recommend.bean.RFWUploadRecommendInfo;
import com.tencent.biz.richframework.localupload.recommend.utils.RFWRecommendUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u000f\u0012\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u0017\u0010\t\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/biz/richframework/localupload/recommend/classifier/filter/RFWRecommendCountFilter;", "Lcom/tencent/biz/richframework/localupload/recommend/classifier/filter/RFWBaseRecommendFilter;", "Lcom/tencent/biz/richframework/localupload/recommend/bean/RFWUploadRecommendInfo;", "recommendInfo", "", "isRecommendCanShow", "", "getTag", "Lcom/tencent/biz/richframework/localupload/recommend/RecommendContext;", "context", "Lcom/tencent/biz/richframework/localupload/recommend/RecommendContext;", "getContext", "()Lcom/tencent/biz/richframework/localupload/recommend/RecommendContext;", "<init>", "(Lcom/tencent/biz/richframework/localupload/recommend/RecommendContext;)V", "Companion", "local-upload-recommend-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class RFWRecommendCountFilter extends RFWBaseRecommendFilter {

    @NotNull
    private final RecommendContext context;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RFWRecommendCountFilter(@NotNull RecommendContext context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    @Override // com.tencent.biz.richframework.localupload.recommend.classifier.filter.RFWBaseRecommendFilter
    @NotNull
    public String getTag() {
        return "RFWRecommendCountFilter";
    }

    @Override // com.tencent.biz.richframework.localupload.recommend.classifier.filter.RFWBaseRecommendFilter
    public boolean isRecommendCanShow(@NotNull RFWUploadRecommendInfo recommendInfo) {
        Integer intOrNull;
        int i3;
        Intrinsics.checkNotNullParameter(recommendInfo, "recommendInfo");
        RFWRecommendConfig rFWRecommendConfig = RFWClassifyID.INSTANCE.getRECOMMEND_CONFIG().get(recommendInfo.getRecommendClassifyId());
        if (rFWRecommendConfig == null || recommendInfo.getRecommendCount() >= rFWRecommendConfig.getMinCountLimit()) {
            intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(RFWRecommendUtil.INSTANCE.getClassifyConfig(this.context, "classify_media_count_min"));
            if (intOrNull != null) {
                i3 = intOrNull.intValue();
            } else {
                i3 = 5;
            }
            if (recommendInfo.getRecommendCount() < i3) {
                return false;
            }
            return true;
        }
        return false;
    }
}
