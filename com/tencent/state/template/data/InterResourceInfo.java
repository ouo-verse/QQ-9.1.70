package com.tencent.state.template.data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0007H\u00c6\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0016\u001a\u00020\u0017H\u00d6\u0001J\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u0019\u00a2\u0006\u0002\u0010\u001bJ\t\u0010\u001c\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/state/template/data/InterResourceInfo;", "", "billNo", "", "senderInfo", "Lcom/tencent/state/template/data/InterSenderInfo;", "receiverInfo", "Lcom/tencent/state/template/data/InterReceiverInfo;", "(Ljava/lang/String;Lcom/tencent/state/template/data/InterSenderInfo;Lcom/tencent/state/template/data/InterReceiverInfo;)V", "getBillNo", "()Ljava/lang/String;", "getReceiverInfo", "()Lcom/tencent/state/template/data/InterReceiverInfo;", "getSenderInfo", "()Lcom/tencent/state/template/data/InterSenderInfo;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "partnerUin", "", "uin", "(J)Ljava/lang/Long;", "toString", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class InterResourceInfo {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String billNo;
    private final InterReceiverInfo receiverInfo;
    private final InterSenderInfo senderInfo;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/state/template/data/InterResourceInfo$Companion;", "", "()V", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class Companion {
        Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public InterResourceInfo(String billNo, InterSenderInfo senderInfo, InterReceiverInfo receiverInfo) {
        Intrinsics.checkNotNullParameter(billNo, "billNo");
        Intrinsics.checkNotNullParameter(senderInfo, "senderInfo");
        Intrinsics.checkNotNullParameter(receiverInfo, "receiverInfo");
        this.billNo = billNo;
        this.senderInfo = senderInfo;
        this.receiverInfo = receiverInfo;
    }

    /* renamed from: component1, reason: from getter */
    public final String getBillNo() {
        return this.billNo;
    }

    /* renamed from: component2, reason: from getter */
    public final InterSenderInfo getSenderInfo() {
        return this.senderInfo;
    }

    /* renamed from: component3, reason: from getter */
    public final InterReceiverInfo getReceiverInfo() {
        return this.receiverInfo;
    }

    public final InterResourceInfo copy(String billNo, InterSenderInfo senderInfo, InterReceiverInfo receiverInfo) {
        Intrinsics.checkNotNullParameter(billNo, "billNo");
        Intrinsics.checkNotNullParameter(senderInfo, "senderInfo");
        Intrinsics.checkNotNullParameter(receiverInfo, "receiverInfo");
        return new InterResourceInfo(billNo, senderInfo, receiverInfo);
    }

    public final String getBillNo() {
        return this.billNo;
    }

    public final InterReceiverInfo getReceiverInfo() {
        return this.receiverInfo;
    }

    public final InterSenderInfo getSenderInfo() {
        return this.senderInfo;
    }

    public int hashCode() {
        String str = this.billNo;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        InterSenderInfo interSenderInfo = this.senderInfo;
        int hashCode2 = (hashCode + (interSenderInfo != null ? interSenderInfo.hashCode() : 0)) * 31;
        InterReceiverInfo interReceiverInfo = this.receiverInfo;
        return hashCode2 + (interReceiverInfo != null ? interReceiverInfo.hashCode() : 0);
    }

    public final Long partnerUin(long uin) {
        if (uin == this.senderInfo.getUin()) {
            return Long.valueOf(this.receiverInfo.getUin());
        }
        if (uin == this.receiverInfo.getUin()) {
            return Long.valueOf(this.senderInfo.getUin());
        }
        return null;
    }

    public String toString() {
        return "InterResourceInfo(billNo=" + this.billNo + ", senderInfo=" + this.senderInfo + ", receiverInfo=" + this.receiverInfo + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InterResourceInfo)) {
            return false;
        }
        InterResourceInfo interResourceInfo = (InterResourceInfo) other;
        return Intrinsics.areEqual(this.billNo, interResourceInfo.billNo) && Intrinsics.areEqual(this.senderInfo, interResourceInfo.senderInfo) && Intrinsics.areEqual(this.receiverInfo, interResourceInfo.receiverInfo);
    }

    public static /* synthetic */ InterResourceInfo copy$default(InterResourceInfo interResourceInfo, String str, InterSenderInfo interSenderInfo, InterReceiverInfo interReceiverInfo, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = interResourceInfo.billNo;
        }
        if ((i3 & 2) != 0) {
            interSenderInfo = interResourceInfo.senderInfo;
        }
        if ((i3 & 4) != 0) {
            interReceiverInfo = interResourceInfo.receiverInfo;
        }
        return interResourceInfo.copy(str, interSenderInfo, interReceiverInfo);
    }
}
