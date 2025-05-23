package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes28.dex */
public final class FeedCloudPubGuideSvr$QueryPubInfoRsp extends MessageMicro<FeedCloudPubGuideSvr$QueryPubInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"has_pub"}, new Object[]{0}, FeedCloudPubGuideSvr$QueryPubInfoRsp.class);
    public final PBEnumField has_pub = PBField.initEnum(0);
}
