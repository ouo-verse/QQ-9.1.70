package ktvchannel;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class KtvKaraokeRoomSvr$LeaveRoomReq extends MessageMicro<KtvKaraokeRoomSvr$LeaveRoomReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uin", AudienceReportConst.ROOM_ID}, new Object[]{0L, ""}, KtvKaraokeRoomSvr$LeaveRoomReq.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBStringField room_id = PBField.initString("");
}
