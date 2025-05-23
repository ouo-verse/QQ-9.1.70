package com.tencent.av;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class hd_video_2$InviteTempSessionData extends MessageMicro<hd_video_2$InviteTempSessionData> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_relationship;
    public final PBBytesField bytes_relationship_ext;
    public final PBUInt32Field uint32_relationship_type;
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_group_uin = PBField.initUInt64(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 42}, new String[]{"uint64_uin", "uint64_group_uin", "bytes_relationship", "uint32_relationship_type", "bytes_relationship_ext"}, new Object[]{0L, 0L, byteStringMicro, 0, byteStringMicro}, hd_video_2$InviteTempSessionData.class);
    }

    public hd_video_2$InviteTempSessionData() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_relationship = PBField.initBytes(byteStringMicro);
        this.uint32_relationship_type = PBField.initUInt32(0);
        this.bytes_relationship_ext = PBField.initBytes(byteStringMicro);
    }
}
