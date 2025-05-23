package com.qzone.personalize.flashnickname.handler.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.trpcprotocol.sweet.verification.judge.DynamicNickModule;

/* compiled from: P */
/* loaded from: classes39.dex */
public final class SsoGetActDynamicNickRsp extends MessageMicro<SsoGetActDynamicNickRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{"is_show", "last_time", "url", "module"}, new Object[]{Boolean.FALSE, 0L, "", null}, SsoGetActDynamicNickRsp.class);
    public final PBBoolField is_show = PBField.initBool(false);
    public final PBUInt64Field last_time = PBField.initUInt64(0);
    public final PBStringField url = PBField.initString("");
    public DynamicNickModule module = new DynamicNickModule();
}
