package oicq.wlogin_sdk.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes28.dex */
public final class ThirdPartLogin$RspCommonInfo extends MessageMicro<ThirdPartLogin$RspCommonInfo> {
    public static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{80, 90, 96}, new String[]{"uint32_need_verify_scenes", "msg_rsp_nt", "uint32_a1_seq"}, new Object[]{0, null, 0}, ThirdPartLogin$RspCommonInfo.class);
    public final PBUInt32Field uint32_need_verify_scenes = PBField.initUInt32(0);
    public ThirdPartLogin$RspNT msg_rsp_nt = new MessageMicro<ThirdPartLogin$RspNT>() { // from class: oicq.wlogin_sdk.pb.ThirdPartLogin$RspNT
        public static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"str_uid", "bytes_ua2"}, new Object[]{"", ByteStringMicro.EMPTY}, ThirdPartLogin$RspNT.class);
        public final PBStringField str_uid = PBField.initString("");
        public final PBBytesField bytes_ua2 = PBField.initBytes(ByteStringMicro.EMPTY);
    };
    public final PBUInt32Field uint32_a1_seq = PBField.initUInt32(0);
}
