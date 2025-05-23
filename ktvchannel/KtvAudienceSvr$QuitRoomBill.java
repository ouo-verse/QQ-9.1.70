package ktvchannel;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class KtvAudienceSvr$QuitRoomBill extends MessageMicro<KtvAudienceSvr$QuitRoomBill> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{AudienceReportConst.ROOM_ID, "uin", "timestamps"}, new Object[]{"", 0L, 0L}, KtvAudienceSvr$QuitRoomBill.class);
    public final PBStringField room_id = PBField.initString("");
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBUInt64Field timestamps = PBField.initUInt64(0);
}
