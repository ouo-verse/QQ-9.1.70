package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudCommon$StWebCommJsonRsp extends MessageMicro<FeedCloudCommon$StWebCommJsonRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"data"}, new Object[]{ByteStringMicro.EMPTY}, FeedCloudCommon$StWebCommJsonRsp.class);
    public final PBBytesField data = PBField.initBytes(ByteStringMicro.EMPTY);
}
