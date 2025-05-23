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
public final class qqstory_struct$VideoSpreadGroupList extends MessageMicro<qqstory_struct$VideoSpreadGroupList> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{"visibility_type", "group_list", "visibility_sharegroup_type", "share_group_list"}, new Object[]{0, 0L, 0, ByteStringMicro.EMPTY}, qqstory_struct$VideoSpreadGroupList.class);
    public final PBUInt32Field visibility_type = PBField.initUInt32(0);
    public final PBRepeatField<Long> group_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field visibility_sharegroup_type = PBField.initUInt32(0);
    public final PBRepeatField<ByteStringMicro> share_group_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
}
