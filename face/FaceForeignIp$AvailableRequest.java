package face;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FaceForeignIp$AvailableRequest extends MessageMicro<FaceForeignIp$AvailableRequest> {
    static final MessageMicro.FieldMap __fieldMap__;

    /* renamed from: ip, reason: collision with root package name */
    public final PBBytesField f398124ip;
    public final PBUInt32Field platform;
    public final PBBytesField version;
    public final PBRepeatField<Integer> dims = PBField.initRepeat(PBEnumField.__repeatHelper__);
    public final PBUInt32Field appID = PBField.initUInt32(0);
    public final PBStringField name = PBField.initString("");
    public final PBStringField from = PBField.initString("");
    public final PBUInt64Field uin = PBField.initUInt64(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 80, 90, 96, 106}, new String[]{"dims", "appID", "name", "from", "uin", "ip", "platform", "version"}, new Object[]{0, 0, "", "", 0L, byteStringMicro, 0, byteStringMicro}, FaceForeignIp$AvailableRequest.class);
    }

    public FaceForeignIp$AvailableRequest() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.f398124ip = PBField.initBytes(byteStringMicro);
        this.platform = PBField.initUInt32(0);
        this.version = PBField.initBytes(byteStringMicro);
    }
}
