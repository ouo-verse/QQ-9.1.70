package com.tencent.trpcprotocol.qbox.datacard_manager.datacard_manager;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes27.dex */
public final class DatacardManagerPB$ActionInfo extends MessageMicro<DatacardManagerPB$ActionInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"pet_id", "desc", "material_url", "miniapp_url"}, new Object[]{0L, "", "", ""}, DatacardManagerPB$ActionInfo.class);
    public final PBUInt64Field pet_id = PBField.initUInt64(0);
    public final PBStringField desc = PBField.initString("");
    public final PBStringField material_url = PBField.initString("");
    public final PBStringField miniapp_url = PBField.initString("");
}
