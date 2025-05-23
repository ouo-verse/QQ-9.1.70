package com.tencent.biz.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes2.dex */
public final class clientbusilogic$GetPluginListRsp extends MessageMicro<clientbusilogic$GetPluginListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"enable_list", "disable_list"}, new Object[]{null, null}, clientbusilogic$GetPluginListRsp.class);
    public final PBRepeatMessageField<clientbusilogic$PublicAccountInfo> enable_list = PBField.initRepeatMessage(clientbusilogic$PublicAccountInfo.class);
    public final PBRepeatMessageField<clientbusilogic$PublicAccountInfo> disable_list = PBField.initRepeatMessage(clientbusilogic$PublicAccountInfo.class);
}
