package com.tencent.state.utils;

import com.google.gson.annotations.SerializedName;
import com.tencent.state.data.SwitchConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0014H\u00d6\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/state/utils/SquareCommonConfig;", "", "disableIntimateMTK", "", "mp4PlayBlockDevices", "", "Lcom/tencent/state/utils/SquareDeviceFilter;", "(ZLjava/util/List;)V", "getDisableIntimateMTK", "()Z", "getMp4PlayBlockDevices", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class SquareCommonConfig {

    @SerializedName(SwitchConfig.Key.intimateMTKDisabled)
    private final boolean disableIntimateMTK;

    @SerializedName("ztp_mp4_play_block_devices")
    private final List<SquareDeviceFilter> mp4PlayBlockDevices;

    public SquareCommonConfig() {
        this(false, null, 3, 0 == true ? 1 : 0);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getDisableIntimateMTK() {
        return this.disableIntimateMTK;
    }

    public final List<SquareDeviceFilter> component2() {
        return this.mp4PlayBlockDevices;
    }

    public final SquareCommonConfig copy(boolean disableIntimateMTK, List<SquareDeviceFilter> mp4PlayBlockDevices) {
        Intrinsics.checkNotNullParameter(mp4PlayBlockDevices, "mp4PlayBlockDevices");
        return new SquareCommonConfig(disableIntimateMTK, mp4PlayBlockDevices);
    }

    public final boolean getDisableIntimateMTK() {
        return this.disableIntimateMTK;
    }

    public final List<SquareDeviceFilter> getMp4PlayBlockDevices() {
        return this.mp4PlayBlockDevices;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z16 = this.disableIntimateMTK;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i3 = r06 * 31;
        List<SquareDeviceFilter> list = this.mp4PlayBlockDevices;
        return i3 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "SquareCommonConfig(disableIntimateMTK=" + this.disableIntimateMTK + ", mp4PlayBlockDevices=" + this.mp4PlayBlockDevices + ")";
    }

    public SquareCommonConfig(boolean z16, List<SquareDeviceFilter> mp4PlayBlockDevices) {
        Intrinsics.checkNotNullParameter(mp4PlayBlockDevices, "mp4PlayBlockDevices");
        this.disableIntimateMTK = z16;
        this.mp4PlayBlockDevices = mp4PlayBlockDevices;
    }

    public /* synthetic */ SquareCommonConfig(boolean z16, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16, (i3 & 2) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SquareCommonConfig)) {
            return false;
        }
        SquareCommonConfig squareCommonConfig = (SquareCommonConfig) other;
        return this.disableIntimateMTK == squareCommonConfig.disableIntimateMTK && Intrinsics.areEqual(this.mp4PlayBlockDevices, squareCommonConfig.mp4PlayBlockDevices);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SquareCommonConfig copy$default(SquareCommonConfig squareCommonConfig, boolean z16, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = squareCommonConfig.disableIntimateMTK;
        }
        if ((i3 & 2) != 0) {
            list = squareCommonConfig.mp4PlayBlockDevices;
        }
        return squareCommonConfig.copy(z16, list);
    }
}
