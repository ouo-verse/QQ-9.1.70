package com.tencent.mobileqq.dynamic_search;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* loaded from: classes5.dex */
public final class mobileqq_dynamic_search$PluginState extends MessageMicro<mobileqq_dynamic_search$PluginState> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"plugin_id", "plugin_switch"}, new Object[]{0, 0}, mobileqq_dynamic_search$PluginState.class);
    public final PBInt32Field plugin_id = PBField.initInt32(0);
    public final PBInt32Field plugin_switch = PBField.initInt32(0);
}
