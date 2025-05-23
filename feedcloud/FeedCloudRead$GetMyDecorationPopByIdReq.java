package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes28.dex */
public final class FeedCloudRead$GetMyDecorationPopByIdReq extends MessageMicro<FeedCloudRead$GetMyDecorationPopByIdReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"decoration_id", "pop", "src"}, new Object[]{"", Boolean.FALSE, 0}, FeedCloudRead$GetMyDecorationPopByIdReq.class);
    public final PBStringField decoration_id = PBField.initString("");
    public final PBBoolField pop = PBField.initBool(false);
    public final PBInt32Field src = PBField.initInt32(0);
}
