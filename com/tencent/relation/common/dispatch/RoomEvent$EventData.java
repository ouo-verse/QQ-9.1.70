package com.tencent.relation.common.dispatch;

import com.tencent.gamematrix.gmcg.sdk.nonage.report.CGNonAgeReport;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqlive.common.api.AegisLogger;

/* compiled from: P */
/* loaded from: classes25.dex */
public final class RoomEvent$EventData extends MessageMicro<RoomEvent$EventData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 50, 58, 66}, new String[]{"seq", CGNonAgeReport.EVENT_TYPE, "create_event", "enter_event", "leave_event", "destory_event", "update_event", "switch_game_event"}, new Object[]{0L, 0, null, null, null, null, null, null}, RoomEvent$EventData.class);
    public final PBUInt64Field seq = PBField.initUInt64(0);
    public final PBEnumField event_type = PBField.initEnum(0);
    public RoomEvent$CreateEvent create_event = new MessageMicro<RoomEvent$CreateEvent>() { // from class: com.tencent.relation.common.dispatch.RoomEvent$CreateEvent
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{AudienceReportConst.ROOM_ID, "creator", AegisLogger.ROOM_INFO}, new Object[]{0L, "", null}, RoomEvent$CreateEvent.class);
        public final PBUInt64Field room_id = PBField.initUInt64(0);
        public final PBStringField creator = PBField.initString("");
        public RoomEvent$RoomInfo room_info = new RoomEvent$RoomInfo();
    };
    public RoomEvent$EnterEvent enter_event = new MessageMicro<RoomEvent$EnterEvent>() { // from class: com.tencent.relation.common.dispatch.RoomEvent$EnterEvent
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34}, new String[]{AudienceReportConst.ROOM_ID, "enter_uid", "enter_role", AegisLogger.ROOM_INFO}, new Object[]{0L, "", 0, null}, RoomEvent$EnterEvent.class);
        public final PBUInt64Field room_id = PBField.initUInt64(0);
        public final PBStringField enter_uid = PBField.initString("");
        public final PBUInt32Field enter_role = PBField.initUInt32(0);
        public RoomEvent$RoomInfo room_info = new RoomEvent$RoomInfo();
    };
    public RoomEvent$LeaveEvent leave_event = new MessageMicro<RoomEvent$LeaveEvent>() { // from class: com.tencent.relation.common.dispatch.RoomEvent$LeaveEvent
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 42, 50}, new String[]{AudienceReportConst.ROOM_ID, "leave_uid", "leave_reason", "leave_role", "leave_tip", AegisLogger.ROOM_INFO}, new Object[]{0L, "", 0L, 0, "", null}, RoomEvent$LeaveEvent.class);
        public final PBUInt64Field room_id = PBField.initUInt64(0);
        public final PBStringField leave_uid = PBField.initString("");
        public final PBUInt64Field leave_reason = PBField.initUInt64(0);
        public final PBUInt32Field leave_role = PBField.initUInt32(0);
        public final PBStringField leave_tip = PBField.initString("");
        public RoomEvent$RoomInfo room_info = new RoomEvent$RoomInfo();
    };
    public RoomEvent$DestroyEvent destory_event = new MessageMicro<RoomEvent$DestroyEvent>() { // from class: com.tencent.relation.common.dispatch.RoomEvent$DestroyEvent
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{AudienceReportConst.ROOM_ID, "destroy_uid", AegisLogger.ROOM_INFO}, new Object[]{0L, "", null}, RoomEvent$DestroyEvent.class);
        public final PBUInt64Field room_id = PBField.initUInt64(0);
        public final PBStringField destroy_uid = PBField.initString("");
        public RoomEvent$RoomInfo room_info = new RoomEvent$RoomInfo();
    };
    public RoomEvent$UpdateEvent update_event = new MessageMicro<RoomEvent$UpdateEvent>() { // from class: com.tencent.relation.common.dispatch.RoomEvent$UpdateEvent
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 80}, new String[]{AudienceReportConst.ROOM_ID, AegisLogger.ROOM_INFO, "update_reason", "update_tip", "room_name_audit"}, new Object[]{0L, null, 0L, "", 0}, RoomEvent$UpdateEvent.class);
        public final PBUInt64Field room_id = PBField.initUInt64(0);
        public RoomEvent$RoomInfo room_info = new RoomEvent$RoomInfo();
        public final PBUInt64Field update_reason = PBField.initUInt64(0);
        public final PBStringField update_tip = PBField.initString("");
        public final PBUInt32Field room_name_audit = PBField.initUInt32(0);
    };
    public RoomEvent$SwitchGameEvent switch_game_event = new MessageMicro<RoomEvent$SwitchGameEvent>() { // from class: com.tencent.relation.common.dispatch.RoomEvent$SwitchGameEvent
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{AudienceReportConst.ROOM_ID, AegisLogger.ROOM_INFO}, new Object[]{0L, null}, RoomEvent$SwitchGameEvent.class);
        public final PBUInt64Field room_id = PBField.initUInt64(0);
        public RoomEvent$RoomInfo room_info = new RoomEvent$RoomInfo();
    };
}
