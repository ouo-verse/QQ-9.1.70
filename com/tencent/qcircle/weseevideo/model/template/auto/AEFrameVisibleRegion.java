package com.tencent.qcircle.weseevideo.model.template.auto;

import com.google.gson.annotations.SerializedName;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001e\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qcircle/weseevideo/model/template/auto/AEFrameVisibleRegion;", "", "()V", "height", "", "getHeight", "()F", "setHeight", "(F)V", "offsetX", "getOffsetX", "setOffsetX", "offsetY", "getOffsetY", "setOffsetY", BasicAnimation.KeyPath.ROTATION, "getRotation", "setRotation", "width", "getWidth", "setWidth", "libtavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes22.dex */
public final class AEFrameVisibleRegion {

    @SerializedName(HippyTKDListViewAdapter.X)
    private float offsetX;

    @SerializedName("y")
    private float offsetY;

    @SerializedName(BasicAnimation.KeyPath.ROTATION)
    private float rotation;

    @SerializedName("width")
    private float width = 1.0f;

    @SerializedName("height")
    private float height = 1.0f;

    public final float getHeight() {
        return this.height;
    }

    public final float getOffsetX() {
        return this.offsetX;
    }

    public final float getOffsetY() {
        return this.offsetY;
    }

    public final float getRotation() {
        return this.rotation;
    }

    public final float getWidth() {
        return this.width;
    }

    public final void setHeight(float f16) {
        this.height = f16;
    }

    public final void setOffsetX(float f16) {
        this.offsetX = f16;
    }

    public final void setOffsetY(float f16) {
        this.offsetY = f16;
    }

    public final void setRotation(float f16) {
        this.rotation = f16;
    }

    public final void setWidth(float f16) {
        this.width = f16;
    }
}
