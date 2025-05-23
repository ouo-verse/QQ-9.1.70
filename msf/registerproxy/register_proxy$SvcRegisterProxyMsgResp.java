package msf.registerproxy;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes28.dex */
public final class register_proxy$SvcRegisterProxyMsgResp extends MessageMicro<register_proxy$SvcRegisterProxyMsgResp> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField c2c_msg;
    public final PBRepeatMessageField<register_proxy$DiscussList> discuss_list;
    public final PBUInt32Field discuss_list_flag;
    public final PBRepeatMessageField<register_proxy$SvcPbResponsePullDisMsgProxy> discuss_msg;
    public final PBBytesField err_msg;
    public final PBUInt32Field flag;
    public final PBRepeatMessageField<register_proxy$SvcResponsePbPullGroupMsgProxy> gourp_msg;
    public final PBUInt32Field group_guild_flag;
    public final PBRepeatMessageField<register_proxy$GroupList> group_list;
    public register_proxy$SvcResponseMsgInfo msg_info;
    public final PBBytesField pub_account_msg;
    public final PBUInt32Field result = PBField.initUInt32(0);
    public final PBUInt32Field roam_msg_optimize_flag;
    public final PBUInt32Field seq;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 42, 50, 58, 66, 74, 82, 90, 96, 104, 112}, new String[]{"result", "err_msg", "flag", "seq", "msg_info", "group_list", "discuss_list", "gourp_msg", "discuss_msg", "c2c_msg", "pub_account_msg", "discuss_list_flag", "roam_msg_optimize_flag", "group_guild_flag"}, new Object[]{0, byteStringMicro, 0, 0, null, null, null, null, null, byteStringMicro, byteStringMicro, 0, 0, 0}, register_proxy$SvcRegisterProxyMsgResp.class);
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [msf.registerproxy.register_proxy$SvcResponseMsgInfo] */
    public register_proxy$SvcRegisterProxyMsgResp() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.err_msg = PBField.initBytes(byteStringMicro);
        this.flag = PBField.initUInt32(0);
        this.seq = PBField.initUInt32(0);
        this.msg_info = new MessageMicro<register_proxy$SvcResponseMsgInfo>() { // from class: msf.registerproxy.register_proxy$SvcResponseMsgInfo
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"group_num", "discuss_num"}, new Object[]{0, 0}, register_proxy$SvcResponseMsgInfo.class);
            public final PBUInt32Field group_num = PBField.initUInt32(0);
            public final PBUInt32Field discuss_num = PBField.initUInt32(0);
        };
        this.group_list = PBField.initRepeatMessage(register_proxy$GroupList.class);
        this.discuss_list = PBField.initRepeatMessage(register_proxy$DiscussList.class);
        this.gourp_msg = PBField.initRepeatMessage(register_proxy$SvcResponsePbPullGroupMsgProxy.class);
        this.discuss_msg = PBField.initRepeatMessage(register_proxy$SvcPbResponsePullDisMsgProxy.class);
        this.c2c_msg = PBField.initBytes(byteStringMicro);
        this.pub_account_msg = PBField.initBytes(byteStringMicro);
        this.discuss_list_flag = PBField.initUInt32(0);
        this.roam_msg_optimize_flag = PBField.initUInt32(0);
        this.group_guild_flag = PBField.initUInt32(0);
    }
}
