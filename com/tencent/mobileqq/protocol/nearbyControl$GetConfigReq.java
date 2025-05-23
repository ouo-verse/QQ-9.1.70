package com.tencent.mobileqq.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes35.dex */
public final class nearbyControl$GetConfigReq extends MessageMicro<nearbyControl$GetConfigReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"keys", "dimensions"}, new Object[]{null, null}, nearbyControl$GetConfigReq.class);
    public final PBRepeatMessageField<nearbyControl$FlagBuffer> keys = PBField.initRepeatMessage(nearbyControl$FlagBuffer.class);
    public nearbyControl$MatchDimension dimensions = new MessageMicro<nearbyControl$MatchDimension>() { // from class: com.tencent.mobileqq.protocol.nearbyControl$MatchDimension
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 42, 50}, new String[]{"version", "deviceType", "clientType", "strVersion", "keyMetas", "geoData"}, new Object[]{0, "", 0, "", null, null}, nearbyControl$MatchDimension.class);
        public final PBUInt32Field version = PBField.initUInt32(0);
        public final PBStringField deviceType = PBField.initString("");
        public final PBUInt32Field clientType = PBField.initUInt32(0);
        public final PBStringField strVersion = PBField.initString("");
        public final PBRepeatMessageField<nearbyControl$RuleKeyMeta> keyMetas = PBField.initRepeatMessage(nearbyControl$RuleKeyMeta.class);
        public nearbyControl$GeoData geoData = new MessageMicro<nearbyControl$GeoData>() { // from class: com.tencent.mobileqq.protocol.nearbyControl$GeoData
            static final MessageMicro.FieldMap __fieldMap__;
            public final PBDoubleField longitude = PBField.initDouble(0.0d);
            public final PBDoubleField latitude = PBField.initDouble(0.0d);
            public final PBUInt32Field coordinate = PBField.initUInt32(0);

            static {
                Double valueOf = Double.valueOf(0.0d);
                __fieldMap__ = MessageMicro.initFieldMap(new int[]{9, 17, 24}, new String[]{"longitude", "latitude", "coordinate"}, new Object[]{valueOf, valueOf, 0}, nearbyControl$GeoData.class);
            }
        };
    };
}
