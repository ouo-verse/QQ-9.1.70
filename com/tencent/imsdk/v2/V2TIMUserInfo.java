package com.tencent.imsdk.v2;

import com.tencent.imsdk.relationship.UserInfo;
import java.io.Serializable;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes7.dex */
public class V2TIMUserInfo implements Serializable {
    UserInfo userInfo = new UserInfo();
    HashMap<String, Object> modifyParams = new HashMap<>();

    public long getBirthday() {
        return this.userInfo.getBirthday();
    }

    public String getFaceUrl() {
        return this.userInfo.getFaceUrl();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HashMap<String, Object> getModifyParams() {
        return this.modifyParams;
    }

    public String getNickName() {
        return this.userInfo.getNickname();
    }

    public String getUserID() {
        return this.userInfo.getUserID();
    }

    UserInfo getUserInfo() {
        return this.userInfo;
    }

    public void setBirthday(long j3) {
        this.userInfo.setBirthday(j3);
        this.modifyParams.put(UserInfo.USERINFO_KEY_BIRTHDAY, Long.valueOf(j3));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setFaceUrl(String str) {
        this.userInfo.setFaceUrl(str);
        this.modifyParams.put("Tag_Profile_IM_Image", str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setNickName(String str) {
        this.userInfo.setNickname(str);
        this.modifyParams.put("Tag_Profile_IM_Nick", str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setUserID(String str) {
        this.userInfo.setUserID(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
