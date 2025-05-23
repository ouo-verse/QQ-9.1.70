package com.vivo.push.model;

/* compiled from: P */
/* loaded from: classes13.dex */
public class SubscribeAppInfo {
    public static final int SUBSCIRBE = 1;
    public static final int SUBSCIRBE_CANCLE = 2;
    private int mActualStatus;
    private String mName;
    private int mTargetStatus;

    public SubscribeAppInfo(String str, int i3, int i16) {
        this.mName = str;
        this.mTargetStatus = i3;
        this.mActualStatus = i16;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SubscribeAppInfo subscribeAppInfo = (SubscribeAppInfo) obj;
        String str = this.mName;
        if (str == null) {
            if (subscribeAppInfo.mName != null) {
                return false;
            }
        } else if (!str.equals(subscribeAppInfo.mName)) {
            return false;
        }
        if (this.mTargetStatus == subscribeAppInfo.mTargetStatus) {
            return true;
        }
        return false;
    }

    public int getActualStatus() {
        return this.mActualStatus;
    }

    public String getName() {
        return this.mName;
    }

    public int getTargetStatus() {
        return this.mTargetStatus;
    }

    public int hashCode() {
        int hashCode;
        String str = this.mName;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return ((hashCode + 31) * 31) + this.mTargetStatus;
    }

    public void setActualStatus(int i3) {
        this.mActualStatus = i3;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void setTargetStatus(int i3) {
        this.mTargetStatus = i3;
    }

    public String toString() {
        return "SubscribeAppInfo [mName=" + this.mName + ", mTargetStatus=" + this.mTargetStatus + ", mActualStatus=" + this.mActualStatus + "]";
    }
}
