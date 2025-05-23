package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes11.dex */
public final class ARCloudRecogCustomPb$CNBSInfo extends MessageMicro<ARCloudRecogCustomPb$CNBSInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 808, 816}, new String[]{"uint32_game_id", "uint32_confirmed", "uint32_confirm_time", "uint32_be_killed", "uint32_killed_time", "uint32_key_time", "uint32_sum_num", "uint32_dead_num"}, new Object[]{0, 0, 0, 0, 0, 0, 0, 0}, ARCloudRecogCustomPb$CNBSInfo.class);
    public final PBUInt32Field uint32_game_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_confirmed = PBField.initUInt32(0);
    public final PBUInt32Field uint32_confirm_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_be_killed = PBField.initUInt32(0);
    public final PBUInt32Field uint32_killed_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_key_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sum_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_dead_num = PBField.initUInt32(0);
}
