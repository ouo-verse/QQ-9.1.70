package com.tencent.mobileqq.mini.entry.expDesktop.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0012\u001a\u00020\u0005H\u00d6\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/bean/ExpDesktopAppModuleLayoutInfo;", "", "direction", "", "aggregate", "", "(ILjava/lang/String;)V", "getAggregate", "()Ljava/lang/String;", "getDirection", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final /* data */ class ExpDesktopAppModuleLayoutInfo {
    private final String aggregate;
    private final int direction;

    public ExpDesktopAppModuleLayoutInfo(int i3, String str) {
        this.direction = i3;
        this.aggregate = str;
    }

    /* renamed from: component1, reason: from getter */
    public final int getDirection() {
        return this.direction;
    }

    /* renamed from: component2, reason: from getter */
    public final String getAggregate() {
        return this.aggregate;
    }

    public final ExpDesktopAppModuleLayoutInfo copy(int direction, String aggregate) {
        return new ExpDesktopAppModuleLayoutInfo(direction, aggregate);
    }

    public final String getAggregate() {
        return this.aggregate;
    }

    public final int getDirection() {
        return this.direction;
    }

    public int hashCode() {
        int i3 = this.direction * 31;
        String str = this.aggregate;
        return i3 + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "ExpDesktopAppModuleLayoutInfo(direction=" + this.direction + ", aggregate=" + this.aggregate + ")";
    }

    public static /* synthetic */ ExpDesktopAppModuleLayoutInfo copy$default(ExpDesktopAppModuleLayoutInfo expDesktopAppModuleLayoutInfo, int i3, String str, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = expDesktopAppModuleLayoutInfo.direction;
        }
        if ((i16 & 2) != 0) {
            str = expDesktopAppModuleLayoutInfo.aggregate;
        }
        return expDesktopAppModuleLayoutInfo.copy(i3, str);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExpDesktopAppModuleLayoutInfo)) {
            return false;
        }
        ExpDesktopAppModuleLayoutInfo expDesktopAppModuleLayoutInfo = (ExpDesktopAppModuleLayoutInfo) other;
        return this.direction == expDesktopAppModuleLayoutInfo.direction && Intrinsics.areEqual(this.aggregate, expDesktopAppModuleLayoutInfo.aggregate);
    }
}
