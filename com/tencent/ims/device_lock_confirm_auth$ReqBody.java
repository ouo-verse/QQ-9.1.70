package com.tencent.ims;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class device_lock_confirm_auth$ReqBody extends MessageMicro<device_lock_confirm_auth$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_appname;
    public final PBBytesField bytes_guid;
    public final PBRepeatMessageField<device_lock_confirm_auth$DeviceInfo> rpt_msg_devicelist;
    public final PBUInt32Field uint32_appid;
    public final PBUInt32Field uint32_seq;
    public final PBUInt32Field uint32_subappid;
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 42, 48, 58}, new String[]{"uint64_uin", "bytes_guid", "uint32_appid", "uint32_subappid", "bytes_appname", "uint32_seq", "rpt_msg_devicelist"}, new Object[]{0L, byteStringMicro, 0, 0, byteStringMicro, 0, null}, device_lock_confirm_auth$ReqBody.class);
    }

    public device_lock_confirm_auth$ReqBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_guid = PBField.initBytes(byteStringMicro);
        this.uint32_appid = PBField.initUInt32(0);
        this.uint32_subappid = PBField.initUInt32(0);
        this.bytes_appname = PBField.initBytes(byteStringMicro);
        this.uint32_seq = PBField.initUInt32(0);
        this.rpt_msg_devicelist = PBField.initRepeatMessage(device_lock_confirm_auth$DeviceInfo.class);
    }
}
