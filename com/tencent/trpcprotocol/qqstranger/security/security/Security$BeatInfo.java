package com.tencent.trpcprotocol.qqstranger.security.security;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class Security$BeatInfo extends MessageMicro<Security$BeatInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"scene", "is_beat", "reason"}, new Object[]{0, Boolean.FALSE, ""}, Security$BeatInfo.class);
    public final PBEnumField scene = PBField.initEnum(0);
    public final PBBoolField is_beat = PBField.initBool(false);
    public final PBStringField reason = PBField.initString("");
}
