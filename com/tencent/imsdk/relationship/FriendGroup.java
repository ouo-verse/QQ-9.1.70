package com.tencent.imsdk.relationship;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public class FriendGroup implements Serializable {
    private String groupName;
    private int userCount;
    private List<String> userIDList = new ArrayList();

    protected void addUserID(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.userIDList.add(str);
        }
    }

    public String getGroupName() {
        return this.groupName;
    }

    public int getUserCount() {
        return this.userCount;
    }

    public List<String> getUserIDList() {
        return this.userIDList;
    }
}
