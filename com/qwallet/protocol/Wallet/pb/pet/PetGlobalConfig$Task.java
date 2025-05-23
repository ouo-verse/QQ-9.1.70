package com.qwallet.protocol.Wallet.pb.pet;

import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdTianshuFeedData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes3.dex */
public final class PetGlobalConfig$Task extends MessageMicro<PetGlobalConfig$Task> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 56, 66}, new String[]{"id", "type", "icon", "title", "description", QZoneAdTianshuFeedData.KEY_BUTTON_TEXT, "action", "url"}, new Object[]{"", "", "", "", "", "", 0, ""}, PetGlobalConfig$Task.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f41709id = PBField.initString("");
    public final PBStringField type = PBField.initString("");
    public final PBStringField icon = PBField.initString("");
    public final PBStringField title = PBField.initString("");
    public final PBStringField description = PBField.initString("");
    public final PBStringField button_text = PBField.initString("");
    public final PBInt32Field action = PBField.initInt32(0);
    public final PBStringField url = PBField.initString("");
}
