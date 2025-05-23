package oicq.wlogin_sdk.request;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes28.dex */
public class UinInfo implements Serializable {
    private static final long serialVersionUID = 1;
    public boolean _hasPassword;
    public Long _uin;
    private int pwdState;

    public UinInfo(Long l3, boolean z16) {
        int i3;
        this.pwdState = 0;
        this._uin = l3;
        this._hasPassword = z16;
        if (z16) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        this.pwdState = i3;
    }

    public boolean getHasPassword() {
        boolean z16 = true;
        if (!this._hasPassword && this.pwdState > 1) {
            z16 = false;
        }
        this._hasPassword = z16;
        return z16;
    }
}
