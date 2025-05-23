package com.tencent.mobileqq.leba.pb;

import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes15.dex */
public final class PluginConfig$BatchGetResourceResp extends MessageMicro<PluginConfig$BatchGetResourceResp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{"uin", "errcode", HippyReporter.EXTRA_KEY_REPORT_ERRMSG, "resp_list"}, new Object[]{0L, 0, "", null}, PluginConfig$BatchGetResourceResp.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBUInt32Field errcode = PBField.initUInt32(0);
    public final PBStringField errmsg = PBField.initString("");
    public final PBRepeatMessageField<PluginConfig$GetResourceResp> resp_list = PBField.initRepeatMessage(PluginConfig$GetResourceResp.class);
}
