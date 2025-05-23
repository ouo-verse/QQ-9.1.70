package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$GetUserBoxCntRsp extends MessageMicro<FeedCloudRead$GetUserBoxCntRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"un_open_count"}, new Object[]{0L}, FeedCloudRead$GetUserBoxCntRsp.class);
    public final PBUInt64Field un_open_count = PBField.initUInt64(0);
}
