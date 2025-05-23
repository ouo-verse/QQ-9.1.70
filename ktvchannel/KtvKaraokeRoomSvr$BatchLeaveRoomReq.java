package ktvchannel;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class KtvKaraokeRoomSvr$BatchLeaveRoomReq extends MessageMicro<KtvKaraokeRoomSvr$BatchLeaveRoomReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uin_list", AudienceReportConst.ROOM_ID}, new Object[]{0L, ""}, KtvKaraokeRoomSvr$BatchLeaveRoomReq.class);
    public final PBRepeatField<Long> uin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBStringField room_id = PBField.initString("");
}
