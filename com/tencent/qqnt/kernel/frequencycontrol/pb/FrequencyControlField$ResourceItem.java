package com.tencent.qqnt.kernel.frequencycontrol.pb;

import com.tencent.mobileqq.haoliyou.sso.CheckForwardServlet;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class FrequencyControlField$ResourceItem extends MessageMicro<FrequencyControlField$ResourceItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{1768810, 1768816, 1768824, 1768832, 1768842, 1768848, 1768856, 1768866}, new String[]{"peer_uid", "chat_type", "scene_id", "update_type", "resource_body_list", "need_download", CheckForwardServlet.KEY_ERR_CODE, "ext_info"}, new Object[]{"", 0, 0, 0, null, Boolean.FALSE, 0, ""}, FrequencyControlField$ResourceItem.class);
    public final PBStringField peer_uid = PBField.initString("");
    public final PBInt32Field chat_type = PBField.initInt32(0);
    public final PBUInt32Field scene_id = PBField.initUInt32(0);
    public final PBUInt32Field update_type = PBField.initUInt32(0);
    public final PBRepeatMessageField<FrequencyControlField$ResourceBody> resource_body_list = PBField.initRepeatMessage(FrequencyControlField$ResourceBody.class);
    public final PBBoolField need_download = PBField.initBool(false);
    public final PBUInt32Field err_code = PBField.initUInt32(0);
    public final PBStringField ext_info = PBField.initString("");
}
