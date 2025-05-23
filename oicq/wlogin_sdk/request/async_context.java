package oicq.wlogin_sdk.request;

import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.tlv_type.tlv_t;
import oicq.wlogin_sdk.tlv_type.tlv_t104;
import oicq.wlogin_sdk.tlv_type.tlv_t105;
import oicq.wlogin_sdk.tlv_type.tlv_t126;
import oicq.wlogin_sdk.tlv_type.tlv_t165;
import oicq.wlogin_sdk.tlv_type.tlv_t174;
import oicq.wlogin_sdk.tlv_type.tlv_t17b;
import oicq.wlogin_sdk.tlv_type.tlv_t402;
import oicq.wlogin_sdk.tlv_type.tlv_t403;
import oicq.wlogin_sdk.tlv_type.tlv_t543;
import oicq.wlogin_sdk.tlv_type.tlv_t546;
import oicq.wlogin_sdk.tools.ErrMsg;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class async_context {
    public tlv_t543 a1List;
    public tlv_t tlv113;
    public tlv_t tlv528;
    public tlv_t tlv530;
    public tlv_t tlv540;
    public tlv_t543 tlv543In119;
    public long _sappid = 0;
    public long _appid = 0;
    public long _sub_appid = 0;
    public long[] _sub_appid_list = new long[0];
    public int _main_sigmap = 0;
    public byte[] _tmp_pwd = new byte[16];
    public int _tmp_pwd_type = 0;
    public byte[] _tmp_no_pic_sig = new byte[0];
    public byte[] tgtQR = new byte[0];
    public int _last_flowid = 0;
    public int _login_bitmap = 0;
    public ErrMsg _last_err_msg = new ErrMsg();
    public byte[] _tgtgt_key = new byte[16];
    private tlv_t104 _t104 = new tlv_t104();
    public tlv_t105 _t105 = new tlv_t105();
    public tlv_t165 _t165 = new tlv_t165();
    public tlv_t126 _t126 = new tlv_t126();
    public boolean _sec_guid_flag = false;
    public tlv_t402 _t402 = new tlv_t402();
    public tlv_t403 _t403 = new tlv_t403();
    public byte[] _dpwd = new byte[16];
    public byte[] _G = new byte[16];
    public tlv_t546 _t546 = new tlv_t546();
    public byte[] _pow_data = new byte[0];
    public tlv_t174 _t174 = new tlv_t174();
    public tlv_t17b _t17b = new tlv_t17b();
    public tlv_t543 _t543 = new tlv_t543();
    public byte[] _t542_data = new byte[0];
    public DevlockInfo _devlock_info = new DevlockInfo();
    public String _smslogin_msg = "";
    public int _smslogin_msgcnt = 0;
    public int _smslogin_timelimit = 0;
    public int _smslogin_zone = 0;
    public String _smslogin_hint_mobile = "";
    public long _msalt = 0;
    public String _mpasswd = "";
    public boolean _isSmslogin = false;
    public long _uin = 0;
    public int _weixinUserFlags = 0;

    public tlv_t104 get_t104() {
        if (this._t104 != null) {
            util.LOGI("async_context get_t104 = " + util.buf_to_string(this._t104.get_data(), 4), " ");
        }
        return this._t104;
    }

    public boolean ifQQLoginInQim(long j3) {
        if (this._appid == 1600001287 && j3 == 13) {
            return true;
        }
        return false;
    }

    public void set_t104(tlv_t104 tlv_t104Var) {
        if (tlv_t104Var != null) {
            util.LOGI("async_context set_t104 = " + util.buf_to_string(tlv_t104Var.get_data(), 4), " ");
        }
        this._t104 = tlv_t104Var;
    }
}
