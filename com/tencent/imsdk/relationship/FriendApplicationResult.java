package com.tencent.imsdk.relationship;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public class FriendApplicationResult implements Serializable {
    private List<FriendApplication> friendApplicationList = new ArrayList();
    private int unreadCount;

    public List<FriendApplication> getFriendApplicationList() {
        return this.friendApplicationList;
    }

    public int getUnreadCount() {
        return this.unreadCount;
    }
}
