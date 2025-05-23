package com.tencent.imsdk.v2;

import com.tencent.imsdk.relationship.FriendInfo;
import com.tencent.imsdk.relationship.UserInfo;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes7.dex */
public class V2TIMFriendInfo implements Serializable {
    private static final String FRIEND_PROFILE_TYPE_KEY_CUSTOM_PREFIX = "Tag_SNS_Custom_";
    private static final String FRIEND_PROFILE_TYPE_KEY_REMARK = "Tag_SNS_IM_Remark";
    public static final int V2TIM_FRIEND_TYPE_BOTH = 2;
    public static final int V2TIM_FRIEND_TYPE_SINGLE = 1;
    private FriendInfo friendInfo = new FriendInfo();
    private HashMap<String, Object> modifyFriendProfileHashMap = new HashMap<>();

    public HashMap<String, byte[]> getFriendCustomInfo() {
        return this.friendInfo.getFriendCustomInfo();
    }

    public List<String> getFriendGroups() {
        return this.friendInfo.getFriendGroups();
    }

    public String getFriendRemark() {
        return this.friendInfo.getRemark();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HashMap<String, Object> getModifyFriendInfo() {
        return this.modifyFriendProfileHashMap;
    }

    public String getUserID() {
        return this.friendInfo.getUserInfo().getUserID();
    }

    public V2TIMUserFullInfo getUserProfile() {
        UserInfo userInfo = this.friendInfo.getUserInfo();
        V2TIMUserFullInfo v2TIMUserFullInfo = new V2TIMUserFullInfo();
        v2TIMUserFullInfo.setUserInfo(userInfo);
        return v2TIMUserFullInfo;
    }

    public void setFriendCustomInfo(HashMap<String, byte[]> hashMap) {
        if (hashMap != null && hashMap.size() != 0) {
            if (this.modifyFriendProfileHashMap == null) {
                this.modifyFriendProfileHashMap = new HashMap<>();
            }
            if (hashMap.entrySet() != null) {
                for (Map.Entry<String, byte[]> entry : hashMap.entrySet()) {
                    if (entry.getKey().contains(FRIEND_PROFILE_TYPE_KEY_CUSTOM_PREFIX)) {
                        this.modifyFriendProfileHashMap.put(entry.getKey(), new String(entry.getValue()));
                    } else {
                        this.modifyFriendProfileHashMap.put(FRIEND_PROFILE_TYPE_KEY_CUSTOM_PREFIX + entry.getKey(), new String(entry.getValue()));
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setFriendInfo(FriendInfo friendInfo) {
        this.friendInfo = friendInfo;
    }

    public void setFriendRemark(String str) {
        this.friendInfo.setRemark(str);
        this.modifyFriendProfileHashMap.put(FRIEND_PROFILE_TYPE_KEY_REMARK, str);
    }

    public void setUserID(String str) {
        this.friendInfo.getUserInfo().setUserID(str);
    }

    public String toString() {
        String v2TIMUserFullInfo;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("V2TIMFriendProfile--->");
        HashMap<String, byte[]> friendCustomInfo = getFriendCustomInfo();
        StringBuilder sb6 = new StringBuilder();
        if (friendCustomInfo != null) {
            sb6.append("\n");
            for (Map.Entry<String, byte[]> entry : friendCustomInfo.entrySet()) {
                sb6.append(" |key:" + entry.getKey() + ", value:" + new String(entry.getValue()));
                sb6.append("\n");
            }
        }
        sb5.append("userID:");
        sb5.append(getUserID());
        sb5.append(", remark:");
        sb5.append(getFriendRemark());
        sb5.append(", groupNames:");
        sb5.append(getFriendGroups());
        sb5.append(", friendCustomInfo:");
        sb5.append(sb6.toString());
        sb5.append(", userProfile:");
        if (getUserProfile() == null) {
            v2TIMUserFullInfo = "";
        } else {
            v2TIMUserFullInfo = getUserProfile().toString();
        }
        sb5.append(v2TIMUserFullInfo);
        return sb5.toString();
    }
}
