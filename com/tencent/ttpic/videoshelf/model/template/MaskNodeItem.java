package com.tencent.ttpic.videoshelf.model.template;

import com.google.gson.annotations.Expose;

/* compiled from: P */
/* loaded from: classes27.dex */
public class MaskNodeItem {

    @Expose
    private int[] indexLayerForPag;

    @Expose
    private float[] maskRect;

    @Expose
    private String nodeDefaultMaskCoverImage;

    @Expose
    private int nodeGroupID;

    @Expose
    private int nodeID;

    @Expose
    private NodeTextGroup nodeTextGroup;

    @Expose
    private int nodeTextMaxCount;

    @Expose
    private int type;

    @Expose
    private int zIndex;

    public int[] getIndexLayerForPag() {
        return this.indexLayerForPag;
    }

    public float[] getMaskRect() {
        return this.maskRect;
    }

    public String getNodeDefaultMaskCoverImage() {
        return this.nodeDefaultMaskCoverImage;
    }

    public int getNodeGroupID() {
        return this.nodeGroupID;
    }

    public int getNodeID() {
        return this.nodeID;
    }

    public NodeTextGroup getNodeTextGroup() {
        return this.nodeTextGroup;
    }

    public int getNodeTextMaxCount() {
        return this.nodeTextMaxCount;
    }

    public int getType() {
        return this.type;
    }

    public int getZIndex() {
        return this.zIndex;
    }
}
