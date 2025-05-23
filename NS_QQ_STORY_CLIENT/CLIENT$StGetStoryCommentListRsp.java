package NS_QQ_STORY_CLIENT;

import NS_COMM.COMM;
import NS_QQ_STORY_META.META$StComment;
import NS_QQ_STORY_META.META$StStoryFeed;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CLIENT$StGetStoryCommentListRsp extends MessageMicro<CLIENT$StGetStoryCommentListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42}, new String[]{"extInfo", "vecComment", "totalNum", "isFinish", "storyFeed"}, new Object[]{null, null, 0, 0, null}, CLIENT$StGetStoryCommentListRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBRepeatMessageField<META$StComment> vecComment = PBField.initRepeatMessage(META$StComment.class);
    public final PBUInt32Field totalNum = PBField.initUInt32(0);
    public final PBUInt32Field isFinish = PBField.initUInt32(0);
    public META$StStoryFeed storyFeed = new META$StStoryFeed();
}
