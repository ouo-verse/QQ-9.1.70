package com.tencent.relation.common.security;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes25.dex */
public final class RoomAuth$AuthRsp extends MessageMicro<RoomAuth$AuthRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 802}, new String[]{"ret_code", "ret_msg", "authorized", "document_config"}, new Object[]{0, "", 0, null}, RoomAuth$AuthRsp.class);
    public final PBUInt32Field ret_code = PBField.initUInt32(0);
    public final PBStringField ret_msg = PBField.initString("");
    public final PBInt32Field authorized = PBField.initInt32(0);
    public RoomAuth$DocumentConfig document_config = new MessageMicro<RoomAuth$DocumentConfig>() { // from class: com.tencent.relation.common.security.RoomAuth$DocumentConfig
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42}, new String[]{"title", "body", "tips", "window_type", "confirm_btn_text"}, new Object[]{"", "", "", 0, ""}, RoomAuth$DocumentConfig.class);
        public final PBStringField title = PBField.initString("");
        public final PBStringField body = PBField.initString("");
        public final PBStringField tips = PBField.initString("");
        public final PBUInt32Field window_type = PBField.initUInt32(0);
        public final PBStringField confirm_btn_text = PBField.initString("");
    };
}
