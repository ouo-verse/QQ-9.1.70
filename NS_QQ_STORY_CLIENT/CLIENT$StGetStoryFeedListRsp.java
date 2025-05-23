package NS_QQ_STORY_CLIENT;

import NS_COMM.COMM;
import NS_QQ_STORY_META.META$StStoryFeed;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CLIENT$StGetStoryFeedListRsp extends MessageMicro<CLIENT$StGetStoryFeedListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40, 50, 56, 66}, new String[]{"extInfo", "vecStoryFeed", "totalNum", "isFinish", "isShowCamera", "vecUinStory", "hasNewStory", "storyBannerBuff"}, new Object[]{null, null, 0, 0, 0, null, 0, ByteStringMicro.EMPTY}, CLIENT$StGetStoryFeedListRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBRepeatMessageField<META$StStoryFeed> vecStoryFeed = PBField.initRepeatMessage(META$StStoryFeed.class);
    public final PBUInt32Field totalNum = PBField.initUInt32(0);
    public final PBUInt32Field isFinish = PBField.initUInt32(0);
    public final PBUInt32Field isShowCamera = PBField.initUInt32(0);
    public final PBRepeatMessageField<CLIENT$StUinStory> vecUinStory = PBField.initRepeatMessage(CLIENT$StUinStory.class);
    public final PBUInt32Field hasNewStory = PBField.initUInt32(0);
    public final PBBytesField storyBannerBuff = PBField.initBytes(ByteStringMicro.EMPTY);
}
