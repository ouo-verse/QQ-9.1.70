package com.tencent.mobileqq.zplan.minihome;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/zplan/minihome/ah;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "uin", "Lcom/tencent/mobileqq/zplan/minihome/ag;", "b", "Lcom/tencent/mobileqq/zplan/minihome/ag;", "getMiniHomeInfo", "()Lcom/tencent/mobileqq/zplan/minihome/ag;", "miniHomeInfo", "<init>", "(Ljava/lang/String;Lcom/tencent/mobileqq/zplan/minihome/ag;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.zplan.minihome.ah, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class MiniHomeInfoData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final String uin;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final MiniHomeInfo miniHomeInfo;

    public MiniHomeInfoData(String uin, MiniHomeInfo miniHomeInfo) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        this.uin = uin;
        this.miniHomeInfo = miniHomeInfo;
    }

    /* renamed from: a, reason: from getter */
    public final String getUin() {
        return this.uin;
    }

    public int hashCode() {
        int hashCode = this.uin.hashCode() * 31;
        MiniHomeInfo miniHomeInfo = this.miniHomeInfo;
        return hashCode + (miniHomeInfo == null ? 0 : miniHomeInfo.hashCode());
    }

    public String toString() {
        return "MiniHomeInfoData(uin=" + this.uin + ", miniHomeInfo=" + this.miniHomeInfo + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MiniHomeInfoData)) {
            return false;
        }
        MiniHomeInfoData miniHomeInfoData = (MiniHomeInfoData) other;
        return Intrinsics.areEqual(this.uin, miniHomeInfoData.uin) && Intrinsics.areEqual(this.miniHomeInfo, miniHomeInfoData.miniHomeInfo);
    }
}
