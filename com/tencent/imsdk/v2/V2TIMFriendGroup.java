package com.tencent.imsdk.v2;

import com.tencent.imsdk.relationship.FriendGroup;
import java.io.Serializable;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public class V2TIMFriendGroup implements Serializable {
    private FriendGroup friendGroup = new FriendGroup();

    public long getFriendCount() {
        return this.friendGroup.getUserCount();
    }

    public List<String> getFriendIDList() {
        return this.friendGroup.getUserIDList();
    }

    public String getName() {
        return this.friendGroup.getGroupName();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setFriendGroup(FriendGroup friendGroup) {
        this.friendGroup = friendGroup;
    }
}
