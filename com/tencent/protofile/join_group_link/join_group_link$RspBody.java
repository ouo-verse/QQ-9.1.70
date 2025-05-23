package com.tencent.protofile.join_group_link;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class join_group_link$RspBody extends MessageMicro<join_group_link$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField ark;
    public final PBBytesField context;
    public join_group_link$GroupInfo group_info;
    public final PBBytesField token;
    public final PBUInt32Field error_code = PBField.initUInt32(0);
    public final PBUInt64Field group_code = PBField.initUInt64(0);
    public final PBStringField url = PBField.initString("");

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 50, 58}, new String[]{"error_code", "group_code", "url", "context", "ark", "group_info", "token"}, new Object[]{0, 0L, "", byteStringMicro, byteStringMicro, null, byteStringMicro}, join_group_link$RspBody.class);
    }

    public join_group_link$RspBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.context = PBField.initBytes(byteStringMicro);
        this.ark = PBField.initBytes(byteStringMicro);
        this.group_info = new join_group_link$GroupInfo();
        this.token = PBField.initBytes(byteStringMicro);
    }
}
