package com.tencent.mobileqq.weather.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes20.dex */
public final class WeatherPush$PushReply extends MessageMicro<WeatherPush$PushReply> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"pbRspMsgHead"}, new Object[]{null}, WeatherPush$PushReply.class);
    public WeatherPush$PbRspMsgHead pbRspMsgHead = new MessageMicro<WeatherPush$PbRspMsgHead>() { // from class: com.tencent.mobileqq.weather.proto.WeatherPush$PbRspMsgHead
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_result", "string_err_msg"}, new Object[]{0, ""}, WeatherPush$PbRspMsgHead.class);
        public final PBUInt32Field uint32_result = PBField.initUInt32(0);
        public final PBStringField string_err_msg = PBField.initString("");
    };
}
