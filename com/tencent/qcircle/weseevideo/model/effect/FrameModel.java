package com.tencent.qcircle.weseevideo.model.effect;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087D\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u00020\b8\u0006X\u0087D\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0016\u0010\r\u001a\u00020\b8\u0006X\u0087D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u0016\u0010\u000f\u001a\u00020\b8\u0006X\u0087D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\nR\u0016\u0010\u0011\u001a\u00020\b8\u0006X\u0087D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\n\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qcircle/weseevideo/model/effect/FrameModel;", "", "()V", "angle", "", "getAngle", "()I", "centerX", "", "getCenterX", "()F", "centerY", "getCenterY", "maxScale", "getMaxScale", "minScale", "getMinScale", "scale", "getScale", "libtavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes22.dex */
public final class FrameModel {

    @SerializedName("angle")
    private final int angle;

    @SerializedName("minScale")
    private final float minScale = 0.2f;

    @SerializedName("maxScale")
    private final float maxScale = 1.0f;

    @SerializedName("scale")
    private final float scale = 0.6f;

    @SerializedName("centerX")
    private final float centerX = 0.5f;

    @SerializedName("centerY")
    private final float centerY = 0.5f;

    public final int getAngle() {
        return this.angle;
    }

    public final float getCenterX() {
        return this.centerX;
    }

    public final float getCenterY() {
        return this.centerY;
    }

    public final float getMaxScale() {
        return this.maxScale;
    }

    public final float getMinScale() {
        return this.minScale;
    }

    public final float getScale() {
        return this.scale;
    }
}
