package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$StFollowRecomInfo extends MessageMicro<FeedCloudMeta$StFollowRecomInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 34, 50, 58, 66, 74}, new String[]{"followText", "followUsers", "commFriendText", "commGroupText", "secondFriendText", "secondFriends"}, new Object[]{"", null, "", "", "", null}, FeedCloudMeta$StFollowRecomInfo.class);
    public final PBStringField followText = PBField.initString("");
    public final PBRepeatMessageField<FeedCloudMeta$StFollowUser> followUsers = PBField.initRepeatMessage(FeedCloudMeta$StFollowUser.class);
    public final PBStringField commFriendText = PBField.initString("");
    public final PBStringField commGroupText = PBField.initString("");
    public final PBStringField secondFriendText = PBField.initString("");
    public final PBRepeatMessageField<FeedCloudMeta$StSecondFriend> secondFriends = PBField.initRepeatMessage(FeedCloudMeta$StSecondFriend.class);
}
