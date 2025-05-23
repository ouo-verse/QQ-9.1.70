package oicq.wlogin_sdk.request;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes28.dex */
public class WloginLastLoginInfo implements Serializable {
    private static final long serialVersionUID = 1;
    public String mAccount;
    public long mUin;

    public WloginLastLoginInfo() {
        new String();
        this.mUin = 0L;
        this.mAccount = "";
    }

    public WloginLastLoginInfo(String str, long j3) {
        new String();
        this.mAccount = str;
        this.mUin = j3;
    }
}
