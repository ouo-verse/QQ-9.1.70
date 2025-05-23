package com.tencent.mobileqq.wink.h5native;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0005\u001a\u00020\u0004H\u00c6\u0003J\u001d\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0004H\u00c6\u0001J\t\u0010\n\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\f\u001a\u00020\u000bH\u00d6\u0001J\u0013\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0007\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0007\u0010\u0013\u00a8\u0006\u0016"}, d2 = {"com/tencent/mobileqq/wink/h5native/WinkAiPaintNativeModel$SafeInfo", "", "", "component1", "", "component2", "appID", "isLegal", "Lcom/tencent/mobileqq/wink/h5native/WinkAiPaintNativeModel$SafeInfo;", "copy", "toString", "", "hashCode", "other", "equals", "Ljava/lang/String;", "getAppID", "()Ljava/lang/String;", "Z", "()Z", "<init>", "(Ljava/lang/String;Z)V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.wink.h5native.WinkAiPaintNativeModel$SafeInfo, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class SafeInfo {

    @NotNull
    private final String appID;
    private final boolean isLegal;

    public SafeInfo(@NotNull String appID, boolean z16) {
        Intrinsics.checkNotNullParameter(appID, "appID");
        this.appID = appID;
        this.isLegal = z16;
    }

    public static /* synthetic */ SafeInfo copy$default(SafeInfo safeInfo, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = safeInfo.appID;
        }
        if ((i3 & 2) != 0) {
            z16 = safeInfo.isLegal;
        }
        return safeInfo.copy(str, z16);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getAppID() {
        return this.appID;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getIsLegal() {
        return this.isLegal;
    }

    @NotNull
    public final SafeInfo copy(@NotNull String appID, boolean isLegal) {
        Intrinsics.checkNotNullParameter(appID, "appID");
        return new SafeInfo(appID, isLegal);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SafeInfo)) {
            return false;
        }
        SafeInfo safeInfo = (SafeInfo) other;
        if (Intrinsics.areEqual(this.appID, safeInfo.appID) && this.isLegal == safeInfo.isLegal) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getAppID() {
        return this.appID;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.appID.hashCode() * 31;
        boolean z16 = this.isLegal;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode + i3;
    }

    public final boolean isLegal() {
        return this.isLegal;
    }

    @NotNull
    public String toString() {
        return "SafeInfo(appID=" + this.appID + ", isLegal=" + this.isLegal + ")";
    }
}
