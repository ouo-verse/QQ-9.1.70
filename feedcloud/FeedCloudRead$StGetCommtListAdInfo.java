package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StGetCommtListAdInfo extends MessageMicro<FeedCloudRead$StGetCommtListAdInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"is_need_pull_ad", "ad_trans_req"}, new Object[]{0, ByteStringMicro.EMPTY}, FeedCloudRead$StGetCommtListAdInfo.class);
    public final PBUInt32Field is_need_pull_ad = PBField.initUInt32(0);
    public final PBBytesField ad_trans_req = PBField.initBytes(ByteStringMicro.EMPTY);
}
