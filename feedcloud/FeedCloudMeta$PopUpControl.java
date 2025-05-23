package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* loaded from: classes28.dex */
public final class FeedCloudMeta$PopUpControl extends MessageMicro<FeedCloudMeta$PopUpControl> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{16, 24}, new String[]{"play_times", "play_duration_seconds"}, new Object[]{0, 0}, FeedCloudMeta$PopUpControl.class);
    public final PBInt32Field play_times = PBField.initInt32(0);
    public final PBInt32Field play_duration_seconds = PBField.initInt32(0);
}
