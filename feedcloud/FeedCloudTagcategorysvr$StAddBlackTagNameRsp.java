package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudTagcategorysvr$StAddBlackTagNameRsp extends MessageMicro<FeedCloudTagcategorysvr$StAddBlackTagNameRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"errCode", "msg"}, new Object[]{0, ""}, FeedCloudTagcategorysvr$StAddBlackTagNameRsp.class);
    public final PBInt32Field errCode = PBField.initInt32(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f398473msg = PBField.initString("");
}
