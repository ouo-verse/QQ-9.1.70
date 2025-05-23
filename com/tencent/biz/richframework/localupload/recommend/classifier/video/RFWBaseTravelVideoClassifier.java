package com.tencent.biz.richframework.localupload.recommend.classifier.video;

import com.tencent.biz.richframework.localupload.recommend.RFWUploadRecommendDbManager;
import com.tencent.biz.richframework.localupload.recommend.RecommendContext;
import com.tencent.biz.richframework.localupload.recommend.bean.RFWMediaInfo;
import com.tencent.biz.richframework.localupload.recommend.classifier.tag.RFWResearchClassifyUtils;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00070\u0006J\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/biz/richframework/localupload/recommend/classifier/video/RFWBaseTravelVideoClassifier;", "Lcom/tencent/biz/richframework/localupload/recommend/classifier/video/RFWBaseVideoClassifier;", "", "tagType", "", "isScenery", "Lkotlin/Pair;", "", "getTravelTagQueryInfo", "", "Lcom/tencent/biz/richframework/localupload/recommend/bean/RFWMediaInfo;", "rfwMediaInfoList", "handpick", "Lcom/tencent/biz/richframework/localupload/recommend/RecommendContext;", "context", "Lcom/tencent/biz/richframework/localupload/recommend/RFWUploadRecommendDbManager;", "dbManager", "<init>", "(Lcom/tencent/biz/richframework/localupload/recommend/RecommendContext;Lcom/tencent/biz/richframework/localupload/recommend/RFWUploadRecommendDbManager;)V", "local-upload-recommend-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public abstract class RFWBaseTravelVideoClassifier extends RFWBaseVideoClassifier {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RFWBaseTravelVideoClassifier(@NotNull RecommendContext context, @NotNull RFWUploadRecommendDbManager dbManager) {
        super(context, dbManager);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dbManager, "dbManager");
    }

    private final boolean isScenery(String tagType) {
        if (!Intrinsics.areEqual(tagType, "\u6237\u5916") && !Intrinsics.areEqual(tagType, "\u5efa\u7b51")) {
            return false;
        }
        return true;
    }

    @NotNull
    public final Pair<String, String[]> getTravelTagQueryInfo() {
        Object[] plus;
        RFWResearchClassifyUtils rFWResearchClassifyUtils = RFWResearchClassifyUtils.INSTANCE;
        plus = ArraysKt___ArraysJvmKt.plus((Object[]) rFWResearchClassifyUtils.getARCHITECTURE_SUB_TAGS(), (Object[]) rFWResearchClassifyUtils.getLANDSCAPE_SUB_TAG());
        return RFWResearchClassifyUtils.getQueryInfoByTags$default(rFWResearchClassifyUtils, new String[]{"\u6237\u5916", "\u5efa\u7b51", "\u690d\u7269"}, (String[]) plus, 0.0f, 4, null);
    }

    @Override // com.tencent.biz.richframework.localupload.recommend.classifier.RFWBaseClassifier
    @NotNull
    public List<RFWMediaInfo> handpick(@NotNull List<RFWMediaInfo> rfwMediaInfoList) {
        List<RFWMediaInfo> sortedWith;
        List mutableListOf;
        Intrinsics.checkNotNullParameter(rfwMediaInfoList, "rfwMediaInfoList");
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(rfwMediaInfoList, new Comparator() { // from class: com.tencent.biz.richframework.localupload.recommend.classifier.video.RFWBaseTravelVideoClassifier$handpick$$inlined$sortedByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t16, T t17) {
                int compareValues;
                compareValues = ComparisonsKt__ComparisonsKt.compareValues(Float.valueOf(((RFWMediaInfo) t17).getMTagScore()), Float.valueOf(((RFWMediaInfo) t16).getMTagScore()));
                return compareValues;
            }
        });
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (RFWMediaInfo rFWMediaInfo : sortedWith) {
            if (rFWMediaInfo.getMFaceSize() > 0 && arrayList.size() <= 3) {
                arrayList.add(rFWMediaInfo);
            } else if (isScenery(rFWMediaInfo.getMTagType()) && arrayList2.size() <= 2) {
                arrayList2.add(rFWMediaInfo);
            } else {
                List list = (List) linkedHashMap.get(rFWMediaInfo.getMCity());
                if (list == null) {
                    mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(rFWMediaInfo);
                    linkedHashMap.put(rFWMediaInfo.getMCity(), mutableListOf);
                } else if (list.size() < 3) {
                    list.add(rFWMediaInfo);
                } else {
                    arrayList3.add(rFWMediaInfo);
                }
            }
        }
        ArrayList arrayList4 = new ArrayList();
        arrayList4.addAll(arrayList);
        arrayList4.addAll(arrayList2);
        ArrayList arrayList5 = new ArrayList();
        Iterator it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList5, (List) ((Map.Entry) it.next()).getValue());
        }
        arrayList4.addAll(arrayList5);
        while (arrayList4.size() < getMaxPhotoCount() && (!arrayList3.isEmpty())) {
            arrayList4.add(arrayList3.remove(0));
        }
        return arrayList4;
    }
}
