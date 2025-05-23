package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$GetAICommentsRsp extends MessageMicro<FeedCloudRead$GetAICommentsRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"trans_info", "comments", "ext_info"}, new Object[]{ByteStringMicro.EMPTY, null, null}, FeedCloudRead$GetAICommentsRsp.class);
    public final PBBytesField trans_info = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<FeedCloudMeta$StComment> comments = PBField.initRepeatMessage(FeedCloudMeta$StComment.class);
    public FeedCloudCommon$StCommonExt ext_info = new FeedCloudCommon$StCommonExt();
}
