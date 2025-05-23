package com.tencent.biz.richframework.localupload.recommend.classifier;

import com.tencent.biz.richframework.localupload.recommend.RFWUploadRecommendDbManager;
import com.tencent.biz.richframework.localupload.recommend.RecommendContext;
import com.tencent.biz.richframework.localupload.recommend.bean.RFWMediaInfo;
import com.tencent.biz.richframework.localupload.recommend.trace.RFWLocalPhotoTracer;
import com.tencent.biz.richframework.localupload.recommend.utils.RFWRecommendUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\b&\u0018\u0000 /2\u00020\u0001:\u0001/B\u0017\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\u0006\u0010#\u001a\u00020\"\u00a2\u0006\u0004\b-\u0010.J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016J\u0006\u0010\u000b\u001a\u00020\u0006J \u0010\u000e\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\r\u0018\u00010\fH&J\u0018\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\bH\u0016J(\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00100\u00132\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0010H\u0016J\b\u0010\u0015\u001a\u00020\u0006H\u0016J\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u0016H\u0016J\b\u0010\u0019\u001a\u00020\u0002H&J\b\u0010\u001a\u001a\u00020\u0006H\u0016J\b\u0010\u001b\u001a\u00020\u0006H\u0016J\b\u0010\u001c\u001a\u00020\u0006H\u0016R\u0017\u0010\u001e\u001a\u00020\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010#\u001a\u00020\"8\u0006\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\"\u0010'\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,\u00a8\u00060"}, d2 = {"Lcom/tencent/biz/richframework/localupload/recommend/classifier/RFWBaseClassifier;", "", "", "getQueryLimit", "", "getClassifyId", "", "isMakeVideoClassifier", "Lcom/tencent/biz/richframework/localupload/recommend/bean/RFWMediaInfo;", "mediaInfo", "getPreDisplayName", "isClassifierEnabled", "Lkotlin/Pair;", "", "getQuerySelectInfo", "offsetItem", "", "queryMediaList", "mediaInfoList", "", "groupBy", "isNeedHandpick", "", "rfwMediaInfoList", "handpick", "getMaxPhotoCount", "isRelyOnResearchTag", "isPhotoFromSameDay", "isNeedGroup", "Lcom/tencent/biz/richframework/localupload/recommend/RecommendContext;", "mContext", "Lcom/tencent/biz/richframework/localupload/recommend/RecommendContext;", "getMContext", "()Lcom/tencent/biz/richframework/localupload/recommend/RecommendContext;", "Lcom/tencent/biz/richframework/localupload/recommend/RFWUploadRecommendDbManager;", "mDbManager", "Lcom/tencent/biz/richframework/localupload/recommend/RFWUploadRecommendDbManager;", "getMDbManager", "()Lcom/tencent/biz/richframework/localupload/recommend/RFWUploadRecommendDbManager;", "mPreDisplayName", "Ljava/lang/String;", "getMPreDisplayName", "()Ljava/lang/String;", "setMPreDisplayName", "(Ljava/lang/String;)V", "<init>", "(Lcom/tencent/biz/richframework/localupload/recommend/RecommendContext;Lcom/tencent/biz/richframework/localupload/recommend/RFWUploadRecommendDbManager;)V", "Companion", "local-upload-recommend-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public abstract class RFWBaseClassifier {

    @NotNull
    private static final String TAG = "RFWBaseClassifier";

    @NotNull
    private static String sDisableClassifierConfig = "";

    @NotNull
    private static List<String> sDisableClassifierIDList;

    @NotNull
    private final RecommendContext mContext;

    @NotNull
    private final RFWUploadRecommendDbManager mDbManager;

    @NotNull
    private String mPreDisplayName;

    static {
        List<String> emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        sDisableClassifierIDList = emptyList;
    }

    public RFWBaseClassifier(@NotNull RecommendContext mContext, @NotNull RFWUploadRecommendDbManager mDbManager) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        Intrinsics.checkNotNullParameter(mDbManager, "mDbManager");
        this.mContext = mContext;
        this.mDbManager = mDbManager;
        this.mPreDisplayName = "";
    }

    private final int getQueryLimit() {
        if (isNeedGroup()) {
            return 500;
        }
        return 100;
    }

    @NotNull
    public abstract String getClassifyId();

    @NotNull
    public final RecommendContext getMContext() {
        return this.mContext;
    }

    public abstract int getMaxPhotoCount();

    @NotNull
    public String getPreDisplayName(@NotNull RFWMediaInfo mediaInfo) {
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        return "";
    }

    @Nullable
    public abstract Pair<String, String[]> getQuerySelectInfo();

    @NotNull
    public Map<String, List<RFWMediaInfo>> groupBy(@NotNull List<RFWMediaInfo> mediaInfoList) {
        Intrinsics.checkNotNullParameter(mediaInfoList, "mediaInfoList");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : mediaInfoList) {
            RFWMediaInfo rFWMediaInfo = (RFWMediaInfo) obj;
            String str = rFWMediaInfo.getMFestival() + rFWMediaInfo.getMYear();
            Object obj2 = linkedHashMap.get(str);
            if (obj2 == null) {
                obj2 = new ArrayList();
                linkedHashMap.put(str, obj2);
            }
            ((List) obj2).add(obj);
        }
        return linkedHashMap;
    }

    @NotNull
    public List<RFWMediaInfo> handpick(@NotNull List<RFWMediaInfo> rfwMediaInfoList) {
        Intrinsics.checkNotNullParameter(rfwMediaInfoList, "rfwMediaInfoList");
        return rfwMediaInfoList;
    }

    public final synchronized boolean isClassifierEnabled() {
        List<String> split$default;
        String disableClassifier = this.mContext.getDelegate().getConfigDelegate().getDisableClassifier();
        if (!Intrinsics.areEqual(sDisableClassifierConfig, disableClassifier)) {
            sDisableClassifierConfig = disableClassifier;
            split$default = StringsKt__StringsKt.split$default((CharSequence) disableClassifier, new String[]{","}, false, 0, 6, (Object) null);
            sDisableClassifierIDList = split$default;
        }
        return !sDisableClassifierIDList.contains(getClassifyId());
    }

    public boolean isMakeVideoClassifier() {
        return false;
    }

    public boolean isNeedGroup() {
        return false;
    }

    public boolean isNeedHandpick() {
        return true;
    }

    public boolean isPhotoFromSameDay() {
        return false;
    }

    public boolean isRelyOnResearchTag() {
        return true;
    }

    @NotNull
    public List<RFWMediaInfo> queryMediaList(@Nullable RFWMediaInfo offsetItem) {
        String str;
        Object floatOrNull;
        Pair<String, String[]> querySelectInfo = getQuerySelectInfo();
        if (querySelectInfo == null) {
            RFWLocalPhotoTracer.INSTANCE.onClassifyError(this, "query result is null");
            return new ArrayList();
        }
        int queryLimit = getQueryLimit();
        if (querySelectInfo.getFirst() != null) {
            str = querySelectInfo.getFirst();
        } else {
            str = null;
        }
        if (offsetItem != null) {
            if (str == null) {
                str = "_id<" + offsetItem.getMId();
            } else {
                str = ((Object) str) + " and _id<" + offsetItem.getMId();
            }
        }
        if (isRelyOnResearchTag()) {
            floatOrNull = StringsKt__StringNumberConversionsJVMKt.toFloatOrNull(RFWRecommendUtil.INSTANCE.getClassifyConfig(this.mContext, "tag_confidence_min"));
            if (floatOrNull == null) {
                floatOrNull = 80;
            }
            String str2 = "(mTagScore >= " + floatOrNull + " or mTagScore = 0)";
            if (str == null) {
                str = str2;
            } else {
                str = ((Object) str) + " and " + str2;
            }
        }
        RecommendContext recommendContext = this.mContext;
        String str3 = TAG;
        String classifyId = getClassifyId();
        String arrays = Arrays.toString(querySelectInfo.getSecond());
        Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
        recommendContext.dev(str3, "[queryMediaList] id: " + classifyId + ", selection: " + ((Object) str) + ", args:" + arrays);
        return this.mDbManager.query(str, querySelectInfo.getSecond(), "_id DESC", String.valueOf(queryLimit));
    }
}
