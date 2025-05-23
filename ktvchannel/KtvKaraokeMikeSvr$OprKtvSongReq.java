package ktvchannel;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class KtvKaraokeMikeSvr$OprKtvSongReq extends MessageMicro<KtvKaraokeMikeSvr$OprKtvSongReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40, 48, 56, 64, 72, 80, 88}, new String[]{AudienceReportConst.ROOM_ID, "mike_id", "song_id", "opr_type", "req_timestamp", "video_timestamp", "acc_timestamp", "role_type", "sing_type", "sing_part", "acc_time_length"}, new Object[]{"", "", "", 0, 0, 0, 0, 0, 0, 0, 0}, KtvKaraokeMikeSvr$OprKtvSongReq.class);
    public final PBStringField room_id = PBField.initString("");
    public final PBStringField mike_id = PBField.initString("");
    public final PBStringField song_id = PBField.initString("");
    public final PBInt32Field opr_type = PBField.initInt32(0);
    public final PBUInt32Field req_timestamp = PBField.initUInt32(0);
    public final PBUInt32Field video_timestamp = PBField.initUInt32(0);
    public final PBUInt32Field acc_timestamp = PBField.initUInt32(0);
    public final PBInt32Field role_type = PBField.initInt32(0);
    public final PBInt32Field sing_type = PBField.initInt32(0);
    public final PBInt32Field sing_part = PBField.initInt32(0);
    public final PBUInt32Field acc_time_length = PBField.initUInt32(0);
}
