package ktvchannel;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class KtvKaraokeMikeSvr$ApplyMikeReq extends MessageMicro<KtvKaraokeMikeSvr$ApplyMikeReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42}, new String[]{AudienceReportConst.ROOM_ID, "song_mid", "sing_type", "sing_part", "ext_info"}, new Object[]{"", "", 0, 0, null}, KtvKaraokeMikeSvr$ApplyMikeReq.class);
    public final PBStringField room_id = PBField.initString("");
    public final PBStringField song_mid = PBField.initString("");
    public final PBInt32Field sing_type = PBField.initInt32(0);
    public final PBInt32Field sing_part = PBField.initInt32(0);
    public final PBRepeatMessageField<KtvCommon$KVItem> ext_info = PBField.initRepeatMessage(KtvCommon$KVItem.class);
}
