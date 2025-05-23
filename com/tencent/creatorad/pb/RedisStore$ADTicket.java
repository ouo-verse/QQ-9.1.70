package com.tencent.creatorad.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tenpay.sdk.util.QWSoterConstans;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class RedisStore$ADTicket extends MessageMicro<RedisStore$ADTicket> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32, 40}, new String[]{"ticket", QWSoterConstans.CGI_KEY_BUSI_TYPE, "content_id", "display_pos", "ad_template"}, new Object[]{"", 0, "", 0, 0}, RedisStore$ADTicket.class);
    public final PBStringField ticket = PBField.initString("");
    public final PBEnumField busi_type = PBField.initEnum(0);
    public final PBStringField content_id = PBField.initString("");
    public final PBEnumField display_pos = PBField.initEnum(0);
    public final PBEnumField ad_template = PBField.initEnum(0);
}
