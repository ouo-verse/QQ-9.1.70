package com.tencent.imsdk.v2;

import com.tencent.imsdk.relationship.FriendApplication;
import com.tencent.imsdk.relationship.FriendApplicationResult;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public class V2TIMFriendApplicationResult implements Serializable {
    private FriendApplicationResult friendApplicationResult;
    private List<V2TIMFriendApplication> v2TIMFriendApplicationList = new ArrayList();

    public List<V2TIMFriendApplication> getFriendApplicationList() {
        return this.v2TIMFriendApplicationList;
    }

    public int getUnreadCount() {
        return this.friendApplicationResult.getUnreadCount();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setFriendApplicationResult(FriendApplicationResult friendApplicationResult) {
        this.v2TIMFriendApplicationList.clear();
        for (FriendApplication friendApplication : friendApplicationResult.getFriendApplicationList()) {
            V2TIMFriendApplication v2TIMFriendApplication = new V2TIMFriendApplication();
            v2TIMFriendApplication.setFriendApplication(friendApplication);
            this.v2TIMFriendApplicationList.add(v2TIMFriendApplication);
        }
        this.friendApplicationResult = friendApplicationResult;
    }
}
