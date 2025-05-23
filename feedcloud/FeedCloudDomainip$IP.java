package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes28.dex */
public final class FeedCloudDomainip$IP extends MessageMicro<FeedCloudDomainip$IP> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"ip", "port"}, new Object[]{"", 0}, FeedCloudDomainip$IP.class);

    /* renamed from: ip, reason: collision with root package name */
    public final PBStringField f398430ip = PBField.initString("");
    public final PBInt32Field port = PBField.initInt32(0);
}
