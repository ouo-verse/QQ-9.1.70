package com.tencent.imsdk.v2;

import com.tencent.imsdk.group.GroupInfoGetResult;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes7.dex */
public class V2TIMGroupInfoResult implements Serializable {
    private GroupInfoGetResult groupInfoGetResult = new GroupInfoGetResult();

    public V2TIMGroupInfo getGroupInfo() {
        V2TIMGroupInfo v2TIMGroupInfo = new V2TIMGroupInfo();
        v2TIMGroupInfo.setGroupInfo(this.groupInfoGetResult.getGroupInfo());
        return v2TIMGroupInfo;
    }

    GroupInfoGetResult getGroupInfoGetResult() {
        return this.groupInfoGetResult;
    }

    public int getResultCode() {
        return this.groupInfoGetResult.getErrorCode();
    }

    public String getResultMessage() {
        return this.groupInfoGetResult.getErrorMessage();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setGroupInfoGetResult(GroupInfoGetResult groupInfoGetResult) {
        this.groupInfoGetResult = groupInfoGetResult;
    }
}
