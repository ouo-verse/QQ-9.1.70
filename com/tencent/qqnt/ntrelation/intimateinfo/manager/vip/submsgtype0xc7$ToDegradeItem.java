package com.tencent.qqnt.ntrelation.intimateinfo.manager.vip;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class submsgtype0xc7$ToDegradeItem extends MessageMicro<submsgtype0xc7$ToDegradeItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 88, 96}, new String[]{"type", "old_level", "new_level", "continuity_days", "uint64_last_action_time"}, new Object[]{1, 0, 0, 0, 0L}, submsgtype0xc7$ToDegradeItem.class);
    public final PBEnumField type = PBField.initEnum(1);
    public final PBUInt32Field old_level = PBField.initUInt32(0);
    public final PBUInt32Field new_level = PBField.initUInt32(0);
    public final PBUInt32Field continuity_days = PBField.initUInt32(0);
    public final PBUInt64Field uint64_last_action_time = PBField.initUInt64(0);
}
