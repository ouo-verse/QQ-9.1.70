package com.tencent.relation.common.security;

import com.tencent.biz.qqcircle.tedgers2.bean.QFSEdgeItem;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes25.dex */
public final class SecurityEvent$SecEventData extends MessageMicro<SecurityEvent$SecEventData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34}, new String[]{"uin", "document_config", "beat_action", "document_channel"}, new Object[]{0L, null, 0, null}, SecurityEvent$SecEventData.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public SecurityEvent$DocumentConfig document_config = new MessageMicro<SecurityEvent$DocumentConfig>() { // from class: com.tencent.relation.common.security.SecurityEvent$DocumentConfig
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42, 48, 58}, new String[]{"title", "body", "tips", "window_type", "confirm_btn_text", "show_time", QFSEdgeItem.KEY_EXTEND}, new Object[]{"", "", "", 0, "", 0, ""}, SecurityEvent$DocumentConfig.class);
        public final PBStringField title = PBField.initString("");
        public final PBStringField body = PBField.initString("");
        public final PBStringField tips = PBField.initString("");
        public final PBUInt32Field window_type = PBField.initUInt32(0);
        public final PBStringField confirm_btn_text = PBField.initString("");
        public final PBUInt32Field show_time = PBField.initUInt32(0);
        public final PBStringField extend = PBField.initString("");
    };
    public final PBEnumField beat_action = PBField.initEnum(0);
    public SecurityEvent$DocumentConfig document_channel = new MessageMicro<SecurityEvent$DocumentConfig>() { // from class: com.tencent.relation.common.security.SecurityEvent$DocumentConfig
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42, 48, 58}, new String[]{"title", "body", "tips", "window_type", "confirm_btn_text", "show_time", QFSEdgeItem.KEY_EXTEND}, new Object[]{"", "", "", 0, "", 0, ""}, SecurityEvent$DocumentConfig.class);
        public final PBStringField title = PBField.initString("");
        public final PBStringField body = PBField.initString("");
        public final PBStringField tips = PBField.initString("");
        public final PBUInt32Field window_type = PBField.initUInt32(0);
        public final PBStringField confirm_btn_text = PBField.initString("");
        public final PBUInt32Field show_time = PBField.initUInt32(0);
        public final PBStringField extend = PBField.initString("");
    };
}
