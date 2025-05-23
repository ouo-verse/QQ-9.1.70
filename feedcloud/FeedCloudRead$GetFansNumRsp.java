package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$GetFansNumRsp extends MessageMicro<FeedCloudRead$GetFansNumRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"fansNum"}, new Object[]{0}, FeedCloudRead$GetFansNumRsp.class);
    public final PBInt32Field fansNum = PBField.initInt32(0);
}
