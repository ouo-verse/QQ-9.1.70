package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudToastshowsvr$StShowTime extends MessageMicro<FeedCloudToastshowsvr$StShowTime> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"showTimeType", "value", "showDuration"}, new Object[]{0, 0L, 0L}, FeedCloudToastshowsvr$StShowTime.class);
    public final PBUInt32Field showTimeType = PBField.initUInt32(0);
    public final PBInt64Field value = PBField.initInt64(0);
    public final PBInt64Field showDuration = PBField.initInt64(0);
}
