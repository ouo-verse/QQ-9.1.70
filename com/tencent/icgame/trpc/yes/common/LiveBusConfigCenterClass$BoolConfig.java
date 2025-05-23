package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class LiveBusConfigCenterClass$BoolConfig extends MessageMicro<LiveBusConfigCenterClass$BoolConfig> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"type", "flag"}, new Object[]{0, Boolean.FALSE}, LiveBusConfigCenterClass$BoolConfig.class);
    public final PBEnumField type = PBField.initEnum(0);
    public final PBBoolField flag = PBField.initBool(false);
}
