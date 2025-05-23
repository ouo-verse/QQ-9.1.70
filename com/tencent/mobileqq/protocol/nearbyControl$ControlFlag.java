package com.tencent.mobileqq.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes35.dex */
public final class nearbyControl$ControlFlag extends MessageMicro<nearbyControl$ControlFlag> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{"flag_id", "value", "wording", "DocumentConfig"}, new Object[]{0, 0, "", null}, nearbyControl$ControlFlag.class);
    public final PBUInt32Field flag_id = PBField.initUInt32(0);
    public final PBUInt32Field value = PBField.initUInt32(0);
    public final PBStringField wording = PBField.initString("");
    public nearbyControl$DocumentConfig DocumentConfig = new MessageMicro<nearbyControl$DocumentConfig>() { // from class: com.tencent.mobileqq.protocol.nearbyControl$DocumentConfig
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32}, new String[]{"title", "body", "tips", "window_type"}, new Object[]{"", "", "", 0}, nearbyControl$DocumentConfig.class);
        public final PBStringField title = PBField.initString("");
        public final PBStringField body = PBField.initString("");
        public final PBStringField tips = PBField.initString("");
        public final PBUInt32Field window_type = PBField.initUInt32(0);
    };
}
