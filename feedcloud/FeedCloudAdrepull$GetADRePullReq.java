package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes28.dex */
public final class FeedCloudAdrepull$GetADRePullReq extends MessageMicro<FeedCloudAdrepull$GetADRePullReq> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField adres;
    public final PBStringField attach_info;
    public final PBBytesField client_info;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"adres", "attach_info", "client_info"}, new Object[]{byteStringMicro, "", byteStringMicro}, FeedCloudAdrepull$GetADRePullReq.class);
    }

    public FeedCloudAdrepull$GetADRePullReq() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.adres = PBField.initBytes(byteStringMicro);
        this.attach_info = PBField.initString("");
        this.client_info = PBField.initBytes(byteStringMicro);
    }
}
