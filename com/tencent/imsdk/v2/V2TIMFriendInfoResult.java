package com.tencent.imsdk.v2;

import com.tencent.imsdk.relationship.FriendInfoResult;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes7.dex */
public class V2TIMFriendInfoResult implements Serializable {
    private FriendInfoResult friendInfoResult = new FriendInfoResult();

    public V2TIMFriendInfo getFriendInfo() {
        V2TIMFriendInfo v2TIMFriendInfo = new V2TIMFriendInfo();
        v2TIMFriendInfo.setFriendInfo(this.friendInfoResult.getFriendInfo());
        return v2TIMFriendInfo;
    }

    public int getRelation() {
        return this.friendInfoResult.getRelationType();
    }

    public int getResultCode() {
        return this.friendInfoResult.getErrorCode();
    }

    public String getResultInfo() {
        return this.friendInfoResult.getErrorMessage();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setFriendInfoResult(FriendInfoResult friendInfoResult) {
        this.friendInfoResult = friendInfoResult;
    }
}
