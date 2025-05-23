package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$CmtBlockAd extends MessageMicro<FeedCloudMeta$CmtBlockAd> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"trans_rsp"}, new Object[]{ByteStringMicro.EMPTY}, FeedCloudMeta$CmtBlockAd.class);
    public final PBBytesField trans_rsp = PBField.initBytes(ByteStringMicro.EMPTY);
}
