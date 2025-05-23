package com.tencent.imsdk.v2;

import com.tencent.imsdk.relationship.FriendAddApplication;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes7.dex */
public class V2TIMFriendAddApplication implements Serializable {
    private FriendAddApplication friendAddApplication;

    public V2TIMFriendAddApplication(String str) {
        FriendAddApplication friendAddApplication = new FriendAddApplication();
        this.friendAddApplication = friendAddApplication;
        friendAddApplication.setUserID(str);
        this.friendAddApplication.setAddType(2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public FriendAddApplication getFriendAddApplication() {
        return this.friendAddApplication;
    }

    public void setAddSource(String str) {
        this.friendAddApplication.setAddSource(str);
    }

    public void setAddType(int i3) {
        if (i3 != 1 && i3 != 2) {
            i3 = 2;
        }
        this.friendAddApplication.setAddType(i3);
    }

    public void setAddWording(String str) {
        this.friendAddApplication.setAddWording(str);
    }

    public void setFriendGroup(String str) {
        this.friendAddApplication.setGroupName(str);
    }

    public void setFriendRemark(String str) {
        this.friendAddApplication.setRemark(str);
    }

    public void setUserID(String str) {
        this.friendAddApplication.setUserID(str);
    }
}
