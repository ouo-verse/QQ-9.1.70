package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudTagcategorysvr$StCreateUserTagRsp extends MessageMicro<FeedCloudTagcategorysvr$StCreateUserTagRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"errCode", "msg", "tagInfo"}, new Object[]{0, "", null}, FeedCloudTagcategorysvr$StCreateUserTagRsp.class);
    public final PBInt32Field errCode = PBField.initInt32(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f398475msg = PBField.initString("");
    public FeedCloudMeta$StTagInfo tagInfo = new FeedCloudMeta$StTagInfo();
}
