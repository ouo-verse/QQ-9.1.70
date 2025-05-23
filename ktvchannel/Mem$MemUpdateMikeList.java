package ktvchannel;

import com.tencent.mobileqq.dpc.DeviceProfileManager;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class Mem$MemUpdateMikeList extends MessageMicro<Mem$MemUpdateMikeList> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{AudienceReportConst.ROOM_ID, DeviceProfileManager.KEY_LAST_UPDATE_TIME}, new Object[]{"", 0}, Mem$MemUpdateMikeList.class);
    public final PBStringField room_id = PBField.initString("");
    public final PBUInt32Field last_update_time = PBField.initUInt32(0);
}
