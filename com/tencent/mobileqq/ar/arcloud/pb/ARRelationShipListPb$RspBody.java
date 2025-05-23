package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes11.dex */
public final class ARRelationShipListPb$RspBody extends MessageMicro<ARRelationShipListPb$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 40, 48}, new String[]{"uint32_share_flag", "rpt_send_recv_share_list", "uint32_is_end", "bytes_rsp_page_cookies", "uint32_total_send_count", "uint32_total_recv_count"}, new Object[]{0, null, 0, ByteStringMicro.EMPTY, 0, 0}, ARRelationShipListPb$RspBody.class);
    public final PBUInt32Field uint32_share_flag = PBField.initUInt32(0);
    public final PBRepeatMessageField<ARRelationShipListPb$SendRecvShareInfo> rpt_send_recv_share_list = PBField.initRepeatMessage(ARRelationShipListPb$SendRecvShareInfo.class);
    public final PBUInt32Field uint32_is_end = PBField.initUInt32(0);
    public final PBBytesField bytes_rsp_page_cookies = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_total_send_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_total_recv_count = PBField.initUInt32(0);
}
