package com.tencent.biz.qrcode.logindev.pclock;

import com.tencent.mm.opensdk.constants.ConstantsAPI;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0010\u0010\fR\u0017\u0010\u0015\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\t\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/biz/qrcode/logindev/pclock/f;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "b", "()I", "instanceId", "getLockStatus", "lockStatus", "c", ConstantsAPI.Token.WX_TOKEN_PLATFORMID_KEY, "d", "Ljava/lang/String;", "()Ljava/lang/String;", "devName", "<init>", "(IIILjava/lang/String;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.biz.qrcode.logindev.pclock.f, reason: from toString */
/* loaded from: classes5.dex */
public final /* data */ class UnlockPCPushModel {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int instanceId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int lockStatus;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int platformId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String devName;

    public UnlockPCPushModel(int i3, int i16, int i17, @NotNull String devName) {
        Intrinsics.checkNotNullParameter(devName, "devName");
        this.instanceId = i3;
        this.lockStatus = i16;
        this.platformId = i17;
        this.devName = devName;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getDevName() {
        return this.devName;
    }

    /* renamed from: b, reason: from getter */
    public final int getInstanceId() {
        return this.instanceId;
    }

    /* renamed from: c, reason: from getter */
    public final int getPlatformId() {
        return this.platformId;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UnlockPCPushModel)) {
            return false;
        }
        UnlockPCPushModel unlockPCPushModel = (UnlockPCPushModel) other;
        if (this.instanceId == unlockPCPushModel.instanceId && this.lockStatus == unlockPCPushModel.lockStatus && this.platformId == unlockPCPushModel.platformId && Intrinsics.areEqual(this.devName, unlockPCPushModel.devName)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.instanceId * 31) + this.lockStatus) * 31) + this.platformId) * 31) + this.devName.hashCode();
    }

    @NotNull
    public String toString() {
        return "UnlockPCPushModel(instanceId=" + this.instanceId + ", lockStatus=" + this.lockStatus + ", platformId=" + this.platformId + ", devName=" + this.devName + ")";
    }
}
