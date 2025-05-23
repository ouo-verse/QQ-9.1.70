package com.tenpay.bank;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000  2\u00020\u0001:\u0001 B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B+\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\nJ\t\u0010\u0010\u001a\u00020\u0006H\u00c6\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J7\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006H\u00c6\u0001J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u00d6\u0003J\t\u0010\u001b\u001a\u00020\u0016H\u00d6\u0001J\t\u0010\u001c\u001a\u00020\u0006H\u00d6\u0001J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0016H\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\f\u00a8\u0006!"}, d2 = {"Lcom/tenpay/bank/DisableBankInfo;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", SemanticAttributes.DbCassandraConsistencyLevelValues.SERIAL, "", "disableTitle", "disableComment", "disableUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDisableComment", "()Ljava/lang/String;", "getDisableTitle", "getDisableUrl", "getSerial", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", WadlProxyConsts.FLAGS, "CREATOR", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final /* data */ class DisableBankInfo implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "DisableBankInfo";

    @Nullable
    private final String disableComment;

    @Nullable
    private final String disableTitle;

    @Nullable
    private final String disableUrl;

    @NotNull
    private final String serial;

    /* compiled from: P */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001d\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016\u00a2\u0006\u0002\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/tenpay/bank/DisableBankInfo$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tenpay/bank/DisableBankInfo;", "()V", "TAG", "", "createByRetUrl", LayoutAttrDefine.CLICK_URI, "Landroid/net/Uri;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tenpay/bank/DisableBankInfo;", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tenpay.bank.DisableBankInfo$CREATOR, reason: from kotlin metadata */
    /* loaded from: classes27.dex */
    public static final class Companion implements Parcelable.Creator<DisableBankInfo> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final DisableBankInfo createByRetUrl(@NotNull Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            try {
                String queryParameter = uri.getQueryParameter(SemanticAttributes.DbCassandraConsistencyLevelValues.SERIAL);
                String queryParameter2 = uri.getQueryParameter("disable_url");
                String queryParameter3 = uri.getQueryParameter("disable_title");
                String queryParameter4 = uri.getQueryParameter("disable_comment");
                if (!TextUtils.isEmpty(queryParameter)) {
                    Intrinsics.checkNotNull(queryParameter);
                    return new DisableBankInfo(queryParameter, queryParameter3, queryParameter4, queryParameter2);
                }
                return null;
            } catch (Exception e16) {
                QLog.e(DisableBankInfo.TAG, 1, e16, new Object[0]);
                return null;
            }
        }

        Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public DisableBankInfo createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new DisableBankInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public DisableBankInfo[] newArray(int size) {
            return new DisableBankInfo[size];
        }
    }

    public DisableBankInfo(@NotNull String serial, @Nullable String str, @Nullable String str2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(serial, "serial");
        this.serial = serial;
        this.disableTitle = str;
        this.disableComment = str2;
        this.disableUrl = str3;
    }

    public static /* synthetic */ DisableBankInfo copy$default(DisableBankInfo disableBankInfo, String str, String str2, String str3, String str4, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = disableBankInfo.serial;
        }
        if ((i3 & 2) != 0) {
            str2 = disableBankInfo.disableTitle;
        }
        if ((i3 & 4) != 0) {
            str3 = disableBankInfo.disableComment;
        }
        if ((i3 & 8) != 0) {
            str4 = disableBankInfo.disableUrl;
        }
        return disableBankInfo.copy(str, str2, str3, str4);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getSerial() {
        return this.serial;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getDisableTitle() {
        return this.disableTitle;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getDisableComment() {
        return this.disableComment;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getDisableUrl() {
        return this.disableUrl;
    }

    @NotNull
    public final DisableBankInfo copy(@NotNull String serial, @Nullable String disableTitle, @Nullable String disableComment, @Nullable String disableUrl) {
        Intrinsics.checkNotNullParameter(serial, "serial");
        return new DisableBankInfo(serial, disableTitle, disableComment, disableUrl);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DisableBankInfo)) {
            return false;
        }
        DisableBankInfo disableBankInfo = (DisableBankInfo) other;
        if (Intrinsics.areEqual(this.serial, disableBankInfo.serial) && Intrinsics.areEqual(this.disableTitle, disableBankInfo.disableTitle) && Intrinsics.areEqual(this.disableComment, disableBankInfo.disableComment) && Intrinsics.areEqual(this.disableUrl, disableBankInfo.disableUrl)) {
            return true;
        }
        return false;
    }

    @Nullable
    public final String getDisableComment() {
        return this.disableComment;
    }

    @Nullable
    public final String getDisableTitle() {
        return this.disableTitle;
    }

    @Nullable
    public final String getDisableUrl() {
        return this.disableUrl;
    }

    @NotNull
    public final String getSerial() {
        return this.serial;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3 = this.serial.hashCode() * 31;
        String str = this.disableTitle;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = (hashCode3 + hashCode) * 31;
        String str2 = this.disableComment;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        String str3 = this.disableUrl;
        if (str3 != null) {
            i3 = str3.hashCode();
        }
        return i17 + i3;
    }

    @NotNull
    public String toString() {
        return "DisableBankInfo(serial=" + this.serial + ", disableTitle=" + this.disableTitle + ", disableComment=" + this.disableComment + ", disableUrl=" + this.disableUrl + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.serial);
        parcel.writeString(this.disableTitle);
        parcel.writeString(this.disableComment);
        parcel.writeString(this.disableUrl);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public DisableBankInfo(@NotNull Parcel parcel) {
        this(r0 == null ? "" : r0, parcel.readString(), parcel.readString(), parcel.readString());
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String readString = parcel.readString();
    }
}
