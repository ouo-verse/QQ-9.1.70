package com.tencent.mobileqq.gamecenter.qa.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes12.dex */
public final class GameStrategyQA$PicInfo extends MessageMicro<GameStrategyQA$PicInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"url", "height", "width"}, new Object[]{"", 0, 0}, GameStrategyQA$PicInfo.class);
    public final PBStringField url = PBField.initString("");
    public final PBInt32Field height = PBField.initInt32(0);
    public final PBInt32Field width = PBField.initInt32(0);
}
