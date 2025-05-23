package com.trunk.Qworkflow;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class Qworkflow$TodoChangeItem extends MessageMicro<Qworkflow$TodoChangeItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40}, new String[]{"msg_source_appid", "bytes_workflow_id", "uint32_main_type", "uint32_sub_type", "uint64_author_uin"}, new Object[]{null, ByteStringMicro.EMPTY, 0, 0, 0L}, Qworkflow$TodoChangeItem.class);
    public Qworkflow$AppID msg_source_appid = new Qworkflow$AppID();
    public final PBBytesField bytes_workflow_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_main_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sub_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_author_uin = PBField.initUInt64(0);
}
