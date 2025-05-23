package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes28.dex */
public final class FeedCloudDomainip$DomainIPInfo extends MessageMicro<FeedCloudDomainip$DomainIPInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"domain", "ips"}, new Object[]{"", null}, FeedCloudDomainip$DomainIPInfo.class);
    public final PBStringField domain = PBField.initString("");
    public final PBRepeatMessageField<FeedCloudDomainip$IP> ips = PBField.initRepeatMessage(FeedCloudDomainip$IP.class);
}
