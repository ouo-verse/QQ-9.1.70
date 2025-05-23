package com.tencent.trpcprotocol.minibox.basicinfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class VMBasicInfo$IsVMAppBlockedRsp extends MessageMicro<VMBasicInfo$IsVMAppBlockedRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"is_blocked", KeyPropertiesCompact.DIGEST_MD5}, new Object[]{Boolean.FALSE, ""}, VMBasicInfo$IsVMAppBlockedRsp.class);
    public final PBBoolField is_blocked = PBField.initBool(false);
    public final PBStringField MD5 = PBField.initString("");
}
