package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudTagbasesvr$StAddTagBaseRelateReq extends MessageMicro<FeedCloudTagbasesvr$StAddTagBaseRelateReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"tagName", "tagRelateName", "relateType"}, new Object[]{"", "", 0}, FeedCloudTagbasesvr$StAddTagBaseRelateReq.class);
    public final PBStringField tagName = PBField.initString("");
    public final PBStringField tagRelateName = PBField.initString("");
    public final PBEnumField relateType = PBField.initEnum(0);
}
