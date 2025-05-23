package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes28.dex */
public final class FeedCloudWrite$PushBoxBasicDrawInfo extends MessageMicro<FeedCloudWrite$PushBoxBasicDrawInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 21, 24}, new String[]{"box_type", "rate", "count"}, new Object[]{0, Float.valueOf(0.0f), 0L}, FeedCloudWrite$PushBoxBasicDrawInfo.class);
    public final PBUInt32Field box_type = PBField.initUInt32(0);
    public final PBFloatField rate = PBField.initFloat(0.0f);
    public final PBUInt64Field count = PBField.initUInt64(0);
}
