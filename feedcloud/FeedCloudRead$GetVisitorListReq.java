package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$GetVisitorListReq extends MessageMicro<FeedCloudRead$GetVisitorListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"transfer_info", "need_visitor"}, new Object[]{"", Boolean.FALSE}, FeedCloudRead$GetVisitorListReq.class);
    public final PBStringField transfer_info = PBField.initString("");
    public final PBBoolField need_visitor = PBField.initBool(false);
}
