package com.huya.huyasdk.data;

/* compiled from: P */
/* loaded from: classes2.dex */
public class RegisterResultInfo {
    public static final int PUSH_REGISTER_FAIL = 1;
    public static final int PUSH_REGISTER_SUCCESS = 0;
    public String error;
    public String groupId;
    public int status;

    public RegisterResultInfo(int i3) {
        this.groupId = "";
        this.error = "";
        this.status = i3;
    }

    public String getError() {
        return this.error;
    }

    public String getGroupId() {
        return this.groupId;
    }

    public int getStatus() {
        return this.status;
    }

    public void setError(String str) {
        this.error = str;
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }

    public void setStatus(int i3) {
        this.status = i3;
    }

    public String toString() {
        return "RegisterResultInfo{groupId='" + this.groupId + "', status=" + this.status + ", error='" + this.error + "'}";
    }

    public RegisterResultInfo(String str, int i3, String str2) {
        this.groupId = str;
        this.status = i3;
        this.error = str2;
    }
}
