package com.tencent.pb.clubcontent;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class CmShowContentUpdate$STContUpdReq extends MessageMicro<CmShowContentUpdate$STContUpdReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"app_id", "cont_list"}, new Object[]{0, null}, CmShowContentUpdate$STContUpdReq.class);
    public final PBInt32Field app_id = PBField.initInt32(0);
    public final PBRepeatMessageField<CmShowContentUpdate$STContInfo> cont_list = PBField.initRepeatMessage(CmShowContentUpdate$STContInfo.class);
}
