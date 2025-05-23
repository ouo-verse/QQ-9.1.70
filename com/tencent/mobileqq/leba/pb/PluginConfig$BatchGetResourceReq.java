package com.tencent.mobileqq.leba.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes15.dex */
public final class PluginConfig$BatchGetResourceReq extends MessageMicro<PluginConfig$BatchGetResourceReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"req_list"}, new Object[]{null}, PluginConfig$BatchGetResourceReq.class);
    public final PBRepeatMessageField<PluginConfig$GetResourceReq> req_list = PBField.initRepeatMessage(PluginConfig$GetResourceReq.class);
}
