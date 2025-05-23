package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudDatacard$GetDataCardCoverRsp extends MessageMicro<FeedCloudDatacard$GetDataCardCoverRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34}, new String[]{"user_id", "feed", "update_time", "client_info"}, new Object[]{"", null, 0L, ByteStringMicro.EMPTY}, FeedCloudDatacard$GetDataCardCoverRsp.class);
    public final PBStringField user_id = PBField.initString("");
    public FeedCloudMeta$StFeedAbstract feed = new FeedCloudMeta$StFeedAbstract();
    public final PBUInt64Field update_time = PBField.initUInt64(0);
    public final PBBytesField client_info = PBField.initBytes(ByteStringMicro.EMPTY);
}
