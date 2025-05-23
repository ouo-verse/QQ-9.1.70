package com.tencent.mobileqq.protocol;

import com.tencent.mobileqq.pb.MessageMicro;

/* loaded from: classes35.dex */
public final class nearbyProfile$SetProfileReq extends MessageMicro<nearbyProfile$SetProfileReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"base_profile"}, new Object[]{null}, nearbyProfile$SetProfileReq.class);
    public nearbyProfile$BaseProfile base_profile = new nearbyProfile$BaseProfile();
}
