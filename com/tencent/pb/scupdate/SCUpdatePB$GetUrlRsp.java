package com.tencent.pb.scupdate;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes22.dex */
public final class SCUpdatePB$GetUrlRsp extends MessageMicro<SCUpdatePB$GetUrlRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{18}, new String[]{"update_list"}, new Object[]{null}, SCUpdatePB$GetUrlRsp.class);
    public final PBRepeatMessageField<SCUpdatePB$UpdateInfo> update_list = PBField.initRepeatMessage(SCUpdatePB$UpdateInfo.class);
}
