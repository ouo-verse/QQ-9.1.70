package com.tencent.biz.richframework.localupload.recommend.classifier.video;

import com.tencent.biz.richframework.localupload.recommend.RFWUploadRecommendDbManager;
import com.tencent.biz.richframework.localupload.recommend.RecommendContext;
import com.tencent.biz.richframework.localupload.recommend.bean.RFWMediaInfo;
import com.tencent.biz.richframework.localupload.recommend.utils.RFWRecommendUtil;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u001e\u0010\t\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\b0\u0007H\u0016J\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016R\u0017\u0010\u000f\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/biz/richframework/localupload/recommend/classifier/video/RFWUnforgettableVideoClassifier;", "Lcom/tencent/biz/richframework/localupload/recommend/classifier/video/RFWBaseVideoClassifier;", "", "getClassifyId", "", "isPhotoFromSameDay", "isRelyOnResearchTag", "Lkotlin/Pair;", "", "getQuerySelectInfo", "", "Lcom/tencent/biz/richframework/localupload/recommend/bean/RFWMediaInfo;", "rfwMediaInfoList", "handpick", "Lcom/tencent/biz/richframework/localupload/recommend/RecommendContext;", "context", "Lcom/tencent/biz/richframework/localupload/recommend/RecommendContext;", "getContext", "()Lcom/tencent/biz/richframework/localupload/recommend/RecommendContext;", "Lcom/tencent/biz/richframework/localupload/recommend/RFWUploadRecommendDbManager;", "dbManager", "<init>", "(Lcom/tencent/biz/richframework/localupload/recommend/RecommendContext;Lcom/tencent/biz/richframework/localupload/recommend/RFWUploadRecommendDbManager;)V", "Companion", "local-upload-recommend-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class RFWUnforgettableVideoClassifier extends RFWBaseVideoClassifier {

    @NotNull
    private final RecommendContext context;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RFWUnforgettableVideoClassifier(@NotNull RecommendContext context, @NotNull RFWUploadRecommendDbManager dbManager) {
        super(context, dbManager);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dbManager, "dbManager");
        this.context = context;
    }

    @Override // com.tencent.biz.richframework.localupload.recommend.classifier.RFWBaseClassifier
    @NotNull
    public String getClassifyId() {
        return "5_7";
    }

    @Override // com.tencent.biz.richframework.localupload.recommend.classifier.RFWBaseClassifier
    @NotNull
    public Pair<String, String[]> getQuerySelectInfo() {
        Integer intOrNull;
        int i3;
        intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(RFWRecommendUtil.INSTANCE.getClassifyConfig(this.context, "face_proportion_min"));
        if (intOrNull != null) {
            i3 = intOrNull.intValue();
        } else {
            i3 = 10;
        }
        return new Pair<>("mFaceSize=? and mFaceGender1!=mFaceGender2 and mFaceAge1>=15 and mFaceAge2>=15 and mFaceRatio1>=" + i3 + " and mFaceRatio2>=" + i3, new String[]{"2"});
    }

    @Override // com.tencent.biz.richframework.localupload.recommend.classifier.RFWBaseClassifier
    @NotNull
    public List<RFWMediaInfo> handpick(@NotNull List<RFWMediaInfo> rfwMediaInfoList) {
        List sortedWith;
        List<RFWMediaInfo> mutableList;
        Intrinsics.checkNotNullParameter(rfwMediaInfoList, "rfwMediaInfoList");
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(rfwMediaInfoList, new Comparator() { // from class: com.tencent.biz.richframework.localupload.recommend.classifier.video.RFWUnforgettableVideoClassifier$handpick$$inlined$sortedByDescending$1
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

    @Override // com.tencent.biz.richframework.localupload.recommend.classifier.RFWBaseClassifier
    public boolean isPhotoFromSameDay() {
        return true;
    }

    @Override // com.tencent.biz.richframework.localupload.recommend.classifier.RFWBaseClassifier
    public boolean isRelyOnResearchTag() {
        return false;
    }
}
