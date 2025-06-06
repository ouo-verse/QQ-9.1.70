package com.tencent.mobileqq.weiyun.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import cooperation.qzone.api.QZoneContant;

/* loaded from: classes20.dex */
public final class WeiyunPB$MsgHead extends MessageMicro<WeiyunPB$MsgHead> {
    public static final int APPID_FIELD_NUMBER = 5;
    public static final int AUTH_CODE_FIELD_NUMBER = 31;
    public static final int CAN_ACCEL_FIELD_NUMBER = 203;
    public static final int CLIENTIP_FIELD_NUMBER = 8;
    public static final int CMD_FIELD_NUMBER = 4;
    public static final int DISASTER_FLAG_FIELD_NUMBER = 91;
    public static final int EMULATOR_FLAG_FIELD_NUMBER = 16;
    public static final int ENCRYPTKEY_FIELD_NUMBER = 11;
    public static final int ENCRYPT_FIELD_NUMBER = 9;
    public static final int FIX_VERSION_FIELD_NUMBER = 19;
    public static final int KEYTYPE_FIELD_NUMBER = 10;
    public static final int LOGIN_KEYTYPE_FIELD_NUMBER = 12;
    public static final int LOGIN_KEY_FIELD_NUMBER = 13;
    public static final int MAJOR_VERSION_FIELD_NUMBER = 14;
    public static final int MINOR_VERSION_FIELD_NUMBER = 15;
    public static final int NETTYPE_FIELD_NUMBER = 7;
    public static final int QUA_FIELD_NUMBER = 18;
    public static final int RETCODE_FIELD_NUMBER = 101;
    public static final int RETMSG_FIELD_NUMBER = 102;
    public static final int ReqMsg = 1;
    public static final int RspMsg = 2;
    public static final int SEQ_FIELD_NUMBER = 2;
    public static final int SRC_MODULE_ID_FIELD_NUMBER = 21;
    public static final int TPLINK_KEY_FIELD_NUMBER = 204;
    public static final int TYPE_FIELD_NUMBER = 3;
    public static final int UIN_FIELD_NUMBER = 1;
    public static final int VERIFY_SESSION_FIELD_NUMBER = 32;
    public static final int VERSION_FIELD_NUMBER = 6;
    public static final int WEIYUN_HOST_FIELD_NUMBER = 201;
    public static final int WEIYUN_PORT_FIELD_NUMBER = 202;
    public static final int ZIP_FLAG_FIELD_NUMBER = 17;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField auth_code;
    public final PBBoolField can_accel;
    public final PBInt32Field disaster_flag;
    public final PBInt32Field emulator_flag;
    public final PBBytesField encryptkey;
    public final PBInt32Field fix_version;
    public final PBBytesField login_key;
    public final PBInt32Field login_keytype;
    public final PBInt32Field major_version;
    public final PBInt32Field minor_version;
    public final PBStringField qua;
    public final PBInt32Field retcode;
    public final PBStringField retmsg;
    public final PBInt32Field src_module_id;
    public final PBInt64Field tplink_key;
    public final PBStringField verify_session;
    public final PBStringField weiyun_host;
    public final PBInt32Field weiyun_port;
    public final PBInt32Field zip_flag;
    public final PBInt64Field uin = PBField.initInt64(0);
    public final PBUInt32Field seq = PBField.initUInt32(0);
    public final PBEnumField type = PBField.initEnum(1);
    public final PBEnumField cmd = PBField.initEnum(26113);
    public final PBInt32Field appid = PBField.initInt32(0);
    public final PBInt32Field version = PBField.initInt32(0);
    public final PBInt32Field nettype = PBField.initInt32(0);
    public final PBStringField clientip = PBField.initString("");
    public final PBInt32Field encrypt = PBField.initInt32(0);
    public final PBInt32Field keytype = PBField.initInt32(0);

    static {
        int[] iArr = {8, 16, 24, 32, 40, 48, 56, 66, 72, 80, 90, 96, 106, 112, 120, 128, 136, 146, 152, 168, 250, 258, 728, 808, 818, 1610, QZoneContant.QZ_START_FEED_DETAIL_REQ, 1624, 1632};
        String[] strArr = {"uin", "seq", "type", "cmd", "appid", "version", TPReportKeys.LiveExKeys.LIVE_EX_NET_TYPE, "clientip", "encrypt", "keytype", "encryptkey", "login_keytype", "login_key", "major_version", "minor_version", "emulator_flag", "zip_flag", "qua", "fix_version", "src_module_id", "auth_code", "verify_session", "disaster_flag", "retcode", "retmsg", "weiyun_host", "weiyun_port", "can_accel", "tplink_key"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(iArr, strArr, new Object[]{0L, 0, 1, 26113, 0, 0, 0, "", 0, 0, byteStringMicro, 0, byteStringMicro, 0, 0, 0, 0, "", 0, 0, "", "", 0, 0, "", "", 0, Boolean.FALSE, 0L}, WeiyunPB$MsgHead.class);
    }

    public WeiyunPB$MsgHead() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.encryptkey = PBField.initBytes(byteStringMicro);
        this.login_keytype = PBField.initInt32(0);
        this.login_key = PBField.initBytes(byteStringMicro);
        this.major_version = PBField.initInt32(0);
        this.minor_version = PBField.initInt32(0);
        this.emulator_flag = PBField.initInt32(0);
        this.zip_flag = PBField.initInt32(0);
        this.qua = PBField.initString("");
        this.fix_version = PBField.initInt32(0);
        this.src_module_id = PBField.initInt32(0);
        this.auth_code = PBField.initString("");
        this.verify_session = PBField.initString("");
        this.disaster_flag = PBField.initInt32(0);
        this.retcode = PBField.initInt32(0);
        this.retmsg = PBField.initString("");
        this.weiyun_host = PBField.initString("");
        this.weiyun_port = PBField.initInt32(0);
        this.can_accel = PBField.initBool(false);
        this.tplink_key = PBField.initInt64(0L);
    }
}
