package ktvchannel;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class KtvKaraokeMikeSvr$ScoreReportReq extends MessageMicro<KtvKaraokeMikeSvr$ScoreReportReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40, 48, 56, 66}, new String[]{AudienceReportConst.ROOM_ID, "mike_id", "role_type", "sing_type", "total_score", "sentence_count", "score_result", "score_detail"}, new Object[]{"", "", 0, 0, 0, 0, 0, null}, KtvKaraokeMikeSvr$ScoreReportReq.class);
    public final PBStringField room_id = PBField.initString("");
    public final PBStringField mike_id = PBField.initString("");
    public final PBInt32Field role_type = PBField.initInt32(0);
    public final PBInt32Field sing_type = PBField.initInt32(0);
    public final PBUInt32Field total_score = PBField.initUInt32(0);
    public final PBUInt32Field sentence_count = PBField.initUInt32(0);
    public final PBInt32Field score_result = PBField.initInt32(0);
    public Mem$ScoreDetail score_detail = new Mem$ScoreDetail();
}
