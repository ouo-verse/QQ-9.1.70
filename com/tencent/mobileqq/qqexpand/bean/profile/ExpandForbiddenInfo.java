package com.tencent.mobileqq.qqexpand.bean.profile;

import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes16.dex */
public class ExpandForbiddenInfo implements Serializable {
    private String faceAuthUrl;
    private String forbiddenDialogText;
    private long forbiddenDuration;
    private long forbiddenEndTime;
    private int forbiddenReason;
    private int forbiddenType;
    private boolean hasFaceRealName;
    private boolean isForbidden;

    public ExpandForbiddenInfo(boolean z16, long j3, long j16, int i3, int i16, String str) {
        this.isForbidden = z16;
        this.forbiddenEndTime = j3;
        this.forbiddenDuration = j16;
        this.forbiddenType = i3;
        this.forbiddenReason = i16;
        this.forbiddenDialogText = str;
    }

    public String getFaceAuthUrl() {
        return this.faceAuthUrl;
    }

    public long getForbiddenDuration() {
        return this.forbiddenDuration;
    }

    public long getForbiddenEndTime() {
        return this.forbiddenEndTime;
    }

    public int getForbiddenReason() {
        return this.forbiddenReason;
    }

    public String getForbiddenTips() {
        return this.forbiddenDialogText;
    }

    public int getForbiddenType() {
        return this.forbiddenType;
    }

    public long getRemainingForbiddenTime() {
        long serverTime = this.forbiddenEndTime - NetConnInfoCenter.getServerTime();
        if (serverTime < 0) {
            return 0L;
        }
        return serverTime;
    }

    public boolean isForbidden() {
        return this.isForbidden;
    }

    public boolean isHasFaceRealName() {
        return this.hasFaceRealName;
    }

    public void setFaceAuthUrl(String str) {
        this.faceAuthUrl = str;
    }

    public void setForbidden(boolean z16) {
        this.isForbidden = z16;
    }

    public void setForbiddenDuration(long j3) {
        this.forbiddenDuration = j3;
    }

    public void setForbiddenEndTime(long j3) {
        this.forbiddenEndTime = j3;
    }

    public void setForbiddenReason(int i3) {
        this.forbiddenReason = i3;
    }

    public void setForbiddenTips(String str) {
        this.forbiddenDialogText = str;
    }

    public void setForbiddenType(int i3) {
        this.forbiddenType = i3;
    }

    public void setHasFaceRealName(boolean z16) {
        this.hasFaceRealName = z16;
    }

    public String toString() {
        return "ExpandForbiddenInfo{isForbidden=" + this.isForbidden + ", forbiddenEndTime=" + this.forbiddenEndTime + ", forbiddenDuration=" + this.forbiddenDuration + ", forbiddenType=" + this.forbiddenType + ", forbiddenReason='" + this.forbiddenReason + ", forbiddenTips='" + this.forbiddenDialogText + ", hasFaceRealName=" + this.hasFaceRealName + "'}";
    }
}
