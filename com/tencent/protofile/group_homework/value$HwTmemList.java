package com.tencent.protofile.group_homework;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class value$HwTmemList extends MessageMicro<value$HwTmemList> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"simple_infos", "actual_cnt", "store_cnt"}, new Object[]{null, 0, 0}, value$HwTmemList.class);
    public final PBRepeatMessageField<HwSimpleInfo> simple_infos = PBField.initRepeatMessage(HwSimpleInfo.class);
    public final PBInt32Field actual_cnt = PBField.initInt32(0);
    public final PBInt32Field store_cnt = PBField.initInt32(0);

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static final class HwSimpleInfo extends MessageMicro<HwSimpleInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"hw_id", "uin", "team_id", "hw_type"}, new Object[]{0L, 0L, 0L, 0}, HwSimpleInfo.class);
        public final PBUInt64Field hw_id = PBField.initUInt64(0);
        public final PBUInt64Field uin = PBField.initUInt64(0);
        public final PBUInt64Field team_id = PBField.initUInt64(0);
        public final PBUInt32Field hw_type = PBField.initUInt32(0);
    }
}
