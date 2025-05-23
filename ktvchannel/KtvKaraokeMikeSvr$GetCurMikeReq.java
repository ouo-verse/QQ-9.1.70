package ktvchannel;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class KtvKaraokeMikeSvr$GetCurMikeReq extends MessageMicro<KtvKaraokeMikeSvr$GetCurMikeReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40}, new String[]{AudienceReportConst.ROOM_ID, "from_type", "user_scene", "app_ktv_status", "mask"}, new Object[]{"", 0, 0, 0, 0}, KtvKaraokeMikeSvr$GetCurMikeReq.class);
    public final PBStringField room_id = PBField.initString("");
    public final PBInt32Field from_type = PBField.initInt32(0);
    public final PBInt32Field user_scene = PBField.initInt32(0);
    public final PBInt32Field app_ktv_status = PBField.initInt32(0);
    public final PBUInt32Field mask = PBField.initUInt32(0);
}
