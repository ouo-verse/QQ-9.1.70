package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudWrite$StModUserGroupReq extends MessageMicro<FeedCloudWrite$StModUserGroupReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"extInfo", "groupInfo"}, new Object[]{null, null}, FeedCloudWrite$StModUserGroupReq.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public FeedCloudMeta$StUserGroupInfo groupInfo = new FeedCloudMeta$StUserGroupInfo();
}
