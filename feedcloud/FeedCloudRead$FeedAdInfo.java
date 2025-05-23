package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$FeedAdInfo extends MessageMicro<FeedCloudRead$FeedAdInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"feedID", "ad"}, new Object[]{"", ByteStringMicro.EMPTY}, FeedCloudRead$FeedAdInfo.class);
    public final PBStringField feedID = PBField.initString("");

    /* renamed from: ad, reason: collision with root package name */
    public final PBBytesField f398469ad = PBField.initBytes(ByteStringMicro.EMPTY);
}
