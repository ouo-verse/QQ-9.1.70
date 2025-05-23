package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$StCommentExtraInfo extends MessageMicro<FeedCloudMeta$StCommentExtraInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"displayShopEntrance", "privileges", "reddotInfo"}, new Object[]{Boolean.FALSE, 0, null}, FeedCloudMeta$StCommentExtraInfo.class);
    public final PBBoolField displayShopEntrance = PBField.initBool(false);
    public final PBRepeatField<Integer> privileges = PBField.initRepeat(PBInt32Field.__repeatHelper__);
    public FeedCloudMeta$StCommentReddotInfo reddotInfo = new FeedCloudMeta$StCommentReddotInfo();
}
