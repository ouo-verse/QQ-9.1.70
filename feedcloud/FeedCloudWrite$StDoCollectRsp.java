package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudWrite$StDoCollectRsp extends MessageMicro<FeedCloudWrite$StDoCollectRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"extInfo", "hasFavorites"}, new Object[]{null, Boolean.FALSE}, FeedCloudWrite$StDoCollectRsp.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBBoolField hasFavorites = PBField.initBool(false);
}
