package cooperation.vip.tianshu.bean;

/* compiled from: P */
/* loaded from: classes28.dex */
public class TSSplashUserAction {
    private int mActionId;
    private long mActionTime;
    private String mAdId;

    public TSSplashUserAction(String str, int i3) {
        this.mAdId = str;
        this.mActionId = i3;
    }

    public int getActionId() {
        return this.mActionId;
    }

    public long getActionTime() {
        return this.mActionTime;
    }

    public String getAdId() {
        return this.mAdId;
    }

    public void setActionId(int i3) {
        this.mActionId = i3;
    }

    public void setActionTime(long j3) {
        this.mActionTime = j3;
    }

    public void setAdId(String str) {
        this.mAdId = str;
    }

    public String toString() {
        return "TSSplashUserAction{mAdId='" + this.mAdId + "', mActionId=" + this.mActionId + ", mActionTime=" + this.mActionTime + '}';
    }
}
