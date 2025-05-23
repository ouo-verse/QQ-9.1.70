package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes28.dex */
public final class FeedCloudTagbasesvr$StPublishTagBaseInfoReq extends MessageMicro<FeedCloudTagbasesvr$StPublishTagBaseInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"publishType"}, new Object[]{0}, FeedCloudTagbasesvr$StPublishTagBaseInfoReq.class);
    public final PBEnumField publishType = PBField.initEnum(0);
}
