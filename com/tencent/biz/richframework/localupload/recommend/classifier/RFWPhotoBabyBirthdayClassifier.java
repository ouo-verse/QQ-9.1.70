package com.tencent.biz.richframework.localupload.recommend.classifier;

import com.tencent.biz.richframework.localupload.recommend.RFWUploadRecommendDbManager;
import com.tencent.biz.richframework.localupload.recommend.RecommendContext;
import com.tencent.biz.richframework.localupload.recommend.bean.RFWMediaInfo;
import com.tencent.biz.richframework.localupload.recommend.classifier.tag.RFWResearchClassifyUtils;
import com.tencent.biz.richframework.localupload.recommend.utils.RFWRecommendDateUtils;
import com.tencent.biz.richframework.localupload.recommend.utils.RFWRecommendUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u001c\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\nH\u0002J\b\u0010\u000b\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\f\u0012\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0011\u0018\u00010\u0010H\u0016J(\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00130\n2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\b\u0010\u0018\u001a\u00020\u0016H\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/biz/richframework/localupload/recommend/classifier/RFWPhotoBabyBirthdayClassifier;", "Lcom/tencent/biz/richframework/localupload/recommend/classifier/RFWBasePhotoClassifier;", "context", "Lcom/tencent/biz/richframework/localupload/recommend/RecommendContext;", "dbManager", "Lcom/tencent/biz/richframework/localupload/recommend/RFWUploadRecommendDbManager;", "(Lcom/tencent/biz/richframework/localupload/recommend/RecommendContext;Lcom/tencent/biz/richframework/localupload/recommend/RFWUploadRecommendDbManager;)V", "getBabyBirthdayConfigSelectMsg", "", "babyBirthdayConfig", "", "getClassifyId", "getPreDisplayName", "mediaInfo", "Lcom/tencent/biz/richframework/localupload/recommend/bean/RFWMediaInfo;", "getQuerySelectInfo", "Lkotlin/Pair;", "", "groupBy", "", "mediaInfoList", "isNeedGroup", "", "isPhotoFromSameDay", "isRelyOnResearchTag", "local-upload-recommend-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class RFWPhotoBabyBirthdayClassifier extends RFWBasePhotoClassifier {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RFWPhotoBabyBirthdayClassifier(@NotNull RecommendContext context, @NotNull RFWUploadRecommendDbManager dbManager) {
        super(context, dbManager);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dbManager, "dbManager");
    }

    private final String getBabyBirthdayConfigSelectMsg(Map<String, String> babyBirthdayConfig) {
        String removeSuffix;
        if (babyBirthdayConfig.isEmpty()) {
            return "";
        }
        Iterator<Map.Entry<String, String>> it = babyBirthdayConfig.entrySet().iterator();
        String str = " mMonthAndDay in (";
        while (it.hasNext()) {
            str = ((Object) str) + "'" + RFWRecommendDateUtils.getMonthAndDay(it.next().getValue()) + "',";
        }
        removeSuffix = StringsKt__StringsKt.removeSuffix(str, (CharSequence) ",");
        return ((Object) removeSuffix) + ")";
    }

    @Override // com.tencent.biz.richframework.localupload.recommend.classifier.RFWBaseClassifier
    @NotNull
    public String getClassifyId() {
        return "3_4";
    }

    @Override // com.tencent.biz.richframework.localupload.recommend.classifier.RFWBaseClassifier
    @NotNull
    public String getPreDisplayName(@NotNull RFWMediaInfo mediaInfo) {
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        return mediaInfo.getMYear();
    }

    @Override // com.tencent.biz.richframework.localupload.recommend.classifier.RFWBaseClassifier
    @Nullable
    public Pair<String, String[]> getQuerySelectInfo() {
        Map<String, String> convertConfigToMap = RFWRecommendUtil.INSTANCE.convertConfigToMap(getMContext(), "recommend_parenting_album_birthday");
        if (convertConfigToMap.isEmpty()) {
            return null;
        }
        return new Pair<>("mFullDate != ? and mYear != ? and" + RFWResearchClassifyUtils.INSTANCE.getBabySelectMsg(getMContext()) + " and " + getBabyBirthdayConfigSelectMsg(convertConfigToMap), new String[]{"", ""});
    }

    @Override // com.tencent.biz.richframework.localupload.recommend.classifier.RFWBaseClassifier
    @NotNull
    public Map<String, List<RFWMediaInfo>> groupBy(@NotNull List<RFWMediaInfo> mediaInfoList) {
        Intrinsics.checkNotNullParameter(mediaInfoList, "mediaInfoList");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : mediaInfoList) {
            RFWMediaInfo rFWMediaInfo = (RFWMediaInfo) obj;
            String str = rFWMediaInfo.getMYear() + rFWMediaInfo.getMFullDate();
            Object obj2 = linkedHashMap.get(str);
            if (obj2 == null) {
                obj2 = new ArrayList();
                linkedHashMap.put(str, obj2);
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
