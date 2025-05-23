package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudDatacard$SetDataCardCoverReq extends MessageMicro<FeedCloudDatacard$SetDataCardCoverReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"feed_id", "client_info"}, new Object[]{"", ByteStringMicro.EMPTY}, FeedCloudDatacard$SetDataCardCoverReq.class);
    public final PBStringField feed_id = PBField.initString("");
    public final PBBytesField client_info = PBField.initBytes(ByteStringMicro.EMPTY);
}
