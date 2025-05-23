package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes28.dex */
public final class FeedCloudRead$StGetTagPageHeaderRsp extends MessageMicro<FeedCloudRead$StGetTagPageHeaderRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"tagBytesData"}, new Object[]{ByteStringMicro.EMPTY}, FeedCloudRead$StGetTagPageHeaderRsp.class);
    public final PBBytesField tagBytesData = PBField.initBytes(ByteStringMicro.EMPTY);
}
