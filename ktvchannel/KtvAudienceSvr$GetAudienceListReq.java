package ktvchannel;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class KtvAudienceSvr$GetAudienceListReq extends MessageMicro<KtvAudienceSvr$GetAudienceListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32, 42}, new String[]{AudienceReportConst.ROOM_ID, WidgetCacheConstellationData.NUM, "passback", "need_all_users", "convert_param"}, new Object[]{"", 0, "", 0, ""}, KtvAudienceSvr$GetAudienceListReq.class);
    public final PBStringField room_id = PBField.initString("");
    public final PBUInt32Field num = PBField.initUInt32(0);
    public final PBStringField passback = PBField.initString("");
    public final PBUInt32Field need_all_users = PBField.initUInt32(0);
    public final PBStringField convert_param = PBField.initString("");
}
