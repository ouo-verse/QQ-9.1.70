package cooperation.qqcircle.beans;

import uq3.n;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QCircleVVGameConfigBean {
    private long mGetConfigTime;
    private long mLastStartTime;
    private int mVVCount;
    private String mVVFailedTip;
    private String mVVReason;
    private String mVVTopSucceedTip;

    public long getGetConfigTime() {
        return this.mGetConfigTime;
    }

    public long getLastStartTime() {
        return this.mLastStartTime;
    }

    public int getVVCount() {
        return this.mVVCount;
    }

    public String getVVFailedTip() {
        return this.mVVFailedTip;
    }

    public String getVVReason() {
        return this.mVVReason;
    }

    public String getVVTopSucceedTip() {
        return this.mVVTopSucceedTip;
    }

    public boolean isTaskTimeOut() {
        if (this.mLastStartTime <= 0) {
            return false;
        }
        return !n.c(System.currentTimeMillis(), this.mLastStartTime);
    }

    public void setGetConfigTime(long j3) {
        this.mGetConfigTime = j3;
    }

    public void setLastStartTime(long j3) {
        this.mLastStartTime = j3;
    }

    public void setVVCount(int i3) {
        this.mVVCount = i3;
    }

    public void setVVFailedTip(String str) {
        this.mVVFailedTip = str;
    }

    public void setVVReason(String str) {
        this.mVVReason = str;
    }

    public void setVVTopSucceedTip(String str) {
        this.mVVTopSucceedTip = str;
    }

    public String toString() {
        return "QCircleVVGameConfigBean{mVVCount=" + this.mVVCount + ", mVVReason='" + this.mVVReason + "', mVVTopSucceedTip='" + this.mVVTopSucceedTip + "', mVVFailedTip='" + this.mVVFailedTip + "', mGetConfigTime=" + this.mGetConfigTime + ", mLastStartTime=" + this.mLastStartTime + '}';
    }
}
