package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudWrite$StDelViewHistoryReq extends MessageMicro<FeedCloudWrite$StDelViewHistoryReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"extInfo", "delType"}, new Object[]{null, 1}, FeedCloudWrite$StDelViewHistoryReq.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBEnumField delType = PBField.initEnum(1);
}
