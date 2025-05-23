package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes28.dex */
public final class FeedCloudRead$StPrePullOfficialAccountOverlayADRsp extends MessageMicro<FeedCloudRead$StPrePullOfficialAccountOverlayADRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"overLayADBytes"}, new Object[]{ByteStringMicro.EMPTY}, FeedCloudRead$StPrePullOfficialAccountOverlayADRsp.class);
    public final PBBytesField overLayADBytes = PBField.initBytes(ByteStringMicro.EMPTY);
}
