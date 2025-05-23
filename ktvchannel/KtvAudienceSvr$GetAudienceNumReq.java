package ktvchannel;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class KtvAudienceSvr$GetAudienceNumReq extends MessageMicro<KtvAudienceSvr$GetAudienceNumReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{AudienceReportConst.ROOM_ID}, new Object[]{""}, KtvAudienceSvr$GetAudienceNumReq.class);
    public final PBStringField room_id = PBField.initString("");
}
