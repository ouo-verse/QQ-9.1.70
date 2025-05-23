package com.tencent.trpcprotocol.qqstranger.common.common_system_msg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes38.dex */
public final class CommonSystemMsgPB$InteractiveMarkerMsg extends MessageMicro<CommonSystemMsgPB$InteractiveMarkerMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48}, new String[]{"appid", "marker_id", "tinyid", "peer_tinyid", "count", "level"}, new Object[]{0, 0, 0L, 0L, 0L, 0L}, CommonSystemMsgPB$InteractiveMarkerMsg.class);
    public final PBEnumField appid = PBField.initEnum(0);
    public final PBUInt32Field marker_id = PBField.initUInt32(0);
    public final PBUInt64Field tinyid = PBField.initUInt64(0);
    public final PBUInt64Field peer_tinyid = PBField.initUInt64(0);
    public final PBUInt64Field count = PBField.initUInt64(0);
    public final PBUInt64Field level = PBField.initUInt64(0);
}
