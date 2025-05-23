package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudTagcategorysvr$StGetTagChallengeRsp extends MessageMicro<FeedCloudTagcategorysvr$StGetTagChallengeRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"errCode", "msg", "tagInfo"}, new Object[]{0, "", null}, FeedCloudTagcategorysvr$StGetTagChallengeRsp.class);
    public final PBInt32Field errCode = PBField.initInt32(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f398477msg = PBField.initString("");
    public final PBRepeatMessageField<FeedCloudMeta$StTagInfo> tagInfo = PBField.initRepeatMessage(FeedCloudMeta$StTagInfo.class);
}
