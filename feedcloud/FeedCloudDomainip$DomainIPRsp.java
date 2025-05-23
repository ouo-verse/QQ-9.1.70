package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes28.dex */
public final class FeedCloudDomainip$DomainIPRsp extends MessageMicro<FeedCloudDomainip$DomainIPRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"infos"}, new Object[]{null}, FeedCloudDomainip$DomainIPRsp.class);
    public final PBRepeatMessageField<FeedCloudDomainip$DomainIPInfo> infos = PBField.initRepeatMessage(FeedCloudDomainip$DomainIPInfo.class);
}
