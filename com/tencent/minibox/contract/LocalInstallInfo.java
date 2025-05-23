package com.tencent.minibox.contract;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 )2\u00020\u0001:\u0001)B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B/\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0002\u0010\rJ\t\u0010\u0016\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\tH\u00c6\u0003J\t\u0010\u0019\u001a\u00020\tH\u00c6\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\fH\u00c6\u0003J=\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00c6\u0001J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\u0013\u0010\u001e\u001a\u00020\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u00d6\u0003J\t\u0010!\u001a\u00020\u001dH\u00d6\u0001J\b\u0010\"\u001a\u00020#H\u0002J\u0006\u0010$\u001a\u00020\tJ\t\u0010%\u001a\u00020\tH\u00d6\u0001J\u0018\u0010&\u001a\u00020'2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u001dH\u0016R\u0011\u0010\n\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000f\u00a8\u0006*"}, d2 = {"Lcom/tencent/minibox/contract/LocalInstallInfo;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "enableEntry", "", "enablePopup", "title", "", "buttonText", "info", "Lcom/tencent/minibox/contract/GameInfo;", "(ZZLjava/lang/String;Ljava/lang/String;Lcom/tencent/minibox/contract/GameInfo;)V", "getButtonText", "()Ljava/lang/String;", "getEnableEntry", "()Z", "getEnablePopup", "getInfo", "()Lcom/tencent/minibox/contract/GameInfo;", "getTitle", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toJSONObject", "Lorg/json/JSONObject;", "toJSONString", "toString", "writeToParcel", "", WadlProxyConsts.FLAGS, "CREATOR", "MiniBoxDynamicApi_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes9.dex */
public final /* data */ class LocalInstallInfo implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private final String buttonText;
    private final boolean enableEntry;
    private final boolean enablePopup;

    @Nullable
    private final GameInfo info;

    @NotNull
    private final String title;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\tJ\u001d\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016\u00a2\u0006\u0002\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/minibox/contract/LocalInstallInfo$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/minibox/contract/LocalInstallInfo;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "fromJSONString", "jsonString", "", "newArray", "", "size", "", "(I)[Lcom/tencent/minibox/contract/LocalInstallInfo;", "MiniBoxDynamicApi_release"}, k = 1, mv = {1, 1, 16})
    /* renamed from: com.tencent.minibox.contract.LocalInstallInfo$CREATOR, reason: from kotlin metadata */
    /* loaded from: classes9.dex */
    public static final class Companion implements Parcelable.Creator<LocalInstallInfo> {
        Companion() {
        }

        @Nullable
        public final LocalInstallInfo fromJSONString(@NotNull String jsonString) {
            Intrinsics.checkParameterIsNotNull(jsonString, "jsonString");
            try {
                JSONObject jSONObject = new JSONObject(jsonString);
                boolean optBoolean = jSONObject.optBoolean("enableEntry");
                boolean optBoolean2 = jSONObject.optBoolean("enablePopup");
                String optString = jSONObject.optString("title");
                Intrinsics.checkExpressionValueIsNotNull(optString, "json.optString(\"title\")");
                String optString2 = jSONObject.optString("buttonText");
                Intrinsics.checkExpressionValueIsNotNull(optString2, "json.optString(\"buttonText\")");
                return new LocalInstallInfo(optBoolean, optBoolean2, optString, optString2, GameInfo.INSTANCE.fromJSONObject(jSONObject.optJSONObject("info")));
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
        public LocalInstallInfo createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "parcel");
            return new LocalInstallInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public LocalInstallInfo[] newArray(int size) {
            return new LocalInstallInfo[size];
        }
    }

    public LocalInstallInfo(boolean z16, boolean z17, @NotNull String title, @NotNull String buttonText, @Nullable GameInfo gameInfo) {
        Intrinsics.checkParameterIsNotNull(title, "title");
        Intrinsics.checkParameterIsNotNull(buttonText, "buttonText");
        this.enableEntry = z16;
        this.enablePopup = z17;
        this.title = title;
        this.buttonText = buttonText;
        this.info = gameInfo;
    }

    public static /* synthetic */ LocalInstallInfo copy$default(LocalInstallInfo localInstallInfo, boolean z16, boolean z17, String str, String str2, GameInfo gameInfo, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = localInstallInfo.enableEntry;
        }
        if ((i3 & 2) != 0) {
            z17 = localInstallInfo.enablePopup;
        }
        boolean z18 = z17;
        if ((i3 & 4) != 0) {
            str = localInstallInfo.title;
        }
        String str3 = str;
        if ((i3 & 8) != 0) {
            str2 = localInstallInfo.buttonText;
        }
        String str4 = str2;
        if ((i3 & 16) != 0) {
            gameInfo = localInstallInfo.info;
        }
        return localInstallInfo.copy(z16, z18, str3, str4, gameInfo);
    }

    private final JSONObject toJSONObject() {
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("enableEntry", this.enableEntry);
        jSONObject2.put("enablePopup", this.enablePopup);
        jSONObject2.put("title", this.title);
        jSONObject2.put("buttonText", this.buttonText);
        GameInfo gameInfo = this.info;
        if (gameInfo != null) {
            jSONObject = gameInfo.toJSONObject();
        } else {
            jSONObject = null;
        }
        jSONObject2.put("info", jSONObject);
        return jSONObject2;
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getEnableEntry() {
        return this.enableEntry;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getEnablePopup() {
        return this.enablePopup;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getButtonText() {
        return this.buttonText;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final GameInfo getInfo() {
        return this.info;
    }

    @NotNull
    public final LocalInstallInfo copy(boolean enableEntry, boolean enablePopup, @NotNull String title, @NotNull String buttonText, @Nullable GameInfo info) {
        Intrinsics.checkParameterIsNotNull(title, "title");
        Intrinsics.checkParameterIsNotNull(buttonText, "buttonText");
        return new LocalInstallInfo(enableEntry, enablePopup, title, buttonText, info);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof LocalInstallInfo) {
                LocalInstallInfo localInstallInfo = (LocalInstallInfo) other;
                if (this.enableEntry != localInstallInfo.enableEntry || this.enablePopup != localInstallInfo.enablePopup || !Intrinsics.areEqual(this.title, localInstallInfo.title) || !Intrinsics.areEqual(this.buttonText, localInstallInfo.buttonText) || !Intrinsics.areEqual(this.info, localInstallInfo.info)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @NotNull
    public final String getButtonText() {
        return this.buttonText;
    }

    public final boolean getEnableEntry() {
        return this.enableEntry;
    }

    public final boolean getEnablePopup() {
        return this.enablePopup;
    }

    @Nullable
    public final GameInfo getInfo() {
        return this.info;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    public int hashCode() {
        int i3;
        int i16;
        boolean z16 = this.enableEntry;
        int i17 = 1;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i18 = r06 * 31;
        boolean z17 = this.enablePopup;
        if (!z17) {
            i17 = z17 ? 1 : 0;
        }
        int i19 = (i18 + i17) * 31;
        String str = this.title;
        int i26 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i27 = (i19 + i3) * 31;
        String str2 = this.buttonText;
        if (str2 != null) {
            i16 = str2.hashCode();
        } else {
            i16 = 0;
        }
        int i28 = (i27 + i16) * 31;
        GameInfo gameInfo = this.info;
        if (gameInfo != null) {
            i26 = gameInfo.hashCode();
        }
        return i28 + i26;
    }

    @NotNull
    public final String toJSONString() {
        String jSONObject = toJSONObject().toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONObject, "toJSONObject().toString()");
        return jSONObject;
    }

    @NotNull
    public String toString() {
        return "LocalInstallInfo(enableEntry=" + this.enableEntry + ", enablePopup=" + this.enablePopup + ", title=" + this.title + ", buttonText=" + this.buttonText + ", info=" + this.info + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeByte(this.enableEntry ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.enablePopup ? (byte) 1 : (byte) 0);
        parcel.writeString(this.title);
        parcel.writeString(this.buttonText);
        parcel.writeParcelable(this.info, flags);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public LocalInstallInfo(@NotNull Parcel parcel) {
        this(r5, r6, r7, r0 != null ? r0 : "", (GameInfo) parcel.readParcelable(GameInfo.class.getClassLoader()));
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        byte b16 = (byte) 1;
        boolean z16 = parcel.readByte() == b16;
        boolean z17 = parcel.readByte() == b16;
        String readString = parcel.readString();
        String str = readString != null ? readString : "";
        String readString2 = parcel.readString();
    }
}
