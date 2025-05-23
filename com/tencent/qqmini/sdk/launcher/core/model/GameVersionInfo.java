package com.tencent.qqmini.sdk.launcher.core.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001J\t\u0010\u0011\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqmini/sdk/launcher/core/model/GameVersionInfo;", "", "jsLibVersion", "", "tritonVersion", "(Ljava/lang/String;Ljava/lang/String;)V", "getJsLibVersion", "()Ljava/lang/String;", "getTritonVersion", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "lib_minilauncher_internalRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes23.dex */
public final /* data */ class GameVersionInfo {

    @NotNull
    private final String jsLibVersion;

    @NotNull
    private final String tritonVersion;

    public GameVersionInfo(@NotNull String jsLibVersion, @NotNull String tritonVersion) {
        Intrinsics.checkParameterIsNotNull(jsLibVersion, "jsLibVersion");
        Intrinsics.checkParameterIsNotNull(tritonVersion, "tritonVersion");
        this.jsLibVersion = jsLibVersion;
        this.tritonVersion = tritonVersion;
    }

    public static /* synthetic */ GameVersionInfo copy$default(GameVersionInfo gameVersionInfo, String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = gameVersionInfo.jsLibVersion;
        }
        if ((i3 & 2) != 0) {
            str2 = gameVersionInfo.tritonVersion;
        }
        return gameVersionInfo.copy(str, str2);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getJsLibVersion() {
        return this.jsLibVersion;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getTritonVersion() {
        return this.tritonVersion;
    }

    @NotNull
    public final GameVersionInfo copy(@NotNull String jsLibVersion, @NotNull String tritonVersion) {
        Intrinsics.checkParameterIsNotNull(jsLibVersion, "jsLibVersion");
        Intrinsics.checkParameterIsNotNull(tritonVersion, "tritonVersion");
        return new GameVersionInfo(jsLibVersion, tritonVersion);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof GameVersionInfo) {
                GameVersionInfo gameVersionInfo = (GameVersionInfo) other;
                if (!Intrinsics.areEqual(this.jsLibVersion, gameVersionInfo.jsLibVersion) || !Intrinsics.areEqual(this.tritonVersion, gameVersionInfo.tritonVersion)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @NotNull
    public final String getJsLibVersion() {
        return this.jsLibVersion;
    }

    @NotNull
    public final String getTritonVersion() {
        return this.tritonVersion;
    }

    public int hashCode() {
        int i3;
        String str = this.jsLibVersion;
        int i16 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i17 = i3 * 31;
        String str2 = this.tritonVersion;
        if (str2 != null) {
            i16 = str2.hashCode();
        }
        return i17 + i16;
    }

    @NotNull
    public String toString() {
        return "GameVersionInfo(jsLibVersion=" + this.jsLibVersion + ", tritonVersion=" + this.tritonVersion + ")";
    }
}
