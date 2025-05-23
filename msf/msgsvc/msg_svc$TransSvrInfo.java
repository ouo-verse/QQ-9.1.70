package msf.msgsvc;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class msg_svc$TransSvrInfo extends MessageMicro<msg_svc$TransSvrInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_err_msg;
    public final PBBytesField bytes_trans_info;
    public final PBUInt32Field uint32_sub_type = PBField.initUInt32(0);
    public final PBInt32Field int32_ret_code = PBField.initInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{"uint32_sub_type", "int32_ret_code", "bytes_err_msg", "bytes_trans_info"}, new Object[]{0, 0, byteStringMicro, byteStringMicro}, msg_svc$TransSvrInfo.class);
    }

    public msg_svc$TransSvrInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_err_msg = PBField.initBytes(byteStringMicro);
        this.bytes_trans_info = PBField.initBytes(byteStringMicro);
    }
}
