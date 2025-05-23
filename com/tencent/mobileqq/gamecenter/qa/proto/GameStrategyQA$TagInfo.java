package com.tencent.mobileqq.gamecenter.qa.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameStrategyQA$TagInfo extends MessageMicro<GameStrategyQA$TagInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"tag_id", "tag_name", "is_inner_show"}, new Object[]{0L, "", Boolean.FALSE}, GameStrategyQA$TagInfo.class);
    public final PBInt64Field tag_id = PBField.initInt64(0);
    public final PBStringField tag_name = PBField.initString("");
    public final PBBoolField is_inner_show = PBField.initBool(false);
}
