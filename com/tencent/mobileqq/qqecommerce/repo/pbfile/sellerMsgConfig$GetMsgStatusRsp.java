package com.tencent.mobileqq.qqecommerce.repo.pbfile;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes35.dex */
public final class sellerMsgConfig$GetMsgStatusRsp extends MessageMicro<sellerMsgConfig$GetMsgStatusRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"status"}, new Object[]{0}, sellerMsgConfig$GetMsgStatusRsp.class);
    public final PBUInt32Field status = PBField.initUInt32(0);
}
