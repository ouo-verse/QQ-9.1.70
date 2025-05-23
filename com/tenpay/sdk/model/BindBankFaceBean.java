package com.tenpay.sdk.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.annotations.SerializedName;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamematrix.gmcg.sdk.nonage.report.CGNonAgeReport;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.face.FaceVerifyBean;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Parcelize
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 !2\u00020\u0001:\u0001!B'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J+\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001J\t\u0010\u0011\u001a\u00020\u0003H\u00d6\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u00d6\u0003J\t\u0010\u0016\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0017\u001a\u00020\u0005H\u00d6\u0001J \u0010\u0018\u001a\u00020\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0005H\u0007J\u0019\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0003H\u00d6\u0001R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t\u00a8\u0006\""}, d2 = {"Lcom/tenpay/sdk/model/BindBankFaceBean;", "Landroid/os/Parcelable;", "needFace", "", "tokenId", "", "channelInfo", "(ILjava/lang/String;Ljava/lang/String;)V", "getChannelInfo", "()Ljava/lang/String;", "getNeedFace", "()I", "getTokenId", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "toVerifyBean", "Lcom/tenpay/face/FaceVerifyBean;", "name", "idcard", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", WadlProxyConsts.FLAGS, "Companion", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final /* data */ class BindBankFaceBean implements Parcelable {

    @NotNull
    private static final String KEY_FLAG = "face";

    @NotNull
    private static final String TAG = "BindBankFaceBean";

    @SerializedName(CGNonAgeReport.EVENT_CHANNEL)
    @Nullable
    private final String channelInfo;

    @SerializedName("flag")
    private final int needFace;

    @SerializedName("token_id")
    @Nullable
    private final String tokenId;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final Parcelable.Creator<BindBankFaceBean> CREATOR = new Creator();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/tenpay/sdk/model/BindBankFaceBean$Companion;", "", "()V", "KEY_FLAG", "", "TAG", "parseFromUserAuthenRsp", "Lcom/tenpay/sdk/model/BindBankFaceBean;", "data", "Lorg/json/JSONObject;", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @Nullable
        public final BindBankFaceBean parseFromUserAuthenRsp(@NotNull JSONObject data) {
            BindBankFaceBean bindBankFaceBean;
            Intrinsics.checkNotNullParameter(data, "data");
            try {
                bindBankFaceBean = (BindBankFaceBean) new GsonBuilder().create().fromJson(data.optString("face"), BindBankFaceBean.class);
            } catch (JsonSyntaxException e16) {
                QLog.w(BindBankFaceBean.TAG, 1, "gson fail: " + data, e16);
                bindBankFaceBean = null;
            }
            QLog.i(BindBankFaceBean.TAG, 2, "parseFromUserAuthenRsp: " + bindBankFaceBean);
            return bindBankFaceBean;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class Creator implements Parcelable.Creator<BindBankFaceBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BindBankFaceBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new BindBankFaceBean(parcel.readInt(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BindBankFaceBean[] newArray(int i3) {
            return new BindBankFaceBean[i3];
        }
    }

    public BindBankFaceBean() {
        this(0, null, null, 7, null);
    }

    public static /* synthetic */ BindBankFaceBean copy$default(BindBankFaceBean bindBankFaceBean, int i3, String str, String str2, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = bindBankFaceBean.needFace;
        }
        if ((i16 & 2) != 0) {
            str = bindBankFaceBean.tokenId;
        }
        if ((i16 & 4) != 0) {
            str2 = bindBankFaceBean.channelInfo;
        }
        return bindBankFaceBean.copy(i3, str, str2);
    }

    @JvmStatic
    @Nullable
    public static final BindBankFaceBean parseFromUserAuthenRsp(@NotNull JSONObject jSONObject) {
        return INSTANCE.parseFromUserAuthenRsp(jSONObject);
    }

    public static /* synthetic */ FaceVerifyBean toVerifyBean$default(BindBankFaceBean bindBankFaceBean, String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = null;
        }
        if ((i3 & 2) != 0) {
            str2 = null;
        }
        return bindBankFaceBean.toVerifyBean(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final int getNeedFace() {
        return this.needFace;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getTokenId() {
        return this.tokenId;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getChannelInfo() {
        return this.channelInfo;
    }

    @NotNull
    public final BindBankFaceBean copy(int needFace, @Nullable String tokenId, @Nullable String channelInfo) {
        return new BindBankFaceBean(needFace, tokenId, channelInfo);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BindBankFaceBean)) {
            return false;
        }
        BindBankFaceBean bindBankFaceBean = (BindBankFaceBean) other;
        if (this.needFace == bindBankFaceBean.needFace && Intrinsics.areEqual(this.tokenId, bindBankFaceBean.tokenId) && Intrinsics.areEqual(this.channelInfo, bindBankFaceBean.channelInfo)) {
            return true;
        }
        return false;
    }

    @Nullable
    public final String getChannelInfo() {
        return this.channelInfo;
    }

    public final int getNeedFace() {
        return this.needFace;
    }

    @Nullable
    public final String getTokenId() {
        return this.tokenId;
    }

    public int hashCode() {
        int hashCode;
        int i3 = this.needFace * 31;
        String str = this.tokenId;
        int i16 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i17 = (i3 + hashCode) * 31;
        String str2 = this.channelInfo;
        if (str2 != null) {
            i16 = str2.hashCode();
        }
        return i17 + i16;
    }

    @NotNull
    public String toString() {
        return "BindBankFaceBean(needFace=" + this.needFace + ", tokenId=" + this.tokenId + ", channelInfo=" + this.channelInfo + ")";
    }

    @JvmOverloads
    @NotNull
    public final FaceVerifyBean toVerifyBean() {
        return toVerifyBean$default(this, null, null, 3, null);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.needFace);
        parcel.writeString(this.tokenId);
        parcel.writeString(this.channelInfo);
    }

    public BindBankFaceBean(int i3, @Nullable String str, @Nullable String str2) {
        this.needFace = i3;
        this.tokenId = str;
        this.channelInfo = str2;
    }

    @JvmOverloads
    @NotNull
    public final FaceVerifyBean toVerifyBean(@Nullable String str) {
        return toVerifyBean$default(this, str, null, 2, null);
    }

    @JvmOverloads
    @NotNull
    public final FaceVerifyBean toVerifyBean(@Nullable String name, @Nullable String idcard) {
        return new FaceVerifyBean(this.tokenId, this.channelInfo, name, idcard, null, null, 48, null);
    }

    public /* synthetic */ BindBankFaceBean(int i3, String str, String str2, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 0 : i3, (i16 & 2) != 0 ? null : str, (i16 & 4) != 0 ? null : str2);
    }
}
