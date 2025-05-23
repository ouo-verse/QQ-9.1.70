package com.tenpay.sdk.net.core.comm;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.a;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qwallet.utils.g;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Parcelize
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 $2\u00020\u0001:\u0001$B+\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0007H\u00c6\u0003J7\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00c6\u0001J\t\u0010\u0016\u001a\u00020\u0017H\u00d6\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u00d6\u0003J\t\u0010\u001c\u001a\u00020\u0017H\u00d6\u0001J\u0006\u0010\u001d\u001a\u00020\u0019J\t\u0010\u001e\u001a\u00020\u0003H\u00d6\u0001J\u0019\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0017H\u00d6\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\n\u00a8\u0006%"}, d2 = {"Lcom/tenpay/sdk/net/core/comm/BannedUserInfo;", "Landroid/os/Parcelable;", "psKey", "", "psKeyForbid", "bannedUserBuff", "effectTime", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getBannedUserBuff", "()Ljava/lang/String;", "getEffectTime", "()J", "setEffectTime", "(J)V", "getPsKey", "getPsKeyForbid", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", AppConstants.Key.COLUMN_IS_VALID, "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", WadlProxyConsts.FLAGS, "Companion", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final /* data */ class BannedUserInfo implements Parcelable {
    private static final int EFFECT_TIME_DURATION = 600000;

    @NotNull
    private static final String TAG = "BannedUserInfo";

    @SerializedName("banned_user_buff")
    @Nullable
    private final String bannedUserBuff;
    private long effectTime;

    @SerializedName("pskey")
    @Nullable
    private final String psKey;

    @SerializedName("p_skey_forbid")
    @Nullable
    private final String psKeyForbid;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final Parcelable.Creator<BannedUserInfo> CREATOR = new Creator();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/tenpay/sdk/net/core/comm/BannedUserInfo$Companion;", "", "()V", "EFFECT_TIME_DURATION", "", "TAG", "", "getCache", "Lcom/tenpay/sdk/net/core/comm/BannedUserInfo;", "saveInfoIfNeed", "", "h5Json", "Lorg/json/JSONObject;", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final BannedUserInfo getCache() {
            return (BannedUserInfo) g.h("qwallet_banned_user_info", BannedUserInfo.class, null);
        }

        @JvmStatic
        public final void saveInfoIfNeed(@Nullable JSONObject h5Json) {
            if (h5Json != null && h5Json.has("p_skey_forbid")) {
                try {
                    BannedUserInfo bannedUserInfo = (BannedUserInfo) new GsonBuilder().create().fromJson(h5Json.toString(), BannedUserInfo.class);
                    if (bannedUserInfo != null) {
                        bannedUserInfo.setEffectTime(System.currentTimeMillis() + 600000);
                        g.p("qwallet_banned_user_info", bannedUserInfo);
                        QLog.d(BannedUserInfo.TAG, 1, "saveInfoIfNeed finish: " + bannedUserInfo);
                    }
                } catch (Exception e16) {
                    QLog.w(BannedUserInfo.TAG, 1, "saveInfoIfNeed error:", e16);
                }
            }
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class Creator implements Parcelable.Creator<BannedUserInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BannedUserInfo createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new BannedUserInfo(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readLong());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BannedUserInfo[] newArray(int i3) {
            return new BannedUserInfo[i3];
        }
    }

    public BannedUserInfo(@Nullable String str, @Nullable String str2, @Nullable String str3, long j3) {
        this.psKey = str;
        this.psKeyForbid = str2;
        this.bannedUserBuff = str3;
        this.effectTime = j3;
    }

    public static /* synthetic */ BannedUserInfo copy$default(BannedUserInfo bannedUserInfo, String str, String str2, String str3, long j3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = bannedUserInfo.psKey;
        }
        if ((i3 & 2) != 0) {
            str2 = bannedUserInfo.psKeyForbid;
        }
        String str4 = str2;
        if ((i3 & 4) != 0) {
            str3 = bannedUserInfo.bannedUserBuff;
        }
        String str5 = str3;
        if ((i3 & 8) != 0) {
            j3 = bannedUserInfo.effectTime;
        }
        return bannedUserInfo.copy(str, str4, str5, j3);
    }

    @JvmStatic
    public static final void saveInfoIfNeed(@Nullable JSONObject jSONObject) {
        INSTANCE.saveInfoIfNeed(jSONObject);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getPsKey() {
        return this.psKey;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getPsKeyForbid() {
        return this.psKeyForbid;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getBannedUserBuff() {
        return this.bannedUserBuff;
    }

    /* renamed from: component4, reason: from getter */
    public final long getEffectTime() {
        return this.effectTime;
    }

    @NotNull
    public final BannedUserInfo copy(@Nullable String psKey, @Nullable String psKeyForbid, @Nullable String bannedUserBuff, long effectTime) {
        return new BannedUserInfo(psKey, psKeyForbid, bannedUserBuff, effectTime);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BannedUserInfo)) {
            return false;
        }
        BannedUserInfo bannedUserInfo = (BannedUserInfo) other;
        if (Intrinsics.areEqual(this.psKey, bannedUserInfo.psKey) && Intrinsics.areEqual(this.psKeyForbid, bannedUserInfo.psKeyForbid) && Intrinsics.areEqual(this.bannedUserBuff, bannedUserInfo.bannedUserBuff) && this.effectTime == bannedUserInfo.effectTime) {
            return true;
        }
        return false;
    }

    @Nullable
    public final String getBannedUserBuff() {
        return this.bannedUserBuff;
    }

    public final long getEffectTime() {
        return this.effectTime;
    }

    @Nullable
    public final String getPsKey() {
        return this.psKey;
    }

    @Nullable
    public final String getPsKeyForbid() {
        return this.psKeyForbid;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        String str = this.psKey;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = hashCode * 31;
        String str2 = this.psKeyForbid;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        String str3 = this.bannedUserBuff;
        if (str3 != null) {
            i3 = str3.hashCode();
        }
        return ((i17 + i3) * 31) + a.a(this.effectTime);
    }

    public final boolean isValid() {
        if (System.currentTimeMillis() <= this.effectTime) {
            return true;
        }
        return false;
    }

    public final void setEffectTime(long j3) {
        this.effectTime = j3;
    }

    @NotNull
    public String toString() {
        return "BannedUserInfo(psKey=" + this.psKey + ", psKeyForbid=" + this.psKeyForbid + ", bannedUserBuff=" + this.bannedUserBuff + ", effectTime=" + this.effectTime + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.psKey);
        parcel.writeString(this.psKeyForbid);
        parcel.writeString(this.bannedUserBuff);
        parcel.writeLong(this.effectTime);
    }
}
