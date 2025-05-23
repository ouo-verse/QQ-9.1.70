package circlesearch;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CircleSearchExhibition$BypassBeatDetail extends MessageMicro<CircleSearchExhibition$BypassBeatDetail> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40, 50}, new String[]{"feed_id", "post_time", "beat_time", "beat_reason", "beat_common", "beat_desc"}, new Object[]{"", 0, 0, 0, 0, ""}, CircleSearchExhibition$BypassBeatDetail.class);
    public final PBStringField feed_id = PBField.initString("");
    public final PBUInt32Field post_time = PBField.initUInt32(0);
    public final PBUInt32Field beat_time = PBField.initUInt32(0);
    public final PBUInt32Field beat_reason = PBField.initUInt32(0);
    public final PBUInt32Field beat_common = PBField.initUInt32(0);
    public final PBStringField beat_desc = PBField.initString("");
}
