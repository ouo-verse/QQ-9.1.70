package feedcloud;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes28.dex */
public final class FeedCloudPubGuideWriter$FirstPubAnimationReportReq extends MessageMicro<FeedCloudPubGuideWriter$FirstPubAnimationReportReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{WadlProxyConsts.CHANNEL}, new Object[]{0}, FeedCloudPubGuideWriter$FirstPubAnimationReportReq.class);
    public final PBUInt32Field channel = PBField.initUInt32(0);
}
