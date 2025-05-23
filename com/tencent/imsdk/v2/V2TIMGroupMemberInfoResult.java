package com.tencent.imsdk.v2;

import com.tencent.imsdk.group.GroupMemberInfo;
import com.tencent.imsdk.group.GroupMemberInfoResult;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public class V2TIMGroupMemberInfoResult implements Serializable {
    private long nextSeq;
    private List<V2TIMGroupMemberFullInfo> v2TIMGroupMemberFullInfoList = new ArrayList();

    public List<V2TIMGroupMemberFullInfo> getMemberInfoList() {
        return this.v2TIMGroupMemberFullInfoList;
    }

    public long getNextSeq() {
        return this.nextSeq;
    }

    public void setGroupMemberInfoResult(GroupMemberInfoResult groupMemberInfoResult) {
        this.nextSeq = groupMemberInfoResult.getNextSeq();
        this.v2TIMGroupMemberFullInfoList.clear();
        List<GroupMemberInfo> groupMemberInfoList = groupMemberInfoResult.getGroupMemberInfoList();
        for (int i3 = 0; i3 < groupMemberInfoList.size(); i3++) {
            V2TIMGroupMemberFullInfo v2TIMGroupMemberFullInfo = new V2TIMGroupMemberFullInfo();
            v2TIMGroupMemberFullInfo.setGroupMemberInfo(groupMemberInfoList.get(i3));
            this.v2TIMGroupMemberFullInfoList.add(v2TIMGroupMemberFullInfo);
        }
    }
}
