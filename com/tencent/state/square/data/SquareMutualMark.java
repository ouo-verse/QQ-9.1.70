package com.tencent.state.square.data;

import com.tencent.mobileqq.vas.banner.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001J\b\u0010\u0013\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/state/square/data/SquareMutualMark;", "", "iconUrl", "", "markType", "", "(Ljava/lang/String;J)V", "getIconUrl", "()Ljava/lang/String;", "getMarkType", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class SquareMutualMark {
    private final String iconUrl;
    private final long markType;

    public SquareMutualMark(String iconUrl, long j3) {
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        this.iconUrl = iconUrl;
        this.markType = j3;
    }

    /* renamed from: component1, reason: from getter */
    public final String getIconUrl() {
        return this.iconUrl;
    }

    /* renamed from: component2, reason: from getter */
    public final long getMarkType() {
        return this.markType;
    }

    public final SquareMutualMark copy(String iconUrl, long markType) {
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        return new SquareMutualMark(iconUrl, markType);
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final long getMarkType() {
        return this.markType;
    }

    public int hashCode() {
        String str = this.iconUrl;
        return ((str != null ? str.hashCode() : 0) * 31) + c.a(this.markType);
    }

    public String toString() {
        return "iconUrl=" + this.iconUrl + "-markType=" + this.markType;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SquareMutualMark)) {
            return false;
        }
        SquareMutualMark squareMutualMark = (SquareMutualMark) other;
        return Intrinsics.areEqual(this.iconUrl, squareMutualMark.iconUrl) && this.markType == squareMutualMark.markType;
    }

    public static /* synthetic */ SquareMutualMark copy$default(SquareMutualMark squareMutualMark, String str, long j3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = squareMutualMark.iconUrl;
        }
        if ((i3 & 2) != 0) {
            j3 = squareMutualMark.markType;
        }
        return squareMutualMark.copy(str, j3);
    }
}
