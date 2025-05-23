package com.tencent.msf.service.protocol.pb;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.open.business.base.MobileInfoUtil;
import com.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveRequestBuilder;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class SSOReserveField {
    static IPatchRedirector $redirector_ = null;
    public static final int SSO_A2_RSP_TIMEOUT = -10129;
    public static final int SSO_APPID_INVAILD = -10117;
    public static final int SSO_BAN_STATE_BEGIN = -10300;
    public static final int SSO_BAN_STATE_END = -10200;
    public static final int SSO_BAN_STATE_FORBIT_WRITE_CMD = -10201;
    public static final int SSO_BLACK_IPV6_CMD = -10112;
    public static final int SSO_CMD_NOT_CONFIGED = -10115;
    public static final int SSO_CONNECTION_FULL = -302;
    public static final int SSO_CONNECT_ACCESS_DENIED = -10131;
    public static final int SSO_CONNECT_COMM = 6;
    public static final int SSO_D2_ENCRYPTED = 1;
    public static final int SSO_D2_EXPIRED = -10001;
    public static final int SSO_D2_UIN_NOT_MATCH = -10006;
    public static final int SSO_DECRYPT_PING_FAILD = -10113;
    public static final int SSO_DEFAULT = 0;
    public static final int SSO_DEFAULT_FLAG = 0;
    public static final int SSO_DEVICE_APP = 21;
    public static final int SSO_DEVICE_COMM = 20;
    public static final int SSO_DOC_COMM = 60;
    public static final int SSO_DYEING_MESSAGE = 1;
    public static final int SSO_EMPTY_KEY_ENCRYPTED = 2;
    public static final int SSO_FORCE_RESET_KEY = -10106;
    public static final int SSO_GRAY_MESSAGE = 8;
    public static final int SSO_GUEST_MODE_NO_RIGHT = -10126;
    public static final int SSO_GUEST_MODE_SAFE_HIT = -10127;
    public static final int SSO_INVALID_A2D2 = -10003;
    public static final int SSO_INVALID_A2_CONN = -10004;
    public static final int SSO_INVALID_COOKIE = -10009;
    public static final int SSO_INVALID_PRESURE = -10120;
    public static final int SSO_IPV4_STACK = 1;
    public static final int SSO_IPV6_STACK = 2;
    public static final int SSO_IP_DUAL_STACK = 3;
    public static final int SSO_IP_ORIGIN_DEFAULT = 0;
    public static final int SSO_IP_ORIGIN_DISPATCH_DOMAIN = 4;
    public static final int SSO_IP_ORIGIN_DISPATCH_IP = 3;
    public static final int SSO_IP_ORIGIN_HARDCODE_DOMAIN = 2;
    public static final int SSO_IP_ORIGIN_HARDCODE_IP = 1;
    public static final int SSO_IP_UNDEFINED = 0;
    public static final int SSO_LOGIN_MERGE_FAILED = -10107;
    public static final int SSO_MULTI_ENV_MESSAGE = 4;
    public static final int SSO_NEED_SIGNATURE_FLAG = 4;
    public static final int SSO_NOT_TEST_UIN = -10121;
    public static final int SSO_NOT_WHITE_IPV6_CMD = -10111;
    public static final int SSO_NOT_WHITE_IPV6_UIN = -10110;
    public static final int SSO_NO_WIFI_BSSID_FLAG = 1;
    public static final int SSO_NT_FUNC_MESSAGE = 32;
    public static final int SSO_PARSE_FAILED = -10118;
    public static final int SSO_POOR_NETWORK_FLAG = 2;
    public static final int SSO_PRESSURE_MESSAGE = 16;
    public static final int SSO_PRODUCT_NO_RIGHT = -10122;
    public static final int SSO_PROTO_V0 = 0;
    public static final int SSO_PROTO_V20 = 20;
    public static final int SSO_PROTO_V21 = 21;
    public static final int SSO_QCALL_COMM = 10;
    public static final int SSO_QCALL_GUEST = 11;
    public static final int SSO_QQ_COMM = 0;
    public static final int SSO_QQ_GID_FOR_TEA_KEYEMP = 4;
    public static final int SSO_QQ_GUEST = 5;
    public static final int SSO_QQ_MAIL = 1;
    public static final int SSO_RATE_LIMIT_EXCEEDED = -10132;
    public static final int SSO_REQUIRE_A2D2 = -10008;
    public static final int SSO_REQUIRE_D2_ENCRYPTED = -10005;
    public static final int SSO_RS_NO_INSTANCE = -10116;
    public static final int SSO_SEC_SIGN_ALL = 1;
    public static final int SSO_SEC_SIGN_NONE = 0;
    public static final int SSO_SEC_SIGN_SOME = 2;
    public static final int SSO_SEND_A2_CHECK_REQ_FAILED = -10130;
    public static final int SSO_SUB_CONN_FAILD = -10114;
    public static final int SSO_SUCCESS = 0;
    public static final int SSO_TEA_EMPTY_BUT_HAS_A2 = -10125;
    public static final int SSO_TEA_EMPTY_BUT_HAS_UID = -10124;
    public static final int SSO_TIM_COMM = 50;
    public static final int SSO_TRACE_MESSAGE = 2;
    public static final int SSO_UNCOMPRESS_FAILED = -10128;
    public static final int SSO_UNDEFINED_NETWORK = 0;
    public static final int SSO_UNENCRYPTED = 0;
    public static final int SSO_UNENCRYPTED_VERIFY_D2 = 3;
    public static final int SSO_V20_DISABLED = -10119;
    public static final int SSO_VERIFY_CODE = -10000;
    public static final int SSO_VERIFY_TIMEOUT = -10007;
    public static final int SSO_WEBJSAPI_LOGIN_CHECk_FAIL = -10123;
    public static final int SSO_WIFI_NETWORK = 1;
    public static final int SSO_WIFI_XG_NETWORK = 3;
    public static final int SSO_XG_NETWORK = 2;

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static final class ReserveFields extends MessageMicro<ReserveFields> {
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField client_ipcookie;
        public final PBStringField env;
        public final PBUInt32Field env_id;
        public final PBUInt32Field flag;
        public final PBUInt32Field imsi;
        public final PBUInt32Field ip_stack_type;
        public final PBUInt32Field locale_id;
        public final PBUInt32Field message_type;
        public final PBUInt32Field network_type;
        public final PBUInt32Field newconn_flag;
        public final PBUInt32Field nt_core_version;
        public final PBBytesField presure_token;
        public final PBBytesField qimei;
        public final PBUInt64Field rsp_timestamp_ms;
        public SsoSecureInfo sec_info;
        public final PBUInt32Field sec_sig_flag;
        public final PBUInt32Field sso_ip_origin;
        public final PBUInt32Field sso_route_cost;
        public final PBStringField trace_parent;
        public final PBRepeatMessageField<SsoMapEntry> trans_info;
        public SsoTrpcResponse trpc_rsp;
        public final PBStringField uid;

        static {
            String[] strArr = {"client_ipcookie", "flag", "env_id", "locale_id", TVKLiveRequestBuilder.RequestParamKey.QIMEI36, MosaicConstants$JsProperty.PROP_ENV, "newconn_flag", "trace_parent", "uid", MobileInfoUtil.IMSI, "network_type", "ip_stack_type", RemoteMessageConst.MSGTYPE, "trpc_rsp", "trans_info", "sec_info", "sec_sig_flag", "nt_core_version", "sso_route_cost", "sso_ip_origin", "presure_token", "rsp_timestamp_ms"};
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{66, 72, 80, 88, 98, 106, 112, 122, 130, 144, 152, 160, 168, 178, 186, 194, 200, 208, 216, 224, 242, 248}, strArr, new Object[]{byteStringMicro, 0, 0, 0, byteStringMicro, "", 0, "", "", 0, 0, 0, 0, null, null, null, 0, 0, 0, 0, byteStringMicro, 0L}, ReserveFields.class);
        }

        public ReserveFields() {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.client_ipcookie = PBField.initBytes(byteStringMicro);
            this.flag = PBField.initUInt32(0);
            this.env_id = PBField.initUInt32(0);
            this.locale_id = PBField.initUInt32(0);
            this.qimei = PBField.initBytes(byteStringMicro);
            this.env = PBField.initString("");
            this.newconn_flag = PBField.initUInt32(0);
            this.trace_parent = PBField.initString("");
            this.uid = PBField.initString("");
            this.imsi = PBField.initUInt32(0);
            this.network_type = PBField.initUInt32(0);
            this.ip_stack_type = PBField.initUInt32(0);
            this.message_type = PBField.initUInt32(0);
            this.trpc_rsp = new SsoTrpcResponse();
            this.trans_info = PBField.initRepeatMessage(SsoMapEntry.class);
            this.sec_info = new SsoSecureInfo();
            this.sec_sig_flag = PBField.initUInt32(0);
            this.nt_core_version = PBField.initUInt32(0);
            this.sso_route_cost = PBField.initUInt32(0);
            this.sso_ip_origin = PBField.initUInt32(0);
            this.presure_token = PBField.initBytes(byteStringMicro);
            this.rsp_timestamp_ms = PBField.initUInt64(0L);
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static final class SsoMapEntry extends MessageMicro<SsoMapEntry> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"key", "value"}, new Object[]{"", ByteStringMicro.EMPTY}, SsoMapEntry.class);
        public final PBStringField key = PBField.initString("");
        public final PBBytesField value = PBField.initBytes(ByteStringMicro.EMPTY);
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static final class SsoSecureInfo extends MessageMicro<SsoSecureInfo> {
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField sec_device_token;
        public final PBBytesField sec_extra;
        public final PBBytesField sec_sig;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"sec_sig", "sec_device_token", "sec_extra"}, new Object[]{byteStringMicro, byteStringMicro, byteStringMicro}, SsoSecureInfo.class);
        }

        public SsoSecureInfo() {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.sec_sig = PBField.initBytes(byteStringMicro);
            this.sec_device_token = PBField.initBytes(byteStringMicro);
            this.sec_extra = PBField.initBytes(byteStringMicro);
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static final class SsoTrpcResponse extends MessageMicro<SsoTrpcResponse> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"ret", "func_ret", "error_msg"}, new Object[]{0, 0, ByteStringMicro.EMPTY}, SsoTrpcResponse.class);
        public final PBInt32Field ret = PBField.initInt32(0);
        public final PBInt32Field func_ret = PBField.initInt32(0);
        public final PBBytesField error_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    }

    SSOReserveField() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
