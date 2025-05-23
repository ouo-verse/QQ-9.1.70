package com.tencent.protobuf.nearbyReportSvr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class NearbyReportSvr$TempChatReq extends MessageMicro<NearbyReportSvr$TempChatReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 48, 58, 66, 74}, new String[]{"sender", "receiver", "send_time", QQHealthReportApiImpl.MSG_TYPE_KEY, "msg_content", "src", "ext", "location", "common_data"}, new Object[]{0L, 0L, 0L, 0, "", 0L, "", null, null}, NearbyReportSvr$TempChatReq.class);
    public final PBUInt64Field sender = PBField.initUInt64(0);
    public final PBUInt64Field receiver = PBField.initUInt64(0);
    public final PBUInt64Field send_time = PBField.initUInt64(0);
    public final PBUInt32Field msg_type = PBField.initUInt32(0);
    public final PBStringField msg_content = PBField.initString("");
    public final PBUInt64Field src = PBField.initUInt64(0);
    public final PBStringField ext = PBField.initString("");
    public NearbyReportSvr$Location location = new MessageMicro<NearbyReportSvr$Location>() { // from class: com.tencent.protobuf.nearbyReportSvr.NearbyReportSvr$Location
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"latitude", "longitude", "coordinate"}, new Object[]{"", "", 0}, NearbyReportSvr$Location.class);
        public final PBStringField latitude = PBField.initString("");
        public final PBStringField longitude = PBField.initString("");
        public final PBInt32Field coordinate = PBField.initInt32(0);
    };
    public NearbyReportSvr$CommonData common_data = new MessageMicro<NearbyReportSvr$CommonData>() { // from class: com.tencent.protobuf.nearbyReportSvr.NearbyReportSvr$CommonData
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"client_ip", "platform", "version"}, new Object[]{"", "", ""}, NearbyReportSvr$CommonData.class);
        public final PBStringField client_ip = PBField.initString("");
        public final PBStringField platform = PBField.initString("");
        public final PBStringField version = PBField.initString("");
    };
}
