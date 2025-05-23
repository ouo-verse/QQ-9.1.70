package p93;

import android.net.Uri;
import com.tencent.mobileqq.winkpublish.model.PromotionParams;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\"\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\"\u0010\t\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\"\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0005J,\u0010\u0012\u001a\u0004\u0018\u00010\u00072\"\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u000fj\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010`\u0011J\u000e\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u0005\u00a8\u0006\u0018"}, d2 = {"Lp93/a;", "", "", "recallSource", "businessType", "Lorg/json/JSONObject;", "jsonData", "Lcom/tencent/mobileqq/winkpublish/model/PromotionParams;", "f", "g", h.F, "Landroid/net/Uri;", "jumpUri", "schemaData", "d", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "e", "b", "c", "a", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f425806a = new a();

    a() {
    }

    private final PromotionParams f(int recallSource, int businessType, JSONObject jsonData) {
        boolean z16;
        Integer intOrNull;
        int i3;
        Integer intOrNull2;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        if (jsonData.has("promotion_task_id") && jsonData.has("promotion_task_name")) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            QLog.e("PromotionParamsParser", 1, "jsonData is not a valid default promotion data.");
            return null;
        }
        String taskId = jsonData.optString("promotion_task_id");
        String taskName = jsonData.optString("promotion_task_name");
        String coverUrl = jsonData.optString("promotion_cover_url");
        long optLong = jsonData.optLong("promotion_task_end_time", Long.MAX_VALUE);
        String reportId = jsonData.optString("promotion_report_id", taskId);
        String optString = jsonData.optString("promotion_recall_source");
        Intrinsics.checkNotNullExpressionValue(optString, "jsonData.optString(PROMOTION_RECALL_SOURCE)");
        intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(optString);
        if (intOrNull != null) {
            i3 = intOrNull.intValue();
        } else {
            i3 = -1;
        }
        String optString2 = jsonData.optString("promotion_business_type");
        Intrinsics.checkNotNullExpressionValue(optString2, "jsonData.optString(PROMOTION_BUSINESS_TYPE)");
        intOrNull2 = StringsKt__StringNumberConversionsKt.toIntOrNull(optString2);
        if (intOrNull2 != null) {
            i17 = intOrNull2.intValue();
            i16 = recallSource;
        } else {
            i16 = recallSource;
            i17 = -1;
        }
        if (i16 != -1) {
            i19 = businessType;
            i18 = i16;
        } else {
            i18 = i3;
            i19 = businessType;
        }
        if (i19 != -1) {
            i26 = i19;
        } else {
            i26 = i17;
        }
        Intrinsics.checkNotNullExpressionValue(taskId, "taskId");
        Intrinsics.checkNotNullExpressionValue(taskName, "taskName");
        Intrinsics.checkNotNullExpressionValue(reportId, "reportId");
        Intrinsics.checkNotNullExpressionValue(coverUrl, "coverUrl");
        return new PromotionParams(taskId, taskName, optLong, reportId, coverUrl, null, null, i18, i26, 96, null);
    }

    private final PromotionParams g(int recallSource, int businessType, JSONObject jsonData) {
        boolean z16;
        if (jsonData.has("spu_id") && jsonData.has("title")) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            QLog.e("PromotionParamsParser", 1, "jsonData is not a valid shop goods promotion data.");
            return null;
        }
        String goodsId = jsonData.optString("spu_id");
        String goodsName = jsonData.optString("title");
        Intrinsics.checkNotNullExpressionValue(goodsId, "goodsId");
        Intrinsics.checkNotNullExpressionValue(goodsName, "goodsName");
        return new PromotionParams(goodsId, goodsName, 0L, goodsId, null, null, null, recallSource, businessType, 116, null);
    }

    private final PromotionParams h(int recallSource, int businessType, JSONObject jsonData) {
        boolean z16;
        int i3;
        if (jsonData.has("media_product_id") && jsonData.has("title")) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            QLog.e("PromotionParamsParser", 1, "jsonData is not a valid saas goods promotion data.");
            return null;
        }
        String goodsId = jsonData.optString("media_product_id");
        String goodsName = jsonData.optString("title");
        String saasProductType = jsonData.optString("saas_product_id");
        String platformType = jsonData.optString("saas_type_str");
        int optInt = jsonData.optInt("goods_type");
        Intrinsics.checkNotNullExpressionValue(goodsId, "goodsId");
        Intrinsics.checkNotNullExpressionValue(goodsName, "goodsName");
        Intrinsics.checkNotNullExpressionValue(platformType, "platformType");
        Intrinsics.checkNotNullExpressionValue(saasProductType, "saasProductType");
        if (businessType != -1) {
            i3 = businessType;
        } else {
            i3 = optInt;
        }
        return new PromotionParams(goodsId, goodsName, 0L, goodsId, null, platformType, saasProductType, recallSource, i3, 20, null);
    }

    @NotNull
    public final String a(@NotNull JSONObject jsonData) {
        Intrinsics.checkNotNullParameter(jsonData, "jsonData");
        String optString = jsonData.optString("promotion_cover_url");
        Intrinsics.checkNotNullExpressionValue(optString, "jsonData.optString(PROMOTION_COVER_URL)");
        return optString;
    }

    @NotNull
    public final String b(@NotNull JSONObject jsonData) {
        Intrinsics.checkNotNullParameter(jsonData, "jsonData");
        String optString = jsonData.optString("promotion_task_id");
        Intrinsics.checkNotNullExpressionValue(optString, "jsonData.optString(PROMOTION_TASK_ID)");
        return optString;
    }

    @NotNull
    public final String c(@NotNull JSONObject jsonData) {
        Intrinsics.checkNotNullParameter(jsonData, "jsonData");
        String optString = jsonData.optString("promotion_task_name");
        Intrinsics.checkNotNullExpressionValue(optString, "jsonData.optString(PROMOTION_TASK_NAME)");
        return optString;
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0016, code lost:
    
        r0 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
    
        r2 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r2);
     */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final PromotionParams d(@NotNull Uri jumpUri, @NotNull JSONObject schemaData) {
        int i3;
        int i16;
        Integer intOrNull;
        Integer intOrNull2;
        Intrinsics.checkNotNullParameter(jumpUri, "jumpUri");
        Intrinsics.checkNotNullParameter(schemaData, "schemaData");
        String queryParameter = jumpUri.getQueryParameter("promotion_recall_source");
        int i17 = -1;
        if (queryParameter != null && intOrNull2 != null) {
            i3 = intOrNull2.intValue();
        } else {
            i3 = -1;
        }
        String queryParameter2 = jumpUri.getQueryParameter("promotion_business_type");
        if (queryParameter2 != null && intOrNull != null) {
            i16 = intOrNull.intValue();
        } else {
            i16 = -1;
        }
        String queryParameter3 = jumpUri.getQueryParameter("target");
        if (queryParameter3 != null) {
            i17 = Integer.parseInt(queryParameter3);
        }
        if (i17 != 7) {
            if (i17 != 21 && i17 != 45) {
                return f(i3, i16, schemaData);
            }
            return g(i3, i16, schemaData);
        }
        return h(i3, i16, schemaData);
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0012, code lost:
    
        r0 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0029, code lost:
    
        r2 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r2);
     */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final PromotionParams e(@NotNull HashMap<String, String> schemaData) {
        int i3;
        Integer intOrNull;
        Integer intOrNull2;
        Intrinsics.checkNotNullParameter(schemaData, "schemaData");
        String str = schemaData.get("promotion_recall_source");
        int i16 = -1;
        if (str != null && intOrNull2 != null) {
            i3 = intOrNull2.intValue();
        } else {
            i3 = -1;
        }
        String str2 = schemaData.get("promotion_business_type");
        if (str2 != null && intOrNull != null) {
            i16 = intOrNull.intValue();
        }
        JSONObject jSONObject = new JSONObject();
        for (String str3 : schemaData.keySet()) {
            jSONObject.put(str3, schemaData.get(str3));
        }
        return f(i3, i16, jSONObject);
    }
}
