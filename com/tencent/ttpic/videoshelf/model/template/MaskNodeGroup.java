package com.tencent.ttpic.videoshelf.model.template;

import com.google.gson.annotations.Expose;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public class MaskNodeGroup {

    @Expose
    private String nodeGroupCoverImage;

    @Expose
    private int nodeGroupID;

    @Expose
    private String nodeGroupMaskImage;

    @Expose
    private List<MaskNodeItem> nodeList;

    public String getNodeGroupCoverImage() {
        return this.nodeGroupCoverImage;
    }

    public int getNodeGroupID() {
        return this.nodeGroupID;
    }

    public String getNodeGroupMaskImage() {
        return this.nodeGroupMaskImage;
    }

    public List<MaskNodeItem> getNodeList() {
        return this.nodeList;
    }
}
