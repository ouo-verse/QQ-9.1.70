package ktvchannel;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes28.dex */
public final class KtvFlowSvr$ProduceReq extends MessageMicro<KtvFlowSvr$ProduceReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"pulsar_conf", "msg_data", RemoteMessageConst.MSGTYPE}, new Object[]{null, ByteStringMicro.EMPTY, 0}, KtvFlowSvr$ProduceReq.class);
    public KtvFlowSvr$PulsarConf pulsar_conf = new MessageMicro<KtvFlowSvr$PulsarConf>() { // from class: ktvchannel.KtvFlowSvr$PulsarConf
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 48}, new String[]{"url", "listener_name", "token", "topic", "sub", "enable_retry"}, new Object[]{"", "", "", "", "", Boolean.FALSE}, KtvFlowSvr$PulsarConf.class);
        public final PBStringField url = PBField.initString("");
        public final PBStringField listener_name = PBField.initString("");
        public final PBStringField token = PBField.initString("");
        public final PBStringField topic = PBField.initString("");
        public final PBStringField sub = PBField.initString("");
        public final PBBoolField enable_retry = PBField.initBool(false);
    };
    public final PBBytesField msg_data = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField message_type = PBField.initEnum(0);
}
