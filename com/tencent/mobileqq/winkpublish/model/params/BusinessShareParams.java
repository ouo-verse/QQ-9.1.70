package com.tencent.mobileqq.winkpublish.model.params;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.a;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B-\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\t\u0010\u0012\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\nH\u00c6\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\nH\u00c6\u0001J\b\u0010\u0017\u001a\u00020\nH\u0016J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u00d6\u0003J\t\u0010\u001c\u001a\u00020\nH\u00d6\u0001J\t\u0010\u001d\u001a\u00020\u001eH\u00d6\u0001J\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\nH\u0016R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000f\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/model/params/BusinessShareParams;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "businessTroopId", "", "businessGuildId", "businessMsgSeq", "bindSource", "", "(JJJI)V", "getBindSource", "()I", "getBusinessGuildId", "()J", "getBusinessMsgSeq", "getBusinessTroopId", "component1", "component2", "component3", "component4", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", WadlProxyConsts.FLAGS, "Companion", "qq-winkpublish-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final /* data */ class BusinessShareParams implements Parcelable {

    @NotNull
    private static final String TAG = "BusinessShareParams";
    private final int bindSource;
    private final long businessGuildId;
    private final long businessMsgSeq;
    private final long businessTroopId;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<BusinessShareParams> CREATOR = new Parcelable.Creator<BusinessShareParams>() { // from class: com.tencent.mobileqq.winkpublish.model.params.BusinessShareParams$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public BusinessShareParams createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new BusinessShareParams(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public BusinessShareParams[] newArray(int size) {
            return new BusinessShareParams[size];
        }
    };

    public BusinessShareParams() {
        this(0L, 0L, 0L, 0, 15, null);
    }

    public static /* synthetic */ BusinessShareParams copy$default(BusinessShareParams businessShareParams, long j3, long j16, long j17, int i3, int i16, Object obj) {
        long j18;
        long j19;
        long j26;
        int i17;
        if ((i16 & 1) != 0) {
            j18 = businessShareParams.businessTroopId;
        } else {
            j18 = j3;
        }
        if ((i16 & 2) != 0) {
            j19 = businessShareParams.businessGuildId;
        } else {
            j19 = j16;
        }
        if ((i16 & 4) != 0) {
            j26 = businessShareParams.businessMsgSeq;
        } else {
            j26 = j17;
        }
        if ((i16 & 8) != 0) {
            i17 = businessShareParams.bindSource;
        } else {
            i17 = i3;
        }
        return businessShareParams.copy(j18, j19, j26, i17);
    }

    /* renamed from: component1, reason: from getter */
    public final long getBusinessTroopId() {
        return this.businessTroopId;
    }

    /* renamed from: component2, reason: from getter */
    public final long getBusinessGuildId() {
        return this.businessGuildId;
    }

    /* renamed from: component3, reason: from getter */
    public final long getBusinessMsgSeq() {
        return this.businessMsgSeq;
    }

    /* renamed from: component4, reason: from getter */
    public final int getBindSource() {
        return this.bindSource;
    }

    @NotNull
    public final BusinessShareParams copy(long businessTroopId, long businessGuildId, long businessMsgSeq, int bindSource) {
        return new BusinessShareParams(businessTroopId, businessGuildId, businessMsgSeq, bindSource);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BusinessShareParams)) {
            return false;
        }
        BusinessShareParams businessShareParams = (BusinessShareParams) other;
        if (this.businessTroopId == businessShareParams.businessTroopId && this.businessGuildId == businessShareParams.businessGuildId && this.businessMsgSeq == businessShareParams.businessMsgSeq && this.bindSource == businessShareParams.bindSource) {
            return true;
        }
        return false;
    }

    public final int getBindSource() {
        return this.bindSource;
    }

    public final long getBusinessGuildId() {
        return this.businessGuildId;
    }

    public final long getBusinessMsgSeq() {
        return this.businessMsgSeq;
    }

    public final long getBusinessTroopId() {
        return this.businessTroopId;
    }

    public int hashCode() {
        return (((((a.a(this.businessTroopId) * 31) + a.a(this.businessGuildId)) * 31) + a.a(this.businessMsgSeq)) * 31) + this.bindSource;
    }

    @NotNull
    public String toString() {
        return "BusinessShareParams(businessTroopId=" + this.businessTroopId + ", businessGuildId=" + this.businessGuildId + ", businessMsgSeq=" + this.businessMsgSeq + ", bindSource=" + this.bindSource + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.businessTroopId);
        parcel.writeLong(this.businessGuildId);
        parcel.writeLong(this.businessMsgSeq);
        parcel.writeInt(this.bindSource);
    }

    public BusinessShareParams(long j3, long j16, long j17, int i3) {
        this.businessTroopId = j3;
        this.businessGuildId = j16;
        this.businessMsgSeq = j17;
        this.bindSource = i3;
    }

    public /* synthetic */ BusinessShareParams(long j3, long j16, long j17, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 0L : j3, (i16 & 2) != 0 ? 0L : j16, (i16 & 4) == 0 ? j17 : 0L, (i16 & 8) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BusinessShareParams(@NotNull Parcel parcel) {
        this(parcel.readLong(), parcel.readLong(), parcel.readLong(), parcel.readInt());
        Intrinsics.checkNotNullParameter(parcel, "parcel");
    }
}
