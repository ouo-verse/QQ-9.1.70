package com.tencent.qcircle.weseevideo.model.template.auto;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qcircle/weseevideo/model/template/auto/AEFramePAGItem;", "", "()V", "pagName", "", "getPagName", "()Ljava/lang/String;", "setPagName", "(Ljava/lang/String;)V", "visibleRatio", "", "getVisibleRatio", "()F", "setVisibleRatio", "(F)V", "visibleRegion", "Lcom/tencent/qcircle/weseevideo/model/template/auto/AEFrameVisibleRegion;", "getVisibleRegion", "()Lcom/tencent/qcircle/weseevideo/model/template/auto/AEFrameVisibleRegion;", "setVisibleRegion", "(Lcom/tencent/qcircle/weseevideo/model/template/auto/AEFrameVisibleRegion;)V", "libtavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes22.dex */
public final class AEFramePAGItem {

    @SerializedName("visibleRatio")
    private float visibleRatio;

    @SerializedName("pagName")
    @NotNull
    private String pagName = "";

    @SerializedName("visibleRegion")
    @NotNull
    private AEFrameVisibleRegion visibleRegion = new AEFrameVisibleRegion();

    @NotNull
    public final String getPagName() {
        return this.pagName;
    }

    public final float getVisibleRatio() {
        return this.visibleRatio;
    }

    @NotNull
    public final AEFrameVisibleRegion getVisibleRegion() {
        return this.visibleRegion;
    }

    public final void setPagName(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.pagName = str;
    }

    public final void setVisibleRatio(float f16) {
        this.visibleRatio = f16;
    }

    public final void setVisibleRegion(@NotNull AEFrameVisibleRegion aEFrameVisibleRegion) {
        Intrinsics.checkParameterIsNotNull(aEFrameVisibleRegion, "<set-?>");
        this.visibleRegion = aEFrameVisibleRegion;
    }
}
