package com.tenpay.payment;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.a;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Parcelize
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 '2\u00020\u0001:\u0001'B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0006H\u00c6\u0003J1\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u00c6\u0001J\t\u0010\u001a\u001a\u00020\u001bH\u00d6\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u00d6\u0003J\t\u0010 \u001a\u00020\u001bH\u00d6\u0001J\t\u0010!\u001a\u00020\u0003H\u00d6\u0001J\u0019\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001bH\u00d6\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012\u00a8\u0006("}, d2 = {"Lcom/tenpay/payment/QWalletWearPayBean;", "Landroid/os/Parcelable;", WinkDaTongReportConstant.ElementParamValue.XSJ_OPERATION_TYPE_AUTH, "", "devName", "timestamp", "", "systemTime", "(Ljava/lang/String;Ljava/lang/String;JJ)V", "getAuth", "()Ljava/lang/String;", "setAuth", "(Ljava/lang/String;)V", "getDevName", "setDevName", "getSystemTime", "()J", "setSystemTime", "(J)V", "getTimestamp", "setTimestamp", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", WadlProxyConsts.FLAGS, "Companion", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final /* data */ class QWalletWearPayBean implements Parcelable {

    @NotNull
    private String auth;

    @NotNull
    private String devName;
    private long systemTime;
    private long timestamp;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final Parcelable.Creator<QWalletWearPayBean> CREATOR = new Creator();

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007\u00a8\u0006\u0005"}, d2 = {"Lcom/tenpay/payment/QWalletWearPayBean$Companion;", "", "()V", OperateCustomButton.OPERATE_CREATE, "Lcom/tenpay/payment/QWalletWearPayBean;", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final QWalletWearPayBean create() {
            return new QWalletWearPayBean("", "", 0L, 0L);
        }

        Companion() {
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class Creator implements Parcelable.Creator<QWalletWearPayBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final QWalletWearPayBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new QWalletWearPayBean(parcel.readString(), parcel.readString(), parcel.readLong(), parcel.readLong());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final QWalletWearPayBean[] newArray(int i3) {
            return new QWalletWearPayBean[i3];
        }
    }

    public QWalletWearPayBean(@NotNull String auth, @NotNull String devName, long j3, long j16) {
        Intrinsics.checkNotNullParameter(auth, "auth");
        Intrinsics.checkNotNullParameter(devName, "devName");
        this.auth = auth;
        this.devName = devName;
        this.timestamp = j3;
        this.systemTime = j16;
    }

    public static /* synthetic */ QWalletWearPayBean copy$default(QWalletWearPayBean qWalletWearPayBean, String str, String str2, long j3, long j16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = qWalletWearPayBean.auth;
        }
        if ((i3 & 2) != 0) {
            str2 = qWalletWearPayBean.devName;
        }
        String str3 = str2;
        if ((i3 & 4) != 0) {
            j3 = qWalletWearPayBean.timestamp;
        }
        long j17 = j3;
        if ((i3 & 8) != 0) {
            j16 = qWalletWearPayBean.systemTime;
        }
        return qWalletWearPayBean.copy(str, str3, j17, j16);
    }

    @JvmStatic
    @NotNull
    public static final QWalletWearPayBean create() {
        return INSTANCE.create();
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getAuth() {
        return this.auth;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getDevName() {
        return this.devName;
    }

    /* renamed from: component3, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    /* renamed from: component4, reason: from getter */
    public final long getSystemTime() {
        return this.systemTime;
    }

    @NotNull
    public final QWalletWearPayBean copy(@NotNull String auth, @NotNull String devName, long timestamp, long systemTime) {
        Intrinsics.checkNotNullParameter(auth, "auth");
        Intrinsics.checkNotNullParameter(devName, "devName");
        return new QWalletWearPayBean(auth, devName, timestamp, systemTime);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QWalletWearPayBean)) {
            return false;
        }
        QWalletWearPayBean qWalletWearPayBean = (QWalletWearPayBean) other;
        if (Intrinsics.areEqual(this.auth, qWalletWearPayBean.auth) && Intrinsics.areEqual(this.devName, qWalletWearPayBean.devName) && this.timestamp == qWalletWearPayBean.timestamp && this.systemTime == qWalletWearPayBean.systemTime) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getAuth() {
        return this.auth;
    }

    @NotNull
    public final String getDevName() {
        return this.devName;
    }

    public final long getSystemTime() {
        return this.systemTime;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        return (((((this.auth.hashCode() * 31) + this.devName.hashCode()) * 31) + a.a(this.timestamp)) * 31) + a.a(this.systemTime);
    }

    public final void setAuth(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.auth = str;
    }

    public final void setDevName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.devName = str;
    }

    public final void setSystemTime(long j3) {
        this.systemTime = j3;
    }

    public final void setTimestamp(long j3) {
        this.timestamp = j3;
    }

    @NotNull
    public String toString() {
        return "QWalletWearPayBean(auth=" + this.auth + ", devName=" + this.devName + ", timestamp=" + this.timestamp + ", systemTime=" + this.systemTime + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.auth);
        parcel.writeString(this.devName);
        parcel.writeLong(this.timestamp);
        parcel.writeLong(this.systemTime);
    }
}
