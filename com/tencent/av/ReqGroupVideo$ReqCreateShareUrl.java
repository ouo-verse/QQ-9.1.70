package com.tencent.av;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class ReqGroupVideo$ReqCreateShareUrl extends MessageMicro<ReqGroupVideo$ReqCreateShareUrl> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField group_name;
    public final PBUInt32Field role;
    public final PBBytesField share_name;
    public final PBUInt32Field uint32_is_need_verify;
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
    public final PBUInt64Field uint64_room_id = PBField.initUInt64(0);
    public final PBUInt32Field uint32_room_create_time = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 50, 56, 64}, new String[]{"uint64_uin", "uint64_group_code", "uint64_room_id", "uint32_room_create_time", "group_name", "share_name", "role", "uint32_is_need_verify"}, new Object[]{0L, 0L, 0L, 0, byteStringMicro, byteStringMicro, 0, 0}, ReqGroupVideo$ReqCreateShareUrl.class);
    }

    public ReqGroupVideo$ReqCreateShareUrl() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.group_name = PBField.initBytes(byteStringMicro);
        this.share_name = PBField.initBytes(byteStringMicro);
        this.role = PBField.initUInt32(0);
        this.uint32_is_need_verify = PBField.initUInt32(0);
    }
}
