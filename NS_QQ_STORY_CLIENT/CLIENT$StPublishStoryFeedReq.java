package NS_QQ_STORY_CLIENT;

import NS_COMM.COMM;
import NS_QQ_STORY_META.META$StStoryFeed;
import com.tencent.mobileqq.pb.MessageMicro;

/* loaded from: classes.dex */
public final class CLIENT$StPublishStoryFeedReq extends MessageMicro<CLIENT$StPublishStoryFeedReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"extInfo", "storyFeed"}, new Object[]{null, null}, CLIENT$StPublishStoryFeedReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public META$StStoryFeed storyFeed = new META$StStoryFeed();
}
