package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudOfficialaccount$OfficialTopFollowUsersRsp extends MessageMicro<FeedCloudOfficialaccount$OfficialTopFollowUsersRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"title", "users_detail"}, new Object[]{"", null}, FeedCloudOfficialaccount$OfficialTopFollowUsersRsp.class);
    public final PBStringField title = PBField.initString("");
    public final PBRepeatMessageField<FeedCloudOfficialaccount$TopUserDetail> users_detail = PBField.initRepeatMessage(FeedCloudOfficialaccount$TopUserDetail.class);
}
