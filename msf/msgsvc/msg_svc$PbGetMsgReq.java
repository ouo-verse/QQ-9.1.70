package msf.msgsvc;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes28.dex */
public final class msg_svc$PbGetMsgReq extends MessageMicro<msg_svc$PbGetMsgReq> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_server_buf;
    public final PBBytesField msg_ctrl_buf;
    public final PBUInt32Field nt_flag;
    public final PBBytesField pubaccount_cookie;
    public final PBEnumField sync_flag = PBField.initEnum(0);
    public final PBBytesField sync_cookie = PBField.initBytes(ByteStringMicro.copyFromUtf8(""));
    public final PBUInt32Field ramble_flag = PBField.initUInt32(1);
    public final PBUInt32Field latest_ramble_number = PBField.initUInt32(20);
    public final PBUInt32Field other_ramble_number = PBField.initUInt32(3);
    public final PBUInt32Field online_sync_flag = PBField.initUInt32(1);
    public final PBUInt32Field context_flag = PBField.initUInt32(0);
    public final PBUInt32Field whisper_session_id = PBField.initUInt32(0);
    public final PBUInt32Field msg_req_type = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 40, 48, 56, 64, 72, 82, 90, 98, 128}, new String[]{"sync_flag", "sync_cookie", "ramble_flag", "latest_ramble_number", "other_ramble_number", "online_sync_flag", "context_flag", "whisper_session_id", "msg_req_type", "pubaccount_cookie", "msg_ctrl_buf", "bytes_server_buf", "nt_flag"}, new Object[]{0, ByteStringMicro.copyFromUtf8(""), 1, 20, 3, 1, 0, 0, 0, byteStringMicro, byteStringMicro, byteStringMicro, 0}, msg_svc$PbGetMsgReq.class);
    }

    public msg_svc$PbGetMsgReq() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.pubaccount_cookie = PBField.initBytes(byteStringMicro);
        this.msg_ctrl_buf = PBField.initBytes(byteStringMicro);
        this.bytes_server_buf = PBField.initBytes(byteStringMicro);
        this.nt_flag = PBField.initUInt32(0);
    }
}
