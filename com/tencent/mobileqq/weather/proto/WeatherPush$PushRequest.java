package com.tencent.mobileqq.weather.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes20.dex */
public final class WeatherPush$PushRequest extends MessageMicro<WeatherPush$PushRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32}, new String[]{"pbReqMsgHead", "uin", "adcode", "hideRedPoint"}, new Object[]{null, 0L, 0, Boolean.FALSE}, WeatherPush$PushRequest.class);
    public WeatherPush$PbReqMsgHead pbReqMsgHead = new MessageMicro<WeatherPush$PbReqMsgHead>() { // from class: com.tencent.mobileqq.weather.proto.WeatherPush$PbReqMsgHead
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint32_platform_type", "uint32_version", "uint32_ext_mask"}, new Object[]{0, 0, 0}, WeatherPush$PbReqMsgHead.class);
        public final PBUInt32Field uint32_platform_type = PBField.initUInt32(0);
        public final PBUInt32Field uint32_version = PBField.initUInt32(0);
        public final PBUInt32Field uint32_ext_mask = PBField.initUInt32(0);
    };
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBUInt32Field adcode = PBField.initUInt32(0);
    public final PBBoolField hideRedPoint = PBField.initBool(false);
}
