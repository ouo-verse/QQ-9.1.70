package com.tencent.state.battery;

import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.state.square.data.Resource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0006H\u00c6\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0014\u001a\u00020\u0003H\u00d6\u0001J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/state/battery/SquareBatteryLevelItem;", "", "minLevel", "", "maxLevel", "resource", "Lcom/tencent/state/square/data/Resource;", "(IILcom/tencent/state/square/data/Resource;)V", "getMaxLevel", "()I", "getMinLevel", "getResource", "()Lcom/tencent/state/square/data/Resource;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final /* data */ class SquareBatteryLevelItem {
    private final int maxLevel;
    private final int minLevel;
    private final Resource resource;

    public SquareBatteryLevelItem(int i3, int i16, Resource resource) {
        Intrinsics.checkNotNullParameter(resource, "resource");
        this.minLevel = i3;
        this.maxLevel = i16;
        this.resource = resource;
    }

    /* renamed from: component1, reason: from getter */
    public final int getMinLevel() {
        return this.minLevel;
    }

    /* renamed from: component2, reason: from getter */
    public final int getMaxLevel() {
        return this.maxLevel;
    }

    /* renamed from: component3, reason: from getter */
    public final Resource getResource() {
        return this.resource;
    }

    public final SquareBatteryLevelItem copy(int minLevel, int maxLevel, Resource resource) {
        Intrinsics.checkNotNullParameter(resource, "resource");
        return new SquareBatteryLevelItem(minLevel, maxLevel, resource);
    }

    public final int getMaxLevel() {
        return this.maxLevel;
    }

    public final int getMinLevel() {
        return this.minLevel;
    }

    public final Resource getResource() {
        return this.resource;
    }

    public int hashCode() {
        int i3 = ((this.minLevel * 31) + this.maxLevel) * 31;
        Resource resource = this.resource;
        return i3 + (resource != null ? resource.hashCode() : 0);
    }

    public String toString() {
        return '{' + this.minLevel + '-' + this.maxLevel + MsgSummary.STR_COLON + this.resource.getActionId() + '}';
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SquareBatteryLevelItem)) {
            return false;
        }
        SquareBatteryLevelItem squareBatteryLevelItem = (SquareBatteryLevelItem) other;
        return this.minLevel == squareBatteryLevelItem.minLevel && this.maxLevel == squareBatteryLevelItem.maxLevel && Intrinsics.areEqual(this.resource, squareBatteryLevelItem.resource);
    }

    public static /* synthetic */ SquareBatteryLevelItem copy$default(SquareBatteryLevelItem squareBatteryLevelItem, int i3, int i16, Resource resource, int i17, Object obj) {
        if ((i17 & 1) != 0) {
            i3 = squareBatteryLevelItem.minLevel;
        }
        if ((i17 & 2) != 0) {
            i16 = squareBatteryLevelItem.maxLevel;
        }
        if ((i17 & 4) != 0) {
            resource = squareBatteryLevelItem.resource;
        }
        return squareBatteryLevelItem.copy(i3, i16, resource);
    }
}
