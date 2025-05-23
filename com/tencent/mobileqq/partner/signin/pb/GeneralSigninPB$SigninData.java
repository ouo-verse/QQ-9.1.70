package com.tencent.mobileqq.partner.signin.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;

/* loaded from: classes16.dex */
public final class GeneralSigninPB$SigninData extends MessageMicro<GeneralSigninPB$SigninData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34}, new String[]{"timestamp", "member_uin", "status", IndividuationUrlHelper.UrlId.CARD_HOME}, new Object[]{0L, "", 0, null}, GeneralSigninPB$SigninData.class);
    public final PBInt64Field timestamp = PBField.initInt64(0);
    public final PBStringField member_uin = PBField.initString("");
    public final PBInt32Field status = PBField.initInt32(0);
    public GeneralSigninPB$CalendarCard card = new GeneralSigninPB$CalendarCard();
}
