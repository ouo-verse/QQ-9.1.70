package com.tencent.biz.richframework.localupload.recommend.bean;

import android.text.TextUtils;
import com.tencent.biz.richframework.localupload.recommend.classifier.RFWBaseClassifier;
import com.tencent.biz.richframework.localupload.recommend.utils.RFWRecommendUtil;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R#\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/biz/richframework/localupload/recommend/bean/RFWClassifyID;", "", "Lcom/tencent/biz/richframework/localupload/recommend/classifier/RFWBaseClassifier;", "classifyInfo", "Lcom/tencent/biz/richframework/localupload/recommend/bean/RFWMediaInfo;", "mediaInfo", "", "convertDisplayName", "", "Lcom/tencent/biz/richframework/localupload/recommend/bean/RFWRecommendConfig;", "RECOMMEND_CONFIG", "Ljava/util/Map;", "getRECOMMEND_CONFIG", "()Ljava/util/Map;", "<init>", "()V", "local-upload-recommend-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class RFWClassifyID {

    @NotNull
    public static final RFWClassifyID INSTANCE = new RFWClassifyID();

    @NotNull
    private static final Map<String, RFWRecommendConfig> RECOMMEND_CONFIG;

    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        RECOMMEND_CONFIG = concurrentHashMap;
        concurrentHashMap.put("3_1", new RFWRecommendConfig("\u6b22\u805a\u65f6\u523b"));
        concurrentHashMap.put("1_3", new RFWRecommendConfig("\u5728\u8def\u4e0a"));
        concurrentHashMap.put("3_2", new RFWRecommendConfig("Happy Birthday"));
        concurrentHashMap.put("3_3", new RFWRecommendConfig("\u611f\u52a8\u77ac\u95f4"));
        concurrentHashMap.put("3_4", new RFWRecommendConfig("\u5b9d\u8d1d\u751f\u65e5"));
        concurrentHashMap.put("3_5", new RFWRecommendConfig("\u6709\u4f60\u771f\u597d"));
        concurrentHashMap.put("3_6", new RFWRecommendConfig("\u6210\u957f\u65e5\u8bb0"));
        concurrentHashMap.put("3_7", new RFWRecommendConfig("\u6211\u7684\u5ba0\u7269\u65e5\u8bb0"));
        concurrentHashMap.put("3_8", new RFWRecommendConfig("\u7eaa\u5ff5\u65e5"));
        concurrentHashMap.put("2_2", new RFWRecommendConfig("\u5468\u672b\u65f6\u5149"));
        concurrentHashMap.put("4_1", new RFWRecommendConfig("\u552f\u6709\u7f8e\u98df\u4e0d\u53ef\u8f9c\u8d1f"));
        concurrentHashMap.put("5_1", new RFWRecommendConfig("\u6211\u7684\u8db3\u8ff9"));
        concurrentHashMap.put("5_2", new RFWRecommendConfig("\u65c5\u884c\u65f6\u523b"));
        concurrentHashMap.put("5_3", new RFWRecommendConfig("\u90a3\u5e74\u4eca\u65e5"));
        concurrentHashMap.put("5_4", new RFWRecommendConfig("\u5e78\u798f\u65f6\u523b"));
        concurrentHashMap.put("5_5", new RFWRecommendConfig("\u840c\u5ba0\u5b9d\u8d1d"));
        concurrentHashMap.put("5_6", new RFWRecommendConfig("\u5b9d\u8d1d\u65e5\u8bb0"));
        concurrentHashMap.put("5_7", new RFWRecommendConfig("\u96be\u5fd8\u4e00\u523b"));
    }

    RFWClassifyID() {
    }

    @NotNull
    public final String convertDisplayName(@NotNull RFWBaseClassifier classifyInfo, @NotNull RFWMediaInfo mediaInfo) {
        String str;
        boolean contains$default;
        String removeSuffix;
        boolean contains$default2;
        Intrinsics.checkNotNullParameter(classifyInfo, "classifyInfo");
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        String classifyTitleConfig = RFWRecommendUtil.INSTANCE.getClassifyTitleConfig(classifyInfo.getMContext(), classifyInfo.getClassifyId());
        RFWRecommendConfig rFWRecommendConfig = RECOMMEND_CONFIG.get(classifyInfo.getClassifyId());
        String str2 = "";
        if (rFWRecommendConfig == null || (str = rFWRecommendConfig.getDisplayName()) == null) {
            str = "";
        }
        try {
            try {
                if (!TextUtils.isEmpty(classifyTitleConfig)) {
                    contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) classifyTitleConfig, (CharSequence) "%s", false, 2, (Object) null);
                    if (!contains$default2) {
                        removeSuffix = StringsKt__StringsKt.removeSuffix(classifyTitleConfig, (CharSequence) "\u5e02");
                        return removeSuffix;
                    }
                }
                if (!TextUtils.isEmpty(classifyTitleConfig)) {
                    contains$default = StringsKt__StringsKt.contains$default((CharSequence) classifyTitleConfig, (CharSequence) "%s", false, 2, (Object) null);
                    if (contains$default) {
                        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                        classifyTitleConfig = String.format(classifyTitleConfig, Arrays.copyOf(new Object[]{classifyInfo.getPreDisplayName(mediaInfo)}, 1));
                        Intrinsics.checkNotNullExpressionValue(classifyTitleConfig, "format(format, *args)");
                        removeSuffix = StringsKt__StringsKt.removeSuffix(classifyTitleConfig, (CharSequence) "\u5e02");
                        return removeSuffix;
                    }
                }
                removeSuffix = StringsKt__StringsKt.removeSuffix(classifyTitleConfig, (CharSequence) "\u5e02");
                return removeSuffix;
            } catch (Exception unused) {
                str2 = classifyTitleConfig;
                classifyInfo.getMContext().d("RFWClassifyID", "[convertDisplayName] fail " + classifyInfo.getPreDisplayName(mediaInfo));
                return str2;
            }
            if (!TextUtils.isEmpty(str)) {
                classifyTitleConfig = str;
            } else {
                classifyTitleConfig = classifyInfo.getPreDisplayName(mediaInfo);
            }
        } catch (Exception unused2) {
        }
    }

    @NotNull
    public final Map<String, RFWRecommendConfig> getRECOMMEND_CONFIG() {
        return RECOMMEND_CONFIG;
    }
}
