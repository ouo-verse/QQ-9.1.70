package msf.msgcomm;

import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class msg_comm$C2CTmpMsgHead extends MessageMicro<msg_comm$C2CTmpMsgHead> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField business_name;
    public final PBBytesField business_sub_content;
    public final PBUInt32Field direction_flag;
    public final PBStringField from_phone;
    public final PBUInt32Field lock_display;
    public final PBBytesField reserved;
    public final PBBytesField sig;
    public final PBUInt32Field sig_type;
    public final PBStringField to_phone;
    public final PBUInt32Field c2c_type = PBField.initUInt32(0);
    public final PBUInt32Field service_type = PBField.initUInt32(0);
    public final PBUInt64Field group_uin = PBField.initUInt64(0);
    public final PBUInt64Field group_code = PBField.initUInt64(0);

    static {
        String[] strArr = {"c2c_type", "service_type", "group_uin", "group_code", PreloadTRTCPlayerParams.KEY_SIG, "sig_type", "from_phone", "to_phone", "lock_display", "direction_flag", "reserved", "business_name", "business_sub_content"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 48, 58, 66, 72, 80, 90, 114, 122}, strArr, new Object[]{0, 0, 0L, 0L, byteStringMicro, 0, "", "", 0, 0, byteStringMicro, byteStringMicro, byteStringMicro}, msg_comm$C2CTmpMsgHead.class);
    }

    public msg_comm$C2CTmpMsgHead() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.sig = PBField.initBytes(byteStringMicro);
        this.sig_type = PBField.initUInt32(0);
        this.from_phone = PBField.initString("");
        this.to_phone = PBField.initString("");
        this.lock_display = PBField.initUInt32(0);
        this.direction_flag = PBField.initUInt32(0);
        this.reserved = PBField.initBytes(byteStringMicro);
        this.business_name = PBField.initBytes(byteStringMicro);
        this.business_sub_content = PBField.initBytes(byteStringMicro);
    }
}
