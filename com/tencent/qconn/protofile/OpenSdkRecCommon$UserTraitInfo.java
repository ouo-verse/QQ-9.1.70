package com.tencent.qconn.protofile;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class OpenSdkRecCommon$UserTraitInfo extends MessageMicro<OpenSdkRecCommon$UserTraitInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"is_teenager_mode"}, new Object[]{Boolean.FALSE}, OpenSdkRecCommon$UserTraitInfo.class);
    public final PBBoolField is_teenager_mode = PBField.initBool(false);
}
