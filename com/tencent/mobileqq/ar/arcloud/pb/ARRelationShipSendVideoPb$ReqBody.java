package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes11.dex */
public final class ARRelationShipSendVideoPb$ReqBody extends MessageMicro<ARRelationShipSendVideoPb$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"msg_share_info", "rpt_uint64_to_uin"}, new Object[]{null, 0L}, ARRelationShipSendVideoPb$ReqBody.class);
    public ARRelationShipSendVideoPb$shareInfo msg_share_info = new MessageMicro<ARRelationShipSendVideoPb$shareInfo>() { // from class: com.tencent.mobileqq.ar.arcloud.pb.ARRelationShipSendVideoPb$shareInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 50, 58, 66, 72, 80, 162, 170, 178, 186}, new String[]{"uint64_from_uin", "uint64_topic_id", "uint64_share_id", "enum_content_type", "uint64_create_time", "str_video_url", "str_cover_url", "str_desc", "uint32_duration", "uint32_size", "str_msg_url", "str_msg_picture_cover", "str_msg_title", "str_msg_summary"}, new Object[]{0L, 0L, 0L, 1, 0L, "", "", "", 0, 0, "", "", "", ""}, ARRelationShipSendVideoPb$shareInfo.class);
        public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0);
        public final PBUInt64Field uint64_topic_id = PBField.initUInt64(0);
        public final PBUInt64Field uint64_share_id = PBField.initUInt64(0);
        public final PBEnumField enum_content_type = PBField.initEnum(1);
        public final PBUInt64Field uint64_create_time = PBField.initUInt64(0);
        public final PBStringField str_video_url = PBField.initString("");
        public final PBStringField str_cover_url = PBField.initString("");
        public final PBStringField str_desc = PBField.initString("");
        public final PBUInt32Field uint32_duration = PBField.initUInt32(0);
        public final PBUInt32Field uint32_size = PBField.initUInt32(0);
        public final PBStringField str_msg_url = PBField.initString("");
        public final PBStringField str_msg_picture_cover = PBField.initString("");
        public final PBStringField str_msg_title = PBField.initString("");
        public final PBStringField str_msg_summary = PBField.initString("");
    };
    public final PBRepeatField<Long> rpt_uint64_to_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
