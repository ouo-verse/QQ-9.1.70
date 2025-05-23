package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class qqstory_struct$VideoReaderConf extends MessageMicro<qqstory_struct$VideoReaderConf> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"ban_type", "user_list", "user_unionid_list"}, new Object[]{0, 0L, ByteStringMicro.EMPTY}, qqstory_struct$VideoReaderConf.class);
    public final PBUInt32Field ban_type = PBField.initUInt32(0);
    public final PBRepeatField<Long> user_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBRepeatField<ByteStringMicro> user_unionid_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
}
