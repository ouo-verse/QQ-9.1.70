package NS_QQ_STORY_CLIENT;

import NS_COMM.COMM;
import NS_QQ_STORY_META.META$StStoryFeed;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CLIENT$StGetStoryCommentListReq extends MessageMicro<CLIENT$StGetStoryCommentListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"extInfo", "storyFeed", "listNum"}, new Object[]{null, null, 0}, CLIENT$StGetStoryCommentListReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public META$StStoryFeed storyFeed = new META$StStoryFeed();
    public final PBUInt32Field listNum = PBField.initUInt32(0);
}
