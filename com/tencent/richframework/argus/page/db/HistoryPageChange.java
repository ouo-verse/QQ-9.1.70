package com.tencent.richframework.argus.page.db;

import com.tencent.richframework.argus.node.NodePO;
import com.tencent.richframework.argus.page.PageInfoPO;
import java.util.List;

/* loaded from: classes25.dex */
public class HistoryPageChange {
    public String actionInfo;
    public List<NodePO> addBlocks;
    public int count;
    public List<NodePO> firstShowBlocks;
    public int isSameRootWithGroup;
    public PageInfoPO toPage;

    public String toString() {
        return "HistoryPageChange{toPage=" + this.toPage + ", isSameRootWithGroup=" + this.isSameRootWithGroup + ", actionInfo='" + this.actionInfo + "', addBlocks=" + this.addBlocks + ", count=" + this.count + '}';
    }
}
