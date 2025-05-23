package com.tencent.mobileqq.audiotrans;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class AudioTransClientTransInfo$IntC2SFailedRsp extends MessageMicro<AudioTransClientTransInfo$IntC2SFailedRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_errcode", "str_errmsg"}, new Object[]{0, ""}, AudioTransClientTransInfo$IntC2SFailedRsp.class);
    public final PBUInt32Field uint32_errcode = PBField.initUInt32(0);
    public final PBStringField str_errmsg = PBField.initString("");
}
