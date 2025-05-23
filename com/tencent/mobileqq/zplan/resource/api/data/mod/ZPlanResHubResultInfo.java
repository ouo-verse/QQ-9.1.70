package com.tencent.mobileqq.zplan.resource.api.data.mod;

import android.text.TextUtils;
import com.heytap.mcssdk.a.a;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.zootopia.data.ZootopiaEnterParams;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u001a\b\u0086\b\u0018\u0000 32\u00020\u0001:\u00014Ba\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0004\b1\u00102J\u0006\u0010\u0003\u001a\u00020\u0002J\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003Ji\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001J\t\u0010\u0018\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u001a\u001a\u00020\u0019H\u00d6\u0001J\u0013\u0010\u001d\u001a\u00020\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u00d6\u0003R$\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u001e\u001a\u0004\b#\u0010 \"\u0004\b$\u0010\"R$\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b%\u0010 \"\u0004\b&\u0010\"R$\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u001e\u001a\u0004\b'\u0010 \"\u0004\b(\u0010\"R$\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u001e\u001a\u0004\b)\u0010 \"\u0004\b*\u0010\"R$\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u001e\u001a\u0004\b+\u0010 \"\u0004\b,\u0010\"R$\u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u001e\u001a\u0004\b-\u0010 \"\u0004\b.\u0010\"R$\u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u001e\u001a\u0004\b/\u0010 \"\u0004\b0\u0010\"\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/zplan/resource/api/data/mod/ZPlanResHubResultInfo;", "Ljava/io/Serializable;", "", AppConstants.Key.COLUMN_IS_VALID, "", "", "convertToModEnterParams", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "resHubExtraDesc", "resHubLocalPath", "resHubOriginalPath", "modMainPakVersion", "appId", a.f36102l, MosaicConstants$JsProperty.PROP_ENV, "resId", "copy", "toString", "", "hashCode", "", "other", "equals", "Ljava/lang/String;", "getResHubExtraDesc", "()Ljava/lang/String;", "setResHubExtraDesc", "(Ljava/lang/String;)V", "getResHubLocalPath", "setResHubLocalPath", "getResHubOriginalPath", "setResHubOriginalPath", "getModMainPakVersion", "setModMainPakVersion", "getAppId", "setAppId", "getAppKey", "setAppKey", "getEnv", "setEnv", "getResId", "setResId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final /* data */ class ZPlanResHubResultInfo implements Serializable {
    private String appId;
    private String appKey;
    private String env;
    private String modMainPakVersion;
    private String resHubExtraDesc;
    private String resHubLocalPath;
    private String resHubOriginalPath;
    private String resId;

    public ZPlanResHubResultInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.resHubExtraDesc = str;
        this.resHubLocalPath = str2;
        this.resHubOriginalPath = str3;
        this.modMainPakVersion = str4;
        this.appId = str5;
        this.appKey = str6;
        this.env = str7;
        this.resId = str8;
    }

    /* renamed from: component1, reason: from getter */
    public final String getResHubExtraDesc() {
        return this.resHubExtraDesc;
    }

    /* renamed from: component2, reason: from getter */
    public final String getResHubLocalPath() {
        return this.resHubLocalPath;
    }

    /* renamed from: component3, reason: from getter */
    public final String getResHubOriginalPath() {
        return this.resHubOriginalPath;
    }

    /* renamed from: component4, reason: from getter */
    public final String getModMainPakVersion() {
        return this.modMainPakVersion;
    }

    /* renamed from: component5, reason: from getter */
    public final String getAppId() {
        return this.appId;
    }

    /* renamed from: component6, reason: from getter */
    public final String getAppKey() {
        return this.appKey;
    }

    /* renamed from: component7, reason: from getter */
    public final String getEnv() {
        return this.env;
    }

    /* renamed from: component8, reason: from getter */
    public final String getResId() {
        return this.resId;
    }

    public final Map<String, String> convertToModEnterParams() {
        HashMap hashMap = new HashMap();
        String str = this.resHubLocalPath;
        String str2 = "";
        if (str == null) {
            str = "";
        }
        hashMap.put(ZootopiaEnterParams.KEY_HOT_PATCH_FOLDER, str);
        if (!TextUtils.isEmpty(this.resHubExtraDesc)) {
            try {
                String str3 = this.resHubExtraDesc;
                if (str3 == null) {
                    str3 = "";
                }
                str2 = new JSONObject(str3).optString("ver");
            } catch (Exception e16) {
                QLog.e("ZPlanResHubResultInfo", 1, "convertToModEnterParams error", e16);
            }
        }
        Intrinsics.checkNotNullExpressionValue(str2, "if (!TextUtils.isEmpty(r\u2026      }\n        } else \"\"");
        hashMap.put(ZootopiaEnterParams.KEY_HOT_PATCH_VERSION, str2);
        return hashMap;
    }

    public final ZPlanResHubResultInfo copy(String resHubExtraDesc, String resHubLocalPath, String resHubOriginalPath, String modMainPakVersion, String appId, String appKey, String env, String resId) {
        return new ZPlanResHubResultInfo(resHubExtraDesc, resHubLocalPath, resHubOriginalPath, modMainPakVersion, appId, appKey, env, resId);
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getAppKey() {
        return this.appKey;
    }

    public final String getEnv() {
        return this.env;
    }

    public final String getModMainPakVersion() {
        return this.modMainPakVersion;
    }

    public final String getResHubExtraDesc() {
        return this.resHubExtraDesc;
    }

    public final String getResHubLocalPath() {
        return this.resHubLocalPath;
    }

    public final String getResHubOriginalPath() {
        return this.resHubOriginalPath;
    }

    public final String getResId() {
        return this.resId;
    }

    public int hashCode() {
        String str = this.resHubExtraDesc;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.resHubLocalPath;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.resHubOriginalPath;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.modMainPakVersion;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.appId;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.appKey;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.env;
        int hashCode7 = (hashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.resId;
        return hashCode7 + (str8 != null ? str8.hashCode() : 0);
    }

    public final boolean isValid() {
        return (TextUtils.isEmpty(this.resHubExtraDesc) && TextUtils.isEmpty(this.resHubLocalPath)) ? false : true;
    }

    public final void setAppId(String str) {
        this.appId = str;
    }

    public final void setAppKey(String str) {
        this.appKey = str;
    }

    public final void setEnv(String str) {
        this.env = str;
    }

    public final void setModMainPakVersion(String str) {
        this.modMainPakVersion = str;
    }

    public final void setResHubExtraDesc(String str) {
        this.resHubExtraDesc = str;
    }

    public final void setResHubLocalPath(String str) {
        this.resHubLocalPath = str;
    }

    public final void setResHubOriginalPath(String str) {
        this.resHubOriginalPath = str;
    }

    public final void setResId(String str) {
        this.resId = str;
    }

    public String toString() {
        return "ZPlanResHubResultInfo(resHubExtraDesc=" + this.resHubExtraDesc + ", resHubLocalPath=" + this.resHubLocalPath + ", resHubOriginalPath=" + this.resHubOriginalPath + ", modMainPakVersion=" + this.modMainPakVersion + ", appId=" + this.appId + ", appKey=" + this.appKey + ", env=" + this.env + ", resId=" + this.resId + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZPlanResHubResultInfo)) {
            return false;
        }
        ZPlanResHubResultInfo zPlanResHubResultInfo = (ZPlanResHubResultInfo) other;
        return Intrinsics.areEqual(this.resHubExtraDesc, zPlanResHubResultInfo.resHubExtraDesc) && Intrinsics.areEqual(this.resHubLocalPath, zPlanResHubResultInfo.resHubLocalPath) && Intrinsics.areEqual(this.resHubOriginalPath, zPlanResHubResultInfo.resHubOriginalPath) && Intrinsics.areEqual(this.modMainPakVersion, zPlanResHubResultInfo.modMainPakVersion) && Intrinsics.areEqual(this.appId, zPlanResHubResultInfo.appId) && Intrinsics.areEqual(this.appKey, zPlanResHubResultInfo.appKey) && Intrinsics.areEqual(this.env, zPlanResHubResultInfo.env) && Intrinsics.areEqual(this.resId, zPlanResHubResultInfo.resId);
    }

    public /* synthetic */ ZPlanResHubResultInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i3 & 8) != 0 ? null : str4, (i3 & 16) != 0 ? "" : str5, (i3 & 32) != 0 ? "" : str6, (i3 & 64) != 0 ? "" : str7, (i3 & 128) != 0 ? "" : str8);
    }
}
