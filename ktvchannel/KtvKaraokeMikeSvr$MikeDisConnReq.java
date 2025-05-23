package ktvchannel;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class KtvKaraokeMikeSvr$MikeDisConnReq extends MessageMicro<KtvKaraokeMikeSvr$MikeDisConnReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"mike_id", AudienceReportConst.ROOM_ID, "role_type"}, new Object[]{"", "", 0}, KtvKaraokeMikeSvr$MikeDisConnReq.class);
    public final PBStringField mike_id = PBField.initString("");
    public final PBStringField room_id = PBField.initString("");
    public final PBInt32Field role_type = PBField.initInt32(0);
}
