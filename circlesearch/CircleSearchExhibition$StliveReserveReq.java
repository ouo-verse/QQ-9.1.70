package circlesearch;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CircleSearchExhibition$StliveReserveReq extends MessageMicro<CircleSearchExhibition$StliveReserveReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"uin", AudienceReportConst.ROOM_ID, "status"}, new Object[]{"", "", 0}, CircleSearchExhibition$StliveReserveReq.class);
    public final PBStringField uin = PBField.initString("");
    public final PBStringField room_id = PBField.initString("");
    public final PBUInt32Field status = PBField.initUInt32(0);
}
