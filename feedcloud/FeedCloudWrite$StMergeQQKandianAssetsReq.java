package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudWrite$StMergeQQKandianAssetsReq extends MessageMicro<FeedCloudWrite$StMergeQQKandianAssetsReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"extInfo", "profileAuthorize", "feedsAuthorize"}, new Object[]{null, 0, 0}, FeedCloudWrite$StMergeQQKandianAssetsReq.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBUInt32Field profileAuthorize = PBField.initUInt32(0);
    public final PBUInt32Field feedsAuthorize = PBField.initUInt32(0);
}
