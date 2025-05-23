package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$StButtomBanner extends MessageMicro<FeedCloudMeta$StButtomBanner> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 42, 50, 58, 66}, new String[]{"title", "style_type", "pop_up_ctrl", "vecUser", "extInfo", "content", "count_info", "button"}, new Object[]{"", 0, null, null, null, null, null, null}, FeedCloudMeta$StButtomBanner.class);
    public final PBStringField title = PBField.initString("");
    public final PBEnumField style_type = PBField.initEnum(0);
    public FeedCloudMeta$PopUpControl pop_up_ctrl = new FeedCloudMeta$PopUpControl();
    public final PBRepeatMessageField<FeedCloudMeta$StUser> vecUser = PBField.initRepeatMessage(FeedCloudMeta$StUser.class);
    public final PBRepeatMessageField<FeedCloudCommon$Entry> extInfo = PBField.initRepeatMessage(FeedCloudCommon$Entry.class);
    public FeedCloudMeta$UserImageAndText content = new FeedCloudMeta$UserImageAndText();
    public FeedCloudMeta$StCountInfo count_info = new FeedCloudMeta$StCountInfo();
    public FeedCloudMeta$StFeedButton button = new FeedCloudMeta$StFeedButton();
}
