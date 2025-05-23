package msf.msgsvc;

import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import msf.msgcomm.msg_comm$UinPairMsg;

/* loaded from: classes28.dex */
public final class msg_svc$PbGetMsgResp extends MessageMicro<msg_svc$PbGetMsgResp> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt64Field bind_uin;
    public final PBBoolField is_partial_sync;
    public final PBBytesField msg_ctrl_buf;
    public final PBUInt32Field msg_rsp_type;
    public final PBBytesField pubaccount_cookie;
    public final PBBytesField sync_cookie;
    public final PBEnumField sync_flag;
    public final PBRepeatMessageField<msg_comm$UinPairMsg> uin_pair_msgs;
    public final PBUInt32Field result = PBField.initUInt32(0);
    public final PBStringField errmsg = PBField.initString("");

    static {
        String[] strArr = {"result", HippyReporter.EXTRA_KEY_REPORT_ERRMSG, "sync_cookie", "sync_flag", "uin_pair_msgs", "bind_uin", "msg_rsp_type", "pubaccount_cookie", "is_partial_sync", "msg_ctrl_buf"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 42, 48, 56, 66, 72, 82}, strArr, new Object[]{0, "", byteStringMicro, 0, null, 0L, 0, byteStringMicro, Boolean.FALSE, byteStringMicro}, msg_svc$PbGetMsgResp.class);
    }

    public msg_svc$PbGetMsgResp() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.sync_cookie = PBField.initBytes(byteStringMicro);
        this.sync_flag = PBField.initEnum(0);
        this.uin_pair_msgs = PBField.initRepeatMessage(msg_comm$UinPairMsg.class);
        this.bind_uin = PBField.initUInt64(0L);
        this.msg_rsp_type = PBField.initUInt32(0);
        this.pubaccount_cookie = PBField.initBytes(byteStringMicro);
        this.is_partial_sync = PBField.initBool(false);
        this.msg_ctrl_buf = PBField.initBytes(byteStringMicro);
    }
}
