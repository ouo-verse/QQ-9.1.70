package com.tencent.minibox.contract;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.ark.ark;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.tuxmetersdk.impl.ruleengine.JsonRuleKey;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 62\u00020\u0001:\u00016B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004BU\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\u0006\u0010\u0010\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0011J\t\u0010\u001e\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0006H\u00c6\u0003J\t\u0010 \u001a\u00020\u0006H\u00c6\u0003J\t\u0010!\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\"\u001a\u00020\u0006H\u00c6\u0003J\t\u0010#\u001a\u00020\u0006H\u00c6\u0003J\t\u0010$\u001a\u00020\u0006H\u00c6\u0003J\t\u0010%\u001a\u00020\u0006H\u00c6\u0003J\t\u0010&\u001a\u00020\u000eH\u00c6\u0003J\t\u0010'\u001a\u00020\u0006H\u00c6\u0003Jm\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u0006H\u00c6\u0001J\b\u0010)\u001a\u00020\u000eH\u0016J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-H\u00d6\u0003J\t\u0010.\u001a\u00020\u000eH\u00d6\u0001J\u0006\u0010/\u001a\u000200J\u0006\u00101\u001a\u00020\u0006J\t\u00102\u001a\u00020\u0006H\u00d6\u0001J\u0018\u00103\u001a\u0002042\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00105\u001a\u00020\u000eH\u0016R\u0011\u0010\u000f\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\f\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\n\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\u0010\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0011\u0010\u000b\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d\u00a8\u00067"}, d2 = {"Lcom/tencent/minibox/contract/GameInfo;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", JsonRuleKey.OPERATOR, "", "version", "privacyUrl", "permissionUrl", VirtualAppProxy.KEY_GAME_ID, "packageName", "appName", "versionCode", "", "apkUrl", "iconUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getApkUrl", "()Ljava/lang/String;", "getAppName", "getGameId", "getIconUrl", "getOperator", "getPackageName", "getPermissionUrl", "getPrivacyUrl", "getVersion", "getVersionCode", "()I", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toJSONObject", "Lorg/json/JSONObject;", "toJSONString", "toString", "writeToParcel", "", WadlProxyConsts.FLAGS, "CREATOR", "MiniBoxDynamicApi_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes9.dex */
public final /* data */ class GameInfo implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private final String apkUrl;

    @NotNull
    private final String appName;

    @NotNull
    private final String gameId;

    @NotNull
    private final String iconUrl;

    @NotNull
    private final String operator;

    @NotNull
    private final String packageName;

    @NotNull
    private final String permissionUrl;

    @NotNull
    private final String privacyUrl;

    @NotNull
    private final String version;
    private final int versionCode;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0010\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\fJ\u001d\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016\u00a2\u0006\u0002\u0010\u0011\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/minibox/contract/GameInfo$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/minibox/contract/GameInfo;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "fromJSONObject", ark.ARKMETADATA_JSON, "Lorg/json/JSONObject;", "fromJSONString", "jsonString", "", "newArray", "", "size", "", "(I)[Lcom/tencent/minibox/contract/GameInfo;", "MiniBoxDynamicApi_release"}, k = 1, mv = {1, 1, 16})
    /* renamed from: com.tencent.minibox.contract.GameInfo$CREATOR, reason: from kotlin metadata */
    /* loaded from: classes9.dex */
    public static final class Companion implements Parcelable.Creator<GameInfo> {
        Companion() {
        }

        @Nullable
        public final GameInfo fromJSONObject(@Nullable JSONObject json) {
            if (json != null) {
                String optString = json.optString(JsonRuleKey.OPERATOR);
                Intrinsics.checkExpressionValueIsNotNull(optString, "json.optString(\"operator\")");
                String optString2 = json.optString("version");
                Intrinsics.checkExpressionValueIsNotNull(optString2, "json.optString(\"version\")");
                String optString3 = json.optString("privacyUrl");
                Intrinsics.checkExpressionValueIsNotNull(optString3, "json.optString(\"privacyUrl\")");
                String decodeUrl = InstallDialogDataKt.decodeUrl(optString3);
                String optString4 = json.optString("permissionUrl");
                Intrinsics.checkExpressionValueIsNotNull(optString4, "json.optString(\"permissionUrl\")");
                String decodeUrl2 = InstallDialogDataKt.decodeUrl(optString4);
                String optString5 = json.optString(VirtualAppProxy.KEY_GAME_ID);
                Intrinsics.checkExpressionValueIsNotNull(optString5, "json.optString(\"gameId\")");
                String optString6 = json.optString("packageName");
                Intrinsics.checkExpressionValueIsNotNull(optString6, "json.optString(\"packageName\")");
                String optString7 = json.optString("appName");
                Intrinsics.checkExpressionValueIsNotNull(optString7, "json.optString(\"appName\")");
                int optInt = json.optInt("versionCode");
                String optString8 = json.optString("apkUrl");
                Intrinsics.checkExpressionValueIsNotNull(optString8, "json.optString(\"apkUrl\")");
                String decodeUrl3 = InstallDialogDataKt.decodeUrl(optString8);
                String optString9 = json.optString("iconUrl");
                Intrinsics.checkExpressionValueIsNotNull(optString9, "json.optString(\"iconUrl\")");
                return new GameInfo(optString, optString2, decodeUrl, decodeUrl2, optString5, optString6, optString7, optInt, decodeUrl3, InstallDialogDataKt.decodeUrl(optString9));
            }
            return null;
        }

        @Nullable
        public final GameInfo fromJSONString(@NotNull String jsonString) {
            Intrinsics.checkParameterIsNotNull(jsonString, "jsonString");
            try {
                return fromJSONObject(new JSONObject(jsonString));
            } catch (JSONException unused) {
                return null;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public GameInfo createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "parcel");
            return new GameInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public GameInfo[] newArray(int size) {
            return new GameInfo[size];
        }
    }

    public GameInfo(@NotNull String operator, @NotNull String version, @NotNull String privacyUrl, @NotNull String permissionUrl, @NotNull String gameId, @NotNull String packageName, @NotNull String appName, int i3, @NotNull String apkUrl, @NotNull String iconUrl) {
        Intrinsics.checkParameterIsNotNull(operator, "operator");
        Intrinsics.checkParameterIsNotNull(version, "version");
        Intrinsics.checkParameterIsNotNull(privacyUrl, "privacyUrl");
        Intrinsics.checkParameterIsNotNull(permissionUrl, "permissionUrl");
        Intrinsics.checkParameterIsNotNull(gameId, "gameId");
        Intrinsics.checkParameterIsNotNull(packageName, "packageName");
        Intrinsics.checkParameterIsNotNull(appName, "appName");
        Intrinsics.checkParameterIsNotNull(apkUrl, "apkUrl");
        Intrinsics.checkParameterIsNotNull(iconUrl, "iconUrl");
        this.operator = operator;
        this.version = version;
        this.privacyUrl = privacyUrl;
        this.permissionUrl = permissionUrl;
        this.gameId = gameId;
        this.packageName = packageName;
        this.appName = appName;
        this.versionCode = i3;
        this.apkUrl = apkUrl;
        this.iconUrl = iconUrl;
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getOperator() {
        return this.operator;
    }

    @NotNull
    /* renamed from: component10, reason: from getter */
    public final String getIconUrl() {
        return this.iconUrl;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getPrivacyUrl() {
        return this.privacyUrl;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getPermissionUrl() {
        return this.permissionUrl;
    }

    @NotNull
    /* renamed from: component5, reason: from getter */
    public final String getGameId() {
        return this.gameId;
    }

    @NotNull
    /* renamed from: component6, reason: from getter */
    public final String getPackageName() {
        return this.packageName;
    }

    @NotNull
    /* renamed from: component7, reason: from getter */
    public final String getAppName() {
        return this.appName;
    }

    /* renamed from: component8, reason: from getter */
    public final int getVersionCode() {
        return this.versionCode;
    }

    @NotNull
    /* renamed from: component9, reason: from getter */
    public final String getApkUrl() {
        return this.apkUrl;
    }

    @NotNull
    public final GameInfo copy(@NotNull String operator, @NotNull String version, @NotNull String privacyUrl, @NotNull String permissionUrl, @NotNull String gameId, @NotNull String packageName, @NotNull String appName, int versionCode, @NotNull String apkUrl, @NotNull String iconUrl) {
        Intrinsics.checkParameterIsNotNull(operator, "operator");
        Intrinsics.checkParameterIsNotNull(version, "version");
        Intrinsics.checkParameterIsNotNull(privacyUrl, "privacyUrl");
        Intrinsics.checkParameterIsNotNull(permissionUrl, "permissionUrl");
        Intrinsics.checkParameterIsNotNull(gameId, "gameId");
        Intrinsics.checkParameterIsNotNull(packageName, "packageName");
        Intrinsics.checkParameterIsNotNull(appName, "appName");
        Intrinsics.checkParameterIsNotNull(apkUrl, "apkUrl");
        Intrinsics.checkParameterIsNotNull(iconUrl, "iconUrl");
        return new GameInfo(operator, version, privacyUrl, permissionUrl, gameId, packageName, appName, versionCode, apkUrl, iconUrl);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof GameInfo) {
                GameInfo gameInfo = (GameInfo) other;
                if (!Intrinsics.areEqual(this.operator, gameInfo.operator) || !Intrinsics.areEqual(this.version, gameInfo.version) || !Intrinsics.areEqual(this.privacyUrl, gameInfo.privacyUrl) || !Intrinsics.areEqual(this.permissionUrl, gameInfo.permissionUrl) || !Intrinsics.areEqual(this.gameId, gameInfo.gameId) || !Intrinsics.areEqual(this.packageName, gameInfo.packageName) || !Intrinsics.areEqual(this.appName, gameInfo.appName) || this.versionCode != gameInfo.versionCode || !Intrinsics.areEqual(this.apkUrl, gameInfo.apkUrl) || !Intrinsics.areEqual(this.iconUrl, gameInfo.iconUrl)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @NotNull
    public final String getApkUrl() {
        return this.apkUrl;
    }

    @NotNull
    public final String getAppName() {
        return this.appName;
    }

    @NotNull
    public final String getGameId() {
        return this.gameId;
    }

    @NotNull
    public final String getIconUrl() {
        return this.iconUrl;
    }

    @NotNull
    public final String getOperator() {
        return this.operator;
    }

    @NotNull
    public final String getPackageName() {
        return this.packageName;
    }

    @NotNull
    public final String getPermissionUrl() {
        return this.permissionUrl;
    }

    @NotNull
    public final String getPrivacyUrl() {
        return this.privacyUrl;
    }

    @NotNull
    public final String getVersion() {
        return this.version;
    }

    public final int getVersionCode() {
        return this.versionCode;
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
        String str = this.operator;
        int i29 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i36 = i3 * 31;
        String str2 = this.version;
        if (str2 != null) {
            i16 = str2.hashCode();
        } else {
            i16 = 0;
        }
        int i37 = (i36 + i16) * 31;
        String str3 = this.privacyUrl;
        if (str3 != null) {
            i17 = str3.hashCode();
        } else {
            i17 = 0;
        }
        int i38 = (i37 + i17) * 31;
        String str4 = this.permissionUrl;
        if (str4 != null) {
            i18 = str4.hashCode();
        } else {
            i18 = 0;
        }
        int i39 = (i38 + i18) * 31;
        String str5 = this.gameId;
        if (str5 != null) {
            i19 = str5.hashCode();
        } else {
            i19 = 0;
        }
        int i46 = (i39 + i19) * 31;
        String str6 = this.packageName;
        if (str6 != null) {
            i26 = str6.hashCode();
        } else {
            i26 = 0;
        }
        int i47 = (i46 + i26) * 31;
        String str7 = this.appName;
        if (str7 != null) {
            i27 = str7.hashCode();
        } else {
            i27 = 0;
        }
        int i48 = (((i47 + i27) * 31) + this.versionCode) * 31;
        String str8 = this.apkUrl;
        if (str8 != null) {
            i28 = str8.hashCode();
        } else {
            i28 = 0;
        }
        int i49 = (i48 + i28) * 31;
        String str9 = this.iconUrl;
        if (str9 != null) {
            i29 = str9.hashCode();
        }
        return i49 + i29;
    }

    @NotNull
    public final JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(JsonRuleKey.OPERATOR, this.operator);
        jSONObject.put("version", this.version);
        jSONObject.put("privacyUrl", InstallDialogDataKt.encodeUrl(this.privacyUrl));
        jSONObject.put("permissionUrl", InstallDialogDataKt.encodeUrl(this.permissionUrl));
        jSONObject.put(VirtualAppProxy.KEY_GAME_ID, this.gameId);
        jSONObject.put("packageName", this.packageName);
        jSONObject.put("appName", this.appName);
        jSONObject.put("versionCode", this.versionCode);
        jSONObject.put("apkUrl", InstallDialogDataKt.encodeUrl(this.apkUrl));
        jSONObject.put("iconUrl", InstallDialogDataKt.encodeUrl(this.iconUrl));
        return jSONObject;
    }

    @NotNull
    public final String toJSONString() {
        String jSONObject = toJSONObject().toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONObject, "toJSONObject().toString()");
        return jSONObject;
    }

    @NotNull
    public String toString() {
        return "GameInfo(operator=" + this.operator + ", version=" + this.version + ", privacyUrl=" + this.privacyUrl + ", permissionUrl=" + this.permissionUrl + ", gameId=" + this.gameId + ", packageName=" + this.packageName + ", appName=" + this.appName + ", versionCode=" + this.versionCode + ", apkUrl=" + this.apkUrl + ", iconUrl=" + this.iconUrl + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeString(this.operator);
        parcel.writeString(this.version);
        parcel.writeString(this.privacyUrl);
        parcel.writeString(this.permissionUrl);
        parcel.writeString(this.gameId);
        parcel.writeString(this.packageName);
        parcel.writeString(this.appName);
        parcel.writeInt(this.versionCode);
        parcel.writeString(this.apkUrl);
        parcel.writeString(this.iconUrl);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public GameInfo(@NotNull Parcel parcel) {
        this(r3, r4, r5, r6, r7, r8, r9, r10, r11, r14 != null ? r14 : "");
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        String readString = parcel.readString();
        String str = readString != null ? readString : "";
        String readString2 = parcel.readString();
        String str2 = readString2 != null ? readString2 : "";
        String readString3 = parcel.readString();
        String str3 = readString3 != null ? readString3 : "";
        String readString4 = parcel.readString();
        String str4 = readString4 != null ? readString4 : "";
        String readString5 = parcel.readString();
        String str5 = readString5 != null ? readString5 : "";
        String readString6 = parcel.readString();
        String str6 = readString6 != null ? readString6 : "";
        String readString7 = parcel.readString();
        String str7 = readString7 != null ? readString7 : "";
        int readInt = parcel.readInt();
        String readString8 = parcel.readString();
        String str8 = readString8 != null ? readString8 : "";
        String readString9 = parcel.readString();
    }
}
