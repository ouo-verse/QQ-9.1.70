package com.tencent.mobileqq.tofumsg.pushtofu.proto;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class RevealLocal$NotifyReveal extends MessageMicro<RevealLocal$NotifyReveal> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 42, 50}, new String[]{"uid", "chat_type", "need_del", "bid", "uuid", "toufu"}, new Object[]{"", 0, Boolean.FALSE, 0, "", ByteStringMicro.EMPTY}, RevealLocal$NotifyReveal.class);
    public final PBStringField uid = PBField.initString("");
    public final PBUInt32Field chat_type = PBField.initUInt32(0);
    public final PBBoolField need_del = PBField.initBool(false);
    public final PBUInt32Field bid = PBField.initUInt32(0);
    public final PBStringField uuid = PBField.initString("");
    public final PBBytesField toufu = PBField.initBytes(ByteStringMicro.EMPTY);
}
