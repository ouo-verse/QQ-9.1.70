package msf.msgsvc;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes28.dex */
public final class msg_svc$PbThirdQQUnReadMsgNumReq extends MessageMicro<msg_svc$PbThirdQQUnReadMsgNumReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"thirdqq_req_info", "source"}, new Object[]{null, 0}, msg_svc$PbThirdQQUnReadMsgNumReq.class);
    public final PBRepeatMessageField<ThirdQQReqInfo> thirdqq_req_info = PBField.initRepeatMessage(ThirdQQReqInfo.class);
    public final PBUInt32Field source = PBField.initUInt32(0);

    /* loaded from: classes28.dex */
    public static final class ThirdQQReqInfo extends MessageMicro<ThirdQQReqInfo> {
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBUInt64Field third_uin = PBField.initUInt64(0);
        public final PBBytesField third_uin_cookie;
        public final PBBytesField third_uin_sig;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"third_uin", "third_uin_sig", "third_uin_cookie"}, new Object[]{0L, byteStringMicro, byteStringMicro}, ThirdQQReqInfo.class);
        }

        public ThirdQQReqInfo() {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.third_uin_sig = PBField.initBytes(byteStringMicro);
            this.third_uin_cookie = PBField.initBytes(byteStringMicro);
        }
    }
}
