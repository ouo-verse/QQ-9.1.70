package com.tencent.filament.zplanservice.pbjava.sceneevent;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class MiniConnectMaskLayerInfo$MaskLayerInfo extends MessageMicro<MiniConnectMaskLayerInfo$MaskLayerInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"scene_address", "top_mask_layer_url", "bottom_mask_layer_url", "bottom_mask_layer_focus_url"}, new Object[]{0L, "", "", ""}, MiniConnectMaskLayerInfo$MaskLayerInfo.class);
    public final PBUInt64Field scene_address = PBField.initUInt64(0);
    public final PBStringField top_mask_layer_url = PBField.initString("");
    public final PBStringField bottom_mask_layer_url = PBField.initString("");
    public final PBStringField bottom_mask_layer_focus_url = PBField.initString("");
}
