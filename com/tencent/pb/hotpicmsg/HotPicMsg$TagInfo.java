package com.tencent.pb.hotpicmsg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes22.dex */
public final class HotPicMsg$TagInfo extends MessageMicro<HotPicMsg$TagInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"uint32_tag_id", "bytes_tag_name", "uint32_tag_type"}, new Object[]{0, ByteStringMicro.EMPTY, 0}, HotPicMsg$TagInfo.class);
    public final PBUInt32Field uint32_tag_id = PBField.initUInt32(0);
    public final PBBytesField bytes_tag_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_tag_type = PBField.initUInt32(0);
}
