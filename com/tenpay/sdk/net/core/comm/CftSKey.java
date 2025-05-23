package com.tenpay.sdk.net.core.comm;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.a;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Parcelize
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0007H\u00c6\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00c6\u0001J\t\u0010\u0013\u001a\u00020\u0007H\u00d6\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u00d6\u0003J\t\u0010\u0018\u001a\u00020\u0007H\u00d6\u0001J\t\u0010\u0019\u001a\u00020\u0003H\u00d6\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0007H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u001f"}, d2 = {"Lcom/tenpay/sdk/net/core/comm/CftSKey;", "Landroid/os/Parcelable;", "skey", "", "expireTime", "", "transSeq", "", "(Ljava/lang/String;JI)V", "getExpireTime", "()J", "getSkey", "()Ljava/lang/String;", "getTransSeq", "()I", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", WadlProxyConsts.FLAGS, "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final /* data */ class CftSKey implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<CftSKey> CREATOR = new Creator();
    private final long expireTime;

    @NotNull
    private final String skey;
    private final int transSeq;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class Creator implements Parcelable.Creator<CftSKey> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CftSKey createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CftSKey(parcel.readString(), parcel.readLong(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CftSKey[] newArray(int i3) {
            return new CftSKey[i3];
        }
    }

    public CftSKey(@NotNull String skey, long j3, int i3) {
        Intrinsics.checkNotNullParameter(skey, "skey");
        this.skey = skey;
        this.expireTime = j3;
        this.transSeq = i3;
    }

    public static /* synthetic */ CftSKey copy$default(CftSKey cftSKey, String str, long j3, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            str = cftSKey.skey;
        }
        if ((i16 & 2) != 0) {
            j3 = cftSKey.expireTime;
        }
        if ((i16 & 4) != 0) {
            i3 = cftSKey.transSeq;
        }
        return cftSKey.copy(str, j3, i3);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getSkey() {
        return this.skey;
    }

    /* renamed from: component2, reason: from getter */
    public final long getExpireTime() {
        return this.expireTime;
    }

    /* renamed from: component3, reason: from getter */
    public final int getTransSeq() {
        return this.transSeq;
    }

    @NotNull
    public final CftSKey copy(@NotNull String skey, long expireTime, int transSeq) {
        Intrinsics.checkNotNullParameter(skey, "skey");
        return new CftSKey(skey, expireTime, transSeq);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CftSKey)) {
            return false;
        }
        CftSKey cftSKey = (CftSKey) other;
        if (Intrinsics.areEqual(this.skey, cftSKey.skey) && this.expireTime == cftSKey.expireTime && this.transSeq == cftSKey.transSeq) {
            return true;
        }
        return false;
    }

    public final long getExpireTime() {
        return this.expireTime;
    }

    @NotNull
    public final String getSkey() {
        return this.skey;
    }

    public final int getTransSeq() {
        return this.transSeq;
    }

    public int hashCode() {
        return (((this.skey.hashCode() * 31) + a.a(this.expireTime)) * 31) + this.transSeq;
    }

    @NotNull
    public String toString() {
        return "CftSKey(skey=" + this.skey + ", expireTime=" + this.expireTime + ", transSeq=" + this.transSeq + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.skey);
        parcel.writeLong(this.expireTime);
        parcel.writeInt(this.transSeq);
    }
}
