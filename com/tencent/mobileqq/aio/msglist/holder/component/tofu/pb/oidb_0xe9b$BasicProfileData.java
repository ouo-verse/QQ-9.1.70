package com.tencent.mobileqq.aio.msglist.holder.component.tofu.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes11.dex */
public final class oidb_0xe9b$BasicProfileData extends MessageMicro<oidb_0xe9b$BasicProfileData> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_addfrd_src;
    public final PBBytesField bytes_place;
    public final PBUInt32Field uint32_comm_frd_num;
    public final PBUInt32Field uint32_age = PBField.initUInt32(0);
    public final PBUInt32Field uint32_gender = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 40}, new String[]{"uint32_age", "uint32_gender", "bytes_place", "bytes_addfrd_src", "uint32_comm_frd_num"}, new Object[]{0, 0, byteStringMicro, byteStringMicro, 0}, oidb_0xe9b$BasicProfileData.class);
    }

    public oidb_0xe9b$BasicProfileData() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_place = PBField.initBytes(byteStringMicro);
        this.bytes_addfrd_src = PBField.initBytes(byteStringMicro);
        this.uint32_comm_frd_num = PBField.initUInt32(0);
    }
}
