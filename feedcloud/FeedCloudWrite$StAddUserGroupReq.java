package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudWrite$StAddUserGroupReq extends MessageMicro<FeedCloudWrite$StAddUserGroupReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"extInfo", "groupInfo"}, new Object[]{null, null}, FeedCloudWrite$StAddUserGroupReq.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public FeedCloudMeta$StUserGroupInfo groupInfo = new FeedCloudMeta$StUserGroupInfo();
}
