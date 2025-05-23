package NS_QQ_STORY_CLIENT;

import NS_COMM.COMM;
import NS_QQ_STORY_META.META$StStoryFeed;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CLIENT$StGetUserNewestStoryRsp extends MessageMicro<CLIENT$StGetUserNewestStoryRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32}, new String[]{"extInfo", "vecStoryFeed", "vecUinStory", "hasNewStory"}, new Object[]{null, null, null, 0}, CLIENT$StGetUserNewestStoryRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBRepeatMessageField<META$StStoryFeed> vecStoryFeed = PBField.initRepeatMessage(META$StStoryFeed.class);
    public final PBRepeatMessageField<CLIENT$StUinStory> vecUinStory = PBField.initRepeatMessage(CLIENT$StUinStory.class);
    public final PBUInt32Field hasNewStory = PBField.initUInt32(0);
}
