package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$FrameVertexInfo extends MessageMicro<FeedCloudMeta$FrameVertexInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"coordinate", "width", "height"}, new Object[]{0L, 0L, 0L}, FeedCloudMeta$FrameVertexInfo.class);
    public final PBRepeatField<Long> coordinate = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt64Field width = PBField.initUInt64(0);
    public final PBUInt64Field height = PBField.initUInt64(0);
}
