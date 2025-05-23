package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudWrite$ShareResult extends MessageMicro<FeedCloudWrite$ShareResult> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"targets", "status"}, new Object[]{null, 0}, FeedCloudWrite$ShareResult.class);
    public FeedCloudWrite$ShareTarget targets = new FeedCloudWrite$ShareTarget();
    public final PBEnumField status = PBField.initEnum(0);
}
