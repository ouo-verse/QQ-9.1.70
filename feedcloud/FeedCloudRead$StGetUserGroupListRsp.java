package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StGetUserGroupListRsp extends MessageMicro<FeedCloudRead$StGetUserGroupListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"extInfo", "groupList", "friendGroupList"}, new Object[]{null, null, null}, FeedCloudRead$StGetUserGroupListRsp.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBRepeatMessageField<FeedCloudMeta$StUserGroupInfo> groupList = PBField.initRepeatMessage(FeedCloudMeta$StUserGroupInfo.class);
    public final PBRepeatMessageField<FeedCloudMeta$StUserGroupInfo> friendGroupList = PBField.initRepeatMessage(FeedCloudMeta$StUserGroupInfo.class);
}
