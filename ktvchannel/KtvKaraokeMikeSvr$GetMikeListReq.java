package ktvchannel;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class KtvKaraokeMikeSvr$GetMikeListReq extends MessageMicro<KtvKaraokeMikeSvr$GetMikeListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{AudienceReportConst.ROOM_ID, "mikelist_mask"}, new Object[]{"", 0L}, KtvKaraokeMikeSvr$GetMikeListReq.class);
    public final PBStringField room_id = PBField.initString("");
    public final PBUInt64Field mikelist_mask = PBField.initUInt64(0);
}
