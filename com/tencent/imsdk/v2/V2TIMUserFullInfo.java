package com.tencent.imsdk.v2;

import com.tencent.imsdk.relationship.UserInfo;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes7.dex */
public class V2TIMUserFullInfo extends V2TIMUserInfo {
    public static final String PROFILE_TYPE_KEY_ALLOWTYPE = "Tag_Profile_IM_AllowType";
    public static final String PROFILE_TYPE_KEY_CUSTOM_PREFIX = "Tag_Profile_Custom_";
    public static final String PROFILE_TYPE_KEY_FACEURL = "Tag_Profile_IM_Image";
    public static final String PROFILE_TYPE_KEY_GENDER = "Tag_Profile_IM_Gender";
    public static final String PROFILE_TYPE_KEY_NICK = "Tag_Profile_IM_Nick";
    public static final String PROFILE_TYPE_KEY_SELF_SIGNATURE = "Tag_Profile_IM_SelfSignature";
    public static final int V2TIM_FRIEND_ALLOW_ANY = 0;
    public static final int V2TIM_FRIEND_DENY_ANY = 2;
    public static final int V2TIM_FRIEND_NEED_CONFIRM = 1;
    public static final int V2TIM_GENDER_FEMALE = 2;
    public static final int V2TIM_GENDER_MALE = 1;
    public static final int V2TIM_GENDER_UNKNOWN = 0;

    public int getAllowType() {
        int allowType = this.userInfo.getAllowType();
        if (allowType == 2) {
            return 2;
        }
        if (allowType == 1 || allowType != 0) {
            return 1;
        }
        return 0;
    }

    public HashMap<String, byte[]> getCustomInfo() {
        return this.userInfo.getCustomUserInfoString();
    }

    public int getGender() {
        int gender = this.userInfo.getGender();
        if (gender == 1) {
            return 1;
        }
        if (gender == 2) {
            return 2;
        }
        return 0;
    }

    public int getLevel() {
        return this.userInfo.getLevel();
    }

    public int getRole() {
        return this.userInfo.getRole();
    }

    public String getSelfSignature() {
        return this.userInfo.getSignature();
    }

    public void setAllowType(int i3) {
        if (i3 == 0) {
            this.userInfo.setAllowType(0);
            this.modifyParams.put("Tag_Profile_IM_AllowType", UserInfo.USERINFO_ALLOWTYPE_TYPE_ALLOWANY);
        } else if (2 == i3) {
            this.userInfo.setAllowType(2);
            this.modifyParams.put("Tag_Profile_IM_AllowType", UserInfo.USERINFO_ALLOWTYPE_TYPE_DENYANY);
        } else if (1 == i3) {
            this.userInfo.setAllowType(1);
            this.modifyParams.put("Tag_Profile_IM_AllowType", UserInfo.USERINFO_ALLOWTYPE_TYPE_NEEDCONFIRM);
        } else {
            this.userInfo.setAllowType(1);
            this.modifyParams.put("Tag_Profile_IM_AllowType", UserInfo.USERINFO_ALLOWTYPE_TYPE_NEEDCONFIRM);
        }
    }

    public void setCustomInfo(HashMap<String, byte[]> hashMap) {
        if (hashMap != null && hashMap.size() != 0) {
            for (Map.Entry<String, byte[]> entry : hashMap.entrySet()) {
                if (entry.getKey().contains("Tag_Profile_Custom_")) {
                    this.modifyParams.put(entry.getKey(), entry.getValue());
                } else {
                    this.modifyParams.put("Tag_Profile_Custom_" + entry.getKey(), new String(entry.getValue()));
                }
            }
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMUserInfo
    public void setFaceUrl(String str) {
        super.setFaceUrl(str);
    }

    public void setGender(int i3) {
        if (1 == i3) {
            this.userInfo.setGender(1);
            this.modifyParams.put("Tag_Profile_IM_Gender", UserInfo.USERINFO_GENDER_TYPE_MALE);
        } else if (2 == i3) {
            this.userInfo.setGender(2);
            this.modifyParams.put("Tag_Profile_IM_Gender", UserInfo.USERINFO_GENDER_TYPE_FEMALE);
        } else {
            this.userInfo.setGender(0);
            this.modifyParams.put("Tag_Profile_IM_Gender", UserInfo.USERINFO_GENDER_TYPE_UNKNOWN);
        }
    }

    public void setLevel(int i3) {
        this.userInfo.setLevel(i3);
        this.modifyParams.put(UserInfo.USERINFO_KEY_LEVEL, Integer.valueOf(i3));
    }

    public void setNickname(String str) {
        super.setNickName(str);
    }

    public void setRole(int i3) {
        this.userInfo.setRole(i3);
        this.modifyParams.put(UserInfo.USERINFO_KEY_ROLE, Integer.valueOf(i3));
    }

    public void setSelfSignature(String str) {
        this.userInfo.setSignature(str);
        this.modifyParams.put("Tag_Profile_IM_SelfSignature", str);
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("V2TIMUserFullInfo--->");
        HashMap<String, byte[]> customInfo = getCustomInfo();
        StringBuilder sb6 = new StringBuilder();
        if (customInfo != null) {
            sb6.append("\n");
            for (Map.Entry<String, byte[]> entry : customInfo.entrySet()) {
                sb6.append(" |key:" + entry.getKey() + ", value:" + new String(entry.getValue()));
                sb6.append("\n");
            }
        }
        sb5.append("userID:");
        sb5.append(getUserID());
        sb5.append(", nickName:");
        sb5.append(getNickName());
        sb5.append(", gender:");
        sb5.append(getGender());
        sb5.append(", faceUrl:");
        sb5.append(getFaceUrl());
        sb5.append(", selfSignature:");
        sb5.append(getSelfSignature());
        sb5.append(", allowType:");
        sb5.append(getAllowType());
        sb5.append(", customInfo:");
        sb5.append(sb6.toString());
        return sb5.toString();
    }
}
