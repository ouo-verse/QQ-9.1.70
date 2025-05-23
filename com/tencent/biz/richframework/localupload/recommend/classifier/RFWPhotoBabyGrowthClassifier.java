package com.tencent.biz.richframework.localupload.recommend.classifier;

import com.tencent.biz.richframework.localupload.recommend.RFWUploadRecommendDbManager;
import com.tencent.biz.richframework.localupload.recommend.RecommendContext;
import com.tencent.biz.richframework.localupload.recommend.bean.RFWMediaInfo;
import com.tencent.biz.richframework.localupload.recommend.classifier.tag.RFWResearchClassifyUtils;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J \u0010\f\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\f\u0012\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000e\u0018\u00010\rH\u0016J(\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00110\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0011H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0016\u001a\u00020\u0014H\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/biz/richframework/localupload/recommend/classifier/RFWPhotoBabyGrowthClassifier;", "Lcom/tencent/biz/richframework/localupload/recommend/classifier/RFWBasePhotoClassifier;", "context", "Lcom/tencent/biz/richframework/localupload/recommend/RecommendContext;", "dbManager", "Lcom/tencent/biz/richframework/localupload/recommend/RFWUploadRecommendDbManager;", "(Lcom/tencent/biz/richframework/localupload/recommend/RecommendContext;Lcom/tencent/biz/richframework/localupload/recommend/RFWUploadRecommendDbManager;)V", "getClassifyId", "", "getPreDisplayName", "mediaInfo", "Lcom/tencent/biz/richframework/localupload/recommend/bean/RFWMediaInfo;", "getQuerySelectInfo", "Lkotlin/Pair;", "", "groupBy", "", "", "mediaInfoList", "isNeedGroup", "", "isPhotoFromSameDay", "isRelyOnResearchTag", "local-upload-recommend-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class RFWPhotoBabyGrowthClassifier extends RFWBasePhotoClassifier {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RFWPhotoBabyGrowthClassifier(@NotNull RecommendContext context, @NotNull RFWUploadRecommendDbManager dbManager) {
        super(context, dbManager);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dbManager, "dbManager");
    }

    @Override // com.tencent.biz.richframework.localupload.recommend.classifier.RFWBaseClassifier
    @NotNull
    public String getClassifyId() {
        return "3_6";
    }

    @Override // com.tencent.biz.richframework.localupload.recommend.classifier.RFWBaseClassifier
    @NotNull
    public String getPreDisplayName(@NotNull RFWMediaInfo mediaInfo) {
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        return mediaInfo.getMMonthAndDay();
    }

    @Override // com.tencent.biz.richframework.localupload.recommend.classifier.RFWBaseClassifier
    @Nullable
    public Pair<String, String[]> getQuerySelectInfo() {
        return new Pair<>("mMonthAndDay != ? and mFullDate != ?  and " + RFWResearchClassifyUtils.INSTANCE.getBabySelectMsg(getMContext()), new String[]{"", ""});
    }

    @Override // com.tencent.biz.richframework.localupload.recommend.classifier.RFWBaseClassifier
    @NotNull
    public Map<String, List<RFWMediaInfo>> groupBy(@NotNull List<RFWMediaInfo> mediaInfoList) {
        Intrinsics.checkNotNullParameter(mediaInfoList, "mediaInfoList");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : mediaInfoList) {
            String mFullDate = ((RFWMediaInfo) obj).getMFullDate();
            Object obj2 = linkedHashMap.get(mFullDate);
            if (obj2 == null) {
                obj2 = new ArrayList();
                linkedHashMap.put(mFullDate, obj2);
            }
            ((List) obj2).add(obj);
        }
        return linkedHashMap;
    }

    @Override // com.tencent.biz.richframework.localupload.recommend.classifier.RFWBaseClassifier
    public boolean isNeedGroup() {
        return true;
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
