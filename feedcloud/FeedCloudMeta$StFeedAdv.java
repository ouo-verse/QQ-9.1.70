package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$StFeedAdv extends MessageMicro<FeedCloudMeta$StFeedAdv> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"jobID", "advData"}, new Object[]{0L, ByteStringMicro.EMPTY}, FeedCloudMeta$StFeedAdv.class);
    public final PBInt64Field jobID = PBField.initInt64(0);
    public final PBBytesField advData = PBField.initBytes(ByteStringMicro.EMPTY);
}
