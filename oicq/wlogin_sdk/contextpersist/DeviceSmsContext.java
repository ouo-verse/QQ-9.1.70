package oicq.wlogin_sdk.contextpersist;

import java.util.Arrays;
import oicq.wlogin_sdk.tlv_type.tlv_t104;
import oicq.wlogin_sdk.tlv_type.tlv_t174;
import oicq.wlogin_sdk.tlv_type.tlv_t402;
import oicq.wlogin_sdk.tlv_type.tlv_t403;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class DeviceSmsContext extends PersistContext {
    public static final String MMKV_KEY_CONTEXT_PERSIST_DEVICE_SMS_VERIFY = "context_persist_device_sms_verify";
    private final String _mpasswd;
    private final long[] _sub_appid_list;
    private final tlv_t174 _t174;
    private final tlv_t402 _t402;
    private final tlv_t403 _t403;
    private final byte[] _tgtgt_key;
    private final long mSalt;
    private final tlv_t104 tlv_t104;

    public DeviceSmsContext(tlv_t104 tlv_t104Var, tlv_t174 tlv_t174Var, tlv_t402 tlv_t402Var, tlv_t403 tlv_t403Var, long j3, String str, byte[] bArr, long[] jArr) {
        this.tlv_t104 = tlv_t104Var;
        this._t174 = tlv_t174Var;
        this._t402 = tlv_t402Var;
        this._t403 = tlv_t403Var;
        this.mSalt = j3;
        this._mpasswd = str;
        this._tgtgt_key = bArr;
        this._sub_appid_list = jArr;
    }

    public long getSalt() {
        return this.mSalt;
    }

    public tlv_t104 getTlv_t104() {
        return this.tlv_t104;
    }

    public long[] get_sub_appid_list() {
        return this._sub_appid_list;
    }

    public tlv_t174 get_t174() {
        return this._t174;
    }

    public tlv_t402 get_t402() {
        return this._t402;
    }

    public tlv_t403 get_t403() {
        return this._t403;
    }

    public byte[] get_tgtgt_key() {
        return this._tgtgt_key;
    }

    public String getpasswd() {
        return this._mpasswd;
    }

    public String toString() {
        return "DeviceSmsContext{tlv_t104=" + util.buf_to_string(this.tlv_t104.get_data()) + ", _t174=" + util.buf_to_string(this._t174.get_data()) + ", _t402=" + util.buf_to_string(this._t402.get_data()) + ", _t403=" + util.buf_to_string(this._t403.get_data()) + ", mSalt=" + this.mSalt + ", _mpasswd='" + this._mpasswd + "', _tgtgt_key=" + Arrays.toString(this._tgtgt_key) + ", _sub_appid_list=" + Arrays.toString(this._sub_appid_list) + '}';
    }
}
