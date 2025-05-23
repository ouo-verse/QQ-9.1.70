package com.tencent.mobileqq.leba.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qwallet.preload.IPreloadServiceProxy;

/* loaded from: classes15.dex */
public final class PluginConfig$PluginGroup extends MessageMicro<PluginConfig$PluginGroup> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{IPreloadServiceProxy.KEY_RESID}, new Object[]{0}, PluginConfig$PluginGroup.class);
    public final PBRepeatField<Integer> res_id = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
}
