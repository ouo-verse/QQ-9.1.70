package com.tencent.mobileqq.zootopia.download.mod.hotpatch;

import com.tencent.mobileqq.troop.announcement.api.ITroopAnnouncementHelperApi;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0007H\u00c6\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u00d6\u0003J\t\u0010\u0016\u001a\u00020\u0017H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/zootopia/download/mod/hotpatch/ZPlanModHotPatchConfig;", "Ljava/io/Serializable;", "modId", "", "enableHotPatch", "", ITroopAnnouncementHelperApi.CONTROL_INFO_VAILD_TIME, "", "(Ljava/lang/String;ZJ)V", "getEnableHotPatch", "()Z", "getModId", "()Ljava/lang/String;", "getValidTime", "()J", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final /* data */ class ZPlanModHotPatchConfig implements Serializable {
    private final boolean enableHotPatch;
    private final String modId;
    private final long validTime;

    public ZPlanModHotPatchConfig(String modId, boolean z16, long j3) {
        Intrinsics.checkNotNullParameter(modId, "modId");
        this.modId = modId;
        this.enableHotPatch = z16;
        this.validTime = j3;
    }

    /* renamed from: component1, reason: from getter */
    public final String getModId() {
        return this.modId;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getEnableHotPatch() {
        return this.enableHotPatch;
    }

    /* renamed from: component3, reason: from getter */
    public final long getValidTime() {
        return this.validTime;
    }

    public final ZPlanModHotPatchConfig copy(String modId, boolean enableHotPatch, long validTime) {
        Intrinsics.checkNotNullParameter(modId, "modId");
        return new ZPlanModHotPatchConfig(modId, enableHotPatch, validTime);
    }

    public final boolean getEnableHotPatch() {
        return this.enableHotPatch;
    }

    public final String getModId() {
        return this.modId;
    }

    public final long getValidTime() {
        return this.validTime;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.modId.hashCode() * 31;
        boolean z16 = this.enableHotPatch;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return ((hashCode + i3) * 31) + com.tencent.mobileqq.vas.banner.c.a(this.validTime);
    }

    public String toString() {
        return "ZPlanModHotPatchConfig(modId=" + this.modId + ", enableHotPatch=" + this.enableHotPatch + ", validTime=" + this.validTime + ")";
    }

    public /* synthetic */ ZPlanModHotPatchConfig(String str, boolean z16, long j3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? false : z16, j3);
    }

    public static /* synthetic */ ZPlanModHotPatchConfig copy$default(ZPlanModHotPatchConfig zPlanModHotPatchConfig, String str, boolean z16, long j3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = zPlanModHotPatchConfig.modId;
        }
        if ((i3 & 2) != 0) {
            z16 = zPlanModHotPatchConfig.enableHotPatch;
        }
        if ((i3 & 4) != 0) {
            j3 = zPlanModHotPatchConfig.validTime;
        }
        return zPlanModHotPatchConfig.copy(str, z16, j3);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZPlanModHotPatchConfig)) {
            return false;
        }
        ZPlanModHotPatchConfig zPlanModHotPatchConfig = (ZPlanModHotPatchConfig) other;
        return Intrinsics.areEqual(this.modId, zPlanModHotPatchConfig.modId) && this.enableHotPatch == zPlanModHotPatchConfig.enableHotPatch && this.validTime == zPlanModHotPatchConfig.validTime;
    }
}
