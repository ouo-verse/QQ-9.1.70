package ktvchannel;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class KtvKaraokeMikeSvr$HcTransSoloReq extends MessageMicro<KtvKaraokeMikeSvr$HcTransSoloReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42}, new String[]{AudienceReportConst.ROOM_ID, "mike_id", "device_type", "song_mid", "file_mid"}, new Object[]{"", "", 0, "", ""}, KtvKaraokeMikeSvr$HcTransSoloReq.class);
    public final PBStringField room_id = PBField.initString("");
    public final PBStringField mike_id = PBField.initString("");
    public final PBInt32Field device_type = PBField.initInt32(0);
    public final PBStringField song_mid = PBField.initString("");
    public final PBStringField file_mid = PBField.initString("");
}
