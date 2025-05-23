package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$StFeedButton extends MessageMicro<FeedCloudMeta$StFeedButton> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"text", "jump_url", "button_url"}, new Object[]{"", "", ""}, FeedCloudMeta$StFeedButton.class);
    public final PBStringField text = PBField.initString("");
    public final PBStringField jump_url = PBField.initString("");
    public final PBStringField button_url = PBField.initString("");
}
