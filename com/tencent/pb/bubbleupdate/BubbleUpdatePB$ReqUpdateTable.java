package com.tencent.pb.bubbleupdate;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes22.dex */
public final class BubbleUpdatePB$ReqUpdateTable extends MessageMicro<BubbleUpdatePB$ReqUpdateTable> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_item_id", "uint32_version"}, new Object[]{0, 0}, BubbleUpdatePB$ReqUpdateTable.class);
    public final PBUInt32Field uint32_item_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_version = PBField.initUInt32(0);
}
