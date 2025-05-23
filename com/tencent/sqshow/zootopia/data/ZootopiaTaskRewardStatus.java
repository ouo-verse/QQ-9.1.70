package com.tencent.sqshow.zootopia.data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0013\b\u0086\b\u0018\u0000 \u00172\u00020\u0001:\u0001\nB%\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0016\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0019\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/sqshow/zootopia/data/x;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "b", "()J", "setBillId", "(J)V", "billId", "I", "c", "()I", "setQuestCurrentCnt", "(I)V", "questCurrentCnt", "d", "setTargetAmount", "targetAmount", "<init>", "(JII)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.sqshow.zootopia.data.x, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class ZootopiaTaskRewardStatus {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: e, reason: collision with root package name */
    private static final ZootopiaTaskRewardStatus f370463e = new ZootopiaTaskRewardStatus(0, 0, 0, 7, null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private long billId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private int questCurrentCnt;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private int targetAmount;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0017\u0010\u0006\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/sqshow/zootopia/data/x$a;", "", "Lxv4/aa;", "info", "Lcom/tencent/sqshow/zootopia/data/x;", "a", "DEFAULT_DATA", "Lcom/tencent/sqshow/zootopia/data/x;", "b", "()Lcom/tencent/sqshow/zootopia/data/x;", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.sqshow.zootopia.data.x$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ZootopiaTaskRewardStatus b() {
            return ZootopiaTaskRewardStatus.f370463e;
        }

        Companion() {
        }

        public final ZootopiaTaskRewardStatus a(xv4.aa info) {
            if (info != null) {
                return new ZootopiaTaskRewardStatus(info.f448764a, info.f448765b, info.f448766c);
            }
            return b();
        }
    }

    public ZootopiaTaskRewardStatus() {
        this(0L, 0, 0, 7, null);
    }

    /* renamed from: b, reason: from getter */
    public final long getBillId() {
        return this.billId;
    }

    /* renamed from: c, reason: from getter */
    public final int getQuestCurrentCnt() {
        return this.questCurrentCnt;
    }

    /* renamed from: d, reason: from getter */
    public final int getTargetAmount() {
        return this.targetAmount;
    }

    public int hashCode() {
        return (((com.tencent.mobileqq.vas.banner.c.a(this.billId) * 31) + this.questCurrentCnt) * 31) + this.targetAmount;
    }

    public String toString() {
        return "ZootopiaTaskRewardStatus(billId=" + this.billId + ", questCurrentCnt=" + this.questCurrentCnt + ", targetAmount=" + this.targetAmount + ")";
    }

    public ZootopiaTaskRewardStatus(long j3, int i3, int i16) {
        this.billId = j3;
        this.questCurrentCnt = i3;
        this.targetAmount = i16;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZootopiaTaskRewardStatus)) {
            return false;
        }
        ZootopiaTaskRewardStatus zootopiaTaskRewardStatus = (ZootopiaTaskRewardStatus) other;
        return this.billId == zootopiaTaskRewardStatus.billId && this.questCurrentCnt == zootopiaTaskRewardStatus.questCurrentCnt && this.targetAmount == zootopiaTaskRewardStatus.targetAmount;
    }

    public /* synthetic */ ZootopiaTaskRewardStatus(long j3, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? 0L : j3, (i17 & 2) != 0 ? 0 : i3, (i17 & 4) != 0 ? 0 : i16);
    }
}
