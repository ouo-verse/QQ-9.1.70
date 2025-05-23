package com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_info;

import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes31.dex */
public final class ECOrderInfo$ExtraJmpPage extends MessageMicro<ECOrderInfo$ExtraJmpPage> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"desc", "title", MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK}, new Object[]{"", "", ""}, ECOrderInfo$ExtraJmpPage.class);
    public final PBStringField desc = PBField.initString("");
    public final PBStringField title = PBField.initString("");
    public final PBStringField link = PBField.initString("");
}
