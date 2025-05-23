package com.tencent.mobileqq.gamecenter.qa.proto;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameStrategyQA$StarUserInfo extends MessageMicro<GameStrategyQA$StarUserInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField head = PBField.initString("");
    public final PBBytesField nick = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt64Field answer_num = PBField.initInt64(0);
    public final PBInt64Field be_liked_num = PBField.initInt64(0);
    public final PBBoolField is_online = PBField.initBool(false);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBBoolField is_self = PBField.initBool(false);
    public final PBStringField uin_str = PBField.initString("");

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40, 48, 56, 66}, new String[]{"head", "nick", "answer_num", "be_liked_num", "is_online", "uin", "is_self", "uin_str"}, new Object[]{"", ByteStringMicro.EMPTY, 0L, 0L, bool, 0L, bool, ""}, GameStrategyQA$StarUserInfo.class);
    }
}
