package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes11.dex */
public final class ARRelationShipListPb$ReqBody extends MessageMicro<ARRelationShipListPb$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 40, 48, 56, 64, 72}, new String[]{"uint32_req_list_type", "bytes_req_page_cookies", "uint32_req_count", "uint64_start_time", "uint64_topic_id", "rpt_uint64_peer_uin", "uint64_share_id", "uint32_send_recv_flag", "uint64_del_to_uin"}, new Object[]{0, ByteStringMicro.EMPTY, 0, 0L, 0L, 0L, 0L, 0, 0L}, ARRelationShipListPb$ReqBody.class);
    public final PBUInt32Field uint32_req_list_type = PBField.initUInt32(0);
    public final PBBytesField bytes_req_page_cookies = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_req_count = PBField.initUInt32(0);
    public final PBUInt64Field uint64_start_time = PBField.initUInt64(0);
    public final PBUInt64Field uint64_topic_id = PBField.initUInt64(0);
    public final PBRepeatField<Long> rpt_uint64_peer_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt64Field uint64_share_id = PBField.initUInt64(0);
    public final PBUInt32Field uint32_send_recv_flag = PBField.initUInt32(0);
    public final PBUInt64Field uint64_del_to_uin = PBField.initUInt64(0);
}
