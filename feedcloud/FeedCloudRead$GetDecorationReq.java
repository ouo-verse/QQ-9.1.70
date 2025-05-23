package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$GetDecorationReq extends MessageMicro<FeedCloudRead$GetDecorationReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"decoration_id"}, new Object[]{""}, FeedCloudRead$GetDecorationReq.class);
    public final PBStringField decoration_id = PBField.initString("");
}
