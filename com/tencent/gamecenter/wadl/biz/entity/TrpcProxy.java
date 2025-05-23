package com.tencent.gamecenter.wadl.biz.entity;

import com.tencent.component.media.image.ImageTaskConst;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;

/* loaded from: classes6.dex */
public final class TrpcProxy {
    public static final int COMPRESS_TYPE_GZIP = 1;
    public static final int COMPRESS_TYPE_NOOP = 0;
    public static final int COMPRESS_TYPE_SNAPPY = 2;
    public static final int COMPRESS_TYPE_ZLIB = 3;
    public static final int ERR_TYPE_BUSINESS = 2;
    public static final int ERR_TYPE_CALLEE_FRAMEWORK = 3;
    public static final int ERR_TYPE_FRAMEWORK = 1;
    public static final int ERR_TYPE_SUCCESS = 0;
    public static final int ERR_TYPE_TARS_PROXY = 4;
    public static final int ERR_TYPE_TRPC_PROXY = 5;
    public static final int REQUEST_TYPE_SEND_AND_RECV = 0;
    public static final int REQUEST_TYPE_SEND_ONLY = 1;
    public static final int SERIALIZATION_TYPE_FLAT_BUFFER = 3;
    public static final int SERIALIZATION_TYPE_FORM = 129;
    public static final int SERIALIZATION_TYPE_GET = 130;
    public static final int SERIALIZATION_TYPE_JCE = 1;
    public static final int SERIALIZATION_TYPE_JSON = 2;
    public static final int SERIALIZATION_TYPE_NOOP = 4;
    public static final int SERIALIZATION_TYPE_PB = 0;
    public static final int SERIALIZATION_TYPE_UNSUPPORTED = 128;

    /* loaded from: classes6.dex */
    public static final class TrpcInovkeReq extends MessageMicro<TrpcInovkeReq> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"data", "msg", "options"}, new Object[]{ByteStringMicro.EMPTY, null, null}, TrpcInovkeReq.class);
        public final PBBytesField data = PBField.initBytes(ByteStringMicro.EMPTY);

        /* renamed from: msg, reason: collision with root package name */
        public TrpcMsg f106730msg = new TrpcMsg();
        public TrpcOptions options = new TrpcOptions();
    }

    /* loaded from: classes6.dex */
    public static final class TrpcInovkeRsp extends MessageMicro<TrpcInovkeRsp> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34}, new String[]{"data", ImageTaskConst.ERROR_TYPE, "ret", "msg"}, new Object[]{ByteStringMicro.EMPTY, 0, 0, ""}, TrpcInovkeRsp.class);
        public final PBBytesField data = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBEnumField errType = PBField.initEnum(0);
        public final PBInt32Field ret = PBField.initInt32(0);

        /* renamed from: msg, reason: collision with root package name */
        public final PBStringField f106731msg = PBField.initString("");
    }

    /* loaded from: classes6.dex */
    public static final class TrpcListReq extends MessageMicro<TrpcListReq> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"list"}, new Object[]{null}, TrpcListReq.class);
        public final PBRepeatMessageField<TrpcInovkeReq> list = PBField.initRepeatMessage(TrpcInovkeReq.class);
    }

    /* loaded from: classes6.dex */
    public static final class TrpcListRsp extends MessageMicro<TrpcListRsp> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34}, new String[]{"list", ImageTaskConst.ERROR_TYPE, "ret", "msg"}, new Object[]{null, 0, 0, ""}, TrpcListRsp.class);
        public final PBRepeatMessageField<TrpcInovkeRsp> list = PBField.initRepeatMessage(TrpcInovkeRsp.class);
        public final PBEnumField errType = PBField.initEnum(0);
        public final PBInt32Field ret = PBField.initInt32(0);

        /* renamed from: msg, reason: collision with root package name */
        public final PBStringField f106732msg = PBField.initString("");
    }

    /* loaded from: classes6.dex */
    public static final class TrpcMetaData extends MessageMicro<TrpcMetaData> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"key", "value"}, new Object[]{"", ByteStringMicro.EMPTY}, TrpcMetaData.class);
        public final PBStringField key = PBField.initString("");
        public final PBBytesField value = PBField.initBytes(ByteStringMicro.EMPTY);
    }

    /* loaded from: classes6.dex */
    public static final class TrpcMsg extends MessageMicro<TrpcMsg> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"clientRPCName", "calleeApp", "calleeServer", "calleeService"}, new Object[]{"", "", "", ""}, TrpcMsg.class);
        public final PBStringField clientRPCName = PBField.initString("");
        public final PBStringField calleeApp = PBField.initString("");
        public final PBStringField calleeServer = PBField.initString("");
        public final PBStringField calleeService = PBField.initString("");
    }

    /* loaded from: classes6.dex */
    public static final class TrpcOptions extends MessageMicro<TrpcOptions> {
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBStringField target = PBField.initString("");
        public final PBStringField nameSpace = PBField.initString("");
        public final PBInt64Field timeout = PBField.initInt64(0);
        public final PBEnumField serializationType = PBField.initEnum(0);
        public final PBEnumField currentSerializationType = PBField.initEnum(0);
        public final PBStringField serviceName = PBField.initString("");
        public final PBStringField calleeMethod = PBField.initString("");
        public final PBStringField callerServiceName = PBField.initString("");
        public final PBEnumField currentCompressType = PBField.initEnum(0);
        public final PBEnumField compressType = PBField.initEnum(0);
        public final PBBoolField disableFilter = PBField.initBool(false);
        public final PBStringField password = PBField.initString("");
        public final PBStringField network = PBField.initString("");
        public final PBEnumField requestType = PBField.initEnum(0);
        public final PBBoolField connectionMode = PBField.initBool(false);
        public final PBBoolField disableConnectionPool = PBField.initBool(false);
        public final PBBoolField disableServiceRouter = PBField.initBool(false);
        public final PBRepeatMessageField<TrpcMetaData> metaData2 = PBField.initRepeatMessage(TrpcMetaData.class);

        static {
            String[] strArr = {"target", "nameSpace", "timeout", "serializationType", "currentSerializationType", "serviceName", "calleeMethod", "callerServiceName", "currentCompressType", "compressType", "disableFilter", NotificationActivity.PASSWORD, "network", "requestType", "connectionMode", "disableConnectionPool", "disableServiceRouter", "metaData2"};
            Boolean bool = Boolean.FALSE;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 48, 58, 66, 74, 80, 88, 96, 106, 114, 120, 128, 136, 144, 154}, strArr, new Object[]{"", "", 0L, 0, 0, "", "", "", 0, 0, bool, "", "", 0, bool, bool, bool, null}, TrpcOptions.class);
        }
    }

    /* loaded from: classes6.dex */
    public static final class UniSsoServerReq extends MessageMicro<UniSsoServerReq> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"comm", "reqdata", "pbReqData"}, new Object[]{null, "", ByteStringMicro.EMPTY}, UniSsoServerReq.class);
        public UniSsoServerReqComm comm = new UniSsoServerReqComm();
        public final PBStringField reqdata = PBField.initString("");
        public final PBBytesField pbReqData = PBField.initBytes(ByteStringMicro.EMPTY);
    }

    /* loaded from: classes6.dex */
    public static final class UniSsoServerReqComm extends MessageMicro<UniSsoServerReqComm> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"platform", TPReportKeys.Common.COMMON_OS_VERSION, "mqqver"}, new Object[]{0L, "", ""}, UniSsoServerReqComm.class);
        public final PBInt64Field platform = PBField.initInt64(0);
        public final PBStringField osver = PBField.initString("");
        public final PBStringField mqqver = PBField.initString("");
    }

    /* loaded from: classes6.dex */
    public static final class UniSsoServerRsp extends MessageMicro<UniSsoServerRsp> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42}, new String[]{"ret", HippyReporter.EXTRA_KEY_REPORT_ERRMSG, "comm", "rspdata", "pbRsqData"}, new Object[]{0L, "", null, "", ByteStringMicro.EMPTY}, UniSsoServerRsp.class);
        public final PBInt64Field ret = PBField.initInt64(0);
        public final PBStringField errmsg = PBField.initString("");
        public UniSsoServerRspComm comm = new UniSsoServerRspComm();
        public final PBStringField rspdata = PBField.initString("");
        public final PBBytesField pbRsqData = PBField.initBytes(ByteStringMicro.EMPTY);
    }

    /* loaded from: classes6.dex */
    public static final class UniSsoServerRspComm extends MessageMicro<UniSsoServerRspComm> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"delayms", "packagesize"}, new Object[]{0, 0}, UniSsoServerRspComm.class);
        public final PBUInt32Field delayms = PBField.initUInt32(0);
        public final PBUInt32Field packagesize = PBField.initUInt32(0);
    }

    TrpcProxy() {
    }
}
