package com.tencent.mobileqq.data.troop;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0016\u001a\u00020\u0017H\u00d6\u0001R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/data/troop/TroopMemberNickIconInfo;", "Ljava/io/Serializable;", "resId", "", "expireTime", "", "bizId", "(IJI)V", "getBizId", "()I", "getExpireTime", "()J", "getResId", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "", "imcore-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes10.dex */
public final /* data */ class TroopMemberNickIconInfo implements Serializable {
    private final int bizId;
    private final long expireTime;
    private final int resId;

    public TroopMemberNickIconInfo() {
        this(0, 0L, 0, 7, null);
    }

    public static /* synthetic */ TroopMemberNickIconInfo copy$default(TroopMemberNickIconInfo troopMemberNickIconInfo, int i3, long j3, int i16, int i17, Object obj) {
        if ((i17 & 1) != 0) {
            i3 = troopMemberNickIconInfo.resId;
        }
        if ((i17 & 2) != 0) {
            j3 = troopMemberNickIconInfo.expireTime;
        }
        if ((i17 & 4) != 0) {
            i16 = troopMemberNickIconInfo.bizId;
        }
        return troopMemberNickIconInfo.copy(i3, j3, i16);
    }

    /* renamed from: component1, reason: from getter */
    public final int getResId() {
        return this.resId;
    }

    /* renamed from: component2, reason: from getter */
    public final long getExpireTime() {
        return this.expireTime;
    }

    /* renamed from: component3, reason: from getter */
    public final int getBizId() {
        return this.bizId;
    }

    @NotNull
    public final TroopMemberNickIconInfo copy(int resId, long expireTime, int bizId) {
        return new TroopMemberNickIconInfo(resId, expireTime, bizId);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TroopMemberNickIconInfo)) {
            return false;
        }
        TroopMemberNickIconInfo troopMemberNickIconInfo = (TroopMemberNickIconInfo) other;
        if (this.resId == troopMemberNickIconInfo.resId && this.expireTime == troopMemberNickIconInfo.expireTime && this.bizId == troopMemberNickIconInfo.bizId) {
            return true;
        }
        return false;
    }

    public final int getBizId() {
        return this.bizId;
    }

    public final long getExpireTime() {
        return this.expireTime;
    }

    public final int getResId() {
        return this.resId;
    }

    public int hashCode() {
        return (((this.resId * 31) + androidx.fragment.app.a.a(this.expireTime)) * 31) + this.bizId;
    }

    @NotNull
    public String toString() {
        return "TroopMemberNickIconInfo(resId=" + this.resId + ", expireTime=" + this.expireTime + ", bizId=" + this.bizId + ')';
    }

    public TroopMemberNickIconInfo(int i3, long j3, int i16) {
        this.resId = i3;
        this.expireTime = j3;
        this.bizId = i16;
    }

    public /* synthetic */ TroopMemberNickIconInfo(int i3, long j3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? 0 : i3, (i17 & 2) != 0 ? 0L : j3, (i17 & 4) != 0 ? 0 : i16);
    }
}
