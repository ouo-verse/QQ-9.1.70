package com.tencent.mobileqq.leba.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qwallet.preload.IPreloadServiceProxy;

/* loaded from: classes15.dex */
public final class PluginConfig$GetResourceReqInfo extends MessageMicro<PluginConfig$GetResourceReqInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{IPreloadServiceProxy.KEY_RESID, "res_seq"}, new Object[]{0, 0}, PluginConfig$GetResourceReqInfo.class);
    public final PBUInt32Field res_id = PBField.initUInt32(0);
    public final PBUInt32Field res_seq = PBField.initUInt32(0);
}
