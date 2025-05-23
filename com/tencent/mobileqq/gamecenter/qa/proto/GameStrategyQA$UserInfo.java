package com.tencent.mobileqq.gamecenter.qa.proto;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameStrategyQA$UserInfo extends MessageMicro<GameStrategyQA$UserInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 42, 50}, new String[]{"uin", "name", "avatar", "gender", "title", "encode_uin"}, new Object[]{0L, ByteStringMicro.EMPTY, "", 0, "", ""}, GameStrategyQA$UserInfo.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBBytesField name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField avatar = PBField.initString("");
    public final PBEnumField gender = PBField.initEnum(0);
    public final PBStringField title = PBField.initString("");
    public final PBStringField encode_uin = PBField.initString("");
}
