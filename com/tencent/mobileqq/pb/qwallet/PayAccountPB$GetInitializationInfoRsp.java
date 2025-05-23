package com.tencent.mobileqq.pb.qwallet;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes16.dex */
public final class PayAccountPB$GetInitializationInfoRsp extends MessageMicro<PayAccountPB$GetInitializationInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField is_identified = PBField.initBool(false);
    public final PBStringField name = PBField.initString("");
    public final PBStringField channel = PBField.initString("");
    public final PBBoolField face_verified = PBField.initBool(false);
    public final PBBoolField has_provided_namecreid = PBField.initBool(false);

    static {
        String[] strArr = {"is_identified", "name", WadlProxyConsts.CHANNEL, "face_verified", "has_provided_namecreid"};
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40}, strArr, new Object[]{bool, "", "", bool, bool}, PayAccountPB$GetInitializationInfoRsp.class);
    }
}
