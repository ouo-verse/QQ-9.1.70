package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudUsersettings$Interval extends MessageMicro<FeedCloudUsersettings$Interval> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"polling", "homeSwitch"}, new Object[]{0, 0}, FeedCloudUsersettings$Interval.class);
    public final PBInt32Field polling = PBField.initInt32(0);
    public final PBInt32Field homeSwitch = PBField.initInt32(0);
}
