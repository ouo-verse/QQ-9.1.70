package com.tencent.qqnt.qwallet.db;

import androidx.room.Entity;
import com.qzone.album.data.model.AlbumCacheData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Entity(primaryKeys = {"paymentId", "msgOwnerUin", "paymentType", AlbumCacheData.LOGINUIN}, tableName = "aio_payment_state_table")
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0004\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u000e\u0010\fR\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0017\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0018\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010\u001a\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u0019\u0010\u0016\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/qqnt/qwallet/db/i;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", AlbumCacheData.LOGINUIN, "d", "paymentId", "c", "setMsgOwnerUin", "(Ljava/lang/String;)V", "msgOwnerUin", "I", "e", "()I", "paymentType", "groupUin", "f", "state", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;I)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.qqnt.qwallet.db.i, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class PaymentStateEntity {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String loginUin;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String paymentId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String msgOwnerUin;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int paymentType;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String groupUin;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final int state;

    public PaymentStateEntity(@NotNull String loginUin, @NotNull String paymentId, @NotNull String msgOwnerUin, int i3, @NotNull String groupUin, int i16) {
        Intrinsics.checkNotNullParameter(loginUin, "loginUin");
        Intrinsics.checkNotNullParameter(paymentId, "paymentId");
        Intrinsics.checkNotNullParameter(msgOwnerUin, "msgOwnerUin");
        Intrinsics.checkNotNullParameter(groupUin, "groupUin");
        this.loginUin = loginUin;
        this.paymentId = paymentId;
        this.msgOwnerUin = msgOwnerUin;
        this.paymentType = i3;
        this.groupUin = groupUin;
        this.state = i16;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getGroupUin() {
        return this.groupUin;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getLoginUin() {
        return this.loginUin;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getMsgOwnerUin() {
        return this.msgOwnerUin;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getPaymentId() {
        return this.paymentId;
    }

    /* renamed from: e, reason: from getter */
    public final int getPaymentType() {
        return this.paymentType;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PaymentStateEntity)) {
            return false;
        }
        PaymentStateEntity paymentStateEntity = (PaymentStateEntity) other;
        if (Intrinsics.areEqual(this.loginUin, paymentStateEntity.loginUin) && Intrinsics.areEqual(this.paymentId, paymentStateEntity.paymentId) && Intrinsics.areEqual(this.msgOwnerUin, paymentStateEntity.msgOwnerUin) && this.paymentType == paymentStateEntity.paymentType && Intrinsics.areEqual(this.groupUin, paymentStateEntity.groupUin) && this.state == paymentStateEntity.state) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final int getState() {
        return this.state;
    }

    public int hashCode() {
        return (((((((((this.loginUin.hashCode() * 31) + this.paymentId.hashCode()) * 31) + this.msgOwnerUin.hashCode()) * 31) + this.paymentType) * 31) + this.groupUin.hashCode()) * 31) + this.state;
    }

    @NotNull
    public String toString() {
        return "PaymentStateEntity(loginUin=" + this.loginUin + ", paymentId=" + this.paymentId + ", msgOwnerUin=" + this.msgOwnerUin + ", paymentType=" + this.paymentType + ", groupUin=" + this.groupUin + ", state=" + this.state + ")";
    }

    public /* synthetic */ PaymentStateEntity(String str, String str2, String str3, int i3, String str4, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? com.tencent.mobileqq.base.a.c() : str, str2, str3, i3, str4, i16);
    }
}
