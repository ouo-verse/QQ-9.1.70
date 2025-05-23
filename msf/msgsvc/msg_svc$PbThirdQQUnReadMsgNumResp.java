package msf.msgsvc;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes28.dex */
public final class msg_svc$PbThirdQQUnReadMsgNumResp extends MessageMicro<msg_svc$PbThirdQQUnReadMsgNumResp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32}, new String[]{"result", HippyReporter.EXTRA_KEY_REPORT_ERRMSG, "thirdqq_resp_info", WidgetCacheConstellationData.INTERVAL}, new Object[]{0, "", null, 0}, msg_svc$PbThirdQQUnReadMsgNumResp.class);
    public final PBUInt32Field result = PBField.initUInt32(0);
    public final PBStringField errmsg = PBField.initString("");
    public final PBRepeatMessageField<ThirdQQRespInfo> thirdqq_resp_info = PBField.initRepeatMessage(ThirdQQRespInfo.class);
    public final PBUInt32Field interval = PBField.initUInt32(0);

    /* loaded from: classes28.dex */
    public static final class ThirdQQRespInfo extends MessageMicro<ThirdQQRespInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 40, 48, 56}, new String[]{"third_uin", "third_uin_cookie", "msg_num", "msg_flag", "redbag_time", "status", "last_msg_time"}, new Object[]{0L, ByteStringMicro.EMPTY, 0, 0, 0, 0, 0}, ThirdQQRespInfo.class);
        public final PBUInt64Field third_uin = PBField.initUInt64(0);
        public final PBBytesField third_uin_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field msg_num = PBField.initUInt32(0);
        public final PBUInt32Field msg_flag = PBField.initUInt32(0);
        public final PBUInt32Field redbag_time = PBField.initUInt32(0);
        public final PBUInt32Field status = PBField.initUInt32(0);
        public final PBUInt32Field last_msg_time = PBField.initUInt32(0);
    }
}
