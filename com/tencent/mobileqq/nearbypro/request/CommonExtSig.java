package com.tencent.mobileqq.nearbypro.request;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000b\b\u0086\b\u0018\u0000 !2\u00020\u0001:\u0001\u0014B\u0017\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\u0006\u0010\u001c\u001a\u00020\u0017\u00a2\u0006\u0004\b\u001d\u0010\u001eB\t\b\u0016\u00a2\u0006\u0004\b\u001d\u0010\u001fB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001d\u0010 J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\u0006\u0010\n\u001a\u00020\tJ\t\u0010\f\u001a\u00020\u000bH\u00d6\u0001J\t\u0010\r\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\u0010\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u00d6\u0003R\u0017\u0010\u0016\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u001c\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/nearbypro/request/CommonExtSig;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "b", "", "toString", "hashCode", "", "other", "equals", "", "d", "[B", "a", "()[B", PreloadTRTCPlayerParams.KEY_SIG, "", "e", "J", "getLastTime", "()J", "lastTime", "<init>", "([BJ)V", "()V", "(Landroid/os/Parcel;)V", "CREATOR", "qq_nearby_pro_base_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final /* data */ class CommonExtSig implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final byte[] sig;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final long lastTime;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/request/CommonExtSig$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/nearbypro/request/CommonExtSig;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/mobileqq/nearbypro/request/CommonExtSig;", "<init>", "()V", "qq_nearby_pro_base_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.nearbypro.request.CommonExtSig$a, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
    public static final class Companion implements Parcelable.Creator<CommonExtSig> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public CommonExtSig createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CommonExtSig(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public CommonExtSig[] newArray(int size) {
            return new CommonExtSig[size];
        }

        Companion() {
        }
    }

    public CommonExtSig(@NotNull byte[] sig, long j3) {
        Intrinsics.checkNotNullParameter(sig, "sig");
        this.sig = sig;
        this.lastTime = j3;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final byte[] getSig() {
        return this.sig;
    }

    public final boolean b() {
        return true;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CommonExtSig)) {
            return false;
        }
        CommonExtSig commonExtSig = (CommonExtSig) other;
        if (Intrinsics.areEqual(this.sig, commonExtSig.sig) && this.lastTime == commonExtSig.lastTime) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (Arrays.hashCode(this.sig) * 31) + androidx.fragment.app.a.a(this.lastTime);
    }

    @NotNull
    public String toString() {
        return "CommonExtSig(sig=" + Arrays.toString(this.sig) + ", lastTime=" + this.lastTime + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.sig.length);
        parcel.writeByteArray(this.sig);
        parcel.writeLong(this.lastTime);
    }

    public CommonExtSig() {
        this(new byte[0], 0L);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public CommonExtSig(@NotNull Parcel parcel) {
        this(r0, parcel.readLong());
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        byte[] bArr = new byte[parcel.readInt()];
        parcel.readByteArray(bArr);
    }
}
