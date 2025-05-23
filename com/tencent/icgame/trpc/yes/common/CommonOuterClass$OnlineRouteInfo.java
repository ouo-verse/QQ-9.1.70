package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.vip.impl.VasQQSettingMeImpl;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class CommonOuterClass$OnlineRouteInfo extends MessageMicro<CommonOuterClass$OnlineRouteInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{"route_status", VasQQSettingMeImpl.EXPIRE_TIME, "update_time", "yolo_room_route_info"}, new Object[]{0, 0, 0, null}, CommonOuterClass$OnlineRouteInfo.class);
    public final PBInt32Field route_status = PBField.initInt32(0);
    public final PBUInt32Field expire_time = PBField.initUInt32(0);
    public final PBUInt32Field update_time = PBField.initUInt32(0);
    public CommonOuterClass$RoomRouteInfo yolo_room_route_info = new MessageMicro<CommonOuterClass$RoomRouteInfo>() { // from class: com.tencent.icgame.trpc.yes.common.CommonOuterClass$RoomRouteInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{AudienceReportConst.ROOM_ID, "room_type"}, new Object[]{0L, 0}, CommonOuterClass$RoomRouteInfo.class);
        public final PBUInt64Field room_id = PBField.initUInt64(0);
        public final PBInt32Field room_type = PBField.initInt32(0);
    };
}
