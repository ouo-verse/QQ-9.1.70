package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StQuerySchoolListByKeywordRsp extends MessageMicro<FeedCloudRead$StQuerySchoolListByKeywordRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"schoolInfo"}, new Object[]{null}, FeedCloudRead$StQuerySchoolListByKeywordRsp.class);
    public final PBRepeatMessageField<FeedCloudMeta$SchoolInfo> schoolInfo = PBField.initRepeatMessage(FeedCloudMeta$SchoolInfo.class);
}
