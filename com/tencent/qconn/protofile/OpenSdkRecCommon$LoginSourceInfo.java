package com.tencent.qconn.protofile;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class OpenSdkRecCommon$LoginSourceInfo extends MessageMicro<OpenSdkRecCommon$LoginSourceInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"channel_source", ISchemeApi.KEY_REFERER}, new Object[]{0L, 1}, OpenSdkRecCommon$LoginSourceInfo.class);
    public final PBInt64Field channel_source = PBField.initInt64(0);
    public final PBEnumField referer = PBField.initEnum(1);
}
