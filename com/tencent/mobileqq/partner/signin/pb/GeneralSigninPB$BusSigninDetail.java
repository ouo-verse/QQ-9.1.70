package com.tencent.mobileqq.partner.signin.pb;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;

/* loaded from: classes16.dex */
public final class GeneralSigninPB$BusSigninDetail extends MessageMicro<GeneralSigninPB$BusSigninDetail> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50}, new String[]{"any_count", "all_count", "member_detail", WadlProxyConsts.KEY_MATERIAL, "bus_info", QCircleDaTongConstant.ElementParamValue.SETTINGS}, new Object[]{null, null, null, null, null, null}, GeneralSigninPB$BusSigninDetail.class);
    public GeneralSigninPB$SigninCount any_count = new GeneralSigninPB$SigninCount();
    public GeneralSigninPB$SigninCount all_count = new GeneralSigninPB$SigninCount();
    public final PBRepeatMessageField<GeneralSigninPB$MemberSigninDetailEntity> member_detail = PBField.initRepeatMessage(GeneralSigninPB$MemberSigninDetailEntity.class);
    public GeneralSigninPB$Material material = new GeneralSigninPB$Material();
    public GeneralSigninPB$BusInfo bus_info = new GeneralSigninPB$BusInfo();
    public final PBRepeatMessageField<GeneralSigninPB$Setting> settings = PBField.initRepeatMessage(GeneralSigninPB$Setting.class);
}
