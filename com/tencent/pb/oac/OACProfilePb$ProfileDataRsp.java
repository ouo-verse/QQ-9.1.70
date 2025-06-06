package com.tencent.pb.oac;

import com.tencent.mobileqq.mp.mobileqq_mp$GetPublicAccountMenuResponse;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes22.dex */
public final class OACProfilePb$ProfileDataRsp extends MessageMicro<OACProfilePb$ProfileDataRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34}, new String[]{"base_data", "common_follower_count", "menu_rsp", "attachinfo"}, new Object[]{null, 0, null, ""}, OACProfilePb$ProfileDataRsp.class);
    public OACProfilePb$BaseData base_data = new OACProfilePb$BaseData();
    public final PBUInt32Field common_follower_count = PBField.initUInt32(0);
    public mobileqq_mp$GetPublicAccountMenuResponse menu_rsp = new mobileqq_mp$GetPublicAccountMenuResponse();
    public final PBStringField attachinfo = PBField.initString("");
}
