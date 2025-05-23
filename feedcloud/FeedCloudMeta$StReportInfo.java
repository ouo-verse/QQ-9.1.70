package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$StReportInfo extends MessageMicro<FeedCloudMeta$StReportInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"id", "busiReport"}, new Object[]{"", ByteStringMicro.EMPTY}, FeedCloudMeta$StReportInfo.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f398461id = PBField.initString("");
    public final PBBytesField busiReport = PBField.initBytes(ByteStringMicro.EMPTY);
}
