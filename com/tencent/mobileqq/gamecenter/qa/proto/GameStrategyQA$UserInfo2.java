package com.tencent.mobileqq.gamecenter.qa.proto;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameStrategyQA$UserInfo2 extends MessageMicro<GameStrategyQA$UserInfo2> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42}, new String[]{"name", "avatar", "gender", "title", "encode_uin"}, new Object[]{ByteStringMicro.EMPTY, "", 0, "", ""}, GameStrategyQA$UserInfo2.class);
    public final PBBytesField name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField avatar = PBField.initString("");
    public final PBEnumField gender = PBField.initEnum(0);
    public final PBStringField title = PBField.initString("");
    public final PBStringField encode_uin = PBField.initString("");
}
