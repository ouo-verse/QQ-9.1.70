package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$AICommentCache extends MessageMicro<FeedCloudMeta$AICommentCache> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"hot_comments", "my_history_comments", "me_info"}, new Object[]{null, null, null}, FeedCloudMeta$AICommentCache.class);
    public final PBRepeatMessageField<FeedCloudMeta$StComment> hot_comments = PBField.initRepeatMessage(FeedCloudMeta$StComment.class);
    public final PBRepeatMessageField<FeedCloudMeta$StComment> my_history_comments = PBField.initRepeatMessage(FeedCloudMeta$StComment.class);
    public FeedCloudMeta$StUser me_info = new FeedCloudMeta$StUser();
}
