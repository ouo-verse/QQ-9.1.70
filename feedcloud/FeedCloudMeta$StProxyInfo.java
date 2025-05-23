package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes28.dex */
public final class FeedCloudMeta$StProxyInfo extends MessageMicro<FeedCloudMeta$StProxyInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{"cmdId", "subCmdId", "appProtocol", "reqBody"}, new Object[]{0, 0, "", ByteStringMicro.EMPTY}, FeedCloudMeta$StProxyInfo.class);
    public final PBInt32Field cmdId = PBField.initInt32(0);
    public final PBInt32Field subCmdId = PBField.initInt32(0);
    public final PBStringField appProtocol = PBField.initString("");
    public final PBBytesField reqBody = PBField.initBytes(ByteStringMicro.EMPTY);
}
