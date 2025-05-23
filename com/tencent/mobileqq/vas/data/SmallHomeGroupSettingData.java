package com.tencent.mobileqq.vas.data;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0005H\u00c6\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u00d6\u0003J\t\u0010\u001b\u001a\u00020\u0005H\u00d6\u0001J\u0006\u0010\u001c\u001a\u00020\u0018J\t\u0010\u001d\u001a\u00020\u001eH\u00d6\u0001R\u0011\u0010\b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/vas/data/SmallHomeGroupSettingData;", "Ljava/io/Serializable;", "troopUin", "", "enterSwitch", "", "rankSwitch", "onlineSwitch", "addedSwitch", "(JIIII)V", "getAddedSwitch", "()I", "getEnterSwitch", "getOnlineSwitch", "getRankSwitch", "getTroopUin", "()J", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "needSettingShow", "toString", "", "zplan_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final /* data */ class SmallHomeGroupSettingData implements Serializable {
    private final int addedSwitch;
    private final int enterSwitch;
    private final int onlineSwitch;
    private final int rankSwitch;
    private final long troopUin;

    public SmallHomeGroupSettingData() {
        this(0L, 0, 0, 0, 0, 31, null);
    }

    public static /* synthetic */ SmallHomeGroupSettingData copy$default(SmallHomeGroupSettingData smallHomeGroupSettingData, long j3, int i3, int i16, int i17, int i18, int i19, Object obj) {
        if ((i19 & 1) != 0) {
            j3 = smallHomeGroupSettingData.troopUin;
        }
        long j16 = j3;
        if ((i19 & 2) != 0) {
            i3 = smallHomeGroupSettingData.enterSwitch;
        }
        int i26 = i3;
        if ((i19 & 4) != 0) {
            i16 = smallHomeGroupSettingData.rankSwitch;
        }
        int i27 = i16;
        if ((i19 & 8) != 0) {
            i17 = smallHomeGroupSettingData.onlineSwitch;
        }
        int i28 = i17;
        if ((i19 & 16) != 0) {
            i18 = smallHomeGroupSettingData.addedSwitch;
        }
        return smallHomeGroupSettingData.copy(j16, i26, i27, i28, i18);
    }

    /* renamed from: component1, reason: from getter */
    public final long getTroopUin() {
        return this.troopUin;
    }

    /* renamed from: component2, reason: from getter */
    public final int getEnterSwitch() {
        return this.enterSwitch;
    }

    /* renamed from: component3, reason: from getter */
    public final int getRankSwitch() {
        return this.rankSwitch;
    }

    /* renamed from: component4, reason: from getter */
    public final int getOnlineSwitch() {
        return this.onlineSwitch;
    }

    /* renamed from: component5, reason: from getter */
    public final int getAddedSwitch() {
        return this.addedSwitch;
    }

    @NotNull
    public final SmallHomeGroupSettingData copy(long troopUin, int enterSwitch, int rankSwitch, int onlineSwitch, int addedSwitch) {
        return new SmallHomeGroupSettingData(troopUin, enterSwitch, rankSwitch, onlineSwitch, addedSwitch);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SmallHomeGroupSettingData)) {
            return false;
        }
        SmallHomeGroupSettingData smallHomeGroupSettingData = (SmallHomeGroupSettingData) other;
        if (this.troopUin == smallHomeGroupSettingData.troopUin && this.enterSwitch == smallHomeGroupSettingData.enterSwitch && this.rankSwitch == smallHomeGroupSettingData.rankSwitch && this.onlineSwitch == smallHomeGroupSettingData.onlineSwitch && this.addedSwitch == smallHomeGroupSettingData.addedSwitch) {
            return true;
        }
        return false;
    }

    public final int getAddedSwitch() {
        return this.addedSwitch;
    }

    public final int getEnterSwitch() {
        return this.enterSwitch;
    }

    public final int getOnlineSwitch() {
        return this.onlineSwitch;
    }

    public final int getRankSwitch() {
        return this.rankSwitch;
    }

    public final long getTroopUin() {
        return this.troopUin;
    }

    public int hashCode() {
        return (((((((androidx.fragment.app.a.a(this.troopUin) * 31) + this.enterSwitch) * 31) + this.rankSwitch) * 31) + this.onlineSwitch) * 31) + this.addedSwitch;
    }

    public final boolean needSettingShow() {
        if (this.enterSwitch == 0 && this.rankSwitch == 0 && this.onlineSwitch == 0 && this.addedSwitch == 0) {
            return false;
        }
        return true;
    }

    @NotNull
    public String toString() {
        return "SmallHomeGroupSettingData(troopUin=" + this.troopUin + ", enterSwitch=" + this.enterSwitch + ", rankSwitch=" + this.rankSwitch + ", onlineSwitch=" + this.onlineSwitch + ", addedSwitch=" + this.addedSwitch + ')';
    }

    public SmallHomeGroupSettingData(long j3, int i3, int i16, int i17, int i18) {
        this.troopUin = j3;
        this.enterSwitch = i3;
        this.rankSwitch = i16;
        this.onlineSwitch = i17;
        this.addedSwitch = i18;
    }

    public /* synthetic */ SmallHomeGroupSettingData(long j3, int i3, int i16, int i17, int i18, int i19, DefaultConstructorMarker defaultConstructorMarker) {
        this((i19 & 1) != 0 ? 0L : j3, (i19 & 2) != 0 ? 0 : i3, (i19 & 4) != 0 ? 0 : i16, (i19 & 8) != 0 ? 0 : i17, (i19 & 16) != 0 ? 0 : i18);
    }
}
