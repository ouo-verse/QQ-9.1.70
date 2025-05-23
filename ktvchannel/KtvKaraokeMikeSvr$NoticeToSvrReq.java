package ktvchannel;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class KtvKaraokeMikeSvr$NoticeToSvrReq extends MessageMicro<KtvKaraokeMikeSvr$NoticeToSvrReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40}, new String[]{AudienceReportConst.ROOM_ID, "mike_id", "notice_type", "notice_time", "notice_wait"}, new Object[]{"", "", 0, 0, 0}, KtvKaraokeMikeSvr$NoticeToSvrReq.class);
    public final PBStringField room_id = PBField.initString("");
    public final PBStringField mike_id = PBField.initString("");
    public final PBInt32Field notice_type = PBField.initInt32(0);
    public final PBUInt32Field notice_time = PBField.initUInt32(0);
    public final PBUInt32Field notice_wait = PBField.initUInt32(0);
}
