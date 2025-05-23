package com.tencent.pb.scupdate;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes22.dex */
public final class SCUpdatePB$SCPreload extends MessageMicro<SCUpdatePB$SCPreload> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"plver", "item_list"}, new Object[]{0L, null}, SCUpdatePB$SCPreload.class);
    public final PBInt64Field plver = PBField.initInt64(0);
    public final PBRepeatMessageField<SCUpdatePB$ItemVersion> item_list = PBField.initRepeatMessage(SCUpdatePB$ItemVersion.class);
}
