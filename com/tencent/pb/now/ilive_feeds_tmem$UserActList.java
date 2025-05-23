package com.tencent.pb.now;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ilive_feeds_tmem$UserActList extends MessageMicro<ilive_feeds_tmem$UserActList> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"act_uin", "feeds_id"}, new Object[]{0L, ByteStringMicro.EMPTY}, ilive_feeds_tmem$UserActList.class);
    public final PBUInt64Field act_uin = PBField.initUInt64(0);
    public final PBRepeatField<ByteStringMicro> feeds_id = PBField.initRepeat(PBBytesField.__repeatHelper__);
}
