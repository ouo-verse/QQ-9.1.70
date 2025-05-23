package com.tencent.state.square.avatar.filament;

import com.tencent.mobileqq.vas.banner.c;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J1\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u001a\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001c\u001a\u00020\u001dH\u00d6\u0001J\t\u0010\u001e\u001a\u00020\u001fH\u00d6\u0001R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006 "}, d2 = {"Lcom/tencent/state/square/avatar/filament/LoadFilamentAssetsStatistics;", "", "loadMoodConfigCost", "", "loadMoodConfigFromNet", "", "loadHostAvatarInfoCost", "loadGuestAvatarInfoCost", "(JZJJ)V", "getLoadGuestAvatarInfoCost", "()J", "setLoadGuestAvatarInfoCost", "(J)V", "getLoadHostAvatarInfoCost", "setLoadHostAvatarInfoCost", "getLoadMoodConfigCost", "setLoadMoodConfigCost", "getLoadMoodConfigFromNet", "()Z", "setLoadMoodConfigFromNet", "(Z)V", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class LoadFilamentAssetsStatistics {
    private long loadGuestAvatarInfoCost;
    private long loadHostAvatarInfoCost;
    private long loadMoodConfigCost;
    private boolean loadMoodConfigFromNet;

    public LoadFilamentAssetsStatistics() {
        this(0L, false, 0L, 0L, 15, null);
    }

    /* renamed from: component1, reason: from getter */
    public final long getLoadMoodConfigCost() {
        return this.loadMoodConfigCost;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getLoadMoodConfigFromNet() {
        return this.loadMoodConfigFromNet;
    }

    /* renamed from: component3, reason: from getter */
    public final long getLoadHostAvatarInfoCost() {
        return this.loadHostAvatarInfoCost;
    }

    /* renamed from: component4, reason: from getter */
    public final long getLoadGuestAvatarInfoCost() {
        return this.loadGuestAvatarInfoCost;
    }

    public final LoadFilamentAssetsStatistics copy(long loadMoodConfigCost, boolean loadMoodConfigFromNet, long loadHostAvatarInfoCost, long loadGuestAvatarInfoCost) {
        return new LoadFilamentAssetsStatistics(loadMoodConfigCost, loadMoodConfigFromNet, loadHostAvatarInfoCost, loadGuestAvatarInfoCost);
    }

    public final long getLoadGuestAvatarInfoCost() {
        return this.loadGuestAvatarInfoCost;
    }

    public final long getLoadHostAvatarInfoCost() {
        return this.loadHostAvatarInfoCost;
    }

    public final long getLoadMoodConfigCost() {
        return this.loadMoodConfigCost;
    }

    public final boolean getLoadMoodConfigFromNet() {
        return this.loadMoodConfigFromNet;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int a16 = c.a(this.loadMoodConfigCost) * 31;
        boolean z16 = this.loadMoodConfigFromNet;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return ((((a16 + i3) * 31) + c.a(this.loadHostAvatarInfoCost)) * 31) + c.a(this.loadGuestAvatarInfoCost);
    }

    public final void setLoadGuestAvatarInfoCost(long j3) {
        this.loadGuestAvatarInfoCost = j3;
    }

    public final void setLoadHostAvatarInfoCost(long j3) {
        this.loadHostAvatarInfoCost = j3;
    }

    public final void setLoadMoodConfigCost(long j3) {
        this.loadMoodConfigCost = j3;
    }

    public final void setLoadMoodConfigFromNet(boolean z16) {
        this.loadMoodConfigFromNet = z16;
    }

    public String toString() {
        return "LoadFilamentAssetsStatistics(loadMoodConfigCost=" + this.loadMoodConfigCost + ", loadMoodConfigFromNet=" + this.loadMoodConfigFromNet + ", loadHostAvatarInfoCost=" + this.loadHostAvatarInfoCost + ", loadGuestAvatarInfoCost=" + this.loadGuestAvatarInfoCost + ")";
    }

    public LoadFilamentAssetsStatistics(long j3, boolean z16, long j16, long j17) {
        this.loadMoodConfigCost = j3;
        this.loadMoodConfigFromNet = z16;
        this.loadHostAvatarInfoCost = j16;
        this.loadGuestAvatarInfoCost = j17;
    }

    public /* synthetic */ LoadFilamentAssetsStatistics(long j3, boolean z16, long j16, long j17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0L : j3, (i3 & 2) != 0 ? false : z16, (i3 & 4) != 0 ? 0L : j16, (i3 & 8) != 0 ? 0L : j17);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LoadFilamentAssetsStatistics)) {
            return false;
        }
        LoadFilamentAssetsStatistics loadFilamentAssetsStatistics = (LoadFilamentAssetsStatistics) other;
        return this.loadMoodConfigCost == loadFilamentAssetsStatistics.loadMoodConfigCost && this.loadMoodConfigFromNet == loadFilamentAssetsStatistics.loadMoodConfigFromNet && this.loadHostAvatarInfoCost == loadFilamentAssetsStatistics.loadHostAvatarInfoCost && this.loadGuestAvatarInfoCost == loadFilamentAssetsStatistics.loadGuestAvatarInfoCost;
    }
}
