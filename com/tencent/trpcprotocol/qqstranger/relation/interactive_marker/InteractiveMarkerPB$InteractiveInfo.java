package com.tencent.trpcprotocol.qqstranger.relation.interactive_marker;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes38.dex */
public final class InteractiveMarkerPB$InteractiveInfo extends MessageMicro<InteractiveMarkerPB$InteractiveInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 66, 72, 82, 90, 98, 106}, new String[]{"appid", "marker_id", "tinyid", "peer_tinyid", "count", "level", "type", "summary", "interactive_emoji", "start_time", "end_time", "interactive_message", "assist_content"}, new Object[]{0, 0, 0L, 0L, 0L, 0L, 0, "", 0L, "", "", "", ""}, InteractiveMarkerPB$InteractiveInfo.class);
    public final PBEnumField appid = PBField.initEnum(0);
    public final PBUInt32Field marker_id = PBField.initUInt32(0);
    public final PBUInt64Field tinyid = PBField.initUInt64(0);
    public final PBUInt64Field peer_tinyid = PBField.initUInt64(0);
    public final PBUInt64Field count = PBField.initUInt64(0);
    public final PBUInt64Field level = PBField.initUInt64(0);
    public final PBEnumField type = PBField.initEnum(0);
    public final PBStringField summary = PBField.initString("");
    public final PBUInt64Field interactive_emoji = PBField.initUInt64(0);
    public final PBStringField start_time = PBField.initString("");
    public final PBStringField end_time = PBField.initString("");
    public final PBStringField interactive_message = PBField.initString("");
    public final PBStringField assist_content = PBField.initString("");
}
