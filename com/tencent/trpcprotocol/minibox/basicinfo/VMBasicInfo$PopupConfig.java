package com.tencent.trpcprotocol.minibox.basicinfo;

import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdTianshuFeedData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes27.dex */
public final class VMBasicInfo$PopupConfig extends MessageMicro<VMBasicInfo$PopupConfig> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"allow_local_installation_popup", "body_text", QZoneAdTianshuFeedData.KEY_BUTTON_TEXT}, new Object[]{Boolean.FALSE, "", ""}, VMBasicInfo$PopupConfig.class);
    public final PBBoolField allow_local_installation_popup = PBField.initBool(false);
    public final PBStringField body_text = PBField.initString("");
    public final PBStringField button_text = PBField.initString("");
}
