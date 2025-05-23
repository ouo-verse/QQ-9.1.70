package com.tencent.trpcprotocol.minigame.config_center;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class MiniGameVAHardwareConfig$ConfigItem extends MessageMicro<MiniGameVAHardwareConfig$ConfigItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"appid", "info"}, new Object[]{"", ByteStringMicro.EMPTY}, MiniGameVAHardwareConfig$ConfigItem.class);
    public final PBStringField appid = PBField.initString("");
    public final PBBytesField info = PBField.initBytes(ByteStringMicro.EMPTY);
}
