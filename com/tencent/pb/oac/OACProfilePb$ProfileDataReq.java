package com.tencent.pb.oac;

import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes22.dex */
public final class OACProfilePb$ProfileDataReq extends MessageMicro<OACProfilePb$ProfileDataReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{IPublicAccountBrowser.KEY_PUB_UIN, "attachinfo"}, new Object[]{0L, ""}, OACProfilePb$ProfileDataReq.class);
    public final PBUInt64Field puin = PBField.initUInt64(0);
    public final PBStringField attachinfo = PBField.initString("");
}
