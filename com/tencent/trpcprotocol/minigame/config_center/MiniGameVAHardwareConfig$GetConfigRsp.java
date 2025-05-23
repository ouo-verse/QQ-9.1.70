package com.tencent.trpcprotocol.minigame.config_center;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class MiniGameVAHardwareConfig$GetConfigRsp extends MessageMicro<MiniGameVAHardwareConfig$GetConfigRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"items", WidgetCacheConstellationData.INTERVAL}, new Object[]{null, 0L}, MiniGameVAHardwareConfig$GetConfigRsp.class);
    public final PBRepeatMessageField<MiniGameVAHardwareConfig$ConfigItem> items = PBField.initRepeatMessage(MiniGameVAHardwareConfig$ConfigItem.class);
    public final PBUInt64Field interval = PBField.initUInt64(0);
}
