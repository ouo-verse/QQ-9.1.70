package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class YesGameInfoOuterClass$GameConfigLinkageOption extends MessageMicro<YesGameInfoOuterClass$GameConfigLinkageOption> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32}, new String[]{"index", "key", "type", "limit"}, new Object[]{0, "", 0, 0}, YesGameInfoOuterClass$GameConfigLinkageOption.class);
    public final PBInt32Field index = PBField.initInt32(0);
    public final PBRepeatField<String> key = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBInt32Field type = PBField.initInt32(0);
    public final PBInt32Field limit = PBField.initInt32(0);
}
