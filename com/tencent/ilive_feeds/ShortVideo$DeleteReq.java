package com.tencent.ilive_feeds;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class ShortVideo$DeleteReq extends MessageMicro<ShortVideo$DeleteReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{"ver", "seq", "file_type", "file_id"}, new Object[]{0, 0, 0, ByteStringMicro.EMPTY}, ShortVideo$DeleteReq.class);
    public final PBInt32Field ver = PBField.initInt32(0);
    public final PBUInt32Field seq = PBField.initUInt32(0);
    public final PBUInt32Field file_type = PBField.initUInt32(0);
    public final PBBytesField file_id = PBField.initBytes(ByteStringMicro.EMPTY);
}
