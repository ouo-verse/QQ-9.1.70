package com.tencent.pb.extendfriend;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes22.dex */
public final class ExtendFriendSquareInfo$PageCookie extends MessageMicro<ExtendFriendSquareInfo$PageCookie> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32}, new String[]{"uint32_start_idx", "bytes_attach_info", "rpt_ad_pos", "uint32_ad_cnt"}, new Object[]{0, ByteStringMicro.EMPTY, 0, 0}, ExtendFriendSquareInfo$PageCookie.class);
    public final PBUInt32Field uint32_start_idx = PBField.initUInt32(0);
    public final PBBytesField bytes_attach_info = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatField<Integer> rpt_ad_pos = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBUInt32Field uint32_ad_cnt = PBField.initUInt32(0);
}
