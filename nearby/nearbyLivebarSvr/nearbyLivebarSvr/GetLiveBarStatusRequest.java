package nearby.nearbyLivebarSvr.nearbyLivebarSvr;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class GetLiveBarStatusRequest extends MessageMicro<GetLiveBarStatusRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32}, new String[]{AudienceReportConst.ANCHOR_ID, "longitude", "latitude", "need_anchorInfo"}, new Object[]{0L, "", "", 0}, GetLiveBarStatusRequest.class);
    public final PBUInt64Field anchor_id = PBField.initUInt64(0);
    public final PBStringField longitude = PBField.initString("");
    public final PBStringField latitude = PBField.initString("");
    public final PBUInt32Field need_anchorInfo = PBField.initUInt32(0);
}
