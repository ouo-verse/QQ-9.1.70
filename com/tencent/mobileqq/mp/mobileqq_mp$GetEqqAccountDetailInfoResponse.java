package com.tencent.mobileqq.mp;

import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class mobileqq_mp$GetEqqAccountDetailInfoResponse extends MessageMicro<mobileqq_mp$GetEqqAccountDetailInfoResponse> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 56, 64, 74, 80, 90}, new String[]{"ret_info", "accountInfo", "address", "lng", QCircleSchemeAttr.Polymerize.LAT, "phone_number", "is_recv_msg", "follow_type", "config_group_info", "seqno", "introduce"}, new Object[]{null, null, "", "", "", "", Boolean.FALSE, 0, null, 0, ""}, mobileqq_mp$GetEqqAccountDetailInfoResponse.class);
    public mobileqq_mp$RetInfo ret_info = new mobileqq_mp$RetInfo();
    public mobileqq_mp$EqqAccountInfo accountInfo = new mobileqq_mp$EqqAccountInfo();
    public final PBStringField address = PBField.initString("");
    public final PBStringField lng = PBField.initString("");
    public final PBStringField lat = PBField.initString("");
    public final PBStringField phone_number = PBField.initString("");
    public final PBBoolField is_recv_msg = PBField.initBool(false);
    public final PBUInt32Field follow_type = PBField.initUInt32(0);
    public final PBRepeatMessageField<mobileqq_mp$ConfigGroupInfo> config_group_info = PBField.initRepeatMessage(mobileqq_mp$ConfigGroupInfo.class);
    public final PBUInt32Field seqno = PBField.initUInt32(0);
    public final PBStringField introduce = PBField.initString("");
}
