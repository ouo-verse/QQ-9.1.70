package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$GetAICommentsReq extends MessageMicro<FeedCloudRead$GetAICommentsReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42, 50}, new String[]{"trans_info", "feed", "user_write_text", "gen_type", "target_cmt", "target_reply"}, new Object[]{ByteStringMicro.EMPTY, null, "", 0, null, null}, FeedCloudRead$GetAICommentsReq.class);
    public final PBBytesField trans_info = PBField.initBytes(ByteStringMicro.EMPTY);
    public FeedCloudMeta$StFeed feed = new FeedCloudMeta$StFeed();
    public final PBStringField user_write_text = PBField.initString("");
    public final PBInt32Field gen_type = PBField.initInt32(0);
    public FeedCloudMeta$StComment target_cmt = new FeedCloudMeta$StComment();
    public FeedCloudMeta$StReply target_reply = new FeedCloudMeta$StReply();
}
