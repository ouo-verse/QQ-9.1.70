package com.tencent.qcircle.weseevideo.model.resource;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Deprecated(message = "nest class")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qcircle/weseevideo/model/resource/ResourceExtra;", "Ljava/io/Serializable;", "threeDPath", "Lcom/tencent/qcircle/weseevideo/model/resource/Path3DInfo;", "(Lcom/tencent/qcircle/weseevideo/model/resource/Path3DInfo;)V", "getThreeDPath", "()Lcom/tencent/qcircle/weseevideo/model/resource/Path3DInfo;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "libtavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes22.dex */
public final /* data */ class ResourceExtra implements Serializable {

    @SerializedName("3d_path")
    @NotNull
    private final Path3DInfo threeDPath;

    public ResourceExtra(@NotNull Path3DInfo threeDPath) {
        Intrinsics.checkParameterIsNotNull(threeDPath, "threeDPath");
        this.threeDPath = threeDPath;
    }

    public static /* synthetic */ ResourceExtra copy$default(ResourceExtra resourceExtra, Path3DInfo path3DInfo, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            path3DInfo = resourceExtra.threeDPath;
        }
        return resourceExtra.copy(path3DInfo);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final Path3DInfo getThreeDPath() {
        return this.threeDPath;
    }

    @NotNull
    public final ResourceExtra copy(@NotNull Path3DInfo threeDPath) {
        Intrinsics.checkParameterIsNotNull(threeDPath, "threeDPath");
        return new ResourceExtra(threeDPath);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (!(other instanceof ResourceExtra) || !Intrinsics.areEqual(this.threeDPath, ((ResourceExtra) other).threeDPath)) {
                return false;
            }
            return true;
        }
        return true;
    }

    @NotNull
    public final Path3DInfo getThreeDPath() {
        return this.threeDPath;
    }

    public int hashCode() {
        Path3DInfo path3DInfo = this.threeDPath;
        if (path3DInfo != null) {
            return path3DInfo.hashCode();
        }
        return 0;
    }

    @NotNull
    public String toString() {
        return "ResourceExtra(threeDPath=" + this.threeDPath + ")";
    }
}
