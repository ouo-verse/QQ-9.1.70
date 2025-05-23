package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProClientPresence implements Serializable {
    public String bigIcon;
    public int clientId;
    public String clientName;
    public String details;
    public long endTimeStamp;
    public long expireTimeStamp;
    public long partyMax;
    public long partySize;
    public String role;
    long serialVersionUID;
    public String smallIcon;
    public long startTimeStamp;
    public String state;

    public GProClientPresence() {
        this.serialVersionUID = 1L;
        this.clientName = "";
        this.bigIcon = "";
        this.state = "";
        this.details = "";
        this.role = "";
        this.smallIcon = "";
    }

    public String getBigIcon() {
        return this.bigIcon;
    }

    public int getClientId() {
        return this.clientId;
    }

    public String getClientName() {
        return this.clientName;
    }

    public String getDetails() {
        return this.details;
    }

    public long getEndTimeStamp() {
        return this.endTimeStamp;
    }

    public long getExpireTimeStamp() {
        return this.expireTimeStamp;
    }

    public long getPartyMax() {
        return this.partyMax;
    }

    public long getPartySize() {
        return this.partySize;
    }

    public String getRole() {
        return this.role;
    }

    public String getSmallIcon() {
        return this.smallIcon;
    }

    public long getStartTimeStamp() {
        return this.startTimeStamp;
    }

    public String getState() {
        return this.state;
    }

    public String toString() {
        return "GProClientPresence{clientId=" + this.clientId + ",clientName=" + this.clientName + ",bigIcon=" + this.bigIcon + ",state=" + this.state + ",details=" + this.details + ",partySize=" + this.partySize + ",partyMax=" + this.partyMax + ",role=" + this.role + ",startTimeStamp=" + this.startTimeStamp + ",endTimeStamp=" + this.endTimeStamp + ",expireTimeStamp=" + this.expireTimeStamp + ",smallIcon=" + this.smallIcon + ",}";
    }

    public GProClientPresence(int i3, String str, String str2, String str3, String str4, long j3, long j16, String str5, long j17, long j18, long j19, String str6) {
        this.serialVersionUID = 1L;
        this.clientId = i3;
        this.clientName = str;
        this.bigIcon = str2;
        this.state = str3;
        this.details = str4;
        this.partySize = j3;
        this.partyMax = j16;
        this.role = str5;
        this.startTimeStamp = j17;
        this.endTimeStamp = j18;
        this.expireTimeStamp = j19;
        this.smallIcon = str6;
    }
}
