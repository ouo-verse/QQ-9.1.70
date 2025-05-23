package com.tencent.ecommerce.biz.live;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0014\b\u0086\b\u0018\u0000 #2\u00020\u0001:\u0001\u0013B\u001f\u0012\u0006\u0010\u0017\u001a\u00020\u0010\u0012\u0006\u0010\u001b\u001a\u00020\u0010\u0012\u0006\u0010\u001f\u001a\u00020\u0010\u00a2\u0006\u0004\b \u0010!B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b \u0010\"J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\t\u0010\n\u001a\u00020\tH\u00d6\u0001J\t\u0010\u000b\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u00d6\u0003R\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001b\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R\"\u0010\u001f\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u0012\u001a\u0004\b\u001d\u0010\u0014\"\u0004\b\u001e\u0010\u0016\u00a8\u0006$"}, d2 = {"Lcom/tencent/ecommerce/biz/live/TransactionData;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "toString", "hashCode", "", "other", "", "equals", "", "d", "J", "a", "()J", "setOrderMoney", "(J)V", "orderMoney", "e", "b", "setOrderNum", "orderNum", "f", "c", "setPersonNum", "personNum", "<init>", "(JJJ)V", "(Landroid/os/Parcel;)V", "CREATOR", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final /* data */ class TransactionData implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private long orderMoney;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private long orderNum;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private long personNum;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/ecommerce/biz/live/TransactionData$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/ecommerce/biz/live/TransactionData;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/ecommerce/biz/live/TransactionData;", "<init>", "()V", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.live.TransactionData$a, reason: from kotlin metadata */
    /* loaded from: classes5.dex */
    public static final class Companion implements Parcelable.Creator<TransactionData> {
        Companion() {
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public TransactionData createFromParcel(@NotNull Parcel parcel) {
            return new TransactionData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public TransactionData[] newArray(int size) {
            return new TransactionData[size];
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public TransactionData(long j3, long j16, long j17) {
        this.orderMoney = j3;
        this.orderNum = j16;
        this.personNum = j17;
    }

    /* renamed from: a, reason: from getter */
    public final long getOrderMoney() {
        return this.orderMoney;
    }

    /* renamed from: b, reason: from getter */
    public final long getOrderNum() {
        return this.orderNum;
    }

    /* renamed from: c, reason: from getter */
    public final long getPersonNum() {
        return this.personNum;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof TransactionData) {
                TransactionData transactionData = (TransactionData) other;
                if (this.orderMoney != transactionData.orderMoney || this.orderNum != transactionData.orderNum || this.personNum != transactionData.personNum) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((androidx.fragment.app.a.a(this.orderMoney) * 31) + androidx.fragment.app.a.a(this.orderNum)) * 31) + androidx.fragment.app.a.a(this.personNum);
    }

    @NotNull
    public String toString() {
        return "TransactionData(orderMoney=" + this.orderMoney + ", orderNum=" + this.orderNum + ", personNum=" + this.personNum + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        parcel.writeLong(this.orderMoney);
        parcel.writeLong(this.orderNum);
        parcel.writeLong(this.personNum);
    }

    public TransactionData(@NotNull Parcel parcel) {
        this(parcel.readLong(), parcel.readLong(), parcel.readLong());
    }
}
