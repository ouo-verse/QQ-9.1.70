package com.tencent.mobileqq.partner.signin.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes16.dex */
public final class GeneralSigninPB$CalendarCard extends MessageMicro<GeneralSigninPB$CalendarCard> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42}, new String[]{"content", "content_source", "daily_tips", "backgroup_image_url", "msg_image_url"}, new Object[]{"", "", "", "", ""}, GeneralSigninPB$CalendarCard.class);
    public final PBStringField content = PBField.initString("");
    public final PBStringField content_source = PBField.initString("");
    public final PBStringField daily_tips = PBField.initString("");
    public final PBStringField backgroup_image_url = PBField.initString("");
    public final PBStringField msg_image_url = PBField.initString("");
}
