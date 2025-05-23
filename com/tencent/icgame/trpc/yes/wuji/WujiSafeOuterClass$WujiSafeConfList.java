package com.tencent.icgame.trpc.yes.wuji;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class WujiSafeOuterClass$WujiSafeConfList extends MessageMicro<WujiSafeOuterClass$WujiSafeConfList> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"data"}, new Object[]{null}, WujiSafeOuterClass$WujiSafeConfList.class);
    public final PBRepeatMessageField<WujiSafeOuterClass$WujiSafeConf> data = PBField.initRepeatMessage(WujiSafeOuterClass$WujiSafeConf.class);
}
