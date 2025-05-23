package com.tencent.mobileqq.leba.pb;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes15.dex */
public final class PluginConfig$PluginLayout extends MessageMicro<PluginConfig$PluginLayout> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"plugin_layout_seq", "group_list", ParseCommon.LAYOUT_TYPE}, new Object[]{0, null, 0}, PluginConfig$PluginLayout.class);
    public final PBUInt32Field plugin_layout_seq = PBField.initUInt32(0);
    public final PBRepeatMessageField<PluginConfig$PluginGroup> group_list = PBField.initRepeatMessage(PluginConfig$PluginGroup.class);
    public final PBUInt32Field layout_type = PBField.initUInt32(0);
}
