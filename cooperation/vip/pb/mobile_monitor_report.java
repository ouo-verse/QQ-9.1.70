package cooperation.vip.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class mobile_monitor_report {
    public static final int TYPE_2G = 6;
    public static final int TYPE_3G = 5;
    public static final int TYPE_4G = 4;
    public static final int TYPE_ACTIVE_FEED = 21;
    public static final int TYPE_ADV_BANNER = 3;
    public static final int TYPE_ALBUM = 20;
    public static final int TYPE_CARD_DRESS = 9;
    public static final int TYPE_COMMENT_BUBBLE = 25;
    public static final int TYPE_COMM_PENDANT = 16;
    public static final int TYPE_EVENT_PENDANT = 17;
    public static final int TYPE_E_SPLASH = 22;
    public static final int TYPE_FACADE = 15;
    public static final int TYPE_GITF = 19;
    public static final int TYPE_HEAD_DRESS = 7;
    public static final int TYPE_HOME_PAGE_DIY = 24;
    public static final int TYPE_HUNG_DRESS = 8;
    public static final int TYPE_NAVIGTION_DRESS = 5;
    public static final int TYPE_NOT_REACH = 2;
    public static final int TYPE_PASSIVE_LIKE = 12;
    public static final int TYPE_PLAY_DRESS = 6;
    public static final int TYPE_POLY_LIKE = 13;
    public static final int TYPE_QBOSS = 18;
    public static final int TYPE_QQ_UNION_VIP = 23;
    public static final int TYPE_QZONE_COVER = 2;
    public static final int TYPE_QZONE_FONT = 26;
    public static final int TYPE_QZONE_VIP_PAY = 1;
    public static final int TYPE_REPLAY_LIKE = 14;
    public static final int TYPE_SPLASH = 2;
    public static final int TYPE_UNKNOW = 1;
    public static final int TYPE_USER_PAY_ACTION = 1;
    public static final int TYPE_VIP_DIAMOND = 10;
    public static final int TYPE_VIP_LIKE = 11;
    public static final int TYPE_WARNING_BANNER = 4;
    public static final int TYPE_WIFI = 3;
    public static final int TYPE_XG = 7;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class ExceptionReport extends MessageMicro<ExceptionReport> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"busi_id", "errcode", "msg"}, new Object[]{1, 0, ""}, ExceptionReport.class);
        public final PBEnumField busi_id = PBField.initEnum(1);
        public final PBInt32Field errcode = PBField.initInt32(0);

        /* renamed from: msg, reason: collision with root package name */
        public final PBStringField f391308msg = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class PkgExceptionReq extends MessageMicro<PkgExceptionReq> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"user_comm_report", "exception_report"}, new Object[]{null, null}, PkgExceptionReq.class);
        public UserCommReport user_comm_report = new UserCommReport();
        public final PBRepeatMessageField<ExceptionReport> exception_report = PBField.initRepeatMessage(ExceptionReport.class);
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class PkgRsp extends MessageMicro<PkgRsp> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32}, new String[]{"ret", "err_msg", "mult_cnt", "mult_delay"}, new Object[]{0, "", 0, 0}, PkgRsp.class);
        public final PBUInt32Field ret = PBField.initUInt32(0);
        public final PBStringField err_msg = PBField.initString("");
        public final PBInt32Field mult_cnt = PBField.initInt32(0);
        public final PBInt32Field mult_delay = PBField.initInt32(0);
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class PkgTraceReq extends MessageMicro<PkgTraceReq> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"user_busi_type", "user_comm_report", "trace_report"}, new Object[]{1, null, null}, PkgTraceReq.class);
        public final PBEnumField user_busi_type = PBField.initEnum(1);
        public UserCommReport user_comm_report = new UserCommReport();
        public final PBRepeatMessageField<TraceReport> trace_report = PBField.initRepeatMessage(TraceReport.class);
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class TraceReport extends MessageMicro<TraceReport> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34}, new String[]{"msg", "trace_id", "trace_num", "page_id"}, new Object[]{"", "", 0, ""}, TraceReport.class);

        /* renamed from: msg, reason: collision with root package name */
        public final PBStringField f391309msg = PBField.initString("");
        public final PBStringField trace_id = PBField.initString("");
        public final PBUInt32Field trace_num = PBField.initUInt32(0);
        public final PBStringField page_id = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class UserCommReport extends MessageMicro<UserCommReport> {
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBStringField imei = PBField.initString("");
        public final PBDoubleField longitude = PBField.initDouble(0.0d);
        public final PBDoubleField latitude = PBField.initDouble(0.0d);
        public final PBStringField city_code = PBField.initString("");
        public final PBEnumField net_type = PBField.initEnum(1);
        public final PBUInt32Field from_id = PBField.initUInt32(0);
        public final PBStringField mobile_type = PBField.initString("");
        public final PBStringField qua = PBField.initString("");

        static {
            Double valueOf = Double.valueOf(0.0d);
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 17, 25, 34, 40, 48, 58, 66}, new String[]{"imei", "longitude", "latitude", "city_code", "net_type", "from_id", "mobile_type", "qua"}, new Object[]{"", valueOf, valueOf, "", 1, 0, "", ""}, UserCommReport.class);
        }
    }

    mobile_monitor_report() {
    }
}
