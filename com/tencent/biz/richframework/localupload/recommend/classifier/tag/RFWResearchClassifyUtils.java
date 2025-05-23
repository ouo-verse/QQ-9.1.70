package com.tencent.biz.richframework.localupload.recommend.classifier.tag;

import com.tencent.biz.richframework.localupload.recommend.RecommendContext;
import com.tencent.biz.richframework.localupload.recommend.utils.RFWRecommendUtil;
import com.tencent.map.lib.models.AccessibleTouchItem;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b \u0010!J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002JG\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00060\u000b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00062\b\b\u0002\u0010\n\u001a\u00020\t\u00a2\u0006\u0004\b\f\u0010\rR\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u00068\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u000fR\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u000fR\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0017\u0010\u0011R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u000fR\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u000fR\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u00068\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u000f\u001a\u0004\b\u001b\u0010\u0011R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u000fR\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u000fR\u001d\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\u00068\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u000f\u001a\u0004\b\u001f\u0010\u0011\u00a8\u0006\""}, d2 = {"Lcom/tencent/biz/richframework/localupload/recommend/classifier/tag/RFWResearchClassifyUtils;", "", "Lcom/tencent/biz/richframework/localupload/recommend/RecommendContext;", "context", "", "getBabySelectMsg", "", "tagArray", "subTagArray", "", "minTagScore", "Lkotlin/Pair;", "getQueryInfoByTags", "([Ljava/lang/String;[Ljava/lang/String;F)Lkotlin/Pair;", "ARCHITECTURE_SUB_TAGS", "[Ljava/lang/String;", "getARCHITECTURE_SUB_TAGS", "()[Ljava/lang/String;", "LANDSCAPE_SUB_TAG", "getLANDSCAPE_SUB_TAG", "MARRY_SUB_TAGS", "BIRTHDAY_SUB_TAGS", "LIFE_FOOD", "getLIFE_FOOD", "LIFE_SUB_TAGS", "STILL_LIFE_SUB_TAGS", "FOOD_SUB_TAG", "getFOOD_SUB_TAG", "PLANT_SUB_TAG", "ANIMAL_SUB_TAG", "PET_SUB_TAG", "getPET_SUB_TAG", "<init>", "()V", "local-upload-recommend-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class RFWResearchClassifyUtils {

    @NotNull
    public static final RFWResearchClassifyUtils INSTANCE = new RFWResearchClassifyUtils();

    @NotNull
    private static final String[] ARCHITECTURE_SUB_TAGS = {"\u5bfa\u5e99", "\u623f\u5b50", "\u55b7\u6cc9", "\u5927\u53a6", "\u5bab\u6bbf", "\u5854", "\u6559\u5802"};

    @NotNull
    private static final String[] LANDSCAPE_SUB_TAG = {"\u5c71", "\u8def", "\u6d77", "\u6811", "\u6865", "\u5929\u7a7a", "\u6c5f\u6cb3\u6e56\u6cca", "\u6d77\u6ee9", "\u7011\u5e03", "\u65e5\u51fa\u65e5\u843d", "\u98ce\u8f66", "\u8349\u5730", "\u51b0\u5ddd", "\u65e5\u98df\u6708\u4eae", "\u6d82\u9e26", "\u96ea\u666f", "\u5f69\u8679", "\u56ed\u6797", "\u5927\u6d77", "\u519c\u573a", "\u7267\u573a", "\u6c99\u6f20\u6208\u58c1"};

    @NotNull
    private static final String[] MARRY_SUB_TAGS = {"\u5a5a\u793c"};

    @NotNull
    private static final String[] BIRTHDAY_SUB_TAGS = {"\u751f\u65e5"};

    @NotNull
    private static final String[] LIFE_FOOD = {"\u996e\u54c1", "\u751c\u70b9", "\u83dc\u80b4", "\u897f\u9910"};

    @NotNull
    private static final String[] LIFE_SUB_TAGS = {"\u94f6\u884c\u5361", "\u4e66\u6cd5", "\u8eab\u4efd\u8bc1", "\u8bc1\u4ef6", AccessibleTouchItem.MAP_DEFAULT_CONTENT_DESCRIPTION, "\u4e8c\u7ef4\u7801", "\u622a\u56fe", "\u7968\u636e", "\u540d\u7247", "\u5e7b\u706f\u7247", "\u4f1a\u8bdd"};

    @NotNull
    private static final String[] STILL_LIFE_SUB_TAGS = {"\u5305", "\u6212\u6307", "\u624b\u956f", "\u96d5\u5851", "\u7f8e\u7532", "\u773c\u955c", "\u94a2\u7434", "\u9879\u94fe", "\u978b", "\u949f\u8868", "\u624b\u673a", "\u5409\u4ed6", "\u53e4\u7b5d", "\u6cf0\u8fea\u718a", "\u76f8\u673a", "\u73a9\u5177", "\u897f\u88c5", "\u53f0\u7403", "\u7434", "\u67b6\u5b50\u9f13", "\u6c14\u7403", "\u624b\u8868", "\u786c\u5e01", "\u8033\u673a", "\u4e50\u9ad8", "\u5c0f\u63d0\u7434", "\u58a8\u955c", "\u56fd\u9645\u8c61\u68cb"};

    @NotNull
    private static final String[] FOOD_SUB_TAG = {"\u9152", "\u5496\u5561", "\u7ea2\u9152", "\u86cb\u7cd5", "\u6c34\u679c", "\u751c\u54c1", "\u751c\u751c\u5708", "\u7206\u7c73\u82b1", "\u62ab\u8428", "\u6d77\u9bae", "\u706b\u9505", "\u70e7\u70e4", "\u5bff\u53f8", "\u9f99\u867e", "\u6c49\u5821", "\u725b\u6392", "\u85af\u6761"};

    @NotNull
    private static final String[] PLANT_SUB_TAG = {"\u82b1", "\u6a31\u82b1", "\u76c6\u683d", "\u73ab\u7470", "\u5170\u82b1", "\u4e01\u9999\u82b1", "\u7261\u4e39", "\u767e\u5408\u82b1", "\u591a\u8089", "\u8377\u82b1", "\u90c1\u91d1\u9999", "\u5411\u65e5\u8475", "\u71d5\u8863\u8349", "\u6708\u5b63", "\u7d2b\u7f57\u5170"};

    @NotNull
    private static final String[] ANIMAL_SUB_TAG = {"\u5927\u8c61", "\u5154\u5b50", "\u8774\u8776", "\u957f\u9888\u9e7f", "\u677e\u9f20", "\u7f8a", "\u7f8a\u9a7c", "\u9e2d\u5b50", "\u9e66\u9e49", "\u677e\u8ddf", "\u8003\u62c9", "\u6d63\u718a", "\u6d77\u72ee", "\u9cc4\u9c7c", "\u725b", "\u86c7\u7c7b", "\u5b54\u6211", "\u7334\u5b50", "\u9e21", "\u72d0\u72f8", "\u6d77\u8c5a", "\u888b\u9f20", "\u9e35\u9e1f", "\u5317\u6781\u80fd", "\u8c79\u5b50", "\u72ee\u5b50", "\u9e1f\u7c7b", "\u9a6c", "\u4ed3\u9f20", "\u4f01\u9e45", "\u718a", "\u718a\u732b", "\u8725\u8734", "\u8001\u864e", "\u86d9"};

    @NotNull
    private static final String[] PET_SUB_TAG = {"\u732b", "\u72d7"};

    RFWResearchClassifyUtils() {
    }

    public static /* synthetic */ Pair getQueryInfoByTags$default(RFWResearchClassifyUtils rFWResearchClassifyUtils, String[] strArr, String[] strArr2, float f16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            f16 = 0.0f;
        }
        return rFWResearchClassifyUtils.getQueryInfoByTags(strArr, strArr2, f16);
    }

    @NotNull
    public final String[] getARCHITECTURE_SUB_TAGS() {
        return ARCHITECTURE_SUB_TAGS;
    }

    @NotNull
    public final String getBabySelectMsg(@NotNull RecommendContext context) {
        Integer intOrNull;
        int i3;
        Intrinsics.checkNotNullParameter(context, "context");
        intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(RFWRecommendUtil.INSTANCE.getClassifyConfig(context, "face_proportion_min"));
        if (intOrNull != null) {
            i3 = intOrNull.intValue();
        } else {
            i3 = 10;
        }
        return " mFaceSize=1 and (mFaceRatio1 >= " + i3 + " or mFaceRatio2 >= " + i3 + " or mFaceRatio3 >= " + i3 + " or mFaceRatio4 >= " + i3 + ") and ((mFaceAge1>=0 and mFaceAge1<=8) or (mFaceAge2>=0 and mFaceAge2<=8) or (mFaceAge3>=0 and mFaceAge3<=8) or (mFaceAge4>=0 and mFaceAge4<=8))";
    }

    @NotNull
    public final String[] getFOOD_SUB_TAG() {
        return FOOD_SUB_TAG;
    }

    @NotNull
    public final String[] getLANDSCAPE_SUB_TAG() {
        return LANDSCAPE_SUB_TAG;
    }

    @NotNull
    public final String[] getLIFE_FOOD() {
        return LIFE_FOOD;
    }

    @NotNull
    public final String[] getPET_SUB_TAG() {
        return PET_SUB_TAG;
    }

    @NotNull
    public final Pair<String, String[]> getQueryInfoByTags(@NotNull String[] tagArray, @Nullable String[] subTagArray, float minTagScore) {
        boolean z16;
        Intrinsics.checkNotNullParameter(tagArray, "tagArray");
        ArrayList arrayList = new ArrayList();
        int length = tagArray.length;
        String str = "";
        int i3 = 0;
        int i16 = 0;
        while (i3 < length) {
            String str2 = tagArray[i3];
            int i17 = i16 + 1;
            if (i16 == 0) {
                str = ((Object) str) + "(";
            }
            String str3 = ((Object) str) + " mTagType=? ";
            arrayList.add(str2);
            if (i16 == tagArray.length - 1) {
                str = ((Object) str3) + ")";
            } else {
                str = ((Object) str3) + "or";
            }
            i3++;
            i16 = i17;
        }
        if (subTagArray != null) {
            if (subTagArray.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                int length2 = subTagArray.length;
                str = ((Object) str) + " and ";
                int i18 = 0;
                int i19 = 0;
                while (i18 < length2) {
                    String str4 = subTagArray[i18];
                    int i26 = i19 + 1;
                    if (i19 == 0) {
                        str = ((Object) str) + "(";
                    }
                    arrayList.add(str4);
                    String str5 = ((Object) str) + " mTagSubType=? ";
                    if (i19 == subTagArray.length - 1) {
                        str = ((Object) str5) + ")";
                    } else {
                        str = ((Object) str5) + "or";
                    }
                    i18++;
                    i19 = i26;
                }
            }
        }
        Object[] array = arrayList.toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return new Pair<>(str, array);
    }
}
