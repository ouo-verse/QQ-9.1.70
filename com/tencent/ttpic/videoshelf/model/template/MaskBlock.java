package com.tencent.ttpic.videoshelf.model.template;

import com.google.gson.annotations.Expose;

/* compiled from: P */
/* loaded from: classes27.dex */
public class MaskBlock {

    @Expose
    private int blendMode;

    @Expose
    private MaskRectPoint[] maskRect;

    @Expose
    private NodeRectPoint[] nodeRect;

    @Expose
    private int zIndex;

    public int getBlendMode() {
        return this.blendMode;
    }

    public MaskRectPoint[] getMaskRect() {
        return this.maskRect;
    }

    public NodeRectPoint[] getNodeRect() {
        return this.nodeRect;
    }

    public int getZIndex() {
        return this.zIndex;
    }
}
