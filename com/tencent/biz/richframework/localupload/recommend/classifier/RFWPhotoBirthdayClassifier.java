package com.tencent.biz.richframework.localupload.recommend.classifier;

import com.tencent.biz.richframework.localupload.recommend.RFWUploadRecommendDbManager;
import com.tencent.biz.richframework.localupload.recommend.RecommendContext;
import com.tencent.biz.richframework.localupload.recommend.bean.RFWMediaInfo;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010$\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\u001e\u0010\t\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\f\u0012\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000b0\nH\u0016J(\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/biz/richframework/localupload/recommend/classifier/RFWPhotoBirthdayClassifier;", "Lcom/tencent/biz/richframework/localupload/recommend/classifier/RFWBasePhotoClassifier;", "context", "Lcom/tencent/biz/richframework/localupload/recommend/RecommendContext;", "dbManager", "Lcom/tencent/biz/richframework/localupload/recommend/RFWUploadRecommendDbManager;", "(Lcom/tencent/biz/richframework/localupload/recommend/RecommendContext;Lcom/tencent/biz/richframework/localupload/recommend/RFWUploadRecommendDbManager;)V", "getClassifyId", "", "getQuerySelectInfo", "Lkotlin/Pair;", "", "groupBy", "", "", "Lcom/tencent/biz/richframework/localupload/recommend/bean/RFWMediaInfo;", "mediaInfoList", "isNeedGroup", "", "isPhotoFromSameDay", "local-upload-recommend-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class RFWPhotoBirthdayClassifier extends RFWBasePhotoClassifier {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RFWPhotoBirthdayClassifier(@NotNull RecommendContext context, @NotNull RFWUploadRecommendDbManager dbManager) {
        super(context, dbManager);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dbManager, "dbManager");
    }

    @Override // com.tencent.biz.richframework.localupload.recommend.classifier.RFWBaseClassifier
    @NotNull
    public String getClassifyId() {
        return "3_2";
    }

    @Override // com.tencent.biz.richframework.localupload.recommend.classifier.RFWBaseClassifier
    @NotNull
    public Pair<String, String[]> getQuerySelectInfo() {
        return new Pair<>("mTagSubType = ? and mFullDate != ?", new String[]{"\u751f\u65e5", ""});
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
}
