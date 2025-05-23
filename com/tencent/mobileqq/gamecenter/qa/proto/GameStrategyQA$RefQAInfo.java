package com.tencent.mobileqq.gamecenter.qa.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameStrategyQA$RefQAInfo extends MessageMicro<GameStrategyQA$RefQAInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"appid", "qusid", "ansid"}, new Object[]{0, 0L, 0L}, GameStrategyQA$RefQAInfo.class);
    public final PBUInt32Field appid = PBField.initUInt32(0);
    public final PBInt64Field qusid = PBField.initInt64(0);
    public final PBInt64Field ansid = PBField.initInt64(0);
}
