package com.tencent.mobileqq.wink.reddot.material;

import androidx.annotation.Keep;
import androidx.fragment.app.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Keep
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\bH\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0005H\u00c6\u0003J;\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001c\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u001d\u001a\u00020\bH\u00d6\u0001R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\t\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/wink/reddot/material/MaterialRedDotInfo;", "", "redDotVersion", "", "startDate", "", "endDate", "redDotType", "", "redDotMask", "(IJJLjava/lang/String;J)V", "getEndDate", "()J", "getRedDotMask", "getRedDotType", "()Ljava/lang/String;", "getRedDotVersion", "()I", "getStartDate", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final /* data */ class MaterialRedDotInfo {
    private final long endDate;
    private final long redDotMask;

    @NotNull
    private final String redDotType;
    private final int redDotVersion;
    private final long startDate;

    public MaterialRedDotInfo(int i3, long j3, long j16, @NotNull String redDotType, long j17) {
        Intrinsics.checkNotNullParameter(redDotType, "redDotType");
        this.redDotVersion = i3;
        this.startDate = j3;
        this.endDate = j16;
        this.redDotType = redDotType;
        this.redDotMask = j17;
    }

    public static /* synthetic */ MaterialRedDotInfo copy$default(MaterialRedDotInfo materialRedDotInfo, int i3, long j3, long j16, String str, long j17, int i16, Object obj) {
        int i17;
        long j18;
        long j19;
        String str2;
        long j26;
        if ((i16 & 1) != 0) {
            i17 = materialRedDotInfo.redDotVersion;
        } else {
            i17 = i3;
        }
        if ((i16 & 2) != 0) {
            j18 = materialRedDotInfo.startDate;
        } else {
            j18 = j3;
        }
        if ((i16 & 4) != 0) {
            j19 = materialRedDotInfo.endDate;
        } else {
            j19 = j16;
        }
        if ((i16 & 8) != 0) {
            str2 = materialRedDotInfo.redDotType;
        } else {
            str2 = str;
        }
        if ((i16 & 16) != 0) {
            j26 = materialRedDotInfo.redDotMask;
        } else {
            j26 = j17;
        }
        return materialRedDotInfo.copy(i17, j18, j19, str2, j26);
    }

    /* renamed from: component1, reason: from getter */
    public final int getRedDotVersion() {
        return this.redDotVersion;
    }

    /* renamed from: component2, reason: from getter */
    public final long getStartDate() {
        return this.startDate;
    }

    /* renamed from: component3, reason: from getter */
    public final long getEndDate() {
        return this.endDate;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getRedDotType() {
        return this.redDotType;
    }

    /* renamed from: component5, reason: from getter */
    public final long getRedDotMask() {
        return this.redDotMask;
    }

    @NotNull
    public final MaterialRedDotInfo copy(int redDotVersion, long startDate, long endDate, @NotNull String redDotType, long redDotMask) {
        Intrinsics.checkNotNullParameter(redDotType, "redDotType");
        return new MaterialRedDotInfo(redDotVersion, startDate, endDate, redDotType, redDotMask);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MaterialRedDotInfo)) {
            return false;
        }
        MaterialRedDotInfo materialRedDotInfo = (MaterialRedDotInfo) other;
        if (this.redDotVersion == materialRedDotInfo.redDotVersion && this.startDate == materialRedDotInfo.startDate && this.endDate == materialRedDotInfo.endDate && Intrinsics.areEqual(this.redDotType, materialRedDotInfo.redDotType) && this.redDotMask == materialRedDotInfo.redDotMask) {
            return true;
        }
        return false;
    }

    public final long getEndDate() {
        return this.endDate;
    }

    public final long getRedDotMask() {
        return this.redDotMask;
    }

    @NotNull
    public final String getRedDotType() {
        return this.redDotType;
    }

    public final int getRedDotVersion() {
        return this.redDotVersion;
    }

    public final long getStartDate() {
        return this.startDate;
    }

    public int hashCode() {
        return (((((((this.redDotVersion * 31) + a.a(this.startDate)) * 31) + a.a(this.endDate)) * 31) + this.redDotType.hashCode()) * 31) + a.a(this.redDotMask);
    }

    @NotNull
    public String toString() {
        return "MaterialRedDotInfo(redDotVersion=" + this.redDotVersion + ", startDate=" + this.startDate + ", endDate=" + this.endDate + ", redDotType=" + this.redDotType + ", redDotMask=" + this.redDotMask + ")";
    }
}
