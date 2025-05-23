package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;

/* loaded from: classes28.dex */
public final class FeedCloudDatacard$AddRedPocketCoverRsp extends MessageMicro<FeedCloudDatacard$AddRedPocketCoverRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"cover_info", "number"}, new Object[]{null, null}, FeedCloudDatacard$AddRedPocketCoverRsp.class);
    public FeedCloudDatacard$RedPocketCoverInfo cover_info = new FeedCloudDatacard$RedPocketCoverInfo();
    public FeedCloudDatacard$GetRedPocketNumberRsp number = new FeedCloudDatacard$GetRedPocketNumberRsp();
}
