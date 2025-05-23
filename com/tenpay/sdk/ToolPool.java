package com.tenpay.sdk;

import com.tencent.mobileqq.qwallet.utils.g;
import com.tenpay.QwLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes27.dex */
public class ToolPool {
    public static final String RSA_2048 = "rsa_2048";
    private static final String TAG = "ToolPool";
    private List<String> ecdh_cgis;
    private List<String> open_setting;

    /* loaded from: classes27.dex */
    private static class Ins {
        public static ToolPool mInstance = new ToolPool();

        Ins() {
        }
    }

    public static ToolPool instance() {
        return Ins.mInstance;
    }

    public String getParamsEncryptType() {
        return g.i("params_encrypt_type");
    }

    public String getPwdEncryptType() {
        return g.i("pwd_encrypt_type");
    }

    public boolean isEcdhEncrypt(String str) {
        if (isUseOldEnc()) {
            return false;
        }
        QwLog.i("no ecdh config = " + this.ecdh_cgis);
        Iterator<String> it = this.ecdh_cgis.iterator();
        while (it.hasNext()) {
            if (str.contains(it.next())) {
                return true;
            }
        }
        return false;
    }

    public boolean isInfo2048() {
        return RSA_2048.equals(getParamsEncryptType());
    }

    public boolean isPwd2048() {
        return RSA_2048.equals(getPwdEncryptType());
    }

    public boolean isRSASettingUrl(String str) {
        return this.open_setting.contains(str);
    }

    public boolean isUseOldEnc() {
        return g.b("use_old_enc");
    }

    public void setParamsEncryptType(String str) {
        g.q("params_encrypt_type", str);
    }

    public void setPwdEncryptType(String str) {
        g.q("pwd_encrypt_type", str);
    }

    public void setUseOldEnc(boolean z16) {
        g.l("use_old_enc", z16);
    }

    public String toString() {
        return String.format("pwd_encrypt_type = %s\nparams_encrypt_type = %s\n", getPwdEncryptType(), getParamsEncryptType());
    }

    ToolPool() {
        this.ecdh_cgis = new ArrayList();
        this.open_setting = new ArrayList(Arrays.asList(Cgi.URL_WALLET_GATE, Cgi.URI_PAY_GATE, Cgi.URI_PASS_SDK_AUTH));
    }
}
