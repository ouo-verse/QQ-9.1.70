package com.tencent.mobileqq.comment.oidb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class oidb_0xdea$Comment extends MessageMicro<oidb_0xdea$Comment> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_comment_msg;
    public final PBBytesField bytes_nick;
    public final PBBytesField bytes_pass_through;
    public final PBUInt32Field uint32_comment_ctime;
    public final PBUInt32Field uint32_source;
    public final PBUInt64Field uint64_comment_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_seq = PBField.initUInt64(0);
    public final PBUInt64Field uint64_comment_location = PBField.initUInt64(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{16, 24, 32, 42, 50, 56, 66, 72}, new String[]{"uint64_comment_uin", "uint64_seq", "uint64_comment_location", "bytes_comment_msg", "bytes_pass_through", "uint32_comment_ctime", "bytes_nick", "uint32_source"}, new Object[]{0L, 0L, 0L, byteStringMicro, byteStringMicro, 0, byteStringMicro, 0}, oidb_0xdea$Comment.class);
    }

    public oidb_0xdea$Comment() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_comment_msg = PBField.initBytes(byteStringMicro);
        this.bytes_pass_through = PBField.initBytes(byteStringMicro);
        this.uint32_comment_ctime = PBField.initUInt32(0);
        this.bytes_nick = PBField.initBytes(byteStringMicro);
        this.uint32_source = PBField.initUInt32(0);
    }
}
