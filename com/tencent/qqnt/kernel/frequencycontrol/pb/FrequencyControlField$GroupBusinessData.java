package com.tencent.qqnt.kernel.frequencycontrol.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class FrequencyControlField$GroupBusinessData extends MessageMicro<FrequencyControlField$GroupBusinessData> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField elem_elem_flags2;
    public final PBBytesField elem_extra_info;
    public final PBBytesField elem_general_flags;
    public final PBBytesField elem_pub_group;
    public final PBBoolField is_online_msg;
    public final PBBytesField msg_head_group_info;
    public final PBInt64Field msg_id = PBField.initInt64(0);
    public final PBInt64Field msg_seq = PBField.initInt64(0);
    public final PBInt64Field msg_time = PBField.initInt64(0);
    public final PBStringField peer_uid = PBField.initString("");
    public final PBInt64Field peer_uin = PBField.initInt64(0);
    public final PBStringField sender_uid = PBField.initString("");
    public final PBInt64Field sender_uin = PBField.initInt64(0);

    static {
        String[] strArr = {"msg_id", "msg_seq", ProtocolDownloaderConstants.HEADER_C2C_MSG_TIME, "peer_uid", ProtocolDownloaderConstants.HEADER_FRIEND_UIN, "sender_uid", "sender_uin", "msg_head_group_info", "elem_general_flags", "elem_elem_flags2", "elem_extra_info", "elem_pub_group", "is_online_msg"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 40, 50, 56, 66, 74, 82, 90, 98, 104}, strArr, new Object[]{0L, 0L, 0L, "", 0L, "", 0L, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, Boolean.FALSE}, FrequencyControlField$GroupBusinessData.class);
    }

    public FrequencyControlField$GroupBusinessData() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.msg_head_group_info = PBField.initBytes(byteStringMicro);
        this.elem_general_flags = PBField.initBytes(byteStringMicro);
        this.elem_elem_flags2 = PBField.initBytes(byteStringMicro);
        this.elem_extra_info = PBField.initBytes(byteStringMicro);
        this.elem_pub_group = PBField.initBytes(byteStringMicro);
        this.is_online_msg = PBField.initBool(false);
    }
}
