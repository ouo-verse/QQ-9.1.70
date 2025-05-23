package NS_QQ_STORY_CLIENT;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CLIENT$StBannerFriendsUnreadByUser extends MessageMicro<CLIENT$StBannerFriendsUnreadByUser> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34}, new String[]{"userStoryList", "total", "isFinish", "attachInfo"}, new Object[]{null, 0, 0, ""}, CLIENT$StBannerFriendsUnreadByUser.class);
    public final PBRepeatMessageField<CLIENT$StStoryBanner> userStoryList = PBField.initRepeatMessage(CLIENT$StStoryBanner.class);
    public final PBUInt32Field total = PBField.initUInt32(0);
    public final PBUInt32Field isFinish = PBField.initUInt32(0);
    public final PBStringField attachInfo = PBField.initString("");
}
