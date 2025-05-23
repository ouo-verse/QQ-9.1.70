package com.tencent.ttpic.videoshelf.model.template;

import com.google.gson.annotations.Expose;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public class VideoFrameItem {

    @Expose
    private int frameID;

    @Expose
    private int nodeGroupID;

    @Expose
    private List<FrameNodeItem> nodeList;

    public int getFrameID() {
        return this.frameID;
    }

    public int getNodeGroupID() {
        return this.nodeGroupID;
    }

    public List<FrameNodeItem> getNodeList() {
        return this.nodeList;
    }
}
