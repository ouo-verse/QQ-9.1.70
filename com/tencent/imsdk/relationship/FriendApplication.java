package com.tencent.imsdk.relationship;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes7.dex */
public class FriendApplication implements Serializable {
    private String addSource;
    private long addTime;
    private String addWording;
    private int applicationType;
    private String faceUrl;
    private String nickName;
    private String userID;

    public String getAddSource() {
        return this.addSource;
    }

    public long getAddTime() {
        return this.addTime;
    }

    public String getAddWording() {
        return this.addWording;
    }

    public int getApplicationType() {
        return this.applicationType;
    }

    public String getFaceUrl() {
        return this.faceUrl;
    }

    public String getNickName() {
        return this.nickName;
    }

    public String getUserID() {
        return this.userID;
    }
}
