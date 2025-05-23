package cooperation.qzone.sim;

import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes28.dex */
public class SimInfo {
    private boolean mIseDataTrafficSim = false;
    private String mIMSI = "";
    private String mPhoneNum = "";

    public String getIMSI() {
        return this.mIMSI;
    }

    public String getPhoneNum() {
        return this.mPhoneNum;
    }

    public boolean isIseDataTrafficSim() {
        return this.mIseDataTrafficSim;
    }

    public void setIMSI(String str) {
        this.mIMSI = str;
    }

    public void setIsDataTrafficSim(boolean z16) {
        this.mIseDataTrafficSim = z16;
    }

    public void setPhoneNum(String str) {
        this.mPhoneNum = str;
        if (!TextUtils.isEmpty(str)) {
            String replaceAll = this.mPhoneNum.replaceAll("\\+86", "");
            this.mPhoneNum = replaceAll;
            this.mPhoneNum = replaceAll.replaceAll("\\D", "");
        }
    }

    public String toString() {
        return "SimInfo mIseDataTrafficSim=" + this.mIseDataTrafficSim + ",mIMSI=" + this.mIMSI + ",mPhoneNum=" + this.mPhoneNum;
    }
}
