package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes11.dex */
public final class ARRelationShipListPb$PageCookie extends MessageMicro<ARRelationShipListPb$PageCookie> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_my_send_start_idx", "uint32_my_recv_start_idx"}, new Object[]{0, 0}, ARRelationShipListPb$PageCookie.class);
    public final PBUInt32Field uint32_my_send_start_idx = PBField.initUInt32(0);
    public final PBUInt32Field uint32_my_recv_start_idx = PBField.initUInt32(0);
}
