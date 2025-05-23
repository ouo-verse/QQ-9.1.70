package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudWidget$StButtonGroup extends MessageMicro<FeedCloudWidget$StButtonGroup> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"buttons"}, new Object[]{null}, FeedCloudWidget$StButtonGroup.class);
    public final PBRepeatMessageField<FeedCloudWidget$StButton> buttons = PBField.initRepeatMessage(FeedCloudWidget$StButton.class);
}
