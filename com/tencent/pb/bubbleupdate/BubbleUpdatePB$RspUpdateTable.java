package com.tencent.pb.bubbleupdate;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes22.dex */
public final class BubbleUpdatePB$RspUpdateTable extends MessageMicro<BubbleUpdatePB$RspUpdateTable> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_item_id", "uint32_is_update"}, new Object[]{0, 0}, BubbleUpdatePB$RspUpdateTable.class);
    public final PBUInt32Field uint32_item_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_update = PBField.initUInt32(0);
}
