package com.tencent.mobileqq.qqecommerce.repo.pbfile;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;

/* compiled from: P */
/* loaded from: classes35.dex */
public final class sellerMsgConfig$GetMsgStatusReq extends MessageMicro<sellerMsgConfig$GetMsgStatusReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{QQHealthReportApiImpl.MSG_TYPE_KEY}, new Object[]{0}, sellerMsgConfig$GetMsgStatusReq.class);
    public final PBUInt32Field msg_type = PBField.initUInt32(0);
}
