package com.tencent.biz.richframework.localupload.recommend.bean;

import com.huawei.hms.support.feature.result.CommonConstant;
import com.tencent.biz.richframework.localupload.recommend.RecommendContext;
import com.tencent.biz.richframework.localupload.recommend.classifier.RFWBaseClassifier;
import com.tencent.biz.richframework.localupload.recommend.classifier.RFWMediaStatistics;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 I2\u00020\u0001:\u0001IB\u001f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u00a2\u0006\u0004\bG\u0010HJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\u0014\u0010\n\u001a\u00020\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0007R\u0017\u0010\r\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0012\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0017\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\"\u0010\u001b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010\"\u001a\u00020!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010)\u001a\u00020(8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u0010/\u001a\u00020(8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u0010*\u001a\u0004\b0\u0010,\"\u0004\b1\u0010.R$\u00102\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107RF\u0010;\u001a&\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u000109\u0018\u000108j\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u000109\u0018\u0001`:8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R(\u0010A\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010F\u00a8\u0006J"}, d2 = {"Lcom/tencent/biz/richframework/localupload/recommend/bean/RFWUploadRecommendInfo;", "", "", "getRecommendClassifyId", "", "getRecommendCount", "toString", "", "Lcom/tencent/biz/richframework/localupload/recommend/bean/RFWMediaInfo;", "handpickResult", "setResult", "getMediaList", "Lcom/tencent/biz/richframework/localupload/recommend/RecommendContext;", "context", "Lcom/tencent/biz/richframework/localupload/recommend/RecommendContext;", "getContext", "()Lcom/tencent/biz/richframework/localupload/recommend/RecommendContext;", "Lcom/tencent/biz/richframework/localupload/recommend/bean/RFWClassifyInfo;", "classifyInfo", "Lcom/tencent/biz/richframework/localupload/recommend/bean/RFWClassifyInfo;", "getClassifyInfo", "()Lcom/tencent/biz/richframework/localupload/recommend/bean/RFWClassifyInfo;", "Lcom/tencent/biz/richframework/localupload/recommend/classifier/RFWBaseClassifier;", "classifier", "Lcom/tencent/biz/richframework/localupload/recommend/classifier/RFWBaseClassifier;", "getClassifier", "()Lcom/tencent/biz/richframework/localupload/recommend/classifier/RFWBaseClassifier;", CommonConstant.KEY_DISPLAY_NAME, "Ljava/lang/String;", "getDisplayName", "()Ljava/lang/String;", "setDisplayName", "(Ljava/lang/String;)V", "Lcom/tencent/biz/richframework/localupload/recommend/classifier/RFWMediaStatistics;", "mediaStatistics", "Lcom/tencent/biz/richframework/localupload/recommend/classifier/RFWMediaStatistics;", "getMediaStatistics", "()Lcom/tencent/biz/richframework/localupload/recommend/classifier/RFWMediaStatistics;", "setMediaStatistics", "(Lcom/tencent/biz/richframework/localupload/recommend/classifier/RFWMediaStatistics;)V", "", "lastTakePicTime", "J", "getLastTakePicTime", "()J", "setLastTakePicTime", "(J)V", "lastScanTime", "getLastScanTime", "setLastScanTime", "firstMediaInfo", "Lcom/tencent/biz/richframework/localupload/recommend/bean/RFWMediaInfo;", "getFirstMediaInfo", "()Lcom/tencent/biz/richframework/localupload/recommend/bean/RFWMediaInfo;", "setFirstMediaInfo", "(Lcom/tencent/biz/richframework/localupload/recommend/bean/RFWMediaInfo;)V", "Ljava/util/HashMap;", "Ljava/io/Serializable;", "Lkotlin/collections/HashMap;", "extData", "Ljava/util/HashMap;", "getExtData", "()Ljava/util/HashMap;", "setExtData", "(Ljava/util/HashMap;)V", "recommendMediaInfoList", "Ljava/util/List;", "getRecommendMediaInfoList", "()Ljava/util/List;", "setRecommendMediaInfoList", "(Ljava/util/List;)V", "<init>", "(Lcom/tencent/biz/richframework/localupload/recommend/RecommendContext;Lcom/tencent/biz/richframework/localupload/recommend/bean/RFWClassifyInfo;Lcom/tencent/biz/richframework/localupload/recommend/classifier/RFWBaseClassifier;)V", "Companion", "local-upload-recommend-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class RFWUploadRecommendInfo {

    @NotNull
    private final RFWBaseClassifier classifier;

    @NotNull
    private final RFWClassifyInfo classifyInfo;

    @NotNull
    private final RecommendContext context;

    @NotNull
    private String displayName;

    @Nullable
    private HashMap<String, Serializable> extData;

    @Nullable
    private RFWMediaInfo firstMediaInfo;
    private long lastScanTime;
    private long lastTakePicTime;

    @NotNull
    private RFWMediaStatistics mediaStatistics;

    @NotNull
    private List<RFWMediaInfo> recommendMediaInfoList;

    public RFWUploadRecommendInfo(@NotNull RecommendContext context, @NotNull RFWClassifyInfo classifyInfo, @NotNull RFWBaseClassifier classifier) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(classifyInfo, "classifyInfo");
        Intrinsics.checkNotNullParameter(classifier, "classifier");
        this.context = context;
        this.classifyInfo = classifyInfo;
        this.classifier = classifier;
        this.displayName = "";
        this.mediaStatistics = new RFWMediaStatistics(classifier);
        this.recommendMediaInfoList = new ArrayList();
    }

    @NotNull
    public final RFWBaseClassifier getClassifier() {
        return this.classifier;
    }

    @NotNull
    public final RFWClassifyInfo getClassifyInfo() {
        return this.classifyInfo;
    }

    @NotNull
    public final String getDisplayName() {
        return this.displayName;
    }

    @Nullable
    public final HashMap<String, Serializable> getExtData() {
        return this.extData;
    }

    @Nullable
    public final RFWMediaInfo getFirstMediaInfo() {
        return this.firstMediaInfo;
    }

    public final long getLastScanTime() {
        return this.lastScanTime;
    }

    public final long getLastTakePicTime() {
        return this.lastTakePicTime;
    }

    @NotNull
    public final List<RFWMediaInfo> getMediaList() {
        return this.recommendMediaInfoList;
    }

    @NotNull
    public final RFWMediaStatistics getMediaStatistics() {
        return this.mediaStatistics;
    }

    @NotNull
    public final String getRecommendClassifyId() {
        return this.classifyInfo.getClassifyId();
    }

    public final int getRecommendCount() {
        return this.recommendMediaInfoList.size();
    }

    @NotNull
    public final List<RFWMediaInfo> getRecommendMediaInfoList() {
        return this.recommendMediaInfoList;
    }

    public final void setExtData(@Nullable HashMap<String, Serializable> hashMap) {
        this.extData = hashMap;
    }

    public final void setFirstMediaInfo(@Nullable RFWMediaInfo rFWMediaInfo) {
        this.firstMediaInfo = rFWMediaInfo;
    }

    @NotNull
    public final String setResult(@NotNull List<RFWMediaInfo> handpickResult) {
        Intrinsics.checkNotNullParameter(handpickResult, "handpickResult");
        if (!handpickResult.isEmpty()) {
            this.recommendMediaInfoList = handpickResult;
            this.mediaStatistics.calculateMediaStatistics(handpickResult);
            String convertDisplayName = RFWClassifyID.INSTANCE.convertDisplayName(this.classifier, handpickResult.get(0));
            this.displayName = convertDisplayName;
            return convertDisplayName;
        }
        return "";
    }

    @NotNull
    public String toString() {
        return "RFWUploadRecommendInfo@" + hashCode() + "{classifyInfo:" + this.classifyInfo + ",recommendCount:" + getRecommendCount() + "}";
    }
}
