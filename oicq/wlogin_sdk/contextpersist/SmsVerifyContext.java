package oicq.wlogin_sdk.contextpersist;

import oicq.wlogin_sdk.tlv_type.tlv_t104;
import oicq.wlogin_sdk.tlv_type.tlv_t126;

/* compiled from: P */
/* loaded from: classes28.dex */
public class SmsVerifyContext extends PersistContext {
    public static final String MANAGER_ID = "101856";
    public static final String MMKV_KEY_CONTEXT_PERSIST_SMS_VERIFY = "context_persist_sms_verify";
    private final long mSalt;
    private final tlv_t104 tlv_t104;
    private final tlv_t126 tlv_t126;

    public SmsVerifyContext(tlv_t104 tlv_t104Var, tlv_t126 tlv_t126Var, long j3) {
        this.tlv_t104 = tlv_t104Var;
        this.tlv_t126 = tlv_t126Var;
        this.mSalt = j3;
    }

    public long getSalt() {
        return this.mSalt;
    }

    public tlv_t104 getTlv_t104() {
        return this.tlv_t104;
    }

    public tlv_t126 getTlv_t126() {
        return this.tlv_t126;
    }

    public String toString() {
        return "SmsVerifyContext{tlv_t104=" + this.tlv_t104 + ", tlv_t126=" + this.tlv_t126 + ", mSalt=" + this.mSalt + '}';
    }
}
