package com.tencent.mobileqq.dynamic_search;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class mobileqq_dynamic_search$TabItemGroup extends MessageMicro<mobileqq_dynamic_search$TabItemGroup> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"group_mask", "tab_name"}, new Object[]{0, ByteStringMicro.EMPTY}, mobileqq_dynamic_search$TabItemGroup.class);
    public final PBUInt32Field group_mask = PBField.initUInt32(0);
    public final PBBytesField tab_name = PBField.initBytes(ByteStringMicro.EMPTY);
}
