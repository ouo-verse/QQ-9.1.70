package com.tencent.trpcprotocol.qqva.midground_sendgift.sendgift;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class sendgift$Token extends MessageMicro<sendgift$Token> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40}, new String[]{"open_id", "open_key", "token_type", "connect_appid", "domain_id"}, new Object[]{"", "", 0, 0, 0}, sendgift$Token.class);
    public final PBStringField open_id = PBField.initString("");
    public final PBStringField open_key = PBField.initString("");
    public final PBEnumField token_type = PBField.initEnum(0);
    public final PBUInt32Field connect_appid = PBField.initUInt32(0);
    public final PBUInt32Field domain_id = PBField.initUInt32(0);
}
