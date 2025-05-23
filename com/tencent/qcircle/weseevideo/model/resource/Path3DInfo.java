package com.tencent.qcircle.weseevideo.model.resource;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0003H\u00d6\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qcircle/weseevideo/model/resource/Path3DInfo;", "", "originalImagePath", "", "depthImagePath", "(Ljava/lang/String;Ljava/lang/String;)V", "getDepthImagePath", "()Ljava/lang/String;", "setDepthImagePath", "(Ljava/lang/String;)V", "getOriginalImagePath", "setOriginalImagePath", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "libtavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes22.dex */
public final /* data */ class Path3DInfo {

    @NotNull
    private String depthImagePath;

    @NotNull
    private String originalImagePath;

    public Path3DInfo(@NotNull String originalImagePath, @NotNull String depthImagePath) {
        Intrinsics.checkParameterIsNotNull(originalImagePath, "originalImagePath");
        Intrinsics.checkParameterIsNotNull(depthImagePath, "depthImagePath");
        this.originalImagePath = originalImagePath;
        this.depthImagePath = depthImagePath;
    }

    public static /* synthetic */ Path3DInfo copy$default(Path3DInfo path3DInfo, String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = path3DInfo.originalImagePath;
        }
        if ((i3 & 2) != 0) {
            str2 = path3DInfo.depthImagePath;
        }
        return path3DInfo.copy(str, str2);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getOriginalImagePath() {
        return this.originalImagePath;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getDepthImagePath() {
        return this.depthImagePath;
    }

    @NotNull
    public final Path3DInfo copy(@NotNull String originalImagePath, @NotNull String depthImagePath) {
        Intrinsics.checkParameterIsNotNull(originalImagePath, "originalImagePath");
        Intrinsics.checkParameterIsNotNull(depthImagePath, "depthImagePath");
        return new Path3DInfo(originalImagePath, depthImagePath);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof Path3DInfo) {
                Path3DInfo path3DInfo = (Path3DInfo) other;
                if (!Intrinsics.areEqual(this.originalImagePath, path3DInfo.originalImagePath) || !Intrinsics.areEqual(this.depthImagePath, path3DInfo.depthImagePath)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @NotNull
    public final String getDepthImagePath() {
        return this.depthImagePath;
    }

    @NotNull
    public final String getOriginalImagePath() {
        return this.originalImagePath;
    }

    public int hashCode() {
        int i3;
        String str = this.originalImagePath;
        int i16 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i17 = i3 * 31;
        String str2 = this.depthImagePath;
        if (str2 != null) {
            i16 = str2.hashCode();
        }
        return i17 + i16;
    }

    public final void setDepthImagePath(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.depthImagePath = str;
    }

    public final void setOriginalImagePath(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.originalImagePath = str;
    }

    @NotNull
    public String toString() {
        return "Path3DInfo(originalImagePath=" + this.originalImagePath + ", depthImagePath=" + this.depthImagePath + ")";
    }
}
