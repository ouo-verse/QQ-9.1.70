package com.tencent.mobileqq.winkpublish.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qqecommerce.biz.sdk.api.IQQECommerceSdk;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkpublish.model.params.PromotionPublishParams;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\b\u0018\u0000 52\u00020\u0001:\u00015B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004BU\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u00a2\u0006\u0002\u0010\u0011J\t\u0010\u001e\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0006H\u00c6\u0003J\t\u0010 \u001a\u00020\tH\u00c6\u0003J\t\u0010!\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\"\u001a\u00020\u0006H\u00c6\u0003J\t\u0010#\u001a\u00020\u0006H\u00c6\u0003J\t\u0010$\u001a\u00020\u0006H\u00c6\u0003J\t\u0010%\u001a\u00020\u000fH\u00c6\u0003J\t\u0010&\u001a\u00020\u000fH\u00c6\u0003Jc\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000fH\u00c6\u0001J\u0006\u0010(\u001a\u00020)J\b\u0010*\u001a\u00020\u000fH\u0016J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.H\u00d6\u0003J\t\u0010/\u001a\u00020\u000fH\u00d6\u0001J\b\u00100\u001a\u00020\u0006H\u0016J\u0018\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u000fH\u0016R\u0011\u0010\u0010\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u000b\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0011\u0010\f\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0011\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0011\u0010\n\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u0011\u0010\r\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0015\u00a8\u00066"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/model/PromotionParams;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "name", "endTimeMs", "", PromotionParams.JSON_KEY_REPORT_ID, "coverUrl", "platformType", "saasProductId", "recallSource", "", "businessType", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V", "getBusinessType", "()I", "getCoverUrl", "()Ljava/lang/String;", "getEndTimeMs", "()J", "getId", "getName", "getPlatformType", "getRecallSource", "getReportId", "getSaasProductId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "covertToPublishParams", "Lcom/tencent/mobileqq/winkpublish/model/params/PromotionPublishParams;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", WadlProxyConsts.FLAGS, "Companion", "qq-winkpublish-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final /* data */ class PromotionParams implements Parcelable {

    @NotNull
    private static final String JSON_KEY_BUSINESS_TYPE = "business_type";

    @NotNull
    private static final String JSON_KEY_COVER_URL = "cover_url";

    @NotNull
    private static final String JSON_KEY_END_TIME = "endTime";

    @NotNull
    private static final String JSON_KEY_ID = "id";

    @NotNull
    private static final String JSON_KEY_NAME = "name";

    @NotNull
    private static final String JSON_KEY_PLATFORM_TYPE = "platform_type";

    @NotNull
    private static final String JSON_KEY_RECALL_SOURCE = "recall_source";

    @NotNull
    private static final String JSON_KEY_REPORT_ID = "reportId";

    @NotNull
    private static final String JSON_KEY_SAAS_PRODUCT_ID = "saas_product_id";

    @NotNull
    private static final String TAG = "PromotionParams";
    private final int businessType;

    @NotNull
    private final String coverUrl;
    private final long endTimeMs;

    @NotNull
    private final String id;

    @NotNull
    private final String name;

    @NotNull
    private final String platformType;
    private final int recallSource;

    @NotNull
    private final String reportId;

    @NotNull
    private final String saasProductId;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @JvmField
    @NotNull
    public static final Parcelable.Creator<PromotionParams> CREATOR = new a();

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0012\u001a\u00020\u0007H\u0007R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/model/PromotionParams$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/winkpublish/model/PromotionParams;", "JSON_KEY_BUSINESS_TYPE", "", "JSON_KEY_COVER_URL", "JSON_KEY_END_TIME", "JSON_KEY_ID", "JSON_KEY_NAME", "JSON_KEY_PLATFORM_TYPE", "JSON_KEY_RECALL_SOURCE", "JSON_KEY_REPORT_ID", "JSON_KEY_SAAS_PRODUCT_ID", "TAG", "revertFromString", "str", "qq-winkpublish-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @Nullable
        public final PromotionParams revertFromString(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "str");
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt(PromotionParams.JSON_KEY_RECALL_SOURCE);
                int optInt2 = jSONObject.optInt(PromotionParams.JSON_KEY_BUSINESS_TYPE);
                if (optInt != 0 && optInt2 != 0) {
                    String optString = jSONObject.optString("id");
                    Intrinsics.checkNotNullExpressionValue(optString, "optString(JSON_KEY_ID)");
                    String optString2 = jSONObject.optString("name");
                    Intrinsics.checkNotNullExpressionValue(optString2, "optString(JSON_KEY_NAME)");
                    long optLong = jSONObject.optLong(PromotionParams.JSON_KEY_END_TIME);
                    String optString3 = jSONObject.optString(PromotionParams.JSON_KEY_REPORT_ID);
                    Intrinsics.checkNotNullExpressionValue(optString3, "optString(JSON_KEY_REPORT_ID)");
                    String optString4 = jSONObject.optString("cover_url");
                    Intrinsics.checkNotNullExpressionValue(optString4, "optString(JSON_KEY_COVER_URL)");
                    String optString5 = jSONObject.optString(PromotionParams.JSON_KEY_PLATFORM_TYPE);
                    Intrinsics.checkNotNullExpressionValue(optString5, "optString(JSON_KEY_PLATFORM_TYPE)");
                    String optString6 = jSONObject.optString(PromotionParams.JSON_KEY_SAAS_PRODUCT_ID);
                    Intrinsics.checkNotNullExpressionValue(optString6, "optString(JSON_KEY_SAAS_PRODUCT_ID)");
                    return new PromotionParams(optString, optString2, optLong, optString3, optString4, optString5, optString6, optInt, optInt2);
                }
                QLog.e(PromotionParams.TAG, 1, "invalid recallSource = " + optInt + ", businessType = " + optInt2);
            } catch (JSONException unused) {
            }
            return null;
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/winkpublish/model/PromotionParams$a", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/winkpublish/model/PromotionParams;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/mobileqq/winkpublish/model/PromotionParams;", "qq-winkpublish-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a implements Parcelable.Creator<PromotionParams> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PromotionParams createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new PromotionParams(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public PromotionParams[] newArray(int size) {
            return new PromotionParams[size];
        }
    }

    public PromotionParams(@NotNull String id5, @NotNull String name, long j3, @NotNull String reportId, @NotNull String coverUrl, @NotNull String platformType, @NotNull String saasProductId, int i3, int i16) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(reportId, "reportId");
        Intrinsics.checkNotNullParameter(coverUrl, "coverUrl");
        Intrinsics.checkNotNullParameter(platformType, "platformType");
        Intrinsics.checkNotNullParameter(saasProductId, "saasProductId");
        this.id = id5;
        this.name = name;
        this.endTimeMs = j3;
        this.reportId = reportId;
        this.coverUrl = coverUrl;
        this.platformType = platformType;
        this.saasProductId = saasProductId;
        this.recallSource = i3;
        this.businessType = i16;
    }

    public static /* synthetic */ PromotionParams copy$default(PromotionParams promotionParams, String str, String str2, long j3, String str3, String str4, String str5, String str6, int i3, int i16, int i17, Object obj) {
        String str7;
        String str8;
        long j16;
        String str9;
        String str10;
        String str11;
        String str12;
        int i18;
        int i19;
        if ((i17 & 1) != 0) {
            str7 = promotionParams.id;
        } else {
            str7 = str;
        }
        if ((i17 & 2) != 0) {
            str8 = promotionParams.name;
        } else {
            str8 = str2;
        }
        if ((i17 & 4) != 0) {
            j16 = promotionParams.endTimeMs;
        } else {
            j16 = j3;
        }
        if ((i17 & 8) != 0) {
            str9 = promotionParams.reportId;
        } else {
            str9 = str3;
        }
        if ((i17 & 16) != 0) {
            str10 = promotionParams.coverUrl;
        } else {
            str10 = str4;
        }
        if ((i17 & 32) != 0) {
            str11 = promotionParams.platformType;
        } else {
            str11 = str5;
        }
        if ((i17 & 64) != 0) {
            str12 = promotionParams.saasProductId;
        } else {
            str12 = str6;
        }
        if ((i17 & 128) != 0) {
            i18 = promotionParams.recallSource;
        } else {
            i18 = i3;
        }
        if ((i17 & 256) != 0) {
            i19 = promotionParams.businessType;
        } else {
            i19 = i16;
        }
        return promotionParams.copy(str7, str8, j16, str9, str10, str11, str12, i18, i19);
    }

    @JvmStatic
    @Nullable
    public static final PromotionParams revertFromString(@NotNull String str) {
        return INSTANCE.revertFromString(str);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final long getEndTimeMs() {
        return this.endTimeMs;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getReportId() {
        return this.reportId;
    }

    @NotNull
    /* renamed from: component5, reason: from getter */
    public final String getCoverUrl() {
        return this.coverUrl;
    }

    @NotNull
    /* renamed from: component6, reason: from getter */
    public final String getPlatformType() {
        return this.platformType;
    }

    @NotNull
    /* renamed from: component7, reason: from getter */
    public final String getSaasProductId() {
        return this.saasProductId;
    }

    /* renamed from: component8, reason: from getter */
    public final int getRecallSource() {
        return this.recallSource;
    }

    /* renamed from: component9, reason: from getter */
    public final int getBusinessType() {
        return this.businessType;
    }

    @NotNull
    public final PromotionParams copy(@NotNull String id5, @NotNull String name, long endTimeMs, @NotNull String reportId, @NotNull String coverUrl, @NotNull String platformType, @NotNull String saasProductId, int recallSource, int businessType) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(reportId, "reportId");
        Intrinsics.checkNotNullParameter(coverUrl, "coverUrl");
        Intrinsics.checkNotNullParameter(platformType, "platformType");
        Intrinsics.checkNotNullParameter(saasProductId, "saasProductId");
        return new PromotionParams(id5, name, endTimeMs, reportId, coverUrl, platformType, saasProductId, recallSource, businessType);
    }

    @NotNull
    public final PromotionPublishParams covertToPublishParams() {
        return new PromotionPublishParams(this.id, this.name, ((IQQECommerceSdk) QRoute.api(IQQECommerceSdk.class)).getContentExtForPublisher(this.name, this.coverUrl, this.recallSource, this.businessType));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PromotionParams)) {
            return false;
        }
        PromotionParams promotionParams = (PromotionParams) other;
        if (Intrinsics.areEqual(this.id, promotionParams.id) && Intrinsics.areEqual(this.name, promotionParams.name) && this.endTimeMs == promotionParams.endTimeMs && Intrinsics.areEqual(this.reportId, promotionParams.reportId) && Intrinsics.areEqual(this.coverUrl, promotionParams.coverUrl) && Intrinsics.areEqual(this.platformType, promotionParams.platformType) && Intrinsics.areEqual(this.saasProductId, promotionParams.saasProductId) && this.recallSource == promotionParams.recallSource && this.businessType == promotionParams.businessType) {
            return true;
        }
        return false;
    }

    public final int getBusinessType() {
        return this.businessType;
    }

    @NotNull
    public final String getCoverUrl() {
        return this.coverUrl;
    }

    public final long getEndTimeMs() {
        return this.endTimeMs;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getPlatformType() {
        return this.platformType;
    }

    public final int getRecallSource() {
        return this.recallSource;
    }

    @NotNull
    public final String getReportId() {
        return this.reportId;
    }

    @NotNull
    public final String getSaasProductId() {
        return this.saasProductId;
    }

    public int hashCode() {
        return (((((((((((((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + androidx.fragment.app.a.a(this.endTimeMs)) * 31) + this.reportId.hashCode()) * 31) + this.coverUrl.hashCode()) * 31) + this.platformType.hashCode()) * 31) + this.saasProductId.hashCode()) * 31) + this.recallSource) * 31) + this.businessType;
    }

    @NotNull
    public String toString() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", this.id);
        jSONObject.put("name", this.name);
        jSONObject.put(JSON_KEY_END_TIME, this.endTimeMs);
        jSONObject.put(JSON_KEY_REPORT_ID, this.reportId);
        jSONObject.put("cover_url", this.coverUrl);
        jSONObject.put(JSON_KEY_PLATFORM_TYPE, this.platformType);
        jSONObject.put(JSON_KEY_SAAS_PRODUCT_ID, this.saasProductId);
        jSONObject.put(JSON_KEY_RECALL_SOURCE, this.recallSource);
        jSONObject.put(JSON_KEY_BUSINESS_TYPE, this.businessType);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply {\n   \u2026ype)\n        }.toString()");
        return jSONObject2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.id);
        dest.writeString(this.name);
        dest.writeLong(this.endTimeMs);
        dest.writeString(this.reportId);
        dest.writeString(this.coverUrl);
        dest.writeString(this.platformType);
        dest.writeString(this.saasProductId);
        dest.writeInt(this.recallSource);
        dest.writeInt(this.businessType);
    }

    public /* synthetic */ PromotionParams(String str, String str2, long j3, String str3, String str4, String str5, String str6, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i17 & 4) != 0 ? Long.MAX_VALUE : j3, str3, (i17 & 16) != 0 ? "" : str4, (i17 & 32) != 0 ? "" : str5, (i17 & 64) != 0 ? "" : str6, i3, i16);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public PromotionParams(@NotNull Parcel parcel) {
        this(r3, r4, r5, r7, r8, r9, r0 == null ? "" : r0, parcel.readInt(), parcel.readInt());
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String readString = parcel.readString();
        String str = readString == null ? "" : readString;
        String readString2 = parcel.readString();
        String str2 = readString2 == null ? "" : readString2;
        long readLong = parcel.readLong();
        String readString3 = parcel.readString();
        String str3 = readString3 == null ? "" : readString3;
        String readString4 = parcel.readString();
        String str4 = readString4 == null ? "" : readString4;
        String readString5 = parcel.readString();
        String str5 = readString5 == null ? "" : readString5;
        String readString6 = parcel.readString();
    }
}
