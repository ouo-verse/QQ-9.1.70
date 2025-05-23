package im.oidb.wifi_poi_group.cmd0x8e9;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class cmd0x8e9$ReqBody extends MessageMicro<cmd0x8e9$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32, 40}, new String[]{"bytes_uid", "uint64_group_code", "rpt_req_visitor_info", "uint32_max_visitor_num", "uint64_judge_uin"}, new Object[]{ByteStringMicro.EMPTY, 0L, null, 0, 0L}, cmd0x8e9$ReqBody.class);
    public final PBBytesField bytes_uid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
    public final PBRepeatMessageField<cmd0x8e9$VisitorInfo> rpt_req_visitor_info = PBField.initRepeatMessage(cmd0x8e9$VisitorInfo.class);
    public final PBUInt32Field uint32_max_visitor_num = PBField.initUInt32(0);
    public final PBUInt64Field uint64_judge_uin = PBField.initUInt64(0);
}
