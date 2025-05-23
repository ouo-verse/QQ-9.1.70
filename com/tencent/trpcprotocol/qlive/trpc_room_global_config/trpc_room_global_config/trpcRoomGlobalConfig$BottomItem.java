package com.tencent.trpcprotocol.qlive.trpc_room_global_config.trpc_room_global_config;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mtt.hippy.dom.node.NodeProps;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class trpcRoomGlobalConfig$BottomItem extends MessageMicro<trpcRoomGlobalConfig$BottomItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 37, 40}, new String[]{"icon", "text", "url", "height", NodeProps.VISIBLE}, new Object[]{"", "", "", Float.valueOf(0.0f), Boolean.FALSE}, trpcRoomGlobalConfig$BottomItem.class);
    public final PBStringField icon = PBField.initString("");
    public final PBStringField text = PBField.initString("");
    public final PBStringField url = PBField.initString("");
    public final PBFloatField height = PBField.initFloat(0.0f);
    public final PBBoolField visible = PBField.initBool(false);
    public final PBBoolField showRedPoint = PBField.initBool(false);

    public boolean equalsTo(trpcRoomGlobalConfig$BottomItem trpcroomglobalconfig_bottomitem) {
        if (this.icon.get().equals(trpcroomglobalconfig_bottomitem.icon.get()) && this.text.get().equals(trpcroomglobalconfig_bottomitem.text.get()) && this.url.get().equals(trpcroomglobalconfig_bottomitem.url.get()) && this.height.get() == trpcroomglobalconfig_bottomitem.height.get() && this.visible.get() == trpcroomglobalconfig_bottomitem.visible.get()) {
            return true;
        }
        return false;
    }
}
