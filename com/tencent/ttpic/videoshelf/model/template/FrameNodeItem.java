package com.tencent.ttpic.videoshelf.model.template;

import com.google.gson.annotations.Expose;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public class FrameNodeItem {

    @Expose
    private int blendMode;

    @Expose
    private List<MaskBlock> maskBlockList;

    @Expose
    private int nodeID;

    @Expose
    private int zIndex;

    public int getBlendMode() {
        return this.blendMode;
    }

    public List<MaskBlock> getMaskBlockList() {
        return this.maskBlockList;
    }

    public int getNodeID() {
        return this.nodeID;
    }

    public int getZIndex() {
        return this.zIndex;
    }
}
