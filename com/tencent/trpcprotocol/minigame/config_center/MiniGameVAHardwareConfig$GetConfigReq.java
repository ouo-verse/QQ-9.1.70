package com.tencent.trpcprotocol.minigame.config_center;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class MiniGameVAHardwareConfig$GetConfigReq extends MessageMicro<MiniGameVAHardwareConfig$GetConfigReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"config_type", "appids", "hardware_info"}, new Object[]{0, "", ByteStringMicro.EMPTY}, MiniGameVAHardwareConfig$GetConfigReq.class);
    public final PBUInt32Field config_type = PBField.initUInt32(0);
    public final PBRepeatField<String> appids = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBBytesField hardware_info = PBField.initBytes(ByteStringMicro.EMPTY);
}
