package com.tencent.state.template.service;

import bt4.l;
import com.tencent.mobileqq.vas.banner.c;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0006H\u00c6\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001J\t\u0010\u0016\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/state/template/service/InviteRsp;", "", "billNo", "", "tips", "countdown", "", "(Ljava/lang/String;Ljava/lang/String;J)V", "getBillNo", "()Ljava/lang/String;", "getCountdown", "()J", "getTips", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class InviteRsp {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String billNo;
    private final long countdown;
    private final String tips;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/state/template/service/InviteRsp$Companion;", "", "Lbt4/l;", "pb", "Lcom/tencent/state/template/service/InviteRsp;", "parsePB", "<init>", "()V", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class Companion {
        Companion() {
        }

        public final InviteRsp parsePB(l pb5) {
            String str;
            String str2;
            String str3 = "";
            if (pb5 == null || (str = pb5.f29133a) == null) {
                str = "";
            }
            if (pb5 != null && (str2 = pb5.f29134b) != null) {
                str3 = str2;
            }
            return new InviteRsp(str, str3, pb5 != null ? pb5.f29135c : 0L);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public InviteRsp(String billNo, String tips, long j3) {
        Intrinsics.checkNotNullParameter(billNo, "billNo");
        Intrinsics.checkNotNullParameter(tips, "tips");
        this.billNo = billNo;
        this.tips = tips;
        this.countdown = j3;
    }

    /* renamed from: component1, reason: from getter */
    public final String getBillNo() {
        return this.billNo;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTips() {
        return this.tips;
    }

    /* renamed from: component3, reason: from getter */
    public final long getCountdown() {
        return this.countdown;
    }

    public final InviteRsp copy(String billNo, String tips, long countdown) {
        Intrinsics.checkNotNullParameter(billNo, "billNo");
        Intrinsics.checkNotNullParameter(tips, "tips");
        return new InviteRsp(billNo, tips, countdown);
    }

    public final String getBillNo() {
        return this.billNo;
    }

    public final long getCountdown() {
        return this.countdown;
    }

    public final String getTips() {
        return this.tips;
    }

    public int hashCode() {
        String str = this.billNo;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.tips;
        return ((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + c.a(this.countdown);
    }

    public String toString() {
        return "InviteRsp(billNo=" + this.billNo + ", tips=" + this.tips + ", countdown=" + this.countdown + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InviteRsp)) {
            return false;
        }
        InviteRsp inviteRsp = (InviteRsp) other;
        return Intrinsics.areEqual(this.billNo, inviteRsp.billNo) && Intrinsics.areEqual(this.tips, inviteRsp.tips) && this.countdown == inviteRsp.countdown;
    }

    public static /* synthetic */ InviteRsp copy$default(InviteRsp inviteRsp, String str, String str2, long j3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = inviteRsp.billNo;
        }
        if ((i3 & 2) != 0) {
            str2 = inviteRsp.tips;
        }
        if ((i3 & 4) != 0) {
            j3 = inviteRsp.countdown;
        }
        return inviteRsp.copy(str, str2, j3);
    }
}
