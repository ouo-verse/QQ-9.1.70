package com.tencent.mobileqq.qqecommerce.repo.pbfile;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes35.dex */
public final class sellerMsgConfig$TabItem extends MessageMicro<sellerMsgConfig$TabItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 48}, new String[]{"id", "name", "icon_url", AppConstants.Preferences.TASK_ENTRY_CONFIG_ICON_URL_FOR_NIGHT, "jump_url", "order"}, new Object[]{0, "", "", "", "", 0}, sellerMsgConfig$TabItem.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBUInt32Field f263437id = PBField.initUInt32(0);
    public final PBStringField name = PBField.initString("");
    public final PBStringField icon_url = PBField.initString("");
    public final PBStringField night_icon_url = PBField.initString("");
    public final PBStringField jump_url = PBField.initString("");
    public final PBUInt32Field order = PBField.initUInt32(0);
}
