package com.tencent.filament.zplanservice.pbjava.wowoconn;

import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class WowoConnMapServer$GetMapRsp extends MessageMicro<WowoConnMapServer$GetMapRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 56, 64, 72, 82, 90, 98, 106}, new String[]{"bg_res", "loading_res", "master_dialog_res", "client_dialog_res", "relation_res", "map_field_list", "is_has_more", "next_page_size", "next_page_num", LayoutAttrDefine.BG_Color, "top_mask_layer_url", "bottom_mask_layer_url", "bottom_mask_layer_focus_url"}, new Object[]{"", "", "", "", "", null, Boolean.FALSE, 0L, 0L, "", "", "", ""}, WowoConnMapServer$GetMapRsp.class);
    public final PBStringField bg_res = PBField.initString("");
    public final PBStringField loading_res = PBField.initString("");
    public final PBStringField master_dialog_res = PBField.initString("");
    public final PBStringField client_dialog_res = PBField.initString("");
    public final PBStringField relation_res = PBField.initString("");
    public final PBRepeatMessageField<WowoConnMapServer$BlockInfo> map_field_list = PBField.initRepeatMessage(WowoConnMapServer$BlockInfo.class);
    public final PBBoolField is_has_more = PBField.initBool(false);
    public final PBUInt64Field next_page_size = PBField.initUInt64(0);
    public final PBUInt64Field next_page_num = PBField.initUInt64(0);
    public final PBStringField bg_color = PBField.initString("");
    public final PBStringField top_mask_layer_url = PBField.initString("");
    public final PBStringField bottom_mask_layer_url = PBField.initString("");
    public final PBStringField bottom_mask_layer_focus_url = PBField.initString("");
}
