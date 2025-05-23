package circlesearch;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudMeta$StFeed;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CircleSearchExhibition$StQueryUser extends MessageMicro<CircleSearchExhibition$StQueryUser> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 42, 48, 58}, new String[]{"uid", "isBigV", "relationType", "isQQFriend", "feeds", "isBlueV", "feedItems"}, new Object[]{"", 0, 0, 0, null, 0, null}, CircleSearchExhibition$StQueryUser.class);
    public final PBStringField uid = PBField.initString("");
    public final PBInt32Field isBigV = PBField.initInt32(0);
    public final PBUInt32Field relationType = PBField.initUInt32(0);
    public final PBInt32Field isQQFriend = PBField.initInt32(0);
    public final PBRepeatMessageField<FeedCloudMeta$StFeed> feeds = PBField.initRepeatMessage(FeedCloudMeta$StFeed.class);
    public final PBInt32Field isBlueV = PBField.initInt32(0);
    public final PBRepeatMessageField<CircleSearchExhibition$stFeedItem> feedItems = PBField.initRepeatMessage(CircleSearchExhibition$stFeedItem.class);
}
