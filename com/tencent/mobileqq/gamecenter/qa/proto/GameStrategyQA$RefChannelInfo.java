package com.tencent.mobileqq.gamecenter.qa.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameStrategyQA$RefChannelInfo extends MessageMicro<GameStrategyQA$RefChannelInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"invite_code", "content_id"}, new Object[]{"", ""}, GameStrategyQA$RefChannelInfo.class);
    public final PBStringField invite_code = PBField.initString("");
    public final PBStringField content_id = PBField.initString("");
}
