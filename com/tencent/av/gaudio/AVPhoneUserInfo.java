package com.tencent.av.gaudio;

import java.io.Serializable;

/* loaded from: classes3.dex */
public class AVPhoneUserInfo implements Serializable {
    public int accountType = 0;
    public long account = 0;
    public TelInfo telInfo = new TelInfo();

    /* loaded from: classes3.dex */
    public class TelInfo implements Serializable {
        public String mobile;
        public String nation;
        public int nationState;
        public String prefix;

        public TelInfo() {
        }

        public String toString() {
            return "TelInfo--> Nation = " + this.nation + ", Prefix = " + this.prefix + ", Mobile = " + this.mobile + ", nationState = " + this.nationState;
        }
    }

    public String toString() {
        return "AVUserInfo-->Account = " + this.account + " , AccountType = " + this.accountType + " , TelInfo = " + this.telInfo + " .";
    }
}
