package com.tencent.bugly.common.meta;

import android.content.SharedPreferences;
import com.heytap.mcssdk.a.a;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.bugly.common.privacy.PrivacyInformation;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.bugly.common.reporter.builder.UniqueIDHelper;
import com.tencent.bugly.common.utils.StringUtil;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001Bc\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\rJ\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\tH\u00c6\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\tH\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0003H\u00c6\u0003Jg\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0006\u0010\u001f\u001a\u00020\u0003J\u0006\u0010 \u001a\u00020\u0003J\t\u0010!\u001a\u00020\"H\u00d6\u0001J\u0010\u0010#\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0000H\u0002J\u0010\u0010$\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0000H\u0002J\u0010\u0010%\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0000H\u0002J\u0010\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0003J\u000e\u0010)\u001a\u00020'2\u0006\u0010\u000f\u001a\u00020\u0003J\u0006\u0010*\u001a\u00020\u0003J\t\u0010+\u001a\u00020\u0003H\u00d6\u0001R\u0012\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006,"}, d2 = {"Lcom/tencent/bugly/common/meta/UserMeta;", "", "uin", "", "buildNumber", a.f36102l, "appId", "appVersion", "sharePreference", "Landroid/content/SharedPreferences;", "crashSharedPreferences", "sdkVersion", "appVersionMode", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/content/SharedPreferences;Landroid/content/SharedPreferences;Ljava/lang/String;Ljava/lang/String;)V", "model", "uniqueID", "uniqueIDHelper", "Lcom/tencent/bugly/common/reporter/builder/UniqueIDHelper;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "getModel", "getUniqueID", "hashCode", "", "isSameProduct", "isSameUser", "isSameVersion", "setModel", "", "value", "setUniqueID", "toJSON", "toString", "bugly-common_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes5.dex */
public final /* data */ class UserMeta {

    @JvmField
    @NotNull
    public String appId;

    @JvmField
    @NotNull
    public String appKey;

    @JvmField
    @NotNull
    public String appVersion;

    @JvmField
    @NotNull
    public String appVersionMode;

    @JvmField
    @NotNull
    public String buildNumber;

    @JvmField
    @Nullable
    public SharedPreferences crashSharedPreferences;
    private String model;

    @JvmField
    @NotNull
    public String sdkVersion;

    @JvmField
    @Nullable
    public SharedPreferences sharePreference;

    @JvmField
    @NotNull
    public String uin;
    private String uniqueID;
    private final UniqueIDHelper uniqueIDHelper;

    public UserMeta() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    private final boolean isSameProduct(UserMeta other) {
        if (Intrinsics.areEqual(this.appId, other.appId) && Intrinsics.areEqual(this.appKey, other.appKey)) {
            return true;
        }
        return false;
    }

    private final boolean isSameUser(UserMeta other) {
        if (Intrinsics.areEqual(this.uin, other.uin) && Intrinsics.areEqual(getUniqueID(), other.getUniqueID()) && Intrinsics.areEqual(this.model, other.model)) {
            return true;
        }
        return false;
    }

    private final boolean isSameVersion(UserMeta other) {
        if (Intrinsics.areEqual(this.appVersion, other.appVersion) && Intrinsics.areEqual(this.sdkVersion, other.sdkVersion) && Intrinsics.areEqual(this.appVersionMode, other.appVersionMode) && Intrinsics.areEqual(this.buildNumber, other.buildNumber)) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getUin() {
        return this.uin;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getBuildNumber() {
        return this.buildNumber;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getAppKey() {
        return this.appKey;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getAppId() {
        return this.appId;
    }

    @NotNull
    /* renamed from: component5, reason: from getter */
    public final String getAppVersion() {
        return this.appVersion;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final SharedPreferences getSharePreference() {
        return this.sharePreference;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final SharedPreferences getCrashSharedPreferences() {
        return this.crashSharedPreferences;
    }

    @NotNull
    /* renamed from: component8, reason: from getter */
    public final String getSdkVersion() {
        return this.sdkVersion;
    }

    @NotNull
    /* renamed from: component9, reason: from getter */
    public final String getAppVersionMode() {
        return this.appVersionMode;
    }

    @NotNull
    public final UserMeta copy(@NotNull String uin, @NotNull String buildNumber, @NotNull String appKey, @NotNull String appId, @NotNull String appVersion, @Nullable SharedPreferences sharePreference, @Nullable SharedPreferences crashSharedPreferences, @NotNull String sdkVersion, @NotNull String appVersionMode) {
        Intrinsics.checkParameterIsNotNull(uin, "uin");
        Intrinsics.checkParameterIsNotNull(buildNumber, "buildNumber");
        Intrinsics.checkParameterIsNotNull(appKey, "appKey");
        Intrinsics.checkParameterIsNotNull(appId, "appId");
        Intrinsics.checkParameterIsNotNull(appVersion, "appVersion");
        Intrinsics.checkParameterIsNotNull(sdkVersion, "sdkVersion");
        Intrinsics.checkParameterIsNotNull(appVersionMode, "appVersionMode");
        return new UserMeta(uin, buildNumber, appKey, appId, appVersion, sharePreference, crashSharedPreferences, sdkVersion, appVersionMode);
    }

    public boolean equals(@Nullable Object other) {
        boolean z16;
        if (!(other instanceof UserMeta)) {
            return false;
        }
        if (this == other) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!Intrinsics.areEqual(other, Boolean.valueOf(z16))) {
            UserMeta userMeta = (UserMeta) other;
            if (!isSameProduct(userMeta) || !isSameVersion(userMeta) || !isSameUser(userMeta)) {
                return false;
            }
        }
        return true;
    }

    @NotNull
    public final String getModel() {
        return this.model;
    }

    @NotNull
    public final String getUniqueID() {
        String realUniqueID = this.uniqueIDHelper.getUniqueID(this.uniqueID, this.sharePreference, this.crashSharedPreferences);
        this.uniqueIDHelper.updateLastUniqueID(realUniqueID, this.sharePreference, this.crashSharedPreferences);
        Intrinsics.checkExpressionValueIsNotNull(realUniqueID, "realUniqueID");
        return realUniqueID;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        int i27;
        int i28;
        String str = this.uin;
        int i29 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i36 = i3 * 31;
        String str2 = this.buildNumber;
        if (str2 != null) {
            i16 = str2.hashCode();
        } else {
            i16 = 0;
        }
        int i37 = (i36 + i16) * 31;
        String str3 = this.appKey;
        if (str3 != null) {
            i17 = str3.hashCode();
        } else {
            i17 = 0;
        }
        int i38 = (i37 + i17) * 31;
        String str4 = this.appId;
        if (str4 != null) {
            i18 = str4.hashCode();
        } else {
            i18 = 0;
        }
        int i39 = (i38 + i18) * 31;
        String str5 = this.appVersion;
        if (str5 != null) {
            i19 = str5.hashCode();
        } else {
            i19 = 0;
        }
        int i46 = (i39 + i19) * 31;
        SharedPreferences sharedPreferences = this.sharePreference;
        if (sharedPreferences != null) {
            i26 = sharedPreferences.hashCode();
        } else {
            i26 = 0;
        }
        int i47 = (i46 + i26) * 31;
        SharedPreferences sharedPreferences2 = this.crashSharedPreferences;
        if (sharedPreferences2 != null) {
            i27 = sharedPreferences2.hashCode();
        } else {
            i27 = 0;
        }
        int i48 = (i47 + i27) * 31;
        String str6 = this.sdkVersion;
        if (str6 != null) {
            i28 = str6.hashCode();
        } else {
            i28 = 0;
        }
        int i49 = (i48 + i28) * 31;
        String str7 = this.appVersionMode;
        if (str7 != null) {
            i29 = str7.hashCode();
        }
        return i49 + i29;
    }

    public final void setModel(@Nullable String value) {
        boolean z16;
        if (value != null) {
            if (value.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                this.model = value;
            }
        }
    }

    public final void setUniqueID(@NotNull String uniqueID) {
        Intrinsics.checkParameterIsNotNull(uniqueID, "uniqueID");
        this.uniqueID = uniqueID;
    }

    @NotNull
    public final String toJSON() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("uin", this.uin);
            jSONObject.put("rdmuuid", this.buildNumber);
            jSONObject.put("app_key", this.appKey);
            jSONObject.put("p_id", this.appId);
            jSONObject.put("version", this.appVersion);
            jSONObject.put("deviceid", getUniqueID());
            jSONObject.put(HiAnalyticsConstant.BI_KEY_SDK_VER, this.sdkVersion);
            PrivacyInformation privacyInformation = PrivacyInformation.getInstance();
            Intrinsics.checkExpressionValueIsNotNull(privacyInformation, "PrivacyInformation.getInstance()");
            jSONObject.put("os", privacyInformation.getOSVersion());
            PrivacyInformation privacyInformation2 = PrivacyInformation.getInstance();
            Intrinsics.checkExpressionValueIsNotNull(privacyInformation2, "PrivacyInformation.getInstance()");
            jSONObject.put("manu", privacyInformation2.getManufacture());
            PrivacyInformation privacyInformation3 = PrivacyInformation.getInstance();
            Intrinsics.checkExpressionValueIsNotNull(privacyInformation3, "PrivacyInformation.getInstance()");
            String model = privacyInformation3.getModel();
            Intrinsics.checkExpressionValueIsNotNull(model, "PrivacyInformation.getInstance().model");
            jSONObject.put("device", StringUtil.encode(model));
            jSONObject.put("api_ver", "1");
            jSONObject.put("plugin_ver", "1");
            jSONObject.put("abfactor", "0");
            jSONObject.put(ReportDataBuilder.KEY_APP_VERSION_MODE, this.appVersionMode);
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkExpressionValueIsNotNull(jSONObject2, "jsonObject.toString()");
            return jSONObject2;
        } catch (Throwable unused) {
            return "";
        }
    }

    @NotNull
    public String toString() {
        return "UserMeta(uin=" + this.uin + ", buildNumber=" + this.buildNumber + ", appKey=" + this.appKey + ", appId=" + this.appId + ", appVersion=" + this.appVersion + ", sharePreference=" + this.sharePreference + ", crashSharedPreferences=" + this.crashSharedPreferences + ", sdkVersion=" + this.sdkVersion + ", appVersionMode=" + this.appVersionMode + ")";
    }

    public UserMeta(@NotNull String uin, @NotNull String buildNumber, @NotNull String appKey, @NotNull String appId, @NotNull String appVersion, @Nullable SharedPreferences sharedPreferences, @Nullable SharedPreferences sharedPreferences2, @NotNull String sdkVersion, @NotNull String appVersionMode) {
        Intrinsics.checkParameterIsNotNull(uin, "uin");
        Intrinsics.checkParameterIsNotNull(buildNumber, "buildNumber");
        Intrinsics.checkParameterIsNotNull(appKey, "appKey");
        Intrinsics.checkParameterIsNotNull(appId, "appId");
        Intrinsics.checkParameterIsNotNull(appVersion, "appVersion");
        Intrinsics.checkParameterIsNotNull(sdkVersion, "sdkVersion");
        Intrinsics.checkParameterIsNotNull(appVersionMode, "appVersionMode");
        this.uin = uin;
        this.buildNumber = buildNumber;
        this.appKey = appKey;
        this.appId = appId;
        this.appVersion = appVersion;
        this.sharePreference = sharedPreferences;
        this.crashSharedPreferences = sharedPreferences2;
        this.sdkVersion = sdkVersion;
        this.appVersionMode = appVersionMode;
        this.model = "unknown";
        this.uniqueID = "";
        this.uniqueIDHelper = new UniqueIDHelper();
    }

    public /* synthetic */ UserMeta(String str, String str2, String str3, String str4, String str5, SharedPreferences sharedPreferences, SharedPreferences sharedPreferences2, String str6, String str7, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? "" : str3, (i3 & 8) != 0 ? "" : str4, (i3 & 16) == 0 ? str5 : "", (i3 & 32) != 0 ? null : sharedPreferences, (i3 & 64) == 0 ? sharedPreferences2 : null, (i3 & 128) != 0 ? "4.4.3" : str6, (i3 & 256) != 0 ? "Unknown" : str7);
    }
}
