package NS_QQ_STORY_CLIENT;

import NS_QQ_STORY_META.META$StStoryFeed;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CLIENT$StStoryBanner extends MessageMicro<CLIENT$StStoryBanner> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"vecStoryFeed", "unreadCount"}, new Object[]{null, 0}, CLIENT$StStoryBanner.class);
    public final PBRepeatMessageField<META$StStoryFeed> vecStoryFeed = PBField.initRepeatMessage(META$StStoryFeed.class);
    public final PBUInt32Field unreadCount = PBField.initUInt32(0);
}
