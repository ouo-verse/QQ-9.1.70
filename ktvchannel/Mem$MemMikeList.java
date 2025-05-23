package ktvchannel;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class Mem$MemMikeList extends MessageMicro<Mem$MemMikeList> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40}, new String[]{AudienceReportConst.ROOM_ID, "vct_mike_index", "sequence_id", "apply_total", "onmike_total"}, new Object[]{"", null, 0L, 0, 0}, Mem$MemMikeList.class);
    public final PBStringField room_id = PBField.initString("");
    public final PBRepeatMessageField<Mem$MikeIndex> vct_mike_index = PBField.initRepeatMessage(Mem$MikeIndex.class);
    public final PBUInt64Field sequence_id = PBField.initUInt64(0);
    public final PBUInt32Field apply_total = PBField.initUInt32(0);
    public final PBUInt32Field onmike_total = PBField.initUInt32(0);
}
