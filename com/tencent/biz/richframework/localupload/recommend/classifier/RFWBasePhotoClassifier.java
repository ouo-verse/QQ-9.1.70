package com.tencent.biz.richframework.localupload.recommend.classifier;

import com.tencent.biz.richframework.localupload.recommend.RFWUploadRecommendDbManager;
import com.tencent.biz.richframework.localupload.recommend.RecommendContext;
import com.tencent.biz.richframework.localupload.recommend.bean.RFWMediaInfo;
import com.tencent.biz.richframework.localupload.recommend.utils.RFWRecommendUtil;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/biz/richframework/localupload/recommend/classifier/RFWBasePhotoClassifier;", "Lcom/tencent/biz/richframework/localupload/recommend/classifier/RFWBaseClassifier;", "context", "Lcom/tencent/biz/richframework/localupload/recommend/RecommendContext;", "dbManager", "Lcom/tencent/biz/richframework/localupload/recommend/RFWUploadRecommendDbManager;", "(Lcom/tencent/biz/richframework/localupload/recommend/RecommendContext;Lcom/tencent/biz/richframework/localupload/recommend/RFWUploadRecommendDbManager;)V", "getMaxPhotoCount", "", "handpick", "", "Lcom/tencent/biz/richframework/localupload/recommend/bean/RFWMediaInfo;", "rfwMediaInfoList", "Companion", "local-upload-recommend-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public abstract class RFWBasePhotoClassifier extends RFWBaseClassifier {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RFWBasePhotoClassifier(@NotNull RecommendContext context, @NotNull RFWUploadRecommendDbManager dbManager) {
        super(context, dbManager);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dbManager, "dbManager");
    }

    @Override // com.tencent.biz.richframework.localupload.recommend.classifier.RFWBaseClassifier
    public int getMaxPhotoCount() {
        Integer intOrNull;
        intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(RFWRecommendUtil.INSTANCE.getClassifyConfig(getMContext(), "photo_count_max"));
        if (intOrNull != null) {
            return intOrNull.intValue();
        }
        return 30;
    }

    @Override // com.tencent.biz.richframework.localupload.recommend.classifier.RFWBaseClassifier
    @NotNull
    public List<RFWMediaInfo> handpick(@NotNull List<RFWMediaInfo> rfwMediaInfoList) {
        List sortedWith;
        List<RFWMediaInfo> mutableList;
        Intrinsics.checkNotNullParameter(rfwMediaInfoList, "rfwMediaInfoList");
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(rfwMediaInfoList, new Comparator() { // from class: com.tencent.biz.richframework.localupload.recommend.classifier.RFWBasePhotoClassifier$handpick$$inlined$sortedByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t16, T t17) {
                int compareValues;
                compareValues = ComparisonsKt__ComparisonsKt.compareValues(Long.valueOf(((RFWMediaInfo) t17).getMTakePicTime()), Long.valueOf(((RFWMediaInfo) t16).getMTakePicTime()));
                return compareValues;
            }
        });
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) sortedWith);
        return mutableList;
    }
}
