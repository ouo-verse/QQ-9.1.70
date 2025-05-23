package com.tencent.hippy.qq.obj;

import com.google.gson.annotations.SerializedName;
import com.tencent.freesia.IConfigData;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\u00048\u0006X\u0087D\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/hippy/qq/obj/HippyDomConfigBean;", "Lcom/tencent/freesia/IConfigData;", "()V", "domNodeCacheDuration", "", "getDomNodeCacheDuration", "()I", "preNodeSnapshotSwitch", "getPreNodeSnapshotSwitch", "toString", "", "hippy-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes7.dex */
public final class HippyDomConfigBean implements IConfigData {

    @SerializedName("domNodeCacheDuration")
    private final int domNodeCacheDuration = 10080;

    @SerializedName("preNodeSnapshotSwitch")
    private final int preNodeSnapshotSwitch;

    public final int getDomNodeCacheDuration() {
        return this.domNodeCacheDuration;
    }

    public final int getPreNodeSnapshotSwitch() {
        return this.preNodeSnapshotSwitch;
    }

    @NotNull
    public String toString() {
        return "HippyDomConfigBean(preNodeSnapshotSwitch=" + this.preNodeSnapshotSwitch + ", domNodeCacheDuration=" + this.domNodeCacheDuration + ')';
    }
}
