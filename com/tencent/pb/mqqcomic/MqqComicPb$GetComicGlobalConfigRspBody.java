package com.tencent.pb.mqqcomic;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes22.dex */
public final class MqqComicPb$GetComicGlobalConfigRspBody extends MessageMicro<MqqComicPb$GetComicGlobalConfigRspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"maintab"}, new Object[]{""}, MqqComicPb$GetComicGlobalConfigRspBody.class);
    public final PBStringField maintab = PBField.initString("");
}
