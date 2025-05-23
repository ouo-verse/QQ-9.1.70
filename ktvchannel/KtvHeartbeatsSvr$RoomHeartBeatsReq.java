package ktvchannel;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class KtvHeartbeatsSvr$RoomHeartBeatsReq extends MessageMicro<KtvHeartbeatsSvr$RoomHeartBeatsReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uin", AudienceReportConst.ROOM_ID, "map_ext"}, new Object[]{0L, "", null}, KtvHeartbeatsSvr$RoomHeartBeatsReq.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBStringField room_id = PBField.initString("");
    public final PBRepeatMessageField<KtvCommon$KVItem> map_ext = PBField.initRepeatMessage(KtvCommon$KVItem.class);
}
