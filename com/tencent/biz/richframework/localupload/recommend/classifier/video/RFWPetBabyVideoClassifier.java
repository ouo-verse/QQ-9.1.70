package com.tencent.biz.richframework.localupload.recommend.classifier.video;

import com.tencent.biz.richframework.localupload.recommend.RFWUploadRecommendDbManager;
import com.tencent.biz.richframework.localupload.recommend.RecommendContext;
import com.tencent.biz.richframework.localupload.recommend.bean.RFWMediaInfo;
import com.tencent.biz.richframework.localupload.recommend.classifier.tag.RFWResearchClassifyUtils;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\u001e\u0010\t\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\f\u0012\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000b0\nH\u0016J\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/biz/richframework/localupload/recommend/classifier/video/RFWPetBabyVideoClassifier;", "Lcom/tencent/biz/richframework/localupload/recommend/classifier/video/RFWBaseVideoClassifier;", "context", "Lcom/tencent/biz/richframework/localupload/recommend/RecommendContext;", "dbManager", "Lcom/tencent/biz/richframework/localupload/recommend/RFWUploadRecommendDbManager;", "(Lcom/tencent/biz/richframework/localupload/recommend/RecommendContext;Lcom/tencent/biz/richframework/localupload/recommend/RFWUploadRecommendDbManager;)V", "getClassifyId", "", "getQuerySelectInfo", "Lkotlin/Pair;", "", "handpick", "", "Lcom/tencent/biz/richframework/localupload/recommend/bean/RFWMediaInfo;", "rfwMediaInfoList", "Companion", "local-upload-recommend-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class RFWPetBabyVideoClassifier extends RFWBaseVideoClassifier {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RFWPetBabyVideoClassifier(@NotNull RecommendContext context, @NotNull RFWUploadRecommendDbManager dbManager) {
        super(context, dbManager);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dbManager, "dbManager");
    }

    @Override // com.tencent.biz.richframework.localupload.recommend.classifier.RFWBaseClassifier
    @NotNull
    public String getClassifyId() {
        return "5_5";
    }

    @Override // com.tencent.biz.richframework.localupload.recommend.classifier.RFWBaseClassifier
    @NotNull
    public Pair<String, String[]> getQuerySelectInfo() {
        RFWResearchClassifyUtils rFWResearchClassifyUtils = RFWResearchClassifyUtils.INSTANCE;
        return RFWResearchClassifyUtils.getQueryInfoByTags$default(rFWResearchClassifyUtils, new String[]{"\u52a8\u7269"}, rFWResearchClassifyUtils.getPET_SUB_TAG(), 0.0f, 4, null);
    }

    @Override // com.tencent.biz.richframework.localupload.recommend.classifier.RFWBaseClassifier
    @NotNull
    public List<RFWMediaInfo> handpick(@NotNull List<RFWMediaInfo> rfwMediaInfoList) {
        List sortedWith;
        List<RFWMediaInfo> mutableList;
        Intrinsics.checkNotNullParameter(rfwMediaInfoList, "rfwMediaInfoList");
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(rfwMediaInfoList, new Comparator() { // from class: com.tencent.biz.richframework.localupload.recommend.classifier.video.RFWPetBabyVideoClassifier$handpick$$inlined$sortedByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t16, T t17) {
                int compareValues;
                compareValues = ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(((RFWMediaInfo) t17).getSharpness()), Integer.valueOf(((RFWMediaInfo) t16).getSharpness()));
                return compareValues;
            }
        });
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) sortedWith);
        return mutableList;
    }
}
