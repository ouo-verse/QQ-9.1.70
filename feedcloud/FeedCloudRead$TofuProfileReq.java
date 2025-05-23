package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes28.dex */
public final class FeedCloudRead$TofuProfileReq extends MessageMicro<FeedCloudRead$TofuProfileReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"uid"}, new Object[]{""}, FeedCloudRead$TofuProfileReq.class);
    public final PBStringField uid = PBField.initString("");
}
