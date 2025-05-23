package msf.msgsvc;

import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class msg_svc$CommTmp extends MessageMicro<msg_svc$CommTmp> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField reserved;
    public final PBBytesField sig;
    public final PBUInt64Field to_uin = PBField.initUInt64(0);
    public final PBUInt32Field c2c_type = PBField.initUInt32(0);
    public final PBUInt32Field svr_type = PBField.initUInt32(0);

    static {
        String[] strArr = {"to_uin", "c2c_type", "svr_type", PreloadTRTCPlayerParams.KEY_SIG, "reserved"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42}, strArr, new Object[]{0L, 0, 0, byteStringMicro, byteStringMicro}, msg_svc$CommTmp.class);
    }

    public msg_svc$CommTmp() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.sig = PBField.initBytes(byteStringMicro);
        this.reserved = PBField.initBytes(byteStringMicro);
    }
}
