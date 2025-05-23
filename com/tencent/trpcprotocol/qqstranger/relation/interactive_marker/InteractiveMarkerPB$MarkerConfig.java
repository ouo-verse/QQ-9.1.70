package com.tencent.trpcprotocol.qqstranger.relation.interactive_marker;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes38.dex */
public final class InteractiveMarkerPB$MarkerConfig extends MessageMicro<InteractiveMarkerPB$MarkerConfig> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"marker_id", "name", "desc", "marker_level_config"}, new Object[]{0, "", "", null}, InteractiveMarkerPB$MarkerConfig.class);
    public final PBUInt32Field marker_id = PBField.initUInt32(0);
    public final PBStringField name = PBField.initString("");
    public final PBStringField desc = PBField.initString("");
    public InteractiveMarkerPB$MarkerLevelConfig marker_level_config = new MessageMicro<InteractiveMarkerPB$MarkerLevelConfig>() { // from class: com.tencent.trpcprotocol.qqstranger.relation.interactive_marker.InteractiveMarkerPB$MarkerLevelConfig
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"level", "target"}, new Object[]{0L, 0L}, InteractiveMarkerPB$MarkerLevelConfig.class);
        public final PBUInt64Field level = PBField.initUInt64(0);
        public final PBUInt64Field target = PBField.initUInt64(0);
    };
}
